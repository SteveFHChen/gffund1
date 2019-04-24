function doInit() {
	// init menu
	WD.api.admin.getMenu(null, function(data) {
		// fisrt level menu
		for(var i = 0; i < data.length; i++) {
			var menu = data[i];
			if(menu.parent == undefined) {		
				var menuElt = $('<a href="javascript:;" id="' + menu.id + '">' + menu.menuName + '</a>');
				// click event of first level menu
				menuElt.click(function() {
					$('.leftNav').empty();
					
					var menuId = $(this).attr('id');
					// second level menu
					var childMenus = findChildMenus(menuId, data);
					for(var j = 0; j < childMenus.length; j++) {
						var childMenu = childMenus[j];
						
						var liElt = $('<li></li>');
						var aElt = $('<a href="javascript:;" id="' + childMenu.id + '"><span class="icon ' + childMenu.icon + '"></span>' + childMenu.menuName + ' </a>');
						liElt.append(aElt);
						$('.leftNav').append(liElt);
						
						// click event of second level menu
						aElt.click(function() {
							$('.leftNav a').removeClass('active');
							$(this).addClass('active');
							$('.leftNavNext').hide();

							var menuId = $(this).attr('id');
							// third level menu							
							var childMenus = findChildMenus(menuId, data);
							if(childMenus.length > 0) {// has third level menu
								// is already display
								var hasNavNextElt = $(this).parent().find('.leftNavNext');
								if(hasNavNextElt.length == 0) {
									var navNextElt = $('<div class="leftNavNext"></div>');
									for(var k = 0; k < childMenus.length; k++) {
										var childMenu = childMenus[k];
										var navNextAElt = $('<a href="javascript:;">> ' + childMenu.menuName + '</a>');
										navNextElt.append(navNextAElt);
									}
									$(this).after(navNextElt);
								}
								hasNavNextElt.toggle();
							} else {
								// init second menu page
								$('#contentIframe').attr('src', $U.getUrl(getMenuById(menuId, data).url,'html'));
							}
						});
					}
					
					// init the first second level menu
					$('.leftNav li:first a').click();
				});
				$('.nav').append(menuElt);
			}
		}
		$('.nav a:eq(0)').click();
	});
	// user info
	initUserInfo();
	// logout
	$('#logoutBtn').click(function() {
		WD.api.auth.logout(null, function(data) {
			document.location.href = 'login.html';
		});
	});
}
$(doInit);
/**
 * 初始化用户信息
 */
function initUserInfo() {
	WD.api.admin.getCurrentAdmin(null, function(data) {
		var admin = data;
		$('#userInfo').html(admin.name);
	});
}

/**
 * 根据菜单编号获取子菜单列表
 * 
 * @param menuId
 * @param data
 */
function findChildMenus(menuId, data) {
	var childMenus = [];
	for(var i = 0; i < data.length; i++) {
		var menu = data[i];
		if(menu.parent == menuId) {
			childMenus.push(menu);
		}
	}
	return childMenus;
}
/**
 * 根据菜单编号获取菜单对象
 * @param menuId
 * @param data
 */
function getMenuById(menuId, data) {
	var menuObj = null;
	for(var i = 0; i < data.length; i++) {
		var menu = data[i];
		if(menu.id == menuId) {
			menuObj = menu;
		}
	}
	return menuObj;
}
