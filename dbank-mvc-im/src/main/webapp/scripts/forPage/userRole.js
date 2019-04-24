function doInit() {
	// init role list
	initRoleSelect();
	// 查询
	$("#searchBtn").click(function() {
		var name = $('#name').val();
		var roleId = $('#roleSelect').val();
		var searchParams = {
			name : name,
			roleId : roleId
		};

		var pageNav = new WD.PageNav('#pageNav', {
			callback : $.proxy(function(params) {
				$.extend(params, searchParams);
				WD.api.admin.listAdmin(params, function(data) {
					renderUserList(data.content);
					pageNav.setParams(data);
				});
			}, this)
		});
		pageNav.first();

	});
	// 添加用户
	$("#addUser").click(function() {
		document.location.href = 'addUser.html';
	});

}
$(doInit);
/**
 * 渲染用户列表
 * 
 * @param data
 */
function renderUserList(data) {
	var str = '';
	if (data) {
		for ( var i = 0; i < data.length; i++) {
			var row = data[i];
			if( i % 2 == 0) {				
				str += '<tr>';
			} else {
				str += '<tr class="gare_bg">';
			}
			str += '<td align="center">' + (i + 1) + '</td>';
			str += '<td align="center">' + row.name + '</td>';
			str += '<td align="center">' + row.roleName + '</td>';
			str += '<td align="center"><a href="javascript:updateUser(' + row.id + ');" >修改</a>  &nbsp; <a href="javascript:deleteUser(' + row.id + ');" >删除</a></td>';
			str += '</tr>';
		}
	}
	$('.listTable>tbody').empty().append(str);
}
/**
 * 删除用户
 * 
 * @param id
 */
function deleteUser(id) {
	var params = {
		id : id
	};
	WD.api.admin.deleteAdmin(params, function(data) {		
		if('success' == data.result) {
			alert("删除成功！");
			$("#searchBtn").click();
		}
	});
}

/**
 * 修改用户信息
 * 
 * @param id
 */
function updateUser(id) {
	var params = {
		id : id
	};
	nextStep('updateUser.html', params);
}