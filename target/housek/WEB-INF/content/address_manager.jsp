<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<meta name="viewport" content="width=device-width, 
			initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<link href="css/bootstrap.min.css" rel="stylesheet"/>
		<link href="css/address_manager.css" type="text/css" rel="stylesheet"/>
        <script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js" ></script>
        <script type="text/javascript" src="js/address-manager.js" ></script>
		 <style>
        	@font-face {font-family: 'iconfont';
                  src: url('font/iconfont.eot'); /* IE9*/
                  src: url('font/iconfont.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
                  url('font/iconfont.woff') format('woff'), /* chrome、firefox */
                  url('font/iconfont.ttf') format('truetype'), /* chrome、firefox、opera、Safari, Android, iOS 4.2+*/
                  url('font/iconfont.svg#iconfont') format('svg'); /* iOS 4.1- */
               }
            .empty_state{
              	 font-size: 2rem;
              	 height: 100%;
              	 width: 100%;
              	 text-align: center;
              	 padding-top: 10rem;
              }
        </style>
		<title></title>
	</head>
	<body>

		<%--主界面 --%>
		<article id="main">
		<div class="container">
		<header>
			<div class="head">
				<p>
					<span class="to_user_message">
					<span class="iconfont head_text">&#xe608;</span><span class="head_text_2">返回</span>
					</span>
					<%-- <span class="shell"><span class="save">保存</span></span>--%>
				</p>
			</div>
		</header>
		<div class="block_1"></div>
		<article class="address_list">
		<%List<UserAddress> addresses=(List<UserAddress>)request.getAttribute("addresses"); %>
		<% 
		if(addresses.size()==0){
			String txt="<div class=\"empty_state\">地址栏是空的~</div>";
			out.write(txt);
		}else{
		for(int i=0;i<addresses.size();i++){ 
			UserAddress address=addresses.get(i);
		%>
			<div class="address_item">
			    
				<div class="address_message_1">
					<span class="add_no" hidden="hidden"><%=i %></span>
					<span class="cus_name"><%=address.getLinkName() %></span>
					<span class="cus_tel"><%=address.getLinkPhone() %></span>
				</div>
				<div class="address_message_2">
					<span class="det_address"><%=address.getUserProvince() %><%=address.getUserCity() %><%=address.getUserRegion() %><%=address.getUserStreet() %><%=address.getUserDetailAddress() %></span>
				</div>
				<div class="address_operate ">
					
					<span class="set_address_text_right  del_address" >
					<span class="iconfont set_address_text_right_icon">&#xe615;</span>
					<span >删除</span>
					</span>
				</div>	
			</div>
			<div class="block_2"></div>
			<% } %>
			
			<div style="height: 5rem;"></div>
			<% } %>
		</article>
		<footer>
			<div class="add_address" id="add_address">
				<span class="add_address_text">添加新地址</span>
			</div>
		</footer>
		</div>
		</article>
		<!--
        	作者：1471880107@qq.com
        	时间：2016-11-08
        	描述：添加修改地址
        -->
        <script type="text/javascript">
        		

			</script>
			
		<%--添加地址界面 --%>
		<article id="main_1">
		<div class="container">
		    <header>
				<div class="head" >
					<p>
						<span class="to_user_message">
						<span class="iconfont head_text"  id="show-main">&#xe608;</span>
						</span>
					</p>
				</div>
			</header>
			<div class="block_1"></div>
			<div class="message_model">
				<span class="in_message_label">联系人&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<input type="text" class="in_message_input" id="linkname"/>
			</div>
			<div class="message_model" >
				<span class="in_message_label">联系电话&nbsp;</span>
				<input type="text" class="in_message_input" id="linkphone"/>
			</div>
			<div class="message_model pos_div feel_click" id="select-area" onclick="getProvinces()">
				<span class="in_message_label">所在地区</span>
				<span class="select"><span id="select_region">请选择&nbsp;&nbsp;&nbsp;</span><span class="iconfont">&#xe616;</span></span>
			</div>
			<div class="message_model pos_div feel_click" id="select-street">
				<span class="in_message_label">街道</span>
				<span class="select" ><span id="select_street">请选择&nbsp;&nbsp;&nbsp;</span><span class="iconfont">&#xe616;</span></span>
			</div>
			<div class="del_message">
				<textarea class="del_textarea" cols="25" rows="6" placeholder="详细信息"></textarea>
			</div>
			<div class="block_2"></div>
			<div class="message_model pos_div feel_click" id="checkbox_div">
				<span class="in_message_label">设为默认地址</span>
				<input  type="checkbox" class="check" id="is_defalut" checked="checked"/>
			</div>
		</div>
		<footer>
			<div class="add_address" id="commit-sure" >
				<span class="add_address_text" id="save">保存</span>
			</div>
		</footer>
		</article>
		<%--省列表 界面--%>
		<article id="main_2">
			<div class="container">
		    <header>
				<div class="head">
					<p>
						<span class="to_user_message">
						<span class="iconfont head_text" id="show-main1">&#xe608;</span>
						</span>
					</p>
				</div>
			</header>
			<div class="block_1"></div>		
			<div id="province_block">
				<!--<p class="province-list area-list">北京市<span id="number">1</span></p>-->
			</div>
			</div>
		</article>
		<%--市列表界面 --%>
		<article id="main_3">
			<div class="container">
		    <header>
				<div class="head">
					<p>
						<span class="to_user_message">
						<span class="iconfont head_text" id="show-main2">&#xe608;</span>
						</span>
					</p>
				</div>
			</header>
			<div class="block_1"></div>
			<div id="city_block">
				<!--<p class="city-list area-list">市辖区<span id="number">1</span></p>-->
			</div>
			</div>
		</article>
		<%--县列表界面 --%>
		<article id="main_4">
			<div class="container">
		    <header>
				<div class="head">
					<p>
						<span class="to_user_message">
						<span class="iconfont head_text" id="show-main3">&#xe608;</span>
						</span>
					</p>
				</div>
			</header>
			<div class="block_1"></div>
			<div id="region_block">
			<%--<p class="region-list area-list">温岭市</p> --%>
			</div>
			</div>
		</article>
		<%--镇列表界面 --%>
		<article id="main_5">
			<div class="container">
		    <header>
				<div class="head">
					<p>
						<span class="to_user_message">
						<span class="iconfont head_text" id="show-main1-2">&#xe608;</span>
						</span>
					</p>
				</div>
			</header>
			<div class="block_1"></div>
			<div id="street_block">
			<%-- <p class="street-list area-list">松门镇</p> --%>
			</div>
			</div>
		</article>
	</body>
</html>
