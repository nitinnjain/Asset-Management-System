<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.assetmanagementsystem.model.entity.RequestEntity"%>
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
<title>Map Asset</title>
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
		RequestEntity re = (RequestEntity) request.getAttribute("empRequest");
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
					<li class="active"><a href="/AssetManagementSystem/SupportJsp/displayJsp.jsp">Display</a></li>
					<li><a
						href="/AssetManagementSystem/SupportController?operation=displayCategories">Categories</a></li>
					<li><a
						href="/AssetManagementSystem/SupportController?operation=displayKeyword">Keywords</a></li>
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
		<div class="container">
			<form class="form-horizontal"
				action="/AssetManagementSystem/SupportController" method=get>
				<table class="table table-striped table-hover">
					<tr>
						<th colspan='2'>REQUEST DETAILS</th>
					</tr>
					<input type="hidden" name="operation" value="mapAsset">
					<tr>
						<td>Request Id</td>
						<td><input class="form-control" type="text" name="request_id"
							value="<%=re.getRequestId()%>" readonly></td>
					</tr>
					<tr>
						<td>Aseet Id</td>
						<td><input class="form-control" type="text" name="asset_id"
							value="<%=re.getAssetId()%>" readonly></td>
					</tr>
					<tr>
						<td>Employee Id</td>
						<td><input class="form-control" type="text"
							name="employee_id" value="<%=re.getEmployeeId()%>" readonly></td>
					</tr>
					<tr>
						<td>Manager Id</td>
						<td><input class="form-control" type="text" name="manager_id"
							value="<%=re.getManagerId()%>" readonly></td>
					</tr>
					<tr>
						<td>request Status</td>
						<td><input class="form-control" type="text" name="status"
							value="<%=re.getRequestStatus()%>" readonly></td>
					</tr>
					<tr>
						<td>Request Type</td>
						<td><input class="form-control" type="text" name="type"
							value="<%=re.getRequestType()%>" readonly></td>
					</tr>
					<tr>
						<td>Allocated By</td>
						<td><input class="form-control" type="text"
							name="allocated_by" value="<%=session.getAttribute("username")%>"
							readonly></td>
					</tr>
					<tr>
						<td>Asset Serial Number</td>
						<td><input class="form-control" type="text" name="asset_sno"
							id="asset_id" placeholder="Asset Serial Number"></td>
					</tr>
					<tr>
						<td><input class="form-control btn btn-primary" type="submit"
							value="Allocate"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<script>
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     document.getElementById("asset_id").innerHTML = this.responseText;
    }
  };
  xhttp.open("POST", "/AssetManagementSystem/SupportController", true);
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("asset_id="<%=re.getAssetId()%>);
}
</script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</body>
</html>