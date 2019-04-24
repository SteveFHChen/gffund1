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
	});
	
	// 初始化选项表
	$('.tabTitle h3').click(function() {
		$('.tabTitle h3').removeClass('active');
		$(this).addClass('active');
		
		var contentId = $(this).attr('id') + '-content';
		$('.tabContent').hide();
		$('#' + contentId).show();
	});
	
	// 复审通过
	$('#reviewPassBtn').click(function() {
		WD.api.loan.updateLoanStatus({ loanId : loanId, status : 'SECOND_PASS'}, function(data) {});
	});
	// 复审不通过
	$('#reviewDenyBtn').click(function() {
		WD.api.loan.updateLoanStatus({ loanId : loanId, status : 'SECOND_DENY'}, function(data) {});
	});
}
$(doInit);

