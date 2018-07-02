<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.assetmanagementsystem.model.entity.KeywordEntity"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Keywords</title>
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
					<li><a href="/AssetManagementSystem/SupportController?operation=displayCategories">Categories</a></li>
					<li class="active"><a
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
					<th>Keyword ID</th>
					<th>Keyword</th>
					<th>Update</th>
				</tr>
				<%
					Map<Integer, KeywordEntity> keywordMap = (Map<Integer, KeywordEntity>) request.getAttribute("keywordMap");
					if (keywordMap != null) {
						int i = 0;
						for (Map.Entry<Integer, KeywordEntity> entry : keywordMap.entrySet()) {
				%>
				<tr>
					<td><%=entry.getValue().getKeywordId()%></td>
					<td><%=entry.getValue().getKeywords()%></td>
					<td><a href="javascript:updateKeyword(<%=entry.getKey()%>)">UPDATE</a></td>
				</tr>
				<tr>
					<td><span id="update_keyword_<%=entry.getKey()%>"
						style="display: none"></span></td>
				</tr>
				<%
					}
					} else {
				%>
				<tr>
					<td colspan='4' align="center">NO KEYWORDS ADDED YET</td>
				</tr>
				<%
					}
				%>
				<tr>
					<td colspan="4" align="center"><a
						href="javascript:addKeyword()">Add Keyword</a></td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<div id="add_keyword" style="display: none;">
							<form class="form-inline" action="SupportController" method="get">
								<input type="hidden" name="operation" value="addKeyword">
								<label>Keyword: </label> <input class="form-control" type="text"
									name="new_keyword"> <input
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
		function updateKeyword(keyword_id) {
			var span_id = "update_keyword_"+keyword_id;
			document.getElementById('add_keyword').style.display = "none";
			document.getElementById(span_id).style.display = "block";
			document.getElementById(span_id).innerHTML = "<form class='form-inline' action='/AssetManagementSystem/SupportController' method='get'><input type='hidden' name='operation' value='updateKeyword'><label>Keyword: </label><input class='form-control' type='text' name='update_keyword_name'><input class='form-control' type='text' name='update_keyword_id' value= '" + keyword_id +" 'readonly><input class='form-control btn btn-primary' type='submit' value='Submit'></form>";
		}

		function addKeyword() {
			document.getElementById('add_keyword').style.display = "block";
			document.getElementById('update_keyword').style.display = "none";
		}
	</script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</body>
</html>