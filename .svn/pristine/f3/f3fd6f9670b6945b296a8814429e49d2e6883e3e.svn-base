<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权益处理</title>
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
		<!--
        	作者：www.981257477@qq.com
        	时间：2017-11-07
        	描述：导入Bootstrap下拉列表包
        -->
		<script type="text/javascript" src="../js/bootstrap-select.js"></script>
		<link rel="stylesheet"  href="../css/bootstrap.min.css"/>
		<!--
        	作者：www.981257477@qq.com
        	时间：2017-11-07
        	描述：导入日期插件包
        -->
        <script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
        <!--导入日期汉化包-->
        <script type="text/javascript" src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
       <link rel="stylesheet"  href="../css/bootstrap-datetimepicker.min.css"/>
		<!--引入弹窗插件的样式文件-->
		<link rel="stylesheet" href="../js/alert/alert.css">
		<!--引入弹窗插件的js文件-->
		<script src='../js/alert/alert.js'></script>
		
		<!-- easyui的js和css部分 -->
		<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
		<link href="../js/easyui/icons/icon-all.css" rel="stylesheet" type="text/css" />
		<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
		<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
		<script type="text/javascript" src="../js/interests.js"></script>
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
			
		</script>
</head>
<body>
		<div id="mianDiv">
			<!--工具栏-->
			<div id="toolbar" class="panel-heading form-inline">
				
				&nbsp;&nbsp;
				<label for="equityType" class="control-label">权益类型:</label>
				<select class="form-control" id="equityType" name="equityType" style="width:210px" data-placement="top" style="width:180px">
									<option ></option>
									<option value="1">分红</option>
									<option value="2">送股</option>
				</select>
			 	<label>除权日：</label>
				<!-- 写法见div -->
		 		<div class="input-group date" id=strDate>
		 			<input type="text" name="strDate" class="form-control" >
		 			<span class="input-group-addon">
		 			<span class="glyphicon glyphicon-calendar"></span>
		 			</span>
		 		</div>
				
				<!--增加按钮-->
				<button id="btnSearch" type="button" class="btn btn-info">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>未处理查询
				</button>
				<!--修改按钮-->
				<button id="btn_edit" type="button" class="btn btn-info">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>处理
				</button>
				
			</div>
			<ul id="myTab" class="nav nav-tabs">
				<li class="active"><a href="#home" data-toggle="tab">
				未处理</a></li>
				<li><a href="#ios" data-toggle="tab">已处理</a></li>

			</ul>
	
		
			<!--中间部分-->
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="home">
					<table id="chuLiTable"></table>
				</div>
				<div class="tab-pane fade" id="ios">
					<table id="weiChuLiTable"></table>
				</div>
			</div>
			
		</div>
</body>
</html>