
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.assetmanagementsystem.model.entity.EmployeeEntity"%>
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
		EmployeeEntity ee = new EmployeeEntity();

		if (request.getAttribute("employeeDetails") != null) {
			ee = (EmployeeEntity) request.getAttribute("employeeDetails");
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
				<a href="/AssetManagementSystem/AdminJsp/addEmployee.jsp">Add
					Employee</a>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
				<a href="/AssetManagementSystem/AdminJsp/updateEmployee.jsp">Update
					Employee</a>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
				<a href="/AssetManagementSystem/AdminJsp/deleteEmployee.jsp">Delete
					Employee</a>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
				<a href="/AssetManagementSystem/AdminJsp/viewEmployee.jsp">View
					Employee</a>
			</div>
		</div>
		<table class="table table-striped table-hover">
			<tr>
				<th colspan='2' style="align: center">Employee Details</th>
			</tr>
			<tr>
				<td>Employee ID</td>
				<td><%=ee.getEmployeeId()%></td>
			</tr>
			<tr>
				<td>Employee name</td>
				<td><%=ee.getEmployeeName()%></td>
			</tr>
			<tr>
				<td>ManagerID</td>
				<td><%=ee.getManagerId()%></td>
			</tr>
			<tr>
				<td>ProjectID</td>
				<td><%=ee.getProjectId()%></td>
			</tr>
			<tr>
				<td>Department</td>
				<td><%=ee.getEmployeeDepartment()%></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><%=ee.getEmployeeSalary()%></td>
			</tr>
			<tr>
				<td>PhoneNumber</td>
				<td><%=ee.getEmployeePhoneNumber()%></td>
			</tr>
			<tr>
				<td>PostingCity</td>
				<td><%=ee.getEmployeePostingCity()%></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><%=ee.getEmployeeUsername()%></td>
			</tr>
			<tr>
				<td>Flat/House/Floor/Building</td>
				<td><%=ee.getAddress().getFlatHouseFloorBuilding()%></td>
			</tr>
			<tr>
				<td>Colony/Street/Locality</td>
				<td><%=ee.getAddress().getColonyStreetLocality()%></td>
			</tr>
			<tr>
				<td>landmark</td>
				<td><%=ee.getAddress().getLandmark()%></td>
			</tr>
			<tr>
				<td>City</td>
				<td><%=ee.getAddress().getCity()%></td>
			</tr>
			<tr>
				<td>State</td>
				<td><%=ee.getAddress().getState()%></td>
			</tr>
		</table>
		<%
			}
		%>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</body>
</html>





