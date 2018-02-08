<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收益支付</title>
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
<script type="text/javascript" src="../js/select/bootstrap-select.js"></script>
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<!--导入日期插件包-->
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.min.js"></script>
<!--导入日期汉化包-->
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />

<!--引入弹窗插件的样式文件-->
<link rel="stylesheet" href="../js/alert/alert.css">
<!--引入弹窗插件的js文件-->
<script src='../js/alert/alert.js'></script>
<!--引入工具的js-->
<script type="text/javascript" src="../js/utils.js"></script>
<script type="text/javascript" src="../js/incomePay.js"></script>
</head>
<body>
	<!--整个界面-->
	<div id="mianDiv">
		<!--工具栏-->
		<div id="toolbar" class="panel-heading form-inline">
			&nbsp;&nbsp; 日期:
			<div class="input-group date" id="businessDate">
				<input type="text" class="form-control" name="businessDate"> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>

				</span>
			</div>
			<button type="button" style="margin-left: 30px" id="btnSearch"
				class="btn btn-info" onclick="searchBond()">查询</button>
			<button type="button" style="margin-left: 30px" id="btnCount"
				class="btn btn-info" onclick="statistics()">统计</button>
		</div>
	</div>
	<ul id="myTab" class="nav nav-tabs">
		<li class="active"><a href="#home" data-toggle="tab"> 支付两费</a></li>
		<li><a href="#ios" data-toggle="tab">现金利息收入</a></li>
		<li><a href="#bond" data-toggle="tab">债券利息收入</a></li>

	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="home">
			<table id="liangFeiTable" style="margin-top: 5px"></table>
		</div>
		<div class="tab-pane fade" id="ios">
			<table id="xiangJinTable" style="margin-top: 5px"></table>
		</div>
		<div class="tab-pane fade" id="bond">
			<table id="zhaiQuanTable" style="margin-top: 5px"></table>
		</div>
	</div>
</body>
</html>