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


import sun.awt.geom.AreaOp.SubOp;

import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;

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
	private File readFile;
	private HashMap<String,Object> map; 
	private String orgcodeTemp;
	private Sum sum;
	private List<Sum> sums;
	
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
							System.out.println(cell.getCellType());
							if (cell.getCellType() != HSSFCell.CELL_TYPE_BLANK) {
								allowInsert = true;		
								break;//结束for循环语句,跳出
							} 
						}
						
						if(allowInsert == false){
							all_num--;
							continue;//跳到excel表格的下一行进行判断
						}
						
				//校验数据输入的正确性，不通过则不做插入操作
						String orgcode =getCellValue(row.getCell((short)0)).trim();
						if ("".equals(orgcode) || orgcode == null){
							msg+="第"+(i+1)+"行，机构/部门不能为空。||";
							map.put("msg", msg);
							failnum++;
							continue;
						}
						int  count= deviceManagermentService.queryOrg(orgcode);
						if(count==0){
							msg+="第"+(i+1)+"行无法插入，机构/部门("+orgcode+")不存在。请检查值是否输错或书写格式错误！||";
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String deviceName = getCellValue(row.getCell((short)1)).trim();
						HashMap infoMap = checkData_singleSelect("DEVICE_NAME", deviceName, "设备名称", i, msg);
						boolean flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg",msg);
							failnum++;
							continue;
						}
						
						String deviceModel = getCellValue(row.getCell((short)2)).trim();
						infoMap = checkData_singleSelect("DEVICE_MODEL", deviceModel, "型号", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg",msg);
							failnum++;
							continue;
						}
						
						String osVersion = getCellValue(row.getCell((short)8)).trim();
						infoMap = checkData_singleSelect("DEVICE_OS_VERSION", osVersion, "操作系统版本", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String ieVersion = getCellValue(row.getCell((short)10)).trim();
						infoMap = checkData_singleSelect("DEVICE_IE_VERSION", ieVersion, "IE版本", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String otherAttribute_1 = getCellValue(row.getCell((short)16)).trim();
						infoMap = checkData_singleSelect("DEVICE_OTHERATTRIBUTE_1", otherAttribute_1, "其他属性1", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String otherAttribute_2 = getCellValue(row.getCell((short)17)).trim();
						infoMap = checkData_singleSelect("DEVICE_OTHERATTRIBUTE_2", otherAttribute_2, "其他属性2", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String otherAttribute_3 = getCellValue(row.getCell((short)18)).trim();
						infoMap = checkData_singleSelect("DEVICE_OTHERATTRIBUTE_3", otherAttribute_3, "其他属性3", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String otherAttribute_4 = getCellValue(row.getCell((short)19)).trim();
						infoMap = checkData_singleSelect("DEVICE_OTHERATTRIBUTE_4", otherAttribute_4, "其他属性4", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String otherAttribute_5 = getCellValue(row.getCell((short)20)).trim();
						infoMap = checkData_singleSelect("DEVICE_OTHERATTRIBUTE_5", otherAttribute_5, "其他属性5", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String deviceState = getCellValue(row.getCell((short)31)).trim();
						infoMap = checkData_singleSelect("DEVICE_STATE",deviceState , "设备状态", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String useful = getCellValue(row.getCell((short)11)).trim();
						infoMap = checkData_multiSelect("DEVICE_USEFUL",useful , "用途", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String plugIn = getCellValue(row.getCell((short)14)).trim();
						infoMap = checkData_multiSelect("DEVICE_PLUGIN",plugIn , "安装的插件", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String peripheral = getCellValue(row.getCell((short)15)).trim();
						infoMap = checkData_multiSelect("DEVICE_PERIPHERAL",peripheral , "对应的外设", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String otherInfo_1 = getCellValue(row.getCell((short)21)).trim();
						infoMap = checkData_multiSelect("DEVICE_OTHERINFO_1",otherInfo_1 , "其他信息1", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String otherInfo_2 = getCellValue(row.getCell((short)22)).trim();
						infoMap = checkData_multiSelect("DEVICE_OTHERINFO_2",otherInfo_2 , "其他信息2", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String otherInfo_3 = getCellValue(row.getCell((short)23)).trim();
						infoMap = checkData_multiSelect("DEVICE_OTHERINFO_3",otherInfo_3 , "其他信息3", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String otherInfo_4 = getCellValue(row.getCell((short)24)).trim();
						infoMap = checkData_multiSelect("DEVICE_OTHERINFO_4",otherInfo_4 , "其他信息4", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						String otherInfo_5 = getCellValue(row.getCell((short)25)).trim();
						infoMap = checkData_multiSelect("DEVICE_OTHERINFO_5",otherInfo_5 , "其他信息5", i, msg);
						flag = (Boolean) infoMap.get("flag");
						msg =  (String) infoMap.get("msg");
						if(!flag){
							map.put("msg", msg);
							failnum++;
							continue;
						}
						
						device = new DevicePo();
						device.setOrgcode(orgcode);
						device.setDeviceName(deviceName);
						device.setDeviceModel(deviceModel);
						device.setIpAdress(getCellValue(row.getCell((short)3)).trim());
						device.setProductionMachineName(getCellValue(row.getCell((short)4)).trim());
						device.setCpuCode(getCellValue(row.getCell((short)5)).trim());
						device.setMemory(getCellValue(row.getCell((short)6)).trim());
						device.setHardDisk(getCellValue(row.getCell((short)7)).trim());
						device.setOsVersion(osVersion);
						device.setSoftwareVersion(getCellValue(row.getCell((short)9)).trim());
						device.setIeVersion(ieVersion);
						device.setUseful(useful);
						device.setTerminalNumber(getCellValue(row.getCell((short)12)).trim());
						device.setUser(getCellValue(row.getCell((short)13)).trim());
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
						device.setRemarks_1(getCellValue(row.getCell((short)26)).trim());
						device.setRemarks_2(getCellValue(row.getCell((short)27)).trim());
						device.setRemarks_3(getCellValue(row.getCell((short)28)).trim());
						device.setRemarks_4(getCellValue(row.getCell((short)29)).trim());
						device.setRemarks_5(getCellValue(row.getCell((short)30)).trim());
						device.setDeviceState(deviceState);
						
						MUOUserSession muoUserSession = getCurrentOnlineUser();
						
						//插入数据
						try{
							this.deviceManagermentService.save(device, muoUserSession);
							sumnum++;
						}catch(Exception e){
							failnum++;
							msg+="插入第"+i+"行时失败。||";
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
		
		private HashMap checkData_multiSelect(String dictTypeId, String dictId, String colName, int i, String msg){
			
			boolean flag = true;
			HashMap infoMap = new HashMap();
			
			if(!"".equals(dictId) ){
				String[] dictIds = dictId.split(", ");   //用 逗号空格 
				EosDictEntry dictEntry = new EosDictEntry();
				
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
			infoMap.put("flag", flag);
			infoMap.put("msg", msg);
			return infoMap;
			
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
				String info ="success";
		    
		    		
		    		
		    		
		    		return "excelTemplate";
		    		
		    	
			}

			private void createListBox(String[] list,org.apache.poi.hssf.usermodel.HSSFSheet sheet, org.apache.poi.hssf.usermodel.HSSFWorkbook wb, int rownum, int colnum) {
				
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
				
			}
			
			
			
	public void batchUpdateExport() throws Exception{
		String info ="success";
    	try {
    		String[] headers = {"设备ID", "*机构/部门(单选)", "*设备名称(单选)", "*型号(单选)", "IP地址", "生产机器名称", "CPU型号", "内存容量(G)", "硬盘容量(G)", "*操作系统版本(单选)", 
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
    			dataset.add(device);
    		}
    		exportExcelFuntion("设备信息批量修改", headers, dataset);
    	
    		
    	} catch (Exception e) {
			info="fails";
			log.error("[批量修改导出失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
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
		String str3 = "2. 其中“用途”、“安装的插件”、“对应的外设”、“其他信息”对应下拉菜单可填写多个值，请用 英文的 逗号和空格（“, ”） 来间隔，除此以外的其他下拉菜单只能对应填写一个值。";
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
		 ts.applyFont(102,117,font1_2);
		 ts.applyFont(117,ts.length(),font1_1);
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
        	
        	for(Object object : list){
       		System.out.println(object.getClass().getName());
        		System.out.println(list.indexOf(object));
        		if(dataset == null){
            		colnum = 0;
            	}else{
            		colnum = 1;//colnum第0列 被设备ID占用
            	}
        		 if( object.getClass().getName().equals("com.gotop.deviceManagement.model.Org")){
        			 Org org = (Org)object;
        			 infos[list.indexOf(org)] = org.getOrgcode()+"--"+org.getOrgname();
        			 colnum = colnum+0;
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
        	createListBox(infos, sheet, wb, rownum, colnum);
        	
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
        
        
        File file = new File(ServletActionContext.getServletContext().getRealPath("/")+"exportEXC.xls");
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
//		//结束
		System.out.println("exportExcelFunction Over");
	}
	
	public InputStream getDownloadFile() throws Exception   {  
		
		System.out.println("333333333333333");

   
		String[] headers = {"*机构/部门(单选)", "*设备名称(单选)", "*型号(单选)", "IP地址", "生产机器名称", "CPU型号", "内存容量(G)", "硬盘容量(G)", "*操作系统版本(单选)", 
				"内置软件版本", "*IE版本(单选)", "*用途(多选)", "终端号", "使用人", "*安装的插件(多选)", "*对应的外设(多选)", 
				"*其他属性1(单选)", "*其他属性2(单选)", "*其他属性3(单选)", "*其他属性4(单选)", "*其他属性5(单选)", 
				"*其他信息1(多选)", "*其他信息2(多选)", "*其他信息3(多选)", "*其他信息4(多选)", "*其他信息5(多选)", 
				"备注1", "备注2", "备注3", "备注4", "备注5", "*设备状态(单选)"};
		exportExcelFuntion("设备信息导入模版", headers, null);
		
		
		
		
		return ServletActionContext.getServletContext().getResourceAsStream("/exportEXC.xls");
			
		

    }  
			
			
}
