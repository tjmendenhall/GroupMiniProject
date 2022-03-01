<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Address</title>
</head>
<body>
	<form action = "editAddressServlet" method="post">
	Owner Name: <input type ="text" name = "owner" value= "${addressToEdit.owner}">
	Building/House Number: <input type = "text" name = "bn" value= "${addressToEdit.buildingNum}">
	Apartment Number (if needed): <input type = "text" name = "an" value= "${addressToEdit.aptNum}">
	Street Name: <input type = "text" name = "sn" value= "${addressToEdit.streetName}">
	City: <input type = "text" name = "city" value= "${addressToEdit.city}">
	State: <input type = "text" name = "state" value= "${addressToEdit.state}">
	Zip: <input type = "text" name = "zip" value= "${addressToEdit.zip}">
	<input type = "hidden" name = "id" value="${addressToEdit.id}">
	<input type = "submit" value="Save Edited Address">
	</form>
	<a href="index.html">Home</a>
</body>
</html>