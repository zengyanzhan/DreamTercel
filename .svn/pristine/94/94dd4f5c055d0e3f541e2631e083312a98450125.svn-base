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
	$('#selectDate').datetimepicker({
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


	//加载表格
	$('#myTable').bootstrapTable({
		url: '../selectFundInvestGroups.action',
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
					statisticDateWhere: $("#statisticDateWhere").val()==''?'':''+$("#statisticDateWhere").val()+'', //查询的参数   写自己的控制类对应的名字
							orderColumn: this.sortName,
							orderStyle: this.sortOrder,
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
		height: 650, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
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
			sortable: true,
			formatter: function(value,row,index){
				if(value==''){
					return '';
				}
				else if(value==undefined){
					return '';
				}else{
					return  value;
				}
			}
		}, {
			field: 'securityName',
			title: '证券名称',
			formatter: function(value,row,index){
				if(value==''){
					return '';
				}
				else if(value==undefined){
					return '';
				}else{
					return  value;
				}
			}
		}, {
			field: 'securityQuantity',
			title: '库存数量',
			formatter: function(value,row,index){
				if(value==0){
					return '';
				}else if(value==undefined){
					return '';
				}
				else{
					return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
				}
			}
		}, {
			field: 'securityUnitCost',
			title: '单位成本',
			formatter: function(value,row,index){
				if(value==0){
					return '';
				}else if(value==undefined){
					return '';
				}
				else{
					return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
				}
			}
		}, {
			field: 'securityCosting',
			title: '证券成本',
			formatter: function(value,row,index){
				if(value==0){
					return '';
				}else if(value==undefined){
					return '';
				}
				else{
					return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
				}
			}
		},{
			field: 'price',
			title: '行情价格',
			formatter: function(value,row,index){
				if(value==0){
					return '';
				}else if(value==undefined){
					return '';
				}else{
					return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
				}
			}
		},{
			field: 'marketValue',
			title: '证券市值',
			formatter: function(value,row,index){
				if(value==0){
					return '';
				}else if(value==undefined){
					return '';
				}else{
					return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
				}
			}
		},{
			field: 'costingPercentage',
			title: '成本占净值百分比',
			formatter: function(value,row,index){
				if(value==undefined){
					return '';
				}else if(value==''){
					return '';
				}
				else{
					return  value+'%';
				}
			}
		},{
			field: 'marketValuePercentage',
			title: '市值占净值百分比',
			formatter: function(value,row,index){
				if(value==undefined){
					return '';
				}else if(value==''){
					return '';
				}
				else{
					return  value+'%';
				}
			}
		}]
	});











	//查询按钮的事件
	$("#btnSearch").click(function() {
		$("#myTable").bootstrapTable('refresh');
		//$("#businessDateWhere").val('');
	});


	var right='L0809';   
	isHaveRight($("#btn_add"),$("#btn_delete"),$("#btn_edit"),right)
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
		'closeTime': 3000, //时间
		'className': 'alertDialog'
	});
}
