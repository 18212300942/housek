package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class AddressManager2Action extends ActionSupport{

	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String workDate=(String) request.getParameter("workDate");
		String workTime=(String) request.getParameter("workTime");
		String workType=(String) request.getParameter("workType");
		String workPayment=(String) request.getParameter("workPayment");
		String workDemand=(String) request.getParameter("workDemand");
		System.out.println("AddressManager2Action");
		System.out.println(workDate);
		System.out.println(workTime);
		System.out.println(workType);
		System.out.println(workPayment);
		System.out.println(workDemand);
		HttpSession session=request.getSession();
		session.setAttribute("workDate", workDate);
		session.setAttribute("workTime", workTime);
		session.setAttribute("workType", workType);
		session.setAttribute("workPayment", workPayment);
		session.setAttribute("workDemand", workDemand);
		return "next";
	}
}
