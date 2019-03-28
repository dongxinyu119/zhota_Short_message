package com.zhita.model;

import java.io.Serializable;

public class Financial_statement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer financial_statement_id;//流水统计表
	
	private String product;//短信网关ID
	
	private String flow_type;//流水类型ID
	
	private Integer flow_count;//流水条数
	
	private String operator;//操作人
	
	private String operator_time;//操作时间
	
	private Integer id;//用户ID

	public Integer getFinancial_statement_id() {
		return financial_statement_id;
	}

	public void setFinancial_statement_id(Integer financial_statement_id) {
		this.financial_statement_id = financial_statement_id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFlow_type() {
		return flow_type;
	}

	public void setFlow_type(String flow_type) {
		this.flow_type = flow_type;
	}

	public Integer getFlow_count() {
		return flow_count;
	}

	public void setFlow_count(Integer flow_count) {
		this.flow_count = flow_count;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperator_time() {
		return operator_time;
	}

	public void setOperator_time(String operator_time) {
		this.operator_time = operator_time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	
}
