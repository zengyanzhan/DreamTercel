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
<!-- 下拉列表 -->
		 <script type="text/javascript" src="../js/select/bootstrap-select.js"></script>
		<script type="text/javascript" src="../js/select/bootstrap-select.min.css"></script>
		


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
       <link rel="stylesheet"  href="../css/bootstrap-datetimepicker.css"/>
       
       <!-- js代码导入 -->
       <script type="text/javascript" src="../js/security.js"></script>
       <!-- 增删改查的按钮管理js代码 -->
       <script type="text/javascript" src="../js/utils.js"></script>
       
<title>证劵信息设置</title>
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
			<div id="toolbar" class="panel-heading form-inline" >
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
				<button id="securityButInput" type="button" class="btn btn-info">
						<span class="glyphicon glyphicon-import" aria-hidden="true">  </span> 证劵信息数据导入
					</button>
				 &nbsp;&nbsp; 证劵编号:
				<input class="form-control" id="securityCodes" /> 发行日期:
			 	<div class="input-group date" id="dateTest">
		 			<input type="text" class="form-control"  id="publishDates" name="publishDate">
		 			<span class="input-group-addon">
		 				<span class="glyphicon glyphicon-calendar"></span>
					</span>
		 		</div>
				<button type="button" style="margin-left: 50px" id="btnSearch" class="btn btn-info">查询</button>
			</div>
			<!--中间部分-->
			<div class="panel-body" >
				<!--表格-->
				<table id="myTable"></table>
			</div>
			<!--弹窗div-->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
				<div class="modal-dialog " role="document">
					<div class="modal-content" style="width:620px;height:500px">

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

								<div class="form-inline" style="padding: 13px;">
									<div class="form-group">
										<label for="securityCode">证&nbsp;劵&nbsp;编&nbsp;号&nbsp;:</label>
										<input type="text" name="securityCode" class="form-control" 
											data-placement="top" placeholder="证劵编号" style="width:175px;" id="securityCode">
									</div>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<div class="form-group">
										<label for="securityName">证&nbsp;劵&nbsp;名&nbsp;称&nbsp;:</label> 
										<input type="text" name="securityName" data-placement="top" 
											class="form-control" placeholder="证劵名称" style="width:175px;">
									</div>
								</div>
								<div class="form-inline" style="padding: 13px;">
									<div class="form-group">
										<label for="publishDate">发&nbsp;行&nbsp;日&nbsp;期&nbsp;:</label>
										<div class="input-group date" id="publishDate">
		 									<input type="text" class="form-control"  style="width:135px;"  name="publishDates" id="publishDate">
		 										<span class="input-group-addon">
		 											<span class="glyphicon glyphicon-calendar"></span>
												</span>
		 							</div>
									</div>
 									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<div class="form-group">
										<label for="delayDate">延&nbsp;迟&nbsp;日&nbsp;期&nbsp;:</label>
										<div class="input-group date" id="delayDate">
		 									<input type="text" class="form-control"  style="width:135px;" name="delayDates" id="delayDate">
		 										<span class="input-group-addon">
		 											<span class="glyphicon glyphicon-calendar"></span>
												</span>
		 							</div>									
		 						</div>
								</div>
								<div class="form-inline" style="padding: 13px;">
									<div class="form-group">
										<label for="securityType">证&nbsp;劵&nbsp;类&nbsp;型&nbsp;:</label>
										<select class="form-control"   id="securityType" name="securityType" style="width:175px;height:35px;">
											<option value="0">—— 请选择 ——</option>
											<option value="1">股票</option>
											<option value="2">债劵</option>
										</select>	
									</div>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<div class="form-group">
										<label for="exchangeName">交易所名称:</label> 
										<select class="form-control" name="exchangeName" style="width:175px;height:35px;">
											<option value="0">—— 请选择 ——</option>
											<option value="1">上交所</option>
											<option value="2">深交所</option>
										</select>	
								</div>
								</div>
								<div class="form-inline"  style="padding: 13px;width: 588px">
								<label for="stockPlateCode">板&nbsp;块&nbsp;分&nbsp;类&nbsp;:</label>
									<div class="form-group" >
									
										<span id="a">
												<input  name="stockPlateCode" id="stockPlateCode" style="width: 175px;height: 34px" class="form-control " data-placement="top" placeholder="板块名称">
								</span>
								<span id="b">
									<input  name="stockPlateCode" id="stockPlateCodes" class="form-control "   data-placement="top" disabled="disabled">
								</span>
										
									</div>
									
									
									&nbsp;&nbsp;
								<div class="form-inline" >
									<div class="form-group">
										<label for="securityDesc">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</label> 
									<textarea name="securityDesc" data-placement="top" class="form-control" placeholder="备注" style="width:480px;margin-top: 23px;resize:none"></textarea>
									</div>
								</div>
							</div>
							<div class="modal-footer">
							<button type="submit" id="btnSave" class="btn btn-primary">
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
		
		<form  action="../securityReadExcel.action" method="post" enctype="multipart/form-data" >
		<!--数据导入弹窗div-->
		<div class="modal fade" id="securityInput" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog " role="document">
				<div class="modal-content" style="width:570px;height:310px">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
						<h4 class="modal-title" id="myModalLabels">证券信息数据导入</h4>
					</div>
					<div class="modal-body" style="height:150px;">
						<span style="font-size:15px;font-weight: bold;">请选择需要的文件：</span><input type="file" name="file" size="15" style="margin-left: 160px ;margin-top: 15px;" />
					</div>
					<div class="modal-footer">
						<button type="submit" id="btnInput" class="btn btn-primary">
							<span class="glyphicon glyphicon-import" aria-hidden="true"></span>导入
						</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
						</button>
					</div>
				</div>
			</div>
		</div>
		</form>
</body>
</html>