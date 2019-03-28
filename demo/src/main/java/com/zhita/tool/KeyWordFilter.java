package com.zhita.tool;



import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author YangJie
 * @Description:屏蔽词工具类
 * @Date:Created in 10:29 2018/2/2
 * @Modified By:
 */
public class KeyWordFilter {

	
	private static Pattern pattern = null;
	
	 /**
	   * 从words.properties初始化正则表达式字符串
	   */
	  private static void initPattern() {
	    StringBuffer patternBuf = new StringBuffer("");
	    try {
	      InputStream in = KeyWordFilter.class.getClassLoader().getResourceAsStream("words.properties");
	      Properties pro = new Properties();
	      pro.load(in);
	      Enumeration<?> enu = pro.propertyNames();
	      patternBuf.append("(");
	      while (enu.hasMoreElements()) {
	        patternBuf.append((String) enu.nextElement() + "|");
	      }
	      patternBuf.deleteCharAt(patternBuf.length() - 1);
	      patternBuf.append(")");
	 
	      //unix换成UTF-8
	      //pattern = Pattern.compile(new String(patternBuf.toString().getBytes("ISO-8859-1"), "UTF-8"));
	      //win下换成gb2312
	      pattern = Pattern.compile(new String(patternBuf.toString().getBytes("ISO-8859-1"), "gb2312"));
	    } catch (IOException ioEx) {
	      ioEx.printStackTrace();
	    }
	  }
	 
	  /**
	   * 屏蔽词取代
	   */
	  private static String doFilter(String str) {
	    Matcher m = pattern.matcher(str);
	    //匹配到的词用 ** 代替
	    str = m.replaceAll("****");
	    return str;
	  }
	 
	  /**
	   * main方法的测试
	   */
	  public static void main(String[] args) {
	    String str = "黄色电影强奸，中国人民，你们都是大傻逼，只知道看小电影，色诱";
	    System.out.println("str:" + str);
	    initPattern();
	    Date d1 = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss:SSS Z");
	    System.out.println("start:" + formatter.format(d1));
	    System.out.println("共" + str.length() + "个字符，查到" + KeyWordFilter.doFilter(str));
	    Date d2 = new Date();
	    System.out.println("end:" + formatter.format(d2));
	 
	  }

}
