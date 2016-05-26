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
	
	
}
