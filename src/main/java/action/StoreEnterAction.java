package action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import service.StoreEnterService;

public class StoreEnterAction extends ActionSupport{

	public String execute() throws Exception{
		String userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		StoreEnterService ses=new StoreEnterService();
		if(!ses.exit(userId)){
			System.out.println("notexit");
			return "notexit";
		}		
		if(!ses.passed(userId)){
			System.out.println("notpass");
			return "notpass";
		}	
		return "pass";
	}
}
