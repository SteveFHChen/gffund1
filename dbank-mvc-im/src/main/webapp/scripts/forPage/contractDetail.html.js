$(function(){
	//初始化合同内容
	WD.api.contract.contractDetail(null, function(data){
		var div = "";
		div += "甲方（投资人）：" + data.invest + "<br/>";
		div += "用户名：" + data.investUser + "<br/>";
		div += "投标金额：" + data.investMoney + "<br/>";
		div += "借款期限：" + data.loanDeadline + "<br/>";
		div += "每月应收本息：" + data.getMoneyForMonth + "<br/>";
		div += "总计：" + data.total + "<br/><br/><br/>";
		
		div += "乙方（借款人）:" + data.loan + "<br/>";
		div += "用户名：" + data.loanUser + "<br/>";
		div += "真实姓名：" + data.realName + "<br/>";
		div += "身份证号：" + data.identidyCard + "<br/><br/>";
		
		div += "丙方（平台服务商）：" + data.platForm + "<br/>";
		div += "联系方式：" + data.call + "<br/>";
		div += "地址：" + data.address + "<br/><br/>";
		
		div += "鉴于：<br/>";
		div += "1、丙方是一家在北京市合法成立并有效存续的有限责任公司，拥有www.********.com 网站（以下简称“该网站”）的经营权，提供信用咨询，为交易提供信息服务；<br/>";
		div += "2、乙方已在该网站注册，并承诺其提供给丁方的信息是完全真实的；<br>";
		div += "3、甲方承诺对本协议涉及的借款具有完全的支配能力，是其自有闲散资金，为其合法所得；并承诺其提供给丁方的信息是完全真实的；<br>";
		div += "4、乙方有借款需求，甲方亦同意借款，双方有意成立借贷关系；<br><br>";
		
		div += "各方经协商一致，于（日期）签订如下协议，共同遵照履行：<br><br>";
		div += "第一条&nbsp; &nbsp;&nbsp; 借款基本信息<br>";
		div += "借款详细用途：" + data.loanUse + "<br/>";
		div += "借款本金数额：" + data.loanMoney + "<br/>";
		div += "借款年利率：" + data.loanRate + "<br/>";
		div += "借款期限：" + data.loanDeadline + "<br/>";
		div += "月偿还本息数额：" + data.getMoneyForMonth + "<br/>";
		div += "还款分期月数：" + data.stages + "<br/>";
		div += "还款日：" + data.loanDeadline + "<br/><br/>";
		
		div += "第二条&nbsp; &nbsp;&nbsp; 各方权利和义务<br>";
		div += "甲方权利和义务<br>";
		div += "乙方权利和义务<br>";
		div += "丙方权利和义务<br><br>";
		
		div += "第三条&nbsp; &nbsp;&nbsp; 费用规则<br><br>";
		div += "第四条&nbsp; &nbsp; &nbsp; 违约责任<br><br>";
		div += "第五条&nbsp; &nbsp;&nbsp; 法律及争议解决<br><br>";
		div += "第六条&nbsp; &nbsp;&nbsp; 附则<br>";
		
		$("#loanContract").html(div);
	});
});