package action;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.StoreApplyInformationDao;
import model.StoreApplyInformation;

public class GetPictureAction extends ActionSupport{

	private ByteArrayInputStream imageStream;
	
	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}

	public String execute() throws Exception{
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		StoreApplyInformationDao saiDao=(StoreApplyInformationDao) act.getBean("storeApplyInformationDao");
		HttpServletRequest request=ServletActionContext.getRequest();
		String applyStoreId=request.getParameter("applyStoreId");
		String picType=request.getParameter("picType");
		StoreApplyInformation sai=saiDao.findInfById(Integer.parseInt(applyStoreId));
		byte [] b=null;
		if("mainPic1".equals(picType)){
			b=sai.getMainPic1();
		}
		if("mainPic2".equals(picType)){
			b=sai.getMainPic2();
		}
		if("sellPic".equals(picType)){
			b=sai.getSellPic();
		}
		if("otherPic1".equals(picType)){
			b=sai.getOtherPic1();
		}
		if("otherPic2".equals(picType)){
			b=sai.getOtherPic2();
		}
		if("otherPic3".equals(picType)){
			b=sai.getOtherPic3();
		}
		imageStream=new ByteArrayInputStream(b);
		return SUCCESS;
	}
}
