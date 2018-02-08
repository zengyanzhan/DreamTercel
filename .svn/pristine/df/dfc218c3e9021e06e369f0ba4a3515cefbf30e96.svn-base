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
$(function(){
	//判断是否为期初标志
	$("#checkboxChange").change(function(){
		//得到复选框是否选中，若是选中则为true,没有选中为false
		var flag=$("#checkboxChange").get(0).checked;
		if(flag){
			$("#btn_add").get(0).disabled=false;//选中变色
		}else{
			$("#btn_add").attr("disabled","disabled");//未选中点击不了

		}
	});
	//加载表格
	$('#myTable').bootstrapTable({
		url: '../selectCashArapStocks.action',
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
					businessDateWhere: $("#businessDateWhere").val()==''?'':''+$("#businessDateWhere").val()+'', //查询的参数   写自己的控制类对应的名字
							orderColumn: this.sortName,
							orderStyle: this.sortOrder,
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
			field: 'cashArapStockCode',
			title: '现金应收应付库存编号',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'cashAccountName',
			title: '现金账户名称'
		}, {
			field: 'fundCode',
			title: '基金代码'
		}, {
			field: 'fundName',
			title: '基金名称'
		}, {
			field: 'businessType',
			title: '业务类型',
			formatter: function(value, row, index) {
				if (value == 1) {
					return "管理费";
				} else if(value == 2){
					return "托管费";
				}else if(value == 3){
					return "存款利息";
				}else if(value == 4){
					return "申购赎回费";
				}
			}
		},{
			field: 'status',
			title: '业务状态',
			formatter: function(value, row, index) {
				if (value == 1) {
					return "应收";
				} else {
					return "应付";
				}
			}
		},{
			field: 'periodFlag',
			title: '期初标志',
			formatter: function(value, row, index) {
				if (value == 1) {
					return "是";
				} else {
					return "不是";
				}
			}
		},{
			field: 'totalMoney',
			title: '总金额 ',
			formatter: function(value,row,index){
				if(value==0){
					return '';
				}else{
					return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
				}
			}
		},{
			field: 'strDate',
			title: '业务日期'
		}]
	});

	//日期时间插件	
	$('#selectDate').datetimepicker({
		 language:'zh-CN',//显示中文
		 format:'yyyy-mm-dd',//格式化日期
		 minView:'month',//设置只显示到月份
		 // initialDate:new Date(),//初始化当前日期
		 autoclose:true,//自动关闭\
		 todayBtn:true//显示今天按钮
	});
	
	//给日期默认今天
	var today=new Date();
	var nowdate=(today.getFullYear())+"-"+(today.getMonth()+1)+"-"+today.getDate();
	//对日期格式进行处理
	var date=new Date(nowdate);
	var mon=date.getMonth()+1;
	var day = date.getDate();
	var mydate = date.getFullYear() + "-" + (mon < 10 ? "0" + mon : mon) + "-" + (day < 10 ? "0" + day : day);
	$("#businessDateWhere").val(mydate);
	
	
	$('#insertDate').datetimepicker({
		language:'zh-CN',//显示中文
		format:'yyyy-mm-dd',//格式化日期
		minView:'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期
		autoclose:true,//自动关闭\
		todayBtn:true//显示今天按钮
	});

	//增加按钮点击事件
	$("#btn_add").click(function() {
		$("#myForm").data("bootstrapValidator").resetForm();
		$.post("../ziDongShengChengCode.action",null,function(value){
			$("input[name=cashArapStockCode]").val(value);
			$('#myModal').modal();
			$("input[name=totalMoney]").val('');
			$('#cashAccountCode').combogrid('setValue', '');
			//$("select[name=periodFlag]").val('1');
			//$("select[name=periodFlag]").attr("readonly","readonly");
			$("select[name=status]").val('');
			$("select[name=businessType]").val('');
			$("input[name=cashArapStockDesc]").val('');
			$("#strDate").val('');
			$("#myModalLabel").text("新增");
		});
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
			var ids=[]; 
			$.each(allRows,function(i,value){
				ids.push(value.cashArapStockCode);//拼接
			});	
			window.dialog3 = jqueryAlert({
				'title': '温馨提示',
				'content': '您确定要删除数据吗？',
				'modal': true, //是否显示模型窗口
				'className': 'alertDialog',
				'buttons': { //按钮
					'确定': function() {
						window.dialog3.destroy();
						//ajax操作   （发送请求到数据库删除）
						$.ajax({
							type : "post",
							url : "../deleteCashArapStock.action",
							data: "ids="+ids,
							success : function(msg) {
								//刷新
								$("#myTable").bootstrapTable('refresh');
								myAlert(msg);
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
		$("#myForm").data("bootstrapValidator").resetForm();
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
		var ids=[]; 
		$.each(allRows,function(i,value){
			ids.push(value.cashArapStockCode);//拼接
		});	
		//ajac请求得到数据
		$.ajax({
			type: "post",
			url: "../selectCashArapStockById.action",
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			data:"cashArapStockCode="+ids,
			success: function(oneRow) {
				$("input[name=cashArapStockCode]").val(oneRow.cashArapStockCode);
				$("input[name=totalMoney]").val(oneRow.totalMoney);
				$('#fundCode').val(oneRow.fundCode);
				$('#cashAccountCode').combogrid('setValue', oneRow.cashAccountCode);
				$("select[name=periodFlag]").val(oneRow.periodFlag);
				$("select[name=periodFlag]").attr("readonly","readonly");
				$("select[name=status]").val(oneRow.status);
				$("select[name=businessType]").val(oneRow.businessType);
				$("input[name=cashArapStockDesc]").val(oneRow.cashArapStockDesc);
				$("#strDate").val(oneRow.strDate);
			}
		});  
		//将弹窗的标题改为修改
		$("#myModalLabel").text("修改");
		//弹窗窗口
		$('#myModal').modal();
	});




	//加载表单验证
	$("#myForm").bootstrapValidator(
			{
				//图标集
				feedbackIcons : {
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				//列字段
				fields : {
					cashArapStockCode : {
						//验证格式
						validators : {
							notEmpty : {
								message : '编号不能为空'
							},
						}
					},
					totalMoney : {
						validators : {
							notEmpty : {
								message : '总金额不能为空'
							},
							regexp: {
	                            regexp: /^[.0-9]+$/,
	                            message: '总金额只能为数字'
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
					periodFlag : {
						validators : {
							notEmpty : {
								message : '请选择初期标志',
							}
						}
					},
					businessType : {
						validators : {
							notEmpty : {
								message : '请选择业务类型',
							}
						}
					},
					status : {
						validators : {
							notEmpty : {
								message : '请选择业务状态',
							}
						}
					},
				},
		//*****阻止表单的按钮提交
		}).on('success.form.bv', function(e) {
			//阻止默认事件提交
			e.preventDefault();
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
			flag = 'insertCashArapStock';
		} else {
			flag = 'updateCashArapStock';
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

	/* 下拉表格部分 基金名称 */
	/*$('#fundCode').combogrid({
		panelWidth: 300, //表格宽度
		//panelHeight:500,//表格高度
		value: '', //输入的默认值（可写可不写）
		idField: 'fundCode', //传输的列  
		textField: 'fundName', //显示的列
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
		            	width: 110
		            }, {
		            	field: 'fundName',
		            	title: '基金名称',
		            	width: 110
		            }, 
		            ]
		          ]
	});*/
	/* 下拉表格部分现金账户名称 */
	$('#cashAccountCode').combogrid({
		panelWidth: 300, //表格宽度
		//panelHeight:500,//表格高度
		value: '', //输入的默认值（可写可不写）
		idField: 'cashAccountCode', //传输的列  
		textField: 'cashAccountCode', //显示的列
		fitColumns: true, //自动适应
		url: '../selectCashAccount.action', //服务器请求路径
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
		            	title: '现金账户表ID',
		            	width: 110
		            }, {
		            	field: 'cashAccountName',
		            	title: '账户名称',
		            	width: 110
		            },
		            ]
		          ]
	});
	//查询按钮的事件
	$("#btnSearch").click(function() {
		$("#myTable").bootstrapTable('refresh');
		//$("#businessDateWhere").val('');
	});


	var right='L0704';   
	isHaveRight($("#btn_add"),$("#btn_delete"),$("#btn_edit"),right)
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
		'closeTime': 3000, //时间
		'className': 'alertDialog'
	});
}
