<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>信贷流程列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="query_form"	action="/jbpm/xdProcessAction_queryXdProcessList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
					<td class="form_label" align="right" >信贷流程名称：</td>
					<td ><h:text id="processName" property="xdProcessBean.processName" /></td>
				</tr>
					<tr>
							<td colspan="2" class="form_bottom">
							每页显示
							<h:text size="2" property="page.length" value="10"
								validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
							<input type="hidden" name="page.begin" value="0">
							<input type="hidden" name="page.isCount" value="true">
							<input type="submit" id="btn" class="button" value='查询'>
						</td>
			</tr>
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="信贷流程发布列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/jbpm/xdProcessAction_queryXdProcessList.action" method="post">
					<h:hidden property="page.begin" />
					<h:hidden property="page.length" />
					<h:hidden property="page.count" />
					<h:hidden property="page.isCount" />
					<h:hiddendata property="xdProcessBean"/>
					<table align="center" border="0" width="100%" class="EOS_table">
						<tr>
							<th align="center" nowrap="nowrap">
								<b:message key="l_select"></b:message>
							</th>
							<th nowrap="nowrap">
								流程名称
							</th>
							<th nowrap="nowrap">
								业务类型
							</th>
							<th nowrap="nowrap">
								状态
							</th>
							<th nowrap="nowrap">
								提交时间
							</th>
						</tr>
					<w:radioGroup id="group1">
                          <l:iterate property="xdProcessBeans" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap" width="5%">
								<w:rowRadio>
										<h:param name='definitionId' iterateId='id1' property='definitionId' />
									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="processName" />
								</td>
								<td nowrap="nowrap"> 
									<d:write dictTypeId="ZHPT_BUSINESS_TYPE" iterateId="id1" property="businessType" />
								</td>
								<td nowrap="nowrap"> 
									<d:write dictTypeId="ZHPT_PROCESS_STATE" iterateId="id1" property="state" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="uploadTime" formatPattern="yyyy-MM-dd HH:mm:ss" />
								</td>
							</tr>
						</l:iterate>
					</w:radioGroup>
						<tr>
              <td colspan="23" class="command_sort_area">
							<div class="h3">
								&nbsp; &nbsp;
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
								<input type="button" class="button" value="选择参数维护"
									onclick="selectParaManage();" />
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

		//选择参数维护	
	  	function selectParaManage(){
	  		var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条流程信息");
	  			return;
	  		}else{
	  			var rows=gop.getSelectRow();
		  		var definitionId=rows.getParam("definitionId");
	  			var strUrl = "/jbpm/xdProcessAction_toSelectParaManage.action?xdProcessBean.definitionId="+definitionId;
	  			showModalCenter(strUrl, null, callBackFunc, 700, 550, '一级分类/贷级分类两级联动维护');  
		  		//parent.window.frames["mainFrame"].location.href = encodeURI(strUrl);	//新弹出一个IE窗口
		  	}
		 }

	  	function callBackFunc(){
	        var frm = $name("query_form");
	            frm.submit();
	    }
		</script>
	</body>
</html>