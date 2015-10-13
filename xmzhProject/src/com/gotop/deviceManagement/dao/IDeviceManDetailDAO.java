package com.gotop.deviceManagement.dao;

import java.util.List;
import java.util.Map;

import com.gotop.deviceManagement.model.DeviceDetail;
import com.primeton.utils.Page;

public interface IDeviceManDetailDAO {

	List detailList(Map<String, Object> map, Page page);

	void insert(DeviceDetail detail);

	int delete(DeviceDetail detail);
	
}
