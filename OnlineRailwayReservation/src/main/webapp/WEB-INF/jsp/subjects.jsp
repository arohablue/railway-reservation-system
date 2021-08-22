<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subjects</title>
</head>
<body>
	Hello, ${cust.name} <hr/>
	<form method="post" action="books">
		<c:forEach var="sub" items="${subjectList}">
			<input type="radio" name="subject" value="${sub}"/> ${sub} <br/>
		</c:forEach>
		<input type="submit" value="Show Books"/>
		<a href="showcart">Show Cart</a>
	</form>
	
	
</body>
</html>

