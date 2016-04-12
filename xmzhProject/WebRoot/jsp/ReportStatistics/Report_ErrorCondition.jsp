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
    
    <title>差错情况统计表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/style.css" type="text/css"></link>
   
  </head>
  
  
  
  
  <script> 
function aa(obj,td_name) 
{ 
 
 
     var select_value=document.getElementById("where"); 
     var td_value = document.getElementById(td_name); 
     if(obj.checked == true){ 
   td_value.className='c1'; //选中时颜色 
          if(select_value.value.length>0){ 
               
               select_value.value+="," + td_value.innerText; 
 
  
          }else{ 
 
 
               select_value.value+=td_value.innerText; 
 
          } 
     }else{ 
td_value.className='c0'; //取消时颜色 
               if(select_value.value.indexOf("," + td_value.innerText + ",") != -1){ 
                         select_value.value = select_value.value.replace("," + 
 
td_value.innerText,'');   
               }else if(select_value.value.indexOf("," + td_value.innerText) != -1){ 
                         select_value.value = select_value.value.replace("," + 
 
td_value.innerText,''); 
               }else if(select_value.value.indexOf(td_value.innerText + ",") != -1){ 
                    select_value.value = select_value.value.replace(td_value.innerText + ",",''); 
               }else if(select_value.value.indexOf(td_value.innerText) != -1){ 
                    select_value.value = select_value.value.replace(td_value.innerText,''); 
               } 
     } 
 
} 
function bb(){ 
     var obj = document.getElementById("ds"); 
     if(obj.style.display==""){ 
          obj.style.display="block"; 
     }else if(obj.style.display=="none"){ 
          obj.style.display="block"; 
     }else if(obj.style.display=="block"){ 
          obj.style.display="none"; 
     } 
     
     } 
     
     function inDaohang(divname,obj){ 
     var f = false; 
     while(obj.parentNode){ 
          if(obj.name==divname){ 
               return true; 
          } 
          obj = obj.parentNode; 
     } 
     return false; 
} 
function closeDaohang(e,divname,aname){ 
     if(e.id!=aname && e.id!='where' && e.id.indexOf("td") ==-1&& e.id.indexOf("check") ==-1) 
     if(!inDaohang(divname,e)){ 
          var a = document.getElementsByName(divname); 
          for(var i=0;i<a.length;i++){ 
               a[i].style.display='none'; 
          } 
 
     } 
 
} 
     
</script> 
<style type="text/css">
.c1{
 background-Color:#dddddd;
//bgColor:#dddddd;
}
.c0{
 background-Color:#ffffff;
//bgColor:#dddddd;
}
 

.menu{ 
    display:none; 
} 
input.blur{ 
     border:1px solid #99BBE8; 
     background:#FFFFFF; 
     height:18px; 
} 
.tableborder{ 
border:solid 1px #CCCCCC; 
border-collapse:collapse; 
font-size:12px; 
 
} 
</style> 
  
  
  
  
  <body>
		<header>
			<h1>信贷二期系统</h1>
		</header>
		<article>
			 <aside style="width:97%; height:410px;">
			   <div>
			   <h2>差错情况统计表</h2>
			   
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
			   <td align="right" bgcolor="#EEF7FF" style="width: 5%">报单日期:
			   </td>
			  <td align="left" bgcolor="#EEF7FF" width="35%" class="style1" colspan="3">
                                <input name="TextBox1" type="date"  id="TextBox1"  style="width:130px;"  />
                            </td>
			  
			   
			   <td align="right" bgcolor="#EEF7FF" style="width: 5%">至
			   </td>
			   <td align="left" bgcolor="#EEF7FF" width="35%" class="style1" colspan="3">
                                <input name="TextBox2" type="date"  id="TextBox2"  style="width:130px;" />
                            </td>
            
			   
			   
			 
			    <td align="right" bgcolor="#EEF7FF" style="width: 5%">
                                客户名称：
                            </td>
                            <td align="left" bgcolor="#EEF7FF" width="35%" class="style1" colspan="3">
                                <input name="TextBox" type="text" value="" id="TextBox"  style="width:60px;" />
                            </td>
                            
                            
                           <td align="right" bgcolor="#EEF7FF" style="width: 5%">
                               差错环节：
                            </td>
                            <td align="left" bgcolor="#EEF7FF" width="15%">
                           


       
               
                    <input type="text" id="where" name="where" style="width:100px" onclick="bb()" 
 
onblur="this.className='blur'" onfocus="this.className='focus'" class="blur" readonly> 
                            
                            <div id="ds" style="display:none;padding:0px 0px 0px 0px; margin:0;"> 
          <table border="0" cellpadding="0" cellspacing="0" class="tableborder"> 
                    <tr><td id="td1"><input type="Checkbox" id="check1" name="idol02" value="1" 
 
onclick="aa(this,'td1')">审查一</td><td id="td6"><input type="Checkbox" id="check6" name="idol02" value="6" 
 
onclick="aa(this,'td6')">合同审核（作业监督岗）</td></tr> 
                    <tr><td id="td2"><input type="Checkbox" id="check2" name="idol02" value="2" 
 
onclick="aa(this,'td2')">审查二</td><td id="td7"><input type="Checkbox" id="check7" name="idol02" value="7" 
 
onclick="aa(this,'td7')">合同审核（前台综合岗）</td></tr> 
                    <tr><td id="td3"><input type="Checkbox" id="check3" name="idol02" value="3" 
 
onclick="aa(this,'td3')">审批一</td><td id="td8"><input type="Checkbox" id="check8" name="idol02" value="8" 
 
onclick="aa(this,'td8')">放款审核</td>   </tr> 

                    <tr><td id="td4"><input type="Checkbox" id="check4" name="idol02" value="4" 
 
onclick="aa(this,'td4')">审批二</td><td id="td9"><input type="Checkbox" id="check9" name="idol02" value="9" 
 
onclick="aa(this,'td9')">支用审批</td>  </tr> 

 <tr><td id="td5"><input type="Checkbox" id="check5" name="idol02" value="5" 
 
onclick="aa(this,'td5')">合同审核（信贷业务主管岗）</td> </tr> 


     </table> 
          </div> 
        
                            
                            
                            
                            
			   
			 <!--   <td align="right" bgcolor="#EEF7FF" style="width: 5%">
                               差错环节：
                            </td>
                            <td align="left" bgcolor="#EEF7FF" width="15%">
                                <select name="cchj" size="1" id="cchj" style="width:120px;">
                                    <option  value="-1" selected="selected">审查一</option>
                                    <option value="0"  >审查二</option>
                                    <option value="1">审批一</option>
                                    <option value="2">审批二</option>
                                    <option value="3">合同审核</option>
                                    <option value="4">合同审核</option>
                                    <option value="5">合同审核</option>
                                    <option value="6">放款审核</option>
                                    <option value="7">支用审批</option>
                                   
                                </select>
                            </td> -->
                            
                    <td>
                    <input id="searchButton" class="inputButton" type="button"  
    value=" 查 询 " />
                    <input type="submit" value="导出EXCEL" id="btndc"/>
                 </td>
                            
                            
                            </tr>
			   
			   
			   
			   <table border="1" class="datalist">
			   	<thead>
			   		<tr>
			   			<td>机构名称</td>
			   			<td>贷种</td>
			   			<td>主调信贷员</td>
			   			<td>辅调信贷员</td>
			   			<td>营业主管</td>
			   			<td>差错情况</td>
			   			<td>扣罚金额</td>
			   			<td>差错次数</td>
			   			<td>差错环节</td>
			   			<td>提出差错人</td>
			   			<td>提出差错时间</td>
			   		
			   		</tr>
			   	</thead>
			   	
			   </table>
			   </div>
			   
			 


		    </aside>
		</article>
		
		
		
		
		

		<footer><h3>版权所有&copy;</h3></footer>
	</body>
</html>
