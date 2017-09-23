package solve.position;

import net.sf.json.JSONObject;
import solve.url.DataFromInternet;

public class QueryPositionByIP {

	private String city="nil";
	private String province="nil";
	private String ip;
	public QueryPositionByIP(String ip){
		this.ip=ip;
		connectToWeb();
	}
	public String getCity(){
		return city;
	}
	
	public String getProvince(){
		return province;
	}
	
	private void connectToWeb(){
		String urlStr="http://apis.baidu.com/bdyunfenxi/intelligence/ip?ip="+ip;
		String data=new DataFromInternet().getWebData(urlStr, "GET", "utf-8");
		JSONObject jsonData=JSONObject.fromObject(data);
		JSONObject jsonAddress=jsonData.getJSONObject("Base_info");
		String cityStr=jsonAddress.getString("city");
		String provinceStr=jsonAddress.getString("province");
		if(cityStr!=null&&provinceStr!=null&&(!"".equals(cityStr))&&(!"".equals(provinceStr))){
			city=cityStr;
			province=provinceStr;
		}
	}
	
}
