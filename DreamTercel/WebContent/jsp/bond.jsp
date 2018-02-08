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
		<!-- 下拉列表 -->
		 <script type="text/javascript" src="../js/select/bootstrap-select.js"></script>
		<script type="text/javascript" src="../js/select/bootstrap-select.min.css"></script>
		
		

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
       
       <!-- js代码导入 -->
   		<script type="text/javascript" src="../js/bond.js"></script>
       	<!-- 增删改查的按钮管理js代码 -->
       	<script type="text/javascript" src="../js/utils.js"></script>
       	
    <title>债劵页面</title>
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
				</button> &nbsp;&nbsp; 债劵代码:
				<input class="form-control" id="bondCodes" /> 计息起始日:
			 	<div class="input-group date" id="dateTest">
		 			<input type="text" class="form-control"  id="strInterestStarDate">
		 			<span class="input-group-addon">
		 				<span class="glyphicon glyphicon-calendar"></span>
					</span>
		 		</div>
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
					<div class="modal-content" style="width:620px;height:550px">

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
										<label for="bondCode">债&nbsp;劵&nbsp;编&nbsp;号:</label>
									<div class="form-group">
										<input class="form-control" id="bondCode" name="bondCode" 
											style="width: 175px;" placeholder="债劵编号"/ readonly="readonly">
									</div>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<div class="form-group">
										<label for="bondName">债&nbsp;劵&nbsp;名&nbsp;称:</label>
										 	<input type="text" name="bondName" data-placement="top" 
										 		class="form-control" placeholder="债劵名称" style="width:175px;">
									</div>
								</div>
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="interestStarDdte">计息起始日:</label>
										<div class="input-group date" id="startDate">
		 									<input type="text" class="form-control"  style="width:135px;" name="strInterestStarDate">
		 										<span class="input-group-addon">
		 											<span class="glyphicon glyphicon-calendar"></span>
												</span>
		 							</div>
									</div>
 									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<div class="form-group">
										<label for="interestEndDate">计息结束日:</label>
										<div class="input-group date" id="endDate">
		 									<input type="text" class="form-control"  style="width:135px;" name="strInterestEndDate">
		 										<span class="input-group-addon">
		 											<span class="glyphicon glyphicon-calendar"></span>
												</span>
		 							</div>									
		 						</div>
								</div>
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="bondType">债&nbsp;劵&nbsp;类&nbsp;型:</label>
										<select class="form-control" name="bondType" style="width:175px;height:35px;">
											<option>—— 请选择 ——</option>
											<option value="1">银行间</option>
											<option value="2">非银行间</option>
										</select>											
									</div>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<div class="form-group">
										<label for="couponRate">票&nbsp;面&nbsp;利&nbsp;率:</label> 
											<input type="text" name="couponRate" data-placement="top" 
											class="form-control" placeholder="票面利率" style="width:175px;">
									</div>
								</div>
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="bondInterest">债&nbsp;劵&nbsp;利&nbsp;息:</label>
											<input type="text" name="bondInterest" class="form-control" 
												data-placement="top" placeholder="债劵利息" style="width:175px;">
									</div>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<div class="form-group">
										<label for="couponMoney">票&nbsp;面&nbsp;金&nbsp;额:</label>
											<input type="text" name="couponMoney" data-placement="top" 
												class="form-control" placeholder="票面金额" style="width:175px;">
									</div>
								</div>
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="paymentCount">付&nbsp;息&nbsp;次&nbsp;数:</label>
										<select class="form-control" name="paymentCount" style="width:175px;height:35px;">
											<option>—— 请选择 ——</option>
											<option value="1">一年一次</option>
											<option value="2">一年两次</option>
										</select>	
									</div>
								<div class="form-inline" >
									<div class="form-group">
										<label for="bondDesc">备&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</label> <textarea name="bondDesc" 
										data-placement="top" class="form-control" placeholder="备注" style="width:470px;margin-top: 23px;resize:none"></textarea>
									</div>
								</div>
							</div>
							<div class="modal-footer">
							<button type="button"   id="btnSave" class="btn btn-primary">
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