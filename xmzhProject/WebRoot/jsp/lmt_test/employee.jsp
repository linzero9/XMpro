<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script type="text/javascript" src="/js/jquery.form.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新增员工</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/lmt_test/omEmployeeAction_save.action"  enctype="multipart/form-data" method="post" >
		<table align="center" border="0" width="100%" class="form_table">
			<h:hidden id="empid" property="employee.empid"  name="employee.empid"/>
			
			<tr>
				<td class="form_label" align="right" width="15%">员工姓名：</td>
				<td colspan="1" width="30%"><h:text
						validateAttr="allowNull=false;maxLength=15" id="empname"
						property="employee.empname" /></td>
			</tr>
			<tr>
				<td class="form_label" align="right">员工编号：</td>
				<td colspan="1" width="30%"><h:text
						validateAttr="allowNull=false;maxLength=15" id="empcode"
						property="employee.empcode" /></td>
			</tr>
			
			<tr id="isWholebankTr">
				<td class="form_label" align="right"><nobr>性别：</nobr></td>
				<td colspan="1" width="30%"><d:radio dictTypeId="ABF_GENDER"   property="employee.gender" name="employee.gender" style="width:133"  value="1"/></td>
			</tr>
			
			<tr>
				<td class="form_label" align="right">证件号码：</td>
				<td colspan="1" width="30%"><h:text
						validateAttr="allowNull=false;maxLength=15" id="cardno"
						property="employee.cardno" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center"><input type="button" value="保存"
					onclick="save();"  class="button"> <input type="button" value="关闭"
					onclick="window.close();" class="button"></td>
			</tr>
		</table>
	</h:form>
<script type="text/javascript">

	function save(){
		var frm=$name("data_form");
 		if(!checkForm(frm)){
			 return ;
		 }
		 var empcode =  $id("empcode").value;
 		$.ajax({
		      url: "/lmt_test/omEmployeeAction_empcodeIExist.action",
		      async: false,
		      type: 'post',
		      data: "employee.empcode="+empcode,
		      timeout: 60000,
		      success: function (data) {
		    	  if (data.indexOf("success") >= 0) {
		    		  ajaxsubmitO(); 
				  } else if (data.indexOf("isExist") >= 0) {
					  alert("该员工编号已存在！");
					  return;
				  }else if (data.indexOf("false") >= 0) {
					  alert("操作失败！");
					  return;
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