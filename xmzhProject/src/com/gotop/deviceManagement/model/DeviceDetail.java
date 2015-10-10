package com.gotop.deviceManagement.model;

import java.io.Serializable;

public class DeviceDetail  implements  Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	//明细ID
	private Long detailId;
	
	//设备ID
	private Long deviceId;
	
	//操作员工ID
	private  Long operateEmpid;
	
	//操作时间
	private   String  operateTime;
	
	//操作员工姓名
	private   String operateEmpname;
	
	//本次 设备名称
		private String deviceName;
		//本次 设备型号
		private String deviceModel;
		//本次 ip地址
		private String ipAdress;
		//本次 生产机器名称
		private   String productionMachineName;
		//本次 cpu型号
		private  String  cpuCode;
		//本次 内存容量
		private  String memory ;
		//本次 硬盘容量
		private String hardDisk;
		//本次 操作系统版本
		private String osVersion;
		//本次 内置软件版本
		private  String  softwareVersion;
		//本次 ie版本
		private  String ieVersion;
		//本次 用途
		private   String useful;
		//本次 终端号
		private   String  terminalNumber;
		
		//本次 使用人
		private String  user;
		//本次 安装的插件（多个）
		private String plugIn;
		//本次 对应的外设
		private String peripheral;
		
		//本次  其他属性1
		private  String otherOne;
		//本次 其他信息1
		private  String otherInfoOne;
		//本次  备注1
		private  String remarksOne;

		//本次 机构部门名称
		private  String orgname;
		//本次 机构部门代码
		private  String orgcode;
		
		//本次 设备状态
		private  String deviceState;

	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Long getOperateEmpid() {
		return operateEmpid;
	}

	public void setOperateEmpid(Long operateEmpid) {
		this.operateEmpid = operateEmpid;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperateEmpname() {
		return operateEmpname;
	}

	public void setOperateEmpname(String operateEmpname) {
		this.operateEmpname = operateEmpname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}

	public String getProductionMachineName() {
		return productionMachineName;
	}

	public void setProductionMachineName(String productionMachineName) {
		this.productionMachineName = productionMachineName;
	}

	public String getCpuCode() {
		return cpuCode;
	}

	public void setCpuCode(String cpuCode) {
		this.cpuCode = cpuCode;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getSoftwareVersion() {
		return softwareVersion;
	}

	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}

	public String getIeVersion() {
		return ieVersion;
	}

	public void setIeVersion(String ieVersion) {
		this.ieVersion = ieVersion;
	}

	public String getUseful() {
		return useful;
	}

	public void setUseful(String useful) {
		this.useful = useful;
	}

	public String getTerminalNumber() {
		return terminalNumber;
	}

	public void setTerminalNumber(String terminalNumber) {
		this.terminalNumber = terminalNumber;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPlugIn() {
		return plugIn;
	}

	public void setPlugIn(String plugIn) {
		this.plugIn = plugIn;
	}

	public String getPeripheral() {
		return peripheral;
	}

	public void setPeripheral(String peripheral) {
		this.peripheral = peripheral;
	}

	public String getOtherOne() {
		return otherOne;
	}

	public void setOtherOne(String otherOne) {
		this.otherOne = otherOne;
	}

	public String getOtherInfoOne() {
		return otherInfoOne;
	}

	public void setOtherInfoOne(String otherInfoOne) {
		this.otherInfoOne = otherInfoOne;
	}

	public String getRemarksOne() {
		return remarksOne;
	}

	public void setRemarksOne(String remarksOne) {
		this.remarksOne = remarksOne;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getDeviceState() {
		return deviceState;
	}

	public void setDeviceState(String deviceState) {
		this.deviceState = deviceState;
	}
	
	
		
}
