//发送通知
function sendNotice(url){
	WD.api.getFile("user/notice/" + url, function(content) {
		$('.part-right').html(content);
	});
}