<%@ page language="java" contentType="text/html; charset=UTF-8
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收益计提</title>
<script type="text/javascript">
		$(function(){
			$('#betweenTable1').bootstrapTable({
				url:'',
				method:'get',//请求方式
				striped: true, //是否显示行间隔色
				pagination: true, //是否显示分页（*）
				sortable: true, //是否启用排序
				sortOrder: "asc", //排序方式
				sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
				pageNumber: 1, //初始化加载第一页，默认第一页
				pageSize: 5, //每页的记录行数（*）
				pageList: [5, 10, 15, 20], //可供选择的每页的行数（*）
				//showColumns: true, //是否显示所有的列
				//showRefresh: true, //是否显示刷新按钮
				//minimumCountColumns: 2, //最少允许的列数
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
					field: 'ca_cashArapCode',
					title: '现金应收应付编号',
					//启用该字段的排序
					sortable: true
				}, {
					field: 'cashAccountCode',
					title: '银行卡号 '
				},{
					field: 'fundCode',
					title: '基金编号'
				},{
					field: 'ca_cashArapType',
					title: '业务类型 '
				},{
					field: 'ca_moneyDirection',
					title: '资金流向'
				},{
					field: 'ca_money',
					title: '金额'
				},{
					field: 'ca_businessDate',
					title: '业务日期'
				},{
					field: 'ca_Desc',
					title: '备注'
				},]
			})
			
			$(function(){
				$('#betweenTable2').bootstrapTable({
					url:'',
					method:'get',//请求方式
					striped: true, //是否显示行间隔色
					pagination: true, //是否显示分页（*）
					sortable: true, //是否启用排序
					sortOrder: "asc", //排序方式
					sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
					pageNumber: 1, //初始化加载第一页，默认第一页
					pageSize: 5, //每页的记录行数（*）
					pageList: [5, 10, 15, 20], //可供选择的每页的行数（*）
					//showColumns: true, //是否显示所有的列
					//showRefresh: true, //是否显示刷新按钮
					//minimumCountColumns: 2, //最少允许的列数
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
						field: 'ca_cashArapCode',
						title: '现金应收应付编号',
						//启用该字段的排序
						sortable: true
					}, {
						field: 'cashAccountCode',
						title: '银行卡号 '
					},{
						field: 'fundCode',
						title: '基金编号'
					},{
						field: 'ca_cashArapType',
						title: '业务类型 '
					},{
						field: 'ca_moneyDirection',
						title: '资金流向'
					},{
						field: 'ca_money',
						title: '金额'
					},{
						field: 'ca_businessDate',
						title: '业务日期'
					},{
						field: 'ca_Desc',
						title: '备注'
					},]
				})
			});
			
			$(function(){
				$('#betweenTable3').bootstrapTable({
					url:'',
					method:'get',//请求方式
					striped: true, //是否显示行间隔色
					pagination: true, //是否显示分页（*）
					sortable: true, //是否启用排序
					sortOrder: "asc", //排序方式
					sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
					pageNumber: 1, //初始化加载第一页，默认第一页
					pageSize: 5, //每页的记录行数（*）
					pageList: [5, 10, 15, 20], //可供选择的每页的行数（*）
					//showColumns: true, //是否显示所有的列
					//showRefresh: true, //是否显示刷新按钮
					//minimumCountColumns: 2, //最少允许的列数
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
						field: 'ca_cashArapCode',
						title: '现金应收应付编号',
						//启用该字段的排序
						sortable: true
					}, {
						field: 'cashAccountCode',
						title: '银行卡号 '
					},{
						field: 'fundCode',
						title: '基金编号'
					},{
						field: 'ca_cashArapType',
						title: '业务类型 '
					},{
						field: 'ca_moneyDirection',
						title: '资金流向'
					},{
						field: 'ca_money',
						title: '金额'
					},{
						field: 'ca_businessDate',
						title: '业务日期'
					},{
						field: 'ca_Desc',
						title: '备注'
					},]
				})
			});
			//日期时间插件	
			$('#dateTest').datetimepicker({
				 language:'zh-CN',//显示中文
				 format:'yyyy-mm-dd',//格式化日期
				 minView:'month',//设置只显示到月份
				// initialDate:new Date(),//初始化当前日期
				 autoclose:true,//自动关闭\
				 todayBtn:true//显示今天按钮
			});
		});	
	</script>
</head>
<body>
<!--整个界面-->
		<div id="mianDiv">
			<!--工具栏-->
			<div id="toolbar" class="panel-heading form-inline">
			 &nbsp;&nbsp; 
			日期:	
			 <div class="input-group date" id="dateTest">
			 	<input type="text" class="form-control" >
			 	<span class="input-group-addon">
			    <span class="glyphicon glyphicon-calendar"></span>
			 	</span>
			 </div>
			 银行卡号:<input class="form-control" id="bankCard" style="width:200px"  />
			<button type="button" style="margin-left: 30px" id="btnSearch" class="btn btn-info">查询</button>
			<button type="button" style="margin-left: 30px" id="btnCount" class="btn btn-info">统计</button>
			</div>
			<!--中间部分-->
			<div class="panel-body">
				<!--表格-->
				<table id="myTable"></table>
			</div>
			</div>
			<div style="margin:20px 0 10px 0;"></div> 
   <div id="tt" class="easyui-tabs" style="height:370px;"> 
	   <div title="现金计息" style="padding:10px" >   
	 	  <table id="betweenTable1">
	 	  
	 	  </table>
	    </div>     
	    <div title="债券计息"  style="padding:10px"  >   
	   	  <table id="betweenTable2">
	 	  
	 	  </table>
	    </div>   
	    <div title="两费" style="padding:10px;" >   
	      <table id="betweenTable3">
	 	  
	 	  </table>
	    </div>   
	</div>  	 
</body>
</html>