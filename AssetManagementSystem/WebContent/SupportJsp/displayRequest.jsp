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
<title>Requests</title>
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
		List<RequestEntity> requestList = (List<RequestEntity>) request.getAttribute("requestList");
		System.out.println("in display.jsp" + requestList);
	%>
	<div class="containner-fluid">
		<div class="container-fluid">
			<h2 style="text-align: center;" class="page-header">Asset
				Management System</h2>
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<li><a
						href="/AssetManagementSystem/SupportJsp/supportHome.jsp">Home</a></li>
					<li class="active"><a
						href="/AssetManagementSystem/SupportJsp/displayJsp.jsp">Display</a></li>
					<li><a href="/AssetManagementSystem/SupportController?operation=displayCategories">Categories</a></li>
					<li><a href="/AssetManagementSystem/SupportController?operation=displayKeyword">Keywords</a></li>
					<li><a href="/AssetManagementSystem/SupportController?operation=assetPool">Add Asset</a></li>
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
		<div id="request_table">
			<div class="container">
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
						RequestEntity r = null;
						if (request.getAttribute("requestList") != null) {
							for (RequestEntity re : requestList) {
								if (re.getRequestStatus().equals((String) Utility.APPROVED)) {
									r = re;
					%>
					<tr>
						<td><%=re.getRequestId()%></td>
						<td><%=re.getAssetId()%></td>
						<td><%=re.getEmployeeId()%></td>
						<td><%=re.getRequestStatus()%></td>
						<td><%=re.getRequestType()%></td>
						<td><%=re.getUserNotes()%></td>
						<td><a
							href="/AssetManagementSystem/SupportController?request_id=<%=re.getRequestId()%>">Allocate</a></td>
					</tr>
					<%
						}
							}

						} else {
					%>
					<tr>
						<td colspan='7'>No Request Pending</td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function empAsset() {
			document.getElementById('emp_asset').style.display = "block";
			document.getElementById('emp_asset_id').style.display = "none";
			document.getElementById('emp_asset_sno').style.display = "none";
			document.getElementById('add_category').style.display = "none";
			document.getElementById('request_table').style.display = "none";
		}

		function empListByAssetId() {
			document.getElementById('emp_asset_id').style.display = "block";
			document.getElementById('emp_asset').style.display = "none";
			document.getElementById('emp_asset_sno').style.display = "none";
			document.getElementById('add_category').style.display = "none";
			document.getElementById('request_table').style.display = "none";
		}

		function empDetailsByAssetSNo() {
			document.getElementById('emp_asset_sno').style.display = "block";
			document.getElementById('emp_asset').style.display = "none";
			document.getElementById('emp_asset_id').style.display = "none";
			document.getElementById('add_category').style.display = "none";
			document.getElementById('request_table').style.display = "none";
		}

		function addCategory() {
			document.getElementById('add_category').style.display = "block";
			document.getElementById('emp_asset').style.display = "none";
			document.getElementById('emp_asset_id').style.display = "none";
			document.getElementById('emp_asset_sno').style.display = "block";
			document.getElementById('request_table').style.display = "none";
		}
	</script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</body>
</html>