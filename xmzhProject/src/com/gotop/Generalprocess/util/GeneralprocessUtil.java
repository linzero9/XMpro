package com.gotop.Generalprocess.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.derby.tools.sysinfo;

import com.gotop.Generalprocess.annonation.GeneralprocessField;
import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;

/**
 * 
 * @author wujiajun
 * @desc 流程通用模板的工具类
 */
public class GeneralprocessUtil<T> {

	/**
	 * @throws ClassNotFoundException
	 * @desc 用于使用类名 ，获取到对象的 基本信息（anno）
	 */

	public List<GeneralprocessFieldBean> getBaseInfoByClassName(String classname)
			throws ClassNotFoundException {

		List<GeneralprocessFieldBean> returnBase = new ArrayList<GeneralprocessFieldBean>();

		Class<?> classc = Class.forName(classname);

		Field[] fs = classc.getDeclaredFields();

		for (Field field : fs) {
		
				if(field.isAnnotationPresent(GeneralprocessField.class)){
					
			
				
				String   fieldName= field.getName();//字段的名称，用于和字段的值匹配？

				GeneralprocessField annotone = field
						.getAnnotation(GeneralprocessField.class);

				GeneralprocessFieldBean bean = new GeneralprocessFieldBean();
				
				
				if(annotone==null){
					bean.setFieldName(fieldName);
				}else{
					bean.setDescription(annotone.description());
					bean.setHandle(annotone.handle());
					bean.setHidden(annotone.hidden());
					bean.setName(annotone.name());
					bean.setType(annotone.type());
					bean.setUrl(annotone.url());
					bean.setFieldName(fieldName);
			
				}
				
			
				returnBase.add(bean);
				}

		}
		
		return returnBase;

	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		GeneralprocessUtil  iii = new GeneralprocessUtil();
		List<GeneralprocessFieldBean>   lists= iii.getBaseInfoByClassName("com.gotop.Generalprocess.model.ProcessModelOne");
		
		for (GeneralprocessFieldBean generalprocessFieldBean : lists) {
		
			
			System.out.println(	generalprocessFieldBean.getName());
			System.out.println(generalprocessFieldBean.getType());
			System.out.println(generalprocessFieldBean.getHandle());
			System.out.println(generalprocessFieldBean.getFieldName());
			System.out.println(generalprocessFieldBean.isHidden());
			
		}
		
		
				
		
		
	}

}
