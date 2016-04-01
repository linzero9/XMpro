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
<title>一级分类/贷级分类两级联动维护</title>
</head>
<body topmargin="0" leftmargin="0">
<DIV class="divList"  style="overflow:auto;width:100%; height:550;">
<h:form name="data_form"  id="data_form" action="/jbpm/xdProcessAction_save.action"  enctype="multipart/form-data" method="post" >
		<table align="center" border="0" width="100%" class="form_table">
			<h:hidden id="deviceId" property="xdProcessBean.definitionId"  name="xdProcessBean.definitionId"/>
			<tr>
				<td class="form_label" align="right" width="15%" nowrap="nowrap">流程名称：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:select  id="deviceName"  dictTypeId="DEVICE_NAME" property="xdProcessBean.processName" nullLabel="请选择"  ></d:select>
				</td>
			</tr>
			<tr>
				<td class="form_label" align="right" width="15%" nowrap="nowrap">一级分类</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:select  id="deviceModel"  dictTypeId="DEVICE_MODEL" property="xdProcessBean.oneCategory" nullLabel="请选择"></d:select>
				</td>
			</tr>
			<tr>
				<td class="form_label" align="right" width="15%" nowrap="nowrap">贷种分类</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:select  id="deviceModel"  dictTypeId="DEVICE_MODEL" property="xdProcessBean.loanCategory" nullLabel="请选择"></d:select>
				</td>
			</tr>
			
				<td colspan="2" style="text-align: left">
					<input type="button" value="保存" onclick="save();"  class="button"> 
					<input type="button" value="关闭" onclick="window.close();" class="button"></td>
			</tr>
		</table>
	</h:form>
	</DIV>
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