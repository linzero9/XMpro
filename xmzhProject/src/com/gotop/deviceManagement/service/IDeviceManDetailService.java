package com.gotop.deviceManagement.service;

import java.util.List;
import com.gotop.deviceManagement.dao.IDeviceManDetailDAO;
import com.gotop.deviceManagement.model.DeviceDetail;
import com.primeton.utils.Page;

public interface IDeviceManDetailService {

	IDeviceManDetailDAO getDeviceManDetailDAO();

	void setDeviceManDetailDAO(IDeviceManDetailDAO detailDAO);
	
	List<DeviceDetail> detailList(DeviceDetail detail, Page page);

	void insert(DeviceDetail detail);

	void delete(DeviceDetail detail);


}
