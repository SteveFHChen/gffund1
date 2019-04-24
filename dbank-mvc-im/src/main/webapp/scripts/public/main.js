$(function(){
	//导航下拉
	(function(){
		$('.nav a.hasNext').parent().on('mouseover',function(){
			$(this).find('.nextNav').show();
		}).on('mouseout',function(){
			$(this).find('.nextNav').delay(800).hide();
		});
	})();
		
	(function(){
		//if($('.tabBox').length==0) return false;
		$('.tabTitle.ccc>h3').on('click',function(){
			$(this).addClass('active').siblings().removeClass('active');
			$('.tabContent.ccc>table').eq($(this).index()).show().siblings().hide();
		});
	})();
	
	//TabFinance切换
	(function(){
		//if($('.tabBox').length==0) return false;
		$('.tabTitle.xxx>h3').on('click',function(){
			$(this).addClass('active').siblings().removeClass('active');
			$('.tabContent.xxx>table').eq($(this).index()).show().siblings().hide();
		});
	})();
});
	
var finance = {};
finance.tabShow = function(){
	if($('.xq-content').length==0) return false;
	$('.xq-content .tab li').on('click',function(){
		$(this).addClass('on').siblings().removeClass('on');
		$('.xq-body .tabContent').eq($(this).index()).show().siblings().hide();
	})
}