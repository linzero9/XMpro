package com.gotop.deviceManagement.service;

import java.util.List;
import com.gotop.deviceManagement.dao.IDeviceManDetailDAO;
import com.gotop.deviceManagement.dao.IDeviceManagementDAO;
import com.gotop.deviceManagement.model.DeviceDetail;
import com.gotop.deviceManagement.model.DevicePo;
import com.gotop.deviceManagement.model.HeJi;
import com.gotop.deviceManagement.model.Sum;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public interface IDeviceManagementService {

	IDeviceManagementDAO getDeviceManagementDAO();

	void setDeviceManagementDAO(IDeviceManagementDAO deviceManagementDAO);
	
	 IDeviceManDetailDAO getDeviceManDetailDAO(); 
	
	void setDeviceManDetailDAO(IDeviceManDetailDAO deviceManDetailDAO);
	
	List<DevicePo> deviceList(DevicePo device, Page page);
	
	//统计机构下所有物品
	List<DevicePo> sumUpDevicePos(DevicePo device,String orgcode, Page page);
	//导出EXCEL
	List<DevicePo> sumUpDevicePosExcel(DevicePo device, String orgcodeTemp);
	DevicePo getDeviceByDeviceId(DevicePo device);

	void save(DevicePo device, MUOUserSession muoUserSession);

	void delete(String deviceIds);

	int queryOrg(String orgname);
	
	List queryOrgList();

	String importExcel(String filePath, String entityType) throws Exception;

	List<DevicePo> deviceList(DevicePo device);

	List<DevicePo> queryType(String deviceName);
   //合计
	 List<HeJi> heJi(DevicePo device, String orgcodeTemp);
}
