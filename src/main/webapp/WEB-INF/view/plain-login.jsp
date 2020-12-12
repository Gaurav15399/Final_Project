<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Login Page


</title>

<style>
	.failed{
		color:red;
	}

</style>
</head>
<body>
	<h3>My Custom Login Page</h3>
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">

		<!-- CHeck for error param -->

		<c:if test="${param.error!=null }">
			<b><i class="failed">Invalid Username Password</i></b>
		</c:if>
		
		<c:if test="${param.logout!=null }">
			<b><i class="failed">You have logged out</i></b>
		</c:if>
		<p>
			User name: <input type="text" name="username" />
		<p>

			Password: <input type="password" name="password" />
		<p>
			<input type="submit" value="login" />
	</form:form>

</body>
</html>