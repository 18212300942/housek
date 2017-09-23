package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import model.User;

public class RegisterAction extends ActionSupport{

	private InputStream inputStream;
	public InputStream getResult(){
		return this.inputStream;
	}
	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String userId=request.getParameter("userId");
		String passwd=request.getParameter("passwd");
		if(userId==null&&passwd==null){
			inputStream=new ByteArrayInputStream("false message".getBytes("utf-8"));
			return SUCCESS;
		}
		if(!check(userId,passwd)){
			inputStream=new ByteArrayInputStream("false message".getBytes("utf-8"));
		}
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao=(UserDao) ctx.getBean("userDao");
		List<User> list=userDao.findByUserId(userId);
		if(list.size()>0)
			inputStream=new ByteArrayInputStream("error1".getBytes("utf-8"));
		else{
			User user=new User(userId,passwd);
			userDao.save(user);
			inputStream=new ByteArrayInputStream("success".getBytes("utf-8"));
		}
		return SUCCESS;
	}
	
	public boolean check(String userId,String passwd){
		Pattern pattern=Pattern.compile("^1[0-9]{10}$");
		Matcher matcher=pattern.matcher(userId);
		if(matcher.matches()==false)
			return false;
		if(passwd.length()<6||passwd.length()>15)
			return false;
		return true;
	}
}
