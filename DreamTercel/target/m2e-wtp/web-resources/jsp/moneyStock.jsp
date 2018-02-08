<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>现金库存</title>
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
					url: 'selectSysUser.action',
					method: 'get', //请求方式（*）
					toolbar: '#toolbar', //工具按钮用哪个容器
					striped: true, //是否显示行间隔色
					//cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
					pagination: true, //是否显示分页（*）
					sortable: true, //是否启用排序
					sortOrder: "asc", //排序方式
					queryParams: function(params) {
						var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
							rows: params.limit, //页面大小
							page: params.offset / params.limit + 1, //页码
							usrName: $("#usrName").val(), //查询的参数   写自己的控制类对应的名字
							usrFlag: $("#usrFlag").val(), //查询的参数
							sortName: this.sortName,
							sortOrder: this.sortOrder,
						};
						return temp;
					}, //传递参数（*）
					sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
					pageNumber: 1, //初始化加载第一页，默认第一页
					pageSize: 5, //每页的记录行数（*）
					pageList: [5, 10, 15, 20], //可供选择的每页的行数（*）
					showColumns: true, //是否显示所有的列
					showRefresh: true, //是否显示刷新按钮
					minimumCountColumns: 2, //最少允许的列数
					clickToSelect: true, //是否启用点击选中行
					height: 600, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
					//uniqueId : "usrId", //每一行的唯一标识，一般为主键列
					showToggle: false, //是否显示详细视图和列表视图的切换按钮
					cardView: false, //是否显示详细视图
					detailView: false, //是否显示父子表
					//列字段
					columns: [{
						//复选框
						checkbox: true
					}, {
						field: 'moneyStock_moneyStockCode',
						title: '现金库存编号',
						//启用该字段的排序
						sortable: true
					}, {
						field: 'moneyStock_fundCode',
						title: '基金姓名'
					}, {
						field: 'moneyStock_moneyBlance',
						title: '余额'
					}, {
						field: 'moneyStock_caskAccountCode',
						title: '现金账户名称'
					}, {
						field: 'moneyStock_statisticDate',
						title: '统计日期',
						/* formatter: function(value, row, index) {
							if (value == 0) {
								return "禁用";
							} else {
								return "启用";
							}
						} */
					},{
						field: 'moneyStock_periodFlag',
						title: '期初数据'
					},{
						field: 'moneyStock_desc',
						title: '备注'
					}]
				});
				//增加按钮点击事件
				$("#btn_add").click(function() {
					$("input[name=usrId]").val("");
					$("input[name=usrName]").val("");
					$("input[name=usrPassword]").val("");
					$("input[name=usrRoleId]").val("");
					$("input[name=usrFlag]").val("");
					$("#myForm").data("bootstrapValidator").resetForm();
					$("#myModalLabel").text("新增");
					$('#myModal').modal();
				});
				//删除按钮的点击事件
				$("#btn_delete").click(function() {
					//得到所有选中的行
					var allRows = $("#myTable").bootstrapTable('getSelections')
						//判断选中的行数
					if (allRows.length == 0) { //没选中任何行
						myAlert("请选中要删除的行");
					} else {
						//选中删除提示
						if (window.dialog3) {
							window.dialog3.destroy();
						};
						window.dialog3 = jqueryAlert({
							'title': '温馨提示',
							'content': '您确定要删除数据吗？',
							'modal': true, //是否显示模型窗口
							'className': 'alertDialog',
							'buttons': { //按钮
								'确定': function() {
									window.dialog3.destroy();
									//ajax操作   （发送请求到数据库删除）
								},
								'取消': function() {
									//销毁弹窗
									window.dialog3.destroy();
								}
							}
						});
					}
				});
				/* 修改的点击事件 */
				$("#btn_edit").click(function() {
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
						$("input[name=usrId]").val(oneRow.usrId);
						$("input[name=usrName]").val(oneRow.usrName);
						$("input[name=usrPassword]").val(oneRow.usrPassword);
						$('#combogridByusrRoleId').combogrid('setValue', oneRow.usrRoleId);
						$("input[name=usrFlag]").val(oneRow.usrFlag);
						//验证
						var $form = $("#myForm");
						var data = $form.data('bootstrapValidator');
						if (data) {
							// 修复记忆的组件不验证
							data.validate();
						}
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
						flag = 'insertSysUser';
					} else {
						flag = 'updateSysUser';
					}
					$('#myModal').modal("hide");
					//ajax发送请求
					$.ajax({
						type: "post",
						url: "" + flag + ".action",
						contentType: "application/x-www-form-urlencoded; charset=UTF-8",
						//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
						data: $("#myForm").serializeArray(),
						success: function(msgs) {
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
					feedbackIcons: {
						valid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
					},
					//列字段
					fields: {
						usrId: {
							//验证格式
							validators: {
								notEmpty: {
									message: '编号不能为空'
								},
							}
						},
						usrName: {
							message: '用户名验证失败',
							validators: {
								notEmpty: {
									message: '用户名不能为空'
								},
								stringLength: {
									min: 6,
									max: 18,
									message: '用户名长度必须在6到18位之间'
								},
								regexp: {
									regexp: /^[a-zA-Z0-9_]+$/,
									message: '用户名只能包含大写、小写、数字和下划线'
								}
							}
						},
						usrPassword: {
							validators: {
								notEmpty: {
									message: '邮箱不能为空'
								},
								stringLength: {
									min: 6,
									max: 16,
									message: '用户名长度必须在6到16位之间'
								},
								regexp: {
									regexp: /^[a-zA-Z0-9_]+$/,
									message: '用户名只能包含大写、小写、数字和下划线'
								}
							}
						},
						usrFlag: {
							validators: {
								notEmpty: {
									message: '请选择状态'
								}
							}
						}
					}
					//*****阻止表单的按钮提交
				}).on('success.form.bv', function(e) {
					//阻止默认事件提交
					e.preventDefault();
				});
				/* 下拉表格部分 */
				$('#combogridByusrRoleId').combogrid({
					panelWidth: 450, //表格宽度
					//panelHeight:500,//表格高度
					value: '', //输入的默认值（可写可不写）
					idField: 'userId', //传输的列  
					textField: 'userName', //显示的列
					fitColumns: true, //自动适应
					url: 'userServlet', //服务器请求路径
					mode: 'remote', //定义在文本改变的时候如何读取数据。设置为'remote'，
					//数据表格将从远程服务器加载数据。当设置为'remote'模式的时候
					//，用户输入将会发送到名为'q'的http请求参数，向服务器检索新的数据。
					pagination: true, //分页条
					pageSize: 5,
					pageList: [5, 10, 15, 20, 25],
					columns: [
						[ //表格列   
							{
								field: 'userId',
								title: '角色编号',
								width: 60
							}, {
								field: 'userName',
								title: '角色名称',
								width: 100
							}, {
								field: 'userPwd',
								title: '角色描述',
								width: 120
							},
						]
					]
				});
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
					'style': 'wap',
					//'modal':false,//添加整个屏幕的大背景
					'content': message, //显示内容 
					'animateType': 'linear', //弹框出现的方式 scale linear 其他为fadeIn动画
					'contentTextAlign': 'center', //设置content显示的位置 center left right
					'width': '300',
					//'height':'100',
					'minWidth': '160',
					'closeTime': 1000, //时间
					'className': 'alertDialog'
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
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				</button>
				<!--修改按钮-->
				<button id="btn_edit" type="button" class="btn btn-info">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
				</button>
				<!--删除按钮-->
				<button id="btn_delete" type="button" class="btn btn-info">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				</button> &nbsp;&nbsp; 用户名:
				<input class="form-control" id="usrName" /> 状态:
				<input class="form-control" id="usrFlag" />
				<button type="button" style="margin-left: 50px" id="btnSearch" class="btn btn-info">查询</button>
			</div>
			<!--中间部分-->
			<div class="panel-body">
				<!--表格-->
				<table id="myTable"></table>
			</div>
			<!--弹窗div-->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog " role="document">
					<div class="modal-content" style="width:640px;height:360px">

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
										<label for="moneyStockCode">现金库存编号:</label>
										<input type="text" name="moneyStockCode" class="form-control" data-placement="top" placeholder="现金库存编号">
									</div>
									&nbsp;&nbsp;
									<div class="form-group">
										<label for="fundCode">基金名称:</label> <input type="text" name="fundCode" data-placement="top" class="form-control" placeholder="基金编号">
									</div>
								</div>
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="moneyBlance">现金余额:</label> <input type="text" data-placement="top" name="moneyBlance" class="form-control" placeholder="现金余额">
									</div>
									&nbsp;&nbsp;
									<div class="form-group">
										<label for="caskAccountCode">现金库存:</label>
										<input type="text" id="combogridByusrRoleId" name="caskAccountCode" data-placement="top" class="form-control" placeholder="现金库存" style="width:210px;height:38px">
									</div>
								</div>
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="statisticDate">统计日期:</label> <input type="text" data-placement="top" name="statisticDate" class="form-control" placeholder="统计日期">
									</div>
									&nbsp;&nbsp;
									<div class="form-group">
										<label for="periodFlag">期初数据:</label>
										<input type="text" id="combogridByusrRoleId" name="periodFlag" data-placement="top" class="form-control" placeholder="期初数据" style="width:210px;height:38px">
									</div>
								</div>
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="desc">备注:</label> <input type="text" data-placement="top" name="desc" class="form-control" placeholder="统计日期">
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