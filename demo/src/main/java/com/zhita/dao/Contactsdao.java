package com.zhita.dao;

import java.util.List;

import com.zhita.model.Contacts;
import com.zhita.model.PageContacts;

public interface Contactsdao {
	
	//模糊查询
	List<Contacts> MohuSelect(PageContacts con);
	
	
	//添加联系人
	Integer InsertCon(Contacts con);
	
	
	//批量删除联系人
	Integer DeletAllCon(String[] ids);
	
	
	//消息总数
	Integer SelePageConut();
	
	//修改分组名称
	Integer GroupingName(Contacts c);
	
	

}
