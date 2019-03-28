package com.zhita.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhita.model.Grouping;
import com.zhita.model.Pagegroup;
import com.zhita.service.Groupingservice;
import com.zhita.service.RedisBaiseTakes;

@Controller
@RequestMapping("/grou")
public class GroupingController {
	
	@Autowired
	private Groupingservice gser;
	
	@Autowired
	private RedisBaiseTakes<?, String, ?> redis;
	
	
	/**
	 * 查询加分页
	 * @param grp
	 * @return list
	 */
	@ResponseBody
	@RequestMapping("SelectGroup")
	public Map<String, Object> SelectGrouping(Pagegroup page){
		Map<String, Object> ma=new HashMap<String, Object>();
		if(redis.get("ids")!=null){	
		return gser.SelectGrou(page);
		}
		String a="未登录";
		ma.put("Grouping", a);
		return ma;
		
	}
	
	/**
	 * 添加分组
	 * @param grop
	 * @return Integer
	 */
	@ResponseBody
	@RequestMapping("InsertGroup")
	public String ImsertGroup(String grouping_name){
		if(redis.get("ids")!=null){
			Grouping grop=new Grouping();
			grop.setId(Integer.parseInt(redis.get("ids")));
			grop.setGrouping_name(grouping_name);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			grop.setGrouping_date(df.format(new Date()));
			return gser.InsertGroup(grop);
		}
		
		return "未登录";
	}
	
	/**
	 * 批量删除
	 * */
	@ResponseBody
	@RequestMapping("delteAllGroup")
	public Integer delteAllGroup(String[] ids){
		return gser.DeleteGroup(ids);
	}
	
	
	/***
	 * 单个删除
	 */
	@ResponseBody
	@RequestMapping("deleteOneGroup")
	public Integer delteOneGroup(Integer grouping_id){
		return gser.DeleteOne(grouping_id);
	}
	
	
	
	
}
