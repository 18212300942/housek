package action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import solve.position.QueryPositionByIP;

public class SetPositionAction extends ActionSupport{

	private HashMap<String,String> resultMap=new HashMap<String,String>();
	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String ip=request.getRemoteAddr();
		QueryPositionByIP qip=new QueryPositionByIP(ip);
		String provinceStr=qip.getProvince();
		String cityStr=qip.getCity();
		HttpSession session=request.getSession();
		session.setAttribute("province", provinceStr);
		session.setAttribute("city", cityStr);
		resultMap.put("city", cityStr);
		return SUCCESS;
	}
}
