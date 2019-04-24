$(function(){
	
	$(".part-right").on("click","#queryRecord",function(){
		
		WD.api.fund.feeTotal(null, function(data){
			var tbody = "";
			for(var i = 0; i < data.length; i++){
				var result = data[i];
				if(i%2 == 0){
					tbody += "<tr class='gare_bg'><td>" + result.feeType + "</td>";
				}
				else{
					tbody += "<tr><td>" + result.feeType + "</td>";
				}
				tbody += "<td>" + result.totalMoney + "</td></tr>";
			}
			
			$("table > tbody").html(tbody);
		});
	});
});