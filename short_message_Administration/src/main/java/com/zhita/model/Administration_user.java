package com.zhita.model;

import java.io.Serializable;

public class Administration_user implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer administration_id;
	
	private String administration_name;
	
	private String administration_password;

	public Integer getAdministration_id() {
		return administration_id;
	}

	public void setAdministration_id(Integer administration_id) {
		this.administration_id = administration_id;
	}

	public String getAdministration_password() {
		return administration_password;
	}

	public void setAdministration_password(String administration_password) {
		this.administration_password = administration_password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAdministration_name() {
		return administration_name;
	}

	public void setAdministration_name(String administration_name) {
		this.administration_name = administration_name;
	}
	

}
