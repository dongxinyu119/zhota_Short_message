package com.zhita.model;

import java.io.Serializable;


//分页
public class PageContacts implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String 	contacts_name;//联系人名称
	
	private String phone_number;//联系电话
	
	private Integer grouping_id;//分组名称
	
	private int page=1;
	
	private int id;//用户ID
	
	private int pagesize=10;//每页数据个数

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public String getContacts_name() {
		return contacts_name;
	}

	public void setContacts_name(String contacts_name) {
		this.contacts_name = contacts_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getGrouping_id() {
		return grouping_id;
	}

	public void setGrouping_id(Integer grouping_id) {
		this.grouping_id = grouping_id;
	}
	
	
	
}
