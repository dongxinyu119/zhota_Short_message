package com.zhita.serviceImp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.bcloud.msg.http.HttpSender;
import com.zhita.dao.Short_messagedao;
import com.zhita.model.Financial_statement;
import com.zhita.model.PageShort;
import com.zhita.model.PageUtil;
import com.zhita.model.Short_message;
import com.zhita.model.Short_recharge;
import com.zhita.model.Short_send;
import com.zhita.model.Short_send_out;
import com.zhita.model.Ismg;
import com.zhita.service.Short_messageservice;


@Service
public class Short_messageserviceimp implements Short_messageservice{

	
	@Autowired
	private Short_messagedao sdao;

	@Override
	public Map<String, Object> SeleShenh(PageShort page) {
		int a=page.getPage();
		int totalCount=sdao.SelectCount();	
		PageUtil pa=new PageUtil(page.getPage(), totalCount);
		page.setPage(pa.getPage());
		page.setPagesize(pa.getPageSize());
		List<Short_message> shors=sdao.SelectPage(page);
		List<Ismg> ismgs=sdao.SelectIsm();
		for(int i=0;i<shors.size();i++){
			shors.get(i).setImss(ismgs);
		}
		Map<String, Object> maps=new HashMap<String, Object>();
		pa.setPage(a);
		maps.put("Short_message", shors);
		maps.put("PageUtil", pa);
		return maps;
	}


	@Override
	public Integer UpdateShotype(String short_task_id) {
		return sdao.UpdateShotype(short_task_id);
	}


	@Override
	public Map<String, Object> SelectSendType(PageShort page) {
		int a=page.getPage();
		int totalCount=sdao.SelectCount();	
		PageUtil pa=new PageUtil(page.getPage(), totalCount);
		page.setPage(pa.getPage());
		page.setPagesize(pa.getPageSize());
		List<Short_message> shors=sdao.ShortMessageOk(page);
		Map<String, Object> maps=new HashMap<String, Object>();
		pa.setPage(a);
		maps.put("Short_message", shors);
		maps.put("PageUtil", pa);
		return maps;
	}


	@Override
	public Short_send ShortSend(Short_message sh) {
			Short_send s=new Short_send();
			String numbers=sh.getNumbers();
			String uri = "http://47.111.84.110/msg/HttpBatchSendSM";//应用地址
			String account = "sxxcjr0006";//账号
			String pswd = "123@.com";//密码
			String mobiles = numbers;//手机号码，多个号码使用","分割
			String content = sh.getShort_content();//短信内容
			boolean needstatus = true;//是否需要状态报告，需要true，不需要false
			String product = sh.getProduct();//产品ID
			String extno = "451";//扩展码
			String respType = "json";//返回json格式响应
			try {
				String returnString = HttpSender.send(uri, account, pswd, mobiles, content, needstatus, product, extno, respType);
				System.out.println(returnString);
				s=JSON.parseObject(returnString, Short_send.class);
				String[] numss=numbers.split(",");
				s.setShortsize(numss.length);
				Ismg i=sdao.OneIsmg(sh.getIsmg_id());
				i.setNum(i.getNum()-numss.length);
				i.setIsmg_id(sh.getIsmg_id());
				sdao.UpdateCount(i);//减去通道余额
				Integer openid=sdao.SelectOpen(sh.getId());
				Integer raid=sdao.SelectRechargeid(openid);
				if(raid == null){
					Short_send sa=new Short_send();
					sa.setMsgid("余额不足");
					return sa;
				}
				
				Short_recharge r=sdao.SelectRechar(raid);
				r.setShort_count(r.getShort_count()-numss.length);
				sdao.rechaCount(r);
			} catch (Exception e) {
				//TODO 处理异常
				e.printStackTrace();
			}
			return s;
	}


	@Override
	public Integer Update_send(Integer messageid,Integer ismg_id) {
		Short_message sh=sdao.SelectShortMessage(messageid);
		if(sh==null){
			return 500;
		}
		sh.setIsmg_id(ismg_id);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println("数据::"+sh.getNumbers());
		String numl[]=sh.getNumbers().split(",");
		for(int i=0;i<numl.length;i++){
		Short_send shore=ShortSend(sh);
		if(shore.getMsgid().equals("余额不足")){
			return 404;
		}
		Short_send_out shenout=new Short_send_out();
		shenout.setShort_receipt_time(df.format(new Date()));//回执时间
		shenout.setShort_autograph(sh.getShort_autograph());//签名
		shenout.setShort_content(sh.getShort_content());//实发条数
		shenout.setShort_message_id(sh.getShort_message_id());//短信ID
		shenout.setShort_task_id(sh.getShort_task_id());//任务ID
		shenout.setShort_time(sh.getShort_time());//发送时间
		shenout.setShort_type(sh.getShort_type());//发送状态
		sh.setSend_time(df.format(new Date()));
		if(shore.getResult()==0){
			sh.setShort_type("发送成功");
			shenout.setShort_type(sh.getShort_type());
		}else if(shore.getResult()<=120 && shore.getResult()>100){
			sh.setShort_type("发送失败");
			shenout.setShort_type(sh.getShort_type());
		}else{
			sh.setShort_type("未知");
			shenout.setShort_type(sh.getShort_type());
		}
			shenout.setShort_phone_number(numl[i]);
			sdao.InsertIntoShort(shenout);
		}
			Financial_statement fin=new Financial_statement();
			Ismg i=sdao.OneIsmg(sh.getIsmg_id());
			fin.setFlow_count(numl.length);
			fin.setFlow_type("消费");
			fin.setId(sh.getId());
			fin.setOperator("系统自动");
			fin.setOperator_time(df.format(new Date()));
			fin.setProduct(i.getProduct());
			sdao.InsertIntoFina(fin);
			return sdao.Shortsend(sh);
	}


	@Override
	public List<Ismg> SeleIsmg() {
		return sdao.SelectIsm();
	}



	
	
	
	
	
	
	
	
	




	
	
	
	
	

	
	
	
	
	
	
	
	
}
