//屏蔽回车键 解决弹窗   回车无限弹的问题		
document.addEventListener('keydown', function(e) {
	var a = e.keyCode;
	if ((a == 13)) { //回车
		if (e.preventDefault) {
			e.preventDefault();
			e.stopPropagation()
		} else {
			e.returnValue = false;
			e.cancelBubble = true
		}
		return false;
	}
});




//加载事件
$(function(){
	//日期时间插件	
	$('#tongjiDate').datetimepicker({
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
	$("#statisticDateWhere").val(mydate);



	//判断今天有没有数据
	$.ajax({
		type : "post",
		url : "../netValue/selectNetValues.action",
		data:'page='+1+"&rows="+5+"&rowsTotal="+5,
		success : function(msg) {
			if(msg==""){
				myAlert("亲！今天还没有数据哦，请先统计！");
			}
			$("#myTable").bootstrapTable('refresh');
		}
	});

	//点击查询的事件
	$("#btnSearch").click(function(){
		$('#myTable').treegrid("load",{
			statisticDateWhere : $("#statisticDateWhere").val(),
		});
		$("#myTable").bootstrapTable('refresh');
	});


	//点击统计的事件
	$("#btnTongJi").click(function(){
		var statisticDateWhere=$("#statisticDateWhere").val();
		if(statisticDateWhere==''){
			myAlert("请选择统计日期进行统计！");
		}else{
			window.dialog3 = jqueryAlert({
				'title': '温馨提示',
				'content': '您确定要统计数据吗？',
				'modal': true, //是否显示模型窗口
				'className': 'alertDialog',
				'buttons': { //按钮
					'确定': function() {
						window.dialog3.destroy();
						//ajax操作   （发送请求到数据库删除）
						$.ajax({
							type : "post",
							url : "../netValue/isHoilday.action",
							data: "statisticDateWhere="+statisticDateWhere,
							success : function(msg) {
								if(msg==''){
									window.dialog3 = jqueryAlert({
										'title': '温馨提示',
										'content': '今天是节假日，您确定要统计数据吗？',
										'modal': true, //是否显示模型窗口
										'className': 'alertDialog',
										'buttons': { //按钮
											'确定': function() {
												window.dialog3.destroy();
												$.ajax({
													type : "post",
													url : "../netValue/netValueStatistics.action",
													data: "statisticDateWhere="+statisticDateWhere,
													success : function(msg) {
														myAlert(msg);
														if(msg=="统计成功"){
															//重新调用查询的方法
															$('#myTable').treegrid("load",{
																statisticDateWhere : $("#statisticDateWhere").val(),
															});
															$("#myTable").bootstrapTable('refresh');
															$("#statisticDateWhere").val('');
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
									}else{
										$.ajax({
											type : "post",
											url : "../netValue/netValueStatistics.action",
											data: "statisticDateWhere="+statisticDateWhere,
											success : function(msg) {
												myAlert(msg);
												if(msg=="统计成功"){
													//重新调用查询的方法
													$('#myTable').treegrid("load",{
														statisticDateWhere : $("#statisticDateWhere").val(),
													});
													$("#myTable").bootstrapTable('refresh');
													$("#statisticDateWhere").val('');
												}
											}
										});
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
	$("#myTable").treegrid({
		height:600,   
		idField:'projectName',    
		treeField:'projectName',  
		animate:true,//定义在节点展开或折叠的时候是否显示动画效果。
		url:'../netValue/selectNetValues.action',
		method:'get',//请求的方式
		toolbar : '#toolbar', //工具按钮用哪个容器
		columns:[[{
			checkbox:true	
		},{
			field:'projectName',
			title:'项目名称'	,
			width:200	
		},{
			field:'projectCode',
			title:'项目代码'		,
			width:200,
			formatter: function(value,row,index){
				if(row.projectName=='基金总份额' || row.projectName=='资产合计' 
					|| row.projectName=='资产负债' || row.projectName=='资产净值' || row.projectName=='单位净值' ){

					return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");

				}else if(value==null){

					return '';
				}
				return value;
			}
		},{
			field:'quantity',
			title:'票面值/股数',
			width:200,
			formatter: function(value,row,index){
				if(value==0){
					return '';
				}else{
					return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
				}
			}
		},{
			field:'price',
			title:'行情价格'	,
			width:200,
			formatter: function(value,row,index){
				if(value==0){
					return '';
				}else{
					return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
				}
			}
		},{
			field:'costing',
			title:'成本',
			width:200,
			formatter: function(value,row,index){
				if(value==0){
					return '';
				}else{
					return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
				}
			}
		},{
			field:'marketValue',
			title:'市值 ',
			width:200,
			formatter: function(value,row,index){
				if(value==0){
					return '';
				}else{
					return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
				}
			}
		},{
			field:'valueAdd',
			title:'估值增值 ',
			width:200,
			formatter: function(value,row,index){
				if(value==0){
					return '';
				}else{
					return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
				}
			}
		}]],
		//表格操作方法
		collapsible:true,//可以折叠
		minimizable:false,//添加最小化按钮
		maximizable:false,// 添加最大话按钮
		striped:true,//是否显示斑马线效果。
		pagination : true,//如果为true，则在DataGrid控件底部显示分页工具栏。
		pageSize : 5,//在设置分页属性的时候初始化页面大小。
		pageList : [5, 10, 15,20],//在设置分页属性的时候 初始化页面大小选择列表。
		pageNumber : 1,//在设置分页属性的时候初始化页码
		pagePosition : 'bottom'//定义分页工具栏的位置。可用的值有：'top','bottom','both'。
	});
	//导出
	$("#btnExport").click(function(){
		var statisticDateWhere=$("#statisticDateWhere").val();
		if(statisticDateWhere==''){
			myAlert("请选择统计日期进行统计！");
		}else{
			$.ajax({
				type : "post",
				url : "../netValue/netValueStatistics.action",
				data: "statisticDateWhere="+statisticDateWhere,
				success : function(msg) {
				
					if(msg=="证券库存和现金库存都没有统计,请先统计库存！"){
						myAlert("今天没有数据不能导出");
					}else{
						window.open('../netValue/exeportNetValue.action?statisticDate='+statisticDateWhere)
					}
				}
			});
		
		}
	})



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
		'closeTime': 4000, //时间
		'className': 'alertDialog'
	});
}
