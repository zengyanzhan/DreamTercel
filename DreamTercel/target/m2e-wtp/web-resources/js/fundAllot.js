	$(function() {
		$("#myTable").bootstrapTable({
			url : 'boot.action',//请求的网址
			method : 'get',//请求的方式
			height : 500,//定义表格的高度
			columns : [ {
				checkbox : true
			}, {
				field : 'code',
				title : '资金调拨编号'
			}, {
				field : 'accountCode',
				title : '银行卡号'
			}, {
				field : 'allotMoney ',
				titile : '调拨资金'
			}, {
				field : 'operateDate',
				title : '业务日期'
			}, {
				field : 'allotDate',
				title : '调拨日期'
			}, {
				field : 'businessCode',
				title : '业务编号'
			}, {
				field : 'allotType',
				title : '调拨类型'
			}, {
				field : 'moneyDirection',
				title : '资金流向'
			}, {
				field : 'desc',
				title : '备注'
			} ],
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, //初始化加载第一页，默认第一页
			pageSize : 5, //每页的记录行数（*）
			pageList : [ 5, 10, 15, 20 ], //可供选择的每页的行数（*）
			showColumns : true, //是否显示所有的列
			showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 2, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行
			height : 600, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			//uniqueId : "usrId", //每一行的唯一标识，一般为主键列
			showToggle : false, //是否显示详细视图和列表视图的切换按钮
			cardView : false, //是否显示详细视图
			detailView : false, //是否显示父子表
			toolbar : '#myTool',

		})
		//得到日期文本框的值 
		$("input[name=allDate]").change(function(){

			if ($(this).val() != '') {
				$(this).tooltip("destroy");
			} else {
				$(this).tooltip({
					title : '日期不能为空'
				});
			}
		})
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
			widht : '230px',
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//格式化日期
			minView : 'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期
			autoclose : true,//自动关闭\
			todayBtn : true
		//显示今天按钮
		});
		$('#businessDates').datetimepicker({
			widht : '230px',
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//格式化日期
			minView : 'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期
			autoclose : true,//自动关闭\
			todayBtn : true
		//显示今天按钮
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
				code : {
					//验证格式
					validators : {
						notEmpty : {
							message : '资金编号不能为空'
						},
					}
				},
				accountCode : {
					message : '银行编号验证失败',
					validators : {
						notEmpty : {
							message : '银行编号不能为空'
						},
					}
				},
				allotMoney : {
					validators : {
						notEmpty : {
							message : '调拨资金不能为空'
						},
					}
				},
				operateDate : {
					validators : {
						notEmpty : {
							message : '业务日期不能为空'
						}
					}
				},
				allotDate : {
					validators : {
						notEmpty : {
							message : '调拨日期不能为空'
						}
					}

				},
				businessCode : {
					validators : {
						notEmpty : {
							message : '业务编号不能为空'
						}
					}

				}

			}
		//*****阻止表单的按钮提交
		}).on('success.form.bv', function(e) {
			//阻止默认事件提交
			e.preventDefault();
		});

		//增加
		$("#btnInsert").click(function() {
			$("#myModalLabel").text("新增");
			$('#myModal').modal();
			$('#allDate').datetimepicker({
				widht : '230px',
				language : 'zh-CN',//显示中文
				format : 'yyyy-mm-dd',//格式化日期
				minView : 'month',//设置只显示到月份
				// initialDate:new Date(),//初始化当前日期
				autoclose : true,//自动关闭\
				todayBtn : true
			//显示今天按钮
			});
			$('#businessDate').datetimepicker({
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
			$("#myModalLabel").text("修改");
			$('#myModal').modal();
		});
		//保存
		$("#btnSave").click(function() {
			var title = $("#myModalLabel").text();
			alert("title=" + title)
		});
		//删除
		$("#btnDelete").click(function() {
			//得到所有选中的行
			var allRows = $("#myTable").bootstrapTable('getSelections')
			//判断选中的行数
			if (allRows.length == 0) { //没选中任何行
				//调用弹窗
				myAlert("请选则要删除的数据");
				return;
			}
		});
	})
