package com.zhita.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhita.model.Pagerecarge;
import com.zhita.model.Short_recharge;
import com.zhita.model.Shortrecord;
import com.zhita.service.Short_recargeservice;

@Controller
@RequestMapping("Short_recag")
public class Short_recargeController {
	
	@Autowired
	private Short_recargeservice rservi;
	
	
	@RequestMapping("SelectRecage")
	@ResponseBody
	public Map<String, Object> SelectRecage(Pagerecarge p){
		return rservi.SelectShort_recarge(p);
	}
	
	
	@RequestMapping("UpdateRecha")
	@ResponseBody
	public Integer Update(Integer short_count,Integer recharge_id,Integer sum){
		System.out.println("走接口");
      		Short_recharge rea=new Short_recharge();
		rea.setShort_count(short_count);
		rea.setSum(sum);
		rea.setRecharge_id(recharge_id);
		return rservi.UpdateShortRecha(rea);
	}
	
	@RequestMapping("Selectrecord")
	@ResponseBody
	public List<Shortrecord> SelectRecord(Integer recharge_id){
		return rservi.SelectShortrecord(recharge_id);
	}
	
	
	
	
	
	
	
}
