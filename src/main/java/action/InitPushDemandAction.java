package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//从session中获取之前保存的需求发布表单
public class InitPushDemandAction extends ActionSupport{

	private HashMap<String,Object> resultMap=new HashMap<String,Object>();

	public HashMap<String, Object> getResultMap() {
		return resultMap;
	}
	public String execute() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();
		String workDate=(String) session.getAttribute("workDate");
		String workTime=(String) session.getAttribute("workTime");
		String workType=(String) session.getAttribute("workType");
		String workPayment=(String) session.getAttribute("workPayment");
		String workDemand=(String) session.getAttribute("workDemand");
		resultMap.put("workDate",workDate);
		resultMap.put("workTime",workTime);
		resultMap.put("workType",workType);
		resultMap.put("workPayment",workPayment);
		resultMap.put("workDemand",workDemand);
		session.removeAttribute("workDate");
		session.removeAttribute("workTime");
		session.removeAttribute("workType");
		session.removeAttribute("workPayment");
		session.removeAttribute("workDemand");
		System.out.println("InitPushDemandAction");
		return SUCCESS;
	}
}
