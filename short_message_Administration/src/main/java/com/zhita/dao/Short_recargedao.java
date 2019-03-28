package com.zhita.dao;

import java.util.List;

import com.zhita.model.Pagerecarge;
import com.zhita.model.Short_recharge;
import com.zhita.model.Shortrecord;

public interface Short_recargedao {
	
	
	//模糊查询+分页
	List<Short_recharge> SelectMoHurecarge(Pagerecarge pa);
	
	
	//查询总条数
	Integer SelectCount();
	
	
	//添加
	Integer Insertrecharge(Short_recharge re);
	
	
	//添加充值记录
	Integer InsertShort_recharge_record(Shortrecord record);
	
	
	//充值
	Integer UpdateShort_recharge(Short_recharge rech);
	
	
	//查询充值记录
	List<Shortrecord> SelectRecord(Integer recharge_id);
}
