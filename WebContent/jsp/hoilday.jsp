<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>节假日管理</title>
<!-- 引入jquery资源时不能以斜杠代替尾标签 -->
    <script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../js/easyui/jquery.min.js"></script>
	<style type="text/css">
		*
		{
			font-family:'KaiTi';
			text-align:center;
		}
		.month 
		{
			/*边框折叠*/
			border-collapse: collapse;
			border: 3px solid rgb(55,191,225);
			margin:10px;
			float: left;
			width: 375px;
			height:310px;
			position:relative;
		}
		.month tr td 
		{
			border: 1px solid white;
			font-size:20px;
		}
		.month tr td:hover 
		{
			background-color: #009F55;
			color: #FFFFFF;
			/*width:70px;
			height:50px;
			font-size:40px;*/
		}
		input 
		{
			background-color:white;
			border-radius:10%;
			/*color:blue;*/
			font-size: 18px;
			font-weight: bold;
		}
		input:hover
		{
			/*width:140px;
			height:50px;
			font-size:20px;*/
			background-color:rgb(55,191,225);
			color:white;
		}
		#date
		{
			width:1200px;
			height:1200px;
			position:absolute;
			top:100px;
			border: 1px blue;
		}
		h1:hover
		{
			/*font-size:50px;*/
		}
	</style>
	<script type="text/javascript">
		var myCountFlag='0';	
		
		//纯jquery日历
		//将选中的日期放进数组中
	    var datearray = new Array();
		//准备选中的周末
		var intendarray = new Array();
		//缓冲周末日期数组
		var bufferarray = new Array();
		//重复点击的标志
		var flag = false;
	    //页面初始化事件先得到当前年份的日历
	    $(
		    function()
		    {
		      	selectdate(2017);
		    }
	    );
	    //减少一年
	    function reduceyear()
	    {
	    	intendarray.splice(0, intendarray.length);
	        var year = parseInt($('#year').val())-1;
	    	selectdate(year);
	    	$('#year').val(year);
	    	clearbuffer();
	    	//alert("减少一年时：当前年份"+year+"当前年份中保存的第一个星期六："+intendarray[0]);
	    }
	    //增加一年
	    function raiseyear()
	    {
	    	intendarray.splice(0, intendarray.length);
	    	var year = parseInt($('#year').val())+1;
	    	selectdate(year);
	    	$('#year').val(year);
	    	clearbuffer();
	    	//alert("增加一年时：当前年份"+year+"当前年份中保存的第一个星期六："+intendarray[0]);
	    }
	    //输入框输入年份
	    function inputyear()
	    {
	    	intendarray.splice(0, intendarray.length);
	    	selectdate(parseInt($('#year').val()));
	    	clearbuffer();
	    }
	    //非正则表达式验证键入输入框的年份 DOM
	    function notzhengze(text,event)
	    {
	    	var num = '0123456789';
	    	var key;
	    	if(window.event)
	    	{
	    		key = window.event.keyCode;
	    	}
	    	else if(event)
	    	{
	    		key = event.charCode;
	    	}
	    	var schar = String.fromCharCode(key);
	    	var isnum = num.indexOf(schar)>-1;
	    	return isnum;
	    }
	    //正则表达式检查输入框输入的是不是年
	    function checkyear()
	    {
	    	var year = $('#year').val();
	    	//正则表达式筛选年份
	    	var reg = /^[0-9]+$/;
			if (reg.exec(year)) 
			{
				alert("验证通过")
			} 
	    	else
	    	{
	    	 	alert("验证出错")
	    	}
	    }
	    //验证提交时数据是否完整
	    function validate()
	    {
	    	var year = $('#year').val();
	    	if(null==datearray)
	    	{
	    		 $('#year').watermark('请选中您需要的日期');
				 return false;
	    	}
	    	return true;
	    }
	    //选中日期
	    function selected(date)
	    {
	    	datearray.push(date);
	    	
	    }
	    //取消选中日期
	    function unselected(date)
	    {
	    	for(var i = 0;i<datearray.length;i++)
	    	{
		    	if (datearray[i] == date) 
				{
					datearray.splice(i, 1);
				}
	    	}
	    	
	    }
		//确定是否选中
		function isSelected(date)
		{
			for(var i = 0;i<datearray.length;i++)
	    	{
		    	if (datearray[i] == date) 
				{
					return true;
				}
	    	}
	    	return false;
		}
	    //日期绑定的选中与否的事件
	    function checkselected(thisobj)
	    {
	    	var date = thisobj.id;
	    	if(isSelected(date))
	    	{
	    		unselected(date);
	    		//dom方式
	    		thisobj.style.backgroundColor = "lightblue";
	    	}
	    	else
	    	{
	    		selected(date);
	    		//dom方式
	    		thisobj.style.backgroundColor = "rgb(55,191,225)";
	    	}
	    }
	    //向服务器发送年份并查找该年选中的日期
	    function selectdate(year)
	    {
		    $.ajax
			({
				type : "get",
				url : "../selectHoildayXiao.action",
				data : 
				{
				//将当前的年份发送至服务器
					senddate : year,
					
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) 
				{
					top.Dialog.alert("服务器发生异常，请重试或反馈意见");
				},
				success : function(data, textStatus) 
				{
				     var dateStr=eval('('+data+')');
				    
				    
					//data为服务器发过来的已选中的日期
					if (dateStr.length > 0) 
					{
						  $.each(dateStr,function(i,value){
							  datearray.push(value.strDate);
						    	 });  
					
					}
					getdate(year);
				}
			});
	    }
	    //再次进入该年将之前保存的加载
	    function reload()
	    {
	    	
	    	for ( var i = 0; i < datearray.length; i++) 
	    	{
				document.getElementById(datearray[i]).style.backgroundColor = "rgb(55,191,225)";
			}
	    }
	    //将界面选中的所有日期发送至服务器
	    function senddate()
	    {
	    	
	    	var year = $('#year').val();
	    	
	    	if(datearray.length!=0)
			{
	    		
				var datestr = datearray.join(",");
				
				$.ajax
				({
					type : "get",
					url  : "../insertHoildayXiao.action",
					data : 
					{
						//将当前年份中选中的日期发送至服务器
						senddate : datestr,
						flag:'save',
						year:year
					}
				});
				getdate(year);
			}
			else
			{
				$.ajax
				({
					type : "post",
					url  : "date.do",
					data : 
					{
						flag:'null',
						year:year
					}
				});
				getdate(year);
			}
			
	    }
	    //选择所有的周末
	    function selectallweekend()
	    {
		    if((null!=intendarray||""!=intendarray)&&""==bufferarray)
		    {
		    	//alert("如果周末未被清空而且缓冲为空，将周末数组发送至服务器");
		    	flag = false;
		    	for ( var i = 0; i < intendarray.length; i++) 
		    	{
		    		selected(intendarray[i]);
					document.getElementById(intendarray[i]).style.backgroundColor = "rgb(55,191,225)";
				}
			}
			else
			{
				//alert("如果周末被清空而且缓冲是满的，将缓冲数组发送至服务器"+bufferarray.length);
			 	flag = true;
				for ( var i = 0; i < bufferarray.length; i++) 
		    	{
		    		selected(bufferarray[i]);
					document.getElementById(bufferarray[i]).style.backgroundColor = "rgb(55,191,225)";
				}
			}
	    }
	    //取消所有选中的日期
	    function cancelall()
	    {
	    	if(""==intendarray&&null!=bufferarray&&flag==true)
			{
				//alert("如果周末被清空而且缓冲是满的并且标志为真，此时删除了缓冲数组，并且数据还给了周末数组");
				flag = true;
				for ( var i = 0; i < bufferarray.length; i++) 
		    	{
		    		intendarray[i] = bufferarray[i];
					document.getElementById(bufferarray[i]).style.backgroundColor = "lightblue";
				}
				bufferarray.splice(0, bufferarray.length);
			}
		    if(null!=datearray)
		    {
		    	//alert("如果选择了日期，此时删除了发送至服务器的数组"+datearray.length+"头一天："+datearray[0]);
		    	for ( var i = 0; i < datearray.length; i++) 
		    	{
					document.getElementById(datearray[i]).style.backgroundColor = "lightblue";
				}
				datearray.splice(0, datearray.length);
			}
			if(null!=intendarray&&flag==false)
			{
				//"如果周末没被清空而且缓冲标志是假的，此时删除了周末数组，并转接给缓冲数组");
				for ( var i = 0; i < intendarray.length; i++) 
		    	{
		    		bufferarray[i] = intendarray[i];
					document.getElementById(intendarray[i]).style.backgroundColor = "lightblue";
				}
				intendarray.splice(0, intendarray.length);
				//缓冲数据删除时将周末数据也同时删除了
			}
	    }
	    //清空缓存数组
	    function clearbuffer()
	    {
	    	if(null!=bufferarray)
	    	{
	    		bufferarray.splice(0, bufferarray.length);
	    	}
	    }
	    //日历打印的方法
		function getdate(year)
		{
		    var allday = 0;
			for(var i = 1900;i<year;i++)
			{
			  	//闰年
			  	if(i % 4 == 0 && ((i % 100 != 0) || (i % 400 == 0))) 
			  	{
					allday+=366;
			  	}
			  	//非闰年
			  	else
			  	{
			   		allday+=365;   
				} 
			}
			//得到2017年一月一日星期几
			var week = allday%7+1;
			var datestr = "";
			// 循环12个月
			for ( var j = 1;j <= 12; j++) 
			{
				// 每个月有多少天
				var monthday = 0;
				//如果分别是这些大月份
				if (j == 1 || j == 3 || j == 5 || j == 7 || j == 8 || j == 10|| j == 12) 
				{
					monthday = 31;
				} 
				//如果分别是这些小月份
				else if (j == 4 || j == 6 || j == 9 || j == 11) 
				{
					monthday = 30;
				} 
				else if (j == 2) 
				{
					// 是闰年
					if (year % 4 == 0 && ((year % 100 != 0) || (year % 400 == 0))) 
					{
						monthday = 29;
					} 
					else 
					{
						monthday = 28;
					}
				}
				var month = "";
				if (j < 10) 
				{
					month = "0" + j;
				} 
				else 
				{
					month = j;
				}
				// 年月以及星期
				datestr += "<table class='month'>"
						+ "<tr style='background-color:rgb(55,191,225);'>" + "<td colspan='7'>"
						+ year + "年" + month + "月</td></tr>"
						+ "<tr style='background-color:skyblue;'>" + "<td>日</td>"
						+ "<td>一</td>" + "<td>二</td>" + "<td>三</td>" + "<td>四</td>"
						+ "<td>五</td>" + "<td>六</td></tr>";
				// 循环每个月
				for ( var d = 1; d <= monthday; d++) 
				{
					//如果输入那年1月1日刚好是星期天则直接开始这一行不加空白
					if (week == 7) 
					{
						datestr += "<tr style='background-color:lightlime;'>";
					}
					//大于星期天自动变为星期一以此来循环每个月
					if (week > 7) 
					{
						week = 1;
					}
					//天
					var day = "";
					if (d < 10) 
					{
						day = "0" + d; 
					} 
					else
					{
						day = d;
					}
					// 每月开始的空白
					//如果一个月的一号不是星期天则前面为空白
					if (d == 1) 
					{
						if (week < 7) 
						{
							datestr += "<tr>";
							for ( var x = 1; x <= week; x++) 
							{
								datestr += "<td>&nbsp;</td>";
							}
						}
					}
					//如果是周末则加入数组中
					//数字的加减影响了结果
					if(week==6||week==7)
					{
						year += "";
						intendarray.push(year+"-"+month+"-"+day);
					}
					//字符串连接处注意空格的使用
					datestr += "<td id="+year+"-"+month+"-"+day+" onmousedown='checkselected(this)'>" + day + "</td>";
					// 每月结束的空白
					if (d == monthday) 
					{
						if (week < 7) 
						{
							//如果这个月最后一天不是星期六则加空白
							for ( var x = 6; x > week; x--)
							{
								datestr += "<td>&nbsp;</td>";
							}
						} 
						//如果这个月最后一天是星期天则加六个空格
						else if (week == 7) 
						{
							for ( var x = 1; x < 7; x++) 
							{
								datestr += "<td>&nbsp;</td>";
							}
						}
					}
					//如果刚好是星期六则用<tr>结束这一行
					if (week == 6)
					{
						datestr += "</tr>";
					}
					week++;
				}
				datestr += "</table>";
				// 每三个表换一行
				if (j % 3 == 0) 
				{
					datestr += "<br/>";
				}
			}
			//添加表到网页上
			$('#date').html(datestr);
			reload();
			
			if(myCountFlag=='0'){
				myCountFlag='1';
			}else{
				myCountFlag='0';
				alert('已成功查询到'+year+'年的节假日数据！');
			}
		}
	</script>
	</head>
	<body style='background-color:lightblue;'>
		<div style="border: 2px blue;position:absolute;top:20px;left:10px;width:1200px;height:70px;">
			<div style="position:absolute;left:10px;"><h1 style="color:black;">假期管理</h1></div>
			<form action=""  onsubmit="return validate()" style="position:absolute;left:395px;">
				<table align="right" style="">
					<tr>
						<td>
							<input type="button"  value="减少一年" onmousedown="reduceyear()"/>
						</td>
						<td>
							<!--获得焦点后的验证事件：onfocus="checkyear()"-->
							<input type="text" maxlength="4" onchange="inputyear()" onkeypress="return notzhengze(this,event)" value="2017" id="year"/>
						</td>
						<td>
							<input type="button" value="增加一年" onmousedown="raiseyear()"/>
						</td>
						<td width="90px" align="center">
							<input type="submit" value="保存" onclick="senddate()"/>
						</td>
						<td width="100px" align="center">
							<input type="button" value="取消所有选择假日" onclick="cancelall()"/>
						</td>
						<td width="100px" align="center">
							<input type="button" value="选择所有假日" onclick="selectallweekend()"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="date"></div>
	</body>
</html>