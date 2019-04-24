$(function(){
	var loanId = getParams().id;
	var flag = getParams().flag;
	
	params = {
		loanId : loanId,
		flag : flag
	};
	
	WD.api.contract.getFullBidDetail(params, function(data) {
		getFullBidDetail(data);
	});
});


function getFullBidDetail(data){
	var tbody = "";	
	tbody += "<tr height='40px'><td width='25%'>借款人：" + data.user +"</td>";
	tbody += "<td width='23%'>用户名：" + data.userName + "</td>";
	tbody += "<td width='23%'>借款标题：" + data.title + "</td>";
	tbody += "<td width='29%'>标的类型：" + data.loanType +"</td></tr>" ;
	
	tbody += "<tr height='40px'><td>借款金额：" + data.amount + "</td>";
	tbody += "<td>年利率：" + data.interest + "</td>";
	tbody += "<td>借款期限：" + data.timeLimit + "</td>";
	tbody += "<td>还款方式：" + data.repayMode + "</td></tr>";
	
	tbody += "<tr height='40px'><td>借款用途：" + data.usage + "</td>";	
	tbody += "<td>筹标期限：" + data.raisePeriod + "</td></tr>";
	
	tbody += "<tr height='40px'><td>担保机构：" + data.guaranteeBranch + "</td>";	
	tbody += "<td>担保时间：" + data.guaranteeDate + "</td>";
	tbody += "<td><a href='"+ data.data +"' style='color:#0000FF'>资料认证表</a></td></tr>";
	
	tbody += "<tr height='40px'><td>合同确认时间：" + data.signDate + "</td></tr>";	
	$("table > tbody").html(tbody);
}

/**放款**/
function loans()
{
	
}

/**终止**/
function termination()
{
	
}