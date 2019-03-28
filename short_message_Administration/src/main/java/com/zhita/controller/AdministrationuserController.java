package com.zhita.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhita.model.Administration_user;
import com.zhita.service.Administrationuserservice;


@Controller
@RequestMapping("Admin")
public class AdministrationuserController {

	@Autowired
	private Administrationuserservice aser;
	
	
	@RequestMapping("Dengl")
	@ResponseBody
	public Map<String, Object> Log(Administration_user a){
		a.setAdministration_name("wang1");
		a.setAdministration_password("123456");
		return aser.dengLAmidn(a);
	}
}
