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

import service.CollectionService;

@Component
@Scope("prototype")
public class CollectStateAction extends ActionSupport{
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
		String storeId=request.getParameter("storeId");
		boolean result=collectionService.collectState(username, storeId);
		if(result==true){
			resultMap.put("collectState", "yes");
		}else{
			resultMap.put("collectState", "no");
		}
		return SUCCESS;
	}
}
