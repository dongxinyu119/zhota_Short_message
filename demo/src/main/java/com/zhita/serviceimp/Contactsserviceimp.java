package com.zhita.serviceimp;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zhita.ExcelTools.ExcelUtil;
import com.zhita.dao.Contactsdao;
import com.zhita.model.Contacts;
import com.zhita.model.PageContacts;
import com.zhita.model.PageUtil;
import com.zhita.service.Contactsservice;


@Service
public class Contactsserviceimp implements Contactsservice{
	
	@Autowired
	private Contactsdao cdao;

	@Override
	public Integer inserCont(Contacts con) {
		return cdao.InsertCon(con);
	}

	@Override
	public Integer deleteAll(String[] ids) {
		return cdao.DeletAllCon(ids);
	}

	@Override
	public Map<String, Object> MohuSelect(PageContacts con) {
		
		int totalCount=cdao.SelePageConut();
		int a=con.getPage();
		PageUtil pageUtil=new PageUtil(con.getPage(), totalCount);
		con.setPagesize(pageUtil.getPageSize());
		con.setPage(pageUtil.getPage());
		List<Contacts> finas=cdao.MohuSelect(con);
		Map<String, Object> maps=new HashMap<String, Object>();
		pageUtil.setPage(a);
		maps.put("Contacts", finas);
		maps.put("PageUtil", pageUtil);
		return maps;
	}

	@Override
	public String ajaxUploadExcel(Integer id, HttpServletRequest request,
			HttpServletResponse response, String grouping_name)
			throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;    
        MultipartFile file = multipartRequest.getFile("upfile");  
        if(file.isEmpty()){  
            try {
				throw new Exception("文件不存在！");
			} catch (Exception e) {
				e.printStackTrace();
			}  
        }  
          
        InputStream in =null;  
        try {
			in = file.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}  
        
		List<List<Object>> listob = null; 
		try {
			listob = new ExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
		}   
		
	    //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出  
        for (int i = 0; i < listob.size(); i++) {  
            List<Object> lo = listob.get(i);  
            Contacts vo = new Contacts(); 
           
	            vo.setContacts_name(String.valueOf(lo.get(0)));     // 表格的第一列   注意数据格式需要对应实体类属性
	            vo.setPhone_number(String.valueOf(lo.get(1)));   // 表格的第二列
	            vo.setContacts_remarks(String.valueOf(lo.get(2)));
	            vo.setId(id);
	            vo.setGrouping_name(grouping_name);
	            cdao.InsertCon(vo);
        }
        System.out.println("文件导入成功！");
        return "文件导入成功！";
	}

	@Override
	public Integer UpdateGrouping(Contacts c) {
		return cdao.GroupingName(c);
	}

	



}
