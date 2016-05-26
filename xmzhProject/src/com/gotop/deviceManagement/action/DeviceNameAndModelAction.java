package com.gotop.deviceManagement.action;

import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.deviceManagement.model.DeviceNameAndModel;
import com.gotop.deviceManagement.service.IDeviceNameAndModelService;

public class DeviceNameAndModelAction extends BaseAction {

	private DeviceNameAndModel deviceNameAndModel;
	
	private List<DeviceNameAndModel> deviceNameAndModels;
	
	protected IDeviceNameAndModelService deviceNameAndModelService;

	
	
	public DeviceNameAndModel getDeviceNameAndModel() {
		return deviceNameAndModel;
	}

	public void setDeviceNameAndModel(DeviceNameAndModel deviceNameAndModel) {
		this.deviceNameAndModel = deviceNameAndModel;
	}

	public List<DeviceNameAndModel> getDeviceNameAndModels() {
		return deviceNameAndModels;
	}

	public void setDeviceNameAndModels(List<DeviceNameAndModel> deviceNameAndModels) {
		this.deviceNameAndModels = deviceNameAndModels;
	}

	public IDeviceNameAndModelService getDeviceNameAndModelService() {
		return deviceNameAndModelService;
	}

	public void setDeviceNameAndModelService(
			IDeviceNameAndModelService deviceNameAndModelService) {
		this.deviceNameAndModelService = deviceNameAndModelService;
	}
	
	/**
	 * 查询 所有 设备名称与设备型号的对应关系
	 * @author liaomeiting
	 * @return
	 */
	public String queryDeviceNameAndModelList(){
		
		deviceNameAndModels = this.deviceNameAndModelService.queryDeviceNameAndModelList(deviceNameAndModel,this.getPage());
		this.setDeviceNameAndModels(deviceNameAndModels);
		return "deviceNameAndModel_list";
	}
	
}
