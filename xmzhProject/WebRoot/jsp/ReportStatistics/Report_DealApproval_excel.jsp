<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://eos.primeton.com/tags/logic" prefix="l"%>
<%@ taglib uri="http://eos.primeton.com/tags/bean" prefix="b"%>
<%@ taglib uri="http://eos.primeton.com/tags/dict" prefix="d"%>
<%@ taglib uri="http://eos.primeton.com/tags/html" prefix="h"%>
<%@page import="com.gotop.util.time.TimeUtil"%>
<%
	response.setContentType("application/x-msdownload;charset=UTF-8");
	//设置Excel的名称;	
	String date = TimeUtil.today()+TimeUtil.now();
	response.setHeader("Content-Disposition",
			"attachment; filename=\""+date+".xls\"");
	out.flush();
%>
<table width="98%" border="1" cellspacing="1" cellpadding="1">
	<tr height="34">
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">机构名称</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">报单时间</th>
		<th height="34" width="200" align="center" class="form_label"  rowspan="2">是否加急</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">客户姓名</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">是否老客户</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">一级分类</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">贷款种类</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">申请币别</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">申请金额（万元）</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">区支行</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">受理支行</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">营销人员</th>
		<th height="34" width="200" align="center" class="form_label"  rowspan="2">主调信贷员</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">辅调信贷员</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">审查人</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">第二审查人</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">调查时间</th>
		<th height="34" width="100" align="center" class="form_label" colspan="2">一次上报</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">二次上报时间</th>
		<th height="34" width="100" align="center" class="form_label" colspan="2">二次上报</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">三次上报时间</th>
		<th height="34" width="100" align="center" class="form_label" colspan="2">三次上报</th>
		<th height="34" width="200" align="center" class="form_label"  rowspan="2">四次上报时间</th>
		<th height="34" width="100" align="center" class="form_label" colspan="2">四次上报</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">五次上报时间</th>
		<th height="34" width="100" align="center" class="form_label" colspan="2">五次上报</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">审查岗审结时间</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">审批方式</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">决策单编号</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">会议期数</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">表决表编号</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2"> 会议时间/审批岗审结时间</th>
		<th height="34" width="200" align="center" class="form_label"  rowspan="2">审议事项</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">贷审会秘书一</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">贷审会秘书二</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">第一审批人（会议审批委员）</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">第二审批人（会议审批委员）</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">会议审批主任委员</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">会议审批委员</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">上会地点</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">风险类型（低/非低风险业务）</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">审批类型</th>
		<th height="34" width="200" align="center" class="form_label"  rowspan="2">有表决权人数</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">会议审议结论</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">评级结论</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">风险限额（万元）</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">额度授信金额（万元）</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">业务金额（万元）</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">批复日期</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="2">备注</th>
		
	</tr>
			   <tr>
		<th height="34" width="100" align="center" class="form_label">接收</th>
		<th height="34" width="100" align="center" class="form_label">退回</th>
		<th height="34" width="100" align="center" class="form_label">接收</th>
		<th height="34" width="100" align="center" class="form_label">退回</th>
		<th height="34" width="100" align="center" class="form_label">接收</th>
		<th height="34" width="100" align="center" class="form_label">退回</th>
		<th height="34" width="100" align="center" class="form_label">接收</th>
		<th height="34" width="100" align="center" class="form_label">退回</th>
		<th height="34" width="100" align="center" class="form_label">接收</th>
		<th height="34" width="100" align="center" class="form_label">退回</th>	  
				</tr>
	<l:iterate property="approvalList" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id1">
			  
			 					<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1"    property="nextOrgName" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="reportTime" />
								</td>
								<td style="vnd.ms-excel.numberformat:@">
								<d:write iterateId="id1" property="isurgent" dictTypeId="ZHPT_ISURGENT" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="custName" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="oldCust" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="oneCategory" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1"    property="loanCategory" />
								</td>
								
								<td style="vnd.ms-excel.numberformat:@">
								<d:write iterateId="id1" property="currency" dictTypeId="PROCESS_MONEY"/>
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="applyBal" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="orgNameOne" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="orgNameTwo" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="yxry" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1"    property="nextOprName" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="fdxdy" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="checkOne" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="checkTwo" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="surveyTime" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="receiveOne" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="returnOne" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="reportedTwo" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="receiveTwo" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="returnTwo" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="reportedThree" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="receiveThree" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="returnThree" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="reportedFour" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="receiveFour" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="returnFour" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="reportedFive" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="receiveFive" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="returnFive" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="checkTime" />
								</td>
								
								<td style="vnd.ms-excel.numberformat:@">
								<d:write iterateId="id1" property="appWay" dictTypeId="PROCESS_method"/>
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="polNo" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="meetingCount" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="voteNo" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="appTime" />
								</td>
								
								<td style="vnd.ms-excel.numberformat:@">
								<d:write iterateId="id1" property="conMatter" dictTypeId="PROCESS_Consideration"/>
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="dsMsOne" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="dsMsTwo" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="dyApp" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="deApp" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="hyZrName" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="hyWyOne" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="shAddr" />
								</td>
								
								<td style="vnd.ms-excel.numberformat:@">
								<d:write iterateId="id1" property="fxType" dictTypeId="PROCESS_risk"/>
								</td>
							
								<td style="vnd.ms-excel.numberformat:@">
								<d:write iterateId="id1" property="spType" dictTypeId="PROCESS_approve"/>
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="ybjNum" />
								</td>
								
								<td style="vnd.ms-excel.numberformat:@">
								<d:write iterateId="id1" property="hySyJl" dictTypeId="PROCESS_conclusion"/>
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="pjJl" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="fxEd" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="sxEd" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="ywEd" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="replyTime" />
								</td>
								<td style="vnd.ms-excel.numberformat:@"> 
									<b:write iterateId="id1" property="" />
								</td>
			</tr>
			</l:iterate>
		</table>
   