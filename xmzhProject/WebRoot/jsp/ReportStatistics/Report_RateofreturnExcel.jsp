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
		  <th height="34" width="100" align="center" class="form_label">贷种</th>
		  <th height="34" width="100" align="center" class="form_label">区支行</th>
		  <th height="34" width="100" align="center" class="form_label">二级支行</th>
		  <th height="34" width="100" align="center" class="form_label">本月审批通过笔数</th>
		  <th height="34" width="100" align="center" class="form_label">其中1次退单率</th>
		  <th height="34" width="100" align="center" class="form_label">其中2次退单率</th>
		  <th height="34" width="100" align="center" class="form_label">其中3次退单率</th>
		  <th height="34" width="100" align="center" class="form_label">其中4次退单率</th>

		</tr>
			<l:iterate property="list" id="id1">
			
			<tr class="<l:output evenOutput='EOS_table_row' />" id="issuedTr">
			
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="loanCategory"/>
			  </td>
			  
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="orgNameOne"/>
			  </td>
			  			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="orgNameTwo"/>
			  </td>
			  			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="passNumber"/>
			  </td>
			  			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="backOne"/>
			  </td>
			  			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="backTwo"/>
			  </td>
			  			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="backThree"/>
			  </td>
			  			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="backFour"/>
			  </td>
			</tr>
			
			</l:iterate>
		</table>
   