$(function(){

	$("#query").on("click",function(){
		WD.api.loan.flowBorrowList(null, function(data){
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
				tbody += "<td>" + result.money + "</td>";
				tbody += "<td>" + result.hasMoney + "</td>";
				tbody += "<td><a href='"+result.act+"'>查看</a></td></tr>";
			}
			
			$("table > tbody").html(tbody);
		});
	});
});

