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
		<th height="34" width="100" align="center" class="form_label">序号</th>
		<th height="34" width="100" align="center" class="form_label">放款日期</th>
		<th height="34" width="200" align="center" class="form_label">客户姓名</th>
		<th height="34" width="100" align="center" class="form_label">放款金额</th>
		<th height="34" width="100" align="center" class="form_label">合作机构</th>
		<th height="34" width="100" align="center" class="form_label">受理支行(一级支行)</th>
	</tr>
	<l:iterate property="cooperateInstitutionDtos" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id1">
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="number"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="endDate" formatPattern="yyyy-MM-dd HH:mm:ss"/>					
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="cust_Name" />							
			  </td>
			  <td >
			   <b:write iterateId="id1" property="apply_bal" />
			 </td>
			   <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="coOrganization" />
				</td>
			    <td style="vnd.ms-excel.numberformat:@">
			  <b:write iterateId="id1" property="orgNameOne" />
			</td>
			  
			</tr>
			</l:iterate>
		</table>
   