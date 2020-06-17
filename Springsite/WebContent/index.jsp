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
<c:forEach items="${ListMember}" var="member">

<h1>Hello ${member.name }</h1>

<a href="view.do?id=${member.memberId }">View Book</a>
<a href="bpindex.do?id=${member.memberId }">Backpack</a>
<a href="history.do?id=${member.memberId }">History</a>
</c:forEach>
</body>
</html>