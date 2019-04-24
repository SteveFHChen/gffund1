$(function(){
	
	$("#query").on("click",function(){
		WD.api.report.collectReport(null, function(data){
			var tbody = "";
			for(var i = 0; i < data.length; i++){
				var result = data[i];
				if(i%2 == 0){
					tbody += "<tr class='gare_bg'><td>" + result.borrowPer + "</td>";
				}
				else{
					tbody += "<tr><td>" + result.borrowPer + "</td>";
				}
				tbody += "<td>" + result.borrId + "</td>";
				tbody += "<td>" + result.style + "</td>";
				tbody += "<td>" + result.periods + "</td>";
				tbody += "<td>" + result.collectTime + "</td>";
				tbody += "<td>" + result.collMoney + "</td>";
				tbody += "<td>" + result.capital + "</td>";
				tbody += "<td>" + result.interest + "</td>";
				tbody += "<td>" +result.faxi+ "</td></tr>";
			}
			
			$("table > tbody").html(tbody);
		});
	});
});
