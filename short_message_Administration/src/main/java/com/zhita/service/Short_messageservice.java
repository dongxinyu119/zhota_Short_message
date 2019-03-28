package com.zhita.service;

import java.util.List;
import java.util.Map;

import com.zhita.model.Ismg;
import com.zhita.model.PageShort;
import com.zhita.model.Short_message;
import com.zhita.model.Short_send;


public interface Short_messageservice {
	
	//查询待审核短信(含分页)
	Map<String, Object> SeleShenh(PageShort page);
	
	
	//短信驳回
	Integer UpdateShotype(String short_task_id);
	
	
	//发送状态
	Map<String, Object> SelectSendType(PageShort page);
	
	
	//发送短信
	Short_send ShortSend(Short_message sh);
	
	
	//修改状态
	Integer Update_send(Integer messageid,Integer ismg_id);
	
	
	//查询网关
	List<Ismg> SeleIsmg();
	
	
	
	
	


	
}
