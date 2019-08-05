<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GC Cafe</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/minty/bootstrap.min.css" />
<!-- Custom CSS goes below Bootstrap CSS -->
<link rel="stylesheet" href="/style.css" />
</head>
<body>
<p>Welcome to GC COFFEE Shop!</p>
<nav>
	<c:if test="${ empty user }">
		<p><a href="/login">Log in!</a></p>
		<p><a href="/signup">Sign up!</a></p>
	</c:if>
	<c:if test="${ not empty user }">
		Welcome ${ user.firstName }
		<p><a href="/products-list">Display our products</a></p>
		<p><a href="/logout">Log out!</a></p>
	</c:if>
</nav>
</body>
</html>