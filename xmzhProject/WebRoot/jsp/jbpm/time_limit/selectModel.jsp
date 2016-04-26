<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>选择模版</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="选择模版">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/jbpm/timeLimitManageAction_ querySelectModel.action" method="post">
					
					<h:hidden id="definitionId" property="proLoanBean.definitionId" />
					<h:hidden id="processName" property="proLoanBean.processName" />
					
					<table align="center" border="0" width="100%" class="EOS_table">
						<tr>
							<th align="center" nowrap="nowrap">
								<b:message key="l_select"></b:message>
							</th>
							<th nowrap="nowrap">
								时限模版名称
							</th>
						</tr>
					<w:radioGroup id="group1">
                          <l:iterate property="proTimeModelBeans" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap" width="5%">
								<w:rowRadio>
										<h:param name='c_id' iterateId='id1' property='c_id' />
										<h:param name='time_modelName' iterateId='id1' property='time_modelName' />
									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="time_modelName" />
								</td>
							</tr>
						</l:iterate>
					</w:radioGroup>
						<tr>
              <td colspan="23" class="command_sort_area">
							<div class="h3">
							<l:equal property="proTimeModelBeans.size" targetValue="0">
								<input type="button" class="button" value="选择"   onclick="my_select();"  disabled="disabled"/>
							</l:equal>
							<l:notEqual property="proTimeModelBeans.size" targetValue="0">
									<input type="button" class="button" value="选择"   onclick="my_select();" />
						</l:notEqual>
					
						 <input  type="button" value="新增模版" onclick="addModel();" class="button">		
							</div>
              </td>
            </tr>
					</table>
				</h:form>
				</viewlist>
			</w:panel>		
		</DIV>
		<script type="text/javascript">

	  	function my_select(){
	  		var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条记录");
	  			return;
	  		}else{
	  			var rows=gop.getSelectRow();
	  			
		  		var c_id = rows.getParam("c_id");
		  		var time_modelName = rows.getParam("time_modelName");
		  		var processName = $id("processName").value;
		  		var definitionId = $id("definitionId").value;

		  		var strUrl = "/jbpm/timeLimitManageAction_ toTimeLimitManage.action?proTimeModelBean.time_modelName="+time_modelName +"&proTimeModelBean.c_id="+c_id;
		  		strUrl += "&proLoanBean.processName="+processName+"&proLoanBean.definitionId="+definitionId;
		  		showModalCenter(encodeURI(strUrl), null, '', 900, 500, '时限管理配置');  
			 }
		 }
	  	
	  	function addModel(){
	  		var definitionId = $id("definitionId").value;
	  		var strUrl = "/jbpm/timeLimitManageAction_ addLoanTimeModel.action?proTimeModelBean.definitionId="+definitionId;
	  		showModalCenter(strUrl, null, callBackFunc, 500, 300, '新增模版');  
		 }

	  	function callBackFunc(){
	  		var frm = $name("page_form");
            frm.submit();
	  	}
		</script>
	</body>
</html>