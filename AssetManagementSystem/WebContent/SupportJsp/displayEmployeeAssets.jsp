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
<title>Employee's Assets</title>
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
		List<AssetSerialNumberEntity> assetList = (List<AssetSerialNumberEntity>) request
				.getAttribute("employeeAssets");
	%>
	<div class="container-fluid">
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
		<div class="container">
			<table class="table table-striped table-hover">
				<tr>
					<th>S No.</th>
					<th>Asset ID</th>
					<th>Asset Name</th>
					<th>Asset Serial Number</th>
					<th>Allocated By</th>
					<th>Action</th>
				</tr>

				<%
					if (assetList != null) {
						int i = 1;
						for (AssetSerialNumberEntity asne : assetList) {
				%>
				<tr>
					<td><%=i%></td>
					<td><%=asne.getAssetPool().getAssetId()%></td>
					<td><%=asne.getAssetPool().getAssetName()%></td>
					<td><%=asne.getAssetSerialNumber()%></td>
					<td><%=asne.getAllocatedBy()%></td>
					<td><a
						href="/AssetManagementSystem/SupportController?operation=deallocate&asset_sno=<%=asne.getAssetSerialNumber()%>">DEALLOCATE</a></td>
				</tr>
				<%
					i++;
						}

					} else {
				%>
				<tr>
					<td colspan='7'>NO ASSET ALLOCATED</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		function empAsset() {
			document.getElementById('emp_asset').style.display = "block";
			document.getElementById('emp_asset_id').style.display = "none";
			document.getElementById('emp_asset_sno').style.display = "none";
		}

		function empListByAssetId() {
			document.getElementById('emp_asset_id').style.display = "block";
			document.getElementById('emp_asset').style.display = "none";
			document.getElementById('emp_asset_sno').style.display = "none";
		}

		function empDetailsByAssetSNo() {
			document.getElementById('emp_asset_sno').style.display = "block";
			document.getElementById('emp_asset').style.display = "none";
			document.getElementById('emp_asset_id').style.display = "none";
		}

		function addCategory() {
			document.getElementById('add_category').style.display = "block";
			document.getElementById('emp_asset').style.display = "none";
			document.getElementById('emp_asset_id').style.display = "none";
		}
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js">
	</script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</body>
</html>