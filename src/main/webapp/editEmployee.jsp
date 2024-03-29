<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
	This is the Edit Employee page
	This page displays fields to edit an Employee 
	The details are sent to the UpdateEmployeeController class in resources package
-->

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Edit Employee</title>
	<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />	
	<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

		<br/>
	<h2 style="text-align: center">Edit Employee:</h2>
	<c:if test="${empty editEmployee}">
		<h3> Employee details not found! <h3/> 
	</c:if>
	<c:if test="${not empty editEmployee}"> 	
	<form action="updateEmployee" method="POST">
		<div class="row">
	<div class="col-md-6">
		<div class="form-group">
			<label for="employeeRole">Role</label>
			<select name="employeeRole" id="employeeRole" class="form-control">
				<c:if test="${editEmployee.employeeRole=='Manager'}">
					<option value="Manager" selected>Manager</option>
					<option value="CustRep">Customer Representative</option>
				</c:if>
				<c:if test="${editEmployee.employeeRole=='CustRep'}">
					<option value="Manager">Manager</option>
					<option value="CustRep" selected>Customer Representative</option>
				</c:if>
			</select>
		</div>
	  <div class="form-group">
	    <label for="employeeEmail">Email address</label>
	    <input type="email" class="form-control" id="employeeEmail" name="employeeEmail" placeholder="Enter email" value='${editEmployee.email}' required>
	  </div>
  	  <div class="form-group">
	    <label for="employeeFirstName">First Name</label>
	    <input type="text" class="form-control" id="employeeFirstName" name="employeeFirstName" placeholder="First Name" value='${editEmployee.firstName}' required>
	  </div>
  	  <div class="form-group">
	    <label for="employeeLastName">last Name</label>
	    <input type="text" class="form-control" id="employeeLastName" name="employeeLastName" placeholder="Last Name" value='${editEmployee.lastName}' required>
	  </div>
   	  <div class="form-group">
	    <label for="employeeAddress">Address</label>
	    <input type="text" class="form-control" id="employeeAddress" name="employeeAddress" placeholder="Address" value='${editEmployee.address}' required>
	  </div>
   	  <div class="form-group">
	    <label for="employeeCity">City</label>
	    <input type="text" class="form-control" id="employeeCity" name="employeeCity" placeholder="City" value='${editEmployee.city}' required>
	  </div>
			</div>
			<div class="col-md-6">
   	  <div class="form-group">
	    <label for="employeeState">State</label>
	    <input type="text" class="form-control" id="employeeState" name="employeeState" placeholder="State" value='${editEmployee.state}' required>
	  </div>
   	  <div class="form-group">
	    <label for="employeeZipcode">Zipcode</label>
	    <input type="text" class="form-control" id="employeeZipcode" name="employeeZipcode" placeholder="Zipcode" value='${editEmployee.zipCode}' required>
	  </div>
   	  <div class="form-group">
	    <label for="employeeTelephone">Telephone</label>
	    <input type="text" class="form-control" id="employeeTelephone" name="employeeTelephone" placeholder="Telephone number" value='${editEmployee.telephone}' required>
	  </div>
   	  <div class="form-group">
	    <label for="employeeSSN">SSN (Employee ID)</label>
	    <input type="text" class="form-control" id="employeeSSN" name="employeeSSN" placeholder="XXX-XX-XXXX" value='${editEmployee.employeeID}' readonly>
	  </div>
   	  <div class="form-group">
	    <label for="employeeStartDate">Start Date</label>
	    <input type="text" class="form-control" id="employeeStartDate" name="employeeStartDate" placeholder="YYYY-MM-DD" value='${editEmployee.startDate}' required>
	  </div>
   	  <div class="form-group">
	    <label for="employeeHourlyRate">Hourly Rate</label>
	    <input type="text" class="form-control" id="employeeHourlyRate" name="employeeHourlyRate" placeholder="Hourly Rate" value='${editEmployee.hourlyRate}' required>
	  </div>
			</div>

		</div>
	  <button type="submit" class="btn btn-primary" style="display: table; margin: auto !important; width: 50% !important;">Submit</button>
	</form>
	</c:if>
	</div>
	<div class="container pt-1">
		<form action="home.jsp">
			<input type="submit" value="Home" class="btn btn-success" style="display: table; margin: auto !important; width: 50% !important;"/>
		</form>
	</div>


</body>
</html>
