<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.assetmanagementsystem.model.entity.AssetSerialNumberEntity"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>List By Asset</title>
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
		List<AssetSerialNumberEntity> empList = (List<AssetSerialNumberEntity>) request
				.getAttribute("assetEmpList");
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
			<table class="table table-striped table-hover">
				<tr>
					<th>S No.</th>
					<th>Asset Serial Number</th>
					<th>Employee Id</th>
					<th>Action</th>
				</tr>

				<%
					AssetSerialNumberEntity asn = null;
					if (empList != null) {
						int i = 1;
						for (AssetSerialNumberEntity asne : empList) {
				%>
				<tr>
					<td><%=i%></td>
					<td><%=asne.getAssetSerialNumber()%></td>
					<td><%=asne.getEmployeeId()%></td>
					</td>
					<td>
						<%
							if (asne.getEmployeeId() != 0) {
						%><a
						href="/AssetManagementSystem/SupportController?operation=deallocate&asset_sno=<%=asne.getAssetSerialNumber()%>">DEALLOCATE</a>
						<%
							}
						%>
					</td>
				</tr>
				<%
					i++;
						}

					} else {
				%>
				<tr>
					<td colspan='7'>No Asset Allocated</td>
				</tr>
				<%
					}
				%>
			</table>
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