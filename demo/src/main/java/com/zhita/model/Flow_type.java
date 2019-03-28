package com.zhita.model;

import java.io.Serializable;

public class Flow_type implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer flow_type_id;
	
	private String flow_type_name;//流水状态

	public Integer getFlow_type_id() {
		return flow_type_id;
	}

	public void setFlow_type_id(Integer flow_type_id) {
		this.flow_type_id = flow_type_id;
	}

	public String getFlow_type_name() {
		return flow_type_name;
	}

	public void setFlow_type_name(String flow_type_name) {
		this.flow_type_name = flow_type_name;
	}
	
	
	
	
}
