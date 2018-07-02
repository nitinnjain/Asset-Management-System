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

<title>Login</title>
</head>
<body>
	<%
		String msg = null;
		if (request.getAttribute("msg") != null) {
			msg = (String) request.getAttribute("msg");
		}
	%>
	<div class="container" onLoad="check(<%=msg%>)">
		<h2 style="text-align: center;" class="page-header">Asset
			Management System</h2>
		<div id="alert_box" class="alert alert-danger" style="display: none;">
			<strong>Login Failed</strong> Either username or password is
			incorrect!!!
		</div>
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Log In</div>
				</div>
				<div style="padding-top: 30px" class="panel-body">
					<form id="loginform" class="form-horizontal"
						action="/AssetManagementSystem/LoginController" method="post">
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="login-username"
								class="form-control" type="text" name="login_username"
								placeholder="Username">
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
								class="form-control" type="password" name="login_password"
								placeholder="Password">
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"></span> <select
								name="login_department" class="form-control">
								<option value="select">Select</option>
								<option value="admin">Admin</option>
								<option value="employee">Employee</option>
								<option value="manager">Manager</option>
								<option value="support">Support</option>
							</select>
						</div>
						<div style="margin-top: 10px; text-align: center;"
							class="form-group">
							<div class="col-sm-12 controls">
								<input class="btn btn-primary" type="submit" value="Login">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<script type="text/javascript">
		function check(error) {
			if(error != null) {
				document.getElementById('alert_box').style.display="block";
			}
		}
		</script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	</div>
</body>
</html>