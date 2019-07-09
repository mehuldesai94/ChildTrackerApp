<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Child Home</title>
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
<script>
	function getLocation() {
		// Check whether browser supports Geolocation API or not
		if (navigator.geolocation) { // Supported

			var options = {
				enableHighAccuracy : true
			};

			navigator.geolocation
					.getCurrentPosition(getPosition, null, options);
		} else { // Not supported
			alert("Oops! This browser does not support HTML Geolocation.");
		}
	}
	function getPosition(position) {
		var latitude = position.coords.latitude;
		var longitude = position.coords.longitude;
		$.ajax({
			type : 'POST',
			url : 'http://localhost:8080/ChildTracker/ProcessLocation',
			data : {
				'latitude' : latitude,
				'longitude' : longitude
			}
		})
		document.getElementById("location").innerHTML = "Latitude: "
				+ position.coords.latitude + "<br>" + "Longitude: "
				+ position.coords.longitude;
	}
</script>

</head>
<body>
	<%
		Child c = (Child) session.getAttribute("child");
	%>



	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 style="text-align: center;">
					Welcome
					<%=c.getFirstName() + " " + c.getLastName()%></h2>
			</div>
		</div>
		<hr style="padding-top: 25px" />
		<div class="row">
			<div class="col-md-4">
				<%
					String key = "parentChat" + c.getParentId();
					if (application.getAttribute(key) != null) {
				%>
				<a href='childChat.jsp'><button>Chat</button></a>
				<%
					}
				%>
			</div>
			<div class="col-md-4">
				<button onclick="getLocation()">Start Tracking</button>
			</div>

			<div class="col-md-4">
				<a href='../LogOut'><button>Logout</button></a>
			</div>
		</div>

	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"
		integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
		crossorigin="anonymous"></script>





</body>
</html>