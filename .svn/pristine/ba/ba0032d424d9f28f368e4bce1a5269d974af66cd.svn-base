$(function() {

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
					sortName: this.sortName,
					sortOrder: this.sortOrder,
					flag:$("#flag").val(),
					strDate:$("input[name=stDates]").val()=='' ? '' : ''+$("input[name=stDates]").val()+'',
							strDateEnd:$("input[name=strDateEnds]").val()=='' ? '' : ''+$("input[name=strDateEnds]").val()+'',	
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
			field: 'savingCode',
			title: '存款业务编号',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'fundCode',
			title: '基金名称'
		}, {
			field: 'outCashAccountCode',
			title: '流出现金账户'
		}, {
			field: 'inCashAccountCode',
			title: '流入现金账户'
		}, {
			field: 'strDate',
			title: '业务日期'

		},{
			field: 'savingMoney',
			title: '存款金额',
			formatter:function(value,index,row){
				return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
			}
		},{
			field: 'savingInterest',
			title: '利息'
		},{
			field: 'strDateEnd',
			title: '业务到期时间'
		},{
			field: 'flag',
			title: '到期标志',
			formatter: function(value, row, index) {
				if (value == 1) {
					return "未到期办理";
				} else {
					return "到期办理";
				}
			}
		}]
	});
//	给所有文本框添加提示框
	$('.clearData').tooltip({
		title : '不为空'
	});
	$('.del').click(function() {
		//alert("进入清除数据的方法");
		test();
	});
//	去掉文本域的提示框
	$(".one").tooltip("destroy");
	//日期时间插件	
	$('#stDates').datetimepicker({
		language : 'zh-CN',//显示中文
		format : 'yyyy-mm-dd',//格式化日期
		minView : 'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期
		autoclose : true,//自动关闭\
		todayBtn : true
		//显示今天按钮
	});
	$('#strDateEnds').datetimepicker({
		language : 'zh-CN',//显示中文
		format : 'yyyy-mm-dd',//格式化日期
		minView : 'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期
		autoclose : true,//自动关闭\
		todayBtn : true
		//显示今天按钮
	});
	$('#outCashAccountCode').combogrid({
		panelWidth : 450, //表格宽度
		//panelHeight:500,//表格高度
		value : '', //输入的默认值（可写可不写）
		idField : 'cashAccountCode', //传输的列  
		textField : 'cashAccountCode', //显示的列
		fitColumns : true, //自动适应
		url : '../selectCashAccount.action', //服务器请求路径
		mode : 'remote', //定义在文本改变的时候如何读取数据。设置为'remote'，
		//数据表格将从远程服务器加载数据。当设置为'remote'模式的时候
		//，用户输入将会发送到名为'q'的http请求参数，向服务器检索新的数据。
		pagination : true, //分页条
		pageSize : 5,
		pageList : [ 5, 10, 15, 20, 25 ],
		columns : [ [ //表格列   
		              {
		            	  field : 'cashAccountCode',
		            	  title : '账户账号',
		            	  width : 120
		              }, {
		            	  field : 'cashAccountName',
		            	  title : '账户名称',
		            	  width : 70
		              },
		              {
		            	  field : 'cashAccountBankName',
		            	  title : '账户银行',
		            	  width : 120
		              }] ],
		              onSelect:function(value,index,row){
		            	  $("input[name=payName]").val(index.cashAccountName);
		              }
	}); 
	$('#inCashAccountCode').combogrid({
		panelWidth : 450, //表格宽度
		//panelHeight:500,//表格高度
		value : '', //输入的默认值（可写可不写）
		idField : 'cashAccountCode', //传输的列  
		textField : 'cashAccountCode', //显示的列
		fitColumns : true, //自动适应
		url : '../selectCashAccount.action', //服务器请求路径
		mode : 'remote', //定义在文本改变的时候如何读取数据。设置为'remote'，
		//数据表格将从远程服务器加载数据。当设置为'remote'模式的时候
		//，用户输入将会发送到名为'q'的http请求参数，向服务器检索新的数据。
		pagination : true, //分页条
		pageSize : 5,
		pageList : [ 5, 10, 15, 20, 25 ],
		columns : [ [ //表格列   
		              {
		            	  field : 'cashAccountCode',
		            	  title : '账户账号',
		            	  width : 120
		              }, {
		            	  field : 'cashAccountName',
		            	  title : '账户名称',
		            	  width : 70
		              },
		              {
		            	  field:'cashAccountCardRate',
		            	  title:'年利率'
		              },
		              {
		            	  field : 'cashAccountBankName',
		            	  title : '账户银行',
		            	  width : 120
		              }] ],
		              onSelect:function(value,index,row){
		            	  $("input[name=cashName]").val(index.cashAccountName);
		            	  $("input[name=savingInterest]").val(index.cashAccountCardRate);
		              }
	}); 
	//删除按钮的点击事件
	$("#btn_delete").click(function() {
		var flag='';
		var today=new Date();
		var nowdate=(today.getFullYear())+"-"+(today.getMonth()+1)+"-"+today.getDate();
		var date=new Date(nowdate);
		var mon=date.getMonth()+1;
		var day = date.getDate();
		var mydate = date.getFullYear() + "-" + (mon < 10 ? "0" + mon : mon) + "-" + (day < 10 ? "0" + day : day);
		//得到所有选中的行
		var allRows = $("#myTable").bootstrapTable('getSelections')
		//判断选中的行数

		$.each(allRows,function(i,v){
			var arr=[];
			arr.push(v.savingCode);
			var b=[];
			b.push(v.strDate)
			if(mydate!=b){
				flag=-1;
				myAlert("只能选择当天的日期删除");
				return;
			}
			if(allRows.length>0){
				if(flag!=-1){
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
							
								$.each(allRows,function(i,v){
								
								})
								//ajax操作   （发送请求到数据库删除）
								$.ajax({
									type:'post',
									url:'../deleteSaveingBusiness.action',
									data:'savingCode='+arr,
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
				
			
			}else{
				myAlert("请选则一条您要删除的数据");
			}
			
				
			
		});
		
		
	});
	
	//加载表单验证
	$("#myForm").bootstrapValidator({
		//图标集
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		//列字段
		fields : {
			savingMoney:{
				//验证格式
				validators : {
					notEmpty : {
						message : '流出金额不能为空'
					},
					regexp: {
						regexp: /^[0-9]+$/,
						message: '流出金额只能为数字'
					}
				}
			}

		},
		submitHandler : function(validator, form,
				submitButton) {
			//得到form表单
			var $form = $("#myForm");
			//得带弹窗的标题判断  是增加还是修改
			var title = $("#myModalLabel").text();
			var flag = '';
			if (title == '新增') {
				flag = 'insertSaveingBusiness';
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
					test();
				}
			});

		}


	});
	//增加按钮点击事件
	$("#btn_add").click(function() {
		$('#strDate').datetimepicker({
			language:'zh-CN',//显示中文
			format:'yyyy-mm-dd',//格式化日期
			minView:'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期 
			autoclose:true,//自动关闭\
			todayBtn:true//显示今天按钮
		});
		$('#savingEndDate').datetimepicker({
			language:'zh-CN',//显示中文
			format:'yyyy-mm-dd',//格式化日期
			minView:'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期 SdDate
			autoclose:true,//自动关闭\
			todayBtn:true//显示今天按钮
		});
		$("#myModalLabel").text("新增");
		$('#myModal').modal();
		//alert("增加按钮");
		//将弹窗的标题改为新增


		$("#savingMoney").keyup(function(){
			var savingMoney=$("input[name=savingMoney]").val();
			//alert(savingMoney)
			$("#money").val(savingMoney)
		})
		//业务类型
		$("#businessType").change(function(){
			
			var strDate= $("input[name=strDate]").val();
			var businessType=$("#businessType").val();
			if(businessType!=null){
				var money=$("input[name=money]").val();
				var yearLiLu=$("input[name=savingInterest]").val();
				var moneys=(yearLiLu/365*businessType*money).toFixed(2);
				$("#liXi").val(moneys);
				$.ajax({
					type: "get",
					url:'../selectDate.action?strDate='+strDate+'&businessType='+businessType,
					success:function(msgs){
						$("input[name=strDateEnd]").val(msgs)
					}
				
				})
			}
			
		})
		
		//业务日期
		$("#strDate").change(function(){

			var strDate= $("input[name=strDate]").val();
			var businessType=$("#businessType").val();
			if(strDate!=null){
				$.ajax({
					type: "get",
					url:'../selectDate.action?strDate='+strDate+'&businessType='+businessType,
					success:function(msgs){
						$("input[name=strDateEnd]").val(msgs)
					}
				})
			}
		
		
		})

	});
    //到期办理
	$("#btn_edit").click(function(){
		var today=new Date();
		var nowdate=(today.getFullYear())+"-"+(today.getMonth()+1)+"-"+today.getDate();
		var date=new Date(nowdate);
		var mon=date.getMonth()+1;
		var day = date.getDate();
		var mydate = date.getFullYear() + "-" + (mon < 10 ? "0" + mon : mon) + "-" + (day < 10 ? "0" + day : day);
		//得到所有选中的行
		var allRows = $("#myTable").bootstrapTable('getSelections')
		//判断选中的行数
		if (allRows.length == 0) { //没选中任何行
			//调用弹窗
			myAlert("请选则要到期办理的数据");
			return;
		} else if (allRows.length > 1) {
			myAlert("只能选择一条数据进行到期办理");
			return;
		}
		$.each(allRows,function(i,oneRow){
			if(oneRow.strDateEnd!=mydate&&oneRow.flag==1){
				myAlert("还不能到期办理");
			}else{
				//选中删除提示
				if (window.dialog3) {
					window.dialog3.destroy();
				};
				window.dialog3 = jqueryAlert({
					'title': '温馨提示',
					'content': '您确定要到期办理吗？',
					'modal': true, //是否显示模型窗口
					'className': 'alertDialog',
					'buttons': { //按钮
						'确定': function() {
							window.dialog3.destroy();
							$.ajax({
								url:'../expire.action?savingCode='+oneRow.savingCode+'&outCashAccountCode='+oneRow.outCashAccountCode+
								'&inCashAccountCode='+oneRow.inCashAccountCode+'&savingMoney='+oneRow.savingMoney+'&strDateEnd='+oneRow.strDateEnd+
								'&strDate='+oneRow.strDate,
								success:function(msgs){
									//刷新表格
									$("#myTable").bootstrapTable('refresh');
									myAlert(msgs)
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
		})
	})

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
	//查询的方法
	$("#btnSearch").click(function(){
		alert("查询");
		//刷新表格
		$("#myTable").bootstrapTable('refresh');
	})
	var right='L0702';
	isHaveRight($("#btn_add"),$("#btn_edit"),$("#btn_delete"),right);
})

//清除数据的方法
function test() {
	$(".clearData").val("");
	$("#outCashAccountCode").combogrid("setValue","");
	$("#inCashAccountCode").combogrid("setValue","");
	$(".one").val("");
	$("#myForm").data("bootstrapValidator").resetForm();
	$('.clearData').tooltip('destroy');
	$('.clearData').tooltip({
		title : '不为空'
	});
	$(".one").tooltip("destroy");
	/*	$("input[name=staticticsDate]").tooltip({
			title : '日期不能为空'
		});*/
}