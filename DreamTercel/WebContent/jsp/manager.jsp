<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
		<!--引入工具的js-->
		<script type="text/javascript" src="../js/utils.js"></script>
		<!--下拉列表css、js-->
		<script type="text/javascript" src="../js/select/bootstrap-select.js"></script>
		<link rel="stylesheet" href="../css/bootstrap.min.css" />
		<!--导入日期插件包-->
		<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
		<!--导入日期汉化包-->
		<script type="text/javascript" src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
		<link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />
		<!-- easyui的js和css部分 -->
		<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
		<link href="../js/easyui/icons/icon-all.css" rel="stylesheet" type="text/css" />
		<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
		<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
		

		<!--引入工具的js-->
		<script type="text/javascript" src="../js/utils.js"></script>
		<script type="text/javascript" src="../js/manager.js"></script>
<title>管理人信息表</title>

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
				</button> &nbsp;&nbsp; 管理人编号:
				<input class="form-control" id="managerCode" />&nbsp;&nbsp; 管理人姓名:
				<input class="form-control" id="managerName" />
				<button type="button" style="margin-left: 50px" id="btnSearch" class="btn btn-info">查询</button>
			</div>
			<!--中间部分-->
			<div class="panel-body">
				<!--表格-->
				<table id="myTable"></table>
			</div>
			<!--弹窗div-->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
				<div class="modal-dialog " role="document">
					<div class="modal-content" style="width:640px;height:500px">

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
									&nbsp;&nbsp;&nbsp;&nbsp;	
										<label for="managerCode">管理人编号&nbsp;:</label>
										<input type="text" name="managerCode" style="width: 172px; height:32px" readonly class="form-control" data-placement="top" placeholder="管理人ID">
									</div>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<div class="form-group">
										<label for="managerName">&nbsp;管理人名称&nbsp;:</label> <input type="text" name="managerName" style="width: 172px; height:32px" data-placement="top" class="form-control" placeholder="管理人名称">
									</div>
									
								</div>
								<!-- 第二行 -->
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group" >
										&nbsp;&nbsp;&nbsp;&nbsp;	
										<label for="managerAge" >管理人年龄&nbsp;:</label>
										<input id="managerAge" name="managerAge" class="form-control" style="width: 172px; height:32px" data-placement="top" placeholder="管理人年龄"/>
									</div>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<div class="form-group" >
										<label for="managerSex">管理人性别&nbsp;:</label>
											<select id="managerSex" name="managerSex" class="form-control" style="width:170px ;height:32px ">
										
										<option value="男">男</option>
										<option value="女">女</option>
							
										</select>
						
									</div>
								
								</div>
								
								<!-- 第三行 -->
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<label for="managerCompany">所在公司:</label>
										<input type="text" name="managerCompany" style="width: 172px; height:32px" class="form-control" data-placement="top" placeholder="所在公司">
									</div>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<div class="form-group">
										<label for="managerPhone">管理人电话:</label> <input type="text" name="managerPhone" style="width: 172px; height:32px" data-placement="top" class="form-control" placeholder="管理人电话">
									</div>
										&nbsp;&nbsp;
								</div>
								<!-- 第四行 -->
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<label for="managerFee">管理费&nbsp;:</label>
										<input type="text" name="managerFee" class="form-control" style="width: 172px; height:32px" data-placement="top" placeholder="管理费">
									</div>
									
								</div>
					
								<div class="form-inline" style="padding: 5px;">
								<div class="form-group">
									<label for="managerDesc">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备&nbsp;&nbsp;&nbsp;&nbsp;注&nbsp;:</label>
									<textarea id="managerDesc" name="managerDesc" class="form-control" placeholder="备注" style="width: 465px;height:90px;resize:none"></textarea>
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

		</div>
	</body>

</html>