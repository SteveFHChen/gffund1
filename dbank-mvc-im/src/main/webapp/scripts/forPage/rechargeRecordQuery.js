$(function(){
	
	//查询充值记录
	$(".part-right").on("click","#queryRecharge",function(){
		
		WD.api.fund.recharge(null, function(data){
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
				tbody += "<td>" + result.rechargeTime + "</td>";
				tbody += "<td>" + result.rechargeMoney + "</td>";
				tbody += "<td>" + result.fee + "</td>";
				tbody += "<td>" + result.expenditureMoney + "</td>";
				tbody += "<td>" + result.realMoney + "</td>";
				tbody += "<td>" + result.status + "</td></tr>";
			}
			
			$("#rechargeTbody").html(tbody);
		});
	});
});