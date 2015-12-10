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
   <%--  <h:form name="appQuery"	action="/jbpm/tProcessConfigAction_queryMyProcessList.action" method="post">
		<w:panel id="panel1" title="我的流程">
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
					<td class="form_label" align="right" width="20%">流程名称：</td>
					<td colspan="1"  width="30%"><h:text id="processName" property="processConfig.processName" /></td>
				</tr>
				<tr class="form_bottom">
						<td colspan="4" class="form_bottom">
							每页显示
							<h:text size="2" property="page.length" value="10"
								validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
							<input type="hidden" name="page.begin" value="0">
							<input type="hidden" name="page.isCount" value="true">
							<input type="submit" id="btn" class="button" value='查询'>
						</td>
					</tr>				
			</table>
		</w:panel>
	</h:form> --%>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="查询结果">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
					<table>
						<tr>
						<td>
							<d:checkbox perrow="3" id="oneCategory"    name="generalprocessDto.oneCategory" dictTypeId="PROCESS_onecategory" property="generalprocessDto.oneCategory"  seperator=","  />
						</td>
						</tr>
						<tr>
						<td align="center">
						<input type="button" class="button" value="选择" onclick="returnValue();"/>
						</td>
						</tr>
					</table>
					<div class="h3"> 
						
					</div>
				</viewlist>
			</w:panel>		
		</DIV>
  </body>
  <script type="text/javascript">
  function returnValue(){
	  /* var gop = $id("group1");
		var len = gop.getSelectLength();
		if(len == 0){
			alert("请选择一条流程信息");
			return;
		}else{
			var rows=gop.getSelectRow();
	  		var firstClass=rows.getParam("firstClass");
	  		window.returnValue=firstClass;
	  		window.close();
		} */
		var oneCategory="";
		var oneCategoryTxt="";
        var  plugInLength  =  $("input[name='generalprocessDto.oneCategory']:checkbox:checked").length;
        $("input[name='generalprocessDto.oneCategory']:checkbox:checked").each(function(i,value){ 
            if($(this).attr("checked")){
                if((i+1)==plugInLength){
                	oneCategory += $(this).val();
                }else{
                	oneCategory += $(this).val()+", ";
            	}
                if((i+1)==plugInLength){
                	oneCategoryTxt += $(this).next('label').text();
                }else{ 
                	oneCategoryTxt += $(this).next('label').text()+", ";
            	}
            }
        });
        var rvalue=oneCategory+":"+oneCategoryTxt;
        window.returnValue=rvalue;
  		window.close();
	  }
  </script>
</html>
