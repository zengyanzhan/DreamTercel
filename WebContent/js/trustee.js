$(function(){
				//加载表格
				$("#myTable").bootstrapTable({
					url:'../trustee/selectTrusteeRow.action',
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
							trusteeCode: $("#trusteeCode").val(), //查询的参数   写自己的控制类对应的名字
							trusteeName: $("#trusteeName").val(), //查询的参数
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
						field: 'trusteeCode',
						title: '托管人编号',
						//启用该字段的排序
						sortable: true
					}, {
						field: 'trusteeName',
						title: '托管人姓名'
					}, {
						field: 'trusteeAddres',
						title: '托管人地址'
					}, {
						field: 'trusteeCompany',
						title: '托管人公司'
					},
					{
						field: 'trusteePhone',
						title: '电话'
					},
					{
						field: 'trusteeFee',
						title: '托管费率'
					},
					{
						field: 'trusteeDesc',
						title: '备注'
					}]
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

											var trusteeCodes = [];
											$.each(allRows, function(i, rows) {
												trusteeCodes.push("'" + rows.trusteeCode
														+ "'");

											});
											$.ajax({
												type : "post",
												url : "../trustee/deleteTrustee.action?trusteeCode="
														+ trusteeCodes,
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
					$.ajax({
						type : "post",
						url : "../trustee/autoBianhao.action",
						//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
						data : $("#myForm").serializeArray(),
						success : function(msgs) {
							$("input[name=trusteeCode]").val(msgs);
						}
					});

					//将弹窗的标题改为新增
					$("#myModalLabel").text("新增");
					$('#myModal').modal();
					$("input[name=trusteeCode]").val("");//托管人ID
					$("input[name=trusteeName]").val("");//托管人姓名
					 $("input[name=trusteeAddres]").val("");//托管人地址
					$("input[name=trusteeCompany]").val("");//托管人公司
					$("input[name=trusteePhone]").val("");//托管人电话
					$("input[name=trusteeFee ]").val("");//托管人费率
					$("input[name=trusteeDesc]").val("");//备注 
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
						$("input[name=trusteeCode]").val(oneRow.trusteeCode);//托管人的ID 
						$("input[name=trusteeName]").val(oneRow.trusteeName);//托管人的姓名
						$("input[name=trusteeAddres]").val(oneRow.trusteeAddres);//托管人地址
						$("input[name=trusteeCompany]").val(oneRow.trusteeCompany);//托管人公司
						$("input[name=trusteePhone]").val(oneRow.trusteePhone);//托管人电话		
						$("input[name=trusteeFee]").val(oneRow.trusteeFee);//托管人费率
						$("input[name=trusteeDesc]").val(oneRow.trusteeDesc);//备注 
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
						flag = 'insertTrustee';
					} else {
						flag = 'updateTrustee';
					}
					$('#myModal').modal("hide");
					//ajax发送请求
					$.ajax({
						type : "post",
						url : "../trustee/" + flag + ".action",
						//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
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
						trusteeCode: {
							//验证格式
							validators: {
								notEmpty: {
									message: '基金编号不能为空'
									
								},
							}
						
						},
						trusteeName: {
							message: '基金名验证失败',
							validators: {
								notEmpty: {
									message: '基金名不能为空'
								},
								regexp: {
									regexp: /^[a-zA-Z\u4e00-\u9fa5]+$/,
									message: '基金名称必须为中文,英文'
								},
							}
						},
						trusteeAddres: {
							message: '地址验证失败',
							validators: {
								notEmpty: {
									message: '地址不能为空'
								},
							}
						},
						trusteeCompany: {
							message: '所在公司验证失败',
							validators: {
								notEmpty: {
									message: '所在公司不能为空'
								},
							}
						},
						trusteePhone: {
							message: '电话验证失败',
							validators: {
								notEmpty: {
									message: '电话不能为空'
								},
								stringLength: {
									min: 5,
									max: 13,
									message: '电话长度必须在5-11位之间'
								},
							}
						},
						trusteeFee: {
							message: '验证失败',
							validators: {
								notEmpty: {
									message: '不能为空'
								},
								regexp: {
									regexp:  /^0\.[0-9]*\d*$/,
									message: '费率大于0小于1的一个数'
								},
							}
						},
					
					}
					//*****阻止表单的按钮提交
				}).on('success.form.bv', function(e) {
					//阻止默认事件提交
					e.preventDefault();
				});
				$("#btnSearch").click(function(){
					$("#myTable").bootstrapTable("refresh");
					
				});
				var right='L0109';
				isHaveRight($("#btn_add"),$("#btn_edit"),$("#btn_delete"),right);
			});
			

			
