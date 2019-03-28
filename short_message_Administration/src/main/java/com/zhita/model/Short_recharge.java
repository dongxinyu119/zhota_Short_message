package com.zhita.model;

import java.io.Serializable;

public class Short_recharge implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer recharge_id;   //短信充值表
	
	private Integer open_id;    //开户ID
		
	private Integer short_count;	//短信条数
	
	private String corporate_name;//公司名称
	
	private String customer_name;//客户名称
	
	private String username;//账号
	
	private Integer sum;//添加条数
	
	private String recharge_time;	//充值时间

	public Integer getRecharge_id() {
		return recharge_id;
	}

	public void setRecharge_id(Integer recharge_id) {
		this.recharge_id = recharge_id;
	}

	public Integer getOpen_id() {
		return open_id;
	}

	public void setOpen_id(Integer open_id) {
		this.open_id = open_id;
	}

	public Integer getShort_count() {
		return short_count;
	}

	public void setShort_count(Integer short_count) {
		this.short_count = short_count;
	}

	public String getRecharge_time() {
		return recharge_time;
	}

	public void setRecharge_time(String recharge_time) {
		this.recharge_time = recharge_time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCorporate_name() {
		return corporate_name;
	}

	public void setCorporate_name(String corporate_name) {
		this.corporate_name = corporate_name;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}
	

}
