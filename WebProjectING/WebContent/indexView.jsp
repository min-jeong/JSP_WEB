<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	아아아아아아

	<div class="dd" id="domenu">
		<li class="dd-item-blueprint">
			<div class="dd-handle dd3-handle">Drag</div>
			<div class="dd3-content">
				<span>[item_name]</span>
				<button class="item-remove">&times;</button>
					<div class="dd-edit-box" style="display: none;">
						가나다라마바사
						<c:forEach var="index" items="${ indexs }">
							<c:out value="${ index.memName }" />
						</c:forEach>
						<i>&#x270e;</i>
					</div>
				</div>
			</li>
			<ol class="dd-list">
			</ol>
		</div>

</body>
</html>