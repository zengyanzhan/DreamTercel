<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权益数据</title>
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
		<!--
        	作者：www.981257477@qq.com
        	时间：2017-11-07
        	描述：导入日期插件包
        -->
        <script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
        <!--导入日期汉化包-->
        <script type="text/javascript" src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
       <link rel="stylesheet"  href="../css/bootstrap-datetimepicker.min.css"/>
		<!-- easyui的js和css部分 -->
		<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
		<link href="../js/easyui/icons/icon-all.css" rel="stylesheet" type="text/css" />
		<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
		<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
		<script type="text/javascript" src="../js/equityData.js"></script>
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
			<!--工具栏-->
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
				
				 &nbsp;&nbsp; 权益类型:<select class="form-control" id="eqShareOutBonusScale"  data-placement="top" style="width:208px;height:35px">
										<option ></option>
										<option value="2">送股</option>
										<option value="1">分红</option>
										</select>  除权日:
			<div class="input-group date" id="streqExDayDate">
				<input type="text" class="form-control" name="streqExDayDate"> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>

				</span>
			</div> 
				<button type="button" style="margin-left: 50px" id="btnSearch" class="btn btn-info">查询</button>
				<!-- 权益数据导入 -->
				<button id="shInput" type="button" class="btn btn-info">
						<span class="glyphicon glyphicon-import" aria-hidden="true">  </span> 权益数据导入
				</button>
			</div>
			<!--中间部分-->
			<div class="panel-body">
				<!--表格-->
				<table id="myTable"></table>
			</div>
			<!--数据导入弹窗div-->
		<div class="modal fade" id="inputDate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog " role="document">
				
				<div class="modal-content" style="width:570px;height:310px">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
						<h4 class="modal-title" id="myModalLabels">权益数据导入</h4>
					</div>
					<form action="../inputEquityDataCode.action"  method="post" enctype="multipart/form-data">
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
			<!--弹窗div-->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
				<div class="modal-dialog " role="document"   >
					<div class="modal-content" style="width:700px;height:490px">

						<!--表单验证  -->
						<form class="form-signin required-validate" action="/insertSysUser.action" method="post" id="myForm" onsubmit="return insertSysUser(this)">
						<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">增加</h4>
							</div>
							<div class="modal-body">
								<!-- 表单 -->

								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="eqDataCode">权&nbsp;&nbsp;益&nbsp;&nbsp;Id&nbsp;&nbsp;&nbsp;&nbsp;</label>
										<input type="text" name="eqDataCode" readonly class="form-control" data-placement="top" placeholder="权益id" style="width:200px;height:35px">
									</div>
									&nbsp;&nbsp;&nbsp;
									<div class="form-group" >
										<label for="cashAccountCode">账&nbsp;&nbsp;户&nbsp;&nbsp;名称&nbsp;</label> 
										<input type="text" id="combogridByusrRoleId" name="cashAccountCode" data-placement="top" class="form-control" placeholder="账号的Code" style="width:215px;height:35px">
									</div>
								</div>
								<div class="form-inline" style="padding:10px;">
								<div class="form-group">
									<label for="eqRegisterDay">权益登记日   &nbsp;</label>
									 <div class="input-group date" id="dateTest">
										<input type="text" id="eqRegisterDay" name="eqRegisterDay" data-placement="top" class="form-control" placeholder="权益登记日" style="width:165px;height:35px">
										<span class="input-group-addon">
		 									<span class="glyphicon glyphicon-calendar"></span>
		 								</span></div>
									</div>
									&nbsp;&nbsp;
										<div class="form-group">
										<label for="eqExDay">权益除权日&nbsp;</label>
										<div class="input-group date" id="dateTests">
										<input type="text" name="eqExDay" data-placement="top" class="form-control" placeholder="权益除权日" style="width:175px;height:35px">
										<span class="input-group-addon">
		 									<span class="glyphicon glyphicon-calendar"></span>
		 								</span>
									</div>
									</div>
								</div>
								<div class="form-inline" style="padding: 10px;">
								<div class="form-group">
										<label for="eqShareOutBonusScale">权益类型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
										<select class="form-control" name="eqShareOutBonusScale"  data-placement="top" style="width:208px;height:35px">
										<option ></option>
										<option value="2">送股</option>
										<option value="1">分红</option>
										</select>
									</div>
									&nbsp;&nbsp;
									<div class="form-group">
										<label for="eqToAccountDate">到账日期&nbsp;&nbsp;&nbsp;&nbsp;</label> 
										<div class="input-group date" id="dateTestsa">
										<input type="text" name="eqToAccountDate" data-placement="top" class="form-control" placeholder="到账日期" style="width:175px;height:35px">
											<span class="input-group-addon">
		 									<span class="glyphicon glyphicon-calendar"></span>
		 									</span>
									</div>
									</div>		
								</div>
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="securityCode">证&nbsp;&nbsp;券&nbsp;&nbsp;名称&nbsp;&nbsp;</label> 
										<input type="text" data-placement="top"  id="combogridByusrRoleIds" name="securityCode" class="form-control" placeholder="证券Id" style="width:203px;height:35px">
									</div>
									&nbsp;&nbsp;
									<div class="form-group">
										<label for="eqSendStockScale">比&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;例&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> 
										<input type="text" name="eqSendStockScale" data-placement="top" class="form-control" placeholder="送股比例" style="width:215px;height:35px">
									</div>
								</div>
								
								<div class="form-inline" style="padding: 10px;">
									<div class="form-group">
										<label for="eqDesc">处&nbsp;&nbsp;理&nbsp;&nbsp;状态&nbsp;&nbsp;</label> 
										<input type="text" name="eqDesc" readonly class="form-control" data-placement="top" placeholder="处理状态" style="width:200px;height:35px">
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