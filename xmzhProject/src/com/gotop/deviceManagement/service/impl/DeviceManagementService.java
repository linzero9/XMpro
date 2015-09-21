package com.gotop.deviceManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.deviceManagement.dao.IDeviceManagementDAO;
import com.gotop.deviceManagement.model.DevicePo;
import com.gotop.deviceManagement.service.IDeviceManagementService;
import com.primeton.utils.Page;

public class DeviceManagementService implements IDeviceManagementService{

	protected Logger log = Logger.getLogger(DeviceManagementService.class);
	
	protected IDeviceManagementDAO deviceManagementDAO;
	
	public IDeviceManagementDAO getDeviceManagementDAO() {
		return deviceManagementDAO;
	}

	public void setDeviceManagementDAO(IDeviceManagementDAO deviceManagementDAO) {
		this.deviceManagementDAO = deviceManagementDAO;
	}

	@Override
	public List<DevicePo> deviceList(DevicePo device, Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(device != null && device.getDeviceName() != null && !"".equals(device.getDeviceName())){
			map.put("deviceName", device.getDeviceName());
		}
		List list = deviceManagementDAO.deviceList(map, page);
        return list;
	}

	@Override
	public DevicePo getDeviceByDeviceId(DevicePo device) {
		DevicePo devicePo = deviceManagementDAO.selectByPrimaryKey(device.getDeviceId());
		return devicePo;
	}

	@Override
	public void save(DevicePo device) {
		if(device.getDeviceId() == null){
			deviceManagementDAO.insert(device);
		}else{
			deviceManagementDAO.updateByPrimaryKey(device);
		}
		
	}
	
}
