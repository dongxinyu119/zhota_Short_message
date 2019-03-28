package com.zhita.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhita.model.Contacts;
import com.zhita.model.PageContacts;

public interface Contactsservice {
	
	/**
	 * 模糊查询
	 * @param contacts_name 联系人名称     phone_number 手机号   grouping_name 分组名称  page 页数  pagesize 每页个数
	 * @return Contacts
	 */
	Map<String, Object> MohuSelect(PageContacts con);
	
	
	
	/**
	 * 添加联系人
	 * @param contacts 联系人表
	 * @return Integer
	 */
	Integer inserCont(Contacts con);
	
	
	
	/**
	 * 批量删除联系人
	 * @param String[] 字符串数组
	 * @return Integer
	 */
	Integer deleteAll(String[] ids);
	
	
	
	/**
	 * 导入联系人
	 * @param grouping_name  request
	 * @return Integer
	 */
	String ajaxUploadExcel(Integer id,HttpServletRequest request,HttpServletResponse response,String grouping_name) throws Exception;

	
	/**
	 * 修改分组
	 * @param contacts_id,grouping_name
	 * @return String
	 */
	Integer UpdateGrouping(Contacts c);
}
