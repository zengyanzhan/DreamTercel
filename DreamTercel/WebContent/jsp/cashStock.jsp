<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>现金库存</title>
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
		<!-- 引入现金库存插件js -->
		<script type="text/javascript" src="../js/cashStock.js"></script>
		
		
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
			$(function (){
				//加载表单验证
				$("#myForm").bootstrapValidator({
					//图标集
					feedbackIcons: {
						valid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
					},
					//列字段
					fields: {
						CashStockCode: {
							//验证格式
							validators: {

								notEmpty: {
									message: '请填写现金库存编号'
								},
							}
						},
						FundCode: {
							validators: {
								notEmpty: {
									message: '请填写基金名称'
								},
							}
						},
						CashBlance: {
							validators: {
								notEmpty: {
									message: '请填写库存余额'
								},
							}
						},
						
						CashAccountCode: {
							message: '账户名验证失败',
							validators: {
								notEmpty: {
									message: '请填写账户名'
								},
								/* stringLength: {
									min: 6,
									max: 18,
									message: '用户名长度必须在6到18位之间'
								}, */
								/* regexp: {
									regexp: /^[a-zA-Z0-9_]+$/,
									message: '用户名只能包含大写、小写、数字和下划线'
								} */
							}
						},
						strDate: {
							validators: {
								notEmpty: {
									message: '请填写日期'
								},
								/* stringLength: {
									min: 6,
									max: 16,
									message: '用户名长度必须在6到16位之间'
								}, */
								/* regexp: {
									regexp: /^[a-zA-Z0-9_]+$/,
									message: '用户名只能包含大写、小写、数字和下划线'
								} */
							}
						},
						PeriodFlag: {
							validators: {
								notEmpty: {
									message: '请填写期初数据 期初数据只有两个选择(1导入 2不导入)'
								},
								 stringLength: {
									min: 0,
									max: 1,
									message: '长度只能是1个单位'
								}, 
								 regexp: {
									regexp: /^[1-2]+$/,
									message: '期初数据只有两个选择(1导入 2不导入)'
								} 
							}
						},
						CashDesc: {
							validators: {
								notEmpty: {
									message: '请填写备注'
								}
							}
						}
					}
					//*****阻止表单的按钮提交
				}).on('success.form.bv', function(e) {
					//阻止默认事件提交
					e.preventDefault();
				});
				
			})

		</script>
	</head>

	<body>
		<!--整个界面-->
		<div id="mianDiv">
			<!--工具栏-->
			<div id="toolbar" class="panel-heading form-inline">
				<!--增加按钮-->
				<button id="btn_add" type="button" class="btn btn-info" disabled>
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				</button>
				是否为期初标志:<input type="checkbox" id="radioPeriodFlag" name="radioPeriodFlag"/>
				<!--修改按钮-->
				<button id="btn_edit" type="button" class="btn btn-info">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
				</button>
				<!--删除按钮-->
				<button id="btn_delete" type="button" class="btn btn-info">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				</button> &nbsp;&nbsp; 现金库存编号:
				<input class="form-control" id="code" name="code" /> 
				<label for="stDate">统计日期:</label>
					<div class="input-group date" id="stDate">
		 				<input type="text" class="form-control" name="stDate" style="width:138px;height:38px">
		 					<span class="input-group-addon">
		 						<span class="glyphicon glyphicon-calendar"></span>
							</span>
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
					<div class="modal-content" style="width:640px;height:380px">

						<!--表单验证  -->
						<form class="form-signin required-validate" action="/insertCashStock.action" method="post" id="myForm" onsubmit="return insertCashStock(this)">
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
										<label for="CashStockCode">库存编号:</label>
										<input type="text" name="CashStockCode" class="form-control" data-placement="top" placeholder="现金库存编号">
									</div>
									&nbsp;&nbsp;
					
									<div class="form-group">
										<label for="FundCode">基金名称:</label> <input type="text" name="FundCode" data-placement="top" class="form-control" placeholder="基金编号" style="width:210px;height:38px">
									</div>
								</div>
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="CashBlance">现金余额:</label> <input type="text" data-placement="top" name="CashBlance" class="form-control" placeholder="现金余额">
									</div>
									&nbsp;&nbsp;
									<div class="form-group">
										<label for="CashAccountCode">库存名称:</label>
										<input type="text" id="combogridByusrRoleId" name="CashAccountCode" data-placement="top" class="form-control" placeholder="库存名称" style="width:210px;height:38px">
									</div>
								</div>
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="strDate">统计日期:</label>
										<div class="input-group date" id="SDate">
		 									<input type="text" class="form-control" name="strDate" style="width:168px;height:38px">
		 										<span class="input-group-addon">
		 											<span class="glyphicon glyphicon-calendar"></span>
												</span>
		 							</div>									
		 						</div>
									&nbsp;&nbsp;
									<div class="form-group">
										<label for="PeriodFlag">期初数据:</label>
										<select  id="combogrid" name="PeriodFlag" data-placement="top" class="form-control" placeholder="期初数据" style="width:210px;height:38px">
										   <option value="">请选择</option>
										   <option value="1">是</option>
										   <option value="2">不是</option>
										</select>
									</div>
								</div>
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="CashDesc">库存备注:</label> <input type="text" data-placement="top" name="CashDesc" class="form-control" placeholder="库存备注">
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

		</div>
	</body>

</html>