<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	$(document).ready(function() {
		
		$("#btnLogin").click(function() {

			var form = $("#loginForm");
			form.attr("method", "POST");
			form.attr("action", "/doLogin");
			
			form.submit();
			
		});
		
		$("#join").click(function() {
			location.href = "/addMember";
		})
		
	});
</script>    

    	<div id="login">	
    	
    		<form id="loginForm">
    			<img src="/resource/img/login.png" id="btnLogin" />
    			<input type="password" id="userPw" name="userPw" placeholder="Password">
    			<input type="text" id="userId" name="userId" placeholder="ID">
    		</form>
    			
    	</div>
    	<br/>
    	<input type="button" id="join" value="회원가입" />
    	<div class="clear"></div>