var flag='twoMoney';
$(function() {
	//日期时间插件	
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

	$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		// 获取已激活的标签页的名称
		var activeTab = $(e.target).text(); 
		if($(e.target).text()=='支付两费'){}
		//alert("activeTab="+activeTab);
		if(activeTab=='现金利息收入'){
			flag="xiangJin";
		}else if(activeTab=="债券利息收入"){
			flag="bondPay";
		} else if(activeTab=='支付两费'){
			flag="twoMoney";
		}
	/*	if(activeTab=="支付两费"){
			alert("进来了")
			flag="twoMoney";
		}if(activeTab=="现金利息收入"){
			flag="xiangJin";
		}if(activeTab=="债券利息收入"){
			flag="bondPay";
		}*/
		//alert(activeTab)
		// 获取前一个激活的标签页的名称
		var previousTab = $(e.relatedTarget).text(); 
		$(".active-tab span").html(activeTab);
		$(".previous-tab span").html(previousTab);
	});
	/*$('#myTab a:first').click(function(){
		alert("进来了")
		$("#btnSearch").text("支付两费");
	});
	//选取第二个标签页
	$('#myTab a:odd').click(function(){
	$("#btnSearch").text("现金利息收入");
	});
	// 选取最后一个标签页
	$('#myTab a:last').click(function(){
		$("#btnSttlement").text("债券利息收入");
	});*/
	//两费
	$("#liangFeiTable").bootstrapTable({
		url: '../selectTwoMoney.action',
		method: 'get', //请求方式（*）
		contentType:'application/json',
		//toolbar: '#toolbar', //工具按钮用哪个容器
		title:'支付两费',
		striped: true, //是否显示行间隔色
		//cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination: true, //是否显示分页（*）
		sortable: true, //是否启用排序
		sortOrder: "asc", //排序方式
		queryParams: function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					rows: params.limit, //页面大小
					page: params.offset / params.limit + 1, //页码
					sortName: this.sortName,
					sortOrder: this.sortOrder,
					strBusiness:$("input[name=businessDate]").val()=='' ? 'flag' : ''+$("input[name=businessDate]").val()+'',

			};
			return temp;
		}, //传递参数（*）
		sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
		pageNumber: 1, //初始化加载第一页，默认第一页
		pageSize: 5, //每页的记录行数（*）
		pageList: [5, 10, 15, 20], //可供选择的每页的行数（*）
		//showColumns: true, //是否显示所有的列
		//showRefresh: true, //是否显示刷新按钮
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
		},  {
			field: 'cashAccountCode',
			title: '现金编号',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'fundCode',
			title: '基金编号'
		}, {
			field: 'accountName',
			title: '账户名称'
		}, {
			field: 'cardNum',
			title: '卡号'
		}, {
			field: 'businessType',
			title: '业务类型',
			formatter : function(value, row, index) {
				if (value == 1) {
					return "管理费";
				}if(value == 2){
					return "托管费";
				} 
				else {
					return "存款计息";
				}
			}
		}, {
			field: 'money',
			title: '收支金额'
		}, {
			field: 'moneyDirection',
			title: '资金方向',
			formatter : function(value, row, index) {
				if (value == 1) {
					return "流入";
				} else {
					return "流出";
				}
			}
		}, {
			field: 'strBusiness',
			title: '业务日期'
		}, {
			field: 'desc',
			title: '备注'
		},]

	});
	//现金利息收入
	$("#xiangJinTable").bootstrapTable({
		url: '../selectCashPay.action',
		method: 'get', //请求方式（*）
		contentType:'application/json',
		//toolbar: '#toolbar', //工具按钮用哪个容器
		title:'现金利息收入',
		striped: true, //是否显示行间隔色
		//cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination: true, //是否显示分页（*）
		sortable: true, //是否启用排序
		sortOrder: "asc", //排序方式
		queryParams: function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					rows: params.limit, //页面大小
					page: params.offset / params.limit + 1, //页码
					sortName: this.sortName,
					sortOrder: this.sortOrder,
					strBusiness:$("input[name=businessDate]").val()=='' ? 'flag' : ''+$("input[name=businessDate]").val()+'',
			};
			return temp;
		}, //传递参数（*）
		sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
		pageNumber: 1, //初始化加载第一页，默认第一页
		pageSize: 5, //每页的记录行数（*）
		pageList: [5, 10, 15, 20], //可供选择的每页的行数（*）
		//showColumns: true, //是否显示所有的列
		//showRefresh: true, //是否显示刷新按钮
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
			field: 'cashAccountCode',
			title: '现金编号',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'fundCode',
			title: '基金编号'
		}, {
			field: 'accountName',
			title: '账户名称'
		}, {
			field: 'cardNum',
			title: '卡号'
		}, {
			field: 'businessType',
			title: '业务类型',
			formatter : function(value, row, index) {
				if (value == 1) {
					return "管理费";
				}if(value == 2){
					return "托管费";
				} 
				else {
					return "存款计息";
				}
			}
		}, {
			field: 'money',
			title: '收支金额'
		}, {
			field: 'moneyDirection',
			title: '资金方向',
			formatter : function(value, row, index) {
				if (value == 1) {
					return "流入";
				} else {
					return "流出";
				}
			}
		}, {
			field: 'strBusiness',
			title: '业务日期'
		}, {
			field: 'desc',
			title: '备注'
		},]

	});

	//债券利息收入
	$("#zhaiQuanTable").bootstrapTable({
		url: '../selectBondPay.action',
		method: 'get', //请求方式（*）
		contentType:'application/json',
		//toolbar: '#toolbar', //工具按钮用哪个容器
		title:'债券利息收入',
		striped: true, //是否显示行间隔色
		//cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination: true, //是否显示分页（*）
		sortable: true, //是否启用排序
		sortOrder: "asc", //排序方式
		queryParams: function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					rows: params.limit, //页面大小
					page: params.offset / params.limit + 1, //页码
					sortName: this.sortName,
					sortOrder: this.sortOrder,
					strBusiness:$("input[name=businessDate]").val()=='' ? 'flag' : ''+$("input[name=businessDate]").val()+'',
			};
			return temp;
		}, //传递参数（*）
		sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
		pageNumber: 1, //初始化加载第一页，默认第一页
		pageSize: 5, //每页的记录行数（*）
		pageList: [5, 10, 15, 20], //可供选择的每页的行数（*）
		//showColumns: true, //是否显示所有的列
		//showRefresh: true, //是否显示刷新按钮
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
			field: 'bondCode',
			title: '债券编号',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'fundCode',
			title: '基金编号'
		}, {
			field: 'accountCode',
			title: '现金编号'
		}, {
			field: 'bondName',
			title: '债券名称'
		}, {
			field: 'bondType',
			title: '债券类型',
			formatter : function(value, row, index) {
				if (value == 1) {
					return "银行期";
				} else{
					return "非银行期";
				}
			}
		}, {
			field: 'businessType',
			title: '业务类型',
			formatter : function(value, row, index) {
				if (value == 3) {
					return "债券计息";
				} 
			}
		}, {
			field: 'allMoney',
			title: '收支金额'
		}, {
			field: 'direction',
			title: '资金方向',
			formatter : function(value, row, index) {
				if (value == 1) {
					return "流入";
				} else{
					return "流出";
				}
			}
		}, 
		{
			field: 'strBusiness',
			title: '业务日期'
		},{
			field: 'desc',
			title: '备注'
		},]

	});
});
//查询
function searchBond() {
	/*	$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		// 获取已激活的标签页的名称
		var activeTab = $(e.target).text(); 
		if(activeTab=='债券利息收入'){
			$("#zhaiQuanTable").bootstrapTable('refresh');
		}
		if(activeTab='现金利息收入'){
			$("#xiangJinTable").bootstrapTable('refresh');
		}


	});*/
	if(flag=="twoMoney"){
		$("#liangFeiTable").bootstrapTable('refresh');
	}
	if(flag=="xiangJin"){
		$("#xiangJinTable").bootstrapTable('refresh');
	}
	if(flag=="bondPay"){
		$("#zhaiQuanTable").bootstrapTable('refresh');
	}

}

//统计
function statistics(){
	var businessDate=$("input[name=businessDate]").val();
	if(flag=="twoMoney"){
		
		var twoMoneyrows = $('#liangFeiTable').bootstrapTable("getSelections");
		if(twoMoneyrows.length == 0){
			myAlert("请选中要统计两费的数据！");
		}else{
		$.each(twoMoneyrows, function(i, oneRow) {
			$.ajax({
				type:'get',
				contentType:'application/json',
				url:'../tongJiTwoMoney.action?cashAccountCode='+oneRow.cashAccountCode+'&fundCode='+oneRow.fundCode+'&strBusiness='+oneRow.strBusiness+'&businessType='+oneRow.businessType+'&money='+oneRow.money,
				//data:'bonCode='+bondCode+"&fundCode="+fundCode,
				success:function(msg){
					if(msg="统计成功"){
						myAlert("统计成功");
					}else{
						myAlert("统计失败");
					}
				}
			})
		});
		}
	}
	if(flag=="xiangJin"){
		var xianJinrows = $('#xiangJinTable').bootstrapTable("getSelections");
		if(xianJinrows.length == 0){
			myAlert("请选中要统计现金的数据！");
		}else{
		$.each(xianJinrows, function(i, oneRow) {
			$.ajax({
				type:'get',
				contentType:'application/json',
				url:'../tongJiMoney.action?cashAccountCode='+oneRow.cashAccountCode+'&fundCode='+oneRow.fundCode+'&strBusiness='+oneRow.strBusiness+'&money='+oneRow.money,
				//data:'bonCode='+bondCode+"&fundCode="+fundCode,
				success:function(msg){
					if(msg="统计成功"){
						myAlert("统计成功");
					}else{
						myAlert("统计失败");
					}
				}
			})
		});
		}
	}
	if(flag=="bondPay"){
		//得到债券表格所选中的行
		var rows = $('#zhaiQuanTable').bootstrapTable("getSelections");
		if(rows.length == 0){
			myAlert("请选中要统计债券的数据！");
		}else{
		$.each(rows, function(i, oneRow) {	
			$.ajax({
				type:'get',
				contentType:'application/json',
				url:'../tongJiBondPay.action?bondCode='+oneRow.bondCode+'&fundCode='+oneRow.fundCode+'&strBusiness='+oneRow.strBusiness+'&accountCode='+oneRow.accountCode
				+'&strBusiness='+oneRow.strBusiness+'&allMoney='+oneRow.allMoney,
				//data:'bonCode='+bondCode+"&fundCode="+fundCode,
				success:function(msg){
					if(msg=="统计成功"){
						myAlert("统计成功");
					}else{
						myAlert("统计失败");
					}
				}
			})
		});
		}
	}




	/* */

	/*	*/












}