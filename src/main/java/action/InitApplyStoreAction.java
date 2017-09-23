package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminDao;
import dao.StoreApplyInformationDao;
import model.StoreApplyInformation;

public class InitApplyStoreAction extends ActionSupport{

	private Map<String,String> resultMap=new HashMap<String,String>();
	
	public Map<String, String> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, String> resultMap) {
		this.resultMap = resultMap;
	}

	public String execute() throws Exception{
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		StoreApplyInformationDao saiDao=(StoreApplyInformationDao) act.getBean("storeApplyInformationDao");
		HttpServletRequest request=ServletActionContext.getRequest();
		String applyStoreId=request.getParameter("applyStoreId");
		System.out.println(applyStoreId);
		StoreApplyInformation sai=saiDao.findInfById(Integer.parseInt(applyStoreId));
		if(sai.getPassApply()==true){
			resultMap.put("result", "error");
			return SUCCESS;
		}
		resultMap.put("province", sai.getProvince());
		resultMap.put("city", sai.getCity());
		resultMap.put("region", sai.getRegion());
		resultMap.put("street", sai.getStreet());
		resultMap.put("detailAddress", sai.getAddressDetail());
		resultMap.put("storeName", sai.getStoreName());
		resultMap.put("linkName", sai.getLinkName());
		resultMap.put("linkPhone", sai.getLinkPhone());
		resultMap.put("rangeType", sai.getRangeType());
		resultMap.put("storeType", sai.getStoreType());
		String carType= sai.getStoreType();
		int oPicNum=0;
		resultMap.put("carType",carType);
		if("营业执照".equals(carType)){
			oPicNum++;
		}
		if("其他资质".equals(carType)){
			if(sai.getOtherPic1()!=null)
				oPicNum++;
			if(sai.getOtherPic2()!=null)
				oPicNum++;
			if(sai.getOtherPic3()!=null)
				oPicNum++;
		}
		resultMap.put("oPicNum",oPicNum+"");
		resultMap.put("result", "success");
		return SUCCESS;
	}
}
