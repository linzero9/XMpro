<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>操作日志导出</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/reportjbpm/operateLogAction_queryOperateLog.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
                                        <td class="form_label" align="right" width="10%">报单日期：</td>
					<td colspan="1" width="25%">
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyy-MM-dd" id="airTime" name="operateLog.airTime" 
					property="operateLog.airTime" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyy-MM-dd" id="stopTime" name="operateLog.stopTime" 
					property="operateLog.stopTime" /></td>

					<td class="form_label" align="right" width="10%">客户名称：</td>
					<td colspan="1" width="25%"><h:text id="custName" property="operateLog.custName" />
					</td>
					<td class="form_label" align="right" width="10%">节点名称：</td>
					<td colspan="1" width="25%"><h:text id="activityName" property="operateLog.activityName" />
					</td>
					
				</tr>
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="submit" value="查 询" class="button" onclick="search();">
							<input type="button" value="清 空" class="button" onclick="clears();">
                            <input id="downexl" type="button" class="button" value="导出列表" onclick="excelExport();"></td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="操作日志导出">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/reportjbpm/operateLogAction_queryOperateLog.action" method="post">
			 <h:hiddendata property="operateLog"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">
		 
							<th nowrap="nowrap">
								操作人
							</th>
							<th nowrap="nowrap">
								操作人机构
							</th>
							
							<th nowrap="nowrap">
								模板名称
							</th>
							<th nowrap="nowrap">
								客户名称
							</th>
							<th nowrap="nowrap">
								节点名称
							</th>
							<th nowrap="nowrap">
								操作模式开始时间
							</th>
							<th nowrap="nowrap">
								操作模式结束时间
							</th>
						
						</tr>
                           <l:iterate property="operateLogList" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="empName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgName" />
								</td>
								
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="processName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="custName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="activityName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="start" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="end" />
								</td>
								
							</tr>
						</l:iterate>
							<tr>
              <td colspan="23" class="command_sort_area">
            
							
              <div class="h4">
	                <l:equal property="page.isCount" targetValue="true" >
	                  <b:message key="l_total"></b:message>
	                  <b:write property="page.count" />
	                  <b:message key="l_recordNO."></b:message>
	                  <b:write property="page.currentPage" />
	                  <b:message key="l_page"></b:message>/
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
		<script type="text/javascript">

		//清空
		function clears(){
			//清空JSP页面时间控件显示的值
			$("#airTime_input").val("");
			$("#stopTime_input").val("");
			$("#custName").val("");
			$("#activityName").val("");

			//清空传入后台的时间控件的值
			$name("operateLog.airTime").value = "";
			$name("operateLog.stopTime").value = "";
		}
		
                function search(){
			$("#isExport").val("");
			}

    		//导出excel 	
             function excelExport(){
    				var airTime = $id("airTime").value;
    				var stopTime = $id("stopTime").value;
    				var custName = $id("custName").value;
    				var activityName = $id("activityName").value;
    				var strUrl = "/reportjbpm/operateLogAction_queryOperateLogForExcel.action?";
                     if(airTime!=null){
                    	 strUrl=strUrl+"&operateLog.airTime="+airTime;
                         }
    				
    				if(stopTime!=null){
    					strUrl=strUrl+"&operateLog.stopTime="+stopTime;
        				} 				
    				strUrl=strUrl+"&operateLog.custName="+custName;
    				strUrl=strUrl+"&operateLog.activityName="+activityName;
    				window.location.href=strUrl;


    			}
		

	

	  	


		
		</script>
		
	</body>
</html>