<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>现金应收应付库存</title>
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
	<script src='../js/utils.js'></script>
	<!--导入日期插件包-->
    <script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
    <!--导入日期汉化包-->
    <script type="text/javascript" src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
    <link rel="stylesheet"  href="../css/bootstrap-datetimepicker.min.css"/>
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
	<script type="text/javascript" src="../js/moneyArapStock.js">
	</script>

</head>
<body>
	<!--整个界面-->
	<div id="mianDiv">
		<!--工具栏-->
		<div id="toolbar" class="panel-heading form-inline">
			<!--增加按钮-->
			<button id="btn_add" type="button" class="btn btn-info"  disabled>
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			是否为期初标志：<input type="checkbox" id="checkboxChange" name="checkboxChange"/>
			<!--修改按钮-->
			<button id="btn_edit" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<!--删除按钮-->
			<button id="btn_delete" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			&nbsp;&nbsp; 业务日期:
			<!-- 时间插件 -->
			<div class="input-group date" id="selectDate">
			 	<input type="text" class="form-control" id="businessDateWhere">
			 	<span class="input-group-addon">
			 		<span class="glyphicon glyphicon-calendar"></span>
			 	</span>
		 	</div>
			<button type="button" style="margin-left: 50px" id="btnSearch"class="btn btn-info">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
			</button>
		</div>

		<!--中间部分-->
		<div class="panel-body">
			<!--表格-->
			<table id="myTable"></table>
		</div>
		
		<!--弹窗div-->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  data-backdrop="static">
				<div class="modal-dialog " role="document"  >
					<div class="modal-content" style="width:700px;height:500px">

						<!--表单验证  -->
						<form class="form-signin required-validate" action="/insertSysUser.action" method="post" id="myForm" onsubmit="return insertSysUser(this)">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">新增</h4>
							</div>
							<div class="modal-body">
								<!-- 表单 -->
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="usrId">编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;&nbsp;:</label>
										&nbsp;&nbsp;&nbsp;
										<input type="text" id="cashArapStockCode" name="cashArapStockCode" class="form-control" data-placement="top" readonly="readonly" style="width:180px;height:34px">
									</div>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									
									<div class="form-group">
										<label for="fundCode">基&nbsp;金&nbsp;代&nbsp;码&nbsp;&nbsp;:</label> 
										&nbsp;&nbsp;&nbsp; 
										<input type="text" name="fundCode" id="fundCode" class="form-control" placeholder="基金编号" value="${fund.fundCode}" style="width:180px;height:34px" readonly />
									</div>
								</div>
								
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="usrName">账&nbsp;户&nbsp;编&nbsp;号&nbsp;&nbsp;:</label> 
										&nbsp;&nbsp;&nbsp;
										<input type="text" id="cashAccountCode" name="cashAccountCode" value="${fund.cashAccountCode}" data-placement="top" style="width:180px;height:34px" class="form-control" placeholder="现金账户编号" style="width:176px;height:34px">
									</div>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<div class="form-group">
										<label for="usrFlag" class="control-label">期&nbsp;初&nbsp;标&nbsp;志&nbsp;&nbsp;:</label>
										&nbsp;&nbsp;&nbsp;
										<select class="form-control" name="periodFlag" id="periodFlag"  data-placement="top" style="width:180px;height:34px" >
											<option value="">— — 请选择 — —</option>
											<option value="1" >是</option>
											<option value="2" selected>不是</option>
										</select>
									</div>
								</div>
								
								<div class="form-inline" style="padding: 10px;">
								
								<div class="form-group">
										<label for="usrFlag" class="control-label">业&nbsp;务&nbsp;类&nbsp;型&nbsp;&nbsp;:</label>
										&nbsp;&nbsp;&nbsp;
										<select class="form-control" name="businessType"  id="businessType" data-placement="top" style="width:180px;height:34px">
											<option value="">— — 请选择 — —</option>
											<option value="1">管理费</option>
											<option value="2">托管费</option>
											<option value="3">存款利息</option>
											<option value="4">申购赎回费</option>
										</select>
									</div>
									
									
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<div class="form-group">
										<label for="usrFlag" class="control-label">业&nbsp;务&nbsp;状&nbsp;态&nbsp;&nbsp;:</label>
										&nbsp;&nbsp;&nbsp;
										<select class="form-control" id="status" name="status" style="width:180px;height:34px"  data-placement="top" style="width:176px;height:34px">
											<option value="">— — 请选择 — —</option>
											<option value="1">应收</option>
											<option value="-1">应付</option>
										</select>
									</div>
								</div>
								
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="usrPassword">业&nbsp;务&nbsp;日&nbsp;期&nbsp;&nbsp;:</label> 
										&nbsp;&nbsp;&nbsp;
										<!-- 事件插件 -->
										<div class="input-group date" id="insertDate" style="width:180px;height:34px">
										 	<input type="text" class="form-control" id="strDate" name="strDate">
										 	<span class="input-group-addon">
										 		<span class="glyphicon glyphicon-calendar"></span>
										 	</span>
									 	</div>
									</div>
									
									
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									
									<div class="form-group">
										<label for="usrRoleId">总&nbsp;&nbsp;&nbsp;金&nbsp;&nbsp;&nbsp;额&nbsp;&nbsp;:</label>
										&nbsp;&nbsp;&nbsp;
										<input type="text" name="totalMoney" data-placement="top" class="form-control" style="width:180px;height:34px" placeholder="总金额" >
									</div>
								</div>
								
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="usrFlag" class="control-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注&nbsp;&nbsp;:</label>
										&nbsp;&nbsp;&nbsp;
										<textarea name="cashArapStockDesc" id="cashArapStockDesc"  data-placement="top" class="form-control" placeholder="请输入备注字段(可写可不写)" style="resize:none; width: 545px" ></textarea>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" id="btnSave" class="btn btn-primary">
									<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
								</button>
								<button type="button" class="btn btn-default " data-dismiss="modal">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		
		
		
	</div>
</body>
</html>