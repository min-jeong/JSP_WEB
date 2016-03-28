<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />


<div id="left_menu">
	<div id="profile">
		<jsp:include page="/WEB-INF/view/view/profile.jsp"></jsp:include>
	</div>
	<div id="team_menu">
		<jsp:include page="/WEB-INF/view/view/team_menu.jsp"></jsp:include>
	</div>
	<div id="mine">
		<jsp:include page="/WEB-INF/view/member/mine.jsp"></jsp:include>
	</div>
</div>