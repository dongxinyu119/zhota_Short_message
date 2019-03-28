package com.zhita.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhita.model.PageShortSend;
import com.zhita.model.Pagefinancial;
import com.zhita.service.Contactsservice;
import com.zhita.service.Financialstatementservice;
import com.zhita.service.Groupingservice;
import com.zhita.service.RedisBaiseTakes;
import com.zhita.service.Shortmessageservice;

@Controller
@RequestMapping("/exce")
public class ExcelController {
	
	@Autowired
	private Contactsservice cser;
	
	@Autowired
	private Financialstatementservice fser;
	
	@Autowired
	private Groupingservice gser;
	
	@Autowired
    private RedisBaiseTakes<?, String, ?> seeUserRedisTakes;
	
	
	@Autowired
	private Shortmessageservice sh;
	
	
	/**
	 * from表单提交才能实现导出excel
	 * 导出充值流水
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("export")
	@ResponseBody
	public void export(HttpServletRequest request,HttpServletResponse response,Pagefinancial fina) throws Exception{
	        response.reset(); //清除buffer缓存  
	        //Map<String,Object> map=new HashMap<String,Object>(); 
	        response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
	        response.setHeader("Content-Disposition","attachment;filename="+new String("充值消费流水表.xlsx".getBytes(),"iso-8859-1"));

			//导出Excel对象  
	        XSSFWorkbook workbook = fser.exportExcelInfo(fina);
	        OutputStream output; 
	        try {  
	        	output = response.getOutputStream();
	            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);  
	            bufferedOutput.flush();  
	            workbook.write(bufferedOutput);  
	            bufferedOutput.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }
	}
	
	
	/**
	 * from表单提交才能实现导出excel
	 * 导出充值流水日消费
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("ExcelDay")
	@ResponseBody
	public void ExportDay(HttpServletRequest request,HttpServletResponse response,Pagefinancial fina) throws Exception{
		 response.reset(); //清除buffer缓存  
	        //Map<String,Object> map=new HashMap<String,Object>(); 
	        response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
	        response.setHeader("Content-Disposition","attachment;filename="+new String("充值消费日记录表.xlsx".getBytes(),"iso-8859-1"));
	        //导出excel对象
	        XSSFWorkbook workbook = fser.exportExcelInfoDay(fina);
	        OutputStream output;
	        try {
	        	output = response.getOutputStream();
	            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);  
	            bufferedOutput.flush();  
	            workbook.write(bufferedOutput);  
	            bufferedOutput.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	
	/**
	 * from表单提交才能实现导出excel
	 * 导出充值流水月消费
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("ExcelMoth")
	@ResponseBody
	public void ExportMoth(HttpServletRequest request,HttpServletResponse response,Pagefinancial fina) throws Exception{
		 response.reset(); //清除buffer缓存  
	        //Map<String,Object> map=new HashMap<String,Object>(); 
	        response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
	        response.setHeader("Content-Disposition","attachment;filename="+new String("充值消费月记录表.xlsx".getBytes(),"iso-8859-1"));
	        //导出excel对象
	        XSSFWorkbook workbook = fser.exportExcelInfoMoth(fina);
	        OutputStream output;  
	        try {
	        	output = response.getOutputStream();
	            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);  
	            bufferedOutput.flush();  
	            workbook.write(bufferedOutput);  
	            bufferedOutput.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	
	
	
	/**
	 * 分组参考模板
	 */
	@RequestMapping("ExcelGrouping")
	@ResponseBody
	public void ExcelGroup(HttpServletRequest request,HttpServletResponse response)throws Exception{
		response.reset(); //清除buffer缓存  
        //Map<String,Object> map=new HashMap<String,Object>(); 
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
        response.setHeader("Content-Disposition","attachment;filename="+new String("导入.xlsx".getBytes(),"iso-8859-1"));
        //导出excel对象
        XSSFWorkbook workbook = gser.exportExcelGroup();
        OutputStream output;  
        try {
        	output = response.getOutputStream();
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);  
            bufferedOutput.flush();  
            workbook.write(bufferedOutput);  
            bufferedOutput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 导出通讯录模板
	 */
	@RequestMapping("ToExcelGroup")
	@ResponseBody
	public void exportGroup(HttpServletRequest request,HttpServletResponse response) throws Exception{
	response.reset(); //清除buffer缓存  
    //Map<String,Object> map=new HashMap<String,Object>(); 
    response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
    response.setHeader("Content-Disposition","attachment;filename="+new String("通讯录模板.xlsx".getBytes(),"iso-8859-1"));
	//导出Excel对象  
    XSSFWorkbook workbook = gser.exportExcelGroup();
    OutputStream output; 
    try {  
    	output = response.getOutputStream();
        BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);  
        bufferedOutput.flush();  
        workbook.write(bufferedOutput);  
        bufferedOutput.close();  
    } catch (IOException e) {  
        e.printStackTrace();  
    }
	}
	
	
	/**
	 * 号码分流中的例子模板
	 */
	@RequestMapping("NumberExcel")
	@ResponseBody
	public void NumberExcel(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.reset(); //清除buffer缓存  
	    //Map<String,Object> map=new HashMap<String,Object>(); 
	    response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
	    response.setHeader("Content-Disposition","attachment;filename="+new String("导入手机号模板.xlsx".getBytes(),"iso-8859-1"));
	  //导出Excel对象  
	    XSSFWorkbook workbook = fser.exportNumberExcel();
	    OutputStream output; 
	    try {  
	    	output = response.getOutputStream();
	        BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);  
	        bufferedOutput.flush();  
	        workbook.write(bufferedOutput);  
	        bufferedOutput.close();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }
		
	}
	
	
	/**
	 * 联系人分组 导入excel表格内容
	 * @return 
	 */
	@RequestMapping("InputExcels")
	@ResponseBody
    public String UploadExcel(String grouping_name,HttpServletRequest request,HttpServletResponse response) throws Exception {  
        Integer id=Integer.valueOf(seeUserRedisTakes.get("ids"));
		return cser.ajaxUploadExcel(id,request, response,grouping_name);
    }
	
	
	/**
	 * 导出下行报告
	 * 
	 */
	@RequestMapping("TophoneNumber")
	@ResponseBody
	public void ToNumber(HttpServletRequest request,HttpServletResponse response,PageShortSend page) throws Exception{
		response.reset(); //清除buffer缓存  
        //Map<String,Object> map=new HashMap<String,Object>(); 
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
        response.setHeader("Content-Disposition","attachment;filename="+new String("下行报告.xlsx".getBytes(),"iso-8859-1"));
        //导出excel对象
        XSSFWorkbook workbook = fser.exportExcelInfoShortSendOut(page);
        OutputStream output;  
        try {
        	output = response.getOutputStream();
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);  
            bufferedOutput.flush();  
            workbook.write(bufferedOutput);  
            bufferedOutput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
