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
	<DIV class="divList"  style="overflow:auto;width:100%; height:250;">  
	<h:form name="query_form"	action="/deviceManagement/deviceManagementAction_deviceList.action" method="post">
		<w:panel id="panel1" title="查询条件">
		<table align="center" border="0" width="100%" class="form_table"  >
				<tr>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">机构/部门</td>
					<td colspan="1"  width="25%" nowrap="nowrap">
						<h:text id="orgname" property="device.orgname"   readonly="true"  />
			            <h:hidden id="orgcode" property="device.orgcode" />
			      		<a href="#" onclick="open_newyw_tree_fun1();">选择</a>
					</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">设备名称：</td>
					<td colspan="1"  width="20%" nowrap="nowrap">
						<d:select  id="deviceName"  dictTypeId="DEVICE_NAME" property="device.deviceName" nullLabel="请选择"></d:select>
					</td>
						<td class="form_label" align="right" width="10%" nowrap="nowrap">设备型号：</td>
					<td colspan="1"  width="25%" nowrap="nowrap">
						<d:select  id="deviceModel"  dictTypeId="DEVICE_MODEL" property="device.deviceModel" nullLabel="请选择"></d:select>
					</td>
					
				</tr>
				<tr>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">内存：</td>
					<td colspan="1"  width="25%" nowrap="nowrap">
						<h:text id="memoryMin" property="device.memoryMin"  size="5"  validateAttr="fracDigit=2;type=double;"  />G
						＜内存容量(G)＜
						<h:text id="memoryMax" property="device.memoryMax"  size="5"  validateAttr="fracDigit=2;type=double;" />G
					</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">硬盘：</td>
					<td colspan="1"  width="20%" nowrap="nowrap">
						<h:text id="hardDiskMin" property="device.hardDiskMin"  size="5"  validateAttr="fracDigit=2;type=double;"  />G
						＜硬盘容量(G)＜
						<h:text id="hardDiskMax" property="device.hardDiskMax" size="5"  validateAttr="fracDigit=2;type=double;"  />G
					</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">设备状态：</td>
					<td colspan="1"  width="25%" nowrap="nowrap" >
						<d:select  id="deviceState"  dictTypeId="DEVICE_STATE" property="device.deviceState" nullLabel="请选择"></d:select>
					</td>
				</tr>
				<tr>
				
					<td class="form_label" align="right" width="10%" nowrap="nowrap">操作系统版本：</td>
					<td colspan="1"  width="23%" nowrap="nowrap">
						<d:select  id="osVersion"  dictTypeId="DEVICE_OS_VERSION" property="device.osVersion" nullLabel="请选择"  ></d:select>
					</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">内置软件版本：</td>
					<td colspan="1"  width="23%" nowrap="nowrap">
						<h:text id="softwareVersion" property="device.softwareVersion"  />
					</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">IE版本：</td>
					<td colspan="1"  width="24%" nowrap="nowrap">
						<d:select  id="ieVersion"  dictTypeId="DEVICE_IE_VERSION" property="device.ieVersion" nullLabel="请选择"></d:select>
					</td>
				</tr></table>
			<table align="center" border="0" width="100%" class="form_table"  >
				<tr>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">用途：</td>
					<td colspan="1"  width="90%" nowrap="nowrap">
					<d:checkbox perrow="12" id="useful"  name="device.useful" dictTypeId="DEVICE_USEFUL" property="device.useful"  seperator=", "  />
					</td>
				</tr>
				<tr>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">安装的插件：</td>
					<td colspan="1"  width="90%" nowrap="nowrap">
						<d:checkbox perrow="12" id="plugIn"  name="device.plugIn" dictTypeId="DEVICE_PLUGIN" property="device.plugIn"   seperator=", " />
					</td>
				
				</tr>
				<tr>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">对应的外设：</td>
					<td colspan="1"  width="90%" nowrap="nowrap">
						<d:checkbox perrow="12" id="peripheral"  name="device.peripheral"  dictTypeId="DEVICE_PERIPHERAL" property="device.peripheral"   seperator=", "  />
					</td>
				</tr>
				<tr class="form_bottom" >
						<td colspan="6" class="form_bottom" style="text-align: center">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
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
								应用系统
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
								其他信息1
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
								备注1
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
								     <d:write iterateId="id1" property="otherAttribute_1"  dictTypeId="DEVICE_OTHERATTRIBUTE_1"/>
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
								     <b:write iterateId="id1" property="remarks_1" />
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
	
		//提交
		function mysubmit(){
			  var frm = $name("query_form");
	            frm.submit();
			}

		//清空
			function clears(){
				$id("orgcode").value="";
				$id("orgname").value="";
				$id("deviceName").value="";
				$id("deviceModel").value="";
				$id("deviceState").value="";
				$id("memoryMin").value="";
				$id("memoryMax").value="";
				$id("hardDiskMin").value="";
				$id("hardDiskMax").value="";
				$id("osVersion").value="";
				$id("softwareVersion").value="";
				$id("ieVersion").value="";
				
				$("input[name='device.useful']:checkbox:checked").each(function(){ 
	                $(this).attr("checked",false);
	            });	

				$("input[name='device.plugIn']:checkbox:checked").each(function(){ 
	                $(this).attr("checked",false);
	            });	

				$("input[name='device.peripheral']:checkbox:checked").each(function(){ 
	                $(this).attr("checked",false);
	            });	
			}

			//新增
			function add(){
				  var url="/deviceManagement/deviceManagementAction_toDevice.action";
				  showModalCenter(url, null,callBackFunc, 700, 550, '新增设备');
			}

			//修改
			function upt(){
				var gop = $id("group1");
		  		var len = gop.getSelectLength();
		  		if(len != 1){
		  			alert("请选择一条记录");
		  			return;
		  		}else{
		  			var rows=gop.getSelectRows();
			  		var deviceId=rows[0].getParam("deviceId");
		  			var strUrl = "/deviceManagement/deviceManagementAction_toDevice.action?device.deviceId="+deviceId;
		  			showModalCenter(strUrl, null, callBackFunc, 700, 550, '修改设备');  
			  	}
			}
			
			function callBackFunc(){
		        var frm = $name("query_form");
		            frm.submit();
		    }

			//删除
			function del(){
				var gop = $id("group1");
		  		var len = gop.getSelectLength();
		  		if(len == 0){
		  			alert("请选择一条或多条记录");
		  			return;
		  		}else{
			  	  if(confirm("确定要删除该设备吗？")){
		  			var rows=gop.getSelectRows();
		  			var deviceIds="";
		  			for(var i=0;i<rows.length;i++){
		  				deviceIds += rows[i].getParam("deviceId")+",";
		  			}
		  			if(deviceIds!=""){
		  				deviceIds=deviceIds.substring(0,deviceIds.length-1);
			  		$.ajax({
					      url: "/deviceManagement/deviceManagementAction_delete.action",
					      async: false,
					      type: 'post',
					      data: "deviceIds="+deviceIds,
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
			}

			//维护明细查询
			function detail_search(){
				var gop = $id("group1");
		  		var len = gop.getSelectLength();
		  		if(len != 1){
		  			alert("请选择一条记录");
		  			return;
		  		}else{
		  			var rows=gop.getSelectRows();
			  		var deviceId=rows[0].getParam("deviceId");
		  			var strUrl = "/deviceManagement/deviceManagementAction_detailList.action?detail.deviceId="+deviceId;
		  			showModalCenter(strUrl, null, callBackFunc, 1000, 500, '修改设备');  
			  	}
			}

			//批量修改导出
			function batchUpdate_export(){
				var gop = $id("group1");
		  		var len = gop.getSelectLength();
		  		if(len == 0){
		  			alert("请选择一条或多条记录");
		  			return;
		  		}else{
		  			var rows=gop.getSelectRows();
		  			var deviceIds="";
		  			for(var i=0;i<rows.length;i++){
		  				deviceIds += rows[i].getParam("deviceId")+",";
		  			}
		  			if(deviceIds!=""){
		  				deviceIds=deviceIds.substring(0,deviceIds.length-1);  //将最后一个逗号去掉



		  				window.location.href="/deviceManagement/deviceManagementAction_batchUpdateExport.action?deviceIds="+deviceIds;
		  				
			  		
		  			}
			  	}
			}

			//选择 部门/机构
			function open_newyw_tree_fun1(){//方法名
			     strUrl ="/tree/initMainTree_mainTree.action?changeTree.showTabOrg=1&changeTree.checkcount=1&changeTree.orgType=4&changeTree.showSelBox=4";
				var peArgument = [];
		   		//机构
		   		var paramEntity = new ParamEntity('Organization');
		   		paramEntity.setProperty('orgcode',$id("orgcode").value);
				paramEntity.setProperty('orgname',$id("orgname").value);
				/* paramEntity.setProperty('orgid',$id("orgid").value);
				peArgument[3]=[paramEntity,'orgname','orgcode','orgid'];  */
				peArgument[3]=[paramEntity,'orgname','orgcode'];
				
		       //调用并传参
		        strUrl += "&time="+new Date().getTime();
				showModalCenter(strUrl,peArgument,openNewEmpTreeCallBack1,500,430,'选择机构');
			}
			
		function openNewEmpTreeCallBack1(arg){//回调方法
			if(arg['Organization']){ //原写法无需判断是否为空
		 		var sorgidArra  = arg['Organization'].slice(0);//人员数组
		 		argRes=[[],[],[],[]];
				for(var i=0;i<sorgidArra.length;i++){
					argRes[0].push(sorgidArra[i].getProperty("orgcode"));
					argRes[1].push(sorgidArra[i].getProperty("orgname"));
					//argRes[2].push(sorgidArra[i].getProperty("orgid"));
				}
				$id("orgcode").value = argRes[0];
				$id("orgname").value = argRes[1];
				//$id("orgid").value = argRes[2];
			}else{
				$id("orgcode").value = "";
				$id("orgname").value = "";
				//$id("orgid").value = "";
			}
		}

		//导出Excel
		function export_Excel(){
			var url = "/deviceManagement/deviceManagementAction_exportExcel.action?";
			var orgcode = $id("orgcode").value;
			var deviceName = $id("deviceName").value;
			var deviceModel = $id("deviceModel").value;
			var deviceState = $id("deviceState").value;
			var memoryMin = $id("memoryMin").value;
			var memoryMax = $id("memoryMax").value;
			var hardDiskMin = $id("hardDiskMin").value;
			var hardDiskMax = $id("hardDiskMax").value;
			var osVersion = $id("osVersion").value;
			var softwareVersion = $id("softwareVersion").value;
			var ieVersion = $id("ieVersion").value;

			//获取复选框的值
            var useful="";
            var  usefulLength  =  $("input[name='device.useful']:checkbox:checked").length;
            $("input[name='device.useful']:checkbox:checked").each(function(i,value){ 
                if($(this).attr("checked")){
                    if((i+1)==usefulLength){
                    	useful += $(this).val();
                    }else{
                    	useful += $(this).val()+", ";
                	}
                }
            });

            var plugIn="";
            var  plugInLength  =  $("input[name='device.plugIn']:checkbox:checked").length;
            $("input[name='device.plugIn']:checkbox:checked").each(function(i,value){ 
                if($(this).attr("checked")){
                    if((i+1)==plugInLength){
                    	plugIn += $(this).val();
                    }else{
                    	plugIn += $(this).val()+", ";
                	}
                }
            });

            var peripheral="";
            var  peripheralLength  =  $("input[name='device.peripheral']:checkbox:checked").length;
            $("input[name='device.peripheral']:checkbox:checked").each(function(i,value){ 
                if($(this).attr("checked")){
                    if((i+1)==peripheralLength){
                    	peripheral += $(this).val();
                    }else{
                    	peripheral += $(this).val()+", ";
                	}
                }
            });
			
			if(useful == null){
				useful="";
				}
			if(plugIn == null){
				plugIn="";
				}
			if(peripheral == null){
				peripheral="";
				}
			url = url+"device.orgcode="+orgcode+"&device.deviceName="+deviceName
			+"&device.deviceModel="+deviceModel+"&device.deviceState="+deviceState
			+"&device.memoryMin="+memoryMin+"&device.memoryMax="+memoryMax
			+"&device.hardDiskMin="+hardDiskMin+"&device.hardDiskMax="+hardDiskMax
			+"&device.osVersion="+osVersion+"&device.softwareVersion="+softwareVersion
			+"&device.ieVersion="+ieVersion+"&device.useful="+useful
			+"&device.plugIn="+plugIn+"&device.peripheral="+peripheral;
			window.location.href=url;
		  	
		}

		//批量导入Excel
		function import_Excel(){
			var url="/deviceManagement/deviceManagementAction_toImportExcel.action?";
			url = url+"importExcelFlag="+"batchInsert";
			showModalCenter(url, null,callBackFunc, 700, 300, '批量导入');
		}

		function allItem(){
			var group =$id("group1");
			if(document.getElementById("selectBox").checked){
				group.selectAll();
			}else{
				group.disSelectAll();
			}
		}

		//批量修改导入Excel importExcel
		function batchUpdate_import_view(){
			var url="/deviceManagement/deviceManagementAction_toImportExcel.action?";
			url = url+"importExcelFlag="+"batchUpdate";
			showModalCenter(url, null,callBackFunc, 700, 300, '批量修改导入');
		}
		</script>
	</body>
</html>