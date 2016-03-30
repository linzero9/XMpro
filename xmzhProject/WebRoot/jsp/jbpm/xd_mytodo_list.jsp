<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>信贷流程待办列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/jbpm/tProcessTaskAssigneeAction_queryMyToDoTasksList.action" method="post">
		<w:panel id="panel1" title="信贷流程待办列表">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
					<td class="form_label" align="right" >客户名称：</td>
					<td >
						<h:text id="taskAssignee.businessTitle" property="taskAssignee.businessTitle" />
					</td>
					
					<td class="form_label" align="right" >一级分类：</td>
					<td >
						<h:text id="taskAssignee.businessTitle" property="taskAssignee.businessTitle" />
					</td>
					
					<td class="form_label" align="right" >贷种分类：</td>
					<td >
						<h:text id="taskAssignee.businessTitle" property="taskAssignee.businessTitle" />
					</td>
				</tr>
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="submit" value="查 询" class="button">
							<input type="button" value="清 空" class="button" onclick="clears();"></td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="查询结果">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/jbpm/tProcessTaskAssigneeAction_queryMyToDoTasksList.action" method="post">
				 <h:hiddendata property="taskAssignee.preTaskAssingeeName"/>

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
								信贷流程名称
							</th>
							<th nowrap="nowrap">
								客户名称
							</th>
							<th nowrap="nowrap">
								一级分类
							</th>
							<th nowrap="nowrap">
								贷种分类
					</th>
							<th nowrap="nowrap">
								上报次数
							</th>
							<th nowrap="nowrap">
								提交人姓名
							</th>
								<th nowrap="nowrap">
								提交人所属机构
							</th>
							<th nowrap="nowrap">
								提交时间
							</th>
							
						</tr>
						<w:radioGroup id="group1">
                           <l:iterate property="processTaskAssignees" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap">
									<w:rowRadio>
										<h:param name='id' iterateId='id1' property='id' />
									

									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="businessTitle" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="processName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="processName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="processName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="processName" />
								</td>
									<td nowrap="nowrap">
									<b:write iterateId="id1" property="preTaskAssingeeName" />
								</td>
								<td nowrap="nowrap">
									<b:write iterateId="id1" property="preTaskOrgName" />
								</td>
								<td nowrap="nowrap">
									<b:write iterateId="id1" property="preTaskTime"  formatPattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
							</tr>
						</l:iterate>
						</w:radioGroup>
							<tr>
              <td colspan="23" class="command_sort_area">
              	<div class="h3"> 
              	<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
									<input type="button" class="button" value="办理" onclick="handleTask();"/>
								</l:greaterThan>
							
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
							<input type="button" class="button" value="查看流程进度" onclick="viewTaskProcess();"/>
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

		function handleTask(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条待办信息");
	  			return;
	  		}else{
		  		var rows=gop.getSelectRow();
		  		var businessKey=rows.getParam("businessKey");
		  		var nextTaskId = rows.getParam("nextTaskId");
		  		var executionId = rows.getParam("executionId");
		  		var businessType = rows.getParam("businessType");
		  		var preTaskAssingee = rows.getParam("preTaskAssingee");
		  		var processTaskAssigneeId = rows.getParam("processTaskAssigneeId");
		  		var parentId = rows.getParam("parentId");
		  		var isChild = rows.getParam("isChild");
		  		var assignee = rows.getParam("assignee");

		  		var businessTitle = rows.getParam("businessTitle");
		  	
		  		
		  		

		  		var processName = rows.getParam("processName");

	            var strUrl = "/jbpm/jbpmDemoAction_handle.action?taskAssgineeDto.businessKey="+businessKey + "&taskAssgineeDto.nextTaskId=" + nextTaskId + "&taskAssgineeDto.executionId=" + executionId + "&taskAssgineeDto.businessType=" + businessType + "&taskAssgineeDto.taskAssingee=" + preTaskAssingee+"&taskAssgineeDto.processTaskAssigneeId="+processTaskAssigneeId+"&taskAssgineeDto.parentId="+parentId+"&taskAssgineeDto.isChild="+isChild+"&taskAssgineeDto.preTaskAssingee="+assignee+"&taskAssgineeDto.businessTitle="+businessTitle;

		  		strUrl+="&taskAssgineeDto.processName="+processName;

		  		/* parent.window.frames["mainFrame"].location.href = encodeURI(strUrl); */	
		  		/**
				* 2014.9.1 改为弹出框
				**/
		  		showModalCenter(encodeURI(strUrl), null, callBack, clientX*0.9, clientY*0.9, '待办详情');
			}
		}
		function callBack(){
			  location.reload();
			}

	  	function viewTaskProcess(){
	  		var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条待办信息");
	  			return;
	  		}else{
	  			var rows=gop.getSelectRow();
		  		var executionId = rows.getParam("executionId");
		  		var strUrl = "/jbpm/jbpmDemoAction_viewTask.action?executionId="+executionId;
		  		showModalCenter(strUrl, null, null, clientX*0.9, clientY*0.9, '当前流程进度'); 
			  	}
		  	}
		</script>
	</body>
</html>