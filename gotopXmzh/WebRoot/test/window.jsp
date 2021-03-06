<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String cbasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html style="height:100%;width:100%;">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="/common.jsp" %>
		<script type="text/javascript" src="<%=cbasePath%>/js/test/jquery.panel.js"></script>
		<script type="text/javascript" src="<%=cbasePath%>/js/test/jquery.window.js"></script>
		<title>jQuery EasyUI grid</title>
	<script>
		function resize(){
			jQuery('#w').window({
				title: 'New Title',
				width: 600,
				modal: true,
				shadow: false,
				closed: false,
				height: 300
			});
		}
		function open1(){
			jQuery('#w').window('open');
		}
		function close1(){
			jQuery('#w').window('close');
		}
		function test(){
			jQuery('#test').window('open');
		}
		
		jQuery(function(){
			var p = jQuery("#pnd");
			var dd="111";
			alert(p.html());
		})
		
	</script>
</head>
<body style="height:100%;width:100%;overflow:hidden;border:none;" >
	<p>Hello-----------</p><p id="pnd">2nd Paragraph</p>
	<h1>Window</h1>
	<div style="margin-bottom:10px">
		<a href="javascript:void(0)" onclick="resize()">resize</a>
		<a href="javascript:void(0)" onclick="open1()">open</a>
		<a href="javascript:void(0)" onclick="close1()">close</a>
	</div>
	<div style="position:relative;width:400px;height:400px;border:1px solid #ccc;overflow:auto;">
		<div class="easyui-window" title="Inline Window" inline="true" modal="true" style="width:250px;height:150px;padding:10px">
			This window stay inside its parent
		</div>
	</div>
	<div id="w" class="easyui-window" title="My Window" iconCls="icon-save" style="width:500px;height:200px;padding:5px;background: #fafafa;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">
				jQuery EasyUI framework help you build your web page easily.
				<br/><br/>
				click <a href="#" onclick="test()">here</a> to popup another window.
			</div>
			<div region="south" border="false" style="text-align:right;height:30px;line-height:30px;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:void(0)" onclick="resize()">Ok</a>
				<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="resize()">Cancel</a>
			</div>
		</div>
	</div>
	<div id="test" class="easyui-window" closed="true" modal="true" title="Test Window" style="width:300px;height:100px;"></div>
</body>
</html>