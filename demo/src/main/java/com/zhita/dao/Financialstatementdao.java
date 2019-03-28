package com.zhita.dao;

import java.util.List;
import java.util.Map;

import com.zhita.model.Financial_statement;
import com.zhita.model.PageShortSend;
import com.zhita.model.Pagefinancial;

public interface Financialstatementdao {
	
	
	/**
	 * 模糊查询流水记录
	 * 
	 */
	List<Financial_statement> SelectFina(Pagefinancial fina);
	
	
	/**
	 * 模糊查询日记录
	 * 
	 */
	List<Financial_statement> SelectDayFina(Pagefinancial fina);
	
	
	/**
	 * 模糊查询月记录
	 * 
	 */
	List<Financial_statement> SelectMontFina(Pagefinancial fina);
	
	
	/**
	 * 总数
	 */
	int SelePageConut(Integer id);
	
	
	/**
	 * 分页
	 */
	List<Financial_statement> SelectFeny(int page);
	
	
	
	/**
	 * 充值消费导出
	 */
	List<Map<String, Object>> SelectFinacials(Pagefinancial fina);
	
	/**
	 * 消费日导出
	 */
	List<Map<String, Object>> SelectFinacialsDay(Pagefinancial fina);
	
	
	/**
	 * 消费月导出
	 */
	List<Map<String, Object>> SelectFinacialsMoth(Pagefinancial fina);
	
	
	
	/**
	 *下行报告导出
	 */
	List<Map<String, Object>> SelectFinacialsShortSendOut(PageShortSend page);

}
