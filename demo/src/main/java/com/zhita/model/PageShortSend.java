package com.zhita.model;

import java.io.Serializable;

public class PageShortSend implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String short_type;//状态
	
	private String statu_time;//开始时间
	
	private String end_time;//结束时间
	
	private String short_phone_number;//手机号
	
	private String short_task_id; //任务ID
	
	private Integer id;
	
	private int page=1;      //当前页

	private int pagesize;     //每页显示的数量

	private int totalCount;     //总记录数

	public String getStatu_time() {
		return statu_time;
	}

	public void setStatu_time(String statu_time) {
		this.statu_time = statu_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	

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

	public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    
    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getShort_type() {
		return short_type;
	}

	public void setShort_type(String short_type) {
		this.short_type = short_type;
	}

	public String getShort_phone_number() {
		return short_phone_number;
	}

	public void setShort_phone_number(String short_phone_number) {
		this.short_phone_number = short_phone_number;
	}

	public String getShort_task_id() {
		return short_task_id;
	}

	public void setShort_task_id(String short_task_id) {
		this.short_task_id = short_task_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
    
	
}
