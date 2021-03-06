<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>净值统计</title>
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
	
	<!-- easyui的js和css部分 -->
	<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet"
		type="text/css" />
	<link href="../js/easyui/icons/icon-all.css" rel="stylesheet"
		type="text/css" />
	<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
	<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
	<!--导入日期插件包-->
    <script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
    <!--导入日期汉化包-->
    <script type="text/javascript" src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
    <link rel="stylesheet"  href="../css/bootstrap-datetimepicker.min.css"/>
    <!-- 导入easyui jar包 -->
	<script type="text/javascript">
	</script>
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
	<script type="text/javascript" src="../js/netValueStatistics.js">
	</script>

</head>
<body>
	<!--整个界面-->
	<div id="mianDiv">
		<!--工具栏-->
		<div id="toolbar" class="panel-heading form-inline" style="padding:20px">
			&nbsp;&nbsp; 统计日期:
			<!-- 时间插件 -->
			<div class="input-group date" id="tongjiDate">
			 	<input type="text" class="form-control" id='statisticDateWhere'>
			 	<span class="input-group-addon">
			 		<span class="glyphicon glyphicon-calendar"></span>
			 	</span>
		 	</div>
			<button type="button" style="margin-left: 50px" id="btnSearch"class="btn btn-info">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
			</button>
			<button type="button" style="margin-left: 50px" id="btnTongJi"class="btn btn-info">
				<span class="glyphicon glyphicon-align-center" aria-hidden="true"></span>统计
			</button>
			<button type="button" style="margin-left: 50px" id="btnExport" class="btn btn-info">
				<span class="glyphicon glyphicon-print" aria-hidden="true"></span>净值导出
			</button>
		</div>

		<!--中间部分-->
		<div class="panel-body">
			<!--表格-->
			<table id="myTable"></table>
		</div>

	</div>
</body>
</html>