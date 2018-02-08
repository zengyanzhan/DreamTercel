$(function(){
				//加载表格
				$("#myTable").bootstrapTable({
					url:'../priceDates/selectPriceData.action',
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
							securityCode: $("#securityCodes").val(), //查询的参数   写自己的控制类对应的名字
							StrEnteringDate: $("#StrEnteringDate").val(), //查询的参数
							sortName: this.sortName,
							sortOrder: this.sortOrder
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
						field: 'priceDataCode',
						title: '行情数据ID',
						//启用该字段的排序
						sortable: true
					}, {
						field: 'securityCode',
						title: '证券代码'
					}, {
						field: 'strEnteringDate',
						title: '录入日期'
					}, {
						field: 'openingPrice',
						title: '开盘价格'
					},
					{
						field: 'closingPrice',
						title: '收盘价格'
					},
					{
						field: 'Desc',
						title: '备注'
					}
					]
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

											var priceDataCodes = [];
											$.each(allRows, function(i, rows) {
												priceDataCodes.push("'" + rows.priceDataCode
														+ "'");

											});
											$.ajax({
												type : "post",
												url : "../priceDates/deletePrrice.action?priceDataCode="
														+ priceDataCodes,
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
			

				//增加按钮点击事件
				$("#btn_add").click(function() {
					

					//将弹窗的标题改为新增
					$("#myModalLabeles").text("新增");
					$('#myModal').modal();
					$("input[name=priceDataCode]").val("");//行情数据ID
					$("input[name=securityCode]").val("");//证券代码
					$("input[name=strEnteringDate]").val("");//录入日期
					$("input[name=openingPrice]").val("");//开盘价格
					$("input[name=closingPrice]").val("");//收盘价格
					$("input[name=Desc]").val("");//备注 
					/*	$("#myTable").val("");*/
					$("#myForm").data("bootstrapValidator").resetForm();
					$("#myModal").form('clear');//清除
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
						$("input[name=priceDataCode]").val(oneRow.priceDataCode);//行情数据ID
						$("#securityCode").combogrid("setValue",oneRow.securityCode);//证券代码
						$("input[name=strEnteringDate]").val(oneRow.strEnteringDate);//录入日期
				
						$("input[name=openingPrice]").val(oneRow.openingPrice);//开盘价格
						$("input[name=closingPrice]").val(oneRow.closingPrice);//收盘价格		
						$("textArea[name=Desc]").val(oneRow.Desc);//备注 
					
						//验证
						var $form = $("#myForm");
						
						var data = $form.data('bootstrapValidator');
						if (data) {
							// 修复记忆的组件不验证
							data.validate();
						}
					});
					//将弹窗的标题改为修改
					$("#myModalLabeles").text("修改");
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
					var title = $("#myModalLabeles").text();
				//	var strEnteringDate=$("input[name=enteringDate]").val('getValue');
					//var establishDate=$("#enteringDate").val('getValue');
					var flag = '';
					if (title == '新增') {
						flag = 'insertPrice';
					} else {
						flag = 'updatePrice';
					}
					$('#myModal').modal("hide");
					//ajax发送请求
					$.ajax({
						type : "post",
						url : "../priceDates/" + flag + ".action",
						//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
						data : $("#myForm").serializeArray(),
						success : function(msgs) {
							//刷新表格
							$("#myTable").bootstrapTable('refresh');
							//提示
							myAlert(msgs);
							//隐藏弹窗
							$('#myModal').modal("hide");
							$("#myModal").form('clear');//清除
						}
					});
				});
				//加载表单验证
				$("#myForm").bootstrapValidator({
					//图标集
					feedbackIcons: {
						valid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
					},
					//列字段/^[0-9a-zA-Z\u4e00-\u9fa5]+$/,
					fields: {
						openingPrice: {
							message: '验证失败',
							validators: {
								notEmpty: {
									message: '不能为空'
								},
								regexp: {
									regexp:  /^[0-9]+(.[0-9]{1,3})?$/,
									message: '只能为数字'
								},
							}
						},
						closingPrice: {
							message: '验证失败',
							validators: {
								notEmpty: {
									message: '不能为空'
								},
								regexp: {
									regexp:  /^[0-9]+(.[0-9]{1,3})?$/,
									message: '只能为数字'
								},
							}
						},
					}
					//*****阻止表单的按钮提交
				}).on('success.form.bv', function(e) {
					//阻止默认事件提交
					e.preventDefault();
				});

				//证券代码表格下拉框
				$('#securityCode').combogrid({    
				    panelWidth:450,
				    idField:'securityCode',    
				    textField:'securityName',  
				    pagination:true,
				    url:'../selectSecuritys.action',    
				    columns:[[    
				        {field:'securityCode',title:'证券ID',width:150},    
				        {field:'securityName',title:'证券名称',width:150},
				        {field:'publishDate',title:'发行日期',width:150} 
				    ]]    
				});  
				
				
				
				$('#enteringDate').datetimepicker({
					 language:'zh-CN',//显示中文
					 format:'yyyy-mm-dd',//格式化日期
					 minView:'month',//设置只显示到月份
					// initialDate:new Date(),//初始化当前日期
					 autoclose:true,//自动关闭
					 todayBtn:true//显示今天按钮
				});
				
				
				$('#enteringDate').change(function(){
					$.ajax({
						type : "post",
						url : "../priceDates/autoBianhao.action?strEnteringDate="+$('input[name="strEnteringDate"]').val(),
						//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
						success : function(msgs) {
							$("input[name=priceDataCode]").val(msgs);
						}
					});
					
					
				});
				$('#sEnteringDates').datetimepicker({
					 language:'zh-CN',//显示中文
					 format:'yyyy-mm-dd',//格式化日期
					 minView:'month',//设置只显示到月份
					// initialDate:new Date(),//初始化当前日期
					 autoclose:true,//自动关闭
					 todayBtn:true//显示今天按钮
				});
				
				//上海导入数据 	shenzhen
				$("#shangHai").click(function(){
					$("#myModalLabel" ).text("上海数据导入");
					
					$("#inputDate").modal();
				});
				$("#btnInput").click(function(){
					var title=$("#myModalLabel").text();
					var flag='inputShguk';
					if(title=='深圳回报库数据导入'){
						flag='imputShangHai';
					}else if(title=='上海过户库数据导入'){
						flag='imputShangHai';
					}
					$("#myTable").bootstrapTable("refresh");
				});
				//查询按钮
				$("#btnSearch").click(function(){
			
					$("#myTable").bootstrapTable("refresh");
					
				});
			
				var right='L0110';
				isHaveRight($("#btn_add"),$("#btn_edit"),$("#btn_delete"),right);
			
			});
			
