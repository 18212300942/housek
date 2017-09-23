package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import service.ApplyResultService;

public class CheckResultAction extends ActionSupport{

	private Map<String,String> resultMap1=new HashMap<String,String>();
	private Map<String,String> resultMap2=new HashMap<String,String>();
	
	public Map<String, String> getResultMap1() {
		return resultMap1;
	}

	public void setResultMap1(Map<String, String> resultMap1) {
		this.resultMap1 = resultMap1;
	}

	public Map<String, String> getResultMap2() {
		return resultMap2;
	}

	public void setResultMap2(Map<String, String> resultMap2) {
		this.resultMap2 = resultMap2;
	}

	public String pass() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String applyStoreId=request.getParameter("applyStoreId");
		if(applyStoreId==null||"".equals(applyStoreId)){
			resultMap1.put("result", "error");
			return SUCCESS;
		}
		ApplyResultService arService=new ApplyResultService();
		arService.pass(Integer.parseInt(applyStoreId));
		resultMap1.put("result", "success");
		return SUCCESS;
	}
	
	public String notPass() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String applyStoreId=request.getParameter("applyStoreId");
		if(applyStoreId==null||"".equals(applyStoreId)){
			resultMap1.put("result", "error");
			return SUCCESS;
		}
		ApplyResultService arService=new ApplyResultService();
		arService.notPass(Integer.parseInt(applyStoreId));
		resultMap1.put("result", "success");
		return SUCCESS;
	}
}
