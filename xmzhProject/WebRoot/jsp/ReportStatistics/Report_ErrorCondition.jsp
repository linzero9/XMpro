<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>差错情况统计列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/ReportStatistics/ReportAction_queryReportErrorCondition.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
                                        <td class="form_label" align="right" width="20%">报单日期：</td>
					<td colspan="1" width="30%">
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="repTimeStrat" name="ErrorConditionDto.repTimeStrat" 
					property="ErrorConditionDto.appTimeStrat" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="repTimeEnd" name="ErrorConditionDto.repTimeEnd" 
					property="ErrorConditionDto.appTimeEnd" /></td>

					<td class="form_label" align="right" width="20%">客户姓名：</td>
					<td colspan="1" width="30%"><h:text id="cust_Name" property="ErrorConditionDto.cust_Name" />
					</td>
					
					<td class="form_label" align="right" >差错环节：</td>
					<td >
			     		<h:hidden id="ErrorlinkId" property="xdProcessTaskAssignee.ErrorlinkId" />  <!--  xdProcessTaskAssignee是dao名称 -->
						<h:text id="Errorlink" property="xdProcessTaskAssignee.Errorlink" readonly="true"/>
						<a href="#" onclick="showErrorlink();">选择</a>
					</td>
					
					
				</tr>
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="submit" value="查 询" class="button" onclick="search();">
							<input type="button" value="清 空" class="button" onclick="clears();">
                                                        <input id="downexl" type="submit" class="button" value="导出列表" onclick="downExl();"></td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="差错情况统计列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/ReportStatistics/ReportAction_queryReportErrorCondition.action" method="post">
			 <h:hiddendata property="xdProcessTaskAssignee"/>  

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
								机构名称
							</th>
							<th nowrap="nowrap">
								贷种
							</th>
							<th nowrap="nowrap">
								主调信贷员
							</th>
							<th nowrap="nowrap">
								辅调信贷员
							</th>
							<th nowrap="nowrap">
								营业主管
					       </th>
					       <th nowrap="nowrap">
								差错情况
							</th>
                                                  <th nowrap="nowrap">
								扣罚金额
							</th>
                                                  <th nowrap="nowrap">
								差错次数
							</th>
                                                  <th nowrap="nowrap">
								差错环节
							</th>
                                                  <th nowrap="nowrap">
								提出差错人
							</th>
                                                  <th nowrap="nowrap">
								提出差错时间
							</th>
						</tr>
						<w:radioGroup id="group1">
                           <l:iterate property="xdProcessTaskAssignees" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap">
									<w:rowRadio>
										<h:param name='executionId' iterateId='id1' property='executionId' />
										<h:param name='InstitutionName' iterateId='id1' property='InstitutionName' />
										<h:param name='Loan' iterateId='id1' property='Loan' />
										<h:param name='homophony_loanteller' iterateId='id1' property='homophony_loanteller' />
										<h:param name='AT_loanteller' iterateId='id1' property='AT_loanteller' />
										<h:param name='BranchProcessOfficer' iterateId='id1' property='BranchProcessOfficer' />
										<h:param name='ErrorCondition' iterateId='id1' property='ErrorCondition' />
<h:param name='finedsum' iterateId='id1' property='finedsum' />
<h:param name='Errornumber' iterateId='id1' property='Errornumber' />
<h:param name='Errorlink' iterateId='id1' property='Errorlink' />
<h:param name='proposeWP' iterateId='id1' property='proposeWP' />
<h:param name='proposeET' iterateId='id1' property='proposeET' />
									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="InstitutionName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="Loan" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="homophony_loanteller" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="AT_loanteller" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="BranchProcessOfficer" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="ErrorCondition" />
								</td>
<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="finedsum" />
								</td>
<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="Errornumber" />
								</td>
<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="Errorlink" />
								</td>
<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="proposeWP" />
								</td>
<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="proposeET" />
								</td>

							</tr>
						</l:iterate>
						</w:radioGroup>
							<tr>
              <td colspan="23" class="command_sort_area">
              	<div class="h3"> 
              	<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
									<input type="button" class="button" value="修改差错情况信息" onclick="upt_loan_info();"/>
								</l:greaterThan>
							
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
							<input type="button" class="button" value="查看修改明细" onclick="queryLoanUptWater();"/>
								</l:greaterThan>
								</div>
							
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
			$id("custName").value="";
			$id("oneCategory").value="";
			$id("oneCategoryId").value="";
			$id("loanCategory").value="";
			$id("loanCategoryId").value="";
		}
                function search(){
			$("#isExport").val("");
			}
                function downExl() {
			$("#isExport").val("1");
		}
		
		function upt_loan_info(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条流程信息");
	  			return;
	  		}else{
	  			var row=gop.getSelectRow();
		  		var executionId = row.getParam("executionId");
		  		var InstitutionName = row.getParam("InstitutionName");
		  		var Loan = row.getParam("Loan");
		  		var homophony_loanteller = row.getParam("homophony_loanteller");
var AT_loanteller = row.getParam("AT_loanteller");
		  		var BranchProcessOfficer = row.getParam("BranchProcessOfficer");
		  		var ErrorCondition = row.getParam("ErrorCondition");
		  		var finedsum = row.getParam("finedsum");
var Errornumber = row.getParam("Errornumber");
var Errorlink = row.getParam("Errorlink");
var proposeWP = row.getParam("proposeWP");
var proposeET = row.getParam("proposeET");

	            var strUrl = "/jbpm/xdProcessAction_toUptLoanInfo.action?xdProcessTaskAssignee.executionId="+executionId+"&xdProcessTaskAssignee.InstitutionName="+InstitutionName;
	            strUrl = strUrl +"&xdProcessTaskAssignee.Loan="+Loan
	            +"&xdProcessTaskAssignee.homophony_loanteller="+homophony_loanteller
	            +"&xdProcessTaskAssignee.AT_loanteller="+AT_loanteller
	            +"&xdProcessTaskAssignee.BranchProcessOfficer="+BranchProcessOfficer
                    +"&xdProcessTaskAssignee.ErrorCondition="+ErrorCondition
+"&xdProcessTaskAssignee.finedsum="+finedsum
+"&xdProcessTaskAssignee.Errornumber="+Errornumber
+"&xdProcessTaskAssignee.Errorlink="+Errorlink
+"&xdProcessTaskAssignee.proposeWP="+proposeWP
+"&xdProcessTaskAssignee.proposeET="+proposeET;
	            
				  showModalCenter(encodeURI(strUrl), null,callBack, 500, 300, '修改差错情况信息');
				  
				  /* 	var url="/jbpm/xdProcessAction_toAddOneCategory.action?xdCdtypeBean.processName="+encodeURI(processName);
		  		parent.window.frames["mainFrame"].location.href = encodeURI(strUrl); 
		  		
		  		showModalCenter(encodeURI(strUrl), null, callBack, clientX*0.9, clientY*0.9, ''修改差错情况信息');*/	
			}
		}
		function callBack(){
			var frm = $name("page_form");
            frm.submit();
			//  location.reload(); //就算页面直接关闭，也会重新加载页面
			}

	  	function queryLoanUptWater(){
	  		var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条流程信息");
	  			return;
	  		}else{
	  			var rows=gop.getSelectRow();
		  		var executionId = rows.getParam("executionId");
		  		var strUrl = "/jbpm/xdProcessAction_queryLoanUptWater.action?waterInfo.flow_id="+executionId;
		  		showModalCenter(strUrl,'',null ,1200,500,'差错情况修改流水明细');
			  	}
		  	}

	  	function showErrorlink() {
			var ErrorlinkId=document.getElementById("ErrorlinkId").value;
			strUrl ="/Generalprocess/tGeneralprocessCdtypeAction_ErrorlinkDic.action?cdtypeJson="+ErrorlinkId,
			showModalCenter(strUrl,'',showErrorlink_callback1 ,800,430,'差错环节选择'); 
		} 
		function showErrorlink_callback1(args){
			if(args!=''){
			var array;
			array = args.split(":");
			 document.getElementById("ErrorlinkId").value = array[0];
			 document.getElementById("Errorlink").value = array[1];
			}
		}	

		
		</script>
		
	</body>
</html>