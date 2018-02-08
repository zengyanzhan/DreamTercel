<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>存款业务</title>
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
<!-- easyui的js和css部分 -->
<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet"
	type="text/css" />
<link href="../js/easyui/icons/icon-all.css" rel="stylesheet"
	type="text/css" />
<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/utils.js"></script>
<script type="text/javascript" src="../js/SaveingBusiness.js"></script>


<title>表格demo</title>
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
	<!--整个界面-->
	<div id="mianDiv">
		<!--工具栏-->
		<div id="toolbar" class="panel-heading form-inline">
			<!--增加按钮-->
			<button id="btn_add" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<!--修改按钮-->
			<button id="btn_edit" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>到期办理
			</button>
			<!--删除按钮-->
			<button id="btn_delete" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			&nbsp;&nbsp; <label>业务类型:</label> <select style="width: 190px;"
				class="form-control one" id="flag">
				<option value="0">----请选择----</option>
				<option value=1>未办理</option>
				<option value=2>已办理</option>

			</select><label>业务日期:</label>
			<div class="input-group date" id="stDates">
				<input type="text" class="form-control one" name="stDates"
					style="width: 138px; height: 38px"> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
			<label>到期日期</label>
			<div class="input-group date" id="strDateEnds">
				<input type="text" class="form-control one" name="strDateEnds"
					style="width: 138px; height: 38px"> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
			<button type="button" style="margin-left: 50px" id="btnSearch"
				class="btn btn-info">查询</button>
		</div>
		<!--中间部分-->
		<div class="panel-body">
			<!--表格-->
			<table id="myTable"></table>
		</div>
		<!--弹窗div-->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" data-backdrop="static">
			<div class="modal-dialog " role="document">
				<div class="modal-content" style="width: 720px; height: 680px">

					<!--表单验证  -->
					<!--表单验证  -->
					<form class="form-signin required-validate" action="#"
						method="post" id="myForm">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">×</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">新增</h4>
						</div>
						<div class="modal-body">
							<!-- 表单 -->
							流出账户
							<div class="form-inline" style="padding: 10px;">
								<div class="form-group">
									<label for="outCashAccountCode">账户编号:</label> <input
										type="text" name="outCashAccountCode" id="outCashAccountCode"
										class="form-control" data-placement="top"
										style="width: 210px; height: 35px;" placeholder="账户编号">
								</div>
								&nbsp;&nbsp;
								<div class="form-group">
									<label for="payName" style="width: 60px; margin-left: 50px">账户名称:</label>
									<input type="text" name="payName" data-placement="top"
										class="form-control clearData" placeholder="账户名称"
										style="width: 210px; height: 38px" readonly="readonly">
								</div>

							</div>
							<div class="form-inline" style="padding: 10px;">
								<div class="form-group">
									<label for="fundCode">基金编号:</label> <input type="text"
										name="fundCode" data-placement="top" class="form-control"
										value="${fund.fundCode}" readonly="readonly"
										placeholder="基金编号" style="width: 210px; height: 38px">
								</div>
								<div class="form-group">
									<label for="savingMoney" style="width: 60px; margin-left: 64px">流出余额:</label>
									<input type="text" id="savingMoney" data-placement="top"
										name="savingMoney" class="form-control clearData"
										placeholder="流出余额" style="width: 210px; height: 38px;" />
								</div>
							</div>
							&nbsp;&nbsp; 流入账户<br />
							<div class="form-inline" style="padding: 10px;">
								<div class="form-group">
									<label for="inCashAccountCode">账户编号:</label> <input type="text"
										name="inCashAccountCode" id="inCashAccountCode"
										class="form-control clearData" data-placement="top"
										style="width: 210px; height: 35px;" placeholder="账户编号">
								</div>
								&nbsp;&nbsp;
								<div class="form-group">
									<label for="cashName" style="width: 60px; margin-left: 50px">账户名称:</label>
									<input type="text" name="cashName" data-placement="top"
										class="form-control clearData" placeholder="账户名称"
										style="width: 210px; height: 38px" readonly="readonly">
								</div>

							</div>
							<div class="form-inline" style="padding: 10px;">
								<div class="form-group">
									<label for="money">流入资金:</label> <input type="text" id="money"
										name="money" class="form-control clearData"
										data-placement="top" style="width: 210px; height: 38px"
										placeholder="流入资金" readonly="readonly">
								</div>
								&nbsp;&nbsp;
								<div class="form-group">
									<label for="businessType" style="margin-left: 52px"></label>业务类型:<select
										style="width: 216px" class="form-control  clearData"
										name="businessType" id="businessType">
										<option value="0">----请选择----</option>
										<option value="3">定期3天</option>
										<option value="7">定期7天</option>
									</select>
								</div>

							</div>

							<div class="form-inline" style="padding: 10px;">
								<div class="form-group">
									<label for="yaarLiLu">年利率:</label> <input type="text"
										name="savingInterest" class="form-control clearData"
										data-placement="top" placeholder="年利率"
										style="width: 210px; height: 38px; margin-left: 12px"
										readonly="readonly">
								</div>
								&nbsp;&nbsp;
								<div class="form-group">
									<label for="liXi" style="width: 60px; margin-left: 50px">计算利息:</label>
									<input type="text" name="liXi" id="liXi" data-placement="top"
										class="form-control clearData" placeholder="计算利息"
										readonly="readonly" style="width: 210px; height: 38px">
								</div>

							</div>

							<div class="form-inline" style="padding: 10px;">
								<div class="form-group">
									<label for="strDate">业务日期:</label>
									<div class="input-group date" id="strDate">
										<input type="text" class="form-control clearData"
											name="strDate" style="width: 168px; height: 38px"> <span
											class="input-group-addon"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
								&nbsp;&nbsp;
								<div class="form-group">
									<label for="strDate" style="width: 60px; margin-left: 50px">到期日期:</label>
									<div class="input-group date" id="savingEndDate">
										<input type="text" class="form-control clearData"
											name="strDateEnd" style="width: 168px; height: 38px"
											readonly="readonly"> <span class="input-group-addon">
											<span class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>
							<div class="form-inline" style="padding: 10px;">
								<div class="form-group">
									<label for="desc" style="width: 90px;">备注:</label>
									<textarea class="form-control  one" name="desc" rows="3"
										style="margin-left: -30px" cols="74" max="200"
										placeholder="请输入备注子段"></textarea>
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