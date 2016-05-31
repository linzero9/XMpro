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
		
		<th height="34" width="100" align="center" class="form_label">贷种</th>
		<th height="34" width="200" align="center" class="form_label">区支行</th>
		<th height="34" width="100" align="center" class="form_label">二级支行</th>
		<th height="34" width="100" align="center" class="form_label">审批通过笔数</th>
		<th height="34" width="100" align="center" class="form_label">拒贷笔数</th>
		<th height="34" width="100" align="center" class="form_label">拒贷率</th>
		
		
	</tr>
	<l:iterate property="list" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id1">
			 
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="loanCategory"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="orgname" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="orgnametwo"/>
			  </td>
			   <td>
			   <b:write iterateId="id1" property="EA_number"/>
			  </td>
			    <td>
			   <b:write iterateId="id1" property="rejection_number"/>
			  </td>
			   <td>
			   <b:write iterateId="id1" property="refusalrate"/>%
			  </td>
			   
			</tr>
			</l:iterate>					  
                    			
                     
								<l:iterate property="listSum" id="id2">
								  <tr>	
							<th align="center" nowrap="nowrap" colspan="3">
								上报审批笔数合计/拒贷笔数合计	/拒贷率合计	
							</th>
								 <td nowrap="nowrap"> 
									<b:write iterateId="id2" property="upnum"/>
								</td>
								<td nowrap="nowrap" > 
									<b:write iterateId="id2" property="downnum"/>
								</td>
							   <td nowrap="nowrap" > 
									<b:write iterateId="id2" property="dowup"/>%
								</td>
						     	</tr>
								</l:iterate>																					
						
					

		</table>
   