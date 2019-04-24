function newCreate(){
	//document.location.href = '/dbank-mvc-im/views/advertiseColumn/advertiseColumnNew.html';
	$U.navigate('advertiseColumn/advertiseColumnNew.html');
}

function getList() {

	var id = $('#id').val();
	var name = $('#name').val();
	var state = $('#state').val();

	alert(state);
	var searchParams = {
		id : id,
		name : name,
		state : state
	};
	var pageNav = new WD.PageNav('#pageNav', {
		callback : $.proxy(function(params) {
			$.extend(params, searchParams);
			alert($.param(params));
			WD.api.advertiseColumn.queryList(params, function(data) {
				queryListByTrad(data.content);
				pageNav.setParams(data);
			});
		}, this)
	});
	pageNav.first();
}

function queryListByTrad(data) {
	var tbody = "";
	if (data) {
		for ( var i = 0; i < data.length; i++) {
			var result = data[i];
			if (i % 2 == 0) {
				tbody += "<tr class='gare_bg'><td><a href='javascript:void(0)' onclick='getOne(\""+ result.id+ "\")'>"+result.id +"</a></td>";
			} else {
				tbody += "<tr><td><a href='javascript:void(0)' onclick='getOne(\""+ result.id+ "\")'>"+result.id +"</a></td>";
			}
			tbody += "<td>" + result.name + "</td>";
			if(result.state == 'OPEN')
			{
				tbody += "<td>开放中</td>";
			}
			else if(result.state == 'CLOSE')
			{
				tbody += "<td>关闭</td>";
			}
			tbody += "<td><a href='javascript:void(0)' onclick='modify(\""+ result.id+ "\")'>修改</a>   " +
				   "   <a href='javascript:void(0)' onclick='drop(\""
					+ result.id + "\")'>删除 </a></td></tr>";
		}
	}
	$("#contractTbody").html(tbody);
}


function modify(id){
	//document.location.href = '/dbank-mvc-im/views/advertiseColumn/advertiseColumnUpdate.html';
	$U.navigate('advertiseColumn/advertiseColumnUpdate.html?id=' + id);
}

function drop(id){
	alert(id);
	
	var params = {
		id : id
	};
	
	WD.api.advertiseColumn.remove(params, function(data) {
		alert("删除成功");
		location.reload();
	});
}

function getOne(id)
{
	//document.location.href = '/dbank-mvc-im/views/advertiseColumn/advertiseColumnDetail.html?id='+ id;
	$U.navigate('advertiseColumn/advertiseColumnDetail.html?id='+ id);
}




