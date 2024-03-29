<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width:device-width, initial-scale=1">
	<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
	<title>Profile</title>
</head>
<body>

<br/>
<div>
	<h1>The Highly Rated Profiles Details are:</h1>
	<c:if test="${empty profiles}">
	<h3> Profile details not found! <h3/>
		</c:if>
		<c:if test="${not empty profiles}">
		<table class="table table-striped">
			<thead>
			<tr>
				<th>Profile</th>
				<th>Rate</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${profiles}" var="cd">
				<tr>
					<td>${cd.profileID}</td>
					<td>${cd.rate}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</c:if>
</div>
	<div class="container pt-1">
		<form action="home.jsp">
			<input type="submit" value="Home" class="btn btn-success" style="display: table; margin: auto !important; width: 50% !important;"/>
		</form>
	</div>

	</div>


	<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</body>
</html>
