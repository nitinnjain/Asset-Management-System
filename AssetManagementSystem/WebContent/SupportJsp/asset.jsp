<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Map"%>
<%@ page
	import="com.assetmanagementsystem.model.entity.AssetCategoryEntity"%>
<%@ page import="com.assetmanagementsystem.model.entity.KeywordEntity"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Add Asset</title>
</head>
<body>
	<%
		Map<Integer, AssetCategoryEntity> categoryMap = (Map<Integer, AssetCategoryEntity>) request
				.getAttribute("categoryMap");
		Map<Integer, KeywordEntity> keywordMap = (Map<Integer, KeywordEntity>) request.getAttribute("keywordMap");
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
					<li><a href="/AssetManagementSystem/SupportJsp/displayJsp.jsp">Display</a></li>
					<li><a
						href="/AssetManagementSystem/SupportController?operation=displayCategories">Categories</a></li>
					<li><a
						href="/AssetManagementSystem/SupportController?operation=displayKeyword">Keywords</a></li>
					<li class="active"><a
						href="/AssetManagementSystem/SupportController?operation=assetPool">Add
							Asset</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"><%=session.getAttribute("username")%><span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a
								href="/AssetManagementSystem/SupportJsp/myProfile.jsp">Change
									Password</a></li>
						</ul></li>
					<li><a href="/AssetManagementSystem/LogoutController">Logout</a></li>
				</ul>
			</div>
			</nav>
		</div>
		<div class="container">
			<form class="form-horizontal" action="SupportController" method=get>
				<input type="hidden" name="operation" value="addAsset">
				<div class="form-group">
					<label>Asset Name: </label> <input class="form-control" type="text"
						name="asset_name">
				</div>
				<div class="form-group">
					<label>Asset Category: </label> <select class="form-control"
						name="category">
						<option>Select</option>
						<%
							for (Map.Entry<Integer, AssetCategoryEntity> entry : categoryMap.entrySet()) {
						%>
						<option <%=entry.getValue().getCategoryName()%>><%=entry.getValue().getCategoryName()%></option>
						<%
								}
							%>
					</select>
				</div>
				<%
					for (Map.Entry<Integer, KeywordEntity> entry : keywordMap.entrySet()) {
				%>
				<div class="checkbox">
					<input type="checkbox" name="<%=entry.getKey()%>"
						value="<%=entry.getKey()%>"><%=entry.getValue().getKeywords()%></div>
				<%
					}
				%>
				<div class="form-group">
					<label>Asset Quantity: </label> <input class="form-control"
						type="text" name="quantity">
				</div>
				<div class="form-group">
					<label>Asset Description: </label> <input class="form-control"
						type="textarea" name="description">
				</div>
				<div class="form-group">
					<input class="form-control btn btn-primary" type="submit"
						value="Submit">
				</div>
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






