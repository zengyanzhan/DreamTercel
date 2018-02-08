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
<!--引用券商信息的js文件 -->
<script src="../js/borket.js"></script>
<!--引入工具的js-->
<script type="text/javascript" src="../js/utils.js"></script>
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
<title>券商信息</title>
</head>

<body>
	<div id="mianDiv">
		<!--描述：表格-->
		<table id="borkerTable"></table>
		<!--描述：工具栏-->
		<div id="toolbar" class="panel-heading form-inline">
			<!--增加按钮-->
			<button id="btn_add" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<!--修改按钮-->
			<button id="btn_edit" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<!--删除按钮-->
			<button id="btn_delete" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			&nbsp;&nbsp; 券商名称: <input class="form-control" id="brokerName" />
			<button type="button" style="margin-left: 50px" id="btnSearch"
				class="btn btn-info">查询</button>
		</div>
	</div>
	<!--弹窗div-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" data-backdrop="static">
		<div class="modal-dialog " role="document">
			<div class="modal-content" style="width: 670px; height: 350px">

				<!--表单验证  -->
				<form class="form-signin required-validate"
					action="/insertSysUser.action" method="post" id="myForm"
					onsubmit="return insertSysUser(this)">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">新增</h4>
					</div>
					<div class="modal-body">
						<!-- 表单 -->

						<div class="form-inline" style="padding: 10px;">
							<div class="form-group">
								<label for="brokerCode">券商编号:</label> <input type="text"
									name="brokerCode" class="form-control" data-placement="top"
									placeholder="券商编号" style="width:205px">
							</div>
							&nbsp;&nbsp;
							<div class="form-group">
								<label for="brokerName">券商名称:</label> <input type="text"
									name="brokerName" data-placement="top" class="form-control"
									placeholder="券商名称">
							</div>
						</div>
						<div class="form-inline" style="padding: 10px;">
							<div class="form-group">
								<label for="brokerExplain">券商说明:</label> <input type="text"
									data-placement="top" name="brokerExplain" class="form-control"
									placeholder="券商说明">
							</div>
							&nbsp;&nbsp;
							<div class="form-group">
								<label for="brokerDesc">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</label>
								<textarea id="brokerDesc" name="brokerDesc" class="form-control"
									placeholder="备注"
									style="width: 495px; height: 50px; margin-top: 20px; resize: none;"></textarea>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" id="btnSave" class="btn btn-primary">
							<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
						</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
						</button>

					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>