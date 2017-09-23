package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import model.User;
import model.UserAddress;

//通过用户名获取所有地址
public class InitPushDemandAddressAction extends ActionSupport{

	private HashMap<String,Object> resultMap=new HashMap<String,Object>();

	public HashMap<String, Object> getResultMap() {
		return resultMap;
	}
	public String execute() throws Exception{
		String userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao=(UserDao) act.getBean("userDao");
		User user=userDao.findByUserId(userId).get(0);
		List<HashMap> addresses=new ArrayList<HashMap>();
		List<UserAddress> addressList=user.getUserAddresses();
		for(int i=0;i<addressList.size();i++){
			UserAddress address=addressList.get(i);
			HashMap<String,String> addressMap=new HashMap<String,String>();
			addressMap.put("linkName",address.getLinkName());
			addressMap.put("linkPhone",address.getLinkPhone());
			addressMap.put("province",address.getUserProvince());
			addressMap.put("city",address.getUserCity());
			addressMap.put("region",address.getUserRegion());
			addressMap.put("street",address.getUserStreet());
			addressMap.put("detailAddress",address.getUserDetailAddress());
			addresses.add(addressMap);
		}
		System.out.println("InitPushDemandAddressAction");
		resultMap.put("initAddress",addresses);
		return SUCCESS;
	}
}
