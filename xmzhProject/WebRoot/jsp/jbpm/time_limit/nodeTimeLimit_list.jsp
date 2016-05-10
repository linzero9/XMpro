<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>流程节点列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="流程节点列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/jbpm/timeLimitManageAction_queryNodeTimeLimitList.action" method="post">
					
					<h:hiddendata property="proTimeModelBean" />
					
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
					<td class="form_label"  >时限模版名称：<b:write  property="proTimeModelBean.time_modelName"  /></td>
				</tr>
			</table>
			
					<table align="center" border="0" width="100%" class="EOS_table">
						<tr>
							<th align="center" nowrap="nowrap">
								<b:message key="l_select"></b:message>
							</th>
							<th nowrap="nowrap">
								节点名称
							</th>
							<th nowrap="nowrap">
								时限（单位：工时）
							</th>
							<th nowrap="nowrap">
								二次提交时限（单位：工时）
							</th>
						</tr>
					<w:radioGroup id="group1">
                          <l:iterate property="nodeTimeLimitBeans" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap" width="5%">
								<w:rowRadio>
										<h:param name='e_id' iterateId='id1' property='e_id' />
										<h:param name='c_id' iterateId='id1' property='c_id' />
										<h:param name='taskName' iterateId='id1' property='taskName' />
										<h:param name='timeLimit' iterateId='id1' property='timeLimit' />
										<h:param name='twotimeLimit' iterateId='id1' property='twotimeLimit' />
									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="taskName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="timeLimit" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="twotimeLimit" />
								</td>
							</tr>
						</l:iterate>
					</w:radioGroup>
						<tr>
              <td colspan="23" class="command_sort_area">
							<div class="h3">
							<l:equal property="nodeTimeLimitBeans.size" targetValue="0">
								<input type="button" class="button" value="设置节点时限"   onclick="setNodeTimeLimit();" disabled="disabled"/>
							</l:equal>
							<l:notEqual property="nodeTimeLimitBeans.size" targetValue="0">
								<input type="button" class="button" value="设置节点时限"   onclick="setNodeTimeLimit();" />
				</l:notEqual>
						 <input  type="button" value="关闭" onclick="window.close();" class="button">		
							</div>
              </td>
            </tr>
					</table>
				</h:form>
				</viewlist>
			</w:panel>		
		</DIV>
		<script type="text/javascript">

	  	function setNodeTimeLimit(){
	  		var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条节点信息");
	  			return;
	  		}else{
	  			var rows=gop.getSelectRow();
	  			
	  			var e_id = rows.getParam("e_id");
		  		var c_id = rows.getParam("c_id");
		  		var taskName = rows.getParam("taskName");
		  		var timeLimit = rows.getParam("timeLimit");
		  		var twotimeLimit = rows.getParam("twotimeLimit");

		  		var strUrl = "/jbpm/timeLimitManageAction_toSetNodeTimeLimit.action?nodeTimeLimitBean.timeLimit="+timeLimit + "&nodeTimeLimitBean.taskName=" + taskName + "&nodeTimeLimitBean.e_id=" + e_id +"&nodeTimeLimitBean.c_id="+c_id+"&nodeTimeLimitBean.twotimeLimit="+twotimeLimit;
		  		 
		  		showModalCenter(encodeURI(strUrl), null,callBackFunc, 500, 300, '设置节点时限'); 
			 }
		 }
	  	
	  	function callBackFunc(){
	        var frm = $name("page_form");
	            frm.submit();
	    }

		</script>
	</body>
</html>