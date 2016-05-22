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
<title>工作时间维护</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/jbpm/timeLimitManageAction_saveWorkTime.action"   method="post" >
		<h:hidden id="mainID"  property="workTimeSideBean.mainID" />
		<table align="center" border="0" width="100%" class="form_table" id="tab">
			<tr>
				<td class="form_label" align="right"  width="30%">工作日有效期：</td>
				<td colspan="1" width="70%"> 
					<%-- 开始日期 <w:date id="startDate" property="workTimeMainBean.startDate"  readonly="true" />	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					结束日期 <w:date id="endDate" property="workTimeMainBean.endDate"  readonly="true" />	 --%>
					开始日期 <h:text property="workTimeMainBean.startDate"  readonly="true"/> &nbsp;
					结束日期 <h:text property="workTimeMainBean.endDate"  readonly="true" />
				</td>
			</tr>
			
			 <tr>
				<td class="form_label" align="right"  width="30%">
				<h:hidden id="timeType" property="workTimeSideBean.timeType"  />
					名称：<input type="text" id="timeType0" size="8"  >
				</td>
				<td colspan="1" width="70%"> 
				<h:hidden id="startTime" property="workTimeSideBean.startTime" />
				<h:hidden id="endTime" property="workTimeSideBean.endTime" />
					<%-- 开始时间 <w:time id="startTime0" /><font style="color: red">*</font>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					结束时间 <w:time id="endTime0"  /><font style="color: red">*</font>	 --%>
					开始时间 <input id="startTime0" onclick="WdatePicker({el:this,dateFmt:'HH:mm:ss',onpicked:null})"/><font style="color: red">*</font>
					结束时间 <input id="endTime0" onclick="WdatePicker({el:this,dateFmt:'HH:mm:ss',onpicked:null})"/><font style="color: red">*</font>	
					<h:img alt="添加"   src="../images/e_add.gif" onclick="add_time();" /><br/>
				</td>
			</tr>
			</table>
			<table align="center" border="0" width="100%" class="form_table" >
			<tr>
				<td colspan="2" style="text-align: center">
					<input type="button" value="保存" onclick="save();"  class="button">
					<input type="button" value="关闭" onclick="window.close()"  class="button">
				</td>
			</tr>
		</table>
	</h:form>
<script type="text/javascript">
/* function clears(num){

//***********清空 工作日有效期******************************
	  // $("#startDate_input").val("");
	  // $("#endDate_input").val("");
	  // $name("time.startDate").value = "";
	  //$name("time.endDate").value = ""; 

//***********清空 上午时间******************************       
	   $("#INPUT_HOURstartTime1").val("");
	   $("#INPUT_MINUTEstartTime1").val("");
       $("#INPUT_SECONDstartTime1").val("");

       $("#INPUT_HOURendTime1").val("");
	   $("#INPUT_MINUTEendTime1").val("");
       $("#INPUT_SECONDendTime1").val("");
       $name("timeBean.startTime1").value = "null";
       $name("timeBean.endTime1").value = "null";
} */



	function save() {
		var frm = $name("data_form");
		if (!checkForm(frm)) {
			return;
		}

		//每次点保存，都要先清除之前的值，再赋值，以免检验不通过时多次点保存，导致重复赋值！
		$id("timeType").value = "";
		$id("startTime").value = "";
		$id("endTime").value = "";

		
		var type = "";	
		var start = "";
		var end = "";
		for(var i=0; i<a; i++){
			$id("timeType"+i).className = ""; //把校验失败的红框去掉
			$id("startTime"+i).className = ""; //把校验失败的红框去掉
			$id("endTime"+i).className = ""; //把校验失败的红框去掉
			
			type =$("#timeType"+i).val();
			start =$("#startTime"+i).val();
			end =$("#endTime"+i).val();
			
			//1.校验时间不能为空	
			//内容不为空的时候，才将值拼接起来
			if(type != "" && type != undefined){
				$("#timeType").val( $("#timeType").val()+ type + "," ); 
			}else if(type == ""){
				alert("名称 不能为空！");
				$id("timeType"+i).className = "verify_failure"; //让输入框外框变，必须用$id("timeType"+i)，用$("#timeType"+i)则无效果
				$("#timeType"+i).focus(); //聚焦，将光标移到该输入框
				return;
			}else if(type == undefined){
				continue;
			}
			
			if(start != "" && start != undefined){
				$("#startTime").val( $("#startTime").val()+ start + "," ); 
			}else if(start == ""){
				alert("开始时间 不能为空！");
				$id("startTime"+i).className = "verify_failure";//让输入框外框变红框，必须用$id("timeType"+i)，用$("#timeType"+i)则无效果
				$("#startTime"+i).focus(); //聚焦，将光标移到该输入框
				return;
			}else if(start == undefined){
				continue;
			}
			
			if(end != "" && end != undefined){
				$("#endTime").val( $("#endTime").val()+ end + "," ); 
			}else if(end == ""){
				alert("结束时间 不能为空！");
				$id("endTime"+i).className = "verify_failure";//让输入框外框变红框，必须用$id("timeType"+i)，用$("#timeType"+i)则无效果
				$("#endTime"+i).focus();//聚焦，将光标移到该输入框
				return;
			}else if(end == undefined){
				continue;
			}

			//2.校验结束时间不能小于开始时间
			if(end <= start){
				alert("结束时间 必须大于 开始时间！");
				$id("endTime"+i).className = "verify_failure";//让输入框外框变红框，必须用$id("timeType"+i)，用$("#timeType"+i)则无效果
				$("#endTime"+i).focus();//聚焦，将光标移到该输入框
				return;
			}
						 
		}

		if($("#timeType").val() != ""){
			//将拼接好的值去掉最后的 空格+逗号,空格是时间控件会自动加的
			$("#timeType").val($("#timeType").val().substring(0,$("#timeType").val().length-1));
		}
		if($("#startTime").val() != ""){
			//将拼接好的值去掉最后的 空格+逗号,空格是时间控件会自动加的
			$("#startTime").val($("#startTime").val().substring(0,$("#startTime").val().length-1));
		}
		if($("#endTime").val() != ""){
			//将拼接好的值去掉最后的 空格+逗号,空格是时间控件会自动加的
			$("#endTime").val($("#endTime").val().substring(0,$("#endTime").val().length-1));
		}

	//3.校验页面输入的时间范围不能有交集
	for(var i=0; i<a; i++){
		var i_st =  $("#startTime"+i).val();
		var i_et =  $("#endTime"+i).val();
		
		for(var j= i+1; j<a; j++){
			var j_st = $("#startTime"+j).val();
			var j_et = $("#endTime"+j).val();
			
			if( ((j_st <= i_st) && (j_et >= i_st)) || ((j_st <= i_et) && (j_et >= i_et)) || ((j_st >= i_st) && (j_et <= i_et)) ){
			    alert("页面时间范围重叠！请重新配置！");
			    $id("startTime"+i).className = "verify_failure";
				$id("endTime"+i).className = "verify_failure";
				$id("startTime"+j).className = "verify_failure";
				$id("endTime"+j).className = "verify_failure";
				return; //则不继续后面的校验
			}
		}
	}

	//4.检验时间在数据库里是否有重叠交集	
		var flag = false; //判断时间检验是否校验成功的标志
	for(var i=0; i<a; i++){
		start = $("#startTime"+i).val();
		end = $("#endTime"+i).val();
		mainID = $("#mainID").val();

		if(start != "" && end != "" && start != undefined && end != undefined){

		$.ajax({
		      url: "/jbpm/timeLimitManageAction_checkWorkTime.action",
		      async: false,
		      type: 'post',
		      data: "time.startTime="+start+"&time.endTime="+end+"&time.mainID="+mainID,
		      timeout: 60000,
		      dataType:"text",
		      success: function (data) {
		    	  if (data.indexOf("notExist") >= 0) {
		    		//继续下一个时间校验
		    		  flag = true;
				}else if (data.indexOf("exist") >= 0) {
					alert("该时间范围内已存在配置信息，请重新配置！");
					$id("startTime"+i).className = "verify_failure";
					$id("endTime"+i).className = "verify_failure";
					flag = false;
				} else if (data.indexOf("fails") >= 0) {
					alert("日期校验失败！");
					flag = false;
				} else {
					alert("操作失败!");
					flag = false;
				}
						  	
		      }
		});	

		if(!flag){//flag为false，跳出循环
			break;
		}

	  }
	}

	if(flag){//flag为true，表单才提交
		//表单提交
		  ajaxsubmitO();
	}
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

	var a = 1; 
	function add_time() {
		var tab = $id("tab");
		var row = tab.insertRow();
		row.id = "myRow"+a;
		
		var td1 = row.insertCell(); 
		td1.className = "form_label";
		td1.align = "right";
		td1.innerHTML = "名称：<input type='text' id='timeType"+a+"'  size='8'/>";
		
		var td2 = row.insertCell(); 
		//时间控件 可以根据格式化  选择 是否需要时分秒
		td2.innerHTML = "开始时间 <input id='startTime"+a+"'  onclick='WdatePicker({el:this,dateFmt:\"HH:mm:ss\",onpicked:null})''/> 	&nbsp;"+
								"结束时间 <input id='endTime"+a+"'  onclick='WdatePicker({el:this,dateFmt:\"HH:mm:ss\",onpicked:null})''/>  &nbsp;"+
								"<input type=\"button\" onclick=\"del_addTr('myRow"+a+"');\" name='button"+a+"' value=\"删除\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
		
		a += 1;
	}

	function del_addTr(id){
		$("#"+id).remove(); //JSP页面移除一行
	}
</script>
</body>
</html>