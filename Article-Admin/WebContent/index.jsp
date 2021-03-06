<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="loginId" value="${ sessionScope._MEMBER_.memberId }" />

<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<c:choose>
	<c:when test="${ empty loginId }">
		<jsp:include page="/WEB-INF/view/common/login.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>
	</c:otherwise>
</c:choose>

