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
        
        <h:hidden id="btnType" name="taskAssgineeDto.btnType" property="taskAssgineeDto.btnType"/>
         
        <h:hidden id="processModelId" name="modelFive.processModelId" property="modelFive.processModelId"/>
		<h:hidden id="taskName" name="modelFive.taskName" property="modelFive.taskName"/>
		
		<h:hidden id="beginAssingee" name="taskAssgineeDto.beginAssingee" property="taskAssgineeDto.beginAssingee"/>
		<h:hidden id="beginOrg" name="taskAssgineeDto.beginOrg" property="taskAssgineeDto.beginOrg"/>
		
		<table align="center" border="0" width="100%" class="form_table" >
      <tr>
         <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:50px;background-color: rgb(145, 186, 221);" >
        		 ${taskName}
        </td>
      </tr>
      
      <tr>
     	<td class="form_label" align="right" style="width:20%;" >决策单编号</td>
      	<td colspan="1" style="width:30%">
        	<h:text id="polNo" property="modelFive.polNo"   />
      	</td>
     	<td class="form_label" align="right">表决表编号</td>
     	<td colspan="1" style="width:30%">
        	<h:text id="voteNo" property="modelFive.voteNo" />
        </td>
      </tr>
      
      <tr>
     	<td class="form_label" align="right" style="width:20%;" >会议期数</td>
      	<td colspan="1" style="width:30%">
        	<h:text id="meetingCount" property="modelFive.meetingCount"   />
      	</td>
     	<td class="form_label" align="right" style="width:20%;">审批方式</td>
     	<td colspan="1" style="width:30%">
        	<d:select id="appWay" dictTypeId="PROCESS_method" property="modelFive.appWay"  nullLabel="请选择"></d:select>
        </td>
      </tr>
      
      <tr>
     	<td class="form_label" align="right" style="width:20%;" >审批岗审结时间</td>
      	<td colspan="1" style="width:30%">
        	<w:date id="appTime" submitFormat="yyyyMMdd" format="yyyy-MM-dd" property="modelFive.appTime"/>
      	</td>
     	<td class="form_label" align="right" >审议事项</td>
     	<td colspan="1" style="width:30%">
        	 <d:checkbox id="conMatter" dictTypeId="PROCESS_Consideration" property="modelFive.conMatter" />
        </td>
      </tr>
      
      <tr>
     	<td class="form_label" align="right" style="width:20%;" >授信部负责人签批时间</td>
      	<td colspan="1" style="width:30%">
        	<w:date id="sxAppTime" submitFormat="yyyyMMdd" format="yyyy-MM-dd" property="modelFive.sxAppTime"/>
      	</td>
     	<td class="form_label" align="right">有权审批人签批时间</td>
     	<td colspan="1" style="width:30%">
        	<w:date id="yqAppTime" submitFormat="yyyyMMdd" format="yyyy-MM-dd" property="modelFive.yqAppTime"/>
        </td>
      </tr>
    
    	<tr>
     	<td class="form_label" align="right" style="width:20%;" >第一审批人（会议审批委员）</td>
      	<td colspan="1" style="width:30%">
        	<h:text id="dyApp" property="modelFive.dyApp"/>
      	</td>
     	<td class="form_label" align="right">第二审批人（会议审批委员）</td>
     	<td colspan="1" style="width:30%">
        	<h:text id="deApp" property="modelFive.deApp"/>
        </td>
      </tr>
      
      <tr>
     	<td class="form_label" align="right" style="width:20%;" >会议审批委员一</td>
      	<td colspan="1" style="width:30%">
        	<h:text id="hyWyOne" property="modelFive.hyWyOne"/>
      	</td>
     	<td class="form_label" align="right">会议审批委员二</td>
     	<td colspan="1" style="width:30%">
        	<h:text id="hyWyTwo" property="modelFive.hyWyTwo"/>
        </td>
      </tr>
      
       <tr>
     	<td class="form_label" align="right" style="width:20%;" >会议审批主任委员</td>
      	<td colspan="1" style="width:30%">
        	<h:text id="hyZrName" property="modelFive.hyZrName"/>
      	</td>
     	<td class="form_label" align="right">有表决权人数</td>
     	<td colspan="1" style="width:30%">
        	<h:text id="ybjNum" property="modelFive.ybjNum"/>
        </td>
      </tr>
      
      <tr>
     	<td class="form_label" align="right" style="width:20%;" >贷审会秘书一</td>
      	<td colspan="1" style="width:30%">
        	<h:text id="dsMsOne" property="modelFive.dsMsOne"/>
      	</td>
     	<td class="form_label" align="right">贷审会秘书二</td>
     	<td colspan="1" style="width:30%">
        	<h:text id="dsMsTwo" property="modelFive.dsMsTwo"/>
        </td>
      </tr>
      
       <tr>
     	<td class="form_label" align="right" style="width:20%;" >风险类型</td>
      	<td colspan="1" style="width:30%">
        	<d:select id="fxType" dictTypeId="PROCESS_risk" property="modelFive.fxType"   nullLabel="请选择"></d:select>
      	</td>
     	<td class="form_label" align="right">审批类型</td>
     	<td colspan="1" style="width:30%">
        	<d:select id="spType" dictTypeId="PROCESS_approve" property="modelFive.spType"  nullLabel="请选择"></d:select>
        </td>
      </tr>
      
      <tr>
     	<td class="form_label" align="right" style="width:20%;" >上会地点</td>
      	<td colspan="1" style="width:30%">
        	<h:text id="shAddr" property="modelFive.shAddr"/>
      	</td>
     	<td class="form_label" align="right">会议审议结论</td>
     	<td colspan="1" style="width:30%">
        	<d:select id="hySyJl" dictTypeId="PROCESS_conclusion" property="modelFive.hySyJl"  nullLabel="请选择"></d:select>
        </td>
      </tr>
      
       <tr>
     	<td class="form_label" align="right" style="width:20%;" >评级结论</td>
      	<td colspan="1" style="width:30%">
        	<h:text id="pjJl" property="modelFive.pjJl"/>
      	</td>
      </tr>
      
      <tr>
     	<td class="form_label" align="right" style="width:20%;" >风险币别</td>
      	<td colspan="1" style="width:30%">
        	<d:select id="fxBb" property="modelFive.fxBb" dictTypeId="PROCESS_MONEY"  nullLabel="请选择"></d:select>
      	</td>
     	<td class="form_label" align="right">风险额度</td>
     	<td colspan="1" style="width:30%">
        	<h:text id="fxEd" property="modelFive.fxEd"/>元
        </td>
      </tr>
      
      <tr>
     	<td class="form_label" align="right" style="width:20%;" >授信币别</td>
      	<td colspan="1" style="width:30%">
        	<d:select id="sxBb" property="modelFive.sxBb" dictTypeId="PROCESS_MONEY"  nullLabel="请选择"></d:select>
      	</td>
     	<td class="form_label" align="right">授信额度</td>
     	<td colspan="1" style="width:30%">
        	<h:text id="sxEd" property="modelFive.sxEd"/>元
        </td>
      </tr>
      
       <tr>
     	<td class="form_label" align="right" style="width:20%;" >业务币别</td>
      	<td colspan="1" style="width:30%">
        	<d:select id="ywBb" property="modelFive.ywBb" dictTypeId="PROCESS_MONEY"  nullLabel="请选择"></d:select>
      	</td>
     	<td class="form_label" align="right" style="width:20%;">业务额度</td>
     	<td colspan="1" style="width:30%">
        	<h:text id="ywEd" property="modelFive.ywEd"/>元
        </td>
      </tr>
      
      
      <tr>
					<td class="form_label" align="right">处理意见</td>
					<td colspan="3"><h:textarea
							property="modelFive.optionNew" id="optionNew"
							extAttr="class='h80' "
							validateAttr="maxLength=512;allowNull=ture" rows="4"
							style="width:90%;" /></td>
				</tr>
      
      
      <tr class="form_bottom">
        <td colspan="4">
          <input type="button" value="保存" onclick="doSave(1);" class="button" id="save2" />
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
				 	$("#save2").hide();
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
    		}else{
    			var _form = $id("form1");
    	  	  	url="/Generalprocess/tGeneralprocessModelFiveAction_handleModelFive.action";	
    	  	  	_form.action =url
    	  	  	if(checkForm($id("form1")))
    			    ajaxsubmitO(0);
    		}
     	}
		function taskAssigneeCallBack(arg){
		  	 	var _form = $id("form1");
		  	 	if(arg!=""){
		  	  	 	url="/Generalprocess/tGeneralprocessModelFiveAction_handleModelFive.action?"+arg;	
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