$(function(){
	//导航下拉
	(function(){
		$('.nav a.hasNext').parent().on('mouseover',function(){
			$(this).find('.nextNav').show();
		}).on('mouseout',function(){
			$(this).find('.nextNav').delay(800).hide();
		});
	})();
	
	//Tab切换
	(function(){
		if($('.tabBox').length==0) return false;
		$('.tabTitle h3').on('click',function(){
			$(this).addClass('active').siblings().removeClass('active');
			$('.tabContent').eq($(this).index()).show().siblings('.tabContent').hide();
			//crumbsTextChange();
		});
	}
	)();
	(function(){
		//crumbsTextChange();
	})();
	(function (){
		var object = $("#creditextension");
		object.click(); 
	}
	)();
});
