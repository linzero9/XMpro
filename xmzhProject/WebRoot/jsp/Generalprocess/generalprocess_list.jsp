<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath()%>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>流程列表</title>
</head>
<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"
		action="/Generalprocess/generalProcessAction_queryGeneralprocessList.action"
		method="post" >
		<h:hidden property="nameString" id="nameString" />
		<h:hidden property="isExport" id="isExport"/>
		<w:panel id="panel1" title="流程列表">
			<table align="center" border="0" width="100%" class="form_table">
			<tr>
					
					<td class="form_label" align="right" width="20%">审批时间：</td>
					<td colspan="1" width="30%">
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="appTimeStrat" name="generalprocessDto.appTimeStrat" 
					property="generalprocessDto.appTimeStrat" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="appTimeEnd" name="generalprocessDto.appTimeEnd" 
					property="generalprocessDto.appTimeEnd" /></td>
					<td class="form_label" align="right" width="20%">上报时间：</td>
					<td colspan="1" width="30%">
					从
					<w:date format="yyyy-MM-dd" submitFormat="yyyy-MM-dd" id="reporttimeStrat" name="generalprocessDto.reporttimeStrat" 
					property="generalprocessDto.reporttimeStrat" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyy-MM-dd" id="reporttimeEnd" name="generalprocessDto.reporttimeEnd" 
					property="generalprocessDto.reporttimeEnd" />
					</td>
				</tr>
				<tr>
					<td class="form_label" align="right">一级支行</td>
				            <td colspan="1">
				              <h:text id="orgNameOne" property="generalprocessDto.orgNameOne"   readonly="true" />
			                  <h:hidden id="orgCodeOne" property="generalprocessDto.orgCodeOne" />
			                  <h:hidden id="orgidOne" property="generalprocessDto.orgidOne" />
			  <a href="#" onclick="open_newyw_tree_fun1();">选择</a>
				            </td>
				    <td class="form_label" align="right">二级支行：</td>
				            <td colspan="1">
				              <h:text id="orgNameTwo" property="generalprocessDto.orgNameTwo"   readonly="true" />
			                  <h:hidden id="orgCodeTwo" property="generalprocessDto.orgCodeTwo" />
			                  <h:hidden id="orgidTwo" property="generalprocessDto.orgidTwo" />
			 		 <a href="#" onclick="open_newyw_tree_fun2();">选择</a>
				     </td>        
				</tr>
				<tr>
					<td class="form_label" align="right" width="20%">客户姓名：</td>
					<td colspan="1" width="30%"><h:text id="cust_Name" property="generalprocessDto.cust_Name" />
					</td>
					<td class="form_label" align="right">流程状态：</td>
						<td colspan="1">
						<d:select  id="isEnd"  dictTypeId="PROCESS_IsEnd" nullLabel="请选择" property="generalprocessDto.isEnd"></d:select>
					
						</td>
				</tr>
				
				<tr>
					<td class="form_label" align="right" width="20%">主调信贷员：</td>
					<td colspan="1" width="30%"><h:text id="creator" property="generalprocessDto.creator" />
					</td>
					<td class="form_label" align="right" width="20%">辅调信贷员：</td>
					<td colspan="1" width="30%"><h:text id="fdxdy" property="generalprocessDto.fdxdy" />
					</td>
				</tr>
				<tr>
					<td class="form_label" align="right" width="20%">第一审批人：</td>
					<td colspan="1" width="30%"><h:text id="dyApp" property="generalprocessDto.dyApp" />
					</td>
					<td class="form_label" align="right" width="20%">第二审批人：</td>
					<td colspan="1" width="30%"><h:text id="deApp" property="generalprocessDto.deApp" />
					</td>
				</tr>
				<tr>
					<td class="form_label" align="right" width="20%">第一审查人：</td>
					<td colspan="1" width="30%"><h:text id="dyCheck" property="generalprocessDto.dyCheck" />
					</td>
					<td class="form_label" align="right" width="20%">第二审查人：</td>
					<td colspan="1" width="30%"><h:text id="deCheck" property="generalprocessDto.deCheck" />
					</td>
				</tr>
				<%-- <tr>
					<td colspan="4" class="form_label" align="center" nowrap="nowrap" width="100%">一级分类</td>
					</tr>
					<tr>
					<td colspan="4" width="100%">
					<d:checkbox perrow="4" id="oneCategory"    name="generalprocessDto.oneCategory" dictTypeId="PROCESS_onecategory" property="generalprocessDto.oneCategory"  seperator=","  />
					</td>
				</tr> --%>
				<tr>
				<td class="form_label" align="right" width="20%">一级分类：</td>
					<td colspan="1" width="30%">
					<h:hidden id="oneCategory" property="generalprocessDto.oneCategory" />
					<h:text id="oneCategoryTxt" property="generalprocessDto.oneCategoryTxt" readonly="true"/>
					<a href="#" onclick="showoneCategory();">选择</a>
					</td>
					<td class="form_label" align="right" width="20%">贷种分类：</td>
					<td colspan="1" width="30%">
					<h:hidden id="loanCategory" property="generalprocessDto.loanCategory" />
					<h:text id="loanCategoryTxt" property="generalprocessDto.loanCategoryTxt" readonly="true"/>
					<a href="#" onclick="showloanCategory();">选择</a>
					</td>
				</tr>
				<tr>
					<%-- <td class="form_label" align="right" width="20%">发起时间：</td>
					<td colspan="1" width="30%">
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="minoperaterDateStrat" name="generalprocessDto.minoperaterDateStrat" 
					property="generalprocessDto.minoperaterDateStrat" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="minoperaterDateEnd" name="generalprocessDto.minoperaterDateEnd" 
					property="generalprocessDto.minoperaterDateEnd" /></td> --%>
					<td class="form_label" align="right" style="width:20%;" >
						流程名称：</td>
					<td colspan="1">
						<h:text id="processName" property="generalprocessDto.processName"/>
					</td>
					<td class="form_label" align="right" style="width:20%;" >
						支用类别：</td>
						<td colspan="1" width="30%">
						<h:hidden id="supportCategory" property="generalprocessDto.supportCategory" />
						<h:text id="supportCategoryTxt" property="generalprocessDto.supportCategoryTxt" readonly="true"/>
						<a href="#" onclick="showsupportCategory();">选择</a>
						</td>
							<%-- <d:checkbox perrow="12" id="supportCategory"  name="generalprocessDto.supportCategory" dictTypeId="PROCESS_pay" property="generalprocessDto.supportCategory"   seperator=", " />
					</td> --%>
				</tr>
				<%-- <tr>
					<td colspan="4" class="form_label" align="center" nowrap="nowrap" width="100%">贷种分类</td>
					</tr>
					<tr>
					<td colspan="4" width="100%">
					<d:checkbox perrow="4" id="oneCategory"    name="generalprocessDto.loanCategory" dictTypeId="PROCESS_credit_type" property="generalprocessDto.loanCategory"  seperator=","  />
					</td>
				</tr> --%>
				<tr class="form_bottom">
					<td colspan="4" class="form_bottom"><b:message
							key="l_display_per_page"></b:message> <h:text size="2"
							property="page.length" value="10"
							validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
						<input type="hidden" name="page.begin" value="0"> 
						<input type="hidden" name="page.isCount" value="true"> 
						<input id="querys" type="submit" value="查 询" class="button" onclick="search();"> 
						<input type="button" value="清 空" class="button" onclick="clears();">
						<input id="downexl" type="submit" class="button" value="导出列表" onclick="downExl();"></td>
				</tr>
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList" style="height: 43%;overflow:auto;width:100%;" >
		<w:panel id="panel" width="100%" title="查询结果">
			<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493"> <h:form
				name="page_form"
				action="/Generalprocess/generalProcessAction_queryGeneralprocessList.action"
				method="post">
				<h:hiddendata property="generalprocessDto.appTimeStrat" />
				<h:hiddendata property="generalprocessDto.appTimeEnd" />
				<h:hiddendata property="generalprocessDto.reporttimeStrat" />
				<h:hiddendata property="generalprocessDto.reporttimeEnd" />
				<h:hiddendata property="generalprocessDto.orgCodeOne" />
				<h:hiddendata property="generalprocessDto.orgCodeTwo" />
				<h:hiddendata property="generalprocessDto.cust_Name" />
				<h:hiddendata property="generalprocessDto.isEnd" />
				<h:hiddendata property="generalprocessDto.creator" />
				<h:hiddendata property="generalprocessDto.fdxdy" />
				<h:hiddendata property="generalprocessDto.dyApp" />
				<h:hiddendata property="generalprocessDto.deApp" />
				<h:hiddendata property="generalprocessDto.dyCheck" />
				<h:hiddendata property="generalprocessDto.deCheck" />
				<h:hiddendata property="generalprocessDto.oneCategory" />
				<h:hiddendata property="generalprocessDto.oneCategoryTxt" />
				<h:hiddendata property="generalprocessDto.loanCategory" />
				<h:hiddendata property="generalprocessDto.loanCategoryTxt" />
				<h:hiddendata property="generalprocessDto.supportCategory" />
				<h:hiddendata property="generalprocessDto.supportCategoryTxt" />
				<h:hiddendata property="generalprocessDto.processName" />
				<%-- <h:hiddendata property="generalprocessDto.minoperaterDateEnd" />
				<h:hiddendata property="generalprocessDto.minoperaterDateStrat" /> --%>
				<h:hidden property="page.begin" />
				<h:hidden property="page.length" />
				<h:hidden property="page.count" />
				<h:hidden property="page.isCount" />
				<table align="center" border="0" width="100%" class="EOS_table">
					<tr>
						<th align="center" nowrap="nowrap"><b:message key="l_select"></b:message>
						</th>
						<th nowrap="nowrap">标题</th>
						<th nowrap="nowrap">机构名称</th>
						<th nowrap="nowrap">客户经理</th>
						 <th nowrap="nowrap">客户名称</th>
						<th nowrap="nowrap">一级分类</th>
						<th nowrap="nowrap">贷种分类</th>
						<th nowrap="nowrap">币种</th>
						<th nowrap="nowrap">申请/支用金额（万元）</th>
						<th nowrap="nowrap">支用类别</th>
						<th nowrap="nowrap">当前节点名称</th>
						<th nowrap="nowrap">当前节点办理人</th>
						<th nowrap="nowrap">当前处理人机构</th>
						<!-- <th nowrap="nowrap">
								提交时间
							</th> -->
					</tr>
					<w:radioGroup id="group1">
						<l:iterate property="generalprocessDtos" id="id1">
							<tr
								class="<l:output oddOutput="EOS_table_row_o" evenOutput='EOS_table_row' />">
								<td align="center" nowrap="nowrap"><w:rowRadio>
										<h:param name='id' iterateId='id1' property='id' />
										<h:param name='executionId' iterateId='id1'
											property='executionId' />
										<h:param name='activityName' iterateId='id1'
											property='activityName' />
										<h:param name='currentActivityName' iterateId='id1'
											property='currentActivityName' />
										<h:param name='processName' iterateId='id1'
											property='processName' />
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
									
									
								<td nowrap="nowrap"><b:write iterateId="id1" property="businessTitle" /></td>
								<%-- <td nowrap="nowrap"> 
									<d:write dictTypeId="ZHPT_BUSINESS_TYPE"  property="businessType" iterateId="id1" />
								</td> --%>
								<td nowrap="nowrap"><b:write iterateId="id1" property="beginEmpname" /></td>
								<td nowrap="nowrap"><b:write iterateId="id1" property="beginOrgname" /></td>
								<td nowrap="nowrap"><b:write iterateId="id1" property="cust_Name" /></td>
								<td nowrap="nowrap"><b:write iterateId="id1" property="oneCategory" /></td>
								<td nowrap="nowrap"><b:write iterateId="id1" property="loanCategory" /></td>
								
								<td nowrap="nowrap">
								<d:write dictTypeId="PROCESS_MONEY" property="currency" iterateId="id1"/>
								</td>
								<td nowrap="nowrap">
								<b:write iterateId="id1" property="apply_bal" />
								</td>
								<td nowrap="nowrap">
								<d:write dictTypeId="PROCESS_pay" property="supportCategory" iterateId="id1"/>
								</td>
								<td nowrap="nowrap"><b:write iterateId="id1" property="currentActivityName" /></td>
								<td nowrap="nowrap"><b:write iterateId="id1" property="currentAssingee" /></td>
								<td nowrap="nowrap"><b:write iterateId="id1" property="preTaskOrgName" /></td>
							</tr>
						</l:iterate>
					</w:radioGroup>
					<tr>
						<td colspan="23" class="command_sort_area">
							<div class="h3">


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
				var processName = rows.getParam("processName");
				var businessType = rows.getParam("businessType");
				var activityName = rows.getParam("activityName");

				var strUrl = "/jbpm/jbpmDemoAction_viewBussinessDetail.action?isView="
						+ 1
						+ "&taskAssgineeDto.executionId="
						+ executionId
						+ "&taskAssgineeDto.taskName="
						+ activityName
						+ "&taskAssgineeDto.preTaskId="
						+ preTaskId
						+ "&taskAssgineeDto.businessType=" + businessType
						+ "&taskAssgineeDto.activityName=" + activityName;
				/**
				 * 2014.9.1 改为弹出框
				 **/
				showModalCenter(encodeURI(strUrl), null, callBack, 1050, 520,
						'已办详情');
			}
		}
		function callBack() {
		}

		function search(){
			$("#isExport").val("");
			}
		function downExl() {
			$("#isExport").val("1");
		}
		//选择	受理支行	二级选项
		function open_newyw_tree_fun2(){
			var strUrl ="";
			var objName="";
			var peArgument = [];
			var startOrgid=$("#startOrgid").val();
			strUrl ="/tree/initMainTree_mainTree.action?changeTree.showTabOrg=1&changeTree.orgType=4&changeTree.showSelBox=1&changeTree.checkcount=1&";
			objName="选择受理支行";  
			var paramEntity = new ParamEntity('Organization');
				paramEntity.setProperty('orgname',$id("orgNameTwo").value);
				paramEntity.setProperty('orgcode',$id("orgCodeTwo").value);
				peArgument[3]=[paramEntity,'orgname','orgcode',"orgid"];			
			showModalCenter(strUrl,peArgument,open_slzhej_callback2,600,430,objName); 
			}
		
		//受理支行		二级选项	回调方法
		function open_slzhej_callback2(arg){//回调方法
				if(arg!=''){
		    	if(arg['Organization']){ //原写法无需判断是否为空
				  		var sorgidArra  = arg['Organization'].slice(0);//人员数组
				  		argRes=[[],[],[],[]];
						for(var i=0;i<sorgidArra.length;i++){
							argRes[0].push(sorgidArra[i].getProperty("orgcode"));
							argRes[1].push(sorgidArra[i].getProperty("orgname"));
						}
						$id("orgNameTwo").value = argRes[1];
						$id("orgCodeTwo").value = argRes[0];
					}
		    	}
			}
		//选择	受理支行	二级选项
		function open_newyw_tree_fun1(){
			var strUrl ="";
			var objName="";
			var peArgument = [];
			strUrl ="/tree/initMainTree_mainTree.action?changeTree.showTabOrg=1&changeTree.orgType=4&changeTree.showSelBox=1&changeTree.checkcount=1";
			objName="选择受理支行";  
			var paramEntity = new ParamEntity('Organization');
				paramEntity.setProperty('orgname',$id("orgNameOne").value);
				paramEntity.setProperty('orgcode',$id("orgCodeOne").value);
				peArgument[3]=[paramEntity,'orgname','orgcode',"orgid"];			
			showModalCenter(strUrl,peArgument,open_slzhej_callback1,600,430,objName); 
			}
		
		//受理支行		二级选项	回调方法
		function open_slzhej_callback1(arg){//回调方法
				if(arg!=''){
		    	if(arg['Organization']){ //原写法无需判断是否为空
				  		var sorgidArra  = arg['Organization'].slice(0);//人员数组
				  		argRes=[[],[],[],[]];
						for(var i=0;i<sorgidArra.length;i++){
							argRes[0].push(sorgidArra[i].getProperty("orgcode"));
							argRes[1].push(sorgidArra[i].getProperty("orgname"));
						}
						$id("orgNameOne").value = argRes[1];
						$id("orgCodeOne").value = argRes[0];
					}
		    	}
			}
		function showloanCategory() {
			var loanCategory=document.getElementById("loanCategory").value;
			strUrl ="/Generalprocess/tGeneralprocessCdtypeAction_loanCategoryDic.action?cdtypeJson="+loanCategory,
			showModalCenter(strUrl,'',showloanCategory_callback1 ,800,430,'贷种选择'); 
		} 
		function showloanCategory_callback1(args){
			if(args!=''){
			var array;
			array = args.split(":");
			 document.getElementById("loanCategory").value = array[0];
			 document.getElementById("loanCategoryTxt").value = array[1];
			}
		}
		function showoneCategory() {
			var oneCategory=document.getElementById("oneCategory").value;
			strUrl ="/Generalprocess/tGeneralprocessCdtypeAction_oneCategoryDic.action?cdtypeJson="+oneCategory,
			showModalCenter(strUrl,'',showoneCategory_callback1 ,800,430,'一级分类选择'); 
		} 
		function showoneCategory_callback1(args){
			if(args!=''){
			var array;
			array = args.split(":");
			 document.getElementById("oneCategory").value = array[0];
			 document.getElementById("oneCategoryTxt").value = array[1];
			}
		}
		function showsupportCategory() {
			var supportCategory=document.getElementById("supportCategory").value;
			strUrl ="/Generalprocess/tGeneralprocessCdtypeAction_supportCategoryDic.action?cdtypeJson="+supportCategory,
			showModalCenter(strUrl,'',showsupportCategory_callback1 ,800,430,'支用类型'); 
		} 
		function showsupportCategory_callback1(args){
			if(args!=''){
			var array;
			array = args.split(":");
			 document.getElementById("supportCategory").value = array[0];
			 document.getElementById("supportCategoryTxt").value = array[1];
			}
		}
		function clears(){
			$("#appTimeStrat_input").val("");
			$("#appTimeStrat_hidden").val("");
			$("#appTimeEnd_input").val("");
			$("#appTimeEnd_hidden").val("");
			$("#reporttimeStrat_input").val("");
			$("#reporttimeStrat_hidden").val("");
			$("#reporttimeEnd_input").val("");
			$("#reporttimeEnd_hidden").val("");
/* 			$("#minoperaterDateStrat_input").val("");
			$("#minoperaterDateStrat_hidden").val("");
			$("#minoperaterDateEnd_input").val("");
			$("#minoperaterDateEnd_hidden").val(""); */
			$id("orgNameOne").value="";
			$id("orgidOne").value="";
			$id("orgCodeOne").value="";
			$id("orgNameTwo").value="";
			$id("orgidTwo").value="";
			$id("orgCodeTwo").value="";
			$id("cust_Name").value="";
			$id("isEnd").value="";
			$id("creator").value="";
			$id("fdxdy").value="";
			$id("dyApp").value="";
			$id("deApp").value="";
			$id("dyCheck").value="";
			$id("deCheck").value="";
			$id("oneCategory").value="";
			$id("loanCategory").value="";
			$id("oneCategoryTxt").value="";
			$id("loanCategoryTxt").value="";
			$id("supportCategory").value="";
			$id("supportCategoryTxt").value="";
		}
	</script>
</body>
</html>