package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import model.User;
import model.UserAddress;

public class AddressManagerAction extends ActionSupport{

	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("userId");
		System.out.println(userId);
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao=(UserDao) act.getBean("userDao");
		List<User> users=userDao.findByUserId(userId);
		System.out.println(users.size());
		if(users.size()<1){
			throw new Exception();
		}
		User user=users.get(0);
		List<UserAddress> addresses=user.getUserAddresses();
		request.setAttribute("addresses",addresses);
		return SUCCESS;
	}
}
