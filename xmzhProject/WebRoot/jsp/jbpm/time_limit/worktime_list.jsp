<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>工作时间配置列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="query_form"	action="/jbpm/timeLimitManageAction_queryWorkTimeList.action" method="post">
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
					action="/jbpm/timeLimitManageAction_queryWorkTimeList.action" method="post">
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
								时间类型
							</th>
							<th nowrap="nowrap">
								开始时间
							</th>
							<th nowrap="nowrap">
								结束时间
							</th>
						</tr>
					<w:radioGroup id="group1">
                          <l:iterate property="workTimeMaintainBeans" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap" width="5%">
								<w:rowRadio>
										<h:param name='id' iterateId='id1' property='id' />
										<h:param name='mainID' iterateId='id1' property='mainID' />
									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="startDate" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="endDate" />
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" dictTypeId="TIMELIMIT_TIMETYPE"  property="timeType"   />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="startTime" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="endTime" />
								</td>
							</tr>
						</l:iterate>
					</w:radioGroup>
						<tr>
              <td colspan="23" class="command_sort_area">
							<div class="h3">
								&nbsp; &nbsp;
								<input type="button" class="button" value="新增" onclick="add();" />
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
								<input type="button" class="button" value="删除" onclick="del();" />
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

		function add(){
			var strUrl = "/jbpm/timeLimitManageAction_toAddWorkTime.action";
  			showModalCenter(strUrl, null, callBackFunc, 800, 400, '新增');  
		}

		function callBackFunc(){
	        var frm = $name("query_form");
	            frm.submit();
	    }
	    	
	  	function del(){
	  		var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条记录");
	  			return;
	  		}else{
	  		  if(confirm("确定要删除该项吗？")){
	    			var row=gop.getSelectRow();
	    			var id = row.getParam("id");
	    			var mainID = row.getParam("mainID");  
		    			
		  	  		$.ajax({
		  			      url: "/jbpm/timeLimitManageAction_deleteWorkTime.action",
		  			      async: false,
		  			      type: 'post',
		  			      data: "workTimeMaintainBean.id="+id+"&workTimeMaintainBean.mainID="+mainID,
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

		</script>
	</body>
</html>