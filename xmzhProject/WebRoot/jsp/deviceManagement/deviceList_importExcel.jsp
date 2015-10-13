<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>批量导入</title>
  </head>
  
  <body topmargin="0" leftmargin="0">
  <h:form name="imp_form"	action="/deviceManagement/deviceManagementAction_importExcel.action" method="post">
		<w:panel id="panel1" title="选择文件">
			<table align="center" border="0" width="100%" class="form_table">

   					<tr>
						<td class="form_label" align="right">设备信息Excel文件：
						<td colspan="1">
							<h:file name="dictItemFile"  id="dictItemFile"   />  <font style="color: red">文件扩展名为.xls</font>
						</td>
					</tr>
					<tr class="form_bottom">
						<td colspan="4" class="form_bottom">
							<input  type="button" value="导入" class="button" onclick="import_file();">
							<input type="button" value="关闭"  onclick="window.close();" class="button">
						</td>
					</tr>
			</table>
		</w:panel>
	</h:form>
		<w:panel id="panel1" title="导入结果信息">
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
					<td>
							<b:write property="msg" />
					</td>
				</tr>
			</table>
		</w:panel>
  </body>
  <script type="text/javascript">
  //导入
  function import_file(){
	var excelFile = $name("dictItemFile").value;
	if (excelFile=="") {
		alert('请选择您要导入的Excel文件！');//请选择您要导入的Excel文件！
		return;
	}
	var re= /.xls$/;
	if (!re.test(excelFile))
	{
		alert('请选择2003年版本的Excel文件！'); //请选择Excel文件！
		return;
	}
	excelFile = excelFile.substr(excelFile.lastIndexOf("\\") + 1);
	
	if(!confirm("是否确认导入数据？")){
				return false;
			}
	
	var frm = $name("imp_form");
	frm.submit();
  }
  </script>
</html>
