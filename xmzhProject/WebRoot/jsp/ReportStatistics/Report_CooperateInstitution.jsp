<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>合作机构业务发展台账列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/reportjbpm/reportCooperateInstitutionAction_queryReportCooperateInstitution.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
                                        <td class="form_label" align="right" width="20%">放款日期：</td>
					<td colspan="1" width="30%">
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="appTimeStrat" name="cooperateInstitutionDto.appTimeStrat" 
					property="cooperateInstitutionDto.appTimeStrat" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="appTimeEnd" name="cooperateInstitutionDto.appTimeEnd" 
					property="cooperateInstitutionDto.appTimeEnd" /></td>

					
					
					
				</tr>
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="submit" value="查 询" class="button" >
							<input type="button" value="清 空" class="button" onclick="clears();">
                                                        <input id="downexl" type="button" class="button" value="导出列表" onclick="downExl();"></td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="合作机构业务发展台账列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/reportjbpm/reportCooperateInstitutionAction_queryReportCooperateInstitution.action" method="post">
			 <h:hiddendata property="cooperateInstitutionDto"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">
		    
						<tr>
							<th align="center" nowrap="nowrap">
								<b:message key="l_select"></b:message>
							</th>
							
							<th nowrap="nowrap">
								序号
							</th>
							<th nowrap="nowrap">
								放款日期
							</th>
							<th nowrap="nowrap">
								客户姓名
							</th>
							<th nowrap="nowrap">
								放款金额
							</th>
							<th nowrap="nowrap">
								合作机构
					       </th>
					       <th nowrap="nowrap">
								受理支行（一级支行）
							</th>
                                                  
						</tr>
						<w:radioGroup id="group1">
                           <l:iterate property="cooperateInstitutionDtos" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap">
									<w:rowRadio>
										<h:param name='executionId' iterateId='id1' property='executionId' />
										<h:param name='flow_Id' iterateId='id1' property='flow_Id' />
										<h:param name='endDate' iterateId='id1' property='endDate' />
										<h:param name='cust_Name' iterateId='id1' property='cust_Name' />
										<h:param name='apply_bal' iterateId='id1' property='apply_bal' />
										<h:param name='coOrganization' iterateId='id1' property='coOrganization' />
										</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="number" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="endDate" formatPattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="cust_Name" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="apply_bal" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="coOrganization" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgNameOne" />
								</td>
							</tr>
						</l:iterate>
						</w:radioGroup>
						  	<tr>
              <td colspan="23" class="command_sort_area">
              <!--	<div class="h3"> 
              	<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
									<input type="button" class="button" value="修改合作机构业务发展台账信息" onclick="upt_loan_info();"/>
								</l:greaterThan>
							
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
							<input type="button" class="button" value="查看修改明细" onclick="queryLoanUptWater();"/>
								</l:greaterThan>
								</div>
							-->
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

		//清空
		function clears(){
			/*$id("appTimeStrat").value="";
			$id("appTimeEnd").value="";*/
			$("#appTimeStrat_input").val("");
			$("#appTimeEnd_input").val("");
			
		}
                function search(){
			$("#isExport").val("");
			}
                function downExl() {
			$("#isExport").val("1");
		}
		
		/*function upt_loan_info(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条流程信息");
	  			return;
	  		}else{
	  			var row=gop.getSelectRow();
		  		var executionId = row.getParam("executionId");
		  		var processName = row.getParam("processName");
		  		var custName = row.getParam("cust_Name");
		  		var apply_bal = row.getParam("apply_bal");
		  		var oneCategory = row.getParam("oneCategory");
		  		var loanCategory = row.getParam("loanCategory");
		  		var coorganization = row.getParam("coOrganization");
		  		alert(oneCategory);
		  			alert(loanCategory);

	            var strUrl = "/jbpm/xdProcessAction_toUptLoanInfo.action?xdProcessTaskAssignee.executionId="+executionId+"&xdProcessTaskAssignee.processName="+processName;
	            strUrl = strUrl+"&xdProcessTaskAssignee.custName="+custName
	            +"&xdProcessTaskAssignee.apply_bal="+apply_bal
	            +"&xdProcessTaskAssignee.oneCategory="+oneCategory
	            +"&xdProcessTaskAssignee.loanCategory="+loanCategory
	            +"&xdProcessTaskAssignee.coorganization="+coorganization;
	            
				  showModalCenter(encodeURI(strUrl), null,callBack, 500, 300, '修改合作机构业务发展台账信息');
				  
				  /* 	var url="/jbpm/xdProcessAction_toAddOneCategory.action?xdCdtypeBean.processName="+encodeURI(processName);
		  		parent.window.frames["mainFrame"].location.href = encodeURI(strUrl); 
		  		
		  		showModalCenter(encodeURI(strUrl), null, callBack, clientX*0.9, clientY*0.9, ''修改合作机构业务发展台账信息');*/	
			/*}
		}*/
		function callBack(){
			var frm = $name("page_form");
            frm.submit();
			//  location.reload(); //就算页面直接关闭，也会重新加载页面
			}

	  	/*function queryLoanUptWater(){
	  		var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条流程信息");
	  			return;
	  		}else{
	  			var rows=gop.getSelectRow();
		  		var executionId = rows.getParam("executionId");
		  		var strUrl = "/jbpm/xdProcessAction_queryLoanUptWater.action?waterInfo.flow_id="+executionId;
		  		showModalCenter(strUrl,'',null ,1200,500,'合作机构业务发展台账修改流水明细');
			  	}
		  	}*/

		/*导出excl表格*/
		function downExl() {
		
			var url = "/reportjbpm/reportCooperateInstitutionAction_queryReportCooperateInstitutionForExcl.action?";
			
			var startTime = $id("appTimeStrat").value;
			
			var endTime = $id("appTimeEnd").value;
	
			url = url + "ooperateInstitutionDto.appTimeStrat="
					+ startTime + "&cooperateInstitutionDto.appTimeEnd="
					+ endTime;
			window.location.href = url;

		}
		</script>
		
	</body>
</html>