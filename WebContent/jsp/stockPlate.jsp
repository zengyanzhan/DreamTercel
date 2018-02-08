<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
		<link rel="stylesheet" href=../css/bootstrapValidator.css />
		<!--引入表格的汉化文件-->
		<script src="../js/bootstrap-table-zh-CN.js"></script>

		<!--引入弹窗插件的样式文件-->
		<link rel="stylesheet" href="../js/alert/alert.css">
		<!--引入弹窗插件的js文件-->
		<script src='../js/alert/alert.js'></script>
		
		

		<!-- easyui的js和css部分 -->
		<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
		<link href="../js/easyui/icons/icon-all.css" rel="stylesheet" type="text/css" />
		<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
		<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
		
		
		<!-- 下拉列表 -->
		 <script type="text/javascript" src="../js/select/bootstrap-select.js"></script>
		<script type="text/javascript" src="../js/select/bootstrap-select.min.css"></script>
		
		<!--描述：导入日期插件包-->
        <script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
        <!--导入日期汉化包-->
        <script type="text/javascript" src="../js/zh_CN.js"></script>
       <link rel="stylesheet"  href="../css/bootstrap-datetimepicker.css"/>
       
       <!-- jquery包 -->
		<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../js/easyui/easyui-lang-zh_CN.js" ></script>
       
       <!-- js代码导入 -->
		<script type="text/javascript" src="../js/stockPlate.js"></script>
		<!-- 增删改查的按钮控制js代码 -->
		<script type="text/javascript" src="../js/utils.js"></script>
		
<title>股票板块信息设置网页</title>
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
			
			div .alert-content,
			div .alert-title,
			div .alert-btn-box,
			div .alert-btn-p {
				/* background-color:blue; */
				font-weight: bold;
			}
		</style>
	</head>

	<body>
		<!--整个界面-->
		<div id="mianDiv">
			<!--工具栏-->
			<div id="toolbar" class="panel-heading form-inline" style="padding:20px;">
				<!--增加按钮-->
				<button  type="button" class="btn btn-info btn_add" title="F">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增父功能
				</button>
				<!--增加按钮-->
				<button type="button" class="btn btn-info btn_add" title="D">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增子功能
				</button>
				<!--修改按钮-->
				<button id="btn_edit" type="button" class="btn btn-info">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改功能
				</button>
				<!--删除按钮-->
				<button id="btn_delete" type="button" class="btn btn-info">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除功能
				</button> &nbsp;&nbsp; &nbsp;&nbsp;股票板块编号:
				<input class="form-control" id="stockPlateCodes" />&nbsp;&nbsp;&nbsp;&nbsp;股票板块名称:
				<input class="form-control" id="stockPlateNames" />
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
					<div class="modal-content" style="width:640px;height:360px">

						<!--表单验证  -->
						<form class="form-signin required-validate"  method="post" id="myForm" >
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
								<h4 class="modal-title" id="myModalLabel">新增</h4>
							</div>
							<div class="modal-body">
								<!-- 表单 -->

								<div class="form-inline" style="padding: 15px;">
									<div class="form-group">
										<label for="stockBlockCode">股票板块编号:</label>
										<input type="text" name="stockBlockCode" class="form-control" 
										data-placement="top" placeholder="股票板块编号" readonly="readonly" id="stockBlockCode">
									</div>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<div class="form-group">
										<label for="stockBlockFatherCode">父板块编号:</label> 
										<select id="stockBlockFatherCode" name="stockBlockFatherCode"  class="form-control"  style="width: 165px">
										
										</select>
									</div>
								</div>
								<div class="form-inline" style="padding: 15px;">
									<div class="form-group">
										<label for="stockBlockName">股票板块名称:</label> 
											<input type="text" data-placement="top" name="stockBlockName" id="stockBlockName" 
												class="form-control" placeholder="股票板块名称" style="width:175px;">
									</div>
									<div class="form-inline" >
									<div class="form-group">
										<label for="bondDesc">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;注:</label> <textarea name="stockBlockDesc" data-placement="top" 
											class="form-control" placeholder="备注" style="width:465px;margin-top: 23px;resize:none"></textarea>
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

		</div>
	</body>

</html>