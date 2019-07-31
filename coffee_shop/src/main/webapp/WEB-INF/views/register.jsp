<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<h3>Please fill the form to register!</h3>

<form action="register" method="post">
		<p>First Name:	<input	type="text"			name="firstName"	required/> </p>
		<p>Last Name:	<input	type="text"			name="lastName"		required/> </p>
		<p>Phone Number:<input	type="text"			name="phoneNumber"	required/> </p>
		<p>Email:		<input	type="email"		name="email" 		required
          				placeholder="username@grandcircus.com" pattern=".+@.+"
          				title="Please provide only a Best Startup Ever corporate e-mail address"/> </p>
		<p>Password:	<input	type="password"		name="password" required/> </p>
		<p><button type="submit">Register</button></p>
</form>
</body>
</html>