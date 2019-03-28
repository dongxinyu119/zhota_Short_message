package com.zhita.serviceimp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;




import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhita.ExcelTools.ExcelUtil;
import com.zhita.dao.Financialstatementdao;
import com.zhita.model.Cellphone_number;
import com.zhita.model.ExcelBean;
import com.zhita.model.Financial_statement;
import com.zhita.model.PageShortSend;
import com.zhita.model.PageUtil;
import com.zhita.model.Pagefinancial;
import com.zhita.model.Short_send_out;
import com.zhita.service.Financialstatementservice;
import com.zhita.service.RedisBaiseTakes;

@Service
public class Financialstatementserviceimp implements Financialstatementservice{
	
	@Autowired
	private Financialstatementdao fdao;
	
	@Autowired
	private RedisBaiseTakes<?, String, ?> redis;

	@Override
	public Map<String, Object> SelectFina(Pagefinancial fina) {
		int id=Integer.valueOf(redis.get("ids").toString());
		fina.setId(id);
		int totalCount=fdao.SelePageConut(id);
		fina.setId(Integer.valueOf(redis.get("ids").toString()));
		int a=fina.getPage();
		PageUtil pageUtil=new PageUtil(fina.getPage(), totalCount);
		fina.setPagesize(pageUtil.getPageSize());
		fina.setPage(pageUtil.getPage());
		List<Financial_statement> finas=fdao.SelectFina(fina);
		Map<String, Object> maps=new HashMap<String, Object>();
		System.out.println("模糊查询长度："+finas.size());
		pageUtil.setPage(a);
		maps.put("Financial_statement", finas);
		maps.put("PageUtil", pageUtil);
		return maps;
	}

	@Override
	public Map<String, Object> SelectDayFin(Pagefinancial fina) {
		int id=Integer.valueOf(redis.get("ids").toString());
		fina.setId(id);
		int totalCount=fdao.SelePageConut(id);
		int a=fina.getPage();
		fina.setId(Integer.valueOf(redis.get("ids").toString()));
		PageUtil pageUtil=new PageUtil(fina.getPage(), totalCount);
		fina.setPagesize(pageUtil.getPageSize());
		fina.setPage(pageUtil.getPage());
		List<Financial_statement> finas=fdao.SelectDayFina(fina);
		Map<String, Object> maps=new HashMap<String, Object>();
		System.out.println("模糊查询长度："+finas.size());
		pageUtil.setPage(a);
		maps.put("Financial_statement", finas);
		maps.put("PageUtil", pageUtil);
		return maps;
	}

	@Override
	public Map<String, Object> SelectMonthFin(Pagefinancial fina) {
		Map<String, Object> maps=new HashMap<String, Object>();
		int a=fina.getPage();
		int id=Integer.valueOf(redis.get("ids").toString());
		fina.setId(id);
		int totalCount=fdao.SelePageConut(id);
		PageUtil pageUtil=new PageUtil(fina.getPage(), totalCount);
		fina.setPagesize(pageUtil.getPageSize());
		fina.setPage(pageUtil.getPage());
		List<Financial_statement> finas=fdao.SelectMontFina(fina);
		System.out.println("模糊查询长度："+finas.size());
		pageUtil.setPage(a);
		maps.put("Financial_statement", finas);
		maps.put("PageUtil", pageUtil);
		return maps;
		
	}

	@Override
	public int Pageconunt() {
		if(redis.get("ids")!=null){
			int id=Integer.valueOf(redis.get("ids").toString());
			return fdao.SelePageConut(id);
		}
		return 0;
	}

	@Override
	public List<Financial_statement> SelectFyS(int page) {
		return fdao.SelectFeny(page);
		
	}

	
	@Override
	public XSSFWorkbook exportExcelInfo(Pagefinancial fina) throws Exception {
				
				int id=Integer.valueOf(redis.get("ids").toString());
				int totalCount=fdao.SelePageConut(id);
				fina.setId(id);
				PageUtil pageUtil=new PageUtil(fina.getPage(), totalCount);
				fina.setPagesize(pageUtil.getPageSize());
				fina.setPage(pageUtil.getPage());
				System.out.println("当前页:"+fina.getPage());
				//根据条件查询数据
				List<Map<String,Object>> list = fdao.SelectFinacials(fina);
				//System.out.println(list);
				List<ExcelBean> excel = new ArrayList<>();
				Map<Integer,List<ExcelBean>> map = new LinkedHashMap<>();
				//设置标题栏
				excel.add(new ExcelBean("短信网关","ismg_name",0));
				excel.add(new ExcelBean("流水类型","flow_type",0));
				excel.add(new ExcelBean("流水条数","flow_count",0));
				excel.add(new ExcelBean("操作人","operator",0));
				excel.add(new ExcelBean("操作时间","operator_time",0));
				map.put(0,excel);
				String sheetName = "充值消费表";
				//调用ExcelUtil方法
				XSSFWorkbook xssfWorkbook = ExcelUtil.createExcelFile(Financial_statement.class, list, map, sheetName);
				System.out.println(xssfWorkbook);
				return xssfWorkbook;
		
	}

	
	@Override
	public XSSFWorkbook exportExcelInfoDay(Pagefinancial fina) throws Exception {
		int id=Integer.valueOf(redis.get("ids").toString());
		fina.setId(id);
		int totalCount=fdao.SelePageConut(id);
		PageUtil pageUtil=new PageUtil(fina.getPage(), totalCount);
		fina.setPagesize(pageUtil.getPageSize());
		fina.setPage(pageUtil.getPage());
		System.out.println("当前页:"+fina.getPage());
		//根据条件查询数据
		List<Map<String,Object>> list = fdao.SelectFinacialsDay(fina);
		//System.out.println(list);
		List<ExcelBean> excel = new ArrayList<>();
		Map<Integer,List<ExcelBean>> map = new LinkedHashMap<>();
		//设置标题栏
		excel.add(new ExcelBean("短信网关","ismg_name",0));
		excel.add(new ExcelBean("流水类型","flow_type",0));
		excel.add(new ExcelBean("流水条数","flow_count",0));
		excel.add(new ExcelBean("操作时间","operator_time",0));
		map.put(0,excel);
		String sheetName = "消费日记录";
		//调用ExcelUtil方法
		XSSFWorkbook xssfWorkbook = ExcelUtil.createExcelFile(Financial_statement.class, list, map, sheetName);
		System.out.println(xssfWorkbook);
		return xssfWorkbook;
	}

	@Override
	public XSSFWorkbook exportExcelInfoMoth(Pagefinancial fina) throws Exception {
				int id=Integer.valueOf(redis.get("ids").toString());
				fina.setId(id);
				int totalCount=fdao.SelePageConut(id);
				PageUtil pageUtil=new PageUtil(fina.getPage(), totalCount);
				fina.setPagesize(pageUtil.getPageSize());
				fina.setPage(pageUtil.getPage());
				List<Map<String,Object>> list=fdao.SelectFinacialsMoth(fina);
				System.out.println("当前页:"+fina.getPage());
				//根据条件查询数据
				//System.out.println(list);
				List<ExcelBean> excel = new ArrayList<>();
				Map<Integer,List<ExcelBean>> map = new LinkedHashMap<>();
				//设置标题栏
				excel.add(new ExcelBean("短信网关","ismg_name",0));
				excel.add(new ExcelBean("流水类型","flow_type",0));
				excel.add(new ExcelBean("流水条数","flow_count",0));
				excel.add(new ExcelBean("操作时间","operator_time",0));
				map.put(0,excel);
				String sheetName = "消费月记录";
				//调用ExcelUtil方法
				XSSFWorkbook xssfWorkbook = ExcelUtil.createExcelFile(Financial_statement.class, list, map, sheetName);
				System.out.println(xssfWorkbook);
				return xssfWorkbook;
	}

	@Override
	public XSSFWorkbook exportNumberExcel() throws Exception {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> maps=new HashMap<String, Object>();
		maps.put("number", "123465789");
		list.add(maps);
		//System.out.println(list);
		List<ExcelBean> excel = new ArrayList<>();
		Map<Integer,List<ExcelBean>> map = new LinkedHashMap<>();
		//设置标题栏
		excel.add(new ExcelBean("联系方式","number",0));
		map.put(0,excel);
		String sheetName = "联系方式导入";
		//调用ExcelUtil方法
		XSSFWorkbook xssfWorkbook = ExcelUtil.createExcelFile(Cellphone_number.class, list, map, sheetName);
		System.out.println(xssfWorkbook);
		return xssfWorkbook;
	}
	
	
	
	@Override
	public XSSFWorkbook exportExcelInfoShortSendOut(PageShortSend page) throws Exception {
				int id=Integer.valueOf(redis.get("ids").toString());
				int totalCount=fdao.SelePageConut(id);
				PageUtil pageUtil=new PageUtil(page.getPage(), totalCount);
				page.setPagesize(pageUtil.getPageSize());
				page.setPage(pageUtil.getPage());
				List<Map<String,Object>> list=fdao.SelectFinacialsShortSendOut(page);
				System.out.println("当前页:"+page.getPage());
				//根据条件查询数据
				//System.out.println(list);
				List<ExcelBean> excel = new ArrayList<>();
				Map<Integer,List<ExcelBean>> map = new LinkedHashMap<>();
				//设置标题栏
				excel.add(new ExcelBean("任务ID","short_task_id",0));
				excel.add(new ExcelBean("手机号","short_phone_number",0));
				excel.add(new ExcelBean("发送时间","short_time",0));
				excel.add(new ExcelBean("签名","short_autograph",0));
				excel.add(new ExcelBean("短信内容","short_content",0));
				excel.add(new ExcelBean("状态","short_type",0));
				excel.add(new ExcelBean("发送结果","short_result",0));
				excel.add(new ExcelBean("返回值","short_return",0));
				excel.add(new ExcelBean("回执时间","short_receipt_time",0));
				map.put(0,excel);
				String sheetName = "下行报告";
				//调用ExcelUtil方法
				XSSFWorkbook xssfWorkbook = ExcelUtil.createExcelFile(Short_send_out.class, list, map, sheetName);
				System.out.println(xssfWorkbook);
				return xssfWorkbook;
	}
	
}
