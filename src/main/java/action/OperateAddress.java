package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import model.User;
import model.UserAddress;

public class OperateAddress extends ActionSupport{

	private InputStream inputStream;
	public InputStream getResult(){
		return this.inputStream;
	}
	
	public String addAddress() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String linkname=request.getParameter("linkname");
		String linkphone=request.getParameter("linkphone");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String region=request.getParameter("region");
		String street=request.getParameter("street");
		String detail=request.getParameter("detail");
		String check=request.getParameter("check");
		String userId=(String) request.getSession().getAttribute("userId");
		System.out.println(linkname);
		if(linkname==null||linkphone==null||province==null||city==null||region==null||street==null||detail==null||check==null){
			inputStream=new ByteArrayInputStream("error".getBytes("utf-8"));
			return SUCCESS;
		}
		UserAddress userAddress=new UserAddress(linkname,linkphone,province,city,region,street,detail);
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao=act.getBean(UserDao.class);
		User user=userDao.findByUserId(userId).get(0);
		List<UserAddress> userAddresses=user.getUserAddresses();
		if(check.equals("yes")){
			userAddresses.add(0, userAddress);
		}else{
			userAddresses.add(userAddress);
		}
		userDao.update(user);
		inputStream=new ByteArrayInputStream("success".getBytes("utf-8"));
		return SUCCESS;
	}
	
	public String delAddress() throws Exception{
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		HttpServletRequest request=ServletActionContext.getRequest();
		inputStream=new ByteArrayInputStream("error".getBytes("utf-8"));
		int addressNo=Integer.parseInt(request.getParameter("addressNo").trim());
		String userId=(String) request.getSession().getAttribute("userId");
		UserDao userDao=act.getBean(UserDao.class);
		User user=userDao.findByUserId(userId).get(0);
		List<UserAddress> userAddresses=user.getUserAddresses();
		userAddresses.remove(addressNo);
		userDao.update(user);
		inputStream=new ByteArrayInputStream("success".getBytes("utf-8"));
		return SUCCESS;
	}
}
