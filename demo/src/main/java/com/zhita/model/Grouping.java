package com.zhita.model;

import java.io.Serializable;

//分组表
public class Grouping implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer grouping_id;//分组ID
	
	private String grouping_name;//分组名称
	
	private String grouping_date;//创建时间
	
	private Integer id;//用户ID

	public Integer getGrouping_id() {
		return grouping_id;
	}

	public void setGrouping_id(Integer grouping_id) {
		this.grouping_id = grouping_id;
	}

	public String getGrouping_name() {
		return grouping_name;
	}

	public void setGrouping_name(String grouping_name) {
		this.grouping_name = grouping_name;
	}

	public String getGrouping_date() {
		return grouping_date;
	}

	public void setGrouping_date(String grouping_date) {
		this.grouping_date = grouping_date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
