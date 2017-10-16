 window.requestAnimFrame = (function(){
                          return window.requestAnimationFrame ||
                           window.webkitRequestAnimationFrame ||
                            window.mozRequestAnimationFrame ||
                           function( callback ){
                             window.setTimeout(callback, 1000 / 60);
                                 };
                              })();
						var canvas=document.getElementById('can');
						canvas.width=canvas.parentNode.offsetWidth;
						canvas.height=canvas.parentNode.offsetHeight;
						var ctx=canvas.getContext('2d');
						ctx.lineWidth='1';
						var step=0;
						var lines=['rgba(0,202,121,1)','rgba(0,202,26,0.3)'];
						function loop(){
						ctx.clearRect(0,0,canvas.width,canvas.height);
						for(var j=lines.length-1;j>=0;j--){
							step++;
							ctx.fillStyle=lines[j];
							var angle=(step+j*90)*Math.PI/180;
							var delHeight=Math.sin(angle)*5;
							var delHeightRight=Math.cos(angle)*5;
							ctx.beginPath();
							ctx.moveTo(0,0);
							var height=canvas.height*0.9;
							ctx.lineTo(canvas.width,0);
							ctx.lineTo(canvas.width,height+delHeightRight);
							ctx.bezierCurveTo(canvas.width/2,height+delHeightRight-5,canvas.width/2,height+delHeight-5,0,height+delHeight);
							ctx.lineTo(0,0);
							ctx.closePath();
							ctx.fill();
							$("#user-photo").css("top",''+(7.5+delHeight/10)+'rem');
						}
						requestAnimFrame(loop);
					  }
						loop();
						
						function ses(){
							if($('.option-lists').is(':hidden')){
								$('.option-lists').show();
								$('#tree').html('&#xe614;');
							}else{
								$('.option-lists').hide();
								$('#tree').html('&#xe613;');
							}
						}
						
		              function tel(){
		              	if($("#tel_phone").is(":hidden")){
		              		$("#tel_phone").show();
		              		$("body")[0].scrollTop=$("body")[0].scrollHeight;
		              	}
		              	else{
		              		$("#tel_phone").hide();
		              	}
		              }