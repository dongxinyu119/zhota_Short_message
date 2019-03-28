package com.zhita.service;

import java.util.List;
import java.util.Map;

import com.zhita.model.PageShort;
import com.zhita.model.PageShortSend;
import com.zhita.model.Short_message;

public interface Shortmessageservice {
	
	//短信发送添加
	Integer AddShortMessage(Short_message mesg);
	
	
	//短信等待审核(含分页)
	Map<String, Object> ExamineShort(PageShort shor);
	
	
	//等候发送(含分页)
	Map<String, Object> DengdaiShort(PageShort page);
	
	
	
	//查询已完成短信(含分页)
	Map<String, Object> ShortMessageOK(PageShort pages);
	
	
	
	//查询导出的手机号
	List<String> getNumber(String short_task_id);
	
	
	//模糊查询下行报告
	Map<String, Object> Short_map(PageShortSend page);

	
	//取消发送
	Integer DeleteShenhe(Integer short_message_id);
	
	
	//屏蔽词
	Boolean ShortContext(String str) throws Exception;



	
}
