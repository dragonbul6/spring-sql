<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" action="saveEmp.do" commandName="book">
<form:hidden path="bookId" /><br/>
Name of Book : <form:input path="namebook" /><br/>
Author : <form:input path="author"/><br/>
Serial: <form:input path="serial"/><br/>
Genre: <form:input path ="catagory"/><br/>
<input type="submit" value="Save" />
</form:form>
</body>
</html>