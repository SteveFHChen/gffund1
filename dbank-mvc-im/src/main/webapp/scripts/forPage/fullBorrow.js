$(function(){
	
	$("#query").on("click",function(){
		WD.api.loan.fullBorrowList(null, function(data){
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
				tbody += "<td>" + result.rate + "</td>";
				tbody += "<td>" + result.time + "</td>";
				tbody += "<td>" + result.hasTime + "</td>";
				tbody += "<td>" + result.state + "</td>";
				tbody += "<td><a href='javascript:void(0)' onclick='queryDetail(\"" + result.act + "\")'>查看</a></td></tr>";
			}
			
			$("table > tbody").html(tbody);
		});
	});
});

//查看详细
function queryDetail(url){
	WD.api.getFile("loan/credit/" + url, function(content) {
		$('.part-right').html(content);
	});
}