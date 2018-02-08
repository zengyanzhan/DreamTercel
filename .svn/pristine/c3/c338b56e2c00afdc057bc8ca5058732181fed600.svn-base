<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
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
<!--导入日期插件包-->
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.css" />
<script type="text/javascript"
	src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />
<script type="text/javascript">
	
</script>
<script src='../js/utils.js'></script>
<!-- easyui的js和css部分 -->
<link href="../js/easyui/themes/default/easyui.css" rel="stylesheet"
	type="text/css" />
<link href="../js/easyui/icons/icon-all.css" rel="stylesheet"
	type="text/css" />
<script src="../js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="../js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/echarts.min.js"></script>
<title>股票价格波动表</title>
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
	var flag = false;//判断标志 是否调用生成图表的方法
	//加载事件 
	$(function() {
		//加载表格
		$('#myTable').bootstrapTable({
			url : '../stockFluctuate.action',
			method : 'get', //请求方式（*）
			contentType : 'application/json',
			toolbar : '#toolbar', //工具按钮用哪个容器
			striped : true, //是否显示行间隔色
			//cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, //是否显示分页（*）
			sortable : true, //是否启用排序
			sortOrder : "asc", //排序方式
			queryParams : function(params) {
				var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					rows : params.limit, //页面大小
					page : params.offset / params.limit + 1, //页码
					endEnteringDate : $("#endEnteringDate").val(), //查询的参数   写自己的控制类对应的名字
					startEnteringDate : $("#startEnteringDate").val(), //查询的参数
					sortName : this.sortName,
					sortOrder : this.sortOrder,
				};
				return temp;
			}, //传递参数（*）
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, //初始化加载第一页，默认第一页
			pageSize : 5, //每页的记录行数（*）
			pageList : [ 5, 10, 15, 20 ], //可供选择的每页的行数（*）
			showColumns : true, //是否显示所有的列
			showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 2, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行
			height : 600, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			//uniqueId : "usrId", //每一行的唯一标识，一般为主键列
			showToggle : false, //是否显示详细视图和列表视图的切换按钮
			cardView : false, //是否显示详细视图
			detailView : false, //是否显示父子表
			//列字段
			columns : [ {
				//复选框
				checkbox : true
			}, {
				field : 'priceDataCode',
				title : '行情数据编号',
				//启用该字段的排序
				sortable : true
			}, {
				field : 'securityCode',
				title : '证券ID'
			}, {
				field : 'securityName',
				title : '证券名称'
			}, {
				field : 'strEnteringDate',
				title : '录用日期'
			}, {
				field : 'openingPrice',
				title : '开盘价'
			}, {
				field : 'closingPrice',
				title : '收盘价',
			}, {
				field : 'pricelimit',
				title : '涨跌幅',
			} ]
		});
		//日期时间插件	
		$('#startDate').datetimepicker({
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//格式化日期
			minView : 'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期
			autoclose : true,//自动关闭
			todayBtn : true
		//显示今天按钮
		});
		$('#endDate').datetimepicker({
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd',//格式化日期
			minView : 'month',//设置只显示到月份
			// initialDate:new Date(),//初始化当前日期
			autoclose : true,//自动关闭
			todayBtn : true
		//显示今天按钮
		});
	});   
</script>
</head>

<body>
	<!--整个界面-->
	<div id="mianDiv">
		<div id="" class="panel-heading form-inline">
			<label>开始时间：</label>
			<div class="input-group date" id="startDate">
				<input type="text" class="form-control" id="startEnteringDate" /> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
			<label>结束时间：</label>
			<div class="input-group date" id="endDate">
				<input type="text" class="form-control" id="endEnteringDate" /> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
			<button type="button" style="margin-left: 50px" id="btnSearch"
				class="btn btn-info">查询</button>
			<button type="button" style="margin-left: 50px" id="btnImage"
				class="btn btn-info">生成图表</button>
		</div>
		<div class="changeDiv" id="ssss">
			<div class="page div1" id="biaoGe">
				<table id="myTable"></table>
			</div>
			<div id="main" class="page div2" style="width: 800px; height: 400px"></div>
		</div>
	</div>

</body>
<script type="text/javascript">
    $(function() {
		$("#btnImage").click(function() {
			//alert(flag);
			changeDiv($(window), "#btnImage", "#ssss");
			img();//调用生成图表方法
			if (flag == false) {
				flag = true;
			} else {
				flag = false;
			}
		});
		//查询
		$("#btnSearch").click(function() {
			//alert(flag);
			if (flag == false) {
				var firstDate = $("#startEnteringDate").val();
				var secondDate = $("#endEnteringDate").val();
				if (firstDate != "" && secondDate != "") {
					$("#myTable").bootstrapTable('refresh');
				} else {
					myAlert("请输入统计日期");
				}
			} else {
				img();//调用生成图表
			}

		})
	});
    function img() {
        /*基于准备好的dom，初始化echarts实例*/
        var myChart = echarts.init(document.getElementById('main'));
        var option = {
                title: {    //标题
                    text: '股票价格波动表',
                    left: 0
                },
                tooltip: {  //提示框
                    trigger: 'axis',    //触发类型：坐标轴触发
                    axisPointer: {  //坐标轴指示器配置项
                        type: 'cross'   //指示器类型，十字准星
                    },
                },
             
                legend: {   //图例控件，点击图例控制哪些系列不现实
                    data: []
                },
                grid: {     //直角坐标系
                    show:true,
                    left: '10%',    //grid组件离容器左侧的距离
                    right: '10%',
                    bottom: '15%',
                    //backgroundColor:'#ccc'
                },
                xAxis: {
                    type: 'category',   //坐标轴类型，类目轴
                    data: [],
                    //scale: true,  //只在数字轴中有效
                    boundaryGap : false,    //刻度作为分割线，标签和数据点会在两个刻度上
                    axisLine: {onZero: false},
                    splitLine: {show: false},   //是否显示坐标轴轴线
                    //splitNumber: 20,    //坐标轴的分割段数，预估值，在类目轴中无效
                    min: 'dataMin', //特殊值，数轴上的最小值作为最小刻度
                    max: 'dataMax'  //特殊值，数轴上的最大值作为最大刻度
                },
                yAxis: {
                    scale: true,    //坐标刻度不强制包含零刻度
                    splitArea: {
                        show: true  //显示分割区域
                    }
                },
                dataZoom: [     //用于区域缩放
                    {
                        filterMode:'filter',    //当前数据窗口外的数据被过滤掉来达到数据窗口缩放的效果  默认值filter
                        type: 'inside', //内置型数据区域缩放组件
                        start: 50,      //数据窗口范围的起始百分比
                        end: 100        //数据窗口范围的结束百分比
                    },
                    {
                        show: true,
                        type: 'slider', //滑动条型数据区域缩放组件
                        y: '90%',
                        start: 50,
                        end: 100
                    }
                ],
                series: []
            };
      //定义行情数组数据
		var detailPrice = [];//开盘价 收盘价`
		var totalPrice = [];//总的数据
		var strEnteringDate = [];//行情录入时间
		var three=[];
		var securityName=[];//股票的名称
		$.ajax({ //使用JQuery内置的Ajax方法
			type : "post", //post请求方式
			async : true, //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
			url : "../stockFluctuateImage.action?startEnteringDate="+ $("#startEnteringDate").val()+'&endEnteringDate='+$("#endEnteringDate").val(), //请求发送到ShowInfoIndexServlet处
			//data : $("#endEnteringDate").val()+','+$("#startEnteringDate").val(),        //请求内包含一个key为name，value为A0001的参数；服务器接收到客户端请求时通过request.getParameter方法获取该参数值
			dataType : "json", //返回数据形式为json
			success : function(result) {
				//请求成功时执行该函数内容，result即为服务器返回的json对象
				if (result != null && result.length > 0) {
					for (var i = 0; i < result.length; i++) {
							securityName.push(result[i].securityName);
							detailPrice.push(result[i].openingPrice);
							detailPrice.push(result[i].closingPrice);
							totalPrice.push("["+detailPrice+"]");
							strEnteringDate.push(result[i].strEnteringDate);
							detailPrice=[];
						//挨个取出温度、湿度、压强等值并填入前面声明的温度、湿度、压强等数组
					}
					
					$.each(unique(securityName),function(i,v){
							var test="{ name: '"+v+"', type: 'candlestick', data:["+totalPrice+"],markPoint: {label: {normal:{show:true,formatter:function(param){return param != null ? Math.round(param.value) : '';} } },data:[{name: 'XX标点',coord: ['2013/5/31', 2300], value: 2300,  itemStyle: { normal: {color: 'rgb(41,60,85)'}} },{ name: 'highest value', type: 'max', valueDim: 'highest' },{ name: 'lowest value',  type: 'min', valueDim: 'lowest' },{ name: 'average value on close', type: 'average', valueDim: 'close' }] },markLine: { symbol: ['none', 'none'], data: [ [ { name: 'from lowest to highest', type: 'min',  valueDim: 'lowest', symbol: 'circle', symbolSize: 10,label: { normal: {show: false},  emphasis: {show: false} } }, { type: 'max', valueDim: 'highest',  symbol: 'circle', symbolSize: 10,  label: { normal: {show: false}, emphasis: {show: false} } }],{ name: 'min line on close',  type: 'min',  valueDim: 'close'},{ name: 'max line on close', type: 'max', valueDim: 'close'} ] } }";
							var str=eval("("+test+")");
				                    three.push(str);//jQuery.parseJSON();   	
					})
					
					myChart.hideLoading(); //隐藏加载动画
					myChart.setOption({ //载入数据
						legend:{data:securityName},
						xAxis : [ {
							data : unique(strEnteringDate)
						} ],
						series :  three
					});
				}
			}
		})
     
        // 使用刚指定的配置项和数据显示图表
        myChart.setOption(option);
    }
    //数组去重复项
    function unique(arr) {
        var result = [], hash = {};
        for (var i = 0, elem; (elem = arr[i]) != null; i++) {
            if (!hash[elem]) {
                result.push(elem);
                hash[elem] = true;
            }
        }
        return result;
        }
    </script>
</html>