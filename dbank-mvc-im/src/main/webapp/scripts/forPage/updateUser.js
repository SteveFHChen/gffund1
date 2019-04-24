function doInit() {
	// init role list
	initRoleSelect();
	// init form data
	initFormData();

	$('#resetPwdChk').click(function() {
		if($(this).is(":checked")) {
			$('.pwdTr').show();
		} else {
			$('.pwdTr').hide();
		}
	});

	$('#updateUserBtn').click(function() {
		var username = $('#username').val();
		var name = $('#name').val();
		var password = $('#password').val();
		var roleId = $('#roleSelect').val();
		params = {
			id : getParams().id,
			username : username,
			name : name,
			password : password,
			roleId : roleId
		};
		WD.api.admin.updateAdmin(params, function(data) {
			document.location.href = 'updateUser_success.html';
		});
	});
}
$(doInit);
/**
 * 初始化页面表单数据
 */
function initFormData() {
	var params = getParams();
	WD.api.admin.getAdmin(params, function(data) {
		$('#name').val(data.name);
		$('#username').val(data.username);
		$('#roleSelect').val(data.roleId);
	});
}