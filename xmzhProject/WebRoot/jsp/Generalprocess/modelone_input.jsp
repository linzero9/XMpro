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
  <e:datasource name="euip" type="bean" path="com.gotop.euipApply.model.TApplyEuip" />
    <h:form name="form1" id="form1" action="/euipApply/tApplyEuipAction_insertEuipInfo.action" method="post" enctype="multipart/form-data" onsubmit="return checkForm(this);">
    <div id="content">
         <h:hidden property="euip.epId"/>
         <h:hidden property="euip.flowId"/>
	     <h:hidden property="euip.createDate"/>
	     <h:hidden property="euip.empId" id="createor"/>
        <h:hidden id="executionId" property="taskAssgineeDto.executionId"/>
        <h:hidden id="taskId"  property="taskAssgineeDto.nextTaskId"/>
        <h:hidden id="taskAssingee" property="taskAssgineeDto.taskAssingee"/>
        <h:hidden id="beginOrg" property="taskAssgineeDto.beginOrg"/>
        <h:hidden id="definitionId" property="taskAssgineeDto.definitionId"/>
        <h:hidden id="businessType" property="taskAssgineeDto.businessType"/>
          <h:hidden id="templateFileIds" property="taskAssgineeDto.templateFileIds"/>
          <h:hidden id="isC" name="isC" property="taskAssgineeDto/isC"/>
		 <input type="hidden" id="btnType" name="btnType" />
		   <h:hidden name="isFirst" value="1" />
		<table align="center" border="0" width="100%" class="form_table" >
       <tr>
         <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:50px" >
        		受理调查表
        </td>
      </tr>
      <tr>
      <td class="form_label" align="right" style="width:120px;" >受理支行<br>（一级选项）</td>
      <td colspan="1">
         <h:text property="euip.orgName" id="orgName" validateAttr="allowNull=false" readonly="true" style="width:130px;" /><font style="color: red">*</font>	
        </td>
     <td class="form_label" align="right" style="width:120px;" >受理支行<br>（二级选项）</td>
     <td colspan="3">
              <h:text id="objName" property="processDeployDto.objName" readonly="true" validateAttr="allowNull=false;" />
			   <h:hidden id="deployRange" property="processDeployDto.deployRange" />
			  <h:hidden id="orgcode" property="processDeployDto.orgcode" />
			  <a href="#" onclick="open_newyw_tree_fun()">选择</a>
            </td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                   主调信贷员：
        </td>
        <td colspan="1">
         <h:text property="euip.empName" id="empName" validateAttr="allowNull=false" readonly="true" style="width:130px;" /><font style="color: red">*</font>	
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                  辅调信贷员：
        </td>
        <td colspan="1">
         <h:text property="euip.orgName" id="orgName" validateAttr="allowNull=false" readonly="true" style="width:130px;" /><font style="color: red">*</font>	
        </td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                   营业主管：
        </td>
        <td colspan="1">
         <h:text property="euip.empName" id="empName" validateAttr="allowNull=false"  style="width:130px;" /><font style="color: red">*</font>	
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                   营销人员：
        </td>
        <td colspan="1">
         <h:text property="euip.orgName" id="orgName" validateAttr="allowNull=ture" style="width:130px;" />	
        </td>
      </tr>
       <tr>
     	<td class="form_label" align="right">客户姓名：</td>
     	<td>
	     	 <h:text property="euip.phoneNo" id="phoneNo" validateAttr="allowNull=false" style="width:130px;" />
	     	 <font style="color: red;">*</font>
     	</td>
     	<td class="form_label" align="right">合作机构：</td>
     	<td>
	     	 <h:text property="euip.phoneNo" id="phoneNo" validateAttr="allowNull=ture" style="width:130px;" />
     	</td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                 申请金额：
        </td>
        <td colspan="1">
         <h:text property="euip.empName" id="empName" validateAttr="allowNull=false" readonly="true" style="width:130px;" /><font style="color: red">*</font>	
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                   申请币别：
        </td>
        <td colspan="1">
         <h:text property="euip.orgName" id="orgName" validateAttr="allowNull=false" readonly="true" style="width:130px;" /><font style="color: red">*</font>	
        </td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                 一级分类：
        </td>
        <td colspan="1">
         <h:text property="euip.empName" id="empName" validateAttr="allowNull=false" readonly="true" style="width:130px;" /><font style="color: red">*</font>	
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                   贷种分类：
        </td>
        <td colspan="1">
         <h:text property="euip.orgName" id="orgName" validateAttr="allowNull=false" readonly="true" style="width:130px;" /><font style="color: red">*</font>	
        </td>
      </tr>
      <tr>
      <td class="form_label" align="right" style="width:120px;">
                                                   抵押物权属人名称：
        </td>
        <td colspan="1">
          <h:text property="euip.phoneNo" id="phoneNo" value="${sessionScope.login_user.mobi }" validateAttr="allowNull=ture" style="width:130px;" /><font style="color: red">*</font>	
        </td>
        
        <td class="form_label" align="right" style="width:120px;">
                                                    申请时间：
        </td>
        <td colspan="1">
        <div id="inputTime">
	         <w:date  id="applyTime" submitFormat="yyyy-MM-dd" format="yyyy-MM-dd" readonly="true" allowNull="false" property="euip.applyTime"/>
         </div>
        <%--   <div id="hiddenTime" style="display: none">
         	<h:text property="euip.applyTime" readonly="true"/>
         </div><font style="color: red">*</font> --%>
        </td>
      </tr>
     
      <tr>
     	<td class="form_label" align="right">超限说明：</td>
     	<td colspan="3">
	     	<h:textarea property="euip.epReason" id="epReason"  extAttr="class='h80' "  validateAttr="maxLength=512;allowNull=ture" rows="4"  style="width:90%;" />
     	</td>
      </tr>
       
      <tr class="form_bottom">
        <td colspan="4">
          <input type="button" value="结束流程" class="button" onclick="doDeleteProcess('<b:write property="taskAssgineeDto/businessKey" />','07');" id="deleteProcessBtn">
          <input type="button" value="保存" class="button" id="save1" onclick="doSave(1);"  />
          <input type="button" value="提交" onclick="doSave(2);" class="button" id="smit" />
          <input type="button" value="回退" onclick="doSave2(2);" class="button" id="smit2" />
          <input type="button" value="查看流程" onclick="doflowpic();" class="button" id="flowpic" />
         </td>
      </tr>
       <tr id="row2">
     <td class="form_label" align="right">流 程 列 表：</td>
     <td colspan="3">
     <%@include file="/jsp/util/opinionUtil.jsp"%>
		</td>
     </tr>
    </table>
    </div>
    </h:form>
  </body>
 <script type="text/javascript">
 $(document).ready(function(){
	 var templateFileIds = $("#templateFileIds").val();
		if(templateFileIds == "" || templateFileIds == null){
			$("#rowTemplate").hide();
		}
	//隐藏结束流程按钮
		$("#deleteProcessBtn").hide();
		if('${sessionScope.login_user.empid}'=='${euip.empId}'){
			  if($("#executionId").val()){
				  //当登录人等于发起人，显示结束流程按钮
				  $("#deleteProcessBtn").show();
		  	    }
		}
	 if('${euip.epId}'!=""){
		 if('${euip.empId}'!='${sessionScope.login_user.empid}')
		 $("#save1").css("display","none"); 
		 $.ajax({
		        url: '/file/tFileResourceTableAction_queryFileList.action',
		        async: false,
		        type: 'post',
		        data: "resourceType=${taskAssgineeDto.businessType}&resourceId=${euip.epId}",
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
		  $("#beginOrg").val("${euip.orgid}");	
		  //判断
		  WEB.doDisabledAttr('${isView}','${euip.empId}','${sessionScope.login_user.empid}',"opinion");  
		  WEB.doConditionDisplay('${euip.empId}','${sessionScope.login_user.empid}',"row3,dopiRow","none");//隐藏意见
		  if('${euip.empId}'!='${sessionScope.login_user.empid}'){
			 //$("#opninion").val("已处理");
			 }
	 }else{
		
		 $("#row1").css("display","none");  
		 $("#row2").css("display","none");  
		 $("#row3").css("display","none");  
		 $("#dopiRow").css("display","none");  
		 $("#beginOrg").val('${sessionScope.login_user.orgid}'); 
	 }
	 if('${euip.empName}'==""){
		 $("#empName").val('${sessionScope.login_user.empname}');
	 }
	 if('${euip.orgName}'==""){
		 $("#orgName").val('${sessionScope.login_user.orgname}');
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
			queryCond += "<resourceId>${euip.epId}</resourceId>";
		 	queryCond += "<resourceType>${taskAssgineeDto.businessType}</resourceType>";
			return queryCond;
		}

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
  	  	 	url="/euipApply/tApplyEuipAction_insertEuipInfo.action?"+arg;	
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

		function open_newyw_tree_fun(){//方法名
			var strUrl ="";
			var objName="";
			var peArgument = [];
			var deployType = $id("deployType").value;
			if(deployType=="02"){
		     strUrl="/tree/initMainTree_mainTree.action?changeTree.showTabOrg=1&changeTree.orgType=6&changeTree.showSelBox=2";
		     objName="人员发布";
		     var paramEntity = new ParamEntity('Employee');
				paramEntity.setProperty('empid',$id("deployRange").value);
				paramEntity.setProperty('empname',$id("objName").value);
				peArgument[2]=[paramEntity,'empname','empid'];
			}else if(deployType=="01"){
			 strUrl = "/tree/initMainTree_mainTree.action?orgType=4&changeTree.showTabOrg=0&changeTree.showTabGroup=0&changeTree.showTabRole=1&showSelBox=4";
			 objName="角色发布";
			 var paramEntity = new ParamEntity('Role');
				paramEntity.setProperty('roleid',$id("deployRange").value);
				paramEntity.setProperty('rolename',$id("objName").value);
				peArgument[2]=[paramEntity,'rolename','roleid'];
			}else if(deployType=="03"){
			strUrl ="/tree/initMainTree_mainTree.action?changeTree.showTabOrg=1&changeTree.orgType=4&changeTree.showSelBox=4"
			objName="机构发布";  
			var paramEntity = new ParamEntity('Organization');
				paramEntity.setProperty('orgid',$id("deployRange").value);
				paramEntity.setProperty('orgname',$id("objName").value);
				paramEntity.setProperty('orgcode',$id("orgcode").value);
				peArgument[3]=[paramEntity,'orgname','orgcode',"orgid"];	
			}else if(deployType=="04"){
				strUrl = "/empMngr/positionSelectWin2_empMngr.action"
					peArgument[0]=$id("deployRange").value;
				peArgument[1]=$id("objName").value;
					objName="岗位发布";  
			}			
					showModalCenter(strUrl,peArgument,openNewEmpTreeCallBack,600,430,objName); 
			}

		function openNewEmpTreeCallBack(arg){//回调方法
			var deployType = $id("deployType").value;
		    if(deployType=="01"){
		        //角色
				if(arg!=''){
		    	if(arg['Role']){ //原写法无需判断是否为空
				  		var sorgidArra  = arg['Role'].slice(0);//角色数组
				  		argRes=[[],[],[],];
						for(var i=0;i<sorgidArra.length;i++){
							argRes[0].push(sorgidArra[i].getProperty("roleid"));
							argRes[1].push(sorgidArra[i].getProperty("rolename"));
						}
						$id("deployRange").value = argRes[0];
						$id("objName").value = argRes[1];
					}else{
						 $id("deployRange").value = "";
						$id("objName").value = ""; 
					}
				}
		    }else if(deployType=="02"){
		        //人员
				if(arg!=''){
		    	if(arg['Employee']){ //原写法无需判断是否为空
				  		var sorgidArra  = arg['Employee'].slice(0);//人员数组
				  		argRes=[[],[],[],[]];
						for(var i=0;i<sorgidArra.length;i++){
							argRes[0].push(sorgidArra[i].getProperty("empid"));
							argRes[1].push(sorgidArra[i].getProperty("empname"));
						}
						$id("deployRange").value = argRes[0];
						$id("objName").value = argRes[1];
					}else{
						$id("objName").value = "";
						$id("deployRange").value = "";
					}}
		    }else{
				if(arg!=''){
		    	if(arg['Organization']){ //原写法无需判断是否为空
				  		var sorgidArra  = arg['Organization'].slice(0);//人员数组
				  		argRes=[[],[],[],[]];
						for(var i=0;i<sorgidArra.length;i++){
							argRes[0].push(sorgidArra[i].getProperty("orgcode"));
							argRes[1].push(sorgidArra[i].getProperty("orgname"));
							argRes[2].push(sorgidArra[i].getProperty("orgid"));
						}
						$id("deployRange").value = argRes[2];
						$id("objName").value = argRes[1];
						$id("orgcode").value = argRes[0];
					}else{
						//指定岗位
						$id("deployRange").value =arg[0];
						$id("objName").value =arg[1];
						$id("orgcode").value=arg[2];
					}}
		    }
			}
				
 </script>
</html>