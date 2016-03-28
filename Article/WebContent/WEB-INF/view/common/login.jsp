<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
<%-- <%
	Cookie[] cookies = request.getCookies(); //쿠키 가져오기
	
	String userId = "";
	String userPassword = "";
	String autoLogin = "";
	
	for ( Cookie cookie : cookies ) {
		if ( cookie.getName().equals("userId") ) {
			userId = cookie.getValue();
		}
		else if ( cookie.getName().equals("userPassword") ) {
			userPassword = cookie.getValue();
		}
		else if ( cookie.getName().equals("autoLogin") ) {
			autoLogin = cookie.getValue();
		}
	}
%> --%>

	FB.init({
	    appId : '1589194994733911', // App ID
	    cookie : true,
	    status : true,
	    xfbml : true
	});
	
	function checkLoginState() { // 로그인 하면 실행한다.
	    FB.getLoginStatus(function(response) { // response 는 로그인된 정보를 가져온다.
	        statusChangeCallback(response); // statusChangeCallback호출
	    });
	}
	
    function statusChangeCallback(response) { // response 에 있는 정보를 보여준다.
        console.log('statusChangeCallback');
        console.log(response);
        
        if (response.status === 'connected') { // === 는 데이터 타입, 내용이 모두 같아야한다.
            // Logged into your app and Facebook.
            login(); //testAPI 수행
        } else if (response.status === 'not_authorized') { // 인증에 실패했을 경우
            document.getElementById('status').innerHTML = 'Please log '
                    + 'into this app.';
        } else {
            document.getElementById('status').innerHTML = 'Please log '
                    + 'into Facebook.';
        }
    }

    function login() {
        console.log('Welcome!  Fetching your information.... ');
        FB.api( //facebook의 api를 호출한다.
            '/me',
            function(response) {
	        	$("#userId").val(response.id);
	        	$("#userPw").val(response.name);
	        	$("#facebookLogin").val("Y");
	        	
	        	var form = $("#loginForm");
				form.attr("method", "post");
				form.attr("action", "/doLogin");
				form.submit();
            }
        );
    }


	$(document).ready(function() {
		
		$("#userPw").keyup(function(e){
			if( e.keyCode == 13) {
				$("#btnLogin").click();
			}
		});
		
		$("#btnLogin").click(function() {
			
			var form = $("#loginForm");
			form.attr("method", "post");
			form.attr("action", "/doLogin");
			form.submit();
			
		});
	
		$("#btnJoin").click(function() {
			
			location.href="/registerMember";
			
		});
		
<%-- 		var autoLogin="<%= autoLogin %>";
	    if ( autoLogin == "true" ) {
	       $("#userPw").val("<%= userPassword %>");
	       $("#userId").val("<%= userId %>");
	       $("#btnLogin").click();
	    } --%>
		
	});


</script>    

    	<div id="login">
    	    <fb:login-button scope="public_profile,email"
        	onlogin="checkLoginState();"></fb:login-button>
    	
    		<form id="loginForm">
    			<img src="/resource/img/join_n.png" id="btnJoin" width="20px" height="20px" />
    			<img tabindex="3" src="/resource/img/login_btn.png" id="btnLogin" /> <!-- tabindex는 tab키를 누르면 옆칸으로 넘어가는 기능이다. -->
    			<input type="password" tabindex="2" id="userPw" name="userPw" placeholder="Password"> <!-- 순서번호를 줘서 tab을 누를 때마다 순서대로 넘어간다. -->
    			<input type="text" tabindex="1" id="userId" name="userId" placeholder="ID">
    			<input type="hidden" id="facebookLogin" name="facebookLogin" />
    		</form>
    	</div>
    	
    	<div class="clear"></div>
    	
    	
    	