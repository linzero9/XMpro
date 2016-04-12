<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>受理审批台账列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/jbpm/xdProcessAction_queryXdStartProcessList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
                                        <td class="form_label" align="right" width="20%">上报日期：</td>
					<td colspan="1" width="30%">
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="repTimeStrat" name="DealApprovalDto.repTimeStrat" 
					property="DealApprovalDto.repTimeStrat" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="repTimeEnd" name="DealApprovalDto.repTimeEnd" 
					property="DealApprovalDto.repTimeEnd" /></td>

					<td class="form_label" align="right" width="20%">审批日期：</td>
					<td colspan="1" width="30%">
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="appTimeStrat" name="DealApprovalDto.appTimeStrat" 
					property="DealApprovalDto.appTimeStrat" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="appTimeEnd" name="DealApprovalDto.appTimeEnd" 
					property="DealApprovalDto.appTimeEnd" /></td>
					
					
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
			<w:panel id="panel" width="100%" title="受理审批台账列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/jbpm/xdProcessAction_queryXdStartProcessList.action" method="post">
			 <h:hiddendata property="xdProcessTaskAssignee"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">

		    
						<tr>
							<th align="center" nowrap="nowrap"  rowspan="2">
								<b:message key="l_select"></b:message>
							</th>
                                                        <th nowrap="nowrap" rowspan="2">
								机构名称
							</th>

                                                        <th nowrap="nowrap" rowspan="2">报单时间</th>
			   			 <th nowrap="nowrap" rowspan="2">是否加急</th>
			   			 <th nowrap="nowrap" rowspan="2">客户姓名</th>
			   			 <th nowrap="nowrap" rowspan="2">是否老客户</th>
			   			 <th nowrap="nowrap" rowspan="2">一级分类</th>
			   			 <th nowrap="nowrap" rowspan="2">贷款种类</th>
			   			 <th nowrap="nowrap" rowspan="2">申请币别</th>
			   			 <th nowrap="nowrap" rowspan="2">申请金额（万元）</th>
			   			 <th nowrap="nowrap" rowspan="2">区支行</th>
			   			 <th nowrap="nowrap" rowspan="2">受理支行</th>
			   			 <th nowrap="nowrap" rowspan="2">营销人员</th>
			   			 <th nowrap="nowrap" rowspan="2">主调</th>
			   			 <th nowrap="nowrap" rowspan="2">辅调</th>
			   			 <th nowrap="nowrap" rowspan="2">审查人</th>
			   			 <th nowrap="nowrap" rowspan="2">第二审查人</th>
			   <th nowrap="nowrap" rowspan="2">调查时间</th>
			   <th nowrap="nowrap" colspan="2">一次上报</th>
			   <th  nowrap="nowrap" rowspan="2">二次上报时间</th>
			   <th nowrap="nowrap" colspan="2">二次上报</th>
			   <th  nowrap="nowrap" rowspan="2">三次上报时间</th>
			    <th nowrap="nowrap" colspan="2">三次上报</th>
			   <th  nowrap="nowrap" rowspan="2">四次上报时间</th>
			    <th nowrap="nowrap" colspan="2">四次上报</th>
			   <th  nowrap="nowrap" rowspan="2">五次上报时间</th>
			    <th nowrap="nowrap" colspan="2">五次上报</th>
			    <th  nowrap="nowrap" rowspan="2">审查岗审结时间</th>
			   			 <th  nowrap="nowrap" rowspan="2">审批方式</th>
			   			 <th  nowrap="nowrap" rowspan="2">决策单编号</th>
			   			<th  nowrap="nowrap" rowspan="2">会议期数</th>
			   			 <th  nowrap="nowrap" rowspan="2">表决表编号</th>
			   			 <th  nowrap="nowrap" rowspan="2"> 会议时间/审批岗审结时间</th>
			   			<th  nowrap="nowrap" rowspan="2">审议事项</th>
			   			 <th  nowrap="nowrap" rowspan="2">贷审会秘书一</th>
			   			 <th  nowrap="nowrap" rowspan="2">贷审会秘书二</th>
			   			 <th  nowrap="nowrap" rowspan="2">第一审批人（会议审批委员）</th>
			   			 <th  nowrap="nowrap" rowspan="2">第二审批人（会议审批委员）</th>
			   			 <th  nowrap="nowrap" rowspan="2">会议审批主任委员</th>
			   			 <th  nowrap="nowrap" rowspan="2">会议审批委员</th>
			   			 <th  nowrap="nowrap" rowspan="2">会议审批委员</th>
			   			 <th  nowrap="nowrap" rowspan="2">上会地点</th>
			   			<th  nowrap="nowrap" rowspan="2">风险类型（低/非低风险业务）</th>
			   			 <th  nowrap="nowrap" rowspan="2">审批类型</th>
			   			 <th  nowrap="nowrap" rowspan="2">有表决权人数</th>
			   			 <th  nowrap="nowrap" rowspan="2">会议审议结论</th>
			   			 <th  nowrap="nowrap" rowspan="2">评级结论</th>
			   			 <th  nowrap="nowrap" rowspan="2">风险限额（万元）</th>
			   			 <th  nowrap="nowrap" rowspan="2">额度授信金额（万元）</th>
			   			<th  nowrap="nowrap" rowspan="2">业务金额（万元）</th>
			   			<th  nowrap="nowrap" rowspan="2">批复日期</th>
			   			 <th  nowrap="nowrap" rowspan="2">备注</th>
			   </tr>
			   <tr>
			   <th nowrap="nowrap">接收</th>
			   <th nowrap="nowrap">退回</th>
			   <th nowrap="nowrap">接收</th>
			   <th nowrap="nowrap">退回</th>
			   <th nowrap="nowrap">接收</th>
			   <th nowrap="nowrap">退回</th>
			   <th nowrap="nowrap">接收</th>
			   <th nowrap="nowrap">退回</th>
			   <th nowrap="nowrap">接收</th>
			   <th nowrap="nowrap">退回</th>



							
							
							
						</tr>
						<w:radioGroup id="group1">
                           <l:iterate property="xdProcessTaskAssignees" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap">
									<w:rowRadio>
										<h:param name='executionId' iterateId='id1' property='executionId' />
										<h:param name='processName' iterateId='id1' property='processName' />
										<h:param name='custName' iterateId='id1' property='custName' />
										<h:param name='apply_bal' iterateId='id1' property='apply_bal' />
										<h:param name='oneCategory' iterateId='id1' property='oneCategory' />
										<h:param name='loanCategory' iterateId='id1' property='loanCategory' />
										<h:param name='coorganization' iterateId='id1' property='coorganization' />
									</w:rowRadio>
								</td>
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
							</tr>
						</l:iterate>
						</w:radioGroup>
							<tr>
              <td colspan="23" class="command_sort_area">
              	<div class="h3"> 
              	<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
									<input type="button" class="button" value="修改受理审批台账信息" onclick="upt_loan_info();"/>
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
		  		var processName = row.getParam("processName");
		  		var custName = row.getParam("custName");
		  		var apply_bal = row.getParam("apply_bal");
		  		var oneCategory = row.getParam("oneCategory");
		  		var loanCategory = row.getParam("loanCategory");
		  		var coorganization = row.getParam("coorganization");

	            var strUrl = "/jbpm/xdProcessAction_toUptLoanInfo.action?xdProcessTaskAssignee.executionId="+executionId+"&xdProcessTaskAssignee.processName="+processName;
	            strUrl = strUrl+"&xdProcessTaskAssignee.custName="+custName
	            +"&xdProcessTaskAssignee.apply_bal="+apply_bal
	            +"&xdProcessTaskAssignee.oneCategory="+oneCategory
	            +"&xdProcessTaskAssignee.loanCategory="+loanCategory
	            +"&xdProcessTaskAssignee.coorganization="+coorganization;
	            
				  showModalCenter(encodeURI(strUrl), null,callBack, 500, 300, '修改受理审批台账信息');
				  
				  /* 	var url="/jbpm/xdProcessAction_toAddOneCategory.action?xdCdtypeBean.processName="+encodeURI(processName);
		  		parent.window.frames["mainFrame"].location.href = encodeURI(strUrl); 
		  		
		  		showModalCenter(encodeURI(strUrl), null, callBack, clientX*0.9, clientY*0.9, ''修改受理审批台账信息');*/	
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
		  		showModalCenter(strUrl,'',null ,1200,500,'受理审批台账修改流水明细');
			  	}
		  	}

	  	
		
		</script>
		
	</body>
</html>