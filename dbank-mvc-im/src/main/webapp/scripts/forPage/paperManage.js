function newCreate() {
	$U.navigate('paper/paperNew.html');
}

function getList() {

	var name = $('#name').val();

	alert(state);
	var searchParams = {
		name : name,
	};
	var pageNav = new WD.PageNav('#pageNav', {
		callback : $.proxy(function(params) {
			$.extend(params, searchParams);
			alert($.param(params));
			WD.api.paper.queryList(params, function(data) {
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
				tbody += "<tr class='gare_bg'><td>" + result.name + "</td>";
			} else {
				tbody += "<tr><td>" + result.name + "</td>";
			}
			tbody += "<td><a href='javascript:void(0)' onclick='detail(\""
					+ result.id + "\")'>详情</a>   "
					+ "   <a href='javascript:void(0)' onclick='modify(\""
					+ result.id + "\")'>修改 </a>   "
					+ "   <a href='javascript:void(0)' onclick='drop(\""
					+ result.id + "\")'>删除 </a></td></tr>"
		}
	}
	$("#contractTbody").html(tbody);
}

function modify(id) {
	$U.navigate('paper/paperUpdate.html?id=' + id);
}

function drop(id) {
	alert(id);

	var params = {
		id : id
	};

	WD.api.advertiseColumn.remove(params, function(data) {
		alert("删除成功");
		location.reload();
	});
}

function getOne(id) {
	$U.navigate('paper/paperDetail.html?id=' + id);
}
