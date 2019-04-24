$(function(){
	
	//查询资金对账表
	$(".part-right").on("click","#queryCheck",function(){
		
		WD.api.fund.fundCheck(null, function(data){
			var tbody = "";
			for(var i = 0; i < data.length; i++){
				var result = data[i];
				if(i%2 == 0){
					tbody += "<tr class='gare_bg'><td>" + result.name + "</td>";
				}
				else{
					tbody += "<tr><td>" + result.name + "</td>";
				}
				tbody += "<td>" + result.realName + "</td>";
				tbody += "<td>" + result.remainMoney + "</td>";
				tbody += "<td>" + result.freezeMoney + "</td>";
				tbody += "<td>" + result.investMoney + "</td>";
				tbody += "<td>" + result.receiveMoney + "</td>";
				tbody += "<td>" + result.conectionMoney + "</td>";
				tbody += "<td>" + result.investFee + "</td>";
				tbody += "<td>" + result.loan + "</td>";
				tbody += "<td>" + result.debtMoney + "</td>";
				tbody += "<td>" + result.paidMoney + "</td>";
				tbody += "<td>" + result.loanFee + "</td>";
				tbody += "<td>" + result.withdrawTotal + "</td>";
				tbody += "<td>" + result.withdrawFee + "</td>";
				tbody += "<td>" + result.rechargeTotal + "</td>";
				tbody += "<td>" + result.rechargeFee + "</td></tr>";
			}
			
			$("#checkTbody").html(tbody);
		});
	});
});