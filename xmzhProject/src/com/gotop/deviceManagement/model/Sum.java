package com.gotop.deviceManagement.model;

public class Sum {
	private long tot;
	private String orgnameTemp;
	
	private String deviceName;
	
	private String deviceModel;
	
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

	public long getTot() {
		return tot;
	}

	public void setTot(long tot) {
		this.tot = tot;
	}

	public String getOrgnameTemp() {
		return orgnameTemp;
	}

	public void setOrgnameTemp(String orgnameTemp) {
		this.orgnameTemp = orgnameTemp;
	}

	
}
