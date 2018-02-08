<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>存款业务</title>
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
		<link rel="stylesheet" href=../css/bootstrapValidator.css />
		<!--引入表格的汉化文件-->
		<script src="../js/bootstrap-table-zh-CN.js"></script>

		<!--引入弹窗插件的样式文件-->
		<link rel="stylesheet" href="../js/alert/alert.css">
		<!--引入弹窗插件的js文件-->
		<script src='../js/alert/alert.js'></script>
		<script type="text/javascript" src="../js/utils.js"></script>
		<!-- 下拉列表 -->
		 <script type="text/javascript" src="../js/select/bootstrap-select.js"></script>
		<script type="text/javascript" src="../js/select/bootstrap-select.min.css"></script>
		
		

		<!-- easyui的js和css部分 -->
		<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
		<link href="../js/easyui/icons/icon-all.css" rel="stylesheet" type="text/css" />
		<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
		<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
		
		
		<!--描述：导入日期插件包-->
        <script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
        <!--导入日期汉化包-->
        <script type="text/javascript" src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
       <link rel="stylesheet"  href="../css/bootstrap-datetimepicker.min.css"/>
		<!-- 引入存款业务插件js -->
		<script type="text/javascript" src="../js/bankSaving.js"></script>
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
			
			div .alert-content,
			div .alert-title,
			div .alert-btn-box,
			div .alert-btn-p {
				/* background-color:blue; */
				font-weight: bold;
			}
		</style>
		<script type="text/javascript">
			
		</script>
	</head>

	<body>
		<!--整个界面-->
		<div id="mianDiv">
			<!--工具栏-->
			<div id="toolbar" class="panel-heading form-inline">
				<!--增加按钮-->
				<button id="btn_add" type="button" class="btn btn-info">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				</button>
				<!-- 修改按钮
				<button id="btn_edit" type="button" class="btn btn-info">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
				</button> -->
				<!--删除按钮-->
				<button id="btn_delete" type="button" class="btn btn-info">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				</button> 
				<div class="form-group">
				<label for="StartDate">业务日期:</label>
					<div class="input-group date" id="StartDate">
		 				<input type="text" class="form-control" name="StartDate" style="width:138px;height:38px">
		 					<span class="input-group-addon">
		 						<span class="glyphicon glyphicon-calendar"></span>
							</span>
		 		   </div>
		 		 </div>
		 		 <label for="BsType">业务类型:</label>
						<select   name="BsType" data-placement="top" class="form-control"  style="width:210px;height:38px">
							<option value="">请选择</option>
							<option value="1">1(3天)</option>
							<option value="2">2(7天)</option>
						</select>
		 		 <div class="form-group">
				<label for="EndDate">到期日期:</label>
					<div class="input-group date" id="EndDate">
		 				<input type="text" class="form-control" name="EndDate" style="width:138px;height:38px">
		 					<span class="input-group-addon">
		 						<span class="glyphicon glyphicon-calendar"></span>
							</span>
		 		   </div>
		 		 </div>
				
				
				<button type="button" style="margin-left: 50px" id="btnSearch" class="btn btn-info">查询</button>
			</div>
			<!--中间部分-->
			<div class="panel-body">
				<!--表格-->
				<table id="myTable"></table>
			</div>
			<!--弹窗div-->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog " role="document">
						<div class="modal-content" style="width:640px;height:700px">

							<!--表单验证-->
							<form class="form-signin required-validate" action="/insertSysUser.action" method="post" id="myForm" onsubmit="return insertSysUser(this)">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
									<h4 class="modal-title" id="myModalLabel">新增</h4>
						
								</div>
								<div class="modal-body">
									<!-- 表单 -->

									<div class="form-inline" style="padding: 10px;">
										<div class="form-group">
											<label for="SavingCode">业务编号:</label>
											<input type="text" name="SavingCode" id="SavingCode" class="form-control" data-placement="top" placeholder="业务编号" >
										</div>
										&nbsp;&nbsp;
										<div class="form-group">
											<label for="FundCode">基金名称:</label> 
											<input type="text" name="FundCode" id="FundCode" data-placement="top" class="form-control" placeholder="基金名称" style="width:210px;height:38px">
										</div>
									</div>
									<div class="form-inline" style="padding: 10px;">
										<div class="form-group">
											<label for="OutCash">流出金额:</label> 
											<input type="text" data-placement="top" name="OutCash" id="OutCash"class="form-control" placeholder="流出金额" style="width:210px;height:38px">
										</div>
										&nbsp;&nbsp;
										<div class="form-group">
											<label for="OutCashAccountCode">流向账户:</label> 
											<input type="text" data-placement="top" name="OutCashAccountCode" id="OutCashAccountCode"class="form-control" placeholder="流出金额">
										</div>
									</div>
									
									<hr>
								
									<div class="form-inline" style="padding: 10px;">
										  <div class="form-group">
											<label for="InCashAccountCode">流入金额:</label> 
											<input type="text" data-placement="top" name="InCashAccountCode" id="InCashAccountCode" class="form-control" placeholder="流入金额" style="width:210px;height:38px">
										  </div>			
										&nbsp;&nbsp;
										<div class="form-group">
											<label for="InCash">流入账户:</label> 
											<input type="text" data-placement="top" name="InCash" id="InCash"class="form-control" placeholder="流出金额" style="width:210px;height:38px">
										</div>
									</div>
									<div class="form-inline" style="padding: 10px;">
										<div class="form-group">
											<label for="SavingInterestBFB">每日利率:</label>
											<input type="text"  name="SavingInterestBFB" id="SavingInterestBFB" data-placement="top" class="form-control" placeholder="每日利率" style="width:210px;height:38px">
										</div> 
										&nbsp;&nbsp;
										<div class="form-group">
											<label for="SavingInterest">所含利息:</label>
											<input type="text"  name="SavingInterest" id="SavingInterest" data-placement="top" class="form-control" placeholder="所含利息" style="width:210px;height:38px">
										</div> 
									</div>
									<div class="form-inline" style="padding: 10px;">
									   <div class="form-group">
										   <label for="strDate">业务时间:</label>
										     <div class="input-group date" id="strDate">
		 									   <input type="text" class="form-control" name="strDate" id="strDate" style="width:168px;height:38px">
		 										  <span class="input-group-addon">
		 											 <span class="glyphicon glyphicon-calendar"></span>
												  </span>
		 							         </div>					
									   </div>
									&nbsp;&nbsp;
										<div class="form-group">
											<label for="strDate">到期时间:</label>
											<div class="input-group date" id="SavingEndDate">
												<input type="text" class="form-control" name="strDate" id="strDate" style="width:168px;height:38px">
													<span class="input-group-addon">
														<span class="glyphicon glyphicon-calendar"></span>
													</span>
										   </div>					
										</div>
									</div>
									
									<div class="form-inline" style="padding: 10px;">
										
										<div class="form-group">
											<label for="Flag">办理标志:</label>
											<select  id="combogrid" name="Flag" id="Flag"  data-placement="top" class="form-control" placeholder="期初数据" style="width:210px;height:38px">
											   <option value="">请选择</option>
											   <option value="1">1(到期办理)</option>
											   <option value="2">2(到期未办理)</option>
											</select>
										</div>
										&nbsp;&nbsp;
										<div class="form-group">
											<label for="BusinessType">业务类型:</label>
											<select   name="BusinessType" id="BusinessType" data-placement="top" class="form-control" placeholder="业务类型" style="width:210px;height:38px">
											   <option value="">请选择</option>
											   <option value="1">1(3天)</option>
											   <option value="2">2(7天)</option>
											</select>
										</div>
									</div>
									<hr>
									<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
											<label for="Desc">业务备注:</label> 
											<input type="text" data-placement="top" name="Desc" id="Desc" class="form-control" placeholder="备注" style="width:500px;height:60px">
										</div>
									 </div>
								</div>
								<div class="modal-footer">

							<button type="button" id="btnSave" class="btn btn-primary">
								<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
							</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
							</button>
						</div>
							</form>
						</div>
					</div>
			    
			</div>

		</div>
	</body>

</html>