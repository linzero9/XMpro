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
				<td colspan="1" width="60%"   > 
				<h:hidden id="time"  property="day.time"/>
	              <input id="date0" onclick="WdatePicker({el:this,dateFmt:'yyyy/MM/dd ',onpicked:null})"/>
	              <font style="color: red">*</font>
                  <h:img alt="添加"   src="../images/e_add.gif" onclick="add_time();" /><br/>
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
		
		if($name("day.status").value == ""){
			alert("是否在用 不能为空！");
			return;
		}

		$name("day.time").value = "";//每次点保存，都要先清除之前的值，再赋值，以免检验不通过时多次点保存，导致重复赋值！
		$("#time").val("");

		var date = "";	
		for(var i=0; i<a; i++){
			date =$("#date"+i).val();
			
			//日期内容不为空的时候，才将值拼接起来
			if(date != ""){
				
					$("#time").val( $("#time").val()+ date + "," ); 
			}
						 
		}

		if($("#time").val() != ""){
			//将拼接好的值去掉最后的 空格+逗号,空格是时间控件会自动加的
			$("#time").val($("#time").val().substring(0,$("#time").val().length-2));
		}
		
		if($name("day.time").value == ""){
			alert("时间 不能为空！");
			return;
		}
		

		var flag = true; //判断时间检验是否校验成功的标志
		for(var i=0; i<a; i++){
			date =$("#date"+i).val();
			
			 if(date != ""){

				 //检验日期在数据库里是否已存在
				 $.ajax({
				      url: "/timeMachine/tModelTimedayAction_checkDayTime.action",
				      async: false,
				      type: 'post',
				      data: "day.time="+date,
				      timeout: 60000,
				      dataType:"text",
				      success: function (data) {
				    	  if (data.indexOf("notExist") >= 0) {
				    		//继续下一个时间校验
						}else if (data.indexOf("exist") >= 0) {
							alert(date+"该日期已维护，请重新配置！");
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

		//onclick="WdatePicker( {el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'} )"
		//可以根据格式化  选择 是否需要时分秒
	    $("#add_time").append(" 	 <input id='date"+a+"'  onclick='WdatePicker({el:this,dateFmt:\"yyyy/MM/dd \",onpicked:null})''/> <br/>");
		a += 1;
		
	}

</script>
</body>
</html>