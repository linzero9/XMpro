<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>节点模式 列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="节点模式列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
		    
					<table align="center" border="0" width="100%" class="EOS_table">
		    
						<tr>
							<th align="center" nowrap="nowrap">
								<b:message key="l_select"></b:message>
							</th>
							<th nowrap="nowrap">
								节点模式名称
							</th>
						</tr>
						<w:radioGroup id="group1">
                           <l:iterate property="models" id="id1" >
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap">
									<w:rowRadio>
										<h:param name='node_key' iterateId='id1' property='model_name' />
										<h:param name='node_value' iterateId='id1' property='model_tablename' />
									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="model_name" />
								</td>
							</tr>
						</l:iterate>
						</w:radioGroup>
							<tr>
              <td colspan="23" class="command_sort_area">
              	<div class="h3"> 
              				<l:equal property="models.size" targetValue="0" compareType="number" >
									<input type="button" class="button" value="选择" onclick="my_select();" disabled="disabled" />
							</l:equal>
							<l:notEqual property="models.size" targetValue="0" compareType="number">
								<input type="button" class="button" value="选择" onclick="my_select();" />
							</l:notEqual>
						<input type="button" class="button" value="关闭" onclick="window.close();"/>	
				</div>
              </td>
            </tr>
					</table>
				</viewlist>
			</w:panel>		
		</DIV>
		<script type="text/javascript">

		function my_select(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		
	  		if(len == 0){
	  			alert("请选择一个节点模式");
	  			return;
	  		}else{
			var row=gop.getSelectRow();
			var node_key=row.getParam("node_key");
	  		var node_value=row.getParam("node_value");
	  		
			window.returnValue = [node_key,node_value];
			window.close();
	  		}
		}
		</script>
		
	</body>
</html>