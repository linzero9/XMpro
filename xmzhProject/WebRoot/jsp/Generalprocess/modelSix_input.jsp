<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<%@page import="java.util.*"%>



<h:css href="/css/style1/style-custom.css" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/fileDown.css">
<script type="text/javascript" src="/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript" src="/js/modeFileDown.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>
<title>节点模式六，办理抵押、发起支用</title>
</head>
<body>
	<h:form name="form1" id="form1" action="" method="post"
		enctype="multipart/form-data" >
		<div id="content">
			<h:hidden id="createor" />
			<h:hidden id="executionId" property="taskAssgineeDto.executionId" />
			<h:hidden id="taskId" property="taskAssgineeDto.nextTaskId" />
			<h:hidden id="taskAssingee" property="taskAssgineeDto.taskAssingee" />
			<h:hidden id="definitionId" property="taskAssgineeDto.definitionId" />
			<h:hidden id="businessType" property="taskAssgineeDto.businessType" />
			<h:hidden id="processName" property="taskAssgineeDto.processName" />
			<h:hidden id="templateFileIds"
				property="taskAssgineeDto.templateFileIds" />
			<h:hidden id="isC" name="isC" property="taskAssgineeDto/isC" />
			<h:hidden id="isStrat" name="isStrat" property="isStrat" />
			
				<h:hidden id="startFlag" name="taskAssgineeDto.startFlag" property="taskAssgineeDto.startFlag" />
			<h:hidden id="btnType" name="taskAssgineeDto.btnType" />
			<h:hidden name="taskAssgineeDto.isFirst" value="1" />

			<h:hidden id="processModelId" name="modelSix.processModelId"
				property="modelSix.processModelId" />
			<h:hidden id="taskName" name="modelSix.taskName"
				property="modelSix.taskName" />
			<h:hidden id="flowId" name="modelSix.flow_Id"
				property="modelSix.flow_Id" />

			<h:hidden id="beginAssingee" name="taskAssgineeDto.beginAssingee" property="taskAssgineeDto.beginAssingee"/>
			<h:hidden id="beginOrg" name="taskAssgineeDto.beginOrg" property="taskAssgineeDto.beginOrg"/>
		 	<h:hidden property="modelSix.loanCategory" name="modelSix.loanCategory" id="loanCategory" />
		 	<h:hidden property="modelSix.oneCategory" name="modelSix.oneCategory" id="oneCategory" />
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
					<td colspan="4"
						style="text-align: center;font-weight:bold;font-size:12pt;height:50px;background-color: rgb(145, 186, 221);">
						${taskName }</td>
				</tr>
				
				
				<tr>
	
			
					
				<td class="form_label" align="right" style="width:20%;" >客户姓名
				</td>
					<td colspan="1"><h:text id="custName"
							property="modelSix.custName"  />		<font id="custName_msg"  style="color: red">*</font>
					</td>
							<td class="form_label" align="right" style="width:20%;" >
							是否抵押
					</td>
					<td  colspan="3">
					<div id="ismortgage" >
						<label><input name="Fruit" type="radio" value="1" />是</label> 
                        <label><input name="Fruit" type="radio" value="2" />否 </label> 
                        </div>
                        <h:hidden name="modelSix.yesOrNotRisk" property="modelSix.yesOrNotRisk" id="yesOrNotRisk"/>
                       <%--  <d:radio dictTypeId="PROCESS_sixyesnot" name="modelSix.yesOrNotRisk" property="modelSix.yesOrNotRisk" id="ismortgage" /> --%>
					</td>
					
					
					
				
				
					
				</tr>
				
				
				<tr>
					<td class="form_label" align="right"   style="width:20%;" >抵押送件时间</td>
					<td colspan="1">
					
				
							
							
							   <w:date  id="mortgageTime" submitFormat="yyyy-MM-dd" format="yyyy-MM-dd"  property="modelSix.mortgageTime"/><font  id="mortgageTime_msg" style="color: red">*</font>
							</td>
					<td class="form_label" align="right" style="width:20%;" >收到他项/回执时间</td>
					<td colspan="3">
							
							
														   <w:date  id="receiveTime" submitFormat="yyyy-MM-dd" format="yyyy-MM-dd"  property="modelSix.receiveTime"/><font   id="receiveTime_msg"  style="color: red">*</font>
							
							
							
							</td>
				</tr>
				<tr>
					<td class="form_label" align="right" style="width:20%;" >
						公积金中心申请时间</td>
					<td colspan="1">
					
					
							
							
<w:date  id="applicationTime" submitFormat="yyyy-MM-dd" format="yyyy-MM-dd" property="modelSix.applicationTime"/></td>
					<td class="form_label" align="right"  style="width:20%;" >
						公积金中心下达放款指标时间</td>
					<td colspan="1">
					
			
							
	<w:date  id="issuedTime" submitFormat="yyyy-MM-dd" format="yyyy-MM-dd"  property="modelSix.issuedTime"/>
							
							
							</td>
				</tr>
				<tr id='notmodelOne'>
					<td class="form_label" align="right" style="width:20%;">
			                                                 一级分类：
			        </td>
			        <td>
			        	<h:text  id="oneCategory1"  readonly="true"  property=""/>
			        </td>
					<td class="form_label" align="right" style="width:20%;">
			                                                 贷种分类：
			        </td>
			        <td>
			        	<h:text  id="loanCategory1"  readonly="true"/>
			        </td>
			        </tr>
				<tr id='havemodelOne'>
			        <td class="form_label" align="right" style="width:20%;">
			                                                 一级分类：
			        </td>
			        <td colspan="1">
			        <select id="oneCategorys" onchange="changeoneCategory()"     >
			         </select> 
			        <%--  <h:hidden id="oneCategory2" /> --%>
			         <font style="color: red">*</font>	
			        </td>
			        <td class="form_label" align="right" style="width:20%;">
			                                                   贷种分类：
			        </td>
			        <td colspan="1">
			         <%-- <h:text property="modelOne.loanCategory" id="loanCategory" validateAttr="allowNull=false" style="width:130px;" /> --%>
			         <select    id="loanCategorys" onchange="changeloanCategory()" >
			         </select> 
			        <%-- <h:hidden id="loanCategory2" /> --%>
			         <font style="color: red">*</font>	
			        </td>
			      	</tr>
				
				<tr>
					<td class="form_label" align="right" style="width:20%;" >
						支用类别</td>
					<td colspan="1">
							
						
						
						<select  id="supportCategory"   name="modelSix.supportCategory">
						
			
						
									<l:iterate id="cate" property="supportCategory">
							
							
										<option value="${cate.dickid_id }">
										
										${ cate.dictname}
																				
										</option>
							
							
							</l:iterate>
						
						
						
						</select>
						
				
							
										</td>
							<td class="form_label" align="right" style="width:20%;" >
							是否风险额度重检
					</td>
					<td  colspan="3">
							<d:select  id="risk"  dictTypeId="PROCESS_QuotaCheck" property="modelSix.risk"  nullLabel="请选择"></d:select>
					</td>
		
				</tr>
				
				     <tr>
     	<td class="form_label" align="right" style="width:20%;" >支用金额币别</td>
      	<td colspan="1" style="width:30%">
        	<d:select id="supportMoneyType" property="modelSix.supportMoneyType" dictTypeId="PROCESS_MONEY"   nullLabel="请选择"></d:select>
      	</td>
     	<td class="form_label" align="right" style="width:20%;">支用金额</td>
     	<td colspan="1" style="width:30%">
        	<h:text id="supportMoney" property="modelSix.supportMoney"   validateAttr="type=float"/>元
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
					<td class="form_label" align="right">处理意见</td>
					<td colspan="3"><h:textarea
							property="modelSix.processingOpinion" id="hanldOption"
							extAttr="class='h80' "
							validateAttr="maxLength=512;allowNull=ture" rows="4"
							style="width:90%;" /></td>
				</tr>
				    <tr id="rowFile">
      
				<table border=0 id="tabtest1"   width="100%">
				</table>
     	</td>
     </tr>
				 <%@include file="/jsp/util/default_gp_opinionUtil.jsp" %>
				<tr class="form_bottom">
					<td colspan="4"> <input type="button" value="保存"
						class="button" id="save1" onclick="doSave(1);" /> <input
						type="button" value="提交" onclick="doSave(2);" class="button"
						id="smit" /> <input type="button" value="查看流程"
						onclick="doflowpic();" class="button" id="flowpic" /></td>
				</tr>
				<tr id="row2">
					<td class="form_label" align="right">流 程 列 表</td>
					<td colspan="3"><%@include
							file="/jsp/util/opinionUtil_generalProcess.jsp"%>
					</td>
				</tr>
				<div id='showdiv'></div>
			</table>
		</div>
	</h:form>
</body>
<script type="text/javascript">


function saveRectification(mistakeId,rowId){

	var rectification = $("#rectification"+rowId).val();
	if(rectification==null & rectification==""){alert("请输入整改情况!")}
	$.ajax({//获得当前
		        url: "/Generalprocess/tGeneralprocessModelSixAction_updateProcessMistake.action",
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
	 url : "/Generalprocess/tGeneralprocessModelSixAction_querySubmitter.action",
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
			
			url : "/Generalprocess/tGeneralprocessModelSixAction_queryProcessMistake.action",
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





$(function(){


	 $("#processingOpinion").text("");



	if($("#custName").val()==""||$("#custName").val()==null){
	
		}else{
			$("#custName").attr("readonly",true);
			}
	if('${modelSix.processModelId}'!=""){
		 $.ajax({
		        url: '/modeFile/tModelFileAction_selectFiletest.action',
		        async: false,
		        type: 'post',
		        data: "executionId=${taskAssgineeDto.executionId}&modeId=${modelSix.processModelId}&modeType=mod6",
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
    } 

	
	if('${isView}'!=''){
		$("#save1").hide();
		$("#smit").hide();
	}
	if('${isStrat}'==0){
		$("#notmodelOne").hide();
		setOneSelect('${taskAssgineeDto.processName}');
		 if('${modelSix.oneCategory}'!=""){
			 $("#oneCategory").val('${modelSix.oneCategory}');
			 var oneCategory='${modelSix.oneCategory}';
			 setLcselect(oneCategory);
		 }
		}else{
			$("#havemodelOne").hide();
			$("#oneCategory1").val('${modelSix.oneCategory}');
			$("#loanCategory1").val('${modelSix.loanCategory}');
			}
	var ismortgage='${modelSix.yesOrNotRisk}';
	if(ismortgage==null||ismortgage==""||ismortgage=="2"){
		$("#ismortgage input[type='radio']").get(1).checked = true;
		}else{
			$("#ismortgage input[type='radio']").get(0).checked = true;
			}
	
});
	show('${taskAssgineeDto.fxJson}');


	/**
	 * 查询流程列表
	 */
	function initPlanCell20() {
		var queryCond = "";
		queryCond += "<flowId>${taskAssgineeDto.executionId}</flowId>";
		return queryCond;
	}

	//value 为1		保存
	//value 为2 	提交
	function doSave(value) {
		$("#btnType").val(value);
		$("#yesOrNotRisk").val($("#ismortgage input[type='radio']:checked").val());
		if('${isStrat}'!=0){
			$("#oneCategory").val($("#oneCategory1").val());
			$("#loanCategory").val($("#loanCategory1").val());
			}
		if (value != "1") {
			if (checkForm($id("form1"))) {
			

				var flag={"mortgageTime":true,"custName":true,"receiveTime":true};
		

	    	     var mortgageTime= $("#mortgageTime_input").val();
	    	     var custName= $("#custName").val();
	    	     var receiveTime= $("#receiveTime_input").val();


	    	     if($("#ismortgage input[type='radio']:checked").val()==1){
		    

	    	     if(mortgageTime==null||mortgageTime==""||mortgageTime==undefined){
		    	     $("#mortgageTime_msg").text("该项为必输！");
		    	  
		    	     flag.mortgageTime=false;
		   
		    	     }
	    	 
	    	     if(custName==null||custName==""||custName==undefined){
		    	     $("#custName_msg").text("该项为必输！");
		    	     

		    	     flag.custName=false;
		    	     } 
	    	     if(receiveTime==null||receiveTime==""||receiveTime==undefined){
		    	     $("#receiveTime_msg").text("该项为必输！");
		    	     flag.receiveTime=false;
		    	     }

	    	//     alert($("#ismortgage input[type='radio']:checked").val());

	    	  
	    	     
	    	     }else{
	        	     if(custName==null||custName==""||custName==undefined){
			    	     $("#custName_msg").text("该项为必输！");
			    	     

			    	     flag.custName=false;
			    	     } 
		    	     
		    	     }

	    	     if( flag.mortgageTime==true&&flag.custName==true&&   flag.receiveTime==true){
		    	     
		    	     
	    	     

				
				var strUrl = "/jbpm/jbpmDemoAction_toNextTaskConfig.action?taskAssgineeDto.executionId="
						+ $id("executionId").value
						+ "&taskAssgineeDto.definitionId=${taskAssgineeDto.definitionId}";
				strUrl+="&taskAssgineeDto.beginOrg="+$id("beginOrg").value+"&taskAssgineeDto.beginAssingee="+$id("beginAssingee").value;


				
				showModalCenter(strUrl, null, taskAssigneeCallBack, 700, 400,
						'节点选择');
	    	     };
			};
		} else {


			
			var _form = $id("form1");
			url = "/Generalprocess/tGeneralprocessModelSixAction_handleModelSix.action";
			_form.action = url
			if (checkForm($id("form1")))
				ajaxsubmitO(0);
		}
	}

	function taskAssigneeCallBack(arg) {
		var _form = $id("form1");
		if (arg != "") {
			url = "/Generalprocess/tGeneralprocessModelSixAction_handleModelSix.action?"
					+ arg;
			_form.action = url;
	



			
			// 异步提交请求 
			ajaxsubmitO(1);
		}
	}

	function ajaxsubmitO(flag) {
		maskTop();
		var options = {
			type : "post",
			cache : "false",
			success : function(data) {
				try {
					if (data.indexOf("success") >= 0) {
						alert("操作成功!")
						unMaskTop();
						
							WEB.turnMainFrame();
					} else if (data.indexOf("fails") >= 0) {
						unMaskTop();
						alert("操作失败!");
					} else {
						unMaskTop();
						alert("操作失败!");
					}
				} catch (Exception) {
				}
			},
			error : function(data) {
				unMaskTop();
				alert("添加失败请联系管理员！");
			}
		};
		$("#form1").ajaxSubmit(options);
	}

	function changeloanCategory(){
		$("#loanCategory").val($('#loanCategorys option:selected').val());
		}	
	function changeoneCategory(){
		$("#oneCategory").val($('#oneCategorys option:selected').val());
		 setLcselect($("#oneCategory").val());
		}	
	function setLcselect(arg){
		$("#loanCategorys").html("");
		var processName='${taskAssgineeDto.processName}';
		var selecthtml=$("#loanCategorys").html();
		 $.ajax({
		        url: "/Generalprocess/tGeneralprocessCdtypeAction_querycreditType.action?cdtype.firstClass="+encodeURI(arg)+"&cdtype.processName="+encodeURI(processName),
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
	
	function delTr(id){
		$("#"+id).remove();
	}
	
</script>
</html>