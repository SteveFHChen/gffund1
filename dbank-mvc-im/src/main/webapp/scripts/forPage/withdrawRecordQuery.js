$(function(){
	//$("table").css('display','none');
	
	//查询提现记录
	$(".part-right").on("click","#queryWithdraw",function(){
		WD.api.fund.withdraw(null, function(data){
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
				tbody += "<td>" + result.withdrawAccount + "</td>";
				tbody += "<td>" + result.withdrawTime + "</td>";
				tbody += "<td>" + result.withdrawMoney + "</td>";
				tbody += "<td>" + result.fee + "</td>";
				tbody += "<td>" + result.realMoney + "</td>";
				tbody += "<td>" + result.status + "</td></tr>";
			}
			
			$("#withdrawTbody").html(tbody);
			
			//$("table").css('display','block');
			
		});
	});
});

function queryTable(){
	
	$.ajax({
		url:"test.json",
		success:function(data){
			var tbody = "";
			for(var i = 0; i < data.cd.length; i++){
				var result = data.cd[i];
				tbody += "<tr class='gare_bg'><td>" + result.name + "</td>";
				tbody += "<td>" + result.realName + "</td>";
				tbody += "<td>" + result.withdrawAccount + "</td>";
				tbody += "<td>" + result.withdrawTime + "</td>";
				tbody += "<td>" + result.withdrawMoney + "</td>";
				tbody += "<td>" + result.fee + "</td>";
				tbody += "<td>" + result.realMoney + "</td>";
				tbody += "<td>" + result.status + "</td></tr>";
			}
			
			$("table > tbody").append(tbody);
			
			$("table").css('display','block');
		},
		error:function(){alert('加载失败！');}
	});
}