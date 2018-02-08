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
<!-- easyui的js和css部分 -->
<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet"
	type="text/css" />
<link href="../js/easyui/icons/icon-all.css" rel="stylesheet"
	type="text/css" />
<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
<!--导入日期汉化包-->
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />

<!--引入弹窗插件的js文件-->
<script src='../js/alert/alert.js'></script>
<script type="text/javascript" src="../js/securityArap.js"></script>
<title>证券应收应付</title>
</head>
<body>
	<!--整个界面-->
	<div id="mianDiv">
		<!--工具栏-->
		<div id="toolbar" class="panel-heading form-inline">
			<!--增加按钮-->
			<button id="btnInsert" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<!--删除按钮-->
			<button id="btnDelete" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			<!--修改按钮-->
			<button id="btnUpdate" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			&nbsp;&nbsp; 
			日期:
			<div class="input-group date" id="strDate" >
				<input type="text" class="form-control" id="strDateWhere" name="strDateWhere" /> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
			业务类型:<select name="securityArapType" style="width: 180px;" id="securityArapType"
				class="form-control">
				<option value=0></option>
				<option value=1>估值增值</option>
				<option value=2>清算款</option>
				<option value=3>债券利息</option>
			</select>
			<button type="button" style="margin-left: 30px" id="btnSearch"
				class="btn btn-info">查询</button>
		</div>
		<!--中间部分-->
		<div class="panel-body">
			<!--表格-->
			<table id="myTable"></table>
		</div>
	</div>
	<!--弹窗div-->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" data-backdrop="static">
			<div class="modal-dialog " role="document">
				<div class="modal-content" style="width: 750px; height: 500px">

					<!--表单验证  -->
					<form class="form-signin required-validate" method="post"
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
									&nbsp;<label for="securityArapCode" style="width: 90px">应收应付编号:</label> 
									<input type="text" name="securityArapCode" style="width: 210px"
										readonly="readonly"
										class="form-control" data-placement="top"
										placeholder="证券应收应付编号" />
								</div>
								&nbsp;&nbsp;
								<div class="form-group" style="padding-left:62px;">
									<label for="cashAccountCode" style="width:60px;">现金账户:</label>
									<input type="text" name="cashAccountCode" data-placement="top"
										class="form-control"  style="width:225px" placeholder="现金账户">
								</div>
							</div>
							<div class="form-inline" style="padding: 10px;">
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="fundCode" 
											style="width: 87px; text-align: right">基金编号:</label>
											<div class="form-group">
										<input class="form-control" name="fundCode" style="width: 210px;" value="${fund.fundCode}" readonly="readonly"   />
									</div>
									</div>
									&nbsp;&nbsp;
									<div class="form-group" style="padding-left:60px;">
										<label for="moneyDirection"  
											style="width: 60px; text-align: right">资金方向:</label>
										<select   class="form-control" name="moneyDirection" style="width: 225px;" placeholder="资金方向">
											<option value="0"></option>
											<option value="1">流入</option>
											<option value="-1">流出</option>
										</select>
									</div>
								</div>
								<div class="form-inline" style="padding:10px;">
									<div class="form-group">
										<label for="strDate" class="control-label" 
											style="width:85px; text-align: right">业务日期:</label>
										<div class="input-group date" id="strDateser">
											<input type="text" class="form-control" name="strDate" style="width:169px;" placeholder="业务日期"> 
											<span class="input-group-addon"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
									&nbsp;&nbsp;
									<div class="form-group" style="padding-left:64px;">
										<label for="money" style="width: 50px">金&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;额:</label>
									&nbsp;&nbsp;<input type="text" name="money" data-placement="top"
											class="form-control" name="money" style="width: 225px"   placeholder="金额 ">
									</div>
								</div>
								<div class="form-inline" style="padding: 10px;">
										<div class="form-group">
										<label for="securityArapType" 
											style="width: 87px; text-align: right">证券类型:</label><select
											style="width: 210px;" class="form-control" name="securityArapType" placeholder="证券类型">
											<option value="0"></option>
											<option value="1">估值增值</option>
											<option value="2">清算款</option>
											<option value="3">债券利息</option>
										</select>
									</div>
									<div class="form-group" style="padding-left:70px;">
										&nbsp;&nbsp;<label for="securityCode"  
											style="width:60px; text-align: right">证券代码:</label>
									    <input  class="form-control" id="securityCode" name="securityCode"
										  style="width:222px;height:35px;" placeholder="证券代码">
									</div>
								</div>
								<div class="form-inline" style="padding:10px;">
									<div class="form-group" style="padding-left:22px;">
										<label for="securityArapDesc"
											style="width:60px; text-align: right">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</label>
										<textarea class="form-control" name="securityArapDesc" rows="3" cols="65"
											max="200" placeholder="备注"></textarea>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" id="btnSave" class="btn btn-primary">
									<span class="glyphicon glyphicon-floppy-disk"
										aria-hidden="true"></span>保存
								</button>
								<button type="button" class="btn btn-default"
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