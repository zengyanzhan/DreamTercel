<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/bootstrap-table.css" />
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="../css/bootstrap-theme.min.css" />

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="../js/jquery-3.1.1.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="../js/bootstrap.min.js"></script>
<!--表格插件的JavaScript文件  -->
<script type="text/javascript" src="../js/bootstrap-table.js"></script>
<!-- 表格插件的JavaScript汉化包 -->
<script type="text/javascript" src="../js/bootstrap-table-zh-CN.js"></script>
<!--引入弹窗插件的样式文件-->
<link rel="stylesheet" href="../js/alert/alert.css" />
<!--引入弹窗插件的js文件-->
<script type="text/javascript" src='../js/alert/alert.js'></script>

<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen" />
<link href="../css/bootstrap-theme.min.css" rel="stylesheet"
	media="screen" />
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.min.js"></script>
<!--导入日期汉化包-->
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />
<script type="text/javascript" src="../js/AssetValuation.js"></script>
<script type="text/javascript" src="../js/utils.js"></script>


<title>资产估值</title>
</head>
<body>
	<div id="toolbar" class="panel-heading form-inline">
		<label style="font-size: 20px">日期 ：</label>
		<div class="input-group date" id="appraisementDateDiv">
			<input type="text" class="form-control" id="appraisementDate" /> <span
				class="input-group-addon"> <span
				class="glyphicon glyphicon-calendar"></span>
			</span>
		</div>
		<button id="appraisement" type="button" style="margin-left: 50px"
			class="btn btn-info" onclick="appraisement();">估值</button>
	</div>
	<!--中间部分-->
	<div class="panel-body">
		<fieldset
			style="padding: .35em .625em .75em; margin: 0 2px; border: 1px solid silver">
			<legend style="padding: .5em; border: 0; width: auto">估值项</legend>
			<table id="btnGroups" class="table table-bordered table-striped"
				width="1000px" border="0" cellspacing="0" cellpadding="0"
				style="margin: 0 auto">
				<thead>
					<tr>
						<th data-options="field:'check'"></th>
						<th data-options="field:'businessType',width:200,align:'center'">业务类型</th>
						<th data-options="field:'status',width:200,align:'center'">状态</th>
						<th data-options="field:'guZhi',width:330,align:'center'">估值</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox" value="1" id="zengZhiId"
							onclick="searchOnchangeBox()" /></td>
						<td>证券估值增值</td>
						<td><div id="zhengquanstatus">未估值</div></td>
						<td>
							<div id="zhi"></div>
						</td>
					</tr>
					<tr>
						<td><input type="checkbox" value="2" id="qingSuanKuanId"
							onclick="searchOnchangeBox()" /></td>
						<td>清算款</td>
						<td>
							<div id="qiangsuanstatus">未清算</div>
						</td>
						<td>
							<div id="qingSuan"></div>
						</td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</div>
	<div id="toolbars">
		<button type="button" id="PriceDate" class="btn btn-info">行情数据</button>
		&nbsp;
		<button type="button" id="Security" class="btn btn-info">证券信息设置</button>
		&nbsp;
		<button type="button" id="TradeData" class="btn btn-info">交易数据</button>
		&nbsp;
		<button type="button" id="Stock" class="btn btn-info">库存统计</button>
		&nbsp;
		<button type="button" id="TaTradeData" class="btn btn-info">Ta交易数据</button>
		&nbsp;
		<button type="button" id="SecurityApar" class="btn btn-info">证券应收应付</button>
		&nbsp;
		<button type="button" id="CashArap" class="btn btn-info">现金应收应付</button>
	</div>

</body>
</html>