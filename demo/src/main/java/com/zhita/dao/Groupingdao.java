package com.zhita.dao;

import java.util.List;

import com.zhita.model.Grouping;
import com.zhita.model.Pagegroup;

public interface Groupingdao {
	
	//查询带分页
	List<Grouping> SelectGrop(Pagegroup page);
	
	//批量删除
	Integer DeletAllGrou(String[] ids);
	
	//添加
	Integer InsertGrou(Grouping g);
	
	//删除单个
	Integer DeleteOne(Integer grouping_id);
	
	
	//查询消息总数
	Integer SelePageConut(Integer id);
	
	
	//查询分组名称
	Integer SelectGroupName(Grouping g);
	
	
	

}
