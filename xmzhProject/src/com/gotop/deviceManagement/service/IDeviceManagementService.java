package com.gotop.deviceManagement.service;

import java.util.List;
import com.gotop.deviceManagement.dao.IDeviceManDetailDAO;
import com.gotop.deviceManagement.dao.IDeviceManagementDAO;
import com.gotop.deviceManagement.model.DevicePo;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public interface IDeviceManagementService {

	IDeviceManagementDAO getDeviceManagementDAO();

	void setDeviceManagementDAO(IDeviceManagementDAO deviceManagementDAO);
	
	 IDeviceManDetailDAO getDeviceManDetailDAO(); 
	
	void setDeviceManDetailDAO(IDeviceManDetailDAO deviceManDetailDAO);
	
	List<DevicePo> deviceList(DevicePo device, Page page);

	DevicePo getDeviceByDeviceId(DevicePo device);

	void save(DevicePo device, MUOUserSession muoUserSession);

	void delete(DevicePo device);


}
