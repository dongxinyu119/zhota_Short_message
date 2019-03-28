package com.zhita.service;

import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zhita.model.Grouping;
import com.zhita.model.Pagegroup;

public interface Groupingservice {
	
	/**
	 * 查询分组带分页
	 * 
	 */
	Map<String, Object> SelectGrou(Pagegroup pa);
	
	
	
	/**
	 * 批量删除分组
	 * 
	 */
	Integer DeleteGroup(String[] ids);
	
	
	/**
	 * 添加分组
	 * 
	 */
	String InsertGroup(Grouping grou);
	
	
	/**
	 * 单个删除
	 * 
	 */
	Integer DeleteOne(Integer grouping_id);
	
	
	
	/**
	 * 导入模板
	 * 
	 */
	XSSFWorkbook exportExcelGroup() throws Exception; 

}
