package action;

import java.util.HashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.CompanyStoreDao;
import dao.SingleStoreDao;
import model.CompanyStore;
import model.SingleStore;

public class InitIndexAction extends ActionSupport{

	private HashMap<String,String> resultMap=new  HashMap<String,String>();

	public HashMap<String, String> getResultMap() {
		return resultMap;
	}
	
	public String execute() throws Exception{
		String userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		if(userId!=null){
			resultMap.put("logined", "yes");
		}		
		return SUCCESS;
	}
}
