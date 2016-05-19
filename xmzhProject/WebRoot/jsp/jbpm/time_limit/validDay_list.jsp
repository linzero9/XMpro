<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>有效日列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="query_form"	action="/jbpm/timeLimitManageAction_queryValidDayList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
					<td class="form_label" align="right" width="40%">有效日范围：</td>
					<td ><w:date id="query_startDate" property="time.query_startDate"/> 
					至<w:date id="query_endDate" property="time.query_endDate"/>
					&nbsp; 注：日期包前不包后
					</td>
				</tr>
					<tr>
							<td colspan="2" class="form_bottom">
							每页显示
							<h:text size="2" property="page.length" value="10"
								validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
							<input type="hidden" name="page.begin" value="0">
							<input type="hidden" name="page.isCount" value="true">
							<input type="submit" id="btn" class="button" value='查询' >
							<input type="button" id="btn" class="button" value='清空' onclick="clears();">
						</td>
			</tr>
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="工作时间配置列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/jbpm/timeLimitManageAction_queryValidDayList.action" method="post">
					<h:hidden property="page.begin" />
					<h:hidden property="page.length" />
					<h:hidden property="page.count" />
					<h:hidden property="page.isCount" />
					<h:hiddendata property="time"/>
					<table align="center" border="0" width="100%" class="EOS_table">
						<tr>
							<th align="center" nowrap="nowrap">
								<b:message key="l_select"></b:message>
							</th>
							<th nowrap="nowrap">
								有效日开始日期
							</th>
							<th nowrap="nowrap">
								有效日结束日期
							</th>
							<th nowrap="nowrap">
								维护机构
							</th>
							<th nowrap="nowrap">
								维护员工
							</th>
						</tr>
					<w:radioGroup id="group1">
                          <l:iterate property="workTimeMainBeans" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap" width="5%">
								<w:rowRadio>
										<h:param name='id' iterateId='id1' property='id' />
										<h:param name='startDate' iterateId='id1' property='startDate' />
										<h:param name='endDate' iterateId='id1' property='endDate' />
									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="startDate" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="endDate" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgname" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="empname" />
								</td>
							</tr>
						</l:iterate>
					</w:radioGroup>
						<tr>
              <td colspan="23" class="command_sort_area">
							<div class="h3">
								&nbsp; &nbsp;
								<input type="button" class="button" value="新增有效日" onclick="addValidDay();" />
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
								<input type="button" class="button" value="修改有效日" onclick="uptValidDay();" />
								<input type="button" class="button" value="删除有效日" onclick="delValidDay();" />
								<input type="button" class="button" value="维护工作时间" onclick="addWorkTime();" />
								<input type="button" class="button" value="查看工作时间" onclick="queryWorkTimeList();" />
								<!-- <input type="button" class="button" value="维护工作日" onclick="addWorkDay();" />
								<input type="button" class="button" value="查看工作日" onclick="queryWorkDayList();" /> -->
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

		function clears(){
			//让JSP页面的时间输入框 清空
			$("#query_startDate_input").val("");
			$("#query_endDate_input").val("");

			//让时间传入后台的值 清空
			$name("time.query_startDate").value = "";
			$name("time.query_endDate").value = "";
			}

		function addValidDay(){
			var strUrl = "/jbpm/timeLimitManageAction_toAddValidDay.action";
  			showModalCenter(strUrl, null, callBackFunc, 500, 200, '新增有效日');  
		}

		function addWorkTime(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条记录");
	  			return;
	  		}else{
	  			var row=gop.getSelectRow();
    			var id = row.getParam("id");
    			var startDate = row.getParam("startDate");
    			var endDate = row.getParam("endDate");
    			
				var strUrl = "/jbpm/timeLimitManageAction_toAddWorkTime.action?workTimeSideBean.mainID="+id;
				strUrl += "&workTimeMainBean.startDate="+startDate+"&workTimeMainBean.endDate="+endDate;
	  			showModalCenter(strUrl, null, '', 800, 400, '维护工作时间');  
	  		}
		}

		function uptValidDay(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条记录");
	  			return;
	  		}else{
	  			var row=gop.getSelectRow();
    			var id = row.getParam("id");
    			
				var strUrl = "/jbpm/timeLimitManageAction_toUptValidDay.action?workTimeMainBean.id="+id;
	  			showModalCenter(strUrl, null, callBackFunc, 500, 200, '修改有效日');  
	  		}
		}

		/* function addWorkDay(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条记录");
	  			return;
	  		}else{
	  			var row=gop.getSelectRow();
    			var id = row.getParam("id");
    			var startDate = row.getParam("startDate");
    			var endDate = row.getParam("endDate");
    			
				var strUrl = "/timeMachine/tModelTimedayAction_toAddWorkDay.action?day.mainID="+id;
				strUrl += "&day.startDate="+startDate+"&day.endDate="+endDate;
	  			showModalCenter(strUrl, null, '', 800, 400, '新增');  
	  		}
		} */
		
		function callBackFunc(){
	        var frm = $name("query_form");
	            frm.submit();
	    }
	    	
	  	function delValidDay(){
	  		var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条记录");
	  			return;
	  		}else{
	  		  if(confirm("确定要删除该项吗？")){
	    			var row=gop.getSelectRow();
	    			var id = row.getParam("id");
		    			
		  	  		$.ajax({
		  			      url: "/jbpm/timeLimitManageAction_deleteValidDay.action",
		  			      async: false,
		  			      type: 'post',
		  			      data: "workTimeMainBean.id="+id,
		  			      timeout: 60000,
		  			      dataType:"text",
		  			      success: function (data) {
		  			    	  if (data.indexOf("success") >= 0) {
		  			    		  alert("删除成功");
		  			    		  callBackFunc();
		  					} else if (data.indexOf("fails") >= 0) {
		  						alert("删除失败!");
		  					} else {
		  						alert("操作失败!");
		  					}
		  							  	
		  			      }
		  			}); 
		    	}
	  				
		  	}
		 }

	  	function queryWorkTimeList(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条记录");
	  			return;
	  		}else{
	  			var row=gop.getSelectRow();
    			var id = row.getParam("id");
				var strUrl = "/jbpm/timeLimitManageAction_queryWorkTimeList.action?workTimeMainBean.id="+id;
	  			showModalCenter(strUrl, null, '', 800, 400, '工作时间列表');  
	  		}
		}

	  	/* function queryWorkDayList(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条记录");
	  			return;
	  		}else{
	  			var row=gop.getSelectRow();
    			var id = row.getParam("id");
				var strUrl = "/timeMachine/tModelTimedayAction_queryWorkDayList.action?day.mainID="+id;
	  			showModalCenter(strUrl, null, '', 1000, 400, '工作日列表');  
	  		}
		} */
	  	
		</script>
	</body>
</html>