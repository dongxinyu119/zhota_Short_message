package com.zhita.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhita.model.Open_account;
import com.zhita.service.Openaccountservice;


@Controller
@RequestMapping("Openac")
public class OpenaccountController {
	
	@Autowired
	private Openaccountservice oser;
	
	
	
	@RequestMapping("OpenInsert")
	@ResponseBody
	public String OpenInsert(Open_account opena,MultipartFile file, ModelMap map) throws IOException{
		opena.setCorporate_name("酒店");
		opena.setCustomer_name("张三");
		opena.setPassword("465");
		opena.setUsername("zhangsan123");
		return oser.InserOpena(opena,file,map);
	}
	
	
	@RequestMapping("DeleteOpena")
	@ResponseBody
	public Integer DeleteOpena(Integer open_id){
		return oser.DeleteOpena(open_id);
	}
	
	@RequestMapping("UpdateOpena")
	@ResponseBody
	public Integer UpdateOpena(Open_account opena){
		return oser.UpdateOpena(opena);
	}
	
	@RequestMapping("SelecOpena")
	@ResponseBody
	public Map<String, Object> SelectOpena(Open_account open){
		return oser.SelectOpena(open);
	}
	
}
