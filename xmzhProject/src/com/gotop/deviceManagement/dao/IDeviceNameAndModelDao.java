package com.gotop.deviceManagement.dao;

import java.util.List;
import java.util.Map;

import com.gotop.deviceManagement.model.DeviceNameAndModel;
import com.primeton.utils.Page;

public interface IDeviceNameAndModelDao {

	List queryDeviceNameAndModelList(Map<String, Object> map,
			Page page);

}
