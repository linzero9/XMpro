package com.gotop.deviceManagement.action;

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
		    	
		    	//返回JSP页面mapa
				HashMap<String,Object> map = new HashMap<String,Object>();
				//传入数据库的map
				HashMap<String,Object> tmp_map =  new HashMap<String,Object>();
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
					HSSFCell cell_orgname = row.getCell((short)0);
					String orgname =getCellValue(cell_orgname);
					tmp_map.put("orgname", orgname);
					Object[] orgs = deviceManagermentService.queryOrg(orgname);
					if(null==orgs || orgs.length==0){
						msg+="机构/部门："+orgname+"不存在。||";
						map.put("msg", msg);
						failnum++;
						continue;
					}
					
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
				map.put("imp_flag", "1");
				fileInputStream.close();
//				return map;
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
