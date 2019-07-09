<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "beans.*" import = "database.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Child</title>

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
		if(session.getAttribute("registerError") != null){
			out.print("<span style='color:red'>" + (String) session.getAttribute("registerError") + "</span>");
		}
		UserDAO userDAO = new UserDAO();
		String childId = (String) session.getAttribute("childIdEditChild");
		Child c = userDAO.getChildById(Integer.valueOf(childId));
	%>
	<div class="container register">
		<h3 style="text-align: center">Edit Child Information</h3>
		<form method="post" action="../ProcessEditChildByParent">
			<div class="row">
				<div class="col-md-6">
					<div>
						First Name* <input type="text" class="form-control" value="<%=c.getFirstName() %>"
							name="firstName" />
					</div>
					<div>
						Last Name* <input type="text" class="form-control" value="<%=c.getLastName() %>"
							name="lastName" />
					</div>
					<div>
						Password* <input type="password" class="form-control" value="<%=c.getPassword() %>"
							name="password" />
					</div>
					<div>
						Email* <input type="email" name="email" class="form-control" value="<%=c.getEmail() %>"/>
					</div>
				</div>
				<div class="col-md-6">
					<div>
						Phone* <input type="tel" class="form-control" value="<%=c.getPhone() %>"
							 name="phone">
					</div>
					<div>
						Address * <input type="text" class="form-control" value="<%=c.getAddress() %>"
							name="address" />
					</div>

					<div>
						Date of Birth* <input type="date" class="form-control"
							placeholder="Date of Birth *" value="<%=c.getBirthdate() %>" name="birthdate" />
					</div>

					<div>
						Gender*
						<div class="maxl">
							<%
								if(c.getGender().equals("male")){
									out.print("<label class='radio inline'><input type='radio' name='gender' value='male' checked>");
								}
								else{
									out.print("<label class='radio inline'><input type='radio' name='gender' value='male'>");
								}
							%>
								<span> Male </span></label>
							<%
								if(c.getGender().equals("female")){
									out.print("<label class='radio inline'><input type='radio' name='gender' value='female' checked>");
								}
								else{
									out.print("<label class='radio inline'><input type='radio' name='gender' value='female'>");
								}
							%>
								<span>Female </span></label>
						</div>
					</div>
				</div>

			</div>
			<div class="row">
				<div class="col-md-4">
					<button name="register" value="Register">Register</button>
				</div>

				<div class="col-md-4">
					<a href='../LogOut'><button>Back</button></a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
