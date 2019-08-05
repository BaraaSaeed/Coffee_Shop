<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update A Product</title>
</head>
<body>
<nav>Welcome ${ user.firstName }!</nav>
<h3>Please edit the product!</h3>

<form  method="post">
		<input type="hidden" name="id" value="${food.id}" />
		<p>Product Name:	<input	type="text"		name="name"			value="${product.name}"			required/> </p>
		<p>Description:		<input	type="text"		name="description"	value="${product.description}"	required/> </p>
		<p>Price:			<input	type="number"	name="price"		value="${product.price}"		required/> </p>
		<button type="submit">Apply</button>
		<a href="/products-list" class="btn btn-link">Cancel</a>
</form>
</body>
</html>