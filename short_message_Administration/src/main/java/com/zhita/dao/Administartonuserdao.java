package com.zhita.dao;

import org.apache.ibatis.annotations.Param;

public interface Administartonuserdao {

	
	//登陆
	Integer dengluAdminUser(@Param("administration_name") String administration_name,@Param("administration_password") String administration_password);
	
	
	//查询账号是否存在
	Integer SelectUsers(String administration_name);
}
