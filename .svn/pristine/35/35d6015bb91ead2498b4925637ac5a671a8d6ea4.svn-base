<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="../js/jquery-3.1.1.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../js/easyui/ui-sunny/easyui.css" />
<link rel="stylesheet" href="../js/easyui/icons/icon-all.css" />
<script src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/modernizr.js">
</script>
<!--引入弹窗插件的样式文件-->
<link rel="stylesheet" href="../js/alert/alert.css">
<!--引入弹窗插件的js文件-->
<script src='../js/alert/alert.js'></script>
<link rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../js/utils.js"></script>
<title>权限管理</title>
<style type="text/css">
</style>
<script type="text/javascript">
	$(function() {
		$("#managementTable").treegrid({
			height : '450',
			url : '../loadAuthorityByRole.action',
			title : '修改权限',
			//toolbar:'#tool',
			animate : true,
			//toolbar:'#tool',
			idField : 'rightText',
			treeField : 'rightText',
			singleSelect:false,
			checkOnSelect:false,
			fitColumns : true,
			checkOnSelect:false,
			onCheck:function(index,rows){
					//得到子节点	
					var allChred=$("#managementTable").treegrid('getChildren',index.rightText);
					if(!(allChred.length==0)){
						$.each(allChred,function(i,children){
							//勾选指定的行
							$("#managementTable").treegrid('checkRow',children.rightText);
						});
					}
				var insertFlag =$("#insert"+index.rightCode);
				if(!(insertFlag.attr("checked")=="checked")){
					$(insertFlag).click();
				}
				var updateFlag =$("#update"+index.rightCode); 
				if(!(updateFlag.attr("checked")=="checked")){
					$(updateFlag).click();
				}
				var deleteFlag =$("#delete"+index.rightCode); 
				if(!(deleteFlag.attr("checked")=="checked")){
					$(deleteFlag).click();
				}
				index.checked=true;
			},
			onUncheck:function(index,rows){
				//得到子节点	
				var allChred=$("#managementTable").treegrid('getChildren',index.rightText);
				if(!(allChred.length==0)){
					$.each(allChred,function(i,children){
						//勾选指定的行
						$("#managementTable").treegrid('uncheckRow',children.rightText);
					});
				}
				var insertFlag =$("#insert"+index.rightCode);
				if((insertFlag.attr("checked")=="checked")){
					$(insertFlag).click();
				}
				var updateFlag =$("#update"+index.rightCode); 
				if((updateFlag.attr("checked")=="checked")){
					$(updateFlag).click();
				}
				var deleteFlag =$("#delete"+index.rightCode); 
				if((deleteFlag.attr("checked")=="checked")){
					$(deleteFlag).click();
				}
				index.checked=false;
			},
			onSelectAll:function(rows){
				$.each(rows,function(i,c){
					$("#managementTable").treegrid('checkRow',c.rightText);
					c.checked=true;
				})
			},
			onUnselectAll:function(rows){
				$.each(rows,function(i,c){
					$("#managementTable").treegrid('uncheckRow',c.rightText);
					c.checked=false;
				})
			},
			columns : [[{
				
				checkbox : true,
			}, {
				field : 'rightText',
				title : '功能名称',
				width : 100,
			}, {
				field : 'insertFlag',
				title : '<b>增加功能<b/>',
				align : 'center',
				width : 100,
				formatter:function(value,row,index){
					
					var allChred=$("#managementTable").treegrid('getChildren',row.rightText);
					if((allChred.length==0)){
					if(value=='1'){
						return "<input type='checkbox' value='"+value+"' id='insert"+row.rightCode+"'  onclick='chageChecked(this)' name='box' checked='checked' class = 'chk_3'/><label for='insert"+row.rightCode+"'>";
					}else{
						return "<input type='checkbox' name='box'  value='0' id='insert"+row.rightCode+"'  onclick='chageChecked(this)' class = 'chk_3' /><label for='insert"+row.rightCode+"'>";
					}
					}
				}
			}, {
				field : 'updateFlag',
				title : '<b>修改功能<b/>',
				align : 'center',
				width : 100,
				formatter:function(value,row,index){
					var allChred=$("#managementTable").treegrid('getChildren',row.rightText);
					if((allChred.length==0)){
					if(value=='1'){
						return "<input type='checkbox'  name='box'  value='"+value+"' id='update"+row.rightCode+"'  onclick='chageChecked(this)' checked='checked' class = 'chk_3'/><label for='update"+row.rightCode+"'>";
					}else {
						
						return "<input type='checkbox' name='box' value='0' id='update"+row.rightCode+"'  onclick='chageChecked(this)' title=''  class = 'chk_3'/><label for='update"+row.rightCode+"'>";
					}
					}
				}
			}, {
				field : 'deleteFlag',
				title : '<b>删除功能<b/>',
				align : 'center',
				width : 100,formatter:function(value,row,index){
					var allChred=$("#managementTable").treegrid('getChildren',row.rightText);
					if((allChred.length==0)){
					if(value=='1'){
						
						return "<input type='checkbox'  name='box'  value='"+value+"' id='delete"+row.rightCode+"'  onclick='chageChecked(this)' checked='checked' class = 'chk_3'/><label for='delete"+row.rightCode+"'>";
					}else {
						return "<input type='checkbox' name='box' value='0' id='delete"+row.rightCode+"'  onclick='chageChecked(this)'   class = 'chk_3' /><label for='delete"+row.rightCode+"'>";
					}
					}
				}
			},
			]],
		});
	});
	function allChecked(){

		$("#onChecked").get(0).checked=true;
		$("#disChecked").get(0).checked=false;
		var allChecks=$("#managementTable").treegrid('getRoots');
		$.each(allChecks,function(i,kk){
			var allChecksd=$("#managementTable").treegrid('getChildren',i);
			$.each(allChecksd,function(i,kks){
				$("#managementTable").treegrid('checkRow',kks.rightText);
			});
		});
	}
	function allDisChecked(){j
		$("#onChecked").get(0).checked=false;
		$("#disChecked").get(0).checked=true;
		var allChecks=$("#managementTable").treegrid('getRoots');
		$.each(allChecks,function(i,kk){
			var allChecksd=$("#managementTable").treegrid('getChildren',i);
			$.each(allChecksd,function(i,kks){
				$("#managementTable").treegrid('uncheckRow',kks.rightText);
			});
		});
	}
	function  getAllChecked(){
		var allChecks=$("#managementTable").treegrid('getRoots');
		var allRight_role=[];
		$.each(allChecks,function(i,kk){
			var allChecksd=$("#managementTable").treegrid('getChildren',i);
			$.each(allChecksd,function(i,kks){
				var checkFlag = kks.checked;
				var bianhao = kks.rightCode;
				if(checkFlag){
					var insertFlag =$("#insert"+bianhao).attr("value");
				
					if((insertFlag ==undefined) ){
						insertFlag=-1;
					}
					var updateFlag=$("#update"+bianhao).attr("value");
					if(updateFlag==undefined){
						updateFlag=-1;
					}
					var deleteFlag=$("#delete"+bianhao).attr("value"); 
					if(deleteFlag==undefined){
						deleteFlag=-1;
					}
					var  right_role = '{"rightCode":"'+kks.rightCode+'","insertFlag":"'+insertFlag
					+'","updateFlag":"'+updateFlag+'","deleteFlag":"'+deleteFlag+'"}';
					
					allRight_role.push(right_role);
				}
			});
		});
		
		//ajax发送请求
		$.ajax({
			type: "post",
			url: "../insertRoleRight.action",
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			//$("#myForm").serializeArray() 以对象的形式得到文本框内的值
			data: "roleRight=["+allRight_role+"]",
			success: function(msgs) {
				//提示
				myAlert(msgs);
				goBack();
			}
		});
	};
	function chageChecked(checkFlag){
	var   values=	$(checkFlag).attr("value");
	//alert($(checkFlag).attr("checked"));
		if(values==1){
			$(checkFlag).attr("checked",false);
			$(checkFlag).attr("value",0);
		}else if(values==0){
			$(checkFlag).attr("checked",true);
			$(checkFlag).attr("value",1);
		}
	}
	function goBack(){
		history.go(-1);
		
		
	}
 </script>
</head>
<body>
	<div style="padding: 10px" >
		<!-- <input type="checkbox" class="" id="onChecked" onchange="allChecked()" />全选
		<input type="checkbox" class="" id="disChecked" onchange="allDisChecked()" />全不选 -->
		<div class="form-inline" style="padding: 10px;">
		<button type="button" id="btnSave" class="btn btn-primary" onclick="getAllChecked()">
		
								<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
							</button>
							<button type="button"  class="btn btn-primary" onclick="goBack()">
		
								<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>返回上一页
							</button>
							
							
								
								<label>当前角色名 :</label>
								<div class="form-group " >
									<input type="text" class="form-control"  disabled="disabled" value="${role.roleName}" style="width:150px">
								</div>
								
								
							</div>
							
		
	</div>
	
	<!-- 权限管理的表格 -->
	<table id="managementTable">
	</table>
</body>
</html>