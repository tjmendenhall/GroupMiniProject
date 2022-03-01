<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Displaying Address List</title>
</head>
<body>
	<form method = "post" action = "navigationServlet">
	<table class="table table-striped table-hover">
	<c:forEach items="${requestScope.allAddresses}" var="currentaddress">
	<tr>
 		<td><input type="radio" name="id" value="${currentaddress.id}"></td>
 		<td>Owner Name: ${currentaddress.owner}<br /></td>
 		<td>Building/House Number: ${currentaddress.buildingNum}<br /></td>
 		<td>Apartment Number (if needed): ${currentaddress.aptNum}<br /></td>
 		<td>Street Name: ${currentaddress.streetName}<br /></td>
 		<td>City: ${currentaddress.city}<br /></td>
 		<td>State: ${currentaddress.state}<br /></td>
 		<td>Zip: ${currentaddress.zip}<br /></td>
 	</tr>
	</c:forEach>
	</table>
	<br />
	<input type = "submit" value = "edit" name="doThisToAddress" class="btn btn-warning">
	<input type = "submit" value = "delete" name="doThisToAddress" class="btn btn-danger">
	<input type="submit" value = "add" name = "doThisToAddress" class="btn btn-success">
	</form>
	<a href="index.html">Home</a>
	<br />
	<a href="viewAllListsServlet">View all address lists</a>
	<br />
	<a href="addAddressesForListServlet">Create a new address list</a>
</body>
</html>