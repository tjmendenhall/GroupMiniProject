<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
	<form action="createNewListServlet" method="post">
		List Name: <input type="text" name="listName"><br />
		Date Created: <input type="text" name="month" placeholder="mm" size="4">
		<input type="text" name="day" placeholder="dd" size="4"> <input
			type="text" name="year" placeholder="yyyy" size="4"> 
		User: <input type="text" name="userName"><br /> 
		Available Addresses:<br /> <select name="allAddressesToAdd" multiple size="6">
			<c:forEach items="${requestScope.allAddresses}" var="currentaddress">
				<option value="${currentaddress.id}">${currentaddress.owner} ${currentaddress.buildingNum} ${currentaddress.aptNum} ${currentaddress.city} ${currentaddress.state} ${currentaddress.zip}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create list and Add Addresses">

	</form>
	<a href="index.html">Home</a>
</body>
</html>