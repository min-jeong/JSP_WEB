<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
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


	$(document).ready(function() {
		
		$("#userPw").keyup(function(e){
			if( e.keyCode == 13) {
				$("#btnLogin").click();
			}
		});
		
		$("#btnLogin").click(function() {
			
			var form = $("#loginForm");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/doLogin" />");
			form.submit();
			
		});
	
		$("#btnJoin").click(function() {
			
			location.href="<c:url value="/registerMember" />";
			
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
    		<form id="loginForm">
    			<img src="<c:url value="/resource/img/join_n.png" />" id="btnJoin" width="20px" height="50px" />
    			<img tabindex="3" src="<c:url value="/resource/img/login_btn.png" />" id="btnLogin" /> <!-- tabindex는 tab키를 누르면 옆칸으로 넘어가는 기능이다. -->
    			<input type="password" tabindex="2" id="userPw" name="userPw" placeholder="Password"> <!-- 순서번호를 줘서 tab을 누를 때마다 순서대로 넘어간다. -->
    			<input type="text" tabindex="1" id="userId" name="userId" placeholder="ID">
    		</form>
    	</div>
    	
    	<div class="clear"></div>
    	
    	
    	