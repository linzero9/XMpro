<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/fileDown.css">
<script type="text/javascript" src="/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript" src="/js/fileDown.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>
<title>数据字典 设备型号选择</title>

  </head>
  <body>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="设备型号">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
					<table>
						 <h:hidden id="deviceJson" property="deviceJson" name="deviceJson"/>
						<tr>
						<td>
							<d:checkbox perrow="4" id="devicemodel"    name="deviceNameAndModel.devicemodel" dictTypeId="DEVICE_MODEL" property="deviceNameAndModel.devicemodel"  seperator=","  />
						</td>
						</tr>
						<tr>
						<td align="center">
						<input type="button" class="button" value="选择" onclick="returnValue();"/>
						<input type="button" class="button" value="全选" onclick="chooseall();"/>
						<input type="button" class="button" value="清空" onclick="clearall();"/>
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
  
			$(function() {
				//当页面加载完成的时候，自动调用该方法
				window.onload = function() {
					//获得所要回显的值，此处为：100,1001,200,1400
					var checkeds = $id("deviceJson").value;
					//拆分为字符串数组
					var checkArray = checkeds.split(", ");
					//获得所有的复选框对象
					var checkBoxAll = $("input[name='deviceNameAndModel.devicemodel']");
					for ( var i = 0; i < checkArray.length; i++) {
						//获取所有复选框对象的value属性，然后，用checkArray[i]和他们匹配，如果有，则说明他应被选中
						$.each(checkBoxAll, function(j, checkbox) {
							//获取复选框的value属性
							var checkValue = $(checkbox).val();
							if (checkArray[i] == checkValue) {
								$(checkbox).attr("checked", true);
							}
						});
					}
				};
			});
			function returnValue() {
				
				var devicemodel_id = "";
				var devicemodel = "";
				var plugInLength = $("input[name='deviceNameAndModel.devicemodel']:checkbox:checked").length;
				$(
						"input[name='deviceNameAndModel.devicemodel']:checkbox:checked")
						.each(
								function(i, value) {
									if ($(this).attr("checked")) {
										if ((i + 1) == plugInLength) {
											devicemodel_id += $(this).val();
										} else {
											devicemodel_id += $(this).val() + ", ";
										}
										if ((i + 1) == plugInLength) {
											devicemodel += $(this).next(
													'label').text();
										} else {
											devicemodel += $(this).next(
													'label').text()
													+ ", ";
										}
									}
								});
				var rvalue = devicemodel_id + ":" + devicemodel;
				window.returnValue = rvalue;
				window.close();
			}
			
			function chooseall(){
				  $("input[name='deviceNameAndModel.devicemodel']:checkbox").each(function(){ 
			          $(this).attr("checked",true);
			      });	
			}
			
			function clearall(){
				  $("input[name='deviceNameAndModel.devicemodel']:checkbox").each(function(){ 
			          $(this).attr("checked",false);
			      });	
			 }
		</script>
</html>
