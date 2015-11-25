package com.gotop.deviceManagement.action;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.junit.Test;

public class TestPoi {
	
	
	
	@Test
	public void test1() throws Exception{
		
		
		String dropDataSource=null;
		
		StringBuffer  sb = new StringBuffer();
	    for (int i = 200; i >= 0; i--) {
	      sb.append(i+"我的天啊 快点显示吧").append(",");
	    }
	    sb = sb.deleteCharAt(sb.length() - 1);
	    dropDataSource = sb.toString();
		
		
		dropDownList2003(dropDataSource, "workbook.xls");
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void dropDownList2003(String dataSource, String filePath)
		      throws Exception {
		    HSSFWorkbook workbook = new HSSFWorkbook();
		    HSSFSheet realSheet = workbook.createSheet("下拉列表测试");
		    HSSFSheet hidden = workbook.createSheet("hidden");
		    //数据源sheet页不显示
		    workbook.setSheetHidden(1, true);
		    String[] datas = dataSource.split("\\,");
		    CellStyle style = workbook.createCellStyle();
		    style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
		    style.setAlignment(CellStyle.ALIGN_CENTER);
		    style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		    HSSFRow row = null;
		    HSSFCell cell = null;
		    for (int i = 0, length = datas.length; i < length; i++) {
		      row = hidden.createRow(i);
		      cell = row.createCell(0);
		      cell.setCellValue(String.valueOf(datas[i]));
		    }
		    Name namedCell = workbook.createName();
		    namedCell.setNameName("hidden");
		    namedCell.setRefersToFormula("hidden!A1:A" + datas.length);
		    DVConstraint constraint = DVConstraint
		        .createFormulaListConstraint("hidden");
		    CellRangeAddressList addressList = null;
		    HSSFDataValidation validation = null;
		    row = null;
		    cell = null;
		    for (int i = 0; i < 100; i++) {
		      row = realSheet.createRow(i);
		      cell = row.createCell(0);
		      cell.setCellStyle(style);
		      addressList = new CellRangeAddressList(i, i, 0, 0);
		      validation = new HSSFDataValidation(addressList, constraint);
		      realSheet.addValidationData(validation);
		      validation.setShowErrorBox(false);// 取消弹出错误框
		    }
		    FileOutputStream stream = new FileOutputStream(filePath);
		    workbook.write(stream);
		    stream.close();
		    style = null;
		    addressList = null;
		    validation = null;
		  }
	
	

}






