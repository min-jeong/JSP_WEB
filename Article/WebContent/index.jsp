<%@page import="com.ktds.jmj.history.vo.OperationHistoryVO"%>
<%@page import="com.ktds.jmj.history.vo.ActionCode"%>
<%@page import="com.ktds.jmj.history.vo.BuildDescription"%>
<%@page import="com.ktds.jmj.history.vo.Description"%>
<%@page import="com.ktds.jmj.history.biz.OperationHistoryBiz"%>
<%@page import="com.ktds.jmj.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
	if ( member != null) {
		
		OperationHistoryVO historyVO = new OperationHistoryVO();
		
		historyVO.setIp(request.getRemoteHost());
		historyVO.setMemberId(member.getMemberId());
		historyVO.setUrl(request.getRequestURI());
		historyVO.setActionCode(ActionCode.LOGIN);
		historyVO.setDescription( BuildDescription
								.get( Description.ALREADY_LOGIN, member.getMemberId() ) );
		OperationHistoryBiz biz = new OperationHistoryBiz();
		
		biz.addHistory(historyVO);
		response.sendRedirect("/list");
		return;
	}
	

	OperationHistoryVO historyVO = new OperationHistoryVO();
	
	historyVO.setIp(request.getRemoteHost());
	historyVO.setMemberId("");
	historyVO.setUrl(request.getRequestURI());
	historyVO.setActionCode(ActionCode.LOGIN);
	historyVO.setDescription( BuildDescription
							.get( Description.VISIT_LOGIN_PAGE, request.getRemoteHost() ) );
	
	OperationHistoryBiz biz = new OperationHistoryBiz();
	biz.addHistory(historyVO);
	
%>

<script src="http://connect.facebook.net/en_US/all.js"></script>

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

