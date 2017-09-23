$(document).ready(function(){
	    	$("#back").click(function(){
	    		$("#back").hide();
	    		$("#register-page").hide();
	    		$("#login-page").show();
	    		$("#back2").show();
	    	});
	    	$("#register").click(function(){
	    		$("#login-page").hide();
	    		$("#back2").hide();
	    		$("#register-page").show();
	    		$("#back").show();
	    	});
	    });
		
    	function inputReturn1(){
    		$('#false1').hide();
    	}
    	
    	function inputReturn2(){
    		$('#false2').hide();
    	}
        	userIdState=false;
        	passwd1State=false;
        	passwd2State=false;
        	function register(){
        		
        		var userId=$("#reg-user-id").val();
        		var passwd1=$("#reg-passwd1").val();
        		if(userIdState==false||passwd1State==false||passwd2State==false)
        		  return;
        		$('#regist').attr('disabled','true');
        		$('#regist-text').text('注册中...');
        		$.ajax({
        			type:"post",
        			url:"register.action",
        			async:true,
        			data:{
        				userId:userId,
        				passwd:passwd1
        			},
        			success:function(msg){
        				$('#regist').attr('disabled','false');
        				$('#regist-text').text('注册');
        				if(msg=="error1")
        				$("#error1").show();
        				if(msg=="success"){
        					$("input[type='text']").val("");
        					$("#user-id").val(userId);
        					$("#register-page").hide();
        					$("#login-page").show();
        					$("#reg-success").show();
        				}
        			},
        			error:function(){
        				$('#regist').attr('disabled','false');
        				$('#regist-text').text('注册');
        			}
        		});
        	}
        	function regUserIdCheck(){
        		var pattern=new RegExp("^1[0-9]{10}$");
        		var userId=$("#reg-user-id").val();
        		if(pattern.test(userId)==true){
        			$("#reg-user-id-check").html("&#xe60c;").addClass("begreen");
        			userIdState=true;
        		}
        		else{
        			$("#reg-user-id-check").html("&#xe60b;").removeClass("begreen");
        			userIdState=false;
        		}
        	}
        	
        	function passwdCheck(){
        		var passwd1=$("#reg-passwd1").val();
        		var passwd2=$("#reg-passwd2").val();
        		if(passwd1.length>=6&&passwd1.length<=15){
        			$("#reg-passwd1-check").html("&#xe60c;").addClass("begreen");
        			passwd1State=true;
        			if(passwd2==passwd1){
        				$("#reg-passwd2-check").html("&#xe60c;").addClass("begreen");
        			    passwd2State=true;
        			}
        			else{
        				$("#reg-passwd2-check").html("&#xe60b;").removeClass("begreen");
        			passwd2State=false;
        			}
        		}
        		else{
        			$("#reg-passwd1-check").html("&#xe60b;").removeClass("begreen");
        			passwd1State=false;
        		}
        	}