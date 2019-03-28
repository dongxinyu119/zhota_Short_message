package com.zhita.model;

import java.io.Serializable;
import java.util.Date;

//回复表
public class Short_reply implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer short_reply_id;
	
	private String short_task_id;//任务ID
	
	private Integer short_phone_number;//手机号码
	
	private Date short_reply_time;//回复时间
	
	private String short_autograph;//签名
	
	private String short_content;//短信内容
	
	private String short_reply_content;//回复内容
	
	private Integer short_message_id;//短信ID

	public Integer getShort_reply_id() {
		return short_reply_id;
	}

	public void setShort_reply_id(Integer short_reply_id) {
		this.short_reply_id = short_reply_id;
	}

	public String getShort_task_id() {
		return short_task_id;
	}

	public void setShort_task_id(String short_task_id) {
		this.short_task_id = short_task_id;
	}

	public Integer getShort_phone_number() {
		return short_phone_number;
	}

	public void setShort_phone_number(Integer short_phone_number) {
		this.short_phone_number = short_phone_number;
	}

	public Date getShort_reply_time() {
		return short_reply_time;
	}

	public void setShort_reply_time(Date short_reply_time) {
		this.short_reply_time = short_reply_time;
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

	public String getShort_reply_content() {
		return short_reply_content;
	}

	public void setShort_reply_content(String short_reply_content) {
		this.short_reply_content = short_reply_content;
	}

	public Integer getShort_message_id() {
		return short_message_id;
	}

	public void setShort_message_id(Integer short_message_id) {
		this.short_message_id = short_message_id;
	}
	
	
	
	
	
}
