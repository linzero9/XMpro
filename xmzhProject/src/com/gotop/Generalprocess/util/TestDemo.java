package com.gotop.Generalprocess.util;

import java.util.ArrayList;

/**
 * @author wujiajun
 * @desc  test
 */
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;



import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.model.ProcessModelOne;

public class TestDemo {
	
	@Test
	public  void   test1() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException{
		
		
		java.util.List<ProcessModelOne> lists = new ArrayList<ProcessModelOne>();
		
		
		ProcessModelOne  bean  = new  ProcessModelOne();
		//bean.setProcessModelOneID(11);
		
		
		ProcessModelOne  bean1 = new  ProcessModelOne();
		//bean1.setProcessModelOneID(3333);
		
		lists.add(bean);
		lists.add(bean1);
		
		
	
		
	
		
		
		Map<String, List<GeneralprocessFieldBean>>    befores=GeneralprocessUtil.fixBean(lists, ProcessModelOne.class, "com.gotop.Generalprocess.model.ProcessModelOne");
		
		

		
	for (String key : befores.keySet()) {
		
		List<GeneralprocessFieldBean>   lists1=befores.get(key);
		
		for (GeneralprocessFieldBean generalprocessFieldBean : lists1) {
			System.out.println(generalprocessFieldBean.getFieldName());
			System.out.println(generalprocessFieldBean.getValue());
		}
		
		
	}
	
	

	
	  
	JSONObject json = JSONObject.fromObject(befores);
	System.out.println(json);
	
		
		
	}
	
	@Test
	public  void  testJson(){
		
		
		GeneralprocessFieldBean  bean1= new GeneralprocessFieldBean();
		bean1.setName("wujiajun1");
		
		GeneralprocessFieldBean  bean2= new GeneralprocessFieldBean();
		bean2.setName("wujiajun2");
		
		GeneralprocessFieldBean  bean3= new GeneralprocessFieldBean();
		bean3.setName("wujiajun3");
		
		
		List<GeneralprocessFieldBean>  lists= new ArrayList<GeneralprocessFieldBean>();
		
		lists.add(bean1);
		lists.add(bean2);
		lists.add(bean3);
		
		
		JSONArray  json =  JSONArray.fromObject(lists);
		
		  
		  System.out.println(json.toString());
		
		
		
	}

}
