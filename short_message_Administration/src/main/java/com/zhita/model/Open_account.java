package com.zhita.model;

import java.io.Serializable;

public class Open_account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer open_id;
	
	private String corporate_name;//公司名称
	
	private String customer_name;//客户名称
	
	private String username;//账号
	
	private String password;//密码
	
	private String business_license;//营业执照
	
	private Integer page=1;
	
	private Integer pagesize=10;

	public Integer getOpen_id() {
		return open_id;
	}

	public void setOpen_id(Integer open_id) {
		this.open_id = open_id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBusiness_license() {
		return business_license;
	}

	public void setBusiness_license(String business_license) {
		this.business_license = business_license;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	
	

}
