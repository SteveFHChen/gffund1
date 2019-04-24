if (!window.WD) {
	window.WD = {};
}

WD.api = function() {
	
	var PATH = $U.getUrl('manage/');// web interface
	
	var PATH_VIEW = $U.getUrl('views/');
	

	var api = {};
	
	var beforeRequest = function(callback) {
		
		if ($.isPlainObject(callback)) {
			var loadingArea = callback.loadingArea;
			if (loadingArea && !$.isPlainObject(loadingArea)) {
				loadingArea = {target:loadingArea};
			}
			var loadingButton = callback.loadingButton;
			var disableButton = callback.disableButton;
			if (disableButton && !$.isArray(disableButton)) {
				disableButton = [disableButton];
			}
			var before = callback.before;

			if (loadingArea) {
				loadingArea = $.extend({content:WD.utils.LOADING_NORMAL}, loadingArea);
				WD.utils.Loading(loadingArea.target, true, loadingArea.content);
			}
			if (loadingButton) {
				loadingButton.loading(true);
			}
			if (disableButton && disableButton.length > 0) {
				$(disableButton).each(function(index, button) {
					button.disable();
				});
			}
			if ($.isFunction(before)) {
				before();
			}
		}
	};

	var afterRequest = function(callback) {
		
		if ($.isPlainObject(callback)) {
			var loadingArea = callback.loadingArea;
			if (loadingArea && !$.isPlainObject(loadingArea)) {
				loadingArea = {target:loadingArea};
			}
			var loadingButton = callback.loadingButton;
			var disableButton = callback.disableButton;
			if (disableButton && !$.isArray(disableButton)) {
				disableButton = [disableButton];
			}
			var after = callback.after;

			if (loadingArea) {
				WD.utils.Loading(loadingArea.target, false);
			}
			if (loadingButton) {
				loadingButton.loading(false);
			}
			if (disableButton && disableButton.length > 0) {
				$(disableButton).each(function(index, button) {
					button.enable();
				});
			}
			if ($.isFunction(after)) {
				after();
			}
		}
	};
	
	var doSuccess = function(data, callback) {
		
		var success, fail;
		if ($.isFunction(callback)) {
			success = callback;
		} else if ($.isPlainObject(callback)){
			success = callback.success;
			fail = callback.fail;
		}
		if (data === null || data === undefined) {
			data = '';
		}
		if (data.errorCode !== undefined) {
			var ret;
			if ($.isFunction(fail)) {
				ret = fail(data);
			}
			if (ret !== false) {
				if (data.errorCode == '990007') {	//session invalid
					$U.toLogin();
					return;
				}
				alert('错误码：'+data.errorCode+'，错误信息：'+data.errorMessage);
			}
		} else if ($.isFunction(success)) {
			success(data);
		}
	};
	api.doSuccess = doSuccess;
	
	var doFail = function(data, callback) {

		data.errorCode = 'HTTP-' + data.errorCode;
		var fail;
		if ($.isPlainObject(callback)){
			fail = callback.fail;
		}
		var ret;
		if ($.isFunction(fail)) {
			ret = fail(data);
		}
		if (ret !== false && data.errorCode != 'HTTP-0') {
			alert('错误码：'+data.errorCode+'，错误信息：'+data.errorMessage);
		}
	};
	api.doFail = doFail;
	
	var simulate = function(data, callback) {

		beforeRequest(callback);
		//setTimeout(function(){
			afterRequest(callback);
			doSuccess(data, callback);
		//}, 1000);
	};
	api.simulate = simulate;
	
	var request = function(method, url, params, callback) {
		
		var option;
		if ($.isPlainObject(callback)){
			option = callback.option;
		}
		
		if (params) {
			$.each(params, function(key, value) {
				if (value === null || value === undefined) {
					delete params[key];
				}
			});
		}
		
		beforeRequest(callback);
		return $.ajax({
			url : PATH + url,
			data : params,
			type : method, 
			cache : false,
			traditional : true,
			success : function(data, textStatus, jqXHR) {
				//setTimeout(function() {
					//fix for 302 Redirect
					if (jqXHR.responseText == '') {
						data = '';
					}
					if ($.trim(jqXHR.responseText).indexOf('<!DOCTYPE html') == 0) {
						//console.log(url);
						WD.utils.reload();
					} else {
						afterRequest(callback);
						doSuccess(data, callback);
					}
				//}, 1000);
			}, error : function(jqXHR, textStatus, errorThrown) {
				afterRequest(callback);
				var errorCode = jqXHR.status, errorMessage = errorThrown;
				doFail({errorCode:errorCode, errorMessage:errorMessage}, callback);
			}
		});
	};
	/* 获取页面内容 */
	api.getFile = function(url, callback) {
		return $.get(PATH_VIEW + url, callback);
	};
	
	/* 通用Get方法 */
	api.Get = function(url, params, callback) {
		
		return request('GET', url, params, callback);
	};

	/* 通用Post方法 */
	api.Post = function(url, params, callback) {

		return request('POST', url, params, callback);
	};

	/* 通用Put方法 */
	api.Put = function(url, params, callback) {

		return request('PUT', url, params, callback);
	};
	
	/* 通用Delete方法 */
	api.Delete = function(url, params, callback) {

		return request('DELETE', url, params, callback);
	};

	api.auth = {};
	
	api.auth.login = function(params, callback) {
		
		//simulate({content:{'name':'test','password':'111111111'}},callback);
		return api.Post('authentication', params, callback);
	};
    //登出
    api.auth.logout = function(params, callback) {
        return api.Get('logout',params, callback);
    };

	// 后台管理员对象
	api.admin = {};
	
	api.admin.getCurrentAdmin = function(params, callback) { // 获取当前用户
		return api.Get('admin/getCurrentAdmin', params, callback);
	};
	
	api.admin.getAdmin = function(params, callback) { // 获取用户
		return api.Get('admin/getAdmin', params, callback);
	};
	
	api.admin.saveAdmin = function(params, callback) { // 保存用户
		return api.Post('admin/saveAdmin', params, callback);
	};
	
	api.admin.deleteAdmin = function(params, callback) { // 删除用户
		return api.Post('admin/deleteAdmin', params, callback);
	};
	
	api.admin.listAdmin = function(params, callback) { // 模糊查询用户列表
		return api.Post('admin/listAdmin', params, callback);
	};
	
	api.admin.updateAdmin = function(params, callback) { // 修改用户
		return api.Post('admin/updateAdmin', params, callback);
	};
	
	api.admin.getMenu = function(params, callback) { // 获取用户菜单
		return api.Get('admin/getMenu', params, callback);
	};
	
	
	// 角色
	api.adminRole = {};
	
	api.adminRole.getAllRole = function(params, callback) { // 获取角色列表
		return api.Get('adminRole/getAllRole', params, callback);
	};
	
	api.adminRole.saveAdminRole = function(params, callback) { // 保存角色
		return api.Post('adminRole/saveAdminRole', params, callback);
	};
	
	// 角色权限配置
	api.roleAdminMenu = {};
	
	api.roleAdminMenu.saveRoleAdminMenu = function(params, callback) { // 保存角色
		return api.Post('roleAdminMenu/saveRoleAdminMenu', params, callback);
	};
	
	// 菜单
	api.adminMenu = {};
	
	api.adminMenu.saveMenu = function(params, callback) { // 保存菜单
		return api.Post('adminMenu/saveMenu', params, callback);
	};
	
	api.admin.menu = function(params, callback) { // 获取菜单
		return api.Get('admin/getMenu', params, callback);
	};
	
	// 贷前管理
	api.beforeLoan = {};
	
	api.beforeLoan.getLoanBaseInfo = function(params, callback){// 获取认证授信基本信息
		return api.Post('loan/getLoanBaseInfo', params, callback);
	};
	
	// 借款申请对象
	api.loan = {};
	
	api.loan.getToBeCerttifiedList = function(params, callback){// 待认证授信借款
		return api.Post('loan/getToBeCerttifiedList', params, callback);
	};
	
	api.loan.getToBeReviewList = function(params, callback){// 待复审借款
		return api.Post('loan/getToBeReviewList', params, callback);
	};
	
	api.loan.getReviewCerttifiedList = function(params, callback){// 复审通过借款
		return api.Post('loan/getReviewCerttifiedList', params, callback);
	};
	
	api.loan.getReviewDenyCerttifiedList = function(params, callback){// 复审未通过借款
		return api.Post('loan/getReviewDenyCerttifiedList', params, callback);
	};
	
	api.loan.updateMaterialFinancialRptStatus = function(params, callback){// 设置状态 - 认证材料 - 企业财务报表
		return api.Post('loan/updateMaterialFinancialRptStatus', params, callback);
	};
	
	api.loan.updatePhoneFileAuthStatus = function(params, callback){// 设置状态 - 认证材料 - 手机实名认证状态
		return api.Post('loan/updatePhoneFileAuthStatus', params, callback);
	};
	
	api.loan.updateEduFileAuthStatus = function(params, callback){// 设置状态 - 认证材料 - 学历认证状态
		return api.Post('loan/updateEduFileAuthStatus', params, callback);
	};
	
	api.loan.updateLiveAddrFileAuthStatus = function(params, callback){// 设置状态 - 认证材料 - 居住地认证状态
		return api.Post('loan/updateLiveAddrFileAuthStatus', params, callback);
	};
	
	api.loan.updateIdfileAuthStatus = function(params, callback){// 设置状态 - 认证材料 - 身份证件认证状态
		return api.Post('loan/updateIdfileAuthStatus', params, callback);
	};
	
	api.loan.updateLoanStatus = function(params, callback){// 设置状态
		return api.Post('loan/updateLoanStatus', params, callback);
	};
	
	   //投标中借款
	api.loan.bidBorrowList = function(params, callback){//合同管理列表 
		return api.Get('bidBorrowList', params, callback);
	};
	  //流标借款
	api.loan.flowBorrowList = function(params, callback){//合同管理列表 
		return api.Get('flowBorrowList', params, callback);
	};
	
	
	
	// 贷后管理
	api.postLoan = {};
	//逾期借款-风控复审
	api.postLoan.overdueBorrowCheck = function(params, callback){//合同管理列表 
		return api.Get('overdueBorrowCheck', params, callback);
	};
	//逾期借款-信贷业务员
	api.postLoan.overdueBorrowCreditSales = function(params, callback){//合同管理列表 
		return api.Get('overdueBorrowCreditSales', params, callback);
	};
	
	// 合同管理///////////////////////////////////////////////////////////////////////////////////////////
	api.contract = {};
	
	api.contract.contractList = function(params, callback){//合同管理列表 
		return api.Get('contract/getContractList', params, callback);
	};
	
	//模糊查询合同管理
	api.contract.contractListByTrad = function(params, callback) { // 模糊查询合同列表
		return api.Get('contract/getContractListByTrad', params, callback);
	};
	
	api.contract.contractDetail = function(params, callback){//合同详情
		return api.Get('getContractDetail', params, callback);
	};
	
	 //满标借款
	api.contract.getFullBidListByTrad = function(params, callback){//合同管理列表 
		return api.Get('contract/getFullBidListByTrad', params, callback);
	};
	
	//满标借款确认合同查看及放款
	api.contract.getFullBidDetail = function(params, callback){//合同管理列表 
		return api.Get('contract/getFullBidDetail', params, callback);
	};
	
	// 资金管理
	api.fund = {};
	
	api.fund.fundManage = function(params, callback){//资金管理首页
		return api.Get('getFund', params, callback);
	};
	
	api.fund.withdraw = function(params, callback){//提现记录查询 
		return api.Get('getWithdraw', params, callback);
	};
	
	api.fund.recharge = function(params, callback){//充值记录查询
		return api.Get('getRecharge', params, callback);
	};
	
	api.fund.fundRecord = function(params, callback){//资金记录查询
		return api.Get('getFundRecord', params, callback);
	};
	
	api.fund.fundCheck = function(params, callback){//资金对账表
		return api.Get('getFundCheck', params, callback);
	};
	
	api.fund.fee = function(params, callback){//平台费用记录查询
		return api.Get('getFee', params, callback);
	};
	
	api.fund.feeTotal = function(params, callback){//平台费用统计
		return api.Get('getFeeTotal', params, callback);
	};
	
	// 广告栏管理
	api.advertiseColumn = {};
	//广告栏新增
	api.advertiseColumn.save = function(params, callback){
		return api.Post('advertiseColumn/save', params, callback);
	};
	//广告栏修改
	api.advertiseColumn.update = function(params, callback){
		return api.Post('advertiseColumn/update', params, callback);
	};
	//广告栏删除
	api.advertiseColumn.remove = function(params, callback){
		return api.Post('advertiseColumn/delete', params, callback);
	};
	//广告栏单条记录详情查询
	api.advertiseColumn.getOne = function(params, callback){
		return api.Get('advertiseColumn/getOne', params, callback);
	};
	//广告栏分页查询
	api.advertiseColumn.queryList = function(params, callback){
		return api.Get('advertiseColumn/queryList', params, callback);
	};
	
	// 试卷管理
	api.paper = {};
	
	api.paper.save = function(params, callback){
		return api.Post('paper/save', params, callback);
	};
	api.paper.update = function(params, callback){
		return api.Post('paper/update', params, callback);
	};
	api.paper.remove = function(params, callback){
		return api.Post('paper/delete', params, callback);
	};
	api.paper.getOne = function(params, callback){
		return api.Get('paper/getOne', params, callback);
	};
	api.paper.queryList = function(params, callback){
		return api.Get('paper/queryList', params, callback);
	};
	
	//帮助分类管理
	api.faqCategory = {};
	api.faqCategory.queryListByPage = function(params, callback) {
		return api.Get('faqCategory/query', params, callback);
	};
	
	api.faqCategory.updateFaqCategory = function(params, callback) {
		return api.Post('faqCategory/update', params, callback);
	};
	
	api.faqCategory.createFaqCategory = function(params, callback) {
		return api.Post('faqCategory/', params, callback);
	};
	
	api.faqCategory.deteleFaqCategory = function(params, callback) {
		return api.Post('faqCategory/detele', params, callback);
	};
	
	api.faqCategory.getFaqCategoryById = function(params, callback) {
		return api.Get('faqCategory/getDetailsById', params, callback);
	};
	
		api.faqCategory.getFaqCategoryList = function(params, callback) {
		return api.Get('faqCategory/getCatList', params, callback);
	};
	//帮助FAQ 
	api.faq = {};
	//获取帮助FAQ列表
	api.faq.queryListByPage = function(params, callback) {
		return api.Get('faq/page', params, callback);
	};
	//获取帮助详情
	api.faq.getFaqDetailById = function(params,callback){
		return api.Get('faq/' + params.id, params, callback);
	};
	//新增FAQ
	api.faq.createFaq = function(params, callback) {
		return api.Post('faq/', params, callback);
	};
	//更新FAQ
	api.faq.updateFaq = function(params, callback) {
		return api.Post('faq/update/'+ params.id, params, callback);
	};
		
	//角色管理
	api.role = {};
	api.role.queryListByPage = function(params, callback) {
		return api.Get('adminRole/page/', params, callback);
	};
	
	api.role.updateRole = function(params, callback) {
		return api.Post('adminRole/update/' + params.id, params, callback);
	};
	
	api.role.deleteRole = function(params, callback) {
		return api.Post('adminRole/delete/' + params.id, params, callback);
	};
	
	api.role.createRole = function(params, callback) {
		return api.Post('adminRole/', params, callback);
	};
	
	api.role.getRoleDetails = function(params, callback) {
		return api.Get('adminRole/' + params.id, params, callback);
	};
	
	//广告管理
	api.advertise = {};
	api.advertise.createAdvertise = function(params, callback){
		return api.Post("advertise/", params, callback);
	};
	
	api.advertise.updateAdvertise = function(params, callback){
		return api.Post("advertise/update", params, callback);
	};
	
	api.advertise.deleteAdvertise = function(params, callback){
		return api.Get("advertise/delete/"+params.adId, params, callback);
	};
	
	api.advertise.getAdvertiseById = function(params, callback){
		return api.Get("advertise/getDetailsById/"+params.adId, params, callback);
	};
	
	api.advertise.getAdvertiseList = function(params, callback){
		return api.Get("advertise/page", params, callback);
	};
	
	//订单
	api.order = {};
	api.order.getOrderList = function(params, callback){
		return api.Get("order/page", params, callback);
	};
	
	//题库
	api.question = {};
	api.question.getQuestionList = function(params, callback){
		return api.Get("question/page", params, callback);
	};
	
	// 统计查询
	api.report = {};
	//借款列表
	api.report.borrowReport = function(params, callback){
		return api.Get('borrowReport', params, callback);
	};
	//已收款信息
	api.report.collectReport = function(params, callback){
		return api.Get('collectReport', params, callback);
	};
	//单笔借款详情页面
	api.report.oneBorrowInfo = function(params, callback){
		return api.Get('oneBorrowInfo', params, callback);
	};
	//用户
	api.user = {};
	
	return api;
}();
