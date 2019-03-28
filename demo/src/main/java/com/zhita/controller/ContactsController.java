package com.zhita.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhita.model.Contacts;
import com.zhita.model.PageContacts;
import com.zhita.service.Contactsservice;
import com.zhita.service.RedisBaiseTakes;


@Controller
@RequestMapping("/con")
public class ContactsController {
	
	@Autowired
	private Contactsservice cservi;
	
	
	@Autowired
	private RedisBaiseTakes<?, String, ?> redis;
	
	
	
	/**
	 * 模糊查询
	 * @param pag
	 * @return
	 * private String 	contacts_name;//联系人名称
	
	private Integer phone_number;//联系电话
	
	private String grouping_name;//分组名称
	 */
	@ResponseBody
	@RequestMapping("Mohu")
	public Map<String, Object> MohuSelect(PageContacts con){
		
		Map<String, Object> ma=new HashMap<String, Object>();
		if(redis.get("ids")!=null){
			con.setId(Integer.valueOf(redis.get("ids").toString()));
			return cservi.MohuSelect(con);
		}
		String a="请登陆";
		ma.put("Contacts", a);
		return ma;
		
	}
	
	
	
	/**
	 * 添加联系人
	 */
	@ResponseBody
	@RequestMapping("addCon")
	public Integer InserCont(Contacts con){
		
		if(redis.get("ids")!=null){
		con.setId(Integer.valueOf(redis.get("ids")));
		return cservi.inserCont(con);
		}
		return 400;
	}
	
	
	/**
	 * 批量删除联系人
	 */
	@ResponseBody
	@RequestMapping("deleteAll")
	public Integer DeleteAll(String[] ids){
		if(redis.get("ids")!=null){
		return cservi.deleteAll(ids);
		}
		return 400;
	}
	
	
	/**
	 * 修改分组
	 */
	@ResponseBody
	@RequestMapping("UpdateGroup")
	public Integer UpdateGroupName(Contacts c){
		if(redis.get("ids")!=null){
			Integer ids=Integer.valueOf(redis.get("ids").toString());
			System.out.println("数据:"+c.getContacts_id()+c.getGrouping_id());
			if(c.getContacts_id()!=null){
				c.setId(ids);
				return cservi.UpdateGrouping(c);
			}
			return 0;
		}
		return 0;
		
	}
	
	
	
	
	
	
	
}
