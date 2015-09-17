package com.gotop.deviceManagement.model;

import java.io.Serializable;

public class DevicePo  implements  Serializable{
	
	/**
	 * @author wujiajun
	 */
	private static final long serialVersionUID = 1L;
	
	
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
	private  String  memory ;
	//硬盘容量
	private String hardDisk;
	//操作系统版本
	private String OSversion;
	//软件版本
	private  String  softwareVersion;
	//ie版本
	private  String IEversion;
	//用途
	private   String useful;
	//终端号
	private   String  terminalNumber;
	
	//使用人
	private String  user;
	//安装的插件（多个）
	private String[]  plugIn;
	//对应的 外设
	private String[]  Peripheral;
	//其他属性1
	private  String otherOne;
	
	//其他属性2
	private  String otherTwo;
	//其他属性3
	private  String otherThree;
	//备注1
	private  String RemarksOne;
	//备注2
	private  String RemarksTwo;
	//备注3
	private  String RemarksThree;
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
	public String getOSversion() {
		return OSversion;
	}
	public void setOSversion(String oSversion) {
		OSversion = oSversion;
	}
	public String getSoftwareVersion() {
		return softwareVersion;
	}
	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}
	public String getIEversion() {
		return IEversion;
	}
	public void setIEversion(String iEversion) {
		IEversion = iEversion;
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
	public String[] getPlugIn() {
		return plugIn;
	}
	public void setPlugIn(String[] plugIn) {
		this.plugIn = plugIn;
	}
	public String[] getPeripheral() {
		return Peripheral;
	}
	public void setPeripheral(String[] peripheral) {
		Peripheral = peripheral;
	}
	public String getOtherOne() {
		return otherOne;
	}
	public void setOtherOne(String otherOne) {
		this.otherOne = otherOne;
	}
	public String getOtherTwo() {
		return otherTwo;
	}
	public void setOtherTwo(String otherTwo) {
		this.otherTwo = otherTwo;
	}
	public String getOtherThree() {
		return otherThree;
	}
	public void setOtherThree(String otherThree) {
		this.otherThree = otherThree;
	}
	public String getRemarksOne() {
		return RemarksOne;
	}
	public void setRemarksOne(String remarksOne) {
		RemarksOne = remarksOne;
	}
	public String getRemarksTwo() {
		return RemarksTwo;
	}
	public void setRemarksTwo(String remarksTwo) {
		RemarksTwo = remarksTwo;
	}
	public String getRemarksThree() {
		return RemarksThree;
	}
	public void setRemarksThree(String remarksThree) {
		RemarksThree = remarksThree;
	}
	
	
	
	

}
