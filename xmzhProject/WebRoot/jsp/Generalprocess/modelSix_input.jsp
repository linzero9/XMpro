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
<script type="text/javascript" src="/js/fileDown.js"></script>
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
			
			<h:hidden id="yesOrNotRisk" name="modelSix.yesOrNotRisk" property="taskAssgineeDto.beginOrg"/>
			
			
		
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
					<div id="ismortgage">
						<label><input name="Fruit" type="radio" value="1"    />是</label> 
                        <label><input name="Fruit" type="radio" value="2"  checked/>否 </label> 
                        </div>
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
				



				<tr>
					<td class="form_label" align="right">处理意见</td>
					<td colspan="3"><h:textarea
							property="modelSix.processingOpinion" id="hanldOption"
							extAttr="class='h80' "
							validateAttr="maxLength=512;allowNull=ture" rows="4"
							style="width:90%;" /></td>
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

$(function(){


	 $("#processingOpinion").text("");



	if($("#custName").val()==""||$("#custName").val()==null){
	
		}else{
			$("#custName").attr("readonly",true);
			}

	if('${isView}'!=''){
		$("#save1").hide();
		$("#smit").hide();
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
		    	     
		    	    //把是否抵押    放入到隐藏域中 传到后台
		    	    
		    	    var  yesOrNotRisk = $("#ismortgage input[type='radio']:checked").val();

		    	    
		    	    
		    	    $("#yesOrNotRisk").val(yesOrNotRisk);
	    	     

				
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


</script>
</html>