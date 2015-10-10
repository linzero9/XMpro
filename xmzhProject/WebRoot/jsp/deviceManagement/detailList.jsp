<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>设备明细列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="query_form"	action="/deviceManagement/deviceManagementAction_detailList.action" method="post">
		<w:panel id="panel1" title="设备明细列表">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
					<td class="form_label" align="right" width="20%">操作员工姓名：</td>
					<td colspan="1"  width="30%">
						<h:text id="operateEmpname" property="detail.operateEmpname"   />
					</td>
				</tr>
				<tr class="form_bottom">
						<td colspan="4" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="button" value="查 询" class="button" onclick="mysubmit();">
							<input type="button" value="清 空" class="button" onclick="clears();">
							<input id="downexl" type="button" class="button" value="导出列表" onclick="downExl2();">
							</td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList"  style="overflow:auto;width:100%; height: 380;">
			<w:panel id="panel" width="100%" title="查询结果">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/deviceManagement/deviceManagementAction_detailList.action" method="post">
            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
					<table align="center" border="0" width="100%" class="EOS_table">
						<tr>
							<th nowrap="nowrap">
								操作时间
							</th>
							<th nowrap="nowrap">
								操作员工姓名
							</th>
							<th nowrap="nowrap">
								机构/部门
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
								内存容量(G)
							</th>
							<th nowrap="nowrap">
								硬盘容量(T)
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
								其他信息
							</th>
							<th nowrap="nowrap">
								备注
							</th>
							<th nowrap="nowrap">
								设备状态
							</th>
						</tr>
                            <l:iterate property="details" id="id1">
							 <tr class="<l:output oddOutput="EOS_table_row_o" evenOutput='EOS_table_row' />">
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="operateTime" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="operateEmpname" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgname" />
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" property="deviceName"  dictTypeId="DEVICE_NAME" />
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" property="deviceModel"  dictTypeId="DEVICE_MODEL"  />
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
									<d:write iterateId="id1" property="osVersion"  dictTypeId="DEVICE_OS_VERSION"/>
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="softwareVersion" />
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" property="ieVersion"  dictTypeId="DEVICE_IE_VERSION"/>
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" property="useful"  dictTypeId="DEVICE_USEFUL" seperator=", "  />
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="terminalNumber" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="user" />
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" property="plugIn" dictTypeId="DEVICE_PLUGIN"  seperator=", " />
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="peripheral"  dictTypeId="DEVICE_PERIPHERAL"  seperator=", "  />
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherOne"  dictTypeId="DEVICE_OTHERONE"/>
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherInfoOne"  dictTypeId="DEVICE_OTHERINFOONE"/>
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="remarksOne" />
								</td>
								<td nowrap="nowrap">
										<d:write  iterateId="id1"  dictTypeId="DEVICE_STATE" property="deviceState" />
								</td>
							</tr>
						</l:iterate>
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
	
		//提交
		function mysubmit(){
			  var frm = $name("query_form");
	            frm.submit();
			}

		//清空
			function clears(){
				$id("operateEmpname").value="";
			}
		
		function downExl2(){
			var url = "/deviceManagement/deviceManagementAction_downexl2.action?";
			var operateEmpname = $id("operateEmpname").value;
			
			url = url+"detail.operateEmpname="+operateEmpname;
			window.location.href=url;
		  	
		}	
		</script>
	</body>
</html>