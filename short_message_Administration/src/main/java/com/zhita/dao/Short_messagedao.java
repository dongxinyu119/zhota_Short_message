package com.zhita.dao;

import java.util.List;

import com.zhita.model.Financial_statement;
import com.zhita.model.PageShort;
import com.zhita.model.Short_message;
import com.zhita.model.Short_recharge;
import com.zhita.model.Short_send_out;
import com.zhita.model.Ismg;

public interface Short_messagedao {
	
	//查询审核短信
	List<Short_message> SelectPage(PageShort page);
	
	
	//发送短信
	Integer InserShot(Short_send_out shortsend);
	
	
	//短信驳回
	Integer UpdateShotype(String short_task_id);
	
	
	//查询短信条数
	Integer SelectCount();
	
	
	//发送状态
	List<Short_message> ShortMessageOk(PageShort page);
	
	
	//修改状态
	Integer Shortsend(Short_message sh);
	
	
	//添加
	Integer InsertIntoShort(Short_send_out sh);
	
	
	//添加网关
	Integer insertIms(Ismg ps);
	
	
	Integer delete_name();
	
	
	//查询网管
	List<Ismg> SelectIsm();
	
	
	//查询手机号
	List<String> nums(Integer short_message_id);
	
	
	//添加流水统计
	Integer InsertIntoFina(Financial_statement fina);
	
	
	//修改网管数量
	Integer UpdateCount(Ismg is);
	
	
	//查询网关
	Ismg OneIsmg(Integer ismg_id);
	
	
	Short_message SelectShortMessage(Integer short_message_id);
	
	
	//查询充值开户ID
	Integer SelectOpen(Integer id);
	
	
	//查询账户ID
	Integer SelectRechargeid(Integer open_id);
	
	
	//查询余额
	Short_recharge SelectRechar(Integer recharge_id);
	
	
	//修改余额
	Integer rechaCount(Short_recharge re);
}
