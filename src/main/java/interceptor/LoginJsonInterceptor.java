package interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@Component
@Scope("prototype")
public class LoginJsonInterceptor extends AbstractInterceptor{

	private Map<String,Object> resultMap=new HashMap<String,Object>();

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("userId");
		String passId=(String) session.getAttribute("passwd");
		if(userId!=null&&passId!=null)
			return arg0.invoke();
		else{
			resultMap.put("result", "unlogin");
			return "unloginjs";
		}
		
	}
}
