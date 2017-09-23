package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.CommentDao;
import dao.CompanyStoreDao;
import dao.OverOrderDao;
import dao.SingleStoreDao;
import dao.UserDao;
import model.Comment;
import model.CompanyStore;
import model.SingleStore;
import model.StoreAddress;
import model.StoreInformation;

public class GetStoreInformationAction extends ActionSupport {

	private HashMap<String, Object> resultMap = new HashMap<String, Object>();

	public HashMap<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(HashMap<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public String execute() throws Exception {
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		String storeId = ServletActionContext.getRequest().getParameter("storeId");
		// *
		OverOrderDao ooDao = (OverOrderDao) act.getBean("overOrderDao");
		CommentDao cDao = (CommentDao) act.getBean("commentDao");
		SingleStoreDao ssDao = (SingleStoreDao) act.getBean("singleStoreDao");
		UserDao userDao = (UserDao) act.getBean("userDao");
		SingleStore ss = ssDao.findStoreById(storeId);
		if (ss != null) {
			String storeType = "个体商户";
			StoreInformation sif = ss.getSinsStoreInformation();
			String storeName = sif.getStoreName();
			String rangeType = sif.getStoreType();
			StoreAddress sa = sif.getStoreAddress();
			String province = sa.getStoreProvince();
			String city = sa.getStoreCity();
			String region = sa.getStoreRegion();
			String street = sa.getStoreStreet();
			String detail = sa.getStoreDetailAddress();
			String price = sif.getStorePrice();
			String linkPhone = sif.getStorePhone();
			int serviceCount = ooDao.getOverOrderCount(storeId);
			double score = ss.getSumScore();
			resultMap.put("storeName", storeName);
			resultMap.put("storeType", storeType);
			resultMap.put("rangeType", rangeType);
			resultMap.put("province", province);
			resultMap.put("city", city);
			resultMap.put("region", region);
			resultMap.put("street", street);
			resultMap.put("detail", detail);
			resultMap.put("price", price);
			resultMap.put("serviceCount", serviceCount);
			resultMap.put("score", score);
			resultMap.put("linkPhone", linkPhone);
			List<Comment> comments = cDao.findCommentById(storeId);
			ArrayList<HashMap<String, Object>> commentList = new ArrayList<HashMap<String, Object>>();
			HashMap<String, Object> comment = new HashMap<String, Object>();
			for (int i = 0; i < comments.size(); i++) {
				String userName = userDao.findByUserId(comments.get(i).getUserId()).get(0).getUserName();
				comment.put("user", userName);
				comment.put("date", comments.get(i).getCommentDate());
				commentList.add(comment);
			}
			resultMap.put("commentList", commentList);
		} else {
			CompanyStoreDao csDao = (CompanyStoreDao) act.getBean("companyStoreDao");
			CompanyStore cs = csDao.findStoreById(storeId);
			if (cs != null) {
				String storeType = "企业商户";
				StoreInformation sif = cs.getComStoreInformation();
				String storeName = sif.getStoreName();
				String rangeType = sif.getStoreType();
				StoreAddress sa = sif.getStoreAddress();
				String province = sa.getStoreProvince();
				String city = sa.getStoreCity();
				String region = sa.getStoreRegion();
				String street = sa.getStoreStreet();
				String detail = sa.getStoreDetailAddress();
				String price = sif.getStorePrice();
				String linkPhone = sif.getStorePhone();
				int serviceCount = ooDao.getOverOrderCount(storeId);
				double score = cs.getSumScore();
				resultMap.put("storeName", storeName);
				resultMap.put("storeType", storeType);
				resultMap.put("rangeType", rangeType);
				resultMap.put("province", province);
				resultMap.put("city", city);
				resultMap.put("region", region);
				resultMap.put("street", street);
				resultMap.put("detail", detail);
				resultMap.put("price", price);
				resultMap.put("serviceCount", serviceCount);
				resultMap.put("score", score);
				resultMap.put("linkPhone", linkPhone);
				List<Comment> comments = cDao.findCommentById(storeId);
				ArrayList<HashMap<String, Object>> commentList = new ArrayList<HashMap<String, Object>>();
				HashMap<String, Object> comment = new HashMap<String, Object>();
				for (int i = 0; i < comments.size(); i++) {
					String userName = userDao.findByUserId(comments.get(i).getUserId()).get(0).getUserName();
					comment.put("user", userName);
					comment.put("date", comments.get(i).getCommentDate());
					commentList.add(comment);
				}
				resultMap.put("commentList", commentList);
			}
		}

		return SUCCESS;
	}
}
