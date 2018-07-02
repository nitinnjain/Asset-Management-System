<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="com.assetmanagementsystem.model.entity.AssetSerialNumberEntity"%>
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
					<li><a
						href="/AssetManagementSystem/EmployeeJsp/employeeHome.jsp">Home</a></li>
					<li><a
						href="/AssetManagementSystem/EmployeeJsp/raiseRequest.jsp">Raise
							Request</a></li>
					<li><a
						href="/AssetManagementSystem/EmployeeController?operation=my_requests">My
							Requests</a></li>
					<li class="active"><a
						href="/AssetManagementSystem/EmployeeController?operation=my_assets">My
							Assets</a></li>
					<li><a
						href="/AssetManagementSystem/EmployeeJsp/techSupport.jsp">Need
							technical assistance?</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"><%=session.getAttribute("username")%><span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/AssetManagementSystem/EmployeeJsp/myProfile.jsp">Change Password</a></li>
						</ul></li>
					<li><a href="/AssetManagementSystem/LogoutController">Logout</a></li>
				</ul>
			</div>
			</nav>
		</div>
		<table class="table table-striped table-hover">
			<tr>
				<th>Asset Serial Number</th>
				<th>Asset Name</th>
				<th>Allocated By</th>
			</tr>
			<%
				if (request.getAttribute("asset_list") != null) {
					List<AssetSerialNumberEntity> assetList = (List<AssetSerialNumberEntity>) request
							.getAttribute("asset_list");
					for (AssetSerialNumberEntity asne : assetList) {
			%>
			<tr>
				<td><%=asne.getAssetSerialNumber()%></td>
				<td><%=asne.getAssetPool().getAssetName()%></td>
				<td><%=asne.getAllocatedBy()%></td>
			</tr>
			<%
				}
				}
			%>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</body>
</html>