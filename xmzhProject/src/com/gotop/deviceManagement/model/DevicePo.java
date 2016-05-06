package com.gotop.deviceManagement.model;

import java.io.Serializable;

public class DevicePo  implements  Serializable{
	
	/**
	 * @author wujiajun
	 */
	private static final long serialVersionUID = 1L;
	
	//设备ID
	private Long deviceId;
	
	//设备名称
	private String deviceName;
	//设备型号
	private String deviceModel;
	//ip地址
	private String ipAdress;
	//生产机器名称
	private   String productionMachineName;
	//cpu型号
	private  String  cpuCode;
	//内存容量
	private  String memory ;
	//硬盘容量
	private String hardDisk;
	//操作系统版本
	private String osVersion;
	//内置软件版本
	private  String  softwareVersion;
	//ie版本
	private  String ieVersion;
	//用途
	private   String useful;
	//终端号
	private   String  terminalNumber;
	
	//使用人
	private String  user;
	//安装的插件（多个）
	private String plugIn;
	//对应的外设
	private String peripheral;
	
	//是否在用
	private  String otherAttribute_1;
	//其他属性2
	private  String otherAttribute_2;
	//其他属性3
	private  String otherAttribute_3;
	//其他属性4
	private  String otherAttribute_4;
	//其他属性5
	private  String otherAttribute_5;
					
	//其他信息1
	private  String otherInfo_1;
	//其他信息2
	private  String otherInfo_2;
	//其他信息3
	private  String otherInfo_3;
	//其他信息4
	private  String otherInfo_4;
	//其他信息5
	private  String otherInfo_5;
			
	//任务标记
	private  String remarks_1;
	//备注2
	private  String remarks_2;
	//备注3
	private  String remarks_3;
	//备注4
	private  String remarks_4;
	//备注5
	private  String remarks_5;

	//机构部门名称
	private  String orgname;
	//机构部门代码
	private  String orgcode;
	
	//设备状态
	private  String deviceState;
	
	//内存容量 最小值
	private  String  memoryMin ;
	//内存容量 最大值
	private  String  memoryMax ;
	//硬盘容量 最小值
	private String hardDiskMin;	
	//硬盘容量 最大值
	private String hardDiskMax;
	
	private String deviceModelName;
	
	public String getDeviceModelName() {
		return deviceModelName;
	}
	public void setDeviceModelName(String deviceModelName) {
		this.deviceModelName = deviceModelName;
	}
	public Long getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
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
	
	public String getOtherAttribute_1() {
		return otherAttribute_1;
	}
	public void setOtherAttribute_1(String otherAttribute_1) {
		this.otherAttribute_1 = otherAttribute_1;
	}
	public String getOtherAttribute_2() {
		return otherAttribute_2;
	}
	public void setOtherAttribute_2(String otherAttribute_2) {
		this.otherAttribute_2 = otherAttribute_2;
	}
	public String getOtherAttribute_3() {
		return otherAttribute_3;
	}
	public void setOtherAttribute_3(String otherAttribute_3) {
		this.otherAttribute_3 = otherAttribute_3;
	}
	public String getOtherAttribute_4() {
		return otherAttribute_4;
	}
	public void setOtherAttribute_4(String otherAttribute_4) {
		this.otherAttribute_4 = otherAttribute_4;
	}
	public String getOtherAttribute_5() {
		return otherAttribute_5;
	}
	public void setOtherAttribute_5(String otherAttribute_5) {
		this.otherAttribute_5 = otherAttribute_5;
	}
	public String getOtherInfo_1() {
		return otherInfo_1;
	}
	public void setOtherInfo_1(String otherInfo_1) {
		this.otherInfo_1 = otherInfo_1;
	}
	public String getOtherInfo_2() {
		return otherInfo_2;
	}
	public void setOtherInfo_2(String otherInfo_2) {
		this.otherInfo_2 = otherInfo_2;
	}
	public String getOtherInfo_3() {
		return otherInfo_3;
	}
	public void setOtherInfo_3(String otherInfo_3) {
		this.otherInfo_3 = otherInfo_3;
	}
	public String getOtherInfo_4() {
		return otherInfo_4;
	}
	public void setOtherInfo_4(String otherInfo_4) {
		this.otherInfo_4 = otherInfo_4;
	}
	public String getOtherInfo_5() {
		return otherInfo_5;
	}
	public void setOtherInfo_5(String otherInfo_5) {
		this.otherInfo_5 = otherInfo_5;
	}
	public String getRemarks_1() {
		return remarks_1;
	}
	public void setRemarks_1(String remarks_1) {
		this.remarks_1 = remarks_1;
	}
	public String getRemarks_2() {
		return remarks_2;
	}
	public void setRemarks_2(String remarks_2) {
		this.remarks_2 = remarks_2;
	}
	public String getRemarks_3() {
		return remarks_3;
	}
	public void setRemarks_3(String remarks_3) {
		this.remarks_3 = remarks_3;
	}
	public String getRemarks_4() {
		return remarks_4;
	}
	public void setRemarks_4(String remarks_4) {
		this.remarks_4 = remarks_4;
	}
	public String getRemarks_5() {
		return remarks_5;
	}
	public void setRemarks_5(String remarks_5) {
		this.remarks_5 = remarks_5;
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
	public String getMemoryMin() {
		return memoryMin;
	}
	public void setMemoryMin(String memoryMin) {
		this.memoryMin = memoryMin;
	}
	public String getMemoryMax() {
		return memoryMax;
	}
	public void setMemoryMax(String memoryMax) {
		this.memoryMax = memoryMax;
	}
	public String getHardDiskMin() {
		return hardDiskMin;
	}
	public void setHardDiskMin(String hardDiskMin) {
		this.hardDiskMin = hardDiskMin;
	}
	public String getHardDiskMax() {
		return hardDiskMax;
	}
	public void setHardDiskMax(String hardDiskMax) {
		this.hardDiskMax = hardDiskMax;
	}

	
}
