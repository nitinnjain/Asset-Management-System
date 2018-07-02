<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
	<%
		if (session.getAttribute("username") == null) {
	%>
	<jsp:forward page="/login.jsp" />
	<%
		}
	%>
	<div class="container-fluid">
		<div>
			<h2 style="text-align: center;" class="page-header">Asset
				Management System</h2>
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<li><a
						href="/AssetManagementSystem/SupportJsp/supportHome.jsp">Home</a></li>
					<li><a href="/AssetManagementSystem/SupportJsp/displayJsp.jsp">Display</a></li>
					<li><a
						href="/AssetManagementSystem/SupportController?operation=displayCategories">Categories</a></li>
					<li><a
						href="/AssetManagementSystem/SupportController?operation=displayKeyword">Keywords</a></li>
					<li><a href="/AssetManagementSystem/SupportController?operation=assetPool">Add Asset</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="#"><%=session.getAttribute("username")%></a></li>
					<li><a href="/AssetManagementSystem/LogoutController">Logout</a></li>
				</ul>
			</div>
			</nav>
		</div>
		<div>
		</div>
		<div class="container-fluid" id="change_form">
			<div>
				<form class="form-horizontal"
					action='/AssetManagementSystem/SupportController' method='post'>
					<input type='hidden' name='operation' value='change_pass'>
					<div class="form-group">
						<div>
							<label for="n_p">New Password :</label> <input
								class="form-control" id='n_p' type='password'
								name='new_password'>
						</div>
					</div>
					<div class="form-group">
						<div>
							<label for="c_p">Confirm Password :</label> <input
								class="form-control" id='c_p' type='password'
								name='confirm_password' onkeyup='checkPass()'>
						</div>
					</div>
					<div class="form-group">
						<input class="btn btn-primary" id='submit_button' type='submit'
							value='Change Password' disabled>
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>
	<script type="text/javascript">
		function checkPass() {
			var newPass = document.getElementById("n_p").value;
			var confirmPass = document.getElementById("c_p").value;

			if (newPass !== null && confirmPass !== null) {
				if (newPass === confirmPass) {
					document.getElementById('submit_button').disabled = false;
				}
				if (newPass !== confirmPass) {
					document.getElementById('submit_button').disabled = true;
				}
			}
		}
	</script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</body>
</html>