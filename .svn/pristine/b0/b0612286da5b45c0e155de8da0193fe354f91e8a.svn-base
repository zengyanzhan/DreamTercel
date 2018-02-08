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
		<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
		<link href="../js/easyui/icons/icon-all.css" rel="stylesheet" type="text/css" />
		<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
		<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
		 <!--导入日期汉化包-->
		<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
        <script type="text/javascript" src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
        <link rel="stylesheet"  href="../css/bootstrap-datetimepicker.min.css"/>
<title>证券应收应付</title>
<script type="text/javascript">
		$(function(){
			$('#myTable').bootstrapTable({
				url:'',
				method:'get',//请求方式
				toolbar: '#toolbar',//工具栏
				striped: true, //是否显示行间隔色
				pagination: true, //是否显示分页（*）
				sortable: true, //是否启用排序
				sortOrder: "asc", //排序方式
				sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
				pageNumber: 1, //初始化加载第一页，默认第一页
				pageSize: 5, //每页的记录行数（*）
				pageList: [5, 10, 15, 20], //可供选择的每页的行数（*）
				showColumns: true, //是否显示 所有的列
				showRefresh: true, //是否显示刷新按钮
				minimumCountColumns: 2, //最少允许的列数
				clickToSelect: true, //是否启用点击选中行
				height: 348, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
				//uniqueId : "usrId", //每一行的唯一标识，一般为主键列
				showToggle: false, //是否显示详细视图和列表视图的切换按钮
				cardView: false, //是否显示详细视图
				detailView: false, //是否显示父子表
				//列字段
				columns: [{
					//复选框
					checkbox: true
				}, {
					field: 'sa_securityArapCode',
					title: '证券应收应付编号',
					//启用该字段的排序
					sortable: true
				}, {
					field: 'cashAccountCode',
					title: '账户ID号'
				},{
					field: 'fundCode',
					title: '基金代码'
				},{
					field: 'securityCode',
					title: '证券代码'
				},{
					field: 'sa_securityAparType',
					title: '证券应收应付类型'
				},{
					field: 'sa_moneyDirection',
					title: '资金流动方向'
				},{
					field: 'sa_money',
					title: '金额'
				},{
					field: 'sa_businessDate',
					title: '业务日期'
				},{
					field: 'sa_Desc',
					title: '备注'
				},]
			})
			//日期时间插件	
			$('#dateTest').datetimepicker({
				 language:'zh-CN',//显示中文
				 format:'yyyy-mm-dd',//格式化日期
				 minView:'month',//设置只显示到月份
				// initialDate:new Date(),//初始化当前日期
				 autoclose:true,//自动关闭\
				 todayBtn:true//显示今天按钮
			});
		});
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
				</button> &nbsp;&nbsp;
				 日期:
			<div class="input-group date" id="dateTest">
			 	<input type="text" class="form-control" >
			 	<span class="input-group-addon">
			 		<span class="glyphicon glyphicon-calendar"></span>
			 		
			 	</span>
			 </div>
				证券代码:
				
				<button type="button" style="margin-left: 30px" id="btnSearch" class="btn btn-info">查询</button>
			</div>
			
			<!--中间部分-->
			<div class="panel-body">
				<!--表格-->
				<table id="myTable"></table>
			</div>
		</div>
</body>
</html>