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
	
	<c:forEach items="${showList}" var="bp">
	<table id="table-1" border="1">
		<thead>
			<tr>
				<th>Order of Backpack</th>
				<th>Due Date</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${bp.backpack.bookId }</td>
				<td> ${bp.date} </td>
				<td><a href = "extend.do?id=${bp.rentId }">Extend due date</a></td>
			
			
			</tr>
		</tbody>	
	</table>
	</c:forEach>
	<a href= "login.jsp">Index</a>
</body>
</html>