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
		<h:hidden id="mianID"  property="workTimeSideBean.mianID" />
		<table align="center" border="0" width="100%" class="form_table">
			<tr>
				<td class="form_label" align="right"  width="40%">工作日有效期：</td>
				<td colspan="1" width="60%"> 
					<%-- 开始日期 <w:date id="startDate" property="workTimeMainBean.startDate"  readonly="true" />	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					结束日期 <w:date id="endDate" property="workTimeMainBean.endDate"  readonly="true" />	 --%>
					开始日期<h:text property="workTimeMainBean.startDate"  readonly="true"/> 
					结束日期<h:text property="workTimeMainBean.endDate"  readonly="true" />
				</td>
			</tr>
			
			 <tr>
				<td class="form_label" align="right"  width="40%">
					名称：<h:text property="workTimeSideBean.timeType" />
				</td>
				<td colspan="1" width="60%"> 
				<%-- <h:hidden property="timeBean.id1" /> --%>
					开始时间 <w:time id="startTime0" property="timeBean.startTime1"  /><font style="color: red">*</font>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					结束时间 <w:time id="endTime1" property="timeBean.endTime1"  /><font style="color: red">*</font>	
					<br> <input type="button" value="清空" onclick="clears(0);" >
				</td>
			</tr>
			
		<%--	<tr>
				<td class="form_label" align="right"  width="40%">下午（必填）：</td>
				<td colspan="1" width="60%"> 
				<h:hidden property="timeBean.id2" />
					开始时间 <w:time id="startTime2" property="timeBean.startTime2"  /><font style="color: red">*</font>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					结束时间 <w:time id="endTime2" property="timeBean.endTime2"  /><font style="color: red">*</font>
					<br><input type="button" value="清空" onclick="clears2();" >	
				</td>
			</tr> --%>
			
			<tr>
				<td class="form_label" align="right"  width="40%">晚上（可选填）：</td>
				<td colspan="1" width="60%"> 
				<h:hidden property="timeBean.id3" />
					开始时间 <w:time id="startTime3" property="timeBean.startTime3"  />	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					结束时间 <w:time id="endTime3" property="timeBean.endTime3"  />	
					<br><input type="button" value="清空" onclick="clears3();" >
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
function clears1(){
/* 
//***********清空 工作日有效期******************************
	   $("#startDate_input").val("");
	   $("#endDate_input").val("");
	   $name("time.startDate").value = "";
	   $name("time.endDate").value = ""; */

//***********清空 上午时间******************************       
	   $("#INPUT_HOURstartTime1").val("");
	   $("#INPUT_MINUTEstartTime1").val("");
       $("#INPUT_SECONDstartTime1").val("");

       $("#INPUT_HOURendTime1").val("");
	   $("#INPUT_MINUTEendTime1").val("");
       $("#INPUT_SECONDendTime1").val("");
       $name("timeBean.startTime1").value = "null";
       $name("timeBean.endTime1").value = "null";
}
       function clears2(){      
 //***********清空 下午时间****************************** 
       $("#INPUT_HOURstartTime2").val("");
	   $("#INPUT_MINUTEstartTime2").val("");
       $("#INPUT_SECONDstartTime2").val("");

       $("#INPUT_HOURendTime2").val("");
	   $("#INPUT_MINUTEendTime2").val("");
       $("#INPUT_SECONDendTime2").val("");
       $name("timeBean.startTime2").value = "null";
       $name("timeBean.endTime2").value = "null";
       }

       function clears3(){

//***********清空 晚上时间****************************** 
       $("#INPUT_HOURstartTime3").val("");
	   $("#INPUT_MINUTEstartTime3").val("");
       $("#INPUT_SECONDstartTime3").val("");

       $("#INPUT_HOURendTime3").val("");
	   $("#INPUT_MINUTEendTime3").val("");
       $("#INPUT_SECONDendTime3").val("");
       $name("timeBean.startTime3").value = "null";
       $name("timeBean.endTime3").value = "null";
}

	function save() {
		var frm = $name("data_form");
		if (!checkForm(frm)) {
			return;
		}

		/* if($name("time.startDate").value == ""){
			alert("请为工作日有效期设置 开始日期！");
			return;
		}
		if($name("time.endDate").value == ""){
			alert("请为工作日有效期设置 结束日期！");
			return;
		} */
		
		if($name("timeBean.startTime1").value == "null"){
			alert("请为上午设置 开始时间！");
			return;
		}
		if($name("timeBean.endTime1").value == "null"){
			alert("请为上午设置 结束时间！");
			return;
		}
		if($name("timeBean.startTime2").value == "null"){
			alert("请为下午设置 开始时间！");
			return;
		}
		if($name("timeBean.endTime2").value == "null"){
			alert("请为下午设置 结束时间！");
			return;
		}

		/* if($name("time.endDate").value <= $name("time.startDate").value){
			alert("工作日有效期 结束日期必须大于始日期！");
			return;
			} */
		if($name("timeBean.endTime1").value <= $name("timeBean.startTime1").value){
			alert("上午 结束时间必须大于开始时间！");
			return;
			}
		if($name("timeBean.endTime2").value <= $name("timeBean.startTime2").value){
			alert("下午 结束时间必须大于开始时间！");
			return;
			}
		if($name("timeBean.startTime2").value <= $name("timeBean.endTime1").value){
			alert("下午 开始时间必须大于上午结束时间！");
			return;
			}
		
		if($name("timeBean.startTime3").value != "null" || $name("timeBean.endTime3").value != "null"){

			if($name("timeBean.startTime3").value == "null"){
				alert("请为晚上设置 开始时间！");
				return;
			}
			if($name("timeBean.endTime3").value == "null"){
				alert("请为晚上设置 结束时间！");
				return;
			}
			
			if($name("timeBean.endTime3").value <= $name("timeBean.startTime3").value){
				alert("晚上 结束时间必须大于开始时间！");
				return;
				}
			if($name("timeBean.startTime3").value <= $name("timeBean.endTime2").value){
				alert("晚上 开始时间必须大于下午结束时间！");
				return;
				}
		}

		ajaxsubmitO();
		
		/* var startDate = $id("startDate").value;
		var endDate = $id("endDate").value;
		
		$.ajax({
		      url: "/jbpm/timeLimitManageAction_checkDate.action",
		      async: false,
		      type: 'post',
		      data: "time.startDate="+startDate+"&time.endDate="+endDate,
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
		}); */	
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