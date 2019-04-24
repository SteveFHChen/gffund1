$(function() {
	// Tab切换
	(function() {
		if ($('.tabBox').length == 0)
			return false;
		$('.tabTitle h3').on('click',function() {
			$(this).addClass('active').siblings().removeClass('active');
			$('.tabContent').eq($(this).index()).show().siblings('.tabContent').hide();
		});
	})();
});