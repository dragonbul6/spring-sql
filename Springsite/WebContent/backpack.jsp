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
<H1>This is backpack </H1>
<c:forEach items="${showList}" var="bp">
	<table id="table-1" border="1">
		<thead>
			<tr>
				<th>ID of book in Backpack </th>
				<th>Name of Book</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${bp.bookId}</td>
				<td> ${bp.bookName} </td>
				<td><a href = "delete.do?id=${bp.bookId }" >Delete</a></td>
			</tr>
		</tbody>	
	</table>

	<form id="form-1" action = "rent.do" method="post">
	<input type = "hidden" name = "idusr" value="${bp.member.memberId }">
	<input type = "hidden" name = "idbk" value = "${bp.bookId }">
	<input type="submit" value="Rent" id="button-1"/>
	</form>

</c:forEach>


<a href="login.jsp">logout </a>
</body>
</html>