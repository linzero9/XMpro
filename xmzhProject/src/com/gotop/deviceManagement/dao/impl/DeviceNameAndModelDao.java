package com.gotop.deviceManagement.dao.impl;

import java.util.List;
import java.util.Map;

import com.gotop.deviceManagement.dao.IDeviceNameAndModelDao;
import com.gotop.deviceManagement.model.DeviceNameAndModel;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class DeviceNameAndModelDao extends SqlMapClientDao implements IDeviceNameAndModelDao{

	@Override
	public List queryDeviceNameAndModelList(Map<String, Object> map, Page page) {
		
		List list = queryForList("DeviceNameAndModel_SqlMap.queryDeviceNameAndModelList", map, page);
		return list;
	}

	@Override
	public int deleteItem(DeviceNameAndModel deviceNameAndModel) {
		int rows = getSqlMapClientTemplate().delete("DeviceNameAndModel_SqlMap.deleteItem", deviceNameAndModel);
        return rows;
		
	}

	@Override
	public void addItem(DeviceNameAndModel deviceNameAndModel) {
		
		getSqlMapClientTemplate().insert("DeviceNameAndModel_SqlMap.addItem", deviceNameAndModel);
		
		
	}

	@Override
	public List checkDeviceNameAndModel(Map<String, Object> map) {
		
		List list = queryForList("DeviceNameAndModel_SqlMap.checkDeviceNameAndModel", map);
		return list;
	}

}
