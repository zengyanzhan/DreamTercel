$(function() {
	$("#myTable").bootstrapTable({
		url : '../selectAppropriationOrder.action',//请求的网址
		method: 'get', //请求方式（*）
		contentType:'application/json',
		toolbar: '#myTool', //工具按钮用哪个容器
		striped: true, //是否显示行间隔色
		//cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination: true, //是否显示分页（*）
		sortable: true, //是否启用排序
		sortOrder: "asc", //排序方式
		queryParams: function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					rows: params.limit, //页面大小
					page: params.offset / params.limit + 1, //页码
					strOrderDate:$("#str").val()=='' ? '' : ''+$("#str").val()+'',
							strToDate:$("#strToDate").val()=='' ? '' : ''+$("#strToDate").val()+'',
									cashName:$("input[name=cashNames]").val(),
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
		height: 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		//uniqueId : "usrId", //每一行的唯一标识，一般为主键列
		showToggle: false, //是否显示详细视图和列表视图的切换按钮
		cardView: false, //是否显示详细视图
		detailView: false, //是否显示父子表
		columns : [ {
			checkbox : true
		}, {
			field : 'code',
			title : '编号',
			sortable: true
		}, {
			field : 'strOrderDate',
			title : '指定日期',
		}, {
			field : 'strToDate',
			title : '到款日期',
		}, {
			field : 'cashName',
			title : '收款人',
		}, {
			field : 'cashBank',
			title : '收款银行',
		}, {
			field : 'cashCode',
			title : '收款卡号',
		}, {
			field : 'payName',
			title : '付款人',
		}, {
			field : 'payBank',
			title : '付款银行',
			formatter:function(value,index,row){
				return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
			}
		}, 
		{
			field : 'payCode',
			title : '付款卡号',
		},{
			field : 'money',
			title : '划款金额',
		},
		{
			field : 'allotFlag',
			title : '调拨标志',
			formatter : function(value, row, index) {
				if (value == 1) {
					return "未调拨";
				}
				else {
					return "已经调拨";
				}
			}
		}],

	})
	//生成资金调拨
	$("#btn_addAllot").click(function(){
		//alert("进来了")
		//得到所有选中的行
		var allRows = $("#myTable").bootstrapTable('getSelections')
		//判断选中的行数
		if (allRows.length == 0) { //没选中任何行
			//调用弹窗
			myAlert("请先选择一条数据");
			return;
		}else if (allRows.length > 1) {
			myAlert("只能选择一条数据进行修改");
			return;
		}else{
			//给文本框赋值
			$.each(allRows, function(i, oneRow) {
				if(oneRow.allotFlag==2){
					myAlert("您的数据已经调拨");
				}else{
					$.ajax({
						url:'../createMoneyAllot.action?code='+oneRow.code+'&strOrderDate='+oneRow.strOrderDate+'&strToDate='+oneRow.strToDate+'&cashCode='+oneRow.cashCode+'&money='+oneRow.money
						+'&payCode='+oneRow.payCode,
						contentType: "application/x-www-form-urlencoded; charset=UTF-8",
						success: function(msgs){
							myAlert(msgs);
						}
					})
				}
			});
		}
	})
	//导出
	$("#exportExcel").click(function(){
		var allRows = $("#myTable").bootstrapTable('getSelections')
		//判断选中的行数
		if (allRows.length == 0) { //没选中任何行
			//调用弹窗
			myAlert("请先选择一条数据");
			return;
		}else if (allRows.length > 1) {
			myAlert("只能选择一条数据进行修改");
			return;
		}else{
			//给文本框赋值
				$.each(allRows,function(i,v){
					window.open('../exportExcel.action?code='+v.code)
				
				})
	
		}
	})
//	给所有文本框添加提示框
	$('.clearData').tooltip({
		title : '不为空'
	});
//	去掉文本域的提示框
	$(".one").tooltip("destroy");
//	日期时间插件	
	$('#orderDates').datetimepicker({
		language : 'zh-CN',//显示中文
		format : 'yyyy-mm-dd',//格式化日期
		minView : 'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期
		autoclose : true,//自动关闭
		todayBtn : true
		//显示今天按钮
	});
	$('#dates').datetimepicker({
		language : 'zh-CN',//显示中文
		format : 'yyyy-mm-dd',//格式化日期
		minView : 'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期
		autoclose : true,//自动关闭\
		todayBtn : true
		//显示今天按钮
	});
	$('.del').click(function() {
		//alert("进入清除数据的方法");
		test();
	});
	//查询
	$("#btnSelect").click(function() {
		$("#myTable").bootstrapTable('refresh');
		//alert($("input[name=orderDates]").val())
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
			money : {
				//验证格式
				validators : {
					notEmpty : {
						message : '划款金额不能为空'
					},
					regexp: {
						regexp: /^[0-9]+$/,
						message: '划款金额只能为数字'
					}
				}
			},
			code:{
				validators : {
					notEmpty : {
						message : '划款编号不能为空'
					}
				}
			},
			allotFlag:{
				validators : {
					notEmpty : {
						message : '调拨标志不能为空'
					}
				}
			}

		},
		submitHandler : function(validator, form,
				submitButton) {
			//得到form表单
			var $form = $("#myForm");
			var title = $("#myModalLabel").text();
			var flag = '';
			if (title == '新增') {
				flag = 'insertApproOrder';
			} else {
				flag = 'updateApproOrder';
			}
			$('#myModal').modal("hide");
			$.ajax({
				type: "get",
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
					test();//清除数据
				}
			});

		}


	});
	$('#payCode').combogrid({
		panelWidth : 450, //表格宽度
		//panelHeight:500,//表格高度
		value : '', //输入的默认值（可写可不写）
		idField : 'cashAccountBankCard', //传输的列  
		textField : 'cashAccountBankCard', //显示的列
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
		            	  field : 'cashAccountBankCard',
		            	  title : '付款人卡号',
		            	  width : 120
		              }, {
		            	  field : 'cashAccountName',
		            	  title : '付款人',
		            	  width : 70
		              },
		              {
		            	  field : 'cashAccountBankName',
		            	  title : '付款银行',
		            	  width : 120
		              }] ],
		              onSelect:function(value,index,row){
		            	  $("input[name=payName]").val(index.cashAccountName);
		            	  $("input[name=payBank]").val(index.cashAccountBankName);
		              }
	}); 

	$('#cashCode').combogrid({
		panelWidth : 450, //表格宽度
		//panelHeight:500,//表格高度
		value : '', //输入的默认值（可写可不写）
		idField : 'cashAccountBankCard', //传输的列  
		textField : 'cashAccountBankCard', //显示的列
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
		            	  field : 'cashAccountBankCard',
		            	  title : '收款人卡号',
		            	  width : 120
		              }, {
		            	  field : 'cashAccountName',
		            	  title : '收款人',
		            	  width : 70
		              },
		              {
		            	  field : 'cashAccountBankName',
		            	  title : '收款银行',
		            	  width : 120
		              }] ],
		              onSelect:function(value,index,row){
		            	  $("input[name=cashName]").val(index.cashAccountName);
		            	  $("input[name=cashBank]").val(index.cashAccountBankName);
		              }
	}); 
	//增加
	$("#btn_add").click(function() {
		$('#date').datetimepicker({
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//格式化日期
			minView : 'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期
			autoclose : true,//自动关闭
			todayBtn : true
			//显示今天按钮
		});
		$('#strOrderDate').datetimepicker({
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//格式化日期
			minView : 'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期
			autoclose : true,//自动关闭
			todayBtn : true
			//显示今天按钮
		});

		$("#myModalLabel").text("新增");
		$('#myModal').modal();
		$.ajax({
			url:'../autoApproCode.action',
			success:function(code){
				$("input[name=code]").val(code);
			}
		})

	});
	//修改
	$("#btn_edit").click(function() {
		$('#date').datetimepicker({
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//格式化日期
			minView : 'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期
			autoclose : true,//自动关闭
			todayBtn : true
			//显示今天按钮
		});
		$('#strOrderDate').datetimepicker({
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//格式化日期
			minView : 'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期
			autoclose : true,//自动关闭
			todayBtn : true
			//显示今天按钮
		});
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
			$.ajax({
				url:'../selectApproCode.action?code='+oneRow.code,
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				success: function(msgs){
					var msg=eval("("+msgs+")");
					$.each(msg,function(i,v){
						$("input[name="+i+"]").val(v);
						$("select[name="+i+"]").val(v);
						$("textarea[name="+i+"]").val(v);
						if(i=='payCode'){
							$("#payCode").combogrid("setValue",v);
						}
						if(i=='cashCode'){
							$("#cashCode").combogrid("setValue",v);
						}
					})

				}
			})
		});
		$("#myModalLabel").text("修改");
		$('#myModal').modal();
	});
	//保存
	/*	$("#btnSave").click(function() {

	});*/
	//删除
	$("#btn_delete").click(function() {
		//得到所有选中的行
		var allRows = $("#myTable").bootstrapTable('getSelections')
		//判断选中的行数
		if (allRows.length == 0) { //没选中任何行
			//调用弹窗
			myAlert("请选则要删除的数据");
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
						var code=[];
						$.each(allRows,function(i,appro){
							code.push("'"+appro.code+"'");
						});
						$.ajax({
							type : "post",
							url : "../deleteAppro.action",
							data:"code="+code,
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

	var isRight="L0302";
	isHaveRight($("#btn_add"),$("#btn_edit"),$("#btn_delete"),isRight);
})
//清除数据的方法
function test() {
	$(".clearData").val("");
	$("#payCode").combogrid("setValue","");
	$("#cashCode").combogrid("setValue","");
	$(".one").val("");
	$("#myForm").data("bootstrapValidator").resetForm();
	$('.clearData').tooltip('destroy');
	$('.clearData').tooltip({
		title : '不为空'
	});
	$(".one").tooltip("destroy");
	/*	$("input[name=staticticsDate]").tooltip({
			title : '日期不能为空'
		});*/
}
