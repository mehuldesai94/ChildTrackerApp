<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="beans.*" import="database.*" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Parent Home</title>
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
table {frame ="box" width:100%;
	
}

th, td {
	padding: 8px;
	text-align: center;
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
<%
	Parent p = (Parent) session.getAttribute("parent");
	UserDAO userDAO = new UserDAO();
	List<Child> children = new ArrayList<Child>();
	children = userDAO.getChildByParentId(p.getId());
%>

<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 style="text-align: center;">
					Welcome
					<%=p.getFirstName() + " " + p.getLastName()%></h2>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12" style="text-align: center; padding-top: 15px;">
				<h4>Child list</h4>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<table style="width: 100%">
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Edit</th>
						<th>Delete</th>
						<th>Chat</th>
						<th>Track</th>
					</tr>
					<%
						for (Child c : children) {
					%>
					<tr>
						<form method='post' action="../ProcessChildByParent">
							<input type='hidden' name='parentId' value='<%=p.getId()%>' /> <input
								type='hidden' name='childId' value='<%=c.getId()%>' />
							<td>
								<%
									out.print(c.getFirstName());
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

						<%
							String key = "childChat" + c.getId();
								if (application.getAttribute(key) != null) {
						%>

						<td>
							<form action='parentChat.jsp' method='get'>
								<button name='chat' value="chat">Chat</button>
								<input type='hidden' name='childId' value='<%=c.getId()%>' />
							</form>
						</td>
						<%
							} else {
						%>
						<td><label>NA</label></td>
						<%
							}
						%>
						<%
							if (userDAO.getLocationByChildId(c.getId()) != null) {
									Location location = userDAO.getLocationByChildId(c.getId());
									String URL = "http://www.openstreetmap.org/?mlat=" + location.getLatitude() + "&mlon="
											+ location.getLongitude() + "&zoom=16";
						%>
						<td>
							
							<%out.print("<button onclick='window.open(\""+URL+"\")'>Track</button>"); %>
						</td>
						<%
							} else {
						%>
						<td><label>NA</label></td>
						<%
							}
						%>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>

		<hr style="padding-top: 25px" />
		<div class="row">
			<div class="col-md-4">
				<a href='RegisterChild.jsp'><button>Register child</button></a>
			</div>
			<div class="col-md-4">
				<a href='Review.jsp'><button>Review</button></a>
			</div>
			<div class="col-md-4">
				<a href='../LogOut'><button>Logout</button></a>
			</div>
		</div>
	</div>
</body>
</html>