package com.gotop.deviceManagement.service;

import java.util.List;

import com.gotop.deviceManagement.model.DeviceNameAndModel;
import com.primeton.utils.Page;

public interface IDeviceNameAndModelService {

	List<DeviceNameAndModel> queryDeviceNameAndModelList(
			DeviceNameAndModel deviceNameAndModel, Page page);

	void deleteItem(DeviceNameAndModel deviceNameAndModel);

	void addItem(DeviceNameAndModel deviceNameAndModel);

	List<DeviceNameAndModel> checkDeviceNameAndModel(
			DeviceNameAndModel deviceNameAndModel);

}
