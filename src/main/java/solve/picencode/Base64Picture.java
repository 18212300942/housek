package solve.picencode;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;

public class Base64Picture {

	public static byte[] convertImage(byte[] srcBytes){
		ByteArrayInputStream bais=new ByteArrayInputStream(srcBytes);
		byte[] b=null;
		try {
			BufferedImage bimage=ImageIO.read(ImageIO.createImageInputStream(bais));
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			ImageIO.write(bimage, "gif", baos);
			b=baos.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public static byte[] generateImage(String imgStr) throws Exception{
		String base64HeadP="data:image/.*;base64,";
		if (imgStr == null){
			System.out.println("输入流不能为空");
			return null;
		}	
		Pattern p1=Pattern.compile(base64HeadP);
		Matcher m1=p1.matcher(imgStr);
		if(!m1.find()){
			System.out.println("不是图片格式");
			return null;
		}	
		String base64Head=m1.group(0);
		String base64Body=imgStr.substring(base64Head.length(),imgStr.length());
		Pattern p2=Pattern.compile("/.*;");
		Matcher m2=p2.matcher(imgStr);
		m2.find();
		String res=m2.group(0);
		//String imgType=res.substring(1, res.length()-1);
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] b2=null;
		try {
			byte[] b = decoder.decodeBuffer(base64Body);
			for (int i = 0; i < b.length; ++i)
			{
				if (b[i] < 0)
				{
					b[i] += 0;
				}
			}
			System.out.println("生成图片成功");
			b2=convertImage(b);
		}
		catch (Exception e) {
				e.printStackTrace();
			}
		finally{
			return b2;
			}
		}
	
}
