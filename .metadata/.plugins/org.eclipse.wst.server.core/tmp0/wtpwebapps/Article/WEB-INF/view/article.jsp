<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
#c { text-align: center; }

</style>

</head>
<body>
<table border=1 width=700px>
	<tr>
		<th>ARTICLE_ID</th>
		<th>TITLE</th>
		<th>NICK NAME</th>
		<th>HITS</th>
		<th>RECOMMEDS</th>
	</tr>
	
<c:forEach items="${ articlelist }" var="article">
	<tr>
		<td class="c">${ article.articleId }</td>
		<td>
		<a href="/count?articleId=${ article.articleId }">${ article.title }</a></td>
		<td>${ article.nickName }</td>
		<td class="c">${ article.hits }</td>
		<td class="c">${ article.recommends }</td>
	</tr>
 </c:forEach>

</table>
<a href ="/write">글쓰기</a>
<a href ="/logout">로그아웃</a>
</body>
</html>