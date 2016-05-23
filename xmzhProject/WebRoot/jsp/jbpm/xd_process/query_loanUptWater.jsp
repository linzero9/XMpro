<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>贷款信息修改流水明细</title>
	</head>
	<body topmargin="0" leftmargin="0">

	<DIV class="divList">
			<w:panel id="panel" width="100%" title="查询结果">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/jbpm/xdProcessAction_queryLoanUptWater.action" method="post">
			 <h:hidden property="waterInfo.flow_id"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">
		    
						<tr>
							<th nowrap="nowrap">
								信贷流程名称
							</th>
							<th nowrap="nowrap">
								客户名称
							</th>
							<th nowrap="nowrap">
								申请金额
							</th>
							<th nowrap="nowrap">
								一级分类
							</th>
							<th nowrap="nowrap">
								贷种分类
					       </th>
					       <th nowrap="nowrap">
								合作机构
							</th>
							 <th nowrap="nowrap">
								营销人员
							</th>
						    <th nowrap="nowrap">
								营销人员所属机构
							</th>
						    <th nowrap="nowrap">
								报单次数
							</th>
							 <th nowrap="nowrap">
								修改人
							</th>
							 <th nowrap="nowrap">
								修改人所属机构
							</th>
							 <th nowrap="nowrap">
								修改时间
							</th>
						</tr>
                           <l:iterate property="waterInfos" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="processName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="custName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="apply_bal" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="oneCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="loanCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="coorganization" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="cyxry" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="cyxryjg" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="creportcnt" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="uptEmpname" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="uptOrgname" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="uptTime" />
								</td>
							</tr>
						</l:iterate>
							<tr>
              <td colspan="23" class="command_sort_area">
              
                <div class="h4">
	                <l:equal property="page.isCount" targetValue="true" >
	                  <b:message key="l_total"></b:message>
	                  <b:write property="page.count" />
	                  <b:message key="l_recordNO."></b:message>
	                  <b:write property="page.currentPage" />
	                  <b:message key="l_page"></b:message>
	                  <b:write property="page.totalPage" />
	                  <b:message key="l_page"></b:message>
	                </l:equal>
	                <l:equal property="page.isCount" targetValue="false" >
	                  <b:message key="l_NO."></b:message>
	                  <b:write property="page.currentPage" />
	                  <b:message key="l_page"></b:message>
	                </l:equal>
	                <input type="button" class="button" onclick="firstPage('page', '', null, null, 'page_form');" value='<b:message key="l_firstPage"></b:message>'  <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
	                <input type="button" class="button" onclick="prevPage('page', '', null, null, 'page_form');" value='<b:message key="l_upPage"></b:message>' <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
	                <input type="button" class="button" onclick="nextPage('page', '', null, null, 'page_form');" value='<b:message key="l_nextPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                <l:equal property="page.isCount" targetValue="true">
	                  <input type="button" class="button" onclick="lastPage('page', '', null, null, 'page_form');" value='<b:message key="l_lastPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                </l:equal>
              </div>
              </td>
            </tr>
					</table>
				</h:form>
				</viewlist>
			</w:panel>		
		</DIV>
		<script type="text/javascript">
		</script>
		
	</body>
</html>