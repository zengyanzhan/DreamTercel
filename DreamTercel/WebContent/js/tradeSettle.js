$(function(){
	$('#setAccountDate').datetimepicker({
		language:'zh-CN',//显示中文
		format:'yyyy-mm-dd',//格式化日期
		minView:'month',//设置只显示到月份
		//initialDate:new Date(),//初始化当前日期
		autoclose:true,//自动关闭\
		todayBtn:true,//显示今天按钮
		todayHighlight:true
	});
	$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		// 获取已激活的标签页的名称
		var activeTab = $(e.target).text(); 
		// 获取前一个激活的标签页的名称
		var previousTab = $(e.relatedTarget).text(); 
		$(".active-tab span").html(activeTab);
		$(".previous-tab span").html(previousTab);
	});
	//给日期默认今天
	var today=new Date();
	var nowdate=(today.getFullYear())+"-"+(today.getMonth()+1)+"-"+today.getDate();
	//对日期格式进行处理
	var date=new Date(nowdate);
	var mon=date.getMonth()+1;
	var day = date.getDate();
	var mydate = date.getFullYear() + "-" + (mon < 10 ? "0" + mon : mon) + "-" + (day < 10 ? "0" + day : day);
	$("#strSetAccountDate").val(mydate);
	//投资经理下拉列表
	$("#dealType").bootstrapSelect({
		data:[{"text":"买入","id":"1"},{"text":"卖出","id":"2"},{"text":"送股","id":"4"},{"text":"分红","id":"3"}],   //数据[{key:value},{key:value}]
		method : 'get',//请求方法
		textField  : 'text',//显示文本字段
		valueField : 'id',//隐藏文本字段
		relationId : null,//级联id
		emptyText  : null,//空选项文本，该属性为null或undefined时不创建空选项，默认不创建
		emptyValue : '',//空选项值
		separator  : ',',//多选时返回值的分割符
		editable	 : true,//是否可编辑
		multiple : false,//多选
		disabled : false,//禁用
		downBorder : false,//下拉按钮是否带边框
		cls:'',//自定义样式,多个样式用逗号隔开 class1,class2
		formatter:function(rec){},//格式化节点	
		onSelect : function(val,rec){},
		unSelect : function(val,rec){},//反选
		onBeforeLoad: function(param){},//param 请求参数
		onLoadSuccess: function(data){},//data加载成功后返回的数据
		onLoadError: function(){},
		filter : false//选项过滤
	});
	//	选取第一个标签页
	$('#myTab a:first').click(function(){
		$("#btnSttlement").text("结算");
		$("#btnSearch").click();
	});
	//	选取最后一个标签页
	$('#myTab a:last').click(function(){
		$("#btnSttlement").text("反结算");
		$("#btnSearch").click();
	});
	$("#jiesuanTable").bootstrapTable({
		//url: '../js/text.json',
		method: 'get', //请求方式（*）
		//toolbar: '#toolbar', //工具按钮用哪个容器
		title:'交易结算',
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
			field: 'dealDataCode',
			title: '交易单号',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'securityCode',
			title: '证券名称'
		}, {
			field: 'brokerCode',
			title: '券商名称'
		}, {
			field: 'cashAccountCode',
			title: '现金账户'
		}, {
			field: 'dealPrice',
			title: '交易单价'
		}, {
			field: 'dealQuantity',
			title: '交易数量'
		}, {
			field: 'dealTotalPrice',
			title: '交易金额'
		}, {
			field: 'realCollectFee',
			title: '实收金额'
		},  {
			field: 'dealType',
			title: '交易类型',
			formatter:function(value,row,index){
				if(value==1){
					return "买入";
				}else if(value==2){
					return "卖出";
				}else if(value==3){
					return "分红";
				}else if(value==4){
					return "送股";
				}
			}
		}, {
			field: 'strDealDate',
			title: '交易日期'
		}, {
			field: 'strSetAccountDate',
			title: '结算日期'
		}, {
			field: 'dealStatus',
			title: '交易状态',
			formatter:function(value,row,index){
				if(value==1){
					return "已结算";
				}else{
					return "未结算";
				}
			}
		}]
	});
	//未结算
	$("#weiJieSuanTable").bootstrapTable({
		//url: '../js/text.json',
		method: 'get', //请求方式（*）
		//toolbar: '#toolbar', //工具按钮用哪个容器
		striped: true, //是否显示行间隔色
		//cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination: true, //是否显示分页（*）
		sortable: true, //是否启用排序
		sortOrder: "asc", //排序方式
		queryParams: function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					rows: params.limit, //页面大小
					page: params.offset / params.limit + 1, //页码
					seatType: $('#seatSelect').val(), //查询的参数   写自己的控制类对应的名字
					brokerCode: $('#brokerSelect').val(),
					sortName: this.sortName,
					sortOrder: this.sortOrder,
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
			field: 'dealDataCode',
			title: '交易单号',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'securityCode',
			title: '证券名称'
		}, {
			field: 'brokerCode',
			title: '券商名称'
		}, {
			field: 'cashAccountCode',
			title: '现金账户'
		}, {
			field: 'dealPrice',
			title: '交易单价'
		}, {
			field: 'dealQuantity',
			title: '交易数量'
		}, {
			field: 'dealTotalPrice',
			title: '交易金额'
		},  {
			field: 'realCollectFee',
			title: '实收金额'
		}, {
			field: 'dealType',
			title: '交易类型',
			formatter:function(value,row,index){
				if(value==1){
					return "买入";
				}else if(value==2){
					return "卖出";
				}else if(value==3){
					return "分红";
				}else if(value==4){
					return "送股";
				}
			}
		}, {
			field: 'strDealDate',
			title: '交易日期'
		}, {
			field: 'strSetAccountDate',
			title: '结算日期'
		}, {
			field: 'dealStatus',
			title: '交易状态',
			formatter:function(value,row,index){
				if(value==1){
					return "已结算";
				}else{
					return "未结算";
				}
			}
		}]
	});
	//点击查询按钮
	$("#btnSearch").click(function(){
		var btnSttlementText=$("#btnSttlement").text();
		var strSetAccountDate=$("#strSetAccountDate").val();
		var dealType=$("#dealType").bootstrapSelect('getValue');
		if(btnSttlementText=="结算"){
			$("#weiJieSuanTable").bootstrapTable("refresh",{
				url:'../selectTradeSettle.action?dealStatus=2&strDealDate='+strSetAccountDate+"&dealType="+dealType,
			});
		}else if(btnSttlementText=="反结算"){
			$("#jiesuanTable").bootstrapTable("refresh",{
				url:'../selectTradeSettle.action?dealStatus=1&strDealDate='+strSetAccountDate+"&dealType="+dealType,
			});
		}
	});
	//点击结算
	$("#btnSttlement").click(function(){
		var btnSttlementText=$("#btnSttlement").text();
		if(btnSttlementText=="结算"){
			//得到所有选中的行
			var allRows = $("#weiJieSuanTable").bootstrapTable('getSelections');
			var dealDataCode=[];
			$.each(allRows ,function(i,value){
				dealDataCode.push(value.dealDataCode);
			}); 
			if(allRows.length == 0){
				myAlert("请选中要结算的交易数据！");
			}else{
				$.ajax({
					type: "get",
					url:"../insertTradeNotSettle.action?dealDataCode="+dealDataCode,
					success: function(msgs) {
						$("#btnSearch").click();
						if(msgs!=0){
							myAlert("结算成功！");
						}else{
							myAlert("结算失败！");
						}
					}
				});
			}
		}else if(btnSttlementText=="反结算"){
			//得到所有选中的行
			var allRows = $("#jiesuanTable").bootstrapTable('getSelections');
			var dealDataCode=[];
			$.each(allRows ,function(i,value){
				dealDataCode.push(value.dealDataCode);
			});
			if(allRows.length == 0){
				myAlert("请选中要反结算的交易数据！");
			}else{
				$.ajax({
					type: "get",
					url:"../insertTradeAlreadySettle.action?dealDataCode="+dealDataCode,
					success: function(msgs) {
						$("#btnSearch").click();
						if(msgs!=0){
							myAlert("反结算成功！");
						}else{
							myAlert("反结算失败！");
						}
					}
				});
			}
		}
	});
});