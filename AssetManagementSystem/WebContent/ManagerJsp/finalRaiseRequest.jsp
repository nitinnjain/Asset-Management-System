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
	<%
		int id = Integer.parseInt(request.getParameter("asset_id"));
		String name = request.getParameter("asset_name");
	%>
	<div class="container-fluid">
		<div>
			<h2 style="text-align: center;" class="page-header">Asset
				Management System</h2>
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<li><a
						href="/AssetManagementSystem/ManagerJsp/managerHome.jsp">Home</a></li>
					<li class="active"><a
						href="/AssetManagementSystem/ManagerJsp/raiseRequest.jsp">Raise
							Request</a></li>
					<li><a
						href="/AssetManagementSystem/ManagerController?operation=my_requests">My
							Requests</a></li>
					<li><a
						href="/AssetManagementSystem/ManagerController?operation=my_assets">My
							Assets</a></li>
					<li><a
						href="/AssetManagementSystem/ManagerController?operation=my_team_requests">My
							Team's Requests</a></li>
					<li><a
						href="/AssetManagementSystem/ManagerController?operation=my_team_assets">My
							Team's Assets</a></li>
					<li><a
						href="/AssetManagementSystem/ManagerJsp/techSupport.jsp">Need
							technical assistance?</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"><%=session.getAttribute("username")%><span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a
								href="/AssetManagementSystem/ManagerJsp/myProfile.jsp">Change
									Password</a></li>
						</ul></li>
					<li><a href="/AssetManagementSystem/LogoutController">Logout</a></li>
				</ul>
			</div>
			</nav>
		</div>
		<div>
			<form class="form-horizontal"
				action="/AssetManagementSystem/EmployeeController" method="post">
				<input type="hidden" name="operation" value="raise">
				<div class="form-group">
					<label>ID: </label> <input type="text" name="asset_id"
						value="<%=id%>" readonly>
				</div>
				<div class="form-group">
					<label>Name: </label> <input class="form-control" type="text"
						name="asset_name" value="<%=name%>" readonly>
				</div>
				<div class="form-group">
					<label>Notes: </label>
					<textarea class="form-control" rows="4" cols="40"
						name="employee_notes"></textarea>
				</div>
				<div class="form-group">
					<input class="form-control btn btn-primary" type="submit"
						value="Raise Request">
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