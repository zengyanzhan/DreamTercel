$(function() {

	$("#myTable").bootstrapTable({
		url : '../selectMoneyAllot.action',//请求的网址
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
					type:$("#types").val(),
					strDate:$("input[name=allDates]").val()=='' ? '' : ''+$("input[name=allDates]").val()+'',
							sortName: this.sortName,
							sortOrder: this.sortOrder,
							strBusinessDate:$("input[name=businessDates]").val()=='' ? '' : ''+$("input[name=businessDates]").val()+'',
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
			title : '资金调拨编号',
			sortable: true
		}, {
			field : 'accountCode',
			title : '银行卡号',
		},  {
			field : 'strBusinessDate',
			title : '业务日期',
		}, {
			field : 'strDate',
			title : '调拨日期',
		}, {
			field : 'businessCode',
			title : '业务编号',
		}, {
			field : 'type',
			title : '调拨类型',
			formatter : function(value, row, index) {
				if (value == 1) {
					return "存款利息";
				}if(value == 5){
					return "债券利息";
				} if(value==2){
					return "申购赎回清算款";
				}
				if(value==3){
					return "买卖交易清算款";
				}
				if(value==4){
					return "两费利息";
				}
			}
		},{
			field : 'direction',
			title : '资金流向',
			formatter : function(value, row, index) {
				if (value == 1) {
					return "流入";
				} else {
					return "流出";
				}
			}
	
			
		}, {
			field : 'money',
			title : '调拨资金',
			formatter:function(value,index,row){
				return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
			}
		}],

	})
	//给所有文本框添加提示框
	$('.clearData').tooltip({
		title : '不为空'
	});
	//去掉文本域的提示框
	$(".one").tooltip("destroy");
	//得到日期文本框的值 

	/*	$("input[name=allDate]").change(function(){

		if ($(this).val() != '') {
			$(this).tooltip("destroy");
		} else {
			$(this).tooltip({
				title : '日期不能为空'
			});
		}
	})*/
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
	}
	;
	//日期时间插件	
	$('#allDates').datetimepicker({
		language : 'zh-CN',//显示中文
		format : 'yyyy-mm-dd',//格式化日期
		minView : 'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期
		autoclose : true,//自动关闭\
		todayBtn : true
		//显示今天按钮
	});
	$('#businessDates').datetimepicker({
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
			fundCode : {
				//验证格式
				validators : {
					notEmpty : {
						message : '资金编号不能为空'
					},
				}
			},
			money : {
				validators : {
					notEmpty : {
						message : '调拨资金不能为空'
					},regexp: {
						regexp: /^[0-9]+$/,
						message: '调拨资金只能为数字'
					}
				}
			},
			businessCode : {
				validators : {
					notEmpty : {
						message : '业务编号不能为空'
					}
				}

			},
			direction : {
				validators : {
					notEmpty : {
						message : '资金流向不能为空'
					}
				}
			},
			type : {
				validators : {
					notEmpty : {
						message : '调拨类型不能为空'
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
				flag = 'insertMoneyAllot';
			} else {

				flag = 'updateMoneyAllot';
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
					test();//清除数据
				}
			});

		}

	});
	$('#accountCode').combogrid({
		panelWidth : 450, //表格宽度
		//panelHeight:500,//表格高度
		value : '', //输入的默认值（可写可不写）
		idField : 'cashAccountCode', //传输的列  
		textField : 'cashAccountCode', //显示的列
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
		            	  field : 'cashAccountCode',
		            	  title : '付款人账号',
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
	}); 

	//增加
	$("#btn_add").click(function() {
		$("#myModalLabel").text("新增");
		$('#myModal').modal();
		
		$("#strBusinessDate").change(function(){
			$.ajax({
				url:'../autoBianHao.action?strBusinessDate='+$("input[name=strBusinessDate]").val(),
				success:function(code){
					$("input[name=code]").val(code);
				}
			})
		})
	
		$('#strDate').datetimepicker({
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//格式化日期
			minView : 'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期
			autoclose : true,//自动关闭\
			todayBtn : true
			//显示今天按钮
		});
		$('#strBusinessDate').datetimepicker({
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//格式化日期
			minView : 'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期
			autoclose : true,//自动关闭\
			todayBtn : true
			//显示今天按钮
		});

		/*	$(".form-control").tooltip({
			title:'不为空'
		})*/

	});
	//修改
	$("#btn_edit").click(function() {
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
		$('#strBusinessDate').datetimepicker({
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
			myAlert("请选则要修改的数据");
			return;
		} else if (allRows.length > 1) {
			myAlert("只能选择一条数据进行修改");
			return;
		}
		//给文本框赋值
		$.each(allRows, function(i, oneRow) {
			$.ajax({
				url:'../selectMoneyAllotByCode.action?code='+oneRow.code,
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				success: function(msgs){
					var msg=eval("("+msgs+")");
					$.each(msg,function(i,v){
						$("input[name="+i+"]").val(v);
						$("select[name="+i+"]").val(v);
						$("textarea[name="+i+"]").val(v);
						if(i=='accountCode'){
							$("#accountCode").combogrid("setValue",v);
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
						$.each(allRows,function(i,moneyAllot){
							code.push("'"+moneyAllot.code+"'");
						});
						$.ajax({
							type : "post",
							url : "../deleteMoneyAllot.action",
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

	var isRight="L0301";
	isHaveRight($("#btn_add"),$("#btn_edit"),$("#btn_delete"),isRight);
})
//清除数据的方法
function test() {
	$(".clearData").val("");
	$(".one").val("");
	$("#accountCode").combogrid("setValue","");
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
