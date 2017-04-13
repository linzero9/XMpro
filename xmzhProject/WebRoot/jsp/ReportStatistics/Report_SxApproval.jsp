<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>授信审批统计表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/reportjbpm/sxApprovalReportAction_sxApprovalReportList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
                     <td class="form_label" align="right" >审批日期：</td>
					<td >
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="approvalTimeStart" name="sxApprovalReport.approvalTimeStart" 
					property="sxApprovalReport.approvalTimeStart" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="approvalTimeEnd" name="sxApprovalReport.approvalTimeEnd" 
					property="sxApprovalReport.approvalTimeEnd" /></td>
					
				</tr>
				
				<tr class="form_bottom">
						<td colspan="10" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="button" value="查 询" class="button" onclick="search();">
							<input type="button" value="清 空" class="button" onclick="clears();">
                                                        <input id="downexl" type="button" class="button" value="导出列表" onclick="excelExport();"></td>
					</tr>			
					
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList"    style="overflow-y:scroll;height: 70%"   >
			<w:panel id="panel" width="100%" title="授信审批统计列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/reportjbpm/sxApprovalReportAction_sxApprovalReportList.action" method="post">
			 <h:hiddendata property="sxApprovalReport"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">
		           <tr>
							<l:empty property="sxApprovalReportTitleList">
							
							<th nowrap="nowrap">
								一级支行
							</th>
							<th nowrap="nowrap" >
								二级支行
							</th>
							<th nowrap="nowrap">
								列出所有一级分类
							</th>
							</l:empty>
							<l:notEmpty property="sxApprovalReportTitleList">
								<th nowrap="nowrap"  rowspan="3">
								一级支行
							</th>
							<th nowrap="nowrap"  rowspan="3">
								二级支行
							</th>
							<th nowrap="nowrap"  rowspan="1"   colspan='<b:write property="sxApprovalReportTitleList.size()*2" />' >
								列出所有一级分类
							</th>
							</tr>
							<tr>
							
                           <l:iterate property="sxApprovalReportTitleList" id="id1">
							<th nowrap="nowrap" rowspan="1"   colspan="2">
							<b:write iterateId="id1" property="oneCategory" />
							</th>
							
						</l:iterate>
					       </tr>
					       <tr>
					      <l:iterate property="sxApprovalReportTitleList" id="id2">
							<th nowrap="nowrap">
								笔数
					       </th>
					       <th nowrap="nowrap">
								金额
							</th>
							</l:iterate>
							
						</tr>
							</l:notEmpty>
							<b:write property="orgNameOne" />
							<l:iterate property="sxApprovalReportOrgNameOneList" id="id3">
							<tr  >
							<!-- 一级支行 -->
							<%if %>
								<td nowrap="nowrap" rowspan='<b:write property="3" />'> 
								<b:write iterateId="id3" property="orgNameOne" />
							<!-- 二级支行 -->
								<td nowrap="nowrap" > 
								1111
								</td>
								<!-- 类型值 -->
								<td nowrap="nowrap" > 
								222
								</td>
								<td nowrap="nowrap" > 
								2223
								</td>
							</tr>
							<tr  >
								<td nowrap="nowrap" > 
								1111
								</td>
								<td nowrap="nowrap" > 
								222
								</td>
								<td nowrap="nowrap" > 
								2223
								</td>
							</tr>
							<tr  >
								<td nowrap="nowrap" > 
								1111
								</td>
								<td nowrap="nowrap" > 
								222
								</td>
								<td nowrap="nowrap" > 
								2223
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
	                <l:equal property="page.isCount" targetValue="true">
		                <input type="button" class="button" onclick="firstPage('page', '', null, null, 'page_form');" value='<b:message key="l_firstPage"></b:message>'  <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
		                <input type="button" class="button" onclick="prevPage('page', '', null, null, 'page_form');" value='<b:message key="l_upPage"></b:message>' <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
		                <input type="button" class="button" onclick="nextPage('page', '', null, null, 'page_form');" value='<b:message key="l_nextPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
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
			$("#approvalTimeStart_input").val("");
			$("#approvalTimeEnd_input").val("");
			//清空传入后台的时间控件的值
			$name("sxApprovalReport.approvalTimeStart").value = "";
			$name("sxApprovalReport.approvalTimeEnd").value = "";

		}

		
            function search(){
            	var frm = $name("appQuery");
                frm.submit();
			}

    		//导出excel 	
             function excelExport(){
    				//报单时间 开始
    				var approvalTimeStart = $id("approvalTimeStart").value;
    				//报单时间 结束
    				var approvalTimeEnd = $id("approvalTimeEnd").value;
    				
    				var strUrl = "/reportjbpm/sxApprovalReportAction_sxApprovalReportExcel.action?";
    				if(approvalTimeStart != null){strUrl=strUrl+"&sxApprovalReport.approvalTimeStart="+approvalTimeStart;}
    	    		if(approvalTimeEnd != null){strUrl=strUrl+"&sxApprovalReport.approvalTimeEnd="+approvalTimeEnd;} 
    				//alert(strUrl);
    				window.location.href=strUrl;
    			}
		
		</script>
		
	</body>
</html>