<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://eos.primeton.com/tags/logic" prefix="l"%>
<%@ taglib uri="http://eos.primeton.com/tags/bean" prefix="b"%>
<%@ taglib uri="http://eos.primeton.com/tags/dict" prefix="d"%>
<%@ taglib uri="http://eos.primeton.com/tags/html" prefix="h"%>
<%@ page import="com.gotop.util.time.TimeUtil" %>
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
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_NAME}</th>
		  <th height="34" width="100" align="center" class="form_label">IP地址</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_OTHERATTRIBUTE_1}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_REMARKS_1}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_MODEL}</th>
		  <th height="34" width="100" align="center" class="form_label">生产机器名称</th>
		  <th height="34" width="100" align="center" class="form_label">CPU型号</th>
		  <th height="34" width="100" align="center" class="form_label">内存容量(G)</th>
		  <th height="34" width="100" align="center" class="form_label">硬盘容量(T)</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_OS_VERSION}</th>
		  <th height="34" width="100" align="center" class="form_label">内置软件版本</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_IE_VERSION}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_USEFUL}</th>
		  <th height="34" width="100" align="center" class="form_label">终端号</th>
		  <th height="34" width="100" align="center" class="form_label">使用人</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_PLUGIN}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_PERIPHERAL}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_OTHERATTRIBUTE_2}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_OTHERATTRIBUTE_3}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_OTHERATTRIBUTE_4}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_OTHERATTRIBUTE_5}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_OTHERINFO_1}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_OTHERINFO_2}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_OTHERINFO_3}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_OTHERINFO_4}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_OTHERINFO_5}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_REMARKS_2}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_REMARKS_3}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_REMARKS_4}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_REMARKS_5}</th>
		  <th height="34" width="100" align="center" class="form_label">${sheBeiShuX.DEVICE_STATE}</th>
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
			    <b:write iterateId="id1" property="ipAdress" />
			  </td>		  
			  <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="otherAttribute_1"  dictTypeId="DEVICE_OTHERATTRIBUTE_1"/>
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="remarks_1" />
		      </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <d:write iterateId="id1" property="deviceModel"  dictTypeId="DEVICE_MODEL"  />
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
			   <d:write iterateId="id1" property="useful"  dictTypeId="DEVICE_USEFUL"  seperator=", "   />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="terminalNumber" />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="user" />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="plugIn" dictTypeId="DEVICE_PLUGIN"  seperator=", "   />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			  <d:write iterateId="id1" property="peripheral"  dictTypeId="DEVICE_PERIPHERAL"  seperator=", "  />
		      </td>

		      <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="otherAttribute_2"  dictTypeId="DEVICE_OTHERATTRIBUTE_2"/>
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="otherAttribute_3"  dictTypeId="DEVICE_OTHERATTRIBUTE_3"/>
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="otherAttribute_4"  dictTypeId="DEVICE_OTHERATTRIBUTE_4"/>
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="otherAttribute_5"  dictTypeId="DEVICE_OTHERATTRIBUTE_5"/>
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="otherInfo_1"  dictTypeId="DEVICE_OTHERINFO_1"  seperator=", "   />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="otherInfo_2"  dictTypeId="DEVICE_OTHERINFO_2"  seperator=", "   />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="otherInfo_3"  dictTypeId="DEVICE_OTHERINFO_3"  seperator=", "   />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="otherInfo_4"  dictTypeId="DEVICE_OTHERINFO_4"  seperator=", "   />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="otherInfo_5"  dictTypeId="DEVICE_OTHERINFO_5"  seperator=", "   />
		      </td>

		      <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="remarks_2" />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="remarks_3" />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="remarks_4" />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="remarks_5" />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			  <d:write  iterateId="id1"  dictTypeId="DEVICE_STATE" property="deviceState" />
		      </td>
			</tr>
			</l:iterate>
		</table>
   