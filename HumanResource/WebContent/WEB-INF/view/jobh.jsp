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

<table>
	<tr>
		<th>EMPLOYEE_ID</th>
		<th>START_DATE</th>
		<th>END_DATE</th>
		<th>JOB_ID</th>
		<th>DEPARTMENT_ID</th>
	</tr>
<c:forEach items="${ allJobHistory }" var="emp">
<tr>
	<td> ${ emp.employeeId } </td>
	<td> ${ emp.startDate } </td>
	<td> ${ emp.endDate }</td>
	<td> ${ emp.jobId }</td>
	<td> ${ emp.departmentId } </td>
</tr>
</c:forEach>
</table>

</body>
</html>