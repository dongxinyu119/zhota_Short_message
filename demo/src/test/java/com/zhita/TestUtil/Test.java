package com.zhita.TestUtil;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		 list.add("aaa");
	     list.add("bbb");
	     list.add("ccc");
	     System.out.println(listToString(list));
		
	}
	
	
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
	
//	 public static String listToString(List<String> stringList){
//		if(stringList==null) {
//		    return null;
//		  }
//		 StringBuilder result = new StringBuilder();
//		booleanflag=false;
//		        for(String string : stringList) {
//		            if(flag) {
//		                result.append(",");
//		            }else{
//		                flag=true;
//		            }
//		            result.append(string);
//		        }
//		        return result.toString();
//		    }
//		}

}
