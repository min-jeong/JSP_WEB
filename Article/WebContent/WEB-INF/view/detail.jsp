<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resource/js/jquery-1.12.1.js"></script>
<script type="text/javascript">
	 $(document).ready( function() {
		 $("#recommendCount").click( function() {
			location.href = "/update?articleId=" + ${ article.articleId };	 	
		 })
		 
		 $("#back").click( function() {
			 location.href = "/list";
		 })
		 
 		$("#modify").click( function() {
 			
 			location.href="/modify?articleId=" + ${ article.articleId };
 			
		}); 
	 })
	 
	 
 
</script>
</head>
<body>
<table border=1 width=700px>
	<tr>
		<th>ARTICLE_ID</th>
		<th>TITLE</th>
		<th>NICK NAME</th>
		<th>MEMBER ID</th>
		<th>DESCRIPT</th>
		<th>HITS</th>
		<th>RECOMMEDS</th>
	</tr>
	
	<tr>
		<td id="c" name="articleId">${ article.articleId }</td>
		<td>${ article.title }</td>
		<td>${ article.nickName }</td>
		<td>${ article.memberId }</td>
		<td>${ article.descript }</td>
		<td id="c">${ article.hits }</td>
		<td id="c">${ article.recommends }</td>
	</tr>
</table>
<input type ="button" id="recommendCount" value="추천" />
<input type ="button" id="back" value="목록" />

<!-- memberBiz의 로그인한 멤버를 꺼내올 수 있다. -->
${ sessionScope._MEMBER_.memberId }
${ sessionScope._MEMBER_.nickName }
${ sessionScope._MEMBER_.password }
${ sessionScope._MEMBER_.email }

<c:set var="loginId" value="${ sessionScope._MEMBER_.memberId }" />
${ loginId }

<c:if test="${ loginId eq article.memberId }">
<a href="/delete?articleId=${ article.articleId }"> 삭제 </a>
<input type="button" id="modify" value="수정" />
</c:if>
</body>
</html>