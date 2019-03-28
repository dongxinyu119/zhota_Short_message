package com.zhita.model;

import java.io.Serializable;

public class Ismg implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer ismg_id;

	private String product;
	
	private Integer num;

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getIsmg_id() {
		return ismg_id;
	}

	public void setIsmg_id(Integer ismg_id) {
		this.ismg_id = ismg_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
