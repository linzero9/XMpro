<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>设置 时限</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form"  action="/jbpm/timeLimitManageAction_saveModelName.action" method="post" onsubmit="return checkForm(this);">
		<table align="center" border="0" width="100%" class="form_table">
		
		<h:hidden id="definitionId" property="proTimeModelBean.definitionId" /> 
			<tr>
				<td class="form_label" align="right" width="15%">时限模版名称</td>
				<td colspan="1" width="30%">
				<h:text id="time_modelName"  property="proTimeModelBean.time_modelName"  validateAttr="allowNull=false;"/>
				</td>
			</tr>
			<tr class="form_bottom">
				<td colspan="2"><input type="button" value="保存" onclick="saveModelName()"
					 class="button" > <input
					type="button" value="关闭" onclick="window.close();" class="button"></td>
			</tr>
		</table>
	</h:form>
<script type="text/javascript">

	function saveModelName() {
		var frm = $name("data_form");
		if (!checkForm(frm)) {
			return;
		}

		var definitionId = $id("definitionId").value;
		var time_modelName = $id("time_modelName").value;
		
		$.ajax({
		      url: "/jbpm/timeLimitManageAction_checkTimeModelName.action",
		      async: false,
		      type: 'post',
		      data: "proTimeModelBean.definitionId="+definitionId+"&proTimeModelBean.time_modelName="+time_modelName,
		      timeout: 60000,
		      success: function (data) {
		       if (data.indexOf("notExist") >= 0) {
		    		  ajaxsubmitO(); 
				}else if (data.indexOf("exist") >= 0){
					alert("该流程已存在此模版名称！请重新输入！");	
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
						unMaskTop();
					} else {
						alert("操作失败!");
						unMaskTop();
					}
				} catch (Exception) {
				}
			},
			error : function(data) {
				alert("添加失败请联系管理员！");
				unMaskTop();
			}
		};
		$("#data_form").ajaxSubmit(options);
	}

</script>
</body>
</html>