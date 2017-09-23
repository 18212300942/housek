package service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CompanyStoreDao;
import dao.SingleStoreDao;
import dao.StoreApplyInformationDao;
import dao.UserDao;
import model.CompanyStore;
import model.SingleStore;
import model.StoreAddress;
import model.StoreApplyInformation;
import model.StoreInformation;
import model.User;

public class ApplyResultService {

	private StoreApplyInformationDao saiDao;
	private UserDao userDao;
	private SingleStoreDao ssDao;
	private CompanyStoreDao csDao;
	public ApplyResultService(){
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		saiDao=(StoreApplyInformationDao) act.getBean("storeApplyInformationDao");
		ssDao= (SingleStoreDao) act.getBean("singleStoreDao");
		csDao= (CompanyStoreDao) act.getBean("companyStoreDao");
		userDao= (UserDao) act.getBean("userDao");
	}
	
	public void notPass(int id){
		StoreApplyInformation sai=saiDao.findInfById(id);
		saiDao.delete(sai);
	}
	
	public void pass(int id){
		StoreApplyInformation sai=saiDao.findInfById(id);
		String userId=sai.getUserId();
		System.out.println(userId);
		List<User> userList=userDao.findByUserId(userId);
		User user=userList.get(0);
		if(user==null)
			return;
		
		StoreAddress storeAddress=new StoreAddress();
		storeAddress.setStoreProvince(sai.getProvince());
		storeAddress.setStoreCity(sai.getCity());
		storeAddress.setStoreRegion(sai.getRegion());
		storeAddress.setStoreStreet(sai.getStreet());
		storeAddress.setStoreDetailAddress(sai.getAddressDetail());
		String storeType=sai.getStoreType();
		StoreInformation storeInf=new StoreInformation();
		storeInf.setStoreAddress(storeAddress);
		storeInf.setStoreName(sai.getStoreName());
		storeInf.setStorePhone(sai.getLinkPhone());
		storeInf.setStoreType(sai.getRangeType());
		storeInf.setStorePhoto(sai.getMainPic1());
		if("个体商户".equals(storeType)){
			SingleStore singleStore=new SingleStore();
			singleStore.setId(user.getId());
			singleStore.setUserId(user.getUserId());
			singleStore.setUserPasswd(user.getUserPasswd());
			singleStore.setUserPhoto(user.getUserPhoto());
			singleStore.setSinsName(sai.getLinkName());
			singleStore.setSinsStoreInformation(storeInf);
			ssDao.save(singleStore);
		}else{
			CompanyStore comStore=new CompanyStore();
			comStore.setId(user.getId());
			comStore.setUserId(user.getUserId());
			comStore.setUserPasswd(user.getUserPasswd());
			comStore.setUserPhoto(user.getUserPhoto());
			comStore.setComsName(sai.getLinkName());
			comStore.setComStoreInformation(storeInf);
			csDao.save(comStore);
		}
		sai.setPassApply(true);
		saiDao.update(sai);
	}
}
