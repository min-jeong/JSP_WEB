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
<!--  Departments -->
<table>
	<tr>
		<th>DEPARTMENT_ID</th>
		<th>DEPARTMENT_NAME</th>
		<th>MANAGER_ID</th>
		<th>LOCATION_ID</th>	
    </tr>


<c:forEach items="${ allDepartments }" var="emp">
	<tr>
		<td>${ emp.departmentId }</td>
		<td>${ emp.departmentName }</td>
		<td>${ emp.managerId }</td>
		<td>${ emp.locationId }</td>
	</tr>	
</c:forEach>
</table>


</body>
</html>