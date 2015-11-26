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
<title>受理调查</title>
</head>
  <body>
    <h:form name="form1" id="form1" action="" method="post" enctype="multipart/form-data" onsubmit="return checkForm(this);">
    <div id="content">
    	<h:hidden id="createor"/>
        <h:hidden id="executionId" property="taskAssgineeDto.executionId"/>
        <h:hidden id="taskId"  property="taskAssgineeDto.nextTaskId"/>
        <h:hidden id="taskAssingee" property="taskAssgineeDto.taskAssingee"/>
        <h:hidden id="beginOrg" property="taskAssgineeDto.beginOrg"/>
        <h:hidden id="definitionId" property="taskAssgineeDto.definitionId"/>
        <h:hidden id="businessType" property="taskAssgineeDto.businessType"/>
        <h:hidden id="processName" property="taskAssgineeDto.processName"/>
        <h:hidden id="templateFileIds" property="taskAssgineeDto.templateFileIds"/>
        <h:hidden id="isC" name="isC" property="taskAssgineeDto/isC"/>
		<h:hidden id="btnType" name="taskAssgineeDto.btnType" />
		<h:hidden name="taskAssgineeDto.isFirst" value="1" />
		
		<h:hidden id="processModelId" name="modelOne.processModelId" property="modelOne.processModelId"/>
		<h:hidden id="taskName" name="modelOne.taskName" property="modelOne.taskName"/>
		<h:hidden id="flowId" name="modelOne.flow_Id" property="modelOne.flow_Id"/>
		
		<table align="center" border="0" width="100%" class="form_table" >
      <tr>
         <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:50px" >
        		受理调查表
        </td>
      </tr>
      <tr>
      	<td class="form_label" align="right" style="width:120px;" >受理支行<br>（一级选项）</td>
      	<td colspan="1">
         <h:text property="modelOne.orgNameOne" id="orgNameOne" validateAttr="allowNull=false" readonly="true" style="width:130px;" /><font style="color: red">*</font>
         <h:hidden property="modelOne.orgCodeOne" id="orgCodeOne"/>	
      	</td>
     	<td class="form_label" align="right" style="width:120px;" >受理支行<br>（二级选项）</td>
     	<td colspan="3">
        <h:text id="orgNameTwo" property="modelOne.orgNameTwo" readonly="true" validateAttr="allowNull=false;" />
		<h:hidden id="orgCodeTwo" property="modelOne.orgCodeTwo" />
	    <a href="#" onclick="open_slzhej_fun()">选择</a>
        </td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                   主调信贷员：
        </td>
        <td colspan="1">
         <h:text property="modelOne.creatorName" id="creatorName" validateAttr="allowNull=false" readonly="true" style="width:130px;" /><font style="color: red">*</font>	
         <h:hidden id="creator" property="modelOne.creator" />
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                  辅调信贷员：
        </td>
        <td colspan="1">
         <h:text property="modelOne.fdxdy" id="fdxdy" validateAttr="allowNull=false" style="width:130px;" /><font style="color: red">*</font>	
        </td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                   营业主管：
        </td>
        <td colspan="1">
         <h:text property="modelOne.yxzg" id="yxzg" validateAttr="allowNull=false"  style="width:130px;" /><font style="color: red">*</font>	
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                   营销人员：
        </td>
        <td colspan="1">
         <h:text property="modelOne.yxry" id="yxry" validateAttr="allowNull=ture" style="width:130px;" />	
        </td>
      	</tr>
       <tr>
     	<td class="form_label" align="right" style="width:120px;">客户姓名：</td>
     	<td>
	     	 <h:text property="modelOne.cust_Name" id="cust_Name" validateAttr="allowNull=false" style="width:130px;" />
	     	 <font style="color: red;">*</font>
     	</td>
     	<td class="form_label" align="right" style="width:120px;">合作机构：</td>
     	<td>
	     	 <h:text property="modelOne.coOrganization" id="coOrganization" validateAttr="allowNull=ture" style="width:130px;" />
     	</td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                 申请金额：
        </td>
        <td colspan="1">
         <h:text property="modelOne.apply_bal" id="apply_bal" validateAttr="allowNull=false" style="width:130px;" /><font style="color: red">*</font>	
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                   申请币别：
        </td>
        <td colspan="1">
         <h:text property="modelOne.currency" id="currency" validateAttr="allowNull=false" style="width:130px;" /><font style="color: red">*</font>	
        </td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                 一级分类：
        </td>
        <td colspan="1">
         <h:text property="modelOne.oneCategory" id="oneCategory" validateAttr="allowNull=false" style="width:130px;" /><font style="color: red">*</font>	
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                   贷种分类：
        </td>
        <td colspan="1">
         <h:text property="modelOne.loanCategory" id="loanCategory" validateAttr="allowNull=false" style="width:130px;" /><font style="color: red">*</font>	
        </td>
      </tr>
      <tr>
      <td class="form_label" align="right" style="width:120px;">
                                                   抵押物权属人名称：
        </td>
        <td colspan="1">
          <h:text property="modelOne.dywx_Name" id="dywx_Name" validateAttr="allowNull=ture" style="width:130px;" /><font style="color: red">*</font>	
        </td>
        
        <td class="form_label" align="right" style="width:120px;">
                                                    调查时间：
        </td>
        <td colspan="1">
        <div id="inputTime">
	         <w:date  id="survey_Time" submitFormat="yyyy-MM-dd" format="yyyy-MM-dd" allowNull="false" property="modelOne.survey_Time"/>
         </div>
        </td>
      </tr>
     
      <tr>
     	<td class="form_label" align="right">超限说明：</td>
     	<td colspan="3">
	     	<h:textarea property="modelOne.content" id="content"  extAttr="class='h80' "  validateAttr="maxLength=512;allowNull=ture" rows="4"  style="width:90%;" />
     	</td>
      </tr>
       <tr id="row3">
     	<td class="form_label" align="right">意见：</td>
     	<td colspan="3">
	     	<h:textarea property="modelOne.opinion"   extAttr="class='h80' " name="modelOne.opinion" id="opinion" validateAttr="maxLength=512" rows="4"  style="width:90%;"/>
		    <font style="color: red">*</font>
     	</td>
      </tr>
      <tbody id="dopiRow">
     	<%@include file="/jsp/util/default_opinionUtil.jsp" %>
     </tbody>
      <tr class="form_bottom">
        <td colspan="4">
          <input type="button" value="结束流程" class="button" onclick="doDeleteProcess('<b:write property="taskAssgineeDto/businessKey" />','07');" id="deleteProcessBtn">
          <input type="button" value="保存" class="button" id="save1" onclick="doSave(1);"  />
          <input type="button" value="提交" onclick="doSave(2);" class="button" id="smit" />
          <input type="button" value="回退" onclick="doSave2(2);" class="button" id="smit2" />
          <input type="button" value="查看流程" onclick="doflowpic();" class="button" id="flowpic" />
         </td>
      </tr>
       <%-- <tr id="row2">
     <td class="form_label" align="right">流 程 列 表：</td>
     <td colspan="3">
     <%@include file="/jsp/util/opinionUtil.jsp"%>
		</td>
     </tr> --%>
     <w:panel id="showpanel" title="流程信息">
    		<div id='showdiv'>
    	</div>	
	</w:panel>
    </table>
    </div>
    </h:form>
  </body>
 <script type="text/javascript">
 show('${taskAssgineeDto.fxJson}');
 $(document).ready(function(){
	 var templateFileIds = $("#templateFileIds").val();
		if(templateFileIds == "" || templateFileIds == null){
			$("#rowTemplate").hide();
		}
	//隐藏结束流程按钮
		$("#deleteProcessBtn").hide();
		if('${sessionScope.login_user.empid}'=='${modelOne.creator}'){
			  if($("#executionId").val()){
				  //当登录人等于发起人，显示结束流程按钮
				  $("#deleteProcessBtn").show();
		  	    }
		}
	 if('${modelOne.processModelId}'!=""){
		 if('${modelOne.creator}'!='${sessionScope.login_user.empid}')
		 $("#save1").css("display","none"); 
		 $.ajax({
		        url: '/file/tFileResourceTableAction_queryFileList.action',
		        async: false,
		        type: 'post',
		        data: "resourceType=${taskAssgineeDto.businessType}&resourceId=${modelOne.processModelId}",
		        dataType: 'json',
		        timeout: 60000,
		        success: function (files) {
			        if(files!=""){
			         	$.each(files,function( i,item ){
			         		if('${sessionScope.login_user.empid}'!=item.creator)
			    	        	$("#tag").fileDown({filename:item.fileName,filevalue:item.fileId});
				         	else
				         		 if('${isView}'!=''){
				         			$("#tag").fileDown({filename:item.fileName,filevalue:item.fileId});
					         	}else{
					         		$("#tag").fileDown({filename:item.fileName,filevalue:item.fileId,remove:1});
						         }
			          		});	
			        }else{
			        	 $("#row1").css("display","none");  
			        }
		        }
	    });
		  //$("#beginOrg").val("${euip.orgid}");	
		  //判断
		  WEB.doDisabledAttr('${isView}','${modelOne.creator}','${sessionScope.login_user.empid}',"opinion");  
		  WEB.doConditionDisplay('${modelOne.creator}','${sessionScope.login_user.empid}',"row3,dopiRow","none");//隐藏意见
	 }else{
		 $("#row1").css("display","none");  
		 $("#row2").css("display","none");  
		 $("#row3").css("display","none");  
		 $("#dopiRow").css("display","none");  
		 $("#beginOrg").val('${sessionScope.login_user.orgid}');
		 $("#createor").val('${sessionScope.login_user.empid}');
	 }
	 
	 //主调信贷员	姓名		显示
	 if('${modelOne.creatorName}'==""){
		 $("#creatorName").val('${sessionScope.login_user.empname}');
	 }
	 //主调信贷员	员工号	隐藏
	 if('${modelOne.creator}'==""){
		 $("#creator").val('${sessionScope.login_user.empid}');
	 }
	 //受理支行一 	 机构名称	显示
	 if('${modelOne.orgNameOne}'==""){
		 $("#orgNameOne").val('${sessionScope.login_user.orgname}');
	 }
	 //受理支行一 	机构code	隐藏
	 if('${modelOne.orgCodeOne}'==""){
		 $("#orgCodeOne").val('${sessionScope.login_user.orgcode}');
	 }
	 
	 if('${isView}'!=''){
		$("#deleteProcessBtn").hide();
		$("#save1").hide();
		$("#smit").hide();
		$("#fujian").hide();
		$("#row1").show();
		$("#hiddenTime").show();
		$("#rowTemplate").hide();
	}
	 
	 if('${taskAssgineeDto.isC}'){
			$("#smit").hide();
			$("#deleteProcessBtn").hide();
		}else{			
			$("#smit2").hide();
	 }
});

function initPlanCell20(){
		var queryCond="";
			queryCond += "<resourceId>${modelOne.processModelId}</resourceId>";
		 	queryCond += "<resourceType>${taskAssgineeDto.businessType}</resourceType>";
			return queryCond;
		}

	 //value 为1		保存
	 //value 为2 	提交
     function doSave(value){
    		$("#btnType").val(value);
    		if(value!="1"){
    			if(checkForm($id("form1"))){
    			var strUrl = "/jbpm/jbpmDemoAction_toNextTaskConfig.action?taskAssgineeDto.executionId="+$id("executionId").value+"&taskAssgineeDto.beginOrg="+$("#beginOrg").val()+"&taskAssgineeDto.beginAssingee="+$("#createor").val()+"&taskAssgineeDto.definitionId=${taskAssgineeDto.definitionId}";
    			showModalCenter(strUrl, null, taskAssigneeCallBack, 700, 400, '节点选择');
    			}
    		}else{
    			var _form = $id("form1");
    	  	  	url="/euipApply/tApplyEuipAction_insertEuipInfo.action";	
    	  	  	_form.action =url
    	  	  	if(checkForm($id("form1")))
    			    ajaxsubmitO(0);
    	  	 	}
     }

	 //回退
     function doSave2(value){
    		$("#btnType").val(value);
    		if(value!="1"){
    			if(checkForm($id("form1"))){
    			var strUrl = "/jbpm/jbpmDemoAction_toNextTaskConfig2.action?taskAssgineeDto.executionId="+$id("executionId").value+"&taskAssgineeDto.beginOrg="+$("#beginOrg").val()+"&taskAssgineeDto.beginAssingee="+$("#createor").val()+"&taskAssgineeDto.definitionId=${taskAssgineeDto.definitionId}";
        		showModalCenter(strUrl, null, taskAssigneeCallBack, 700, 400, '节点选择');
    			}
    		}else{
    			var _form = $id("form1");
    	  	  	 	url="/euipApply/tApplyEuipAction_insertEuipInfo.action";	
    	  	  	    _form.action =url
    	  	  	if(checkForm($id("form1")))
    			    ajaxsubmitO(0);
    	  	 	}
     }
 	function taskAssigneeCallBack(arg){
  	 	var _form = $id("form1");
  	 	if(arg!=""){
  	  	 	url="/Generalprocess/generalProcessAction_handleModelOne.action?"+arg;	
  	  	    _form.action =url
  	        // 异步提交请求 
  	  	    ajaxsubmitO(1);
  	 	}
  	 }

  	  function ajaxsubmitO(flag){
  	  	maskTop();
  	  	 var options = {
  		  		type : "post",
  		  		cache : "false",
  			  	success : function(data){
  					try {  
  					  	if(data.indexOf("success")>=0){
      					  	alert("操作成功!")
  					  		unMaskTop();
      					  if(flag==1)
      					  WEB.turnMainFrame();
  					  	}else if(data.indexOf("fails")>=0){
  					  	unMaskTop();
      					  	alert("操作失败!");
  					  	}else{	
  					  	unMaskTop(); 
  					  	    alert("操作失败!"); 	
  					  	}
  	   				} catch (Exception) {  
  					}  
  				},  
  			  	error : function(data){
  					unMaskTop();
  				  alert("添加失败请联系管理员！");
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

		//选择	受理支行	二级选项
		function open_slzhej_fun(){
			var strUrl ="";
			var objName="";
			var peArgument = [];
			strUrl ="/tree/initMainTree_mainTree.action?changeTree.showTabOrg=1&changeTree.orgType=4&changeTree.showSelBox=1&changeTree.checkcount=1"
			objName="选择受理支行";  
			var paramEntity = new ParamEntity('Organization');
				paramEntity.setProperty('orgname',$id("orgNameTwo").value);
				paramEntity.setProperty('orgcode',$id("orgCodeTwo").value);
				peArgument[3]=[paramEntity,'orgname','orgcode',"orgid"];			
			showModalCenter(strUrl,peArgument,open_slzhej_callback,600,430,objName); 
			}
		
		//受理支行		二级选项	回调方法
		function open_slzhej_callback(arg){//回调方法
				if(arg!=''){
		    	if(arg['Organization']){ //原写法无需判断是否为空
				  		var sorgidArra  = arg['Organization'].slice(0);//人员数组
				  		argRes=[[],[],[],[]];
						for(var i=0;i<sorgidArra.length;i++){
							argRes[0].push(sorgidArra[i].getProperty("orgcode"));
							argRes[1].push(sorgidArra[i].getProperty("orgname"));
						}
						$id("orgNameTwo").value = argRes[1];
						$id("orgCodeTwo").value = argRes[0];
					}
		    	}
			}
				
 </script>
</html>