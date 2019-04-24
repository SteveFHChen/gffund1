$(function(){
	
	$("#query").on("click",function(){
		WD.api.postLoan.overdueBorrowCheck(null, function(data){
			var tbody = "";
			for(var i = 0; i < data.length; i++){
				var result = data[i];
				if(i%2 == 0){
					tbody += "<tr class='gare_bg'><td>" + result.borrowPer + "</td>";
				}
				else{
					tbody += "<tr><td>" + result.borrowPer + "</td>";
				}
				tbody += "<td>" + result.style + "</td>";
				tbody += "<td>" + result.period + "</td>";
				tbody += "<td>" + result.returnTime + "</td>";
				tbody += "<td>" + result.overdueDay + "</td>";
				tbody += "<td>" + result.returnMoney + "</td>";
				tbody += "<td>" + result.overdueMoney + "</td>";
				tbody += "<td>" + result.state + "</td>";
				tbody += "<td><a href='" + result.look + "'>查看</a><a href='" + result.pay + "'style='margin-left:10px'>垫付</a></td></tr>";
			}
			
			$("table > tbody").html(tbody);
		});
	});
});
