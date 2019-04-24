function queryFullBidList(){
	
		var personName = $('#personName').val();
		var loanType = $('#loanType').val();
		var guarantee ;
		
		if($("#guarantee")[0].checked==true){
			guarantee = true;
		}else{
			guarantee = false;
		}
		
		var searchParams = {
			personName : personName,
			loanType : loanType,
			guarantee : guarantee
		};
		
		var pageNav = new WD.PageNav('#pageNav', {
		callback : $.proxy(function(params) {
			$.extend(params, searchParams);
			//alert(jQuery.param(params));
			WD.api.contract.getFullBidListByTrad(params, function(data) {
				getFullBidListByTrad(data.content);
				pageNav.setParams(data);
				});
			}, this)
		});
		pageNav.first();
	
}


function getFullBidListByTrad(data){
	
		var tbody = "";
		if (data) 
		{
			for(var i = 0; i < data.length; i++){
				var result = data[i];
				if(i%2 == 0){
					tbody += "<tr class='gare_bg'><td>" + result.user + "</td>";
				}
				else{
					tbody += "<tr><td>" + result.user + "</td>";
				}
				tbody += "<td>" + result.loanType + "</td>";
				tbody += "<td>" + result.amount + "</td>";
				tbody += "<td>" + result.interest + "</td>";
				tbody += "<td>" + result.timeLimit + "</td>";
				tbody += "<td>" + result.raisePeriod + "</td>";
				tbody += "<td>" + result.contractStatus + "</td>";
				tbody += "<td><a href='javascript:void(0)' onclick='queryDetail("+ result.id +",\""+ result.loanType +"\")'>查看</a>  &nbsp; ";
						     
			
				if("APPLY" == result.contractStatus){
					tbody += "<a href='javascript:void(0)' onclick='stop(\""+ result.id + "\")'>终止</a></td></tr>";
				}else if("SIGNED" == result.contractStatus){
					tbody += "<a href='javascript:void(0)' onclick='loans(\""+ result.id + "\")'>放款</a></td></tr>";
				}else if("TERMINATE" == result.contractStatus){
					tbody += "</td></tr>";
				}else{
					tbody += "</td></tr>";
				}
			}
			//console.info(tbody);
			$("table > tbody").html(tbody);
		}
}


/**
 * 查看详细
 * 
 * @param id
 */
function queryDetail(id , flag) {
	
	params = {
			id : id,
			flag : flag
	};
	var url = 'fullBorrow_stop.html';
	
	nextStep(url, params);
}


function stop(id){
	
}

function loans(id){
	
}