<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath()%>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>我的已办</title>
</head>
<body topmargin="0" leftmargin="0">

<h:hidden  id="curr_empid"  property="${muo.empid }"/>

	<h:form name="appQuery"
		action="/jbpm/tProcessTaskAssigneeAction_queryMyCompletedTasksList.action"
		method="post">
		<h:hidden property="nameString" id="nameString" />
		<w:panel id="panel1" title="我的已办">
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
					<td class="form_label" align="right" width="20%">提交人姓名：</td>
					<td colspan="1" width="30%"><h:text id="assingeeName"
							property="taskAssignee.preTaskAssingeeName" /></td>
					<td class="form_label" align="right" width="20%">提交机构名称：</td>
					<td colspan="1" width="30%"><h:text id="orgName"
							property="taskAssignee.preTaskOrgName" /></td>
				</tr>
				<tr>
					<td class="form_label" align="right" width="20%">开始时间：</td>
					<td colspan="1" width="30%">从<w:date format="yyyy-MM-dd"
							submitFormat="yyyyMMdd" id="d1" name="taskAssignee.startTime"
							property="taskAssignee.startTime" /> 到<w:date
							format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="d2"
							name="taskAssignee.startTimeAfter"
							property="taskAssignee.startTimeAfter" /></td>
					<td class="form_label" align="right" width="20%">结束时间：</td>
					<td colspan="1" width="30%">从<w:date format="yyyy-MM-dd"
							submitFormat="yyyyMMdd" id="d3" name="taskAssignee.endTime"
							property="taskAssignee.endTime" /> 到<w:date format="yyyy-MM-dd"
							submitFormat="yyyyMMdd" id="d4" name="taskAssignee.endTimeAfter"
							property="taskAssignee.endTimeAfter" /></td>
				</tr>
				<tr>
					<td class="form_label" align="right" width="15%">工作事项类型：</td>
					<td colspan="1" width="30%">
					<d:select dictTypeId="ZHPT_BUSINESS_TYPE" id="businessType"
							name="taskAssignee.businessType"
							property="taskAssignee.businessType" nullLabel="请选择"></d:select>
				<%-- 	<h:select id="businessType"
							name="taskAssignee.businessType"
							property="taskAssignee.businessType">
							<h:option label="未选择" value="" />
							<h:option label="信息发布" value="01" />
							<h:option label="督办管理" value="02" />
							<h:option label="工作月报" value="03" />
							<h:option label="会议申请" value="04" />
							<h:option label="数据申请" value="05" />
							<h:option label="数据下发" value="06" />
							<h:option label="设备申请" value="07" />
							<h:option label="请假流程" value="08" />
						</h:select> --%>
						
						</td>
						<td class="form_label" align="right" width="20%">标题：</td>
					<td colspan="1" width="30%"><h:text id="businessTitle"
							property="taskAssignee.businessTitle" /></td>
				</tr>
				<%-- <tr>
					<td class="form_label" align="right" width="20%">提交时间</td>
					<td colspan="1"  width="30%"><w:date format="yyyy-MM-dd"submitFormat="yyyyMMdd" name="taskAssignee.preTaskTimeStart" property="taskAssignee.preTaskTimeStart" /></td>
					<td class="form_label" align="right" width="20%">提交时间</td>
					<td colspan="1"  width="30%"><w:date format="yyyy-MM-dd" submitFormat="yyyyMMdd" name="taskAssignee.preTaskTimeEnd" property="taskAssignee.preTaskTimeEnd" /></td>
				</tr> --%>
				<tr class="form_bottom">
					<td colspan="4" class="form_bottom"><b:message
							key="l_display_per_page"></b:message> <h:text size="2"
							property="page.length" value="10"
							validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
						<input type="hidden" name="page.begin" value="0"> <input
						type="hidden" name="page.isCount" value="true"> <input
						id="querys" type="submit" value="查 询" class="button"> <input
						type="button" value="清 空" class="button" onclick="clears();">
						<input id="downexl" type="button" class="button" value="导出列表"
						onclick="downExl();"></td>
				</tr>
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
		<w:panel id="panel" width="100%" title="查询结果">
			<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493"> <h:form
				name="page_form"
				action="/jbpm/tProcessTaskAssigneeAction_queryMyCompletedTasksList.action"
				method="post">
				<h:hiddendata property="taskAssignee.preTaskAssingeeName" />
				<h:hiddendata property="taskAssignee.preTaskOrgName" />
				<h:hiddendata property="taskAssignee.startTime" />
				<h:hiddendata property="taskAssignee.endTime" />
				<h:hiddendata property="taskAssignee.startTimeAfter" />
				<h:hiddendata property="taskAssignee.endTimeAfter" />
				<h:hiddendata property="taskAssignee.businessType" />

				<h:hidden property="page.begin" />
				<h:hidden property="page.length" />
				<h:hidden property="page.count" />
				<h:hidden property="page.isCount" />
				<table align="center" border="0" width="100%" class="EOS_table">
					<tr>
						<th align="center" nowrap="nowrap"><b:message key="l_select"></b:message>
						</th>
						<th nowrap="nowrap">标题</th>
						<!-- <th nowrap="nowrap">
								工作事项类型
							</th> -->
						<th nowrap="nowrap">流程名称</th>
						<th nowrap="nowrap">当前节点名称</th>
						<th nowrap="nowrap">当前节点办理人</th>
						<th nowrap="nowrap">提交人姓名</th>
						<th nowrap="nowrap">提交人所属机构</th>
						<th nowrap="nowrap">开始时间</th>
						<th nowrap="nowrap">结束时间</th>
						<!-- <th nowrap="nowrap">
								提交时间
							</th> -->
					</tr>
					<w:radioGroup id="group1">
						<l:iterate property="processTaskAssignees" id="id1">
							<tr
								class="<l:output oddOutput="EOS_table_row_o" evenOutput='EOS_table_row' />">
								<td align="center" nowrap="nowrap"><w:rowRadio>
										<h:param name='id' iterateId='id1' property='id' />
										<h:param name='processName' iterateId='id1'
											property='processName' />
										<h:param name='executionId' iterateId='id1'
											property='executionId' />
										<h:param name='activityName' iterateId='id1'
											property='activityName' />
										<h:param name='currentActivityName' iterateId='id1'
											property='currentActivityName' />
										<h:param name='preTaskId' iterateId='id1' property='preTaskId' />
										<h:param name='businessType' iterateId='id1'
											property='businessType' />
										<h:param name='businessKey' iterateId='id1'
											property='businessKey' />
										<h:param name='activityName' iterateId='id1'
											property='activityName' />
										<h:param name='preTaskAssingee' iterateId='id1'
											property='preTaskAssingee' />
										<h:param name='nextTaskId' iterateId='id1'
											property='nextTaskId' />
										<h:param name='taskExeConfigId' iterateId='id1'
											property='taskExeConfigId' />
										<h:param name='preTaskAssingeeName' iterateId='id1'
											property='preTaskAssingeeName' />
										<h:param name='currentAssingee' iterateId='id1'
											property='currentAssingee' />
										<h:param name='nextTaskId' iterateId='id1'
											property='nextTaskId' />
										<h:param name='oldTaskId' iterateId='id1'
											property='oldTaskId' />
									</w:rowRadio></td>
								<td nowrap="nowrap"><b:write iterateId="id1"
										property="businessTitle" /></td>
								<%-- <td nowrap="nowrap"> 
									<d:write dictTypeId="ZHPT_BUSINESS_TYPE"  property="businessType" iterateId="id1" />
								</td> --%>
								<td nowrap="nowrap"><b:write iterateId="id1"
										property="processName" /></td>
								<td nowrap="nowrap"><b:write iterateId="id1"
										property="currentActivityName" /></td>
								<td nowrap="nowrap"><b:write iterateId="id1"
										property="currentAssingee" /></td>
								<td nowrap="nowrap"><b:write iterateId="id1"
										property="preTaskAssingeeName" /></td>
								<td nowrap="nowrap"><b:write iterateId="id1"
										property="preTaskOrgName" /></td>
								<td nowrap="nowrap"><b:write iterateId="id1"
										property="startTime" formatPattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td nowrap="nowrap"><b:write iterateId="id1"
										property="endTime" formatPattern="yyyy-MM-dd HH:mm:ss" /></td>

							</tr>
						</l:iterate>
					</w:radioGroup>
					<tr>
						<td colspan="23" class="command_sort_area">
							<div class="h3">
<!--
								<l:greaterThan property="page.count" targetValue="0"
									compareType="number">
								&nbsp; &nbsp;
							<input type="button" class="button" value="回退"
										onclick="handleTask();" />
								</l:greaterThan>
  -->
  
  
  
                        <l:greaterThan property="page.count" targetValue="0"
									compareType="number">
								&nbsp; &nbsp;
							<input type="button" class="button" value="流程收回"
										onclick="backOver();" />
								</l:greaterThan>
								
								
								<l:greaterThan property="page.count" targetValue="0"
									compareType="number">
								&nbsp; &nbsp;
							<input type="button" class="button" value="查看流程"
										onclick="viewTaskProcess();" />
								</l:greaterThan>

								<l:greaterThan property="page.count" targetValue="0"
									compareType="number">
								&nbsp; &nbsp;
							<input type="button" class="button" value="查看详情"
										onclick="viewBussinessDetail();" />
								</l:greaterThan>
							</div>
							<div class="h4">
								<l:equal property="page.isCount" targetValue="true">
									<b:message key="l_total"></b:message>
									<b:write property="page.count" />
									<b:message key="l_recordNO."></b:message>
									<b:write property="page.currentPage" />
									<b:message key="l_page"></b:message>
									<b:write property="page.totalPage" />
									<b:message key="l_page"></b:message>
								</l:equal>
								<l:equal property="page.isCount" targetValue="false">
									<b:message key="l_NO."></b:message>
									<b:write property="page.currentPage" />
									<b:message key="l_page"></b:message>
								</l:equal>
								<input type="button" class="button"
									onclick="firstPage('page', '', null, null, 'page_form');"
									value='<b:message key="l_firstPage"></b:message>'
									<l:equal property="page.isFirst"  targetValue="true">disabled</l:equal>>
								<input type="button" class="button"
									onclick="prevPage('page', '', null, null, 'page_form');"
									value='<b:message key="l_upPage"></b:message>'
									<l:equal property="page.isFirst"  targetValue="true">disabled</l:equal>>
								<input type="button" class="button"
									onclick="nextPage('page', '', null, null, 'page_form');"
									value='<b:message key="l_nextPage"></b:message>'
									<l:equal property="page.isLast"  targetValue="true">disabled</l:equal>>
								<l:equal property="page.isCount" targetValue="true">
									<input type="button" class="button"
										onclick="lastPage('page', '', null, null, 'page_form');"
										value='<b:message key="l_lastPage"></b:message>'
										<l:equal property="page.isLast"  targetValue="true">disabled</l:equal>>
								</l:equal>
							</div>
						</td>
					</tr>
				</table>
			</h:form> </viewlist>
		</w:panel>
	</DIV>
	<script type="text/javascript">
	function clears(){
		
		$("#assingeeName").val("");
		$("#orgName").val("");
		$("#businessType").val("");
		$("#businessTitle").val("");
		//清空 时间控件页面显示的值
		$("#d1_input").val("");
		$("#d2_input").val("");
		$("#d3_input").val("");
		$("#d4_input").val("");
		//清空时间控件 传入后台的值
		$name("taskAssignee.startTime").value = "";
		$name("taskAssignee.endTime").value = "";
		$name("taskAssignee.startTimeAfter").value = "";
		$name("taskAssignee.endTimeAfter").value = "";

		}
		function winclose() {
			window.close();
		}
		function viewTaskProcess() {
			var gop = $id("group1");
			var len = gop.getSelectLength();
			if (len == 0) {
				alert("请选择一条流程信息");
				return;
			} else {
				var rows = gop.getSelectRow();
				var executionId = rows.getParam("executionId");
				var strUrl = "/jbpm/jbpmDemoAction_viewTask.action?executionId="
						+ executionId;
				showModalCenter(strUrl, null, null, 900, 400, '当前流程进度');
			}
		}

		function handleTask() {
			var gop = $id("group1");
			var len = gop.getSelectLength();
			var rows = gop.getSelectRow();
			var businessKey = rows.getParam("businessKey");
			var nextTaskId = rows.getParam("nextTaskId");
			var executionId = rows.getParam("executionId");
			var businessType = rows.getParam("businessType");
			var preTaskAssingee = rows.getParam("preTaskAssingee");
			var processTaskAssigneeId = rows.getParam("taskExeConfigId");
			var currentAssingee = rows.getParam("currentAssingee");
			var preTaskAssingeeName = rows.getParam("preTaskAssingeeName");
			var currentActivityName = rows.getParam("currentActivityName");
			var activityName = rows.getParam("activityName");
			var nameString = $id('nameString').value;
			
			if (len == 0) {
				alert("请选择一条待办信息");
				
				return;
			} 
			else if(currentAssingee == preTaskAssingeeName){
				alert("请到待办事项中操作该流程");
				return;
				}
			else if(currentActivityName == activityName){
				alert("该流程已结束");
				return;
				}
			else if(preTaskAssingeeName != nameString){
				
				alert("无法操作回退他人流程");
				return;
				}
			else if(nextTaskId != '')
			{	
		    	
				//var parentId = rows.getParam("parentId");
				//var isChild = rows.getParam("isChild");
				//var assignee = rows.getParam("assignee");
				var strUrl = "/jbpm/jbpmDemoAction_handle.action?taskAssgineeDto.businessKey="
						+ businessKey
						+ "&taskAssgineeDto.nextTaskId="
						+ nextTaskId
						+ "&taskAssgineeDto.executionId="
						+ executionId
						+ "&taskAssgineeDto.businessType="
						+ businessType
						+ "&taskAssgineeDto.taskAssingee="
						+ preTaskAssingee
						+ "&taskAssgineeDto.processTaskAssigneeId="
						+ processTaskAssigneeId
						+ "&taskAssgineeDto.isChild="
						+ '0'
						+"&taskAssgineeDto.isC="
						+'1';
				/* parent.window.frames["mainFrame"].location.href = encodeURI(strUrl); */
				/**
				 * 2014.9.1 改为弹出框
				 **/
				showModalCenter(encodeURI(strUrl), null, callBack,
						clientX * 0.8, clientY * 0.65, '待办详情');
				
				}
			else {
			
				alert("该流程已结束");
				return;
			}
		}
		function callBack() {
			location.reload();
		}

		
		function viewBussinessDetail() {
			var gop = $id("group1");
			var len = gop.getSelectLength();
			if (len == 0) {
				alert("请选择一条流程信息");
				return;
			} else {
				var rows = gop.getSelectRow();
				var executionId = rows.getParam("executionId");
				var activityName = rows.getParam("activityName");
				var currentActivityName = rows.getParam("currentActivityName");
				var preTaskId = rows.getParam("preTaskId");
				var businessType = rows.getParam("businessType");
				var activityName = rows.getParam("activityName");

				var processName = rows.getParam("processName");
				
				
				var strUrl = "/jbpm/jbpmDemoAction_viewBussinessDetail.action?isView="
						+ 1
						+ "&taskAssgineeDto.executionId="
						+ executionId
						+ "&taskAssgineeDto.taskName="
						+ activityName
						+ "&taskAssgineeDto.preTaskId="
						+ preTaskId
						+ "&taskAssgineeDto.businessType=" + businessType
						+ "&taskAssgineeDto.activityName=" + activityName
						+ "&taskAssgineeDto.processName=" + processName;
				/**
				 * 2014.9.1 改为弹出框
				 **/
				showModalCenter(encodeURI(strUrl), null, callBack, clientX*0.95, clientY*0.9,
						'已办详情');
			}
		}
		function callBack() {
		}

		function downExl() {
			var url = "/jbpm/tProcessTaskAssigneeAction_downexl.action?";
			var assingeeName = $("#assingeeName").val();
			var orgName = $("#orgName").val();
			var businessType = $("#businessType").val();
			var businessTitle = $("#businessTitle").val();
			var startTime1 = $("#d1_input").val().replaceAll("-", "");
			var endTime1 = $("#d2_input").val().replaceAll("-", "");
			var startTime2 = $("#d3_input").val().replaceAll("-", "");
			var endTime2 = $("#d4_input").val().replaceAll("-", "");
			url = url + "taskAssignee.preTaskAssingeeName="
					+ encodeURI(assingeeName) + "&taskAssignee.preTaskOrgName="
					+ encodeURI(orgName) + "&taskAssignee.startTime="
					+ startTime1 + "&taskAssignee.startTimeAfter=" + endTime1
					+ "&taskAssignee.endTime=" + startTime2
					+ "&taskAssignee.endTimeAfter=" + endTime2
					+ "&taskAssignee.businessTitle=" + businessTitle
					+ "&taskAssignee.businessType=" + businessType;
			window.location.href = url;

		}



//流程回退，撤销
		function backOver() {
			var gop = $id("group1");
			var len = gop.getSelectLength();
			if (len == 0) {
				alert("请选择一条流程信息");
				return;
			} else {
				var rows = gop.getSelectRow();
				var businessType = rows.getParam("businessType");

				var preTaskAssingee = rows.getParam("preTaskAssingee");
				var preTaskAssingeeName =  rows.getParam("preTaskAssingeeName");
				
				var executionId = rows.getParam("executionId");
				var activityName = rows.getParam("activityName");
				var currentActivityName = rows.getParam("currentActivityName");
				var preTaskId = rows.getParam("preTaskId");
				var businessKey = rows.getParam("businessKey");
				var nextTaskId = rows.getParam("nextTaskId");
			//	var activityName = rows.getParam("activityName");
				var processName = rows.getParam("processName");
				
				if(businessType == "88"){
					alert("该流程为信贷流程，不能收回！");
					return ;
				}else if(preTaskAssingeeName.indexOf("开始") != -1 ){ //包含“开始”
					alert("上个节点为开始节点，无法收回！");
					return;
			}else if(currentActivityName == "结束"){
				alert("流程已经结束，无法收回！");
				return;
			}else if(preTaskAssingee != $id("curr_empid").value){
				alert("您不是上个节点办理人，无权收回！");
				return;
			}else{
				if (confirm("确定要收回该流程吗？")) {

					$.ajax({
						url : "/jbpm/jbpmDemoAction_backOver.action",
						async : false,
						type : 'post',
						data : "isView=1&taskAssgineeDto.executionId=" + executionId+
								 "&taskAssgineeDto.taskName="+ currentActivityName+
								 "&taskAssgineeDto.preTaskId="+ preTaskId+
								 "&taskAssgineeDto.businessType=" + businessType+
								 "&taskAssgineeDto.activityName=" + activityName+
								 "&taskAssgineeDto.processName=" + processName+
								 "&taskAssgineeDto.nextTaskId="+nextTaskId+
								 "&taskAssgineeDto.businessKey="+businessKey+
								 "&taskAssgineeDto.preTaskAssingee="+preTaskAssingee,
						timeout : 60000,
						dataType : "text",
						success : function(data) {
							if (data.indexOf("success") >= 0) {
								alert("收回成功");
								callBackFunc();
							} else if (data.indexOf("fails") >= 0) {
								alert("收回失败!");
							} else {
								alert("操作失败!");
							}

						}
					});
				}
					
				/* 	var strUrl = "/jbpm/jbpmDemoAction_backOver.action?isView="
						+ 1
						+ "&taskAssgineeDto.executionId="
						+ executionId
						+ "&taskAssgineeDto.taskName="
						+ currentActivityName
						+ "&taskAssgineeDto.preTaskId="
						+ preTaskId
						+ "&taskAssgineeDto.businessType=" + businessType
						+ "&taskAssgineeDto.activityName=" + activityName
						+ "&taskAssgineeDto.processName=" + processName
						+ "&taskAssgineeDto.nextTaskId="+nextTaskId;

				window.location.href = strUrl; */
				
			}
		}
}
		function callBackFunc() {
			var frm = $name("appQuery");
			frm.submit();
			
		}
	</script>
</body>
</html>