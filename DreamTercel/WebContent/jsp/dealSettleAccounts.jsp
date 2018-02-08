<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成交清算日报表</title>
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
<!--引用交易结算的js文件 -->
<script src="../js/dealSettleAccounts.js"></script>
<!--引入工具的js-->
<script type="text/javascript" src="../js/utils.js"></script>
<!--下拉列表css、js-->
<script type="text/javascript" src="../js/select/bootstrap-select.js"></script>
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<!--导入日期插件包-->
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.min.js"></script>
<!--导入日期汉化包-->
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />
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
</head>
<body>
	<div id="mianDiv">
		<div id="toolbar" class="panel-heading form-inline">
			<div class="form-group">
				<label for="jieMianDealDate">成交日期:</label>
				<div class="input-group date" id="jieMianDealDate"
					style="width: 204px;">
					<input type="text" class="form-control" id="strJieMianDealDate">
					<span class="input-group-addon"> <span
						class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
			</div>
			<button type="button" style="margin-left: 50px" id="btnSearch"
				class="btn btn-info">统计</button>
		</div>
	</div>
	<table id="dealSettleAccountsTable"></table>
</body>
</html>