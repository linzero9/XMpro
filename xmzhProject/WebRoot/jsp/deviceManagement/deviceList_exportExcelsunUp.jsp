<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://eos.primeton.com/tags/logic" prefix="l"%>
<%@ taglib uri="http://eos.primeton.com/tags/bean" prefix="b"%>
<%@ taglib uri="http://eos.primeton.com/tags/dict" prefix="d"%>
<%@ taglib uri="http://eos.primeton.com/tags/html" prefix="h"%>
<%@page import="com.gotop.util.time.TimeUtil" %>
<%
	response.setContentType("application/x-msdownload;charset=UTF-8");
	//设置Excel的名称;	
	String date = TimeUtil.today()+TimeUtil.now();
	response.setHeader("Content-Disposition",
			"attachment; filename=\""+date+".xls\"");
	out.flush();
%>
<table width="98%" border="1" cellspacing="1" cellpadding="1">
	<tr>
		<td colspan="4"
			style="height: 14.25pt; width: 506pt; font-weight: 700; text-align: center; color: windowtext; font-size: 12.0pt; font-style: normal; text-decoration: none; font-family: 宋体; vertical-align: middle; white-space: nowrap; border: medium none; padding: 0px"><a
			name="RANGE!A1">机构设备数量统计</a></td>
	</tr>
	<tr style="font-size:10.0pt" >
		<td colspan="2">&nbsp;机构/部门：
		<b:write property="device.orgname" />
		</td>
		<td colspan="2">&nbsp;设备名称：
		<d:write property="device.deviceName" dictTypeId="DEVICE_NAME" />
		</td>
	</tr>
	<tr style="font-size:10.0pt">
		<td colspan="2">&nbsp;设备型号：
		<d:write property="device.deviceModel" dictTypeId="DEVICE_MODEL"/>
		</td>
		<td colspan="2">&nbsp;设备状态：
		<d:write property="device.deviceState"  dictTypeId="DEVICE_STATE"/>
		</td>
	</tr>
		<tr style="font-size:10.0pt">
		<td colspan="4">&nbsp;内存容量：
		<b:write property="device.memoryMin" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;＜内存容量(G)＜：
		<b:write property="device.memoryMax" />
		</td>
	</tr>
		<tr style="font-size:10.0pt">
		<td colspan="4">&nbsp;硬盘容量：
		<b:write property="device.hardDiskMin" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;＜硬盘容量(G)＜：
		<b:write property="device.hardDiskMax" />
		</td>
	</tr>
		<tr style="font-size:10.0pt">
		<td colspan="2">&nbsp;操作系统版本：
		<d:write property="device.osVersion" dictTypeId="DEVICE_OS_VERSION"/>
		</td>
		<td colspan="2">&nbsp;内置软件版本：
		<b:write property="device.softwareVersion" />
		</td>
	</tr>
		<tr style="font-size:10.0pt">
		<td colspan="2">&nbsp;IE版本：
		<d:write property="device.ieVersion" dictTypeId="DEVICE_IE_VERSION"/>
		</td>
		<td colspan="2">&nbsp;用途：
		<d:write property="device.useful" dictTypeId="DEVICE_USEFUL" seperator=", "/>
		</td>
	</tr>
	<tr style="font-size:10.0pt">
		<td colspan="2">&nbsp;安装的插件：
		<d:write property="device.plugIn" dictTypeId="DEVICE_PLUGIN" seperator=", "/>
		</td>
		<td colspan="2">&nbsp;对应的外设：
		<d:write property="device.peripheral" dictTypeId="DEVICE_PERIPHERAL" seperator=", "/>
		</td>
	</tr>
</table>
<table width="98%" border="1" cellspacing="1" cellpadding="1">
		<tr height="34">
		  <th height="34" width="100" align="center" class="form_label">机构/部门</th>
		  <th height="34" width="100" align="center" class="form_label">设备名称</th>
		  <th height="34" width="100" align="center" class="form_label">型号</th>
		  <th height="34" width="100" align="center" class="form_label">设备数量</th>
		</tr>
			<l:iterate property="devices" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="issuedTr">
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="orgnameTemp"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <d:write iterateId="id1" property="deviceName"  dictTypeId="DEVICE_NAME" />   
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <d:write iterateId="id1" property="deviceModel"  dictTypeId="DEVICE_MODEL"  />   
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="tot" />
			  </td>
			</tr>
			</l:iterate>
		</table>
   