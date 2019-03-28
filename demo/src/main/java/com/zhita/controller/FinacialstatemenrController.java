package com.zhita.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhita.model.Financial_statement;
import com.zhita.model.PageUtil;
import com.zhita.model.Pagefinancial;
import com.zhita.service.Financialstatementservice;
import com.zhita.service.RedisBaiseTakes;



@Controller
@RequestMapping("/fina")
public class FinacialstatemenrController {
	
	@Autowired
	private Financialstatementservice fser;
	
	

	@Autowired
    private RedisBaiseTakes<?, String, ?> redis;
	
	
	@ResponseBody
	@RequestMapping("SelectHm")
	public Map<String, Object> Selectmohu(Pagefinancial fina){
		Integer ids=Integer.valueOf(redis.get("ids").toString());
		Map<String, Object> ma=new HashMap<String, Object>();
		if(ids!=null){
			return fser.SelectFina(fina);
		}
		String a="未登录";
		ma.put("Financial_statement",a );
		return ma;
		
	}
	
	
	@ResponseBody
	@RequestMapping("SelectDayHm")
	public Map<String, Object> SelectmohuDay(Pagefinancial fina){
		Map<String, Object> ma=new HashMap<String, Object>();
		if(redis.get("ids")!=null){
		return fser.SelectDayFin(fina);
		}
		String a="未登录";
		ma.put("Financial_statement",a );
		return ma;
	}
	
	
	@ResponseBody
	@RequestMapping("SelectMothHm")
	public Map<String, Object> SelectmohuMoth(Pagefinancial fina){
		Map<String, Object> ma=new HashMap<String, Object>();
		if(redis.get("ids")!=null){	
		return fser.SelectMonthFin(fina);
		}
		String a="未登录";
		ma.put("Financial_statement",a );
		return ma;
	}
	
	@ResponseBody
	@RequestMapping("SelectFy")
	public List<Financial_statement> SelectFy(Integer page){
		
		int totalCount=fser.Pageconunt();
		PageUtil pageUtil=new PageUtil(page, totalCount);
		List<Financial_statement> fins=fser.SelectFyS(pageUtil.getPage());
		
		return fins;
	}

}
