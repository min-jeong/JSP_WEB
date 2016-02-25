<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border=1 >
	<tr>
		<th>MOVIE_ID</th>
		<th>TITLE</th>
		<th>RATE</th>
		<th>RUNNING_TIME</th>
		<th>OPEN_DATE</th>
		<th>GRADE_ID</th>
		<th>GRADE_TITLE</th>
	</tr>
	
<c:forEach items="${ allMovies }" var="movie">
	<tr>
		<td>${ movie.movieId }</td>
		<td><!-- ?는 파라미터를 전달시키는것 -->
			<a href="/HumanResource/detail?movieId=${ movie.movieId }">${ movie.title }</a>(${ movie.actorCount })</td>
		<td>${ movie.rate }</td>
		<td>${ movie.runningTime }</td>
		<td>${ movie.openDate }</td>
		<td>${ movie.gradeId }</td>
		<td>${ movie.gradeTitle }</td>
	</tr>
</c:forEach>
</table>


</body>
</html>