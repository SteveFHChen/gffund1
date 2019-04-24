function doInit() {
	$U.fillOptions('.bidType', WD.Dict.LoanType);
	// 查询
	$("#toBeCertied_searchBtn").click(function() {
		var name = $('#toBeCertied_loanPerson').val();
		var bidType = $('#toBeCertied_bidType').val();
		var isGuarantee = $('#toBeCertied_isGuarantee').is(":checked");
		var searchParams = {
			name : name,
			type : bidType,
			guarantee : isGuarantee
		};
		var pageNav = new WD.PageNav('#toBeCertied_pageNav', {
			callback : $.proxy(function(params) {
				$.extend(params, searchParams);
				WD.api.loan.getToBeCerttifiedList(params, function(data) {
					renderToBeCertiedList('toBeCertied-content', data.content);
					pageNav.setParams(data);
				});
			}, this)
		});
		pageNav.first();
	});
	$("#agree_searchBtn").click(function() {
		var name = $('#agree_loanPerson').val();
		var bidType = $('#agree_bidType').val();
		var isGuarantee = $('#agree_isGuarantee').is(":checked");
		var searchParams = {
			name : name,
			type : bidType,
			guarantee : isGuarantee
		};
		var pageNav = new WD.PageNav('#agree_pageNav', {
			callback : $.proxy(function(params) {
				$.extend(params, searchParams);
				WD.api.loan.getReviewCerttifiedList(params, function(data) {
					renderAgreeList('agree-content', data.content);
					pageNav.setParams(data);
				});
			}, this)
		});
		pageNav.first();
	});
	$("#disagree_searchBtn").click(function() {
		var name = $('#disagree_loanPerson').val();
		var bidType = $('#disagree_bidType').val();
		var isGuarantee = $('#disagree_isGuarantee').is(":checked");
		var searchParams = {
			name : name,
			type : bidType,
			guarantee : isGuarantee
		};
		var pageNav = new WD.PageNav('#disagree_pageNav', {
			callback : $.proxy(function(params) {
				$.extend(params, searchParams);
				WD.api.loan.getReviewDenyCerttifiedList(params, function(data) {
					renderDisagreeList('disagree-content', data.content);
					pageNav.setParams(data);
				});
			}, this)
		});
		pageNav.first();
	});
	
	$('.tabTitle h3').click(function() {
		$('.tabTitle h3').removeClass('active');
		$(this).addClass('active');
		
		var contentId = $(this).attr('id');
		$('.tabContent').hide();
		$('#' + contentId + '-content').show();
		if (contentId == 'toBeCertied') {
			$('#navPath').html('待认证授信借款');
		} else if (contentId == 'agree') {
			$('#navPath').html('复审通过借款');
		} else if (contentId == 'disagree') {
			$('#navPath').html('复审未通过借款');
		}
	});
}
$(doInit);
/**
 * 待认证授信列表
 * 
 * @param tabId
 * @param data
 */
function renderToBeCertiedList(tabId, data) {
	var str = '';
	if (data) {
		for ( var i = 0; i < data.length; i++) {
			var row = data[i];
			
			if( i % 2 == 0) {				
				str += '<tr>';
			} else {
				str += '<tr class="gare_bg">';
			}
			str += '<td align="center">' + row.user + '</td>';
			str += '<td align="center">' + WD.Dict.getDisplay('LoanType', row.loanType) + '</td>';
			str += '<td align="center">' + row.amount + '</td>';
			str += '<td align="center">' + row.interest + '</td>';
			str += '<td align="center">' + row.loanStatus + '</td>';
			str += '<td align="center"><a href="javascript:certification(' + row.id + ', ' + row.userType + ');" >认证</a>  &nbsp; <a href="javascript:credit(' + row.id + ', ' + row.userType + ');">授信</a></td>';
			str += '</tr>';
		}
	}
	$('#' + tabId + '>.listTable>tbody').empty().append(str);
}
/**
 * 复审通过列表
 * 
 * @param tabId
 * @param data
 */
function renderAgreeList(tabId, data) {
	var str = '';
	if (data) {
		for ( var i = 0; i < data.length; i++) {
			var row = data[i];
			
			if( i % 2 == 0) {				
				str += '<tr>';
			} else {
				str += '<tr class="gare_bg">';
			}
			str += '<td align="center">' + row.user + '</td>';
			str += '<td align="center">' + WD.Dict.getDisplay('LoanType', row.loanType) + '</td>';
			str += '<td align="center">' + row.amount + '</td>';
			str += '<td align="center">' + row.interest + '</td>';
			str += '<td align="center">' + row.loanStatus + '</td>';
			str += '<td align="center"><a href="javascript:certification(' + row.id + ', ' + row.userType + ');" >查看</a></td>';
			str += '</tr>';
		}
	}
	$('#' + tabId + '>.listTable>tbody').empty().append(str);
}
/**
 * 复审未通过列表
 * 
 * @param tabId
 * @param data
 */
function renderDisagreeList(tabId, data) {
	var str = '';
	if (data) {
		for ( var i = 0; i < data.length; i++) {
			var row = data[i];
			
			if( i % 2 == 0) {				
				str += '<tr>';
			} else {
				str += '<tr class="gare_bg">';
			}
			str += '<td align="center">' + row.user + '</td>';
			str += '<td align="center">' + WD.Dict.getDisplay('LoanType', row.loanType) + '</td>';
			str += '<td align="center">' + row.amount + '</td>';
			str += '<td align="center">' + row.interest + '</td>';
			str += '<td align="center">' + row.loanStatus + '</td>';
			str += '<td align="center"><a href="javascript:certification(' + row.id + ', ' + row.userType + ');" >查看</a></td>';
			str += '</tr>';
		}
	}
	$('#' + tabId + '>.listTable>tbody').empty().append(str);
}
/**
 * 认证
 */
function certification(id, userType) {
	params = {
		id : id
	};
	var url = 'certificationCreditPerson.html';
	if(userType == 1) {
		url = 'certificationCreditCorpor.html';
	}
	nextStep(url, params);
}
/**
 * 授信
 * 
 * @param id
 * @param userType
 */
function credit(id, userType) {
	params = {
		id : id,
		credit : true
	};
	var url = 'certificationCreditPerson.html';
	if (userType == 1) {
		url = 'certificationCreditCorpor.html';
	}
	nextStep(url, params);
}