$(function() {
	$("#borkerTable").bootstrapTable({
		url: '../selectBorket.action',
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
				brokerName: $("#brokerName").val(), //查询的参数   写自己的控制类对应的名字
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
			field: 'brokerCode',
			title: '券商编号',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'brokerName',
			title: '券商名称'
		}, {
			field: 'brokerExplain',
			title: '券商说明'
		}, {
			field: 'brokerDesc',
			title: '备注'
		}]
	});
	
	//点击增加按钮
	$("#btn_add").click(function() {
		$.ajax({
			type: "get",
			url: "../autoCreateBrokerCode.action",
			success: function(msgs) {
				$("input[name=brokerCode]").val(msgs);
			}
		});
		$("#myForm").data("bootstrapValidator").resetForm();
		$("input[name=brokerCode]").val("");
		$("input[name=brokerName]").val("");
		$("input[name=brokerExplain]").val("");
		$("#brokerDesc").val("");
		$("#myModalLabel").text("新增");
		$("input[name=brokerCode]").attr("disabled", "disabled");
		$('#myModal').modal();
	});
	//点击修改按钮
	$("#btn_edit").click(function() {
		$("#myForm").data("bootstrapValidator").resetForm();
		//得到所有选中的行
		var allRows = $("#borkerTable").bootstrapTable('getSelections')
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
			url: "../selectBorketById.action?brokerCode="+value.brokerCode,
			success: function(msgs) {
				var msg=eval('('+msgs+')');
				$.each(msg,function(j,value){
					$("input[name=brokerCode]").val(value.brokerCode);
					$("input[name=brokerName]").val(value.brokerName);
					$("input[name=brokerExplain]").val(value.brokerExplain);
					$("#brokerDesc").val(value.brokerDesc);
				});
			}
		});
		$("#myModalLabel").text("修改");
		$("input[name=brokerCode]").attr("disabled", "disabled");
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
		var brokerCode=$("input[name=brokerCode]").val();
		var flag = '';
		if (title == '新增') {
			flag = 'insertBorket';
		} else {
			flag = 'updateBorket';
		}
		$.ajax({
			type: "post",
			url: "../"+flag+".action?brokerCode="+brokerCode,
			data: $("#myForm").serializeArray(),
			success: function(msgs) {
				$("#borkerTable").bootstrapTable('refresh');
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
		var allRows = $("#borkerTable").bootstrapTable('getSelections');
		var broketCode=[];
		$.each(allRows ,function(i,value){
			broketCode.push("'"+value.brokerCode+"'");
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
							url:"../deleteBorket.action?brokerCode="+broketCode,
							success: function(msgs) {
								$("#borkerTable").bootstrapTable('refresh');
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
		$("#borkerTable").bootstrapTable('refresh');
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
			brokerName: {
				message: '验证失败',
				validators: {
					notEmpty: {
						message: '名称不能为空'
					}
				}
			},
			brokerExplain: {
				message: '验证失败',
				validators: {
					notEmpty: {
						message: '描述不能为空'
					}
				}
			}
		}
	}).on('success.form.bv', function(e) {
		//阻止默认事件提交
		e.preventDefault();
	});
	var right="L0102";
	isHaveRight($("#btn_add"),$("#btn_edit"),$("#btn_delete"),right);
});
