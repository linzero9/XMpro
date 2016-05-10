<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>

<html>
 <head>
<title>一级分类/贷种分类维护列表</title>
</head>
<body>
	<w:panel id="list_panel1" width="100%" height="100%"title="一级分类/贷种分类维护列表">
		<w:layout height="100%" width="100%" type="horizontal">
			<w:layoutPanel width="50%">
				<div style="border:1px solid #dddddd;width:100%;height:100%">
				<h:form name="query_formx" id="query_formx"
				action="/jbpm/xdProcessAction_toSelectParaManage.action"  target="_self" method="post" >
				
				<table align="center" border="0" width="100%" class="form_table">
				<tr>
						<td class="form_label" align="right">信贷流程名称：</td>
						<td colspan="1">
						<h:hidden id="processName" property="xdCdtypeBean.processName"/>		
							<b:write property="xdCdtypeBean.processName" />
						</td>
					</tr>
					<tr>
						<td class="form_label" align="right">一级分类：</td>
						<td colspan="1">
						<h:hidden id="oneCategoryId"  property="xdCdtypeBean.oneCategoryId" />
							<h:text id="oneCategory" property="xdCdtypeBean.oneCategory" readonly="true"/>
							<a href="#" onclick="showoneCategory();">选择</a>
						</td>
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
				action="/jbpm/xdProcessAction_toSelectParaManage.action"  target="_self" method="post" >
				<h:hiddendata property="xdCdtypeBean"  />
				<h:hiddendata property="page"/>
				<table align="center" border="0" width="100%" class="EOS_table">
					<tr>
						<th nowrap="nowrap">
						<b:message key="l_select"></b:message>
						</th>
						<th nowrap="nowrap">一级分类</th>
					</tr>
					<w:radioGroup id="xgroup1">
						<l:iterate property="xdCdtypeBeans" id="idx" indexId="index">
							<tr class="<l:output evenOutput='EOS_table_row' />">
								<td align="center" nowrap="nowrap"><w:rowRadio>
									<h:param name='oneCategory' iterateId='idx' property='oneCategory' />
								</w:rowRadio></td>
								<td nowrap="nowrap"><b:write iterateId="idx" property="oneCategory" /></td>
							</tr>
						</l:iterate>
					</w:radioGroup>
					<tr>
						 <td colspan="23" class="command_sort_area">
						 <div class="h3">
								<input type="button" value="新增" onclick="add_oneCategory();" class="button">
							
							<l:greaterThan property="page.count" targetValue="0"
								compareType="number">
								<input type="button" value="删除" onclick="del_oneCategory();" class="button">
							</l:greaterThan>
							<l:greaterThan property="page.count" targetValue="0"
								compareType="number">
								<input type="button" value="查看贷种分类" onclick="queryLoanCategory();" class="button">
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
				action="/jbpm/xdProcessAction_queryLoanCategoryList.action"  target="_self" method="post" >
				
				<h:hidden id="processName2"  property="xdCdtypeBean2.processName"  />
				
				<h:hiddendata property="xdCdtypeBean"  />
				<h:hiddendata property="page" />
				<h:hiddendata property="page2" />
				<table align="center" border="0" width="100%" class="EOS_table">
					<tr>
						<td colspan="2">一级分类：
						<b:write property="xdCdtypeBean2.oneCategory"  />
						<h:hidden id="oneCategory2" property="xdCdtypeBean2.oneCategory"  />
						</td>
					</tr>
					<tr>
						<th nowrap="nowrap">
								<b:message key="l_select"></b:message>
						</th>
						<th nowrap="nowrap">贷种分类</th>
					</tr>
					<w:radioGroup id="ygroup1">
						<l:iterate property="xdCdtypeBeans2" id="idy" indexId="index">
							<tr class="<l:output evenOutput='EOS_table_row' />">
								<td align="center" nowrap="nowrap"><w:rowRadio>
									<h:param name='loanCategory' iterateId='idy' property='loanCategory' />
								</w:rowRadio></td>
								<td nowrap="nowrap"><b:write iterateId="idy" property="loanCategory" /></td>
							</tr>
						</l:iterate>
					</w:radioGroup>
					<tr>
						<td colspan="23" class="command_sort_area">
							<div class="h3">
							<l:notEmpty property="xdCdtypeBean2.oneCategory">
								<input type="button" class="button" value="新增"  onclick="add_loanCategory();" />
							</l:notEmpty>
								<l:greaterThan property="page2.count" targetValue="0"
									compareType="number">
									<input type="button" class="button" value="删除"
												onclick="del_loanCategory();" />
								</l:greaterThan>
							</div>
							
			<l:greaterThan property="page2.count" targetValue="0"  compareType="number">
							<div class="h4">
	                <l:equal property="page2.isCount" targetValue="true" >
	                  <b:message key="l_total"></b:message>
	                  <b:write property="page2.count" />
	                  <b:message key="l_recordNO."></b:message>
	                  <b:write property="page2.currentPage" />
	                  <b:message key="l_page"></b:message>
	                  <b:write property="page2.totalPage" />
	                  <b:message key="l_page"></b:message>
	                </l:equal>
	                <l:equal property="page2.isCount" targetValue="false" >
	                  <b:message key="l_NO."></b:message>
	                  <b:write property="page2.currentPage" />
	                  <b:message key="l_page"></b:message>
	                </l:equal>
	                <input type="button" class="button" onclick="firstPage('page2', '', null, null, 'formy_list');" value='<b:message key="l_firstPage"></b:message>'  <l:equal property="page2.isFirst"  targetValue="true">disabled</l:equal> >
	                <input type="button" class="button" onclick="prevPage('page2', '', null, null, 'formy_list');" value='<b:message key="l_upPage"></b:message>' <l:equal property="page2.isFirst"  targetValue="true">disabled</l:equal> >
	                <input type="button" class="button" onclick="nextPage('page2', '', null, null, 'formy_list');" value='<b:message key="l_nextPage"></b:message>' <l:equal property="page2.isLast"  targetValue="true">disabled</l:equal> >
	                <l:equal property="page2.isCount" targetValue="true">
	                  <input type="button" class="button" onclick="lastPage('page2', '', null, null, 'formy_list');" value='<b:message key="l_lastPage"></b:message>' <l:equal property="page2.isLast"  targetValue="true">disabled</l:equal> >
	                </l:equal>
              </div>
              </l:greaterThan>
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
		$id("oneCategory").value="";
		$id("oneCategoryId").value="";
	}

	//查询一级分类对应的 贷种分类
	function queryLoanCategory(){
		var gop = $id("xgroup1");
  		var len = gop.getSelectLength();
  		if(len == 0){
  			alert("请选择一条记录");
  			return;
  		}else{
  			var row=gop.getSelectRow();
  			var oneCategory =  row.getParam("oneCategory");
			$id("oneCategory2").value = oneCategory;
			$id("processName2").value = $id("processName").value;
			var frm = $name("formy_list");
		 	frm.submit();
	  	  }
		}
	
  //新增 一级分类
	function add_oneCategory(){
		var processName=$id("processName").value;
		 var url="/jbpm/xdProcessAction_toAddOneCategory.action?xdCdtypeBean.processName="+encodeURI(processName);
		  showModalCenter(url, null,callBackFunc, 500, 300, '新增一级分类');
	}

	function callBackFunc(){
        var frm = $name("formx_list");
            frm.submit();
    }

	//删除 一级分类
	function del_oneCategory(){
		var gop = $id("xgroup1");
  		var len = gop.getSelectLength();
  		if(len == 0){
  			alert("请选择一条记录");
  			return;
  		}else{
	  	  if(confirm("确定要删除该项吗？")){
  			var row=gop.getSelectRow();
  			var processName = $id("processName").value;
	  		var oneCategory=row.getParam("oneCategory");
  			
	  		$.ajax({
			      url: "/jbpm/xdProcessAction_delOneCategory.action",
			      async: false,
			      type: 'post',
			      data: "xdCdtypeBean.processName="+processName+"&xdCdtypeBean.oneCategory="+oneCategory,
			      timeout: 60000,
			      dataType:"text",
			      success: function (data) {
			    	  if (data.indexOf("success") >= 0) {
			    		  alert("删除成功");
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

	//新增 贷种分类
	function add_loanCategory(){
		var processName=$id("processName").value;
		var oneCategory=$id("oneCategory2").value;
		 var url="/jbpm/xdProcessAction_toAddLoanCategory.action?xdCdtypeBean.processName="+encodeURI(processName)+"&xdCdtypeBean.oneCategory="+encodeURI(oneCategory);
		  showModalCenter(url, null,callBackFunc2, 500, 300, '新增贷种分类');
	}

	function callBackFunc2(){
        var frm = $name("formy_list");
            frm.submit();
    }
    
	//删除 贷种分类
	function del_loanCategory(){
		var gop = $id("ygroup1");
  		var len = gop.getSelectLength();
  		if(len == 0){
  			alert("请选择一条记录");
  			return;
  		}else{
	  	  if(confirm("确定要删除该项吗？")){
  			var row=gop.getSelectRow();
  			var processName = $id("processName").value;
  			var oneCategory = $id("oneCategory2").value;
	  		var loanCategory=row.getParam("loanCategory");
  			
	  		$.ajax({
			      url: "/jbpm/xdProcessAction_delLoanCategory.action",
			      async: false,
			      type: 'post',
			      data: "xdCdtypeBean.processName="+processName+"&xdCdtypeBean.oneCategory="+oneCategory+"&xdCdtypeBean.loanCategory="+loanCategory,
			      timeout: 60000,
			      dataType:"text",
			      success: function (data) {
			    	  if (data.indexOf("success") >= 0) {
			    		  alert("删除成功");
			    		  callBackFunc2();
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


	function showoneCategory() {
		var oneCategoryId=document.getElementById("oneCategoryId").value;
		strUrl ="/Generalprocess/tGeneralprocessCdtypeAction_oneCategoryDic.action?cdtypeJson="+oneCategoryId,
		showModalCenter(strUrl,'',showoneCategory_callback1 ,800,430,'一级分类选择'); 
	} 
	function showoneCategory_callback1(args){
		if(args!=''){
		var array;
		array = args.split(":");
		 document.getElementById("oneCategoryId").value = array[0];
		 document.getElementById("oneCategory").value = array[1];
		}
	}
	
	</script>
</html>
