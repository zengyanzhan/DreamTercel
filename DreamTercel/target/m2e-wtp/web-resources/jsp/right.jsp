<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模块管理</title>
<!-- 导入bootstrap组件 -->
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap.css">
<!--引入表单的验证文件-->
<script type="text/javascript" src="../js/bootstrapValidator.js"></script>
<!-- 引入表单验证 的css文件-->
<link rel="stylesheet" href="../css/bootstrapValidator.css" />
<!-- 导入easyui组件 -->
<link rel="stylesheet" href="../js/easyui/ui-sunny/easyui.css" />
<link rel="stylesheet" href="../js/easyui/icons/icon-all.css" />
<script src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/modernizr.js"></script>
<script type="text/javascript" src="../js/select/bootstrap-select.js"></script>
<!--引入弹窗插件的样式文件-->
<link rel="stylesheet" href="../js/alert/alert.css">
<!--引入弹窗插件的js文件-->
<script src='../js/alert/alert.js'></script>
<script type="text/javascript" src="../js/utils.js"></script>
<!-- 导入message.js -->
<script type="text/javascript" src="../js/message/message.js"></script>
<link type="text/css" href="../js/message/message.css" />
<script type="text/javascript">
	$(function() {
		var flag = '增加,修改,删除';//标志
		$('#myTable')
				.treegrid(
						{
							url : '../selectRight.action',
							method : 'get',
							contentType : 'application/json',
							width : '100%',
							height : 510,
							idField : 'rightCode',
							treeField : 'rightCode',
							animate : true,//定义在节点展开或折叠的时候是否显示动画效果。
							fitColumns : true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
							title : '功能信息',
							columns : [ [
									{
										checkbox : true
									},
									{
										title : '功能编号',
										field : 'rightCode',
										width : 150,
										align : 'center',
										formatter : function(value, row, index) {
											return '<span style="font-size:20px;color:gray; ">'
													+ value + '</span>';//改变表格中内容字体的大小
										}
									},
									{
										title : '功能名称',
										field : 'rightText',
										width : 100,
										align : 'center',
										formatter : function(value, row, index) {
											return '<span style="font-size:20px;color:gray; ">'
													+ value + '</span>';//改变表格中内容字体的大小
										}
									},
									{
										title : '功能类别',
										field : 'rightType',
										width : 100,
										align : 'center',
										formatter : function(value, row, index) {
											return '<span style="font-size:20px;color:gray; ">'
													+ value + '</span>';//改变表格中内容字体的大小
										}
									},
									{
										title : '功能链接',
										field : 'rightUrl',
										width : 100,
										align : 'center',
										formatter : function(value, row, index) {
											if (value == null || value == '') {
												return '<span style="font-size:20px;color:gray; ">暂无</span>';
											}
											return '<span style="font-size:20px;color:gray; ">'
													+ value + '</span>';
											//改变表格中内容字体的大小
										}
									},
									{
										title : '功能图标名',
										field : 'rightIcon',
										formatter : function(value, row, index) {
											if (value == '' || value == null) {
												return '<span style="font-size:20px;color:gray; ">暂无</span>';
											} else {
												return '<span style="font-size:20px;color:gray; ">'
														+ value + '</span>';
											}
										}
									} ] ],
							//表格操作方法
							singleSelect : false,
							collapsible : true,//可以折叠
							minimizable : false,//添加最小化按钮
							maximizable : false,// 添加最大话按钮
							rownumbers : true,//如果为true，则显示一个行号列
							striped : true,//是否显示斑马线效果。
							pagination : true,//如果为true，则在DataGrid控件底部显示分页工具栏。
							pageSize : 10,//在设置分页属性的时候初始化页面大小。
							pageList : [ 10, 20, 30, 40 ],//在设置分页属性的时候 初始化页面大小选择列表。
							pageNumber : 1,//在设置分页属性的时候初始化页码
						});
		//加载下拉列表
		/* $('#rightParentCode').bootstrapSelect({
			//data:[{id:1,text:'lzx'},{id:2,text:'lsl'}],
			url:'../selectRightCodeByType.action',
			downBorder:true,
			multiple:false,//多选
			onSelect:function(val,rec){
					alert("val="+val+", rec"+rec);
			}
		});  */
		$
				.post(
						'../selectRightCodeByType.action?rightType=Document&rightParentCode=',
						null, function(msg) {
							var message = eval("(" + msg + ")");
							var data = document
									.getElementById("rightParentCode");
							data.innerHTML = '';
							for (var i = 0; i < message.length; i++) {
								var right = message[i];
								var opt = new Option(right.rightText,
										right.rightCode);
								data.appendChild(opt);
							}
						})
		//增加
		$("#btn_add").click(function() {
			if (flag.indexOf('增加') != -1) {
				$("#myModalLabel").text("新增功能");
				$("#myModal").modal();
			} else {
				myAlert("正在进行" + flag + "操作,请稍候操作");
			}
		})
		//修改
		$("#btn_edit").click(function() {
			if (flag.indexOf('修改') != -1) {
				var allRows = $("#myTable").datagrid('getSelections');
				alert(allRows.length);
				if (allRows.length == 0) {
					myAlert("请选中要修改的行");
					return;
				} else if (allRows.length > 1) {
					myAlert("请选择一行修改");
					return;
				}
				//循环
				$.each(allRows, function(i, v) {
					$("input[name=rightCode]").val(v.rightCode);
					$("input[name=rightText]").val(v.rightText);
					$("select[name=rightType]").val(v.rightType);
					$("input[name=rightUrl]").val(v.rightUrl);
					$("select[name=rightParentCode]").val(v.rightParentCode);
					$("input[name=rightIcon]").val(v.rightIcon);
				})
				$("#myModalLabel").text("修改功能");
				$("input[name=rightText]").attr("readonly", false);
				$("input[name=rightUrl]").attr("readonly", false);
				$("input[name=rightIcon]").attr("readonly", false);
				$("select[name=rightType]").attr("disabled", true);
				$("#myModal").modal();
			} else {
				myAlert("正在进行" + flag + "操作,请稍候操作");
			}
		})
		$("#btn_delete")
				.click(
						function() {
							//alert("删除" + flag + flag.indexOf('删除'));
							if (flag.indexOf("删除") != -1) {
								//得到所有选中的行
								var allRows = $("#myTable").datagrid(
										'getSelections')
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
												var codes = [];//功能编号
												$
														.each(
																allRows,
																function(i, v) {
																	codes
																			.push("'"
																					+ v.rightCode
																					+ "'");
																})
												//alert(codes);
												$
														.ajax({
															type : "post",
															url : "../deleteRight.action",
															contentType : "application/x-www-form-urlencoded; charset=UTF-8",
															//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
															data : 'rightCode='
																	+ codes,
															success : function(
																	msgs) {
																//刷新表格
																$("#myTable")
																		.treegrid(
																				'reload');
																//提示
																myAlert(msgs);
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
							} else {
								myAlert("正在进行" + flag + "操作,请稍候操作");
							}
						});
		//加载表单验证
		$("#myForm")
				.bootstrapValidator(
						{
							//图标集
							feedbackIcons : {
								valid : 'glyphicon glyphicon-ok',
								invalid : 'glyphicon glyphicon-remove',
								validating : 'glyphicon glyphicon-refresh'
							},
							//列字段
							fields : {
								rightCode : {
									//验证格式
									validators : {
										notEmpty : {
											message : '功能编号不能为空'
										},
									}
								},
								rightText : {
									//验证格式
									validators : {
										notEmpty : {
											message : '功能名称不能为空'
										},
									}
								},
								rightType : {
									validators : {
										notEmpty : {
											message : '功能类型不能为空'
										},
									}
								},
								rightParentCode : {
									validators : {
										notEmpty : {
											message : '父功能编号不能为空'
										}
									}
								},
							},
							submitHandler : function(validator, form,
									submitButton) {
								//判断是否是新增和修改
								var title = $("#myModalLabel").text();
								var flag = '';
								if (title.substr(0, 2) == '新增') {
									flag = 'insertRight';
								} else {
									flag = 'updateRight';
								}
								//这里可以进行ajax传输数据  form.serializeArray() or .serialize() 得到表单的数据
								$
										.ajax({
											type : "post",
											url : "../" + flag + ".action",
											contentType : "application/x-www-form-urlencoded; charset=UTF-8",
											//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
											data : form.serializeArray(),
											success : function(msgs) {
												//alert(msgs);
												//刷新表格
												$("#myTable")
														.treegrid('reload');
												//隐藏弹窗s
												$('#myModal').modal("hide");
												$("select[name=rightType]")
														.attr("disabled", false);
												test();//清除数据
												//提示
												myAlert(msgs);
											}
										});
							}
						//*****阻止表单的按钮提交
						});
		$("input[name=rightText]").attr("readonly", "true");
		$("input[name=rightUrl]").attr("readonly", "true");
		$("input[name=rightIcon]").attr("readonly", "true");
		$("select[name=rightParentCode]").attr("disabled", true);
		$("select[name=rightType]").attr("disabled", false);
		$("select[name=rightType]").change(
				function() {
					var flag = '';
					var parentCode = '';
					if ($(this).val() == 'Folder') {//父功能
						flag = 'Folder';
						parentCode = 'one';
					} else {//子功能
						flag = 'Document';
						$("select[name=rightParentCode]").attr("disabled",
								false);
					}
					alert(flag);
					//发送请求，然后添加到文本框
					$.post('../selectRightCodeByType.action?rightType=' + flag
							+ '&rightParentCode=' + parentCode, null, function(
							msg) {
						if (msg.indexOf("FolderL") != -1) {
							$("input[name=rightCode]").val(msg.substr(6));
						} else {
							var message = eval("(" + msg + ")");
							var data = document
									.getElementById("rightParentCode");
							data.innerHTML = '';
							for (var i = 0; i < message.length; i++) {
								var right = message[i];
								var opt = new Option(right.rightText,
										right.rightCode);
								data.appendChild(opt);
							}
						}
					})
					$("input[name=rightText]").attr("readonly", false);
					$("input[name=rightUrl]").attr("readonly", false);
					$("input[name=rightIcon]").attr("readonly", false);
				})
		//当选择的父功能发生变化的时候 就会自动生成编号
		$("select[name=rightParentCode]").change(
				function() {
					$.post(
							'../selectRightCodeByType.action?rightType=Document&rightParentCode='
									+ $(this).val(), null, function(msg) {
								$("input[name=rightCode]").val(msg);
							})
				})
		//清除数据
		$(".del").click(function() {
			test();
		})
		//查询
		$("#btn_search").click(
				function() {
					 $("#myTable").treegrid(
							'load',
							{
								rightCode:$("input[name=rightCodes]").val(),
							    rightText:$("input[name=rightTexts]").val()
							}); 
							//alert($("input[name=rightCodes]").val()+","+$("input[name=rightTexts]").val());
							$("input[name=rightCodes]").val('');
							$("input[name=rightTexts]").val('');
				})
		isHaveRight($("#btn_add", $("#btn_edit"), $("#btn_delete"), 'L0904'));
	});
	//clear data
	function test() {
		$(".form-control").val("");
		$("#myForm").data("bootstrapValidator").resetForm();
		$('.form-control').tooltip('destroy');
		$("input[name=rightText]").attr("readonly", "true");
		$("input[name=rightUrl]").attr("readonly", "true");
		$("input[name=rightIcon]").attr("readonly", "true");
		$("select[name=rightParentCode]").attr("disabled", true);
		$("select[name=rightType]").attr("disabled", false);
	}
</script>
</head>
<body>
	<div class="form-inline" style="height: 80px; line-height: 80px;">
		<label style="width: 20px"></label>
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
		&nbsp;&nbsp;
		<label for="rightCodes">功能编号:</label><input
			type="text" name="rightCodes" class="form-control" placeholder="功能编号" />
		<label for="rightTexts">功能名称:</label> <input
			type="text" name="rightTexts" class="form-control" placeholder="功能名称" />
		<button id="btn_search" type="button" class="btn btn-info">
			<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
		</button>
	</div>
	<table id="myTable"></table>
	<!--弹窗div-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog " role="document">
			<div class="modal-content" style="width: 700px;">
				<!--表单验证  -->
				<form class="form-signin required-validate" action="#" method="post"
					id="myForm">
					<div class="modal-header">
						<button type="button" class="close del" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">新增</h4>
					</div>
					<div class="modal-body" style="height: 270px">
						<!-- 表单 -->
						<div class="form-inline" style="padding:10px; height: 55px">
							<div class="form-group">
								<label for="rightCode" style="width: 80px; text-align: right">功能编号:</label>
								<input type="text" name="rightCode" class="form-control"
									placeholder="功能编号" readonly />
							</div>
							<label style="width:50px"></label>
							<div class="form-group">
								<label for="rightText" style="width:80px; text-align: right">功能名称:</label><input
									type="text" id="rightText" name="rightText"
									class="form-control" placeholder="功能名称" />
							</div>
						</div>

						<div class="form-inline" style="padding: 10px; height: 55px">
							<div class="form-group">
								<label for="rightParentCode"
									style="width: 80px; text-align: right">父功能:</label> <select
									type="text" id="rightParentCode" name="rightParentCode"
									class="form-control" style="width: 210px;">
									<option value="">父功能</option>
								</select>
							</div>
							<label style="width: 50px"></label>
							<div class="form-group">
								<label for="rightType" style="width: 80px; text-align: right">功能类型:</label><select
									type="text" name="rightType" class="form-control"
									placeholder="功能类型" style="width: 210px;">
									<option value="">功能类型</option>
									<option value="Folder">父功能</option>
									<option value="Document">子功能</option>
								</select>
							</div>
						</div>

						<div class="form-inline" style="padding: 10px; height: 55px">
							<div class="form-group">
								<div class="form-group">
									<label for="rightIcon" style="width: 80px; text-align: right">功能图标名:</label><input
										type="text" id="rightIcon" name="rightIcon"
										class="form-control" placeholder="功能图标名"
										style="width: 210px; height: 35px;" />
								</div>
							</div>
							<div class="form-group">
								<label for="rightUrl" style="width: 135px; text-align: right">功能链接:</label>
								<input type="text" name="rightUrl" class="form-control"
									placeholder="功能链接" style="width: 210px;" />
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">
							<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
						</button>
						<button type="button" class="btn btn-default del"
							data-dismiss="modal">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>