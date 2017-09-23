<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, 
			initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/login.css" />
        <script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js" ></script>
        <script type="text/javascript" src="js/login.js" ></script>
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
	</head>
	<body>
		<div class="container">
			<header>
				<div class="head_div">
					<span class="back iconfont" id="back">&#xe608;</span>
					<span class="back iconfont" id="back2" onclick="window.location.href='toIndex'">&#xe608;</span>
				</div>
			</header>
			<div class="space_block"></div>
			<article id="login-page">
			<div class="input-group">
				<span class="input-group-addon iconfont" >&#xe607;</span>
				<input class="form-control" id="user-id" placeholder="输入手机号"  onfocus="inputReturn1()"/>
			</div>
			<div class="input-group">
				<span class="input-group-addon iconfont">&#xe606;</span>
				<input class="form-control" id="passwd" type="password" placeholder="输入密码" onfocus="inputReturn1()" />
			</div>
			<div class="next-block">
			<span><a id="register">新用户注册</a></span>
			<span style="float: right;"><a>找回密码</a></span>
			</div>
			<div class="button-block">
			<button class="btn" id="login"
				style="display: block;width: 80%;margin: 0 auto;
				height: 4.5rem;background: #00ca79;" onclick="login()">
				<span class="button-text" id="login-text" style="color: #FFFFFF;font-size: 2rem;">
					登录</span>
			</button>
			<script type="text/javascript">
			function login(){
	    		var userId=$("#user-id").val();
	    		var passwd=$("#passwd").val();
	    		if(userId!=null&&userId!=""&&passwd!=null&&passwd!=""){
	    			$('#login').attr('disabled','true');
					$('#login-text').text('登录中...');
	    		$.ajax({
	    			type:'post',
	    			url:'login.action',
	    			async:true,
	    			data:{
	    				userId:userId,
	    				passwd:passwd
	    			},
	    			dataType:'text',
	    			success:function(msg){
	    				$('#login').attr('disabled','false');
						$('#login-text').text('登录');
	    				 if(msg=='false1'){
	    					 $('#error1').hide();
	    		
	    						$('#false2').hide();
	    						$('#reg-success').hide();
	    					$("#false1").show();
	    				 }
	    				 if(msg=='false2'){
	    					 $('#error1').hide();
	    						$('#false1').hide();
	    			
	    						$('#reg-success').hide();
	    					$("#false2").show();
	    				 }
	    				 if(msg=='success'){
	    					 window.location.href='<s:property value="#parameters.pageState"/>.action';
	    				 }
	    			},
	    			error:function(){
	    				$('#login').attr('disabled','false');
						$('#login-text').text('登录');
	    			}
	    		});
	    		}
	    	}
			</script>
			</div>
			<div class="false-prompt iconfont" id="false1">&#xe60a;用户不存在</div>
			<div class="false-prompt iconfont" id="false2">&#xe60a;密码错误</div>
			<div class="success-prompt iconfont" id="reg-success">&#xe60c;注册成功,请登录</div>
			</article>
			<article id="register-page">
			<div class="input-group">
				<span class="input-group-addon iconfont" >&#xe607;</span>
				<input id="reg-user-id" class="form-control" placeholder="输入手机号" onkeyup="regUserIdCheck()"/>
				<span class="input-group-addon iconfont" id="reg-user-id-check">&#xe60b;</span>
			</div>
			<div class="input-group">
				<span class="input-group-addon iconfont">&#xe606;</span>
				<input id="reg-passwd1" class="form-control" type="password" placeholder="输入6~15位密码"  onkeyup="passwdCheck()"/>
				<span class="input-group-addon iconfont" id="reg-passwd1-check">&#xe60b;</span>
			</div>
			<div class="input-group">
				<span class="input-group-addon iconfont">&#xe609;</span>
				<input id="reg-passwd2" class="form-control" type="password" placeholder="确认密码" onkeyup="passwdCheck()" />
				<span class="input-group-addon iconfont" id="reg-passwd2-check">&#xe60b;</span>
			</div>
			
			<div class="button-block">
			<button class="btn" id="regist"
				style="display: block;width: 80%;margin: 0 auto;
				height: 4.5rem;background: #00ca79;" onclick="register()">
				<span class="button-text"  id="regist-text" style="color: #FFFFFF;font-size: 2rem;" >
					注册</span>
			</button>
			</div>
			<div class="false-prompt iconfont" id="error1">&#xe60b;该用户已存在</div>
			</article>
		</div>
	</body>
</html>
