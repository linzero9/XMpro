<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp" %>
<%@page import="java.util.*"%>
<h:css href="/css/style1/style-custom.css"/>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>
      人员信息查询列表
    </title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <style>
  	.command_sort_area .h3{
  		float: left;
  	}
  	.command_sort_area .h4{
  		float: right;
  	}
  </style>
  <body style="margin: 0px;">
  
  
  	<e:datasource name="omInformation" type="bean" path="com.gotop.peopleManagement.model.OmInformation"/>
  	<queryform id="8cf82903-39b3-4dd6-9c1e-ffaff96fa1af">
		<h:form name="form1" action="/peopleManagement/omInformationAction_queryOmInformationList.action"
			checkType="blur" target="_self" method="post" onsubmit="return checkForm(this);">
			<w:panel id="panel1" width="100%" title="查询条件" expand="true">
			<table align="center" border="0" width="100%" class="form_table">
					<tr>
						<td class="form_label" align="right">人员姓名：</td>
						<td colspan="1">
							<h:text id="empName" property="omInformation.empName" style="width:148px;" />
						</td>
						<td class="form_label"  align="right">人员工号：</td>
						<td colspan="1">
							<h:text id="empCode" property="omInformation.empCode" style="width:148px;" />
						</td>
					</tr>
					
					<tr>
						<td class="form_label" align="right">机构名称：</td>
						<td colspan="1">
							<h:text id="orgName" property="omInformation.orgName" style="width:148px;" />
							<a href="#" onclick="showErrorlink1()">选择</a>
						</td>
						<td class="form_label"  align="right">业务角色：</td>
						<td colspan="1">
							<h:text id="roleName" property="omInformation.roleName" style="width:148px;" />
							<a href="#" onclick="showErrorlink2()">选择</a>
						</td>
					</tr>
					
					<tr>
						<td class="form_label" align="right">岗位名称：</td>
						<td colspan="1">
							<h:text id="posiName" property="omInformation.posiName" style="width:148px;" />
							<a href="#" onclick="showErrorlink3()">选择</a>
						</td>
					</tr>
					
					<tr class="form_bottom">
						<td colspan="4" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="submit" value="查 询" class="button">
							<input type="button" value="清 空" class="button" onclick="clears();"></td>
					</tr>
				</table>
			</w:panel>
		</h:form>
	</queryform>
	 <h:form name="data_form" action="/peopleManagement/omInformationAction_queryOmInformationList.action" method="post">
            <h:hiddendata property="omInformation"/>
            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
           <table align="center" border="0" width="100%" class="EOS_table">
           <tr>
		       <td colspan="7" class="eos-panel-title">&nbsp;人员信息查询结果</td>
		      </tr>
           <tr>
	            <th align="center">
	              <l:greaterThan property="page.count" targetValue="0" compareType="number">
	                 <h:checkbox id="xuanze" onclick="allItem();"/>
	              </l:greaterThan>
	              <b:message key="l_select"></b:message>
	            </th>
	            <!-- 
	            <th>   
	              <b:message key="positionManager_OmPosition.posiname"></b:message>
	            </th>
	            <th>
	              <b:message key="positionManager_OmPosition.posicode"></b:message>
	            </th>	
	             -->
	               <th>
	            	人员姓名
	            </th> 
	            <th>   
	              	性别
	            </th>           
	            <th>   
	              	人员工号
	            </th>
	            <th>
	            	所属单位
	            </th>            
	            <th>   
	              	人员状态
	            </th>
	            
	            <th>   
	              	手机号
	            </th>
	          </tr>
          <w:checkGroup id="group1">
          <l:iterate property="omInformationList" id="id1">
              <tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
               <td align="center">
                    <w:rowCheckbox>
                        <h:param name='empid' iterateId='id1' property='empid'/>
                         <h:param name='orgid' iterateId='id1' property='orgid'/>
                          <h:param name='userid' iterateId='id1' property='userid'/>
                    </w:rowCheckbox>
                </td> 
                            
                <td>  
                  <b:write iterateId="id1" property="empName"/>
                </td>
                  <td>
                	<d:write iterateId="id1"  property="gender" dictTypeId="ABF_GENDER"/>
                </td>
                <td>  
                  <b:write iterateId="id1" property="empCode"/>
                </td>
                <td>
                	<b:write iterateId="id1"  property="orgName"/>
                </td>
                <td>
                	<d:write iterateId="id1"  property="empStatus" dictTypeId="ABF_EMPSTATUS"/> 
                </td>
                 <td>
                	<b:write iterateId="id1" property="mobileNo"/>
                </td>
                </tr>
            </l:iterate>
            </w:checkGroup>
            <tr>
              <td colspan="7" class="command_sort_area">
              	<div class="h3">
	              
	                <l:greaterThan property="page.count" targetValue="0" compareType="number" >
	                   <input type="button" class="button" value="人员维护" onclick="updateRecord();"  id="updateButton">
	                </l:greaterThan>
	                <l:greaterThan property="page.count" targetValue="0" compareType="number" >
	                   <input type="button" class="button" value="所属机构的修改维护" onclick="updateRecord2();"  id="updateButton">
	                </l:greaterThan>
                </div>
                
                
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
	                <input type="button" class="button" onclick="firstPage('page', '', null, null, 'data_form');" value='<b:message key="l_firstPage"></b:message>'  <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
	                <input type="button" class="button" onclick="prevPage('page', '', null, null, 'data_form');" value='<b:message key="l_upPage"></b:message>' <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
	                <input type="button" class="button" onclick="nextPage('page', '', null, null, 'data_form');" value='<b:message key="l_nextPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                <l:equal property="page.isCount" targetValue="true">
	                  <input type="button" class="button" onclick="lastPage('page', '', null, null, 'data_form');" value='<b:message key="l_lastPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                </l:equal>
              </div>
              </td>
            </tr>
            </table>
          </h:form> 
        <script type="text/javascript">
        	
		        
		        //所属机构的修改维护
		        function updateRecord2(){
		        	var gop = $id("group1");
			  		var len = gop.getSelectLength();
			  		if(len == 0){
			  			alert("至少选择一位人员信息");
			  			return;
			  		} else if(len > 1){
			  			alert("只能选择一位人员信息进行修改");
			  			return;
			  		}else{
			  			var rows = gop.getSelectRows();	  			
	  					var orgId = rows[0].getParam("orgid");
	  					var empid = rows[0].getParam("empid");
			        	var strUrl = "/jsp/tyjg/empMngr/empopr_belong_maintain.jsp?empid="+empid+"&orgId="+orgId;
			        	showModalCenter(strUrl, null, callBack, 850, 500, '人员维护信息');  
		        	}
		        }

		        //人员维护
		        function updateRecord(){
		        	var gop = $id("group1");
			  		var len = gop.getSelectLength();
			  		if(len == 0){
			  			alert("至少选择一位人员信息");
			  			return;
			  		} else if(len > 1){
			  			alert("只能选择一位人员信息进行修改");
			  			return;
			  		}else{
			  			var rows = gop.getSelectRows();
	  					var userid = rows[0].getParam("userid");
	  					var orgId = rows[0].getParam("orgid");
	  					var empid = rows[0].getParam("empid");
			        	var strUrl = "/empMngr/queryEmpBaseAndFjxx_empMngr.action?empid="+empid+"&orgId="+orgId+"&userid="+userid+"&sNodetype=emp"+"&execType=update"+"&_ts=" +new Date();
			        	showModalCenter(strUrl, null, callBack, 850, 500, '人员维护信息');  
		        	}
		        }
		        
		        function callBack(){
		        	$id("querys").click();
		        }
		        function clears(){
					$id("orgName").value="";
					$id("empName").value="";
					$id("empCode").value="";
					$id("roleName").value="";
					$id("posiName").value="";
				}
				function allItem(){
					var group =$id("group1");
					if(document.getElementById("xuanze").checked){
						group.selectAll();
					}else{
						group.disSelectAll();
					}
				}

			  	function showErrorlink1() {
			  		var orgName=document.getElementById("orgName").value;
					strUrl ="/peopleManagement/omInformationAction_queryOrgName.action?omInformation.orgName="+orgName;
					showModalCenter(encodeURI(strUrl),'',showErrorlink_callback1 ,900,500,'机构选择'); 
				} 

			  	function showErrorlink_callback1(returnValue){
					if(returnValue == ""){
						//点击右上角关闭时,returnValue为null
						//不做操作
						$id("orgName").value="";
					}else{
						$id("orgName").value= returnValue[0];
					

					}
					}

			  	function showErrorlink2() {
			  		var roleName=document.getElementById("roleName").value;
					strUrl ="/peopleManagement/omInformationAction_queryRoleName.action";
					showModalCenter(encodeURI(strUrl),'',showErrorlink_callback2 ,900,400,'业务角色选择'); 
				} 

			  	function showErrorlink_callback2(returnValue){
					if(returnValue == ""){
						//点击右上角关闭时,returnValue为null
						//不做操作
						$id("roleName").value="";
					}else{
						$id("roleName").value= returnValue[0];
					

					}
					}

			  	function showErrorlink3() {
			  		var posiName=document.getElementById("posiName").value;
					strUrl ="/peopleManagement/omInformationAction_queryPosiName.action";
					showModalCenter(encodeURI(strUrl),'',showErrorlink_callback3 ,900,500,'岗位选择'); 
				} 
			  	function showErrorlink_callback3(returnValue){
					if(returnValue == ""){
						//点击右上角关闭时,returnValue为null
						//不做操作
						$id("posiName").value="";
					}else{
						$id("posiName").value= returnValue[0];
					

					}
					}
        </script>
  </body>
</html>
