<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, 
			initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/index.css" />
        <link rel="icon" href="img/favicon.ico" type="image/x-icon"/>
        <script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js" ></script>
        <script type="text/javascript" src="js/index.js" ></script>
        <style>
        	@font-face {font-family: 'iconfont';
                  src: url('font/iconfont.eot'); /* IE9*/
                  src: url('font/iconfont.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
                  url('font/iconfont.woff') format('woff'), /* chrome、firefox */
                  url('font/iconfont.ttf') format('truetype'), /* chrome、firefox、opera、Safari, Android, iOS 4.2+*/
                  url('font/iconfont.svg#iconfont') format('svg'); /* iOS 4.1- */
               }
        
        </style>
		<title></title>
	</head>
	<body>
		<div class="container">
			<header>
				<div class="head_div"></div>
			</header>
			<div class="space_block">
				<div id="myCarousel" class="carousel slide">
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1" ></li>
						<li data-target="#myCarousel" data-slide-to="2" ></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<a href="http://www.baidu.com">
								<img src="img/aaa.jpg" />
							</a>
						</div>
						<div class="item">
						    <a href="http://www.baidu.com">
						    	<img src="img/bbb.jpg"  />
							</a>
						</div>
						<div class="item">
							<a href="http://www.baidu.com">
								<img src="img/ccc.jpg"/>
							</a>
						</div>
					</div>
					<a class="carousel-control left" data-slide="prev" href="#myCarousel">&lsaquo;</a>
					<a class="carousel-control right" data-slide="next" href="#myCarousel">&rsaquo;</a>
				</div>
			</div>
			<div class="list-style">
				<div class="a list-u" >
					<span class="message">宁波市</span>
					<span class="iconfont background-icon">&#xe604;</span>
				</div>
				<div class="b list-u">
					<div class="new-message">9</div>
					<span class="message">消息</span>
					<span class="iconfont background-icon">&#xe600;</span>
				</div>
			</div>
			<div class="list-style">
				<div class="c list-u">
					<span class="message">服务分类</span>
					<span class="iconfont background-icon">&#xe602;</span>
				</div>
				<div class="d list-u">
					<span class="message">需求发布</span>
					<span class="iconfont background-icon">&#xe603;</span>
				</div>
			</div>
			<div class="list-style">
				<div class="e list-u">
					<span class="message">订单管理</span>
					<span class="iconfont background-icon">&#xe601;</span>
				</div>
				<div class="f list-u">
					<span class="message">个人信息</span>
					<span class="iconfont background-icon">&#xe605;</span>
				</div>
			</div>
		</div>
	</body>
</html>
