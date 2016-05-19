<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>
<style>

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
	<h:form name="query_form"	action="/deviceManagement/deviceManagementAction_sumUpDevice.action" method="post">
		<w:panel id="panel1" title="设备列表">
			<table align="center" border="0" width="100%" class="form_table"  >
				<tr>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">机构/部门</td>
					<td colspan="1"  width="25%" nowrap="nowrap">
						<h:text id="orgname" property="device.orgname"   readonly="true"  />
			            <h:hidden id="orgcode" property="device.orgcode" />
			      		<a href="#" onclick="open_orgcode_tree(1);">选择部室</a>
			      		<a href="#" onclick="open_orgcode_tree(2);">选择支行</a>
					</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">${sheBeiShuX.DEVICE_NAME}：</td>
					<td colspan="1"  width="20%" nowrap="nowrap">
						<d:select  id="deviceName"  dictTypeId="DEVICE_NAME" property="device.deviceName" nullLabel="请选择" onchange="devicename(this.value)"></d:select>
					</td>
						<td class="form_label" align="right" width="10%" nowrap="nowrap">${sheBeiShuX.DEVICE_MODEL}：</td>
						<td colspan="1" width="30%" nowrap="nowrap">
						<select
							id="deviceModels" onchange="changedeviceModel()">
								
						</select> <h:hidden property="device.deviceModel" id="deviceModel" /> 

						</td>
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
					<td class="form_label" align="right" width="10%" nowrap="nowrap">${sheBeiShuX.DEVICE_STATE}：</td>
					<td colspan="1"  width="25%" nowrap="nowrap" >
						<d:select  id="deviceState"  dictTypeId="DEVICE_STATE" property="device.deviceState" nullLabel="请选择"></d:select>
					</td>
				</tr>
				<tr>
				
					<td class="form_label" align="right" width="10%" nowrap="nowrap">${sheBeiShuX.DEVICE_OS_VERSION}：</td>
					<td colspan="1"  width="23%" nowrap="nowrap">
						<d:select  id="osVersion"  dictTypeId="DEVICE_OS_VERSION" property="device.osVersion" nullLabel="请选择"  ></d:select>
					</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">内置软件版本：</td>
					<td colspan="1"  width="23%" nowrap="nowrap">
						<h:text id="softwareVersion" property="device.softwareVersion"  />
					</td>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">${sheBeiShuX.DEVICE_IE_VERSION}：</td>
					<td colspan="1"  width="24%" nowrap="nowrap">
						<d:select  id="ieVersion"  dictTypeId="DEVICE_IE_VERSION" property="device.ieVersion" nullLabel="请选择"></d:select>
					</td>
				</tr></table>
			<table align="center" border="0" width="100%" class="form_table"  >
				<tr>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">${sheBeiShuX.DEVICE_USEFUL}：</td>
					<td colspan="1"  width="90%" nowrap="nowrap">
					<d:checkbox perrow="12" id="useful"  name="device.useful" dictTypeId="DEVICE_USEFUL" property="device.useful"  seperator=", "  />
					</td>
				</tr>
				<tr>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">${sheBeiShuX.DEVICE_PLUGIN}：</td>
					<td colspan="1"  width="90%" nowrap="nowrap">
						<d:checkbox perrow="12" id="plugIn"  name="device.plugIn" dictTypeId="DEVICE_PLUGIN" property="device.plugIn"   seperator=", " />
					</td>
				
				</tr>
				<tr>
					<td class="form_label" align="right" width="10%" nowrap="nowrap">${sheBeiShuX.DEVICE_PERIPHERAL}：</td>
					<td colspan="1"  width="90%" nowrap="nowrap">
						<d:checkbox perrow="12" id="peripheral"  name="device.peripheral"  dictTypeId="DEVICE_PERIPHERAL" property="device.peripheral"   seperator=", "  />
					</td>
				</tr>
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom"  style="text-align: center">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="button" value="查 询" class="button" onclick="mysubmit();">
							<input type="button" value="清 空" class="button" onclick="clears();">
							<input id=" exportExcel" type="button" class="button" value="导出列表" onclick="export_Excel();">
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
					action="/deviceManagement/deviceManagementAction_sumUpDevice.action" method="post">
            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    <h:hiddendata property="device" />
					<table align="center" border="0" width="100%" class="EOS_table">
						<tr>
				
							<th align="center" nowrap="nowrap">
								机构/部门
							</th>
							<th align="center" nowrap="nowrap">
								${sheBeiShuX.DEVICE_NAME}
							</th>
							<th align="center" nowrap="nowrap">
								型号
							</th>
						   <th align="center" nowrap="nowrap">
								数量
							</th>
						</tr>
						<w:radioGroup id="group1">
                            <l:iterate property="devices" id="id1">
							 <tr class="<l:output oddOutput="EOS_table_row_o" evenOutput='EOS_table_row' />">
								<td align="center" nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgnameTemp" />
								</td>
								<td align ="center" nowrap="nowrap"> 
									<d:write iterateId="id1" property="deviceName"  dictTypeId="DEVICE_NAME" />   
								</td>
								<td align ="center" nowrap="nowrap"> 
									<d:write iterateId="id1" property="deviceModel"  dictTypeId="DEVICE_MODEL"  />   
								</td>
								<td align ="center" nowrap="nowrap"> 
									<b:write iterateId="id1" property="tot"/>
								</td>
							</tr>
						</l:iterate>
					</w:radioGroup>

                      <table align="center" border="0" width="100%" class="EOS_table">
                      <tr>				
							<th align="center" nowrap="nowrap">
								合计
							</th>
						   <th align="center" nowrap="nowrap">
								<l:iterate property="heJis" id="id1">
								    <b:write iterateId="id1" property="heJi"/>
								</l:iterate>
																								
							</th>
						</tr>
                      </table>					
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
														selecthtml = 

	selecthtml
																

	+ "<option value="+value.deviceModel+">"
																

	+ value.deviceModelName
																

	+ "</option>";
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
				  showModalCenter(url, null,callBackFunc, 700, 600, '新增设备');
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
			  		var deviceId=rows.getParam("deviceId");
		  			var strUrl = "/deviceManagement/deviceManagementAction_toDevice.action?device.deviceId="+deviceId;
		  			showModalCenter(strUrl, null, callBackFunc, 700, 600, '修改设备');  
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
		  			alert("请选择一条记录");
		  			return;
		  		}else{
			  	  if(confirm("确定要删除该设备吗？")){
		  			var rows=gop.getSelectRow();
			  		var deviceId=rows.getParam("deviceId");
			  		$.ajax({
					      url: "/deviceManagement/deviceManagementAction_delete.action",
					      async: false,
					      type: 'post',
					      data: "device.deviceId="+deviceId,
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

			//维护明细查询
			function detail_search(){
				var gop = $id("group1");
		  		var len = gop.getSelectLength();
		  		if(len == 0){
		  			alert("请选择一条记录");
		  			return;
		  		}else{
		  			var rows=gop.getSelectRow();
			  		var deviceId=rows.getParam("deviceId");
		  			var strUrl = "/deviceManagement/deviceManagementAction_detailList.action?detail.deviceId="+deviceId;
		  			showModalCenter(strUrl, null, callBackFunc, 1000, 500, '修改设备');  
			  	}
			}
			

			//选择 部门/机构
			function open_orgcode_tree(flag){//方法名
				 //strUrl ="/deviceManagement/myMainTreeAction_initMainTree.action?changeTree.showTabOrg=1&changeTree.checkcount=1&changeTree.orgType=4&changeTree.showSelBox=4";
				 
				strUrl = "/deviceManagement/myMainTreeAction_initMainTree.action?changeTree.showTabOrg=1&changeTree.orgType=4&changeTree.showSelBox=4";//changeTree.checkcount=1为多选框可选个数，为1表示只能单选，若不指定选的个数，则需去掉
			     if(flag == "1"){
					  strUrl += "&orgflag=1";
				  }else if(flag == "2"){
					  strUrl += "&orgflag=2";
				  }
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
			var url = "/deviceManagement/deviceManagementAction_exportExcelsumUp.action?";
			var orgcode = $id("orgcode").value;
			var orgname = $id("orgname").value;
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
			+"&device.plugIn="+plugIn+"&device.peripheral="+peripheral+"&device.orgname="+orgname;
			window.location.href=url;
		  	
		}

		//导入Excel
		function import_Excel(){
			var url="/jsp/deviceManagement/deviceList_importExcel.jsp";
			showModalCenter(url, null,callBackFunc, 700, 300, '批量导入');
		}
		</script>
	</body>
</html>