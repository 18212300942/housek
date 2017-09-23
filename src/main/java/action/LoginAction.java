package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import model.User;

public class LoginAction extends ActionSupport {

	private InputStream inputStream;

	public InputStream getResult() {
		return this.inputStream;
	}

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) act.getBean("userDao");
		List<User> list = userDao.findByUserId(userId);
		if (list.size() > 0) {
			inputStream = new ByteArrayInputStream("false2".getBytes("utf-8"));
			if (list.get(0).getUserPasswd().equals(passwd)) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);
				session.setAttribute("passwd", passwd);
				inputStream = new ByteArrayInputStream("success".getBytes("utf-8"));
			}
		} else
			inputStream = new ByteArrayInputStream("false1".getBytes("utf-8"));
		return SUCCESS;
	}

}
