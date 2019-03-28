package com.zhita.model;

import java.io.Serializable;
import java.util.Date;

//报告表

public class Short_send_out implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer short_send_out_id;
	
	private String short_task_id;//任务ID
	
	private String short_phone_number;//手机号码
	
	private String short_time;//发送时间
	
	private String short_autograph;//签名
	
	private String short_content;//电信内容
	
	private String short_type;//状态
	
	private String short_result;//发送结果
	
	private String short_return;//返回值
	
	private Date short_receipt_time;//回执时间
	
	private Integer short_message_id;//短信ID

	public Integer getShort_send_out_id() {
		return short_send_out_id;
	}

	public void setShort_send_out_id(Integer short_send_out_id) {
		this.short_send_out_id = short_send_out_id;
	}

	public String getShort_task_id() {
		return short_task_id;
	}

	public void setShort_task_id(String short_task_id) {
		this.short_task_id = short_task_id;
	}

	public String getShort_autograph() {
		return short_autograph;
	}

	public void setShort_autograph(String short_autograph) {
		this.short_autograph = short_autograph;
	}

	public String getShort_content() {
		return short_content;
	}

	public void setShort_content(String short_content) {
		this.short_content = short_content;
	}

	public String getShort_result() {
		return short_result;
	}

	public void setShort_result(String short_result) {
		this.short_result = short_result;
	}

	public String getShort_return() {
		return short_return;
	}

	public void setShort_return(String short_return) {
		this.short_return = short_return;
	}

	public Date getShort_receipt_time() {
		return short_receipt_time;
	}

	public void setShort_receipt_time(Date short_receipt_time) {
		this.short_receipt_time = short_receipt_time;
	}

	public Integer getShort_message_id() {
		return short_message_id;
	}

	public void setShort_message_id(Integer short_message_id) {
		this.short_message_id = short_message_id;
	}

	public String getShort_phone_number() {
		return short_phone_number;
	}

	public void setShort_phone_number(String short_phone_number) {
		this.short_phone_number = short_phone_number;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getShort_type() {
		return short_type;
	}

	public void setShort_type(String short_type) {
		this.short_type = short_type;
	}

	public String getShort_time() {
		return short_time;
	}

	public void setShort_time(String short_time) {
		this.short_time = short_time;
	}
	
	

}
