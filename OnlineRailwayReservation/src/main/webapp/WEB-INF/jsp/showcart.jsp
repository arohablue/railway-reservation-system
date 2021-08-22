<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Author</th>
				<th>Subject</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="b" items="${bookList}">
				<tr>
					<td>${b.id}</td>
					<td>${b.name}</td>
					<td>${b.author}</td>
					<td>${b.subject}</td>
					<td>${b.price}</td>
				</tr>					
			</c:forEach>
		</tbody>
	</table>

	<a href="logout">Sign Out</a>
</body>
</html>

