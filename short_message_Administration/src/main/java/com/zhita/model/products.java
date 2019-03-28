package com.zhita.model;

import java.io.Serializable;
import java.util.List;

public class products implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer result;
	
	private String ts;//网关扩展号
	
	private List<Ismg> products;//网关名称

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public List<Ismg> getProducts() {
		return products;
	}

	public void setProducts(List<Ismg> products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
