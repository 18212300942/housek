package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.CompanyStoreDao;
import dao.SingleStoreDao;
import model.CompanyStore;
import model.SingleStore;

public class GetStoresAction extends ActionSupport {

	private HashMap<String, Object> resultMap = new HashMap<String, Object>();

	public HashMap<String, Object> getResultMap() {
		return resultMap;
	}

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		CompanyStoreDao csDao = (CompanyStoreDao) act.getBean("companyStoreDao");
		List<CompanyStore> csList = csDao.findOrderedByPage(page, 9);
		SingleStoreDao ssDao = (SingleStoreDao) act.getBean("singleStoreDao");
		List<SingleStore> ssList = ssDao.findOrderedByPage(page, 9);
		ArrayList<Object> arrayList1 = new ArrayList<Object>();
		ArrayList<Object> arrayList2 = new ArrayList<Object>();
		for (int i = 0; i < csList.size(); i++) {
			CompanyStore cs = csList.get(i);
			HashMap<String, String> csMap = new HashMap<String, String>();
			csMap.put("storeId", cs.getId() + "");
			csMap.put("storeName", cs.getComStoreInformation().getStoreName());
			csMap.put("rangeType", cs.getComStoreInformation().getStoreType());
			csMap.put("storeType", "企业");
			csMap.put("sumScore", cs.getSumScore() + "");
			csMap.put("orderCount", cs.getOrderCount() + "");
			arrayList1.add(csMap);
		}
		for (int i = 0; i < ssList.size(); i++) {
			SingleStore ss = ssList.get(i);
			HashMap<String, String> ssMap = new HashMap<String, String>();
			ssMap.put("storeId", ss.getId() + "");
			ssMap.put("storeName", ss.getSinsStoreInformation().getStoreName());
			ssMap.put("rangeType", ss.getSinsStoreInformation().getStoreType());
			ssMap.put("storeType", "个体");
			ssMap.put("sumScore", ss.getSumScore() + "");
			ssMap.put("orderCount", ss.getOrderCount() + "");
			arrayList1.add(ssMap);
		}
		resultMap.put("single", arrayList1);
		resultMap.put("company", arrayList2);
		return SUCCESS;
	}
}
