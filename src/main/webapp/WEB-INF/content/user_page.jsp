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
		<link rel="stylesheet" href="css/user.css" />
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
	</head>
	<body>
		<div class="container">
			<header>
			<div class="head_div">
					<div class="name-div">
					<span class="user-name">153***5182</span>
					</div>
					<div class="to-index"><span class="iconfont">&#xe617;<span class="to-index-text">首页</span></span></div> 
				    <div class="to-exit"><span class="to-exit-text">退出</span></span></div> 
				    <canvas class="can" id="can"></canvas>
					<script type="text/javascript" src="js/user.js"> 
					</script>
			</div>
			<div class="block"></div>
			
		    <img id="user-photo" src="img/slide1.png"  width="55rem" height="55rem" class="photo"/>
			</header>
			<div class="art">
			<div class="cash-list">
				<div class="cash">
					<p class="count">0</p>
					<p class="dis-text">代金券</p>
				</div>
				<div class="cash collect">
					<p class="count">0</p>
					<p class="dis-text">收藏店铺</p>
				</div>
				<div class="cash">
					<p class="count">0</p>
					<p class="dis-text">余额</p>
				</div>
			</div>

			<div style="height: 1rem;background: #eeeeee;"></div>
			</div>
			<div class="store-enter" id="store-enter"><span class="iconfont">&#xe611;</span>商家入驻</div>
			<div class="store-enter" id="person" onclick="ses()"><span class="iconfont">&#xe612;</span>个人信息
			<span class="iconfont" id="tree">&#xe613;</span>
			</div>
			<article class="option-lists">
				<p class="option" id="address-manager"><span class="iconfont" style="font-size:2rem ;">&#xe60f;</span>&nbsp;&nbsp;地址管理</p>
				<script style="text/javascript">
					$("document").ready(function(){
						$("#address-manager").click(function(){
							window.location.href="addressManager";
						});
						$(".to-index").click(function(){
							window.location.href="toIndex";
						});
						$("#store-enter").click(function(){
							var id = Math.ceil(Math.random()*3500);
							window.location.href="storeEnter.action?id="+id;
						});
						$(".to-exit").click(function(){
							window.location.href="exitUser?pageState=toUserPage";
						});
						$("#password-manager").click(function(){
							window.location.href="passwordManager";
						});
					});
				</script>
				<p class="option" id="password-manager"><span class="iconfont" style="font-size:2rem ;">&#xe610;</span>&nbsp;&nbsp;密码维护</p>
				<p class="option"><span class="iconfont" style="font-size:2rem ;">&#xe60e;</span>&nbsp;&nbsp;我的评价</p>
				<p class="option" id="tel" onclick="tel()"><span class="iconfont" style="font-size:2rem ;">&#xe60d;</span>&nbsp;&nbsp;联系客服</p>
				<p class="option" id="tel_phone">联系方式:<a href="tel:15325865182">1532865182</a></p>
			</article>
		</div>
	</body>
</html>
