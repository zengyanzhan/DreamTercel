<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>TA交易数据</title>
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

<!--描述：导入日期插件包-->
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.min.js"></script>
<!--导入日期汉化包-->
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />
<!--引用TA交易数据的js文件 -->
<script src="../js/taTradeData.js"></script>
<script src='../js/utils.js'></script>
<!-- easyui的js和css部分 -->
<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet"
	type="text/css" />
<link href="../js/easyui/icons/icon-all.css" rel="stylesheet"
	type="text/css" />
<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
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
	
</script>
</head>
<body>
	<div id="mianDiv">
		<table id="deslateTable"></table>
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
			<!--申购-->
			<button id="shInput" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-import" aria-hidden="true">
				</span> TA申购
			</button>
			<button id="TaShInput" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-import" aria-hidden="true">
				</span> TA赎回
			</button>
			&nbsp;&nbsp; 类型： <select class="form-control" name="taRadeTypeWhere"
				style="width: 180px" data-placement="top" placeholder="交易类型"
				style="width:180px">
				<option value=""></option>
				<option value="1">认购</option>
				<option value="2">申购</option>
				<option value="3">赎回</option>
			</select> &nbsp;&nbsp;
			<div class="form-group">
				<label for="taTradeStatus">状态&nbsp;:</label>
				<!--  <label for="ta_tradeType">交易状态&nbsp;:</label> <input type="text" name="ta_tradeType" data-placement="top" class="form-control" placeholder="交易状态">-->
				<select class="form-control" name="taTradeStatusWhere"
					style="width: 180px" data-placement="top" placeholder="交易状态"
					style="width:180px">
					<option value=""></option>
					<option value="1">已结算</option>
					<option value="2">未结算</option>
				</select>
			</div>
			&nbsp;&nbsp; <label>结算时间：</label>
			<div class="input-group date" id="dateTest">
				<input type="text" class="form-control" name="settleDateWhere"
					id="settleDateWhere"> <span class="input-group-addon">
					<span class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
			<button type="button" style="margin-left: 50px" id="btnSearch"
				class="btn btn-info">查询</button>
		</div>
	</div>

	<!--数据导入弹窗div-->
	<div class="modal fade" id="inputDate" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog " role="document">
			<div class="modal-content" style="width: 570px; height: 310px">
				<form action="../TaTradeDataUpload.action" method="post"
					enctype="multipart/form-data">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">TA申购</h4>
					</div>
					<div class="modal-body" style="height: 150px;">
						<span style="font-size: 15px; font-weight: bold;">请选择需要的xlsx文件：</span><input
							type="file" name="file" size="15"
							style="margin-left: 160px; margin-top: 15px;" />
					</div>
					<div class="modal-footer">
						<button type="submit" id="btnInput" class="btn btn-primary">
							<span class="glyphicon glyphicon-import" aria-hidden="true"></span>导入
						</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
						</button>

					</div>
				</form>
			</div>
		</div>
	</div>


	<!--数据导入弹窗div   赎回窗口-->
	<div class="modal fade" id="TaShOutput" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog " role="document">
			<div class="modal-content" style="width: 570px; height: 310px">
				<form action="../TaTradeDataTaShOutputUpload.action" method="post"
					enctype="multipart/form-data">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title" id="modalLabels">TA赎回</h4>
					</div>
					<div class="modal-body" style="height: 150px;">
						<span style="font-size: 15px; font-weight: bold;">请选择需要的dbf文件：</span><input
							type="file" name="file" size="15"
							style="margin-left: 160px; margin-top: 15px;" />
					</div>
					<div class="modal-footer">
						<button type="submit" id="btnInput" class="btn btn-primary">
							<span class="glyphicon glyphicon-import" aria-hidden="true"></span>导入
						</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
						</button>

					</div>
				</form>
			</div>
		</div>
	</div>
	<!--增加弹窗div-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" data-backdrop="static">
		<div class="modal-dialog " role="document" >
			<div class="modal-content" style="width: 610px; height: 670px">
				<!--表单验证  -->
				<form class="form-signin required-validate"
					action="/insertSysUser.action" method="post" id="myForm"
					name="inputMyForm" onsubmit="return insertSysUser(this)">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title" id="myModalLabels">新增</h4>
					</div>
					<div class="modal-body">
						<div class="form-inline" style="padding: 5px;">
							&nbsp;&nbsp;&nbsp;
							<div class="form-group">
								<label for="taTradDataCode">TA账号ID&nbsp;:</label> <input
									type="text" name="taTradDataCode" id="taTradeDataCode"
									class="form-control" readonly data-placement="top"
									placeholder="TA账号ID" />
							</div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="form-group">
								<label for="fundCode">基金代码&nbsp;:</label> <input type="text"
									id="funCode" name="fundCode" data-placement="top"
									class="form-control" placeholder="基金代码" readonly
									style="width: 175px; height: 35px" value="${fund.fundCode}">
							</div>
						</div>

						<div class="form-inline" style="padding: 5px;">
							&nbsp;&nbsp;&nbsp;
							<div class="form-group">
								<label for="cashAccountCode">账&nbsp;&nbsp;户&nbsp;&nbsp;I&nbsp;D&nbsp;:</label>
								<input type="text" id="cashAccountCode" name="cashAccountCode"
									data-placement="top" class="form-control" placeholder="基金代码"
									style="width: 175px; height: 35px">
							</div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="form-group">
								<label for="agencies">代销机构&nbsp;:</label> <select
									class="form-control" name="agencies" id="agencies"
									style="width: 180px" data-placement="top" placeholder="代销机构"
									style="width:180px">
									<option value=""></option>
									<option value="1">建设银行</option>
									<option value="2">工商银行</option>
									<option value="3">农业银行</option>
								</select>
							</div>
						</div>

						<hr />
						<div class="form-inline" style="padding: 5px;">
							&nbsp;&nbsp;&nbsp;
							<div class="form-group">
								<label for="taQuality">基&nbsp;金&nbsp;数&nbsp;量:</label> <input
									type="text" onkeyup="suan()" id="taTradQuality"
									name="taTradQuality" class="form-control" data-placement="top"
									placeholder="基金数量" style="width: 175px; height: 35px">
							</div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="form-group">
								<label for="taUnitMoney">单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价&nbsp;:</label>
								<input type="text" onkeyup="suan()" id="taUnitMoney"
									name="taUnitMoney" data-placement="top" class="form-control"
									placeholder="单价" style="width: 175px; height: 35px">
							</div>

						</div>
						<div class="form-inline" style="padding: 5px;">
							&nbsp;&nbsp;&nbsp;
							<div class="form-group">
								<label for="fee">费&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用&nbsp;:</label>
								<input type="text" onkeyup="jisuan()" id="fee" name="fee"
									data-placement="top" class="form-control" placeholder="费用"
									style="width: 175px; height: 35px">
							</div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="form-group">
								<label for="taTotalMoney">总&nbsp;&nbsp;金&nbsp;&nbsp;额:</label> <input
									type="text" data-placement="top" id="taTotalMoney"
									name="taTotalMoney" class="form-control" readonly
									placeholder="总金额">
							</div>

						</div>

						<div class="form-inline" style="padding: 5px;">
							&nbsp;&nbsp;&nbsp;
							<div class="form-group">
								<label for="taRealMoney">实&nbsp;际&nbsp;金&nbsp;额:</label> <input
									type="text" id="taRealMoney" name="taRealMoney"
									data-placement="top" class="form-control" readonly
									placeholder="实际金额">
							</div>
						</div>
						<hr />


						<div class="form-inline" style="padding: 5px;">
							&nbsp;&nbsp;&nbsp;
							<div class="form-group">
								<label for="taTradeDate">交&nbsp;易&nbsp;日&nbsp;期:</label>

								<div class="input-group date" id="taTradeDate"
									style="width: 180px">
									<input type="text" class="form-control" id="tradeDate"
										name="tradeDate" /> <span class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="form-group">
								<label for="taTradeStatus">交易状态&nbsp;:</label>
								<!--  <label for="ta_tradeType">交易状态&nbsp;:</label> <input type="text" name="ta_tradeType" data-placement="top" class="form-control" placeholder="交易状态">-->
								<select class="form-control" name="taTradeStatus"
									id="taTradeStatus" style="width: 180px" data-placement="top"
									placeholder="交易状态" style="width:180px">
									<option value=""></option>
									<option value="1">已结算</option>
									<option value="2">未结算</option>
								</select>
							</div>
						</div>
						<div class="form-inline" style="padding: 5px;">
							&nbsp;&nbsp;&nbsp;
							<div class="form-group">
								<label for="settleDate">结&nbsp;算&nbsp;日&nbsp;期:</label>
								<div class="input-group date" id="settleDate"
									style="width: 180px">
									<input type="text" class="form-control" id="settlesDate"
										readonly name="settlesDate"> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="form-group">
								<label for="taRadeTypes">交易类型&nbsp;:</label> <select
									class="form-control" name="taRadeType" id="taRadeType"
									style="width: 180px" data-placement="top" placeholder="交易类型"
									style="width:180px">
									<option value=""></option>
									<option value="1">认购</option>
									<option value="2">申购</option>
									<option value="3">赎回</option>
								</select>
							</div>
						</div>


						<hr />
						<div class="form-inline" style="padding: 5px;">
							&nbsp;&nbsp;&nbsp;
							<div class="form-group">
								<label for="taTradDataDesc">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</label>
								<textarea id="taTradDataDesc" name="taTradDataDesc"
									class="form-control" placeholder="备注"
									style="width: 473px; height: 50px; resize: none"></textarea>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="btnSave" class="btn btn-primary">
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