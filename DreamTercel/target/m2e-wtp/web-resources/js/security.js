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
				
				//证劵发行的日期时间插件	
				$('#publishDate').datetimepicker({
					 language:'zh-CN',//显示中文
					 format:'yyyy-mm-dd',//格式化日期
					 minView:'month',//设置只显示到月份
					// initialDate:new Date(),//初始化当前日期
					 autoclose:true,//自动关闭\
					 todayBtn:true//显示今天按钮
				});
				
				//证劵结束日的日期时间插件	
				$('#delayDate').datetimepicker({
					 language:'zh-CN',//显示中文
					 format:'yyyy-mm-dd',//格式化日期
					 minView:'month',//设置只显示到月份
					// initialDate:new Date(),//初始化当前日期
					 autoclose:true,//自动关闭\
					 todayBtn:true//显示今天按钮
				});
				
				$('#stockPlateCode').combotree({    
				    url: '../getSelect.action',    
				
				});  
				
				$("#b").css("display","none");
				//加载表格
				$('#myTable').bootstrapTable({
					url: '../selectSecuritys.action',
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
//							securityCode:$("#securityCodes").val(""),
							publishDates: $("#publishDates").val(), //查询的参数
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
						field: 'securityCode',
						title: '证券编号',
						//启用该字段的排序
						sortable: true
					}, {
						field: 'securityName',
						title: '证券名称'
					}, {
						field: 'publishDates',
						title: '发行日期'
					}, {
						field: 'delayDates',
						title: '延迟日期'
					},{
						field: 'securityType',
						title: '证劵类型',
							formatter:function(value,rows,index){
								if(value==1){
									return '股票';
								}else{
									return '债劵';
								}
							}
							
					},{
						field: 'exchangeName',
						title: '交易所名称',
						formatter:function(value,rows,index){
							if(value==1){
								return '上交所';
							}else{
								return '深交所';
							}
						}
					},{
						field: 'stockPlateCode',
						title: '板块分类'
					},{
						field: 'securityDesc',
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
							 			arr.push(v.securityCode);
							 		})
									//ajax操作   （发送请求到数据库删除）
							 		alert("fdsfkwejdqwpodj");
								$.ajax({
										type:'post',
										url:'../deleteSecurityByIds.action',
										data:'securityCode='+arr,
										success:function(msg){
							 				$("#myTable").bootstrapTable("refresh");//刷新
							 			//提示
							 				myAlert(msg);
							 			//隐藏弹窗
							 				$('#myTable').modal("hide");
							 				myAlert("删除成功");
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
					$("#myForm").data("bootstrapValidator").resetForm();
					//将弹窗的标题改为新增
					$("#myModalLabel").text("新增");
					$('#myModal').modal();
					$("input[name=securityCode]").val("");
					$("input[name=securityName]").val("");
					$("#publishDate]").val("");
					$("#delayDate]").val("");
					$("select[name=securityType]").val("");
					$("select[name=exchangeName]").val("");
					$("input[name=stockPlateCode]").val("");
					$("input[name=securityDesc]").val("");
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
						arr.push(v.securityCode);
					});
					//ajax发送请求
					$.ajax({
						type:"post",
						url:"../selectSecurityByIds.action",
						data:'securityCode='+arr,
						success:function(oneRow){
							$("input[name=securityCode]").val(oneRow.securityCode);
							$("input[name=securityName]").val(oneRow.securityName);
							$("input[name=publishDates]").val(oneRow.publishDates);
							$("input[name=delayDates]").val(oneRow.delayDates);
							$("select[name=securityType]").val(oneRow.securityType);
							$("select[name=exchangeName]").val(oneRow.exchangeName);
							$("input[name=stockPlateCode]").val(oneRow.stockPlateCode);
							$("textarea[name=securityDesc]").val(oneRow.securityDesc);
							
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
						flag = 'insertSecuritys';
					} else {
						flag = 'updateSecurity';
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
				
				//查询的方法
				$("#btnSearch").click(function(){
					//刷新表格
					$("#myTable").bootstrapTable('refresh');
				});
				
				
				
				//改变事件
				$("#securityType").change(function(){
					var aa=$("#securityType option:selected").val();
					
					if(aa=='1'){
						$("#b").css("display","none");
						$("#a").css("display","block");
				
						
					}else{
						$("#a").css("display","none");
						$("#b").css("display","block");
			
					}
				});
				var right='L0105';
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
						securityCode: {
							//验证格式
							validators: {
								notEmpty: {
									message: '证券编号不能为空'
								},stringLength: {
									min:6,
									max:6,
									message: '证券唯一编号必须是6位数'
								},
								regexp: {
									regexp: /^[0-9_]+$/,
									message: '证劵编号只能是数字'
								}
							}
						},
						securityName: {
							validators: {
								notEmpty: {
									message: '劵商名称不能为空'
								}
							}
						},
						securityType: {
							validators: {
								notEmpty: {
									message: '证券类型不能为空'
								}
							}
						},
						exchangeName: {
							validators: {
								notEmpty: {
									message: '交易所名称不能为空'
								}
							}
						},
					}
					//*****阻止表单的按钮提交
				}).on('success.form.bv', function(e) {
					//阻止默认事件提交
					e.preventDefault();
				});
				
				//导入弹窗
				$("#securityButInput").click(function(){
					alert("导入");
					$("#myModalLabels").text("证券信息数据导入");
					$("#securityInput").modal();
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