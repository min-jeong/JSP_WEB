<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />


<div id="right_menu">
	<div id="calendar">
		<jsp:include page="/WEB-INF/view/calendar/calendar.jsp"></jsp:include>
	</div>
	<div id="chatbyMem">
		<jsp:include page="/WEB-INF/view/chat/chat_mem.jsp"></jsp:include>
	</div>
	<div id="chatbyKeyword">
		<jsp:include page="/WEB-INF/view/chat/chat_keyword.jsp"></jsp:include>
	</div>
</div>