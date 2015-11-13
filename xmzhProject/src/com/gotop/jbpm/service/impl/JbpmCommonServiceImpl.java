package com.gotop.jbpm.service.impl;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.gotop.jbpm.service.JbpmCommonService;

public class JbpmCommonServiceImpl implements JbpmCommonService{

	@Override
	public String makeJbpmJsonByData(String data) throws JSONException {
		JSONObject jsonObject = new JSONObject(data);
		JSONObject propsPJson = jsonObject.getJSONObject("props");
		JSONObject statesJson = jsonObject.getJSONObject("states");
		JSONObject pathsJson = jsonObject.getJSONObject("paths");
		
		String str = "";
		String pName = propsPJson.getJSONObject("props").getJSONObject("name").getString("value");
		str+="<process name=\""+pName+"\" xmlns=\"http://jbpm.org/4.4/jpdl\">";
		 Iterator it = statesJson.keys();  
         while (it.hasNext()) {  
             String key = (String) it.next();  
             JSONObject j = statesJson.getJSONObject(key);
             String type = (String) j.get("type");
             if("start".equals(type)){
            	 	//开始节点
            	 str += "<start";
            	 if(j.getJSONObject("text") != null){
            		 JSONObject textJson = j.getJSONObject("text");
            		 if(textJson.getString("text") != null){
            			 String name = textJson.getString("text");
                		 str += " name=" +"\""+ name +"\""; 
            		 }
            	 }
            	 if(j.getJSONObject("attr") != null){
            		 JSONObject attrJson = j.getJSONObject("attr");
            		 str += " g=\"";
            		 if(attrJson.getString("x") != null){
            			 str += attrJson.getString("x");
            			 str +=",";
            		 }
            		 if(attrJson.getString("y") != null){
            			 str += attrJson.getString("y");
            			 str +=",";
            		 }
            		 if(attrJson.getString("width") != null){
            			 str += attrJson.getString("width");
            			 str +=",";
            		 }
            		 if(attrJson.getString("height") != null){
            			 str += attrJson.getString("height");
            		 }
            		 str +="\">";
            		 str = makePath(key, str, statesJson, pathsJson);
            		 str +="</start>";
            	 }
             }else if("task".equals(type)){
            	 	//任务节点
            	 str += "<task";
            	 if(j.getJSONObject("text") != null){
            		 JSONObject textJson = j.getJSONObject("text");
            		 if(textJson.getString("text") != null && !"".equals(textJson.getString("text"))){
            			 String name = textJson.getString("text");
                		 str += " name=" +"\""+ name +"\""; 
            		 }
            	 }
            	 if(j.getJSONObject("attr") != null){
            		 JSONObject attrJson = j.getJSONObject("attr");
            		 str += " g=\"";
            		 if(attrJson.getString("x") != null && !"".equals(attrJson.getString("x"))){
            			 str += attrJson.getString("x");
            			 str +=",";
            		 }
            		 if(attrJson.getString("y") != null && !"".equals(attrJson.getString("y"))){
            			 str += attrJson.getString("y");
            			 str +=",";
            		 }
            		 if(attrJson.getString("width") != null && !"".equals(attrJson.getString("width"))){
            			 str += attrJson.getString("width");
            			 str +=",";
            		 }
            		 if(attrJson.getString("height") != null && !"".equals(attrJson.getString("height"))){
            			 str += attrJson.getString("height");
            		 }
            		 str +="\"";
            	 }
            	 if(j.getJSONObject("props") != null){
            		 JSONObject propsJson = j.getJSONObject("props");
            		/* if(propsJson.getJSONObject("desc") != null && !"".equals(propsJson.getJSONObject("desc").getString("value"))){
            			 //拼接desc描述内容
            			 str += " desc=\"" +propsJson.getJSONObject("desc").getString("value") + "\"";
            		 }*/
            		 if(propsJson.getJSONObject("form") != null){
            			 if(!"".equals(propsJson.getJSONObject("form").getString("value"))){
            				//拼接form表单内容
                			 str += " form=\"" +propsJson.getJSONObject("form").getString("value") + "\"";
            			 }else{
            				 str += " form=\"" +"/commonProcess/tCommonProcessAction_getCommonProcessForapprove.action" + "\"";
            			 }
            		 }
            		 /*if(propsJson.getJSONObject("assignee") != null && !"".equals(propsJson.getJSONObject("assignee").getString("value"))){
            			//拼接assignee内容
            			 str += " assignee=\"" +propsJson.getJSONObject("assignee").getString("value") + "\"";
            		 }*/
            	 }
            	 str +=" >";
            	 str = makePath(key, str, statesJson, pathsJson);
        		 str +="</task>";
             }else if("end".equals(type)){
            	   //结束节点
            	 str += "<end";
            	 if(j.getJSONObject("text") != null){
            		 JSONObject textJson = j.getJSONObject("text");
            		 if(textJson.getString("text") != null){
            			 String name = textJson.getString("text");
                		 str += " name=" +"\""+ name +"\""; 
            		 }
            	 }
            	 if(j.getJSONObject("attr") != null){
            		 JSONObject attrJson = j.getJSONObject("attr");
            		 str += " g=\"";
            		 if(attrJson.getString("x") != null){
            			 str += attrJson.getString("x");
            			 str +=",";
            		 }
            		 if(attrJson.getString("y") != null){
            			 str += attrJson.getString("y");
            			 str +=",";
            		 }
            		 if(attrJson.getString("width") != null){
            			 str += attrJson.getString("width");
            			 str +=",";
            		 }
            		 if(attrJson.getString("height") != null){
            			 str += attrJson.getString("height");
            		 }
            		 str +="\">";
            		 str =  makePath(key, str, statesJson, pathsJson);
            		 str +="</end>";
            	 }
             }
         }  
         str+="</process>";
         System.out.println(str);
		return str;
	}

	
	/**
	 * 根据页面的在线编辑器和节点的json构造线条的xml信息
	 * 
	 * @param key
	 * @param str
	 * @param statesJson
	 * @param pathsJson
	 * @return
	 * @throws JSONException
	 */
	public String makePath(String key,String str,JSONObject statesJson,JSONObject pathsJson) throws JSONException{
		Iterator  it2 = pathsJson.keys();  
        while (it2.hasNext()) {  
            String key2 = (String) it2.next();  
            JSONObject j2 = pathsJson.getJSONObject(key2);
            String from = j2.getString("from");
            if(from.equals(key)){
           	 String to = j2.getString("to");
	             if(to != null && !"".equals(to)){
	            	  str += "<transition";
	                  String toName = statesJson.getJSONObject(to).getJSONObject("text").getString("text");
	                  str += " to=\"" + toName + "\"";
	             }
	             str += " g=\"";
	             if(j2.getJSONArray("dots") != null && j2.getJSONArray("dots").length()>0){
	            	 JSONArray dotsJson = j2.getJSONArray("dots");
	        		 if(dotsJson.getJSONObject(0) != null){
	        			 if( !"".equals(dotsJson.getJSONObject(0).getString("x"))){
	        				 str += dotsJson.getJSONObject(0).getString("x");
		        			 str +=",";
	        			 }
	        			 if(!"".equals(dotsJson.getJSONObject(0).getString("y"))){
		        			 str += dotsJson.getJSONObject(0).getString("y");
		        		 }
	        		 }
	        		 str+=":";
	             }
	             if(j2.getJSONObject("textPos") != null){
	            	 JSONObject textPosJson = j2.getJSONObject("textPos");
	        		 if(textPosJson.getString("x") != null && !"".equals(textPosJson.getString("x"))){
	        			 str += textPosJson.getString("x");
	        			 str +=",";
	        		 }
	        		 if(textPosJson.getString("y") != null && !"".equals(textPosJson.getString("y"))){
	        			 str += textPosJson.getString("y");
	        		 }
	             }
	             str +="\"";
	             if(j2.getJSONObject("text") != null && !"".equals(j2.getJSONObject("text").getString("text"))){
	            	 str += " name=\"" + j2.getJSONObject("text").getString("text") + "\"";
	             }
	             str +="/>";
            }
        }
        return str;
	}
}
