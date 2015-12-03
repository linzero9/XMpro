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
		enctype="multipart/form-data" onsubmit="return checkForm(this);">
		<div id="content">
			<h:hidden id="createor" />
			<h:hidden id="executionId" property="taskAssgineeDto.executionId" />
			<h:hidden id="taskId" property="taskAssgineeDto.nextTaskId" />
			<h:hidden id="taskAssingee" property="taskAssgineeDto.taskAssingee" />
			<h:hidden id="beginOrg" property="taskAssgineeDto.beginOrg" />
			<h:hidden id="definitionId" property="taskAssgineeDto.definitionId" />
			<h:hidden id="businessType" property="taskAssgineeDto.businessType" />
			<h:hidden id="processName" property="taskAssgineeDto.processName" />
			<h:hidden id="templateFileIds"
				property="taskAssgineeDto.templateFileIds" />
			<h:hidden id="isC" name="isC" property="taskAssgineeDto/isC" />
			<h:hidden id="btnType" name="taskAssgineeDto.btnType" />
			<h:hidden name="taskAssgineeDto.isFirst" value="1" />

			<h:hidden id="processModelId" name="modelOne.processModelId"
				property="modelOne.processModelId" />
			<h:hidden id="taskName" name="modelOne.taskName"
				property="modelOne.taskName" />
			<h:hidden id="flowId" name="modelOne.flow_Id"
				property="modelOne.flow_Id" />

			<table align="center" border="0" width="100%" class="form_table">
				<tr>
					<td colspan="4"
						style="text-align: center;font-weight:bold;font-size:12pt;height:50px">
						${taskName }</td>
				</tr>
				<tr>
					<td class="form_label" align="right" style="width:120px;">抵押送件时间</td>
					<td colspan="1"><h:text property="modelSix.mortgageTime"
							id="mortgageTime" validateAttr="allowNull=false"
							style="width:130px;" /></td>
					<td class="form_label" align="right" style="width:120px;">收到他项时间</td>
					<td colspan="3"><h:text id="receiveTime"
							property="modelSix.receiveTime" /></td>
				</tr>
				<tr>
					<td class="form_label" align="right" style="width:120px;">
						公积金中心申请时间：</td>
					<td colspan="1"><h:text property="modelSix.applicationTime"
							id="applicationTime" validateAttr="allowNull=false"
							style="width:130px;" /><font style="color: red">*</font></td>
					<td class="form_label" align="right" style="width:120px;">
						公积金中心下达放款指标时间：</td>
					<td colspan="1"><h:text property="modelSix.issuedTime"
							id="issuedTime" validateAttr="allowNull=false"
							style="width:130px;" /><font style="color: red">*</font></td>
				</tr>
				<tr>
					<td class="form_label" align="right" style="width:120px;">
						支用类别：</td>
					<td colspan="1"><h:text property="modelSix.supportCategory"
							id="supportCategory" validateAttr="allowNull=false"
							style="width:130px;" /><font style="color: red">*</font></td>
					<td class="form_label" align="right" style="width:120px;">
						支用金额：</td>
					<td colspan="1"><h:text property="modelSix.supportMoney"
							id="supportMoney" validateAttr="allowNull=ture"
							style="width:130px;" /></td>
				</tr>
				<tr>
					<td class="form_label" align="right" style="width:120px;">是否风险额度重检：</td>
					<td><h:text property="modelSix.risk" id="risk"
							validateAttr="allowNull=false" style="width:130px;" /> <font
						style="color: red;">*</font></td>
				</tr>



				<tr>
					<td class="form_label" align="right">处理意见：</td>
					<td colspan="3"><h:textarea
							property="modelSix.processingOpinion" id="processingOpinion"
							extAttr="class='h80' "
							validateAttr="maxLength=512;allowNull=ture" rows="4"
							style="width:90%;" /></td>
				</tr>
				<tr class="form_bottom">
					<td colspan="4"><input type="button" value="结束流程"
						class="button"
						onclick="doDeleteProcess('<b:write property="modelOne/processModelId" />','<b:write property="taskAssgineeDto/businessType" />');"
						id="deleteProcessBtn"> <input type="button" value="保存"
						class="button" id="save1" onclick="doSave(1);" /> <input
						type="button" value="提交" onclick="doSave(2);" class="button"
						id="smit" /> <input type="button" value="查看流程"
						onclick="doflowpic();" class="button" id="flowpic" /></td>
				</tr>
				<tr id="row2">
					<td class="form_label" align="right">流 程 列 表：</td>
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
	show('${taskAssgineeDto.fxJson}');
	$(document)
			.ready(
					function() {



							});

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
				var strUrl = "/jbpm/jbpmDemoAction_toNextTaskConfig.action?taskAssgineeDto.executionId="
						+ $id("executionId").value
						+ "&taskAssgineeDto.beginOrg="
						+ $("#beginOrg").val()
						+ "&taskAssgineeDto.beginAssingee="
						+ $("#createor").val()
						+ "&taskAssgineeDto.definitionId=${taskAssgineeDto.definitionId}";
				showModalCenter(strUrl, null, taskAssigneeCallBack, 700, 400,
						'节点选择');
			}
		} else {
			var _form = $id("form1");
			alert(111);
			url = "/Generalprocess/tGeneralprocessModelsixAction_handleModelSix.action";
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
			_form.action = url
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
						if (flag == 1)
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