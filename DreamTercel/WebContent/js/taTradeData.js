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
	$('#taTradeDate').datetimepicker({
		language:'zh-CN',//显示中文
		format:'yyyy-mm-dd',//格式化日期
		minView:'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期
		autoclose:true,//自动关闭\
		todayBtn:true//显示今天按钮
	});
	$('#settleDate').datetimepicker({
		language:'zh-CN',//显示中文
		format:'yyyy-mm-dd',//格式化日期
		minView:'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期
		autoclose:true,//自动关闭\
		todayBtn:true//显示今天按钮
	});
	
	/* 下拉表格部分 */
	$('#cashAccountCode').combogrid({
		panelWidth: 450, //表格宽度
		//panelHeight:500,//表格高度
		value: '', //输入的默认值（可写可不写）
		idField: 'cashAccountCode', //传输的列  
		textField: 'cashAccountCode', //显示的列
		fitColumns: true, //自动适应
		url: '../selectCashAccount.action',
		method:'get',//请求方式', //服务器请求路径
		mode: 'remote', //定义在文本改变的时候如何读取数据。设置为'remote'，
		//数据表格将从远程服务器加载数据。当设置为'remote'模式的时候
		//，用户输入将会发送到名为'q'的http请求参数，向服务器检索新的数据。
		pagination: true, //分页条
		pageSize: 5,
		pageList: [5, 10, 15, 20, 25],
		columns: [
		          [ //表格列   
		            {
		            	field: 'cashAccountCode',
		            	title: '现金账户',
		            	width: 60
		            }, {
		            	field: 'cashAccountName',
		            	title: '账户名称',
		            	width: 100
		            }, {
		            	field: 'cashAccountBankCard',
		            	title: '银行卡号',
		            	width: 120
		            },
		            ]
		          ]
	});
	
	//交易类型改变改变结算日期
	$("#taRadeType").change(function(){
		//得到成交日期
		var tradeDate=$("#tradeDate").val();
		var taRadeType=$("#taRadeType").val();
		$.ajax({
			type: "post",
			url: '../taTradeData/selectHoildayByDradeDate.action',
			data:'tradeDate='+tradeDate+'&taRadeType='+taRadeType,
			success: function(msgs) {
				$("#settlesDate").val(msgs);
			}
		})
	});
	//成交日期改变也改变结算日期
	$("#tradeDate").change(function(){
		//得到成交日期
		var tradeDate=$("#tradeDate").val();
		var taRadeType=$("#taRadeType").val();
		
		$.post("../ziDongShengChengBH.action?taTradeDate="+tradeDate,null,function(value){
			$("input[name=taTradDataCode]").val(value);
		});
		
		
		$.ajax({
			type: "post",
			url: '../taTradeData/selectHoildayByDradeDate.action',
			data:'tradeDate='+tradeDate+'&taRadeType='+taRadeType,
			success: function(msgs) {
				$("#settlesDate").val(msgs);
			}
		})
	});
	
	
});
//计算总金额
function suan() {
	var taTradQuality=$("#taTradQuality").val();//得到数量
	var taUnitMoney=$("#taUnitMoney").val();//得到单价
	$("#taTotalMoney").val(taTradQuality*taUnitMoney);
	
}
//计算实际金额
function jisuan() {
	var taTotalMoney=$("#taTotalMoney").val();//得到总金额
	var fee=$("#fee").val();//得到总金额
	$("#taRealMoney").val(taTotalMoney-fee);
}
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
		$("#deslateTable").bootstrapTable({
			url: '../selectTaTradData.action',
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
						taRadeTypeWhere: $('select[name=taRadeTypeWhere]').val(), //查询的参数   写自己的控制类对应的名字
						taTradeStatusWhere: $('select[name=taTradeStatusWhere]').val(),
						settleDateWhere:$("#settleDateWhere").val(),//查询的参数   写自己的控制类对应的名字
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
			columns: [{
				//复选框
				checkbox: true
			}, {
				field: 'taTradDataCode',
				title: 'TA编号',
				//启用该字段的排序
				sortable: true
			}, /*{
				field: 'cashAccountCode',
				title: '账户'
			}, */{
				field: 'fundCode',
				title: '基金名称'
			}, {
				field: 'taUnitMoney',
				title: '单价',
				formatter: function(value,row,index){
					return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
				}
			}, {
				field: 'taTradQuality',
				title: '基金数量',
				formatter: function(value,row,index){
					return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
				}
			}, {
				field: 'taTotalMoney',
				title: '总金额',
				formatter: function(value,row,index){
					return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
				}
			}, {
				field: 'agencies',
				title: '代销机构',
				formatter:function(value,row,index){
					if(value==1){
						return "建设银行";
					}else if(value==2){
						return "工商银行";
					}else if(value==3){
						return "农业银行";
					}
				}
			}, {
				field: 'taRadeType',
				title: '交易类型',
				formatter:function(value,row,index){
					if(value==1){
						return "认购";
					}else if(value==2){
						return "申购";
					}else if(value==3){
						return "赎回";
					}
				}
			}, {
				field: 'taTradeStatus',
				title: '交易状态',
				formatter:function(value,row,index){
					if(value==1){
						return "已结算";
					}else if(value==2){
						return "未结算";
					}
				}
			}, {
				field: 'settlesDate',
				title: '结算日期',
			}]

		});
		
		$("#shInput").click(function(){
			$("#myModalLabel").text("申购");
			$("#inputDate").modal();
		});

		$("#TaShInput").click(function(){
			$("#modalLabels").text("赎回");
			$("#TaShOutput").modal();
		});
			//查询按钮的时间
			$("#btnSearch").click(function(){
				$("#deslateTable").bootstrapTable('refresh');
			});

			//增加按钮点击事件
			$("#btn_add").click(function() {
			
				$.post("../taReTradeByFundId.action",null,function(msg){
					$("input[name=fundCode]").val(msg);
				});
				$("input[name=taTradDataCode]").val("");
				$("input[name=taTradQuality]").val("");
				$("#cashAccountCode").combogrid('setValue', "");
				$("input[name=taTotalMoney]").val("");
				$("input[name=taRealMoney]").val("");
				$("input[name=tradeDate]").val("");
				$("input[name=settlesDate]").val("");
				$("input[name=taUnitMoney]").val("");
				$("input[name=fee]").val("");
				$("#agencies").val("");
				$("#taRadeType").val("");
				$("#taTradeStatus").val("");
				$("input[name=taTradDataDesc]").val("");
				$("select[name=taTradeStatus]").val("2");//设置交易状态为未结算
				$("select[name=taRadeType]").val("2");//设置交易类型为申购
				
				$("#myForm").data("bootstrapValidator").resetForm();
				
				
				$("#myModalLabels").text("新增");
				$('#myModal').modal();
			});
			//删除按钮的点击事件
			$("#btn_delete").click(function() {
				//得到所有选中的行
				var allRows = $("#deslateTable").bootstrapTable('getSelections')
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
									arr.push(v.taTradDataCode);
								})
//								alert("点击删除的时候得到的数据是="+arr);
								//ajax操作   （发送请求到数据库删除）
								$.ajax({
									url:'../deleteTaTradDataByTaTradDataId.action',
									type: "post",
									contentType: "application/x-www-form-urlencoded; charset=UTF-8",
									data: 'taTradDataCode='+arr,
									success: function(msgs) {
										//刷新表格
										$("#deslateTable").bootstrapTable('refresh');
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
				var allRows = $("#deslateTable").bootstrapTable('getSelections')
				//判断选中的行数
				if (allRows.length == 0) { //没选中任何行
					//调用弹窗
					myAlert("请选择要修改的数据");
					return;
				} else if (allRows.length > 1) {
					myAlert("只能选择一条数据进行修改");
					return;
				}
				$("#myModalLabels").text("修改");
				var arr=[];
				$.each(allRows,function(i,v){
					arr.push(v.taTradDataCode);
				});
				//ajax发送请求
				$.ajax({
					type: "post",
					url: "../selectTaTradDataById.action",
					data: 'taTradDataCode='+arr,
					success: function(oneRow) {
						$("input[name=taTotalMoney]").val(oneRow.taTotalMoney);
						$("input[name=taTradDataCode]").val(oneRow.taTradDataCode);
						$("#fundCode").val(oneRow.fundCode);
						$("input[name=taTradQuality]").val(oneRow.taTradQuality);
						$("#cashAccountCode").combogrid("setValue",oneRow.cashAccountCode);
						$("input[name=taTotalMoney]").val(oneRow.taTotalMoney);
						$("input[name=taRealMoney]").val(oneRow.taRealMoney);
						$("input[name=tradeDate]").val(oneRow.tradeDate);
						$("input[name=settlesDate]").val(oneRow.settlesDate);
						$("input[name=taUnitMoney]").val(oneRow.taUnitMoney);
						$("input[name=fee]").val(oneRow.fee);
						$("select[name=agencies]").val(oneRow.agencies);
						$("select[name=taRadeType]").val(oneRow.taRadeType);
						$("select[name=taTradeStatus]").val(oneRow.taTradeStatus);
						$("input[name=taTradDataDesc]").val(oneRow.taTradDataDesc);
					}
				});
				//弹窗窗口
				$('#myModal').modal();
			});
			/* 保存事件 */
			$("#btnSave").click(function() {
//				alert("进入1");
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
//				alert($form.serializeArray());
				var fundCode=$("input[name=fundCode]").val();
				//var cashAccountCode=$("#cashAccountCode").combogrid("getValues");
//				alert(fundCode);
				//得带弹窗的标题判断  是增加还是修改
				var title = $("#myModalLabels").text();
				var flag = '';
				if (title == '新增') {
					flag ='insertTaTradData';
				} else {
					flag = 'updateTaTradData';
				}
				//	$('#myModal').modal("hide");
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
						$("#deslateTable").bootstrapTable('refresh');
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
					taTradQuality: {
						//验证格式
						validators: {
							regexp: {
								regexp: /^[.0-9_]+$/,
								message: '数量只能是数字'
							}
							}
							},
							taUnitMoney: {
								validators: {
								regexp: {
									regexp: /^[.0-9_]+$/,
									message: '数量只能是数字'
								}
								}	
							},
							fee: {
							validators: {
							regexp: {
								regexp: /^[.0-9_]+$/,
								message: '数量只能是数字'
									}
								}
							}
					},
				//*****阻止表单的按钮提交
			}).on('success.form.bv', function(e) {
				//阻止默认事件提交
				e.preventDefault();
			});
			var right='L0401';
			isHaveRight($("#btn_add"),$("#btn_edit"),$("#btn_delete"),right);
		
//		定义提示弹窗的方法
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
	});

