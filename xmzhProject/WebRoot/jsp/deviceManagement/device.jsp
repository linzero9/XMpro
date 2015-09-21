<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script type="text/javascript" src="/js/jquery.form.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新增设备</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/deviceManagement/deviceManagementAction_save.action"  enctype="multipart/form-data" method="post" >
		<table align="center" border="0" width="100%" class="form_table">
			<h:hidden id="deviceId" property="device.deviceId"  name="device.deviceId"/>
			<tr>
				<td class="form_label" align="right" width="15%">设备名称</td>
				<td colspan="1" width="30%"><h:text
						validateAttr="allowNull=false" id="deviceName"
						property="device.deviceName" /></td>
			</tr>
			<tr>
				<td class="form_label" align="right" width="15%">设备型号</td>
				<td colspan="1" width="30%"><h:text id="deviceModel"
						property="device.deviceModel" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">IP地址</td>
				<td colspan="1" width="30%"><h:text id="ipAdress"
						property="device.ipAdress" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">生产机器名称</td>
				<td colspan="1" width="30%"><h:text id="productionMachineName"
						property="device.productionMachineName" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">CPU型号</td>
				<td colspan="1" width="30%"><h:text id="cpuCode"
						property="device.cpuCode" /></td>						
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">内存容量</td>
				<td colspan="1" width="30%"><h:text  id="memory"
						property="device.memory" /></td>				
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">硬盘容量</td>
				<td colspan="1" width="30%"><h:text id="hardDisk"
						property="device.hardDisk" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">操作系统版本</td>
				<td colspan="1" width="30%"><h:text id="osVersion"
						property="device.osVersion" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">内置软件版本</td>
				<td colspan="1" width="30%"><h:text id="softwareVersion"
						property="device.softwareVersion" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">IE版本</td>
				<td colspan="1" width="30%"><h:text id="ieVersion"
						property="device.ieVersion" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">用途</td>
				<td colspan="1" width="30%"><h:text id="useful"
						property="device.useful" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">终端号</td>
				<td colspan="1" width="30%"><h:text id="terminalNumber"
						property="device.terminalNumber" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">使用人</td>
				<td colspan="1" width="30%"><h:text id="user"
						property="device.user" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">安装的插件</td>
				<td colspan="1" width="30%"><h:text id="plugIn"
						property="device.plugIn" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">对应的外设</td>
				<td colspan="1" width="30%"><h:text id="peripheral"
						property="device.peripheral" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">其他属性</td>
				<td colspan="1" width="30%"><h:text id="otherOne"
						property="device.otherOne" /></td>
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">备注</td>
				<td colspan="1" width="30%"><h:text id="remarksOne"
						property="device.remarksOne" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center"><input type="button" value="保存"
					onclick="save();"  class="button"> <input type="button" value="关闭"
					onclick="window.close();" class="button"></td>
			</tr>
		</table>
	</h:form>
<script type="text/javascript">

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

</script>
</body>
</html>