<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script type="text/javascript" src="/js/jquery.form.js"></script>
<style>
.eos_dict_class{
margin-left:inherit;
}
</style>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新增/修改设备</title>
</head>
<body topmargin="0" leftmargin="0">
<DIV class="divList"  style="overflow:auto;width:100%; height:550;">
<h:form name="data_form"  id="data_form" action="/deviceManagement/deviceManagementAction_save.action"  enctype="multipart/form-data" method="post" >
		<table align="center" border="0" width="100%" class="form_table">
			<h:hidden id="deviceId" property="device.deviceId"  name="device.deviceId"/>
			<tr>
				<td class="form_label" align="right" nowrap="nowrap">机构/部门：</td>
				 <td colspan="1" nowrap="nowrap">
				        <h:text id="orgname" property="device.orgname"   readonly="true"  validateAttr="allowNull=false"  />
			            <h:hidden id="orgcode" property="device.orgcode" />
			      <a href="#" onclick="open_newyw_tree_fun1();">选择</a>
				</td>
			</tr>
			<tr>
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_NAME}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:select  id="deviceName"  dictTypeId="DEVICE_NAME" property="device.deviceName" nullLabel="请选择"  onchange="devicename(this.value)"></d:select>
				</td>
			</tr>
			<tr>
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_MODEL}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<select  id="deviceModels" onchange="changedeviceModel()"></select> 
					<h:hidden property="device.deviceModel" id="deviceModel" />
							
				<%-- 	<d:select  id="deviceModel"  dictTypeId="DEVICE_MODEL" property="device.deviceModel" nullLabel="请选择"></d:select> --%>
				</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">IP地址：</td>
				<td colspan="1" width="30%" nowrap="nowrap"><h:text id="ipAdress"
						property="device.ipAdress" validateAttr="type=IP" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">生产机器名称：</td>
				<td colspan="1" width="30%" nowrap="nowrap"><h:text id="productionMachineName"
						property="device.productionMachineName"  validateAttr="maxLength=127;" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">CPU型号：</td>
				<td colspan="1" width="30%" nowrap="nowrap"><h:text id="cpuCode"
						property="device.cpuCode"  validateAttr="maxLength=127;" /></td>						
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">内存容量：</td>
				<td colspan="1" width="30%" nowrap="nowrap"><h:text  id="memory"
						property="device.memory"  size="5"  validateAttr="fracDigit=2;type=double;" />G</td>				
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">硬盘容量：</td>
				<td colspan="1" width="30%" nowrap="nowrap"><h:text id="hardDisk"
						property="device.hardDisk"  size="5"  validateAttr="fracDigit=2;type=double;" />G</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_OS_VERSION}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:select  id="osVersion"  dictTypeId="DEVICE_OS_VERSION" property="device.osVersion" nullLabel="请选择"></d:select>
				</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">内置软件版本：</td>
				<td colspan="1" width="30%" nowrap="nowrap"><h:text id="softwareVersion"
						property="device.softwareVersion"  validateAttr="maxLength=127;" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_IE_VERSION}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:select id="ieVersion"  dictTypeId="DEVICE_IE_VERSION" property="device.ieVersion" nullLabel="请选择"></d:select>
				</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_USEFUL}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:checkbox   perrow="12" id="useful"  dictTypeId="DEVICE_USEFUL" property="device.useful"  seperator=", "  />
				</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">终端号：</td>
				<td colspan="1" width="30%"><h:text id="terminalNumber"
						property="device.terminalNumber"  validateAttr="maxLength=127;" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">使用人：</td>
				<td colspan="1" width="30%" nowrap="nowrap"><h:text id="user"
						property="device.user"  validateAttr="maxLength=127;" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_PLUGIN}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:checkbox   perrow="12"   id="plugIn"  dictTypeId="DEVICE_PLUGIN" property="device.plugIn"  seperator=", "/>
				</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_PERIPHERAL}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:checkbox    perrow="12"  id="peripheral"  dictTypeId="DEVICE_PERIPHERAL" property="device.peripheral"  seperator=", " />
				</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_OTHERATTRIBUTE_1}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:select id="otherAttribute_1"  dictTypeId="DEVICE_OTHERATTRIBUTE_1" property="device.otherAttribute_1" nullLabel="请选择"></d:select>
				</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_OTHERATTRIBUTE_2}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:select id="otherAttribute_2"  dictTypeId="DEVICE_OTHERATTRIBUTE_2" property="device.otherAttribute_2" nullLabel="请选择"></d:select>
				</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_OTHERATTRIBUTE_3}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:select id="otherAttribute_3"  dictTypeId="DEVICE_OTHERATTRIBUTE_3" property="device.otherAttribute_3" nullLabel="请选择"></d:select>
				</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_OTHERATTRIBUTE_4}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:select id="otherAttribute_4"  dictTypeId="DEVICE_OTHERATTRIBUTE_4" property="device.otherAttribute_4" nullLabel="请选择"></d:select>
				</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_OTHERATTRIBUTE_5}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:select id="otherAttribute_5"  dictTypeId="DEVICE_OTHERATTRIBUTE_5" property="device.otherAttribute_5" nullLabel="请选择"></d:select>
				</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_OTHERINFO_1}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:checkbox   perrow="12" id="otherInfo_1"  dictTypeId="DEVICE_OTHERINFO_1" property="device.otherInfo_1"  seperator=", " />
				</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_OTHERINFO_2}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:checkbox perrow="12"  id="otherInfo_2"  dictTypeId="DEVICE_OTHERINFO_2" property="device.otherInfo_2"  seperator=", " />
				</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_OTHERINFO_3}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:checkbox     perrow="12"    id="otherInfo_3"  dictTypeId="DEVICE_OTHERINFO_3" property="device.otherInfo_3"  seperator=", " />
				</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_OTHERINFO_4}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:checkbox  perrow="12"     id="otherInfo_4"  dictTypeId="DEVICE_OTHERINFO_4" property="device.otherInfo_4"  seperator=", " />
				</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_OTHERINFO_5}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:checkbox   perrow="12"    id="otherInfo_5"  dictTypeId="DEVICE_OTHERINFO_5" property="device.otherInfo_5"  seperator=", " />
				</td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_REMARKS_1}：</td>
				<td colspan="1" width="30%" nowrap="nowrap"><h:textarea property="device.remarks_1"
						id="remarks_1" extAttr="class='h80' "  rows="4" style="width:90%;"  validateAttr="maxLength=127;" /> </td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_REMARKS_2}：</td>
				<td colspan="1" width="30%" nowrap="nowrap"><h:textarea property="device.remarks_2"
						id="remarks_2" extAttr="class='h80' "  rows="4" style="width:90%;"  validateAttr="maxLength=127;" /> </td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_REMARKS_3}：</td>
				<td colspan="1" width="30%" nowrap="nowrap"><h:textarea property="device.remarks_3"
						id="remarks_3" extAttr="class='h80' "  rows="4" style="width:90%;"  validateAttr="maxLength=127;" /> </td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_REMARKS_4}：</td>
				<td colspan="1" width="30%" nowrap="nowrap"><h:textarea property="device.remarks_4"
						id="remarks_4" extAttr="class='h80' "  rows="4" style="width:90%;"  validateAttr="maxLength=127;" /> </td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_REMARKS_5}：</td>
				<td colspan="1" width="30%" nowrap="nowrap"><h:textarea property="device.remarks_5"
						id="remarks_5" extAttr="class='h80' "  rows="4" style="width:90%;"  validateAttr="maxLength=127;" /> </td>
			</tr>
			
			<l:notEmpty property="device.deviceState" >
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">${sheBeiShuX.DEVICE_STATE}：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:select dictTypeId="DEVICE_STATE" property="device.deviceState"  />
				</td>
			</tr>
			</l:notEmpty>
			
			<tr>
				<td colspan="2" style="text-align: left">
					&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					<input type="button" value="保存" onclick="save();"  class="button"> 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="关闭" onclick="closes();" class="button"></td>
			</tr>
		</table>
	</h:form>
	</DIV>
<script type="text/javascript">
$(function (){
	
	devicename($("#deviceName").val());
});

function devicename(value) {
	var deviceModel = $("#deviceModel").val();

	$("#deviceModel").val("");
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
							if(deviceModel != null && deviceModel == value.deviceModel ){
								selecthtml = selecthtml+ "<option value="+value.deviceModel+" selected='selected' "+">"+ value.deviceModelName+ "</option>";
					        }else{
					        	selecthtml = selecthtml+ "<option value="+value.deviceModel+">"+ value.deviceModelName+ "</option>";
						     }
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

function closes(){

	window.close();
}

	function save(){
		var frm=$name("data_form");
 		if(!checkForm(frm)){
			 return ;
		 }
		 
 		ajaxsubmitO();
	}

	function ajaxsubmitO() {
		maskTop();
		var options = {
			type : "post",
			cache : "false",
			success : function(data) {
				try {
					if (data.indexOf("success") >= 0) {
						alert("保存成功!");
						unMaskTop();
						returnValue();
						window.close();
					} else if (data.indexOf("fails") >= 0) {
						alert("保存失败!");
					} else {
						alert("操作失败!");
					}
				} catch (Exception) {
				}
			},
			error : function(data) {
				alert("添加失败请联系管理员！");
			}
		};
		
		$("#data_form").ajaxSubmit(options);
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

function returnValue(){
/*   	var deviceId=$id("deviceId").value;
  	var currentPages=$id("currentPages").value;
  	var gdzhi=$id("gdzhi").value; */
  	  //window.returnValue=[deviceId,currentPages,gdzhi];
  	  window.close();
  }

</script>
</body>
</html>