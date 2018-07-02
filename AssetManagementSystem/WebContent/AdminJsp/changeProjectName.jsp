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

<body>
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
					<li><a href="/AssetManagementSystem/AdminJsp/adminHome.jsp">Home</a></li>
					<li><a href="/AssetManagementSystem/AdminJsp/employeeHome.jsp">Employee
							Management</a></li>
					<li class="active"><a
						href="/AssetManagementSystem/AdminJsp/projectHome.jsp">Project
							Management</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"><%=session.getAttribute("username")%><span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="myProfile.jsp">Change Password</a></li>
						</ul></li>
					<li><a href="/AssetManagementSystem/LogoutController">Logout</a></li>
				</ul>
			</div>
			</nav>
		</div>
		<div class="row-fluid">
			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
				<a href="/AssetManagementSystem/AdminJsp/addProject.jsp">Add Project</a>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
				<a href="/AssetManagementSystem/AdminJsp/changeManager.jsp">Change Manager</a>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
				<a href="/AssetManagementSystem/AdminJsp/changeProjectName.jsp">Change Project Name</a>
			</div>
		</div>
		<br>
		<div class="container">
			<form class="form-horizontal" action="/AssetManagementSystem/AdminProjectController"
				method="post">
				<input type="hidden" name="operation" value="changeProjectNmae">
				<div class="form-group">
					<label>Project ID: </label> <input class="form-control" type="text"
						name="project_id">
				</div>
				<div class="form-group">
					<label>Project Name:</label> <input class="form-control"
						type="text" name="project_name">
				</div>
				<div class="form-group">
					<input class="form-control btn btn-primary" type="submit"
						value="Change Project Name">
				</div>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</body>
</html>