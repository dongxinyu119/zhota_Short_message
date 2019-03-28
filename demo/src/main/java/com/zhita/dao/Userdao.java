package com.zhita.dao;

import org.apache.ibatis.annotations.Param;

public interface Userdao {

	//查询账号密码是否正确
	Integer login(@Param("username") String username,@Param("password") String password);
	
	
	//查询账号是否存在
	Integer SelectUser(@Param("username") String username);
	
	
	//查询账号是否注销
	Integer openID(String username);
	
	
	
	
}
