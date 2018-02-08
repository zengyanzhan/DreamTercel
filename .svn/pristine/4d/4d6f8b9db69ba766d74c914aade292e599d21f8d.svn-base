<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>TA库存</title>
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
		<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
		<link href="../js/easyui/icons/icon-all.css" rel="stylesheet" type="text/css" />
		<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
		<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
		<!--描述：导入日期插件包-->
        <script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
        <!--导入日期汉化包-->
        <script type="text/javascript" src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
       <link rel="stylesheet"  href="../css/bootstrap-datetimepicker.min.css"/>
       <script  type="text/javascript"  src="../js/TaStock.js"></script>
       <script src='../js/utils.js'></script>
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
			
			div .alert-content,
			div .alert-title,
			div .alert-btn-box,
			div .alert-btn-p {
				/* background-color:blue; */
				font-weight: bold;
			}
		</style>
		<script type="text/javascript">
			//屏蔽回车键 解决弹窗   回车无限弹的问题		
		</script>
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
				</button> &nbsp;&nbsp; <!--  基金编号:
				<input class="form-control" id="fundCodeWhere"  name="fundCodeWhere"/>--> 统计日期:
				 <div class="input-group date" id="dateTest">
		 			<input type="text" name="statisticDateWhere"class="form-control" id="statisticDateWhere" >
		 			<span class="input-group-addon">
		 				<span class="glyphicon glyphicon-calendar"></span>	
		 			</span>
		 		</div>
				<!-- <input class="form-control" id="taStock_statisticDate" /> -->
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
					<div class="modal-content" style="width:640px;height:430px">

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
										<label for="taStockCode">TA库存编号:</label>
										<input type="text" name="taStockCode" class="form-control" data-placement="top" placeholder="TA库存Code"  readonly="readonly">
									</div>
									&nbsp;&nbsp;
									<div class="form-group">
										<label for="fundCode">基金编号:</label> 
										<input type="text" id="combogridByusrRoleId" name="fundCode" data-placement="top" class="form-control"  readonly placeholder="基金编号" style="width:205px;height:38px"value="${fund.fundCode}">
									</div>
								</div>
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="taStockQuantity">TA&nbsp;&nbsp;&nbsp;数&nbsp;&nbsp;&nbsp;量:</label> 
										<input type="text" data-placement="top" name="taStockQuantity" class="form-control" 
												placeholder="TA数量"	style="width:180px;">
									</div>
									&nbsp;
									<div class="form-group">
										<label for="taStockMoney">T&nbsp;A&nbsp;金&nbsp;额:</label>
										<input type="text" name="taStockMoney" data-placement="top"
											 class="form-control" placeholder="TA金额" style="width:203px;height:38px">
									</div>
									</div>
									<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="statisticDate">日&nbsp;&nbsp;期&nbsp;&nbsp;统计:</label>
										
										<div class="input-group date" id="dateTest2">
		 							<input type="text"  id="strDate" name="strDate" class="form-control"  placeholder="日期统计" style="width:140px;height:38px"  >
		 								<span class="input-group-addon">
		 								<span class="glyphicon glyphicon-calendar"></span>	
		 						</span>
		 							</div>
		 									
									</div>		
									&nbsp;&nbsp;
									<div class="form-group">
										<label for="periodFlag">初始标志:</label>
										<select class="form-control"  name="periodFlag" style="width:205px" data-placement="top" placeholder="初始标志" style="width:180px">
											<option value="0"></option>
											<option value="1">是</option>
											<option value="2">不是</option>
											
								</select> 
									</div>
									</div>
									<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="taStockDesc">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</label>
										<input type="text" id="combogridByusrRoleId" name="taStockDesc" 
											data-placement="top" class="form-control" placeholder="备注" 
												style="width:470px;height:70px">
										
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