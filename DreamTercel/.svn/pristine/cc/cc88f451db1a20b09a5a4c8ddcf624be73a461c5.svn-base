<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>交易数据</title>
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
		<!--引入弹窗插件的样式文件-->
		<link rel="stylesheet" href="../js/alert/alert.css">
		<!--引入弹窗插件的js文件-->
		<script src='../js/alert/alert.js'></script>
		<!--引用券商信息的js文件 -->
		<script src="../js/tradeData.js"></script>
		<!--引入工具的js-->
		<script type="text/javascript" src="../js/utils.js"></script>
		<!--下拉列表css、js-->
		<script type="text/javascript" src="../js/select/bootstrap-select.js"></script>
		<link rel="stylesheet" href="../css/bootstrap.min.css" />
		<!--导入日期插件包-->
		<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
		<!--导入日期汉化包-->
		<script type="text/javascript" src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
		<link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />
		<!-- easyui的js和css部分 -->
		<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
		<link href="../js/easyui/icons/icon-all.css" rel="stylesheet" type="text/css" />
		<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
		<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
		

		<!--引入工具的js-->
		<script type="text/javascript" src="../js/utils.js"></script>
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
			
			div .alert-content,
			div .alert-title,
			div .alert-btn-box,
			div .alert-btn-p {
				/* background-color:blue; */
				font-weight: bold;
			}
		</style>
	</head>

	<body>
		<div id="mianDiv">
			<table id="deslateTable"></table>
			<!--描述：工具栏-->
			<div id="toolbar" class="panel-heading form-inline">
				<!--增加按钮-->
				<button id="btn_add" type="button" class="btn btn-info">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
					</button>
				<!--修改按钮-->
				<button id="btn_edit" type="button" class="btn btn-info">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
					</button>
				<!--删除按钮-->
				<button id="btn_delete" type="button" class="btn btn-info">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
					</button>
				<!--从上海-->
				<button id="shInput" type="button" class="btn btn-info">
						<span class="glyphicon glyphicon-import" aria-hidden="true">  </span> 上海过户库数据导入
					</button>
				<button id="szInput" type="button" class="btn btn-info">
						<span class="glyphicon glyphicon-import" aria-hidden="true">  </span> 深圳回报库数据导入
					</button>&nbsp;&nbsp; 
					<div class="form-group">
				<label for="dealType">证券代码:</label>
				<div class="form-group">
					<input type="text" data-placement="top" id="jiemiansecurityCode" name="jiemiansecurityCode" class="form-control" placeholder="证券代码">
				</div>
			</div>&nbsp;&nbsp;
				<label>交易日期：</label>
				<div class="input-group date" id="dateTest">
					<input type="text" class="form-control" id="dealDate">
					<span class="input-group-addon">
		 				<span class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
				<button type="button" style="margin-left: 50px" id="btnSearch" class="btn btn-info">查询</button>
			</div>
		</div>
		<!--数据导入弹窗div-->
		<div class="modal fade" id="inputDate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog " role="document">
				<div class="modal-content" style="width:570px;height:310px">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
						
					</button>
					
						<h4 class="modal-title" id="myModalLabel">深圳回报库导入</h4>
					</div>
					<form action="../imputShguk.action" method="post" enctype="multipart/form-data">
					<div class="modal-body" style="height:150px;">
						<span style="font-size:15px;font-weight: bold;">请选择需要的dbf文件：</span><input type="file" name="szInput" size="15" style="margin-left: 160px ;margin-top: 15px;" />
					</div>
					<div class="modal-footer">
					<button type="submit" id="btnInput" class="btn btn-primary">
						<span class="glyphicon glyphicon-import" aria-hidden="true"></span>导入
					</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
					</button>
						
					</div>
					</form>
				</div>
			</div>
		</div>
		<!--增加弹窗div-->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
			<div class="modal-dialog " role="document">
				<div class="modal-content" style="width:855px;height:670px;margin-left: -130px"  >
					<!--表单验证  -->
					<form class="form-signin required-validate" action="/insertSysUser.action" method="post" id="myForm" onsubmit="return insertSysUser(this)">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
							<h4 class="modal-title" id="myModalLabel">新增</h4>
						</div>
						<div class="modal-body">
							<div class="form-inline" style="padding: 5px;">
								<div class="form-group" style="margin-right: 20px">
									<label for="dealDataCode">交易单号:</label>
									<input type="text" name="dealDataCode" class="form-control" data-placement="top" placeholder="交易单号">
								</div>
								&nbsp;&nbsp;
								<div class="form-group"  style="margin-right: 20px">
									<label for="securityCode">证券编号:</label> <input type="text" id="securityCode" name="usrRoleId" data-placement="top" class="form-control" placeholder="角色编号" style="width:175px;height:32px">
								</div>
								&nbsp;&nbsp;
								<div class="form-group">
									<label for="userName">投资经理:</label>
									<div class="form-group">
										<input class="form-control" id="userName" name="userName" style="width: 175px;" />
									</div>
								</div>
							</div>

							<div class="form-inline" style="padding: 5px;">
								<div class="form-group"  style="margin-right: 20px">
									<label for="brokerCode">券商名称:</label> <input type="text" id="brokerCode" name="usrRoleId" data-placement="top" class="form-control" placeholder="角色编号" style="width:175px;height:32px">
								</div>
								&nbsp;&nbsp;
								<div class="form-group"  style="margin-right: 20px">
									<label for="seatCode">席位名称:</label> <input type="text" id="seatCode" name="usrRoleId" data-placement="top" class="form-control" placeholder="角色编号" style="width:175px;height:32px">
								</div>
								&nbsp;&nbsp;
								<div class="form-group">
									<label for="dealType">交易方式:</label>
									<div class="form-group">

										<input class="form-control" id="dealType" name="dealType" style="width: 175px;" />
									</div>
								</div>
							</div>

							<hr/>

							<div class="form-inline" style="padding: 5px;">
								<div class="form-group" style="margin-right: 20px">
									<label for="dealStatus">交易状态:</label>
									<div class="form-group">

										<input class="form-control" id="dealStatus" name="dealStatus" style="width: 175px;" />
									</div>
								</div>
								&nbsp;&nbsp;
								<div class="form-group"  style="margin-right: 20px">
									<label for="dealPrice">交易价格:</label> <input type="text" data-placement="top" id="dealPrice" name="dealPrice" class="form-control" placeholder="交易价格">
								</div>
								&nbsp;&nbsp;
								<div class="form-group" >
									<label for="dealQuantity">交易数量:</label> <input type="text" id="dealQuantity" name="dealQuantity" data-placement="top" class="form-control" placeholder="交易数量">
								</div>
								
								
							</div>
							<div class="form-inline" style="padding: 5px;">
								<div class="form-group" style="margin-right: 20px">
									<label for="cashAccountCode">账户编号:</label>
									<div class="form-group">

										<input class="form-control" id="cashAccountCode" name="cashAccountCode" style="width: 175px;" />
									</div>
								</div>
								&nbsp;&nbsp;
								<div class="form-group"  style="margin-right: 20px">
									<label for="realCollectFee">实收金额:</label>
									<input type="text" id="realCollectFee"name="realCollectFee" class="form-control" data-placement="top" placeholder="实收金额" readonly="readonly">
								</div>
								&nbsp;&nbsp;
								<div class="form-group"  style="margin-right: 20px">
									<label for="dealAllPrice">交易金额:</label> <input type="text" id="dealAllPrice"name="dealTotalPrice" data-placement="top" class="form-control" placeholder="交易金额" readonly="readonly">
								</div>
								
								
							</div>
							<div class="form-inline" style="padding: 5px;">

								<div class="form-group"  style="margin-right: 20px">
									<label for="tradeDate">成交日期:</label>
									<div class="input-group date" id="tradeDate" style="width: 174px;">
										<input type="text" id="inputtradeDate"class="form-control">
										<span class="input-group-addon">
		 						<span class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
								&nbsp;&nbsp;
								<div class="form-group"  style="margin-right: 20px">
									<label for="setAccountDate">结算日期:</label>
									<div class="input-group date" id="setAccountDate" style="width: 174px;" >
										<input type="text" id="inputsetAccountDate" class="form-control" readonly="readonly">
										<span class="input-group-addon">
		 								<span class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
								&nbsp;&nbsp;
								<div class="form-group">
									<label for="dealFlag">交易标识:</label>
									<div class="form-group">

										<input class="form-control" id="dealFlag" name="dealType" style="width: 175px;" readonly="readonly"/>
									</div>
								</div>
								
							</div>
							<hr/>

							<div class="form-inline" style="padding: 5px;">
								<div class="form-group"  style="margin-right: 20px">
									<label for="commissionFee">佣金费用:</label>
									<input type="text" name="commissionFee" class="form-control" data-placement="top" placeholder="佣金费用" readonly="readonly">
								</div>
								&nbsp;&nbsp;
								<div class="form-group"  style="margin-right: 20px">
									<label for="transferFee">过&nbsp;&nbsp;户&nbsp;&nbsp;费:</label> <input type="text" name="transferFee" data-placement="top" readonly="readonly"class="form-control" placeholder="过户费">
								</div>
								&nbsp;&nbsp;
								<div class="form-group">
									<label for="handleFee">经&nbsp;&nbsp;手&nbsp;&nbsp;费:</label> <input type="text" name="brokerageFee" data-placement="top" class="form-control"readonly="readonly" placeholder="经手费">
								</div>
							</div>
							<div class="form-inline" style="padding: 5px;">
								<div class="form-group"  style="margin-right: 20px">
									<label for="stamps">印&nbsp;&nbsp;花&nbsp;税:</label> <input type="text" data-placement="top" name="stampDuty" class="form-control" readonly="readonly"placeholder="印花税">
								</div>
								&nbsp;&nbsp;&nbsp;
								<div class="form-group"  style="margin-right: 20px">
									<label for="connectionAndManagementFees">征&nbsp;&nbsp;管&nbsp;&nbsp;费:</label> <input type="text" name="managementFee" readonly="readonly"data-placement="top" class="form-control" placeholder="征管费">
								</div>
								&nbsp;&nbsp;
								<div class="form-group">
									<label for="securityInterest">证券利息:</label> <input type="text" name="securityFnterest" data-placement="top" readonly="readonly"class="form-control" placeholder="证券利息">
								</div>
							</div>
							<hr/>
							<div class="form-inline" style="padding: 5px;">
								<div class="form-group">
									<label for="dealDataDesc">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</label> <textarea id="dealDataDesc" name="dealDataDesc" class="form-control" placeholder="备注" style="width: 465px;height:50px;resize:none"></textarea>
								</div>
							</div>
						</div>
						<div class="modal-footer">
						<button type="button" id="btnSave" class="btn btn-primary">
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
					</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
					</button>
					
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>