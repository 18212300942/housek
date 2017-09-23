package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.StoreApplyInformationDao;
import model.StoreApplyInformation;

public class GetApplyStoreAction extends ActionSupport{

	private Map<String,Object> resultMap=new HashMap<String,Object>();

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	public String execute() throws Exception{
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		StoreApplyInformationDao saiDao=(StoreApplyInformationDao) act.getBean("storeApplyInformationDao");
		List<StoreApplyInformation> sais=saiDao.findNotPassStore();
		List<Map<String,String>> resultList=new ArrayList<Map<String,String>>();
		for(int i=0;i<sais.size();i++){
			StoreApplyInformation sai=sais.get(i);
			Map<String,String> map=new HashMap<String,String>();
			map.put("applyStoreId", sai.getId()+"");
			map.put("storeName", sai.getStoreName());
			map.put("storeType", sai.getStoreType());
			map.put("carType", sai.getCarType());
			map.put("rangeType", sai.getRangeType());
			resultList.add(map);
		}
		resultMap.put("result", resultList);
		return SUCCESS;
	}
}
