		var pageState=0;	
		var pageClasses=['main','main_1','main_2','main_3','main_4','main_5'];//所有的页面类
		//记录省名称
		var pro_name=null;
		//记录市名称
		var city_name=null;
		//记录区名称
		var retion_name=null;
		//记录街道名称
		var street_name=null;
		//获取省信息
		
		function showPage(pageClass){
			for(var i=0;i<pageClasses.length;i++){
				var pageC=pageClasses[i];
				if(pageC==pageClass){
					$("#"+pageC).show();
					pageState=i;
				}
				else $("#"+pageC).hide();
			}
		}
		
		function backPage(){
			if(pageState==0){
				history.back(-1); 
				return;
			}
			for(var i=1;i<pageClasses.length;i++){
				if(i==pageState){
					pageState--;
					showPage(pageClasses[pageState]);
				}
			}
		}
		
		function getProvinces(){
			$.ajax({
				type:"post",
				url:"getProvinces.action",
				data:"{}",
				dataType:"json",
				success:function(msg){
					
					$('#province_block').html('');
					var data=eval(msg); 
					var provincesMap=data.provincesMap;
						for(var key in provincesMap){
							$('#province_block').append('<p class="province-list area-list">'+provincesMap[key]+'<span id="number" class="number_style">'+key+'</span></p>');//省名字+省id(hiden)
						}
						
					
					//ajax类似多线程   城市信息加载完成后再进行监听
					$('.province-list').click(function(){
						pro_name=$(this).contents().filter(function(){
							return this.nodeType==3;
						}).text();
						var proId=$(this).children('#number').html();
						 getCities(proId);
						// $('#main_2').hide();
						 //$('#main_3').show();
						 showPage('main_3');
					});
				},
				error:function(){
					
				}
			});
			
		}
		
		//通过省id获取市信息
		function getCities(proId){
			$.ajax({
				type:"post",
				url:"getCities.action",
				data:{
					provinceId:proId
				},
				dataType:"json",
				success:function(msg){
					$('#city_block').html('');
					var data=eval(msg); 
					var citiesMap=data['citiesMap'];
					for(var key in citiesMap){
						$('#city_block').append('<p class="city-list area-list">'+citiesMap[key]+'<span id="number" class="number_style">'+key+'</span></p>');
						
					}
					//市列表加载完毕后实行监听
					$('.city-list').click(
							function(){
								city_name=$(this).contents().filter(function(){
									return this.nodeType==3;
								}).text();
								var cityId=$(this).children('#number').html();
								getRegions(cityId);
								// $('#main_3').hide();
								 //$('#main_4').show();
								 showPage('main_4');
							}
					);
				},
				error:function(){
					alert("获取数据失败");
				}
			});

		}
		
		//通过市id获取县信息
		function getRegions(cityId){
			$.ajax({
				type:"post",
				url:"getRegions.action",
				data:{
					cityId:cityId
				},
				dataType:"json",
				success:function(msg){
					$('#region_block').html('');
					var data=eval(msg);
					var regionsMap=data['regionsMap'];
					for(var key in regionsMap){
						$('#region_block').append('<p class="region-list area-list">'+regionsMap[key]+'<span id="number" class="number_style">'+key+'</span></p>');
					}
					//加载完成后添加监听
					$('.region-list').click(function(){
						region_name=$(this).contents().filter(function(){
							return this.nodeType==3;
						}).text();
						var regionId=$(this).children('#number').html();
						region_name=$(this).contents().filter(function(){
							return this.nodeType==3;
						}).text();		
						var str=pro_name+" "+city_name+" "+region_name+"   ";
						$('#select_region').text(str);
						$('#select_street').text("请选择    ");
						 //$('#main_4').hide();
						 //$('#main_1').show();
						 showPage('main_1');
						 getStreets(regionId);
					});
				},
				error:function(){
					alert("获取数据失败");
				}
			});
		}
		
		//通过县id获取街道信息
		function getStreets(regionId){
			$.ajax({
				type:"post",
				url:"getStreets.action",
				data:{
					regionId:regionId
				},
				dataType:"json",
				success:function(msg){
					$('#street_block').html('');
					var data=eval(msg);
					var streetsMap=data['streetsMap'];
					for(var key in streetsMap){
						$('#street_block').append('<p class="street-list area-list">'+streetsMap[key]+'<span id="number" class="number_style">'+key+'</span></p>');
					}
					$('.street-list').click(function(){
						street_name=$(this).contents().filter(function(){
							return this.nodeType==3;
						}).text();
						$('#select_street').text(street_name+"   ");
						//$('#main_5').hide();
						//$('#main_1').show();
						showPage('main_1');
					});
				},
				error:function(){
					alert("获取数据失败");
				}
			});
		}
		    var thisP;
		    function colorChange(){
		    	thisP.css("background","#cad2ca");
				setTimeout(function(){
				thisP.css("background","#FFFFFF");
				},170);
		    }
			$(document).ready(function(){
				$('.feel_click').click(function(){
				thisP=$(this);
				colorChange();
					});

				$('#is_defalut').attr('checked',false);
				$('#checkbox_div').click(function(){
					if($('#is_defalut').attr('checked')=='checked'){
						$('#is_defalut').attr('checked',false);
					}
					else{
						$('#is_defalut').attr('checked',true);
					}
				});
				
				$('#add_address').click(function(){
					
					//$('#main').hide();
					//$('#main_1').show();
					showPage('main_1');
					
				});
				$('#show-main').click(function(){
					pro_name=null;
					city_name=null;
					retion_name=null;
					street_name=null;
					region_id=null;
					//$('#main_1').hide();
					//$('#main').show();
					showPage('main');
					$('input[type=text]').val('');
					$('#select_region').text("请选择    ");
					$('#select_street').text("请选择    ");
					$('#is_defalut').attr('checked',false);
				});
				$('#show-main1').click(function(){
					$('#province_block').html('');
					//$('#main_1').show();
					//$('#main_2').hide();
					showPage('main_1');
					
				});
				$('#show-main2').click(function(){
					$('#city_block').html('');
					//$('#main_2').show();
					//$('#main_3').hide();
					showPage('main_2');
					
				});
				$('#show-main3').click(function(){
					$('.region-list').remove();
					//$('#main_3').show();
					//$('#main_4').hide();
					showPage('main_3');
					
				});
				$('#show-main1-2').click(function(){
					
					//$('#main_1').show();
					//$('#main_5').hide();
					showPage('main_1');
					
				});
				//选择地址
				$('#select-area').click(function(){
				    pro_name=null;
					city_name=null;
					retion_name=null;
					street_name=null;
					region_id=null;
					//$('#main_1').hide();
					//$('#main_2').show();
					showPage('main_2');
				});
				
				//选择街道
				$('#select-street').click(function(){
					street_name=null;
					//$('#main_5').show();
					//$('#main_1').hide();
					showPage('main_5');
				});

				//返回按钮监听
				$(".to_user_message").mousedown(
						function(){
							backPage();
						}
				);
				
				//保存按钮监听
				$('#commit-sure').click(function(){
					var linkname=$('#linkname').val().trim();
					var linkphone=$('#linkphone').val().trim();
					var text1=$('#select_region').text().trim();				
					var strs=text1.split(' ');
					var province=strs[0];
					var city=strs[1];
					var region=strs[2];
					var street=$('#select_street').text().trim();
					if(linkname==null||linkname==""||linkphone==null||linkphone==""||province==null||province==""||city==null||city==""||region==null||region==""||street==null||street==""||street=="请选择"){
						alert("信息填写不完整");
						return;
					}
					var pattern=new RegExp("^([0-9]|-){6,20}$");
					if(pattern.test(linkphone)==false){
						alert("联系方式格式不正确");
						return
					}
					var detail=$('.del_textarea').val().trim();
					var check="no";
					if($('#is_defalut').attr('checked')=='checked'){
						check="yes";
					}

					$.ajax({
	        			type:"post",
	        			url:"addAddress.action",
	        			async:true,
	        			data:{
	        				linkname:linkname,
							linkphone:linkphone,
							province:province,
							city:city,
							region:region,
							street:street,
							detail:detail,
							check:check
	        			},
	        			success:function(msg){
	        				if(msg=="success"){
	        					alert("添加地址成功");
	        					window.location.href="addressManager.action";
	        					
	        				}else{
	        					alert("添加地址失败");
	        				}
	        			},
	        			error:function(){
	        				alert("添加地址失败");
	        			}
	        		});
					
				});
				
				//删除按钮监听
				$(".del_address").click(function(){
					var addressNo=$(this).parents('.address_item').find('.add_no').text();
					if(confirm("是否删除该地址")){
						$.ajax({
							type:"post",
							url:"delAddress.action",
							data:{
								addressNo:addressNo
							},
							success:function(msg){
								if(msg=="success"){
									window.location.href="addressManager.action";
								}else{
									alert("删除地址失败");
								}
							},
							error:function(){
								alert("删除地址失败");
							}
						});
					}else{
						
					}
				});
            });
            
            function checkAddress(obj){
            	var all=document.getElementsByClassName('set_address_checkbox');
					for(var i=0;i<all.length;i++){
						if(obj==all[i]){
							
						}
					    else all[i].checked=false;
					}
				
            }