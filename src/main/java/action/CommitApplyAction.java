package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.StoreApplyInformationDao;
import model.StoreApplyInformation;
import solve.picencode.Base64Picture;

public class CommitApplyAction extends ActionSupport{

	private Map<String,String> resultMap=new HashMap<String,String>();
	public Map<String, String> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, String> resultMap) {
		this.resultMap = resultMap;
	}
	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String region=request.getParameter("region");
		String street=request.getParameter("street");
		String addressDetail=request.getParameter("addressDetail");
		String storeName=request.getParameter("storeName");
		String storeType=request.getParameter("storeType");
		String rangeType=request.getParameter("rangeType");
		String linkName=request.getParameter("linkName");
		String linkPhone=request.getParameter("linkPhone");
		String mainPic1=request.getParameter("mainPic1");
		String mainPic2=request.getParameter("mainPic2");
		String carType=request.getParameter("carType");
		String sellPic=null;
		String otherPic1=null;
		String otherPic2=null;
		String otherPic3=null;
		StoreApplyInformation sai=new StoreApplyInformation();
		sai.setUserId((String)request.getSession().getAttribute("userId"));
		sai.setProvince(province);
		sai.setCity(city);
		sai.setRegion(region);
		sai.setStreet(street);
		sai.setAddressDetail(addressDetail);
		sai.setStoreName(storeName);
		sai.setStoreType(storeType);
		sai.setRangeType(rangeType);
		sai.setLinkName(linkName);
		sai.setLinkPhone(linkPhone);
		sai.setMainPic1(Base64Picture.generateImage(mainPic1));
		sai.setMainPic2(Base64Picture.generateImage(mainPic2));
		sai.setCarType(carType);
		if("营业执照".equals(carType)){
			sellPic=request.getParameter("sellPic");
			sai.setSellPic(Base64Picture.generateImage(sellPic));
		}else if("其他资质".equals(carType)){
			otherPic1=request.getParameter("otherPic1");
			otherPic2=request.getParameter("otherPic2");
			otherPic3=request.getParameter("otherPic3");
			sai.setOtherPic1(Base64Picture.generateImage(otherPic1));
			sai.setOtherPic2(Base64Picture.generateImage(otherPic2));
			sai.setOtherPic3(Base64Picture.generateImage(otherPic3));
		}
		StoreApplyInformationDao storeApplyInformationDao=(StoreApplyInformationDao) new ClassPathXmlApplicationContext("beans.xml").getBean("storeApplyInformationDao");
		storeApplyInformationDao.save(sai);
		resultMap.put("result", "success");
		return SUCCESS;
	}
}
