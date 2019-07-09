<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="database.UserDAO" import="java.util.*" import="beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>

<!--Bootsrap 4 CDN-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<!--Fontawesome CDN-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<style>
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: #D3D3D3;
}

form {
	border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>
<body>

	<%
		Admin admin = (Admin) session.getAttribute("admin");
		String fname = admin.getFirstName();
		String lname = admin.getLastName();
		String password = admin.getPassword();
		String address = admin.getAddress();
		String dob = admin.getBirthdate();
		String email = admin.getEmail();
		String phone = admin.getPhone();
	%>


	<div class="container register">
		<h3 style="text-align: center">Basic Information</h3>
		<div class="row">
			<div class="col-md-6">

				<div>
					First Name <input type="text" id="fname" name="firstname"
						value="<%=fname%>">
				</div>
				<div>
					Last Name <input type="text" id="lname" name="lastname"
						value="<%=lname%>">
				</div>
				<div>
					Password <input type="text" id="password" name="password"
						value="<%=password%>">
				</div>
				<div>
					Email <input type="text" id="email" name="email" value="<%=email%>">
				</div>
			</div>
			<div class="col-md-6">
				<div>
					Phone <input type="text" id="phone" name="phone" value="<%=phone%>">
				</div>
				<div>
					Address <input type="text" id="address" name="address"
						value="<%=address%>">
				</div>

				<div>
					BirthDate <input type="text" id="dob" name="dob" value="<%=dob%>">
				</div>

				<div>
					Address <input type="text" id="lname" name="firstname"
						value="<%=lname%>">
				</div>

			</div>
			
		</div>
		<div class="row">
				<div class="col-md-4">
					<a href='UserList.jsp'><button>Users</button></a>
				</div>
				<div class="col-md-4">
					<a href='AdminReview.jsp'><button>Reviews</button></a>
				</div>
				<div class="col-md-4">
					<a href='../LogOut'><button>Logout</button></a>
				</div>
			</div>
	</div>
</body>
</html>
