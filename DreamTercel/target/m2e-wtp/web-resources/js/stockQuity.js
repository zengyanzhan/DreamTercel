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
			$(function() {
				//加载表格
				$('#myTable').bootstrapTable({
					url: '../selectStockeQuity.action',
					method: 'get', //请求方式（*）
					//toolbar: '#toolbar', //工具按钮用哪个容器
					striped: true, //是否显示行间隔色
					//cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
					pagination: true, //是否显示分页（*）
					sortable: true, //是否启用排序
					sortOrder: "asc", //排序方式
					queryParams: function(params) {
						var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
							rows: params.limit, //页面大小
							page: params.offset / params.limit + 1, //页码
							strDate: $("input[name=strDate]").val(), //查询的参数   写自己的控制类对应的名字
							equityType: $("#equityType").val(), //查询的参数
							sortName: this.sortName,
							sortOrder: this.sortOrder,
						};
						return temp;
					}, //传递参数（*）
					sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
					pageNumber: 1, //初始化加载第一页，默认第一页
					pageSize: 5, //每页的记录行数（*）
					pageList: [5, 10, 15, 20], //可供选择的每页的行数（*）
					showColumns: false, //是否显示所有的列
					showRefresh: false, //是否显示刷新按钮
					minimumCountColumns: 2, //最少允许的列数
					clickToSelect: true, //是否启用点击选中行
					height: 600, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
					//uniqueId : "usrId", //每一行的唯一标识，一般为主键列
					showToggle: false, //是否显示详细视图和列表视图的切换按钮
					cardView: false, //是否显示详细视图
					detailView: false, //是否显示父子表
					//列字段
					columns:[{
						//复选框
						checkbox: true
					}, 
					{
						field: 'securityCode',
						title: '股票代码',
						//启用该字段的排序
						sortable: true
					},{
						field: 'securityName',
						title: '股票名称',
						
					}, {
						field: 'strDate',
						title: '除权日'
					}, 
					{
						field: 'securityquantity',
						title: '数量',
						formatter: function(value,row,index){
							return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
						}
						
					},{
						field: 'totalmoney',
						title: '金额',
						formatter: function(value,row,index){
							return  (value || 0).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
						}
					},]	
				});
					//日期时间插件	
					$("#strDate").datetimepicker({
						 language:'zh-CN',//显示中文
						 format:'yyyy-mm-dd',//格式化日期
						 minView:'month',//设置只显示到月份
						// initialDate:new Date(),//初始化当前日期
						 autoclose:true,//自动关闭\
						 todayBtn:true//显示今天按钮
					});
					
					//查询按钮的事件
					$("#btnSearch").click(function(){
						$("#myTable").bootstrapTable('refresh');
					});
				
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
					'closeTime': 1000, //时间
					'className': 'alertDialog'
				});		
			}
			