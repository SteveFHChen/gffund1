jQuery.cookie = function(name, value, options) {
    if (typeof value != 'undefined') {
	 options = options || {};
	 if (value === null) {
	     value = '';
	     options = $.extend({}, options);
	     options.expires = -1;
	 }
	 var expires = '';
	 if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
	     var date;
	     if (typeof options.expires == 'number') {
		  date = new Date();
		  date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
	     } else {
		  date = options.expires;
	     }
	     expires = '; expires=' + date.toUTCString();
	 }
	 var path = options.path ? '; path=' + (options.path) : '';
	 var domain = options.domain ? '; domain=' + (options.domain) : '';
	 var secure = options.secure ? '; secure' : '';
	 document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
    } else {
	 var cookieValue = null;
	 if (document.cookie && document.cookie != '') {
	     var cookies = document.cookie.split(';');
	     for (var i = 0; i < cookies.length; i++) {
		  var cookie = jQuery.trim(cookies[i]);
		  if (cookie.substring(0, name.length + 1) == (name + '=')) {
		      cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
		      break;
		  }
	     }
	 }
	 return cookieValue;
    }
};

jQuery.isString = function(o) {
	return (typeof o==="string");
};


jQuery.fn.serializeJSON = function() {
	var json = {};
	jQuery.map($(this).serializeArray(), function(n, i){
		json[n['name']] = n['value'];
	});
	return json;
};

jQuery.fn.setData = function(data) {
	var $form = $(this);
	jQuery.each(data, function(k, v) {
		var $el = $form.find('[name="'+k+'"]');
		if ($el.is(':radio')) {
			$el.filter('[value="'+v+'"]').attr('checked', 'checked');
		} else {
			$el.val(v);	//TODO
		}
	});
};



jQuery.fn.quickHide = function() {
	this.css('display', 'none');
	return this;
};

jQuery.fn.quickShow = function() {
	this.css('display', '');
	return this;
};



/*
jQuery `input` special event v1.1

http://whattheheadsaid.com/projects/input-special-event

(c) 2010-2011 Andy Earnshaw
MIT license
www.opensource.org/licenses/mit-license.php
*/
(function($, udf) {
	var timer;
var ns = ".inputEvent ",
    // A bunch of data strings that we use regularly
    dataBnd = "bound.inputEvent",
    dataVal = "value.inputEvent",
    dataDlg = "delegated.inputEvent",
    // Set up our list of events
    bindTo = [
	 "input", "textInput", "propertychange", "paste", "cut", "keydown", "drop",
    ""].join(ns),
    // Events required for delegate, mostly for IE support
    dlgtTo = [ "focusin", "mouseover", "dragstart", "" ].join(ns),
    // Elements supporting text input, not including contentEditable
    supported = {TEXTAREA:udf, INPUT:udf},
    // Events that fire before input value is updated
    delay = { paste:udf, cut:udf, keydown:udf, drop:udf, textInput:udf };

$.event.special.txtinput = {
    setup: function(data, namespaces, handler) {
	 var triggerTimer,
	     bndCount,
	     changeTimer,
	     // Get references to the element
	     elem  = this,
	     $elem = $(this),
	     triggered = false;

	 if (elem.tagName in supported) {
	     bndCount = $.data(elem, dataBnd) || 0;

	     if (!bndCount)
		  $elem.bind(bindTo, handler);

	     $.data(elem, dataBnd, ++bndCount);
	     $.data(elem, dataVal, elem.value);
	 } else {
	     $elem.bind(dlgtTo, function (e) {
		  var target = e.target;
		  if (target.tagName in supported && !$.data(elem, dataDlg)) {
		      bndCount = $.data(target, dataBnd) || 0;

		      if (!bndCount)
			   target.bind(bindTo, handler);

		      // make sure we increase the count only once for each bound ancestor
		      $.data(elem, dataDlg, true);
		      $.data(target, dataBnd, ++bndCount);
		      $.data(target, dataVal, target.value);
		  }
	     });
	 }
	 function handler (e) {
	     var elem = e.target;

	     // Clear previous timers because we only need to know about 1 change
	     window.clearTimeout(timer), timer = null;

	     // Return if we've already triggered the event
	     if (triggered)
		  return;

	     // paste, cut, keydown and drop all fire before the value is updated
	     if (e.type in delay && !timer) {
		  // ...so we need to delay them until after the event has fired
		  timer = window.setTimeout(function () {
		      if (elem.value !== $.data(elem, dataVal)) {
			   $(elem).trigger("txtinput");
			   $.data(elem, dataVal, elem.value);
		      }
		  }, 0);
	     }
	     else if (e.type == "propertychange") {
		  if (e.originalEvent.propertyName == "value") {
		      $(elem).trigger("txtinput");
		      $.data(elem, dataVal, elem.value);
		      triggered = true;
		      window.setTimeout(function () {
			   triggered = false;
		      }, 0);
		  }
	     }
	     else {
		  $(elem).trigger("txtinput");
		  $.data(elem, dataVal, elem.value);
		  triggered = true;
		  window.setTimeout(function () {
		      triggered = false;
		  }, 0);
	     }
	 }
    },
    teardown: function () {
	 var elem = $(this);
	 elem.unbind(dlgtTo);
	 elem.find("input, textarea").andSelf().each(function () {
	     bndCount = $.data(this, dataBnd, ($.data(this, dataBnd) || 1)-1);

	     if (!bndCount)
		  elem.unbind(bindTo);
	 });
    }
};

// Setup our jQuery shorthand method
$.fn.input = function (handler) {
    return handler ? this.bind("txtinput", handler) : this.trigger("txtinput");
}
})(jQuery);


jQuery.encodeText = function(text) {
	
	if (typeof text !== 'string') {
		return '';
	}
	var s = text;
	return s.replace(/&/g, "&gt;").replace(/</g, "&lt;").replace(/>/g, "&gt;")
				.replace(/ /g, "&nbsp;").replace(/\'/g, "&#39;").replace(/\"/g, "&quot;")
				.replace(/\n/g, '<br />');
};


jQuery.windowSize = function() {
	
	var size = {};
	if($.browser.msie){ 
		size.height = document.compatMode == "CSS1Compat" ? 
				document.documentElement.clientHeight : document.body.clientHeight; 
		size.width = document.compatMode == "CSS1Compat" ?
				document.documentElement.clientWidth : document.body.clientWidth;
	} else {
		size.height = self.innerHeight;
		size.width = self.innerWidth;
	}
	return size;
};

jQuery.getInputWidth = function(el){
	el = $(el);
    var s = $('<span >'+el.val()+'</span>');
    s.css({
	position : 'absolute',
	left : -9999,
	top : -9999,
	// ensure that the span has same font properties as the element
	'font-family' : el.css('font-family'),
	'font-size' : el.css('font-size'),
	'font-weight' : el.css('font-weight'),
	'font-style' : el.css('font-style')
    });
    $('body').append(s);
    var result = s.width();
    //remove the newly created span
    s.remove();
    return result;
};

jQuery.grayScaleImg = function(src){
	var canvas = document.createElement('canvas');  
	var ctx = canvas.getContext('2d');  
	var imgObj = new Image();  
	imgObj.src = src;  
	canvas.width = imgObj.width;  
	canvas.height = imgObj.height;  
	ctx.drawImage(imgObj, 0, 0);  
	var imgPixels = ctx.getImageData(0, 0, canvas.width, canvas.height);  
	for(var y = 0; y < imgPixels.height; y++){  
		for(var x = 0; x < imgPixels.width; x++){  
			var i = (y * 4) * imgPixels.width + x * 4;  
			var avg = (imgPixels.data[i] + imgPixels.data[i + 1] + imgPixels.data[i + 2]) / 3;  
			imgPixels.data[i] = avg;  
			imgPixels.data[i + 1] = avg;  
			imgPixels.data[i + 2] = avg;  
		}  
	}  
	ctx.putImageData(imgPixels, 0, 0, 0, 0, imgPixels.width, imgPixels.height);  
	return canvas.toDataURL();  
};

jQuery.showObject = function(obj) {
	
	var sb = [];
	for (var i in obj) {
		sb.push(i + ':' + obj[i]);
	}
	return '{'+sb.join(', ')+'}';
};

