<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改有效日</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/jbpm/timeLimitManageAction_uptValidDayById.action"   method="post" >
		<h:hidden id="id" property="workTimeMainBean.id"  />
		<table align="center" border="0" width="100%" class="form_table">
			<tr>
				<td > 
					有效日开始日期 <w:date id="startDate" property="workTimeMainBean.startDate"  /><font style="color: red">*</font>
				</td>
				<td> 
					有效日结束日期 <w:date id="endDate" property="workTimeMainBean.endDate"  /><font style="color: red">*</font>	
				</td>
			</tr>
			
			<tr>
				<td colspan="2" style="text-align: center">
					<input type="button" value="保存" onclick="save();"  class="button">
					<input type="button" value="清空" onclick="clears();" class="button"> 
				</td>
			</tr>
		</table>
	</h:form>
<script type="text/javascript">
function clears(){

//***********清空 工作日有效期******************************
	   $("#startDate_input").val("");
	   $("#endDate_input").val("");
	   $name("workTimeMainBean.startDate").value = "";
	   $name("workTimeMainBean.endDate").value = "";
}

	function save() {
		var frm = $name("data_form");
		if (!checkForm(frm)) {
			return;
		}

		if($name("workTimeMainBean.startDate").value == ""){
			alert("请为工作日有效期设置 开始日期！");
			return;
		}
		if($name("workTimeMainBean.endDate").value == ""){
			alert("请为工作日有效期设置 结束日期！");
			return;
		}

		if($name("workTimeMainBean.endDate").value <= $name("workTimeMainBean.startDate").value){
			alert("工作日有效期 结束日期必须大于始日期！");
			return;
			}

		var id = $id("id").value;
		var startDate = $id("startDate").value;
		var endDate = $id("endDate").value;
		
		$.ajax({
		      url: "/jbpm/timeLimitManageAction_checkDate.action",
		      async: false,
		      type: 'post',
		      data: "time.startDate="+startDate+"&time.endDate="+endDate+"&time.id="+id,
		      timeout: 60000,
		      dataType:"text",
		      success: function (data) {
		    	  if (data.indexOf("notExist") >= 0) {
		    		  ajaxsubmitO();
				}else if (data.indexOf("exist") >= 0) {
					alert("在此工作日有效期时间范围内已存在配置信息，请重新配置！");
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