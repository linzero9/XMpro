<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script type="text/javascript" src="/js/jquery.form.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改属性名称</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/dict/eosDictEntryAction_updateItem.action"  enctype="multipart/form-data" method="post" >
		<table align="center" border="0" width="100%" class="form_table">
			<h:hidden id="dictTypeId" property="dictType.dictTypeId"  name="dictType.dictTypeId"/>		
			<tr>	
				<td class="form_label" align="right" width="15%">属性名称：</td>
				<td colspan="1" width="30%"><h:text id="dictTypeName"
						property="dictType.dictTypeName"  validateAttr="allowNull=false" /></td>						
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
						refreshCache();//数据字典刷新缓存
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

	//数据字典刷新缓存
	function refreshCache(){
		//调用逻辑流
    	var myAjax = new Ajax("/reloadEosDict.flow");
    	//开始调用
    	myAjax.submit();
    	//取得调用后的结果(xml对象)
    	var returnNode =myAjax.getResponseXMLDom();
    	if(returnNode)
    	{
    		//获取指定的节点值
    		reCode = myAjax.getValue("/root/data/reCode");
    	}
    	if(reCode == 1)
    	{
    		alert("刷新缓存成功");//刷新业务字典信息成功。
    	}else{
    		alert("刷新缓存失败");//刷新业务字典信息失败。
    	}
	}
</script>
</body>
</html>