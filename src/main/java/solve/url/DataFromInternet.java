package solve.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataFromInternet {

	public String getWebData(String urlStr,String requestMethod,String encode){
		  StringBuffer str=new StringBuffer("");
		  try {  
		        URL url = new URL(urlStr);  
		        System.out.println(url);  
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
		        conn.setRequestMethod(requestMethod);  
		        conn.setDoInput(true);  
		        conn.setDoOutput(true);  
		        conn.setInstanceFollowRedirects(true);  
		        conn.setRequestProperty("content-type", "text/html");
		        conn.setRequestProperty("apikey","481a16ad98f0dfaa8484e7135851d1ba");
		        conn.connect();// 握手  
		        OutputStream os = conn.getOutputStream();// 拿到输出流  
		        PrintWriter out = new PrintWriter(os);    
		        out.flush();  
		        os.flush();  
		        out.close();  
		        os.close();  
		        InputStream is = conn.getInputStream();//拿到输入流  
		        InputStreamReader isr = new InputStreamReader(is,encode);  
		        BufferedReader br = new BufferedReader(isr);        
		        str.append(br.readLine());
		        System.out.println(str.toString());  
		        br.close();  
		        isr.close();  
		        is.close();  
		    } catch (Exception e) {  
		        e.printStackTrace();  
		    }  
		  return str.toString();
	}
}
