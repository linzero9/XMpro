<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>拒贷率统计列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/reportRefusalrateAction_queryReportRefusalRate.action" method="post">
	<h:hidden property="nameString" id="nameString" />
	<h:hidden property="isExport" id="isExport"/>
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
                                        <td class="form_label" align="right" width="20%">报单日期：</td>
					<td colspan="1" width="30%">
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="stratdate" name="reportRefusalrate.stratdate" 
					property="reportRefusalrate.stratdate" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="enddate" name="reportRefusalrate.enddate" 
					property="reportRefusalrate.enddate" /></td>

					
					
					<td class="form_label" align="right" >一级分类：</td>
					<td >
			     		<h:hidden id="oneCategoryId" property="reportRefusalrate.oneCategoryId" />  
						<h:text id="oneCategoryTxt" property="reportRefusalrate.oneCategoryTxt" readonly="true"/>
						<a href="#" onclick="showoneCategory();">选择</a>
					</td>
					
					<td class="form_label" align="right" >贷种分类：</td>
					<td >
						<h:hidden id="loanCategoryId" property="reportRefusalrate.loanCategoryId" />
						<h:text id="loanCategoryTxt" property="reportRefusalrate.loanCategoryTxt" readonly="true"/>
						<a href="#" onclick="showloanCategory();">选择</a>
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
                            <input id="downexl" type="button" class="button" value="导出列表" onclick="downExl();"></td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="拒贷率统计列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/ReportStatistics/reportRefusalrateAction_queryReportRefusalRate.action" method="post">
			 <h:hiddendata property="reportRefusalrate"/>  
			 <h:hiddendata property="reportRefusalrate.stratdate" />
				<h:hiddendata property="reportRefusalrate.enddate" />
                <h:hiddendata property="reportRefusalrate.oneCategoryId" />
				<h:hiddendata property="reportRefusalrate.oneCategoryTxt" />
				<h:hiddendata property="reportRefusalrate.loanCategoryId" />
				<h:hiddendata property="reportRefusalrate.loanCategoryTxt" />
            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">
		    
						<tr>
							<th align="center" nowrap="nowrap">
								<b:message key="l_select"></b:message>
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
								本月上报审批笔数
							</th>
							<th nowrap="nowrap">
								本月拒贷笔数
					       </th>
					       <th nowrap="nowrap">
								本月拒贷率
							</th>
                                                 
						</tr>
						<w:radioGroup id="group1">
                           <l:iterate property="list" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap">
									<w:rowRadio>
										<h:param name='executionId' iterateId='id1' property='executionId' />
										<h:param name='loancategory' iterateId='id1' property='loancategory' />
										<h:param name='orgname' iterateId='id1' property='orgname' />
										<h:param name='orgnametwo' iterateId='id1' property='orgnametwo' />
										<h:param name='EA_number' iterateId='id1' property='EA_number' />
										<h:param name='rejection_number' iterateId='id1' property='rejection_number' />
										<h:param name='refusalrate' iterateId='id1' property='refusalrate'/>
									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="loanCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgname"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgnametwo" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="EA_number"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="rejection_number" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="refusalrate" />
								</td>
							</tr>
						</l:iterate>
						</w:radioGroup>
							<tr>
              <td colspan="23" class="command_sort_area">
              	<!--  <div class="h3"> 
              	<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
									<input type="button" class="button" value="修改拒贷率信息" onclick="upt_loan_info();"/>
								</l:greaterThan>
							
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
							<input type="button" class="button" value="查看修改明细" onclick="queryLoanUptWater();"/>
								</l:greaterThan>
								</div>-->
							
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
			$("#stratdate_input").val("");
			$("#stratdate_hidden").val("");
			$("#enddate_input").val("");
			$("#enddate_hidden").val("");
			$id("oneCategoryTxt").value="";
			$id("oneCategoryId").value="";
			$id("loanCategoryTxt").value="";
			$id("loanCategoryId").value="";
		}
                function search(){
			$("#isExport").val("");
			}
               
		//导出excel 	
             function downExl(){
             
             //alert('ssssss');
    				//报单开始日期
    				var stratdate = $id("stratdate").value;
    				//报单结束日期
    				var enddate = $id("enddate").value;
    				//一级分类
    				var oneCategoryTxt = $id("oneCategoryTxt").value;
    				//贷种分类
    				var loanCategoryTxt = $id("loanCategoryTxt").value;
    				
    				
    				var strUrl = "/reportjbpm/reportRefusalrateAction_queryReportRefusalrateExcel.action?"
    				+"&reportRefusalrate.stratdate="+stratdate
    				+"&reportRefusalrate.enddate="+enddate
    				+"&reportRefusalrate.oneCategoryTxt="+oneCategoryTxt
    				+"&reportRefusalrate.loanCategoryTxt="+loanCategoryTxt
    				//alert(strUrl);
    				window.location.href=strUrl;
    			}
		
		 /*function upt_loan_info(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条流程信息");
	  			return;
	  		}else{
	  			var row=gop.getSelectRow();
		  		var executionId = row.getParam("executionId");
		  		var loan = row.getParam("loan");
		  		var areasubbranch = row.getParam("areasubbranch");
		  		var secondarysubbranch = row.getParam("secondarysubbranch");
		  		var EA_number = row.getParam("EA_number");
		  		var rejection_number = row.getParam("rejection_number");
		  		var refusalrate = row.getParam("refusalrate");

	            var strUrl = "/ReportStatistics/reportRefusalrateAction_toUptLoanInfo.action?reportRefusalrate.executionId="+executionId+"&reportRefusalrate.loan="+loan;
	            strUrl = strUrl+"&reportRefusalrate.areasubbranch="+areasubbranch
	            +"&reportRefusalrate.secondarysubbranch="+secondarysubbranch
	            +"&reportRefusalrate.EA_number="+EA_number
	            +"&reportRefusalrate.rejection_number="+rejection_number
	            +"&reportRefusalrate.refusalrate="+refusalrate;
	            
				  showModalCenter(encodeURI(strUrl), null,callBack, 500, 300, '修改拒贷率信息');
				  
				  /* 	var url="/jbpm/xdProcessAction_toAddOneCategory.action?xdCdtypeBean.processName="+encodeURI(processName);
		  		parent.window.frames["mainFrame"].location.href = encodeURI(strUrl); 
		  		
		  		showModalCenter(encodeURI(strUrl), null, callBack, clientX*0.9, clientY*0.9, ''修改拒贷率信息');
			}
		}*/	
		function callBack(){
			var frm = $name("page_form");
            frm.submit();
			//  location.reload(); //就算页面直接关闭，也会重新加载页面
			}

	   /*	function queryLoanUptWater(){
	  		var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条流程信息");
	  			return;
	  		}else{
	  			var rows=gop.getSelectRow();
		  		var executionId = rows.getParam("executionId");
		  		var strUrl = "/ReportStatistics/reportRefusalrateAction_queryLoanUptWater.action?waterInfo.flow_id="+executionId;
		  		showModalCenter(strUrl,'',null ,1200,500,'拒贷率修改流水明细');
			  	}
		  	}*/	

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
			 document.getElementById("oneCategoryTxt").value = array[1];
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
			 document.getElementById("loanCategoryTxt").value = array[1];
			}
		}
		</script>
		
	</body>
</html>