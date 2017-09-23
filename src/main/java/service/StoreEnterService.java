package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.StoreApplyInformationDao;
import model.StoreApplyInformation;

public class StoreEnterService {

	private StoreApplyInformationDao siDao;
	public StoreEnterService(){
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		siDao=(StoreApplyInformationDao) act.getBean("storeApplyInformationDao");
	}
	
	public boolean passed(String userId){
		StoreApplyInformation sif=siDao.findInfByUserId(userId);
		if(sif==null)
			return false;
		boolean result=sif.getPassApply();
		if(result==true)
			return true;
		return false;
	}
	
	public boolean exit(String userId){
		StoreApplyInformation sif=siDao.findInfByUserId(userId);
		if(sif==null)
			return false;
		return true;
	}
}
