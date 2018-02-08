var flag='cash';
$(function(){
	//日期时间插件	
	$('#businessDatess').datetimepicker({
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
	$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		// 获取已激活的标签页的名称
		var activeTab = $(e.target).text(); 
		if(activeTab=='现金计息'){
			flag="cash";
		}else if(activeTab=="债券计息"){
			flag="bond";
		} else if(activeTab=='两费'){
			flag="twoFee";
		}
		// 获取前一个激活的标签页的名称
		var previousTab = $(e.relatedTarget).text(); 
		$(".active-tab span").html(activeTab);
		$(".previous-tab span").html(previousTab);
	});
	$('#betweenTable1').bootstrapTable({
		url:'../selectCashAccrual.action',
		method:'get',//请求方式
		striped: true, //是否显示行间隔色
		pagination: true, //是否显示分页（*）
		sortable: true, //是否启用排序
		sortOrder: "asc", //排序方式
		queryParams: function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					rows: params.limit, //页面大小
					page: params.offset / params.limit + 1, //页码
					businessDateWhere:$("#businessDateWhere").val(),
					sortName: this.sortName,
					sortOrder:this.sortOrder,
			};
			return temp;
		}, //传递参数（*）
		sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
		pageNumber: 1, //初始化加载第一页，默认第一页
		pageSize: 5, //每页的记录行数（*）
		pageList: [5, 10, 15, 20], //可供选择的每页的行数（*）
		//showColumns: true, //是否显示所有的列
		//showRefresh: true, //是否显示刷新按钮
		//minimumCountColumns: 2, //最少允许的列数
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
			field: 'cashAccountBankName',
			title: '银行名称',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'cashAccountBankCard',
			title: '银行卡号 '
		},{
			field: 'fundCode',
			title: '基金编号'
		},{
			field: 'cashAccountCode',
			title: '账户id '
		},{
			field: 'cashBlance',
			title: '卡号余额'
		},{
			field: 'strDate',
			title: '业务日期'
		},{
			field: 'cashAccountDepositType',
			title: '存款类型',
			formatter: function(value, rowDate, rowIndex){
				if(value==1){
					return '活期';
				}else{
					return'定期';
				}
			}
		},{
			field: 'cashAccountCardRate',
			title: '年利率'
		},{	 
			field: 'cashAccountInterestPeriod',
			title: '计息期间',
			formatter: function(value, rowDate, rowIndex){
				if(value==1){
					return '360天';
				}else if(value==2){
					return '365天';
				}else{
					return '366天';
				}
			}
		},]
	})
	$('#betweenTable2').bootstrapTable({
		url:'../selectBondAccrual.action',
		method:'get',//请求方式
		striped: true, //是否显示行间隔色
		pagination: true, //是否显示分页（*）
		sortable: true, //是否启用排序
		sortOrder: "asc", //排序方式
		queryParams: function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					rows: params.limit, //页面大小
					page: params.offset / params.limit + 1, //页码
					bondCode:$("#bondCode").val(),
					businessDateWhere:$("#businessDateWhere").val(),
					sortName: this.sortName,
					orderStyle:this.sortOrder,
			};
			return temp;
		}, //传递参数（*）
		sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
		pageNumber: 1, //初始化加载第一页，默认第一页
		pageSize: 5, //每页的记录行数（*）
		pageList: [5, 10, 15, 20], //可供选择的每页的行数（*）
		//showColumns: true, //是否显示所有的列
		//showRefresh: true, //是否显示刷新按钮
		//minimumCountColumns: 2, //最少允许的列数
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
			field: 'bondName',
			title: '债券名称',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'bondCode',
			title: '债券代码 '
		},{
			field: 'couponRate',
			title: '票面利率 '
		},{
			field: 'securityQuantity',
			title: '债券数量'
		},{
			field: 'bondType',
			title: '债券类型',
			formatter: function(value, rowDate, rowIndex){
				if(value==1){
					return '银行';
				}else{
					return'非银行';
				}
			}
		},{
			field: 'paymentCount',
			title: '付息次数',
			formatter: function(value, rowDate, rowIndex){
				if(value==1){
					return '一年一次';
				}else{
					return'一年二次';
				}
			}
		},{
			field: 'couponMoney',
			title: '票面金额'
		},{
			field: 'strSecurityStatisticsDate',
			title: '业务日期'
		},{
			field: 'StrStarDate',
			title: '计息起始日'
		},{
			field: 'StrEndDate',
			title: '计息截止日'
		},]
	})
	$('#betweenTable3').bootstrapTable({
		url:'../selectTwoCost.action',
		method:'get',//请求方式
		striped: true, //是否显示行间隔色
		pagination: true, //是否显示分页（*）
		sortable: true, //是否启用排序
		sortOrder: "asc", //排序方式
		queryParams: function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					rows: params.limit, //页面大小
					page: params.offset / params.limit + 1, //页码
					cashAccountCode:$("#cashAccountCode").val(),
					businessDateWhere:$("#businessDateWhere").val(),
					sortName: this.sortName,
					sortOrder:this.sortOrder,
			};
			return temp;
		}, //传递参数（*）
		sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
		pageNumber: 1, //初始化加载第一页，默认第一页
		pageSize: 5, //每页的记录行数（*）
		pageList: [5, 10, 15, 20], //可供选择的每页的行数（*）
		//showColumns: true, //是否显示所有的列
		//showRefresh: true, //是否显示刷新按钮
		//minimumCountColumns: 2, //最少允许的列数
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
			field: 'fundName',
			title: '基金名称',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'fundCode',
			title: '基金编号'
		},{
			field: 'manageRate',
			title: '管理人费率'
		},{
			field: 'trusteeRate',
			title: '托管人费率'
		},{
			field: 'cashAccountCode',
			title: '现金账户'
		},{
			field: 'projectCode',
			title: '资产净值'
		},{
			field: 'StrstatisticDate',
			title: '业务日期'
		},]
	})


	//查询的方法
	$("#btnSelect").click(function() {
		if(flag=="cash"){ //当flag标志等于现金计息时调用现金计息的查询
			var a=$("#businessDateWhere").val();
			$("#betweenTable1").bootstrapTable('refresh');
		}
		if(flag=="bond"){//当flag标志等于债券计息时调用债券计息的查询
			var b=$("#bondCode").val();
			var c=$("#businessDateWhere").val();
			$("#betweenTable2").bootstrapTable('refresh');
		}
		if(flag=="twoFee"){//当flag标志等于两费时调用两费的查询
			var d=$("#cashAccountCode").val();
			var e=$("#businessDateWhere").val();
			$("#betweenTable3").bootstrapTable('refresh');
		}
	});
	
	
	
	$('#btnCount').click(function(){
		var businessDateWhere=$("#businessDateWhere").val();
		if(businessDateWhere!=""){
		if(flag=="cash"){
			//得到所有选中的行
			var cashRows = $("#betweenTable1").bootstrapTable('getSelections');
			//判断选中的行数
			if (cashRows.length == 0) { //没选中任何行
				//调用弹窗
				myAlert("请选择一条数据进行统计");
			}else{
				var fundCode=cashRows[0].fundCode;
				var cashAccountCode=cashRows[0].cashAccountCode;
				var cashAccountDepositType=cashRows[0].cashAccountDepositType;
				var cashAccountBankCard=cashRows[0].cashAccountBankCard;
				var cashArapCode=cashRows[0].cashArapCode;
				$.ajax({
					type : "get",
					contentType:'application/json',
					url : "../insertCashAccrual.action?businessDateWhere="+businessDateWhere+"&cashAccountCode="+cashAccountCode+"&fundCode="+fundCode+"&cashAccountDepositType="+cashAccountDepositType+"&cashAccountBankCard="+cashAccountBankCard,
					success : function(msgs) {
						//刷新
						$("#myTable").bootstrapTable('refresh');
						//调用弹窗
						myAlert("统计成功");
					}
				})
			}
		}
		
		if(flag=="bond"){
			//得到所有选中的行
			var bondRows = $("#betweenTable2").bootstrapTable('getSelections');
			//判断选中的行数
			if (bondRows.length == 0) { //没选中任何行
				//调用弹窗
				myAlert("请选择一条数据进行统计");
			}else{
				var bondCode=bondRows[0].bondCode;
				var cashAccountCode=bondRows[0].cashAccountCode;
				var businessDateWhere=$("#businessDateWhere").val();
				$.ajax({
					type : "get",
					contentType:'application/json',
					url : '../insertBondAccrual.action?bondCode='+bondCode+"&businessDateWhere="+businessDateWhere+"&cashAccountCode="+cashAccountCode,
					success : function(msgs) {
						//刷新
						$("#myTable").bootstrapTable('refresh');
						//调用弹窗
						myAlert("统计成功");
					}
				})
			}
		}
		if(flag=="twoFee"){
			//得到所有选中的行
			var twoFeeRows = $("#betweenTable3").bootstrapTable('getSelections');
			//判断选中的行数
			if (twoFeeRows.length == 0) { //没选中任何行
				//调用弹窗
				myAlert("请选择一条数据进行统计");
			}else{
				var businessDateWhere=$("#businessDateWhere").val();
				var cashAccountCode=twoFeeRows[0].cashAccountCode;
				var feePeriodDay=twoFeeRows[0].feePeriodDay;
				var manageRate=twoFeeRows[0].manageRate;
				var projectCode=twoFeeRows[0].projectCode;
				var statisticDate=twoFeeRows[0].StrstatisticDate;
				var trusteeRate=twoFeeRows[0].trusteeRate;
				var fundCode=twoFeeRows[0].fundCode;
				var cashAccountBankCard=twoFeeRows[0].cashAccountBankCard;
				var cashAccountDepositType=twoFeeRows[0].cashAccountDepositType;
				$.ajax({
					type : "get",
					contentType:'application/json',
					url : '../insertTwoCost.action?cashAccountCode='+cashAccountCode+"&feePeriodDay="+feePeriodDay+"&manageRate="+manageRate+"&projectCode="+projectCode+"&statisticDate="+statisticDate+"&trusteeRate="+trusteeRate+"&fundCode="+fundCode+"&cashAccountBankCard="+cashAccountBankCard+"&cashAccountDepositType="+cashAccountDepositType+"&businessDateWhere="+businessDateWhere,
					success : function(msgs) {
						//刷新
						$("#myTable").bootstrapTable('refresh');
						//调用弹窗
						myAlert("统计成功");
					}
				})
			}
		}
		}else{
			//调用弹窗
			myAlert("请选择日期进行统计");
		}
	});
});