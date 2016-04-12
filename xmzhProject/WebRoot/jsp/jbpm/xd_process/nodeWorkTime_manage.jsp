<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script type="text/javascript" src="/js/jquery.form.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>节点工时维护</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/jbpm/xdProcessAction_saveNodeWorkTime.action"  enctype="multipart/form-data" method="post" >
		<w:panel id="panel1" title="节点工时维护">
		<table align="center" border="0" width="100%" class="form_table">
			<tr>	
				<td class="form_label" align="right"  width="40%">选择节点：</td>
				<td colspan="1"  width="60%">
					<h:text id="node_key" property="node_key"  readonly="true"   validateAttr="allowNull=false;"  />
					<h:hidden  id="node_value" property="workTimeBean.model_tableName" />
					<a href="#" onclick="select_node();">选择</a>	
				</td>						
			</tr>
			<tr>
				<td class="form_label" align="right"  width="40%">超时时长：</td>
				<td colspan="1" width="60%"> 
					<h:text property="workTimeBean.workTime" size="10"  validateAttr="type=double;minValue=0;allowNull=false;"   />工时
				</td>
			</tr>
			
			<tr>
				<td colspan="2" style="text-align: center">
					<input type="button" value="保存" onclick="save();"  class="button"> 
				</td>
			</tr>
		</table>
		</w:panel>
	</h:form>
	
<script type="text/javascript">	
 function select_node(){

	 strUrl ="/jbpm/xdProcessAction_toNodeSelect.action",
		showModalCenter(strUrl,'',callBackFunc ,800,500,'节点选择'); 
	 }

 function callBackFunc(args){
	 $id("node_key").value = args[0];
	 $id("node_value").value = args[1];
	 }
 
 function save(){
		var frm=$name("data_form");
		if(!checkForm(frm)){
			 return ;
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
						unMaskTop();  //若去掉这个，关掉alert框，怎么页面会变成模态，无法操作，必须重新刷新才行
					} else if (data.indexOf("fails") >= 0) {
						alert("保存失败!");
						unMaskTop();
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