<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
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
<!--导入日期插件包-->
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.css" />
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />
<script type="text/javascript">
	
</script>
<script src='../js/utils.js'></script>
<!-- easyui的js和css部分 -->
<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet"
	type="text/css" />
<link href="../js/easyui/icons/icon-all.css" rel="stylesheet"
	type="text/css" />
<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
<title>用户管理</title>
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
<script type="text/javascript">
	//屏蔽回车键 解决弹窗   回车无限弹的问题		
	document.addEventListener('keydown', function(e) {
		var a = e.keyCode;
		if ((a == 13)) { //回车
			if (e.preventDefault) {
				e.preventDefault();
				e.stopPropagation()
			} else {
				e.returnValue = false;
				e.cancelBubble = true
			}
			return false;
		}
	});
	//加载事件 
	$(function() {
		//加载表格
		$('#myTable').bootstrapTable({
			url : '../selectUser.action',
			method : 'get', //请求方式（*）
			contentType : 'application/json',
			toolbar : '#toolbar', //工具按钮用哪个容器
			striped : true, //是否显示行间隔色
			//cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, //是否显示分页（*）
			sortable : true, //是否启用排序
			sortOrder : "asc", //排序方式
			queryParams : function(params) {
				var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					rows : params.limit, //页面大小
					page : params.offset / params.limit + 1, //页码
					userName : $("#userName").val(), //查询的参数   写自己的控制类对应的名字
					createDate : $("#createDates").val(), //查询的参数
					sortName : this.sortName,
					sortOrder : this.sortOrder,
				};
				return temp;
			}, //传递参数（*）
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, //初始化加载第一页，默认第一页
			pageSize : 5, //每页的记录行数（*）
			pageList : [ 5, 10, 15, 20 ], //可供选择的每页的行数（*）
			showColumns : true, //是否显示所有的列
			showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 2, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行
			height : 600, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			//uniqueId : "usrId", //每一行的唯一标识，一般为主键列
			showToggle : false, //是否显示详细视图和列表视图的切换按钮
			cardView : false, //是否显示详细视图
			detailView : false, //是否显示父子表
			//列字段
			columns : [ {
				//复选框
				checkbox : true
			}, {
				field : 'userCode',
				title : '用户编号',
				//启用该字段的排序
				sortable : true
			}, {
				field : 'userName',
				title : '用户姓名'
			}, {
				field : 'userPwd',
				title : '密码'
			}, {
				field : 'createDate',
				title : '创建日期'
			}, {
				field : 'roleCode',
				title : '角色编号',
				
			}, {
				field : 'userFlag',
				title : '用户状态',
				formatter : function(value, row, index) {
					if (value == 1) {
						return "启用";
					} else {
						return "禁用";
					}
				}
			}, {
				field : 'userDesc',
				title : '备注字段',
			}, ]
		});
		//增加按钮点击事件
		$("#btn_add").click(function() {
			$.ajax({
				type : "post",
				url : "../autoUserBianhao.action",
				//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
				data : $("#myForm").serializeArray(),
				success : function(msgs) {
					$("input[name=userCode]").val(msgs);
				}
			});
			$("input[name=userCode]").val("");
			$("input[name=userName]").val("");
			$("input[name=userPwd]").val("");
			$("input[name=createDate]").val("");
			$("input[name=roleCode]").val("");
			$("input[name=userFlag]").val("");
			$("input[name=userDesc]").val("");
			$("#myForm").data("bootstrapValidator").resetForm();
			$("#myModalLabel").text("新增");
			$('#myModal').modal();
			$('#createDate').datetimepicker({
				//width :'170px',
				language : 'zh-CN',//显示中文
				format : 'yyyy-mm-dd',//格式化日期
				minView : 'month',//设置只显示到月份
				// initialDate:new Date(),//初始化当前日期
				autoclose : true,//自动关闭\
				todayBtn : true
			//显示今天按钮
			});

		});
		//删除按钮的点击事件
		$("#btn_delete").click(
				function() {
					//得到所有选中的行
					var allRows = $("#myTable").bootstrapTable('getSelections')
					//判断选中的行数
					if (allRows.length == 0) { //没选中任何行
						myAlert("请选中要删除的行");
					} else {
						//选中删除提示
						if (window.dialog3) {
							window.dialog3.destroy();
						}
						;
						window.dialog3 = jqueryAlert({
							'title' : '温馨提示',
							'content' : '您确定要删除数据吗？',
							'modal' : true, //是否显示模型窗口
							'className' : 'alertDialog',
							'buttons' : { //按钮
								'确定' : function() {
									window.dialog3.destroy();
									//ajax操作   （发送请求到数据库删除）
									var userCode = [];
									$.each(allRows,
											function(i, rows) {
												userCode.push("'"
														+ rows.userCode + "'");
											});
									$.ajax({
										type : "post",
										url : "../deleteUser.action?userCode="
												+ userCode,
										//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
										success : function(msgs) {
											//刷新表格
											$("#myTable").bootstrapTable(
													'refresh');
											//提示
											myAlert(msgs);
											//隐藏弹窗
										}
									});
								},
								'取消' : function() {
									//销毁弹窗
									window.dialog3.destroy();
								}
							}
						});
					}
				});
		/* 修改的点击事件 */
		$("#btn_edit").click(
				function() {
					//得到所有选中的行
					var allRows = $("#myTable").bootstrapTable('getSelections')
					//判断选中的行数
					if (allRows.length == 0) { //没选中任何行
						//调用弹窗
						myAlert("请选则要修改的数据");
						return;
					} else if (allRows.length > 1) {
						myAlert("只能选择一条数据进行修改");
						return;
					}
					//给文本框赋值
					$.each(allRows, function(i, oneRow) {
						//通过编号到数据库查询数据修改
						$.ajax({
							type : "post",
							url : "../selectOneUserByCode.action?userCode="
									+ oneRow.userCode,
							//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
							success : function(msg) {
								var msgs = eval('(' + msg + ')');
								$("input[name=userCode]").val(msgs.userCode);
								$("input[name=userName]").val(msgs.userName);
								$("input[name=userPwd]").val(msgs.userPwd);
								$("input[name=createDate]")
										.val(msgs.createDate);
								$("#combogridByusrRoleId").combogrid(
										'setValue', msgs.roleCode);
								$("input[name=userFlag]").val(msgs.userFlag);
								$("input[name=userDesc]").val(msgs.userDesc);
								//	$("#userDesc").text(msgs.userDesc);
								//验证
								var $form = $("#myForm");
								var data = $form.data('bootstrapValidator');
								if (data) {
									// 修复记忆的组件不验证
									data.validate();
								}

							}
						});

					});
					//将弹窗的标题改为修改
					$("#myModalLabel").text("修改");
					//弹窗窗口
					$('#myModal').modal();
				});
		/* 保存事件 */
		$("#btnSave").click(function() {
			//得到form表单
			var $form = $("#myForm");
			//进行表单验证
			var data = $form.data('bootstrapValidator');
			if (data) {
				// 修复记忆的组件不验证
				data.validate();
				if (!data.isValid()) {
					//验证不通过  阻止提交
					return;
				}
			}
			//得带弹窗的标题判断  是增加还是修改
			var title = $("#myModalLabel").text();
			var flag = '';
			if (title == '新增') {
				flag = 'insertUser';
			} else {
				flag = 'updateUser';
			}
			$('#myModal').modal("hide");
			//ajax发送请求
			$.ajax({
				type : "post",
				url : "../" + flag + ".action",
				data : $("#myForm").serializeArray(),
				success : function(msgs) {
					//刷新表格
					$("#myTable").bootstrapTable('refresh');
					//提示
					myAlert(msgs);
					//隐藏弹窗
					$('#myModal').modal("hide");
				}
			});
		});
		//查询按钮的事件
		$("#btnSearch").click(function() {
			$("#myTable").bootstrapTable('refresh');
		});
		//加载表单验证
		$("#myForm").bootstrapValidator({
			//图标集
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			//列字段
			fields : {
				userName : {
					message : '用户名验证失败',
					validators : {
						notEmpty : {
							message : '用户名不能为空'
						},
						regexp : {
							regexp : /^[a-zA-Z\u4e00-\u9fa5]+$/,
							message : '用户名称必须为中文,英文'
						},
					}
				},
				userPwd: {
					message: '密码验证失败',
					validators: {
						notEmpty: {
							message: '密码不能为空'
						},
						regexp: {
							regexp:  /^[a-z0-9A-Z]{6,16}$/,
							message: '密码长度必须是6到16位'
						},
					}
				},
				
			}
		//*****阻止表单的按钮提交
		}).on('success.form.bv', function(e) {
			//阻止默认事件提交
			e.preventDefault();
		});
		//角色表格下拉框
		$('#combogridByusrRoleId').combogrid({    
		    panelWidth:450,
		    idField:'roleCode',    
		    textField:'roleCode',  
		    pagination:true,
		    url:'../selectRole.action', 
		    mode: 'remote', //定义在文本改变的时候如何读取数据。设置为'remote'，
		    columns:[[    
		        {field:'roleCode',title:'角色编号',width:150},    
		        {field:'roleName',title:'角色名字',width:150},    
		        {field:'roleDepict',title:'角色描述',width:150}
		    ]]    
		});
		//日期时间插件	
		$('#dateTest').datetimepicker({
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//格式化日期
			minView : 'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期
			autoclose : true,//自动关闭
			todayBtn : true
		//显示今天按钮
		});
		var right = 'L0902';
		isHaveRight($("#btn_add"), $("#btn_edit"), $("#btn_delete"), right);
	});
	//定义提示弹窗的方法
	function myAlert(message) {
		//判断提示框是否存在
		if (window.dialog1) {
			//销毁以前的
			window.dialog1.destroy();
		}
		//新增提示
		window.dialog1 = jqueryAlert({
			//'title':'温馨提示', //弹框的标题 这里可以不用
			'style' : 'wap',
			//'modal':false,//添加整个屏幕的大背景
			'content' : message, //显示内容 
			'animateType' : 'linear', //弹框出现的方式 scale linear 其他为fadeIn动画
			'contentTextAlign' : 'center', //设置content显示的位置 center left right
			'width' : '300',
			//'height':'100',
			'minWidth' : '160',
			'closeTime' : 1000, //时间
			'className' : 'alertDialog'
		});
	}
</script>
</head>

<body>
	<!--整个界面-->
	<div id="mianDiv">
		<!--工具栏-->
		<div id="toolbar" class="panel-heading form-inline">
			<!--增加按钮-->
			<button id="btn_add" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>增加
			</button>
			<!--修改按钮-->
			<button id="btn_edit" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<!--删除按钮-->
			<button id="btn_delete" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			&nbsp;&nbsp; <label>用户姓名:</label><input class="form-control"
				id="userName" /> <label>创建时间：</label>
			<div class="input-group date" id="dateTest">
				<input type="text" class="form-control" id="createDates"
					 /> <span class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
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
			aria-labelledby="myModalLabel" data-backdrop="static">
			<div class="modal-dialog " role="document">
				<div class="modal-content" style="width: 640px; height: 430px">

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
									<label for="usrId">用户编号:</label> <input type="text"
										name="userCode" class="form-control" data-placement="top"
										readonly="readonly" placeholder="用户编号">
								</div>
								&nbsp;&nbsp;
								<div class="form-group">
									<label for="usrName">用户姓名:</label> <input type="text"
										name="userName" data-placement="top" class="form-control"
										placeholder="用户姓名" style="width:175px">
								</div>
							</div>
							<div class="form-inline" style="padding: 10px;">
								<div class="form-group">
									<label for="usrPassword">用户密码:</label> <input type="text"
										data-placement="top" name="userPwd" class="form-control"
										placeholder="用户密码" style="width:175px">
								</div>
								&nbsp;&nbsp;
								<div class="form-group">
									<label for="roleCode">角色编号:</label> <input type="text"
										id="combogridByusrRoleId" name="roleCode" data-placement="top"
										class="form-control" placeholder="角色编号"
										style="width: 180px; height: 38px">
								</div>
							</div>
							<div class="form-inline" style="padding: 10px;">
								<div class="form-group">
									<label for="usrFlag" class="control-label">用户状态:</label> <select
										class="form-control" name="userFlag" style="width: 175px"
										data-placement="top" style="width:160px">
										<option value="1">启用</option>
										<option value="0">禁用</option>
									</select>
								</div>
								&nbsp;&nbsp; <label>业务日期:</label>
								<div class="input-group date" id="createDates">
									<input type="text" id="createDate" name="createDate"
										class="form-control" style="width: 150px"> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>

							</div>
							<div class="form-inline" style="padding: 10px;">
								<label for="userDesc">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</label>
								<textarea id="userDesc" name="userDesc" class="form-control"
									placeholder="备注"
									style="width: 470px; height: 60px; margin-top: 30px; resize: none;"></textarea>
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" id="btnSave" class="btn btn-primary">
								<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
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

	</div>
</body>

</html>