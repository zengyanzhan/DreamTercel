<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>现金寸头金额报表</title>
</head>
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
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.zh-CN.js"></script>

<!--引入弹窗插件的样式文件-->
<link rel="stylesheet" href="../js/alert/alert.css">
<!--引入弹窗插件的js文件-->
<script src='../js/alert/alert.js'></script>
<!--引入弹窗插件的样式文件-->
<link rel="stylesheet" href="../js/message/message.css">
<!--引入弹窗插件的js文件-->
<script src='../js/message/message.js'></script>
<style type="text/css">
* {
	font-family: "微软雅黑";
}

.form-control {
	width: 140px;
}

#mianDiv {
	position: absolute;
	width: 100%;
	height: 100%;
}

#mianDiv .columns-right {
	margin-top: 30px;
}
/*弹窗的样式*/
div .alert-content, div .alert-title, div .alert-btn-box, div .alert-btn-p
	{
	/* background-color:blue; */
	font-weight: bold;
}
</style>
<script type="text/javascript">
	//加载表格
	$(function() {
		$('#myTable').bootstrapTable(
				{
					url : '../selectCashPositionReport.action',
					method : 'get', //请求方式（*）
					contentType : 'application/json',
					toolbar : '#toolbar', //工具按钮用哪个容器
					striped : true, //是否显示行间隔色
					//cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
					pagination : true, //是否显示分页（*）
					sortable : true, //是否启用排序
					sortOrder : "asc", //排序方式
					queryParams : function(params) {
						var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
							rows : params.limit, //页面大小
							page : params.offset / params.limit + 1, //页码
							firstStrDate : $("#datetime").val(), //查询的参数   查询时间
							sortName : this.sortName,
							sortOrder : this.sortOrder,
						};
						return temp;
					}, //传递参数（*）
					sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
					pageNumber : 1, //初始化加载第一页，默认第一页
					pageSize : 10, //每页的记录行数（*）
					pageList : [ 10, 15, 20 ], //可供选择的每页的行数（*）
					showColumns : true, //是否显示所有的列
					showRefresh : true, //是否显示刷新按钮
					minimumCountColumns : 2, //最少允许的列数
					clickToSelect : true, //是否启用点击选中行
					height : 600, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
					//uniqueId : "usrId", //每一行的唯一标识，一般为主键列
					showToggle : false, //是否显示详细视图和列表视图的切换按钮
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					//列字段
					columns : [ {
						//复选框
						checkbox : true
					}, {
						field : 'projectId',
						title : '现金寸头编号',
						//启用该字段的排序
						sortable : true
					}, {
						field : 'projectName',
						title : '现金寸头名称',
						//启用该字段的排序
						sortable : true
					}, {
						field : 'projectPrice',
						title : '现金总金额',
						formatter : function(value, index, row) {
							if(Number(value)==0){
								return "";
							}
							if (Number(value) < 0) {
								return "<span style='color:red'>"
										+ (value*-1 || 0)
												.toString()
												.replace(
														/(\d)(?=(\d{3})+(?!\d))/g,
														"$1,")
										+ "</span>";
							}
							return "<span style='color:green'>"
									+ (value || 0)
											.toString()
											.replace(
													/(\d)(?=(\d{3})+(?!\d))/g,
													"$1,")
									+ "</span>";
						}
					}]
				});
		$('#datetimepicker').datetimepicker({
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//显示格式
			minView : "month",//设置只显示到月份
			//initialDate: new Date(),//初始化当前日期
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
		$("#datetime").val(mydate);
		//查询
		$("#btnSearch").click(function() {
			$("#myTable").bootstrapTable('refresh');
		});
	});
</script>
</head>

<body>
	<!--整个界面-->
	<div id="mianDiv">
		<!--工具栏-->
		<div id="toolbar" class="panel-heading form-inline"
			style="margin-top: 10px">
			<label class="control-label">日期：</label>
			<div class='input-group date' id='datetimepicker'>
				<input type='text' class="form-control" id="datetime" /> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
			<button type="button" style="margin-left: 10px" id="btnSearch"
				class="btn btn-info">统计</button>
		</div>
		<!--中间部分-->
		<div class="panel-body">
			<!--表格-->
			<table id="myTable"></table>
		</div>
	</div>
</body>
</html>