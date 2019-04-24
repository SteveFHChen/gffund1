function doInit() {
	$U.fillOptions('.bidType', WD.Dict.LoanType);
	// 查询
	$("#toBeReview_searchBtn").click(function() {
		var name = $('#toBeReview_loanPerson').val();
		var bidType = $('#toBeReview_bidType').val();
		var isGuarantee = $('#toBeReview_isGuarantee').is(":checked");
		var searchParams = {
			name : name,
			type : bidType,
			guarantee : isGuarantee
		};
		var pageNav = new WD.PageNav('#toBeReview_pageNav', {
			callback : $.proxy(function(params) {
				$.extend(params, searchParams);
				WD.api.loan.getToBeReviewList(params, function(data) {
					renderToBeReviewList('toBeReview-content', data.content);
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
		if (contentId == 'toBeReview') {
			$('#navPath').html('待复审借款');
		} else if (contentId == 'agree') {
			$('#navPath').html('复审通过借款');
		} else if (contentId == 'disagree') {
			$('#navPath').html('复审未通过借款');
		}
	});
}
$(doInit);
/**
 * 待复审借款列表
 * 
 * @param tabId
 * @param data
 */
function renderToBeReviewList(tabId, data) {
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
			str += '<td align="center"><a href="javascript:reviewLoan(' + row.id + ', ' + row.userType + ');" >复审</a></td>';
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
			str += '<td align="center"><a href="javascript:reviewLoan(' + row.id + ', ' + row.userType + ');" >查看</a></td>';
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
			str += '<td align="center"><a href="javascript:reviewLoan(' + row.id + ', ' + row.userType + ');" >查看</a></td>';
			str += '</tr>';
		}
	}
	$('#' + tabId + '>.listTable>tbody').empty().append(str);
}
/**
 * 复审
 */
function reviewLoan(id, userType) {
	params = {
		id : id
	};
	var url = 'forCreditReviewOfBorrowingPerson.html';
	if(userType == 1) {
		url = 'forCreditReviewOfBorrowingCorpor.html';
	}
	nextStep(url, params);
}
