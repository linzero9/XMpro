<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>

<html>
 <head>
<title>设备属性列表</title>
</head>
<body>
	<w:panel id="list_panel1" width="100%" height="100%"title="设备属性列表">
		<w:layout height="100%" width="100%" type="horizontal">
			<w:layoutPanel width="50%">
				<div style="border:1px solid #dddddd;width:100%;height:100%">				
				<h:form name="query_formx" id="query_formx"
				action="/dict/eosDictEntryAction_dictTypeList.action"  target="_self" method="post" >
				
				<table align="center" border="0" width="100%" class="form_table">
					<tr>
						<td class="form_label" align="right">属性名称：</td>
						<td colspan="1"><h:text id="dictTypeName" property="dictType.dictTypeName" /></td>
					</tr>
					<tr class="form_bottom">
						<td colspan="4" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="submit" value="查 询" class="button">
							<input type="button" value="清 空" class="button" onclick="clears();">
							</td>
					</tr>		
				</table>
				</h:form>
				<h:form name="formx_list" id="formx_list"
				action="/dict/eosDictEntryAction_queryDictEntryBydictTypeId.action"  target="_self" method="post" >
				<h:hidden property="dictEntry.dictTypeId" id="dictTypeId" />
				<h:hiddendata property="dictType"  />
				<h:hiddendata property="page"/>
				<table align="center" border="0" width="100%" class="EOS_table">
					<tr>
						<th nowrap="nowrap">选择</th>
						<th nowrap="nowrap">属性名称</th>
					</tr>
					<w:radioGroup id="xgroup1">
						<l:iterate property="dictTypes" id="idx" indexId="index">
							<tr class="<l:output evenOutput='EOS_table_row' />">
								<td align="center" nowrap="nowrap"><w:rowRadio>
									<h:param name='dictTypeId' iterateId='idx' property='dictTypeId' />
								</w:rowRadio></td>
								<td nowrap="nowrap"><b:write iterateId="idx" property="dictTypeName" /></td>
							</tr>
						</l:iterate>
					</w:radioGroup>
					<tr>
						 <td colspan="23" class="command_sort_area">
						 <div class="h3">
							<l:greaterThan property="page.count" targetValue="0"
								compareType="number">
								<input type="button" value="查询属性值" onclick="queryEntry();" class="button">
							</l:greaterThan>
						</div>
						<div class="h4">
	                <l:equal property="page.isCount" targetValue="true" >
	                  <b:message key="l_total"></b:message>
	                  <b:write property="page.count" />
	                  <b:message key="l_recordNO."></b:message>
	                  <b:write property="page.currentPage" />
	                  <b:message key="l_page"></b:message>
	                  <b:write property="page.totalPage" />
	                  <b:message key="l_page"></b:message>
	                </l:equal>
	                <l:equal property="page.isCount" targetValue="false" >
	                  <b:message key="l_NO."></b:message>
	                  <b:write property="page.currentPage" />
	                  <b:message key="l_page"></b:message>
	                </l:equal>
	                <input type="button" class="button" onclick="firstPage('page', '', null, null, 'formx_list');" value='<b:message key="l_firstPage"></b:message>'  <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
	                <input type="button" class="button" onclick="prevPage('page', '', null, null, 'formx_list');" value='<b:message key="l_upPage"></b:message>' <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
	                <input type="button" class="button" onclick="nextPage('page', '', null, null, 'formx_list');" value='<b:message key="l_nextPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                <l:equal property="page.isCount" targetValue="true">
	                  <input type="button" class="button" onclick="lastPage('page', '', null, null, 'formx_list');" value='<b:message key="l_lastPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                </l:equal>
              </div>
					</td>
					</tr>
				</table>
				</h:form>
				</div>
			</w:layoutPanel>
			<w:layoutPanel width="50%">
				<div style="border:1px solid #dddddd;width:100%;height:100%">
				<h:form name="formy_list" id="formy_list"
				action="/dict/eosDictEntryAction_queryDictEntryBydictTypeId.action"  target="_self" method="post" >
				<table align="center" border="0" width="100%" class="EOS_table">
					<tr>
						<th nowrap="nowrap">
							<l:greaterThan property="page.count" targetValue="0" compareType="number">
	                 					<h:checkbox id="selectBox" onclick="allItem();"/>
	             				 </l:greaterThan>
								<b:message key="l_select"></b:message>
						</th>
						<th nowrap="nowrap">项编号</th>
						<th nowrap="nowrap">项名称</th>
					</tr>
					<w:checkGroup id="ygroup1">
						<l:iterate property="dictEntrys" id="idy" indexId="index">
							<tr class="<l:output evenOutput='EOS_table_row' />">
								<td align="center" nowrap="nowrap"><w:rowCheckbox>
									<h:param name='dictTypeId' iterateId='idy' property='dictTypeId' />
									<h:param name='dictId' iterateId='idy' property='dictId' />
								</w:rowCheckbox></td>
								<td nowrap="nowrap"><b:write iterateId="idy" property="dictId" /></td>
								<td nowrap="nowrap"><b:write iterateId="idy" property="dictName" /></td>
							</tr>
						</l:iterate>
					</w:checkGroup>
					<tr>
						<td colspan="23" class="command_sort_area">
							<div class="h3">
							<input type="button" class="button" value="新增"
										onclick="addItem();" />
								<l:greaterThan property="page.count" targetValue="0"
									compareType="number">
							<input type="button" class="button" value="修改"
										onclick="uptItem();" />
								</l:greaterThan>
								<l:greaterThan property="page.count" targetValue="0"
									compareType="number">
							<input type="button" class="button" value="删除"
										onclick="delItem();" />
								</l:greaterThan>
							</div>
              </td>
					</tr>
				</table>
				</h:form>
				</div>
			</w:layoutPanel>
		</w:layout>
	</w:panel>
	</body>
	<script type="text/javascript">
	//清空
	function clears(){
		$id("dictTypeName").value="";
	}

	function queryEntry(){
		var gop = $id("xgroup1");
  		var len = gop.getSelectLength();
  		if(len == 0){
  			alert("请选择一个属性");
  			return;
  		}else{
  			var rows=gop.getSelectRow();
  			$id("dictTypeId").value = rows.getParam("dictTypeId");
  			var frm = $name("formx_list");
  		 	frm.submit();
	  	}
	}

	//新增
	function addItem(){
		var dictTypeId=$id("dictTypeId").value;
		  var url="/dict/eosDictEntryAction_toInsert.action?dictEntry.dictTypeId="+dictTypeId;
		  showModalCenter(url, null,callBackFunc, 400, 200, '新增属性项');
	}

	//修改
	function uptItem(){
		var gop = $id("ygroup1");
  		var len = gop.getSelectLength();
  		if(len != 1){
  			alert("请选择一条记录");
  			return;
  		}else{
  			var rows=gop.getSelectRows();
	  		var dictTypeId=rows[0].getParam("dictTypeId");
	  		var dictId=rows[0].getParam("dictId");
  			var strUrl = "/dict/eosDictEntryAction_toUpdate.action?dictEntry.dictTypeId="+dictTypeId+"&dictEntry.dictId="+dictId;
  			showModalCenter(strUrl, null, callBackFunc, 400, 200, '修改属性项');  
	  	}
	}

	function callBackFunc(){
        var frm = $name("formx_list");
            frm.submit();
    }

	//删除
	function delItem(){
		var gop = $id("ygroup1");
  		var len = gop.getSelectLength();
  		if(len == 0){
  			alert("请选择一条或多条记录");
  			return;
  		}else{
	  	  if(confirm("确定要删除该项吗？")){
  			var rows=gop.getSelectRows();
  			var dictTypeId=rows[0].getParam("dictTypeId");
  			var dictIds="";
  			var id ="";
  			var flag = 0;
  			for(var i=0;i<rows.length;i++){
  				id = rows[i].getParam("dictId");
  				$.ajax({
				      url: "/dict/eosDictEntryAction_isExist.action",
				      async: false,
				      type: 'post',
				      data: "dictEntry.dictTypeId="+dictTypeId+"&dictEntry.dictId="+id,
				      timeout: 60000,
				      dataType:"text",
				      success: function (data) {
				    	  if (data.indexOf("exist") >= 0) {
				    		  alert(id+"无法删除，该属性项已在设备信息中使用！");
				    		  flag = 1;
						}
								  	
				      }
				}); 
			 
  				dictIds += rows[i].getParam("dictId")+",";
  			}
  			if(flag == 1){
				return;
			}
  			if(dictIds!=""){
  				dictIds=dictIds.substring(0,dictIds.length-1);
	  		$.ajax({
			      url: "/dict/eosDictEntryAction_deleteItem.action",
			      async: false,
			      type: 'post',
			      data: "dictEntry.dictTypeId="+dictTypeId+"&dictEntry.dictId="+dictIds,
			      timeout: 60000,
			      dataType:"text",
			      success: function (data) {
			    	  if (data.indexOf("success") >= 0) {
			    		  alert("删除成功");
			    		  refreshCache();//数据字典刷新缓存
			    		  callBackFunc();
					} else if (data.indexOf("fails") >= 0) {
						alert("删除失败!");
					} else {
						alert("操作失败!");
					}
							  	
			      }
			}); 
  			}
	 	 }	
	  	}
	}

	//数据字典刷新缓存
	function refreshCache(){
		//调用逻辑流
    	var myAjax = new Ajax("/reloadEosDict.flow");
    	//开始调用
    	myAjax.submit();
    	//取得调用后的结果(xml对象)
    	var returnNode =myAjax.getResponseXMLDom();
    	if(returnNode)
    	{
    		//获取指定的节点值
    		reCode = myAjax.getValue("/root/data/reCode");
    	}
    	if(reCode == 1)
    	{
    		alert("刷新缓存成功");//刷新业务字典信息成功。
    	}else{
    		alert("刷新缓存失败");//刷新业务字典信息失败。
    	}
	}

	function allItem(){
		var group =$id("ygroup1");
		if(document.getElementById("selectBox").checked){
			group.selectAll();
		}else{
			group.disSelectAll();
		}
	}

	</script>
</html>
