<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>

<h:css href="/css/style1/style-custom.css" />
<script type="text/javascript" src="/js/jquery.form.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新增设备名称、型号对应关系</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/deviceManagement/deviceNameAndModelAction_addItem.action"  enctype="multipart/form-data" method="post" >
		<table align="center" border="0" width="100%" class="form_table">
			
			<tr>	
				<td class="form_label" align="right" width="15%">设备名称：</td>
				<td colspan="1" width="30%">
				<h:hidden id="devicename_id" property="deviceNameAndModel.devicename_id" />
				<h:text id="devicename" property="deviceNameAndModel.devicename"  readonly="true"  validateAttr="allowNull=false" />
							<a href="#" onclick="showDevicenameDic();">选择</a>	
							<font style="color: red">（只选一个）</font>	
				</td>						
			</tr>
			
			<tr>	
				<td class="form_label" align="right" width="15%">设备型号：</td>
				<td colspan="1" width="30%">
				<h:hidden id="devicemodel_id"  property="deviceNameAndModel.devicemodel_id"  />
				<h:textarea rows="5" cols="40"  id="devicemodel" property="deviceNameAndModel.devicemodel"  readonly="true"  extAttr="class='h80' "  validateAttr="allowNull=false" />
							<a href="#" onclick="showDevicemodelDic();">选择</a>		
				</td>						
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

 		var devicename= $id("devicename").value;  //设备名称
		var devicemodel = $id("devicemodel").value;  //设备型号

		var arr = devicename.split(", ");
		if(arr.length > 1){
			alert("设备名称只能选择一个！");
			return;
		}
		
 		$.ajax({
		      url: "/deviceManagement/deviceNameAndModelAction_checkDeviceNameAndModel.action",
		      async: false,
		      type: 'post',
		      data: "deviceNameAndModel.devicename="+devicename+"&deviceNameAndModel.devicemodel="+devicemodel,
		      timeout: 60000,
		      success: function (data) {
		       if (data.indexOf("success") >= 0) {
		    		  ajaxsubmitO(); 
				}else if (data.indexOf("success") < 0){
					alert("操作失败！该设备名称与型号("+data+")的对应关系已存在！请重新选择！");	
				} else {
					alert("操作失败!");
				}
		      }
		}); 
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

	// 数据字典 多选按钮显示页面
	function showDevicenameDic() {
		var devicename_id=document.getElementById("devicename_id").value;
		strUrl ="/deviceManagement/deviceNameAndModelAction_showDevicenameDic.action?deviceJson="+devicename_id,
		showModalCenter(strUrl,'',showDevicenameDic_callback ,800,430,'选择'); 
	} 
	function showDevicenameDic_callback(args){
		if(args!=''){
		var array;
		array = args.split(":");
		 document.getElementById("devicename_id").value = array[0];
		 document.getElementById("devicename").value = array[1];
		}
	}

	// 数据字典 多选按钮显示页面
	function showDevicemodelDic() {
		var devicemodel_id=document.getElementById("devicemodel_id").value;
		strUrl ="/deviceManagement/deviceNameAndModelAction_showDevicemodelDic.action?deviceJson="+devicemodel_id;

		showModalCenter(encodeURI(strUrl),'',showDevicemodelDic_callback ,800,500,'选择'); 
	} 
	function showDevicemodelDic_callback(args){
		if(args!=''){
		var array;
		array = args.split(":");
		 document.getElementById("devicemodel_id").value = array[0];
		 document.getElementById("devicemodel").value = array[1];
		}
	}	
</script>
</body>
</html>