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
		
		<h:hidden id="beginAssingee" name="taskAssgineeDto.beginAssingee" property="taskAssgineeDto.beginAssingee"/>
		<h:hidden id="beginOrg" name="taskAssgineeDto.beginOrg" property="taskAssgineeDto.beginOrg"/>
		
		<table align="center" border="0" width="100%" class="form_table" >
       <tr>
         <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:50px;background-color: rgb(145, 186, 221);" >
        		 ${taskName}
        </td>
      </tr>
      
       <tr>
     	<td class="form_label" align="right" style="width:20%;" >是否电话核实</td>
      	<td colspan="1" style="width:30%">
        	<d:select id="dhhs" dictTypeId="ABF_PHONECHECK" property="modelFour.dhhs"   nullLabel="请选择"></d:select>
      	</td>
     
       <td class="form_label" align="right" style="width:120px;">
                                                   终审币别：
        </td>
					<td colspan="1">
						<d:select  id="zscurrency"  dictTypeId="PROCESS_MONEY" property="modelFour.zscurrency"></d:select>    <font style="color: red">*</font>	
					</td>
					
					
      </tr>
    
      <tr>
      <td class="form_label" align="right" style="width:120px;">
                                                 终审金额：
        </td>
        <td colspan="1">
         <h:text property="modelFour.zsmoney" id="zsje"  style="width:130px;" />万元<font id="decimal" style="color: red" style=display:none>最多保留小数点后两位 </font>	
        </td>
      </tr>
      <tr>
     	<td class="form_label" align="right" style="width:10%;">处理意见：</td>
     	<td colspan="3">
	     	<h:textarea  extAttr="class='h80' "  name="modelFour.opninionContent" property="modelFour.opninionContent"  id="hanldOption" validateAttr="maxLength=512;" rows="4"  style="width:90%;" />
		 
     	</td>
    
       <tr id="row2">
        <td class="form_label" align="right">附件下载：</td>
        <td colspan="3">
        <div id="tag"></div>
      </td>
      </tr>
           <tr id="fujian">
     	<td class="form_label" align="right">附件：</td>
     	<td colspan="3">
				<input type="button" onclick="addFile('tabtest2','files2');return false;" value="新增附件" 
					style="margin-left:2px;vertical-align:middle;cursor:hand;"/>
				<font style="color: red">(说明：最多上传5个附件)</font>
				<br/>
				<table border=0 id="tabtest2">
				</table>
     	</td>
     </tr>
      
      
       <tr id="rowHi">
      	<td class="form_label" align="right">历史差错情况：</td>
     	<td colspan="3">
      	<table border=0 id="hiTable"  width="100%">
		</table>
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
				<input type="button"  onclick="addMisTake('tabtest','files','jees','timees');return false;" value="新增差错" 
					style="margin-left:2px;vertical-align:middle;cursor:hand;"/>
				<br/>
				<table border=0 id="tabtest"   width="100%">
				</table>
     	</td>
     </tr>
    <%@include file="/jsp/util/default_gp_opinionUtil.jsp" %>
      </tr>
      
     <!--     <tr>
     	<td class="form_label" align="right" style="width:10%;">整改情况：</td>
     	<td colspan="3">
	     	<h:textarea  extAttr="class='h80' "  name="modelFour.rectification" property="modelFour.rectification"  id="hanldOption" validateAttr="maxLength=512;" rows="4"  style="width:90%;" />
		 
     	</td>
      </tr>-->
      <tr class="form_bottom">
        <td colspan="4">
          <input type="button"  value="提交" onclick="doSave(2);" class="button" id="save3" />
          <input type="button" value="查看流程" onclick="doflowpic();" class="button" id="flowpic" />
         </td>
      </tr>
     <tr id="row2">
     <td class="form_label" align="right" >流 程 列 表：</td>
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

			 
			 $("#opninionContent").text("");

 			 $.ajax({
				    url: '/modeFile/tModelFileAction_selectFiletest.action',
			        async: false,
			        type: 'post',
			        data: "executionId=${taskAssgineeDto.executionId}&modeId=${modelFour.processModelId}&modeType=mod4",
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
				        	$("#row2").css("display","none");  
				        } 
			        }
		 }); 
			
			 //查看详情界面
			 if('${isView}'!=''){
					$("#save3").hide();
					$("#rowFile").hide();
					$("#opninionContent").attr("readonly",true);
			 }else{
				 $("#row1").css("display","none");  
			 }
			 
			 if('${taskAssgineeDto.executionId}'!=""){
				 var tab,row,td,tdStr,rowId,fId,jeId,atId,pfId,tnId,epId,flId
				 rowId=0;
		         var tab = $id("hiTable");
				 var hiAddTime = "hiAddTime";
				 var hiProFour = "hiProFour";
				 var hiTaskName = "hiTaskName";
				 var hiEmpId = "hiEmpId";
				 var hiFlowId = "hiFlowId";
				 var hiJees = "hiJees";
				 var hiFiles = "hiFiles";
				 
				 $.ajax({
				        url: '/Generalprocess/tGeneralprocessModelFourAction_queryFourMistakeByFlowId.action',
				        async: false,
				        type: 'post',
				        data: "taskAssgineeDto.executionId=${taskAssgineeDto.executionId}" + "&modelFour.processModelId=${modelFour.processModelId}",
				        dataType: 'json',
				        timeout: 60000,
				        success: function (files) {
					        if(files!="" && files !=null){
					        	$.each(files,function( i,item ){
									 fId = hiFiles+rowId;
									 jeId= hiJees+"je"+rowId;
									 atId= hiAddTime+rowId;
									 pfId= hiProFour+rowId;
									 tnId= hiTaskName+rowId;
									 epId= hiEmpId+rowId;
									 flId= hiFlowId+rowId;
					         		 if('${isView}'!=''){
					         			
					         		 }else{
										row =  tab.insertRow();
										row.id = "fileRow"+rowId;
										td = row.insertCell();
										tdStr="节点名称："+item.taskName+"&nbsp&nbsp&nbsp&nbsp&nbsp<br/>";
										tdStr+="<input type=\"hidden\" name=\""+hiAddTime+"\" id=\""+atId+"\" value=\""+item.addTime+"\" >";
										tdStr+="<input type=\"hidden\" name=\""+hiProFour+"\" id=\""+pfId+"\" value=\""+item.processModelIdFour+"\" >";
										tdStr+="<input type=\"hidden\" name=\""+hiTaskName+"\" id=\""+tnId+"\" value=\""+item.taskName+"\" >";
										tdStr+="<input type=\"hidden\" name=\""+hiEmpId+"\" id=\""+epId+"\" value=\""+item.empid+"\" >";
										tdStr+="<input type=\"hidden\" name=\""+hiFlowId+"\" id=\""+flId+"\" value=\""+item.flowId+"\" >";
					         			tdStr+="差错内容：<textarea  rows=\"3\"  style=\"width:60%\"  name=\""+hiFiles+"\" id=\""+fId+"\" value=\""+item.mistakeContent+"\" size='70' validateAttr=\"allowNull=false\" onkeyup=\"this.value=this.value.replace(/[\|]/g,'')\">"+item.mistakeContent+"</textarea>";
									 	tdStr+="扣罚金额：<input type=\"text\" name=\""+hiJees+"\" id=\""+jeId+"\" value=\""+item.punishBal+"\" size='10' validateAttr=\"allowNull=false\" >元";
									 	tdStr+= "<input type=\"button\" onclick=\"delTr('fileRow"+rowId+"');\" name='button"+rowId+"' value=\"删除\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
									 	td.innerHTML = tdStr;
										rowId = rowId+1; 
					         		 }
					        	});
					          	
					        }else{
					        	 $("#rowHi").css("display","none");  
					        }    
				        }
			    }); 
			 }
			 
			 if('${modelFour.processModelId}'!=""){
				 var tab,row,td,tdStr,rowId,fId,jeId,timemask
			 rowId=0;
		         var tab = $id("ccTable");
				 var tab1 = $id("tabtest");
				 var fName = "files";
				 var jeName = "jees";
				 var timeName = "timees";
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
									 timemask=timeName+rowId;
									// atId= hiAddTime+rowId;
					         		 if('${isView}'!=''){
					         			row =  tab.insertRow();
										row.id = "fileRow"+rowId;
										td = row.insertCell();
					         			tdStr= "<textarea   style=\"display:none\"   style=\"width:60%\"  size='70' validateAttr=\"allowNull=false\" readonly=\"true\" >"+item.addTime+"</textarea>";
										
					         			tdStr+="差错内容：<textarea   rows=\"3\"   style=\"width:60%\"  size='70' validateAttr=\"allowNull=false\" readonly=\"true\" >"+item.mistakeContent+"</textarea>";
									 	tdStr+="扣罚金额：<input type=\"text\" value=\""+item.punishBal+"\" size='10' validateAttr=\"allowNull=false\" readonly=\"true\">元";
									 	tdStr+="添加时间：<input type=\"text\" value=\""+item.addTime+"\" size='10' validateAttr=\"allowNull=false\" readonly=\"true\">";
									 	td.innerHTML = tdStr;
										 rowId = rowId+1; 
					         		 }else{
										row =  tab1.insertRow();
										row.id = "fileRow"+rowId;
										td = row.insertCell();
										
					         			tdStr="<textarea   style=\"display:none\"  style=\"width:60%\"  size='70'                name=\""+timeName+"\"   id=\""+timemask+"\"   validateAttr=\"allowNull=false\" readonly=\"true\" >"+item.addTime+"</textarea>";

										
					         			tdStr+="差错内容：<textarea   rows=\"3\" style=\"width:60%\"   name=\""+fName+"\" id=\""+fId+"\"    validateAttr=\"allowNull=false\" onkeyup=\"this.value=this.value.replace(/[\|]/g,'')\">"+item.mistakeContent+"</textarea>";
					         		//	tdStr+=row.id;
									 	tdStr+="扣罚金额：<input type=\"text\" name=\""+jeName+"\" id=\""+jeId+"\" value=\""+item.punishBal+"\" size='10' validateAttr=\"allowNull=false\">元";
									 	tdStr+= "<input type=\"button\" onclick=\"delTr('fileRow"+rowId+"');\" name='button"+rowId+"' value=\"删除\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
									 	tdStr+= "<input type=\"button\" id='save"+rowId+"' onclick=\"saveMistake('fileRow"+rowId+"');\"  name='button"+rowId+"' value=\"保存\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
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
			
			var zs=$("#zsje").val();
			 var reg =/^[0-9]+([.]\d{1,2})?$/;
		        var is = reg.test(zs);
			
			if($.trim(zs)>0){
				if(!is){
					$("#decimal").css("display","");
					return;
					}
				
				}
			
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
		 function addMisTake(tabid,varName,varJeName,vartimeName){
			 var tab,row,td,fName,jeName,fId,jeId,tdStr,timeName;
			 var zs=$("#tabtest tbody tr").length;
			 tab = $id(tabid); 
			 fName = varName;
			 jeName = varJeName;
			 timeName=vartimeName;
			   var ididi= $("#tabtest  tr:last").attr("id");
	             if(ididi!=undefined){
	             var ids= ididi.split("fileRow");
	             rowId= ids[1];
	             rowId=parseInt(rowId)+1;
	             }
			 fId = varName+rowId;
			 jeId= varName+"je"+rowId; 
			 timemask=vartimeName+rowId; 
			 row =  tab.insertRow();
			 row.id = "fileRow"+rowId;
			 td = row.insertCell(); 
  			tdStr="<textarea    style=\"display:none\"  style=\"width:60%\"  size='70'                name=\""+timeName+"\" id=\""+timemask+"\"   validateAttr=\"allowNull=false\" readonly=\"true\" ></textarea>"; 
			 	tdStr="差错内容：<textarea   rows=\"3\" style=\"width:60%\"  name=\""+fName+"\" id=\""+fId+"\" size='70' validateAttr=\"allowNull=false\" onkeyup=\"this.value=this.value.replace(/[\|]/g,'')\"></textarea>";
			 	tdStr+="扣罚金额：<input type=\"text\" name=\""+jeName+"\" id=\""+jeId+"\" size='10' validateAttr=\"allowNull=false\">元";
			    tdStr+= "<input type=\"button\" onclick=\"delTr('fileRow"+rowId+"');\" name='button"+rowId+"' value=\"删除\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
			    tdStr+= "<input type=\"button\" id=\"save"+rowId+"\" onclick=\"saveMistake('fileRow"+rowId+"');\" name='button"+rowId+"' value=\"保存\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
				    td.innerHTML = tdStr;
			    rowId = rowId+1;    
		 }
			var rowId2 = 0;
			function addFile(tabid,varName){
			    var tab,row,td,fName,fId,tdStr;
			    var zs=$("#tabtest tbody tr").length;
			    tab = $id(tabid);
			    if (zs>=5){
			    	alert("新增附件不能超过5个");
			    	return false;
			    }
			    fName = varName;
			    fId = varName+rowId2;
			    row =  tab.insertRow();
			    row.id = "fileRow2"+rowId2;
			    td = row.insertCell(); 
			    
			    tdStr="<input type=\"file\" name=\""+fName+"\" id=\""+fId+"\" onchange=\"CheckUpLoadFile(this,2);\" size='70' class=smallInput validateAttr=\"allowNull=false\">";
			    tdStr += "<input type=\"button\" onclick=\"delTr('fileRow2"+rowId2+"');\" name='button"+rowId2+"' value=\"删除\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
			    td.innerHTML = tdStr;
			    rowId2 = rowId2+1;    
			}

		 function delTr(id){
			$("#"+id).remove();
		}
			function saveMistake(id){
				
				var money = $("#" + id + "   input").val();
				var time = $("#" + id + "   textarea[name='timees']").val();
				var files = $("#" + id + "   textarea[name='files']").val();
				if(files==null ||files==""){
					alert("差错内容不能为空");
					return;
					}else if(money==null||money==""){
						alert("扣罚金额不能为空");
						return;
						}
				
				$.ajax({//获得当前
					        url: '/Generalprocess/tGeneralprocessModelFourAction_saveMistakeInfo.action',
					        async:false,
					        type: 'post',
					        data: "modelFour.taskName=${modelFour.taskName}"+"&modelFour.processModelId=${modelFour.processModelId}"+"&taskAssgineeDto.nextTaskId=${taskAssgineeDto.nextTaskId}"+"&taskAssgineeDto.executionId=${taskAssgineeDto.executionId}"+"&misTakeId="+id+"&jees="+money+"&time="+time+"&files="+files,
					        dataType:"text",
					        timeout: 60000,
					        	 success: function (data) {
							    	  if (data.indexOf("success") >= 0) {
							    		 alert("保存成功");
							    		 var length=id.length;
										 var s=id.substring(7,length);
											 $("#save"+s).attr("disabled","disabled");
									} else if (data.indexOf("fails") >= 0) {
										alert("保存失败!");
									} else {
										alert("操作失败!");
									}
											  	
							      }
					        
				    });	
			
			 }
				
 </script>
</html>