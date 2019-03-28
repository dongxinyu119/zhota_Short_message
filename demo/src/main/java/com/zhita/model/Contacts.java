package com.zhita.model;

import java.io.Serializable;

//联系人表
public class Contacts implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer contacts_id;//联系人ID
	
	private String 	contacts_name;//联系人名称
	
	private String phone_number;//联系电话
	
	private String grouping_name;//分组名称
	
	private String contacts_remarks;//备注
	
	private Integer grouping_id;//分组ID
	
	private int id;//用户ID
	

	public Integer getContacts_id() {
		return contacts_id;
	}

	public void setContacts_id(Integer contacts_id) {
		this.contacts_id = contacts_id;
	}

	public String getContacts_name() {
		return contacts_name;
	}

	public void setContacts_name(String contacts_name) {
		this.contacts_name = contacts_name;
	}

	public String getGrouping_name() {
		return grouping_name;
	}

	public void setGrouping_name(String grouping_name) {
		this.grouping_name = grouping_name;
	}

	public String getContacts_remarks() {
		return contacts_remarks;
	}

	public void setContacts_remarks(String contacts_remarks) {
		this.contacts_remarks = contacts_remarks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Integer getGrouping_id() {
		return grouping_id;
	}

	public void setGrouping_id(Integer grouping_id) {
		this.grouping_id = grouping_id;
	}
	
	

}
