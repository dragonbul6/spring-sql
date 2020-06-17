<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booklist</title>
</head>
<body>

<form action = "viewproge.do">
	<input type="hidden" name="genre" value="Novel" />
	<input type="submit" value="Novel" id="button-1"/>
</form>

<form action = "viewproge.do">
	<input type="hidden" name="genre" value="Education" />
	<input type="submit" value="Education" id="button-2"/>
</form>

<form action = "viewproge.do">
	<input type="hidden" name="genre" value="IT" />
	<input type="submit" value="IT" id="button-3"/>
</form>



<c:forEach items="${booklist}" var="emp">
	<table id="table-1" border="1">
	
		<thead>
			<tr>
				<th>Name of Book</th>
				<th>Serial Number</th>
				<th>Author </th>
				<th>Category </th>
				<th> Function </th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td> ${emp.namebook} </td>
				<td> ${emp.serial} </td>
				<td> ${emp.author} </td>
				<td> ${emp.catagory} </td>
				<td><a href = "addbook.do?idbook=${emp.bookId}">Add to backpack</a></td>
			</tr>
		</tbody>
		
	</table>

</c:forEach>
	
</body>
</html>