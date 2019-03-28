package com.zhita.serviceimp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zhita.dao.Userdao;
import com.zhita.model.User;
import com.zhita.service.RedisBaiseTakes;
import com.zhita.service.Userservice;


@Service
public class Userserviceimp implements Userservice{
	
	@Autowired
	private Userdao udao;
	
	
	@Autowired
	private RedisBaiseTakes<?, String, ?> redisbai;
	

	@Override
	public Map<String, Object> denglu(String username, String password) {
		Map<String, Object> map= new HashMap<String,Object>();
		if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password))
		{
			map.put("msg", "账号密码不能为空");
			return map;
		}else{
			Integer a=udao.SelectUser(username);
			if(a!=null){
				Integer c=udao.login(username, password);
				Integer d=udao.openID(username);
				if(c==null){
					map.put("msg", "账号或密码错误");
					return map;
				}else if(d==null){
					
					map.put("msg", "该账号已注销");
					return map;
				}else{
					List<User> users=new ArrayList<User>();
					User u=new User();
					u.setPassword(password);
					u.setUsername(username);
					u.setId(c);
					users.add(u);
					redisbai.add("Users", users.toString());
					redisbai.add("ids", c.toString());
					map.put("msg", "200");
					
				}
			}else{
				map.put("msg", "账号不存在");
				return map;
			}
		}
		return map;
	}


	@Override
	public Integer DeleteRedis() {
		redisbai.delete("ids");
		return 200;
	}
	
	
}
