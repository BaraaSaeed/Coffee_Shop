<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Our products</title>
</head>
<body>

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
					<td><a href="/list_of_products?name=${product.name}">${product.name}</a></td>
					<td>${product.description}</td>
					<td>${product.price }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


<a href="/register">Register</a>
</body>
</html>