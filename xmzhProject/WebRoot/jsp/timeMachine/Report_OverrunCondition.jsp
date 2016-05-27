<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>超限情况统计列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/timeMachine/tModelTimedayAction_queryOvertimeReport.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<%-- <h:hidden id="request_id" property="overTimeReport.request_id" /> --%>
				<tr>
					<td class="form_label" align="right" width="20%">客户名称：</td>
					<td colspan="1" width="30%">
						<h:text   id="custName" property="overTimeReport.custName" />
					</td>
					
					<td class="form_label" align="right" width="20%">超限人员：</td>
					<td colspan="1" width="30%">
						<h:text   id="empname" property="overTimeReport.empname" />
					</td>
				</tr>
				<tr>
					<td class="form_label" align="right" width="20%">报单日期：</td>
					<td  width="30%">
						从
						<w:date  id="reportStarttime"  property="overTimeReport.reportStarttime" /> 
						到
						<w:date id="reportEndtime"  property="overTimeReport.reportEndtime" />
					</td>
					
					<td class="form_label" align="right" width="20%">超限环节：</td>
					<td colspan="1" width="30%">
						<h:text   id="taskName" property="overTimeReport.taskName"   readonly="true"/>
						<a href="#" onclick="select_taskname();">选择</a>
					</td>					
				</tr>
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="submit" value="查 询" class="button"  >
							<input type="button" value="清 空" class="button" onclick="clears();">
                                                        <input id="downexl" type="button" class="button" value="导出列表" onclick="downExl();"></td>
					</tr>
					<tr>
						<td colspan="6">
								<font style="color: blue">最近更新时间：<b:write property="update_time" /> </font> &nbsp;&nbsp;&nbsp;
								<!-- <font style="color: red"> 注：该报表存在半小时延时。</font> -->
						</td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList"  style="overflow:auto;width:100%; height:355px;">
			<w:panel id="panel" width="100%" title="超限情况统计列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/timeMachine/tModelTimedayAction_queryOvertimeReport.action" method="post">
					
			 <h:hiddendata property="overTimeReport"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">
		    
						<tr>
							<%-- <th align="center" nowrap="nowrap">
								<b:message key="l_select"></b:message>
							</th> --%>
							
							<th nowrap="nowrap">
								报单时间
							</th>
							<th nowrap="nowrap">
								流程名称
							</th>
							<th nowrap="nowrap">
								超限环节
							</th>
							<th nowrap="nowrap">
								客户名称
							</th>
							<th nowrap="nowrap">
								贷种
							</th>
							<th nowrap="nowrap">
								受理支行（一级）
					       </th>
					       <th nowrap="nowrap">
								受理支行（二级）
					       </th>
					       <th nowrap="nowrap">
								超限人员
							</th>
                             <th nowrap="nowrap">
								超限时长(单位:小时)
							</th>
                             <th nowrap="nowrap">
								备注
							</th>
						</tr>
						<w:radioGroup id="group1">
                           <l:iterate property="overTimeReports" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<%-- <td align="center" nowrap="nowrap">
									<w:rowRadio>
									</w:rowRadio>
								</td> --%>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="reportTime" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="process_name" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="taskName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="custName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="loanCategory_name" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgname_one" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgname_two" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="empname" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="overtime" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="remark" />
								</td>
							</tr>
						</l:iterate>
						</w:radioGroup>
							<tr>
              <td colspan="23" class="command_sort_area">
              	<!--  <div class="h3"> 
              	<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
									<input type="button" class="button" value="修改超限情况信息" onclick="upt_loan_info();"/>
								</l:greaterThan>
							
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
							<input type="button" class="button" value="查看修改明细" onclick="queryLoanUptWater();"/>
								</l:greaterThan>
								</div>-->
							
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
			$id("empname").value="";
			$id("taskName").value="";
			
			//清除JSP页面时间控件的值
			$id("reportStarttime_input").value="";
			$id("reportEndtime_input").value="";

			//清除传入后台的值
			$name("overTimeReport.reportStarttime").value="";
			$name("overTimeReport.reportEndtime").value="";
		}

		function downExl() {
			var reportStarttime = $id("reportStarttime_input").value;
			var reportEndtime = $id("reportEndtime_input").value;

			var custName = $id("custName").value;
			var empname = $id("empname").value;
			var taskName = $id("taskName").value;
			
			var url = "/timeMachine/tModelTimedayAction_queryOvertimeReportExcel.action?";
     		url += "overTimeReport.reportStarttime="+reportStarttime+"&overTimeReport.reportEndtime="+reportEndtime;
			url += "&overTimeReport.custName="+custName+"&overTimeReport.empname="+empname+"&overTimeReport.taskName="+taskName;
			window.location.href=url; 
		} 

		function select_taskname(){
	  		var taskName = $id("taskName").value;
	  		strUrl ="/timeMachine/tModelTimedayAction_selectTaskname.action?overTimeReport.taskName="+taskName;

			showModalCenter(encodeURI(strUrl),'',select_taskname_callback ,900,380,'流程节点选择'); 
		} 

		function select_taskname_callback(returnValue){
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