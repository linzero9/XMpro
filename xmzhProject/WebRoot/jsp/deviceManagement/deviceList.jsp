<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>
<style>


#_panel1_panel_table{
table-layout: fixed;
}

.form_label{
width:10%;
}


.eos_dict_class{
margin-left:inherit;
}
</style>


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>设备列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<DIV class="divList"  style="overflow:auto;width:100%; height:168;">  
	<h:form name="query_form"	action="/deviceManagement/deviceManagementAction_deviceList.action" method="post">
		<w:panel id="panel1" title="查询条件">
		<table align="center" border="0" width="100%" class="form_table"  >
				<tr>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">机构/部门</td>
					<td colspan="1"  width="25%" nowrap="nowrap">
						<h:text id="orgname" property="device.orgname"   readonly="true"  />
			            <h:hidden id="orgcode" property="device.orgcode" />
			      		<a href="#" onclick="open_orgcode_tree(1);">选择部室</a>
			      		<a href="#" onclick="open_orgcode_tree(2);">选择支行</a>
					</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">IP地址：</td>
					<td colspan="1"  width="25%" nowrap="nowrap">
						<h:text id="ipAdress" property="device.ipAdress"  size="15"   />
					</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">操作系统版本：</td>
					<td colspan="1"  width="23%" nowrap="nowrap">
						<d:select  id="osVersion"  dictTypeId="DEVICE_OS_VERSION" property="device.osVersion" nullLabel="请选择"  ></d:select>
					</td>
						<td class="form_label" align="right" width="10%" nowrap="nowrap">其他属性2：</td>
					<td colspan="1" width="30%" nowrap="nowrap">
					<d:select id="otherAttribute_2"  dictTypeId="DEVICE_OTHERATTRIBUTE_2" property="device.otherAttribute_2" nullLabel="请选择"></d:select>
				</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">其他信息2：</td>
					<td colspan="1" width="30%" nowrap="nowrap">
					<d:checkbox perrow="12"  id="otherInfo_2"  dictTypeId="DEVICE_OTHERINFO_2" property="device.otherInfo_2"  seperator=", " />
				</td>
					
				</tr>
				<tr>
				<td class="form_label" align="right" width="10%" nowrap="nowrap">设备名称：</td>
					<td colspan="1"  width="20%" nowrap="nowrap">
						<d:select  id="deviceName"  dictTypeId="DEVICE_NAME" property="device.deviceName" nullLabel="请选择" onchange="devicename(this.value)"></d:select>
					</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">任务标记：</td>
					
					<td colspan="1" width="30%" nowrap="nowrap"><h:text id="remarks_1"
						property="device.remarks_1" size="15" validateAttr="maxLength=127;" /></td>
			
					<td class="form_label" align="right" width="10%" nowrap="nowrap">备注2：</td>
					
					<td colspan="1" width="30%" nowrap="nowrap"><h:text id="remarks_2"
						property="device.remarks_2" size="15" validateAttr="maxLength=127;" /></td>
		
					<td class="form_label" align="right" width="10%" nowrap="nowrap">其他属性3：</td>
					<td colspan="1" width="30%" nowrap="nowrap">
					<d:select id="otherAttribute_3"  dictTypeId="DEVICE_OTHERATTRIBUTE_3" property="device.otherAttribute_3" nullLabel="请选择"></d:select>
				</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">其他信息3：</td>
					<td colspan="1" width="30%" nowrap="nowrap">
					<d:checkbox     perrow="12"    id="otherInfo_3"  dictTypeId="DEVICE_OTHERINFO_3" property="device.otherInfo_3"  seperator=", " />
				</td>
					
				</tr>
				<tr>
					<tr>
						<td class="form_label" align="right" width="10%" nowrap="nowrap">型号

：</td>
						<td colspan="1" width="30%" nowrap="nowrap">
						<select
							id="deviceModels" onchange="changedeviceModel()">
								
						</select> <h:hidden property="device.deviceModel" id="deviceModel" /> 

<!-- <d:select  id="deviceModel"  dictTypeId="DEVICE_MODEL" property="device.deviceModel" nullLabel="请选择"></d:select> -->
						</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">是否在用：</td>
					<td colspan="1" width="30%" nowrap="nowrap">
					<d:select id="otherAttribute_1"  dictTypeId="DEVICE_OTHERATTRIBUTE_1" property="device.otherAttribute_1" nullLabel="请选择"></d:select>
				</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">设备状态：</td>
					<td colspan="1"  width="25%" nowrap="nowrap" >
						<d:select  id="deviceState"  dictTypeId="DEVICE_STATE" property="device.deviceState" nullLabel="请选择"></d:select>
					</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">其他属性4：</td>
					<td colspan="1" width="30%" nowrap="nowrap">
					<d:select id="otherAttribute_4"  dictTypeId="DEVICE_OTHERATTRIBUTE_4" property="device.otherAttribute_4" nullLabel="请选择"></d:select>
				</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">其他信息4：</td>
					<td colspan="1" width="30%" nowrap="nowrap">
					<d:checkbox  perrow="12"     id="otherInfo_4"  dictTypeId="DEVICE_OTHERINFO_4" property="device.otherInfo_4"  seperator=", " />
				</td>
					
				</tr></table>
			<table align="center" border="0" width="100%" class="form_table"  >
				
				
				
				<tr class="form_bottom" >
						<td colspan="6" class="form_bottom" style="text-align: left;">
						    <b:message key="l_display_per_page"></b:message> 
					        <h:text size="3" property="page.length"  value="100" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="button" value="查 询" class="button" onclick="mysubmit();">
							<input type="button" value="清 空" class="button" onclick="clears();">
							<input id=" exportExcel" type="button" class="button" value="导出列表" onclick="export_Excel();">
							<input id="importExcel"  type="button" class="button" value="批量导入" onclick="import_Excel();">
							<input id="importExcel"  type="button" class="button" value="批量修改导入" onclick="batchUpdate_import_view();">
						</td>
					</tr>
			</table>
		</w:panel>
	</h:form>
	</DIV>
	<DIV class="divList"  style="overflow:auto;width:100%; height: 310;">
			<w:panel id="panel" width="100%" title="查询结果">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/deviceManagement/deviceManagementAction_deviceList.action" method="post">
            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    <h:hiddendata property="device" />
					<table align="center" border="0" width="100%" class="EOS_table">
						<tr>
							<th align="center" nowrap="nowrap">
								<l:greaterThan property="page.count" targetValue="0" compareType="number">
	                 					<h:checkbox id="selectBox" onclick="allItem();"/>
	             				 </l:greaterThan>
								<b:message key="l_select"></b:message>
							</th>
							<th nowrap="nowrap">
								机构/部门    
							</th>
							<th nowrap="nowrap">
								设备名称  
							</th>
							<th nowrap="nowrap">
								IP地址  
							</th>
							<th nowrap="nowrap">
								是否在用  
							</th>
							<th nowrap="nowrap">
								任务标记  
							</th>
							<th nowrap="nowrap">
								型号
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
								硬盘容量(G)
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
								其他属性2  
							</th>
							<th nowrap="nowrap">
								其他属性3  
							</th>
							<th nowrap="nowrap">
								其他属性4 
							</th>
							<th nowrap="nowrap">
								其他属性5 
							</th>
							<th nowrap="nowrap">
								应用系统 
							</th>
							<th nowrap="nowrap">
								其他信息2  
							</th>
							<th nowrap="nowrap">
								其他信息3 
							</th>
							<th nowrap="nowrap">
								其他信息4  
							</th>
							<th nowrap="nowrap">
								其他信息5  
							</th>

							<th nowrap="nowrap">
								备注2  
							</th>
							<th nowrap="nowrap">
								备注3  
							</th>
							<th nowrap="nowrap">
								备注4  
							</th>
							<th nowrap="nowrap">
								备注5  
							</th>
							<th nowrap="nowrap">
								设备状态  
							</th>
						</tr>
						<w:checkGroup id="group1">
                            <l:iterate property="devices" id="id1">
                            
                             <l:equal  property="deviceState"  targetValue="0"  iterateId="id1">
							 <tr class="<l:output oddOutput="EOS_table_row_o" evenOutput='EOS_table_row' />">
								<td align="center" nowrap="nowrap">
									<w:rowCheckbox>
											<h:param name='deviceId' iterateId='id1' property='deviceId' />  
									</w:rowCheckbox>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgname" />     
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" property="deviceName"  dictTypeId="DEVICE_NAME" />   
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="ipAdress" />   
								</td>
						        <td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherAttribute_1"  dictTypeId="DEVICE_OTHERATTRIBUTE_1"/>  
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="remarks_1" />
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" property="deviceModel"  dictTypeId="DEVICE_MODEL"  />   
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
								     <d:write iterateId="id1" property="otherAttribute_2"  dictTypeId="DEVICE_OTHERATTRIBUTE_2"/>
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherAttribute_3"  dictTypeId="DEVICE_OTHERATTRIBUTE_3"/>
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherAttribute_4"  dictTypeId="DEVICE_OTHERATTRIBUTE_4"/>
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherAttribute_5"  dictTypeId="DEVICE_OTHERATTRIBUTE_5"/>
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherInfo_1"  dictTypeId="DEVICE_OTHERINFO_1"  seperator=", "  />
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherInfo_2"  dictTypeId="DEVICE_OTHERINFO_2"  seperator=", "  />
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherInfo_3"  dictTypeId="DEVICE_OTHERINFO_3"  seperator=", "  />
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherInfo_4"  dictTypeId="DEVICE_OTHERINFO_4"  seperator=", "  />
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherInfo_5"  dictTypeId="DEVICE_OTHERINFO_5"  seperator=", "  />
								</td>

								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="remarks_2" />
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="remarks_3" />
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="remarks_4" />
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="remarks_5" />
								</td>
								<td nowrap="nowrap">
										<d:write  iterateId="id1"  dictTypeId="DEVICE_STATE" property="deviceState" />
								</td>
							</tr>
							</l:equal>
						    <l:equal  property="deviceState"  targetValue="1"  iterateId="id1">
							 <tr bgcolor="#FFFF00">
								<td align="center" nowrap="nowrap">
									<w:rowCheckbox>
											<h:param name='deviceId' iterateId='id1' property='deviceId' />  
									</w:rowCheckbox>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgname" />   
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" property="deviceName"  dictTypeId="DEVICE_NAME" />  
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="ipAdress" />  
								</td>
						        <td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherAttribute_1"  dictTypeId="DEVICE_OTHERATTRIBUTE_1"/>
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="remarks_1" />
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" property="deviceModel"  dictTypeId="DEVICE_MODEL"  />   
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
								     <d:write iterateId="id1" property="otherAttribute_2"  dictTypeId="DEVICE_OTHERATTRIBUTE_2"/>
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherAttribute_3"  dictTypeId="DEVICE_OTHERATTRIBUTE_3"/>
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherAttribute_4"  dictTypeId="DEVICE_OTHERATTRIBUTE_4"/>
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherAttribute_5"  dictTypeId="DEVICE_OTHERATTRIBUTE_5"/>
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherInfo_1"  dictTypeId="DEVICE_OTHERINFO_1"  seperator=", "  />
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherInfo_2"  dictTypeId="DEVICE_OTHERINFO_2"  seperator=", "  />
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherInfo_3"  dictTypeId="DEVICE_OTHERINFO_3"  seperator=", "  />
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherInfo_4"  dictTypeId="DEVICE_OTHERINFO_4"  seperator=", "  />
								</td>
								<td nowrap="nowrap"> 
								     <d:write iterateId="id1" property="otherInfo_5"  dictTypeId="DEVICE_OTHERINFO_5"  seperator=", "  />
								</td>

								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="remarks_2" />
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="remarks_3" />
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="remarks_4" />
								</td>
								<td nowrap="nowrap"> 
								     <b:write iterateId="id1" property="remarks_5" />
								</td>
								<td nowrap="nowrap">
										<d:write  iterateId="id1"  dictTypeId="DEVICE_STATE" property="deviceState" />
								</td>
							</tr>
							</l:equal>
						</l:iterate>
					</w:checkGroup>
							<tr>
              <td colspan="33" class="command_sort_area">
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
								<l:greaterThan property="page.count" targetValue="0"
									compareType="number">
							<input type="button" class="button" value="维护明细查询"
										onclick="detail_search();" />
								</l:greaterThan>
								<l:greaterThan property="page.count" targetValue="0"
									compareType="number">
							<input type="button" class="button" value="批量修改导出"
										onclick="batchUpdate_export();" />
								</l:greaterThan>
								<l:greaterThan property="page.count" targetValue="0"
									compareType="number">
							<input type="button" class="button" value="批量修改导出全部"
										onclick="batchUpdate_exportAll();" />
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
		$(function (){
			
			if($("#deviceName").val()!=0){
				devicename($("#deviceName").val());
				}else{	
				$("deviceModels").html("");
				var selecthtml=$("#deviceModels").html();
				selecthtml = selecthtml+"<option value='' >请选择</option>";
				$("#deviceModels").html(selecthtml);}
			
			});
			function devicename(value) {
				
				$("#deviceModels").html("");
				var selecthtml=$("#deviceModels").html();
				selecthtml = selecthtml+"<option value='' >请选择</option>";
						$.ajax({
							url : "/deviceManagement/deviceManagementAction_queryType.action",
							async : false,
							type : 'post',
							data : "deviceName=" + value,
							timeout : 60000,
							dataType : 'json',
							success : function(json) {

								if (json == "") {

								} else {
									$.each(json,function(key, value) {
			selecthtml = selecthtml+ "<option value="+value.deviceModel+">"+ value.deviceModelName+ "</option>";
													});
								}
							}
						});
						
						$("#deviceModels").html(selecthtml);
				if ($id("deviceModel").value == '') {
					$("#deviceModel").val(
							$('#deviceModels option:selected').val());
				} else {
					var all_options = document.getElementById("deviceModels").options;
					for ( var i = 0; i < all_options.length; i++) {
						if (all_options[i].value == $id("deviceModels").value

						) // 根据option标签的ID来进行判断 测试的代码这里是两个等号
						{
							all_options[i].selected = true;
						}
					}
				}
			}
			function changedeviceModel() {
				$("#deviceModel").val($('#deviceModels option:selected').val());
			}

			//提交
			function mysubmit() {
				var frm = $name("query_form");
				frm.submit();
			}

			//清空
			function clears() {
				$id("orgcode").value = "";
				$id("orgname").value = "";
				$id("deviceName").value = "";
				$id("deviceModel").value = "";
				$id("deviceState").value = "";
				$id("ipAdress").value = "";

				$id("otherAttribute_2").value = "";
				$id("remarks_1").value = "";
				$id("osVersion").value = "";
				$id("remarks_2").value = "";
				$id("otherAttribute_3").value = "";

				$id("otherAttribute_1").value = "";
				$id("otherAttribute_4").value = "";

				$("input[name='device.otherInfo_3']:checkbox:checked").each(
						function() {
							$(this).attr("checked", false);
						});

				$("input[name='device.otherInfo_2']:checkbox:checked").each(
						function() {
							$(this).attr("checked", false);
						});

				$("input[name='device.otherInfo_4']:checkbox:checked").each(
						function() {
							$(this).attr("checked", false);
						});
			}

			//新增
			function add() {
				var url = "/deviceManagement/deviceManagementAction_toDevice.action";
				showModalCenter(url, null, callBackFunc, 700, 550, '新增设备');
			}

			//修改
			function upt() {
				var gop = $id("group1");
				var len = gop.getSelectLength();
				if (len != 1) {
					alert("请选择一条记录");
					return;
				} else {
					var rows = gop.getSelectRows();
					var deviceId = rows[0].getParam("deviceId");
					var strUrl = "/deviceManagement/deviceManagementAction_toDevice.action?device.deviceId="
							+ deviceId;
					showModalCenter(strUrl, null, callBackFunc, 700, 550,
							'修改设备');
				}
			}

			function callBackFunc() {
				var frm = $name("query_form");
				frm.submit();
			}

			//删除
			function del() {
				var gop = $id("group1");
				var len = gop.getSelectLength();
				if (len == 0) {
					alert("请选择一条或多条记录");
					return;
				} else {
					if (confirm("确定要删除该设备吗？")) {
						var rows = gop.getSelectRows();
						var deviceIds = "";
						for ( var i = 0; i < rows.length; i++) {
							deviceIds += rows[i].getParam("deviceId") + ",";
						}
						if (deviceIds != "") {
							deviceIds = deviceIds.substring(0,
									deviceIds.length - 1);
							$
									.ajax({
										url : "/deviceManagement/deviceManagementAction_delete.action",
										async : false,
										type : 'post',
										data : "deviceIds=" + deviceIds,
										timeout : 60000,
										dataType : "text",
										success : function(data) {
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
			}

			//维护明细查询
			function detail_search() {
				var gop = $id("group1");
				var len = gop.getSelectLength();
				if (len != 1) {
					alert("请选择一条记录");
					return;
				} else {
					var rows = gop.getSelectRows();
					var deviceId = rows[0].getParam("deviceId");
					var strUrl = "/deviceManagement/deviceManagementAction_detailList.action?detail.deviceId="
							+ deviceId;
					showModalCenter(strUrl, null, callBackFunc, 1000, 500,
							'修改设备');
				}
			}

			//批量修改导出
			function batchUpdate_export() {
				var gop = $id("group1");
				var len = gop.getSelectLength();
				if (len == 0) {
					alert("请选择一条或多条记录");
					return;
				} else {
					var rows = gop.getSelectRows();
					var deviceIds = "";
					for ( var i = 0; i < rows.length; i++) {
						deviceIds += rows[i].getParam("deviceId") + ",";
					}
					if (deviceIds != "") {
						deviceIds = deviceIds
								.substring(0, deviceIds.length - 1); //将最后一个逗号去掉

						window.location.href = "/deviceManagement/deviceManagementAction_batchUpdateExport.action?deviceIds="
								+ deviceIds;

					}
				}
			}

			//批量修改导出全部
			function batchUpdate_exportAll() {

				window.location.href = "/deviceManagement/deviceManagementAction_batchUpdateExportAll.action";
			}

			//选择 部门/机构
			function open_orgcode_tree(flag) {//方法名
				//strUrl = "/deviceManagement/myMainTreeAction_initMainTree.action?changeTree.showTabOrg=1&changeTree.checkcount=1&changeTree.orgType=4&changeTree.showSelBox=4";

				strUrl = "/deviceManagement/myMainTreeAction_initMainTree.action?changeTree.showTabOrg=1&changeTree.orgType=4&changeTree.showSelBox=4";//changeTree.checkcount=1为多选框可选个数，为1表示只能单选，若不指定选的个数，则需去掉
				if (flag == "1") {
					strUrl += "&orgflag=1";
				} else if (flag == "2") {
					strUrl += "&orgflag=2";
				}
				var peArgument = [];
				//机构
				var paramEntity = new ParamEntity('Organization');
				paramEntity.setProperty('orgcode', $id("orgcode").value);
				paramEntity.setProperty('orgname', $id("orgname").value);
				/* paramEntity.setProperty('orgid',$id("orgid").value);
				peArgument[3]=[paramEntity,'orgname','orgcode','orgid'];  */
				peArgument[3] = [ paramEntity, 'orgname', 'orgcode' ];

				//调用并传参
				strUrl += "&time=" + new Date().getTime();
				showModalCenter(strUrl, peArgument, openNewEmpTreeCallBack1,
						500, 430, '选择机构');
			}

			function openNewEmpTreeCallBack1(arg) {//回调方法
				if (arg['Organization']) { //原写法无需判断是否为空
					var sorgidArra = arg['Organization'].slice(0);//人员数组
					argRes = [ [], [], [], [] ];
					for ( var i = 0; i < sorgidArra.length; i++) {
						argRes[0].push(sorgidArra[i].getProperty("orgcode"));
						argRes[1].push(sorgidArra[i].getProperty("orgname"));
						//argRes[2].push(sorgidArra[i].getProperty("orgid"));
					}
					$id("orgcode").value = argRes[0];
					$id("orgname").value = argRes[1];
					//$id("orgid").value = argRes[2];
				} else {
					$id("orgcode").value = "";
					$id("orgname").value = "";
					//$id("orgid").value = "";
				}
			}

			//导出Excel
			function export_Excel() {

				var url = "/deviceManagement/deviceManagementAction_exportExcel.action?";
				var orgcode = $id("orgcode").value;
				var deviceName = $id("deviceName").value;
				var deviceModel = $id("deviceModel").value;
				var deviceState = $id("deviceState").value;
				var ipAdress = $id("ipAdress").value;
				var otherAttribute_2 = $id("otherAttribute_2").value;

				var remarks_1 = $id("remarks_1").value;
				var remarks_2 = $id("remarks_2").value;
				var otherAttribute_3 = $id("otherAttribute_3").value;

				var otherAttribute_1 = $id("otherAttribute_1").value;
				var otherAttribute_4 = $id("otherAttribute_4").value;

				var osVersion = $id("osVersion").value;

				//获取复选框的值
				var otherInfo_4 = "";
				var otherInfo_4Length = $("input[name='device.otherInfo_4']:checkbox:checked").length;
				$("input[name='device.otherInfo_4']:checkbox:checked").each(
						function(i, value) {
							if ($(this).attr("checked")) {
								if ((i + 1) == otherInfo_4Length) {
									otherInfo_4 += $(this).val();
								} else {
									otherInfo_4 += $(this).val() + ", ";
								}
							}
						});

				var otherInfo_2 = "";
				var otherInfo_2Length = $("input[name='device.otherInfo_2']:checkbox:checked").length;
				$("input[name='device.otherInfo_2']:checkbox:checked").each(
						function(i, value) {
							if ($(this).attr("checked")) {
								if ((i + 1) == otherInfo_2Length) {
									otherInfo_2 += $(this).val();
								} else {
									otherInfo_2 += $(this).val() + ", ";
								}
							}
						});

				var otherInfo_3 = "";
				var otherInfo_3Length = $("input[name='device.otherInfo_3']:checkbox:checked").length;
				$("input[name='device.otherInfo_3']:checkbox:checked").each(
						function(i, value) {
							if ($(this).attr("checked")) {
								if ((i + 1) == otherInfo_3Length) {
									otherInfo_3 += $(this).val();
								} else {
									otherInfo_3 += $(this).val() + ", ";
								}
							}
						});

				if (otherInfo_2 == null) {
					otherInfo_2 = "";
				}
				if (otherInfo_3 == null) {
					otherInfo_3 = "";
				}
				if (otherInfo_4 == null) {
					otherInfo_4 = "";
				}
				url = url + "device.orgcode=" + orgcode + "&device.deviceName="
						+ deviceName + "&device.deviceModel=" + deviceModel
						+ "&device.deviceState=" + deviceState
						+ "&device.ipAdress=" + ipAdress
						+ "&device.otherAttribute_2=" + otherAttribute_2
						+ "&device.remarks_1=" + remarks_1
						+ "&device.remarks_2=" + remarks_2
						+ "&device.osVersion=" + osVersion
						+ "&device.otherAttribute_3=" + otherAttribute_3
						+ "&device.otherAttribute_1=" + otherAttribute_1
						+ "&device.otherInfo_2=" + otherInfo_2
						+ "&device.otherInfo_3=" + otherInfo_3
						+ "&device.otherInfo_4=" + otherInfo_4
						+ "&device.otherAttribute_4=" + otherAttribute_4;
				window.location.href = url;

			}

			//批量导入Excel
			function import_Excel() {
				var url = "/deviceManagement/deviceManagementAction_toImportExcel.action?";
				url = url + "importExcelFlag=" + "batchInsert";
				showModalCenter(url, null, callBackFunc, 700, 300, '批量导入');
			}

			function allItem() {
				var group = $id("group1");
				if (document.getElementById("selectBox").checked) {
					group.selectAll();
				} else {
					group.disSelectAll();
				}
			}

			//批量修改导入Excel importExcel
			function batchUpdate_import_view() {
				var url = "/deviceManagement/deviceManagementAction_toImportExcel.action?";
				url = url + "importExcelFlag=" + "batchUpdate";
				showModalCenter(url, null, callBackFunc, 700, 300, '批量修改导入');
			}
		</script>
	</body>
</html>