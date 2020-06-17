<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
<c:forEach items="${empList}" var="emp">
<tr>
<td>${emp.bookId}</td>
<td> ${emp.namebook} </td>
<td> ${emp.serial} </td>
<td> ${emp.author} </td>
<td> ${emp.catagory} </td>
<td><a href="editEmp.do?id=${emp.bookId}">Edit</a></td>
<td><a
href="deleteEmp.do?id=${emp.bookId}">Remove</a></td>
</tr>
</c:forEach>
</table>
<a href="newEmp.do">Add New Employee</a>
</body>
</html>