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
				//日期时间插件	
				$('#dateTest').datetimepicker({
					 language:'zh-CN',//显示中文
					 format:'yyyy-mm-dd',//格式化日期
					 minView:'month',//设置只显示到月份
					// initialDate:new Date(),//初始化当前日期
					 autoclose:true,//自动关闭\
					 todayBtn:true//显示今天按钮
				});
				$('#dateTest2').datetimepicker({
					 language:'zh-CN',//显示中文
					 format:'yyyy-mm-dd',//格式化日期
					 minView:'month',//设置只显示到月份
					// initialDate:new Date(),//初始化当前日期
					 autoclose:true,//自动关闭\
					 todayBtn:true//显示今天按钮
				});
				//加载表格
				$('#myTable').bootstrapTable({
					url: '../selectTaStocks.action',
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
							fundCode: $("#fundCodeWhere").val(), //查询的参数   写自己的控制类对应的名字
							statisticDateWhere:$("#statisticDateWhere").val(),//查询的参数   写自己的控制类对应的名字
							//usrFlag: $("#usrFlag").val(), //查询的参数
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
						field: 'taStockCode',
						title: 'TA库存编号',
						//启用该字段的排序
						sortable: true
					}, {
						field: 'fundCode',
						title: '基金编号'
					}, {
						field: 'taStockQuantity',
						title: 'TA数量',
						formatter: function(value,row,index){
							return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
						}
					}, {
						field: 'taStockMoney',
						title: 'TA金额',
						formatter: function(value,row,index){
							return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
						}
					}, {
						field: 'strDate',
						title: '统计日期'
					}, {
						field: 'periodFlag',
						title: '期初标志',
						formatter:function(value,row,index){
							if(value==1){
								return "是";
							}else{
								return "不是";
							}
						}
					},{
						field: 'taStockDesc',
						title: '备注'
					}, ]
				});
				//增加按钮点击事件
				$("#btn_add").click(function() {
					$.post("../taStockByFundId.action",null,function(msg){
						$("input[name=fundCode]").val(msg);
					});
					$.post("../ziDongShengCheng.action",null,function(value){
						$("input[name=taStockCode]").val(value);
					});
					//清空文本框
					
					$("input[name=taStockQuantity]").val("");
					$("input[name=taStockMoney]").val("");
					$("input[name=statisticDates]").val("");
					$("input[name=periodFlag]").val("");
					$("input[name=taStockDesc]").val("");
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
									var arr=[];
									$.each(allRows,function(i,v){
										arr.push(v.taStockCode);
									})
									//ajax操作   （发送请求到数据库删除）
									$.ajax({
										url:'../deleteTaStockByTaStockId.action',
										type: "post",
										contentType: "application/x-www-form-urlencoded; charset=UTF-8",
										data: 'taStockCode='+arr,
										success: function(msgs) {
											//刷新表格
											$("#myTable").bootstrapTable('refresh');
											//提示
											myAlert(msgs);
											//隐藏弹窗
											$('#myModal').modal("hide");
										}
									});
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
					alert(allRows.length);
					if (allRows.length == 0) { //没选中任何行
						//调用弹窗
						myAlert("请选则要修改的数据");
						return;
					} else if (allRows.length > 1) {
						myAlert("只能选择一条数据进行修改");
						return;
					}
					var arr=[];
					$.each(allRows,function(i,v){
						arr.push(v.taStockCode);
					})
					//ajax发送请求
					$.ajax({
						type: "post",
						url: "../selectTaStockById.action",
						data: 'taStockCode='+arr,
						success: function(oneRow) {
							$("input[name=taStockCode]").val(oneRow.taStockCode);
							$("input[name=taStockQuantity]").val(oneRow.taStockQuantity);
							$("input[name=taStockMoney]").val(oneRow.taStockMoney);
							$("#strDate").val(oneRow.strDate);
							$("select[name=periodFlag]").val(oneRow.periodFlag);
							$("input[name=taStockDesc]").val(oneRow.taStockDesc);
							//验证
							var $form = $("#myForm");
							/*var data = $form.data('bootstrapValidator');
							if (data) {
								// 修复记忆的组件不验证
								data.validate();
							}*/
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
					/*var data = $form.data('bootstrapValidator');
					if (data) {
						// 修复记忆的组件不验证
						data.validate();
						if (!data.isValid()) {
							//验证不通过  阻止提交
							return;
						}
					}*/
					//得带弹窗的标题判断  是增加还是修改
					var title = $("#myModalLabel").text();
					var flag = '';
					if (title == '新增') {
						flag = 'insertTaStock';
					} else {
						flag = 'updateTaStock';
					}
					//$('#myModal').modal("hide");
					//alert(flag);
					//ajax发送请求
					$.ajax({
						type: "post",
						url: "../" + flag + ".action",
						contentType: "application/x-www-form-urlencoded; charset=UTF-8",
						//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
						data: $("#myForm").serializeArray(),
						success: function(msgs) {
							//提示
							myAlert(msgs);
							//隐藏弹窗
							$('#myModal').modal("hide");
							//刷新表格
							$("#myTable").bootstrapTable('refresh');
						}
					});
				});
				//查询按钮的事件
				$("#btnSearch").click(function() {
					$("#myTable").bootstrapTable('refresh');
					//清空文本框
					$("input[name=fundCodeWhere]").val("");
					$("input[name=statisticDateWhere]").val("");
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
						taStockQuantity: {
							//验证格式
							validators: {
								notEmpty: {
									message: '数量不能为空'
								},
								stringLength: {
									min: 1,
									max: 100000,
									message: '数量必须在1-100000以内'
								},
								regexp: {
									regexp: /^[.0-9_]+$/,
									message: '数量只能是数字'
								}
							}
						},
						taStockMoney: {
							//验证格式
							validators: {
								notEmpty: {
									message: '金额不能为空'
								},
								stringLength: {
									min: 1,
									max: 100000,
									message: '数量必须在1-100000以内'
								},
								regexp: {
									regexp: /^[.0-9_]+$/,
									message: '数量只能是数字'
								}
							}
						},
						periodFlag: {
							//验证格式
							validators: {
								notEmpty: {
									message: '期初标志不能为空'
								}
							}
						},
			}
					//*****阻止表单的按钮提交
				}).on('success.form.bv', function(e) {
					//阻止默认事件提交
					e.preventDefault();
				});
				/* 下拉表格部分 */
				/*$('#combogridByusrRoleId').combogrid({
					panelWidth: 450, //表格宽度
					//panelHeight:500,//表格高度
					value: '', //输入的默认值（可写可不写）
					idField: 'fundCode', //传输的列  
					textField: 'fundCode', //显示的列
					fitColumns: true, //自动适应
					url: '../fund/selectFundRow.action', //服务器请求路径
					mode: 'remote', //定义在文本改变的时候如何读取数据。设置为'remote'，
					//数据表格将从远程服务器加载数据。当设置为'remote'模式的时候
					//，用户输入将会发送到名为'q'的http请求参数，向服务器检索新的数据。
					pagination: true, //分页条
					pageSize: 5,
					pageList: [5, 10, 15, 20, 25],
					columns: [
						[ //表格列   
							{
								field: 'fundCode',
								title: '基金代码',
								width: 60
							}, {
								field: 'fundName',
								title: '基金名称',
								width: 100
							}, {
								field: 'fundScale',
								title: '基金规模',
								width: 120
							},
						]
					]*/
				});
				
				var right='L0705';
				isHaveRight($("#btn_add"),$("#btn_edit"),$("#btn_delete"),right);
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