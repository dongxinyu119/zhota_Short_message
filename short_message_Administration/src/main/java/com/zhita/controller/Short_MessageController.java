package com.zhita.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhita.model.Ismg;
import com.zhita.model.PageShort;
import com.zhita.model.Short_message;
import com.zhita.model.Short_send;
import com.zhita.service.Short_messageservice;


@Controller
@RequestMapping("short_messageAut")
public class Short_MessageController {

	@Autowired
	private Short_messageservice servi;
	
	
	@RequestMapping("ShenH")
	@ResponseBody
	public Map<String, Object> ShortShenh(PageShort page){
		return servi.SeleShenh(page);
	}
	
	
	
	@RequestMapping("UpdateType")
	@ResponseBody
	public Integer UpdateShort_type(String short_task_id){
		return servi.UpdateShotype(short_task_id);
	}
	
	
	@RequestMapping("SendType")
	@ResponseBody
	public Map<String, Object> SelectType(PageShort page){
		return servi.SelectSendType(page);
	}
	
	
	@RequestMapping("Short_send")
	@ResponseBody
	public Integer Send(Integer short_message_id,Integer ismg_id){
		return servi.Update_send(short_message_id,ismg_id);
	}
	
	
	@RequestMapping("SelectIsmg")
	@ResponseBody
	public List<Ismg> SeleIsmg(){
		List<Ismg> ism=servi.SeleIsmg();
		return ism;
	}
	
	
	
	
	
}
