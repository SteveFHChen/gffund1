if (!window.WD) {
	window.WD = {};
}

WD.api = function() {

	//TEST TODO
	var PATH = $U.getUrl('service/');

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
//		if(url=='login'&& window.WD.proState!='develop'){
//			PATH = $U.getUrl('');
//		}
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

	/* ===== 登录+登出 ===== */
	api.auth = {};
	//登录
	api.auth.login = function(params, callback) {
		return api.Post('authentication', params, callback);
	};
	//登出
    api.auth.loginout = function(params, callback) {
        return api.Get('logout',params, callback);
    };
	//获取图片验证码
	api.auth.getPicVerCode = function(params, callback) {
		return api.Get('12345678', params, callback);
	};
	//验证图片验证码
	api.auth.checkPicVerCode = function(params, callback) {
		return api.Post('12345678', params, callback);
	};
	//实名认证
	api.auth.realnameAuthen = function(params, callback) {
        return api.Post('person/certify', params, callback);
    };
	
	/* ===== 注册+找回密码 ===== */
	api.login = {};
	/*  注册  */
	//	获取手机验证码
	api.login.getPhoneCaptcha = function(params, callback) {
		return api.Get('verifyCode/register/'+params,null,callback);
	};
	//	获取已发送的测试验证码(仅供测试)
	api.login.getTestPhoneCaptcha = function(params, callback) {
		return api.Get('verifyCode/getCode/'+params+'/register',null,callback);
	};
	//	注册提交
	api.login.register = function(params, callback) {
		return api.Post('person/register', params, callback);
	};
	/*  找回密码  */
	//	获取手机验证码
	api.login.getPhoneCaptchaRegister = function(params, callback) {
		return api.Get('verifyCode/findPwd/'+params,null,callback);
	};
	//	获取已发送的测试验证码(仅供测试)
	api.login.getTestPhoneCaptchaRegister = function(params, callback) {
		return api.Get('verifyCode/getCode/'+params+'/findPwd',null,callback);
	};
	//	验证手机验证码
	api.login.checkPhoneCaptcha = function(params, callback) {
		return api.Get('person/mobile/verify/findPwd',params,callback);
	};
	//	验证用户身份证件
	api.login.checkUserCertNo = function(params, callback) {
		return api.Get('person/certNo/verify',params,callback);
	};
	//	安全设置信息查询
	api.login.security = function(params, callback) {
		return api.Get('security/settings', params, callback);
	};
	//	找回登录密码提交
	api.login.resetPwd = function(params, callback) {
		return api.Put('person/password/reset', params, callback);
	};
    
	/* ===== 个人中心 ===== */
	api.user = {};
	//  获取用户信息
    api.user.getInfo = function(params,callback){
        return api.Get('person/getInfo', params, callback);
    };
	//	信息总览
	api.user.userCenter = function(params, callback) {
	};
	//	交易明细查询
	api.user.userCenterList = function(params, callback) {
	};
	//	我的投资
	api.user.myFinance = function(params, callback) {
	};
	//	投资回收详情查询
	api.user.myFinanceList = function(params, callback) {
	};
	//	我的借款
	api.user.myLoan = function(params, callback) {
		return api.Get('loanBid/getCurrentLoanAndLoanBid', params, callback);
	};
	// 	历史借款
	api.user.historyLoanBid = function(params, callback) {
		return api.Get('loanBid/getHistoryLoanBid', params, callback);
	    return api.Get('loanBid/getCurrentLoanAndLoanBid', params, callback);
	};
	//  合同内容
	api.user.contract = function(params, callback) {
		return api.Get('contract/'+params.id, params, callback);
	};
	//	合同确认
	api.user.contract = function(params, callback) {
		return api.Put('contract/'+params.id+'/sign', params, callback);
	};
	//	我的资金账户
	api.user.myMoney = function(params, callback) {
	};
	/*  安全与设置  */
	//	个人基本信息查询
	api.user.account = function(params, callback) {
		return api.Get('userBase/info', params, callback);
	};
	//	认证资料信息
	api.user.accountCreditInfo = function(params, callback) {
		return api.Get('certifyMaterial/myCert/recent', params, callback);
	};
	//	安全设置
	api.user.accountSecurity = function(params, callback) {
		return api.Get('security/settings', params, callback);
	};
	//	修改登录密码
	api.user.updatePwd = function(params, callback) {
		return api.Put('security/password/modify', params, callback);
	};
	//	发送认证邮件(首次绑定邮箱)
	api.user.sendEmail = function(params, callback) {
		return api.Post('security/email/send/emailBind', params, callback);
	};
	//	发送认证邮件(验证原邮箱)
	api.user.sendEmailOld = function(params, callback) {
		return api.Post('security/email/send/oldEmailCertify', params, callback);
	};
	//	发送认证邮件(验证新邮箱)
	api.user.sendEmailNew = function(params, callback) {
		return api.Post('security/email/send/newEmailCertify', params, callback);
	};
	//	通过邮箱修改绑定邮箱
	api.user.updateEmailAsEmail = function(params, callback) {
		return api.Put('security/email/modify/byEmail', params, callback);
	};
	//	手机修改绑定邮箱
	api.user.updateEmailAsPhone = function(params, callback) {
		return api.Put('security/email/modify/byMobile', params, callback);
	};
	//	获取手机验证码
	api.user.getPhoneCaptchaEmailBind = function(params, callback) {
		return api.Get('verifyCode/editEmailBind/'+params,null,callback);
	};
	//	获取已发送的测试验证码(仅供测试)
	api.user.getTestPhoneCaptchaEmailBind = function(params, callback) {
		return api.Get('verifyCode/getCode/'+params+'/editEmailBind',null,callback);
	};
	//	验证手机验证码
	api.user.checkPhoneCaptchaEmailBind = function(params, callback) {
		return api.Get('person/mobile/verify/editEmailBind',params,callback);
	};
	//	修改绑定手机
	api.user.updatePhone = function(params, callback) {
		return api.Put('security/mobile/modify', params, callback);
	};
	//	获取手机验证码
	api.user.getPhoneCaptchaMobileBind = function(params, callback) {
		return api.Get('verifyCode/editMobileBind/'+params,null,callback);
	};
	//	获取已发送的测试验证码(仅供测试)
	api.user.getTestPhoneCaptchaMobileBind = function(params, callback) {
		return api.Get('verifyCode/getCode/'+params+'/editMobileBind',null,callback);
	};
	//	验证手机验证码
	api.user.checkPhoneCaptchaMobileBind = function(params, callback) {
		return api.Get('person/mobile/verify/editMobileBind',params,callback);
	};
	//	消息通知
	api.user.notice = function(params, callback) {
		return api.Get('userMessage/messages',params,callback);
	};
	//	消息设置查询
	api.user.noticeSettingQuery = function(params, callback) {
		return api.Get('userMessageSetting/lookup',params,callback);
	};
	//	消息设置修改
	api.user.noticeSetting = function(params, callback) {
		return api.Put('userMessageSetting/modify',params,callback);
	};
	
    /* ===== 企业中心 ===== */
	api.ent = {};

	api.ent.borrowing = function(params, callback){
		return api.Get('ent/getBorrowing', params, callback);
	};
	api.ent.notice = function(params, callback) {	
		return api.Get('ent/getNotice', params, callback);
	};
	
	api.ent.authInfo = function(params, callback){
		return api.Get('ent/getAuthInfo', params,callback);
	};
	
	api.ent.historyLoan = function(params, callback){
		return api.Get('ent/historyLoan', params,callback);
	};
	
	api.ent.loan = function(params, callback){
		return api.Get('ent/loan', params,callback);
	};
	
	api.ent.aboutMe = function(params, callback){
		return api.Get('ent/aboutMe', params,callback);
	};
	
	api.ent.accountDetail = function(params, callback){
		return api.Get('ent/accountDetail', params,callback);
	};
	
	api.ent.repayment = function(params, callback){
		return api.Get('ent/repayment', params,callback);
	};
	
	api.ent.bidRecord = function(params, callback){
		return api.Get('ent/bidRecord', params,callback);
	};
	
	api.ent.currentLoan = function(params, callback){
		return api.Get('ent/currentLoan', params,callback);
	};
	

	//投资理财
	api.finance = {};
	
	//取投标列表
	api.finance.getInvestList = function(params, callback){
		return api.Get('finance/list', params,callback);
	};
	
	//分页投标列表
	api.finance.getInvestLists = function(params, callback){
		return api.Get('finance/lists', params,callback);
	};
	
	//标的信息 getInvestInfo
	api.finance.getInvestInfo = function(params, callback){
		return api.Get('finance/info', params,callback);
	};
	
	/* ===== 贷款 ===== */
	api.loan = {};
	/* 贷款申请 */
	//取已填信息
	api.loan.getLoanInfo =  function(params, callback){
		return api.Get('loan/getInputing', params,callback);
	};
	//提交申请
	api.loan.submitInfo = function(params, callback){
		return api.Post('loan/saveApply', params,callback);
	};
	/* 申请信息填写 */
	//查询认证项
	api.loan.getAllCertify = function(id,params,callback){
		return api.Get('certifyMaterial/myCert/'+id, params,callback);
	};
	//保存各认证项
	api.loan.saveAllCertify = function(id,params,callback){
		return api.Post('certifyMaterial/save/'+id+'/true', params,callback);
	};
	//保存各认证项(企业)
    api.loan.saveAllCertifyEnt = function(id,params,callback){
        return api.Post('certifyMaterial/save/ent/'+id+'/true', params,callback);
    };
    //上传图片
    api.loan.uploadImg = function(params,callback){
        return api.Post('file/upload/img', params,callback);
    };
        
    
	return api;
}();
