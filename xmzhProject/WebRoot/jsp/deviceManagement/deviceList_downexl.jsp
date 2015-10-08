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
		<tr height="34">
		  <th height="34" width="100" align="center" class="form_label">机构/部门</th>
		  <th height="34" width="100" align="center" class="form_label">设备名称</th>
		  <th height="34" width="100" align="center" class="form_label">型号</th>
		  <th height="34" width="100" align="center" class="form_label">IP地址</th>
		  <th height="34" width="100" align="center" class="form_label">生产机器名称</th>
		  <th height="34" width="100" align="center" class="form_label">CPU型号</th>
		  <th height="34" width="100" align="center" class="form_label">内存容量(G)</th>
		  <th height="34" width="100" align="center" class="form_label">硬盘容量(T)</th>
		  <th height="34" width="100" align="center" class="form_label">操作系统版本</th>
		  <th height="34" width="100" align="center" class="form_label">内置软件版本</th>
		  <th height="34" width="100" align="center" class="form_label">IE版本</th>
		  <th height="34" width="100" align="center" class="form_label">用途</th>
		  <th height="34" width="100" align="center" class="form_label">终端号</th>
		  <th height="34" width="100" align="center" class="form_label">使用人</th>
		  <th height="34" width="100" align="center" class="form_label">安装的插件</th>
		  <th height="34" width="100" align="center" class="form_label">对应的外设</th>
		  <th height="34" width="100" align="center" class="form_label">其他属性</th>
		  <th height="34" width="100" align="center" class="form_label">其他信息</th>
		  <th height="34" width="100" align="center" class="form_label">备注</th>
		  <th height="34" width="100" align="center" class="form_label">设备状态</th>
		</tr>
			<l:iterate property="devices" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="issuedTr">
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="orgname"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <d:write iterateId="id1" property="deviceName"  dictTypeId="DEVICE_NAME" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <d:write iterateId="id1" property="deviceModel"  dictTypeId="DEVICE_MODEL"  />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="ipAdress" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="productionMachineName" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="cpuCode" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="memory" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="hardDisk" />
		      </td>
		       <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="osVersion"  dictTypeId="DEVICE_OS_VERSION"/>
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="softwareVersion" />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			  <d:write iterateId="id1" property="ieVersion"  dictTypeId="DEVICE_IE_VERSION"/>
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="useful"  dictTypeId="DEVICE_USEFUL"/>
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="terminalNumber" />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="user" />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="plugIn" dictTypeId="DEVICE_PLUGIN" />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			  <d:write iterateId="id1" property="peripheral"  dictTypeId="DEVICE_PERIPHERAL" />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="otherOne"  dictTypeId="DEVICE_OTHERONE"/>
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="otherInfoOne"  dictTypeId="DEVICE_OTHERINFOONE"/>
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="remarksOne" />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			  <d:write  iterateId="id1"  dictTypeId="DEVICE_STATE" property="deviceState" />
		      </td>
			</tr>
			</l:iterate>
		</table>
   