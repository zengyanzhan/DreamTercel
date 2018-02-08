$(function (){
//加载表格
	$('#myTable').bootstrapTable({
		url: '../selectSaveingBusiness.action',
		method: 'get', //请求方式（*）
		contentType:'application/json;charset=UTF-8',
		toolbar: '#toolbar', //工具按钮用哪个容器
		striped: true, //是否显示行间隔色
		//cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination: true, //是否显示分页（*）
		sortable: true, //是否启用排序
		sortOrder: "asc", //排序方式
		queryParams: function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一致，这边改动，控制器也需要改成一样的
				rows: params.limit, //页面大小
				page: params.offset / params.limit + 1, //页码
				CashStockCode:$("input[name=code]").val()=='' ? '' : ''+$("input[name=code]").val()+'', //查询的参数   写自己的控制类对应的名字
				sortName: this.sortName,
				sortOrder: this.sortOrder,
				strDate:$("input[name=stDate]").val()=='' ? '' : ''+$("input[name=stDate]").val()+'',
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
			field: 'SavingCode',
			title: '存款业务编号',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'FundCode',
			title: '基金代码'
		}, {
			field: 'OutCashAccountCode',
			title: '流入'
		}, {
			field: 'InCashAccountCode',
			title: '流出'
		}, {
			field: 'strDate',
			title: '业务日期',
		},{
			field: 'BusinessType',
			title: '业务类型'
		},{
			field: 'SavingMoney',
			title: '存款金额'
		},{
			field: 'SavingInterest',
			title: '所得利息'
		},{
			field: 'strDate',
			title: '到期日期'
		},{
			field: 'Flag',
			title: '办理标志'
		},{
			field: 'Desc',
			title: '备注'
		}]
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
			var strDate=$('#strDate').val();
			alert(strDate);
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
				 			arr.push(v.SavingCode);
				 		})
						//ajax操作   （发送请求到数据库删除）
				 		alert("删除框");
					$.ajax({
							type:'post',
							url:'../deleteSaveingBusiness.action',
							data:'SavingCode='+arr,
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
		var date=new Date();
		var result=date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();	//转日期	
	});
	//时间日期插件
	$('#strDate').datetimepicker({
		 language:'zh-CN',//显示中文
		 format:'yyyy-mm-dd',//格式化日期
		 minView:'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期 SdDate
		 autoclose:true,//自动关闭\
		 todayBtn:true//显示今天按钮
	});
	$('#SavingEndDate').datetimepicker({
		 language:'zh-CN',//显示中文
		 format:'yyyy-mm-dd',//格式化日期
		 minView:'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期 SdDate
		 autoclose:true,//自动关闭\
		 todayBtn:true//显示今天按钮
	});
	$('#StartDate').datetimepicker({
		 language:'zh-CN',//显示中文
		 format:'yyyy-mm-dd',//格式化日期
		 minView:'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期 SdDate
		 autoclose:true,//自动关闭\
		 todayBtn:true//显示今天按钮
	});
	$('#EndDate').datetimepicker({
		 language:'zh-CN',//显示中文
		 format:'yyyy-mm-dd',//格式化日期
		 minView:'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期 SdDate
		 autoclose:true,//自动关闭\
		 todayBtn:true//显示今天按钮
	});
	//增加按钮点击事件
	$("#btn_add").click(function() {
		//alert("增加按钮");
		//将弹窗的标题改为新增
		$("#myModalLabel").text("新增");
		$('#myModal').modal();
		$("input[name=SavingCode]").val("");
		$("input[name=FundCode]").val("");
		$("input[name=OutCashAccountCode]").val("");
		$("input[name=InCashAccountCode]").val("");
		$("input[name=strDate]").val("");
		$("input[name=BusinessType]").val("");
		$("input[name=SavingMoney]").val("");
		$("input[name=SavingInterest]").val("");
		//$("input[name=SavingEndDate]").val("");
		$("input[name=Flag]").val("");
		$("input[name=Desc]").val("");
		$("#myForm").data("bootstrapValidator").resetForm();
		//alert("增加的弹窗");
		
		//var SavingCodeR=$('SavingCodeR').val(SavingCode);
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
		
		
		
		$.each(allRows, function(i,value) {
		//ajax发送请求
		$.ajax({
			type:"post",
			url:"../selectSaveingBusinessByCode.action?SavingCode="+value.SavingCode,
			/*success:function(oneRow){
				$("input[name=CashStockCode]").val(oneRow.CashStockCode);
				$("input[name=FundCode]").val(oneRow.FundCode);
				$("input[name=CashBlance]").val(oneRow.CashBlance);
				$("input[name=CashAccountCode]").val(oneRow.CashAccountCode);
				$("input[name=strDate]").val(oneRow.strDate);
				$("input[name=PeriodFlag]").val(oneRow.PeriodFlag);
				$("input[name=CashDesc]").val(oneRow.CashDesc);*/
			success: function(msgs){
				var msg=eval("("+msgs+")");
				//alert(msg);
				$.each(msg,function(i,v){
					$("input[name="+i+"]").val(v);
					$("select[name="+i+"]").val(v);
					$("textarea[name="+i+"]").val(v);
				})
			
				//验证
				var $form = $("#myForm");
				var data = $form.data('bootstrapValidator');
				if (data) {
					// 修复记忆的组件不验证
					data.validate();
				}
			}
		});
	});
		//将弹窗的标题改为修改
		$("#myModalLabel").text("修改");
		//弹窗窗口
		$('#myModal').modal();
		$('#strDate').datetimepicker({
			 language:'zh-CN',//显示中文
			 format:'yyyy-mm-dd',//格式化日期
			 minView:'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期 
			 autoclose:true,//自动关闭\
			 todayBtn:true//显示今天按钮
		});
		$('#SavingEndDate').datetimepicker({
			 language:'zh-CN',//显示中文
			 format:'yyyy-mm-dd',//格式化日期
			 minView:'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期 SdDate
			 autoclose:true,//自动关闭\
			 todayBtn:true//显示今天按钮SavingEndDate
		});
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
			flag = 'insertSaveingBusiness';
		} else {
			flag = 'updateSaveingBusiness';
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
		var right='L0203';
		isHaveRight($("#btn_add"),$("#btn_edit"),$("#btn_delete"),right);
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
			SavingCode: {
				//验证格式
				validators: {
					notEmpty: {
						message: '请填写存款业务编号'
					},
				}
			},
			FundCode: {
				//message: '用户名验证失败',
				validators: {
					notEmpty: {
						message: '请填写基金编号(名称)'
					}
				}
			},
			
			OutCashAccountCode: {
				validators: {
					notEmpty: {
						message: '请填写资金流出(现金账户名称)'
					}
					
				}
			},
			InCashAccountCode: {
				validators: {
					notEmpty: {
						message: '请填写资金流入(现金账户名称)'
					}
					
				}
			},
			//bankSavingCode,fundCode,outCashAccountCode,inCashAccountCode,businessDate
			//,businessType,savingMoney,savingInterest,savingEndDate,flag,desc
			strDate: {
				validators: {
					notEmpty: {
						message: '请填写业务办理时间'
					}
					
				}
			},
			BusinessType: {
				validators: {
					notEmpty: {
						message: '请填写业务类型 1代表3天，2代表7天'
					},
					regexp: {
						regexp: /^[1-2]+$/,
						message: '请选择1或者2'
					}
					
				}
			},
			SavingMoney: {
				validators: {
					notEmpty: {
						message: '请填写存款的金额数目'
					}
					
				}
			},
			SavingInterest: {
				validators: {
					notEmpty: {
						message: '请填写存款业务所得的利息'
					}
					
				}
			},
			SavingEndDate: {
				validators: {
					notEmpty: {
						message: '请填写业务到期时间'
					}
					
				}
			},
			Flag: {
				validators: {
					notEmpty: {
						message: '请填写到期办理标志 1到期未办理 2到期已办理'
					},
					regexp: {
						regexp: /^[1-2]+$/,
						message: '请选择1到期未办理 2到期已办理'
					}
					
				}
			},
			Desc: {
				validators: {
					notEmpty: {
						message: '请填写存款业务备注'
					}
				}
			}
		}
		//*****阻止表单的按钮提交
	}).on('success.form.bv', function(e) {
		//阻止默认事件提交
		e.preventDefault();
	});
	//查询的方法
	$("#btnSearch").click(function(){
		alert("查询");
		//刷新表格
		$("#myTable").bootstrapTable('refresh');
	});
	
				
})