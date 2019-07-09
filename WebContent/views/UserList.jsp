<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="database.UserDAO" import="java.util.*" import="beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users List</title>

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
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background-color: #f5f5f5;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 5px 5px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	height: 100%;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}
</style>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 style="text-align: center;">Users Basic Information</h2>

			</div>



		</div>

		<div class="row">
			<div class="col-md-12" style="text-align: center; padding-top: 10px;">
				<h3>Parent's Details</h3>

			</div>
			<div class="col-md-12">
				<table>
					<tr>

						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
					<%
						UserDAO userDAO = new UserDAO();
						List<Parent> parents = new ArrayList<Parent>();
						parents = userDAO.getAllParents();
						for (Parent p : parents) {
					%>
					<tr>
						<form method='post' action="../ProcessParent">
							<input type='hidden' name='parentId' value='<%=p.getId()%>' />
							<td>
								<%
									out.print(p.getFirstName());
								%>
							</td>
							<td>
								<%
									out.print(p.getLastName());
								%>
							</td>
							<td>
								<%
									out.print(p.getEmail());
								%>
							</td>
							<td><button name='option' value="edit">Edit</button></td>
							<td><button name='option' value="delete">Delete</button></td>
						</form>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12" style="text-align: center; padding-top: 10px;">
				<h3>Child's Details</h3>
			</div>
			<div class="col-md-12">
				<table>
					<tr>
						<th>Parent Name</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
					<%
						for (Parent p : parents) {
							List<Child> children = userDAO.getChildByParentId(p.getId());
							for (Child c : children) {
					%>
					<tr>
						<form method='post' action='../ProcessChild'>
							<input type='hidden' name='parentId' value='<%=p.getId()%>' /> <input
								type='hidden' name='childId' value='<%=c.getId()%>' />
							<td>
								<%
									out.print(p.getFirstName() + " " + p.getLastName());
								%>
							</td>
							<td>
								<%
									out.print(c.getLastName());
								%>
							</td>
							<td>
								<%
									out.print(c.getLastName());
								%>
							</td>
							<td>
								<%
									out.print(c.getEmail());
								%>
							</td>
							<td><button name='option' value="edit">Edit</button></td>
							<td><button name='option' value="delete">Delete</button></td>
						</form>
					</tr>
					<%
						}
						}
					%>
				</table>
			</div>
		</div>
		<hr>
		<div class="row" style="padding-top: 10px;">
			<div class="col-md-4 offset-md-4">
				<a href='../LogOut'><button>Logout</button></a>
			</div>
			<div class="col-md-4">
				<a href='AdminHome.jsp'><button>Back</button></a>
			</div>
		</div>

	</div>

</body>
</html>

