<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>基金估值核算系统</title>
  <link rel="stylesheet" href=" css/bootstrap.css" />
  <!-- Font Awesome 图片以及字体-->
  <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"/>
  <!-- Ionicons 图标-->
  <link rel="stylesheet" href="ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href=" css/AdminLTE.min.css"/>
  <link rel="stylesheet" href=" css/_all-skins.min.css"/>
  <script type="text/javascript" src="js/echarts.min.js"></script>
 <!--选项卡需要的包-->
<!--/**********************/-->
<link href=" css/jquery.scrollbar.min.css" rel="stylesheet"/>

<link href="font-awesome/css/font-awesome.min.css"/>

<link href=" css/nth.tabs.min.css" rel="stylesheet"/>

<link href=" css/main.css" rel="stylesheet"/>
<script type="text/javascript">

function LoadBlogParts(){
	var swfUrl = "image/honehone_clock_tr.swf";
	var swfTitle = "honehoneclock";
	var sUrl = swfUrl;	
	var sHtml = "";
	sHtml += '<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0" width="160" height="70" id="' + swfTitle + '" align="middle">';
	sHtml += '<param name="allowScriptAccess" value="always" />';
	sHtml += '<param name="movie" value="' + sUrl + '" />';
	sHtml += '<param name="quality" value="high" />';
	sHtml += '<param name="bgcolor" value="#ffffff" />';
	sHtml += '<param name="wmode" value="transparent" />';
	sHtml += '<embed wmode="transparent" src="' + sUrl + '" quality="high" bgcolor="#ffffff" width="118" height="57" name="' + swfTitle + '" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />';
	sHtml += '</object>';
	document.write(sHtml);
}
</script>
  
 <style type="text/css">
 

	 .nth-tabs span{
		margin-top:15px;
		
	}
	.nth-tabs .roll-nav{
	background-color: #dadada;
	}
	
	.nth-tabs .content-tabs{
	background-color: #EAEAEA;
	}
	.nth-tabs .content-tabs-container{
	
	border: solid  block 1px }
 	
 </style>
</head>
<!--添加类侧栏崩溃来隐藏边栏在加载站点之前-->
<body class="hold-transition skin-blue sidebar-collapse sidebar-mini">
<!-- Site wrapper 整个网站的布局-->
<div class="wrapper">

  <!--头部部分-->
  <header class="main-header">
    <!-- Logo -->
    <a href="#" class="logo" >
      <!-- 对于侧边栏迷你50x50像素迷你标志 -->
      <span class="logo-mini"><strong>J</strong>RF</span>
      <!-- 正则状态和移动设备的标志 -->
      <span class="logo-lg" style="position: absolute;left:10px">
	<img alt="" src="image/logo.png"  ></span>
    </a> 
    <!-- 标题：风格的导航栏中可以找到header.less -->
    <nav class="navbar navbar-static-top">
      <!-- 侧边栏切换按钮-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button" id="shensuo">
        <span class="sr-only">按钮</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>
			
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <li class="dropdown messages-menu">
           
            <ul class="dropdown-menu">
             
              <li>
                <!-- inner menu: contains the actual data 信息提示的具体内容-->
                <ul class="menu">
                  <li><!-- start message -->
                    <a href="#">
					<!--图片 头像之类的-->
                      <div class="pull-left">
                        <img src=" dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                      </div>
					  <!--设置里面的提示信息-->
                      
                    </a>
                  </li>
                  <!-- end message -->
                </ul>
              </li>
              <li class="footer"><a href="#">查看所有</a></li>
            </ul>
          </li>
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
			<!--用户背景图片-->
              <img src=" dist/img/user2-160x160.jpg" class="user-image" alt="">
			  <!--用户的名称-->
              <span class="hidden-xs"> 金融福</span>
            </a>
			<!--当点击用户的图标或者名字的时候 出现该具体信息-->
            <ul class="dropdown-menu">
              <li class="user-header">
                <img src="image/logo.png"  style="width:171px;height:62px;" class="" >
                <p>
                  金融福基金估值核算系统
                  <small id="nowDate"></small>
                  <script type="text/javascript">LoadBlogParts();</script>
                </p>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
                <div class="row">
                  <div class="col-xs-4 text-center">
                    <a href="#">当前用户:</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">${user.userName}</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#" id="fund">${fund.fundCode}</a>
                  </div>
                </div>
                <!-- /.row -->
              </li>
              <!-- Menu Footer 底部的按钮-->
              <li class="user-footer">
                <div class="pull-left">
               <a href="#" class=""> ${fund.fundName}</a>
                </div>
                <div class="pull-right">
                  <a href="logOffUser.action" class="btn btn-default btn-flat">签名离开</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button 换背景的弹框-->
          <li style="margin-right: 10px;"> 
           
          </li>
        </ul>
      </div>
    </nav>
  </header>

  <!-- ================== 以下 就是 左边的左侧栏============================= -->

  <!-- Left side column. contains the sidebar 左侧柱。包含侧边栏 -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less 旁白：式中可以找到sidebar.less -->
    <section class="sidebar">
	
	  <!--具体的按钮 手风琴之类-->
	  <ul  id="accordion" class="sidebar-menu" data-widget="tree">
		
			<c:forEach items="${rightMap}" var="keys">
				<c:if test="${keys.key.checkFlag!='0' }">
				<li class="treeview" id="">
					<!--点击超链接的时候 出现下拉的选项--> <a> <i class="fa ${keys.key.rightIcon}"></i><span>${keys.key.rightText}</span>
						<span class="pull-right-container"><i
							class="fa fa-angle-left pull-right"></i></span>
				</a> <!--出现的选项框--> 
						<ul class="treeview-menu">
							<c:forEach items="${keys.value}" var="sysRight">
								<c:if test="${sysRight.checkFlag!='0'}">
									<li title="${sysRight.rightText }">
									<a title="${sysRight.rightUrl}"><i
											class="fa ${sysRight.rightIcon}"></i> ${sysRight.rightText }</a></li>
								</c:if>
							</c:forEach>

						</ul>


					

				</li>
				</c:if>
			</c:forEach>
	  </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
  <!-- ===================主要的内容部分============================ -->
	
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
		<div class="nth-tabs " id="myTab" width="100%" >
		
		
		</div>
		<!-- <div id="echartId" style="width:800px;height:500px;border : solid red 1px" ></div> -->
  </div>
  

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
  
  </aside>
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar 添加边栏的背景 此div必须在控件边栏之后立即放置-->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src=" js/jquery-3.1.1.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src=" js/bootstrap.min.js"></script>


<script src=" js/adminlte.min.js"></script>
<script type="text/javascript" src=" js/nth.tabs.min.js"></script>
<script type="text/javascript" src=" js/jquery.scrollbar.min.js"></script>





<div class="container myCarousel" id="lunbo" >

<iframe src="jsp/main_1.jsp"  id="myFrame" width="100%" height="100%" frameborder="0"></iframe>
</div> 
</body>
<script>
var myTab;
		$(function(){
			
			
			
			
			
			
			
			
			var now=new Date()   
			var year =now.getFullYear();
			var month =now.getMonth()+1;if(month<=9){month ="0"+month;}var day =now.getDate();
			if(day<=9){day ="0"+day;}
			$("#nowDate").html(year+"-"+month+"-"+day);
			
			
			
			
			
			myTab=$("#myTab").nthTabs();
			$(myTab).css('height','800px');
			var allLi = $("#accordion li ul li");
			//给每个li加上点击事件
			$.each(allLi,function(i,everyLi){
				$(everyLi).click(function(){
					var title =$(this).attr("title");
					var url =$(this).find("a").attr("title"); 
					
					//得到所有已经展开的选项卡
						var allTab=myTab.getTabList();
						//标志  记录选项卡是否展开
						var  flag =false;
						//判断该选项卡是否已经展开
						$.each(allTab,function(i,oneTab){
							//如果当前的标题已经在选项卡中存在
							if(title==oneTab.title){
								flag=true;
							}
						});
						//flag为false说明该选项已经在选项卡中不存在  
							if(!flag){
								//调用增加选项卡的方法
								myTab.addTab({
								id:title,
								title:title,
								content:'<iframe src="'+url+'" frameborder=0 height=100% width=100% ></iframe>',
							});
						}
				//不管存不存在 调用选中选项卡的方法使该选项卡选中
								myTab.setActTab(title);
				});
				$(".tab-content").html($("#lunbo"));
			})
			loadLunBoDiv();
			  
		    $("#shensuo").click(function(){
		    	
		    	setTimeout(function(){
		    		
		    		loadLunBoDiv();
		    		
		    		
		    		
		    	}, 400)
		    	
		    	
		    });
		    
		    window.onresize=function(){
		    	loadLunBoDiv();
		 	}
			    
			   
		});
		
		
		
		function loadLunBoDiv(){
			$("#lunbo").css("margin","0px");
			$(".tab-content").css("padding","0px");
			
			$("#lunbo").css("width",parseInt($(".tab-content").css("width"))-10+"px");
			$("#lunbo").css("height",$(".tab-content").css("height"));
			$("#lunbo").css("padding","0px");
					
			
		}
		
	 </script>
	
</html>
