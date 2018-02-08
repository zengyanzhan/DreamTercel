<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="../css/bootstrap.css" />
   <script type="text/javascript" src="../js/echarts.min.js"></script>
   <script src=" ../js/jquery-3.1.1.min.js"></script>
   <script type="text/javascript" src="../js/utils.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src=" ../js/bootstrap.min.js"></script>
<style type="text/css">
		.#carousel-example-generic{background-color:red }
</style>
</head>
<body   style="position:absolute;left:0;top:0;width:100%;height:100%;">
	<div class="container myCarousel" id="lunbo" style="position:absolute;left:0;top:0;width:100%;height:100%;" >  
    <div id="carousel-example-generic" class="carousel slide" style="position:absolute;left:0;top:0;width:100%;height:100%">  
        <ol class="carousel-indicators" >  
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>  
            <li data-target="#carousel-example-generic" data-slide-to="1" ></li>  
            <li data-target="#carousel-example-generic" data-slide-to="2" ></li>  
            <li data-target="#carousel-example-generic" data-slide-to="3" ></li>
        </ol>  
        <div class="carousel-inner lunbodiv" style="position:absolute;left:0;top:0;width:100%;height:100%">  
            <div class="item active lunbodiv" id="div1" >  
                
            </div>  
            <div class="item lunbodiv" id="div2" >  
                
            </div>  
            <div class="item lunbodiv" id="div3" >  
               <!--  <img src="image/page1_2.png"/>  
                <div class="carousel-caption">  
                    <h3>宅男女神3</h3>  
                    <p>人气偶像票选7836张</p>  
                </div>   -->
            </div>  
        </div>  
        <a class="left carousel-control" href="#carousel-example-generic"  data-slide="prev">  
            <span class="glyphicon glyphicon-chevron-left" ></span>  
        </a>  
        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">  
            <span class="glyphicon glyphicon-chevron-right"></span>  
        </a>  
    </div>  
</div>
</body>
<script type="text/javascript">
	$(function(){
		loadDiv();
		
		 $(".carousel").carousel({  
		        interval:15000  
		    }) 
		    
		   $("#lunbo").resize(function(){
			   
			   loadDiv();
			   myChart.resize();
	 			myChart2.resize();
	 			myChart3.resize();
		   });
	});
	
</script>

 <script type="text/javascript">
 
 function  loadDiv(){
	
	 var allDiv =$(".lunbodiv");
	 $.each(allDiv,function(i,oneDiv){
			$(oneDiv).css("margin","0px");
			$(oneDiv).css("padding","0px");
			$(oneDiv).css("width",parseInt($("#lunbo").css("width"))-15+"px");
			$(oneDiv).css("height",parseInt($("#lunbo").css("height"))-15+"px");
			$(oneDiv).css("padding","0px");
	 });
 }
	 var myChart;
	 var myChart2;
	 var myChart3;
	 	$(function(){
	 		
	 		loadEcharts();
	 		
	 		window.onresize=function(){
	 			myChart.resize();
	 			myChart2.resize();
	 			myChart3.resize();
	 			
		 	}
	 	});
	 		function loadEcharts(){
	 			
	 			var date = new Date();
	 		    var seperator1 = "-";
	 		    var month = date.getMonth() + 1;
	 		    var strDate = date.getDate();
	 		    if (month >= 1 && month <= 9) {
	 		        month = "0" + month;
	 		    }
	 		    if (strDate >= 0 && strDate <= 9) {
	 		        strDate = "0" + strDate;
	 		    }
	 		    var endDate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
	 		     date = new Date(date.valueOf()-15*24*60*60*1000);
	 		    month = date.getMonth() + 1;
	 		     strDate = date.getDate();
	 		    if (month >= 1 && month <= 9) {
	 		        month = "0" + month;
	 		    }
	 		    if (strDate >= 0 && strDate <= 9) {
	 		        strDate = "0" + strDate;
	 		    }
	 		    var openDate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
	 		     
	 		     
	 			 myChart  = echarts.init(document.getElementById('div1'));
	 			 
	 			 
	 			 var dateOption1=[];
	 			 var dateOption2=[];
	 			$.ajax({
	 				type : "post",
	 				url : '../AndroidselectNetValueChaAlls.action?openDate='+openDate+'&endDate='+endDate,
	 				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	 				 async:false,
	 				//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
	 				success : function(msgs) {
	 					
	 					for (var i = msgs.length-1; i >=0; i--) {
	 						dateOption1.push(msgs[i].date);
	 						dateOption2.push(msgs[i].unitNetMoney);
						}
	 				}

	 			});
	 			
	 			
	 			
	 			 
	 			option = {
	 				    title: {
	 				        text: '最近半个月的资产净值变化图',
	 				        subtext: ''
	 				    },
	 				    tooltip: {
	 				        trigger: 'axis'
	 				    },
	 				    legend: {
	 				        data:['资产净值']
	 				    },
	 				    toolbox: {
	 				        show: true,
	 				        feature: {
	 				            dataZoom: {
	 				                yAxisIndex: 'none'
	 				            },
	 				            dataView: {readOnly: false},
	 				            magicType: {type: ['line', 'bar']},
	 				            restore: {},
	 				            saveAsImage: {}
	 				        }
	 				    },
	 				    xAxis:  {
	 				        type: 'category',
	 				        boundaryGap: false,
	 				        data: dateOption1
	 				    },
	 				    yAxis: {
	 				        type: 'value',
	 				        axisLabel: {
	 				            formatter: '{value} 元'
	 				        }
	 				    },
	 				    series: [
	 				       
	 				        {
	 				            name:'资产净值',
	 				            type:'line',
	 				            data:dateOption2,
	 				            markPoint: {
	 				                data: [
	 				                    {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
	 				                ]
	 				            },
	 				            markLine: {
	 				                data: [
	 				                    {type: 'average', name: '平均值'},
	 				                    [{
	 				                        symbol: 'none',
	 				                        x: '90%',
	 				                        yAxis: 'max'
	 				                    }, {
	 				                        symbol: 'circle',
	 				                        label: {
	 				                            normal: {
	 				                                position: 'start',
	 				                                formatter: '最大值'
	 				                            }
	 				                        },
	 				                        type: 'max',
	 				                        name: '最高点'
	 				                    }]
	 				                ]
	 				            }
	 				        }
	 				    ]
	 				};

	 		myChart.setOption(option);

	 		
	 		
	 		
	 		
	 		
	 		
	 		 dateOption1=[];
 			  dateOption2=[];
	 		
	 		
	 		 myChart2 = echarts.init(document.getElementById('div2'));  
	 		$.ajax({
 				type : "post",
 				url : '../AndroidselectNetValueChaAll.action?openDate='+openDate+'&endDate='+endDate+"&fundCode="+$('#fund', parent.document).html(),
 				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
 				 async:false,
 				//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
 				success : function(msg) {
 					var msgs = jQuery.parseJSON(msg);
 					for (var i = msgs.length-1; i >=0; i--) {
 						dateOption1.push(msgs[i].date);
 						dateOption2.push(msgs[i].unitNetMoney);
					}
 				}

 			});
	 		
	 		
	 		var option2 = {
 				    title: {
 				        text: '最近半个月的单位净值变化图',
 				        subtext: ''
 				    },
 				    tooltip: {
 				        trigger: 'axis'
 				    },
 				    legend: {
 				        data:['单位净值']
 				    },
 				    toolbox: {
 				        show: true,
 				        feature: {
 				            dataZoom: {
 				                yAxisIndex: 'none'
 				            },
 				            dataView: {readOnly: false},
 				            magicType: {type: ['line', 'bar']},
 				            restore: {},
 				            saveAsImage: {}
 				        }
 				    },
 				    xAxis:  {
 				        type: 'category',
 				        boundaryGap: false,
 				        data: dateOption1
 				    },
 				    yAxis: {
 				        type: 'value',
 				        axisLabel: {
 				            formatter: '{value} 元'
 				        }
 				    },
 				    series: [
 				       
 				        {
 				            name:'单位净值',
 				            type:'line',
 				            data:dateOption2,
 				            markPoint: {
 				                data: [
 				                    {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
 				                ]
 				            },
 				            markLine: {
 				                data: [
 				                    {type: 'average', name: '平均值'},
 				                    [{
 				                        symbol: 'none',
 				                        x: '90%',
 				                        yAxis: 'max'
 				                    }, {
 				                        symbol: 'circle',
 				                        label: {
 				                            normal: {
 				                                position: 'start',
 				                                formatter: '最大值'
 				                            }
 				                        },
 				                        type: 'max',
 				                        name: '最高点'
 				                    }]
 				                ]
 				            }
 				        }
 				    ]
 				};
	 		myChart2.setOption(option2);  
	 		
	 		
	 		
	 		
	 		
	 		//第三个报表 
	 		 myChart3 = echarts.init(document.getElementById('div3'));
	        var option3 = {
	                title: {    //标题
	                    text: '上证指数',
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
				url : "../stockFluctuateImage.action?startEnteringDate="+ openDate+'&endEnteringDate='+endDate, //请求发送到ShowInfoIndexServlet处
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
						
						myChart3.hideLoading(); //隐藏加载动画
						myChart3.setOption({ //载入数据
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
	        myChart3.setOption(option3);
	 		
	 	};
	 	
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