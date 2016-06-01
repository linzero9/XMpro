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
		<th nheight="34" width="100" align="center" class="form_label">标题</th>
		<th nheight="34" width="100" align="center" class="form_label">机构名称</th>
		<th nheight="34" width="100" align="center" class="form_label">客户经理</th>
		 <th nheight="34" width="100" align="center" class="form_label">客户名称</th>
		<th nheight="34" width="100" align="center" class="form_label">一级分类</th>
		<th nheight="34" width="100" align="center" class="form_label">贷种分类</th>
		<th nheight="34" width="100" align="center" class="form_label">币种</th>
		<th nheight="34" width="100" align="center" class="form_label">申请金额（万元）</th>
		<th nheight="34" width="100" align="center" class="form_label">支用类别</th>
		<th nheight="34" width="100" align="center" class="form_label">当前节点名称</th>
		<th nheight="34" width="100" align="center" class="form_label">当前节点办理人</th>
		<th nheight="34" width="100" align="center" class="form_label">当前处理人机构</th>
		</tr>
			<l:iterate property="generalprocessDtos" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="generalprocessDtosexport">
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="businessTitle"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="beginEmpname"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="beginOrgname" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="cust_Name" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="oneCategory" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="loanCategory" />
			  </td>
		       <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="currency"  dictTypeId="PROCESS_MONEY"/>
		      </td>
			  <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="apply_bal" />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="supportCategory"  dictTypeId="PROCESS_pay"/>
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="currentActivityName" />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="currentAssingee" />
		      </td>
		      <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="preTaskOrgName" />
		      </td>
			</tr>
			</l:iterate>
		</table>
   