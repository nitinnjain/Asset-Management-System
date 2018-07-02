<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"
	import="com.assetmanagementsystem.model.entity.AssetPoolEntity"
	import="java.util.HashMap"%>
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
		<table class="table table-striped table-hover">
			<tr>
				<th>Asset ID</th>
				<th>Asset Name</th>
				<th>Asset Description</th>
				<th></th>
			</tr>
			<%
				String assetName = null, assetDesc = null;
				int assetId = 0;

				List<AssetPoolEntity> assetList = new ArrayList<AssetPoolEntity>();
				if (request.getAttribute("assetMap") != null) {
					assetList = (List<AssetPoolEntity>) request.getAttribute("assetMap");
					for (AssetPoolEntity ape : assetList) {
			%>
			<tr>
				<td><%=assetId = ape.getAssetId()%></td>
				<td><%=assetName = ape.getAssetName()%></td>
				<td><%=ape.getAssetDescription()%></td>
				<td><a
					href="/AssetManagementSystem/ManagerJsp/finalRaiseRequest.jsp?asset_id=<%=assetId%>&&asset_name=<%=assetName%>">Raise
						Request</a></td>
			</tr>
			<%
				}
				} else {
			%>
			<tr>There are no requests of you.
			</tr>
			<%
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