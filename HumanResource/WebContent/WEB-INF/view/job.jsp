<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- JOBS -->
<table>
	<tr>
		<th>JOB_ID</th>
		<th>JOB_TITLE</th>
		<th>MIN_SALARY</th>
		<th>MAX_SALARY</th>
    </tr>

<c:forEach items="${ allJobs }" var="emp">
	<tr>
		<td>${ emp.jobId }</td>
		<td>${ emp.jobTitle }</td>
		<td>${ emp.minSalary }</td>
		<td>${ emp.maxSalary }</td>
	</tr>	
</c:forEach>
</table>

</body>
</html>