$(function(){
	$("#exchangeTable").bootstrapTable({
		url: '../selectExchangeRate.action',
		method: 'get', //请求方式（*）
		contentType : "application/json;charset=UTF-8",
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
				exchangeName:$("input[name=exchangeSelect]").val(),
				exchangeType:$("input[name=exchangeTypeSelect]").val()
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
			field: 'exchangeCode',
			title: '交易所编号',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'exchangeName',
			title: '交易所名称',
			formatter:function(value,row,index){
				if(value==1){
					return "上交所";
				}else if(value==2){
					return "深交所";
				}
			}
		}, {
			field: 'exchangeType',
			title: '费率类型',
			formatter:function(value,row,index){
				if(value==1){
					return "股票";
				}else if(value==2){
					return "债券";
				}
			}
		}, {
			field: 'stampDuty',
			title: '印花税'
		}, {
			field: 'transferFee',
			title: '过户费'
		}, {
			field: 'managementFee',
			title: '征管费'
		}, {
			field: 'brokerageFee',
			title: '经手费'
		}, {
			field: 'exchangeDesc',
			title: '备注'
		}]
	});
	
	//投资经理下拉列表
	$("#exchangeSelect").bootstrapSelect({
			//url    : '', //请求路径
			//params : {},   //请求参数
			//paramsType : '',//参数默认是以表单形势传递，为json时是以json格式传递到后台
			data:[{"text":"上交所","exchangeName":"1"},{"text":"深交所","exchangeName":"2"}],   //数据[{key:value},{key:value}]
	        method : 'get',//请求方法
	        textField  : 'text',//显示文本字段
	        valueField : 'exchangeName',//隐藏文本字段
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
	//投资经理下拉列表
	$("#exchangeTypeSelect").bootstrapSelect({
			//url    : '', //请求路径
			//params : {},   //请求参数
			//paramsType : '',//参数默认是以表单形势传递，为json时是以json格式传递到后台
			data:[{"text":"股票","exchangeType":"1"},{"text":"债券","exchangeType":"2"}],   //数据[{key:value},{key:value}]
	        method : 'get',//请求方法
	        textField  : 'text',//显示文本字段
	        valueField : 'exchangeType',//隐藏文本字段
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
	//投资经理下拉列表
	$("#exchangeName").bootstrapSelect({
		   //url: "../selectExchangeNameSel.action",
			//params : {},   //请求参数
			//paramsType : '',//参数默认是以表单形势传递，为json时是以json格式传递到后台
			data:[{"strExchangeName":"上交所","exchangeName":"1"},{"strExchangeName":"深交所","exchangeName":"2"}],   //数据[{key:value},{key:value}]
	        method : 'get',//请求方法
	        textField  : 'strExchangeName',//显示文本字段
	        valueField : 'exchangeName',//隐藏文本字段
	        relationId : null,//级联id
	        emptyText  : null,//空选项文本，该属性为null或undefined时不创建空选项，默认不创建
	        emptyValue : '',//空选项值
	        separator  : ',',//多选时返回值的分割符
	        editable	 : true,//是否可编辑
	        multiple : false,//多选
	        disabled : false,//禁用
	        downBorder : false,//下拉按钮是否带边框
	        cls:'',//自定义样式,多个样式用逗号隔开 class1,class2
	        formatter:function(rec){
	
	        },//格式化节点	
	        onSelect : function(val,rec){},
	        unSelect : function(val,rec){},//反选
	        onBeforeLoad: function(param){},//param 请求参数
			onLoadSuccess: function(data){},//data加载成功后返回的数据
			onLoadError: function(){},
			filter : false//选项过滤
					
					
			});
	//投资经理下拉列表
	$("#exchangeType").bootstrapSelect({
			//url    : '', //请求路径
			//params : {},   //请求参数
			//paramsType : '',//参数默认是以表单形势传递，为json时是以json格式传递到后台
			data:[{"text":"股票","exchangeType":"1"},{"text":"债券","exchangeType":"2"}],   //数据[{key:value},{key:value}]
	        method : 'get',//请求方法
	        textField  : 'text',//显示文本字段
	        valueField : 'exchangeType',//隐藏文本字段
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
	//点击增加按钮
	$("#btn_add").click(function() {
		
		//自动生成编号
		$.ajax({
			type: "get",
			url: "../autoCreateCode.action",
			success: function(msgs) {
				$("input[name=exchangeCode]").val(msgs);
			}
		});
		$("#myForm").data("bootstrapValidator").resetForm();
		$("#exchangeName").bootstrapSelect('select',"");
		$("#exchangeType").bootstrapSelect('select',"");
		$("input[name=stampDuty]").val("");
		$("input[name=transferFee]").val("");
		$("input[name=managementFee]").val("");
		$("input[name=brokerageFee]").val("");
		$("#exchangeDesc").val(" ");
		$("#myModalLabel").text("新增");
		$("input[name=exchangeCode]").attr("disabled", "disabled");
		$('#myModal').modal();
	});
	//点击修改按钮
	$("#btn_edit").click(function() {
		$("#myForm").data("bootstrapValidator").resetForm();
		//得到所有选中的行
		var allRows = $("#exchangeTable").bootstrapTable('getSelections')
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
			$.ajax({
				type: "get",
				url: "../selectExchangeRateById.action?exchangeCode="+value.exchangeCode+"",
				success: function(msgs) {
					var msg=eval('('+msgs+')');
					alert(msg);
					$.each(msg,function(j,value){
						$("input[name=exchangeCode]").val(value.exchangeCode);
						$("#exchangeName").bootstrapSelect('select',value.exchangeName);
						$("#exchangeType").bootstrapSelect('select',value.exchangeType);
						$("input[name=stampDuty]").val(value.stampDuty);
						$("input[name=transferFee]").val(value.transferFee);
						$("input[name=managementFee]").val(value.managementFee);
						$("input[name=brokerageFee]").val(value.brokerageFee);
						$("#exchangeDesc").val(value.exchangeDesc);
					});
					
				}
			});
		});
		$("#myModalLabel").text("修改");
		$("input[name=exchangeCode]").attr("disabled", "disabled");
		$('#myModal').modal();
	});
	//点击保存按钮
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
			flag = 'insertExchangeRate';
		} else {
			flag = 'updateExchangeRate';
		}
		var exchangeCode=$("input[name=exchangeCode]").val();
		var exchangeName=$("#exchangeName").bootstrapSelect('getValue');
		var exchangeType=$("#exchangeType").bootstrapSelect('getValue');
		if(typeof(exchangeName)!='undefined'&&typeof(exchangeType)!='undefined'){
			$.ajax({
				type: "post",
				url:"../selectExchangeNameSelect.action?exchangeName="+exchangeName+"&exchangeType="+exchangeType+"&exchangeCode="+exchangeCode,
				success: function(msgs) {
					if(msgs=='存在'){
						myAlert("此数据已经存在，请重新选择！");
					}else{
						$.ajax({
							type: "post",
							url:"../"+flag+".action?exchangeCode="+exchangeCode+"&exchangeName="+exchangeName+"&exchangeType="+exchangeType,
							//contentType : "application/json;charset=UTF-8",
							data: $("#myForm").serializeArray(),
							success: function(msgs) {
								$("#exchangeTable").bootstrapTable('refresh');
								//隐藏弹窗
								$('#myModal').modal("hide");
								if(msgs!=0){
									myAlert(title+"成功！");
								}else{
									myAlert(title+"失败！");
								}
							}
						});
					}
				}
			});
		}
		
	});
	//点击删除按钮
	$("#btn_delete").click(function() {
		//得到所有选中的行
		var allRows = $("#exchangeTable").bootstrapTable('getSelections')
		var exchangeCode=[];
		$.each(allRows ,function(i,value){
			exchangeCode.push("'"+value.exchangeCode+"'");
		}); 
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
							type: "post",
							url:"../deleteExchangeRate.action?exchangeCode="+exchangeCode,
							success: function(msgs) {
								$("#exchangeTable").bootstrapTable('refresh');
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
	});
	////查询按钮的事件
	$("#btnSearch").click(function() {
		$("#exchangeTable").bootstrapTable('refresh');
	});
	$("#myForm").bootstrapValidator({
		//图标集
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		//列字段
		fields: {
			exchangeName: {
				message: '验证失败',
				validators: {
					notEmpty: {
						message: '名称不能为空'
					}
				}
			},
			stampDuty: {
				message: '验证失败',
				validators: {
					notEmpty: {
						message: '不能为空'
					},
					regexp: {
						regexp: /^0\.[0-9]*\d*$/,
						message: '费率大于0小于1的一个数'
					}
				}
			}
			,
			transferFee: {
				message: '验证失败',
				validators: {
					notEmpty: {
						message: '不能为空'
					},
					regexp: {
						regexp: /^0\.[0-9]*\d*$/,
						message: '费率大于0小于1的一个数'
					}
				}
			}
			,
			brokerageFee: {
				message: '验证失败',
				validators: {
					notEmpty: {
						message: '不能为空'
					},
					regexp: {
						regexp: /^0\.[0-9]*\d*$/,
						message: '费率大于0小于1的一个数'
					}
				}
			}
			,managementFee:{
				message: '验证失败',
				validators: {
					notEmpty: {
						message: '不能为空'
					},
					regexp: {
						regexp: /^0\.[0-9]*\d*$/,
						message: '费率大于0小于1的一个数'
					}
				}
			}
		}
	}).on('success.form.bv', function(e) {
		//阻止默认事件提交
		e.preventDefault();
	});
	var right="L0104";
	isHaveRight($("#btn_add"),$("#btn_edit"),$("#btn_delete"),right);
});
function selectTypeName(){
	var exchangeName=$("#exchangeName").bootstrapSelect('getValue');
	var exchangeType=$("#exchangeType").bootstrapSelect('getValue');
	
}

