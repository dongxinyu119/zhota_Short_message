package com.zhita.service;

import java.util.Map;

public interface Userservice {
	
	public Map<String, Object> denglu(String username,String password);
	
	
	//推出登陆
	Integer DeleteRedis();
	
	

}
