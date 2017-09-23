package action;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.CompanyStoreDao;
import dao.SingleStoreDao;
import dao.StoreApplyInformationDao;
import model.CompanyStore;
import model.SingleStore;
import model.StoreApplyInformation;

public class GetStorePicAction extends ActionSupport{

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
		String storeId=request.getParameter("storeId");
		String storeType=request.getParameter("storeType");
		if("个体".equals(storeType)){
			SingleStoreDao ssDao=(SingleStoreDao) act.getBean("singleStoreDao");
			SingleStore ss=ssDao.findStoreById(storeId);
			imageStream=new ByteArrayInputStream(ss.getSinsStoreInformation().getStorePhoto());
		}
		if("企业".equals(storeType)){
			CompanyStoreDao csDao=(CompanyStoreDao) act.getBean("companyStoreDao");
			CompanyStore cs=csDao.findStoreById(storeId);
			imageStream=new ByteArrayInputStream(cs.getComStoreInformation().getStorePhoto());
		}
		return SUCCESS;
	}
}
