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
<h:form name="data_form"  id="data_form"  action="/jbpm/timeLimitManageAction_saveNodeTimeLimit.action" method="post" onsubmit="return checkForm(this);">
		<table align="center" border="0" width="100%" class="form_table">
		<h:hidden id="e_id" property="nodeTimeLimitBean.e_id" /> 
		<h:hidden id="c_id" property="nodeTimeLimitBean.c_id" />
			<tr>
				<td class="form_label" align="right" width="15%">节点名称：</td>
				<td colspan="1" width="30%">
				<h:text id="taskName"  property="nodeTimeLimitBean.taskName" readonly="true"/>
				</td>
			</tr>
			<tr>
				<td class="form_label" align="right">时限：</td>
				<td colspan="1">
				<h:text id="timeLimit" property="nodeTimeLimitBean.timeLimit"   validateAttr="type=double;minValue=0;" /> 工时
			</tr>
			<tr>
				<td class="form_label" align="right">二次提交时限：</td>
				<td colspan="1">
				<h:text id="twotimeLimit" property="nodeTimeLimitBean.twotimeLimit"   validateAttr="type=double;minValue=0;" /> 工时
			</tr>
			<tr class="form_bottom">
				<td colspan="2"><input type="button" value="保存" onclick="saveNodeTimeLimit()"
					 class="button" > <input
					type="button" value="关闭" onclick="window.close();" class="button"></td>
			</tr>
		</table>
	</h:form>
<script type="text/javascript">

	function saveNodeTimeLimit() {
		var frm = $name("data_form");
		if (!checkForm(frm)) {
			return;
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