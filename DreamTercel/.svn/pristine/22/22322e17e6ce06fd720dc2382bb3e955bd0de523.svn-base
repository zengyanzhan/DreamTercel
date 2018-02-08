
			$(function(){
				
				//加载表格
				$("#myTable").bootstrapTable({
					url:'../fund/selectFundRow.action',
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
							fundCode: $("#fundCode").val(), //查询的参数   写自己的控制类对应的名字
							fundType: $("#fundTypes").val(), //查询的参数
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
						field: 'fundCode',
						title: '基金代码',
						//启用该字段的排序
						sortable: true
					}, {
						field: 'fundName',
						title: '基金名称'
					}, {
						field: 'managerName',
						title: '基金管理公司'
					}, {
						field: 'trusteeName',
						title: '基金托管银行'
					},
					{
						field: 'fundType',
						title: '基金类型',
							formatter: function(value, rowDate, rowIndex){
								if(value==1){
									return '开放式';
								}else if(value==2){
									return '封闭式';
								}
							}
					},
					{
						field: 'fundScale',
						title: '基金规模',
						formatter:function(value,index,row){
							return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
						}
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

											var fundCodes = [];
											$.each(allRows, function(i, rows) {
												
												fundCodes.push("'" + rows.fundCode
														+ "'");

											});
											$.ajax({
												type : "post",
												url : "../fund/deleteFund.action?fundCode="
														+ fundCodes,
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
					$("#myModalLabel").text("新增");
					$('#myModal').modal();
					$("input[name=fundCode]").val("");//基金代码
					$("input[name=fundName]").val("");//基金名称
					$("input[name=cashAccountCode]").val("");//现金账户
					$("input[name=fundType]").val("");//基金类型 1开放式 2封闭式
					$("input[name=trusteeCode]").val("");//基金管理人
					$("input[name=managerCode]").val("");//基金托管人
					$("input[name=initFundValue]").val("");//基金初期净值
					$("input[name=fundScale]").val("");//基金规模
					$("input[name=manageRate]").val("");//管理人费率
					$("input[name=trusteeRate]").val("");//托管额人费率
					$("input[name=feePeriodDay]").val("");//两费计提天数
					$("input[name=strEstablishDate]").val("");//成立日期
					$("input[name=fundDesc]").val("");//备注 
					$("#myModal").form('clear');//清除
					$("#myForm").data("bootstrapValidator").resetForm();
					
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
					$("btn_edit").click(function(){
						alert("修改的按钮");
						type : "post";
						
						
					});
					//给文本框赋值
					$.each(allRows, function(i, oneRow) {
						
						//验证
						var $form = $("#myForm");
						var data = $form.data('bootstrapValidator');
						if (data) {
							// 修复记忆的组件不验证
							data.validate();
						}
					});$.each(allRows, function(i, oneRow) {

						//通过编号到数据库查询数据修改
						$.ajax({type : "post",
									url : "../fund/selectFundByCode.action?fundCode="
											+ oneRow.fundCode,
									//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
									success : function(msg) {
										var msgs = eval('(' + msg + ')');
										$("input[name=fundCode]").val(
												msgs.fundCode); 	
										$("input[name=fundName]").val(
												msgs.fundName);
										$("#cashAccountCode").combogrid("setValue",
												msgs.cashAccountCode);
										$("#fundType").val(
												msgs.fundType);
										$("#trusteeCode").combogrid("setValue",
												msgs.trusteeCode);
										$("#managerCode").combogrid("setValue",
												msgs.managerCode);
										$("input[name=initFundValue]").val(
												msgs.initFundValue);
										$("input[name=fundScale]").val(
												msgs.fundScale);
										$("input[name=manageRate]").val(
												msgs.manageRate);
										$("input[name=trusteeRate]").val(
												msgs.trusteeRate);
										$("input[name=feePeriodDay]").val(
												msgs.feePeriodDay);
										$("input[name=strEstablishDate]").val(msgs.strEstablishDate);
										/*$('#combogridByusrRoleId').combogrid('setValue', oneRow.usrRoleId);*/
										$("textArea[name=fundDesc]").val(
												msgs.fundDesc);
										//验证
										var $form = $("#myForm");
										var data = $form
												.data('bootstrapValidator');
										if (data) {
											// 修复记忆的组件不验证
											data.validate();
										}

									}
								});

						/*$('#combogridByusrRoleId').combogrid('setValue', oneRow.usrRoleId);*/

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
						flag = 'insertFundRow';
					} else {
						flag = 'updateFund';
					}
					$('#myModal').modal("hide");
					//ajax发送请求
					$.ajax({
						type : "post",
						url : "../fund/" + flag + ".action",
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
						fundCode: {
							//验证格式/^[0-9]+[\.][0-9]+$/
							validators: {
								notEmpty: {
									message: '基金编号不能为空'
									
								},
								stringLength: {
									min: 6,
									max: 6,
									message: '基金代码只能为6位'
								},
								regexp: {
									regexp: /^[0-9]+$/,
									message: '基金代码只能为数字'
								}
							}
						
						},
						fundName: {
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
						initFundValue: {
							message: '验证失败',
							validators: {
								notEmpty: {
									message: '不能为空'
								},
								
								regexp: {
									regexp:  /^\d+$/,
									message: '只能为数字'
								},
							}
						},
						
						manageRate: {
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
						trusteeRate: {
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
						fundScale: {
							message: '验证失败',
							validators: {
								notEmpty: {
									message: '不能为空'
								},
								stringLength: {
									min: 6,
									message: '规模最少6位'
								},
								regexp: {
									regexp:  /^\d+$/,
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
				//数据表格下拉框
				$('#cashAccountCode').combogrid({    
				    panelWidth:450,
				    idField:'cashAccountCode',    
				    textField:'cashAccountName',  
				    pagination:true,
				    url:'../selectCashAccount.action',  
				    mode: 'remote', //定义在文本改变的时候如何读取数据。设置为'remote'，
				    columns:[[    
				        {field:'cashAccountCode',title:'账户id',width:150},    
				        {field:'cashAccountName',title:'账户名称',width:150},    
				        {field:'cashAccountBankName',title:'开户银行',width:150}
				    ]]    
				});
				$('#establishDate').datetimepicker({
					 language:'zh-CN',//显示中文
					 format:'yyyy-mm-dd',//格式化日期
					 minView:'month',//设置只显示到月份
					// initialDate:new Date(),//初始化当前日期
					 autoclose:true,//自动关闭
					 todayBtn:true//显示今天按钮
				});
				//托管人表格下拉框
				$('#trusteeCode').combogrid({    
				    panelWidth:450,
				    idField:'trusteeCode',    
				    textField:'trusteeCompany',  
				    pagination:true,
				    url:'../trustee/selectTrusteeRow.action', 
				    onSelect:function(recs,rows){
						 $("input[name=trusteeRate]").val(rows.trusteeFee);
					 },
				    mode: 'remote', //定义在文本改变的时候如何读取数据。设置为'remote'，
				    columns:[[    
				        {field:'trusteeCode',title:'托管id',width:150},    
				        {field:'trusteeName',title:'托管人名称',width:150},    
				        {field:'trusteeFee',title:'托管费率',width:150},
				        {field:'trusteeCompany',title:'托管公司',width:150}
				    ]]    
				});
				//管理人表格下拉框
				 
				$('#managerCode').combogrid({
					  panelWidth:450,
					  idField:'managerCode',    
					  textField:'managerCompany',  
					  pagination:true,
					  url:'../manager/selectManagerRow.action', 
					
					 onSelect:function(recs,rows){
						 $("input[name=manageRate]").val(rows.managerFee);
					 },
					  mode: 'remote', //定义在文本改变的时候如何读取数据。设置为'remote'，
					    columns:[[    
					        {field:'managerCode',title:'管理人id',width:150},    
					        {field:'managerName',title:'管理人名称',width:150},
					        {field:'managerFee',title:'管理费率',width:150},
					        {field:'managerCompany',title:'管理公司',width:150}
					    ]] 
				});
				
				$("#btnSearch").click(function(){
					$("#myTable").bootstrapTable("refresh");
				})
				
				var right='L0101';
				isHaveRight($("#btn_add"),$("#btn_edit"),$("#btn_delete"),right);
			});
			
