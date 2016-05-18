<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>节假日配置列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="query_form"	action="/timeMachine/tModelTimedayAction_queryWorkDayList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
					<td class="form_label" align="right" width="40%">时间范围：</td>
					<td ><w:date id="startDate" property="day.startDate"  submitFormat="yyyy/MM/dd"  srcFormat="yyyy/MM/dd"  /> 
					至<w:date id="endDate" property="day.endDate"  submitFormat="yyyy/MM/dd"  srcFormat="yyyy/MM/dd" />
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
			<w:panel id="panel" width="100%" title="维护列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/timeMachine/tModelTimedayAction_queryWorkDayList.action" method="post">
					<h:hidden property="page.begin" />
					<h:hidden property="page.length" />
					<h:hidden property="page.count" />
					<h:hidden property="page.isCount" />
					<h:hiddendata property="day"/>
					<table align="center" border="0" width="100%" class="EOS_table">
						<tr>
							<th align="center" nowrap="nowrap">
								<b:message key="l_select"></b:message>
							</th>
							<th nowrap="nowrap">
								时间
							</th>
							<th nowrap="nowrap">
								类型(周末/节假日/自定义节假日)
							</th>
							<th nowrap="nowrap">
								是否在用
							</th>
							<th nowrap="nowrap">
								维护机构
							</th>
							<th nowrap="nowrap">
								维护人员
							</th>
							<th nowrap="nowrap">
								备注
							</th>
						</tr>
					
					<l:equal property="page.count"  targetValue="0"  compareType="number">
					 	<tr bgcolor="#FFE4E1">
					 		<td colspan="20"  align="center">无记录！</td>
					 	</tr>
					 </l:equal>
					 
					<l:notEqual property="days.size"  targetValue="0"  compareType="number">
					<w:radioGroup id="group1">
                          <l:iterate property="days" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap" width="5%">
								<w:rowRadio>
										<h:param name='id' iterateId='id1' property='id' />
										<h:param name='startDate' iterateId='id1' property='startDate' />
										<h:param name='endDate' iterateId='id1' property='endDate' />
									</w:rowRadio>
								</td>
								
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="time"   />
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" property="type"  dictTypeId="TIMEDAY_TYPE"/>
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1"    property="status"  dictTypeId="TIMEDAY_STATUS" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgname" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="empname" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="remark" />
								</td>
							</tr>
						</l:iterate>
					</w:radioGroup>
					</l:notEqual>
						<tr>
              <td colspan="23" class="command_sort_area">
							<div class="h3">
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
								<input type="button" class="button" value="新增" onclick="addWorkDay();" />
								<input type="button" class="button" value="修改" onclick="uptWorkDay();" />
								<input type="button" class="button" value="删除" onclick="delWorkDay();" />
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
			$("#startDate_input").val("");
			$("#endDate_input").val("");

			//让时间传入后台的值 清空
			$name("day.startDate").value = "";
			$name("day.endDate").value = "";
			}
		
		function addWorkDay(){
    			
				var strUrl = "/timeMachine/tModelTimedayAction_toAddWorkDay.action";
	  			showModalCenter(strUrl, null, callBackFunc, 800, 400, '新增');  
	  		}
	  		
		function uptWorkDay(){
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
    			
				var strUrl = "/timeMachine/tModelTimedayAction_toUpdateWorkDay.action?day.id="+id;
				strUrl += "&day.startDate="+startDate+"&day.endDate="+endDate;
	  			showModalCenter(strUrl, null, callBackFunc, 800, 400, '修改');  
	  		}
		}

		function delWorkDay(){
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
		  			      url: "/timeMachine/tModelTimedayAction_delWorkDay.action",
		  			      async: false,
		  			      type: 'post',
		  			      data: "day.id="+id,
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

		function callBackFunc(){
	        var frm = $name("query_form");
	            frm.submit();
	    }
		</script>
	</body>
</html>