package com.gotop.deviceManagement.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.deviceManagement.model.DevicePo;
import com.primeton.utils.Page;

public interface IDeviceManagementDAO {

	List deviceList(Map<String, Object> map, Page page);
	//统计输出
	List sumUpList(Map<String, Object> map, Page page);
	DevicePo selectByPrimaryKey(Long deviceId);

	void insert(DevicePo device);

	int updateByPrimaryKey(DevicePo device);

	int deleteByPrimaryKey(Long deviceId);

	int queryOrg(Map<String, Object> map);
	

}
