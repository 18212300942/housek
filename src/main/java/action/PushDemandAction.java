package action;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.DemandDao;
import model.Demand;
import model.UserAddress;

public class PushDemandAction extends ActionSupport{

	private HashMap<String,Object> resultMap=new HashMap<String,Object>();
	public HashMap<String, Object> getResultMap() {
		return resultMap;
	}
	
	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String userId=(String) request.getSession().getAttribute("userId");
		int year=Integer.parseInt((String)request.getParameter("year"));
		int month=Integer.parseInt((String)request.getParameter("month"));
		int day=Integer.parseInt((String)request.getParameter("day"));
		int workTime=Integer.parseInt((String)request.getParameter("workTime"));
		String workType=(String) request.getParameter("workType");
		String workPayment=(String) request.getParameter("workPayment");
		String linkName=(String) request.getParameter("linkName");
		String linkPhone=(String) request.getParameter("linkPhone");
		String province=(String) request.getParameter("province");
		String city=(String) request.getParameter("city");
		String region=(String) request.getParameter("region");
		String street=(String) request.getParameter("street");
		String detailAddress=(String) request.getParameter("detailAddress");
		String workDemand=(String) request.getParameter("workDemand");
		UserAddress userAddress=new UserAddress();
		userAddress.setLinkName(linkName);
		userAddress.setLinkPhone(linkPhone);
		userAddress.setUserProvince(province);
		userAddress.setUserCity(city);
		userAddress.setUserRegion(region);
		userAddress.setUserRegion(region);
		userAddress.setUserStreet(street);
		userAddress.setUserDetailAddress(detailAddress);
		Date time=new Date();
		time.setYear(year-1900);
		time.setMonth(month-1);
		time.setDate(day);
		time.setHours(workTime);
		time.setMinutes(0);
		time.setSeconds(0);
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		DemandDao demandDao=(DemandDao) act.getBean("demandDao");
		Demand demand=new Demand();
		demand.setUserId(userId);
		demand.setPrice(workPayment);
		demand.setType(workType);
		demand.setWorkTime(time);
		demand.setAmount(1);
		demand.setUserAddress(userAddress);
		demand.setWorkDemand(workDemand);
		demandDao.save(demand);
		resultMap.put("result", "success");
		return SUCCESS;
	}
}
