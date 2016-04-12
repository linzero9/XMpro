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
    
    <title>受理审批台账</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/style.css" type="text/css"></link>


  </head>
  
  <body>
		<header>
			<h1>信贷二期系统
		<table></table>
	</h1>
		</header>
		<article>
			<!--  <section>
				<ul>
					<li><a href="Main.jsp">首页</a></li>
					<li ><a  href="ccqk.jsp">差错情况统计表</a></li>
					<li id="li2"><a>受理审批台账</a></li>
					<li><a href="gwgzl.jsp">岗位工作量统计表</a></li>
					<li><a href="tdltj.jsp">退单率统计表</a></li>
					<li><a href="jdltj.jsp">拒贷率统计表</a></li>
					<li><a href="hzjgyw.jsp">合作机构业务发展台账</a></li>
					<li><a href="cxqktj.jsp">超限情况统计表</a></li>
					
				</ul>
			</section>
			<aside>-->
			 <aside style="width:97%; height:410px;">
			   <div>
			   <h2>受理审批台账</h2>
			   
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
			   <td align="right" bgcolor="#EEF7FF" style="width: 5%">上报日期：
			   </td>
			  <td align="left" bgcolor="#EEF7FF" width="35%" class="style1" colspan="3">
                                <input name="TextBox1" type="date"  id="TextBox1"  style="width:130px;"  />
                            </td>
			  
			   
			   <td align="right" bgcolor="#EEF7FF" style="width: 5%">审批日期：
			   </td>
			   <td align="left" bgcolor="#EEF7FF" width="35%" class="style1" colspan="3">
                                <input name="TextBox2" type="date"  id="TextBox2"  style="width:130px;" />
                            </td>
                             <td>
                    <input id="searchButton" class="inputButton" type="button"  
    value=" 查 询 " />
                    <input type="submit" value="导出EXCEL" id="btndc"/>
                 </td>
                            </tr>
			   
			   <div style="position:absolute; overflow-y:auto; overflow-x:auto; width:100%; height:410px;">
			   
			   <!--<table border="1" class="datalist">
			   	<thead>
			   		<tr>
			   			<td>报单时间</td>
			   			<td>是否加急</td>
			   			<td>客户姓名</td>
			   			<td>是否老客户</td>
			   			<td>一级分类</td>
			   			<td>贷款种类</td>
			   			<td>申请币别</td>
			   			<td>申请金额（万元）</td>
			   			<td>区支行</td>
			   			<td>受理支行</td>
			   			<td>营销人员</td>
			   			<td>主调</td>
			   			<td>辅调</td>
			   			<td>审查人</td>
			   			<td>第二审查人</td>
			   			<td>调查时间</td>
			   			<td>  <table ><tr ><td>一次上报</td></tr>
			   			<tr><th colspan="2">接收</th><td>退回</td></tr> 
			  
			   </table></td>
			   			<td>二次上报时间</td>
			   			<td>  <table ><tr><td>二次上报</td></tr>
			   			<tr><th colspan="2">接收</th><td>退回</td></tr> 
			  
			   </table></td>
			   			<td>三次上报时间</td>
			   			<td>  <table ><tr><td>三次上报</td></tr>
			   			<tr><th colspan="2">接收</th><td>退回</td></tr> 
			  
			   </table></td>
			   			
			   			<td>四次上报时间</td>
			   			<td>  <table ><tr><td>四次上报</td></tr>
			   			<tr><th colspan="2">接收</th><td>退回</td></tr> 
			  
			   </table></td>
			   			<td>五次上报时间</td>
			   			<td>  <table ><tr><td>五次上报</td></tr>
			   			<tr><th colspan="2">接收</th><td>退回</td></tr> 
			  
			   </table></td>
			   			<td>审查岗审结时间</td>
			   			<td>审批方式</td>
			   			<td>决策单编号</td>
			   			<td>会议期数</td>
			   			<td>表决表编号</td>
			   			<td>会议时间/审批岗审结时间</td>
			   			<td>审议事项</td>
			   			<td>贷审会秘书一</td>
			   			<td>贷审会秘书二</td>
			   			<td>第一审批人（会议审批委员）</td>
			   			<td>第二审批人（会议审批委员）</td>
			   			<td>会议审批主任委员</td>
			   			<td>会议审批委员</td>
			   			<td>会议审批委员</td>
			   			<td>上会地点</td>
			   			<td>风险类型（低/非低风险业务）</td>
			   			<td>审批类型</td>
			   			<td>有表决权人数</td>
			   			<td>会议审议结论</td>
			   			<td>评级结论</td>
			   			<td>风险限额（万元）</td>
			   			<td>额度授信金额（万元）</td>
			   			<td>业务金额（万元）</td>
			   			<td>批复日期</td>
			   			<td>备注</td>
			   		</tr>
			   		
			  </thead>
			   
			   </table> -->	
			   
			   
			   
			     <table border="1" class="datalist">
			   	<thead>
			   
			   <tr>
			             <th rowspan="2">报单时间</th>
			   			 <th rowspan="2">是否加急</th>
			   			 <th rowspan="2">客户姓名</th>
			   			 <th rowspan="2">是否老客户</th>
			   			 <th rowspan="2">一级分类</th>
			   			 <th rowspan="2">贷款种类</th>
			   			 <th rowspan="2">申请币别</th>
			   			 <th rowspan="2">申请金额（万元）</th>
			   			 <th rowspan="2">区支行</th>
			   			 <th rowspan="2">受理支行</th>
			   			 <th rowspan="2">营销人员</th>
			   			 <th rowspan="2">主调</th>
			   			 <th rowspan="2">辅调</th>
			   			 <th rowspan="2">审查人</th>
			   			 <th rowspan="2">第二审查人</th>
			   <th rowspan="2">调查时间</th>
			   <th colspan="2">一次上报</th>
			   <th  rowspan="2">二次上报时间</th>
			   <th colspan="2">二次上报</th>
			   <th  rowspan="2">三次上报时间</th>
			    <th colspan="2">三次上报</th>
			   <th  rowspan="2">四次上报时间</th>
			    <th colspan="2">四次上报</th>
			   <th  rowspan="2">五次上报时间</th>
			    <th colspan="2">五次上报</th>
			    <th  rowspan="2">审查岗审结时间</th>
			   			 <th  rowspan="2">审批方式</th>
			   			 <th  rowspan="2">决策单编号</th>
			   			<th  rowspan="2">会议期数</th>
			   			 <th  rowspan="2">表决表编号</th>
			   			 <th  rowspan="2"> 会议时间/审批岗审结时间</th>
			   			<th  rowspan="2">审议事项</th>
			   			 <th  rowspan="2">贷审会秘书一</th>
			   			 <th  rowspan="2">贷审会秘书二</th>
			   			 <th  rowspan="2">第一审批人（会议审批委员）</th>
			   			 <th  rowspan="2">第二审批人（会议审批委员）</th>
			   			 <th  rowspan="2">会议审批主任委员</th>
			   			 <th  rowspan="2">会议审批委员</th>
			   			 <th  rowspan="2">会议审批委员</th>
			   			 <th  rowspan="2">上会地点</th>
			   			<th  rowspan="2">风险类型（低/非低风险业务）</th>
			   			 <th  rowspan="2">审批类型</th>
			   			 <th  rowspan="2">有表决权人数</th>
			   			 <th  rowspan="2">会议审议结论</th>
			   			 <th  rowspan="2">评级结论</th>
			   			 <th  rowspan="2">风险限额（万元）</th>
			   			 <th  rowspan="2">额度授信金额（万元）</th>
			   			<th  rowspan="2">业务金额（万元）</th>
			   			<th  rowspan="2">批复日期</th>
			   			 <th  rowspan="2">备注</th>
			   </tr>
			   <tr>
			   <th>接收</th>
			   <th>退回</th>
			   <th>接收</th>
			   <th>退回</th>
			   <th>接收</th>
			   <th>退回</th>
			   <th>接收</th>
			   <th>退回</th>
			   <th>接收</th>
			   <th>退回</th>
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
