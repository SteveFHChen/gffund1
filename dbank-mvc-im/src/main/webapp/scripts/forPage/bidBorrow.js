$(function(){
	
	$("#query").on("click",function(){
		WD.api.loan.bidBorrowList(null, function(data){
			var tbody = "";
			for(var i = 0; i < data.content.length; i++){
				var result = data.content[i];
				if(i%2 == 0){
					tbody += "<tr class='gare_bg'><td>" + result.borrowPer + "</td>";
				}
				else{
					tbody += "<tr><td>" + result.borrowPer + "</td>";
				}
				tbody += "<td>" + result.style + "</td>";
				tbody += "<td>" + result.money + "</td>";
				tbody += "<td>" + result.rate + "</td>";
				tbody += "<td>" + result.time + "</td>";
				tbody += "<td>" + result.remainTime + "</td>";
				tbody += "<td><a href='#'>查看</a></td></tr>";
			}
			
			$("table > tbody").html(tbody);
		});
	});
});