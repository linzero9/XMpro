package com.gotop.deviceManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.deviceManagement.dao.IDeviceManDetailDAO;
import com.gotop.deviceManagement.dao.IDeviceManagementDAO;
import com.gotop.deviceManagement.model.DeviceDetail;
import com.gotop.deviceManagement.model.DevicePo;
import com.gotop.deviceManagement.service.IDeviceManDetailService;
import com.gotop.deviceManagement.service.IDeviceManagementService;
import com.primeton.utils.Page;

public class DeviceManDetailService implements IDeviceManDetailService{

	protected Logger log = Logger.getLogger(DeviceManDetailService.class);
	
	protected IDeviceManDetailDAO deviceManDetailDAO;
	
	public IDeviceManDetailDAO getDeviceManDetailDAO() {
		return deviceManDetailDAO;
	}

	public void setDeviceManDetailDAO(IDeviceManDetailDAO deviceManDetailDAO) {
		this.deviceManDetailDAO = deviceManDetailDAO;
	}

	@Override
	public List<DeviceDetail> detailList(DeviceDetail detail, Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deviceId", detail.getDeviceId());
		if( detail.getOperateEmpname() != null && !"".equals(detail.getOperateEmpname())){
			map.put("operateEmpname", detail.getOperateEmpname());
		}
		List list = deviceManDetailDAO.detailList(map, page);
        return list;
	}


	@Override
	public void insert(DeviceDetail detail) {
			deviceManDetailDAO.insert(detail);
	}

	@Override
	public void delete(DeviceDetail detail) {
		deviceManDetailDAO.delete(detail);
	}

	
}
