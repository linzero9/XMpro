<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>退单率统计列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/reportjbpm/rateofreturnReportAction_rateofreturnReportList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
                    <td class="form_label" align="right" width="20%">审批时间：</td>
					<td colspan="1" width="30%">
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyy-MM-dd" id="appTimeStrat" name="rateofreturnReport.appTimeStrat" 
					property="rateofreturnReport.appTimeStrat" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyy-MM-dd" id="appTimeEnd" name="rateofreturnReport.appTimeEnd" 
					property="rateofreturnReport.appTimeEnd" /></td>				



				
					
					<td class="form_label" align="right" >一级分类：</td>
					<td >
			     		<h:hidden id="oneCategoryId" />  
						<h:text id="oneCategory" property="rateofreturnReport.oneCategory" readonly="true"/>
						<a href="#" onclick="showoneCategory();">选择</a>
					</td>
					
					<td class="form_label" align="right" >贷种分类：</td>
					<td >
						<h:hidden id="loanCategoryId"/>
						<h:text id="loanCategory" property="rateofreturnReport.loanCategory" readonly="true"/>
						<a href="#" onclick="showloanCategory();">选择</a>
					</td>
				</tr>
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="button" value="查 询" class="button" onclick="search();">
							<input type="button" value="清 空" class="button" onclick="clears();">
                                                        <input id="downexl" type="button" class="button" value="导出列表" onclick="downExl();"></td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="退单率统计列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/reportjbpm/rateofreturnReportAction_rateofreturnReportList.action" method="post">
			 <h:hiddendata property="rateofreturnReport"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">
		    
						<tr>
				          <th nowrap="nowrap">
								一级分类
							</th>
							<th nowrap="nowrap">
								贷种
							</th>
							<th nowrap="nowrap">
								区支行
							</th>
							<th nowrap="nowrap">
								二级支行
							</th>
							<th nowrap="nowrap">
								审批通过笔数
							</th>
							<th nowrap="nowrap">
								其中1次退单率
					       </th>
					       <th nowrap="nowrap">
								其中2次退单率
							</th>
                          <th nowrap="nowrap">
								其中3次退单率
							</th>
                           <th nowrap="nowrap">
								其中4次退单率
							</th>
						</tr>
						<w:radioGroup id="group1">
                           <l:iterate property="list" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
							 <td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="oneCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="loanCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgNameOne" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgNameTwo" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="passNumber" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="backOne" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="backTwo" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="backThree" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="backFour" />
								</td>
							</tr>
						</l:iterate>
						</w:radioGroup>
							<tr>
              <td colspan="23" class="command_sort_area">		
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
		<script type="text/javascript">

		

		//清空
		function clears(){
			$id("appTimeStrat_input").value="";
			$id("appTimeEnd_input").value="";
			$id("oneCategory").value="";
			$id("oneCategoryId").value="";
			$id("loanCategory").value="";
			$id("loanCategoryId").value="";
		}
              
                function search(){
			//$("#isExport").val("");
			
/* 			if(YY==""){     
                alert("请输入年份！");
                return;
				}
			if( MM==""){     
                alert("请输入月份！");
                return;
				} */
        			var frm = $name("appQuery");
                    frm.submit();
    
                    return;
			}
             function downExl() {

  				var appTimeStrat = $id("appTimeStrat").value;
				var appTimeEnd = $id("appTimeEnd").value;
				var oneCategory = $id("oneCategory").value;
				var loanCategory = $id("loanCategory").value;
				
				var url = "/reportjbpm/rateofreturnReportAction_exportExcel.action?";
				if(appTimeStrat!=null){
	     		url = url+"rateofreturnReport.appTimeStrat="+appTimeStrat;
				}
				if(appTimeEnd!=null){
	     		url = url+"&rateofreturnReport.appTimeEnd="+appTimeEnd;
				}
	     		url = url+"&rateofreturnReport.oneCategory="+oneCategory;
	     		url = url+"&rateofreturnReport.loanCategory="+loanCategory;
				window.location.href=url; 
		}
		

		function callBack(){
			var frm = $name("page_form");
            frm.submit();
			//  location.reload(); //就算页面直接关闭，也会重新加载页面
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

		function showloanCategory() {
			var loanCategoryId=document.getElementById("loanCategoryId").value;
			strUrl ="/Generalprocess/tGeneralprocessCdtypeAction_loanCategoryDic.action?cdtypeJson="+loanCategoryId,
			showModalCenter(strUrl,'',showloanCategory_callback1 ,800,500,'贷种选择'); 
		} 
		function showloanCategory_callback1(args){
			if(args!=''){
			var array;
			array = args.split(":");
			 document.getElementById("loanCategoryId").value = array[0];
			 document.getElementById("loanCategory").value = array[1];
			}
		}

  

		
		</script>
		
	</body>
</html>