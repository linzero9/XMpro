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
    
    <title>拒贷率统计表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/style.css" type="text/css"></link>


  </head>
  
  <body>
		<header>
			<h1>信贷二期系统</h1>
		</header>
		<article>
			 <aside style="width:97%; height:410px;">
			   <div>
			   <h2>拒贷率统计表</h2>
			    <form name="form1"  method="post">
			   
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
                                <input name="TextBox1" type="date"  id="TextBox1"  style="width:130px;" />
                            </td>
			  
			   
			   <td align="right" bgcolor="#EEF7FF" style="width: 5%">至
			   </td>
			   <td align="left" bgcolor="#EEF7FF" width="35%" class="style1" colspan="3">
                                <input name="TextBox2" type="date"  id="TextBox2"  style="width:130px;"  />
                            </td>
            
			   
			   
			 
		
			   
			   <td align="right" bgcolor="#EEF7FF" style="width: 5%">
                               一级分类
                            </td>
                            <td align="left" bgcolor="#EEF7FF" width="15%">
                                <select name="yjfl" size="1" id="yjfl" style="width:120px;"    required> 
                                    <option value="" selected="selected">请选择</option>
                                    <option value="0">一手房</option>
                                    <option value="1">二手房</option>
                                    <option value="2">车贷</option>
                                    <option value="3">公积金组合贷</option>
                                    <option value="4">存单质押贷</option>
                                    <option value="5">再就业小额担保贷款</option>
                                    <option value="6">小额</option>
                                    <option value="7">综消、信用贷、留学贷</option>
                                   <option value="8">小额支用</option>
                                   <option value="9">综消、信用贷支用</option>
                                   <option value="10">个商（500万元以下）</option>
                                   <option value="11">个商（500万元以上（含））</option>
                                   <option value="12">经营性车辆</option>
                                   <option value="13">快捷贷</option>
                                   <option value="14">个商支用</option>
                                   <option value="15">一般风险小企业（含快捷贷）</option>
                                   <option value="16">低风险小企业</option>
                                   <option value="17">担保公司准入</option>
                                   <option value="18">小企业业务变更</option>
                                   <option value="19">票据承兑</option>
                                   <option value="20">小企业单笔支用审批</option>
                                   <option value="21">风险额度重检</option>
                                   <option value="22">E捷贷</option>
                                   <option value="23">一手房项目准入</option>
                                   <option value="24">供应链金融业务（非同一核心企业）</option>
                                   <option value="25">供应链金融业务（同一核心企业）</option>
                                   <option value="26">综合授信、项目融资、非低风险贸易融资</option>
                                   <option value="27">集团授信</option>
                                   <option value="28">票据大管家池融资业务</option>
                                   <option value="29">商票贴现</option>
                                   <option value="30">同业授信</option>
                                   <option value="31">公司业务变更</option>
                                   <option value="32">低风险公司授信业务</option>
                                   <option value="33">供应链金融业务（非同一核心企业）</option>
                                   <option value="34">供应链金融业务（同一核心企业）</option>
                                   <option value="35">供应链金融业务项下单笔支用</option>
                                   <option value="36">综合授信、项目融资、非低风险贸易融资</option>
                                    <option value="37">综合授信项下单笔支用</option>
                                     <option value="38">集团授信</option>
                                      
                                </select>
                            </td>*
                            <td align="right" bgcolor="#EEF7FF" style="width: 5%">
                               贷种分类
                            </td>
                            <td align="left" bgcolor="#EEF7FF" width="15%">
                                <select name="dzfl" size="1" id="dzfl" style="width:120px;"  required>
                                     <option value="" selected="selected">请选择</option>
                                    <option value="0">个人一手住房贷款、个人一手商业用房贷款</option>
                                    <option value="1">个人二手住房贷款、个人二手商业用房贷款</option>
                                    <option value="2">个人汽车消费贷款</option>
                                    <option value="3">一手住房公积金委托贷款、二手住房公积金委托贷款</option>
                                    <option value="4">存单质押贷</option>
                                    <option value="5">再就业小额担保贷款</option>
                                    <option value="6">小额循环贷、家庭农场（专业大户）贷款</option>
                                    <option value="7">个人综合消费贷款、个人信用消费贷款、留学贷款</option>
                                   <option value="8">小额循环贷、家庭农场（专业大户）贷款</option>
                                   <option value="9">个人综合消费贷款、个人信用消费贷款</option>
                                   <option value="10">个商（500万元以下）</option>
                                   <option value="11">个商（500万元以上（含））</option>
                                   <option value="12">个商经营性车辆</option>
                                   <option value="13">个商快捷贷</option>
                                   <option value="14">个商支用</option>
                                   <option value="15">小企业快捷贷、小企业法人按揭贷款、小企业经营性车辆贷款</option>
                                   <option value="16">小企业流动资金贷款</option>
                                   <option value="17">其他小企业贷款</option>
                                   <option value="18">小企业快捷贷、小企业法人按揭贷款、小企业经营性车辆贷款</option>
                                   <option value="19">小企业流动资金贷款</option>
                                   <option value="20">担保公司准入</option>
                                   <option value="21">小企业快捷贷、小企业法人按揭贷款、小企业经营性车辆贷款、小企业流动资金贷款</option>
                                   <option value="22">非全额担保票据承兑</option>
                                   <option value="23">小企业单笔支用</option>
                                   <option value="24">风险额度重检</option>
                                   <option value="25">个商E捷贷</option>
                                   <option value="26">一手房项目准入</option>
                                   <option value="27">供应链金融业务（非同一核心企业）</option>
                                   <option value="28">供应链金融业务（同一核心企业）</option>
                                   <option value="29">国际业务综合额度</option>
                                   <option value="30">公司业务单一客户综合授信额度、项目贷款、银团贷款</option>
                                   <option value="31">公司业务集团客户综合授信额度</option>
                                   <option value="32">全额担保票据承兑</option>
                                   <option value="33">票据大管家池融资业务</option>
                                   <option value="34">商票贴现</option>
                                   <option value="35">同业授信</option>
                                   <option value="36">公司业务变更</option>
                                   <option value="37">国际业务低风险业务、公司业务低风险业务</option>
                                   <option value="38">供应链金融业务（非同一核心企业）</option>
                                   <option value="39">供应链金融业务（同一核心企业）</option>
                                   <option value="40">供应链金融业务项下单笔支用</option>
                                   <option value="41">国际业务综合额度</option>
                                   <option value="42">公司业务单一客户综合授信额度、项目贷款、银团贷款</option>
                                    <option value="43">国际业务综合额度项下单笔、公司业务综合授信额度项下单笔</option>
                                     <option value="44">公司业务集团客户综合授信额度</option>
                                      <option value="45">公司业务变更</option>
                                   
                                </select>
                            </td>*
                             <td>
                   <input id="searchButton" class="inputButton" type="submit"  onclick="test();"  
    value=" 查 询 " />
                    <input type="submit" value="导出EXCEL" id="btndc"/>
                 </td>
                            </tr>
			   
			   </form>
			   
			   <table border="1" class="datalist">
			   	<thead>
			   		<tr>
			   			
			   			<td>贷种</td>
			   			<td>区支行</td>
			   			<td>二级支行</td>
			   			<td>本月上报审批笔数</td>
			   			<td>本月拒贷笔数</td>
			   			<td>本月拒贷率</td>
			   			
			   			
			   		</tr>
			   	</thead>
			   	
			   </table>
			   </div>
		    </aside>
		</article>
		
		<footer><h3>版权所有&copy;</h3></footer>
		<script type="text/javascript">
		function test(){
		var frm =$name("form");
		var aa=$id("dzfl").value;
		var bb=$id("yjfl").value;
		if(aa == null && aa=="")
		{
			alert('guhg');
			return false;
			}
			frm.submit();
		}
		if(bb == null && bb=="")
		{
			alert('guhg');
			return false;
			}
			frm.submit();
		}
		</script>
	</body>
</html>
