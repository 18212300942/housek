package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import model.User;

public class PswManagerAction extends ActionSupport{

	private Map<String,String> resultMap=new HashMap<String,String>();
	public  Map<String, String> getResultMap() {
		return resultMap;
	}

	public String execute() throws Exception{
		String oldPsw=ServletActionContext.getRequest().getParameter("oldP");
		String newPsw=ServletActionContext.getRequest().getParameter("newP");
		String userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao=(UserDao) act.getBean("userDao");
		User user=userDao.findByUserId(userId).get(0);
		String psw=user.getUserPasswd();
		if(!oldPsw.equals(psw)){
			System.out.println("原密码错误");
			resultMap.put("result", "pswerror");
			return SUCCESS;
		}else{
			user.setUserPasswd(newPsw);
			userDao.update(user);
			resultMap.put("result", "success");
			System.out.println("修改成功");
			return SUCCESS;
		}
	}
}
