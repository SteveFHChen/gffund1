$(function(){
	
	//查询资金记录
	$(".part-right").on("click","#queryFundRecord",function(){
		
		WD.api.fund.fundRecord(null, function(data){
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
				tbody += "<td>" + result.income + "</td>";
				tbody += "<td>" + result.expenditure + "</td>";
				tbody += "<td>" + result.remainMoney + "</td>";
				tbody += "<td>" + result.tradeType + "</td>";
				tbody += "<td>" + result.tradeFlow + "</td>";
				tbody += "<td>" + result.tradeTime + "</td>";
				tbody += "<td>" + result.status + "</td></tr>";
			}
			
			$("#fundRecordTbody").html(tbody);
		});
	});
});