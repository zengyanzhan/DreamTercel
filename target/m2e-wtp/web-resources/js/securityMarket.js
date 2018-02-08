$(function(){
	//日期时间插件	
	$('#strDate').datetimepicker({
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
	$("#businessDateWhere").val(mydate);
	//工具栏部分
	$('#myTable').bootstrapTable({
		url:'../selectSecurityMarket.action',
		method:'get',//请求方式
		toolbar: '#toolbar',//工具栏
		striped: true, //是否显示行间隔色
		pagination: true, //是否显示分页（*）
		sortable: true, //是否启用排序
		sortOrder: "asc", //排序方式
		queryParams: function(params) {
		var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					rows: params.limit, //页面大小
					page: params.offset / params.limit + 1, //页码
					businessDateWhere:$("#businessDateWhere").val(),
					sortName: this.sortName,
					sortOrder: this.sortOrder,
			};
			return temp;
		}, //传递参数（*）
		sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
		pageNumber: 1, //初始化加载第一页，默认第一页
		pageSize: 5, //每页的记录行数（*）
		pageList: [5, 10, 15, 20], //可供选择的每页的行数（*）
		showColumns: true, //是否显示 所有的列
		showRefresh: true, //是否显示刷新按钮
		minimumCountColumns: 2, //最少允许的列数
		clickToSelect: true, //是否启用点击选中行
		height: 348, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		//uniqueId : "usrId", //每一行的唯一标识，一般为主键列
		showToggle: false, //是否显示详细视图和列表视图的切换按钮
		cardView: false, //是否显示详细视图
		detailView: false, //是否显示父子表
		//列字段
		columns: [{
			//复选框
			checkbox: true
		}, {
			field: 'securityCode',
			title: '证券代码',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'securityName',
			title: '证券名称'
		},{
			field: 'securityQuantity',
			title: '证券数量'
		},{
			field: 'securityUnitCost',
			title: '单位成本'
		},{
			field: 'price',
			title: '行情价格',
		},{
			field: 'projectCode',
			title: '资产净值',
		},{
			field: 'StrStatisticDate',
			title: '统计日期',
		},{
			field: 'marketChange',
			title: '市值变动比',
			formatter: function(value,row,index){
				if(value==0){
					return '';
				}else{
					return value+'%';
				}
			}
		},{
			field: 'marketNetWorth',
			title: '市值占净值',
			formatter: function(value,row,index){
				if(value==0){
					return '';
				}else{
					return value+'%';
				}
			}	
		},]
	})
	//查询的方法
	$('#btnSelect').click(function(){
		alert('进入了查询按钮');
		$("#myTable").bootstrapTable('refresh');
	})
});