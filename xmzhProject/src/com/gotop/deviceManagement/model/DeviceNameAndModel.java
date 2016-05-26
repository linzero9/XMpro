package com.gotop.deviceManagement.model;

import java.io.Serializable;

public class DeviceNameAndModel implements Serializable {

	private Long id; //主键id
	
	private String devicename_id;  //设备名称对应数据字典的id
	
	private String devicename;  //设备名称
	
	private String devicemodel_id;  //设备型号对应数据字典的id
	
	private String devicemodel;  //设备型号

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDevicename_id() {
		return devicename_id;
	}

	public void setDevicename_id(String devicename_id) {
		this.devicename_id = devicename_id;
	}

	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	public String getDevicemodel_id() {
		return devicemodel_id;
	}

	public void setDevicemodel_id(String devicemodel_id) {
		this.devicemodel_id = devicemodel_id;
	}

	public String getDevicemodel() {
		return devicemodel;
	}

	public void setDevicemodel(String devicemodel) {
		this.devicemodel = devicemodel;
	}
	
	
}
