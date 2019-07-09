<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chat</title>

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
	height: 25%;
	bottom: 0;
	right: 15px;
	border: 3px solid #f1f1f1;
	z-index: 9;
	bottom: 0;
}

.chat-popup1 {
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

<%
	Child c = (Child) session.getAttribute("child");
	String key = "parentChat" + c.getParentId();

	Parent p = (Parent) application.getAttribute(key);
	String parent = p.getFirstName();
	String child = c.getFirstName();
%>

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 style="text-align: center;">Chat Page</h2>
			</div>
		</div>

		<form action="../Chat" method="post">
			<input type="hidden" name="sender" value="<%=child%>" /> <input
				id="parentId" type="hidden" name="parent" value="<%=parent%>" /> <input
				id="childId" type="hidden" name="child" value="<%=child%>" />
			<div class="row">
				<div class="col-md-12">
					<label style="vertical-align: top;">Chat Box</label>
					<textarea class="chat-popup1" id="messages" row="50" col="50"
						style="width: 100%; height: 200px;" disabled="disabled">
					</textarea>
				</div>
			</div>
			<hr style="padding-top: 10px;"/>
			<div class="row" style="vertical-align: middle;">
				<div class="col-md-8">
					<input type="text" name="newMessage" style="width: 100%"
						placeholder="type new message ..." />
				</div>
				<div class="col-md-2 offset-md-2">
					<button name="send" value="send">Send</button>
				</div>
			</div>

		</form>

		<hr style="padding-top: 25px" />
		<div class="row">
			<div class="col-md-4 ">
				<a href='../LogOut'><button>Logout</button></a>
			</div>
			<div class="col-md-4">
				<a href='ChildHome.jsp'><button>Home</button></a>
			</div>
		</div>

	</div>

	<!-- Latest compiled and minified jQuery 3.2.1 JavaScript -->
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"
		integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
		crossorigin="anonymous"></script>
	<script src="../js/chat.js"></script>

</body>
</html>