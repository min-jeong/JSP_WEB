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
	</tr>
	
	<tr>
		<td>${ movie.movieId }</td>
		<td>${ movie.title }</td>
		<td>${ movie.rate }</td>
		<td>${ movie.runningTime }</td>
		<td>${ movie.openDate }</td>
		<td>${ movie.gradeId }</td>
	</tr>
	
</table>
	
<table border=1>
	
	<c:forEach items="${ directors }" var="direc">
		<tr>
		<td> 감독명 : ${ direc.directorName } </td>
		</tr>
	</c:forEach>
	
	<c:forEach items="${ actors }" var="ac">
		<tr>
		<td> 배우명 : ${ ac.actorName } </td>
		</tr>
	</c:forEach>
	<c:forEach items="${ genres }" var="gen">
		<tr>
		<td> 장르 :  ${ gen.genreTitle }  </td>
		</tr>
	</c:forEach>
</table>	 


</body>
</html>