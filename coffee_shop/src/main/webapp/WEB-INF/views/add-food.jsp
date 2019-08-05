<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add A Product</title>
</head>
<body>
<nav>Welcome ${ user.firstName }!</nav>
<h3>Please add the product!</h3>

<form  method="post">
		<p>Product Name:	<input	type="text"		name="name"				required/> </p>
		<p>Description:		<input	type="text"		name="description"		required/> </p>
		<p>Price:			<input	type="number"	name="price"			required/> </p>
		<button type="submit">Add</button>
		<a href="/products-list">Cancel</a>
</form>
</body>
</html>