package com.zhita.model;

import java.io.Serializable;

public class PageShort implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String short_type;		//状态
	
	private String statusTime;		//开始时间
	
	private String endTime;    //结束时间
	
	private Integer id;
	
	private int page=1;      //当前页

    private int pagesize;     //每页显示的数量

    private int totalCount;     //总记录数

    private int totalPageCount;      //总页数

	public String getShort_type() {
		return short_type;
	}

	public void setShort_type(String short_type) {
		this.short_type = short_type;
	}

	public String getStatusTime() {
		return statusTime;
	}

	public void setStatusTime(String statusTime) {
		this.statusTime = statusTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
   
    
}
