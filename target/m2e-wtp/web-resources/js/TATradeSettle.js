$(function(){
	$('#setAccountDate').datetimepicker({
		language:'zh-CN',//显示中文
		format:'yyyy-mm-dd',//格式化日期
		minView:'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期
		autoclose:true,//自动关闭\
		todayBtn:true//显示今天按钮
	});
	$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		// 获取已激活的标签页的名称
		var activeTab = $(e.target).text(); 
		// 获取前一个激活的标签页的名称
		var previousTab = $(e.relatedTarget).text(); 
		$(".active-tab span").html(activeTab);
		$(".previous-tab span").html(previousTab);
	});
	//投资经理下拉列表
	$("#dealType").bootstrapSelect({
		//url    : '', //请求路径
		//params : {},   //请求参数
		//paramsType : '',//参数默认是以表单形势传递，为json时是以json格式传递到后台
		//data   : [],   //数据[{key:value},{key:value}]
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
	});

//	选取最后一个标签页
	$('#myTab a:last').click(function(){
		$("#btnSttlement").text("反结算");
	});

	$("#true").click(function(){
		$("#jiesuanTable").bootstrapTable("refresh",{
			taTradeStatus:1,
		});
	});

	$("#jiesuanTable").bootstrapTable({
		//url: '../selectTaTradeSettleData.action',
		url: '../selectTaTradData.action',
		method: 'get', //请求方式（*）
		//toolbar: '#toolbar', //工具按钮用哪个容器
		title:'交易结算',
		striped: true, //是否显示行间隔色
		//cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination: true, //是否显示分页（*）		sortable: true, //是否启用排序
		sortOrder: "asc", //排序方式
		queryParams: function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					rows: params.limit, //页面大小
					page: params.offset / params.limit + 1, //页码
					taRadeType: $('#taTradeType').val(), //查询的参数   写自己的控制类对应的名字
					tradeDate: $('#strSetAccountDate').val(),//交易日期的字符串
					taTradeStatus:1,
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
			field: 'taTradDataCode',
			title: 'TA交易ID',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'fundCode',
			title: '基金代码'
		}, {
			field: 'taTradQuality',
			title: '基金数量'
		},/* {
			field: 'cashAccountCode',
			title: '账户名'
		},*/ {
			field: 'tradeDate',
			title: '交易日期'
		}, {
			field: 'settlesDate',
			title: '结算日期'
		}, {
			field: 'taUnitMoney',
			title: '单价'
		}, {
			field: 'fee',
			title: '费用'
		}, {
			field: 'taTotalMoney',
			title: '总金额'
		}, {
			field: 'agencies',
			title: '代销机构',
			formatter:function(value,row,index){
				if(value==1){
					return "建设银行";
				}else if(value==2){
					return "工商银行";
				}else{
					return "中国银行";
				}
			}
		}, {
			field:'taRadeType',
			title: '交易类型',
			formatter:function(value,row,index){
				if(value==1){
					return "认购";
				}else if(value==2){
					return "申购";
				}else{
					return "赎回";
				}
			}
		}, {
			field:'taTradeStatus',
			title: '交易状态',
			formatter:function(value,row,index){
				if(value==1){
					return "已结算";
				}else{
					return "未结算";
				}
			}
		}, {
			field:'taTradDataDesc',
			title: '备注'
		}]
	});


	//未结算
	$("#false").click(function(){
		$("#weiJieSuanTable").bootstrapTable("refresh",{
			taTradeStatus:2,
		});
	});
	$("#weiJieSuanTable").bootstrapTable({
		//url: '../selectTaTradeSettleData.action',
		url: '../selectTaTradData.action',
		method: 'get', //请求方式（*）
		//toolbar: '#toolbar', //工具按钮用哪个容器
		title:'TA交易结算',
		striped: true, //是否显示行间隔色
		//cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination: true, //是否显示分页（*）
		sortable: true, //是否启用排序
		sortOrder: "asc", //排序方式
		queryParams: function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					rows: params.limit, //页面大小
					page: params.offset / params.limit + 1, //页码
					taRadeType: $('#taTradeType').val(), //查询的参数   写自己的控制类对应的名字
					tradeDate	: $('#strSetAccountDate').val(),
					taTradeStatus:2,
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
			field: 'taTradDataCode',
			title: 'TA交易ID',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'fundCode',
			title: '基金代码'
		}, {
			field: 'taTradQuality',
			title: '基金数量'
		}, /*{
			field: 'cashAccountCode',
			title: '账户名'
		}, */{
			field: 'tradeDate',
			title: '交易日期'
		}, {
			field: 'settlesDate',
			title: '结算日期'
		}, {
			field: 'taUnitMoney',
			title: '单价'
		}, {
			field: 'fee',
			title: '费用'
		}, {
			field: 'taTotalMoney',
			title: '总金额'
		}, {
			field: 'agencies',
			title: '代销机构',
			formatter:function(value,row,index){
				if(value==1){
					return "建设银行";
				}else if(value==2){
					return "工商银行";
				}else{
					return "中国银行";
				}
			}
		}, {
			field:'taRadeType',
			title: '交易类型',
			formatter:function(value,row,index){
				if(value==1){
					return "认购";
				}else if(value==2){
					return "申购";
				}else{
					return "赎回";
				}
			}
		}, {
			field:'taTradeStatus',
			title: '交易状态',
			formatter:function(value,row,index){
				if(value==1){
					return "已结算";
				}else{
					return "未结算";
				}
			}
		}, {
			field:'taTradDataDesc',
			title: '备注'
		}]
	});


//	点击查询的时候进行判断   如果是结算就查结算数据  否则就是反结算的数据
	$("#btnSearch").click(function(){
		var btnSttlementText=$("#btnSttlement").text();
		var setAccountDate=$("#taTradeDateWhere").val();
		var dealType=$("#taRadeTypeWhere").val();
		//alert(dealType);
		if(btnSttlementText=="结算"){
			$("#weiJieSuanTable").bootstrapTable("refresh",{
				url:'../selectTaTradData.action?taTradeStatus=2&taTradeDateWhere='+setAccountDate+"&taRadeTypeWhere="+dealType,
			});
		}else if(btnSttlementText=="反结算"){
			$("#jiesuanTable").bootstrapTable("refresh",{
				url:'../selectTaTradData.action?taTradeStatus=1&taTradeDateWhere='+setAccountDate+"&taRadeTypeWhere="+dealType,
			});
			
		}
	
		$("#taTradeDateWhere").val("");
		$("#taRadeTypeWhere").val("");
	});
	//点击结算进行操作   
	$("#btnSttlement").click(function(){
		//得到点击的按钮的是结算还是反结算
		var btnSttlementText=$("#btnSttlement").text();
		//进行判断    如果是结算   进入结算的action    否则就进入反结算的action
		if(btnSttlementText=="结算"){
			//得到所有选中的行
			var allRows = $("#weiJieSuanTable").bootstrapTable('getSelections')
			//判断选中的行数
			if (allRows.length == 0) { //没选中任何行
				myAlert("请选择您需要操作的行!");
			} else if(allRows.length>0){
				var arr=[];
				$.each(allRows,function(i,v){
					arr.push(v.taTradDataCode);
				});
				//ajax操作   （发送请求到数据库删除）
				$.ajax({
					url:"../taTradeSettle.action",
					type: "post",
//					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					data: 'taTradDataCode='+arr,
					success: function(msg) {
						//刷新表格
						$("#weiJieSuanTable").bootstrapTable('refresh');
						$("#jiesuanTable").bootstrapTable('refresh');
						//提示
						myAlert(msg);
					}
				});
			}
		}else if(btnSttlementText=="反结算"){
			//得到所有选中的行
			var allRows = $("#jiesuanTable").bootstrapTable('getSelections')
			//判断选中的行数
			if (allRows.length == 0) { //没选中任何行
				myAlert("请选择您需要操作的行!");
			} else if(allRows.length>0){
				var arr=[];
				$.each(allRows,function(i,v){
					arr.push(v.taTradDataCode);
				});
				//ajax操作   （发送请求到数据库删除）
				$.ajax({
					url:"../taReTradeSettle.action",
					type: "post",
//					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					data: 'taTradDataCode='+arr,
					success: function(msg) {
						$("#jiesuanTable").bootstrapTable('refresh');
						$("#weiJieSuanTable").bootstrapTable('refresh');
						//提示
						myAlert(msg);
					}
				});
			}
		}
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

});