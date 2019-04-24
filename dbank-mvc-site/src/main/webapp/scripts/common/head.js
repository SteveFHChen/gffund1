function _createHeader(){	
	
	_initHeaderDom();
	
	WD.api.user.getInfo(null,function(data){
		if(data.username){
			if(data.uType=="person"){
				$('.typeUser').show();
				$('#loginUser').text(data.username);
				$('#personLoan').show().siblings().hide();
			}else if(data.uType=="ent"){
				$('.typeEnt').show();
				$('#entLoan').show().siblings().hide();
			}
			$('.noUser').hide();
		}else{
			$('.noUser').show();
		}
		$('.header').show('fast');
	});
	
	//TODEL
	$('.noUser').show();
	$('.header').show();
	
	$('.nav a.hasNext').parent().on('mouseover',function(){
		$(this).find('.nextNav').show();
	}).on('mouseout',function(){
		$(this).find('.nextNav').delay(800).hide();
	});
	
	$('#loginout').click({logout: true},function(){
		WD.api.auth.loginout(null,function(){
			$U.navigate('index.html');
		});
	});
	//alert($('.nav .headList').length);
	$('.nav .headList a').click(function(){
		$('.nav .headList').removeClass('active');
		$('.nav .headList a').removeClass('active');
		$(this).addClass('active');
	});
}
function _initHeaderDom(){
	var str = '';
	str += '<div class="top ta-r">\
		<div class="w-960 m-0a">\
			<a href="'+$U.getUrl('login/register.html','html')+'" class="c-orangeLight mr-5">免费注册</a>\
			<a href="'+$U.getUrl('login/login.html','html')+'" class="c-ccc">立即登录</a>\
		</div>\
	</div>\
	<div class="logo">\
		<div class="w-960 m-0a"><div class="fl-l">\
			<a href="'+$U.getUrl('index.html','html')+'">\
				<img src="'+$U.getUrl('images/logo.png','img')+'" alt="LOGO">\
			</a>\
		</div>\
		<div class="fl-r">\
			<ul class="nav">\
				<li class="headList">\
					<a href="'+$U.getUrl('index.html','html')+'">首页</a>\
				</li>\
				<li class="headList">\
					<a href="'+$U.getUrl('finance/list.html','html')+'">我要理财</a>\
				</li>\
				<li class="headList">\
					<a href="'+$U.getUrl('login/login.html','html')+'" class="loanLink" id="loginLoan">我要借款</a>\
					<a href="'+$U.getUrl('loan/personLoan.html','html')+'" class="loanLink" id="personLoan" style="display:none;">我要借款</a>\
					<a href="'+$U.getUrl('loan/entLoan.html','html')+'" class="loanLink" id="entLoan" style="display:none;">我要借款</a>\
				</li>\
				<li class="headList">\
					<a href="'+$U.getUrl('help/help.html','html')+'">帮助</a>\
				</li>\
				<li>\
					<a href="javascript:;" class="line">&nbsp;</a>\
				</li>\
				<li class="headList">\
					<div class="difType noUser">\
						<a href="'+$U.getUrl('login/register.html','html')+'">注册</a>\
						<a href="'+$U.getUrl('login/login.html','html')+'">登录</a>\
					</div>\
					<div class="difType typeUser">\
						<a href="'+$U.getUrl('user/userCenter.html','html')+'" class="hasNext" id="loginUser"></a>\
						<div class="nextNav" style="display: none;">\
							<a href="'+$U.getUrl('user/myMoneyPay.html','html')+'">充值</a>\
							<a href="'+$U.getUrl('user/myMoneyWithdrawal.html','html')+'">提现</a>\
							<a href="'+$U.getUrl('user/myMoney.html','html')+'">资金管理</a>\
							<a href="'+$U.getUrl('user/myFinance.html','html')+'">理财管理</a>\
							<a href="'+$U.getUrl('user/myLoan.html','html')+'">借款管理</a>\
							<a href="javascript:;" id="loginout">退出</a>\
						</div>\
					</div>\
					<div class="difType typeEnt">\
						<a href="'+$U.getUrl('','html')+'" class="hasNext">企业中心</a>\
						<div class="nextNav" style="display: none;">\
							<a href="'+$U.getUrl('','html')+'">企业借款</a>\
							<a href="">认证资料信息</a>\
							<a href="">消息通知</a>\
						</div>\
					</div>\
				</li>\
			</ul>\
		</div>\
	</div>';
	$('.header').append(str).hide();
}
$(_createHeader);
