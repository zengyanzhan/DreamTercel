$(function(){
	$("#seatTable").bootstrapTable({
		url: '../selectSeat.action',
		method: 'get', //请求方式（*）
		toolbar: '#toolbar', //工具按钮用哪个容器
		contentType : "application/json;charset=UTF-8",
		striped: true, //是否显示行间隔色
		//cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination: true, //是否显示分页（*）
		sortable: true, //是否启用排序
		sortOrder: "asc", //排序方式
		queryParams: function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
				rows: params.limit, //页面大小
				page: params.offset / params.limit + 1, //页码
				seatType:$('#seatSelect').val(), //查询的参数   写自己的控制类对应的名字
				seatName:$('input[name=jiemianseatName]').val(),
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
		height: 600, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		//uniqueId : "usrId", //每一行的唯一标识，一般为主键列
		showToggle: false, //是否显示详细视图和列表视图的切换按钮
		cardView: false, //是否显示详细视图
		detailView: false, //是否显示父子表
		columns: [{
			//复选框
			checkbox: true
		}, {
			field: 'seatCode',
			title: '席位编号',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'seatName',
			title: '席位名称'
		}, {
			field: 'seatType',
			title: '席位类型',
			formatter:function(value,row,index){
				if(value==1){
					return "普通";
				}else if(value==2){
					return "贵宾";
				}
			}
		}, {
			field: 'commissionRate',
			title: '佣金利率'
		}, {
			field: 'brokerCode',
			title: '券商名称'
		}, {
			field: 'seatAddress',
			title: '席位地址'
		}, {
			field: 'seatDesc',
			title: '备注'
		}]
		
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
		          ]
	});
	//席位类型
	$("#seatType").bootstrapSelect({
		//url    : '', //请求路径
		//params : {},   //请求参数
		//paramsType : '',//参数默认是以表单形势传递，为json时是以json格式传递到后台
		data   : [{"seatType":"1","text":"普通"},{"seatType":"2","text":"贵宾"}],   //数据[{key:value},{key:value}]
		method : 'get',//请求方法
		textField  : 'text',//显示文本字段
		valueField : 'seatType',//隐藏文本字段
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
	$("#btn_add").click(function(){
		//自动生成编号
		/*$.ajax({
			type: "get",
			url: "../autoCreateSeatCode.action",
			success: function(msgs) {
				$("input[name=seatCode]").val(msgs);
			}
		});*/
		$("#myForm").data("bootstrapValidator").resetForm();
		$("input[name=seatCode]").val("");
		$("input[name=seatName]").val("");
		$("#seatType").bootstrapSelect("select","");
		$("input[name=commissionRate]").val("");
		$("#brokerCode").combogrid('setValue', "");
		$("input[name=seatAddress]").val("");
		$("#seatDesc").val("");
		$("#myModalLabel").text("新增");
		$('#myModal').modal();
	});
	//点击修改按钮
	$("#btn_edit").click(function(){
		$("#myForm").data("bootstrapValidator").resetForm();
		//得到所有选中的行
		var allRows = $("#seatTable").bootstrapTable('getSelections')
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
				url: "../selectSeatById.action?seatCode="+value.seatCode,
				success: function(msgs) {
					var msg=eval('('+msgs+')');
					$.each(msg,function(j,value){
						$("input[name=seatCode]").val(value.seatCode);
						$("input[name=seatName]").val(value.seatName);
						$("#seatType").bootstrapSelect("select",value.seatType);
						$("input[name=commissionRate]").val(value.commissionRate);
						$("#brokerCode").combogrid('setValue',value.brokerCode);
						$("input[name=seatAddress]").val(value.seatAddress);
						$("#seatDesc").val(value.seatDesc);
					});
				}
			});
		
		$("#myModalLabel").text("修改");
		$('#myModal').modal();
	});
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
			flag = 'insertSeat';
		} else {
			flag = 'updateSeat';
		}
		$.ajax({
			type: "post",
			url: "../"+flag+".action",
			data: $("#myForm").serializeArray(),
			success: function(msgs) {
				$("#seatTable").bootstrapTable('refresh');
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
		var allRows = $("#seatTable").bootstrapTable('getSelections');
		var seatCode=[];
		$.each(allRows ,function(i,value){
			seatCode.push("'"+value.seatCode+"'");
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
							type: "get",
							url:"../deleteSeat.action?seatCode="+seatCode,
							success: function(msgs) {
								$("#seatTable").bootstrapTable('refresh');
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
		$("#seatTable").bootstrapTable('refresh');
	});
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
			seatCode: {
				//验证格式
				validators: {
					notEmpty: {
						message: '编号不能为空'
					},
				}
			},
			seatName: {
				message: '席位名称验证失败',
				validators: {
					notEmpty: {
						message: '席位名称不能为空'
					}
				}
			},
			seatType:{
				//验证格式
				validators: {
					notEmpty: {
						message: '类型不能为空'
					},
				}
			},
			commissionRate:{
				message: '验证失败',
				validators: {
					notEmpty: {
						message: '佣金利率不能为空'
					},
					regexp: {
						regexp: /^0\.[0-9]*\d*$/,
						message: '费率大于0小于1的一个数'
					}
				}
			},
			seatAddress:{
				message: '验证失败',
				validators: {
					notEmpty: {
						message: '地址不能为空'
					}
				}
			},
		}
		//*****阻止表单的按钮提交
	}).on('success.form.bv',function(e) {
		//阻止默认事件提交
		e.preventDefault();
	});
	var right="L0103";
	isHaveRight($("#btn_add"),$("#btn_edit"),$("#btn_delete"),right);
});
