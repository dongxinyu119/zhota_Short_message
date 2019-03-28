package com.zhita.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.zhita.model.Open_account;

public interface Openaccountservice {
	
	//开户
	String InserOpena(Open_account opena,MultipartFile file, ModelMap map)throws  IOException ;

	//重置账号
	Integer UpdateOpena(Open_account opena);
	
	//删除账号
	Integer DeleteOpena(Integer open_id);
	
	//查询+分页
	Map<String, Object> SelectOpena(Open_account open);
}
