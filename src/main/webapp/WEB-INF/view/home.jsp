<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h2>Welcome to home page</h2>



<p>
<!-- DISPLAY USERNAME AND ROLE -->
	User: <security:authentication property="principal.username"/>
<br>
	Role: <security:authentication property="principal.authorities"/>
<br>

<security:authorize access="hasRole('MANAGER')">
<!-- Link for leaders which is only for managers -->

<a href="${pageContext.request.contextPath}/leaders"> Leadership Meeting</a>

<br>

</security:authorize>

<security:authorize access="hasRole('ADMIN')">
<!-- Link for systems which is only for admins-->

<a href="${pageContext.request.contextPath}/systems"> Systems Meeting</a>
</security:authorize>

<p>

<p>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="logout"/>



</form:form>
</body>
</html>