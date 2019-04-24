$(function(){
	
	$("#queryTotal").on("click",function(){
		WD.api.report.borrowReport(null, function(data){
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
				tbody += "<td>" + result.borrMoney + "</td>";
				tbody += "<td>" + result.rate + "</td>";
				tbody += "<td>" + result.deadline + "</td>";
				tbody += "<td>" + result.state + "</td>";
				tbody += "<td><a href='javascript:void(0)' onclick='queryDetail(\"" + result.look + "\")'>查看</a></td></tr>";
			}
			
			$(".listTable").html(tbody);
		});
	});
	
	//切换tab
	$('.part-right').on('click','.tabTitle>h3',function(){
		$(this).addClass('active').siblings().removeClass('active');
		$('.tabContent>div').eq($(this).index()).show().siblings().hide();
	});
});
//查看详细
function queryDetail(url){
	WD.api.getFile("report/borrow/borrowReport/" + url, function(content) {
		$('.part-right').html(content);
	});
}