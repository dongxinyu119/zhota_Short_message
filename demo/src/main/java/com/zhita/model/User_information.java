package com.zhita.model;

import java.io.Serializable;

//用户信息表
public class User_information implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;//用户名
	
	private String corporate_name;//公司名称
	
	private String names;//真实姓名
	
	private Integer contact_number;//联系电话
	
	private Integer QQ;
	
	private String wechat_number;//微信号

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCorporate_name() {
		return corporate_name;
	}

	public void setCorporate_name(String corporate_name) {
		this.corporate_name = corporate_name;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public Integer getContact_number() {
		return contact_number;
	}

	public void setContact_number(Integer contact_number) {
		this.contact_number = contact_number;
	}

	public Integer getQQ() {
		return QQ;
	}

	public void setQQ(Integer qQ) {
		QQ = qQ;
	}

	public String getWechat_number() {
		return wechat_number;
	}

	public void setWechat_number(String wechat_number) {
		this.wechat_number = wechat_number;
	}
	
	
}
