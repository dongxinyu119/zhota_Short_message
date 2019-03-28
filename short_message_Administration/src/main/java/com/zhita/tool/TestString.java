package com.zhita.tool;
import java.util.List;
public class TestString {
	
	
	
	public static String listToString(List<String> stringList){
		if(stringList==null){
			return null;
		}
		StringBuilder result=new StringBuilder();
		boolean flag=false;
		for(String string:stringList){
			if(flag){
				result.append(",");
			}else{
				flag=true;
			}
			result.append(string);
		}
		return result.toString();
	}

	
	//换行
	public static String listToStringTxt(List<String> stringList){
		if(stringList==null){
			return null;
		}
		StringBuilder result=new StringBuilder();
		boolean flag=false;
		for(String string:stringList){
			if(flag){
				result.append("\r\n");
			}else{
				flag=true;
			}
			result.append(string);
		}
		return result.toString();
	}
	
		
}
