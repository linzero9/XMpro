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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h:form name="form1" id="form1" action=" "  method="post" enctype="multipart/form-data" >
    <table align="center" border="0" width="100%" class="form_table" >
       <tr id="row1">
      <td class="form_label" align="right">附件下载：</td>
      <td colspan="3">
      <div id="tag"></div>
      </td>
    </table>
     </h:form>
  </body>
  <script type="text/javascript">
  $(document).ready(function(){

		 $.ajax({
		        url: '/modeFile/tModelFileAction_selectFiletest.action',
		        async: false,
		        type: 'post',
		        data: "executionId=1111555506fhf.1080013&modeId=11115555&modeType=mod1",
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
			        }else{
			        	$("#row1").css("display","none");  
			        }
		        }
	    });	

	  });
  </script>
  
</html>
