$(function(){
	//查询合同列表
	getContractList();
			
	//详细页面点击返回
//	$('.part-right').on('click',"#goback",function(){
//		WD.api.getFile("contract/contractManage.html", function(content) {
//			$('.part-right').html(content);
//		});
//	});
});


function getContractList()
{
	WD.api.contract.contractList(null, function(data){
		var tbody = "";
		
		for(var i = 0; i < data.length; i++){
			var result = data[i];
			if(i%2 == 0){
				tbody += "<tr class='gare_bg'><td>" + result.name + "</td>";
			}
			else{
				tbody += "<tr><td>" + result.name + "</td>";
			}
			tbody += "<td>" + result.loanId + "</td>";
			tbody += "<td>" + result.amount + "</td>";
			tbody += "<td>" + result.period + "</td>";
			tbody += "<td>" + result.id + "</td>";
			tbody += "<td>" + result.status + "</td>";
			tbody += "<td><a href='javascript:void(0)' onclick='queryDetail(\"" + result.id + "\")'>查看</a></td></tr>";
		}
		
		$("#contractTbody").html(tbody);
	});
}


function queryContractList()
{
	//clear();
	//根据条件模糊查询合同列表
	//$("#searchBtn").click(function() {
			var name = $('#name').val();
			var status = $('#status').val();
			var guarantee ;
			if($("#guarantee")[0].checked==true){
				guarantee = true;
			}else{
				guarantee = false;
			}
			
			var searchParams = {
				name : name,
				status : status,
				guarantee : guarantee
		};
		var pageNav = new WD.PageNav('#pageNav', {
			callback : $.proxy(function(params) {
				$.extend(params, searchParams);
				alert(jQuery.param(params));
				WD.api.contract.contractListByTrad(params, function(data) {
					getContractListByTrad(data.content);
					pageNav.setParams(data);
				});
			}, this)
		});
		pageNav.first();

	//});
}


function getContractListByTrad(data)
{
	var tbody = "";
	if (data) 
	{
		for(var i = 0; i < data.length; i++){
			var result = data[i];
			if(i%2 == 0){
				tbody += "<tr class='gare_bg'><td>" + result.name + "</td>";
			}
			else{
				tbody += "<tr><td>" + result.name + "</td>";
			}
			tbody += "<td>" + result.loanId + "</td>";
			tbody += "<td>" + result.amount + "</td>";
			tbody += "<td>" + result.period + "</td>";
			tbody += "<td>" + result.id + "</td>";
			tbody += "<td>" + result.status + "</td>";
			tbody += "<td><a href='javascript:void(0)' onclick='queryDetail(\"" + result.id + "\")'>查看</a></td></tr>";
		}
	}
	$("#contractTbody").html(tbody);
}



function clear()
{
	$("#contractTbody").html('');
}


//查看合同详细
//function queryDetail(url){
//	WD.api.getFile("contract/" + url, function(content) {
//		$('.part-right').html(content);
//	});
//}

/**
 * 查看合同详细
 * 
 * @param id
 */
function queryDetail(id) {
//	var params = {
//		id : id
//	};
//	nextStep('contractDetail.html', params);
	//document.location.href = '../../views/contract/contractDetail.html';
	$U.navigate('contract/contractDetail.html');
}
