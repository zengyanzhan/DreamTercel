<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="../js/jquery-3.1.1.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="../js/bootstrap.min.js"></script>
<!--引入表格的js文件-->
<script src="../js/bootstrap-table.js"></script>
<!--引入表格的样式文件-->
<link href="../css/bootstrap-table.css" rel="stylesheet" />

<!--引入表单的验证文件-->
<script type="text/javascript" src="../js/bootstrapValidator.js"></script>
<!-- 引入表单验证 的css文件-->
<link rel="stylesheet" href="../css/bootstrapValidator.css" />
<!--引入表格的汉化文件-->
<script src="../js/bootstrap-table-zh-CN.js"></script>

<!--导入日期插件包-->
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.zh-CN.js"></script>

<!--引入弹窗插件的样式文件-->
<link rel="stylesheet" href="../js/alert/alert.css">
<!--引入弹窗插件的js文件-->
<script src='../js/alert/alert.js'></script>
<!--引入弹窗插件的样式文件-->
<link rel="stylesheet" href="../js/message/message.css">
<!--引入弹窗插件的js文件-->
<script src='../js/message/message.js'></script>

<!-- easyui的js和css部分 -->
<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet"
	type="text/css" />
<link href="../js/easyui/icons/icon-all.css" rel="stylesheet"
	type="text/css" />
<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>

<link href="../css/nth.tabs.min.css" rel="stylesheet"/>
<script type="text/javascript" src=" ../js/nth.tabs.min.js"></script>

<title>表格demo</title>
<style type="text/css">
* {
	font-family: "微软雅黑";
}

.form-control {
	width: 140px;
}

#mianDiv {
	position: absolute;
	width: 100%;
	height: 100%;
}

#mianDiv .columns-right {
	margin-top: 30px;
}
/*弹窗的样式*/
div .alert-content, div .alert-title, div .alert-btn-box, div .alert-btn-p
	{
	/* background-color:blue; */
	font-weight: bold;
}
</style>
<script type="text/javascript">
		    
			//加载事件 
			$(function() {
				var allTiaozhuan =$(".tiaozhuan");
				myTab=parent.myTab;
				$.each(allTiaozhuan,function(i,everyLi){
					$(everyLi).click(function(){
						var title =$(this).attr("id");
						var url =$(this).attr("title"); 
						
						//得到所有已经展开的选项卡
							var allTab=myTab.getTabList();
							//标志  记录选项卡是否展开
							var  flag =false;
							//判断该选项卡是否已经展开
							$.each(allTab,function(i,oneTab){
								//如果当前的标题已经在选项卡中存在
								if(title==oneTab.title){
								
									flag=true;
								}
							
							
							});
							//flag为false说明该选项已经在选项卡中不存在  
								if(!flag){
									//调用增加选项卡的方法
									myTab.addTab({
									id:title,
									title:title,
									content:'<iframe src="'+url+'" frameborder=0 height=100% width=100% ></iframe>',
								});
							}
					//不管存不存在 调用选中选项卡的方法使该选项卡选中
									myTab.setActTab(title);
					});
				});
				
				
				
				//加载表格
				$('#myTable').bootstrapTable({
					url: '../selectStock.action',
					method: 'get', //请求方式（*）
					contentType:'application/json',
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
							datetime: $("#datetime").val()==''?'':''+$("#datetime").val()+'', //查询的参数   统计的日期 
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
					//列字段
					columns: [{
						//复选框
						checkbox: true
					}, {
						field: 'stockCode',
						title: '编号',
						//启用该字段的排序
						sortable: true
					}, {
						field: 'stockName',
						title: '库存名称'
					}, {
						field: 'fundCode',
						title: '基金编号',
						formatter:function(value,row,index){
							if(value==null || value==''){
								return "暂无";
							}else{
								return value;
							}	
						}
					}, {
						field: 'fundName',
						title: '基金名称',
						formatter:function(value,row,index){
							if(value==null || value==''){
								return "暂无";
							}else{
								return value;
							}	
						}
					}, {
						field: 'operator',
						title: '操作员',
						formatter:function(value,row,index){
							if(value==null || value==''){
								return "暂无";
							}else{
								return value;
							}
						}
					}, {
						field: 'statisticsDate',
						title: '统计日期',  
						formatter:function(value,row,index){
							if(value==null || value==''){
								return "暂无";
							}else{
								return value;
							}
						}
					},{
						field:'stockNum',
						title:'已统计数据',
						formatter:function(value,row,index){
							if(value==null && value==''){
								return "暂无";
							}else{
								return value;
							}
						}
					},{
						field:'stockType',
						title:'统计状态',
						formatter:function(value,row,index){
							if(value==null || value==''){
								return "暂无";
							}else{
								return value;
							}
						}
					} ]
				});
				$('#datetimepicker').datetimepicker({
						         language: 'zh-CN',//显示中文
                                 format: 'yyyy-mm-dd',//显示格式
                                 minView: "month",//设置只显示到月份
                                 //initialDate: new Date(),//初始化当前日期
                                 autoclose: true,//选中自动关闭
                                 todayBtn: true//显示今日按钮
				}); 
				//给日期默认今天
				var today=new Date();
				var nowdate=(today.getFullYear())+"-"+(today.getMonth()+1)+"-"+today.getDate();
				//对日期格式进行处理
				var date=new Date(nowdate);
				var mon=date.getMonth()+1;
				var day = date.getDate();
				var mydate = date.getFullYear() + "-" + (mon < 10 ? "0" + mon : mon) + "-" + (day < 10 ? "0" + day : day);
				$("#datetime").val(mydate);
				//统计按钮的事件
				$("#btnSearch").click(function() { 
					var date=$("#datetime").val();//得到统计日期
					var fundCode=$("input[name=fundCode]").val();//得到基金代码
					var user=$("input[name=user]").val();//得到用户名称
					var rows=$("#myTable").bootstrapTable("getSelections");//得到所有行
					if(rows.length<=0){
						$.message({
							message:'请至少选择一行进行统计',
							type:'warning'
						})
						return;
					}
					if(date==''){
						$.message({
							message:'请输入统计日期',
							type:'warning'
						})
						return;
					}
					var strName=[];
					$.each(rows,function(i,v){
						strName.push(v.stockName);
						//alert(i+","+v);
					})
					if (window.dialog3) {
						window.dialog3.destroy();
					};
					var flag=null;
					window.dialog3 = jqueryAlert({
						'title' : '温馨提示',
						'content' : '您是否忽略统计昨日库存？',
						'modal' : true, //是否显示模型窗口
						'className' : 'alertDialog',
						'buttons' : { //按钮
							'确定' : function() {
								window.dialog3.destroy();
								//ajax操作   （发送请求到数据库删除）
								flag=1;
								postRequest(strName,fundCode,user,date,flag);
							},
							'取消' : function() {
								//销毁弹窗
								window.dialog3.destroy();
								flag=2;
								postRequest(strName,fundCode,user,date,flag);
							}
						}
					});
					
				});
		 
			 });
			function postRequest(strName,fundCode,user,date,flag){
				//ajax发送请求
				$.ajax({
					url:'../stockStatistics.action?stockName='+strName+'&fundCode='+fundCode+'&operator='+user+'&statisticsDate='+date+'&flag='+flag,
					method:'POST',
					contentType : "application/x-www-form-urlencoded; charset=UTF-8",
					success:function(msg){
						 //$("#datetime").val('');//清除数据
						var str=eval("("+msg+")");
						var allTableData = $("#myTable").bootstrapTable('getData');//得到所有的行
						$.each(str,function(i,v){
							$.each(allTableData,function(s,u){
								if(v.stockName==u.stockName){//判断名字相同 就得到该行索引进行修改
									if(v.flag==2){//提示
										$.message({
											message:v.stockName+'统计日期必须在基金成立日期这天以及之后',
											type:'warning'
										})
										return;
									}else if(v.flag==3){//提示请统计昨日库存
										$.message({
											message:'请统计'+v.stockName+'的昨日库存',
											type:'warning'
										})
										return;
									}else{
									    $("#myTable").bootstrapTable('updateRow',{
											index:s,
											row:{
												stockCode:u.stockCode,
												stockName:v.stockName,
												fundCode:v.fundCode,
												fundName:v.fundName,
												operator:v.operator,
												statisticsDate:v.statisticsDate,
												stockNum:v.stockNum,
												stockType:'统计完成'
											}
										})  
										$.message({
											message:v.stockName+'统计完成',
											type:'success'
										})
									}
									
								}
							})
							
						})
					}
				}) 
			}
		</script>
</head>

<body>
	<!--整个界面-->
	<div id="mianDiv">
		<!--工具栏-->
		<div id="toolbar" class="panel-heading form-inline"
			style="margin-top: 10px">
			<a title="jsp/cashStock.jsp" class="btn btn-info  tiaozhuan"    id="现金库存"><span
				class="glyphicon glyphicon-search"></span>查询现金库存</a> <a
				title="jsp/securityStock.jsp" class="btn btn-info tiaozhuan"   id="证券库存"><span
				class="glyphicon glyphicon-search"></span>查询证券库存</a> <a
				title="jsp/TaStock.jsp" class="btn btn-info tiaozhuan"   id="TA库存"><span
				class="glyphicon glyphicon-search"></span>查询TA库存</a> <a
				title="jsp/moneyArapStock.jsp" class="btn btn-info tiaozhuan"  id="现金应收应付库存"><span
				class="glyphicon glyphicon-search"></span>查询现金应收应付库存</a> <a
				title="jsp/securityArapStock.jsp" class="btn btn-info tiaozhuan"  id="证券应收应付库存"><span
				class="glyphicon glyphicon-search"></span>查询证券应收应付库存</a> <label
				class="control-label">日期：</label>
			<div class='input-group date' id='datetimepicker'>
				<input type='text' class="form-control" id="datetime" /> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
			<input type="hidden" name="fundCode" value="${fund.fundCode}" /> <input
				type="hidden" name="user" value="${user.userName}" />
			<button type="button" style="margin-left: 10px" id="btnSearch"
				class="btn btn-info">统计</button>

		</div>
		<!--中间部分-->
		<div class="panel-body">
			<!--表格-->
			<table id="myTable"></table>
		</div>
	</div>
</body>

</html>