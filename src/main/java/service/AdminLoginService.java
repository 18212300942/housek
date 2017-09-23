package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.AdminDao;
import dao.StoreApplyInformationDao;
import model.Admin;

public class AdminLoginService {

	private AdminDao aDao;
	public AdminLoginService(){
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		aDao=(AdminDao) act.getBean("adminDao");
	}
	public boolean login(String adminName,String adminPwd){
		Admin admin=aDao.findAdminByName(adminName);
		if(admin==null)
			return false;
		if(adminPwd.equals(admin.getAdminPwd())){
			return true;
		}
		return false;
	}

}
