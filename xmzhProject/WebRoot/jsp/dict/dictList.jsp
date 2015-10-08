<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>

<html>
 <head>
<title>设备属性列表</title>
</head>
<body>
	<w:panel id="list_panel1" width="100%" height="100%"title="设备属性列表">
		<w:layout height="100%" width="100%" type="horizontal">
			<w:layoutPanel width="50%">
				<div style="border:1px solid #dddddd;width:100%;height:100%">				
				<h:form name="query_formx" id="query_formx"
				action="/dict/eosDictEntryAction_dictTypeList.action"  target="_self" method="post" >
				<table align="center" border="0" width="100%" class="form_table">
					<tr>
						<td class="form_label" align="right">属性名称：</td>
						<td colspan="1"><h:text id="dictTypeName" property="dictType.dictTypeName" /></td>
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
				</h:form>
				<h:form name="formx_list" id="formx_list"
				action="/dict/eosDictEntryAction_dictEntryList.action"  target="_self" method="post" >
				<table align="center" border="0" width="100%" class="EOS_table">
					<tr>
						<th>选择</th>
						<th>属性名称</th>
					</tr>
					<w:radioGroup id="xgroup1">
						<l:iterate property="dictTypes" id="idx" indexId="index">
							<tr class="<l:output evenOutput='EOS_table_row' />">
								<td align="center"><w:rowRadio>
									<h:param name='dictTypeId' iterateId='idx' property='dictTypeId' />
								</w:rowRadio></td>
								<td><b:write iterateId="idx" property="dictTypeName" /></td>
							</tr>
						</l:iterate>
					</w:radioGroup>
					<tr>
						 <td colspan="23" class="command_sort_area">
						 <div class="h3">
							<l:greaterThan property="page.count" targetValue="0"
								compareType="number">
								<input type="button" value="查询属性值" onclick="queryEntry();" class="button">
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
				</div>
			</w:layoutPanel>
			<w:layoutPanel width="50%">
				<div style="border:1px solid #dddddd;width:100%;height:100%">
				<h:form name="formy_list" id="formy_list"
				action="/dict/eosDictEntryAction_dictTypeList.action"  target="_self" method="post" >
				
				<table align="center" border="0" width="100%" class="EOS_table">
					<tr>
						<th nowrap>选择</th>
						<th nowrap>项编号</th>
						<th nowrap>项名称</th>
					</tr>
					<w:radioGroup id="ygroup1">
						<l:iterate property="dictEntrys" id="idy" indexId="index">
							<tr class="<l:output evenOutput='EOS_table_row' />">
								<td align="center"><w:rowRadio>
									<h:param name='dictTypeId' iterateId='idy' property='dictTypeId' />
									<h:param name='dictId' iterateId='idy' property='dictId' />
								</w:rowRadio></td>
								<td><b:write iterateId="idy" property="dictId" /></td>
								<td><b:write iterateId="idy" property="dictName" /></td>
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
              </td>
					</tr>
				</table>
				</h:form>
				</div>
			</w:layoutPanel>
		</w:layout>
	</w:panel>
	</body>
	<script type="text/javascript">
	//清空
	function clears(){
		$id("dictTypeName").value="";
	}

	function queryEntry(){
		var gop = $id("group1");
  		var len = gop.getSelectLength();
  		if(len == 0){
  			alert("请选择一个属性");
  			return;
  		}else{
  			var frm = $name("query_formx");
  		 	frm.submit();
  			/*var rows=gop.getSelectRow();
	  		var dictTypeId=rows.getParam("dictTypeId");
  			var strUrl = "/deviceManagement/deviceManagementAction_toDevice.action?device.deviceId="+deviceId;
  			showModalCenter(strUrl, null, callBackFunc, 700, 600, '修改设备');  
  			*/
	  	}
	}
	</script>
</html>
