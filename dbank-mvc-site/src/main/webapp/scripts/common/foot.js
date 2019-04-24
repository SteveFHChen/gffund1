$(function(){
	_createFooter();
});
function _createFooter(){
	var str = ''
		+'<div class="w-960 m-0a">'
			+'<div>'
				+'<h3 class="fs-18 dp-i">友情链接</h3>'                                                      		
				+'<a href="javascript:;">慧聪金融</a>'
				+'<a href="javascript:;">易观智库</a>'
				+'<a href="javascript:;">好贷网</a>'
				+'<a href="javascript:;">银率网</a>'
				+'<a href="javascript:;">和讯银行</a>'
				+'<a href="javascript:;">国美在线</a>'
				+'<a href="javascript:;">财经道</a>'
				+'<a href="javascript:;">电商服务</a>'
				+'<a href="javascript:;">ShopEx</a>'
				+'<a href="javascript:;">58投资担保</a>'
			+'</div>'
			+'<div class="line"></div>'
			+'<div class="w-700 fl-l">'
				+'<h3 class="fs-18 dp-i">公司介绍</h3>'
				+'<a href="javascript:;">安全保障</a>'
				+'<a href="javascript:;">媒体报道</a>'
				+'<a href="javascript:;">社会责任</a>'
				+'<a href="javascript:;">网站地图</a>'
				+'<a href="javascript:;">帮助中心</a>'
				+'<a href="javascript:;">联系我们</a>'
			+'</div>'
			+'<div class="w-250 fl-r fs-18 ta-r">'
				+'客服电话&nbsp;&nbsp;400-027-8080'
			+'</div>'
			+'<div class="clear ta-c pb-100">&copy; 2013 人人贷 All rights reserved&nbsp;&nbsp;&nbsp;人人贷商务顾问(北京)有限公司&nbsp;&nbsp;&nbsp;京ICP证 100953号</div>'
		+'</div>';
	$('.footer').html(str);
}