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
				<h:form name="page_form"
					action="/Generalprocess/tGeneralprocessCdtypeAction_queryViewList.action" method="post">
					<h:hidden property="page.begin" />
					<h:hidden property="page.length" />
					<h:hidden property="page.count" />
					<h:hidden property="page.isCount" />
					<h:hiddendata property="integral" />
					<table align="center" border="0" width="100%" class="EOS_table">
						<tr>
							<th align="center" nowrap="nowrap" width="5%">
								<b:message key="l_select"></b:message>
							</th>
							<th nowrap="nowrap" >
								一级分类
							</th>
							<th nowrap="nowrap" >
								一级分类
							</th>
						</tr>
					<w:radioGroup id="group1">
						<l:iterate property="cdtypes" id="id1">
							<tr class="<l:output oddOutput='EOS_table_row_o' evenOutput='EOS_table_row' />">
								<td align="center" nowrap="nowrap" width="5%">
								<w:rowRadio>
										<h:param name='firstClass' iterateId='id1' property='firstClass' />
								</w:rowRadio>
								</td>
								<td nowrap="nowrap"  ><b:write iterateId="id1" property="processName" />
								</td>
								</td>
								<td nowrap="nowrap" ><b:write iterateId="id1" property="firstClass" />
								</td>
							</tr>
						</l:iterate>
					</w:radioGroup>
					<tr>
              <td colspan="23" class="command_sort_area">
              	<div class="h3"> 
              	<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
								<input type="button" class="button" value="选择" onclick="returnValue();"/>
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
	                <input type="button" class="button" onclick="firstPage('page', '', null, null, 'page_form');" value='<b:message key="l_firstPage"></b:message>'  <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
	                <input type="button" class="button" onclick="prevPage('page', '', null, null, 'page_form');" value='<b:message key="l_upPage"></b:message>' <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
	                <input type="button" class="button" onclick="nextPage('page', '', null, null, 'page_form');" value='<b:message key="l_nextPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                <l:equal property="page.isCount" targetValue="true">
	                  <input type="button" class="button" onclick="lastPage('page', '', null, null, 'page_form');" value='<b:message key="l_lastPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                </l:equal>
              </div>
              </td>
            </tr>
					</table>
				</h:form>
				</viewlist>
			</w:panel>		
		</DIV>
  </body>
  <script type="text/javascript">
  function returnValue(){
	  var gop = $id("group1");
		var len = gop.getSelectLength();
		if(len == 0){
			alert("请选择一条流程信息");
			return;
		}else{
			var rows=gop.getSelectRow();
	  		var firstClass=rows.getParam("firstClass");
	  		window.returnValue=firstClass;
	  		window.close();
	  		
		}
	  }
  </script>
</html>
