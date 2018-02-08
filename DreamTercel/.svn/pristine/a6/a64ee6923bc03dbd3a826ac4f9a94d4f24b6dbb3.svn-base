<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>现金账号表</title>
<meta charset="UTF-8">
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
<script type="text/javascript" src="../js/bootstrap-table-zh-CN.js"></script>

<!--引入弹窗插件的样式文件-->
<link rel="stylesheet" href="../js/alert/alert.css">
<script src='../js/utils.js'></script>
<!--引入弹窗插件的js文件-->
<script src='../js/alert/alert.js'></script>
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.min.js"></script>
<!--导入日期汉化包-->
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.css" />
<!-- easyui的js和css部分 -->
<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet"
	type="text/css" />
<link href="../js/easyui/icons/icon-all.css" rel="stylesheet"
	type="text/css" />
<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/cashAccount.js"> 
			
		</script>
		<script src='../js/utils.js'></script>

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
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<!--删除按钮-->
			<button id="btn_delete" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			&nbsp;&nbsp; 银行名称: <input class="form-control" id=cashAccountBankName /> 
			
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
			aria-labelledby="myModalLabel"   data-backdrop="static">
			<div class="modal-dialog " role="document">
				<div class="modal-content" style="width: 740px; height: 460px">

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
									<label for="cashAccountCode">&nbsp;&nbsp;账&nbsp;号&nbsp;编&nbsp;号:</label> <input type="text"
										style="width: 180px" name="cashAccountCode" class="form-control"
										data-placement="top" placeholder="账号编号"  	readonly="readonly">
								</div>
								&nbsp;&nbsp;
								<div class="form-group">
									<label for="cashAccountBankCard">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;银&nbsp;行&nbsp;卡&nbsp;号:</label> <input
										style="width: 180px" type="text" name="cashAccountBankCard" data-placement="top"
										class="form-control" placeholder="银行卡号">
								</div>
							</div>
							<div class="form-inline" style="padding: 10px;">
								<div class="form-group">
									<label for="cashAccountName">&nbsp;&nbsp;账&nbsp;户&nbsp;名&nbsp;称:</label> <input type="text"
										style="width: 180px" data-placement="top" name="cashAccountName"
										class="form-control" placeholder="账号名称">
								</div>
								&nbsp;&nbsp;
								<div class="form-group">
									<label for="cashAccountBankName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;银&nbsp;行&nbsp;名&nbsp;称:</label> <input
										style="width: 180px"type="text" data-placement="top" name="cashAccountBankName"
										class="form-control" placeholder="银行名称">
								</div>

							</div>

							<div class="form-inline" style="padding: 10px;">
								<div class="form-group">
									<label for="cashAccountDepositType" class="control-label">&nbsp;&nbsp;存&nbsp;款&nbsp;类&nbsp;型:</label>
									<select class="form-control" name="cashAccountDepositType"
										style="width: 180px" data-placement="top" style="width:180px">
										<option value="1">活期</option>
										<option value="2">定期</option>
									</select>
								</div>
								&nbsp;&nbsp;
								<div class="form-group">
									<label for="cashAccountCardRate">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;卡&nbsp;号&nbsp;利&nbsp;率:</label> <input
										 style="width: 180px" type="text" name="cashAccountCardRate" class="form-control"
										data-placement="top" placeholder="卡号利率">
								</div>
							</div>
							<div class="form-inline" style="padding: 10px;">

								<div class="form-group">
									<label for="cashAccountInterestPeriod" class="control-label">&nbsp;&nbsp;计&nbsp;息&nbsp;期&nbsp;间:</label>
									<select class="form-control" name="cashAccountInterestPeriod"
										style="width: 180px" data-placement="top" style="width:180px">
										<option value="1">360</option>
										<option value="2">365</option>
										<option value="3">366</option>
									</select>
								</div>

								&nbsp;&nbsp;
								<label for="cashAccountStartTime">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开&nbsp;户&nbsp;时&nbsp;间:</label>
								<div class="input-group date" id="shijiekj">
									 <input type="text" name="strStart" 
									 style="width: 140px" data-placement="top" class="form-control"  placeholder="开户时间">
												<span class="input-group-addon"> 
									<span class="glyphicon glyphicon-calendar"></span>
					</span>
								</div>
							</div>
							<div class="form-inline" style="padding: 10px;">
							<label for="cashAccountEndTime">&nbsp;&nbsp;结&nbsp;束&nbsp;时&nbsp;间:</label> 
							<div class="input-group date" id="jieshukj">
								
								<input type="text"  name="strEnd"
									style="width: 143px" data-placement="top" class="form-control" placeholder="结束时间">
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
							</div>
							&nbsp;&nbsp;
							<div class="form-group">
								<label for="cashAccountDesc">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备&nbsp;用&nbsp;字&nbsp;段:</label> <input type="text"
									style="width: 180px" name="cashAccountDesc" data-placement="top"
									class="form-control" placeholder="备用字段">
							</div>
						</div>
						</div>
						
				
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
					</button>
					<button type="button" id="btnSave" class="btn btn-primary">
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
					</button>
				</div>
				</form>
				
			</div>
		</div>
	</div>

	</div>
</body>
</html>