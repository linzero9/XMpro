package com.gotop.Generalprocess.util;

import java.util.ArrayList;
import java.util.List;

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
		bean.setProcessModelOneID(11);
		
		lists.add(bean);
		
		
	
		
		List<GeneralprocessFieldBean>  beforbean= GeneralprocessUtil.getBaseInfoByClassName("com.gotop.Generalprocess.model.ProcessModelOne");
		
		
		
		List<GeneralprocessFieldBean>  befores=GeneralprocessUtil.fixBean(lists, ProcessModelOne.class, beforbean);
		
		
		for (GeneralprocessFieldBean generalprocessFieldBean : befores) {
			
			
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println(	generalprocessFieldBean.getFieldName());
			
			System.out.println(		generalprocessFieldBean.getValue());
		
	
		}
		
		
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
