<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />

<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>

  <script src="/jsp/timeMachine/WdatePicker.js"></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>维护工作日</title>


</head>



<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/timeMachine/tModelTimedayAction_saveWorkDay.action"   method="post" >
		
		<h:hidden property="day.mainID" />
		
		<table align="center" border="0" width="100%" class="form_table">
			<tr>
				<td class="form_label" align="right"  width="30%">工作日有效期：</td>
				<td colspan="1" width="60%"> 
					<%-- 开始日期 <w:date id="startDate" property="day.startDate"  readonly="true" />	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					结束日期 <w:date id="endDate" property="day.endDate"  readonly="true" />	 --%>
					开始日期<h:text property="day.startDate"  readonly="true"/> 
					结束日期<h:text property="day.endDate"  readonly="true" />
				</td>
			</tr>
			<tr>
				<td class="form_label" align="right"  width="30%">类型：</td>
				<td colspan="1" width="60%"> 
					<d:select dictTypeId="TIMEDAY_TYPE"  property="day.type"  nullLabel="请选择"></d:select>
					<font style="color: red">*</font>
				</td>
			</tr>
			<tr>
				<td class="form_label" align="right"  width="30%">时间：</td>
				<td colspan="1" width="60%"  id="timees" > 
				
	              <input id="date" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd ',onpicked:null})"/>
	              
	              
                  <h:img alt="添加"   src="../images/e_add.gif" onclick="add_time();" />
                  <br/><br/><div  id="wujiajundate" ></div>
					<div id="add_time" ></div>
			
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

		if($name("day.type").value == ""){
			alert("类型 不能为空！");
			return;
		}
		if($name("day.time").value == ""){
			alert("非工作日 不能为空！");
			return;
		}
		if($name("day.status").value == ""){
			alert("是否在用 不能为空！");
			return;
		}

		if($name("day.time").value < $name("day.startDate").value || $name("day.time").value>= $name("day.endDate").value){
			alert("非工作日必须在工作日有效期之内！");
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
					alert("该 非工作日 日期已存在，请重新配置！");
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

	var rowId = 1; 
	function add_time() {

		//onclick="WdatePicker( {el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'} )"
		//可以根据格式化  选择 是否需要时分秒
	    $("#wujiajundate").append(" 	 <input id='date'  onclick='WdatePicker({el:this,dateFmt:\"yyyy-MM-dd \",onpicked:null})''/> <br/> <br/>");


	    
	}
	

</script>
</body>
</html>