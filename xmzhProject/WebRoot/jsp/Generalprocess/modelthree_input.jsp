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
<title>收单派单</title>
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
        
        <h:hidden id="processModelId" name="modelThree.processModelId" property="modelThree.processModelId"/>
		<h:hidden id="taskName" name="modelThree.taskName" property="modelThree.taskName"/>
		
		<h:hidden id="modelOneId" name="modelOne.processModelId" property="modelOne.processModelId"/>
		<h:hidden id="modelOneTaskName" name="modelOne.taskName" property="modelOne.taskName"/>
		<h:hidden id="modelOneFlowId" name="modelOne.flow_Id" property="modelOne.flow_Id"/>
		<h:hidden id="modelOneCreateName" name="modelOne.create_name" property="modelOne.create_name"/>
		<h:hidden id="modelOneTime" name="modelOne.create_time" property="modelOne.create_time"/>
		
		<h:hidden id="beginAssingee" name="taskAssgineeDto.beginAssingee" property="taskAssgineeDto.beginAssingee"/>
		<h:hidden id="beginOrg" name="taskAssgineeDto.beginOrg" property="taskAssgineeDto.beginOrg"/>
	<table id="modelOneTb" align="center" border="0" width="100%" class="form_table" >
      <tr>
         <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:50px;background-color: rgb(145, 186, 221);" >
        		 ${modelOne.taskName}
        </td>
      </tr>
      <tr>
      	<td class="form_label" align="right" style="width:120px;" >受理支行<br>（一级选项）</td>
      	<td colspan="1">
         <h:text property="modelOne.orgNameOne" id="orgNameOne" validateAttr="allowNull=false" style="width:130px;" readonly="true"/><font style="color: red">*</font>
         <h:hidden property="modelOne.orgCodeOne" id="orgCodeOne"/>	
      	</td>
     	<td class="form_label" align="right" style="width:120px;" >受理支行<br>（二级选项）</td>
     	<td colspan="3">
        <h:text id="orgNameTwo" property="modelOne.orgNameTwo" readonly="true"/>
		<h:hidden id="orgCodeTwo" property="modelOne.orgCodeTwo" />
	   <!--  <a href="#" onclick="open_slzhej_fun()">选择</a> -->
        </td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                   主调信贷员：
        </td>
        <td colspan="1">
         <h:text property="modelOne.creatorName" id="creatorName" style="width:130px;" /><font style="color: red">*</font>	
         <h:hidden id="creator" property="modelOne.creator" />
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                  辅调信贷员：
        </td>
        <td colspan="1">
         <h:text property="modelOne.fdxdy" id="fdxdy" style="width:130px;" /><font style="color: red">*</font>	
        </td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                   营业主管：
        </td>
        <td colspan="1">
         <h:text property="modelOne.yxzg" id="yxzg" style="width:130px;" /><font style="color: red">*</font>	
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                   营销人员：
        </td>
        <td colspan="1">
         <h:text property="modelOne.yxry" id="yxry" style="width:130px;" />	
        </td>
      	</tr>
       <tr>
     	<td class="form_label" align="right" style="width:120px;">客户姓名：</td>
     	<td>
	     	 <h:text property="modelOne.cust_Name" id="cust_Name"  style="width:130px;" />
	     	 <font style="color: red;">*</font>
     	</td>
     	<td class="form_label" align="right" style="width:120px;">合作机构：</td>
     	<td>
	     	 <h:text property="modelOne.coOrganization" id="coOrganization"  style="width:130px;" />
     	</td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                 申请金额：
        </td>
        <td colspan="1">
         <h:text property="modelOne.apply_bal" id="apply_bal" validateAttr="type=float" style="width:130px;" /><font style="color: red">*</font>	
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                   申请币别：
        </td>
					<td colspan="1">
						<d:select  id="currency"  dictTypeId="PROCESS_MONEY" property="modelOne.currency"></d:select>
					</td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                 一级分类：
        </td>
        <td colspan="1">
        
        <select id="oneCategorys" onchange="changeoneCategory()"   required>
         </select>
         <h:hidden property="modelOne.oneCategory"  id="oneCategory" />
         <font style="color: red">*</font>	
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                   贷种分类：
        </td>
        <td colspan="1">
         <select id="loanCategorys" onchange="changeloanCategory()">
         </select>
         <h:hidden property="modelOne.loanCategory"  id="loanCategory"/>
         
        </td>
      </tr>
        <tr>
           	<td class="form_label" align="right" style="width:120px;">是否老顾客：</td>
     	<td colspan="1">
			<h:select  id="old_Cust"  property="modelOne.old_Cust">
			     <h:option label="否" value="n"/>
			     <h:option label="是" value="y"/>
			     
			</h:select> 
		</td>
      
      </tr>
      <tr>
      <td class="form_label" align="right" style="width:120px;">
                                                   抵押物权属人名称：
        </td>
        <td colspan="1">

          <h:text property="modelOne.dywx_Name" id="dywx_Name" style="width:130px;" />	

        </td>
        
        <td class="form_label" align="right" style="width:120px;">
                                                    调查时间：
        </td>
        <td colspan="1">
        <div id="inputTime">
	         <w:date  id="survey_Time" submitFormat="yyyy-MM-dd" format="yyyy-MM-dd"  property="modelOne.survey_Time"/>
         </div>
        </td>
      </tr>
                  <tr>
     	<td class="form_label" align="right" style="width:120px;">借款人工作单位：</td>
     	<td>
	     	 <h:text property="modelOne.borr_Unit" id="borr_Unit" validateAttr="allowNull=ture" style="width:250px;" />
     	</td>
     	<td class="form_label" align="right" style="width:120px;">借款人配偶工作单位：</td>
     	<td>
	     	 <h:text property="modelOne.borrSpouse_Unit" id="borrSpouse_Unit" validateAttr="allowNull=ture" style="width:250px;" />
     	</td>
      </tr>
                   <tr>
     	<td class="form_label" align="right" style="width:120px;">共同借款人工作单位：</td>
     	<td>
	     	 <h:text property="modelOne.comBorr_Unit" id="comBorr_Unit" validateAttr="allowNull=ture" style="width:250px;" />
     	</td>
     	<td class="form_label" align="right" style="width:120px;">共同借款人配偶工作单位：</td>
     	<td>
	     	 <h:text property="modelOne.comBorrSpouse_Unit" id="comBorrSpouse_Unit" validateAttr="allowNull=ture" style="width:250px;" />
     	</td>
      </tr>
       <tr id="row11">
                <td class="form_label" align="right">附件下载：</td>
                <td colspan="3">
                     <div id="tag11" style="padding-top:15px;"></div>
                 </td>
       </tr>
        <tr id="fujian">
     	<td class="form_label" align="right">附件：</td>
     	<td colspan="3">
				<input type="button" onclick="addFile11('tabtest11','files2');return false;" value="新增附件" 
					style="margin-left:2px;vertical-align:middle;cursor:hand;"/>
				<font style="color: red">(说明：最多上传5个附件)</font>
				<br/>
				<table border=0 id="tabtest11">
				</table>
     	</td>
     </tr>
      
      
      
      <tr>
     	<td class="form_label" align="right">超限说明：</td>
     	<td colspan="3">
	     	<h:textarea property="modelOne.content" id="content"  extAttr="class='h80' "  validateAttr="maxLength=512;" rows="4"  style="width:90%;" />
     	</td>
      </tr>
      <tr>
     	<td class="form_label" align="right">处理意见：</td>
     	<td colspan="3">
	     	<h:textarea property="modelOne.hanldOption" id="hanldOption1"  extAttr="class='h80' "  validateAttr="maxLength=512;allowNull=ture" rows="4"  style="width:90%;" />
     	</td>
      </tr>
    </table>
	<table align="center" border="0" width="100%" class="form_table" >
       <tr>
         <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:50px;background-color: rgb(145, 186, 221);" >
        		${taskName }
        </td>
      </tr>
      <tr>
      	<td class="form_label" align="right" style="width:10%;">是否加急：</td>
      		 <td><d:select dictTypeId="ZHPT_ISURGENT" id="isurgent" property="modelThree.isurgent" nullLabel="请选择"/></td> 
      	<td class="form_label" align="right" style="width:10%;">报单时间：</td>
      		 <td colspan="1">
	         <w:date id="reporttime" submitFormat="yyyy-MM-dd" format="yyyy-MM-dd" allowNull="false" property="modelThree.reporttime"/><font style="color: red">*</font>	
        </td>
      </tr>
      <tr>
      	<td class="form_label" align="right" style="width:10%;" >报单次数：</td>
      	<td>
      		<h:text id="reportcnt" property="modelThree.reportcnt" validateAttr="type=naturalNumber;minValue=1;allowNull=false;" style="width:130px;" /><font style="color: red">*</font>
      	</td>
      </tr>
      
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
      
      <tr>
     	<td class="form_label" align="right" style="width:10%;">处理意见：</td>
     	<td colspan="3">
	     	<h:textarea  extAttr="class='h80' "  id="hanldOption" property="modelThree.opninion_content"  validateAttr="maxLength=512;" rows="4"  style="width:90%;" />
     	</td>
      </tr>
          <tr id="rowFile">
      
				<table border=0 id="tabtest1"   width="100%">
				</table>
     	</td>
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

 function saveRectification(mistakeId,rowId){

		var rectification = $("#rectification"+rowId).val();
		if(rectification==null & rectification==""){alert("请输入整改情况!")}
		$.ajax({//获得当前
			        url: "/Generalprocess/tGeneralprocessModelThreeAction_updateProcessMistake.action",
			        async:false,
			        type: 'post',
			        data: "processMistake.mistakeId="+mistakeId+"&processMistake.rectification="+rectification,
			        dataType:"text",
			        timeout: 60000,
			        	 success: function (data) {
					    	  if (data.indexOf("success") >= 0) {
					    		  alert("保存成功");
					    		  
							} else if (data.indexOf("fails") >= 0) {
								alert("保存失败!");
							} else {
								alert("操作失败!");
							}
									  	
					      }
			        
		    });	
}
var rowId = 0; 
$(function (){
		var submitter; 
		var currenUser;
		var flowId=$("#executionId");
		
		
	 $.ajax({
		 url : "/Generalprocess/tGeneralprocessModelThreeAction_querySubmitter.action",
			async : false,
			type : 'post',
			data : "processSubmitter.flowId=${taskAssgineeDto.executionId}",
			timeout : 60000,
			dataType : 'json',
			success : function(json) {
				
					 submitter=json.submitter; 
					 currenUser=json.currenUser;
					
					
			}});

		if(submitter==currenUser){
			
			$.ajax({
				
				url : "/Generalprocess/tGeneralprocessModelThreeAction_queryProcessMistake.action",
				async : false,
				type : 'post',
				data : "processMistake.flowId=${taskAssgineeDto.executionId}",
				timeout : 60000,
				dataType : 'json',
				success : function(json) {
					if (json == "") {

					} else {

                  $.each(json,function(key, value) {
                 		var money =value.money;
                 		var mistakeContent =value.mistakeContent;
                 		var rectification =value.rectification;
                 		var mistakeId =value.mistakeId;
							if(rectification==null){
								rectification="";

								}
							 var tab,row,td,tdStr;
							 var zs=$("#tabtest1 tbody tr").length;
							 tab = $id("tabtest1"); 
							 row =  tab.insertRow();
							 row.id = "fileRow"+rowId;
							 td = row.insertCell(); 
		tdStr="差错内容：<textarea   rows=\"3\" style=\"width:60%\"  name=\"mistakeContent\" id=\"mistakeContent\" size='70' validateAttr=\"allowNull=false\" readonly=\"true\" onkeyup=\"this.value=this.value.replace(/[\|]/g,'')\">"+mistakeContent+"</textarea>";
		tdStr+="<input type=\"hidden\" id=\"processMistake.mistakeId\" name=\"mistakeId\" value=\""+mistakeId+"\" />";
		tdStr+="扣罚金额：<input type=\"text\" name=\"money\" value=\""+money+"\" id=\"money\" readonly=\"true\" size='10' validateAttr=\"allowNull=false\">元  <br/>";
		tdStr+="整改情况：<textarea   rows=\"3\" style=\"width:60%\"  name=\"rectification\" id=\"rectification"+rowId+"\" size='70'  onkeyup=\"this.value=this.value.replace(/[\|]/g,'')\">"+rectification+"</textarea>";
	    tdStr+= "<input type=\"button\" onclick=\"delTr('fileRow"+rowId+"');\" name='button"+rowId+"' value=\"删除\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
		tdStr+= "<input type=\"button\" onclick=\"saveRectification("+mistakeId+","+rowId+");\" name='button"+rowId+"' value=\"保存\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
								td.innerHTML = tdStr;
							    rowId = rowId+1;     
				
			
							  	 
						});	
							}}
						});
			     }
	           	});

	

		 $(document).ready(function(){
			 $("#opninion_content").text("");

			 
			 if('${modelThree.processModelId}'!=""){
				
				 $.ajax({
				        url: '/modeFile/tModelFileAction_selectFiletest.action',
				        async: false,
				        type: 'post',
				        data: "executionId=${taskAssgineeDto.executionId}&modeId=${modelThree.processModelId}&modeType=mod3",
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
			 }else{    
				 $("#row1").css("display","none");  
				 $("#row2").css("display","none");  
				 $("#row3").css("display","none");  
				 $("#dopiRow").css("display","none");  
				 $("#beginOrg").val('${sessionScope.login_user.orgid}');
				 $("#createor").val('${sessionScope.login_user.empid}');
		        }  
			 
			//存在模式一则显示模式一表单
			 if('${modelOne.processModelId}' != ""){
				 $("#modelOneTb").show();
		 		 $.ajax({
				        url: '/modeFile/tModelFileAction_selectFiletest.action',
				        async: false,
				        type: 'post',
				        data: "executionId=${taskAssgineeDto.executionId}&modeId=${modelOne.processModelId}&modeType=mod1",
				        dataType: 'json',
				        timeout: 60000,
				        success: function (files) {
					        if(files!=""){
					         	$.each(files,function( i,item ){
						         	if('${isView}'!='')
					    	        	$("#tag11").fileDown({filename:item.fileName,filevalue:item.fileId});
						         	else 
						         		$("#tag11").fileDown({filename:item.fileName,filevalue:item.fileId,remove:1});
					          		});	
					        } else{    
					        	$("#row11").css("display","none");  
					        } 
				        }
			    });			 
			 }else{
				 $("#modelOneTb").hide();
			 }
			
			 setOneSelect('${taskAssgineeDto.processName}')
			 if('${modelOne.oneCategory}'!=""){
				 var oneCategory='${modelOne.oneCategory}';
				 setLcselect(oneCategory);
				 
			 }
			 
			 if('${isView}'!=''){
					$("#save3").hide();
					$("#isurgent").attr("disabled",true);
					$id("reporttime").attr("disabled",true);
					$("#reportcnt").attr("readonly",true);
					$("#opninion_content").attr("readonly",true);
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
		  	  	 	url="/Generalprocess/tGeneralprocessModelThreeAction_handleModelThree.action?"+arg;	
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
				
				function changeloanCategory(){
					$("#loanCategory").val($('#loanCategorys option:selected').val());
					}	
				function changeoneCategory(){
					alert(11)
					$("#oneCategory").val($('#oneCategorys option:selected').val());
					 setLcselect($("#oneCategory").val());
					}	
				
				function setLcselect(arg){
					$("#loanCategorys").html("");
					var selecthtml=$("#loanCategorys").html();
					 $.ajax({
					        url: "/Generalprocess/tGeneralprocessCdtypeAction_querycreditType.action?cdtype.firstClass="+encodeURI(arg),
					        async: false,
					        type: 'post',
					        data: "",
					        dataType: 'json',
					        success: function (json) {
					        	if(json==""){
					        	}else {
					        		$.each(json,function(key,value){
						        		selecthtml= selecthtml+"<option value="+value.creditType+">"+value.creditType+"</option>";
						        		});
					        	}
						        }
				    });	
					    $("#loanCategorys").html(selecthtml);
					    if($id("loanCategory").value==''){
					    	$("#loanCategory").val($('#loanCategorys option:selected').val());
						    }else{
						    	var all_options = document.getElementById("loanCategorys").options;
								for (i=0; i<all_options.length; i++){
									if (all_options[i].value ==$id("loanCategory").value ) // 根据option标签的ID来进行判断 测试的代码这里是两个等号
									{
										all_options[i].selected = true;
									}
								}
						    }
				}
				
				function setOneSelect(arg){
					$("#oneCategorys").html("");
					var selecthtml=$("#oneCategorys").html();
					 $.ajax({
					        url: "/Generalprocess/tGeneralprocessCdtypeAction_queryViewList.action?cdtype.processName="+encodeURI(arg),
					        async: false,
					        type: 'post',
					        data: "",
					        dataType: 'json',
					        success: function (json) {
					        	if(json==""){
					        	}else {
					        		$.each(json,function(key,value){
						        		selecthtml= selecthtml+"<option value="+value.firstClass+">"+value.firstClass+"</option>";
						        		});
					        	}
						        }
				    });	
					    $("#oneCategorys").html(selecthtml);
					    if($id("oneCategory").value==''){
					    	$("#oneCategory").val($('#oneCategorys option:selected').val());
					    	 setLcselect($("#oneCategory").val());
						    }else{
						    	var all_options = document.getElementById("oneCategorys").options;
								for (i=0; i<all_options.length; i++){
									if (all_options[i].value ==$id("oneCategory").value ) // 根据option标签的ID来进行判断 测试的代码这里是两个等号
									{
										all_options[i].selected = true;
									}
								}
								$("#oneCategory").val($('#oneCategorys option:selected').val());
								 setLcselect($("#oneCategory").val());
						    }
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

				var rowId2 = 0;
				function addFile11(tabid,varName){
					alert("3zhongyou1 ");
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
 </script>
</html>