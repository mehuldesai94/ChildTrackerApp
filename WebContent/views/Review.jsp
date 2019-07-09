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

<style type="text/css">
body {
	margin: 25px;
	background-color: #D3D3D3;
}

* {
	box-sizing: border-box;
}
/* Button used to open the chat form - fixed at the bottom of the page */
.open-button {
	background-color: #555;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	opacity: 0.8;
	position: fixed;
	bottom: 23px;
	right: 28px;
	width: 280px;
}
/* The popup chat - hidden by default */
.chat-popup {
	width: 100%;
	bottom: 0;
	right: 15px;
	border: 3px solid #f1f1f1;
	z-index: 9;
}

/* Add styles to the form container */
.form-container {
	width: 100%;
	padding: 10px;
	background-color: white;
}

/* Full-width textarea */
.form-container textarea {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	border: none;
	background: #f1f1f1;
	resize: none;
	min-height: 200px;
}

/* When the textarea gets focus, do something */
.form-container textarea:focus {
	background-color: #ddd;
	outline: none;
}

/* Set a style for the submit/send button */
.form-container .btn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	width: 100%;
	margin-bottom: 10px;
	opacity: 0.8;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
	opacity: 1;
}

div.postMessage {
	width: 50%;
	background-color: white;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	margin-bottom: 25px;
}

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
	<%
		if (session.getAttribute("emptyReview") != null) {
			out.print("<span style='color:red'>" + (String) session.getAttribute("emptyReview") + "</span>");
		}
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 style="text-align: center;">Review Wall</h2>
			</div>
		</div>

		<div class="chat-popup" id="myForm">
			<form method="post" action="../ProcessReview" class="form-container">
				<label for="msg"><h3 style="text-align: center;">New
						Review</h3></label>
				<textarea placeholder="Type message.." name="review"></textarea>
				<%
					out.print("<input type='hidden' name='parentId' value='" + p.getId() + "'/>");
				%>
				<button type="submit" class="btn" name="option" value="submit">Submit</button>
			</form>
		</div>

		<div class="row" style="padding-top: 25px">

			<div class="col-md-12">
				<h2 style="text-align: center;">All Reviews:</h2>
			</div>


			<div class="col-md-12">
				<table>
					<tr>

						<th>User Name</th>
						<th>Review</th>
						<th>Delete</th>
					</tr>
					<%
						List<Review> reviews = new ArrayList<Review>();
						UserDAO userDAO = new UserDAO();
						reviews = userDAO.getAllReviews();

						for (Review r : reviews) {
					%>
					<tr>
						<form method='post' action='../ProcessReview'>
							<input type='hidden' name='parentId' value='<%=p.getId()%>' />
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
							<%
								if (r.getUserId() == p.getId()) {
							%>
							<td>
								<button name='option' value="delete">Delete</button> <input
								type='hidden' name='reviewId' value='<%=r.getReviewId()%>' />
							</td>
							<%
								} else {
							%>
							<td><label>By Other</label></td>
							<%
								}
							%>
						</form>
					</tr>
					<%
						}
					%>
				</table>
			</div>
			<div class="col-md-4">
				<a href='ParentHome.jsp'><button>Back</button></a>
			</div>
		</div>
	</div>


</body>

</html>