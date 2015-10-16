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
  <h:form name="imp_form"	action="/deviceManagement/deviceManagementAction_importExcel.action"  method="post"  enctype="multipart/form-data">
		<w:panel id="panel1" title="选择文件">
			<table align="center" border="0" width="100%" class="form_table">

   					<tr>
						<td class="form_label" align="right">设备信息Excel文件：
						<td colspan="1">
							 <input type="file" name="readFile" size="40">  <font style="color: red">文件扩展名为.xls</font> 
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
		<DIV style="width:100%;height:280px;OVERFLOW: auto" >
	<w:panel id="list_panel2" width="100%" title="导入结果信息">
	 <h:hidden property="map/imp_flag"/>
	 <h:hidden property="map/all_num"/>
	 <h:hidden property="map/sumnum"/>
	 <h:hidden property="map/failnum"/>
	 <h:hidden property="map/msg" />
		<div id="showInfo" style="width: 100%">
		</div>
	 </w:panel>
	 	</DIV>
  </body>
  <script type="text/javascript">
  function init(){
	  var f = $name("map/imp_flag").value;
		 if(f=="1"){
			    var all_num=$name("map/all_num").value;
			    var su_num=$name("map/sumnum").value;
			 	var fa_num=$name("map/failnum").value;
			 	alert("总共导入数据"+all_num+"条，其中成功导入数据"+su_num+"条，失败"+fa_num+"条。");
			 	
			 	$id("showInfo").innerHTML="<font style='color:red'>总共导入数据"+all_num+"条，其中成功导入数据"+su_num+"条，失败"+fa_num+"条。</font>"+"<br>";
			 	var msg = $name("map/msg").value;
				var xxs = msg.split("||");
			 	for (var i=0; i<=xxs.length; i++){
					if(xxs[i]){
						$id("showInfo").innerHTML=$id("showInfo").innerHTML+xxs[i]+"<br>";
					}
				}
				
		 }else{
			 $id("showInfo").style.display="none";
		}
  }
  eventManager.add(window,"load",init);
  
  //导入
  function import_file(){
	var excelFile = $name("readFile").value;
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
