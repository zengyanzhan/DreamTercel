<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>划款指令</title>
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
<script type="text/javascript" src="../js/approptiationOrder.js"></script>

<!-- easyui的js和css部分 -->
<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet"
	type="text/css" />
<link href="../js/easyui/icons/icon-all.css" rel="stylesheet"
	type="text/css" />
<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/utils.js"></script>
</head>
<body>
	<table id="myTable"></table>
	<div id="myTool" class="panel-heading form-inline">
		<!-- 按钮 -->
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
		<!--日期控件-->
		<label>指定日期:</label>
		<div class="input-group date" id="orderDates">
			<input type="text" class="form-control one" name="orderDates"
				id="str"> <span class="input-group-addon"> <span
				class="glyphicon glyphicon-calendar"></span>
			</span>
		</div>

		<!--日期控件-->
		<label>到款日期:</label>
		<div class="input-group date" id="dates">
			<input type="text" class="form-control one" name="dates"
				id="strToDate"> <span class="input-group-addon "> <span
				class="glyphicon glyphicon-calendar"></span>
			</span>
		</div>

		<label>收款人名称</label> <input type="text" style="width: 150px"
			name="cashNames" class="form-control one">
		<button type="button" class="btn btn-info" id="btnSelect">查询</button>
         <br/>
         <button id="btn_addAllot" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>生成资金调拨
			</button>
			  <button id="exportExcel" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>导出
			</button>
	</div>

	<!--弹窗div-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" data-backdrop="static">
		<div class="modal-dialog " role="document">
			<div class="modal-content" style="width: 720px; height: 650px">

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
								<label for="code" style="width: 95px">划款指令编号:</label><input
									type="text" name="code" style="width: 210px"
									class="form-control clearData" placeholder="划款指令编号"
									readonly="readonly" />
							</div>
							&nbsp;&nbsp;
							<div class="form-group">
								<label for="payCode" style="width: 60px; margin-left: 50px">付款卡号:</label>
								<input type="text" id="payCode" name="payCode"
									class="form-control" placeholder="付款卡号"
									style="width: 210px; height: 35px;">
							</div>
						</div>
						<div class="form-inline" style="padding: 10px;">
							<div class="form-group">
								<label for="payName" style="width: 90px; text-align: right">付款人:</label>
								<input type="text" style="width: 210px" data-placement="top"
									name="payName" class="form-control clearData" placeholder="付款人"
									readonly="readonly">
							</div>
							&nbsp;&nbsp;
							<div class="form-group">
								<label for="payBank" style="width: 60px; margin-left: 50px">付款银行:</label>
								<input type="text" id="payBank" name="payBank"
									data-placement="top" style="width: 210px"
									class="form-control clearData" placeholder="付款银行"
									style="width: 180px; height: 38px" readonly="readonly">
							</div>
						</div>
						<div class="form-inline" style="padding: 10px;">
							<div class="form-group">
								<label for="cashCode" style="width: 60px; margin-left: 30px">收款卡号:</label>
								<input type="text" id="cashCode" name="cashCode"
									class="form-control" placeholder="付款卡号"
									style="width: 210px; height: 35px;">
							</div>
							<div class="form-group">
								<label for="cashName"
									style="width: 70px; margin-left: 55px; text-align: right;">收款人:</label><input
									type="text" id="cashName" name="cashName" data-placement="top"
									style="width: 210px" class="form-control clearData"
									placeholder="收款人" style="width: 180px; height: 38px"
									readonly="readonly">
							</div>
						</div>
						<div class="form-inline" style="padding: 10px;">
							<div class="form-group">
								<label for="cashBank" style="width: 90px; text-align: right">收款银行:</label>
								<input type="text" id="cashBank" name="cashBank"
									data-placement="top" style="width: 210px"
									class="form-control clearData" placeholder="收款银行"
									style="width: 180px; height: 38px" readonly="readonly">
							</div>
							<div class="form-group">
								<label for="strOrderDate"
									style="width: 90px; text-align: right; margin-left: 30px">指令日期:</label>
								<div class="input-group date" id="strOrderDate">
									<input type="text" class="form-control  clearData"
										name="strOrderDate"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
						</div>
						<div class="form-inline" style="padding: 10px;">
							<div class="form-group">
								<label style="width: 90px; text-align: right">到款日期:</label>
								<div class="input-group date" id="date">
									<input type="text" class="form-control one" name="strToDate"
									> <span class="input-group-addon ">
										<span class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
							<div class="form-group">
								<label for="money"
									style="width: 90px; text-align: right; margin-left: 30px">划款金额:</label>
								<input type="text" id="money" name="money" data-placement="top"
									style="width: 210px" class="form-control clearData"
									placeholder="划款金额" style="width: 180px; height: 38px">
							</div>
						</div>
						<div class="form-inline" style="padding: 10px;">
							<div class="form-group">
								<label for="allotFlag" style="width: 90px; margin-left: 30px">调拨标志:</label><select
									style="width: 213px; margin-left: -22px"
									class="form-control  clearData" name="allotFlag">
									<option value="">----请选择----</option>
									<option value="1">未调拨</option>
									<option value="2">已经调拨</option>
								</select>
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