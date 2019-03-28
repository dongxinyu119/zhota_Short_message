package com.zhita.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zhita.model.Financial_statement;
import com.zhita.model.PageShortSend;
import com.zhita.model.Pagefinancial;

public interface Financialstatementservice {
	
	/**
	 * 模糊查询含分页
	 */
	Map<String, Object> SelectFina(Pagefinancial pagefin);

	
	/**
	 * 模糊查询(日记录) 含分页
	 */
	Map<String, Object> SelectDayFin(Pagefinancial pagefin);
	
	
	/**
	 * 模糊查询(月记录) 含分页
	 */
	Map<String, Object> SelectMonthFin(Pagefinancial pagefin);
	
	
	/**
	 * 总数
	 */
	int Pageconunt();
	
	
	/**
	 * 分页
	 */
	List<Financial_statement> SelectFyS(int page);
	
	
	/**
	 * 导出消费流水
	 * 
	 */
	XSSFWorkbook exportExcelInfo(Pagefinancial fina) throws Exception;
	
	
	/**
	 * 导出充值消费日记录
	 */
	XSSFWorkbook exportExcelInfoDay(Pagefinancial fina) throws Exception;
	
	/**
	 * 导出充值消费月记录
	 */
	XSSFWorkbook exportExcelInfoMoth(Pagefinancial fina) throws Exception;
	
	
	/**
	 * 导入联系方式模板
	 */
	XSSFWorkbook exportNumberExcel() throws Exception;


	XSSFWorkbook exportExcelInfoShortSendOut(PageShortSend page)
			throws Exception;
	
	

}
