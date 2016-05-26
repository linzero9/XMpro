package com.gotop.deviceManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.deviceManagement.dao.IDeviceNameAndModelDao;
import com.gotop.deviceManagement.model.DeviceNameAndModel;
import com.gotop.deviceManagement.service.IDeviceNameAndModelService;
import com.primeton.utils.Page;

public class DeviceNameAndModelService implements IDeviceNameAndModelService {

	protected IDeviceNameAndModelDao deviceNameAndModelDao;

	public IDeviceNameAndModelDao getDeviceNameAndModelDao() {
		return deviceNameAndModelDao;
	}

	public void setDeviceNameAndModelDao(
			IDeviceNameAndModelDao deviceNameAndModelDao) {
		this.deviceNameAndModelDao = deviceNameAndModelDao;
	}

	@Override
	public List<DeviceNameAndModel> queryDeviceNameAndModelList(
			DeviceNameAndModel deviceNameAndModel, Page page) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(deviceNameAndModel != null){
			if(deviceNameAndModel.getDevicename_id() != null && !"".equals(deviceNameAndModel.getDevicename_id())){
				map.put("devicename_id", deviceNameAndModel.getDevicename_id());
			}
			
			if(deviceNameAndModel.getDevicemodel_id() != null && !"".equals(deviceNameAndModel.getDevicemodel_id())){
				map.put("devicemodel_id", deviceNameAndModel.getDevicemodel_id());
			}
		}
		
		List list = this.deviceNameAndModelDao.queryDeviceNameAndModelList(map, page);
		return list;
	}

	@Override
	public void deleteItem(DeviceNameAndModel deviceNameAndModel) {
		
		this.deviceNameAndModelDao.deleteItem(deviceNameAndModel);
	}

	@Override
	public void addItem(DeviceNameAndModel deviceNameAndModel) {
		
		this.deviceNameAndModelDao.addItem(deviceNameAndModel);
		
	}

	@Override
	public List<DeviceNameAndModel> checkDeviceNameAndModel(
			DeviceNameAndModel deviceNameAndModel) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(deviceNameAndModel != null){
			if(deviceNameAndModel.getDevicename() != null && !"".equals(deviceNameAndModel.getDevicename())){
				map.put("devicename", deviceNameAndModel.getDevicename());
			}
			
			if(deviceNameAndModel.getDevicemodel() != null && !"".equals(deviceNameAndModel.getDevicemodel())){
				map.put("devicemodel", deviceNameAndModel.getDevicemodel());
			}
		}
		List list = this.deviceNameAndModelDao.checkDeviceNameAndModel(map);
		return list;
		
		
	}
	
	
}
