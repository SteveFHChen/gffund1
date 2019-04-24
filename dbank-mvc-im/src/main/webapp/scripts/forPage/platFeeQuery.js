$(function(){
	
	//查询平台费用
	$(".part-right").on("click","#queryFee",function(){
		WD.api.fund.fee(null, function(data){
			var tbody = "";
			for(var i = 0; i < data.length; i++){
				var result = data[i];
				if(i%2 == 0){
					tbody += "<tr class='gare_bg'><td>" + result.feeType + "</td>";
				}
				else{
					tbody += "<tr><td>" + result.feeType + "</td>";
				}
				tbody += "<td>" + result.takeMoney + "</td>";
				tbody += "<td>" + result.takeTime + "</td>";
				tbody += "<td>" + result.takeObj + "</td></tr>";
			}
			
			$("#feeTbody").html(tbody);
		});
	});
	
	//查询平台费用统计
	$(".part-right").on("click","#queryTotalFee",function(){
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
			
			$("#feeTotalTbody").html(tbody);
		});
	});
	
	//切换tab
	$('.part-right').on('click','.tabTitle>h3',function(){
		$(this).addClass('active').siblings().removeClass('active');
		$('.tabContent>div').eq($(this).index()).show().siblings().hide();
	});
});