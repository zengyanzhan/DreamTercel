$(function(){
	$('#jieMianDealDate').datetimepicker({
		language:'zh-CN',//显示中文
		format:'yyyy-mm-dd',//格式化日期
		minView:'month',//设置只显示到月份
		//initialDate:new Date(),//初始化当前日期
		autoclose:true,//自动关闭\
		todayBtn:true,//显示今天按钮
		todayHighlight:true
	});
	//给日期默认今天
	var today=new Date();
	var nowdate=(today.getFullYear())+"-"+(today.getMonth()+1)+"-"+today.getDate();
	//对日期格式进行处理
	var date=new Date(nowdate);
	var mon=date.getMonth()+1;
	var day = date.getDate();
	var mydate = date.getFullYear() + "-" + (mon < 10 ? "0" + mon : mon) + "-" + (day < 10 ? "0" + day : day);
	$("#strJieMianDealDate").val(mydate);
	//表格
	$("#dealSettleAccountsTable").bootstrapTable({
		method: 'get', //请求方式（*）
		toolbar: '#toolbar', //工具按钮用哪个容器
		title:'交易结算',
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
			field: 'strSecurityType',
			title: '证券名称'
		}, {
			field: 'lcTotalPrice',
			title: '今日流出金额'
		}, {
			field: 'lrTotalPrice',
			title: '今日流入金额'
		}, {
			field: 'settleMoney',
			title: '今日清算金额',
			formatter : function(value, index, row) {
				if(Number(value)==0){
					return "";
				}
				if (Number(value) < 0) {
					return "<span style='color:red'>"
							+ (value*-1 || 0)
									.toString()
									.replace(
											/(\d)(?=(\d{3})+(?!\d))/g,
											"$1,")
							+ "</span>";
				}
				return "<span style='color:green'>"
						+ (value || 0)
								.toString()
								.replace(
										/(\d)(?=(\d{3})+(?!\d))/g,
										"$1,")
						+ "</span>";
			}
		}, {
			field: 'commissionFee',
			title: '佣金费率'
		},  {
			field: 'stampDuty',
			title: '印花税'
		}, {
			field: 'brokerageFee',
			title: '经手费'
		}, {
			field: 'transferFee',
			title: '过户费'
		}, {
			field: 'managementFee',
			title: '征管费'
		}, {
			field: 'securityInterest',
			title: '国债利息'
		}, {
			field: 'shiJiMoney',
			title: '实际清算金额',
			formatter : function(value, index, row) {
				if(Number(value)==0){
					return "";
				}
				if (Number(value) < 0) {
					return "<span style='color:red'>"
							+ (value*-1 || 0)
									.toString()
									.replace(
											/(\d)(?=(\d{3})+(?!\d))/g,
											"$1,")
							+ "</span>";
				}
				return "<span style='color:green'>"
						+ (value || 0)
								.toString()
								.replace(
										/(\d)(?=(\d{3})+(?!\d))/g,
										"$1,")
						+ "</span>";
			}
		}]
	});
	$("#btnSearch").click(function(){
		var strDealDate=$("#strJieMianDealDate").val();
		if(typeof(strDealDate)!='undefined'&&strDealDate!=''){
			$("#dealSettleAccountsTable").bootstrapTable("refresh",{
				url: '../selectDifferenceReport.action?strDealDate='+strDealDate,
			});
		}else{
			myAlert("请选则要统计的日期");
		}
		
	});
});