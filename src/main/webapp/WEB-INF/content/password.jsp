<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, 
			initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
			<meta name="format-detection" content="telephone=yes" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet"  href="css/password.css" />
		<link href="//fonts.gdgdocs.org/css?family=Lobster" rel="stylesheet" type="text/css"/>
	    <script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<title></title>
		<style>
			
			@font-face {font-family: 'iconfont';
                  src: url('font/iconfont.eot'); /* IE9*/
                  src: url('font/iconfont.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
                  url('font/iconfont.woff') format('woff'), /* chrome、firefox */
                  url('font/iconfont.ttf') format('truetype'), /* chrome、firefox、opera、Safari, Android, iOS 4.2+*/
                  url('font/iconfont.svg#iconfont') format('svg'); /* iOS 4.1- */
               }
               

		</style>
		<script type="application/javascript">
			function strJundge(str){
				if(str==""||str==null||str.length<6||str.length>20){
					return false;
				}
				return true;
			}
			
			//提交给服务器处理
			function commitNet(oldP,newP){
				$.ajax({
					type:"post",
					url:"editPassword.action",
					data:{
						oldP:oldP,
						newP:newP
					},
					dataType:"json",
					success:function(msg){
						var data=eval(msg);
						var result=data['resultMap']['result'];
						if(result=="success"){
							$("#commit").val("修改成功");
							setTimeout(function(){
								$("#commit").val("确定");
								$("#commit").removeAttr("disabled"); 
							},500);
						}else if(result=="pswerror"){
							$("#commit").addClass("btn-danger");
							$("#commit").val("密码错误");
							$("#commit").removeAttr("disabled"); 
							}else{
							$("#commit").addClass("btn-danger");
							$("#commit").val("修改失败");
							$("#commit").removeAttr("disabled"); 
						}
					},
					
					error:function(){
						$("#commit").addClass("btn-danger");
						$("#commit").val("网络出错");
						$("#commit").removeAttr("disabled"); 
					}
				});
			}
			$("document").ready(function(){
				$("#commit").click(function(){
					$("#commit").removeClass("btn-danger");
					var oldP=$.trim($("#oldpa").val());
					var newP=$.trim($("#newpa").val());
					var newP2=$.trim($("#newpa_2").val());
					var errors=false;
					if(!strJundge(oldP)){
						$("#oldpa").parent().addClass("has-error");
						errors=true;
					}else{
						$("#oldpa").parent().removeClass("has-error")
					}
					if(!strJundge(newP)){
						$("#newpa").parent().addClass("has-error");
						errors=true;
					}else{
						$("#newpa").parent().removeClass("has-error")
					}
					if(!strJundge(newP2)||newP!=newP2){
						$("#newpa_2").parent().addClass("has-error");
						errors=true;
					}else{
						$("#newpa_2").parent().removeClass("has-error")
					}
					if(errors){
					//如果上述有问题就返回函数
						return;
					}
					$("#commit").attr("disabled",true);
					$("#commit").val("修改中...");
					commitNet(oldP,newP);
				});
				$("#back").click(function(){
					location.href="toUserPage";
				});
			});
		</script>
	</head>
	<body>
		<div class="container">	
			<header>
				<div class="head">	
					<span class="back iconfont" id="back">&#xe608;</span>
				</div>
			</header>
			<div class="block_1"></div>
			<div class="row" style="margin-top: 7rem;">
				<div class="col-xs-8 col-xs-offset-2 col-sm-6 col-sm-offset-3 margin-1">
					<input type="password" class="form-control" placeholder="输入原密码" id="oldpa"/>
				</div>
				<div class="col-xs-8 col-xs-offset-2 col-sm-6 col-sm-offset-3 margin-1">
					<input type="password" class="form-control" placeholder="输入新密码" id="newpa"/>
				</div>
				<div class="col-xs-8 col-xs-offset-2 col-sm-6 col-sm-offset-3 margin-1">
					<input type="password" class="form-control" placeholder="确认新密码" id="newpa_2"/>
				</div>
				<div class="col-xs-8 col-xs-offset-2 col-sm-4 col-sm-offset-4">
					<input type="button" class="btn btn-block btn-primary margin-2" value="确定" id="commit" ></input>
				</div>
			</div>
		</div>
	</body>
</html>
