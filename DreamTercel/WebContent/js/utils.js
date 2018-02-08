//定义提示弹窗的方法
function myAlert(message) {
	//判断提示框是否存在
	if (window.dialog1) {
		//销毁以前的
		window.dialog1.destroy();
	}
	//新增提示
	window.dialog1 = jqueryAlert({
		//'title':'温馨提示', //弹框的标题 这里可以不用
		'style': 'wap',
		//'modal':false,//添加整个屏幕的大背景
		'content': message, //显示内容 
		'animateType': 'linear', //弹框出现的方式 scale linear 其他为fadeIn动画
		'contentTextAlign': 'center', //设置content显示的位置 center left right
		'width': '300',
		//'height':'100',
		'minWidth': '160',
		'closeTime': 1000, //时间
		'className': 'alertDialog'
	});
}



//权限控制
function isHaveRight(addBtn,updateBtn,deleteBtn,rightCode){

	$.ajax({
		type : "post",
		url : "../isHaveRight.action",
		data:"rightCode="+rightCode,
		//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
		success : function(msg) {
			
			var jsons = jQuery.parseJSON(msg);
			if((jsons.insertFlag!='1')){
				$(addBtn).addClass("but-disabled");
				$(addBtn).tooltip({
					title:'权限不足',
					placement:'bottom'
				})
				$(addBtn).removeAttr("onclick");
				$(addBtn).unbind('click');
				$(addBtn).removeClass("btn-info");
				$(addBtn).addClass("unbtn-info");
			}
			
			if(jsons.updateFlag!='1'){

				$(updateBtn).addClass("but-disabled");
				$(updateBtn).tooltip({
					title:'权限不足',
					placement:'bottom'
				})
				$(updateBtn).removeAttr("onclick");
				$(updateBtn).unbind('click');
				$(updateBtn).removeClass("btn-info");
				$(updateBtn).addClass("unbtn-info");
			}
			if(jsons.deleteFlag!='1'){
				$(deleteBtn).addClass("but-disabled");
				$(deleteBtn).tooltip({
					title:'权限不足',
					placement:'bottom'
				})
				$(deleteBtn).removeAttr("onclick");
				$(deleteBtn).unbind('click');
				$(deleteBtn).removeClass("btn-info");
				$(deleteBtn).addClass("unbtn-info");
			}

		}
	});




}

/**
 * 
 * @param window 当前窗口
 * @param btn 切换窗口的按钮
 * @param div 大div
 * 
 */
function changeDiv(window,btn,div){
	var width = $(window).width();//屏幕的宽度，用于切换时位置的定位
		var btnText=$(btn).html();
		if(btnText=='切换报表'){
			$(div).css('transform', 'translate3d(0px, 0px, 0px)');
			$(btn).html("生成图表");
			$(div).find(".div2").css("display","none");
			
		}else if(btnText=='生成图表'){
			$(div).css('transform', 'translate3d('+-width+'px, 0px, 0px)');
			$(btn).html("切换报表");
			$(div).find(".div2").css("display","block");
		}
}
(function($, h, c) {
	var a = $([]),
	e = $.resize = $.extend($.resize, {}),
	i,
	k = "setTimeout",
	j = "resize",
	d = j + "-special-event",
	b = "delay",
	f = "throttleWindow";
	e[b] = 250;
	e[f] = true;
	$.event.special[j] = {
		setup: function() {
			if (!e[f] && this[k]) {
				return false;
			}
			var l = $(this);
			a = a.add(l);
			$.data(this, d, {
				w: l.width(),
				h: l.height()
			});
			if (a.length === 1) {
				g();
			}
		},
		teardown: function() {
			if (!e[f] && this[k]) {
				return false;
			}
			var l = $(this);
			a = a.not(l);
			l.removeData(d);
			if (!a.length) {
				clearTimeout(i);
			}
		},
		add: function(l) {
			if (!e[f] && this[k]) {
				return false;
			}
			var n;
			function m(s, o, p) {
				var q = $(this),
				r = $.data(this, d);
				r.w = o !== c ? o: q.width();
				r.h = p !== c ? p: q.height();
				n.apply(this, arguments);
			}
			if ($.isFunction(l)) {
				n = l;
				return m;
			} else {
				n = l.handler;
				l.handler = m;
			}
		}
	};
	function g() {
		i = h[k](function() {
			a.each(function() {
				var n = $(this),
				m = n.width(),
				l = n.height(),
				o = $.data(this, d);
				if (m !== o.w || l !== o.h) {
					n.trigger(j, [o.w = m, o.h = l]);
				}
			});
			g();
		},
		e[b]);
	}
})(jQuery, this);

