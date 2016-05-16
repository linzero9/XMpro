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
import com.gotop.util.export.ExcelTemplate;
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

	// 输出统计
	@Override
	public List<DevicePo> sumUpDevicePos(DevicePo device,String orgcodeTemp, Page page) {
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
				//map.put("useful", device.getUseful());
				
				String sql_useful ="";
				String[] arr_useful = device.getUseful().split(", ");
				for(int i=0; i<arr_useful.length; i++){//最后拼接得到的SQL如：sql_otherInfo2 = "t.OTHERINFO_2 like '%01%' or t.OTHERINFO_2 like '%02%'";只要数据库里含用户所选的一项，都要选出来
					if(i == 0){
						sql_useful += "t.USEFUL like  " + "'%" + arr_useful[i] + "%'";
					}else{
						sql_useful += " or " +  "t.USEFUL like  " + "'%" + arr_useful[i] + "%'";
					}
				}
				map.put("useful", sql_useful );
			}
			
			if( device.getPlugIn() != null && !"".equals(device.getPlugIn())){
				//map.put("plugIn", device.getPlugIn());
				
				String sql_plugIn ="";
				String[] arr_plugIn = device.getPlugIn().split(", ");
				for(int i=0; i<arr_plugIn.length; i++){//最后拼接得到的SQL如：sql_otherInfo2 = "t.OTHERINFO_2 like '%01%' or t.OTHERINFO_2 like '%02%'";只要数据库里含用户所选的一项，都要选出来
					if(i == 0){
						sql_plugIn += "t.PLUGIN like  " + "'%" + arr_plugIn[i] + "%'";
					}else{
						sql_plugIn += " or " +  "t.PLUGIN like  " + "'%" + arr_plugIn[i] + "%'";
					}
				}
				map.put("plugIn", sql_plugIn );
			}
			
			if( device.getPeripheral() != null && !"".equals(device.getPeripheral())){
				//map.put("peripheral", device.getPeripheral());
				
				String sql_peripheral ="";
				String[] arr_peripheral = device.getPeripheral().split(", ");
				for(int i=0; i<arr_peripheral.length; i++){//最后拼接得到的SQL如：sql_otherInfo2 = "t.OTHERINFO_2 like '%01%' or t.OTHERINFO_2 like '%02%'";只要数据库里含用户所选的一项，都要选出来
					if(i == 0){
						sql_peripheral += "t.PERIPHERAL like  " + "'%" + arr_peripheral[i] + "%'";
					}else{
						sql_peripheral += " or " +  "t.PERIPHERAL like  " + "'%" + arr_peripheral[i] + "%'";
					}
				}
				map.put("peripheral", sql_peripheral );
			}
		}
		map.put("orgcodeTemp", orgcodeTemp);
		
		List list = deviceManagementDAO.sumUpList(map, null);
        return list;
	}
	
	@Override
	public List<DevicePo> deviceList(DevicePo device, Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(device != null){
			if( device.getOrgcode() != null && !"".equals(device.getOrgcode())){
				
				map.put("orgcode", device.getOrgcode());
			}
			if( device.getIpAdress() != null && !"".equals(device.getIpAdress())){
				
				map.put("ipAdress", device.getIpAdress());
			}
			if (!", ".equals(device.getOsVersion())) {
			if( device.getOsVersion() != null && !"".equals(device.getOsVersion())){
				String[] devices =device.getOsVersion().split(",");
				map.put("osVersion", devices[0]);
			}
			}
			if( device.getOtherAttribute_2() != null && !"".equals(device.getOtherAttribute_2())){
				
				map.put("otherAttribute_2", device.getOtherAttribute_2());
			}
			
			if( device.getOtherInfo_2() != null && !"".equals(device.getOtherInfo_2())){
				//map.put("otherInfo_2", device.getOtherInfo_2());
				
				String sql_otherInfo2 ="";
				String[] arr_otherInfo2 = device.getOtherInfo_2().split(", ");
				for(int i=0; i<arr_otherInfo2.length; i++){//最后拼接得到的SQL如：sql_otherInfo2 = "t.OTHERINFO_2 like '%01%' or t.OTHERINFO_2 like '%02%'";只要数据库里含用户所选的一项，都要选出来
					if(i == 0){
						sql_otherInfo2 += "t.OTHERINFO_2 like  " + "'%" + arr_otherInfo2[i] + "%'";
					}else{
						sql_otherInfo2 += " or " +  "t.OTHERINFO_2 like  " + "'%" + arr_otherInfo2[i] + "%'";
					}
				}
				map.put("otherInfo_2", sql_otherInfo2 );
			}
			
			if( device.getDeviceName() != null && !"".equals(device.getDeviceName())){
			
				map.put("deviceName", device.getDeviceName());
			}
			if( device.getRemarks_1() != null && !"".equals(device.getRemarks_1())){
				
				map.put("remarks_1", device.getRemarks_1());
			}
			if( device.getRemarks_2() != null && !"".equals(device.getRemarks_2())){
				
				map.put("remarks_2", device.getRemarks_2());
			}
			if( device.getOtherAttribute_3() != null && !"".equals(device.getOtherAttribute_3())){
			
				map.put("otherAttribute_3", device.getOtherAttribute_3());
			}
			
			if( device.getOtherInfo_3() != null && !"".equals(device.getOtherInfo_3())){
				//map.put("otherInfo_3", device.getOtherInfo_3());
				
				String sql_otherInfo3 ="";
				String[] arr_otherInfo3 = device.getOtherInfo_3().split(", ");
				for(int i=0; i<arr_otherInfo3.length; i++){//最后拼接得到的SQL如：sql_otherInfo2 = "t.OTHERINFO_2 like '%01%' or t.OTHERINFO_2 like '%02%'";只要数据库里含用户所选的一项，都要选出来
					if(i == 0){
						sql_otherInfo3 += "t.OTHERINFO_3 like " + "'%" + arr_otherInfo3[i] + "%'";
					}else{
						sql_otherInfo3 += " or " +  "t.OTHERINFO_3 like  " + "'%" + arr_otherInfo3[i] + "%'";
					}
				}
				map.put("otherInfo_3", sql_otherInfo3 );
			}
			
			if( device.getDeviceModel() != null && !"".equals(device.getDeviceModel())){
				
				map.put("deviceModel", device.getDeviceModel());
			}
			if( device.getOtherAttribute_1() != null && !"".equals(device.getOtherAttribute_1())){
			
				map.put("otherAttribute_1", device.getOtherAttribute_1());
			}
			if( device.getDeviceState() != null && !"".equals(device.getDeviceState())){
				
				map.put("deviceState", device.getDeviceState());
			}
			if( device.getOtherAttribute_4() != null && !"".equals(device.getOtherAttribute_4())){
				
				map.put("otherAttribute_4", device.getOtherAttribute_4());
			}
			if( device.getOtherInfo_4() != null && !"".equals(device.getOtherInfo_4())){
				//map.put("otherInfo_4", device.getOtherInfo_4());
				
				String sql_otherInfo4 ="";
				String[] arr_otherInfo4 = device.getOtherInfo_4().split(", ");
				for(int i=0; i<arr_otherInfo4.length; i++){//最后拼接得到的SQL如：sql_otherInfo2 = "t.OTHERINFO_2 like '%01%' or t.OTHERINFO_2 like '%02%'";只要数据库里含用户所选的一项，都要选出来
					if(i == 0){
						sql_otherInfo4 += "t.OTHERINFO_4 like  " + "'%" + arr_otherInfo4[i] + "%'";
					}else{
						sql_otherInfo4 += " or " +  "t.OTHERINFO_4 like  " + "'%" + arr_otherInfo4[i] + "%'";
					}
				}
				map.put("otherInfo_4", sql_otherInfo4 );
				
			}
			
			//内存
			if( device.getMemoryMin() != null && !"".equals(device.getMemoryMin())){
				map.put("memoryMin", device.getMemoryMin());
			}
			if( device.getMemoryMax() != null && !"".equals(device.getMemoryMax())){
				map.put("memoryMax", device.getMemoryMax());
			}
			//硬盘
			if( device.getHardDiskMin() != null && !"".equals(device.getHardDiskMin())){
				map.put("hardDiskMin", device.getHardDiskMin());
			}
			if( device.getHardDiskMax() != null && !"".equals(device.getHardDiskMax())){
				map.put("hardDiskMax", device.getHardDiskMax());
			}
			//内置软件版本
			if( device.getSoftwareVersion() != null && !"".equals(device.getSoftwareVersion())){
				map.put("softwareVersion", device.getSoftwareVersion());
			}
			//IE版本
			if( device.getIeVersion() != null && !"".equals(device.getIeVersion())){
				map.put("ieVersion", device.getIeVersion());
			}
			//用途
			if( device.getUseful() != null && !"".equals(device.getUseful())){
				//map.put("useful", device.getUseful());
				
				String sql_useful ="";
				String[] arr_useful = device.getUseful().split(", ");
				for(int i=0; i<arr_useful.length; i++){//最后拼接得到的SQL如：sql_otherInfo2 = "t.OTHERINFO_2 like '%01%' or t.OTHERINFO_2 like '%02%'";只要数据库里含用户所选的一项，都要选出来
					if(i == 0){
						sql_useful += "t.USEFUL like  " + "'%" + arr_useful[i] + "%'";
					}else{
						sql_useful += " or " +  "t.USEFUL like  " + "'%" + arr_useful[i] + "%'";
					}
				}
				map.put("useful", sql_useful );
			}
			//安装的插件
			if( device.getPlugIn() != null && !"".equals(device.getPlugIn())){
				//map.put("plugIn", device.getPlugIn());
				
				String sql_plugIn ="";
				String[] arr_plugIn = device.getPlugIn().split(", ");
				for(int i=0; i<arr_plugIn.length; i++){//最后拼接得到的SQL如：sql_otherInfo2 = "t.OTHERINFO_2 like '%01%' or t.OTHERINFO_2 like '%02%'";只要数据库里含用户所选的一项，都要选出来
					if(i == 0){
						sql_plugIn += "t.PLUGIN like  " + "'%" + arr_plugIn[i] + "%'";
					}else{
						sql_plugIn += " or " +  "t.PLUGIN like  " + "'%" + arr_plugIn[i] + "%'";
					}
				}
				map.put("plugIn", sql_plugIn );
			}
			//对应的外设
			if( device.getPeripheral() != null && !"".equals(device.getPeripheral())){
				//map.put("peripheral", device.getPeripheral());
				
				String sql_peripheral ="";
				String[] arr_peripheral = device.getPeripheral().split(", ");
				for(int i=0; i<arr_peripheral.length; i++){//最后拼接得到的SQL如：sql_otherInfo2 = "t.OTHERINFO_2 like '%01%' or t.OTHERINFO_2 like '%02%'";只要数据库里含用户所选的一项，都要选出来
					if(i == 0){
						sql_peripheral += "t.PERIPHERAL like  " + "'%" + arr_peripheral[i] + "%'";
					}else{
						sql_peripheral += " or " +  "t.PERIPHERAL like  " + "'%" + arr_peripheral[i] + "%'";
					}
				}
				map.put("peripheral", sql_peripheral );
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
		detail.setOtherAttribute_1(device.getOtherAttribute_1());
		detail.setOtherAttribute_2(device.getOtherAttribute_2());
		detail.setOtherAttribute_3(device.getOtherAttribute_3());
		detail.setOtherAttribute_4(device.getOtherAttribute_4());
		detail.setOtherAttribute_5(device.getOtherAttribute_5());
		detail.setOtherInfo_1(device.getOtherInfo_1());
		detail.setOtherInfo_2(device.getOtherInfo_2());
		detail.setOtherInfo_3(device.getOtherInfo_3());
		detail.setOtherInfo_4(device.getOtherInfo_4());
		detail.setOtherInfo_5(device.getOtherInfo_5());
		detail.setRemarks_1(device.getRemarks_1());
		detail.setRemarks_2(device.getRemarks_2());
		detail.setRemarks_3(device.getRemarks_3());
		detail.setRemarks_4(device.getRemarks_4());
		detail.setRemarks_5(device.getRemarks_5());
		detail.setOrgcode(device.getOrgcode());
		detail.setDeviceState(device.getDeviceState());
		
		deviceManDetailDAO.insert(detail);
	}

	@Override
	public void delete(String deviceIds) {
		String[] deviceIdsArr=deviceIds.split(",");
		Long deviceId ;
		for(int i=0; i<deviceIdsArr.length; i++){
			deviceId = Long.valueOf(deviceIdsArr[i]);
			deviceManagementDAO.deleteByPrimaryKey(deviceId);
			
			//同时删除明细表记录
			DeviceDetail detail = new DeviceDetail();
			detail.setDeviceId(deviceId);
			deviceManDetailDAO.delete(detail);
		}
	}

	@Override
	public int queryOrg(String orgcode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgcode", orgcode);
		int count = deviceManagementDAO.queryOrg(map);
		return count;
	}

	//该方法没有调用到，留着仅供参考
	@Override
	public String importExcel(String filePath, String entityType) throws  Exception{
		ExcelTemplate template=new ExcelTemplate();
		List[] devicess =  template.importData(filePath, entityType, 5000);
		List devices;
		if(devicess.length == 1){
			devices = devicess[0];
		}else {
			return "false";
		}
		DevicePo device;
		for(int i=0; i<devices.size(); i++){
			device = (DevicePo) devices.get(i);
			deviceManagementDAO.insert(device);
		}
		return "true";
	}

	@Override
	public List queryOrgList() {
		List list = deviceManagementDAO.queryOrgList();
		return list;
	}

	@Override
	public List<DevicePo> deviceList(DevicePo device) {
		Map<String, Object> map = new HashMap<String, Object>();
		List list = deviceManagementDAO.deviceList(map);
		return list;
	}
//	查询设备型号
	@Override
	public List<DevicePo> queryType(String deviceName) {
		Map<String, String> map =new HashMap<String, String>();
		if (deviceName !=null&&!"".equals(deviceName)) {
			map.put("deviceName", deviceName);
		}
		List list  =deviceManagementDAO.queryType(map);
		return list;
	}

	
}
