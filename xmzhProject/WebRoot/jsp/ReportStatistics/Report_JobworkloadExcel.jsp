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
		<th height="34" width="160" align="center" class="form_label">时间</th>
		<th height="34" width="200" align="center" class="form_label">一级分类</th>
		<th height="34" width="100" align="center" class="form_label">贷种分类</th>
		<th height="34" width="100" align="center" class="form_label">流程节点</th>
		<th height="34" width="100" align="center" class="form_label">人员姓名</th>
		<th height="34" width="100" align="center" class="form_label">1次业务数量 </th>
		<th height="34" width="100" align="center" class="form_label">2次业务数量 </th>
		<th height="34" width="100" align="center" class="form_label">3次业务数量 </th>
		<th height="34" width="100" align="center" class="form_label">4次业务数量 </th>
		<th height="34" width="100" align="center" class="form_label">5次业务数量 </th>
		</tr>
			<l:iterate property="jobWorkloadList" id="id1">
			
			<tr class="<l:output evenOutput='EOS_table_row' />" id="issuedTr">
			<td style="vnd.ms-excel.numberformat:@">
			     ${starttime}     ${endtime} 
			  </td>
			 <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="oneCategory"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="loanCategory"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="processNodeName"/>
			  </td>
			  			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="personName"/>
			  </td>
			  	<td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="businessNumbeOner"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="businessNumberTwo"/>
			  </td>
			  			   <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="businessNumbeThreer"/>
			  </td>
			  			   <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="businessNumberFour"/>
			  </td>
			  			   <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="businessNumberFive"/>
			  </td>
			</tr>
			
			</l:iterate>
		</table>
   		
		
		
		
		
		
		
		
		
		
		
