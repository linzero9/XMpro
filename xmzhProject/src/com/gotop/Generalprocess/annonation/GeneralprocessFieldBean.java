package com.gotop.Generalprocess.annonation;

import java.io.Serializable;

/**
 * 
 * @author wujiajun
 * @desc   获取到annot的封装类
 *
 */

public class GeneralprocessFieldBean implements   Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  String fieldName;
	private  String name;
	private String description;
	private boolean hidden;
	private  String type;
	private String handle;
	private String url;
	
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
