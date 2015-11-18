package com.gotop.Generalprocess.util;

import java.util.ArrayList;
import java.util.List;

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
		
		
	
		
		
		

		
		GeneralprocessUtil.fixBean(lists, ProcessModelOne.class, beforbean);
	}

}
