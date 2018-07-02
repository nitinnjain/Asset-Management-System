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
					<li class="active"><a
						href="/AssetManagementSystem/AdminJsp/employeeHome.jsp">Employee
							Management</a></li>
					<li><a href="/AssetManagementSystem/AdminJsp/projectHome.jsp">Project
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
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
				<a href="/AssetManagementSystem/AdminJsp/addEmployee.jsp">Add Employee</a>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
				<a href="/AssetManagementSystem/AdminJsp/updateEmployee.jsp">Update Employee</a>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
				<a href="/AssetManagementSystem/AdminJsp/deleteEmployee.jsp">Delete Employee</a>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
				<a href="/AssetManagementSystem/AdminJsp/viewEmployee.jsp">View Employee</a>
			</div>
		</div>
		<div class="container">
			<form class="form-horizontal"
				action="/AssetManagementSystem/AdminEmployeeController"
				method="post">
				<input type="hidden" name="operation" value="viewEmployee">
				<div class="form-group">
					<input class="form-control" type="text" name="employee_id"
						placeholder="EmployeeID">
				</div>
				<div class="form-group">
					<input class="form-control btn btn-primary" type="submit"
						value="View Employee">
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