<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@page language="java" import="com.hotel.DAO.*,com.hotel.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>超限情况统计</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/style.css" type="text/css"></link>






  </head>
 <script>  
function   goUrl(obj){  
if(obj.target=='_blank')window.open(obj.value);  
if(obj.target=='_self')location.href=obj.value;  
}  

</script>
  <body>
  
		<header>
			<h1>信贷二期系统</h1>
		</header>
		<article>
			
			<aside style="width:97%; height:410px;">
			   <div>
			   <h2>超限情况统计</h2>
			   
			   <tr>
			    <td align="right" bgcolor="#EEF7FF" style="width: 5%">报表:
			   </td>
			  
                            <td align="left" bgcolor="#EEF7FF" width="15%">
                            
                            <select   name="ym" size="1" id="ym" style="width:120px;" onchange="window.location.href=this.options[selectedIndex].value">  
<option>请选择</option>  
<option   value="http://localhost:8088/jsp/ReportStatistics/Report_ErrorCondition.jsp" target="_blank">差错情况统计表</option>    
<option   value="http://localhost:8088/jsp/ReportStatistics/Report_DealApproval.jsp"   target="_self">受理审批台账</option>  
<option   value="http://localhost:8088/jsp/ReportStatistics/Report_Jobworkload.jsp"   target="_self">岗位工作量统计表</option>  
<option   value="http://localhost:8088/jsp/ReportStatistics/Report_Rateofreturn.jsp"   target="_self">退单率统计表</option> 
<option   value="http://localhost:8088/jsp/ReportStatistics/Report_Refusalrate.jsp"   target="_self">拒贷率统计表</option> 
<option   value="http://localhost:8088/jsp/ReportStatistics/Report_CooperateInstitution.jsp"   target="_self">合作机构业务发展台账</option> 
<option   value="http://localhost:8088/jsp/ReportStatistics/Report_OverrunCondition.jsp"   target="_self">超限情况统计表</option> 
</select>     

                            
                               
                            </td>
                            
                    <td>
                    <input id="searchButton" class="inputButton" type="button"  
    value=" 查 询 " />
                    <input type="submit" value="导出EXCEL" id="btndc"/>
                 </td>
                            
                  
                            
                        
                            
                            </tr>
			   
			   
			   <div style="position:absolute; overflow-y:auto; overflow-x:auto; width:80%; height:410px;">
			   <table border="1" class="datalist">
			   	<thead>
			   		<tr>
			   			<td>时间</td>
			   			<td>超限环节</td>
			   			<td>客户名称</td>
			   			<td>贷种</td>
			   			<td>机构</td>
			   			<td>超限人员</td>
			   			<td>超限时长</td>
			   			<td>备注</td>
			   			
			   		</tr>
			   	</thead>
			   
			   </table>
			   </div>
			   </div>
		    </aside>
		</article>
		
		<footer><h3>版权所有&copy;</h3></footer>
		
		
		
		
		
	</body>
</html>
