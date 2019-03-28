package com.zhita.model;

import java.io.Serializable;
import java.util.List;


//短信管理表
public class Short_message implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer short_message_id;
	
	private String short_task_id;
	
	private Integer ismg_id;
	
	private String product;
	
	private String short_content;
	
	private String short_count;
	
	private Integer short_number_count;
	
	private Integer short_winding_number;
	
	private String short_time;
	
	private String send_time;//发送时间
	
	private Integer id;
	
	private String short_autograph;
	
	private String short_send_type;
	
	private String short_type;
	
	private String numbers;
	
	private List<Ismg> imss;

	private int a;
	
	private int b;
	
	private int c;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	

	public Integer getShort_message_id() {
		return short_message_id;
	}

	public void setShort_message_id(Integer short_message_id) {
		this.short_message_id = short_message_id;
	}

	public String getShort_task_id() {
		return short_task_id;
	}

	public void setShort_task_id(String short_task_id) {
		this.short_task_id = short_task_id;
	}

	public Integer getIsmg_id() {
		return ismg_id;
	}

	public void setIsmg_id(Integer ismg_id) {
		this.ismg_id = ismg_id;
	}

	public String getShort_content() {
		return short_content;
	}

	public void setShort_content(String short_content) {
		this.short_content = short_content;
	}

	public String getShort_count() {
		return short_count;
	}

	public void setShort_count(String short_count) {
		this.short_count = short_count;
	}

	public Integer getShort_number_count() {
		return short_number_count;
	}

	public void setShort_number_count(Integer short_number_count) {
		this.short_number_count = short_number_count;
	}

	public Integer getShort_winding_number() {
		return short_winding_number;
	}

	public void setShort_winding_number(Integer short_winding_number) {
		this.short_winding_number = short_winding_number;
	}

	public String getShort_time() {
		return short_time;
	}

	public void setShort_time(String short_time) {
		this.short_time = short_time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShort_autograph() {
		return short_autograph;
	}

	public void setShort_autograph(String short_autograph) {
		this.short_autograph = short_autograph;
	}

	public String getShort_send_type() {
		return short_send_type;
	}

	public void setShort_send_type(String short_send_type) {
		this.short_send_type = short_send_type;
	}

	public String getShort_type() {
		return short_type;
	}

	public void setShort_type(String short_type) {
		this.short_type = short_type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public List<Ismg> getImss() {
		return imss;
	}

	public void setImss(List<Ismg> imss) {
		this.imss = imss;
	}
	
	
	
	
	
	
}
