package com.zhita.model;

import java.io.Serializable;

public class Pagefinancial implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String flow_type;//流水类型
	
	private String statu_time;//开始时间
	
	private String end_time;//结束时间
	
	private Integer id;
	
	private int page=1;      //当前页

	private int pagesize;     //每页显示的数量

	private int totalCount;     //总记录数

	public String getFlow_type() {
		return flow_type;
	}

	public void setFlow_type(String flow_type) {
		this.flow_type = flow_type;
	}

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
