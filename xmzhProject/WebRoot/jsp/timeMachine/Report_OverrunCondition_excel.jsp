<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://eos.primeton.com/tags/logic" prefix="l"%>
<%@ taglib uri="http://eos.primeton.com/tags/bean" prefix="b"%>
<%@ taglib uri="http://eos.primeton.com/tags/dict" prefix="d"%>
<%@ taglib uri="http://eos.primeton.com/tags/html" prefix="h"%>
<%@page import="com.gotop.util.time.TimeUtil"%>
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
		<th height="34" width="100" align="center" class="form_label">报单时间</th>
		<th height="34" width="100" align="center" class="form_label">超限环节</th>
		<th height="34" width="200" align="center" class="form_label">客户名称</th>
		<th height="34" width="100" align="center" class="form_label">贷种</th>
		<th height="34" width="100" align="center" class="form_label">机构</th>
		<th height="34" width="100" align="center" class="form_label">超限人员</th>
		<th height="34" width="100" align="center" class="form_label">超限时长</th>
		<th height="34" width="100" align="center" class="form_label">备注</th>
	</tr>
	<l:iterate property="overTimeReports" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id1">
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="reportTime"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="custName"/>					
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			   		<b:write iterateId="id1" property="loanCategory_name" />							
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			 		<b:write iterateId="id1" property="orgname" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			  	 	<b:write iterateId="id1" property="empname" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			  		<b:write iterateId="id1" property="overtime" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			  		<b:write iterateId="id1" property="remark" />
			  </td>
			</tr>
			</l:iterate>
		</table>
   