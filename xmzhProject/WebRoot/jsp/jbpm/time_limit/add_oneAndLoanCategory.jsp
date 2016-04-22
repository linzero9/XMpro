<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>

<h:css href="/css/style1/style-custom.css" />
<script type="text/javascript" src="/js/jquery.form.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新增一级/贷种分类对应关系</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/jbpm/timeLimitManageAction_addOneAndLoan.action"  enctype="multipart/form-data" method="post" >
		<table align="center" border="0" width="100%" class="form_table">
			
			<tr>	
				<td class="form_label" align="right" width="15%">一级分类：</td>
				<td colspan="1" width="30%">
				<h:hidden id="oneCategoryId" property="oneAndLoanBean.oneCategory_id" />
				<h:text id="oneCategory" property="oneAndLoanBean.oneCategory_name"  readonly="true"  validateAttr="allowNull=false" />
							<a href="#" onclick="showoneCategory();">选择</a>		
				</td>						
			</tr>
			
			<tr>	
				<td class="form_label" align="right" width="15%">贷种分类：</td>
				<td colspan="1" width="30%">
				<h:hidden id="loanCategoryId"  property="oneAndLoanBean.loanCategory_id"  />
				<h:textarea rows="5" cols="40"  id="loanCategory" property="oneAndLoanBean.loanCategory_name"  readonly="true"  extAttr="class='h80' "  validateAttr="allowNull=false" />
							<a href="#" onclick="showloanCategory();">选择</a>		
				</td>						
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

 		var oneCategory_name= $id("oneCategory").value;
		var loanCategory_name = $id("loanCategory").value;
		
 		$.ajax({
		      url: "/jbpm/timeLimitManageAction_checkOneAndLoan.action",
		      async: false,
		      type: 'post',
		      data: "oneAndLoanBean.oneCategory_name="+oneCategory_name+"&oneAndLoanBean.loanCategory_name="+loanCategory_name,
		      timeout: 60000,
		      success: function (data) {
		       if (data.indexOf("success") >= 0) {
		    		  ajaxsubmitO(); 
				}else if (data.indexOf("success") < 0){
					alert("操作失败！该一级分类与贷种分类("+data+")的对应关系已存在！请重新选择！");	
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

	//自己定义 一级分类 数据字典 单选按钮显示页面
	function showoneCategory() {
		var oneCategoryId=document.getElementById("oneCategoryId").value;
		strUrl ="/jbpm/xdProcessAction_oneCategoryDic.action?cdtypeJson="+oneCategoryId,
		showModalCenter(strUrl,'',showoneCategory_callback1 ,800,430,'一级分类选择'); 
	} 
	function showoneCategory_callback1(args){
		if(args!=''){
		var array;
		array = args.split(":");
		 document.getElementById("oneCategoryId").value = array[0];
		 document.getElementById("oneCategory").value = array[1];
		}
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