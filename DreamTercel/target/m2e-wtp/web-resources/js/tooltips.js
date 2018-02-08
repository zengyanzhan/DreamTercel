var msgdsq;
//错误时：提示调用方法
function show_err_msg(msg){
	 $('.msg_bg').html('');
	 clearTimeout(msgdsq);
	 $('body').append('<div class="sub_err" style="position:absolute;top:60px;left:0;width:500px;z-index:999999;"></div>');
	 var errhtml='<div  class="bac" style="padding:8px 0px;border:1px solid #ff0000;width:100%;margin:0 auto;background-color:#fff;color:#B90802;border:3px #ff0000 solid;text-align:center;font-size:16px;font-family:微软雅黑;"><img style="margin-right:10px;" src="../image/error.png">';
	 var errhtmlfoot='</div>';	 
	 $('.msg_bg').height($(document).height());
	 $('.sub_err').html(errhtml+msg+errhtmlfoot);
	 var left=($(document).width()-500)/2;
	 $('.sub_err').css({'left':left+'px'});
	 var scroll_height=$(document).scrollTop(); 
	 $('.sub_err').animate({'top': scroll_height+120},300);
	 msgdsq=setTimeout(function(){				     
		 $('.sub_err').animate({'top': scroll_height+80},300);
		 setTimeout(function(){
			 $('.msg_bg').remove();
			 $('.sub_err').remove();
		 },300);
	 }, "1000"); 
}

//正确时：提示调用方法
function show_msg(msg,url){	
     $('.msg_bg').html('');
	 clearTimeout(msgdsq);
	 $('body').append('<div class="sub_err" style="position:absolute;top:60px;left:0;width:500px;z-index:999999;"></div>');
	 var htmltop='<div class="bac" style="padding:8px 0px;border:1px solid #090;width:100%;margin:0 auto;background-color:#FFF2F8;color:#090;border:3px #090 solid;;text-align:center;font-size:16px;"><img style="margin-right:10px;" src="../image/loading.gif">';
	 var htmlfoot='</div>';
	 $('.msg_bg').height($(document).height());
	 var left=($(document).width()-500)/2;
	 $('.sub_err').css({'left':left+'px'});
	 $('.sub_err').html(htmltop+msg+htmlfoot);
	 var scroll_height=$(document).scrollTop(); 
	 $('.sub_err').animate({'top': scroll_height+120},500);	 
	 msgdsq=setTimeout(function(){	    
		   $('.sub_err').animate({'top': scroll_height+80},500);
		   setTimeout(function(){
			   $('.msg_bg').remove();
			   $('.sub_err').remove();
			   if(url!='')
			   {	     
				  location.href=url;
			   }		   
		   },800);	 
		   
	 }, "1200");  
}

//显示加载动画
function show_loading()
{
	var str='<div class="msg_bg" style="background:#000;opacity:0.5;filter:alpha(opacity=50);z-index:99998;width:100%;position:absolute;left:0;top:0"></div>';
	str+='<div class="msg_bg" style="z-index:99999;width:100%;position:absolute;left:0;top:0;text-align:center;"><img src="../images/loading.gif" alt="" class="loading"></div>'
	$('body').append(str);
	var scroll_height=$(document).scrollTop(); 
	$('.msg_bg').height($(document).height());
	$('.loading').css('margin-top',scroll_height+240);
}

//改变主题
  function changeEasyUITheme(themeName)  {
    var $easyuiTheme = $('#easyuiTheme');
    var url = $easyuiTheme.attr('href'); 
    
    //将获取到的主题link URL拆装组合为要改变的样式地址
    var href = url.substr(0, url.indexOf('easyui'))  +
        'easyui/themes/' + themeName + '/easyui.css';
    $easyuiTheme.attr('href', href);
  
    //以下是改变页面内框架的样式,如果不设置这个,遇到内框架的样式只能改变外部框架的主题
    var $iframe = $('iframe');
    if($iframe.length > 0) {
      for(var i = 0; i < $iframe.length; i++) {
          var ifr = $iframe[i];
          $(ifr).contents().find('#easyuiTheme').attr('href', href);
          // alert(href);
      }
    }
   
    $.cookie('themeName', themeName, {
        expires : 7
    });
};