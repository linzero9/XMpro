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
	<h:form name="appQuery"	action="/jbpm/xdProcessAction_queryXdMyToDoList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
					<td class="form_label" align="right" >客户名称：</td>
					<td >
						<h:text id="custName" property="xdProcessTaskAssignee.custName" />
					</td>
					
					<td class="form_label" align="right" >一级分类：</td>
					<td >
			     		<h:hidden id="oneCategoryId" property="xdProcessTaskAssignee.oneCategoryId" />  
						<h:text id="oneCategory" property="xdProcessTaskAssignee.oneCategory" readonly="true"/>
						<a href="#" onclick="showoneCategory();">选择</a>
					</td>
					
					<td class="form_label" align="right" >贷种分类：</td>
					<td >
						<h:hidden id="loanCategoryId" property="xdProcessTaskAssignee.loanCategoryId" />
						<h:text id="loanCategory" property="xdProcessTaskAssignee.loanCategory" readonly="true"/>
						<a href="#" onclick="showloanCategory();">选择</a>
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
			<w:panel id="panel" width="100%" title="信贷流程待办列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/jbpm/xdProcessAction_queryXdMyToDoList.action" method="post">
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
                           <l:iterate property="xdProcessTaskAssignees" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap">
									<w:rowRadio>
										<h:param name='id' iterateId='id1' property='id' />
										<h:param name='executionId' iterateId='id1' property='executionId' />
										<h:param name='nextTaskId' iterateId='id1' property='nextTaskId' />
										<h:param name='preTaskId' iterateId='id1' property='preTaskId' />
										<h:param name='preTaskAssingee' iterateId='id1' property='preTaskAssingee' />
										<h:param name='preTaskOrg' iterateId='id1' property='preTaskOrg' />
										<h:param name='preTaskTime' iterateId='id1' property='preTaskTime' />
										<h:param name='businessKey' iterateId='id1' property='businessKey' />
										<h:param name='businessType' iterateId='id1' property='businessType' />
										<h:param name='processTaskAssigneeId' iterateId='id1' property='processTaskAssigneeId' />
										<h:param name='parentId' iterateId='id1' property='parentId' />
										<h:param name='isChild' iterateId='id1' property='isChild' />
										<h:param name='assignee' iterateId='id1' property='assignee' />
										<h:param name='processName' iterateId='id1' property='processName' />
										<h:param name='businessTitle' iterateId='id1' property='businessTitle' />
										
									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="processName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="custName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="oneCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="loanCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="reportcnt" />
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

		//清空
		function clears(){
			$id("custName").value="";
			$id("oneCategory").value="";
			$id("oneCategoryId").value="";
			$id("loanCategory").value="";
			$id("loanCategoryId").value="";
		}
		
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
		  		showModalCenter(encodeURI(strUrl), null, callBack, clientX*0.95, clientY*0.9, '待办详情');
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
		  		showModalCenter(strUrl, null, null, clientX*0.95, clientY*0.9, '当前流程进度'); 
			  	}
		  	}

	  	function showoneCategory() {
			var oneCategoryId=document.getElementById("oneCategoryId").value;
			strUrl ="/Generalprocess/tGeneralprocessCdtypeAction_oneCategoryDic.action?cdtypeJson="+oneCategoryId,
			showModalCenter(strUrl,'',showoneCategory_callback1 ,800,430,'一级分类选择'); 
		} 
		function showoneCategory_callback1(args){
			if(args!=''){
			var array;
			array = args.split(":");
			 document.getElementById("oneCategoryId").value = array[0];
			 document.getElementById("oneCategory").value = array[1];
			}
		}	

		function showloanCategory() {
			var loanCategoryId=document.getElementById("loanCategoryId").value;
			strUrl ="/Generalprocess/tGeneralprocessCdtypeAction_loanCategoryDic.action?cdtypeJson="+loanCategoryId,
			showModalCenter(strUrl,'',showloanCategory_callback1 ,800,500,'贷种选择'); 
		} 
		function showloanCategory_callback1(args){
			if(args!=''){
			var array;
			array = args.split(":");
			 document.getElementById("loanCategoryId").value = array[0];
			 document.getElementById("loanCategory").value = array[1];
			}
		}
		</script>
		
	</body>
</html>