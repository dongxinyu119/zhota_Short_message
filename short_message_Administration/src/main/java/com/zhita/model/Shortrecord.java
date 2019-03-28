package com.zhita.model;

import java.io.Serializable;

public class Shortrecord implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer recharge_record_id;		//充值记录表
	
	private Integer recharge_short_count;	//充值条数
	
	private String recharge_short_time;		//充值时间
	
	private Integer recharge_id;				//公司ID
	
	public Integer getRecharge_record_id() {
		return recharge_record_id;
	}

	public void setRecharge_record_id(Integer recharge_record_id) {
		this.recharge_record_id = recharge_record_id;
	}

	public Integer getRecharge_short_count() {
		return recharge_short_count;
	}

	public void setRecharge_short_count(Integer recharge_short_count) {
		this.recharge_short_count = recharge_short_count;
	}

	public String getRecharge_short_time() {
		return recharge_short_time;
	}

	public void setRecharge_short_time(String recharge_short_time) {
		this.recharge_short_time = recharge_short_time;
	}

	public Integer getRecharge_id() {
		return recharge_id;
	}

	public void setRecharge_id(Integer recharge_id) {
		this.recharge_id = recharge_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
