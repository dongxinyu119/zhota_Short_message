package com.zhita.dao;

import java.util.List;



import com.zhita.model.PageShort;
import com.zhita.model.Short_message;
import com.zhita.model.short_number;

public interface Shortdao {
	
	
	//添加发送短信
	Integer InsertShort(Short_message mesg);
	
	
	//等待审核
	List<Short_message> dengdaiShenhe(PageShort page);
	
	
	//等待发送
	List<Short_message> dengdaiMessage(PageShort page);
	
	
	//查询已完成短信
	List<Short_message> ShortMessageOk(PageShort page);
	
	
	//查询短信数量
	int SelectCount(Integer id);
	
	
	//查询手机号
	List<String> SelectNumber(String short_task_id);
	
	
	//取消发送
	Integer deleteShenhe(Integer short_message_id);
	
	
	//查询短信ID
	Integer SelectShort_messageid(String short_task_id);
	
	//添加手机号
	Integer InsetShortNumber(short_number num);
	
	


}
