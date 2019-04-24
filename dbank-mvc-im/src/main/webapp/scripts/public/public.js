if (!window.WD) {
	window.WD = {};
}
if (!window.console) {
	window.console = {
		log : $.noop
	};
}

//项目布署名
window.WD.proName = 'dbank-mvc-im';
//二种状态:develop  product
window.WD.proState = 'develop';

/** *** 工具 扩展 **** */
WD.utils = {};
$U = WD.utils;

//获取base路径
$U.getRootUrl = function(){
	var base = window.location.protocol+'//'+window.location.host;
	return (window.WD.proState=='product')?base:(base+'/'+window.WD.proName);
}
//获取页面路径
$U.getUrl = function(url,type){
	if(window.location.href){
		if(type=="html"){
			return $U.getRootUrl()+'/views/'+url;
		}else{
			return $U.getRootUrl()+'/'+url;
		}
	}	
}
//跳转到某个页面
$U.navigate = function  (url) {
	window.location.href = $U.getUrl(url,'html');
}
$U.toLogin = function() {
	// TODO
	// window.top.location.href = ;
}

// 载入页面到主体内容中
$U.loadPage = function(url) {
	WD.api.getFile(url, function(content) {
		$('.part-right').html(content);
	});
};

$U.reload = function() {
	window.top.location.reload();
};

$U.Loading = function(target, loading, content) {
	var $target = $(target);
	if (loading) {
		$target.addClass('bl_ui_loading');
		if (content) {
			$(content).addClass('bl_ui_loading_content').insertBefore($target);
		}
	} else {
		$target.removeClass('bl_ui_loading');
		$target.prev('.bl_ui_loading_content').remove();
	}
};

WD.utils.LOADING_NORMAL = '<p><span class="bl_icon bl_icon_20_loading" ></span> 载入中...</p>';
WD.utils.LOADING_LISTTABLE = '<p><span class="bl_icon bl_icon_20_loading" ></span> 正在查询...</p>';

WD.UrlParams = {};
(function() {
	var i, aParams = document.location.search.substr(1).split('&'), aParam;
	for (i = 0; i < aParams.length; i++) {
		aParam = aParams[i].split('=');
		if (aParam[0].length > 0) {
			WD.UrlParams[aParam[0]] = decodeURI(aParam[1]);
		}
	}
})();

WD.RegExp = {
	email : /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/,
	phone : /^(\d{3,4}-?)?\d{7,9}(-\d{3,4})?$/,
	mobile : /^(((13[0-9]{1})|(15[0-9]{1})|18[0-9]{1})+\d{8})$/,
	postcode : /^[0-9]{6}$/,
	url : /^(http(s)?\:\/\/)?([\w-]+\.)+[\w-]+(\/[\w-.\/?%&=]*)?$/,
	name : /^(\w|[\u0080-\uFFFF])+$/
};

/* 按钮 */
WD.Button = function() {

	var pn = function(target, dftMode, modes) {
		var _this = this;
		var $target = $(target);
		if ($target.length > 1) {
			this.$target = $target;
			var buttons = [];
			$target.each(function(index, target) {
				var aButton = new WD.Button(target, dftMode, modes);
				aButton.parentButton = _this;
				buttons.push(aButton); // TODO
			});
			this.buttons = buttons;
			return;
		}
		this.$target = $target.addClass('bl_ui_button');
		if ($target.is('a') && !$target.attr('href')) {
			$target.attr('href', 'javascript:void(0)');
		}

		this._disabled = false;
		this._loading = false;
		this._hover = false;

		this.dftMode = dftMode;
		this.modes = modes;
		this.text = $target.html();
		$target
				.html('<span class="bl_ui_button_helper" ></span><span class="bl_ui_button_helper2" ></span><span class="bl_ui_button_text" ></span><span class="bl_ui_button_loading" >&nbsp;</span>');

		this.changeMode();

		$target.click($.proxy(this._click, this));
		$target.mouseenter($.proxy(this._mouseEnter, this));
		$target.mouseleave($.proxy(this._mouseLeave, this));
	};

	pn.prototype = {

		changeMode : function(mode) {

			if (mode) {
				this.currentMode = this.modes[mode];
			} else {
				this.currentMode = this.dftMode;
			}
			this._refresh();
		},

		_refresh : function() {

			var mode = this.currentMode;
			var look = {
				text : this.text
			};
			if (mode != this.dftMode) {
				if (this.dftMode.normal) {
					$.extend(look, this.dftMode.normal);
					if (this._disabled && this.dftMode.disabled) {
						$.extend(look, this.dftMode.disabled);
					} else if (this._loading && this.dftMode.loading) {
						$.extend(look, this.dftMode.loading);
					} else if (this._hover && this.dftMode.hover) {
						$.extend(look, this.dftMode.hover);
					}
				} else {
					$.extend(look, this.dftMode);
				}
			}
			if (mode.normal) {
				$.extend(look, mode.normal);
				if (this._disabled && mode.disabled) {
					$.extend(look, mode.disabled);
				} else if (this._loading && mode.loading) {
					$.extend(look, mode.loading);
				} else if (this._hover && mode.hover) {
					$.extend(look, mode.hover);
				}
			} else {
				$.extend(look, mode);
			}
			if (this.currentLook) {
				if (this.currentLook.className) {
					this.$target.removeClass(this.currentLook.className);
				} else {
					this.$target.removeClass('bl_ui_button_'
							+ this.currentLook.style);
				}
			}
			if (look.className) {
				this.$target.addClass(look.className);
			} else {
				this.$target.addClass('bl_ui_button_' + look.style);
			}
			this.$target.attr('title', look.title ? look.title : '').find(
					'.bl_ui_button_text').html(
					look.text ? look.text : (this.customText ? this.customText
							: this.text));

			// .html('<span class="bl_ui_button_text"
			// title="'+(look.title?look.title:'')+'" >'
			// +look.text+'</span><span class="bl_ui_button_loading"
			// >&nbsp;</span>');
			this.currentLook = look;
		},

		_click : function() {

			if (!this._loading
					&& !(this._disabled && !this.currentLook.disabledClick)
					&& $.isFunction(this.currentLook.callback)) {
				if (this.parentButton) {
					this.currentLook.callback(this, this.$target[0],
							this.parentButton.buttons,
							this.parentButton.$target);
				} else {
					this.currentLook.callback(this, this.$target[0]);
				}
			}
		},

		_mouseEnter : function() {

			this._hover = true;
			this.$target.addClass('bl_ui_button_h');
			setTimeout($.proxy(function() {
				this._refresh();
			}, this), 0);
		},

		_mouseLeave : function() {

			this._hover = false;
			this.$target.removeClass('bl_ui_button_h');
			setTimeout($.proxy(function() {
				this._refresh();
			}, this), 0);
		},

		setText : function(text) {

			this.customText = text;
			this._refresh();
		},

		enable : function() {

			if (this.buttons) {
				$(this.buttons).each(function(index, button) {
					button.enable();
				});
			} else {
				if (this._disabled) {
					this._disabled = false;
					this.$target.removeClass('bl_ui_button_d');
					this._refresh();
				}
			}
		},

		disable : function() {

			if (this.buttons) {
				$(this.buttons).each(function(index, button) {
					button.disable();
				});
			} else {
				if (!this._disabled) {
					this._disabled = true;
					this.$target.addClass('bl_ui_button_d');
					this._refresh();
				}
			}
		},

		isEnabled : function() {

			return !this._disabled;
		},

		isLoading : function() {

			return this._loading;
		},

		loading : function(loading) {

			if (loading && !this._loading) {
				this._loading = true;
				this.$target.addClass('bl_ui_button_l');
				this._refresh();
			} else if (!loading && this._loading) {
				this._loading = false;
				this.$target.removeClass('bl_ui_button_l');
				this._refresh();
			}
		}
	};

	return pn;
}();

/* 分页 */
WD.PageNav = function() {

	var DEFAULT_CONFIG = {
		defaultPageSize : 10
	};

	var pn = function(container, config) {

		var _this = this;
		this._config = $.extend({
			pageNumbers : true
		}, DEFAULT_CONFIG, config);

		this.$container = $(container).addClass(pn.CLASS);

		this._initElements();
		this._initParams();
		this._refreshDisplay();
	};

	pn.CLASS = 'bl_pageNav';
	pn.CLASS_PREFIX = 'bl_pn_';
	pn.CLASS_PREVIOUS = pn.CLASS_PREFIX + 'previous';
	pn.CLASS_PREVIOUS_DISABLED = pn.CLASS_PREFIX + 'previous_d';
	pn.CLASS_NEXT = pn.CLASS_PREFIX + 'next';
	pn.CLASS_NEXT_DISABLED = pn.CLASS_PREFIX + 'next_d';
	pn.CLASS_PAGENUMBER = pn.CLASS_PREFIX + 'pageNumber';
	pn.CLASS_PAGENUMBERS = pn.CLASS_PREFIX + 'pageNumbers';

	pn.prototype = {

		_initElements : function() {

			$container = this.$container;

			var sb = '<span class="' + pn.CLASS_PREVIOUS + '" >&lt;</span>';
			if (this._config.pageNumbers) {
				sb += '<span class="' + pn.CLASS_PAGENUMBERS + '" ></span>';
			} else {
				sb += '&nbsp;第<span class="' + pn.CLASS_PAGENUMBER
						+ '" ></span>页&nbsp;';
			}
			sb += '<span class="' + pn.CLASS_NEXT + '" >&gt;</span>';
			$container.html(sb);

			var els = {};
			els.$previous = $container.find('.' + pn.CLASS_PREVIOUS).click(
					$.proxy(this.previous, this));
			els.$next = $container.find('.' + pn.CLASS_NEXT).click(
					$.proxy(this.next, this));
			els.$pageNumbers = $container
					.find('.' + pn.CLASS_PAGENUMBERS)
					.delegate('span', 'click', $.proxy(this._pageNoClick, this));
			els.$pageNumber = $container.find('.' + pn.CLASS_PAGENUMBER);

			this._els = els;

		},

		_initParams : function() {

			this._params = {
				pageNo : 0,
				pageSize : this._config.defaultPageSize,
				pageTotal : 0
			};
			// this._targetParams = this._params;
		},

		_refreshDisplay : function() {

			var els = this._els;
			var p = this._params;

			// 上一页、第一页
			if (p.pageNo <= 1) {
				els.$previous.addClass(pn.CLASS_PREVIOUS_DISABLED);
				// els.$first.addClass(pn.CLASS_FIRST_DISABLED);
			} else {
				els.$previous.removeClass(pn.CLASS_PREVIOUS_DISABLED);
				// els.$first.removeClass(pn.CLASS_FIRST_DISABLED);
			}

			// 下一页、最后一页
			if (p.pageNo >= p.pageTotal) {
				els.$next.addClass(pn.CLASS_NEXT_DISABLED);
				// els.$last.addClass(pn.CLASS_LAST_DISABLED);
			} else {
				els.$next.removeClass(pn.CLASS_NEXT_DISABLED);
				// els.$last.removeClass(pn.CLASS_LAST_DISABLED);
			}

			// 页码列表
			if (els.$pageNumbers.length > 0) {
				var sb = '';
				if (p.pageTotal > 0) {
					var begin = p.pageNo - 2;
					if (begin < 1)
						begin = 1;
					var end = begin + 4;
					if (end > p.pageTotal) {
						end = p.pageTotal;
						if (p.pageTotal > 4) {
							begin = p.pageTotal - 4;
						} else {
							begin = 1;
						}
					}
					for ( var i = begin; i <= end; i++) {
						if (i == p.pageNo) {
							sb += '<em>' + i + '</em>';
						} else {
							sb += '<span>' + i + '</span>';
						}
					}
				}
				els.$pageNumbers.html(sb);
			}

			if (els.$pageNumber.length > 0) {
				els.$pageNumber.text(p.pageNo + '/' + p.pageTotal);
			}
		},

		_pageNoClick : function(event) {

			var i = parseInt($(event.target).text());
			this.to(i);
		},

		_parseInputParams : function(params) {

			var func = this._config.inputFunc;
			if ($.isFunction(func)) {
				return func(params);
			} else {
				return {
					pageNo : params.number + 1,
					pageTotal : params.totalPages
				};
			}
		},

		_getOutputParams : function(targetPage) {

			var params = {
				pageNo : targetPage,
				pageSize : this._params.pageSize
			};
			var func = this._config.outputFunc;
			if ($.isFunction(func)) {
				return func(params);
			} else {
				return {
					'page' : params.pageNo - 1,
					'size' : params.pageSize
				};
			}
		},

		first : function() {

			this._doCallBack(this._getOutputParams(1), 'first');
		},

		last : function() {
			var p = this._params;
			this._doCallBack(this._getOutputParams(p.pageTotal), 'last');
		},

		previous : function() {
			var p = this._params;
			if (p.pageNo > 1) {
				this._doCallBack(this._getOutputParams(p.pageNo - 1),
						'previous');
			}
		},

		next : function() {
			var p = this._params;
			if (p.pageNo < p.pageTotal) {
				this._doCallBack(this._getOutputParams(p.pageNo + 1), 'next');
			}
		},

		to : function(page) {

			var p = this._params;
			if (page >= 1 && page <= p.pageTotal) {
				this._doCallBack(this._getOutputParams(page), 'to');
			}
		},

		_doCallBack : function(params, type) {

			if ($.isFunction(this._config.callback)) {
				this._config.callback(params, type);
			}
		},

		setParams : function(inParams) {

			var params = {
				pageNo : 0,
				pageSize : this._config.defaultPageSize,
				pageTotal : 0
			};

			var p = this._parseInputParams(inParams);
			$.extend(params, p);
			if (!params.pageTotal) {
				params.pageTotal = this._params.pageTotal;
			}

			this._params = params;
			this._refreshDisplay();
		}
	};

	return pn;
}();

/* 上传 */
WD.UploadManager = function() {

	var DEFAULT_CONFIG = {
		flashUrl : "scripts/lib/swfupload/swf/swfupload.swf",
		flashDebug : false,
		concurrentSize : 5,
		uploadUrl : null,
		filePostName : 'file',
		fileSizeLimit : 20480000,
		fileTypes : '*.*',
		fileTypesDesc : '所有文件',
		multiSelect : false,
		postParams : null
	};

	var DEFAULT_HANDLE_CONFIG = {
		uploadUrl : null,
		filePostName : 'file',
		fileSizeLimit : 20480000, // 20MB
		fileTypes : '*.*',
		fileTypesDesc : '所有文件',
		mimeTypes : null,
		multiSelect : false,
		postParams : null
	};

	var ERROR_UNKNOWN = -1;
	var ERROR_FILE_EXCEEDS_SIZE_LIMIT = 0;
	var ERROR_INVALID_FILETYPE = 1;

	var uploadManager = function(config) {

		this._config = $.extend({}, DEFAULT_CONFIG, config);

		this.handleCount = 0;
		this.handles = {};
		this.fileCount = 0;
		this.files = {};
		this.waiting = [];

		// 判断浏览器是否支持HTML5文件上传
		if (XMLHttpRequest && new XMLHttpRequest().upload) {
			this._html5Uploading = false;
		} else { // 如果不支持，使用SWFUpload
			this._useSwfUpload = true;
			this.fileIdCountMap = {};
		}
	};

	uploadManager.ERROR_UNKNOWN = ERROR_UNKNOWN;
	uploadManager.ERROR_FILE_EXCEEDS_SIZE_LIMIT = ERROR_FILE_EXCEEDS_SIZE_LIMIT;
	uploadManager.ERROR_INVALID_FILETYPE = ERROR_INVALID_FILETYPE;

	uploadManager.prototype = {

		setDropArea : function(handle, config) {

			var hConfig = $.extend({}, DEFAULT_HANDLE_CONFIG, config);
			var $drop = $(handle);
			/*
			 * var count = 0; document.addEventListener("dragenter", function
			 * (e) { if (count == 0) { $drop.addClass('bl_upload_drop'); } count
			 * ++; }, false ); document.addEventListener("dragleave", function
			 * (e) { count --; if (count == 0) {
			 * $drop.removeClass('bl_upload_drop'); } }, false );
			 * $drop.on("dragenter", function (e) {
			 * $drop.addClass('bl_upload_drop_h'); }); $drop.on("dragleave",
			 * function (e) { $drop.removeClass('bl_upload_drop_h'); });
			 */
			$drop[0].addEventListener("dragover", function(e) {
				e.stopPropagation();
				e.preventDefault();
			}, false);
			$drop[0].addEventListener("drop", $.proxy(function(e) {
				e.stopPropagation();
				e.preventDefault();

				var files = e.dataTransfer.files;
				var oFile = files[0];

				this._html5FileHandler(oFile, hConfig);
			}, this), false);
		},

		add : function(handle, config) {

			var $handle = $(handle);
			var hConfig = $.extend({}, DEFAULT_HANDLE_CONFIG, config);
			var offset = $handle.offset(), width = $handle.outerWidth(), height = $handle
					.outerHeight();

			var $wrapper = $(
					'<span class="bl_upload_wrapper" style="position:relative;" ></span>')
					.insertAfter($handle).append($handle);
			if (this._config.className) {
				$wrapper.addClass(this._config.className);
			}

			var hCount = this.handleCount++;
			this.handles[hCount] = {
				$element : $handle,
				config : hConfig
			};

			if (this._useSwfUpload) {
				var swfUpload = new SWFUpload(
						{
							upload_url : hConfig.uploadUrl,
							file_post_name : hConfig.filePostName,
							post_params : hConfig.postParams,
							file_types : hConfig.fileTypes,
							file_types_description : hConfig.fileTypesDesc,
							file_size_limit : hConfig.fileSizeLimit + 'B',
							// Event Handlers
							swfupload_loaded_handler : $.proxy(function() { // TODO
																			// chrome
																			// firefox
																			// 发生两次事件
								this.$swf = $(swfUpload.movieElement).addClass(
										'bl_upload_swfupload').css({
									position : 'absolute',
									'top' : 0,
									'left' : 0
								});

								/*
								 * //好像只有这种方式能够给Flash绑定事件
								 * this.$swf[0].onmouseout = $.proxy(function() {
								 * this.$swf.css({ top : '-999px', left :
								 * '-999px', width : '10px', height : '10px' });
								 * var hConfig = this.currentHandleConfig; if
								 * ($.isFunction(hConfig.mouseLeave)) {
								 * hConfig.mouseLeave(); } }, this);
								 */
							}, this),
							file_queued_handler : $.proxy(this._swfFileQueued,
									this, hCount),
							file_queue_error_handler : $.proxy(
									this._swfFileQueueError, this, hCount),
							// file_dialog_complete_handler :
							// $.proxy(this._swfFileSelected, this, hCount),
							upload_start_handler : $.proxy(this._swfBegin,
									this, hCount),
							upload_progress_handler : $.proxy(
									this._swfProgress, this, hCount),
							upload_error_handler : $.proxy(this._swfError,
									this, hCount),
							upload_success_handler : $.proxy(this._swfFinish,
									this, hCount),
							upload_complete_handler : $.proxy(this._swfFinally,
									this, hCount),
							// Button Settings
							button_placeholder : $('<span><span>').appendTo(
									$wrapper)[0],
							button_width : width,
							button_height : height,
							button_cursor : SWFUpload.CURSOR.HAND,
							button_action : hConfig.multiSelect ? SWFUpload.BUTTON_ACTION.SELECT_FILES
									: SWFUpload.BUTTON_ACTION.SELECT_FILE,
							button_window_mode : SWFUpload.WINDOW_MODE.TRANSPARENT,
							// Flash Settings
							flash_url : this._config.flashUrl,
							// Debug Settings
							debug : this._config.flashDebug
						});
				this.handles[hCount].swfUpload = swfUpload;
			} else {
				// var $wrapper = $('<div
				// style="position:absolute;width:1px;height:1px;left:-999px"
				// ></div>').appendTo('body');
				var $file = $(
						'<input type="file" style="position:absolute;clip:rect(1px 1px 1px 1px);" />')
						.appendTo($wrapper).on('change',
								$.proxy(this._html5FileSelected, this, hCount));
				if (hConfig.mimeTypes) {
					$file.attr('accept', hConfig.mimeTypes);
				}
				if (hConfig.multiSelect) {
					$file.attr('multiple', 'multiple');
				}
				$handle.click(function() {
					$file.click();
				});
				this.handles[hCount].$file = $file;
			}

			return hCount;
		},

		upload : function(fCount) {

			var file = this.files[fCount];
			handle = this.handles[file.handle], hConfig = handle.config;

			if (handle.swfUpload) {
				try {
					if ($.isFunction(hConfig.begin)) {
						var params = hConfig.begin(fCount, file.info);
						if (params) { // TODO array
							$.map(params, $.proxy(function(value, key) {
								handle.swfUpload
										.addFileParam(index, key, value);
							}, this));
						}
					}
					// console.log('upload h:'+file.handle+' f:'+fCount+'
					// name:'+file.info.fileName+' size:'+file.info.size);
					var stats = handle.swfUpload.getStats();
					if (stats.in_progress == 1) { // 正在上传中，将fileId加入等待列表
						this.waiting.push(fCount);
					} else {
						handle.swfUpload.startUpload(file.swfFile.id);
					}
				} catch (ex) {
					handle.swfUpload.debug(ex);
				}
			} else {
				var oFile = file.html5File, formData = new FormData();
				formData.append(hConfig.filePostName, oFile);
				// html5 begin
				if ($.isFunction(hConfig.begin)) {
					var params = hConfig.begin(fCount, file.info);
					if (params) { // TODO array
						$.map(params, $.proxy(function(value, key) {
							formData.append(key, value);
						}, this));
					}
				}
				file.formData = formData;
				// console.log('upload h:'+file.handle+' f:'+fCount+'
				// name:'+file.info.fileName+' size:'+file.info.size);
				if (this._html5Uploading) {
					this.waiting.push(fCount);
				} else {
					this._html5Begin(fCount);
				}
			}
		},
		destroy : function(hCount) {
			if (this._useSwfUpload) {
				this.handles[hCount].swfUpload.destroy();
			}
		},

		abort : function(fCount) {

			var file = this.files[fCount], handle = this.handles[file.handle], hConfig = handle.config;

			if (handle.swfUpload) {
				handle.swfUpload.cancelUpload(file.swfFile.id, false);
			} else {
				var oXHR = this.oXHRs[index];
				if (oXHR) {
					oXHR.abort();
				}
			}
		},

		_swfFileQueued : function(hCount, oFile) {

			var hConfig = this.handles[hCount].config;
			var info = {
				fileName : oFile.name,
				size : oFile.size
			};
			var ret = true;

			var fCount = this.fileCount++;
			this.files[fCount] = {
				handle : hCount,
				info : info,
				swfFile : oFile
			};
			this.fileIdCountMap[oFile.id] = fCount;

			// console.log('queued h:'+hCount+' f:'+fCount+'
			// name:'+info.fileName+' size:'+info.size);
			if ($.isFunction(hConfig.ready)) {
				ret = hConfig.ready(fCount, info);
			}
			if (ret !== false) {
				this.upload(fCount);
			}
		},

		_swfFileQueueError : function(hCount, oFile, errorCode, errorMessage) {

			var hConfig = this.handles[hCount].config;
			var info = {
				fileName : oFile.name,
				size : oFile.size
			};

			if (errorCode == SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT) {
				this._fileError(hCount, info, ERROR_FILE_EXCEEDS_SIZE_LIMIT,
						'文件大小超出' + hConfig.fileSizeLimit + '字节！');
			} else if (errorCode == SWFUpload.QUEUE_ERROR.INVALID_FILETYPE) {
				this._fileError(hCount, info, ERROR_INVALID_FILETYPE,
						'不支持的文件类型！');
			} else {
				this._fileError(hCount, info, ERROR_UNKNOWN, '未知错误！');
			}
		},

		_fileError : function(hCount, info, errorCode, errorMessage) {

			var ret = true, hConfig = this.handles[hCount].config;
			if ($.isFunction(hConfig.fileError)) {
				ret = hConfig.fileError(hConfig, info, errorCode, errorMessage);
			}
			if (ret !== false) {
				alert('[' + info.fileName + ']' + errorMessage);
			}
		},

		/*
		 * _swfFileSelected : function(numFilesSelected, numFilesQueued) {
		 *  // if (numFilesQueued > 0) { // beforeRequest(this.callback); // } },
		 */

		_swfBegin : function(hCount, oFile) {

		},

		_swfProgress : function(hCount, oFile, bytesLoaded) {

			var handle = this.handles[hCount], hConfig = handle.config;
			var fCount = this.fileIdCountMap[oFile.id], file = this.files[fCount];

			if ($.isFunction(hConfig.progress)) {
				var info = $.extend({
					loaded : bytesLoaded,
					percent : Math.ceil(bytesLoaded * 100 / oFile.size)
				}, file.info);
				hConfig.progress(fCount, info);
			}
		},

		_swfFinish : function(hCount, oFile, serverData) {

			var handle = this.handles[hCount], hConfig = handle.config;
			var fCount = this.fileIdCountMap[oFile.id];

			var _hConfig = $.extend({}, hConfig);
			if ($.isFunction(_hConfig.success)) {
				_hConfig.success = $.proxy(_hConfig.success, null, fCount);
			}
			if ($.isFunction(_hConfig.fail)) {
				_hConfig.fail = $.proxy(_hConfig.fail, null, fCount);
			}

			if (serverData == '') { // fix flash bug (why?)
				WD.api.doFail({
					index : oFile.id,
					errorCode : 0,
					errorMessage : ''
				}, _hConfig);
			} else {
				var data = JSON.parse(serverData);
				WD.api.doSuccess(data, _hConfig);
			}
		},

		_swfError : function(hCount, oFile, errorCode, errorMessage) {

			var handle = this.handles[hCount], hConfig = handle.config;
			// TODO
			var fCount = this.fileIdCountMap[oFile.id];
			// var fCount = this.fileCount++;
			if ($.isFunction(hConfig.fail)) {
				hConfig.fail = $.proxy(hConfig.fail, null, fCount);
			}

			WD.api.doFail({
				errorCode : errorCode,
				errorMessage : errorMessage
			}, hConfig);
		},

		_swfFinally : function(hCount, oFile) {

			if (this.waiting.length > 0) {
				var fCount = this.waiting.shift(), file = this.files[fCount];
				var handle = this.handles[file.handle];
				handle.swfUpload.startUpload(file.swfFile.id);
			}
		},

		_html5FileSelected : function(hCount, e) {

			var $file = $(e.target), hConfig = this.handles[hCount].config, oFiles = $file[0].files;
			for ( var i = 0, s = oFiles.length; i < s; i++) {
				var oFile = oFiles[i];

				var info = {
					fileName : oFile.name,
					size : oFile.size
				};

				if (oFile.size > hConfig.fileSizeLimit) {
					this._fileError(hCount, info,
							ERROR_FILE_EXCEEDS_SIZE_LIMIT, '文件大小超出'
									+ hConfig.fileSizeLimit + '字节！');
					// this._fileError(hCount, info, ERROR_UNKNOWN, '未知错误！');
					return;
				}

				// TODO
				var extIdx = oFile.name.lastIndexOf('.'), ext = extIdx > -1 ? oFile.name
						.substr(extIdx + 1)
						: '';
				var types = hConfig.fileTypes.split(';'), typeInvalid = false;
				$(types)
						.each(
								function(index, type) {
									var aExt = type.substr(2);
									if (aExt == '*'
											|| ext.toLowerCase() == aExt
													.toLowerCase()) {
										typeInvalid = true;
										return false;
									}
								});
				if (!typeInvalid) {
					this._fileError(hCount, info, ERROR_INVALID_FILETYPE,
							'不支持的文件类型！');
					return;
				}

				var fCount = this.fileCount++;
				this.files[fCount] = {
					handle : hCount,
					info : info,
					html5File : oFile
				};

				// console.log('queued h:'+hCount+' f:'+fCount+'
				// name:'+info.fileName+' size:'+info.size);
				var ret = true;
				if ($.isFunction(hConfig.ready)) {
					ret = hConfig.ready(fCount, info);
				}
				if (ret !== false) {
					this.upload(fCount);
				}
			}
			$file.val('');
		},

		_html5Begin : function(fCount) {

			var file = this.files[fCount], handle = this.handles[file.handle], hConfig = handle.config;

			this._html5Uploading = true;

			var oXHR = new XMLHttpRequest();
			file.oXHR = oXHR;
			oXHR.upload.addEventListener('progress', $.proxy(
					this._html5Progress, this, fCount), false);
			oXHR.addEventListener('load', $.proxy(this._html5Finish, this,
					fCount), false);
			oXHR.addEventListener('error', $.proxy(this._html5Error, this,
					fCount), false);
			// oXHR.addEventListener('abort', uploadAbort, false);
			oXHR.open('POST', hConfig.uploadUrl);
			oXHR.send(file.formData);
		},

		_html5Progress : function(fCount, e) {

			var file = this.files[fCount], handle = this.handles[file.handle], hConfig = handle.config;

			if ($.isFunction(hConfig.progress)) {
				var info = $.extend({
					loaded : e.loaded,
					percent : Math.ceil(e.loaded * 100 / e.total)
				}, file.info);
				hConfig.progress(fCount, info);
			}
		},

		_html5Finish : function(fCount, e) {

			var file = this.files[fCount], handle = this.handles[file.handle], hConfig = handle.config;

			var _hConfig = $.extend({}, hConfig);
			if ($.isFunction(_hConfig.success)) {
				_hConfig.success = $.proxy(_hConfig.success, null, fCount);
			}
			if ($.isFunction(_hConfig.fail)) {
				_hConfig.fail = $.proxy(_hConfig.fail, null, fCount);
			}

			var responseText = e.target.responseText;
			var data = responseText.length > 0 ? JSON.parse(responseText) : {};
			WD.api.doSuccess(data, _hConfig);

			this._html5Finally();
		},

		_html5Error : function(fCount, e) {

			var handle = this.handles[hCount], hConfig = handle.config;

			if ($.isFunction(hConfig.fail)) {
				hConfig.fail = $.proxy(hConfig.fail, null, fCount);
			}

			var errorCode = e.target.status, errorMessage = e.target.statusText;
			WD.api.doFail({
				errorCode : errorCode,
				errorMessage : errorMessage
			}, hConfig);

			this._html5Finally();
		},

		_html5Finally : function() {

			this._html5Uploading = false;

			if (this.waiting.length > 0) {
				var fCount = this.waiting.shift();
				this._html5Begin(fCount);
			}
		}
	};

	return uploadManager;
}();
/**
 * fill constants
 */
$U.fillOptions = function(select, dict, select2, dict2) {

	var $select = $(select);
	var sb = '';
	// <option></option>
	$(dict).each(
			function(index, record) {
				sb += '<option value="' + record.key + '" >' + record.text
						+ '</option>';
			});
	$select.html(sb);
	if (select2 && dict2) {
		var $select2 = $(select2);
		var onChange = function() {
			var list = dict2[$select.val()];
			if (list) {
				var sb = '';
				// <option></option>
				$(list).each(
						function(index, record) {
							sb += '<option value="' + record.key + '" >'
									+ record.text + '</option>';
						});
				$select2.html(sb);
			} else {
				$select2.empty();
			}
		};
		$select.change(onChange);
		onChange();
	}
};

$(document).ready(function() {
	WD.uploadManager = new WD.UploadManager();

	$('#backBtn').click(function back() {
		history.back(-1);
	});
});

/**
 * init role list
 */
function initRoleSelect() {
	var selectElt = $('#roleSelect');
	if (selectElt.length > 0) {
		WD.api.adminRole.getAllRole(null, function(data) {
			for ( var i = 0; i < data.length; i++) {
				var role = data[i];
				selectElt.append('<option value="' + role.id + '">' + role.name
						+ '</option>');
			}
		});
	}
}

/**
 * 页面跳转参数传递
 */
function nextStep(url, params) {
	document.location.href = url;
	window.parent.reqParams = params;
}
/**
 * 获取上一个页面的传递参数
 * 
 * @return
 */
function getParams() {
	return window.parent.reqParams;
}