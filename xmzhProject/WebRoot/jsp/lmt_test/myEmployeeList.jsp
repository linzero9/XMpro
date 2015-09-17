<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>我的员工列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="query_form"	action="/lmt_test/omEmployeeAction_myEmployeeList.action" method="post">
		<w:panel id="panel1" title="我的员工列表">
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
					<td class="form_label" align="right" width="20%">员工姓名：</td>
					<td colspan="1"  width="30%"><h:text id="empname" property="employee.empname" /></td>
				</tr>
				<tr class="form_bottom">
						<td colspan="4" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="submit" value="查 询" class="button">
							<input type="button" value="清 空" class="button" onclick="clears();">
							</td>
					</tr>		
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="查询结果">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/lmt_test/omEmployeeAction_myEmployeeList.action" method="post">
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
								员工编号
							</th>
							<th nowrap="nowrap">
								员工姓名
							</th>
							<th nowrap="nowrap">
								性别
							</th>
							<th nowrap="nowrap">
								证件号码
							</th>
						</tr>
						<w:radioGroup id="group1">
                            <l:iterate property="employees" id="id1">
							 <tr class="<l:output oddOutput="EOS_table_row_o" evenOutput='EOS_table_row' />">
								<td align="center" nowrap="nowrap">
									<w:rowRadio>
											<h:param name='empid' iterateId='id1' property='empid' />
									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="empcode" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="empname" />
								</td>
								<td nowrap="nowrap"> 
								     <d:write dictTypeId="ABF_GENDER" property="gender" iterateId="id1" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="cardno" />
								</td>
							</tr>
						</l:iterate>
						</w:radioGroup>
							<tr>
              <td colspan="23" class="command_sort_area">
							<div class="h3">
							<input type="button" class="button" value="新增"
										onclick="add();" />
								<l:greaterThan property="page.count" targetValue="0"
									compareType="number">
							<input type="button" class="button" value="修改"
										onclick="upt();" />
								</l:greaterThan>
								<l:greaterThan property="page.count" targetValue="0"
									compareType="number">
							<input type="button" class="button" value="删除"
										onclick="del();" />
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
				$id("empname").value="";
			}

			//新增员工
			function add(){
				  var url="/lmt_test/omEmployeeAction_toEmployee.action";
				  showModalCenter(url, null,callBackFunc, 700, 300, '新增员工');
			}

			//修改员工
			function upt(){
				var gop = $id("group1");
		  		var len = gop.getSelectLength();
		  		if(len == 0){
		  			alert("请选择一个员工");
		  			return;
		  		}else{
		  			var rows=gop.getSelectRow();
			  		var empid=rows.getParam("empid");
		  			var strUrl = "/lmt_test/omEmployeeAction_toEmployee.action?employee.empid="+empid;
		  			showModalCenter(strUrl, null, callBackFunc, 700, 300, '修改员工');  
			  	}
			}

			function callBackFunc(value){
		        var frm = $name("query_form");
		            frm.submit();
		    }

			//删除群组
			function del(){
				var gop = $id("group1");
		  		var len = gop.getSelectLength();
		  		if(len == 0){
		  			alert("请选择一个员工");
		  			return;
		  		}else{
		  			var rows=gop.getSelectRow();
		  			var empid=rows.getParam("empid");
		  			$.ajax({
					      url: "/lmt_test/omEmployeeAction_delete.action",
					      async: false,
					      type: 'post',
					      data: "employee.empid="+empid,
					      timeout: 60000,
					      dataType:"text",
					      success: function (data) {
					    	  if (data.indexOf("success") >= 0) {
					    		  alert("删除成功!");
					    		  //重新查询一遍，即刷新页面
					    		  var frm = $name("query_form");
						            frm.submit();
							} else if (data.indexOf("fails") >= 0) {
								alert("删除失败!");
							} else {
								alert("操作失败!");
							}
									  	
					      }
					}); 
			 		
			  	}
			}
			
		</script>
	</body>
</html>