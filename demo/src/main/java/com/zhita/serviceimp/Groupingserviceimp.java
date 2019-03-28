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
import com.zhita.dao.Groupingdao;
import com.zhita.model.Contacts;
import com.zhita.model.ExcelBean;
import com.zhita.model.Grouping;
import com.zhita.model.PageUtil;
import com.zhita.model.Pagegroup;
import com.zhita.service.Groupingservice;
import com.zhita.service.RedisBaiseTakes;

@Service
public class Groupingserviceimp implements Groupingservice{
	
	@Autowired
	private Groupingdao gdao;
	
	@Autowired
	private RedisBaiseTakes<?, String, ?> redis;

	@Override
	public Map<String, Object> SelectGrou(Pagegroup pa) {
		Map<String, Object> maps=new HashMap<String, Object>();
		if(redis.get("ids")!=null){
			int id=Integer.valueOf(redis.get("ids").toString());
			int totalCount=gdao.SelePageConut(id);
			int a=pa.getPage();
			pa.setId(id);
			PageUtil pageUtil=new PageUtil(pa.getPage(), totalCount);
			pa.setPagesize(pageUtil.getPageSize());
			pa.setPage(pageUtil.getPage());
			List<Grouping> finas=gdao.SelectGrop(pa);
			pageUtil.setPage(a);
			maps.put("Grouping", finas);
			maps.put("PageUtil", pageUtil);
			return maps;
		}
		String finas="未登录";
		maps.put("Grouping", finas);
		return maps;
	}

	@Override
	public Integer DeleteGroup(String[] ids) {
		return gdao.DeletAllGrou(ids);
	}

	@Override
	public String InsertGroup(Grouping grou) {
		grou.setId(Integer.valueOf(redis.get("ids").toString()));
		Integer a=gdao.SelectGroupName(grou);
		if(a==null){
			gdao.InsertGrou(grou);
			return "200";
		}
		return "0";
	}

	@Override
	public Integer DeleteOne(Integer grouping_id) {
		return gdao.DeleteOne(grouping_id);
	}

	@Override
	public XSSFWorkbook exportExcelGroup() throws Exception {
		//根据条件查询数据
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> maps=new HashMap<String, Object>();
		maps.put("contacts_name", "张三");
		maps.put("phone_number", "13871111111");
		maps.put("contacts_remarks", "朋友");
		list.add(maps);
		//System.out.println(list);
		List<ExcelBean> excel = new ArrayList<>();
		Map<Integer,List<ExcelBean>> map = new LinkedHashMap<>();
		//设置标题栏
		excel.add(new ExcelBean("名称","contacts_name",0));
		excel.add(new ExcelBean("电话","phone_number",0));
		excel.add(new ExcelBean("备注","contacts_remarks",0));
		map.put(0,excel);
		String sheetName = "通讯录模板";
		//调用ExcelUtil方法
		XSSFWorkbook xssfWorkbook = ExcelUtil.createExcelFile(Contacts.class, list, map, sheetName);
		System.out.println(xssfWorkbook);
		return xssfWorkbook;
	}
	
	
	
	
	

}
