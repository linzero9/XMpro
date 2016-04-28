<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>工作时间维护</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/jbpm/timeLimitManageAction_saveWorkTime.action"   method="post" >
		<w:panel id="panel1" title="工作时间维护">
		<table align="center" border="0" width="100%" class="form_table">
			<tr>
				<td class="form_label" align="right"  width="40%">工作日有效期（必填）：</td>
				<td colspan="1" width="60%"> 
					开始日期 <w:date id="startDate"  property="time.startDate"  /><font style="color: red">*</font>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					结束日期 <w:date id="endDate"  property="time.endDate"  /><font style="color: red">*</font>	
				</td>
			</tr>
			
			<tr>
				<td class="form_label" align="right"  width="40%">上午（必填）：</td>
				<td colspan="1" width="60%"> 
					开始时间 <w:time id="startTime1" property="time.startTime1"  /><font style="color: red">*</font>	  &nbsp;&nbsp;&nbsp;
					结束时间 <w:time id="endTime1" property="time.endTime1"  /><font style="color: red">*</font>	
				</td>
			</tr>
			
			<tr>
				<td class="form_label" align="right"  width="40%">下午（必填）：</td>
				<td colspan="1" width="60%"> 
					开始时间 <w:time id="startTime2" property="time.startTime2"  /><font style="color: red">*</font>	&nbsp;&nbsp;&nbsp;
					结束时间 <w:time id="endTime2" property="time.endTime2" /><font style="color: red">*</font>	
				</td>
			</tr>
			
			<tr>
				<td class="form_label" align="right"  width="40%">晚上（可选填）：</td>
				<td colspan="1" width="60%"> 
					开始时间 <w:time id="startTime3" property="time.startTime3"  />	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					结束时间 <w:time id="endTime3" property="time.endTime3"  />	
				</td>
			</tr>
			
			<tr>
				<td colspan="2" style="text-align: center">
					<input type="button" value="保存" onclick="save();"  class="button">
					<input type="button" value="清空" onclick="clears();" class="button"> 
				</td>
			</tr>
		</table>
		</w:panel>
	</h:form>
<script type="text/javascript">
function clears(){
	//$("#startDate_input").val("");
	var a = $("#startDate_input");
	var b = $("#startTime1_hidden");

	
	alert( $("#startDate_input").val() );
	$("#startTime1_container").clear();
	//$name("time.startTime1").clear();
	//$("#startTime1_hidden").clear();
	//$id("startTime1_hidden").clear();
	/* $id("startDate_input").value == "";
	$id("endDate_input").value == ""; */
	/* $id("startTime1_input").value == "";
	$name("time.endTime1").value == ""; */
}

	function save() {
		var frm = $name("data_form");
		if (!checkForm(frm)) {
			return;
		}

		if($name("time.startDate").value == ""){
			alert("请为工作日有效期设置 开始日期！");
			return;
		}
		if($name("time.endDate").value == ""){
			alert("请为工作日有效期设置 结束日期！");
			return;
		}
		
		if($name("time.startTime1").value == "null"){
			alert("请为上午设置 开始时间！");
			return;
		}
		if($name("time.endTime1").value == "null"){
			alert("请为上午设置 结束时间！");
			return;
		}
		if($name("time.startTime2").value == "null"){
			alert("请为下午设置 开始时间！");
			return;
		}
		if($name("time.endTime2").value == "null"){
			alert("请为下午设置 结束时间！");
			return;
		}
		/* var a = $name("time.startTime3").value;
		if($name("time.startTime3").value == "null"){
			$name("time.startTime3").value == "";
		}
		if($name("time.endTime3").value == "null"){
			$name("time.endTime3").value == "";
		}
		var b = $name("time.startTime3").value; */
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