package com.zhita.serviceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhita.dao.Administartonuserdao;
import com.zhita.model.Administration_user;
import com.zhita.service.Administrationuserservice;
import com.zhita.service.RedisBaiseTakes;

@Service
public class Administrationserviceimp implements Administrationuserservice{
	
	@Autowired
	private Administartonuserdao adao;
	
	@Autowired
	private RedisBaiseTakes<?, String, ?> redis;

	@Override
	public Map<String, Object> dengLAmidn(Administration_user auser) {
		Map<String, Object> maps=new HashMap<String, Object>();
		Integer a=adao.SelectUsers(auser.getAdministration_name());
		if(a==null){
			maps.put("msg", "账号不存在");
		}else{
			Integer c=adao.dengluAdminUser(auser.getAdministration_name(), auser.getAdministration_password());
			if(c==null){
				maps.put("msg", "账号或密码错误");
			}else{
				List<Administration_user> ids=new ArrayList<Administration_user>();
				Administration_user adim=new Administration_user();
				adim.setAdministration_id(c);
				adim.setAdministration_password(auser.getAdministration_password());
				adim.setAdministration_name(auser.getAdministration_name());
				ids.add(adim);
				redis.add("Administration_user", ids.toString());
				maps.put("msg", "登陆成功");
			}
		}
		return maps;
	}
	
	
}
