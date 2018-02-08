<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资金调拨</title>
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
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.css" />

<!--引入弹窗插件的样式文件-->
<link rel="stylesheet" href="../js/alert/alert.css">
<!--引入弹窗插件的js文件-->
<script src='../js/alert/alert.js'></script>
<script type="text/javascript" src="../js/moneyAllot.js"></script>
<script type="text/javascript" src="../js/utils.js"></script>
<!-- easyui的js和css部分 -->
<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet"
	type="text/css" />
<link href="../js/easyui/icons/icon-all.css" rel="stylesheet"
	type="text/css" />
<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
</head>
<body>
	<table id="myTable"></table>
	<div id="myTool" class="panel-heading form-inline">
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
		<label>调拨类型:</label> <select style="width: 190px;"
			class="form-control one" id="types">
			<option value="0">----请选择----</option>
			<option value=1>存款利息</option>
			<option value=2>申购赎回清算款</option>
			<option value=3>买卖交易清算款</option>
			<option value="4">两费利息</option>
			<option value="5">债券利息</option>
		</select>

		<!--日期控件-->
		<label>调拨日期:</label>
		<div class="input-group date" id="allDates">
			<input type="text" class="form-control one" name="allDates">
			<span class="input-group-addon"> <span
				class="glyphicon glyphicon-calendar"></span>
			</span>
		</div>

		<!--日期控件-->
		<label>业务日期:</label>
		<div class="input-group date" id="businessDates">
			<input type="text" class="form-control one" name="businessDates">
			<span class="input-group-addon"> <span
				class="glyphicon glyphicon-calendar"></span>
			</span>
		</div>
		<button type="button" class="btn btn-info" id="btnSelect">查询</button>

	</div>

	<!--弹窗div-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" data-backdrop="static">
		<div class="modal-dialog " role="document">
			<div class="modal-content" style="width: 720px; height: 550px">

				<!--表单验证  -->
				<form class="form-signin required-validate" action="#" method="post"
					id="myForm">
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
								<label for="code" style="width: 95px">资金调拨编号:</label><input
									type="text" name="code" style="width: 210px"
									class="form-control" placeholder="资金调拨编号" readonly="readonly" />
							</div>
							&nbsp;&nbsp;
							<div class="form-group">
								<label for="fundCode" style="width: 60px; margin-left: 50px">基金编号:</label>
								<input type="text" name="fundCode" data-placement="top"
									class="form-control" style="width: 210px" placeholder="基金编号"
									value="${fund.fundCode}" readonly="readonly">
							</div>
						</div>
						<div class="form-inline" style="padding: 10px;">
							<div class="form-group">
								<label for="accountCode" style="width: 60px; margin-left: 30px">银行卡号:</label>
								<input type="text" id="accountCode" name="accountCode"
									class="form-control" placeholder="银行卡号"
									style="width: 210px; height: 35px;">
							</div>
							&nbsp;&nbsp;
							<div class="form-group">
								<label for="money" style="width: 60px; margin-left: 50px">调拨资金:</label>
								<input type="text" id="money" name="money" data-placement="top"
									style="width: 210px" class="form-control clearData"
									placeholder="调拨资金" style="width: 180px; height: 38px">
							</div>
						</div>
						<div class="form-inline" style="padding: 10px;">
							<div class="form-group">
								<label for="date" class="control-label"
									style="width: 90px; text-align: right">调拨日期:</label>
								<div class="input-group date" id="strDate">
									<input type="text" class="form-control  clearData"
										name="strDate"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
							&nbsp;&nbsp;
							<div class="form-group">
								<label for="direction" style="width: 70px; margin-left: 45px">资金流向:</label><select
									style="width: 213px; margin-left: -7px"
									class="form-control  clearData" name="direction">
									<option value="">----请选择----</option>
									<option value="1">流入</option>
									<option value="-1">流出</option>
								</select>
							</div>
						</div>
						<div class="form-inline" style="padding: 10px;">
							<div class="form-group">
								<label for="type" style="width: 90px; text-align: right">调拨类型:</label><select
									style="width: 219px;" class="form-control  clearData"
									name="type">
									<option value="">----请选择----</option>
									<option value="1">存款利息</option>
									<option value="2">申购赎回清算款</option>
									<option value="3">买卖交易清算款</option>
									<option value="4">两费利息</option>
									<option value="5">债券利息</option>
								</select>
							</div>
							<div class="form-group">
								<label for="businessCode"
									style="width: 80px; text-align: right; margin-left: 38px">业务编号:</label>
								<input type="text" id="businessCode" name="businessCode"
									data-placement="top" class="form-control clearData"
									placeholder="业务编号" style="width: 210px;">
							</div>
						</div>
						<div class="form-inline" style="padding: 10px;">
							<div class="form-group">
								<label for="businessDate" style="width: 90px; text-align: right">业务日期:</label>
								<div class="input-group date" id="strBusinessDate">
									<input type="text" class="form-control  clearData"
										name="strBusinessDate"> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
						</div>
						<div class="form-inline" style="padding: 10px;">
							<div class="form-group" name="desc">
								<label for="desc" style="width: 90px; text-align: right">备注:</label>
								<textarea class="form-control  one" name="desc" rows="3"
									cols="74" max="200" placeholder="请输入备注子段"></textarea>
							</div>
						</div>
					</div>

					<div class="modal-footer">
						<button type="submit" id="btnSave" class="btn btn-primary">
							<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
						</button>
						<button type="button" class="btn btn-default del"
							data-dismiss="modal">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
						</button>

					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>