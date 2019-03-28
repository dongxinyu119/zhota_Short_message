package com.zhita.controller;

import java.io.BufferedOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhita.model.PageShort;
import com.zhita.model.PageShortSend;
import com.zhita.model.Short_message;
import com.zhita.service.RedisBaiseTakes;
import com.zhita.service.Shortmessageservice;
import com.zhita.tool.TestString;

@Controller
@RequestMapping("/shortmessage")
public class ShortmessageController {
	
	@Autowired
	private Shortmessageservice shors;
	
	
	@Autowired
	private RedisBaiseTakes<?, String, ?> redis;
	
	
	
	
	//添加短信
	@RequestMapping("AddShotr")
	@ResponseBody
	public Integer AddShort(@RequestBody String params){
		
		if(redis.get("ids")!=null){
			JSONObject object =JSON.parseObject(params);
			Short_message shor = JSON.toJavaObject(object, Short_message.class);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	        Integer id=Integer.valueOf(redis.get("ids"));
	        SimpleDateFormat dfC = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
			int d=shor.getA()+shor.getC()+shor.getB();
			shor.setId(id);
			shor.setShort_count(""+shor.getA()+","+shor.getB()+","+shor.getC()+"");
			shor.setShort_number_count(d);
			shor.setShort_task_id(dfC.format(new Date()));
			shor.setShort_time(df.format(new Date()));
			System.out.println("手机号:"+shor.getNumbers());
			shor.setShort_type("等待审核");
			return shors.AddShortMessage(shor);
		}
		return 0;
		}
	
	
	
	//查询等待审核短信
	@RequestMapping("SelectShenh")
	@ResponseBody
	public Map<String, Object> SeleShort(PageShort page){
		Map<String, Object> ma=new HashMap<String, Object>();
		if(redis.get("ids")!=null){	
		return shors.ExamineShort(page);
		}
		String a="未登录";
		ma.put("Short_message", a);
		return ma;
	}
	
	
	
	
	//查询等待发送短信
	@RequestMapping("SelectMessage")
	@ResponseBody
	public Map<String, Object> SeleMessage(PageShort page){
		Map<String, Object> ma=new HashMap<String, Object>();
		if(redis.get("ids")!=null){	
		return shors.DengdaiShort(page);
		}
		String a="未登录";
		ma.put("Short_message", a);
		return ma;
	}
	
	
	
	
	//查询发送成功短信
	@RequestMapping("OKshort")
	@ResponseBody
	public Map<String, Object> SelectShortOk(PageShort page){
		Map<String, Object> ma=new HashMap<String, Object>();
		if(redis.get("ids")!=null){	
		return shors.ShortMessageOK(page);
		}
		String a="未登录";
		ma.put("Short_message", a);
		return ma;
	}
	
	
	

	public  String genAttachmentFileName(String cnName, String defaultName) {
        try {
            cnName = new String(cnName.getBytes("gb2312"), "ISO8859-1");
        } catch (Exception e) {
            cnName = defaultName;
        }
        return cnName;
    }
	
	
	@RequestMapping("test")
    public void add(String short_task_id,HttpServletRequest request, HttpServletResponse response){
    	//string 字符串  导出内容
		short_task_id="158710001";
		List<String> s=shors.getNumber(short_task_id);
        String string = TestString.listToStringTxt(s);//把集合转换成字符串
        System.out.println("转换的电话好:"+string);
        System.out.println("进入");
        //设置响应的内容类型
        response.setContentType("text/plain");
        //设置文件的名称和格式
        response.addHeader("Content-Disposition","attachment;filename="
                + genAttachmentFileName( "手机号码", "JSON_FOR_UCC_")//设置名称格式，没有这个中文名称无法显示
                + ".txt");
        BufferedOutputStream buff = null;
        ServletOutputStream outStr = null;
        try {
            outStr = response.getOutputStream();
            buff = new BufferedOutputStream(outStr);
            buff.write(string.getBytes("UTF-8"));
            buff.flush();
            buff.close();
            System.err.println("shang mian  zou wan le ----------------");
        } catch (Exception e) {
            //LOGGER.error("导出文件文件出错:{}",e);
        } finally {
        	try {
            buff.close();
            outStr.close();
        } catch (Exception e) {
            //LOGGER.error("关闭流对象出错 e:{}",e);
        }
        }
    }
	
/*	
//	/**
//     * 下载txt
//     * @param response
//     * @throws IOException
//     */
//    @RequestMapping("download")
//    public void download(HttpServletResponse response,String filePath ) throws IOException{
//        //用result来保存txt文档的内容，具体内容请自己写读取流操作
//        byte[] result =TxtUtils.readTxtFile(filePath).getBytes();
//        OutputStream os = response.getOutputStream();
//        try {
//            response.reset();
//            response.setHeader("Content-Disposition", "attachment; filename=" + new Date().getTime() + ".txt");
//            response.setContentType("text/plain;charset=utf-8");
//            os.write(result);
//            os.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (os != null) {
//                os.close();
//            }
//        }
//    }
//    
	
	
	
	//模糊查询分页下行报告
	@RequestMapping("OutSelect")
	@ResponseBody
	public Map<String, Object> SelectMapShort(PageShortSend page){
		
		Map<String, Object> ma=new HashMap<String, Object>();
		if(redis.get("ids")!=null){	
		return shors.Short_map(page);
		}
		String a="未登录";
		ma.put("Short_send_out", a);
		return ma;
	}
	
	
	
	//删除等待审核
	@RequestMapping("deleteShort")
	@ResponseBody
	public Integer DeleteShort(Integer short_message_id){
		return shors.DeleteShenhe(short_message_id);
	}
  
	
	//屏蔽词
	@RequestMapping("TestPing")
	@ResponseBody
	public Boolean TestShortContr(String str) throws Exception{
		return shors.ShortContext(str);
	}

	
	
	
	
	
	
	
	
	
}
