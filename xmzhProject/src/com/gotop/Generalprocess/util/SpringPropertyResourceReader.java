package com.gotop.Generalprocess.util;  
import java.lang.reflect.Method;  
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;  
import java.util.Set;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;  
import org.springframework.beans.factory.config.PropertyResourceConfigurer;  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.AbstractApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
import org.springframework.core.io.support.PropertiesLoaderSupport;  


/**
 * 
 * @author wujiajun
 * @desc   load  配置文件
 *
 */
public class SpringPropertyResourceReader {  
	
    private static ApplicationContext applicationContext=new   
    ClassPathXmlApplicationContext("properties-Info.xml");  
    private static AbstractApplicationContext abstractContext =  
    (AbstractApplicationContext) applicationContext;  
    private static Properties properties=new Properties();  
    static{  
        try{  
            // get the names of BeanFactoryPostProcessor  
            String[] postProcessorNames = abstractContext  
                    .getBeanNamesForType(BeanFactoryPostProcessor.class,true,true);  
              
            for (String ppName : postProcessorNames) {  
                // get the specified BeanFactoryPostProcessor  
                BeanFactoryPostProcessor beanProcessor=  
                (BeanFactoryPostProcessor) abstractContext.getBean(ppName, BeanFactoryPostProcessor.class);  
                // check whether the beanFactoryPostProcessor is   
                // instance of the PropertyResourceConfigurer  
                // if it is yes then do the process otherwise continue  
                if(beanProcessor instanceof PropertyResourceConfigurer){  
                    PropertyResourceConfigurer propertyResourceConfigurer=  
                            (PropertyResourceConfigurer) beanProcessor;  
                      
                    // get the method mergeProperties   
                    // in class PropertiesLoaderSupport  
                    Method mergeProperties=PropertiesLoaderSupport.class.  
                        getDeclaredMethod("mergeProperties");  
                    // get the props  
                    mergeProperties.setAccessible(true);  
                    Properties props=(Properties) mergeProperties.  
                    invoke(propertyResourceConfigurer);  
                      
                    // get the method convertProperties   
                    // in class PropertyResourceConfigurer  
                    Method convertProperties=PropertyResourceConfigurer.class.  
                    getDeclaredMethod("convertProperties", Properties.class);  
                    // convert properties  
                    convertProperties.setAccessible(true);  
                    convertProperties.invoke(propertyResourceConfigurer, props);  
                      
                    properties.putAll(props);  
                }  
            }  
              
        }catch(Exception e){  
            throw new RuntimeException(e);  
        }  
    }  
      
    public static String getProperty(String propertyName){  
    	
   
        return properties.getProperty(propertyName);  
        
        
    }  
    
    
    
    
    public static     	 Map<String, String>  getAllPro(){  
    	
    	Set<Object> tset= properties.keySet();
    	List<String> model= new ArrayList<String>();

    	for (Object	 object : tset) {
    		String a= (String) object;
    		if(a.split("-")[0].startsWith("模式")){
    			
    			model.add(a);
    		}
    		
		}
    	

   	 Map<String, String> results  =  new  HashMap<String, String>();
	 
   	 for (String string : model) {
   		String value =  SpringPropertyResourceReader.getProperty(string);
   		results.put(string, value);
   	}
   	 
        return results;    
    }  
    
}  