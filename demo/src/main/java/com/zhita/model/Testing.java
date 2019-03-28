package com.zhita.model;

import java.io.Serializable;


//屏蔽词
public class Testing implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer testing_id;
	
	private String testing_context;

	public Integer getTesting_id() {
		return testing_id;
	}

	public void setTesting_id(Integer testing_id) {
		this.testing_id = testing_id;
	}

	public String getTesting_context() {
		return testing_context;
	}

	public void setTesting_context(String testing_context) {
		this.testing_context = testing_context;
	}
	
	
}
