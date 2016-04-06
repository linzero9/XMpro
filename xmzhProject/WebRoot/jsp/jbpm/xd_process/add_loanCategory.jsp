<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script type="text/javascript" src="/js/jquery.form.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新增 贷种分类</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/jbpm/xdProcessAction_addLoanCategory.action"  enctype="multipart/form-data" method="post" >
		<table align="center" border="0" width="100%" class="form_table">
			<h:hidden id="processName" property="xdCdtypeBean.processName"  name="xdCdtypeBean.processName"/>
			<h:hidden id="oneCategory" property="xdCdtypeBean.oneCategory"  name="xdCdtypeBean.oneCategory"/>
			
			<tr>	
				<td class="form_label" align="right" width="15%">流程名称：</td>
				<td colspan="1" width="30%">
					<b:write property="xdCdtypeBean.processName" />
				</td>						
			</tr>
			
			<tr>	
				<td class="form_label" align="right" width="15%">一级分类：</td>
				<td colspan="1" width="30%">
				<h:hidden id="oneCategoryId" />
		<b:write property="xdCdtypeBean.oneCategory" />
				</td>						
			</tr>
			
			<tr>	
				<td class="form_label" align="right" width="15%">贷种分类：</td>
				<td colspan="1" width="30%">
				<h:hidden id="loanCategoryId" />
				<h:textarea rows="5" cols="40"  id="loanCategory" property="xdCdtypeBean.loanCategory"  readonly="true"  validateAttr="allowNull=false"  extAttr="class='h80' "  />
							<a href="#" onclick="showloanCategory();">选择</a>		
				</td>						
			</tr>
			<tr>
				<td class="form_label" align="right" width="15%">时限参数：</td>
				<td colspan="1" width="30%"> <h:text property="xdCdtypeBean.limit_time"/>   </td>
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

 		var processName = $id("processName").value;
		var oneCategory = $id("oneCategory").value;
		var loanCategory = $id("loanCategory").value;
 		$.ajax({
		      url: "/jbpm/xdProcessAction_checkLoanCategory.action",
		      async: false,
		      type: 'post',
		      data: "xdCdtypeBean.processName="+processName+"&xdCdtypeBean.oneCategory="+oneCategory+"&xdCdtypeBean.loanCategory="+loanCategory,
		      timeout: 60000,
		      success: function (data) {
		       if (data.indexOf("success") >= 0) {
		    		 ajaxsubmitO(); 
				} else if (data.indexOf("success") < 0){
						alert("贷种分类("+data+")已存在！");	
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

	function showloanCategory() {
		var loanCategoryId=document.getElementById("loanCategoryId").value;
		strUrl ="/Generalprocess/tGeneralprocessCdtypeAction_loanCategoryDic.action?cdtypeJson="+loanCategoryId,
		showModalCenter(strUrl,'',showloanCategory_callback1 ,800,500,'贷种选择'); 
	} 
	function showloanCategory_callback1(args){
		if(args!=''){
		var array;
		array = args.split(":");
		 document.getElementById("loanCategoryId").value = array[0];
		 document.getElementById("loanCategory").value = array[1];
		}
	}	
</script>
</body>
</html>