<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>设备列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="query_form"	action="/deviceManagement/deviceManagementAction_deviceList.action" method="post">
		<w:panel id="panel1" title="设备列表">
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
					<td class="form_label" align="right" width="20%">设备名称：</td>
					<td colspan="1"  width="30%"><h:text id="deviceName" property="device.deviceName" /></td>
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
					action="/deviceManagement/deviceManagementAction_deviceList.action" method="post">
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
								设备名称
							</th>
							<th nowrap="nowrap">
								型号
							</th>
							<th nowrap="nowrap">
								IP地址
							</th>
							<th nowrap="nowrap">
								生产机器名称
							</th>
							<th nowrap="nowrap">
								CPU型号
							</th>
							<th nowrap="nowrap">
								内存容量
							</th>
							<th nowrap="nowrap">
								硬盘容量
							</th>
							<th nowrap="nowrap">
								操作系统版本
							</th>
							<th nowrap="nowrap">
								内置软件版本
							</th>
							<th nowrap="nowrap">
								IE版本
							</th>
							<th nowrap="nowrap">
								用途
							</th>
							<th nowrap="nowrap">
								终端号
							</th>
							<th nowrap="nowrap">
								使用人
							</th>
							<th nowrap="nowrap">
								安装的插件
							</th>
							<th nowrap="nowrap">
								对应的外设
							</th>
							<th nowrap="nowrap">
								其他属性
							</th>
							<th nowrap="nowrap">
								备注
							</th>
						</tr>
						<w:radioGroup id="group1">
                            <l:iterate property="devices" id="id1">
							 <tr class="<l:output oddOutput="EOS_table_row_o" evenOutput='EOS_table_row' />">
								<td align="center" nowrap="nowrap">
									<w:rowRadio>
											<h:param name='deviceId' iterateId='id1' property='deviceId' />
									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="deviceName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="deviceModel" />
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="ipAdress" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="productionMachineName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="cpuCode" />
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="memory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="hardDisk" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="osVersion" />
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="softwareVersion" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="ieVersion" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="useful" />
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="terminalNumber" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="user" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="plugIn" />
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="peripheral" />
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="otherOne" />
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="remarksOne" />
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
				$id("deviceName").value="";
			}

			//新增
			function add(){
				  var url="/deviceManagement/deviceManagementAction_toDevice.action";
				  showModalCenter(url, null,callBackFunc, 700, 300, '新增设备');
			}

			//修改
			function upt(){
				var gop = $id("group1");
		  		var len = gop.getSelectLength();
		  		if(len == 0){
		  			alert("请选择一条记录");
		  			return;
		  		}else{
		  			var rows=gop.getSelectRow();
			  		var deviceId=rows.getParam("deviceId");e
		  			var strUrl = "/deviceManagement/deviceManagementAction_toDevice.action?device.deviceId="+deviceId;
		  			showModalCenter(strUrl, null, callBackFunc, 700, 300, '修改设备');  
			  	}
			}
			
			function callBackFunc(value){
		        var frm = $name("query_form");
		            frm.submit();
		    }
			
		</script>
	</body>
</html>