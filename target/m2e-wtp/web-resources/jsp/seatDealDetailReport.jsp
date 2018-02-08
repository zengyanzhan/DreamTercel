<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>席位成交明细报表</title>
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
	//加载事件 
	$(function() {
		$('#myTable').treegrid({
			url : '../selectSeatDealDetailReport.action',
			method : 'get',
			contentType : 'application/json',
			width : '100%',
			height : 510,
			idField : 'seatName',
			treeField : 'seatName',
			animate : true,//定义在节点展开或折叠的时候是否显示动画效果。
			fitColumns : true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
			title : '席位成交明细报表',
			columns : [ [ {
				//复选框
				checkbox : true
			}, {
				field : 'seatName',
				title : '券商席位',
				width:400,
				sortable : true,
				formatter : function(value, index, row) {
					return "<span style='font-size:16px'>"
							+ value + "</span>";
				}
			}, {
				field : 'securityCode',
				title : '证券代码',
				width:100,
				formatter : function(value, index, row) {
					return "<span style='font-size:16px'>"
							+ value + "</span>";
				}
			}, {
				field : 'securityName',
				title : '证券名称',
				width:100,
				formatter : function(value, index, row) {
					return "<span style='font-size:16px'>"
							+ value + "</span>";
				}
			}, {
				field : 'dealQuantity',
				title : '交易数量',
				width:100,
				formatter : function(value, index, row) {
					if (Number(value) == 0) {
						return "";
					} else if (Number(value) < 0) {
						return "<span style='color:red;font-size:16px'>" + Number(-(value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,")) + "</span>";
					}
					return "<span style='color:green;font-size:16px'>" + (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,") + "</span>";
				}
			}, {
				field : 'dealTotalPrice',
				title : '交易金额',
				width:100,
				formatter : function(value, index, row) {
					if (Number(value) == 0) {
						return "";
					} else if (Number(value) < 0) {
						return "<span style='color:red;font-size:16px'>" + Number(-(value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,")) + "</span>";
					}
					return "<span style='color:green;font-size:16px'>" + (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,") + "</span>";
				}
			}, {
				field : 'brokerage',
				title : '佣金费用',
				width:100,
				formatter : function(value, index, row) {
					if (Number(value) == 0) {
						return "";
					} else if (Number(value) < 0) {
						return "<span style='color:red;font-size:16px'>" + value.toFixed(2) + "</span>";
					}
					return "<span style='color:green;font-size:16px'>" + value.toFixed(2) + "</span>";
				}
			}, {
				field : 'stamps',
				title : '印花税',
				width:100,
				formatter : function(value, index, row) {
					if (Number(value) == 0) {
						return "";
					} else if (Number(value) < 0) {
						return "<span style='color:red;font-size:16px'>" + value.toFixed(2) + "</span>";
					}
					return "<span style='color:green;font-size:16px'>" + value.toFixed(2) + "</span>";
				}
			}, {
				field : 'transferFee',
				title : '过户费',
				width:100,
				formatter : function(value, index, row) {
					if (Number(value) == 0) {
						return "";
					} else if (Number(value) < 0) {
						return "<span style='color:red;font-size:16px'>" + value.toFixed(2) + "</span>";
					}
					return "<span style='color:green;font-size:16px'>" + value.toFixed(2) + "</span>";
				}
			}, {
				field : 'manageFee',
				title : '征管费',
				width:100,
				formatter : function(value, index, row) {
					if (Number(value) == 0) {
						return "";
					} else if (Number(value) < 0) {
						return "<span style='color:red;font-size:16px'>" + value.toFixed(2) + "</span>";
					}
					return "<span style='color:green;font-size:16px'>" + value.toFixed(2) + "</span>";
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
		//给日期默认今天
		var today=new Date();
		var nowdate=(today.getFullYear())+"-"+(today.getMonth()+1)+"-"+today.getDate();
		//对日期格式进行处理
		var date=new Date(nowdate);
		var mon=date.getMonth()+1;
		var day = date.getDate();
		var mydate = date.getFullYear() + "-" + (mon < 10 ? "0" + mon : mon) + "-" + (day < 10 ? "0" + day : day);
		$("#firstDate").val(mydate);
		//查询
		$("#btnSearch").click(function() {
			var firstDate = $("#firstDate").val();
			if (firstDate != "") {
				$("#myTable").treegrid('load', {
					firstStrDate : firstDate,
					secondStrDate : firstDate
				})
			} else {
				myAlert("请输入查询日期");
			}
		})
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
			&nbsp;&nbsp; <label class="control-label">查询日期：</label>
			<div class='input-group date' id='datetimepicker1'>
				<input type='text' class="form-control" id="firstDate" /> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
			<button type="button" style="margin-left: 10px" id="btnSearch"
				class="btn btn-info">查询</button>
		</div>
		<!--中间部分-->
		<table id="myTable"></table>
	</div>
</body>
</html>