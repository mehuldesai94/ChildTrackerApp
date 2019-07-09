<%@page import="beans.Parent"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>Registration</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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

<!--Custom styles-->
<link rel="stylesheet" type="text/css" href="../assets/css/styles1.css">
</head>

<body>
	<div class="container register">
		<div class="row">
			<div class="col-md-3 register-left">
				<img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="" />
				<h3>Welcome</h3>
				<p>You are at first the first stage of using Application...</p>
				<a href='Index.jsp'><button type="submit" name="" value="Login">Home</button></a><br />
			</div>


			


			<div class="col-md-9 register-right">

				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<h3 class="register-heading">Apply as a Parent User</h3>
						<%
							Parent user = null;
							if (session.getAttribute("registerError") != null) {
								out.print("<span style='color:red'>" + (String) session.getAttribute("registerError") + "</span>");
							}
						%>
						<form method="post" action="../ProcessRegister">
							<div class="row register-form">
								<div class="col-md-6">
									<div class="form-group">
										First Name* <input type="text" class="form-control" value=""
											name="firstName" />
									</div>

									<div class="form-group">
										Last Name* <input type="text" class="form-control" value=""
											name="lastName" />
									</div>

									<div class="form-group">
										Password* <input type="password" class="form-control" value=""
											name="password" />
									</div>
									<div class="form-group">
										Gender*
										<div class="maxl">
											<label class="radio inline"> <input type="radio"
												name="gender" value="male" checked> <span>
													Male </span>
											</label> <label class="radio inline"> <input type="radio"
												name="gender" value="female"> <span>Female </span>
											</label>
										</div>
									</div>

								</div>
								<div class="col-md-6">

									<div class="form-group">
										Email* <input type="email" name="email" class="form-control">
									</div>

									<div class="form-group">
										Phone* <input type="tel" class="form-control" name="phone">
									</div>

									<div class="form-group">
										Date of Birth* <input type="date" class="form-control"
											placeholder="Date of Birth *" value="" name="birthdate" />
									</div>

									<div class="form-group">
										Address * <input type="text" class="form-control" value=""
											name="address" />
									</div>
									<input type="submit" class="btnRegister" value="Register" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>

</html>