<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Map"%>
<%@ page
	import="com.assetmanagementsystem.model.entity.AssetCategoryEntity"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Categories</title>
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
					<li><a
						href="/AssetManagementSystem/SupportJsp/displayJsp.jsp">Display</a></li>
					<li class="active"><a
						href="/AssetManagementSystem/SupportController?operation=displayCategories">Categories</a></li>
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
					<th>Category ID</th>
					<th>Category Name</th>
					<th>Update</th>
				</tr>
				<%
					Map<Integer, AssetCategoryEntity> categoryMap = (Map<Integer, AssetCategoryEntity>) request
							.getAttribute("categoryMap");
					if (categoryMap != null) {
						int i = 0;
						for (Map.Entry<Integer, AssetCategoryEntity> entry : categoryMap.entrySet()) {
				%>
				<tr>
					<td><%=entry.getValue().getCategoryId()%></td>
					<td><%=entry.getValue().getCategoryName()%></td>
					<td><a href="javascript:updateCategory(<%=entry.getKey()%>)">Update</a></td>
				</tr>
				<tr>
					<td><span id="update_category_<%=entry.getKey()%>"
						style="display: none"></span></td>
				</tr>
				<%
					}
					} else {
				%>
				<tr>
					<td colspan='4' align="center">NO CATEGORY ADDED YET</td>
				</tr>
				<%
					}
				%>
				<tr>
					<td colspan="4" align="center"><a
						href="javascript:addCategory()">Add Category</a></td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<div id="add_category" style="display: none;">
							<form class="form-inline" action="SupportController" method="get">
								<input type="hidden" name="operation" value="addCategory">
								<label>Category Name: </label> <input class="form-control"
									type="text" name="new_category"> <input
									class="form-control btn btn-primary" type="submit"
									value="Submit">
							</form>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		function updateCategory(category_id) {
			var span_id = "update_category_"+category_id;
			document.getElementById(span_id).style.display = "block";
			document.getElementById('add_category').style.display = "none";
			document.getElementById(span_id).innerHTML = "<form class='form-inline' action='/AssetManagementSystem/SupportController' method='get'><input type='hidden' name='operation' value='updateCategory'><label>Category: </label><input class='form-control' type='text' name='update_category_name'><input class='form-control' type='text' name='update_category_id' value= '" + category_id +" 'readonly><input class='form-control btn btn-primary' type='submit' value='Submit'></form>";
		}

		function addCategory() {
			document.getElementById('add_category').style.display = "block";
		}
	</script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</body>
</html>