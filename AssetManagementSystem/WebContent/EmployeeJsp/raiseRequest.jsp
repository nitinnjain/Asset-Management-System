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
						href="/AssetManagementSystem/EmployeeJsp/employeeHome.jsp">Home</a></li>
					<li class="active"><a
						href="/AssetManagementSystem/EmployeeJsp/raiseRequest.jsp">Raise
							Request</a></li>
					<li><a
						href="/AssetManagementSystem/EmployeeController?operation=my_requests">My
							Requests</a></li>
					<li><a
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

		<div class="row-fluid">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<a href="javascript:searchName()" class="btn">Search By Name</a>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<a href="javascript:searchKeyword()" class="btn">Search By
					Keyword</a>
			</div>
		</div>

		<!-- Search By Name -->

		<div id="search_by_name_form" style="display: none;">
			<form class="form-horizontal"
				action="/AssetManagementSystem/EmployeeController" method="post">
				<input type="hidden" name="operation" value="search">

				<div class="form-group">
					<label class="control-label col-sm-2" for="search_category">Asset Name:</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="search_by_name"
							placeholder="Enter name to search">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form>
		</div>

		<!-- Search By Keyword -->

		<div id="search_by_keyword_form" style="display: none;">
			<form class="form-horizontal"
				action="/AssetManagementSystem/EmployeeController" method="post">
				<input type="hidden" name="operation" value="search">

				<div class="form-group">
					<label class="control-label col-sm-2" for="search_keyword">Keyword
						Name:</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="search_by_keyword"
							placeholder="Enter keyword to search">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form>
		</div>

		<!-- Search By Category -->

		<div id="search_by_category_form" style="display: none;">
			<form class="form-horizontal"
				action="/AssetManagementSystem/EmployeeController" method="post">
				<input type="hidden" name="operation" value="search">

				<div class="form-group">
					<label class="control-label col-sm-2" for="search_category">Category
						Name:</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="search_by_category"
							placeholder="Enter category to search">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form>
		</div>

	</div>
	<script type="text/javascript">
		function searchName() {
			document.getElementById('search_by_name_form').style.display = "block";
			document.getElementById('search_by_keyword_form').style.display = "none";
			document.getElementById('search_by_category_form').style.display = "none";
		}

		function searchKeyword() {
			document.getElementById('search_by_name_form').style.display = "none";
			document.getElementById('search_by_keyword_form').style.display = "block";
			document.getElementById('search_by_category_form').style.display = "none";
		}

		function searchCategory() {
			document.getElementById('search_by_name_form').style.display = "none";
			document.getElementById('search_by_keyword_form').style.display = "none";
			document.getElementById('search_by_category_form').style.display = "block";
		}
	</script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</body>
</html>