package com.zhita.tool;

import java.security.MessageDigest;

public class EncodeUtil {
	
	
	//MD5加密
	public String MD5util(String data){
		MessageDigest md5=null;
		try {
			md5=MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		//将获取到的string转换成byte数组
		char[] chars=data.toCharArray();
		byte[] bytes=new byte[chars.length];
		for(int i=0;i<chars.length;i++){
			bytes[i]=(byte)chars[i];
		}
		//获取MD5计算后的byte值
		byte[] md5byte=md5.digest();
		
		//将获取到的byte值转回string
		StringBuffer stringbuffer=new StringBuffer();
		for(int i=0;i<md5byte.length;i++){
			//使用0xff保持转值不出错
			int val=((int)md5byte[i])&0xff;
			if(val<16){
				stringbuffer.append("0");
			}else{
				stringbuffer.append(Integer.toHexString(val));
			}
		}
		
		return stringbuffer.toString();
	
	}
	
	
	
	
	
	//MD5加密  32位大写
	public final String MD5(String s){
		char[] hexDigits={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		try {
			byte[] btInput=s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest Mdigest=MessageDigest.getInstance("MD5");
			//使用指定的字节更新摘要
			Mdigest.update(btInput);
			//获取密文
			byte[] md=Mdigest.digest();
			int j=md.length;
			char[] str=new char[j*2];
			int k=0;
			for(int i=0;i<j;i++){
				byte byte0=md[i];
				str[k++]=hexDigits[byte0 >>> 4 & 0xf];
				str[k++]=hexDigits[byte0 & 0xf];
				
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
            return null;
		}
		
	}

}
