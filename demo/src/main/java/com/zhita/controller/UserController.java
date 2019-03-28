package com.zhita.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhita.service.Userservice;
import com.zhita.tool.EncodeUtil;


@Controller
@RequestMapping("/us")
public class UserController {
	
	@Autowired
	private Userservice users;
	
	
	@RequestMapping("log")
	@ResponseBody
	public Map<String, Object> logins(String username,String password){
		Map<String, Object> a=users.denglu(username, password);
		System.out.println(a.get("msg"));
		EncodeUtil util=new EncodeUtil();
		if(password!=null){
			String sa=util.MD5(password);
			System.out.println("MD5后:"+sa);
		}
		
		return a;
	}
	
	
	@RequestMapping("DeleteRedis")
	@ResponseBody
	public Integer DeleteRedis(){
		return users.DeleteRedis();
	}
}
