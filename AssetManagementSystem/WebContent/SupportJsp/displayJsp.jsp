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
					<li><a
						href="/AssetManagementSystem/SupportJsp/supportHome.jsp">Home</a></li>
					<li class="active"><a
						href="/AssetManagementSystem/SupportJsp/displayJsp.jsp">Display</a></li>
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
			<div class="row">
				<div class="col-lg-3 col-md-3 colsm-12 col-xs-12">
					<a
						href="/AssetManagementSystem/SupportController?operation=request">Display
						Requests</a>
				</div>
				<div class="col-lg-3 col-md-3 colsm-12 col-xs-12">
					<a href="javascript:empAsset()">Display Employee's Assets</a>
				</div>
				<div class="col-lg-3 col-md-3 colsm-12 col-xs-12">
					<a href="javascript:empListByAssetId()">Display Employee List
						By AssetID</a>
				</div>
				<div class="col-lg-3 col-md-3 colsm-12 col-xs-12">
					<a href="javascript:empDetailsByAssetSNo()">Display Details By
						Asset SNo.</a>
				</div>
			</div>
			<div class="container">
				<br>
				<div id="emp_asset" style="display: none;">
					<form class="form-horizontal"
						action="/AssetManagementSystem/SupportController" method="get">
						<input type="hidden" name="operation" value="empAsset">
						<div class="form-group">
							<label>Employee ID: </label> <input class="form-control"
								type="text" name="e_id">
						</div>
						<div class="form-group">
							<input class="form-control btn btn-primary" type="submit"
								value="Submit">
						</div>
					</form>
				</div>
			</div>
			<div class="container">
				<div id="emp_asset_id" style="display: none;">
					<form class="form-horizontal"
						action="/AssetManagementSystem/SupportController" method="get">
						<input type="hidden" name="operation" value="empListByAssetId">
						<div class="form-group">
							<label>Asset ID: </label> <input class="form-control" type="text"
								name="asset_id">
						</div>
						<div class="form-group">
							<input class="form-control btn btn-primary" type="submit"
								value="Submit">
						</div>
					</form>
				</div>
			</div>
			<div class="container">
				<div id="emp_asset_sno" style="display: none">
					<form class="form-horizontal"
						action="/AssetManagementSystem/SupportController" method="get">
						<input type="hidden" name="operation" value="empDetailsByAssetSno">
						<div class="form-group">
							<label>Asset Serial Number: </label> <input class="form-control"
								type="text" name="asset_sno">
						</div>
						<div class="form-group">
							<input class="form-control btn btn-primary" type="submit"
								value="Submit">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function empAsset() {
			document.getElementById('emp_asset').style.display = "block";
			document.getElementById('emp_asset_id').style.display = "none";
			document.getElementById('emp_asset_sno').style.display = "none";
			document.getElementById('add_category').style.display = "none";
		}

		function empListByAssetId() {
			document.getElementById('emp_asset_id').style.display = "block";
			document.getElementById('emp_asset').style.display = "none";
			document.getElementById('emp_asset_sno').style.display = "none";
			document.getElementById('add_category').style.display = "none";
		}

		function empDetailsByAssetSNo() {
			document.getElementById('emp_asset_sno').style.display = "block";
			document.getElementById('emp_asset').style.display = "none";
			document.getElementById('emp_asset_id').style.display = "none";
			document.getElementById('add_category').style.display = "none";
		}

		function addCategory() {
			document.getElementById('add_category').style.display = "block";
			document.getElementById('emp_asset').style.display = "none";
			document.getElementById('emp_asset_id').style.display = "none";
			document.getElementById('emp_asset_sno').style.display = "block";
		}
	</script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</body>
</html>