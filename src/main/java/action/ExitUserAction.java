package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ExitUserAction extends ActionSupport{

	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession httpSession=request.getSession();
		httpSession.removeAttribute("userId");
		httpSession.removeAttribute("passwd");
		//在前端加转跳属性
		return "next";
	}
}
