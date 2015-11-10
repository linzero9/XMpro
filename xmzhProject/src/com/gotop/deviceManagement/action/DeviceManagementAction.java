package com.gotop.deviceManagement.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import sun.awt.geom.AreaOp.SubOp;

import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;

import org.apache.derby.tools.sysinfo;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.CellRangeAddressList;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFDataValidation;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.hssf.util.CellRangeAddressList;


import com.fr.report.core.A.E;
import com.fr.report.core.A.T;
import com.fr.third.org.apache.poi.hssf.record.cf.CellRange;

import com.fr.third.org.apache.poi.hssf.record.formula.functions.Trim;
import com.fr.third.org.apache.poi.hssf.usermodel.HSSFCell;
import com.fr.third.org.apache.poi.hssf.usermodel.HSSFRow;
import com.fr.third.org.apache.poi.hssf.usermodel.HSSFSheet;
import com.fr.third.org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.fr.third.org.apache.poi.poifs.filesystem.POIFSFileSystem;
import com.gotop.crm.util.BaseAction;
import com.gotop.deviceManagement.model.DeviceDetail;
import com.gotop.deviceManagement.model.DevicePo;

import com.gotop.deviceManagement.model.Sum;

import com.gotop.deviceManagement.model.Org;

import com.gotop.deviceManagement.service.IDeviceManDetailService;
import com.gotop.deviceManagement.service.IDeviceManagementService;
import com.gotop.dict.model.EosDictEntry;
import com.gotop.dict.service.IEosDictEntryService;
import com.gotop.util.Struts2Utils;
import com.gotop.util.time.TimeUtil;
import com.gotop.vo.system.MUOUserSession;

public class DeviceManagementAction  extends BaseAction    {

	private static final long serialVersionUID = 1L;
	private DevicePo device;
	private List<DevicePo> devices;
	private DeviceDetail detail;
	private List<DeviceDetail> details;
	private String deviceIds;
	private String importExcelFlag;
	private File readFile;
	private HashMap<String,Object> map; 
	private String orgcodeTemp;
	private Sum sum;
	private List<Sum> sums;
	
	public String getImportExcelFlag() {
		return importExcelFlag;
	}

	public void setImportExcelFlag(String importExcelFlag) {
		this.importExcelFlag = importExcelFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Sum getSum() {
		return sum;
	}

	public void setSum(Sum sum) {
		this.sum = sum;
	}

	public List<Sum> getSums() {
		return sums;
	}

	public void setSums(List<Sum> sums) {
		this.sums = sums;
	}

	public String getOrgcodeTemp() {
		return orgcodeTemp;
	}

	public void setOrgcodeTemp(String orgcodeTemp) {
		this.orgcodeTemp = orgcodeTemp;
	}



	protected IDeviceManagementService deviceManagermentService;
	protected IDeviceManDetailService deviceManDetailService;
	protected IEosDictEntryService eosDictEntryService;
	
	public String getDeviceIds() {
		return deviceIds;
	}

	public void setDeviceIds(String deviceIds) {
		this.deviceIds = deviceIds;
	}

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
	

	public IEosDictEntryService getEosDictEntryService() {
		return eosDictEntryService;
	}

	public void setEosDictEntryService(IEosDictEntryService eosDictEntryService) {
		this.eosDictEntryService = eosDictEntryService;
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
	public String toImportExcel(){
		return "importExcel";
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
	
	//设备列表 导出Excel 数量统计
		public String exportExcelsumUp(){
			
	    	if(device == null){
	    		device = new DevicePo();
	    	}
	    	  MUOUserSession muo=getCurrentOnlineUser();
	    	  orgcodeTemp = muo.getOrgcode();
	    	  devices = deviceManagermentService.sumUpDevicePos(device,orgcodeTemp,this.getPage());
	    	//this.setSums(devices);
	    	this.setDevices(devices);
	    	return "exportExcelsumUp";
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
    		device.setIpAdress(device.getIpAdress().trim());
    		device.setProductionMachineName(device.getProductionMachineName().trim());
    		device.setCpuCode(device.getCpuCode().trim());
    		device.setMemory(device.getMemory().trim());
    		device.setHardDisk(device.getHardDisk().trim());
    		device.setSoftwareVersion(device.getSoftwareVersion().trim());
    		device.setTerminalNumber(device.getTerminalNumber().trim());
    		device.setUser(device.getUser().trim());
    		device.setRemarks_1(device.getRemarks_1().trim());
    		device.setRemarks_2(device.getRemarks_2().trim());
    		device.setRemarks_3(device.getRemarks_3().trim());
    		device.setRemarks_4(device.getRemarks_4().trim());
    		device.setRemarks_5(device.getRemarks_5().trim());
    		this.deviceManagermentService.save(device, muoUserSession);
    	} catch (Exception e) {
			info="fails";
			log.error("[保存设备信息失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
    }
	
	public void delete() throws Exception{
    	String info ="success";
    	try {
    		this.deviceManagermentService.delete(deviceIds);
    	} catch (Exception e) {
			info="fails";
			log.error("[删除设备信息失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
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
				HSSFSheet sheet = wb.getSheetAt(0);  //得到第一个Sheet
				
				
				//文件的行数
				int rows = sheet.getPhysicalNumberOfRows();
				int all_num = rows-2;//总共导入的数据的行数(2：表示第一行的提醒行和第二行的标题行）
				//遍历行数，读取数据
				for(int i=2; i<rows; i++){//i=2表示第三行 开始
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
						device = new DevicePo();
						short column = 0;
						if(importExcelFlag.equals("batchUpdate") ){
							column = 1;
							String deviceId = getCellValue(row.getCell((short)0)).trim();
							if ("".equals(deviceId) || deviceId == null){
								msg+="第"+(i+1)+"行，设备ID不能为空。||";
								map.put("msg", msg);
								failnum++;
								continue;
							}
							DevicePo device1 = new DevicePo();
							device1.setDeviceId(Long.valueOf(deviceId));
							DevicePo device2 = deviceManagermentService.getDeviceByDeviceId(device1);
							if(device2 == null){
								msg+="第"+(i+1)+"行无法插入，无法找到设备ID("+deviceId+")对应的记录。提醒：设备ID不可修改！||";
								map.put("msg", msg);
								failnum++;
								continue;
							}
							device.setDeviceId(Long.valueOf(deviceId));
						}
				//校验数据输入的正确性，不通过则不做插入操作
						String orgcode =getCellValue(row.getCell(column)).trim();
						if ("".equals(orgcode) || orgcode == null){
							msg+="第"+(i+1)+"行，机构号不能为空。||";
							map.put("msg", msg);
							failnum++;
							continue;
						}
						int  count= deviceManagermentService.queryOrg(orgcode);
						if(count==0){
							msg+="第"+(i+1)+"行无法插入，机构号("+orgcode+")不存在。请检查值是否输错或书写格式错误！||";
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String deviceName = getCellValue(row.getCell(column+1)).trim();
						HashMap infoMap = checkData_singleSelect("DEVICE_NAME", deviceName, "设备名称", i, msg);
						boolean flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg",msg);
							failnum++;
							continue;
						}
						
						String deviceModel = getCellValue(row.getCell(column+2)).trim();
						infoMap = checkData_singleSelect("DEVICE_MODEL", deviceModel, "型号", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg",msg);
							failnum++;
							continue;
						}
						
						String ipAdress = getCellValue(row.getCell(column+3)).trim();
						Pattern pattern = null;
						Matcher matcher = null;
						if(!"".equals(ipAdress)){
							pattern = Pattern.compile("\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
							matcher = pattern.matcher(ipAdress); 
							flag= matcher.matches(); 
							if(!flag){
								msg+="第"+(i+1)+"行无法插入，IP地址("+ipAdress+")不符合格式。请输入规范的IP地址！||";
								map.put("msg", msg);
								failnum++;
								continue;
							}
						}
						
						String productionMachineName = getCellValue(row.getCell(column+4)).trim();
						infoMap = checkData_maxLength(productionMachineName, "生产机器名称", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String cpuCode = getCellValue(row.getCell(column+5)).trim();
						infoMap = checkData_maxLength(cpuCode, "CPU型号", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String memory = getCellValue(row.getCell(column+6)).trim();
						if(!"".equals(memory)){
							//正则表达式校验最大只能输入两位小数的正实数
							pattern = Pattern.compile("^[0-9]+(.[0-9]{1,2})?$"); 
							matcher = pattern.matcher(memory); 
							flag= matcher.matches(); 
							if(!flag){
								msg+="第"+(i+1)+"行无法插入，内存容量（G）("+memory+")不符合数据格式。请输入数字，小数位不超过两位！||";
								map.put("msg", msg);
								failnum++;
								continue;
							}
						}
						
						String hardDisk = getCellValue(row.getCell(column+7)).trim();
						if(!"".equals(hardDisk)){
							//正则表达式校验最大只能输入两位小数的正实数
							pattern = Pattern.compile("^[0-9]+(.[0-9]{1,2})?$"); 
							matcher = pattern.matcher(hardDisk); 
							flag= matcher.matches(); 
							if(!flag){
								msg+="第"+(i+1)+"行无法插入，硬盘容量（G）("+hardDisk+")不符合数据格式。请输入数字，小数位不超过两位！||";
								map.put("msg", msg);
								failnum++;
								continue;
							}
						}
						
						String osVersion = getCellValue(row.getCell(column+8)).trim();
						infoMap = checkData_singleSelect("DEVICE_OS_VERSION", osVersion, "操作系统版本", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String softwareVersion = getCellValue(row.getCell(column+9)).trim();
						infoMap = checkData_maxLength(softwareVersion, "内置软件版本", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						
						String ieVersion = getCellValue(row.getCell(column+10)).trim();
						infoMap = checkData_singleSelect("DEVICE_IE_VERSION", ieVersion, "IE版本", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String useful = getCellValue(row.getCell(column+11)).trim();
						infoMap = checkData_multiSelect("DEVICE_USEFUL",useful , "用途", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						useful =replace_separator(useful);
						
						String terminalNumber = getCellValue(row.getCell(column+12)).trim();
						infoMap = checkData_maxLength(terminalNumber, "终端号", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String user = getCellValue(row.getCell(column+13)).trim();
						infoMap = checkData_maxLength(user, "使用人", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String plugIn = getCellValue(row.getCell(column+14)).trim();
						infoMap = checkData_multiSelect("DEVICE_PLUGIN",plugIn , "安装的插件", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						plugIn = replace_separator(plugIn);
						
						String peripheral = getCellValue(row.getCell(column+15)).trim();
						infoMap = checkData_multiSelect("DEVICE_PERIPHERAL",peripheral , "对应的外设", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						peripheral = replace_separator(peripheral);
						
						String otherAttribute_1 = getCellValue(row.getCell(column+16)).trim();
						infoMap = checkData_singleSelect("DEVICE_OTHERATTRIBUTE_1", otherAttribute_1, "其他属性1", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String otherAttribute_2 = getCellValue(row.getCell(column+17)).trim();
						infoMap = checkData_singleSelect("DEVICE_OTHERATTRIBUTE_2", otherAttribute_2, "其他属性2", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String otherAttribute_3 = getCellValue(row.getCell(column+18)).trim();
						infoMap = checkData_singleSelect("DEVICE_OTHERATTRIBUTE_3", otherAttribute_3, "其他属性3", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String otherAttribute_4 = getCellValue(row.getCell(column+19)).trim();
						infoMap = checkData_singleSelect("DEVICE_OTHERATTRIBUTE_4", otherAttribute_4, "其他属性4", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String otherAttribute_5 = getCellValue(row.getCell(column+20)).trim();
						infoMap = checkData_singleSelect("DEVICE_OTHERATTRIBUTE_5", otherAttribute_5, "其他属性5", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String otherInfo_1 = getCellValue(row.getCell(column+21)).trim();
						infoMap = checkData_multiSelect("DEVICE_OTHERINFO_1",otherInfo_1 , "其他信息1", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						otherInfo_1 =  replace_separator(otherInfo_1);
						
						String otherInfo_2 = getCellValue(row.getCell(column+22)).trim();
						infoMap = checkData_multiSelect("DEVICE_OTHERINFO_2",otherInfo_2 , "其他信息2", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						otherInfo_2 = replace_separator(otherInfo_2);
						
						String otherInfo_3 = getCellValue(row.getCell(column+23)).trim();
						infoMap = checkData_multiSelect("DEVICE_OTHERINFO_3",otherInfo_3 , "其他信息3", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						otherInfo_3 = replace_separator(otherInfo_3);
						
						String otherInfo_4 = getCellValue(row.getCell(column+24)).trim();
						infoMap = checkData_multiSelect("DEVICE_OTHERINFO_4",otherInfo_4 , "其他信息4", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						otherInfo_4 = replace_separator(otherInfo_4);
						
						String otherInfo_5 = getCellValue(row.getCell(column+25)).trim();
						infoMap = checkData_multiSelect("DEVICE_OTHERINFO_5",otherInfo_5 , "其他信息5", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						otherInfo_5 = replace_separator(otherInfo_5);
						
						String remarks_1 = getCellValue(row.getCell(column+26)).trim();
						infoMap = checkData_maxLength(remarks_1, "备注1", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String remarks_2 = getCellValue(row.getCell(column+27)).trim();
						infoMap = checkData_maxLength(remarks_2, "备注2", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String remarks_3 = getCellValue(row.getCell(column+28)).trim();
						infoMap = checkData_maxLength(remarks_3, "备注3", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String remarks_4 = getCellValue(row.getCell(column+29)).trim();
						infoMap = checkData_maxLength(remarks_4, "备注4", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String remarks_5 = getCellValue(row.getCell(column+30)).trim();
						infoMap = checkData_maxLength(remarks_5, "备注5", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String deviceState = getCellValue(row.getCell(column+31)).trim();
						infoMap = checkData_singleSelect("DEVICE_STATE",deviceState , "设备状态", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						device.setOrgcode(orgcode);
						device.setDeviceName(deviceName);
						device.setDeviceModel(deviceModel);
						device.setIpAdress(ipAdress);
						device.setProductionMachineName(productionMachineName);
						device.setCpuCode(cpuCode);
						device.setMemory(memory);
						device.setHardDisk(hardDisk);
						device.setOsVersion(osVersion);
						device.setSoftwareVersion(softwareVersion);
						device.setIeVersion(ieVersion);
						device.setUseful(useful);
						device.setTerminalNumber(terminalNumber);
						device.setUser(user);
						device.setPlugIn(plugIn);
						device.setPeripheral(peripheral);
						device.setOtherAttribute_1(otherAttribute_1);
						device.setOtherAttribute_2(otherAttribute_2);
						device.setOtherAttribute_3(otherAttribute_3);
						device.setOtherAttribute_4(otherAttribute_4);
						device.setOtherAttribute_5(otherAttribute_5);
						device.setOtherInfo_1(otherInfo_1);
						device.setOtherInfo_2(otherInfo_2);
						device.setOtherInfo_3(otherInfo_3);
						device.setOtherInfo_4(otherInfo_4);
						device.setOtherInfo_5(otherInfo_5);
						device.setRemarks_1(remarks_1);
						device.setRemarks_2(remarks_2);
						device.setRemarks_3(remarks_3);
						device.setRemarks_4(remarks_4);
						device.setRemarks_5(remarks_5);
						device.setDeviceState(deviceState);
						
						MUOUserSession muoUserSession = getCurrentOnlineUser();
						
						//插入数据
						try{
							this.deviceManagermentService.save(device, muoUserSession);
							sumnum++;
						}catch(Exception e){
							failnum++;
							msg+="插入第"+(i+1)+"行时失败。||";
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
		 
		private HashMap checkData_singleSelect(String dictTypeId, String dictId, String colName, int i, String msg){
			
			boolean flag = true;
			HashMap infoMap = new HashMap();
			
			if(!"".equals(dictId)){
				EosDictEntry dictEntry = new EosDictEntry();
				dictEntry.setDictTypeId(dictTypeId);
				dictEntry.setDictId(dictId);
				EosDictEntry eosDictEntry= this.eosDictEntryService.getDictEntryById(dictEntry);
				if(eosDictEntry == null){
					msg+="第"+(i+1)+"行无法插入，"+colName+"("+dictId+")不存在。请检查值是否输错或书写格式错误！||";
					flag = false;
				}
			}
			infoMap.put("flag", flag);
			infoMap.put("msg", msg);
			return infoMap;
			
		}
		
private HashMap checkData_maxLength(String str, String colName, int i, String msg){
			
			boolean flag = true;
			HashMap infoMap = new HashMap();
			System.out.println(str.length() );
			if(str.length() >127){
				msg+="第"+(i+1)+"行无法插入，"+colName+" 输入最大长度不超过127！||";
				flag = false;
			}
			infoMap.put("flag", flag);
			infoMap.put("msg", msg);
			return infoMap;
			
		}
		
		private HashMap checkData_multiSelect(String dictTypeId, String dictId, String colName, int i, String msg){
			
			boolean flag = true;
			HashMap infoMap = new HashMap();
			
			if(!"".equals(dictId) ){
				String[] dictIds = dictId.split(",");   //用 逗号空格 
				EosDictEntry dictEntry = new EosDictEntry();
				String str1=dictId.substring(dictId.length()-1,dictId.length());
				if(",".equals(str1)){
					msg+="第"+(i+1)+"行无法插入，"+colName+"("+dictId+")书写格式错误！||";
					flag = false;
				}else{
					
					for(int j=0; j<dictIds.length; j++){
						
						dictEntry.setDictTypeId(dictTypeId);
						dictEntry.setDictId(dictIds[j]);
						EosDictEntry eosDictEntry= this.eosDictEntryService.getDictEntryById(dictEntry);
						if(eosDictEntry == null){
							msg+="第"+(i+1)+"行无法插入，"+colName+"("+dictIds[j]+")不存在。请检查值是否输错或书写格式错误！||";
							flag = false;
							break;
						}
						
					}
				}
				
			}
			infoMap.put("flag", flag);
			infoMap.put("msg", msg);
			return infoMap;
			
		}
		
		private String  replace_separator(String str){
			String newStr = str.replaceAll(",",", ");
			return newStr;
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

			public String excelTemplate() throws Exception{
 		
		    		return "excelTemplate";
			}
			
			public String exportOrgcodeTable() throws Exception{
		 		
	    		return "exportOrgcodeTable";
		    }

			private void createListBox(String[] list,org.apache.poi.hssf.usermodel.HSSFSheet sheet, org.apache.poi.hssf.usermodel.HSSFWorkbook wb, int rownum, int colnum) {
				
				
				try {
					
			
				//生成下拉列表

				//只对（0，0）单元格有效
			
				CellRangeAddressList regions = new CellRangeAddressList(rownum,rownum,colnum,colnum);   //CellRangeAddressList(int firstRow, int lastRow, int firstCol, int lastCol)
				
				//生成下拉框内容
				DVConstraint constraint = DVConstraint.createExplicitListConstraint(list);

				//绑定下拉框和作用区域
				HSSFDataValidation data_validation = new HSSFDataValidation(regions,constraint);

				//对sheet页生效
				sheet.addValidationData(data_validation);

				//结束
				System.out.println("createListBox Over");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			
			
	public String batchUpdateExport() throws Exception{
		
		return "batchUpdateExport";
	}
	
	public String batchUpdateExportAll() throws Exception{
		
		return "batchUpdateExportAll";
	}
	
	public void exportExcelFuntion(String title, String[] headers,   List<DevicePo> dataset) throws Exception{
		List[] lists = new List[19];
		
		//List存放为Org类型
		lists[0] = this.deviceManagermentService.queryOrgList();
		
		//List存放为EosDictEntry类型
		EosDictEntry dictEntry = new EosDictEntry();
		dictEntry.setDictTypeId("DEVICE_NAME");
		lists[1] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_MODEL");
		lists[2] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_OS_VERSION");
		lists[3] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_IE_VERSION");
		lists[4] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_USEFUL");
		lists[5] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_PLUGIN");
		lists[6] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_PERIPHERAL");
		lists[7] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_OTHERATTRIBUTE_1");
		lists[8] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_OTHERATTRIBUTE_2");
		lists[9] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_OTHERATTRIBUTE_3");
		lists[10] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_OTHERATTRIBUTE_4");
		lists[11] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_OTHERATTRIBUTE_5");
		lists[12] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_OTHERINFO_1");
		lists[13] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_OTHERINFO_2");
		lists[14] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_OTHERINFO_3");
		lists[15] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_OTHERINFO_4");
		lists[16] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_OTHERINFO_5");
		lists[17] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		dictEntry.setDictTypeId("DEVICE_STATE");
		lists[18] = this.eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		
		//文件初始化
		org.apache.poi.hssf.usermodel.HSSFWorkbook wb = new org.apache.poi.hssf.usermodel.HSSFWorkbook();// 创建Excel文档 
		org.apache.poi.hssf.usermodel.HSSFSheet sheet = wb.createSheet("设备信息"); // sheet 对应一个工作页
		
		// 获取总列数
		int CountColumnNum = headers.length;
		
		//设定单元格区域范围
		CellRangeAddress cra = new CellRangeAddress(0, 0, 0, CountColumnNum-1) ; //参数为顺序为firstRow, lastRow, firstCol, lastCol
		
		//在Sheet里增加合并单元格
		sheet.addMergedRegion(cra);
		
		// 在第一行单元格合并，显示提醒信息
		org.apache.poi.hssf.usermodel.HSSFRow firstrow = sheet.createRow(0);   // 下标为0的行为第一行
		org.apache.poi.hssf.usermodel.HSSFCell cell = firstrow.createCell(0);  //创建单元格
		
		//设置第一行的行高
		sheet.getRow(0).setHeight((short) (40*20)); 
		
		String str1 = "注意：";
		String str2 = "1. 带“*”的列标题点击可显示 下拉菜单，填写该列单元格时需严格参照 下拉菜单 填写对应的代码；";
		String str3 = "2. 其中“用途”、“安装的插件”、“对应的外设”、“其他信息”对应下拉菜单可填写多个值，请用 英文的 逗号（“,”） 来间隔，除此以外的其他下拉菜单只能对应填写一个值。";
		HSSFRichTextString ts= new HSSFRichTextString(str1+"\n"+str2+"\n"+str3);
		
		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setWrapText(true);//只有设置了它，"\n"才可以换行
		
		//设置注意的提示字体颜色
		HSSFFont font1_1 = wb.createFont();
		font1_1.setColor(HSSFColor.LIGHT_BLUE.index); 
		HSSFFont font1_2 = wb.createFont();
		font1_2.setColor(HSSFColor.RED.index); 
		 ts.applyFont(0,35,font1_1);
		 ts.applyFont(35,52,font1_2);
		 ts.applyFont(52,102,font1_1);
		 ts.applyFont(102,114,font1_2);
		 ts.applyFont(114,ts.length(),font1_1);
		 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		 cell.setCellStyle(style1);
		 cell.setCellValue(ts);  //   "\n"可强制换行
		
		// 在第二行生成列名
		org.apache.poi.hssf.usermodel.HSSFRow secondrow = sheet.createRow(1);   // 下标为1的行为第二行
		org.apache.poi.hssf.usermodel.HSSFCell[] cells= new org.apache.poi.hssf.usermodel.HSSFCell[CountColumnNum];  
        
      //加粗列名
        HSSFFont font2 = wb.createFont();
		HSSFCellStyle style2 = wb.createCellStyle();
		
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  //加粗字体
        style2.setFont(font2);
       style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //字体 左右居中
       style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  //字体 上下居中
       style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); ////设置前景填充样式
       style2.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);  //前景填充色25%灰色
       
        //列名标题行设置格式
        for (int j = 0; j < CountColumnNum; j++) {  
            cells[j] = secondrow.createCell(j);  
            cells[j].setCellValue(new HSSFRichTextString(headers[j]));  
            cells[j].setCellStyle(style2);
            sheet.setColumnWidth(j, 27 * 256);//两个参数：一个是列的索引（从0开始），一个是宽度，第二个参数要乘以256，因为单位是1/256个字符宽度
        }  
        
        sheet.getRow(1).setHeight((short) (20*20));//Height的单位是1/20个点，也可以用sheet.getRow(1).setHeightInPoints(20);
        
        //数据字典生成下拉框内容
        for(List<Object> list : lists){
        	String[] infos = new String[list.size()];
        	int rownum = 1;
        	int colnum = 0;
        	boolean myflag = true;
        	
        	for(Object object : list){
       		System.out.println(object.getClass().getName());
        		System.out.println(list.indexOf(object));
        		if(dataset == null){
            		colnum = 0;
            	}else{
            		colnum = 1;//colnum第0列 被设备ID占用
            	}
        		 if( object.getClass().getName().equals("com.gotop.deviceManagement.model.Org")){
//        			 Org org = (Org)object;
//        			 infos[list.indexOf(org)] = org.getOrgcode()+"--"+org.getOrgname();
//        			 colnum = colnum+0;
        			 myflag = false;
        			 break;
        		 }else if(object.getClass().getName().equals("com.gotop.dict.model.EosDictEntry")){
        			 EosDictEntry entry =  (EosDictEntry)object;
        			 infos[list.indexOf(entry)] = entry.getDictId()+"--"+entry.getDictName();
        			 if( (entry.getDictTypeId()).equals("DEVICE_NAME") ){
        				 colnum = colnum+1;
        			 }else if( (entry.getDictTypeId() ).equals("DEVICE_MODEL") ){
        				 colnum = colnum+2;
        			 }else if( (entry.getDictTypeId() ).equals("DEVICE_OS_VERSION") ){
        				 colnum = colnum+8;
        			 }else if( (entry.getDictTypeId() ).equals("DEVICE_IE_VERSION") ){
        				 colnum = colnum+10;
        			 }else if( (entry.getDictTypeId() ).equals("DEVICE_USEFUL") ){
        				 colnum = colnum+11;
        			 }else if( (entry.getDictTypeId() ).equals("DEVICE_PLUGIN") ){
        				 colnum = colnum+14;
        			 }else if( (entry.getDictTypeId() ).equals("DEVICE_PERIPHERAL") ){
        				 colnum = colnum+15;
        			 }else if( (entry.getDictTypeId() ).equals("DEVICE_OTHERATTRIBUTE_1") ){
        				 colnum = colnum+16;
        			 }else if( (entry.getDictTypeId() ).equals("DEVICE_OTHERATTRIBUTE_2") ){
        				 colnum = colnum+17;
        			 }else if( (entry.getDictTypeId() ).equals("DEVICE_OTHERATTRIBUTE_3") ){
        				 colnum = colnum+18;
        			 }else if( (entry.getDictTypeId() ).equals("DEVICE_OTHERATTRIBUTE_4") ){
        				 colnum = colnum+19;
        			 }else if( (entry.getDictTypeId() ).equals("DEVICE_OTHERATTRIBUTE_5") ){
        				 colnum = colnum+20;
        			 }else if( (entry.getDictTypeId() ).equals("DEVICE_OTHERINFO_1") ){
        				 colnum = colnum+21;
        			 }else if( (entry.getDictTypeId() ).equals("DEVICE_OTHERINFO_2") ){
        				 colnum = colnum+22;
        			 }else if( (entry.getDictTypeId() ).equals("DEVICE_OTHERINFO_3") ){
        				 colnum = colnum+23;
        			 }else if( (entry.getDictTypeId() ).equals("DEVICE_OTHERINFO_4") ){
        				 colnum = colnum+24;
        			 }else if( (entry.getDictTypeId() ).equals("DEVICE_OTHERINFO_5") ){
        				 colnum = colnum+25;
        			 }else if( (entry.getDictTypeId() ).equals( "DEVICE_STATE") ){
        				 colnum = colnum+31;
        			 }
        		 }
        	}
        	
        	if(myflag == true){
        		createListBox(infos, sheet, wb, rownum, colnum);
        	}
        
        }
        
        int count = 1000;  //设置1000行的单元格都为文本格式
        
        HSSFCellStyle textStyle = wb.createCellStyle();
		    HSSFDataFormat format = wb.createDataFormat();
		    textStyle.setDataFormat(format.getFormat("@"));//设置单元格格式为"文本"
		 
        for(int i=2; i<count; i++){
        	org.apache.poi.hssf.usermodel.HSSFRow hssfRow = sheet.createRow(i);
        	for(int j=0; j<CountColumnNum; j++){
        		 org.apache.poi.hssf.usermodel.HSSFCell hssfCell = hssfRow.createCell(j);
        		 hssfCell.setCellStyle(textStyle);
        	}
        }
        
        //dataset若为空则导出的为Excel模版，不为空则导出的Excel含数据
        if(dataset != null){
        	org.apache.poi.hssf.usermodel.HSSFRow dataRow = null;
        	// 遍历集合数据，产生数据行  
            Iterator<DevicePo> it = dataset.iterator();  
            int index = 1;  
            while (it.hasNext())  
            {  
                index++;  
                dataRow = sheet.getRow(index);  
                DevicePo d = (DevicePo) it.next();  
                org.apache.poi.hssf.usermodel.HSSFCell dataCell0 = dataRow.getCell(0);
                dataCell0.setCellValue(d.getDeviceId());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell1 = dataRow.getCell(1);
                dataCell1.setCellValue(d.getOrgcode());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell2 = dataRow.getCell(2);
                dataCell2.setCellValue(d.getDeviceName());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell3 = dataRow.getCell(3);
                dataCell3.setCellValue(d.getDeviceModel());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell4 = dataRow.getCell(4);
                dataCell4.setCellValue(d.getIpAdress());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell5 = dataRow.getCell(5);
                dataCell5.setCellValue(d.getProductionMachineName());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell6 = dataRow.getCell(6);
                dataCell6.setCellValue(d.getCpuCode());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell7 = dataRow.getCell(7);
                dataCell7.setCellValue(d.getMemory());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell8 = dataRow.getCell(8);
                dataCell8.setCellValue(d.getHardDisk());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell9 = dataRow.getCell(9);
                dataCell9.setCellValue(d.getOsVersion());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell10 = dataRow.getCell(10);
                dataCell10.setCellValue(d.getSoftwareVersion());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell11 = dataRow.getCell(11);
                dataCell11.setCellValue(d.getIeVersion());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell12 = dataRow.getCell(12);
                dataCell12.setCellValue(d.getUseful());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell13 = dataRow.getCell(13);
                dataCell13.setCellValue(d.getTerminalNumber());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell14 = dataRow.getCell(14);
                dataCell14.setCellValue(d.getUser());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell15 = dataRow.getCell(15);
                dataCell15.setCellValue(d.getPlugIn());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell16 = dataRow.getCell(16);
                dataCell16.setCellValue(d.getPeripheral());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell17 = dataRow.getCell(17);
                dataCell17.setCellValue(d.getOtherAttribute_1());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell18 = dataRow.getCell(18);
                dataCell18.setCellValue(d.getOtherAttribute_2());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell19 = dataRow.getCell(19);
                dataCell19.setCellValue(d.getOtherAttribute_3());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell20 = dataRow.getCell(20);
                dataCell20.setCellValue(d.getOtherAttribute_4());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell21 = dataRow.getCell(21);
                dataCell21.setCellValue(d.getOtherAttribute_5());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell22 = dataRow.getCell(22);
                dataCell22.setCellValue(d.getOtherInfo_1());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell23 = dataRow.getCell(23);
                dataCell23.setCellValue(d.getOtherInfo_2());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell24 = dataRow.getCell(24);
                dataCell24.setCellValue(d.getOtherInfo_3());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell25 = dataRow.getCell(25);
                dataCell25.setCellValue(d.getOtherInfo_4());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell26 = dataRow.getCell(26);
                dataCell26.setCellValue(d.getOtherInfo_5());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell27 = dataRow.getCell(27);
                dataCell27.setCellValue(d.getRemarks_1());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell28 = dataRow.getCell(28);
                dataCell28.setCellValue(d.getRemarks_2());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell29 = dataRow.getCell(29);
                dataCell29.setCellValue(d.getRemarks_3());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell30 = dataRow.getCell(30);
                dataCell30.setCellValue(d.getRemarks_4());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell31 = dataRow.getCell(31);
                dataCell31.setCellValue(d.getRemarks_5());
                org.apache.poi.hssf.usermodel.HSSFCell dataCell32 = dataRow.getCell(32);
                dataCell32.setCellValue(d.getDeviceState());
                
//                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值  
//                Field[] fields = d.getClass().getDeclaredFields();  
//                for (short i = 0; i < fields.length; i++)  
//                {  
//                	dataCell = dataRow.getCell(i);  
//                    Field field = fields[i];  
//                    String fieldName = field.getName();  
//                    String getMethodName = "get"  
//                            + fieldName.substring(0, 1).toUpperCase()  
//                            + fieldName.substring(1);  
//                        Class tCls = d.getClass();  
//                        Method getMethod = tCls.getMethod(getMethodName,  
//                                new Class[]  
//                                {});  
//                        Object value = getMethod.invoke(d, new Object[]  
//                        {});  
//                        // 判断值的类型后进行强制类型转换  
//                        String textValue = value.toString();  
//                        HSSFRichTextString richString = new HSSFRichTextString(  
//                                textValue); 
//                        dataCell.setCellValue(richString);  
//                }  
            } 
        }
        
//写入文件
        
        
        
        System.out.println("create  file................");
        File file1 = new File(ServletActionContext.getServletContext().getRealPath("/")+"devicefile/");
       
        
        System.out.println(ServletActionContext.getServletContext().getRealPath("/")+"devicefile/exportEXCBAL.xls");
        if  (!file1 .exists()  && !file1 .isDirectory())      
        {       
            System.out.println("//不存在");  
            file1 .mkdir();    
        } else   
        {  
            System.out.println("//目录存在");  
        }  
        
        File file = new File(ServletActionContext.getServletContext().getRealPath("/")+"devicefile/exportEXCBAL.xls");
        
        if(!file.exists())    
        {    
            try {    
                file.createNewFile();    
            } catch (IOException e) {    
                // TODO Auto-generated catch block    
                e.printStackTrace();    
            }    
        }    
        
        
		FileOutputStream fileOut=new FileOutputStream(file);
				
 

	    //wujiajun   out 
	    
	    
	    
	    wb.write(fileOut);
	    fileOut.flush();
	    fileOut.close();

	     System.out.println(fileOut);
	    
	    
//        HttpServletResponse response = getResponse();
//        OutputStream out = new BufferedOutputStream(  
//                response.getOutputStream());  
//	    response.setContentType("application/x-msdownload;charset=UTF-8");
//		//设置Excel的名称;	
//		String date = TimeUtil.today()+TimeUtil.now();
//		response.setHeader("Content-Disposition",
//				"attachment; filename=\""+date+".xls\"");
//		wb.write(out);
//		out.flush();
		//结束
		System.out.println("exportExcelFunction Over");
	}
	
	//导入模板下载
	public InputStream getDownloadFile1() throws Exception   {  
		
		System.out.println("getDownloadFile1() start.... ");

		String[] headers = {"机构号(请参照机构号对照表)", "*设备名称(单选)", "*型号(单选)", "IP地址", "生产机器名称", "CPU型号", "内存容量(G)", "硬盘容量(G)", "*操作系统版本(单选)", 
				"内置软件版本", "*IE版本(单选)", "*用途(多选)", "终端号", "使用人", "*安装的插件(多选)", "*对应的外设(多选)", 
				"*其他属性1(单选)", "*其他属性2(单选)", "*其他属性3(单选)", "*其他属性4(单选)", "*其他属性5(单选)", 
				"*其他信息1(多选)", "*其他信息2(多选)", "*其他信息3(多选)", "*其他信息4(多选)", "*其他信息5(多选)", 
				"备注1", "备注2", "备注3", "备注4", "备注5", "*设备状态(单选)"};
		exportExcelFuntion("设备信息导入模版", headers, null);
		
       System.out.println("new22222");
		
		File file = new File(ServletActionContext.getServletContext().getRealPath("/")+"devicefile/exportEXCBAL.xls");
		System.out.println("文件路径是file1："+ServletActionContext.getServletContext().getRealPath("/")+"devicefile/exportEXCBAL.xls");
		
		InputStream in=new FileInputStream(file);
		
		return in;
			
    } 
	
	//批量修改导出 下载
	public InputStream getDownloadFile2() throws Exception{
		System.out.println("getDownloadFile2() start.... ");

		String[] headers = {"设备ID", "机构号(请参照机构号对照表)", "*设备名称(单选)", "*型号(单选)", "IP地址", "生产机器名称", "CPU型号", "内存容量(G)", "硬盘容量(G)", "*操作系统版本(单选)", 
				"内置软件版本", "*IE版本(单选)", "*用途(多选)", "终端号", "使用人", "*安装的插件(多选)", "*对应的外设(多选)", 
				"*其他属性1(单选)", "*其他属性2(单选)", "*其他属性3(单选)", "*其他属性4(单选)", "*其他属性5(单选)", 
				"*其他信息1(多选)", "*其他信息2(多选)", "*其他信息3(多选)", "*其他信息4(多选)", "*其他信息5(多选)", 
				"备注1", "备注2", "备注3", "备注4", "备注5", "*设备状态(单选)"};
		List<DevicePo> dataset = new ArrayList<DevicePo>();  
		String[] deviceIdsArr=deviceIds.split(",");
		Long deviceId ;
		for(int i=0; i<deviceIdsArr.length; i++){
			deviceId = Long.valueOf(deviceIdsArr[i]);
			DevicePo device = new DevicePo();
			device.setDeviceId(deviceId);
			device = deviceManagermentService.getDeviceByDeviceId(device);
			if(device.getUseful() != null){
				device.setUseful((device.getUseful()).replaceAll(", ", "," ));
			}
			if(device.getPlugIn() != null){
				device.setPlugIn((device.getPlugIn()).replaceAll(", ", "," ));
			}
			if(device.getPeripheral() != null){
				device.setPeripheral((device.getPeripheral()).replaceAll(", ", "," ));
			}
			if(device.getOtherInfo_1() != null){
				device.setOtherInfo_1((device.getOtherInfo_1()).replaceAll(", ", "," ));
			}
			if(device.getOtherInfo_2() != null){
				device.setOtherInfo_2((device.getOtherInfo_2()).replaceAll(", ", "," ));
			}
			if(device.getOtherInfo_3() != null){
				device.setOtherInfo_3((device.getOtherInfo_3()).replaceAll(", ", "," ));
			}
			if(device.getOtherInfo_4() != null){
				device.setOtherInfo_4((device.getOtherInfo_4()).replaceAll(", ", "," ));
			}
			if(device.getOtherInfo_5() != null){
				device.setOtherInfo_5((device.getOtherInfo_5()).replaceAll(", ", "," ));
			}
			
			dataset.add(device);
		}
		exportExcelFuntion("设备信息批量修改", headers, dataset);
		
		System.out.println("getDownloadFile2() end.... ");
		
		
		File file = new File(ServletActionContext.getServletContext().getRealPath("/")+"devicefile/exportEXCBAL.xls");
		
		
		System.out.println("文件路径是file2："+ServletActionContext.getServletContext().getRealPath("/")+"devicefile/exportEXCBAL.xls");
		
		
		InputStream in=new FileInputStream(file);
		
		return in;			
	}
	
	//批量修改导出全部 下载
		public InputStream getDownloadFile3() throws Exception{
			System.out.println("getDownloadFile3() start.... ");

			String[] headers = {"设备ID", "机构号(请参照机构号对照表)", "*设备名称(单选)", "*型号(单选)", "IP地址", "生产机器名称", "CPU型号", "内存容量(G)", "硬盘容量(G)", "*操作系统版本(单选)", 
					"内置软件版本", "*IE版本(单选)", "*用途(多选)", "终端号", "使用人", "*安装的插件(多选)", "*对应的外设(多选)", 
					"*其他属性1(单选)", "*其他属性2(单选)", "*其他属性3(单选)", "*其他属性4(单选)", "*其他属性5(单选)", 
					"*其他信息1(多选)", "*其他信息2(多选)", "*其他信息3(多选)", "*其他信息4(多选)", "*其他信息5(多选)", 
					"备注1", "备注2", "备注3", "备注4", "备注5", "*设备状态(单选)"};
			
			DevicePo devicePo = new DevicePo();
			List<DevicePo> dataset = deviceManagermentService.deviceList(devicePo);
			
			for(DevicePo device : dataset){
				if(device.getUseful() != null){
					device.setUseful((device.getUseful()).replaceAll(", ", "," ));
				}
				if(device.getPlugIn() != null){
					device.setPlugIn((device.getPlugIn()).replaceAll(", ", "," ));
				}
				if(device.getPeripheral() != null){
					device.setPeripheral((device.getPeripheral()).replaceAll(", ", "," ));
				}
				if(device.getOtherInfo_1() != null){
					device.setOtherInfo_1((device.getOtherInfo_1()).replaceAll(", ", "," ));
				}
				if(device.getOtherInfo_2() != null){
					device.setOtherInfo_2((device.getOtherInfo_2()).replaceAll(", ", "," ));
				}
				if(device.getOtherInfo_3() != null){
					device.setOtherInfo_3((device.getOtherInfo_3()).replaceAll(", ", "," ));
				}
				if(device.getOtherInfo_4() != null){
					device.setOtherInfo_4((device.getOtherInfo_4()).replaceAll(", ", "," ));
				}
				if(device.getOtherInfo_5() != null){
					device.setOtherInfo_5((device.getOtherInfo_5()).replaceAll(", ", "," ));
				}
				
			}
			exportExcelFuntion("设备信息批量修改全部", headers, dataset);
			
			System.out.println("getDownloadFile3() end.... ");
			
			
			File file = new File(ServletActionContext.getServletContext().getRealPath("/")+"devicefile/exportEXCBAL.xls");
			
			
			System.out.println("文件路径是file3："+ServletActionContext.getServletContext().getRealPath("/")+"devicefile/exportEXCBAL.xls");
			
			
			InputStream in=new FileInputStream(file);
			
			return in;
			
		}
		
		//下载机构号对照表
	    public InputStream getDownloadFile4() throws Exception{
	    	System.out.println("getDownloadFile4() start.... ");

			String[] headers = {"机构号","机构/部门名称"};
			
			List orgList = this.deviceManagermentService.queryOrgList();
			
			//文件初始化
			org.apache.poi.hssf.usermodel.HSSFWorkbook wb = new org.apache.poi.hssf.usermodel.HSSFWorkbook();// 创建Excel文档 
			org.apache.poi.hssf.usermodel.HSSFSheet sheet = wb.createSheet("机构号对照表"); // sheet 对应一个工作页
			
			// 获取总列数
			int CountColumnNum = 2;
			
			org.apache.poi.hssf.usermodel.HSSFRow firstrow = sheet.createRow(0);   // 下标为0的行为第一行
			org.apache.poi.hssf.usermodel.HSSFCell[] cells= new org.apache.poi.hssf.usermodel.HSSFCell[CountColumnNum];   //创建单元格
	        
	      //加粗列名
	        HSSFFont font2 = wb.createFont();
			HSSFCellStyle style2 = wb.createCellStyle();
			
	        font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  //加粗字体
	        style2.setFont(font2);
	       style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //字体 左右居中
	       style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  //字体 上下居中
	       style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); ////设置前景填充样式
	       style2.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);  //前景填充色25%灰色
	       
	        //列名标题行设置格式
	        for (int j = 0; j < CountColumnNum; j++) {  
	            cells[j] = firstrow.createCell(j);  
	            cells[j].setCellValue(new HSSFRichTextString(headers[j]));  
	            cells[j].setCellStyle(style2);
	            sheet.setColumnWidth(j, 27 * 256);//两个参数：一个是列的索引（从0开始），一个是宽度，第二个参数要乘以256，因为单位是1/256个字符宽度
	        }  
	        
	        sheet.getRow(0).setHeight((short) (20*20));//Height的单位是1/20个点，也可以用sheet.getRow(1).setHeightInPoints(20);
	        
	        if(orgList != null){
	        	org.apache.poi.hssf.usermodel.HSSFRow dataRow = null;
	        	org.apache.poi.hssf.usermodel.HSSFCell hssfCell = null;
	        	// 遍历集合数据，产生数据行  
	            Iterator<Org> it = orgList.iterator();  
	            int index = 0;  
	            while (it.hasNext())  
	            {  
	            	index++;  
	                dataRow = sheet.createRow(index);  
	                Org org = (Org) it.next();  
	                org.apache.poi.hssf.usermodel.HSSFCell dataCell0 = dataRow.createCell(0);
	                dataCell0.setCellValue(org.getOrgcode());
	                org.apache.poi.hssf.usermodel.HSSFCell dataCell1 = dataRow.createCell(1);
	                dataCell1.setCellValue(org.getOrgname());
	            } 
	        }
	        
	//写入文件

	        System.out.println("create  file................");
	        File file1 = new File(ServletActionContext.getServletContext().getRealPath("/")+"devicefile/");
	       
	        
	        System.out.println(ServletActionContext.getServletContext().getRealPath("/")+"devicefile/exportEXCBAL.xls");
	        if  (!file1 .exists()  && !file1 .isDirectory())      
	        {       
	            System.out.println("//不存在");  
	            file1 .mkdir();    
	        } else   
	        {  
	            System.out.println("//目录存在");  
	        }  
	        
	        File file = new File(ServletActionContext.getServletContext().getRealPath("/")+"devicefile/exportEXCBAL.xls");
	        
	        if(!file.exists())    
	        {    
	            try {    
	                file.createNewFile();    
	            } catch (IOException e) {    
	                // TODO Auto-generated catch block    
	                e.printStackTrace();    
	            }    
	        }    
	        
			FileOutputStream fileOut=new FileOutputStream(file);

		    wb.write(fileOut);
		    fileOut.flush();
		    fileOut.close();

		     System.out.println(fileOut);
		    
			System.out.println("getDownloadFile4() end.... ");
			
			System.out.println("文件路径是file4："+ServletActionContext.getServletContext().getRealPath("/")+"devicefile/exportEXCBAL.xls");
			
			InputStream in=new FileInputStream(file);
			
			return in;		
		}
			
}
