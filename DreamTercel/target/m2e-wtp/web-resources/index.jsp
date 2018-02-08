<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>金融估值核算系统</title>

<link rel="stylesheet" type="text/css" href="css/style2.0.css"/>
<script src="js/jquery-3.1.1.min.js"></script>


<script type="text/javascript" src="js/select/mock.js"></script>

<script type="text/javascript" src="js/select/jquery.js"></script>

<link rel="stylesheet" type="text/css" href="js/select/jquery.dropdown.css">

<script src="js/select/jquery.dropdown.js"></script>
<style type="text/css">
	#Ull li{font-size: 30px;color:#2ec0f6;}
	.tyg-div{z-index:-1000;float:left;position:absolute;left:5%;top:20%;}
	.tyg-p{
		font-size: 14px;
	    font-family: 'microsoft yahei';
	    position: absolute;
	    top: 135px;
	    left: 60px;
	}
	.tyg-div-denglv{
		z-index:1000;float:right;position:absolute;right:3%;top:10%;
	}
	.tyg-div-form{
		background-color: #23305a;
		width:300px;
		height:auto;
		margin:120px auto 0 auto;
		color:#2ec0f6;
	}
	.tyg-div-form form {padding:10px;}
	.tyg-div-form form input[type="text"]{
		width: 270px;
	    height: 30px;
	    margin: 25px 10px 0px 0px;
	}
	.tyg-div-form form input[type="password"]{
		width: 270px;
	    height: 30px;
	    margin: 25px 10px 0px 0px;
	}
	#loginBtn {
	    cursor: pointer;
	    width: 270px;
	    height: 44px;
	    margin-top: 25px;
	    padding: 0;
	    background: #2ec0f6;
	    -moz-border-radius: 6px;
	    -webkit-border-radius: 6px;
	    border-radius: 6px;
	    border: 1px solid #2ec0f6;
	    -moz-box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    -webkit-box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
	    font-size: 14px;
	    font-weight: 700;
	    color: #fff;
	    text-shadow: 0 1px 2px rgba(0,0,0,.1);
	    -o-transition: all .2s;
	    -moz-transition: all .2s;
	    -webkit-transition: all .2s;
	    -ms-transition: all .2s;
}
</style>
<!--引入弹窗插件的样式文件-->
<link rel="stylesheet" href="js/alert/alert.css">
<!--引入弹窗插件的js文件-->
<script src='js/alert/alert.js'></script>
<script type="text/javascript" src="js/utils.js"></script>
 <script type="text/javascript">
 document.addEventListener('keydown', function(e,windowid){
		
		var a =e.keyCode;
		if((a == 13) ){//ctrl +空格
			   // console.log(1);//你想执行的功能写在这里。
				//调用取单的方法
				login();
			    if(e.preventDefault){
			        e.preventDefault();
			        e.stopPropagation()
			    }else{
			        e.returnValue=false;
			        e.cancelBubble=true
			    }
			    return false;
			}
		
	});
 
 	
 
 	$(function(){//加载事件
 		
 		
 		//加载下拉列表
 		$.ajax({
			type : "post",
			url : "fund/selectFundRow.action?page=1&rows=99&orderStyle=asc",
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
			success : function(msgs) {
				var jsons = jQuery.parseJSON(msgs);
				
				var  fundDown =$("#fundCode");
				$.each(jsons.rows,function(i,fund){
					
					var opt = new Option(fund.fundName,fund.fundCode);
					fundDown.append(opt);
				});
				if(msgs=='[]'){
					
				}else{
				$('#vv').dropdown({
		 			  
		 			  input: '<input type="text" maxLength="20" style="width:256px" placeholder="请输入关键字">'
		 			});
				}
			}

		});
 		$("#loginBtn").click(function(){//登录按钮点击事件
 			
 			login()   
 		});
 		
 	});
 	//登录的方法
 	function login(){
 		var myForm  =$("#loginForm");
 		//ajax发送请求
		$.ajax({
			type : "post",
			url : "checkLogin.action",
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
			data:myForm.serializeArray(),
			success : function(msgs) {
				
				if (msgs == '0')
					{
					
					myAlert("账户或者密码错误,请重新输入");
					$("#userPwd").val("");
					
					
					}else  if(msgs == '1'){
						
						show_msg('登录成功咯！  正在为您跳转...','loadRightforMain.action');
				    	   
						
					}else{
						myAlert(msgs);
						$("#userPwd").val("");
						
						
					}
			
				
			}

		});
 		/* 
 		$('#loginForm').form('submit',{//表单提交    
			    url:'userServlet?flag=login', //网址
			    onSubmit: function(){ //验证
	 
			    },    
			    success:function(data){ //响应   
			    	//alert(data);
			       if(data=='true'){//如果响应成功
			    	 	show_msg('登录成功咯！  正在为您跳转...','mainServlet?flag=load&userName='+$("#userName").val());
			    	   
			       }else{
			    	   
			    	  $.messager.show({
						title : '我的消息',
						msg : "账号或者密码错误  消息将在五秒之后消失！",
						timeout : 5000,
						showType : 'slide'
					});
			       }
			    }    
			});  */
 		
 	}
 		
 	
 
 </script>
<body>
<div class="tyg-div">
	<ul id="Ull">
    	<li>让</li>
    	<li><div style="margin-left:20px;">数</div></li>
    	<li><div style="margin-left:40px;">据</div></li>
    	<li><div style="margin-left:60px;">改</div></li>
    	<li><div style="margin-left:80px;">变</div></li>
    	<li><div style="margin-left:100px;">生</div></li>
    	<li><div style="margin-left:120px;">活</div></li>
    </ul>
</div> 
<div id="contPar" class="contPar">
	<div id="page1"  style="z-index:1;">
		<div class="title0"><img alt="" src="image/logo2.png" style="position:relative;top:7px">金融福估值核算系统</div>
		<div class="title1">投资、炒股、无所不能</div>
		<div class="imgGroug">
			<ul>
				<img alt="" class="img0 png" src="image/page1_0.png" />
				<img alt="" class="img1 png" src="image/page1_1.png" />
				<img alt="" class="img2 png" src="image/page1_2.png" />
			</ul>
		</div>
		<img alt="" class="img3 png" src="./image/page1_3.jpg">
	</div>
</div>
<div class="tyg-div-denglv">
	<div class="tyg-div-form">
		<form action="" id="loginForm" method="post">
			<h2>登录</h2><p class="tyg-p">欢迎访问  </p>
			<div style="margin:5px 0px;">
				<input type="text" placeholder="请输入账号..." id="userName" name="userName"/>
			</div>
			<div style="margin:5px 0px;">
				<input type="password" placeholder="请输入密码..." id="userPwd" name="userPwd"/>
			</div>
			 <div class="dropdown-sin-1" id="vv" style="margin:25px 0px;width:268px;">
	<select style="display:none" name="fundCode" id="fundCode"   placeholder="请选择：测试placeholder">
	
	</select>
	</div>
			<!--<div style="margin:5px 0px;">
				<input type="text" style="width:150px;" placeholder="请输入验证码..."/>
				<img src="./img/1.png" style="vertical-align:bottom;" alt="验证码"/>
			</div>-->
			<button type="button"  id="loginBtn"   >登<span style="width:20px;"></span>录</button>
		</form>
	</div>
</div>



<script type="text/javascript" src="js/com.js"></script>

<script type="text/javascript" src="js/tooltips.js" ></script>
<div style="text-align:center;">

</div>


</body>
</html>