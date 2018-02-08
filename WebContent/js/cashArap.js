$(function(){
	$('#myTable').bootstrapTable({
		url:'../selectCashArap.action',
		method:'get',//请求方式
		toolbar: '#toolbar',//工具栏
		contentType:'application/json',
		striped: true, //是否显示行间隔色
		pagination: true, //是否显示分页（*）
		sortable: true, //是否启用排序
		sortOrder: "asc", //排序方式
		queryParams: function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					rows: params.limit, //页面大小
					page: params.offset / params.limit + 1, //页码
					moneyDirection:$("#moneyDirection").val(),
					cashArapType:$("#cashArapTypeser").val(),
					strDateWhere:$("#strDateWhere").val(),
					sortName: this.sortName,
					sortOrder:this.sortOrder,
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
		height: 348, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		//uniqueId : "usrId", //每一行的唯一标识，一般为主键列
		showToggle: false, //是否显示详细视图和列表视图的切换按钮
		cardView: false, //是否显示详细视图
		detailView: false, //是否显示父子表
		//列字段
		columns: [{
			//复选框
			checkbox: true
		}, {
			field: 'cashArapCode',
			title: '现金应收应付编号',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'cashAccountCode',
			title: '现金账户 '
		},{
			field: 'fundCode',
			title: '基金编号'
		},{
			field: 'cashArapType',
			title: '业务类型 ',
			formatter: function(value, rowDate, rowIndex){
				if(value==1){
					return '资金管理费';
				}else if(value==2){
					return '托管费';
				}else if(value==3){
					return '存款利息';
				}else{
					return '申购赎回款';
				}
			}
		},{
			field: 'moneyDirection',
			title: '资金流向',
			formatter: function(value, rowDate, rowIndex){
				if(value==1){
					return '流入';
				}else{
					return '流出';
				}
			}
		},{
			field: 'money',
			title: '金额',
			formatter:function(value,index,row){
				return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
			}
		},{
			field: 'strDate',
			title: '业务日期'
		},{
			field: 'cashArapDesc',
			title: '备注'
		},]
	})
	//日期时间插件	
	$('#strDate').datetimepicker({
		language:'zh-CN',//显示中文
		format:'yyyy-mm-dd',//格式化日期
		minView:'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期
		autoclose:true,//自动关闭\
		todayBtn:true//显示今天按钮
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
			'style' : 'wap',
			//'modal':false,//添加整个屏幕的大背景
			'content' : message, //显示内容 
			'animateType' : 'linear', //弹框出现的方式 scale linear 其他为fadeIn动画
			'contentTextAlign' : 'center', //设置content显示的位置 center left right
			'width' : '300',
			//'height':'100',
			'minWidth' : '160',
			'closeTime' : 1000, //时间
			'className' : 'alertDialog'
		});
	};
	//查询
	$("#btnSelect").click(function() {
		var a=$("#strDateWhere").val();
		var b=$("#cashArapTypeser").val();
		$("#myTable").bootstrapTable('refresh');
	});
	//加载表单验证
	$("#myForm").bootstrapValidator({
		//图标集
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		//列字段
		fields : {
			cashArapCode : {
				//验证格式
				validators : {
					notEmpty : {
						message : '编号不能为空'
					},
				}
			},
			cashAccountCode : {
				message : '现金账户错误',
				validators : {
					notEmpty : {
						message : '现金账户不能为空'
					},
				}
			},
			fundCode : {
				message : '基金编号错误',
				validators : {
					notEmpty : {
						message : '基金编号不能为空'
					},
				}
			},
			strDate : {
				validators : {
					notEmpty : {
						message : '日期不能为空'
					}
				}
			},
			money : {
				validators : {
					notEmpty : {
						message : '金额不能为空'
					},
					regexp: {
                        regexp:/^\d+(\.\d+)?$/,
                        message: '金额只能输入0-9的数字'
                    }
				}
			},
		}
		//*****阻止表单的按钮提交
	}).on('success.form.bv', function(e) {
		//阻止默认事件提交
		e.preventDefault();
	});
	//增加
	$("#btnInsert").click(function() {
		$.ajax({
			type : "post",
			url : "../autoCashArapBianhao.action",
			//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
			data : $("#myForm").serializeArray(),
			success : function(msgs) {
				$("input[name=cashArapCode]").val(msgs);
			}
		});
		$("input[name=cashArapCode]").val("");
		$("input[name=cashAccountCode]").val("");
		$("input[name=fundCode]").val("");
		$("input[name=money]").val("");
		$("input[name=businessDate]").val("");
		$("input[name=cashArapDesc]").val("");
		$("input[name=cashArapType]").val("");
		$("input[name=moneyDirection]").val("");
		//$("myForm").data("bootstrapValidator").resetForm();
		$("#myModalLabel").text("新增");
		$('#myModal').modal('show');
		$('#strDateser').datetimepicker({
			widht : '230px',
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//格式化日期
			minView : 'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期
			autoclose : true,//自动关闭\
			todayBtn : true
			//显示今天按钮
		});	
	});
	//修改
	$("#btnUpdate").click(function() {
		$('#strDate').datetimepicker({
			widht : '230px',
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//格式化日期
			minView : 'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期
			autoclose : true,//自动关闭\
			todayBtn : true
			//显示今天按钮
		});
		//得到所有选中的行
		var allRows = $("#myTable").bootstrapTable('getSelections')
		//判断选中的行数
		if (allRows.length == 0) { //没选中任何行
			//调用弹窗
			myAlert("请选择要修改的数据");
			return;
		} else if (allRows.length > 1) {
			myAlert("只能选择一条数据进行修改");
			return;
		}
		//给文本框赋值
		$.each(allRows, function(i, value) {
			$.ajax({
				url:'../selectCashArapById.action?cashArapCode='+value.cashArapCode,
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				success: function(msgs){
					var msg=eval("("+msgs+")");
					$.each(msg,function(i,v){
						$("input[name="+i+"]").val(v);
						$("select[name="+i+"]").val(v);
						$("textarea[name="+i+"]").val(v);
					})
				}
			})
		});
		$("#myModalLabel").text("修改");
		$('#myModal').modal();
	});
	//保存
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
		var title = $("#myModalLabel").text();
		var flag = '';
		if (title == '新增') {
			flag = 'insertCashArap';
		} else {
			flag = 'updateCashArap';
		}
		$('#myModal').modal("hide");
		$.ajax({
			type: "post",
			url: "../"+flag + ".action",
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
	//删除
	$("#btnDelete").click(function() {
		//得到所有选中的行
		var allRows = $("#myTable").bootstrapTable('getSelections')
		//判断选中的行数
		if (allRows.length == 0) { //没选中任何行
			//调用弹窗
			myAlert("请选择要删除的数据");
			return;
		}else {
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
						//ajax操作   （发送请求到数据库删除）
						var cashArapCode=[];
						$.each(allRows,function(i,cashArap){
							cashArapCode.push("'"+cashArap.cashArapCode+"'");
						});
						$.ajax({
							type : "post",
							url : "../deleteCashArap.action",
							data:"cashArapCode="+cashArapCode,
							success : function(msgs) {
								$("#myTable").bootstrapTable('refresh');
								//刷新
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
	var right="L0206";
	isHaveRight($("#btnInsert"),$("#btnDelete"),$("#btnDelete"),right);
});