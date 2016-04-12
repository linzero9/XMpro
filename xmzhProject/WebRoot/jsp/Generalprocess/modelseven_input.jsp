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
<script type="text/javascript" src="/js/modeFileDown.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>
<title>出具支用审批意见</title>
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
        
        <h:hidden id="processModelId" name="modelSeven.processModelId" property="modelSeven.processModelId"/>
		<h:hidden id="taskName" name="modelSeven.taskName" property="modelSeven.taskName"/>
		
		<h:hidden id="beginAssingee" name="taskAssgineeDto.beginAssingee" property="taskAssgineeDto.beginAssingee"/>
		<h:hidden id="beginOrg" name="taskAssgineeDto.beginOrg" property="taskAssgineeDto.beginOrg"/>

		<h:hidden id="btnType" name="taskAssgineeDto.btnType" property="taskAssgineeDto.btnType"/>
		<table align="center" border="0" width="100%" class="form_table" >
       <tr>
         <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:50px;background-color: rgb(145, 186, 221);" >
        		 ${taskName}
        </td>
      </tr>
      <tr>
     	<td class="form_label" align="right" style="width:10%;">审批意见</td>
     	<td colspan="3">
	     	<d:select id="handleOpn" property="modelSeven.handleOpn" dictTypeId="PROCESS_opn"  nullLabel="请选择"></d:select>
     	</td>
      </tr>
      
       <tr>
     	<td class="form_label" align="right" style="width:20%;" >审批币别</td>
      	<td colspan="1" style="width:30%">
        	<d:select id="spBb" property="modelSeven.spBb" dictTypeId="PROCESS_MONEY"  nullLabel="请选择"></d:select>
      	</td>
     	<td class="form_label" align="right" style="width:20%;">审批金额</td>
     	<td colspan="1" style="width:30%">
        	<h:text id="spJe" property="modelSeven.spJe"/>元
        </td>
              <tr id="row1">
        <td class="form_label" align="right">附件下载：</td>
        <td colspan="3">
        <div id="tag"></div>
      </td>
      </tr>
           <tr id="fujian">
     	<td class="form_label" align="right">附件：</td>
     	<td colspan="3">
				<input type="button" onclick="addFile('tabtest','files');return false;" value="新增附件" 
					style="margin-left:2px;vertical-align:middle;cursor:hand;"/>
				<font style="color: red">(说明：最多上传5个附件)</font>
				<br/>
				<table border=0 id="tabtest">
				</table>
     	</td>
     </tr>
        
        
      </tr>
      <tr>
					<td class="form_label" align="right">处理意见</td>
					<td colspan="3"><h:textarea
							property="modelSeven.optionNews" id="hanldOption"
							extAttr="class='h80' "
							validateAttr="maxLength=512;allowNull=ture" rows="4"
							style="width:90%;" /></td>
				</tr>
    <%@include file="/jsp/util/default_gp_opinionUtil.jsp" %>
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

				if('${modelSeven.processModelId}'!=""){
					
					 $.ajax({
					        url: '/modeFile/tModelFileAction_selectFiletest.action',
					        async: false,
					        type: 'post',
					        data: "executionId=${taskAssgineeDto.executionId}&modeId=${modelSeven.processModelId}&modeType=mod7",
					        dataType: 'json',
					        timeout: 60000,
					        success: function (files) {
						        if(files!=""){
						         	$.each(files,function( i,item ){
							         	if('${isView}'!='')
						    	        	$("#tag").fileDown({filename:item.fileName,filevalue:item.fileId});
							         	else 
							         		$("#tag").fileDown({filename:item.fileName,filevalue:item.fileId,remove:1});
						          		});	
						        } else{    
						        	$("#row1").css("display","none");  
						        } 
					        }
				 });
				}
			 //查看详情界面
			if('${isView}'!=''){
					$("#save3").hide();
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
    			strUrl+="&taskAssgineeDto.beginOrg="+$id("beginOrg").value+"&taskAssgineeDto.beginAssingee="+$id("beginAssingee").value
    			showModalCenter(strUrl, null, taskAssigneeCallBack, 700, 400, '节点选择');
    			}
    		}
     	}

		 	function taskAssigneeCallBack(arg){
		  	 	var _form = $id("form1");
		  	 	if(arg!=""){
		  	  	 	url="/Generalprocess/tGeneralprocessModelSevenAction_handleModelSeven.action?"+arg;	
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
		  					  		//reload();
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
		  		function addFile(tabid,varName){
		  		    var tab,row,td,fName,fId,tdStr;
		  		    var zs=$("#tabtest tbody tr").length;
		  		    tab = $id(tabid);
		  		    if (zs>=5){
		  		    	alert("新增附件不能超过5个");
		  		    	return false;
		  		    }
		  		    fName = varName;
		  		    fId = varName+rowId;
		  		    row =  tab.insertRow();
		  		    row.id = "fileRow"+rowId;
		  		    td = row.insertCell(); 
		  		    
		  		    tdStr="<input type=\"file\" name=\""+fName+"\" id=\""+fId+"\" onchange=\"CheckUpLoadFile(this,2);\" size='70' class=smallInput validateAttr=\"allowNull=false\">";
		  		    tdStr += "<input type=\"button\" onclick=\"delTr('fileRow"+rowId+"');\" name='button"+rowId+"' value=\"删除\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
		  		    td.innerHTML = tdStr;
		  		    rowId = rowId+1;    
		  		}
		  		
		  		function delTr(id){
		  			$("#"+id).remove();
		  		}
 </script>
</html>