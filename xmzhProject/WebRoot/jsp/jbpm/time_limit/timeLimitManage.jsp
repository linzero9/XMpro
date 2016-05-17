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
			 
			 <h:hidden property="proLoanBean.init_oneCategory_name"  id="init_oneCategory" />
			 <h:hidden property="proLoanBean.init_loanCategory_name"  id="init_loanCategory" />
			 
			 <h:hidden property="my_proLoanBean.oneCategory_name"  id="my_oneCategory" />
			 <h:hidden property="my_proLoanBean.loanCategory_name"  id="my_loanCategory" />
			 
			 <h:hidden property="proLoanBean.definitionId"  id="definitionId" />
			 
			 <h:hidden property="proTimeModelBean.c_id"  id="c_id" />
			 <h:hidden property="proTimeModelBean.time_modelName"  id="time_modelName" />
			 
			<tr>	
				<td class="form_label" align="right" width="15%">流程名称：</td>
				<td colspan="1" width="30%">
				<%-- <h:text id="processName" property="proLoanBean.processName"  readonly="true"  validateAttr="allowNull=false" /> --%>
				<b:write  property="proLoanBean.processName"  />
				</td>						
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">时限模版名称：</td>
				<td colspan="1" width="30%">
				<%-- <h:text id="time_modelName" property="proTimeModelBean.time_modelName"  readonly="true"  validateAttr="allowNull=false" /> --%>
				<b:write  property="proTimeModelBean.time_modelName"  />
				</td>						
			</tr>
			<tr  id="showInfo">	
				<td class="form_label" align="right" width="15%" >已配置的 一级/贷种关系：</td>
				<td colspan="1" width="30%" >
					<table border=0 id="tabtest2"   width="100%">
					</table>
				</td>
			</tr>
			<tr>
			<td class="form_label" align="right" width="15%" >新增 一级/贷种关系：</td>
			<td colspan="1" width="30%">
						<input type="button" onclick="addRelation('tabtest');return false;" value="新增关系" 
							style="margin-left:2px;vertical-align:middle;cursor:hand;"/>
						<br/>
						<table border=0 id="tabtest"   width="100%">
						</table>
					</td>
			</tr>			
			
			<tr>
				<td colspan="2" style="text-align: center">
				<input type="button" value="配置节点时限" onclick="save();"  class="button"> 
				<input type="button" value="返回" onclick="window.close();" class="button">
				</td>
			</tr>
		</table>
	</h:form>
<script type="text/javascript">

//页面一旦加载读取时，就初始化
var rowId2 = 0; 
$(document).ready(function(){
	var definitionId = $id("definitionId").value;
	var c_id = $id("c_id").value;

	 $.ajax({
	        url: "/jbpm/timeLimitManageAction_queryProLoanTimeLimit.action?proLoanBean.definitionId="+definitionId+"&proLoanBean.c_id="+c_id,
	        async: false,
	        type: 'post',
	        data: "",
	        dataType: 'json',
	        success: function (json) {
	        	if(json==""){
	        		$id("showInfo").style.display="none";
	        	}else {
	        		$.each(json,function(key,value){
	        			var tab,row,td,tdStr,my_oneCategorysN,my_oneCategoryM,my_loanCategorysN,my_loanCategoryM;
						var init_oneCategoryM,init_loanCategoryM;
	        		    tab = $id("tabtest2");
	        		    
	        		    my_oneCategorysN = "my_oneCategorys"+rowId2;
	        		    my_oneCategoryM = "my_oneCategory"+rowId2;
	        		    my_loanCategorysN = "my_loanCategorys"+rowId2;
	        		    my_loanCategoryM = "my_loanCategory"+rowId2;
	        		    init_oneCategoryM = "init_oneCategory"+rowId2;
	        		    init_loanCategoryM = "init_loanCategory"+rowId2;
	        			    
	        		    row =  tab.insertRow();
	        		    row.id = "my_fileRow"+rowId2;
	        		    td = row.insertCell(); 

	        			tdStr="一级分类：<select    id=\""+my_oneCategorysN+"\" onchange=\"changeoneCategory(\'"+my_oneCategorysN+"\',\'"+my_oneCategoryM+"\',\'"+my_loanCategorysN+"\',\'"+my_loanCategoryM+"\');\"     ></select>";
	        			tdStr+="  贷种分类：<select    id=\""+my_loanCategorysN+"\" onchange=\"changeloanCategory(\'"+my_loanCategorysN+"\',\'"+my_loanCategoryM+"\');\"     ></select>";
	        			tdStr+="<input  type=\"hidden\"  id=\""+my_oneCategoryM+"\" >";
	        			tdStr+="<input  type=\"hidden\"  id=\""+my_loanCategoryM+"\" >";
	        			
	        			tdStr+="<input  type=\"hidden\"  id=\""+init_oneCategoryM+"\" >";
	        			tdStr+="<input  type=\"hidden\"  id=\""+init_loanCategoryM+"\" >";
	        			tdStr += "<input type=\"button\" onclick=\"del_uptTr('my_fileRow"+rowId2+"', "+init_oneCategoryM+", "+init_loanCategoryM+" );\" name='button"+rowId2+"' value=\"删除\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
	        		    td.innerHTML = tdStr;
	        		    rowId2 = rowId2+1;   

	        		    $id(init_oneCategoryM).value =  value.oneCategory_name;
	        		    $id(init_loanCategoryM).value =  value.loanCategory_name;
	        		    
	        		    setOneSelect(my_oneCategorysN,my_oneCategoryM,my_loanCategorysN,my_loanCategoryM, value.oneCategory_name ,value.loanCategory_name); 
		        		});
	        	}
		    }
 	 });	
});

function setOneSelect(oneCategorysN,oneCategoryM,loanCategorysN,loanCategoryM,oneCategory_name,loanCategory_name){
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
		        		if(oneCategory_name != null && oneCategory_name == value.oneCategory_name ){
		        			selecthtml= selecthtml+"<option value="+value.oneCategory_name+" selected='selected' "+">"+value.oneCategory_name+"</option>";
				        }else{
		        			selecthtml= selecthtml+"<option value="+value.oneCategory_name+">"+value.oneCategory_name+"</option>";
					     }
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
	    	 setLcselect($("#"+oneCategoryM).val(), loanCategorysN, loanCategoryM, loanCategory_name);
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
				 setLcselect($("#"+oneCategoryM).val(), loanCategorysN, loanCategoryM, loanCategory_name);
		    }
}

function setLcselect(arg, loanCategorysN, loanCategoryM, loanCategory_name){
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
	        			if(loanCategory_name != null && loanCategory_name == value.loanCategory_name){
		        			selecthtml= selecthtml+"<option value="+value.loanCategory_name+" selected='selected' "+">"+value.loanCategory_name+"</option>";
				        }else{
					        selecthtml= selecthtml+"<option value="+value.loanCategory_name+">"+value.loanCategory_name+"</option>";
					     }
		        		
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
	 setLcselect($("#"+oneCategoryM).val(), loanCategorysN, loanCategoryM, null);
	}	
function changeloanCategory(loanCategorysN, loanCategoryM){
	//$("#loanCategory").val($('#loanCategorys option:selected').val());
	$("#"+loanCategoryM).val($('#'+loanCategorysN+' option:selected').val());
	}	


	var rowId = 0;  
	//新增关系 按钮功能
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
		tdStr+="  贷种分类：<select    id=\""+loanCategorysN+"\" onchange=\"changeloanCategory(\'"+loanCategorysN+"\',\'"+loanCategoryM+"\');\"     ></select>";
		tdStr+="<input  type=\"hidden\"  id=\""+oneCategoryM+"\" >";
		tdStr+="<input  type=\"hidden\"  id=\""+loanCategoryM+"\" >";
		tdStr += "<input type=\"button\" onclick=\"del_addTr('fileRow"+rowId+"');\" name='button"+rowId+"' value=\"删除\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
	    td.innerHTML = tdStr;
	    rowId = rowId+1;   

	   // setOneSelect();
	    setOneSelect(oneCategorysN,oneCategoryM,loanCategorysN,loanCategoryM, null, null); 
}

function save(){
	var oneCategoryM, loanCategorysN, loanCategoryM;
	var my_oneCategoryM, my_loanCategorysN, my_loanCategoryM, init_oneCategoryM, init_loanCategoryM;
	for (i=0; i<rowId; i++){	
		oneCategoryM = "oneCategory"+i;
		loanCategorysN = "loanCategorys"+i;
		loanCategoryM = "loanCategory"+i;
		$("#"+loanCategoryM).val($('#'+loanCategorysN+' option:selected').val());

		if($("#"+oneCategoryM).val() != undefined){//如果为undefined，说明此行被删除了

			if($id("oneCategory").value == ""){
				$("#oneCategory").val( $("#oneCategory").val()+$("#"+oneCategoryM).val() );
				$("#loanCategory").val( $("#loanCategory").val()+$("#"+loanCategoryM).val() );
			}else{
				$("#oneCategory").val( $("#oneCategory").val()+","+$("#"+oneCategoryM).val() );
				$("#loanCategory").val( $("#loanCategory").val()+","+$("#"+loanCategoryM).val() );
			}
		}
	}

	for (i=0; i<rowId2; i++){	
		my_oneCategoryM = "my_oneCategory"+i;
		my_loanCategorysN = "my_loanCategorys"+i;
		my_loanCategoryM = "my_loanCategory"+i;
		init_oneCategoryM = "init_oneCategory"+i;
		init_loanCategoryM = "init_loanCategory"+i;
		
		$("#"+my_loanCategoryM).val($('#'+my_loanCategorysN+' option:selected').val());

		if($("#"+my_oneCategoryM).val() != undefined){//如果为undefined，说明此行被删除了
			//如果 修改的一级/贷种 不等于初始值
			if(!($("#"+my_oneCategoryM).val() == $("#"+init_oneCategoryM).val() && $("#"+my_loanCategoryM).val() == $("#"+init_loanCategoryM).val()) ){
				if($id("my_oneCategory").value == ""){
					$("#my_oneCategory").val( $("#my_oneCategory").val()+$("#"+my_oneCategoryM).val() );
					$("#my_loanCategory").val( $("#my_loanCategory").val()+$("#"+my_loanCategoryM).val() );
				}else{
					$("#my_oneCategory").val( $("#my_oneCategory").val()+","+$("#"+my_oneCategoryM).val() );
					$("#my_loanCategory").val( $("#my_loanCategory").val()+","+$("#"+my_loanCategoryM).val() );
				}
	
				if($id("init_oneCategory").value == ""){
					$("#init_oneCategory").val( $("#init_oneCategory").val()+$("#"+init_oneCategoryM).val() );
					$("#init_loanCategory").val( $("#init_loanCategory").val()+$("#"+init_loanCategoryM).val() );
				}else{
					$("#init_oneCategory").val( $("#init_oneCategory").val()+","+$("#"+init_oneCategoryM).val() );
					$("#init_loanCategory").val( $("#init_loanCategory").val()+","+$("#"+init_loanCategoryM).val() );
				}
			}
		}
		
	}
	
	var frm=$name("data_form");
		if(!checkForm(frm)){
		 return ;
	 }
		 
	if($id("showInfo").style.display == "none" ){ //说明之前未配置过,故需校验新增不能为空

		if($id("oneCategory").value == ""){
			alert("新增 一级分类不能为空");
			return false;
		}
		if($id("loanCategory").value == ""){
			alert("新增 贷种分类不能为空");
			return false;
		}	 
	}
	
	//ajaxsubmitO();
	var definitionId = $id("definitionId").value;
	var c_id = $id("c_id").value;
	var add_oneCategory = $id("oneCategory").value;
	var add_loanCategory = $id("loanCategory").value;
	
	var upt_oneCategory = $id("my_oneCategory").value;
	var upt_loanCategory = $id("my_loanCategory").value;

	var init_oneCategory = $id("init_oneCategory").value;
	var init_loanCategory = $id("init_loanCategory").value;

	$.ajax({
	      url: "/jbpm/timeLimitManageAction_saveTimeLimitManage.action",
	      async: false,
	      type: 'post',
	      data: "proLoanBean.definitionId="+definitionId+"&proLoanBean.c_id="+c_id+"&proLoanBean.oneCategory_name="+add_oneCategory+"&proLoanBean.loanCategory_name="+add_loanCategory+"&my_proLoanBean.oneCategory_name="+upt_oneCategory+"&my_proLoanBean.loanCategory_name="+upt_loanCategory+"&proLoanBean.init_oneCategory_name="+init_oneCategory+"&proLoanBean.init_loanCategory_name="+init_loanCategory,
	      timeout: 60000,
	      dataType:"text",
	      success: function (data) {
	    	  if (data.indexOf("success") >= 0) {
	    		  //alert("保存成功");
					queryNodeTimeLimitList();
	    		  //window.close();
			}else if (data.indexOf("新增") >= 0 || data.indexOf("修改") >= 0) {
	    		  alert(data);
	    		  window.close();
	    		  //queryNodeTimeLimitList();
	    		 
	    		  /* $id("oneCategory").value = "";
	    		  $id("loanCategory").value = "";
	    		  $id("my_oneCategory").value = "";
	    		  $id("my_loanCategory").value = ""; */
			} else if (data.indexOf("fails") >= 0) {
				alert("保存失败!");
				window.close();
			} else {
				alert("操作失败!");
				window.close();
			}
					  	
	      }
	}); 
 
}

function queryNodeTimeLimitList(){
	var definitionId = $id("definitionId").value;
	var c_id = $id("c_id").value;
	var time_modelName = $id("time_modelName").value;
	
	var strUrl ="/jbpm/timeLimitManageAction_queryNodeTimeLimitList.action?proTimeModelBean.definitionId="+definitionId+"&proTimeModelBean.c_id="+c_id+"&proTimeModelBean.time_modelName="+time_modelName;
	showModalCenter(encodeURI(strUrl),null,callBackFunc ,800,500,'配置节点时限'); 
}

function callBackFunc(){
    window.close();
}

function del_addTr(id){
	$("#"+id).remove(); //JSP页面移除一行
}

function del_uptTr(id, init_oneCategoryM, init_loanCategoryM){
	$("#"+id).remove(); //JSP页面移除一行
	
	var definitionId = $id("definitionId").value;
	var c_id = $id("c_id").value;
	$.ajax({
	      url: "/jbpm/timeLimitManageAction_deleteTimeLimitManage.action",
	      async: false,
	      type: 'post',
	      data: "proLoanBean.definitionId="+definitionId+"&proLoanBean.c_id="+c_id+"&proLoanBean.init_oneCategory_name="+$id(init_oneCategoryM).value+"&proLoanBean.init_loanCategory_name="+$id(init_loanCategoryM).value,
	      timeout: 60000,
	      dataType:"text",
	      success: function (data) {
	    	  if (data.indexOf("success") >= 0) {
	    		  alert("删除成功");
	    		  //window.close();
			}else if (data.indexOf("fails") >= 0) {
				alert("删除失败!");
				window.close();
			} else {
				alert("操作失败!");
				window.close();
			}
					  	
	      }
	}); 
}


</script>
</body>
</html>