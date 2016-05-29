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
		<th height="34" width="100" align="center" class="form_label">机构名称</th>
		<th height="34" width="100" align="center" class="form_label">贷种</th>
		<th height="34" width="100" align="center" class="form_label">客户名称</th>
		<th height="34" width="200" align="center" class="form_label">主调信贷员</th>
		<th height="34" width="100" align="center" class="form_label">辅调信贷员</th>
		<th height="34" width="100" align="center" class="form_label">营业主管</th>
		<th height="34" width="100" align="center" class="form_label">差错情况</th>
		<th height="34" width="100" align="center" class="form_label">扣罚金额</th>
		<th height="34" width="100" align="center" class="form_label">差错次数</th>
		<th height="34" width="100" align="center" class="form_label">差错环节</th>
		<th height="34" width="100" align="center" class="form_label">提出差错人</th>
		<th height="34" width="100" align="center" class="form_label">提出差错时间</th>
		
	</tr>
	<l:iterate property="errorStatisticList" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id1">
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="nextOrgName"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="loancategory"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="custName"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="nextOprName" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="fdxdy"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="yxzg"/>
			  </td>
			    <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="mistakeContent"/>
			  </td>
			   <td>
			   <b:write iterateId="id1" property="punishBal"/>
			  </td>
			   <td>
			    <b:write iterateId="id1" property="mistakeNumber"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="taskName"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="empName"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="addTime"/>
			  </td>
			</tr>
			</l:iterate>
		</table>
   