//基金投资板块表js代码

$(function(){
	
	
	
	//给日期默认今天
	var today=new Date();
	var nowdate=(today.getFullYear())+"-"+(today.getMonth()+1)+"-"+today.getDate();
	//对日期格式进行处理
	var date=new Date(nowdate);
	var mon=date.getMonth()+1;
	var day = date.getDate();
	var mydate = date.getFullYear() + "-" + (mon < 10 ? "0" + mon : mon) + "-" + (day < 10 ? "0" + day : day);
	$("#statisticDateWhere").val(mydate);
	
	
	//条件查询的日期时间插件	
	$('#dateTest').datetimepicker({
		 language:'zh-CN',//显示中文
		 format:'yyyy-mm-dd',//格式化日期
		 minView:'month',//设置只显示到月份
		// initialDate:new Date(),//初始化当前日期
		 autoclose:true,//自动关闭\
		 todayBtn:true//显示今天按钮
	});
	
	//加载表格
	$('#myTable').bootstrapTable({
		url: '../selectFundInvestBlocks.action',
		method: 'get', //请求方式（*）
		contentType:'application/json;charset=UTF-8',
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
				statisticDateWhere: $("#statisticDateWhere").val(), //查询的参数   写自己的控制类对应的名字
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
			field: 'stockBlockName',
			title: '证券板块名称',
			//启用该字段的排序
			sortable: true
		}, {
			field: 'assecurityQuantity',
			title: '证券库存数量'
		}, {
			field: 'marketValue',
			title: '证券市值'
		}, {
			field: 'marketValuePercentage',
			title: '市值占净值百分比',
			formatter: function(value,row,index){
				if(value==''){
					return '';
				}else{
			
					return  (value.toFixed(2)+"%");
				}
			}
		}
		]
	});
	var  myChart= echarts.init(document.getElementById('main'));	
	//查询按钮的事件
	$("#btnSearch").click(function() {
		$("#myTable").bootstrapTable('refresh');
	
		
		$.post('../fundInvestBlocksImage.action?statisticDateWhere='+$("#statisticDateWhere").val(),null,function(msgs){		
			var msg = jQuery.parseJSON(msgs);
			        var array = [];	       
			        var  str=[];
			 		for (var i = 0; i < msg.length; i++) {
			 			  str[i]=msg[i].stockBlockName;
			 			var name=msg[i].stockBlockName;
			 			var map ={};
						map.name = name;
						map.value = msg[i].assecurityQuantity;
						array[i]=map;				
					}
			 		//alert(str)
			 		  myChart.hideLoading();
				 	   // 填入数据
				 	   myChart.setOption({
				 	
				 	       legend: {
				 	           data:str,
				 	           x : '1050',
				 	        	  y:'center',
				 	        	 orient:'vertical'
				 	       },
				 	       series:[{ 
				 	           // 根据名字对应到相应的系列
				 	           name: '数据',
				 	           type: 'pie', 	           
				 	           data:  array,
				 	          itemStyle: {
				 	                normal: {
				 	                    color: function(params) {
				 	                        // build a color map as your need.
				 	                        var colorList = [
				 	                          '#0066ff','#ff99ff','#99ff33','#ccccff','#9900ff'
				 	                        ];
				 	                        return colorList[params.dataIndex]
				 	                    }
				 	                }
				 	          }
				 	       }],
				 	   });				 	
		});
		//$("#businessDateWhere").val('');
	});
	
	$("#btn-image").click(function() {
		/*$("#table").hide();
		$("#main").show();*/
		changeDiv($(window), "#btn-image", "#ssss");
	
		option = {
			    title : {
			        text: '基金投资板块表',
			        subtext: '图表显示',
			        x:'center'
			    },
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    legend: {
			        orient : 'vertical',
			        x : 'left',
			        y:'bottom',
			        data:[]
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            mark : true,
			            dataView : {readOnly: false},
			            restore : true,
			            saveAsImage : true
			        }
			    },
			    calculable : true,
			    series : [
			        {
			            name:'访问来源',
			            type:'pie',
			            radius : '55%',
			            center: ['50%', 225],
			            data:[]
			        }
			    ]
			};
		
	});
		
		myChart.showLoading();// 加载动画	
	//	alert($("#logmin").val());
			setTimeout(function(){
				
			$.post('../fundInvestBlocksImage.action?statisticDateWhere='+$("#statisticDateWhere").val(),null,function(msgs){		
				var msg = jQuery.parseJSON(msgs);
				        var array = [];	       
				        var  str=[];
				 		for (var i = 0; i < msg.length; i++) {
				 			  str[i]=msg[i].stockBlockName;
				 			var name=msg[i].stockBlockName;
				 			var map ={};
							map.name = name;
							map.value = msg[i].assecurityQuantity;
							array[i]=map;				
						}
				 		//alert(str)
				 		  myChart.hideLoading();
					 	   // 填入数据
					 	   myChart.setOption({
					 	
					 	       legend: {
					 	           data:str,
					 	           x : '1050',
					 	        	  y:'center',
					 	        	 orient:'vertical'
					 	       },
					 	       series:[{ 
					 	           // 根据名字对应到相应的系列
					 	           name: '数据',
					 	           type: 'pie', 	           
					 	           data:  array,
					 	          itemStyle: {
					 	                normal: {
					 	                    color: function(params) {
					 	                        // build a color map as your need.
					 	                        var colorList = [
					 	                          '#0066ff','#ff99ff','#99ff33','#ccccff','#9900ff','',
					 	                          '','','',''
					 	                        ];
					 	                        return colorList[params.dataIndex]
					 	                    }
					 	                }
					 	          }
					 	       }],
					 	   });				 	
			});					
		},1000)// 异步加载数据
	
});