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
		<th height="34"  align="center" class="form_label" nowrap="nowrap">报单时间</th>
		<th height="34"  align="center" class="form_label" nowrap="nowrap">流程名称</th>
		<th height="34"  align="center" class="form_label" nowrap="nowrap">客户名称</th>
		<th height="34"  align="center" class="form_label" nowrap="nowrap">受理支行（一级）</th>
		<th height="34"  align="center" class="form_label" nowrap="nowrap">受理支行（二级）</th>
		<th height="34"  align="center" class="form_label" nowrap="nowrap">一级分类</th>
		<th height="34"  align="center" class="form_label" nowrap="nowrap">贷种</th>
		<th height="34"  align="center" class="form_label" nowrap="nowrap">超限环节</th>
		<th height="34"  align="center" class="form_label" nowrap="nowrap">超限人员</th>
		<th height="34"  align="center" class="form_label" nowrap="nowrap">超限时长(单位:小时)</th>
		<th height="34"  align="center" class="form_label" nowrap="nowrap">节点开始时间</th>
		<th height="34"  align="center" class="form_label" nowrap="nowrap">节点结束时间</th>
		<th height="34"  align="center" class="form_label" nowrap="nowrap">备注</th>
	</tr>
	<l:iterate property="overTimeReports" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id1">
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="reportTime"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="process_name"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="custName"/>					
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			 		<b:write iterateId="id1" property="orgname_one" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			 		<b:write iterateId="id1" property="orgname_two" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			   		<b:write iterateId="id1" property="oneCategory_name" />							
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			   		<b:write iterateId="id1" property="loanCategory_name" />							
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="taskName"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			  	 	<b:write iterateId="id1" property="empname" />
			  </td>
			  <td>
			  		<b:write iterateId="id1" property="overtime" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			  		<b:write iterateId="id1" property="starttime" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			  		<b:write iterateId="id1" property="endtime" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			  		<b:write iterateId="id1" property="remark" />
			  </td>
			</tr>
			</l:iterate>
		</table>
   