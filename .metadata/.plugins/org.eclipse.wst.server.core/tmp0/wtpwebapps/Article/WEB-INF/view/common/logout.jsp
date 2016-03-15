<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready( function() {
	
	$("#btnLogout").click( function() {
		
		location.href="/logout";
		
	} );
	
} );
</script>

<c:set var="loginId" value="${ sessionScope._MEMBER_.memberId }" />
<div id=""></div>
	<div id="logout">

		<img src="/resource/img/logout_btn.png" id="btnLogout" />
		<b>${ loginId } 님 로그인 중...</b>
	
	</div>
	
	<div class="clear"></div>