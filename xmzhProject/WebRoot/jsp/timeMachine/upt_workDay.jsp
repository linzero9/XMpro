<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改工作日</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/timeMachine/tModelTimedayAction_updateWorkDay.action"   method="post" >
		
		<h:hidden property="day.id" />
		
		<table align="center" border="0" width="100%" class="form_table">
			<tr>
				<td class="form_label" align="right"  width="30%">类型：</td>
				<td colspan="1" width="60%"> 
					<d:select dictTypeId="TIMEDAY_TYPE"  property="day.type"  nullLabel="请选择"></d:select>
					<font style="color: red">*</font>
				</td>
			</tr>
			<tr>
				<td class="form_label" align="right"  width="30%">时间：</td>
				<td colspan="1" width="60%"> 
					<w:date id="time"  property="day.time"  format="yyyy/MM/dd"  submitFormat="yyyy/MM/dd" />
					<font style="color: red">*</font>
				</td>
			</tr>
			<tr>
				<td class="form_label" align="right"  width="30%">备注：</td>
				<td colspan="1" width="60%"> 
					<h:textarea rows="5"  cols="30"  property="day.remark" />
				</td>
			</tr>
			<tr>
				<td class="form_label" align="right"  width="30%">是否在用：</td>
				<td colspan="1" width="60%"> 
					<d:select dictTypeId="TIMEDAY_STATUS"  property="day.status"  value="0"></d:select>
					<font style="color: red">*</font>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" style="text-align: center">
					<input type="button" value="保存" onclick="save();"  class="button">
					<input type="button" value="关闭" onclick="window.close()"  class="button">
				</td>
			</tr>
		</table>
	</h:form>
<script type="text/javascript">

	function save() {
		var frm = $name("data_form");
		if (!checkForm(frm)) {
			return;
		}

		if($name("day.time").value == ""){
			alert("非工作日 不能为空！");
			return;
		}
		if($name("day.type").value == ""){
			alert("类型 不能为空！");
			return;
		}
		if($name("day.status").value == ""){
			alert("是否在用 不能为空！");
			return;
		}

		var time =$name("day.time").value;
		
		$.ajax({
		      url: "/timeMachine/tModelTimedayAction_checkDayTime.action",
		      async: false,
		      type: 'post',
		      data: "day.time="+time,
		      timeout: 60000,
		      dataType:"text",
		      success: function (data) {
		    	  if (data.indexOf("notExist") >= 0) {
		    		  ajaxsubmitO();
				}else if (data.indexOf("exist") >= 0) {
					alert("该日期已维护，请重新配置！");
				} else if (data.indexOf("fails") >= 0) {
					alert("日期校验失败！");
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