package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import dao.CollectionDao;
import service.CollectionService;

@Component
@Scope("prototype")
public class CollectAction extends ActionSupport{


	@Autowired
	CollectionService collectionService;
	private Map<String,String> resultMap=new HashMap<String,String>();
	public Map<String, String> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, String> resultMap) {
		this.resultMap = resultMap;
	}
	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("userId");
		if(username==null){
			resultMap.put("result", "unlogin");
			return SUCCESS;
		}
		String storeId=request.getParameter("storeId");
		resultMap.put("result","success");
		try{
			if(collectionService.collect(username, storeId)){
				resultMap.put("collectState", "yes");
			}else{
				resultMap.put("collectState", "no");
			}
		}catch(Exception e){
			e.printStackTrace();
			resultMap.put("result","failure");
		}
		
		return SUCCESS;
	}
}
