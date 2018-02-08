	//加载事件 
			$(function() {
				
				//条件查询的日期时间插件	
				$('#dateTest').datetimepicker({
					 language:'zh-CN',//显示中文
					 format:'yyyy-mm-dd',//格式化日期
					 minView:'month',//设置只显示到月份
					// initialDate:new Date(),//初始化当前日期
					 autoclose:true,//自动关闭\
					 todayBtn:true//显示今天按钮
				});
				
				//债劵起始日的日期时间插件	
				$('#startDate').datetimepicker({
					 language:'zh-CN',//显示中文
					 format:'yyyy-mm-dd',//格式化日期
					 minView:'month',//设置只显示到月份
					// initialDate:new Date(),//初始化当前日期
					 autoclose:true,//自动关闭\
					 todayBtn:true//显示今天按钮
				});
				
				//债劵结束日的日期时间插件	
				$('#endDate').datetimepicker({
					 language:'zh-CN',//显示中文
					 format:'yyyy-mm-dd',//格式化日期
					 minView:'month',//设置只显示到月份
					// initialDate:new Date(),//初始化当前日期
					 autoclose:true,//自动关闭\
					 todayBtn:true//显示今天按钮
				});
	
				//加载表格
				$('#myTable').bootstrapTable({
					url: '../selectBonds.action',
					method: 'get', //请求方式（*）
					contentType:'application/json;charset=UTF-8',
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
							bondCode: $("#bondCodes").val(), //查询的参数   写自己的控制类对应的名字
							strInterestStarDate:$("#strInterestStarDate").val(),
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
						field: 'bondCode',
						title: '债劵编号',
						//启用该字段的排序
						sortable: true
					}, {
						field: 'bondName',
						title: '债劵名称'
					}, {
						field: 'strInterestStarDate',
						title: '计息起始日'
					}, {
						field: 'strInterestEndDate',
						title: '计息结束日'
					},{
						field: 'bondType',
						title: '债劵类型',
						formatter:function(value,rows,index){
							if(value==1){
								return '银行间';
							}else{
								return '非银行间';
							}
						}
						
					},{
						field: 'couponRate',
						title: '票面利率'
					},{
						field: 'bondInterest',
						title: '债劵利息'
					},{
						field: 'couponMoney',
						title: '票面金额'
					},{
						field: 'paymentCount',
						title: '付息次数',
							formatter:function(value,rows,index){
								if(value==1){
									return '一年一次';
								}else{
									return '一年两次';
								}
							}
							
					},{
						field: 'bondDesc',
						title: '备用字段'
					}
					]
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
							 			arr.push(v.bondCode);
							 		})
									//ajax操作   （发送请求到数据库删除）
								$.ajax({
										type:'post',
										url:'../deleteBondByBondIds.action',
										data:'bondCode='+arr,
										success:function(msg){
							 				$("#myTable").bootstrapTable("refresh");//刷新
							 			//提示
							 				myAlert(msg);
							 			//隐藏弹窗
							 				$('#myTable').modal("hide");
							 			}
									})
								},
								'取消': function() {
									//销毁弹窗
									window.dialog3.destroy();
								}
							}
						});
					}
				});
				//增加按钮点击事件
				$("#btn_add").click(function() {
					//隐藏弹窗
					$('#myModal').modal("hide");
					$.ajax({
						type:'post',
						url:'../selectSecurityTypes.action',
						success:function(msg){
							if(msg=='0'){
							myAlert('请先增加一条类型为债劵的证券数据');
							return;
							}
							//债劵编号下拉列表
							$("#bondCode").bootstrapSelect({
								url  : '../selectSecurityTypes.action', //请求路径
								//params : {},   //请求参数
								//paramsType : '',//参数默认是以表单形势传递，为json时是以json格式传递到后台
								//data   : [],   //数据[{key:value},{key:value}]
								method : 'get',//请求方法
								textField  : 'securityCode',//显示文本字段
								valueField : 'securityCode',//隐藏文本字段
								relationId : null,//级联id
								emptyText  : null,//空选项文本，该属性为null或undefined时不创建空选项，默认不创建
								emptyValue : '',//空选项值
								separator  : ',',//多选时返回值的分割符
								editable	 : true,//是否可编辑
								multiple : false,//多选
								disabled : false,//禁用
								downBorder : false,//下拉按钮是否带边框
								cls:'',//自定义样式,多个样式用逗号隔开 class1,class2
								formatter:function(rec){},//格式化节点	
								onSelect : function(val,rec){},
								unSelect : function(val,rec){},//反选
								onBeforeLoad: function(param){},//param 请求参数
								onLoadSuccess: function(data){
								},//data加载成功后返回的数据
								onLoadError: function(){},
								filter : false//选项过滤
							});
					$("#myForm").data("bootstrapValidator").resetForm();
					//将弹窗的标题改为新增
					$("#myModalLabel").text("新增");
					$('#myModal').modal();
					$("#bondCode").bootstrapSelect("select","");
					$("input[name=bondName]").val("");
					$("input[name=strInterestStarDate]").val("");
					$("input[name=strInterestEndDate]").val("");
					$("select[name=bondType]").val("");
					$("input[name=couponRate]").val("");
					$("input[name=bondInterest]").val("");
					$("input[name=couponMoney]").val("");
					$("select[name=paymentCount]").val("");
					$("input[name=bondDesc]").val("");
					}
				});
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
					var arr=[];
					$.each(allRows, function(i,v) {
						arr.push(v.bondCode);
					});
					var select=$("#bondCode");
					$(select).html("");
					//ajax发送请求
					$.ajax({
						type:"post",
						url:"../selectBondByIds.action",
						data:'bondCode='+arr,
						success:function(oneRow){
						alert(oneRow.bondCode);
							var bondCode=$("#bondCode").val(oneRow.bondCode);
							$("input[name=bondName]").val(oneRow.bondName);
							$("input[name=strInterestStarDate]").val(oneRow.strInterestStarDate);
							$("input[name=strInterestEndDate]").val(oneRow.strInterestEndDate);
							$("select[name=bondType]").val(oneRow.bondType);
							$("input[name=couponRate]").val(oneRow.couponRate);
							$("input[name=bondInterest]").val(oneRow.bondInterest);
							$("input[name=couponMoney]").val(oneRow.couponMoney);
							$("select[name=paymentCount]").val(oneRow.paymentCount);
							$("textarea[name=bondDesc]").val(oneRow.bondDesc);
							//验证
							var $form = $("#myForm");
							var data = $form.data('bootstrapValidator');
							if (data) {
								// 修复记忆的组件不验证
								data.validate();
							}
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
						flag = 'insertBond';
						
					} else {
						flag = 'updateBond';
					}
					$('#myModal').modal("hide");
					//ajax发送请求
					$.ajax({
						type: "post",
						url: "../" + flag + ".action",
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
						'closeTime': 4000, //时间
						'className': 'alertDialog'
					});
				}
				//查询的方法
				$("#btnSearch").click(function(){
					//刷新表格
					$("#myTable").bootstrapTable('refresh');
				});
				
				var right='L0106';
				isHaveRight=($("#btn_add"),$("#btn_delete"),$("#btn_edit"),right);
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
						bondName: {
							validators: {
								notEmpty: {
									message: '债劵名称不能为空'
								}
							}
						},
						bondType: {
							validators: {
								notEmpty: {
									message: '债劵类型不能为空'
								}
							}
						},
						couponRate: {
							validators: {
								notEmpty: {
									message: '票面利率不能为空'
								},
								regexp: {
									regexp: /^[.0-9_]+$/,
									message: '票面利率只能是数字'
									}
							}
						},
						bondInterest: {
							validators: {
								notEmpty: {
									message: '债劵利息不能为空'
								},
								regexp: {
									regexp: /^[.0-9_]+$/,
									message: '票面利息只能是数字'
									}
							}
						},
						couponMoney: {
							validators: {
								notEmpty: {
									message: '票面金额不能为空'
								},
								regexp: {
								regexp: /^[0-9_]+$/,
								message: '票面金额只能是数字'
								}
							}
						},
						paymentCount: {
							validators: {
								notEmpty: {
									message: '计息次数不能为空'
								}
							}
						}
					}
					//*****阻止表单的按钮提交
				}).on('success.form.bv', function(e) {
					//阻止默认事件提交
					e.preventDefault();
				});
		});