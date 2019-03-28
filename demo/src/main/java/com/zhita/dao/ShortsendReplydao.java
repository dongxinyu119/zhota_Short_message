package com.zhita.dao;

import java.util.List;

import com.zhita.model.PageShortSend;
import com.zhita.model.Short_send_out;
import com.zhita.model.Testing;
public interface ShortsendReplydao {
	

	//导出手机号
	List<String> SelectNumber(String short_task_id);
	
	
	//模糊查询下行报告
	List<Short_send_out> SelectMoH(PageShortSend page);
	
	
	//查询屏蔽词
	List<Testing> selectTest();
}
