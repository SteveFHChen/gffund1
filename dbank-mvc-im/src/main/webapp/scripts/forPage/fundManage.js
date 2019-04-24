$(function(){
	WD.api.fund.fundManage(null, function(data){
		
		$("#lastMoney").html(data.lastMoney);
		
		$("#recharge").html(data.recharge);
		
		$("#withdraw").html(data.withdraw);
		
		$("#accrual").html(data.accrual);
		
		$("#penalty").html(data.penalty);
		
		$("#loanFee").html(data.loanFee);
		
		$("#investFee").html(data.investFee);
	});
});