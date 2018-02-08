	//加载事件 
			$(function() {
				alert("aaaaa");
				
				$("#btnSearch").click(function(){
					$('#myTable').treegrid("load",{
						stockBlateCode:$("#stockPlateCodes").val(),
						stockBlateName:$("#stockPlateNames").val()
											});
					
				});
				//加载表格
				$('#myTable').treegrid({
					url: '../selectStockPlates.action',
					method: 'get', //请求方式（*）
					toolbar: '#toolbar', //工具按钮用哪个容器
					idField:'stockBlockCode',	
				    treeField:'stockBlockCode',
				    fitColumns:true,
				    height:700,
				    animate:true,
					//列字段
					columns:[[{
						//复选框
						checkbox: true
					}, {
						field: 'stockBlockCode',
						title: '股票板块编号',
						//启用该字段的排序
						sortable: true,
						width:100
					}, {
						field: 'stockBlockFatherCode',
						title: '父板块编号',
						width:100
					}, {
						field: 'stockBlockName',
						title: '股票板块名称',
						width:100
					}, {
						field: 'stockBlockDesc',
						width:150,
						title: '股票板块备用字段',
					}]]
				});

			//增加按钮点击事件
			$("#btn_add").click(function() {
				$("#myForm").data("bootstrapValidator").resetForm();
				//将弹窗的标题改为新增
				$("#myModalLabel").text("新增");
				$('#myModal').modal();
				var select=	$("#stockBlockFatherCode");
				$("input[name=stockBlockCode]").val("");
				var select=$("#stockBlockFatherCode");
				$(select).html("");
				$("input[name=stockBlockName]").val("");
				$("input[name=stockBlockDesc]").val("");
				$("#myForm").attr("action","../insertStockPlate.action");
				var flag=this.title;
		alert(flag);
				if(flag=='F'){
					
					var op=new Option("p","p");
					alert(op);
					select.append(op);
					alert("acccaa");
					$.ajax({
						type:'post',
						url:'../autoId.action',
						success:function(msg){
							$("input[name=stockBlockCode]").val(msg);
						}
					});
					
				}else{
					$.ajax({
						type:'post',
						url:'../selectFIds.action',
						success:function(msg){
							$("select[name=stockBlockFatherCode]").val(msg);
							$.each(msg,function(i,v){
								var op=new Option(v.stockBlockCode,v.stockBlockCode);
								select.append(op);
							})
						}
					})
				}
			});
			$("#stockBlockFatherCode").change(function(){
				$.ajax({
					type:'post',
					url:'../autoId.action?stockBlockCode='+$("#stockBlockFatherCode").val(),
					success:function(msg){
						$("input[name=stockBlockCode]").val(msg);
					}
				})
			})
				//删除按钮的点击事件
			$("#btn_delete").click(function() {
				//得到所有选中的行
				var allRows = $("#myTable").treegrid('getSelections');
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
								var arr=[];
							$.each(allRows,function(i,v){
						 			arr.push(v.stockBlockCode);
						 		})
								//ajax操作   （发送请stockBlockCode求到数据库删除）
							$.ajax({
									type:'post',
									url:'../deleteStockPlateByIds.action',
									data:'stockBlockCode='+arr,
									success:function(msg){
						 				$("#myTable").treegrid("reload");//刷新
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
			});
			
			/* 修改的点击事件 */
			$("#btn_edit").click(function() {
				
				/*var select=$("#stockBlockFatherCode");
				$(select).html("");*/
				$.ajax({
					type:'post',
					url:'../selectFIds.action',
					success:function(msg){
						$("select[name=stockBlockFatherCode]").val(msg);
						$.each(msg,function(i,v){
							var op=new Option(v.stockBlockCode,v.stockBlockCode);
							select.append(op);
						})
					}
				})
				//得到所有选中的行
				var allRows = $("#myTable").treegrid('getSelections')
					//判断选中的行数
				
				if (allRows.length == 0) { //没选中任何行
					//调用弹窗
					myAlert("请选则要修改的数据");
					return;
				} else if (allRows.length > 1) {
					myAlert("只能选择一条数据进行修改");
					return;
				}
				var arr=[];
				
				$.each(allRows, function(i,v) {
					arr.push(v.stockBlockCode);
				});
				//ajax发送请求
				alert(arr);
				$.ajax({
					type:"post",
					url:"../updateStockPlateByIds.action",
					data:'stockBlockCode='+arr,
					success:function(oneRow){
						$("input[name=stockBlockCode]").val(oneRow.stockBlockCode);
						$("select[name=stockBlockFatherCode]").val(oneRow.stockBlockFatherCode);
						$("input[name=stockBlockName]").val(oneRow.stockBlockName);
						$("textarea[name=stockBlockDesc]").val(oneRow.stockBlockDesc);
						
						$("#myForm").attr("action","../updateStockPlate.action");
						//验证
						var $form = $("#myForm");
						var data = $form.data('bootstrapValidator');
						if (data) {
							// 修复记忆的组件不验证
							data.validate();
						}
					}
				});
	
				//将弹窗的标题改为修改
				$("#myModalLabel").text("修改");
				//弹窗窗口
				$('#myModal').modal();
			});
			
			$("#btnSave").click(function(){
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
				var action = $("#myForm").attr("action"); 
				//ajax发送请求
				$.ajax({
					type: "post",
					url: action,
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
					data: $("#myForm").serializeArray(),
					success: function(msgs) {
						//刷新表格
						$("#myTable").treegrid("reload");
						//提示
						//隐藏弹窗
						$('#myModal').modal("hide");
						myAlert(msgs);
						//隐藏弹窗
						$('#myModal').modal("hide");
					}
				});
				
			})
					
			//定义提示弹窗的方法a
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
			var right='L0107';
			isHaveRight=($("#btn_add"),$("#btn_delete"),$("#btn_edit"),right);
			
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
					stockBlockName: {
						//验证格式
						validators: {
							notEmpty: {
								message: '股票板块名称不能为空'
							}
						}
					},
				}
				//*****阻止表单的按钮提交
			}).on('success.form.bv', function(e) {
				//阻止默认事件提交
				e.preventDefault();
			});
		});