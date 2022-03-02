<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit An Existing List</title>
</head>
<body>
	<form action="editListDetailsServlet" method="post">
		<input type="hidden" name="id" value="${listToEdit.id}"> 
		List Name: <input type="text" name="listName" value="${listToEdit.listName}"><br /> 
		Date Created: <input type="text" name="month" placeholder="mm" size="4" value="${month}">
						<input type="text" name="day" placeholder="dd" size="4" value="${date}">, 
						<input type="text" name="year" placeholder="yyyy" size="4" value="${year}"> 
		User: <input type="text" name="userName" value="${listToEdit.user.userName}"><br />
		Available Addresses:<br /> <select name="allAddressesToAdd" multiple size="6">
			<c:forEach items="${requestScope.allAddresses}" var="currentaddress">
				<option value="${currentaddress.id}">${currentaddress.owner} ${currentaddress.buildingNum} ${currentaddress.aptNum} ${currentaddress.streetName} ${currentaddress.city} ${currentaddress.state} ${currentaddress.zip}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Edit List and Add Addresses">
	</form>
	<a href="index.html">Home</a>
</body>
</html>