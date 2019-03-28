package com.zhita.service;

import java.util.List;
import java.util.Map;

import com.zhita.model.Pagerecarge;
import com.zhita.model.Short_recharge;
import com.zhita.model.Shortrecord;

public interface Short_recargeservice {
	
	//查询客户充值信息
	Map<String, Object> SelectShort_recarge(Pagerecarge page);
	
	
	//充值
	Integer UpdateShortRecha(Short_recharge rea);
	
	
	//查询充值记录
	List<Shortrecord> SelectShortrecord(Integer recharge_id);
	
	

	


}
