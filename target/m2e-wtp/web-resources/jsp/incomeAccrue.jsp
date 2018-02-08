<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<!--引入弹窗插件的样式文件-->
<link rel="stylesheet" href="../js/alert/alert.css">
<!--引入弹窗插件的js文件-->
<script src='../js/alert/alert.js'></script>
<!--导入日期汉化包-->
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />
<!--引入工具的js-->
<script type="text/javascript" src="../js/utils.js"></script>
<!--引入弹窗插件的js文件-->
<script src='../js/alert/alert.js'></script>
<script type="text/javascript" src="../js/incomeAccrue.js"></script>
<title>收益计提</title>
</head>
<body>
	<!--整个界面-->
	<div id="mianDiv">
		<!--工具栏-->
		<div id="toolbar" class="panel-heading form-inline">
			&nbsp;&nbsp; 日期:
			<div class="input-group date" id="businessDatess">
				<input type="text" class="form-control" id="businessDateWhere"
					name="businessDateWhere" /> <span class="input-group-addon">
					<span class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
			<button type="button" style="margin-left: 30px" id="btnSelect"
				class="btn btn-info">查询</button>
			<button type="button" style="margin-left: 30px" id="btnCount"
				class="btn btn-info">统计</button>
		</div>
		<!--中间部分-->
		<!-- 	<div class="panel-body">
			表格
			<table id="myTable"></table>
		</div> -->
	</div>
	<div style="margin: 20px 0 10px 0;"></div>
	<div id="tt" class="easyui-tabs" style="height: 370px;">
		<ul id="myTab" class="nav nav-tabs">
			<li class="active"><a href="#cash" data-toggle="tab">现金计息</a></li>
			<li><a href="#bond" data-toggle="tab">债券计息</a></li>
			<li><a href="#two" data-toggle="tab">两费</a></li>
		</ul>
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade in active" id="cash">
				<table id="betweenTable1" style="margin-top: 5px"></table>
			</div>
			<div class="tab-pane fade" id="bond">
				<table id="betweenTable2" style="margin-top: 5px"></table>
			</div>
			<div class="tab-pane fade" id="two">
				<table id="betweenTable3" style="margin-top: 5px"></table>
			</div>
		</div>
	</div>
</body>
</html>