var transferFees;
var brokerageFee;
var stampDuty;
var managementFee;
var commissionRate;
var securityCodejisuan;
var bondInterest;
var flagsecurityType;
$(function() {
	//日期时间插件	
	$('#dateTest').datetimepicker({
		language:'zh-CN',//显示中文
		format:'yyyy-mm-dd',//格式化日期
		minView:'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期
		autoclose:true,//自动关闭\
		todayBtn:true//显示今天按钮
	});
	$('#tradeDate').datetimepicker({
		language:'zh-CN',//显示中文
		format:'yyyy-mm-dd',//格式化日期
		minView:'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期
		autoclose:true,//自动关闭\
		todayBtn:true//显示今天按钮
	});
	$('#setAccountDate').datetimepicker({
		language:'zh-CN',//显示中文
		format:'yyyy-mm-dd',//格式化日期
		minView:'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期
		autoclose:true,//自动关闭\
		todayBtn:true//显示今天按钮
	});
	//交易状态下拉列表
	$("#dealStatus").bootstrapSelect({
		//url    : '', //请求路径
		//params : {},   //请求参数
		//paramsType : '',//参数默认是以表单形势传递，为json时是以json格式传递到后台
		data   : [{"dealStatus":"1","text":"已结算"},{"dealStatus":"2","text":"未结算"}],   //数据[{key:value},{9}]
		method : 'get',//请求方法
		textField  : 'text',//显示文本字段
		valueField : 'dealStatus',//隐藏文本字段
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
		onSelect : function(val,rec){			
		if(val==1){
			$("#dealFlag").bootstrapSelect("select","-1");
		}else{
			$("#dealFlag").bootstrapSelect("select","1");
		}
},
		unSelect : function(val,rec){},//反选
		onBeforeLoad: function(param){},//param 请求参数
		onLoadSuccess: function(data){},//data加载成功后返回的数据
		onLoadError: function(){},
		filter : false//选项过滤
	});
	//交易方式下拉列表dealFlag
	$("#jiemianDealStatus").bootstrapSelect({
		//url    : '', //请求路径
		//params : {},   //请求参数
		//paramsType : '',//参数默认是以表单形势传递，为json时是以json格式传递到后台
		data   : [{"dealStatus":"1","text":"已结算"},{"dealStatus":"2","text":"未结算"}],   //数据[{key:value},{key:value}]
		method : 'get',//请求方法
		textField  : 'text',//显示文本字段
		valueField : 'dealStatus',//隐藏文本字段
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
		onSelect : function(val,rec){

		},
		unSelect : function(val,rec){},//反选
		onBeforeLoad: function(param){},//param 请求参数
		onLoadSuccess: function(data){},//data加载成功后返回的数据
		onLoadError: function(){},
		filter : false//选项过滤
	});
	$("#deslateTable").bootstrapTable({
		url: '../selectDealData.action',
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
					sortName: this.sortName,
					sortOrder: this.sortOrder,
					securityCode:$("#jiemiansecurityCode").val(), //查询的参数   写自己的控制类对应的名字
					strDealDate: $('#dealDate').val(),
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
	//证券名称下拉表格
	$("#securityCode").combogrid({
		panelWidth: 450, //表格宽度
		idField: 'securityCode', //传输的列  
		textField: 'securityName', //显示的列
		fitColumns: true, //自动适应
		url: '../selectSecuritys.action', //服务器请求路径
		mode: 'remote', //定义在文本改变的时候如何读取数据。设置为'remote'，
		//数据表格将从远程服务器加载数据。当设置为'remote'模式的时候
		//，用户输入将会发送到名为'q'的http请求参数，向服务器检索新的数据。
		pagination: true, //分页条
		pageSize: 5,
		pageList: [5, 10, 15, 20, 25],
		columns: [
		          [ //表格列   
		            {
		            	field: 'securityCode',
		            	title: '证券代码',
		            	width: 60
		            }, {
		            	field: 'securityName',
		            	title: '证券名称',
		            	width: 100
		            }, {
		            	field: 'securityType',
		            	title: '证券类型',
		            	width: 120,
		            	formatter:function(value,row,index){
		    				if(value==1){
		    					return "股票";
		    				}else{
		    					return "债券";
		    				}
		    			}
		            }
		            ]]
	});

	//席位名称下拉表格
	$("#seatName").combogrid({
		panelWidth: 450, //表格宽度
		//panelHeight:500,//表格高度
		value: '', //输入的默认值（可写可不写）
		idField: 'userId', //传输的列  
		textField: 'userName', //显示的列
		fitColumns: true, //自动适应
		mode: 'remote', //定义在文本改变的时候如何读取数据。设置为'remote'，
		//数据表格将从远程服务器加载数据。当设置为'remote'模式的时候
		//，用户输入将会发送到名为'q'的http请求参数，向服务器检索新的数据。
		pagination: true, //分页条
		pageSize: 5,
		pageList: [5, 10, 15, 20, 25],
		columns: [
		          [ //表格列   
		            {
		            	field: 'userId',
		            	title: '角色编号',
		            	width: 60
		            }, {
		            	field: 'userName',
		            	title: '角色名称',
		            	width: 100
		            }, {
		            	field: 'userPwd',
		            	title: '角色描述',
		            	width: 120
		            },
		            ]
		          ]
	});

	//席位编号下拉表格
	$("#seatCode").combogrid({
		panelWidth: 450, //表格宽度
		idField: 'seatCode', //传输的列  
		textField: 'seatName', //显示的列
		fitColumns: true, //自动适应
		mode: 'remote', //定义在文本改变的时候如何读取数据。设置为'remote'，
		//数据表格将从远程服务器加载数据。当设置为'remote'模式的时候
		//，用户输入将会发送到名为'q'的http请求参数，向服务器检索新的数据。
		pagination: true, //分页条
		pageSize: 5,
		pageList: [5, 10, 15, 20, 25],
		columns: [
		          [ //表格列   
		            {
		            	field: 'seatCode',
		            	title: '席位编号',
		            	width: 60
		            }, {
		            	field: 'seatName',
		            	title: '席位名称',
		            	width: 100
		            }, {
		            	field: 'commissionRate',
		            	title: '佣金利率',
		            	width: 120
		            }, {
		            	field: 'seatAddress',
		            	title: '地址',
		            	width: 120
		            }
		            ]],
		            onSelect: function (index,row) {
		            	if (row != null) { 
		            		commissionRate=row.commissionRate;
		            		createFeilv();
		            	} 
		            } 
	});
	//券商名称下拉表格
	$("#brokerCode").combogrid({
		panelWidth: 450, //表格宽度
		//panelHeight:500,//表格高度
		value: '', //输入的默认值（可写可不写）
		idField: 'brokerCode', //传输的列  
		textField: 'brokerName', //显示的列
		fitColumns: true, //自动适应
		url: '../selectBorket.action', //服务器请求路径
		mode: 'remote', //定义在文本改变的时候如何读取数据。设置为'remote'，
		//数据表格将从远程服务器加载数据。当设置为'remote'模式的时候
		//，用户输入将会发送到名为'q'的http请求参数，向服务器检索新的数据。
		pagination: true, //分页条
		pageSize: 5,
		pageList: [5, 10, 15, 20, 25],
		columns: [
		          [ //表格列   
		            {
		            	field: 'brokerCode',
		            	title: '券商编号',
		            	width: 60
		            }, {
		            	field: 'brokerName',
		            	title: '券商名称',
		            	width: 100
		            }, {
		            	field: 'brokerExplain',
		            	title: '券商描述',
		            	width: 120
		            },
		            ]
		          ],
		          onSelect: function (index,row) {
		        	  if (row != null) {  
		        		  $('#seatCode').combogrid({ 
		        			  panelWidth: 450, //表格宽度
		        			  url: "../selectSeatByBroketCode.action?brokerCode=" + row.brokerCode  
		        		  });  
		        	  } 
		          }  
	});
	//投资经理下拉列表
	$("#userName").bootstrapSelect({
		url    : '../selectMaragerSel.action', //请求路径
		//params : {},   //请求参数
		//paramsType : '',//参数默认是以表单形势传递，为json时是以json格式传递到后台
		//data   : [],   //数据[{key:value},{key:value}]
		method : 'get',//请求方法
		textField  : 'userName',//显示文本字段
		valueField : 'userCode',//隐藏文本字段
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
	//交易方式下拉列表dealFlag
	$("#dealType").bootstrapSelect({
		//url    : '', //请求路径
		//params : {},   //请求参数
		//paramsType : '',//参数默认是以表单形势传递，为json时是以json格式传递到后台
		data   : [{"dealType":"1","text":"买入"},{"dealType":"2","text":"卖出"},{"dealType":"3","text":"分红"},{"dealType":"4","text":"送股"}],   //数据[{key:value},{key:value}]
		method : 'get',//请求方法
		textField  : 'text',//显示文本字段
		valueField : 'dealType',//隐藏文本字段
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
		onSelect : function(val,rec){
			createFeilv();
			if(val==1){
				$("#dealFlag").bootstrapSelect("select","-1");
			}else{
				$("#dealFlag").bootstrapSelect("select","1");
			}

		},
		unSelect : function(val,rec){},//反选
		onBeforeLoad: function(param){},//param 请求参数
		onLoadSuccess: function(data){},//data加载成功后返回的数据
		onLoadError: function(){},
		filter : false//选项过滤
	});
	
	//交易标识下拉列表
	$("#dealFlag").bootstrapSelect({
		//url    : '', //请求路径
		//params : {},   //请求参数
		//paramsType : '',//参数默认是以表单形势传递，为json时是以json格式传递到后台
		data   : [{"dealFlag":"1","text":"流入"},{"dealFlag":"-1","text":"流出"}],   //数据[{key:value},{key:value}]
		method : 'get',//请求方法
		textField  : 'text',//显示文本字段
		valueField : 'dealFlag',//隐藏文本字段
		relationId : null,//级联id
		emptyText  : null,//空选项文本，该属性为null或undefined时不创建空选项，默认不创建
		emptyValue : '',//空选项值
		separator  : ',',//多选时返回值的分割符
		editable	 : true,//是否可编辑
		multiple : false,//多选
		disabled : true,//禁用
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
	
	//交易状态下拉列表
	$("#cashAccountCode").bootstrapSelect({
		url    : '../selectCashAccountSel.action', //请求路径
		//params : {},   //请求参数
		//paramsType : '',//参数默认是以表单形势传递，为json时是以json格式传递到后台
		//data   : [],   //数据[{key:value},{key:value}]
		method : 'get',//请求方法
		textField  : 'cashAccountName',//显示文本字段
		valueField : 'cashAccountCode',//隐藏文本字段
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
	$("#szInput").click(function(){
		$("#myModalLabel").text("深圳回报库数据导入");
		$("#inputDate").modal();
	});
	$("#shInput").click(function(){
		$("#myModalLabel").text("上海过户库数据导入");
		$("#inputDate").modal();
	});
	//点击导入
	$("#btnInput").click(function(){
		var title=$("#myModalLabel").text();
		var flag='inputShguk';
		if(title=='深圳回报库数据导入'){
			flag='imputShguk';
		}else if(title=='上海过户库数据导入'){
			flag='imputShguk';
		}
		
	});
	//点击增加按钮
	$("#btn_add").click(function(){
		$("input[name=dealDataCode]").val("");
		$("#securityCode").combogrid('setValue', "");
		$("#userName").bootstrapSelect("select","");
		$("#brokerCode").combogrid('setValue', "");
		$("#seatCode").combogrid('setValue',"");
		$("#dealType").bootstrapSelect("select","");
		$("input[name=dealPrice]").val("");
		$("input[name=dealQuantity]").val("");
		$("#dealStatus").bootstrapSelect("select","2");
		$("input[name=realCollectFee]").val("");
		$("input[name=realCollectFee]").val("");
		$("input[name=commissionFee]").val("");
		$("input[name=transferFee]").val("");
		$("input[name=brokerageFee]").val("");
		$("input[name=dealTotalPrice]").val("");
		$("input[name=stampDuty]").val("");
		$("input[name=managementFee]").val("");
		$("input[name=securityFnterest]").val("");
		$("#dealDataDesc").text("");
		$("#inputtradeDate").val("");
		$("#inputsetAccountDate").val("");
		$("#cashAccountCode").bootstrapSelect("select","");
		$("#dealFlag").bootstrapSelect("select","");
		$("input[name=dealDataCode]").attr("disabled", "disabled");
		$("#myModalLabel").text("新增");
		$('#myModal').modal();
	});
	//点击修改按钮
	$("#btn_edit").click(function(){
		//得到所有选中的行
		var allRows = $("#deslateTable").bootstrapTable('getSelections');

		//判断选中的行数
		if (allRows.length == 0) { //没选中任何行
			//调用弹窗
			myAlert("请选则要修改的数据");
			return;
		} else if (allRows.length > 1) {
			myAlert("只能选择一条数据进行修改");
			return;
		}
		$.each(allRows, function(i, value) {
			if(value.dealStatus==1){
				myAlert("此数据已经结算，不可以进行修改！");
				return;
			}else{
				$.ajax({
					type: "get",
					url: "../selectDealDataById.action?dealDataCode="+value.dealDataCode,
					success: function(msgs) {
						var msg=eval('('+msgs+')');
						$.each(msg,function(j,value){
							$("input[name=dealDataCode]").val(value.dealDataCode);
							$("#securityCode").combogrid('setValue', value.securityCode);
							$("#userName").bootstrapSelect("select",value.userCode);
							$("#brokerCode").combogrid('setValue', value.brokerCode);
							$("#seatCode").combogrid('setValue', value.tradeSeatCode);
							$("#dealType").bootstrapSelect("select",value.dealType);
							$("input[name=dealPrice]").val(value.dealPrice);
							$("input[name=dealQuantity]").val(value.dealQuantity);
							$("#dealStatus").bootstrapSelect("select",value.dealStatus);
							$("input[name=realCollectFee]").val(value.realCollectFee);
							$("input[name=realCollectFee]").val(value.realCollectFee);
							$("input[name=commissionFee]").val(value.commissionFee);
							$("input[name=transferFee]").val(value.transferFee);
							$("input[name=brokerageFee]").val(value.brokerageFee);
							$("input[name=dealTotalPrice]").val(value.dealTotalPrice);
							$("input[name=stampDuty]").val(value.stampDuty);
							$("input[name=managementFee]").val(value.managementFee);
							$("input[name=securityFnterest]").val(value.securityFnterest);
							$("#dealDataDesc").text(value.dealDataDesc);
							$("#inputtradeDate").val(value.strDealDate);
							$("#inputsetAccountDate").val(value.strSetAccountDate);
							$("#cashAccountCode").bootstrapSelect("select",value.cashAccountCode);
							$("#dealFlag").bootstrapSelect("select",value.dealFlag);
						});
					}
				});
				$('#myModal').modal();
			}
		});
		$("input[name=dealDataCode]").attr("disabled", "disabled");
		$("#myModalLabel").text("修改");

	});
	//点击保存按钮

	$("#btnSave").click(function() {
		//得带弹窗的标题判断  是增加还是修改
		var title = $("#myModalLabel").text();
		//证券编号
		var securityCode=$("#securityCode").combogrid('getValue');
		//席位编号
		var seatCode=$("#seatCode").combogrid('getValue');
		//券商编号
		var brokerCode=$("#brokerCode").combogrid('getValue');
		//交易单号
		var dealDataCode=$("input[name=dealDataCode]").val();
		//成交日期
		var strDealDate=$("#inputtradeDate").val();
		//结算日期
		var strSetAccountDate=$("#inputsetAccountDate").val();
		//
		var userCode=$("#userName").bootstrapSelect('getValue');
		//交易方式
		var dealType=$("#dealType").bootstrapSelect('getValue');
		var dealFlag=$("#dealFlag").bootstrapSelect('getValue');
		var flag = '';
		if (title == '新增') {
			flag = 'insertDealData';
		} else {
			flag = 'updateDealData';
		}
		$.ajax({
			type: "post",
			url: "../"+flag+".action?securityCode="+securityCode+"&tradeSeatCode="+seatCode+"&brokerCode="+brokerCode+"&strDealDate="+strDealDate+"&strSetAccountDate="+strSetAccountDate+"&dealDataCode="+dealDataCode+"&userCode="+userCode+"&dealType="+dealType+"&dealFlag="+dealFlag,
			//contentType : "application/json;charset=UTF-8",
			data: $("#myForm").serializeArray(),
			success: function(msgs) {
				$("#deslateTable").bootstrapTable('refresh');
				//隐藏弹窗
				$('#myModal').modal("hide");
				if(msgs!=0){
					myAlert(title+"成功！");
				}else{
					myAlert(title+"失败！");
				}
			}
		});
	});
	//点击删除按钮
	$("#btn_delete").click(function() {
		//得到所有选中的行
		var allRows = $("#deslateTable").bootstrapTable('getSelections');
		var dealDataCode=[];
		var dealStatus;
		$.each(allRows ,function(i,value){
			dealStatus=value.dealStatus;
			if(dealStatus==1){
				return;
			}else{
				dealDataCode.push("'"+value.dealDataCode+"'");
			}
		}); 
		if(allRows.length!=dealDataCode.length){
			myAlert("所选择数据有已经结算的数据，不可以进行删除！");
			return;
		}else{
			//判断选中的行数
			if (allRows.length == 0) { //没选中任何行
				myAlert("请选中要删除的行");
			} else {
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
							$.ajax({
								type: "get",
								url:"../deleteDealData.action?dealDataCode="+dealDataCode,
								success: function(msgs) {
									$("#deslateTable").bootstrapTable('refresh');
									//隐藏弹窗
									$('#myModal').modal("hide");
									if(msgs!=0){
										myAlert("删除成功！");
									}else{
										myAlert("删除失败！");
									}
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
		}
	});
	//日期改变事件
	$("#inputtradeDate").change(function(){
		var tradeDate=$("#inputtradeDate").val();
		
		//自动生成编号
		$.ajax({
			type: "get",
			url: "../autoCreateDealDataCode.action?strDealDate="+tradeDate,
			success: function(msgs) {
				$("input[name=dealDataCode]").val(msgs);
			}
		});
		$.ajax({
			type: "get",
			url: "../selectHoildayByDradeDate.action?strDealDate="+tradeDate,
			success: function(msgs) {
				$("#inputsetAccountDate").val(msgs);
			}
		});
		if(flagsecurityType==1){
			
		}else{
			zhaiQuanJiXi();
		}
	});
	//选择券商信息
	$("#securityCode").combogrid({
		onSelect: function (index,row) {
			//查询费率
			$.ajax({
				type: "get",
				url: "../selectExchangeRateByExchangeNameAndSecurityType.action?exchangeName="+row.exchangeName+"&securityType="+row.securityType,
				success: function(msgs) {
					var msg=eval('('+msgs+')');
					$.each(msg,function(i,value){
						transferFees=Number(value.transferFee);
						brokerageFee=Number(value.brokerageFee);
						stampDuty=Number(value.stampDuty);
						managementFee=Number(value.managementFee);
						createFeilv();
					});
				}
			});
			flagsecurityType=row.securityType;
			//判断交易类型1.股票
			if(row.securityType==1){
				$("input[name=securityFnterest]").val(0);
				bondInterest=0;
			}else{//债券
				securityCodejisuan=row.securityCode;
				zhaiQuanJiXi();
			}
		}
	});
	//交易数量失去焦点
	$("#dealQuantity").blur(function(){
		countDealAllPrice();
		zhaiQuanJiXi();
	});
	//交易价格失去焦点
	$("#dealPrice").blur(function(){
		countDealAllPrice();
	});

	//查询按钮的事件
	$("#btnSearch").click(function() {
		$("#deslateTable").bootstrapTable('refresh');
	});
	
	var right="L0201";
	isHaveRight($("#btn_add"),$("#btn_edit"),$("#btn_delete"),right);
});

//计算交易金额
function countDealAllPrice(){
	var dealPrice=$("#dealPrice").val();
	var dealQuantity=$("#dealQuantity").val();
	if(dealPrice!=null&&dealPrice!=undefined&&dealQuantity!=null&&dealQuantity!=undefined){
		$("#dealAllPrice").val(dealPrice*dealQuantity);
		createFeilv();
	}
};
//计算费率
function createFeilv(){
	var securityInterest=$("input[name=securityFnterest]").val();
	if(typeof(transferFees)!='undefined'&&typeof(brokerageFee)!='undefined'&&typeof(stampDuty)!='undefined'&& typeof(managementFee)!='undefined'&&typeof(commissionRate)!='undefined'&&securityInterest!=''){
		var dealAllPrice=Number($("#dealAllPrice").val());
		var transferFee=dealAllPrice*transferFees;//过户费
		var handleFee=dealAllPrice*brokerageFee;//经手费
		var stamps=dealAllPrice*stampDuty;//印花税
		var connectionAndManagementFees=dealAllPrice*managementFee;//征管费
		var commissionFee=dealAllPrice*commissionRate;//佣金费率
		var dealType=$("#dealType").bootstrapSelect('getValue');
		var realCollectFee;
		if(dealType==1){//买入
			realCollectFee=Number(dealAllPrice+transferFee)+Number(handleFee)+Number(stamps)+Number(connectionAndManagementFees)+Number(commissionFee)+Number(securityInterest);
			$("input[name=commissionFee]").val(commissionFee.toFixed(2));
			$("input[name=transferFee]").val(transferFee.toFixed(2));
			$("input[name=brokerageFee]").val(handleFee.toFixed(2));
			$("input[name=stampDuty]").val(stamps.toFixed(2));
			$("input[name=managementFee]").val(connectionAndManagementFees.toFixed(2));
		}else if(dealType==2){//卖出
			realCollectFee=Number(dealAllPrice-transferFee)-Number(handleFee)-Number(stamps)-Number(connectionAndManagementFees)-Number(commissionFee)-Number(securityInterest);
			$("input[name=commissionFee]").val(commissionFee.toFixed(2));
			$("input[name=transferFee]").val(transferFee.toFixed(2));
			$("input[name=brokerageFee]").val(handleFee.toFixed(2));
			$("input[name=stampDuty]").val(stamps.toFixed(2));
			$("input[name=managementFee]").val(connectionAndManagementFees.toFixed(2));
		}else if(dealType==3){//分红
			realCollectFee=dealAllPrice;
			$("input[name=commissionFee]").val(0);
			$("input[name=transferFee]").val(0);
			$("input[name=brokerageFee]").val(0);
			$("input[name=stampDuty]").val(0);
			$("input[name=securityFnterest]").val(0);
			$("input[name=managementFee]").val(0);
		}else if(dealType==4){
			$("input[name=commissionFee]").val(0);
			$("input[name=transferFee]").val(0);
			$("input[name=brokerageFee]").val(0);
			$("input[name=stampDuty]").val(0);
			$("input[name=securityFnterest]").val(0);
			$("input[name=managementFee]").val(0);
		}
		
		$("input[name=realCollectFee]").val(realCollectFee.toFixed(2));
	}
};
function zhaiQuanJiXi(){
	//成交日期
	var strDealDate=$("#inputtradeDate").val();
	var dealQuantity=$("#dealQuantity").val();
	if(typeof(strDealDate)!='undefined'&&typeof(dealQuantity)!='undefined'){
		$.ajax({
			type: "get",
			url: "../selectBondBySecurityCode.action?securityCode="+securityCodejisuan+"&strDealDate="+strDealDate+"&dealQuantity="+dealQuantity,
			success: function(msgs) {
				if(msgs!='null'){
					$("input[name=securityFnterest]").val(Number(msgs).toFixed(2));
					createFeilv();
				}
			}
		});
	}
};
