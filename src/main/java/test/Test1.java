package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDao;
import model.User;

public class Test1 {

	public static void main(String[] args){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao=ctx.getBean("userDao",UserDao.class);
		User user=new User();
		user.setUserName("林红f按");
		user.setUserPasswd("452233");
		user.setUserId("11dfd1dd1");
		userDao.save(user);
	}
}
