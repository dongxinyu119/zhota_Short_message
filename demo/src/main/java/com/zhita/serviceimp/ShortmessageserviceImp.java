package com.zhita.serviceimp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhita.dao.Shortdao;
import com.zhita.dao.ShortsendReplydao;
import com.zhita.model.PageShort;
import com.zhita.model.PageShortSend;
import com.zhita.model.PageUtil;
import com.zhita.model.Short_message;
import com.zhita.model.Short_send_out;
import com.zhita.model.Testing;
import com.zhita.service.RedisBaiseTakes;
import com.zhita.service.Shortmessageservice;
import com.zhita.tool.SensitiveWordUtil2;
import com.zhita.tool.TuoMinUtil;

@Service
public class ShortmessageserviceImp implements Shortmessageservice{

	@Autowired
	private Shortdao sdao;
	
	@Autowired
	private ShortsendReplydao sendao;
	
	
	@Autowired
	private RedisBaiseTakes<?, String, ?> redis;
	
	
	
	
	
	@Override
	public Integer AddShortMessage(Short_message mesg) {
		return sdao.InsertShort(mesg);
	}

	
	
	@Override
	public Map<String, Object> ExamineShort(PageShort shor) {
		int id=Integer.valueOf(redis.get("ids").toString());
		shor.setId(id);
		int totalCount=sdao.SelectCount(id);
		int a=shor.getPage();
		PageUtil pageUtil=new PageUtil(shor.getPage(), totalCount);
		shor.setPagesize(pageUtil.getPageSize());
		shor.setPage(pageUtil.getPage());
		List<Short_message> finas=sdao.dengdaiShenhe(shor);
		Map<String, Object> maps=new HashMap<String, Object>();
		System.out.println("模糊查询长度："+finas.size());
		pageUtil.setPage(a);
		maps.put("Short_message", finas);
		maps.put("PageUtil", pageUtil);
		return maps;
	}

	@Override
	public Map<String, Object> DengdaiShort(PageShort shor) {
		int id=Integer.valueOf(redis.get("ids").toString());
		shor.setId(id);
		int totalCount=sdao.SelectCount(id);
		int a=shor.getPage();
		PageUtil pageUtil=new PageUtil(shor.getPage(), totalCount);
		shor.setPagesize(pageUtil.getPageSize());
		shor.setPage(pageUtil.getPage());
		List<Short_message> finas=sdao.dengdaiMessage(shor);
		Map<String, Object> maps=new HashMap<String, Object>();
		System.out.println("模糊查询长度："+finas.size());
		pageUtil.setPage(a);
		maps.put("Short_message", finas);
		maps.put("PageUtil", pageUtil);
		return maps;
	}

	
	@Override
	public Map<String, Object> ShortMessageOK(PageShort pages) {
		int id=Integer.valueOf(redis.get("ids").toString());
		pages.setId(id);
		int totalCount=sdao.SelectCount(id);
		int a=pages.getPage();
		PageUtil pageUtil=new PageUtil(pages.getPage(), totalCount);
		pages.setPagesize(pageUtil.getPageSize());
		pages.setPage(pageUtil.getPage());
		List<Short_message> finas=sdao.ShortMessageOk(pages);
		Map<String, Object> maps=new HashMap<String, Object>();
		System.out.println("模糊查询长度："+finas.size());
		pageUtil.setPage(a);
		maps.put("Short_message", finas);
		maps.put("PageUtil", pageUtil);
		return maps;
	}



	@Override
	public Map<String, Object> Short_map(PageShortSend page) {
		int id=Integer.valueOf(redis.get("ids").toString());
		page.setId(id);
		int totalCount=sdao.SelectCount(id);
		int a=page.getPage();
		PageUtil pageUtil=new PageUtil(page.getPage(), totalCount);
		page.setPagesize(pageUtil.getPageSize());
		page.setPage(pageUtil.getPage());
		List<Short_send_out> finas=sendao.SelectMoH(page);
		for(Short_send_out s:finas){
			TuoMinUtil tou=new TuoMinUtil();
			String sa=tou.mobileEncrypt(s.getShort_phone_number());
			s.setShort_phone_number(sa);
		}
		Map<String, Object> maps=new HashMap<String, Object>();
		System.out.println("模糊查询长度："+finas.size());
		pageUtil.setPage(a);
		maps.put("Short_send_out", finas);
		maps.put("PageUtil", pageUtil);
		return maps;
	}



	@Override
	public List<String> getNumber(String short_task_id) {
		return sdao.SelectNumber(short_task_id);
	}



	@Override
	public Integer DeleteShenhe(Integer short_message_id) {
		return sdao.deleteShenhe(short_message_id);
	}



	@Override
	public Boolean ShortContext(String str) throws Exception {
		List<Testing> list=sendao.selectTest();
		Set<String> sensitiveWordSet = new HashSet<>();
		for(Testing t:list){
			sensitiveWordSet.add(t.getTesting_context());
		}
		SensitiveWordUtil2.init(sensitiveWordSet);
		return SensitiveWordUtil2.contains(str);
	}
	
	
	


	
	



	
	
	

}
