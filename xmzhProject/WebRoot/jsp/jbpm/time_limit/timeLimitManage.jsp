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
<h:form name="data_form"  id="data_form" action="/jbpm/timeLimitManageAction_saveTimeLimitManage.action"  enctype="multipart/form-data" method="post" >
		<table align="center" border="0" width="100%" class="form_table">
			 <h:hidden property="proLoanBean.oneCategory_name"  id="oneCategory" />
			 <h:hidden property="proLoanBean.loanCategory_name"  id="loanCategory" />
			 <h:hidden property="proLoanBean.definitionId"  id="definitionId" />
			 <h:hidden property="proLoanBean.c_id"  id="c_id" />
			 
			<tr>	
				<td class="form_label" align="right" width="15%">流程名称：</td>
				<td colspan="1" width="30%">
				<h:text id="processName" property="proLoanBean.processName"  readonly="true"  validateAttr="allowNull=false" />
				</td>						
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">一级/贷种分类：</td>
				<td colspan="1" width="30%">
					<input type="button" onclick="addRelation('tabtest');return false;" value="新增关系" 
						style="margin-left:2px;vertical-align:middle;cursor:hand;"/>
					<br/>
					<table border=0 id="tabtest"   width="100%">
					</table>
				</td>						
			</tr>
			
			<%-- <tr>	
				<td class="form_label" align="right" width="15%">test：</td>
				<td colspan="1" width="30%">
					 一级分类：
					 <select    id="oneCategorys" onchange="changeoneCategory('oneCategorys', 'oneCategory')"     >
         </select> 
         <h:hidden property="proLoanBean.oneCategory_name"  id="oneCategory" />
         <font style="color: red">*</font>	
         
         贷种分类：
         <select    id="loanCategorys" onchange="changeloanCategory('loanCategorys', 'loanCategory')" >
         </select> 
         <h:hidden property="proLoanBean.loanCategory_name"  id="loanCategory" />
         <font style="color: red">*</font>	
				</td>						
			</tr> --%>
			
			<tr>
				<td colspan="2" style="text-align: center"><input type="button" value="配置节点时限"
					onclick="save();"  class="button"> <input type="button" value="关闭"
					onclick="window.close();" class="button"></td>
			</tr>
		</table>
	</h:form>
<script type="text/javascript">

//页面一旦加载读取时，就初始化
/* $(document).ready(function(){
	// setOneSelect();
	setOneSelect("oneCategorys","oneCategory");
}); */

function setOneSelect(oneCategorysN,oneCategoryM,loanCategorysN,loanCategoryM){
	//$("#oneCategorys").html("");
	$("#"+oneCategorysN).html("");
	//var selecthtml=$("#oneCategorys").html();
	var selecthtml=$("#"+oneCategorysN).html();

	 $.ajax({
	        url: "/jbpm/timeLimitManageAction_queryOneCategorylist.action",
	        async: false,
	        type: 'post',
	        data: "",
	        dataType: 'json',
	        success: function (json) {
	        	if(json==""){
	        	}else {
	        		$.each(json,function(key,value){
		        		selecthtml= selecthtml+"<option value="+value.oneCategory_name+">"+value.oneCategory_name+"</option>";
		        		});
	        	}
		        }
    });	
	    $("#"+oneCategorysN).html(selecthtml);
	  //if($id("oneCategory").value==''){
	  if($id(oneCategoryM).value==''){
	      //$("#oneCategory").val($(oneSelectId+' option:selected').val());
	    	$("#"+oneCategoryM).val($('#'+oneCategorysN+' option:selected').val());
	    	// setLcselect($("#oneCategory").val());
	    	 setLcselect($("#"+oneCategoryM).val(), loanCategorysN, loanCategoryM);
		    }else{
		    	var all_options = document.getElementById(oneCategorysN).options;
				for (i=0; i<all_options.length; i++){
			   //if (all_options[i].value ==$id("oneCategory").value ) // 根据option标签的ID来进行判断 测试的代码这里是两个等号
			   if (all_options[i].value ==$id(oneCategoryM).value ) // 根据option标签的ID来进行判断 测试的代码这里是两个等号
					{
						all_options[i].selected = true;
					}
				}
				//$("#oneCategory").val($('#oneCategorys option:selected').val());
				$("#"+oneCategoryM).val($('#'+oneCategorysN+' option:selected').val());
				// setLcselect($("#oneCategory").val());
				 setLcselect($("#"+oneCategoryM).val(), loanCategorysN, loanCategoryM);
		    }
}

function setLcselect(arg, loanCategorysN, loanCategoryM){
	//$("#loanCategorys").html("");
	$("#"+loanCategorysN).html("");
	//var selecthtml=$("#loanCategorys").html();
	var selecthtml=$("#"+loanCategorysN).html();
	 $.ajax({
	        url: "/jbpm/timeLimitManageAction_queryLoanCategorylist.action?proLoanBean.oneCategory_name="+encodeURI(arg),
	        async: false,
	        type: 'post',
	        data: "",
	        dataType: 'json',
	        success: function (json) {
	        	if(json==""){
	        	}else {
	        		$.each(json,function(key,value){
		        		selecthtml= selecthtml+"<option value="+value.loanCategory_name+">"+value.loanCategory_name+"</option>";
		        		});
	        	}
		        }
    });	
	 //   $("#loanCategorys").html(selecthtml);
	  $("#"+loanCategorysN).html(selecthtml);
	//    if($id("loanCategory").value==''){
	  if($id(loanCategoryM).value==''){
	  //  	$("#loanCategory").val($('#loanCategorys option:selected').val());
		 $("#"+loanCategoryM).val($('#'+loanCategorysN+' option:selected').val());
		    }else{
		    //	var all_options = document.getElementById("loanCategorys").options;
		    var all_options = document.getElementById(loanCategorysN).options;
				for (i=0; i<all_options.length; i++){
				//	if (all_options[i].value ==$id("loanCategory").value ) // 根据option标签的ID来进行判断 测试的代码这里是两个等号
					if (all_options[i].value ==$id(loanCategoryM).value ) // 根据option标签的ID来进行判断 测试的代码这里是两个等号
					{
						all_options[i].selected = true;
					}
				}
		    }
}

function changeoneCategory(oneCategorysN, oneCategoryM, loanCategorysN, loanCategoryM){
//$("#oneCategory").val($('#oneCategorys option:selected').val());
	$("#"+oneCategoryM).val($('#'+oneCategorysN+' option:selected').val());
//setLcselect($("#oneCategory").val());
	 setLcselect($("#"+oneCategoryM).val(), loanCategorysN, loanCategoryM);
	}	
function changeloanCategory(loanCategorysN, loanCategoryM){
	//$("#loanCategory").val($('#loanCategorys option:selected').val());
	$("#"+loanCategoryM).val($('#'+loanCategorysN+' option:selected').val());
	}	

	var rowId = 0;  
function addRelation(tabid){
	 var tab,row,td,tdStr,oneCategorysN,oneCategoryM,loanCategorysN,loanCategoryM;
	    var zs=$("#tabtest tbody tr").length;
	    tab = $id(tabid);
	/*    if (zs>=5){
	    	alert("不能超过5个");
	    	return false;
	    } */
	   
	    oneCategorysN = "oneCategorys"+rowId;
	    oneCategoryM = "oneCategory"+rowId;
	    loanCategorysN = "loanCategorys"+rowId;
	    loanCategoryM = "loanCategory"+rowId;
		    
	    row =  tab.insertRow();
	    row.id = "fileRow"+rowId;
	    td = row.insertCell(); 

		tdStr="一级分类：<select    id=\""+oneCategorysN+"\" onchange=\"changeoneCategory(\'"+oneCategorysN+"\',\'"+oneCategoryM+"\',\'"+loanCategorysN+"\',\'"+loanCategoryM+"\');\"     ></select>";
		tdStr+="贷种分类：<select    id=\""+loanCategorysN+"\" onchange=\"changeloanCategory(\'"+loanCategorysN+"\',\'"+loanCategoryM+"\');\"     ></select><br>";
		tdStr+="<input  type=\"text\"  id=\""+oneCategoryM+"\" >";
		tdStr+="<input  type=\"text\"  id=\""+loanCategoryM+"\" >";
		//  tdStr="<input type=\"file\" name=\""+fName+"\" id=\""+fId+"\" onchange=\"CheckUpLoadFile(this,2);\" size='70' class=smallInput validateAttr=\"allowNull=false\">";
		//   tdStr += "<input type=\"button\" onclick=\"delTr('fileRow"+rowId+"');\" name='button"+rowId+"' value=\"删除\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
	    td.innerHTML = tdStr;
	    rowId = rowId+1;   

	   // setOneSelect();
	    setOneSelect(oneCategorysN,oneCategoryM,loanCategorysN,loanCategoryM); 
}

function save(){
	var oneCategoryM, loanCategorysN, loanCategoryM;
	for (i=0; i<rowId; i++){	
		oneCategoryM = "oneCategory"+i
		loanCategorysN = "loanCategorys"+i;
		loanCategoryM = "loanCategory"+i;
		$("#"+loanCategoryM).val($('#'+loanCategorysN+' option:selected').val());

		if($id("oneCategory").value == ""){
			$("#oneCategory").val( $("#oneCategory").val()+$("#"+oneCategoryM).val() );
			$("#loanCategory").val( $("#loanCategory").val()+$("#"+loanCategoryM).val() );
		}else{
			$("#oneCategory").val( $("#oneCategory").val()+","+$("#"+oneCategoryM).val() );
			$("#loanCategory").val( $("#loanCategory").val()+","+$("#"+loanCategoryM).val() );
		}
		
	}
	
	var frm=$name("data_form");
		if(!checkForm(frm)){
		 return ;
	 }
	if($id("oneCategory").value == ""){
		alert("一级分类不能为空");
		return false;
	}
	if($id("loanCategory").value == ""){
		alert("贷种分类不能为空");
		return false;
	}	 
	//ajaxsubmitO();
	var definitionId = $id("definitionId").value;
	var processName = $id("processName").value;
	var oneCategory_name = $id("oneCategory").value;
	var loanCategory_name = $id("loanCategory").value;

	$.ajax({
	      url: "/jbpm/timeLimitManageAction_saveTimeLimitManage.action",
	      async: false,
	      type: 'post',
	      data: "proLoanBean.definitionId="+definitionId+"&proLoanBean.processName="+processName+"&proLoanBean.oneCategory_name="+oneCategory_name+"&proLoanBean.loanCategory_name="+loanCategory_name,
	      timeout: 60000,
	      dataType:"text",
	      success: function (data) {
	    	  var arr = data.split(",");
	    	  if (arr[0].indexOf("success") >= 0) {
	    		  alert("保存成功");
	    		  $id("c_id").value = arr[1];
					queryNodeTimeLimitList();
	    		  //window.close();
			} else if (arr[0].indexOf("fails") >= 0) {
				alert("保存失败!");
			} else {
				alert("操作失败!");
			}
					  	
	      }
	}); 
 
}

function queryNodeTimeLimitList(){
	var definitionId = $id("definitionId").value;
	var c_id = $id("c_id").value;
	var strUrl ="/jbpm/timeLimitManageAction_queryNodeTimeLimitList.action?proLoanBean.definitionId="+definitionId+"&proLoanBean.c_id="+c_id;
	showModalCenter(strUrl,null,callBackFunc ,800,500,'配置节点时限'); 
}

function callBackFunc(){
    window.close();
}

/* function ajaxsubmitO() {
	maskTop();
	var options = {
		type : "post",
		cache : "false",
		success : function(data) {
			try {
				var arr = data.split(",");
				alert(arr[0]);
				alert(arr[1]);
				if (arr[0].indexOf("success") >= 0) {
					alert("保存成功!");
					unMaskTop();
					//window.close();
					
					 $id("c_id").value = arr[1];
					queryNodeTimeLimitList();
				} else if (arr[0].indexOf("fails") >= 0) {
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
		}
	};
	
	$("#data_form").ajaxSubmit(options);
} */


</script>
</body>
</html>