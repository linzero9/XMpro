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
<title>设备申请</title>
</head>
  <body>

  
  <e:datasource name="euip" type="bean" path="com.gotop.euipApply.model.TApplyEuip" />
    <h:form name="form1" id="form1" action="/euipApply/tApplyEuipAction_insertEuipInfo.action" method="post" enctype="multipart/form-data" onsubmit="return checkForm(this);">
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
        <h:hidden id="isC" name="isC" property="taskAssgineeDto/isC"/>
		 <input type="hidden" id="btnType" name="btnType" />
		<table align="center" border="0" width="100%" class="form_table" >
       <tr>
         <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:50px" >
        		节点模式2
        </td>
      </tr>
      <tr>
      <tr>
     	<td class="form_label" align="right">原因：</td>
     	<td colspan="3">
	     	<h:textarea  extAttr="class='h80' "  property="euip.epReason"  id="epReason" readonly="true" validateAttr="maxLength=512;allowNull=false" rows="4"  style="width:90%;" />
		    <font style="color: red">*</font>
     	</td>
      </tr>
    
      <tr id="row3">
     	<td class="form_label" align="right">意见：</td>
     	<td colspan="3">
	     	<h:textarea property="euip.opninion" extAttr="class='h80'" id="opinion" name="euip.opninion" validateAttr="maxLength=512;allowNull=false" rows="4"  style="width:90%;"/>
		    <font style="color: red">*</font>
     	</td>
      </tr>
     	<%@include file="/jsp/util/default_opinionUtil.jsp" %>
      <tr class="form_bottom">
        <td colspan="4">
          <input type="button" value="保存" class="button" id="save1" onclick="doSave(1);"  />
          <input type="button" value="提交" onclick="doSave(2);" class="button" id="save3" />
          <input type="button" value="回退" onclick="doSave2(2);" class="button" id="save4" />
          <input type="button" value="查看流程" onclick="doflowpic();" class="button" id="flowpic" />
          <d:write property="1"  dictTypeId='ABF_FILE_SAVE'/>
         </td>
      </tr>
    </table>
    </h:form>
      	<w:panel id="showpanel" title="我的流程">
    	<div id='showdiv'>
    	</div>	
	</w:panel>
  </body>
 <script type="text/javascript">

 $(document).ready(function(){
	 if('${euip.epId}'!=""){
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
		 if('${isView}'!=""){
			 $(".smit").attr("display","none");
		 }

		 if('${taskAssgineeDto.isC}'){
			 	$("#save3").hide();
				$("#save1").hide();
			}else{
				$("#save4").hide();
				
				}
		 
	 }else{
		 $("#row1").css("display","none");  
		 $("#row2").css("display","none");  
		 $("#row3").css("display","none");  
	 }
	 if('${euip.empName}'==""){
		 $("#empName").val('${sessionScope.login_user.empname}');
	 }

	 if('${isView}'!=''){
			$("#save1").hide();
			$("#save3").hide();
			$("#fujian").hide();
			$("#row3").hide();
			//$("#hiddenTime").show();
		}

});
show();
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
    			var strUrl = "/jbpm/jbpmDemoAction_toNextTaskConfig.action?taskAssgineeDto.executionId="+$id("executionId").value+"&taskAssgineeDto.beginOrg="+$("#beginOrg").val()+"&taskAssgineeDto.beginAssingee="+$("#createor").val();
        		showModalCenter(strUrl, null, taskAssigneeCallBack, 700, 400, '节点选择');
    			}
    		}else{
    			var _form = $id("form1");
    	  	  	 	url="/euipApply/tApplyEuipAction_insertEuipInfo.action";	
    	  	  	    _form.action =url;
    	  	  	if(checkForm($id("form1")))
    			    ajaxsubmitO();
    	  	 	}
     }

     function doSave2(value){   		
 		$("#btnType").val(value);
 		if(value!="1"){
 			if(checkForm($id("form1"))){
 			var strUrl = "/jbpm/jbpmDemoAction_toNextTaskConfig2.action?taskAssgineeDto.executionId="+$id("executionId").value+"&taskAssgineeDto.beginOrg="+$("#beginOrg").val()+"&taskAssgineeDto.beginAssingee="+$("#createor").val();
     		showModalCenter(strUrl, null, taskAssigneeCallBack, 700, 400, '节点选择');
 			}
 		}else{
 			var _form = $id("form1");
 	  	  	 	url="/euipApply/tApplyEuipAction_insertEuipInfo.action";	
 	  	  	    _form.action =url;
 	  	  	if(checkForm($id("form1")))
 			    ajaxsubmitO();
 	  	 	}
  }
 	function taskAssigneeCallBack(arg){
  	 	var _form = $id("form1");
  	 	if(arg!=""){
  	  	 	url="/euipApply/tApplyEuipAction_insertEuipInfo.action?"+arg;	
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

		function show(jsonString){
			var showpanel=$("#showdiv");
		//	var jsonString='{"comments":[{"content":"很不错嘛","id":1,"nickname":"纳尼"},{"content":"哟西哟西","id":2,"nickname":"小强"}],"content":"你是木头人，哈哈。","infomap":{"性别":"男","职业":"程序员","博客":"http:\/\/www.cnblogs.com\/codeplus\/"},"title":"123木头人"}';
			jsonString='{"seq":[{"description":"","dicname":"","fieldName":"processModelOneID","handle":"","hidden":false,"name":"模式一编号,信贷业务编号","type":"text","url":"","value":11},{"description":"","dicname":"","fieldName":"flow_Id","handle":"","hidden":false,"name":"流程ID","type":"text","url":"","value":1},{"description":"","dicname":"","fieldName":"orgCodeOne","handle":"","hidden":true,"name":"受理支行（一级选项）","type":"text","url":"","value":"11"},{"description":"","dicname":"","fieldName":"orgCodeTwo","handle":"","hidden":true,"name":"受理支行（二级选项）","type":"text","url":"","value":"2"},{"description":"","dicname":"","fieldName":"creator","handle":"","hidden":true,"name":"主调信贷员","type":"text","url":"","value":"2"},{"description":"","dicname":"","fieldName":"fdxdy","handle":"","hidden":true,"name":"辅调信贷员","type":"text","url":"","value":"3"},{"description":"","dicname":"","fieldName":"yxzg","handle":"","hidden":true,"name":"营业主管","type":"text","url":"","value":"4"},{"description":"","dicname":"","fieldName":"yxry","handle":"","hidden":true,"name":"营销人员","type":"text","url":"","value":"6"},{"description":"","dicname":"ABF_FILE_SAVE","fieldName":"currency","handle":"","hidden":true,"name":"申请币别","type":"dic","url":"","value":"1"},{"description":"","dicname":"","fieldName":"apply_bal","handle":"","hidden":true,"name":"申请金额","type":"text","url":"","value":"2"},{"description":"","dicname":"","fieldName":"oneCategory","handle":"","hidden":true,"name":"一级分类","type":"text","url":"","value":"rer"},{"description":"","dicname":"","fieldName":"loanCategory","handle":"","hidden":true,"name":"贷种分类","type":"text","url":"","value":"rere"},{"description":"","dicname":"","fieldName":"dywx_Name","handle":"","hidden":true,"name":"抵押物权属人姓名","type":"text","url":"","value":"rer"},{"description":"","dicname":"","fieldName":"coOrganization","handle":"","hidden":true,"name":"合作机构","type":"text","url":"","value":"房顶上的"},{"description":"","dicname":"","fieldName":"survey_Time","handle":"","hidden":true,"name":"调查时间","type":"text","url":"","value":"234"},{"description":"","dicname":"","fieldName":"content","handle":"","hidden":true,"name":"超限说明","type":"text","url":"","value":"防守对方"},{"description":"","dicname":"","fieldName":"cust_Name","handle":"","hidden":true,"name":"客户名称","type":"text","url":"","value":"防守对方说"},{"description":"","dicname":"","fieldName":"create_Date","handle":"","hidden":true,"name":"创建日期","type":"date","url":"","value":"20151120"},{"description":"","dicname":"","fieldName":"create_time","handle":"","hidden":true,"name":"创建时间","type":"date","url":"","value":"防守对方"},{"description":"","dicname":"","fieldName":"create_name","handle":"","hidden":true,"name":"创建人姓名","type":"text","url":"","value":"辅导费"},{"description":"","dicname":"","fieldName":"last_up_date","handle":"","hidden":true,"name":"最后修改日期","type":"text","url":"","value":"辅导费"},{"description":"","dicname":"","fieldName":"last_up_time","handle":"","hidden":true,"name":"最后修改时间","type":"text","url":"","value":"辅导费"},{"description":"","dicname":"","fieldName":"last_up_name","handle":"","hidden":true,"name":"最后操作员","type":"text","url":"","value":"发的"}],"seq1":[{"description":"","dicname":"","fieldName":"processModelOneID","handle":"","hidden":false,"name":"模式一编号,信贷业务编号","type":"text","url":"","value":22},{"description":"","dicname":"","fieldName":"flow_Id","handle":"","hidden":false,"name":"流程ID","type":"text","url":"","value":1},{"description":"","dicname":"","fieldName":"orgCodeOne","handle":"","hidden":true,"name":"受理支行（一级选项）","type":"text","url":"","value":"2"},{"description":"","dicname":"","fieldName":"orgCodeTwo","handle":"","hidden":true,"name":"受理支行（二级选项）","type":"text","url":"","value":"2"},{"description":"","dicname":"","fieldName":"creator","handle":"","hidden":true,"name":"主调信贷员","type":"text","url":"","value":"3"},{"description":"","dicname":"","fieldName":"fdxdy","handle":"","hidden":true,"name":"辅调信贷员","type":"text","url":"","value":"4"},{"description":"","dicname":"","fieldName":"yxzg","handle":"","hidden":true,"name":"营业主管","type":"text","url":"","value":"是否"},{"description":"","dicname":"","fieldName":"yxry","handle":"","hidden":true,"name":"营销人员","type":"text","url":"","value":"所属"},{"description":"","dicname":"","fieldName":"currency","handle":"","hidden":true,"name":"申请币别","type":"text","url":"","value":"淡定"},{"description":"","dicname":"","fieldName":"apply_bal","handle":"","hidden":true,"name":"申请金额","type":"text","url":"","value":"淡定"},{"description":"","dicname":"","fieldName":"oneCategory","handle":"","hidden":true,"name":"一级分类","type":"text","url":"","value":"方法"},{"description":"","dicname":"","fieldName":"loanCategory","handle":"","hidden":true,"name":"贷种分类","type":"text","url":"","value":"刚刚"},{"description":"","dicname":"","fieldName":"dywx_Name","handle":"","hidden":true,"name":"抵押物权属人姓名","type":"text","url":"","value":"呵呵"},{"description":"","dicname":"","fieldName":"coOrganization","handle":"","hidden":true,"name":"合作机构","type":"text","url":"","value":"阿萨德"},{"description":"","dicname":"","fieldName":"survey_Time","handle":"","hidden":true,"name":"调查时间","type":"text","url":"","value":"斯蒂芬"},{"description":"","dicname":"","fieldName":"content","handle":"","hidden":true,"name":"超限说明","type":"text","url":"","value":"斯蒂芬"},{"description":"","dicname":"","fieldName":"cust_Name","handle":"","hidden":true,"name":"客户名称","type":"text","url":"","value":"斯蒂芬"},{"description":"","dicname":"","fieldName":"create_Date","handle":"","hidden":true,"name":"创建日期","type":"text","url":"","value":"阿达"},{"description":"","dicname":"","fieldName":"create_time","handle":"","hidden":true,"name":"创建时间","type":"text","url":"","value":"洒"},{"description":"","dicname":"","fieldName":"create_name","handle":"","hidden":true,"name":"创建人姓名","type":"text","url":"","value":"多少份"},{"description":"","dicname":"","fieldName":"last_up_date","handle":"","hidden":true,"name":"最后修改日期","type":"text","url":"","value":"斯蒂芬"},{"description":"","dicname":"","fieldName":"last_up_time","handle":"","hidden":true,"name":"最后修改时间","type":"date","url":"","value":"发的"},{"description":"","dicname":"","fieldName":"last_up_name","handle":"","hidden":true,"name":"最后操作员","type":"text","url":"","value":"发生的"}]}';
			//var jsonString='[{"description":"","dicname":"","fieldName":"processModelOneID","handle":"","hidden":false,"name":"模式一编号,信贷业务编号","type":"text","url":"","value":11},{"description":"","dicname":"","fieldName":"flow_Id","handle":"","hidden":false,"name":"流程ID","type":"text","url":"","value":1},{"description":"","dicname":"","fieldName":"orgCodeOne","handle":"","hidden":true,"name":"受理支行（一级选项）","type":"text","url":"","value":"11"},{"description":"","dicname":"","fieldName":"orgCodeTwo","handle":"","hidden":true,"name":"受理支行（二级选项）","type":"text","url":"","value":"2"},{"description":"","dicname":"","fieldName":"creator","handle":"","hidden":true,"name":"主调信贷员","type":"text","url":"","value":"2"},{"description":"","dicname":"","fieldName":"fdxdy","handle":"","hidden":true,"name":"辅调信贷员","type":"text","url":"","value":"3"},{"description":"","dicname":"","fieldName":"yxzg","handle":"","hidden":true,"name":"营业主管","type":"text","url":"","value":"4"},{"description":"","dicname":"","fieldName":"yxry","handle":"","hidden":true,"name":"营销人员","type":"text","url":"","value":"6"},{"description":"","dicname":"","fieldName":"currency","handle":"","hidden":true,"name":"申请币别","type":"text","url":"","value":"5"},{"description":"","dicname":"","fieldName":"apply_bal","handle":"","hidden":true,"name":"申请金额","type":"text","url":"","value":"2"},{"description":"","dicname":"","fieldName":"oneCategory","handle":"","hidden":true,"name":"一级分类","type":"text","url":"","value":"rer"},{"description":"","dicname":"","fieldName":"loanCategory","handle":"","hidden":true,"name":"贷种分类","type":"text","url":"","value":"rere"},{"description":"","dicname":"","fieldName":"dywx_Name","handle":"","hidden":true,"name":"抵押物权属人姓名","type":"text","url":"","value":"rer"},{"description":"","dicname":"","fieldName":"coOrganization","handle":"","hidden":true,"name":"合作机构","type":"text","url":"","value":"房顶上的"},{"description":"","dicname":"","fieldName":"survey_Time","handle":"","hidden":true,"name":"调查时间","type":"text","url":"","value":"234"},{"description":"","dicname":"","fieldName":"content","handle":"","hidden":true,"name":"超限说明","type":"text","url":"","value":"防守对方"},{"description":"","dicname":"","fieldName":"cust_Name","handle":"","hidden":true,"name":"客户名称","type":"text","url":"","value":"防守对方说"},{"description":"","dicname":"","fieldName":"create_Date","handle":"","hidden":true,"name":"创建日期","type":"text","url":"","value":"发生的"},{"description":"","dicname":"","fieldName":"create_time","handle":"","hidden":true,"name":"创建时间","type":"text","url":"","value":"防守对方"},{"description":"","dicname":"","fieldName":"create_name","handle":"","hidden":true,"name":"创建人姓名","type":"text","url":"","value":"辅导费"},{"description":"","dicname":"","fieldName":"last_up_date","handle":"","hidden":true,"name":"最后修改日期","type":"text","url":"","value":"辅导费"},{"description":"","dicname":"","fieldName":"last_up_time","handle":"","hidden":true,"name":"最后修改时间","type":"text","url":"","value":"辅导费"},{"description":"","dicname":"","fieldName":"last_up_name","handle":"","hidden":true,"name":"最后操作员","type":"text","url":"","value":"发的"}],[{"description":"","dicname":"","fieldName":"processModelOneID","handle":"","hidden":false,"name":"模式一编号,信贷业务编号","type":"text","url":"","value":22},{"description":"","dicname":"","fieldName":"flow_Id","handle":"","hidden":false,"name":"流程ID","type":"text","url":"","value":1},{"description":"","dicname":"","fieldName":"orgCodeOne","handle":"","hidden":true,"name":"受理支行（一级选项）","type":"text","url":"","value":"2"},{"description":"","dicname":"","fieldName":"orgCodeTwo","handle":"","hidden":true,"name":"受理支行（二级选项）","type":"text","url":"","value":"2"},{"description":"","dicname":"","fieldName":"creator","handle":"","hidden":true,"name":"主调信贷员","type":"text","url":"","value":"3"},{"description":"","dicname":"","fieldName":"fdxdy","handle":"","hidden":true,"name":"辅调信贷员","type":"text","url":"","value":"4"},{"description":"","dicname":"","fieldName":"yxzg","handle":"","hidden":true,"name":"营业主管","type":"text","url":"","value":"是否"},{"description":"","dicname":"","fieldName":"yxry","handle":"","hidden":true,"name":"营销人员","type":"text","url":"","value":"所属"},{"description":"","dicname":"","fieldName":"currency","handle":"","hidden":true,"name":"申请币别","type":"text","url":"","value":"淡定"},{"description":"","dicname":"","fieldName":"apply_bal","handle":"","hidden":true,"name":"申请金额","type":"text","url":"","value":"淡定"},{"description":"","dicname":"","fieldName":"oneCategory","handle":"","hidden":true,"name":"一级分类","type":"text","url":"","value":"方法"},{"description":"","dicname":"","fieldName":"loanCategory","handle":"","hidden":true,"name":"贷种分类","type":"text","url":"","value":"刚刚"},{"description":"","dicname":"","fieldName":"dywx_Name","handle":"","hidden":true,"name":"抵押物权属人姓名","type":"text","url":"","value":"呵呵"},{"description":"","dicname":"","fieldName":"coOrganization","handle":"","hidden":true,"name":"合作机构","type":"text","url":"","value":"阿萨德"},{"description":"","dicname":"","fieldName":"survey_Time","handle":"","hidden":true,"name":"调查时间","type":"text","url":"","value":"斯蒂芬"},{"description":"","dicname":"","fieldName":"content","handle":"","hidden":true,"name":"超限说明","type":"text","url":"","value":"斯蒂芬"},{"description":"","dicname":"","fieldName":"cust_Name","handle":"","hidden":true,"name":"客户名称","type":"text","url":"","value":"斯蒂芬"},{"description":"","dicname":"","fieldName":"create_Date","handle":"","hidden":true,"name":"创建日期","type":"text","url":"","value":"阿达"},{"description":"","dicname":"","fieldName":"create_time","handle":"","hidden":true,"name":"创建时间","type":"text","url":"","value":"洒"},{"description":"","dicname":"","fieldName":"create_name","handle":"","hidden":true,"name":"创建人姓名","type":"text","url":"","value":"多少份"},{"description":"","dicname":"","fieldName":"last_up_date","handle":"","hidden":true,"name":"最后修改日期","type":"text","url":"","value":"斯蒂芬"},{"description":"","dicname":"","fieldName":"last_up_time","handle":"","hidden":true,"name":"最后修改时间","type":"text","url":"","value":"发的"},{"description":"","dicname":"","fieldName":"last_up_name","handle":"","hidden":true,"name":"最后操作员","type":"text","url":"","value":"发生的"}]';
			//var jsonString='';
			if (jsonString==""){
				$("#showpanel").hide();
				}
			else{
				var dataObj=eval("("+jsonString+")");
				$.each(dataObj,function(key,value){
					showpanelhtml=showpanelhtml+'<table align="center" border="0" width="100%" class="form_table">';
		           var index=0;
		           $.each(value, function(i, item) {
				       if(item.hidden==true){
					       //alert(item.name);
				           if(index%2==0){
				        	   if(item.type=='text'){
				        		  // showpanel.append("<tr>");
				        		   //showpanel.append("<td class='form_label' align='right' style='width:20%;'>"+item.name+"："+ "</td><td style='width:30%'>"+item.value+ "</td>");
				        		  	 showpanelhtml=showpanelhtml+"<tr><td class='form_label' align='right' style='width:20%;'>"+item.name+"："+ "</td><td style='width:30%'>"+item.value+ "</td>";
				        		   //showpanelhtml=showpanelhtml+'<tr><td class="form_label" align="right" style="width:20%">'+item.name+'：'+'</td><td style="width:30%">'+item.value+'</td>';
				        		   //alert(item.name+':'+index);
				        		   index=index+1;
				   				}else if(item.type=='dic'){
					   				//alert(item.value);
					   				//$("#showdiv").append("<d:write property="+item.value+" dictTypeId='ABF_FILE_SAVE'>");
									//alert($("#showdiv").html());
				   					showpanelhtml=showpanelhtml+"<tr><td class='form_label' align='right' style='width:20%;'>"+item.name+"："+ 
				   					"</td><td style='width:30%'> <d:write property="+item.value+" dictTypeId='ABF_FILE_SAVE'></d:write></td>";
				   				 //alert(item.name+':'+index);
				   					index=index+1;
					   				}else if (item.type=='date'){
					   					showpanelhtml=showpanelhtml+"<tr><td class='form_label' align='right' style='width:20%;'>"+item.name+"："+ "</td><td style='width:30%'>"+item.value+ "</td>";
					   					//showpanelhtml=showpanelhtml+'<tr><td class="form_label" align="right" style="width:20%;">'+item.name+'：'+ '</td><td style="width:30%"> '+item.value+'</td>';
					   				 //alert(item.name+':'+index);
					   					index=index+1;
						   				}
					           }else{
					        	   if(item.type=='text'){
					        		   showpanelhtml=showpanelhtml+"<td class='form_label' align='right' style='width:20%;'>"+item.name+"："+ "</td><td style='width:30%'>"+item.value+"</td></tr>";
					        		   //showpanelhtml=showpanelhtml+'<td class="form_label" align="right" style="width:20%;">'+item.name+'：'+'</td><td style="width:30%">'+item.value+'</td></tr>';
					        		  //alert(item.name+':'+index);
					        		   index=index+1;
					   				}else if(item.type=='dic'){

						   				showpanelhtml=showpanelhtml+"<td class='form_label' align='right' style='width:20%;'>"+item.name+"："+ 
					   					"</td><td style='width:30%'> <d:write property="+item.value+  "dictTypeId='ABF_FILE_SAVE'/></td></tr>";
					   					//showpanelhtml=showpanelhtml+'<td class="form_label" align="right" style="width:20%;">'+item.name+'：'+ '</td><td style="width:30%">'+'<d:write value="'+item.value+'" dictTypeId="ABF_FILE_SAVE"/>'+'</td></tr>';
					   					// alert(item.name+':'+index);
					   					index=index+1;
						   				}else if (item.type=='date'){
						   					showpanelhtml=showpanelhtml+"<td class='form_label' align='right' style='width:20%;'>"+item.name+"："+ "</td><td style='width:30%'>"+item.value+ "</td></tr>";
						   					//alert(item.type+':'+index);
						   					//showpanelhtml=showpanelhtml+'<td class="form_label" align="right" style="width:20%;">'+item.name+'：'+ '</td><td style="width:30%">'+item.value+'</td></tr>';
						   					index=index+1;
							   				 //alert(item.name+':'+index);
						           }
					           }
					           }
		           });
		           showpanelhtml=showpanelhtml+'</table>';

		           });
		        //解析数组
				//showpanel.append(showpanelhtml);
					//alert(showpanelhtml);
					showpanel.html(showpanelhtml);
			}
			}
 </script>
</html>