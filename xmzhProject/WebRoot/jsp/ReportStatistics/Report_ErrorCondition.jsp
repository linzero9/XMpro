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
	<h:form name="appQuery"	action="/reportjbpm/errorStatisticAction_queryErrorStatistic.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
                                        <td class="form_label" align="right" width="10%">报单日期：</td>
					<td colspan="1" width="25%">
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="startTime" name="errorStatistic.startTime" 
					property="errorStatistic.startTime" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="endTime" name="errorStatistic.endTime" 
					property="errorStatistic.endTime" /></td>

					<td class="form_label" align="right" width="10%">客户姓名：</td>
					<td colspan="1" width="25%"><h:text id="custName" property="errorStatistic.custName" />
					</td>
					
					<td class="form_label" align="right" width="10%">差错环节：</td>
					<td >
			     		<h:hidden id="ErrorlinkId" property="xdProcessTaskAssignee.ErrorlinkId" />   <!--//xdProcessTaskAssignee是dao名称 -->
						<h:text id="taskName" property="errorStatistic.taskName" readonly="true"/>
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
                            <input id="downexl" type="button" class="button" value="导出列表" onclick="excelExport();"></td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="差错情况统计列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/reportjbpm/errorStatisticAction_queryErrorStatistic.action" method="post">
			 <h:hiddendata property="errorStatistic"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">
		 
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
                           <l:iterate property="errorStatisticList" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="nextOrgName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="loancategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="nextOprName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="fdxdy" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="yxzg" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="mistakeContent" />
								</td>
<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="punishBal" />
								</td>
<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="mistakeNumber" />
								</td>
<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="taskName" />
								</td>
<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="empName" />
								</td>
<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="addTime" />
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
	                  <b:message key="l_page"></b:message>/
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
			$("#startTime_input").val("");
			$("#endTime_input").val("");
			$id("loanCategory").value="";
			$id("loanCategoryId").value="";
		}
                function search(){
			$("#isExport").val("");
			}

    		//导出excel 	
             function excelExport(){
    				//报单开始日期
    				var startTime = $id("startTime").value;
    				//报单结束日期
    				var endTime = $id("endTime").value;
    				//客户名称
    				var custName = $id("custName").value;
    				//差错环节
    				var taskName = $id("taskName").value;
    				
    				
    				var strUrl = "/reportjbpm/errorStatisticAction_queryErrorStatisticForExcel.action?"
    				+"&errorStatistic.startTime="+startTime
    				+"&errorStatistic.endTime="+endTime
    				+"&errorStatistic.custName="+custName
    				+"&errorStatistic.taskName="+taskName
    				window.location.href=strUrl;
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
			strUrl ="/reportjbpm/errorStatisticAction_querytaskNameList.action";
			showModalCenter(strUrl,'',showErrorlink_callback1 ,900,500,'差错环节选择'); 
		} 
		function showErrorlink_callback1(returnValue){
			if(returnValue == ""){
				//点击右上角关闭时,returnValue为null
				//不做操作
				$id("taskName").value="";
			}else{
				$id("taskName").value= returnValue[0];
			

			}
			}

		
		</script>
		
	</body>
</html>