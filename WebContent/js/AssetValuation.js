$(function(){
	//设置日期时间控件
	//日期时间插件	
	$('#appraisementDateDiv').datetimepicker({
		 language:'zh-CN',//显示中文
		 format:'yyyy-mm-dd',//格式化日期
		 minView:'month',//设置只显示到月份
		 autoclose:true,//自动关闭\
		 todayBtn:true//显示今天按钮
	});
	$('#btnGroups').bootstrapTable({
		url:'',
		toolbar :'#toolbars',
	});
	//行情数据跳转
	$("#PriceDate").click (function (){
		window.location.href="priceDate.jsp";
	});
	//证券信息设置跳转
	$("#Security").click (function (){
		window.location.href="security.jsp";
	});
	//交易数据跳转
	$("#TradeData").click (function (){
		window.location.href="tradeData.jsp";
	});
	//库存统计跳转
	$("#Stock").click (function (){
		window.location.href="stock.jsp";
	});
	//现金应收应付跳转
	$("#CashArap").click (function (){
		window.location.href="cashArap.jsp";
	});
	//TA交易数据跳转
	$("#TaTradeData").click (function (){
		window.location.href="taTradeData.jsp";
	});
	//证券应收应付跳转
	$("#SecurityApar").click (function (){
		window.location.href="securityApar.jsp";
	});
	$("#appraisement").click (function (){
		var guzhidate = $('#appraisementDate').val();
		if(guzhidate==null||guzhidate==''){
			document.getElementById("zengZhiId").checked = false;
			document.getElementById("qingSuanKuanId").checked = false;
			myAlert("请输入估值日期");
		}else{
			$.ajax({
				url:"../enddayhoildaySelect.action?appraisementDate="+guzhidate,
				success:function(msg){
					if(msg=='flase'){
						/*myAlert("你选择的日期是节假日");
						return;*/
						window.dialog3 = jqueryAlert({
							'title': '温馨提示',
							'content': '今天是节假日，您确定要统计数据吗？',
							'modal': true, //是否显示模型窗口
							'className': 'alertDialog',
							'buttons': { //按钮
								'确定': function() {
									window.dialog3.destroy();
									var result = "";
									var ss = document.getElementsByTagName("input");
									for (var i = 0; i < ss.length; i++) {
										if (ss[i].checked) {
											result = result + ss[i].value + ",";
										}
									}
									if(result==""){
										myAlert("请选择估值项");
									}else{
										$.ajax({
											url:"../assetValuationSelect.action?appraisementType="+result+"&appraisementDate="+guzhidate,
											success:function(msg){
											var da = msg.split(",");
										
											$("#qingSuan").html(da[0]);
											if(da[1]<0){
												$("#zhi").css("color","green");
											}else{
												$("#zhi").css("color","red");
											}
											$("#zhi").html(da[1]);
											$("#qiangsuanstatus").text("已清算");
											$("#zhengquanstatus").html("已估值");
											
											} 
										});
									}
								},
								'取消': function() {
									//销毁弹窗
									window.dialog3.destroy();
								}
							}
						});
					}
				} 
			});
			
		}
	});
});