<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="database.*" import="beans.*" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review</title>

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
<%
	Parent p = (Parent) session.getAttribute("parent");
%>
<body>


	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 style="text-align: center;">User Review</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<table>
					<tr>
						<th>User Name</th>
						<th>Review Details</th>
						<th>Delete</th>
					</tr>
					<%
					List<Review> reviews = new ArrayList<Review>();
					UserDAO userDAO = new UserDAO();
					reviews = userDAO.getAllReviews();

					for (Review r : reviews) {
					%>
					<tr>
						<form method='post' action="../ProcessReview">
							<input type='hidden' name='reviewId' value='<%=r.getReviewId()%>' />
							<input type='hidden' name='admin' value='admin' />
							<td>
								<%
									out.print(userDAO.getParentNamebyId(r.getUserId()));
								%>
							</td>
							<td>
								<%
									out.print(r.getReviewText());
								%>
							</td>
							<td><button name='option' value="delete">Delete</button></td>
						</form>
					</tr>
					<%
						}
					%>
				</table>
			</div>
			<div class="col-md-4">
				<a href='AdminHome.jsp'><button>Back</button></a>
			</div>
		</div>
	</div>
</body>

</html>