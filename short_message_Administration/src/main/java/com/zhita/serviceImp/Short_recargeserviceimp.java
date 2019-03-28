package com.zhita.serviceImp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhita.dao.Short_recargedao;
import com.zhita.model.PageUtil;
import com.zhita.model.Pagerecarge;
import com.zhita.model.Short_recharge;
import com.zhita.model.Shortrecord;
import com.zhita.service.Short_recargeservice;

@Service
public class Short_recargeserviceimp implements Short_recargeservice{
	
	@Autowired
	private Short_recargedao redao;

	@Override
	public Map<String, Object> SelectShort_recarge(Pagerecarge page) {
		Integer totalCount=redao.SelectCount();
		int a=page.getPage();
		PageUtil pa=new PageUtil(page.getPage(),totalCount);
		page.setPage(pa.getPage());
		List<Short_recharge> rechs=redao.SelectMoHurecarge(page);
		pa.setPage(a);
		Map<String, Object> maps=new HashMap<String, Object>();
		maps.put("Short_recharge", rechs);
		maps.put("PageUtil", pa);
		return maps;
	}

	@Override
	@Transactional
	public Integer UpdateShortRecha(Short_recharge rea) {
		Shortrecord record=new Shortrecord();
		if(rea.getShort_count()!=null){
		if(rea.getSum() != null){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		rea.setRecharge_time(df.format(new Date()));
		Integer a = rea.getShort_count()+rea.getSum();
		rea.setShort_count(a);
		record.setRecharge_id(rea.getRecharge_id());
		record.setRecharge_short_time(rea.getRecharge_time());
		redao.InsertShort_recharge_record(record);
		redao.UpdateShort_recharge(rea);
		return 200;
		}
		}
		return 0;
	}

	@Override
	public List<Shortrecord> SelectShortrecord(Integer recharge_id) {
		// TODO Auto-generated method stub
		return redao.SelectRecord(recharge_id);
	}

	
	
	
	

}
