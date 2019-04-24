function doInit() {
	var loanId = getParams().id; // 借款编号
	
	// 加载显示信息
	loadInfo(loanId);
	
	// 认证通过
	$('#certSuccessBtn').click(function() {
		WD.api.loan.updateMaterialFinancialRptStatus({ loanId : loanId, status : 'PASS'}, function(data) {
			if('success' == data.result) {
				$('#frfasContent').empty();
				loadInfo(loanId);
			}
		});
	});
	// 格式不对
	$('#formatErrorBtn').click(function() {
		WD.api.loan.updateMaterialFinancialRptStatus({ loanId : loanId, status : 'UNLEGAL'}, function(data) {});
	});
	// 虚假
	$('#falseInfoBtn').click(function() {
		WD.api.loan.updateMaterialFinancialRptStatus({ loanId : loanId, status : 'FAKE'}, function(data) {});
	});
	// 授信按钮点击
	$('#creditBtn').click(function() {
		WD.api.loan.updateLoanStatus({ loanId : loanId, status : 'PASS'}, function(data) {});
	});
	
	
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
}
$(doInit);
/**
 * 加载页面信息
 * 
 * @param loanId
 */
function loadInfo(loanId) {
	WD.api.beforeLoan.getLoanBaseInfo({ loanId : loanId}, function(data) {
		if(data.finaReportFileAuthStatus == 'APPLY') {
			$('#frfasContent').show();
		}
		$('#realname').html(data.realname);
		$('#username').html(data.username);
		$('#sex').html(WD.Dict.getDisplay('Sex', data.sex));
		$('#certType').html(WD.Dict.getDisplay('CertType', data.credentType));
		$('#certNo').html(data.certNo);
		$('#birthday').html(data.birthday);
		$('#phonenum').html(data.phonenum);
		$('#topEdu').html(WD.Dict.getDisplay('Education', data.eduLevel));
		$('#liveAddr').html(data.liveAddr);
		$('#name').html(data.name);
		$('#regMoney').html(data.regMoney);
		$('#industry').html(data.industry);
		$('#mainBusi').html(data.mainBusi);
		$('#runYears').html(data.runYears);
		$('#regAddress').html(data.regAddress);
		$('#runAddress').html(data.runAddress);
		// 企业财务信息
		$('#totalAssets').html(data.totalAssets);
		$('#totalDebt').html(data.totalDebt);
		$('#lastYearSell').html(data.lastYearSell);
		$('#lastYearProfit').html(data.lastYearProfit);
		$('#lastYearFinanCost').html(data.lastYearFinanCost);
		$('#moneyFund').html(data.moneyFund);
		$('#finaReportFileAuthStatus').html(WD.Dict.getDisplay('MaterialStatus', data.finaReportFileAuthStatus));
		$('#finaReportFile').html(data.finaReportFile);
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
}