<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Address List</title>
</head>
<body>
	<form method="post" action="listNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allLists}" var="currentlist">
				<tr>
					<td><input type="radio" name="id" value="${currentlist.id}"></td>
					<td><h2>${currentlist.listName}</h2></td>
				</tr>

				<tr>
					<td colspan="3">Date Created: ${currentlist.dateCreated}</td>
				</tr>

				<tr>
					<td colspan="3">User: ${currentlist.user.userName}</td>
				</tr>
				<c:forEach var="listVal" items="${currentlist.listOfAddresses}">
					<tr>
						<td></td>
						<td colspan="3">${listVal.id}, ${listVal.owner}, ${listVal.buildingNum}, ${listVal.aptNum}, ${listVal.streetName}, ${listVal.city}, ${listVal.state}, ${listVal.zip}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToList"> 
		<input type="submit" value="delete" name="doThisToList"> 
		<input type="submit" value="add" name="doThisToList">

	</form>
	<a href="addAddressesForListServlet">Create a new list</a>
	<br />
	<a href="index.html">Home</a>
</body>
</html>