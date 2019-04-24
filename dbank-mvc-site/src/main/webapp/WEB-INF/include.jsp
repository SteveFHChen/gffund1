<%@ page language="java" contentType="application/javascript; charset=UTF-8" pageEncoding="UTF-8"%><%
String CONTEXT_PATH = request.getContextPath();
String BASE_PATH = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+CONTEXT_PATH+"/";
%>

(function() {
	var CONTENT_PATH = '<%=BASE_PATH%>';
	function getUrl(url) {
		return CONTENT_PATH + url;
	}
	window.getUrl = getUrl;
})();
(function() {
	var scripts = document.getElementsByTagName('script');
	var includeSrc = scripts[scripts.length-1].getAttribute('src');
	var i = includeSrc.lastIndexOf('/'), base = '';
	if (i > -1) {
		base = includeSrc.substr(0, i+1);
	}
	window.getRelativeUrl = function(url) {
		return base + url;
	}
})();
document.write('<link rel="stylesheet" href="'+getRelativeUrl('styles/base.css')+'" />');
document.write('<link rel="stylesheet" href="'+getRelativeUrl('styles/public.css')+'" />');
document.write('<link rel="stylesheet" href="'+getRelativeUrl('styles/main.css')+'" />');
document.write('<script type="text/javascript" src="'+getRelativeUrl('scripts/lib/jquery-1.10.2.min.js')+'" ></script>');
document.write('<script type="text/javascript" src="'+getRelativeUrl('scripts/public/public.js')+'" ></script>');
document.write('<script type="text/javascript" src="'+getRelativeUrl('scripts/public/api.js')+'" ></script>');
document.write('<script type="text/javascript" src="'+getRelativeUrl('scripts/common/head.js')+'" ></script>');
document.write('<script type="text/javascript" src="'+getRelativeUrl('scripts/common/foot.js')+'" ></script>');
