<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>岗位工作量统计列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/reportjbpm/jobWorkloadAction_jobWorkloadLists.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
                                        <td class="form_label" align="right" width="20%">报单日期：</td>
					<td colspan="1" width="30%">
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyy-MM-dd" id="appTimeStrat" name="jobWorkload.appTimeStrat" 
					property="jobWorkload.appTimeStrat" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyy-MM-dd" id="appTimeEnd" name="jobWorkload.appTimeEnd" 
					property="jobWorkload.appTimeEnd" /></td>

					
					
					<td class="form_label" align="right" >流程节点：</td>
					<td >
			     		                   
						<h:text id="processNodeName" property="jobWorkload.processNodeName" readonly="true" name="jobWorkload.processNodeName"/>
						<a href="#" onclick="showProcessrode();">选择</a>
					</td>
					
					
				</tr>
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="button" value="查 询" class="button" onclick="search();">
							<input type="button" value="清 空" class="button" onclick="clears();">
                            <input id="downexl" type="button" class="button" value="导出列表" onclick="downExl();"></td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="岗位工作量统计列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/reportjbpm/jobWorkloadAction_jobWorkloadLists.action" method="post">
			 <h:hiddendata property="jobWorkload"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">
		    
						<tr>					
							<th nowrap="nowrap" >
								时    间
							</th>
							<th nowrap="nowrap">
								一级分类
							</th>
							<th nowrap="nowrap">
								贷种分类
							</th>
							<th nowrap="nowrap">
								流程节点
					       </th>
					       <th nowrap="nowrap">
								人员姓名
							</th>
                            <th nowrap="nowrap">
								1次业务数量 
							</th>
						  <th nowrap="nowrap">
								2次业务数量 
							</th>
						  <th nowrap="nowrap">
								3次业务数量 
							</th>
						  <th nowrap="nowrap">
								4次业务数量 
							</th>
							 <th nowrap="nowrap">
								5次业务数量 
							</th>
                                                  
						</tr>
						<w:radioGroup id="group1">
                           <l:iterate property="jobWorkloadList" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
							 <td nowrap="nowrap"> 
							     ${starttime}      ${endtime} 
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="oneCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="loanCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="processNodeName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="personName" />
								</td>
								<td nowrap="nowrap"> 
							         <b:write iterateId="id1" property="businessNumberOne" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="businessNumberTwo" />
								</td>
								 <td nowrap="nowrap"> 
									<b:write iterateId="id1" property="businessNumberThree" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="businessNumberFour" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="businessNumberFive" />
								</td>
							</tr>
						</l:iterate>
						</w:radioGroup>
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

		$(function(){


			});
		
		//清空
		function clears(){
			$id("appTimeStrat_input").value="";
			$id("appTimeEnd_input").value="";
			$id("processNodeName").value="";

		}
                function search(){
       	   		 var appTimeStrat = $id("appTimeStrat").value;
    		     var appTimeEnd = $id("appTimeEnd").value;  
       	         if((appTimeStrat!=null && appTimeStrat!="") && (appTimeEnd!=null && appTimeEnd!="")){
    	             
    	    	     var star=appTimeStrat.replaceAll("-","");
    	    	     var end=appTimeEnd.replaceAll("-","");
    	              if(star>end){
    	                  alert("开始时间大于结束时间,请重新输入！");
    	                 // $id("appTimeEnd_input").value="";
    	                 // $id("appTimeEnd_input").value="";
    	                  return;
    	                  }
    	         }

                    
        			var frm = $name("appQuery");
                    frm.submit();
    
                    return;
			}
                function downExl() {
     				var appTimeStrat = $id("appTimeStrat").value;
    				var appTimeEnd = $id("appTimeEnd").value;
    				var processNodeName = $id("processNodeName").value;
    			//	var loanCategory = $id("loanCategory").value;
    				
    				var url = "/reportjbpm/jobWorkloadAction_jobWorkloadExcel.action?";

                     if(appTimeStrat!=null){
                    	 url = url+"&jobWorkload.appTimeStrat="+appTimeStrat;
                         }
    				if(appTimeEnd!=null){
    					url = url+"&jobWorkload.appTimeEnd="+appTimeEnd;
        				}	
    	     		url = url+"&jobWorkload.processNodeName="+processNodeName;
    	     		//url = url+"&rateofreturnReport.loanCategory="+loanCategory;
    				window.location.href=url; 
			
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
	            
				  showModalCenter(encodeURI(strUrl), null,callBack, 500, 300, '修改岗位工作量信息');
				  
				  /* 	var url="/jbpm/xdProcessAction_toAddOneCategory.action?xdCdtypeBean.processName="+encodeURI(processName);
		  		parent.window.frames["mainFrame"].location.href = encodeURI(strUrl); 
		  		
		  		showModalCenter(encodeURI(strUrl), null, callBack, clientX*0.9, clientY*0.9, ''修改岗位工作量信息');*/	
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
		  		showModalCenter(strUrl,'',null ,1200,500,'岗位工作量修改流水明细');
			  	}
		  	}

	  	function showProcessrode() {
	  		//var processNodeName=document.getElementById("processNodeName").value;
	  		//strUrl ="/reportjbpm/jobWorkloadAction_jobWorkloadNodeName.action？processNodeName="+processNodeName;
	  
	  		strUrl ="/reportjbpm/jobWorkloadAction_jobWorkloadNodeName.action";

	  		//alert(strUrl);
			showModalCenter(strUrl,'',showErrorlink_callback1 ,900,380,'流程节点选择'); 
		} 
		function showErrorlink_callback1(returnValue){
			if(returnValue == ""){
				//点击右上角关闭时,returnValue为null
				//不做操作
				$id("processNodeName").value="";
			}else{
				$id("processNodeName").value= returnValue[0];
			
			}
			}
		
		</script>
		
	</body>
</html>