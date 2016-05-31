<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>受理审批台账列表</title>
	</head>
	<body topmargin="0" leftmargin="0"   >
	<h:form name="appQuery"	action="/reportjbpm/approvalAction_queryApprovalList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
				
				<td class="form_label" align="right" >一级分类：</td>
					<td >
			     		<h:hidden id="oneCategoryId" />  
						<h:text id="oneCategory" property="approval.oneCategory" readonly="true"/>
						<a href="#" onclick="showoneCategory();">选择</a>
					</td>
					
					<td class="form_label" align="right" >贷种分类：</td>
					<td >
						<h:hidden id="loanCategoryId"/>
						<h:text id="loanCategory" property="approval.loanCategory" readonly="true"/>
						<a href="#" onclick="showloanCategory();">选择</a>
					</td>
                   
					<tr>
					                     <td class="form_label" align="right" width="20%">报单日期：</td>
					<td colspan="1" width="30%">
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyy-MM-dd" id="repTimeStrat" name="approval.repTimeStrat" 
					property="approval.repTimeStrat" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyy-MM-dd" id="repTimeEnd" name="approval.repTimeEnd" 
					property="approval.repTimeEnd" /></td>

					<td class="form_label" align="right" width="20%">审批日期：</td>
					<td colspan="1" width="30%">
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyy-MM-dd" id="appTimeStrat" name="approval.appTimeStrat" 
					property="approval.appTimeStrat" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyy-MM-dd" id="appTimeEnd" name="approval.appTimeEnd" 
					property="approval.appTimeEnd" /></td>
					
					</tr>
				</tr>
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="submit" value="查 询" class="button" onclick="search();">
							<input type="button" value="清 空" class="button" onclick="clears();">
                                                        <input id="downexl" type="button" class="button" value="导出列表" onclick="downExl();"></td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList"   style="overflow-y:scroll;height: 70%"   >
			<w:panel id="panel" width="100%" title="受理审批台账列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/reportjbpm/approvalAction_queryApprovalList.action" method="post">
			 <h:hiddendata property="approval"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">

		    
						<tr>
							
                          <th nowrap="nowrap" rowspan="2">标题</th>
                          <th nowrap="nowrap" rowspan="2">机构名称</th>
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
			   			 <th nowrap="nowrap" rowspan="2">营销人员机构</th>
			   			 
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
						
                           <l:iterate property="approvalList" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="title" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="nextOrgName" />
								</td>
								<td nowrap="nowrap"> 
						
								
									
									<fmt:formatDate value="${id1.reportTime}" pattern="yyyy年MM月dd日"/>
								</td>
								<td nowrap="nowrap">
								<d:write iterateId="id1" property="isurgent" dictTypeId="ZHPT_ISURGENT" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="custName" />
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" property="oldCust" dictTypeId="ZHPT_LGK" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="oneCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="loanCategory" />
								</td>
								
								<td nowrap="nowrap">
								<d:write iterateId="id1" property="currency" dictTypeId="PROCESS_MONEY"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"  property="applyBal" />
							
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgNameOne" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgNameTwo" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="yxry" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="yxryjg" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="nextOprName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="fdxdy" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="checkOne" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="checkTwo" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="surveyTime" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="receiveOne" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="returnOne" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="reportedTwo" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="receiveTwo" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="returnTwo" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="reportedThree" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="receiveThree" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="returnThree" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="reportedFour" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="receiveFour" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="returnFour" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="reportedFive" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="receiveFive" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="returnFive" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="checkTime" />
								</td>
								
								<td nowrap="nowrap">
								<d:write iterateId="id1" property="appWay" dictTypeId="PROCESS_method"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="polNo" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="meetingCount" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="voteNo" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="appTime" />
								</td>
								
								<td nowrap="nowrap">
								<d:write iterateId="id1" property="conMatter" dictTypeId="PROCESS_Consideration"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="dsMsOne" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="dsMsTwo" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="dyApp" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="deApp" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="hyZrName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="hyWyOne" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="shAddr" />
								</td>
								
								<td nowrap="nowrap">
								<d:write iterateId="id1" property="fxType" dictTypeId="PROCESS_risk"/>
								</td>
							
								<td nowrap="nowrap">
								<d:write iterateId="id1" property="spType" dictTypeId="PROCESS_approve"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="ybjNum" />
								</td>
								
								<td nowrap="nowrap">
								<d:write iterateId="id1" property="hySyJl" dictTypeId="PROCESS_conclusion"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="pjJl" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="fxEd" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="sxEd" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="ywEd" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="replyTime" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="" />
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
	                <l:equal property="page.isCount" targetValue="true">
		                <input type="button" class="button" onclick="firstPage('page', '', null, null, 'page_form');" value='<b:message key="l_firstPage"></b:message>'  <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
		                <input type="button" class="button" onclick="prevPage('page', '', null, null, 'page_form');" value='<b:message key="l_upPage"></b:message>' <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
		                <input type="button" class="button" onclick="nextPage('page', '', null, null, 'page_form');" value='<b:message key="l_nextPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
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
			//清空JSP页面时间控件显示的值
			$("#repTimeStrat_input").val("");
			$("#repTimeEnd_input").val("");
			$("#appTimeStrat_input").val("");
			$("#appTimeEnd_input").val("");

			//清空传入后台的时间控件的值
			$name("approval.repTimeStrat").value = "";
			$name("approval.repTimeEnd").value = "";
			$name("approval.appTimeStrat").value = "";
			$name("approval.appTimeEnd").value = "";
		}
                function search(){
			$("#isExport").val("");
			}
                function downExl() {
                	//报单开始日期
    				var repTimeStrat = $id("repTimeStrat").value;
    				//报单结束日期
    				var repTimeEnd = $id("repTimeEnd").value;
                	//审批开始日期
    				var appTimeStrat = $id("appTimeStrat").value;
    				//审批结束日期
    				var appTimeEnd = $id("appTimeEnd").value;
    				//一级分类
    				var oneCategory = $id("oneCategory").value;
    				var loanCategory = $id("loanCategory").value;
    				//贷种分类
    				var strUrl = "/reportjbpm/approvalAction_queryApprovalListForExcel.action?";
    					  if(repTimeStrat!=null){
    	                    	 strUrl=strUrl+"&approval.repTimeStrat="+repTimeStrat;
    	                         }
    	    				
    	    				if(repTimeEnd!=null){
    	    					strUrl=strUrl+"&approval.repTimeEnd="+repTimeEnd;
    	        				} 
    				
    					  if(appTimeStrat!=null){
    	                    	 strUrl=strUrl+"&approval.appTimeStrat="+appTimeStrat;
    	                         }
    	    				
    	    				if(appTimeEnd!=null){
    	    					strUrl=strUrl+"&approval.appTimeEnd="+appTimeEnd;
    	        				} 
    	    				if(oneCategory!=null){
    	    					strUrl=strUrl+"&approval.oneCategory="+oneCategory;
    	        				} 
    	    				if(appTimeEnd!=null){
    	    					strUrl=strUrl+"&approval.loanCategory="+loanCategory;
    	        				} 
    				
    				window.location.href=strUrl;
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