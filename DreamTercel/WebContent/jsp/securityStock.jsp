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

<!--导入日期插件包-->
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.css" />
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
<!-- 导入select -->
<script type="text/javascript" src="../js/select/bootstrap-select.js"></script>
<link rel="stylesheet" href="../js/select/bootstrap-select.min.css" />
<script type="text/javascript" src="../js/utils.js"></script>
<!--引入弹窗插件的样式文件-->
<link rel="stylesheet" href="../js/alert/alert.css">
<!--引入弹窗插件的js文件-->
<script src='../js/alert/alert.js'></script>
<!--导入message.js-->
<script type="text/javascript" src="../js/message/message.js"></script>
<link rel="stylesheet" href="../js/message/message.css" />
<!-- easyui的js和css部分 -->
<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet"
	type="text/css" />
<link href="../js/easyui/icons/icon-all.css" rel="stylesheet"
	type="text/css" />
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
		$('#myTable').bootstrapTable(
				{
					url : '../selectSecurityStock.action',
					method : 'get', //请求方式（*）
					contentType : 'application/json',
					toolbar : '#toolbar', //工具按钮用哪个容器
					striped : true, //是否显示行间隔色
					//cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
					pagination : true, //是否显示分页（*）
					sortable : true, //是否启用排序
					sortOrder : "desc", //排序方式
					queryParams : function(params) {
						var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
							rows : params.limit, //页面大小
							page : params.offset / params.limit + 1, //页码
							datetime : $("#datetime").val() == '' ? '' : ''
									+ $("#datetime").val() + '', //查询的参数   查询时间
							securityCode : $("#securityCodes").val() == '' ? ''
									: '' + $("#securityCodes").val() + '', //查询的参数    查询证券名称
							securityType:$("#securityType").val(),
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
						field : 'staticticsDate',
						title : '统计日期',
						//启用该字段的排序
						sortable : true
					}, {
						field : 'fundCode',
						title : '基金代码'
					},{
						field : 'fundName',
						title : '基金名称'
					},{
						field : 'securityCode',
						title : '证券代码'
					},{
						field : 'securityName',
						title : '证券名称'
					}, {
						field : 'securityType',
						title : '证券类型',
						formatter : function(value, row, index) {
							if (value == 1) {
								return "股票";
							} else {
								return "债券";
							}
						}
					},{
						field:'periodFlag',
						title:'期初标志',
						formatter:function(value,row,index){
							if(value==1){
								return "是";
							}else{
								return "不是";
							}
						}
					}, {
						field : 'securityUtilCost',
						title : '单位成本',
						formatter:function(value,index,row){
							return "<span style='color:green;font:16px solid bold'>"
							+ (value || 0)
									.toString()
									.replace(
											/(\d)(?=(\d{3})+(?!\d))/g,
											"$1,")
							+ "</span>";
						}
					}, {
						field : 'securityQuantity',
						title : '证券数量',
						formatter : function(value, index, row) {
							if (Number(value) < 0) {
								return "<span style='color:red;font:16px solid bold'>"
										+ (value*-1 || 0)
												.toString()
												.replace(
														/(\d)(?=(\d{3})+(?!\d))/g,
														"$1,")
										+ "</span>";
							}
							return "<span style='color:green;font:16px solid bold'>"
									+ (value || 0)
											.toString()
											.replace(
													/(\d)(?=(\d{3})+(?!\d))/g,
													"$1,")
									+ "</span>";
						}
					}, {
						field : 'totalMoney',
						title : '总成本',
						formatter : function(value, index, row) {
							if (Number(value) < 0) {
								return "<span style='color:red;font:16px solid bold'>"
										+ (value*-1 || 0)
												.toString()
												.replace(
														/(\d)(?=(\d{3})+(?!\d))/g,
														"$1,")
										+ "</span>";
							}
							return "<span style='color:green;font:16px solid bold'>"
									+ (value || 0)
											.toString()
											.replace(
													/(\d)(?=(\d{3})+(?!\d))/g,
													"$1,")
									+ "</span>";
						}
					}]
				});
		//增加按钮点击事件
		$("#btn_add").click(function() {
			$("#myModalLabel").text("新增证券库存");
			$('#staticticsDate').datetimepicker({
				language : 'zh-CN',//显示中文
				format : 'yyyy-mm-dd',//显示格式
				minView : "month",//设置只显示到月份
				//initialDate: new Date(),//初始化当前日期
				forceParse : true,//当输入非格式化日期时，强制格式化。默认true  
				autoclose : true,//选中自动关闭
				todayBtn : true
			//显示今日按钮
			});
			$('#myModal').modal();
			var accountCode=$("#fundCashAccountCode").val();
			if(accountCode!=''){
				//alert("accountCode有值"+accountCode);
				//发送ajax查询现金账户
				$('#accountCode').combogrid('setValue', accountCode);
				//$('#accountCode').attr('readonly',true);
			}
		});
		//删除按钮的点击事件
		$("#btn_delete")
				.click(
						function() {
							//得到所有选中的行
							var allRows = $("#myTable").bootstrapTable(
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
											var codes = [];
											$.each(allRows, function(i, v) {
												codes.push(v.code);
											})
											//alert(codes);
											$
													.ajax({
														type : "post",
														url : "../deleteSecurityStock.action",
														contentType : "application/x-www-form-urlencoded; charset=UTF-8",
														//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
														data : 'code=' + codes,
														success : function(msgs) {
															//刷新表格
															$("#myTable")
																	.bootstrapTable(
																			'refresh');
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
						});
		/* 修改的点击事件 */
		$("#btn_edit")
				.click(
						function() {
							//得到所有选中的行
							var allRows = $("#myTable").bootstrapTable(
									'getSelections')
							//判断选中的行数
							if (allRows.length == 0) { //没选中任何行
								//调用弹窗
								myAlert("请选则要修改的数据");
								return;
							} else if (allRows.length > 1) {
								myAlert("只能选择一条数据进行修改");
								return;
							}
							//给文本框赋值 交给界面赋值
							$
									.each(
											allRows,
											function(i, v) {
												$
														.ajax({
															type : "post",
															url : "../selectSecurityStockByCode.action",
															contentType : "application/x-www-form-urlencoded; charset=UTF-8",
															//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
															data : 'code='
																	+ v.code,
															success : function(
																	msgs) {
																/* alert("qwewe"
																		+ eval("("
																				+ msgs
																				+ ")")); */
																var msg = eval("("
																		+ msgs
																		+ ")"); //解析json对象
																//alert("      "+msg);
																$
																		.each(
																				msg,
																				function(
																						i, 
																						str) { //遍历对象 赋值
																					$(
																							"input[name="
																									+ i
																									+ "]")
																							.val(
																									str);
																					$(
																							"select[name="
																									+ i
																									+ "]")
																							.val(
																									str);
																					$(
																							"textarea[name="
																									+ i
																									+ "]")
																							.val(
																									str);
																					if(i=='securityCode'){
																						$("#securityCode").combogrid("setValue",str);
																					}
																					if(i=='totalMoney'){
																						$("input[name="+i+"]").val(str.toFixed(2))
																					}
																					if(i=='accountCode'){
																						$('#accountCode').combogrid('setValue', str);
																					}
																				})
																		$("input[name=staticticsDate]").attr('readonly',true);
																
															}
														});
											})
							//将弹窗的标题改为修改
							$("#myModalLabel").text("修改证券库存");
							//弹窗窗口
							$('#myModal').modal();
							$('#staticticsDate').datetimepicker({
								language : 'zh-CN',//显示中文
								format : 'yyyy-mm-dd',//显示格式
								minView : "month",//设置只显示到月份
								//initialDate: new Date(),//初始化当前日期
								autoclose : true,//选中自动关闭
								todayBtn : true
							//显示今日按钮
							});
						});

		//查询按钮的事件
		$("#btnSearch").click(function() {
			$("#myTable").bootstrapTable('refresh');
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
								code : {
									//验证格式
									validators : {
										notEmpty : {
											message : '编号不能为空'
										},
									}
								},
								fundName : {
									//验证格式
									validators : {
										notEmpty : {
											message : '编号不能为空'
										},
									}
								},
								staticticsDate : {
									validators : {
										notEmpty : {
											message : '日期不能为空'
										}
									}
								},
								securityName : {
									validators : {
										notEmpty : {
											message : '证券名称不能为空'
										}
									}
								},
								fundCode : {
									validators : {
										notEmpty : {
											message : '基金代码不能为空'
										}
									}
								},
								securityQuantity : {
									validators : {
										notEmpty : {
											message : '证券数量不能为空'
										},
										regexp: {
				                            regexp: /^[1-9]+[0-9]*/,
				                            message: '证券数量只能为正整数'
				                        }
									}
								},
								securityUtilCost : {
									validators : {
										notEmpty : {
											message : '单位成本不能为空'
										},
										regexp: {
				                            regexp: /^([1-9]|[1-9]\d+)(\.\d+)?$/,
				                            message: '单位成本只能正整数'
				                        }
									}
								},
								totalMoney : {
									validators : {
										notEmpty : {
											message : '总金额不能为空'
										}
									}
								},
								securityType : {
									validators : {
										notEmpty : {
											message : '基金类型不能为空'
										}
									}
								},
								periodFlag : {
									validators : {
										notEmpty : {
											message : '期初标志不为空',
										}
									}
								}
							},
							submitHandler : function(validator, form,
									submitButton) {
								//判断是否是新增和修改
								var title = $("#myModalLabel").text();
								var flag = '';
								if (title.substr(0,2) == '新增') {
									flag = 'insertSecurityStock';
								} else {
									flag = 'updateSecurityStock';
								}
								//alert(flag);
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
												$("#myTable").bootstrapTable(
														'refresh');
												//隐藏弹窗
												$('#myModal').modal("hide");
												test();//清除数据
												//提示
												myAlert(msgs);
											}
										});
							}
						//*****阻止表单的按钮提交
						});
		 //下拉表格部分 
		 $('input[name=accountCode]').combogrid({
			panelWidth : 450, //表格宽度
			//panelHeight:500,//表格高度
			value : '', //输入的默认值（可写可不写）
			idField : 'cashAccountCode', //传输的列  
			textField : 'cashAccountName', //显示的列
			fitColumns : true, //自动适应
			url : '../selectCashAccount.action', //服务器请求路径
			mode : 'remote', //定义在文本改变的时候如何读取数据。设置为'remote'，
			//数据表格将从远程服务器加载数据。当设置为'remote'模式的时候
			//，用户输入将会发送到名为'q'的http请求参数，向服务器检索新的数据。
			pagination : true, //分页条
			pageSize : 5,
			pageList : [ 5, 10, 15, 20, 25 ],
			columns : [ [ //表格列   
			{
				field : 'cashAccountCode',
				title : '现金账户编号',
				width : 60
			}, {
				field : 'cashAccountName',
				title : '现金账户名称',
				width : 120
			}, ] ],
		}); 
		//证券id
		$('#securityCode').combogrid({
			panelWidth : 450, //表格宽度
			//panelHeight:500,//表格高度
			value : '', //输入的默认值（可写可不写）
			idField : 'securityCode', //传输的列  
			textField : 'securityCode', //显示的列
			fitColumns : true, //自动适应
			url : '../selectSecuritys.action', //服务器请求路径
			mode : 'remote', //定义在文本改变的时候如何读取数据。设置为'remote'，
			//数据表格将从远程服务器加载数据。当设置为'remote'模式的时候
			//，用户输入将会发送到名为'q'的http请求参数，向服务器检索新的数据。
			pagination : true, //分页条
			pageSize : 5,
			pageList : [ 5, 10, 15, 20, 25 ],
			columns : [ [ //表格列   
			{
				field : 'securityCode',
				title : '证券id',
				width : 60
			}, {
				field : 'securityName',
				title : '证券名称',
				width : 80
			}, 
			{
				field : 'securityType',
				title : '证券类型',
				width : 100,
				formatter:function(value,index,row){
					if(value==1){
						return "股票";				
					}else{
						return "债券";
					}
				}
			}, ] ],
			onSelect:function(value,index,row){
				//alert(index.securityType);
				$("input[name=securityName]").val(index.securityName);
				$("select[name=securityType]").val(index.securityType);
			}
		}); 

		//给所有文本框添加提示框
		$('.clearData').tooltip({
			title : '不为空'
		});
		//去掉文本域的提示框
		$(".one").tooltip("destroy");
		//得到日期文本框的值 
		$("input[name=staticticsDate]").change(function() {
			if ($(this).val() != '') {
				//发送一个ajax 得到证券库存编号 并赋值到相应的文本框
				$.post('../selectSecurityStockCode.action?staticticsDate='+$(this).val(), null, function(msg) {
					//alert(msg);
					$("input[name=code]").val(msg);
				})
				$(this).tooltip("destroy");
			} else {
				$(this).tooltip({
					title : '日期不能为空'
				});
			}
		})

		//显示时间	
		$('#datetimepicker1').datetimepicker({
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//显示格式
			minView : "month",//设置只显示到月份
			//initialDate: new Date(),//初始化当前日期
			forceParse : true,//当输入非格式化日期时，强制格式化。默认true  
			autoclose : true,//选中自动关闭
			todayBtn : true
		//显示今日按钮
		});
		//清除数据
		$('.del').click(function() {
			//alert("进入清除数据的方法");
			test();
		});
		//计算总金额的方法
		$("input[name=securityUtilCost]").keyup(function() {
			var cost = $(this).val();//单位成本
			var quantity = $("input[name=securityQuantity]").val();//证券数量
			if (cost >=0 && quantity >=0 && cost.substr(0,1)!=0 && quantity.substr(0,1)!=0) {
					$("input[name=totalMoney]").val((cost * quantity).toFixed(2));
			}else{
				$("input[name=totalMoney]").val('0.0');
			}
		})
		$("input[name=securityQuantity]").keyup(function() {
			var cost = $("input[name=securityUtilCost]").val();//单位成本
			var quantity = $(this).val();//证券数量
			if (cost >=0 && quantity >=0 && cost.substr(0,1)!=0 && quantity.substr(0,1)!=0) {
					$("input[name=totalMoney]").val((cost * quantity).toFixed(2));
			}else{
				$("input[name=totalMoney]").val('0.0');
			}
		})
		//调用权限控制的方法
		isHaveRight($("#btn_add"),$("#btn_edit"),$("#btn_delete"),'L0701');
	});
	//定义提示弹窗的方法
	/*function myAlert(message) {
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
	}*/
	//弹框提示
	function myAlert(msg) {
		if (msg.length > 4) {
			$.message({
				message : msg,
				type : 'error',
			})
		} else {
			var str = msg.substr(msg.length - 2, msg.length);
			if (str == '成功') {
				$.message({
					message : msg,
					type : 'success'
				})
			} else {
				$.message({
					message : msg,
					type : 'error'
				})
			}
		}

	}
	//清除数据的方法
	function test() {
		$(".clearData").val("");
		$("#securityCode").combogrid("setValue","");
		$("#myForm").data("bootstrapValidator").resetForm();
		$('.clearData').tooltip('destroy');
		$('.clearData').tooltip({
			title : '不为空'
		});
		$(".one").tooltip("destroy");
		/* $("input[name=staticticsDate]").tooltip({
			title : '日期不能为空'
		}); */
	}
</script>
</head>

<body>
	<!--整个界面-->
	<div id="mianDiv">

		<!--工具栏-->
		<div id="toolbar" class="panel-heading form-inline"
			style="margin-top: 10px">
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
			&nbsp;&nbsp; <label
				class="control-label">查询日期：</label>
			<div class='input-group date' id='datetimepicker1'>
				<input type='text' class="form-control one" id="datetime" /> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
			<label class="control-label">证券代码：</label> <input
				class="form-control one" id="securityCodes" />
				<label class="control-label">证券类型：</label> 
				<select id="securityType" class="form-control one" >
				  <option value="">请选择证券类型</option>
				  <option value="1">股票</option>
				  <option value="2">债券</option>
				</select>
			<button type="button" style="margin-left: 10px" id="btnSearch"
				class="btn btn-info">查询</button>
		</div>
		<!--中间部分-->
		<div class="panel-body">
			<!--表格-->
			<table id="myTable"></table>
		</div>
		<!--弹窗div-->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel"    data-backdrop="static">
			<div class="modal-dialog " role="document">
				<div class="modal-content" style="width: 700px;">

					<!--表单验证  -->
					<form class="form-signin required-validate"
						action="#" method="post" id="myForm">
						<div class="modal-header">
							<button type="button" class="close del" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">×</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">新增</h4>
						</div>
						<div class="modal-body" style="height: 450px">
							<!-- 表单 -->

							<div class="form-inline" style="padding: 10px; height: 55px">
								<div class="form-group">
									<label for="code">证券库存id : </label> <input type="text"
										name="code" class="form-control clearData"  placeholder="证券库存编号" readonly />
								</div>
								<label style="width: 50px"></label>
								<div class="form-group">
									<label for="fundName" style="width: 65px;">基金名称:</label><input
										type="text" id="fundName" name="fundName" class="form-control"
										placeholder="基金名称"  
										value="${fund.fundName}" readonly />
								</div>
							</div>

							<div class="form-inline" style="padding: 10px; height: 55px">
								<div class="form-group">
									<label for="fundCode" style="width: 80px; text-align: right">基金编号:</label>
									<input type="text" name="fundCode" class="form-control"
										  placeholder="基金编号"
										value="${fund.fundCode}" readonly />
								</div>
								<label style="width: 50px"></label>
								<input type="hidden" id="fundCashAccountCode" value="${fund.cashAccountCode}"/>
								<div class="form-group">
									<label for="accountCode" style="width: 60px; text-align: right">账户编号:</label>
										<input
											type="text" id="accountCode" name="accountCode" 
											  class="form-control" style="width: 210px; height: 35px;">
								</div>
							</div>

							<div class="form-inline" style="padding: 10px; height: 55px">
								<div class="form-group">
									<div class="form-group">
										<label for="securityCode"
											style="width: 85px; text-align: right">证券id：</label><input
											type="text" id="securityCode" name="securityCode"
											  class="form-control" placeholder="证券id"
											style="width: 210px; height: 35px;">
									</div>
								</div>
								<label style="width: 50px"></label>
								<div class="form-group">
									<label for="securityName">证券名称:</label> <input type="text"
										name="securityName" class="form-control clearData one"  
										placeholder="证券名称" readonly />
								</div>
							</div>

							<div class="form-inline" style="padding: 10px; height: 55px">
								<div class="form-group">
									<label for="periodFlag" style="width: 80px; text-align: right">期初标志:</label>
									<select name="periodFlag" class="form-control"
										data-placement="top" style="width: 210px" readonly="readonly">
										<option value="">--是否从外部导入--</option>
										<option value="1" selected>是</option>
										<option value="2" >不是</option>
									</select>
								</div>
								<label style="width: 50px"></label>
								<div class="form-group">
									<label for="securityQuantity"
										style="width: 60px; text-align: right">证券数量:</label> <input
										type="text" name="securityQuantity" class="form-control clearData"
										data-placement="top" placeholder="证券数量" >
								</div>
							</div>

							<div class="form-inline" style="padding: 10px; height: 55px">
								<div class="form-group">
									<label for="securityUtilCost"
										style="width: 80px; text-align: right">单位成本:</label> <input
										type="text" name="securityUtilCost" class="form-control clearData"
										data-placement="top" placeholder="单位成本">
								</div>
								<label style="width: 50px"></label>
								<div class="form-group">
									<label for="totalMoney" style="width: 60px; text-align: right">总金额:</label>
									<input type="text" name="totalMoney" class="form-control clearData one"
										  placeholder="总金额" readonly />
								</div>
							</div>

							<div class="form-inline" style="padding: 10px; height: 55px">
								<div class="form-group">
									<label for="staticticsDate"
										style="width: 80px; text-align: right">统计日期：</label>
									<div class='input-group date' id='staticticsDate'
										style="width: 210px">
										<input type='text' class="form-control clearData" name="staticticsDate" />
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
								<label style="width: 50px"></label>
								<div class="form-group">
									<label class="control-label" for="securityType">证券类型:</label> <select
										name="securityType" class="form-control clearData"  style="width: 210px">
										<option value="">请选择证券类型</option>
										<option value="1">股票</option>
										<option value="2">债券</option>
									</select>

								</div>
							</div>

							<div class="form-inline" style="padding: 10px; height: 55px">
								<div class="form-group">
									<label for="securityDesc" class="control-label"
										style="width: 80px; text-align: right;">备注:</label>
									<textarea class="form-control one" name="securityDesc" rows="3"
										cols="70" placeholder="请输入备注字段(可写可不写)" max="200"></textarea>
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

	</div>
</body>

</html>
