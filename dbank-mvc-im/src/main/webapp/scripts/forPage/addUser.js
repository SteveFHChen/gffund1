function doInit() {
	// init role list
	initRoleSelect();
	
	$('#addUserBtn').click(function() {
		var username = $('#username').val();
		var name = $('#name').val();
		var password = $('#password').val();
		var roleId = $('#roleSelect').val();
		params = {
			username : username,
			name : name,
			password : password,
			roleId : roleId
		};
		WD.api.admin.saveAdmin(params, function(data) {
			document.location.href = 'addUser_success.html';
		});
	});
}
$(doInit);
