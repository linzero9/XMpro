<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<%@page import="java.util.*"%>
<h:css href="/css/style1/style-custom.css"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/fileDown.css">
<script type="text/javascript" src="/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript" src="/js/fileDown.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>
</head>
  <body>
  <div id='showdiv'>
    	</div>	
    <h:form name="form1" id="form1" action="" method="post" enctype="multipart/form-data" onsubmit="return checkForm(this);">
        
        <h:hidden id="businessKey" name="taskAssgineeDto.businessKey" property="taskAssgineeDto.businessKey"/>
        <h:hidden id="nextTaskId" name="taskAssgineeDto.nextTaskId" property="taskAssgineeDto.nextTaskId"/>
        <h:hidden id="executionId" name="taskAssgineeDto.executionId" property="taskAssgineeDto.executionId"/>
        <h:hidden id="businessType" name="taskAssgineeDto.businessType" property="taskAssgineeDto.businessType"/>
        <h:hidden id="taskAssingee" name="taskAssgineeDto.taskAssingee" property="taskAssgineeDto.taskAssingee"/>
        <h:hidden id="processTaskAssigneeId" name="taskAssgineeDto.processTaskAssigneeId" property="taskAssgineeDto.processTaskAssigneeId"/>
        <h:hidden id="parentId" name="taskAssgineeDto.parentId" property="taskAssgineeDto.parentId"/>
        <h:hidden id="isChild" name="taskAssgineeDto.isChild" property="taskAssgineeDto.isChild"/>
        <h:hidden id="preTaskAssingee" name="taskAssgineeDto.preTaskAssingee" property="taskAssgineeDto.preTaskAssingee"/>
        <h:hidden id="definitionId" name="taskAssgineeDto.definitionId" property="taskAssgineeDto.definitionId"/>
        
        <h:hidden id="processModelId" name="modelFour.processModelId" property="modelFour.processModelId"/>
		<h:hidden id="taskName" name="modelFour.taskName" property="modelFour.taskName"/>
		
		<table align="center" border="0" width="100%" class="form_table" >
       <tr>
         <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:50px" >
        		 ${taskName}
        </td>
      </tr>
      <tr>
     	<td class="form_label" align="right" style="width:10%;">处理意见：</td>
     	<td colspan="3">
	     	<h:textarea  extAttr="class='h80' "  name="modelFour.opninionContent" property="modelFour.opninionContent"  id="opninionContent" validateAttr="maxLength=512;allowNull=false" rows="4"  style="width:90%;" />
		    <font style="color: red">*</font>
     	</td>
      </tr>
      <tr id="row1">
      	<td class="form_label" align="right">差错情况：</td>
     	<td colspan="3">
      	<table border=0 id="ccTable">
		</table>
      	</td>
      </tr>
      <tr id="rowFile">
     	<td class="form_label" align="right">差错情况：</td>
     	<td colspan="3">
				<input type="button" onclick="addMisTake('tabtest','files','jees');return false;" value="新增差错" 
					style="margin-left:2px;vertical-align:middle;cursor:hand;"/>
				<br/>
				<table border=0 id="tabtest">
				</table>
     	</td>
     </tr>
    
      <tr class="form_bottom">
        <td colspan="4">
          <input type="button" value="提交" onclick="doSave(2);" class="button" id="save3" />
          <input type="button" value="查看流程" onclick="doflowpic();" class="button" id="flowpic" />
         </td>
      </tr>
     <tr id="row2">
     <td class="form_label" align="right">流 程 列 表：</td>
     <td colspan="3">
     <%@include file="/jsp/util/opinionUtil_generalProcess.jsp"%>
	</td>
     </tr>
    </table>
    </h:form>
    		
  </body>
 <script type="text/javascript">
 		 show('${taskAssgineeDto.fxJson}');

		 $(document).ready(function(){
			
			 //查看详情界面
			 if('${isView}'!=''){
					$("#save3").hide();
					$("#rowFile").hide();
					$("#opninionContent").attr("readonly",true);
			 }else{
				 $("#row1").css("display","none");  
			 }
			 
			 if('${modelFour.processModelId}'!=""){
				 var tab,row,td,tdStr,rowId,fId,jeId
		         var tab = $id("ccTable");
				 var tab1 = $id("tabtest");
				 var fName = "files";
				 var jeName = "jees";
				 $.ajax({
				        url: '/Generalprocess/tGeneralprocessModelFourAction_queryFourMistake.action',
				        async: false,
				        type: 'post',
				        data: "modelFour.processModelId=${modelFour.processModelId}",
				        dataType: 'json',
				        timeout: 60000,
				        success: function (files) {
					        if(files!=""){
					        	$.each(files,function( i,item ){
					        		 
									 fId = fName+rowId;
									 jeId= jeName+"je"+rowId;
					         		 if('${isView}'!=''){
					         			row =  tab.insertRow();
										row.id = "fileRow"+rowId;
										td = row.insertCell();
					         			tdStr="差错内容：<input type=\"text\" value=\""+item.mistakeContent+"\" size='70' validateAttr=\"allowNull=false\" readonly=\"true\" >";
									 	tdStr+="扣罚金额：<input type=\"text\" value=\""+item.punishBal+"\" size='10' validateAttr=\"allowNull=false\" readonly=\"true\">";
									 	tdStr+="添加时间：<input type=\"text\" value=\""+item.addTime+"\" size='10' validateAttr=\"allowNull=false\" readonly=\"true\">";
									 	td.innerHTML = tdStr;
										 rowId = rowId+1; 
					         		 }else{
										row =  tab1.insertRow();
										row.id = "fileRow"+rowId;
										td = row.insertCell();
					         			tdStr="差错内容：<input type=\"text\" name=\""+fName+"\" id=\""+fId+"\" value=\""+item.mistakeContent+"\" size='70' validateAttr=\"allowNull=false\" readonly=\"true\">";
									 	tdStr+="扣罚金额：<input type=\"text\" name=\""+jeName+"\" id=\""+jeId+"\" value=\""+item.punishBal+"\" size='10' validateAttr=\"allowNull=false\" readonly=\"true\" >";
									 	//tdStr+= "<input type=\"button\" onclick=\"delTr('fileRow"+rowId+"');\" name='button"+rowId+"' value=\"删除\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
									 	td.innerHTML = tdStr;
										rowId = rowId+1; 
					         		 }
					        	});
					          	
					        }else{
					        	 $("#row1").css("display","none");  
					        }    
				        }
			    });
			 }
		});
		
		function initPlanCell20(){
				var queryCond="";
				queryCond += "<flowId>${taskAssgineeDto.executionId}</flowId>";
					return queryCond;
		}

		function doSave(value){   		
    		$("#btnType").val(value);
    		if(value!="1"){
    			//提交
    			if(checkForm($id("form1"))){
    				var strUrl = "/jbpm/jbpmDemoAction_toNextTaskConfig.action?taskAssgineeDto.executionId="+$id("executionId").value+"&taskAssgineeDto.definitionId=${taskAssgineeDto.definitionId}";
            		showModalCenter(strUrl, null, taskAssigneeCallBack, 700, 400, '节点选择');
        			}
    		}
     	}
		function taskAssigneeCallBack(arg){
		  	 	var _form = $id("form1");
		  	 	if(arg!=""){
		  	  	 	url="/Generalprocess/tGeneralprocessModelFourAction_handleModelFour.action?"+arg;	
		  	  	    _form.action =url
		  	        // 异步提交请求 
		  	  	    ajaxsubmitO();
		  	 	}
		}
		  	  	function ajaxsubmitO(){
					maskTop();
		  	  	 var options = {
		  		  		type : "post",
		  		  		cache : "false",
		  			  	success : function(data){
		  					try {  
		  					  	if(data.indexOf("success")>=0){
		      					  	alert("操作成功!");
			 					  	unMaskTop();
		      					  WEB.turnMainFrame();
		  					  	}else if(data.indexOf("fails")>=0){
		      					  	alert("操作失败!");
			 					  	unMaskTop();
		  					  	}else if(data.indexOf("noFirst")>=0){
		      					  	alert("该节点不能用于发起流程!");
			 					  	unMaskTop();
		  					  	}else{	 
		  					  	    alert("操作失败!"); 
			 					  	unMaskTop();	
		  					  	}
		  	   				} catch (Exception) {  
		  					}  
		  				},  
		  			  	error : function(data){
		  				  alert("添加失败请联系管理员！");
						  	unMaskTop();
		  			   	}  
		  			}; 
		  	  	$("#form1").ajaxSubmit(options);
		  	  	}
		 var rowId = 0;  	
		 function addMisTake(tabid,varName,varJeName){
			 var tab,row,td,fName,jeName,fId,jeId,tdStr;
			 var zs=$("#tabtest tbody tr").length;
			 tab = $id(tabid); 
			 fName = varName;
			 jeName = varJeName;
			 fId = varName+rowId;
			 jeId= varName+"je"+rowId;
			 row =  tab.insertRow();
			 row.id = "fileRow"+rowId;
			 td = row.insertCell(); 
			 	tdStr="差错内容：<input type=\"text\" name=\""+fName+"\" id=\""+fId+"\" size='70' validateAttr=\"allowNull=false\">";
			 	tdStr+="扣罚金额：<input type=\"text\" name=\""+jeName+"\" id=\""+jeId+"\" size='10' validateAttr=\"allowNull=false\">";
			    tdStr+= "<input type=\"button\" onclick=\"delTr('fileRow"+rowId+"');\" name='button"+rowId+"' value=\"删除\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
			    td.innerHTML = tdStr;
			    rowId = rowId+1;    
		 }
		 
		 function delTr(id){
			$("#"+id).remove();
		}
				
 </script>
</html>