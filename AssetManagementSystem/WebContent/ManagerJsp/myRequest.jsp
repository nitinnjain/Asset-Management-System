<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.assetmanagementsystem.model.entity.RequestEntity"
	import="java.util.List"%>
<%@ page import="com.assetmanagementsystem.utility.*"%>
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
						href="/AssetManagementSystem/ManagerJsp/managerHome.jsp">Home</a></li>
					<li><a
						href="/AssetManagementSystem/ManagerJsp/raiseRequest.jsp">Raise
							Request</a></li>
					<li class="active"><a
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
		<%
			List<RequestEntity> requestList = (List<RequestEntity>) request.getAttribute("requestList");
		%>
		<table class="table table-striped table-hover">
			<tr>
				<th>Request ID</th>
				<th>Asset ID</th>
				<th>Employee ID</th>
				<th>Status</th>
				<th>Type</th>
				<th>Description</th>
				<th>Action</th>
			</tr>

			<%
				if (request.getAttribute("requestList") != null) {
					for (RequestEntity re : requestList) {
			%>
			<tr>
				<td><%=re.getRequestId()%></td>
				<td><%=re.getAssetId()%></td>
				<td><%=re.getEmployeeId()%></td>
				<td><%=re.getRequestStatus()%></td>
				<td><%=re.getRequestType()%></td>
				<td><%=re.getUserNotes()%></td>
				<%
					if (re.getRequestStatus().equals((String) Utility.PENDING)) {
				%>
				<td><a
					href="/AssetManagementSystem/EmployeeController?operation=cancel_req&&request_id=<%=re.getRequestId()%>">Cancel
						Request</a></td>
				<%
					} else {
				%>
				<td colspan='7'>Sorry, there are no requests available at the
					moment.</td>
				<%
					}
				%>
			</tr>
			<%
				}
				} else {
			%>
			<tr>
				<td colspan='7'>Sorry, there are no requests available at the
					moment.</td>
			</tr>
			<%
				}
			%>
		</table>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	</div>
</body>
</html>