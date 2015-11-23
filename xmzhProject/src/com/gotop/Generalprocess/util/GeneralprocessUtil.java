package com.gotop.Generalprocess.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.derby.tools.sysinfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gotop.Generalprocess.annonation.GeneralprocessField;
import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.dao.IGeneralprocessDAO;
import com.gotop.Generalprocess.dao.impl.GeneralprocessDAO;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelPublic;
import com.gotop.Generalprocess.service.IGeneralprocessService;
import com.gotop.Generalprocess.service.impl.GeneralprocessService;

/**
 * 
 * @author wujiajun
 * @desc 流程通用模板的工具类
 */


public class GeneralprocessUtil {

	/**
	 * @throws ClassNotFoundException
	 * @desc 用于使用类名 ，获取到对象的 基本信息（anno）
	 */

	public static List<GeneralprocessFieldBean> getBaseInfoByClassName(
			String classname) throws ClassNotFoundException {

		List<GeneralprocessFieldBean> returnBase = new ArrayList<GeneralprocessFieldBean>();

		Class<?> classc = Class.forName(classname);

		Field[] fs = classc.getDeclaredFields();

		for (Field field : fs) {

			if (field.isAnnotationPresent(GeneralprocessField.class)) {

				String fieldName = field.getName();// 字段的名称，用于和字段的值匹配？

				GeneralprocessField annotone = field
						.getAnnotation(GeneralprocessField.class);

				GeneralprocessFieldBean bean = new GeneralprocessFieldBean();

				if (annotone == null) {
					bean.setFieldName(fieldName);
				} else {
					bean.setDescription(annotone.description());
					bean.setHandle(annotone.handle());
					bean.setHidden(annotone.hidden());
					bean.setName(annotone.name());
					bean.setType(annotone.type());
					bean.setUrl(annotone.url());
					bean.setFieldName(fieldName);
					bean.setDicname(annotone.dicname());

				}

				returnBase.add(bean);
			}

		}

		return returnBase;

	}

	/**
	 * 
	 * @param processLists
	 * @param classes
	 * @param className
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws ClassNotFoundException
	 * @desc 传入 数据库查询的值+class+类名称
	 * 
	 * 
	 * 更具传入的值，查询单个 实体类，包括 字段值+字段的描述等
	 */
	public static <T> Map<String, List<GeneralprocessFieldBean>> fixBean(
			List<T> processLists, Class<?> classes, String className)
			throws IllegalArgumentException, IllegalAccessException,
			SecurityException, NoSuchFieldException, ClassNotFoundException {

		// 把 beforeBean 加入 value字段

		// 1.首先遍历 processLists （传入的 基本class ） 取到 所有字段的值

		Map<String, List<GeneralprocessFieldBean>> returnbeans = new HashMap<String, List<GeneralprocessFieldBean>>();

		String j = "seq";
		int i = 1;

		for (T bean : processLists) {
			List<GeneralprocessFieldBean> beforeBean = GeneralprocessUtil
					.getBaseInfoByClassName(className);

			Field[] fields = bean.getClass().getDeclaredFields();

			for (Field field : fields) {

				field.setAccessible(true);

				if (field.isAnnotationPresent(GeneralprocessField.class)) {

					// //获取到了字段的值 ，需要set进入
					// System.out.println(field.getName());
					// System.out.println(field.get(bean));
					//
					Object fieldvalue = field.getName();

					for (GeneralprocessFieldBean beforeBeanone : beforeBean) {

						if (beforeBeanone.getFieldName().equals(fieldvalue)) {

							beforeBeanone.setValue(field.get(bean));

						}

					}

				}

			}

			returnbeans.put(j, beforeBean);

			j = j + i;

			//

		}

		return returnbeans;

	}

	/**
	 * 
	 * @author wujiajun
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @desc 传入 rules， 更具多个rules（eg: com.gotop.ModelOne） 执行不一样的dao，然后获取到 不一样的
	 *       结果集（值+注解）
	 * 
	 * 
	 */

	public static List<List<ProcessModelPublic>> returnAllObj(String[] rules// 规则表中的集合
			, String keyID// 每个模式的主键 用于查询
	) throws ClassNotFoundException, SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, InstantiationException {
		
		
		
		System.out.println(SpringPropertyResourceReader.getProperty("com.gotop.Generalprocess.model.ProcessModelOne")+"++++配置文件的值");  

		// 1. 读取配置文件2.循环 去 获取 结果集 3. 全部结果集 放在一起

		String classname = "com.gotop.Generalprocess.dao.impl.GeneralprocessDAO";
		String method = "getProcessModelOneByBussinessId";

		/*
		 * WebApplicationContext webContext = ContextLoader
		 * .getCurrentWebApplicationContext(); IGeneralprocessService bean
		 * =(IGeneralprocessService)webContext.getBean("generalProcessService");
		 */

		// 实例化dao       
		Object bean = SpringContextUtil.getBean("generalProcessDAO");

		System.out.println(bean);

		Class<?> classes = Class.forName(classname);
		//目前只有值，需要加入加入 @ 注解的 值
		

		Method thismethod = classes.getDeclaredMethod(method, String.class);

		Object returnbean = thismethod.invoke(bean, keyID);

		return (List<List<ProcessModelPublic>>) returnbean;

	}

	public static void main(String[] args) throws ClassNotFoundException {
		

		

		GeneralprocessUtil iii = new GeneralprocessUtil();
		List<GeneralprocessFieldBean> lists = iii
				.getBaseInfoByClassName("com.gotop.Generalprocess.model.ProcessModelOne");

		for (GeneralprocessFieldBean generalprocessFieldBean : lists) {

			System.out.println(generalprocessFieldBean.getName());
			System.out.println(generalprocessFieldBean.getType());
			System.out.println(generalprocessFieldBean.getHandle());
			System.out.println(generalprocessFieldBean.getFieldName());
			System.out.println(generalprocessFieldBean.isHidden());

		}

	}

}
