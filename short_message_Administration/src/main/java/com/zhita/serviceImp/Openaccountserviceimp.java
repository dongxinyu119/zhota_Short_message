package com.zhita.serviceImp;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.zhita.dao.Openaccountdao;
import com.zhita.dao.Short_recargedao;
import com.zhita.model.Open_account;
import com.zhita.model.PageUtil;
import com.zhita.model.Short_recharge;
import com.zhita.model.User;
import com.zhita.service.Openaccountservice;

@Service
public class Openaccountserviceimp implements Openaccountservice{
	
	@Autowired
	private Openaccountdao odao;
	
	@Autowired
	private Short_recargedao rdao;

	@Override
	@Transactional
	public String InserOpena(Open_account opena,MultipartFile file, ModelMap map) throws  IOException {
		User u=new User();
		Integer c=odao.Selectcorporate_name(opena.getCorporate_name());//根据公司名查询
		Integer d=odao.SelectUserName(opena.getUsername());//根据账号名查询
		if(c!=null ){
			return "0";//公司名称已存在
		}else if(d!=null){
			return "100";//账号已存在
			
		}	
		 String filePath = "E:\\upload";//保存图片的路径
	        String originalFilename = file.getOriginalFilename();
	        String newFileName = UUID.randomUUID()+originalFilename;
	        File targetFile = new File(filePath,newFileName); 
	        file.transferTo(targetFile);
	        opena.setBusiness_license(newFileName);
	        odao.InsertOpenacc(opena); //添加开户信息
			Short_recharge re=new Short_recharge();
			u.setPassword(opena.getPassword());
			u.setUsername(opena.getUsername());
			u.setOpenid(odao.SelectUserName(opena.getUsername()));
			re.setCorporate_name(opena.getCorporate_name());
			re.setCustomer_name(opena.getCustomer_name());
			re.setUsername(opena.getUsername());
			re.setOpen_id(odao.SelectUserName(opena.getUsername()));
			re.setShort_count(0);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			re.setRecharge_time(df.format(new Date()));
			odao.AddUser(u);
			rdao.Insertrecharge(re);
			return "200";
			
		
			
	}

	@Override
	public Integer UpdateOpena(Open_account opena) {
		return odao.UpdateOpenacc(opena);
	}

	@Override
	public Integer DeleteOpena(Integer open_id) {
		return odao.DeleteOpenaId(open_id);
	}

	@Override
	public Map<String, Object> SelectOpena(Open_account open) {
		int totalCount=odao.SelectCount();
		int a=open.getPage();
		PageUtil page=new PageUtil(open.getPage(), totalCount);
		open.setPage(page.getPage());
		List<Open_account> ops=odao.AllOpena(open);
		Map<String, Object> maps=new HashMap<String, Object>();
		page.setPage(a);
		maps.put("Open_account", ops);
		maps.put("PageUtil", page);
		return maps;
	}
	
	
	
}
