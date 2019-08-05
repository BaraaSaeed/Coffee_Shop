<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Our products</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/minty/bootstrap.min.css" />
<!-- Custom CSS goes below Bootstrap CSS -->
<link rel="stylesheet" href="/style.css" />
</head>
<body>
<nav>Welcome ${ user.firstName }!</nav>
<div class="container">
		<h1>Products of Grand Circus Cafe</h1>
		<table class="table" border="2" cellpadding="7">
			<thead>
				<tr>
					<th>Name</th><th>Description</th><th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${listOfProducts}">
				<tr>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price }</td>
					<td>
						<a  href="/edit-food?id=${ product.id }">Edit</a>
						<a  href="/delete-food?id=${ product.id }">Delete</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>
		<a href="/add-product">Add a new product</a>
		</p>
	</div>


<a href="/">Home</a>
</body>
</html>