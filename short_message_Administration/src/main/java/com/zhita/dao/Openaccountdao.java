package com.zhita.dao;

import java.util.List;

import com.zhita.model.Open_account;
import com.zhita.model.User;

public interface Openaccountdao {
	
	//开户
	Integer InsertOpenacc(Open_account opena);
	
	
	Integer AddUser(User s);
	
	
	//查询公司名称
	Integer Selectcorporate_name(String corporate_name);
	
	
	//查询账号是否存在
	Integer SelectUserName(String username);
	
	
	//重置账户信息
	Integer UpdateOpenacc(Open_account opena);
	
	
	//删除账号
	Integer DeleteOpenaId(Integer open_id);
	
	
	//查询
	List<Open_account> AllOpena(Open_account op);
	
	
	//查询总条数
	Integer SelectCount();

}
