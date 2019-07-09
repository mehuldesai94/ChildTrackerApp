<%@page import="beans.Parent"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Successful</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
	<%
		Parent user = (Parent) session.getAttribute("user");
	%>

	<div class="container">
		<div class="row text-center">
			<div class="col-sm-6 col-sm-offset-3">
				<br> <br>
				<h2 style="color: #0fad00">Success</h2>
				<h3>Dear, <%= user.getFirstName() + " " + user.getLastName() %></h3>
				<p style="font-size: 20px; color: #5C5C5C;">Thank you for
					registering  to Child Tracker Application. Please go to login and with the credential enjoy Applications features.</p>
				<a href="Login.jsp" class="btn btn-success">     Log in     </a> <br> <br>
			</div>

		</div>
	</div>
</body>
</html>




<!------ Include the above in your HEAD tag ---------->

