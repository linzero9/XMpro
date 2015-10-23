package com.gotop.deviceManagement.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import com.fr.third.org.apache.poi.hssf.record.formula.functions.Trim;
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

public class DeviceManagementAction  extends BaseAction {

	private static final long serialVersionUID = 1L;
	private DevicePo device;
	private List<DevicePo> devices;
	private DeviceDetail detail;
	private List<DeviceDetail> details;
	private File readFile;
	private HashMap<String,Object> map; 
	private String orgcodeTemp;
	


	public String getOrgcodeTemp() {
		return orgcodeTemp;
	}

	public void setOrgcodeTemp(String orgcodeTemp) {
		this.orgcodeTemp = orgcodeTemp;
	}



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
	

	public File getReadFile() {
		return readFile;
	}

	public void setReadFile(File readFile) {
		this.readFile = readFile;
	}
	//输出统计
	public String sumUpDevice(){

    	if(device == null){
    		device = new DevicePo();
    	}
    	
    	  MUOUserSession muo=getCurrentOnlineUser();
    	  orgcodeTemp = muo.getOrgcode();
    	  
    	devices = deviceManagermentService.sumUpDevicePos(device,orgcodeTemp,this.getPage());
    	this.setDevices(devices);
    	return "sumUpDeviceList";
		
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
		if(detail == null){
			detail = new DeviceDetail();
    	}
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
    		device.setDeviceState("0"); //新增设备时默认设状态为可用（即为0）
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
		public String importExcel() throws Exception {
				
		    	String filePath = readFile.getPath();
		    	System.out.println(filePath);
		    	
		    	//返回JSP页面map
				map = new HashMap<String,Object>();
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
				int all_num = rows-1;//总共导入数据的行数
				//遍历行数，读取数据
				for(int i=1; i<rows; i++){
					HSSFRow row = sheet.getRow(i);
					if (row != null) {
						//判断如果整行单元格都为空，则不插入
						boolean allowInsert = false;
						int cells = row.getPhysicalNumberOfCells();
						for (int c = 0; c < cells; c++) {
							HSSFCell cell = row.getCell(c);
							if (cell.getCellType() != HSSFCell.CELL_TYPE_BLANK) {
								allowInsert = true;		
								break;//结束for循环语句,跳出
							} 
						}
						
						if(allowInsert == false){
							all_num--;
							continue;//跳到excel表格的下一行进行判断
						}
						HSSFCell cell_orgcode = row.getCell((short)0);
						String orgcode =getCellValue(cell_orgcode).trim();
						if ("".equals(orgcode) || orgcode == null){
							msg+="第"+i+"行数据，机构/部门不能为空。||";
							map.put("msg", msg);
							failnum++;
							continue;
						}
						int  count= deviceManagermentService.queryOrg(orgcode);
						if(count==0){
							msg+="第"+i+"行数据，机构/部门("+orgcode+")不存在。||";
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						device = new DevicePo();
						device.setOrgcode(orgcode);
						device.setDeviceName(getCellValue(row.getCell((short)1)).trim());
						device.setDeviceModel(getCellValue(row.getCell((short)2)).trim());
						device.setIpAdress(getCellValue(row.getCell((short)3)).trim());
						device.setProductionMachineName(getCellValue(row.getCell((short)4)).trim());
						device.setCpuCode(getCellValue(row.getCell((short)5)).trim());
						device.setMemory(getCellValue(row.getCell((short)6)).trim());
						device.setHardDisk(getCellValue(row.getCell((short)7)).trim());
						device.setOsVersion(getCellValue(row.getCell((short)8)).trim());
						device.setSoftwareVersion(getCellValue(row.getCell((short)9)).trim());
						device.setIeVersion(getCellValue(row.getCell((short)10)).trim());
						device.setUseful(getCellValue(row.getCell((short)11)).trim());
						device.setTerminalNumber(getCellValue(row.getCell((short)12)).trim());
						device.setUser(getCellValue(row.getCell((short)13)).trim());
						device.setPlugIn(getCellValue(row.getCell((short)14)).trim());
						device.setPeripheral(getCellValue(row.getCell((short)15)).trim());
						device.setOtherAttribute_1(getCellValue(row.getCell((short)16)).trim());
						device.setOtherAttribute_2(getCellValue(row.getCell((short)17)).trim());
						device.setOtherAttribute_3(getCellValue(row.getCell((short)18)).trim());
						device.setOtherAttribute_4(getCellValue(row.getCell((short)19)).trim());
						device.setOtherAttribute_5(getCellValue(row.getCell((short)20)).trim());
						device.setOtherInfo_1(getCellValue(row.getCell((short)21)).trim());
						device.setOtherInfo_2(getCellValue(row.getCell((short)22)).trim());
						device.setOtherInfo_3(getCellValue(row.getCell((short)23)).trim());
						device.setOtherInfo_4(getCellValue(row.getCell((short)24)).trim());
						device.setOtherInfo_5(getCellValue(row.getCell((short)25)).trim());
						device.setRemarks_1(getCellValue(row.getCell((short)26)).trim());
						device.setRemarks_2(getCellValue(row.getCell((short)27)).trim());
						device.setRemarks_3(getCellValue(row.getCell((short)28)).trim());
						device.setRemarks_4(getCellValue(row.getCell((short)29)).trim());
						device.setRemarks_5(getCellValue(row.getCell((short)30)).trim());
						device.setDeviceState(getCellValue(row.getCell((short)31)).trim());
						
						MUOUserSession muoUserSession = getCurrentOnlineUser();
						
						//插入数据
						try{
							this.deviceManagermentService.save(device, muoUserSession);
							sumnum++;
						}catch(Exception e){
							failnum++;
							msg+="插入第"+i+"行数据时失败。||";
						}
					}
				}
				map.put("imp_flag", "1");
				map.put("msg", msg);
				map.put("all_num", all_num);
				map.put("sumnum", sumnum);
				map.put("failnum", failnum);
				fileInputStream.close();
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
	case HSSFCell.CELL_TYPE_BLANK:
						return "";
					default:
						return "输入格式错误";
				}
			}

}
