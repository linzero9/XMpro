package com.gotop.deviceManagement.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import com.fr.third.org.apache.poi.hssf.usermodel.HSSFCell;
import com.fr.third.org.apache.poi.hssf.usermodel.HSSFRow;
import com.fr.third.org.apache.poi.hssf.usermodel.HSSFSheet;
import com.fr.third.org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.fr.third.org.apache.poi.poifs.filesystem.POIFSFileSystem;
import com.gotop.crm.util.BaseAction;
import com.gotop.deviceManagement.model.DeviceDetail;
import com.gotop.deviceManagement.model.DevicePo;
import com.gotop.deviceManagement.service.IDeviceManDetailService;
import com.gotop.deviceManagement.service.IDeviceManagementService;
import com.gotop.util.Struts2Utils;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.ext.access.http.IUploadFile;

public class DeviceManagementAction  extends BaseAction {

	private static final long serialVersionUID = 1L;
	private DevicePo device;
	private List<DevicePo> devices;
	private DeviceDetail detail;
	private List<DeviceDetail> details;
	private IUploadFile dictItemFile;
	private HashMap<String,Object> map; 

	protected IDeviceManagementService deviceManagermentService;
	protected IDeviceManDetailService deviceManDetailService;
	public DevicePo getDevice() {
		return device;
	}

	public void setDevice(DevicePo device) {
		this.device = device;
	}

	public List<DevicePo> getDevices() {
		return devices;
	}

	public void setDevices(List<DevicePo> devices) {
		this.devices = devices;
	}

	public DeviceDetail getDetail() {
		return detail;
	}

	public void setDetail(DeviceDetail detail) {
		this.detail = detail;
	}

	public List<DeviceDetail> getDetails() {
		return details;
	}

	public void setDetails(List<DeviceDetail> details) {
		this.details = details;
	}
	

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}

	public IDeviceManagementService getDeviceManagermentService() {
		return deviceManagermentService;
	}

	public void setDeviceManagermentService(
			IDeviceManagementService deviceManagermentService) {
		this.deviceManagermentService = deviceManagermentService;
	}
	
	public IDeviceManDetailService getDeviceManDetailService() {
		return deviceManDetailService;
	}

	public void setDeviceManDetailService(
			IDeviceManDetailService deviceManDetailService) {
		this.deviceManDetailService = deviceManDetailService;
	}
	
	public IUploadFile getDictItemFile() {
		return dictItemFile;
	}

	public void setDictItemFile(IUploadFile dictItemFile) {
		this.dictItemFile = dictItemFile;
	}

	public String deviceList(){

    	if(device == null){
    		device = new DevicePo();
    	}
    	
    	devices = deviceManagermentService.deviceList(device,this.getPage());
    	this.setDevices(devices);
    	return "deviceList";
    }
	
	public String detailList(){
    	details = deviceManDetailService.detailList(detail, this.getPage());
    	this.setDetails(details);
    	return "detailList";
    }
	
	//设备列表 导出Excel
	public String exportExcel(){
		
    	if(device == null){
    		device = new DevicePo();
    	}
    	
    	devices = deviceManagermentService.deviceList(device,null);
    	this.setDevices(devices);
    	return "exportExcel";
    }
	
	//设备明细列表 导出Excel
	public String exportExcel2(){
		
   if(detail == null){
    		detail = new DeviceDetail();
    	}
    	details = deviceManDetailService.detailList(detail, null);
    	this.setDetails(details);
    	return "exportExcel2";
    }
	
	public String toDevice(){
    	if(device != null){
    		device = deviceManagermentService.getDeviceByDeviceId(device);
    	}
    	this.setDevice(device);
    	return "device";
    }
	
	public void save() throws Exception{
    	String info ="success";
    	try {
    		MUOUserSession muoUserSession = getCurrentOnlineUser();
    		this.deviceManagermentService.save(device, muoUserSession);
    	} catch (Exception e) {
			info="fails";
			log.error("[保存设备信息失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
    }
	
	public void delete() throws Exception{
    	String info ="success";
    	try {
    		this.deviceManagermentService.delete(device);
    	} catch (Exception e) {
			info="fails";
			log.error("[删除设备信息失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
    }
	
	//导入Excel
		public String importExcel() throws IOException{
				
		    	String filePath = dictItemFile.getFilePath();
		    	
		    	//返回JSP页面map
				map = new HashMap<String,Object>();
				//传入数据库的map
//				HashMap<String,Object> tmp_map =  new HashMap<String,Object>();
				String msg="";
				int sumnum=0;
				int failnum=0;
				
				//打开文件
				FileInputStream fileInputStream = new FileInputStream(filePath);
				POIFSFileSystem fs =new POIFSFileSystem(fileInputStream);
		        HSSFWorkbook wb = new HSSFWorkbook(fs);
				HSSFSheet sheet = wb.getSheetAt(0);
				//文件的行数
				int rows = sheet.getPhysicalNumberOfRows();
				map.put("all_num", rows-1);
				//遍历行数，读取数据
				for(int i=1; i<rows; i++){
					HSSFRow row = sheet.getRow(i);
					HSSFCell cell_orgcode = row.getCell((short)0);
					String orgcode =getCellValue(cell_orgcode);
//					tmp_map.put("orgname", orgname);
					Object[] orgs = deviceManagermentService.queryOrg(orgcode);
					if(null==orgs || orgs.length==0){
						msg+="机构/部门："+orgcode+"不存在。||";
						map.put("msg", msg);
						failnum++;
						continue;
					}
					
					device.setOrgcode(orgcode);
					device.setDeviceName(getCellValue(row.getCell((short)1)));
					device.setDeviceModel(getCellValue(row.getCell((short)2)));
					device.setIpAdress(getCellValue(row.getCell((short)3)));
					device.setProductionMachineName(getCellValue(row.getCell((short)4)));
					device.setCpuCode(getCellValue(row.getCell((short)5)));
					device.setMemory(getCellValue(row.getCell((short)6)));
					device.setHardDisk(getCellValue(row.getCell((short)7)));
					device.setOsVersion(getCellValue(row.getCell((short)8)));
					device.setSoftwareVersion(getCellValue(row.getCell((short)9)));
					device.setIeVersion(getCellValue(row.getCell((short)10)));
					device.setUseful(getCellValue(row.getCell((short)11)));
					device.setTerminalNumber(getCellValue(row.getCell((short)12)));
					device.setUser(getCellValue(row.getCell((short)13)));
					device.setPlugIn(getCellValue(row.getCell((short)14)));
					device.setPeripheral(getCellValue(row.getCell((short)15)));
					device.setOtherOne(getCellValue(row.getCell((short)16)));
					device.setOtherInfoOne(getCellValue(row.getCell((short)17)));
					device.setRemarksOne(getCellValue(row.getCell((short)18)));
					device.setDeviceState(getCellValue(row.getCell((short)19)));
					
					//插入数据
					try{
						deviceManagermentService.import_insert(device);
						sumnum++;
					}catch(Exception e){
						failnum++;
						msg+="插入第"+i+"行数据时失败。||";
					}
				}
				map.put("msg", msg);
				map.put("sumnum", sumnum);
				map.put("failnum", failnum);
				fileInputStream.close();
//				return map;
				this.setMap(map);
				
				//删除指定路径的内容,指定路径可以是文件或目录
				MyUtil.delete(filePath);
			    
		    	return "importExcel";
		 }
		
		//返回列值
			public String getCellValue(HSSFCell cell1){
				switch(cell1.getCellType()){
					case HSSFCell.CELL_TYPE_NUMERIC:
						DecimalFormat df = new DecimalFormat("#.##");
						return String.valueOf(df.format(cell1.getNumericCellValue()));
					case HSSFCell.CELL_TYPE_STRING:
						return cell1.getStringCellValue();
					default:
						return "输入格式出错！";
				}
			}

}
