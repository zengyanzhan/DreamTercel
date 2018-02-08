<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>席位交易量统计报表</title>
<link rel="stylesheet" href="../css/bootstrap.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="../js/jquery-3.1.1.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="../js/bootstrap.min.js"></script>
<!--引入表格的js文件-->
<script src="../js/bootstrap-table.js"></script>
<!--引入表格的样式文件-->
<link href="../css/bootstrap-table.css" rel="stylesheet" />

<!--引入表单的验证文件-->
<script type="text/javascript" src="../js/bootstrapValidator.js"></script>
<!-- 引入表单验证 的css文件-->
<link rel="stylesheet" href="../css/bootstrapValidator.css" />
<!--引入表格的汉化文件-->
<script src="../js/bootstrap-table-zh-CN.js"></script>
<script src="../js/echarts.common.min.js"></script>
<!--导入日期插件包-->
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.css" />
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
<!-- 导入select -->
<script type="text/javascript" src="../js/select/bootstrap-select.js"></script>
<link rel="stylesheet" href="../js/select/bootstrap-select.min.css" />
<script type="text/javascript" src="../js/utils.js"></script>
<!--引入弹窗插件的样式文件-->
<link rel="stylesheet" href="../js/alert/alert.css">
<!--引入弹窗插件的js文件-->
<script src='../js/alert/alert.js'></script>
<!--导入message.js-->
<script type="text/javascript" src="../js/message/message.js"></script>
<link rel="stylesheet" href="../js/message/message.css" />
<!-- easyui的js和css部分 -->
<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet"
	type="text/css" />
<link href="../js/easyui/icons/icon-all.css" rel="stylesheet"
	type="text/css" />
<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script type="text/javascript">
	//屏蔽回车键 解决弹窗   回车无限弹的问题		
	document.addEventListener('keydown', function(e) {
		var a = e.keyCode;
		if ((a == 13)) { //回车
			if (e.preventDefault) {
				e.preventDefault();
				e.stopPropagation()
			} else {
				e.returnValue = false;
				e.cancelBubble = true
			}
			return false;
		}
	});
	var flag = false;//判断标志 是否调用生成图表的方法
	//加载事件 
	$(function() {
		$('#myTable').treegrid(
				{
					url : '../selectSeatTradeReport.action',
					method : 'get',
					contentType : 'application/json',
					width : '100%',
					height : 510,
					idField : 'seatName',
					treeField : 'seatName',
					animate : true,//定义在节点展开或折叠的时候是否显示动画效果。
					fitColumns : true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
					title : '席位交易量统计报表',
					columns : [ [
							{
								//复选框
								checkbox : true
							},
							{
								field : 'seatName',
								title : '券商席位',
								width : 300,
								//启用该字段的排序
								sortable : true,
								formatter : function(value, index, row) {
									return "<span style='font-size:16px'>"
											+ value + "</span>";
								}
							},
							{
								field : 'inputPlate',
								title : '买入股票',
								width : 100,
								formatter : function(value, index, row) {
									if (Number(value) == 0) {
										return "";
									}
									return "<span style='color:green;font-size:16px'>"
											+ (value || 0).toString().replace(
													/(\d)(?=(\d{3})+(?!\d))/g,
													"$1,") + "</span>";
								}
							},
							{
								field : 'outputPlate',
								title : '卖出股票',
								width : 100,
								formatter : function(value, index, row) {
									if (Number(value) == 0) {
										return "";
									}
									return "<span style='color:red;font-size:16px'>"
											+ (value || 0).toString().replace(
													/(\d)(?=(\d{3})+(?!\d))/g,
													"$1,") + "</span>";
								}
							},
							{
								field : 'inputBond',
								title : '买入债券',
								width : 100,
								formatter : function(value, index, row) {
									if (Number(value) == 0) {
										return "";
									}
									return "<span style='color:green;font-size:16px'>"
											+ (value || 0).toString().replace(
													/(\d)(?=(\d{3})+(?!\d))/g,
													"$1,") + "</span>";
								}
							},
							{
								field : 'outputBond',
								title : '卖出债券',
								width : 100,
								formatter : function(value, index, row) {
									if (Number(value) == 0) {
										return "";
									}
									return "<span style='color:red;font-size:16px'>"
											+ (value || 0).toString().replace(
													/(\d)(?=(\d{3})+(?!\d))/g,
													"$1,") + "</span>";
								}
							},
							{
								field : 'totalMoney',
								title : '合计金额',
								width : 100,
								formatter : function(value, index, row) {
									if (Number(value) == 0) {
										return "";
									}
									return "<span style='color:green;font-size:16px'>"
											+ (value || 0).toString().replace(
													/(\d)(?=(\d{3})+(?!\d))/g,
													"$1,") + "</span>";
								}
							},
							{
								field : 'tradeMeasure',
								title : '交易量比例',
								width : 100,
								formatter : function(value, index, row) {
									if (Number(value) == 0) {
										return "";
									}
									return "<span style='color:green;font-size:16px'>"
											+ value.toFixed(2) + "%</span>";
								}
							} ] ],
					//表格操作方法
					singleSelect : false,
					collapsible : true,//可以折叠
					minimizable : false,//添加最小化按钮
					maximizable : false,// 添加最大话按钮
					rownumbers : true,//如果为true，则显示一个行号列
					striped : true,//是否显示斑马线效果。
					pagination : true,//如果为true，则在DataGrid控件底部显示分页工具栏。
					pageSize : 10,//在设置分页属性的时候初始化页面大小。
					pageList : [ 10, 20, 30, 40 ],//在设置分页属性的时候 初始化页面大小选择列表。
					pageNumber : 1,//在设置分页属性的时候初始化页码
				});

		$('#datetimepicker2').datetimepicker({
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//显示格式
			minView : "month",//设置只显示到月份
			//initialDate: new Date(),//初始化当前日期
			forceParse : true,//当输入非格式化日期时，强制格式化。默认true  
			autoclose : true,//选中自动关闭
			todayBtn : true
		//显示今日按钮
		});

		//显示时间	
		$('#datetimepicker1').datetimepicker({
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//显示格式
			minView : "month",//设置只显示到月份
			//initialDate: new Date(),//初始化当前日期
			forceParse : true,//当输入非格式化日期时，强制格式化。默认true  
			autoclose : true,//选中自动关闭
			todayBtn : true
		//显示今日按钮
		});
		
		$('.datagrid-cell').css('font-size','20px');//更改的是datagrid中的数据
		$('.datagrid-header .datagrid-cell span ').css('font-size','18px');//datagrid中的列名称
		$('.panel-title ').css('font-size','18px'); //标题

	});
</script>

</head>
<body>
	<!--整个界面-->
	<div id="mianDiv">
		<!--工具栏-->
		<div id="toolbar" class="panel-heading form-inline"
			style="margin-top: 10px">

			&nbsp;&nbsp; <label class="control-label">统计开始日期：</label>
			<div class='input-group date' id='datetimepicker1'>
				<input type='text' class="form-control" id="firstDate" /> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
			<label class="control-label">结束日期：</label>
			<div class='input-group date' id='datetimepicker2'>
				<input type='text' class="form-control" id="secondDate" /> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
			<button type="button" style="margin-left: 10px" id="btnSearch"
				class="btn btn-info">统计</button>
			<button type="button" style="margin-left: 50px" id="btnImage"
				class="btn btn-info">生成图表</button>
		</div>
		<div class="changeDiv" id="ssss">
			<!--中间部分-->
			<div class="page" id="biaoGe">
				<!--表格-->
				<table id="myTable"></table>
			</div>
			<div id="main" class="page  div2" style="width: 800px; height: 400px"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("#btnImage").click(function() {
			//alert(flag);
			changeDiv($(window), "#btnImage", "#ssss");
			img();//调用生成图表方法
			if (flag == false) {
				flag = true;
			} else {
				flag = false;
			}
		});

		//查询
		$("#btnSearch").click(function() {
			//alert(flag);
			if (flag == false) {
				var firstDate = $("#firstDate").val();
				var secondDate = $("#secondDate").val();
				if (firstDate != "" && secondDate != "") {
					$("#myTable").treegrid('load', {
						firstStrDate : firstDate,
						secondStrDate : secondDate
					})
				} else {
					myAlert("请输入统计日期");
				}
			} else {
				img();//调用生成图表
			}

		})
	});
	function img() {
		//	$("#logmin").hide();
		var myChart = echarts.init(document.getElementById('main'));
		// 指定图表的配置项和数据
		var option = {
			title : {
				text : '席位成交量统计图表',
				subtext : '券商 席位 交易所'
			},
			tooltip : {
				trigger : 'axis',
				axisPointer : { // 坐标轴指示器，坐标轴触发有效
					type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
				}
			},
			legend : {
				data : [ '上交所', '深交所', '席位' ]
			},
			toolbox : {
				show : true,
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					magicType : {
						show : true,
						type : [ 'line', 'bar' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			calculable : true,
			xAxis : [ {
				type : 'value'
			} ],
			yAxis : [ {
				type : 'category',
				data : []
			} ],
			series : [ {
				name : '上交所',
				type : 'bar',
				stack : '总量',
				itemStyle : {
					normal : {
						label : {
							show : true,
							position : 'inside'
						}
					}
				},
				data : []
			}, {
				name : '深交所',
				type : 'bar',
				stack : '总量',
				itemStyle : {
					normal : {
						label : {
							show : true,
							position : 'inside'
						}
					}
				},
				data : []
			}, {
				name : '席位',
				type : 'bar',
				stack : '总量',
				itemStyle : {
					normal : {
						label : {
							show : true,
							position : 'inside'
						}
					}
				},
				data : []
			} ]
		};

		myChart.showLoading();
		//数据加载完之前先显示一段简单的loading动画
		$.ajax({
			type : 'post',
			url : "../selectSeatTradeReportChart.action?firstStrDate="
					+ $("#firstDate").val() + '&secondStrDate='
					+ $("#secondDate").val(),
			success : function(data) {
				var msg = eval("(" + data + ")");
				//alert(msg);
				if (msg != null) {
					var broker = [];//券商数组
					var shangExchange = [];//上交所
					var shenExchange = [];//深交所
					var seat = [];//席位
					var shangTotal = 0;//定义一个数值接收上交所的合计金额
					var shenTotal = 0;//定义一个数值接收深交所合计金额
					for (var i = 0; i < msg.length; i++) {
						//alert(msg[i]);
						broker.push(msg[i].seatName);
						seat.push(msg[i].totalMoney);//席位
						if (msg[i].seatName == '两地合计') {
							var total = msg[i].children;
							$.each(total, function(e, r) {
								if (r.seatName == '上海合计') {
									shangExchange.push(r.totalMoney);
								} else {
									shenExchange.push(r.totalMoney);
								}
							})
						} else {
							var exchangeData = msg[i].children;//券商下面的交易所
							$.each(exchangeData, function(i, v) {
								//交易所下面的席位总金额
								if (v.seatName == '上交所') {
									var totalData = v.children;
									$.each(totalData, function(k, l) {
										shangTotal += l.totalMoney;
									})
									shangExchange.push(shangTotal);
									shangTotal=0;
								} else {
									var totalData = v.children;
									$.each(totalData, function(k, l) {
										shenTotal += l.totalMoney;
									})
									shenExchange.push(shenTotal);
									shenTotal=0;
								}

							})
						}
						//broker.push(msg[i].seatName);//添加券商名称
						//shangExchange.push(msg[i].);//添加上交所
					}
					myChart.hideLoading(); //隐藏加载动画
					myChart.setOption({ //载入数据
						yAxis : [ {
							data : broker
						} ],
						series : [ {
							name : '上交所',
							barWidth : 50,
							data : shangExchange
						}, {
							name : '深交所',
							barWidth : 50,
							data : shenExchange
						}, {
							name : '席位',
							barWidth : 50,
							data : seat
						} ]
					});
				}
			},
		});
		myChart.setOption(option);
	}
</script>
</html>