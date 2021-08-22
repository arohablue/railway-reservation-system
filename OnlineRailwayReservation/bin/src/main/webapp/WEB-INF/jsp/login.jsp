<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="/css/site.css"/>

</head>
<body>
	<h2><s:message code="app.title" text="####"/></h2>
	<sf:form modelAttribute="cred" method="post" action="authenticate">
		<table>
			<tr>	
				<td><s:message code="email.label" text="####"/>:</td>
				<td><sf:input path="email"/></td>
				<td><sf:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>	
				<td><s:message code="password.label" text="####"/>:</td>
				<td><sf:password path="password"/></td>
				<td><sf:errors path="password" cssClass="error"/></td>
			</tr>
			<tr>	
				<td colspan="2">
					<input type="submit" value="<s:message code="signin.label" text="####"/>"/>
					<a href="register"><s:message code="signup.label" text="####"/></a>
				</td>
			</tr>
		</table>
		<%--
		<sf:errors path="*"/>
		--%>
	</sf:form>
</body>
</html>

