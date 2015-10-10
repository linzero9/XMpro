package com.gotop.deviceManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.deviceManagement.dao.IDeviceManDetailDAO;
import com.gotop.deviceManagement.dao.IDeviceManagementDAO;
import com.gotop.deviceManagement.model.DeviceDetail;
import com.gotop.deviceManagement.model.DevicePo;
import com.gotop.deviceManagement.service.IDeviceManagementService;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public class DeviceManagementService implements IDeviceManagementService{

	protected Logger log = Logger.getLogger(DeviceManagementService.class);
	
	protected IDeviceManagementDAO deviceManagementDAO;
	
	protected IDeviceManDetailDAO deviceManDetailDAO;
	
	public IDeviceManagementDAO getDeviceManagementDAO() {
		return deviceManagementDAO;
	}

	public void setDeviceManagementDAO(IDeviceManagementDAO deviceManagementDAO) {
		this.deviceManagementDAO = deviceManagementDAO;
	}
	

	public IDeviceManDetailDAO getDeviceManDetailDAO() {
		return deviceManDetailDAO;
	}

	public void setDeviceManDetailDAO(IDeviceManDetailDAO deviceManDetailDAO) {
		this.deviceManDetailDAO = deviceManDetailDAO;
	}

	@Override
	public List<DevicePo> deviceList(DevicePo device, Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(device != null){
			if( device.getOrgcode() != null && !"".equals(device.getOrgcode())){
				map.put("orgcode", device.getOrgcode());
			}
			if( device.getDeviceName() != null && !"".equals(device.getDeviceName())){
				map.put("deviceName", device.getDeviceName());
			}
			if( device.getDeviceModel() != null && !"".equals(device.getDeviceModel())){
				map.put("deviceModel", device.getDeviceModel());
			}
			if( device.getDeviceState() != null && !"".equals(device.getDeviceState())){
				map.put("deviceState", device.getDeviceState());
			}
			if( device.getMemoryMin() != null && !"".equals(device.getMemoryMin())){
				map.put("memoryMin", device.getMemoryMin());
			}
			if( device.getMemoryMax() != null && !"".equals(device.getMemoryMax())){
				map.put("memoryMax", device.getMemoryMax());
			}
			if( device.getHardDiskMin() != null && !"".equals(device.getHardDiskMin())){
				map.put("hardDiskMin", device.getHardDiskMin());
			}
			if( device.getHardDiskMax() != null && !"".equals(device.getHardDiskMax())){
				map.put("hardDiskMax", device.getHardDiskMax());
			}
			if( device.getOsVersion() != null && !"".equals(device.getOsVersion())){
				map.put("osVersion", device.getOsVersion());
			}
			if( device.getSoftwareVersion() != null && !"".equals(device.getSoftwareVersion())){
				map.put("softwareVersion", device.getSoftwareVersion());
			}
			if( device.getIeVersion() != null && !"".equals(device.getIeVersion())){
				map.put("ieVersion", device.getIeVersion());
			}
			if( device.getUseful() != null && !"".equals(device.getUseful())){
				map.put("useful", device.getUseful());
			}
			if( device.getPlugIn() != null && !"".equals(device.getPlugIn())){
				map.put("plugIn", device.getPlugIn());
			}
			if( device.getPeripheral() != null && !"".equals(device.getPeripheral())){
				map.put("peripheral", device.getPeripheral());
			}
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
	public void save(DevicePo device,MUOUserSession muoUserSession) {
		if(device.getDeviceId() == null){
			device.setDeviceState("0"); //新增设备时默认设状态为可用（即为0）
			deviceManagementDAO.insert(device);
		}else{
			deviceManagementDAO.updateByPrimaryKey(device);
		}
		
		//不管添加还是修改，同时都要插入一条记录到明细表里：
		DeviceDetail detail = new DeviceDetail();
		Long operateEmpid = muoUserSession.getEmpid();
		
		detail.setOperateEmpid(operateEmpid);
		detail.setDeviceId(device.getDeviceId());
		detail.setDeviceName(device.getDeviceName());
		detail.setDeviceModel(device.getDeviceModel());
		detail.setIpAdress(device.getIpAdress());
		detail.setProductionMachineName(device.getProductionMachineName());
		detail.setCpuCode(device.getCpuCode());
		detail.setMemory(device.getMemory());
		detail.setHardDisk(device.getHardDisk());
		detail.setOsVersion(device.getOsVersion());
		detail.setSoftwareVersion(device.getSoftwareVersion());
		detail.setIeVersion(device.getIeVersion());
		detail.setUseful(device.getUseful());
		detail.setTerminalNumber(device.getTerminalNumber());
		detail.setUser(device.getUser());
		detail.setPlugIn(device.getPlugIn());
		detail.setPeripheral(device.getPeripheral());
		detail.setOtherOne(device.getOtherOne());
		detail.setOtherInfoOne(device.getOtherInfoOne());
		detail.setRemarksOne(device.getRemarksOne());
		detail.setOrgcode(device.getOrgcode());
		detail.setDeviceState(device.getDeviceState());
		
		deviceManDetailDAO.insert(detail);
	}

	@Override
	public void delete(DevicePo device) {
		deviceManagementDAO.deleteByPrimaryKey(device.getDeviceId());
		
		//同时删除明细表记录
		DeviceDetail detail = new DeviceDetail();
		detail.setDeviceId(device.getDeviceId());
		deviceManDetailDAO.delete(detail);
	}
	
}
