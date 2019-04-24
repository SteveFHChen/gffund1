function doInit() {
	var loanId = getParams().id; // 借款编号
	
	// 查询认证材料信息
	WD.api.beforeLoan.getLoanBaseInfo({ loanId : loanId}, function(data) {
		$('#realname').html(data.realname);
		$('#username').html(data.username);
		$('#sex').html(data.sex);
		$('#certNo').html(data.certNo);
		$('#birthday').html(data.birthday);
		$('#phonenum').html(data.phonenum);
		$('#topEdu').html(data.topEdu);
		$('#gradSchool').html(data.gradSchool);
		$('#entSchYear').html(data.entSchYear);
		$('#home').html(data.homeProv + data.homeCity);
		$('#regist').html(data.registProv + data.registCity);
		$('#liveAddr').html(data.liveAddr);
		$('#liveAddrPost').html(data.liveAddrPost);
		$('#liveAddrPhone').html(data.liveAddrPhone);
		// 授信
		$('#loanPerson').html(data.realname);
		$('#username2').html(data.username);
		$('#title').html(data.title);
		$('#type').html(data.type);
		$('#amount').html(data.amount);
		$('#interest').html(data.interest);
		$('#raisePeriod').html(data.raisePeriod);
		$('#repayMode').html(data.repayMode);
		$('#usage').html(data.usage);
		$('#period').html(data.period);
		$('#status').html(data.status);
	});
	
	// 初始化选项表
	$('.tabTitle h3').click(function() {
		$('.tabTitle h3').removeClass('active');
		$(this).addClass('active');
		
		var contentId = $(this).attr('id') + '-content';
		$('.tabContent').hide();
		$('#' + contentId).show();
	});
	if(getParams().credit) {
		// 直接授信
		$('#creditextension').click();
	}
	
	// 身份证件认证状态 - 认证通过
	$('#idfileAuthStatusPASS').click(function() {
		WD.api.loan.updateIdfileAuthStatus({ loanId : loanId, status : 'PASS'}, function(data) {});
	});
	// 身份证件认证状态 - 格式不对
	$('#idfileAuthStatusUNLEGAL').click(function() {
		WD.api.loan.updateIdfileAuthStatus({ loanId : loanId, status : 'UNLEGAL'}, function(data) {});
	});
	// 身份证件认证状态 - 虚假资料
	$('#idfileAuthStatusFAKE').click(function() {
		WD.api.loan.updateIdfileAuthStatus({ loanId : loanId, status : 'FAKE'}, function(data) {});
	});
	
	// 居住地认证状态 - 认证通过
	$('#liveAddrFileAuthStatusPASS').click(function() {
		WD.api.loan.updateLiveAddrFileAuthStatus({ loanId : loanId, status : 'PASS'}, function(data) {});
	});
	// 居住地认证状态 - 格式不对
	$('#liveAddrFileAuthStatusUNLEGAL').click(function() {
		WD.api.loan.updateLiveAddrFileAuthStatus({ loanId : loanId, status : 'UNLEGAL'}, function(data) {});
	});
	// 居住地认证状态 - 虚假资料
	$('#liveAddrFileAuthStatusFAKE').click(function() {
		WD.api.loan.updateLiveAddrFileAuthStatus({ loanId : loanId, status : 'FAKE'}, function(data) {});
	});
	
	// 学历认证状态 - 认证通过
	$('#eduFileAuthStatusPASS').click(function() {
		WD.api.loan.updateEduFileAuthStatus({ loanId : loanId, status : 'PASS'}, function(data) {});
	});
	// 学历认证状态 - 格式不对
	$('#eduFileAuthStatusUNLEGAL').click(function() {
		WD.api.loan.updateEduFileAuthStatus({ loanId : loanId, status : 'UNLEGAL'}, function(data) {});
	});
	// 学历认证状态 - 虚假资料
	$('#eduFileAuthStatusFAKE').click(function() {
		WD.api.loan.updateEduFileAuthStatus({ loanId : loanId, status : 'FAKE'}, function(data) {});
	});
	
	// 手机实名认证状态 - 认证通过
	$('#phoneFileAuthStatusPASS').click(function() {
		WD.api.loan.updatePhoneFileAuthStatus({ loanId : loanId, status : 'PASS'}, function(data) {});
	});
	// 手机实名认证状态 - 格式不对
	$('#phoneFileAuthStatusUNLEGAL').click(function() {
		WD.api.loan.updatePhoneFileAuthStatus({ loanId : loanId, status : 'UNLEGAL'}, function(data) {});
	});
	// 手机实名认证状态 - 虚假资料
	$('#phoneFileAuthStatusFAKE').click(function() {
		WD.api.loan.updatePhoneFileAuthStatus({ loanId : loanId, status : 'FAKE'}, function(data) {});
	});
	
	// 授信按钮点击
	$('#creditBtn').click(function() {
		WD.api.loan.updateLoanStatus({ loanId : loanId, status : 'PASS'}, function(data) {});
	});
}
$(doInit);

