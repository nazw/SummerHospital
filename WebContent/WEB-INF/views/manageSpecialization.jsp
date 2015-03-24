<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="main_container">
<div class="col" id="left"><%@include file="adminMainMenu.jsp" %></div>
<div class="col" id="right">

<div class="header">Manage Specializations<a href="createSpecialization">Add Specialization</a></div>
<table  border="1" bordercolor="teal">
		<tr>
			<th>Name</th>
			<th>Description</th>					
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${specializationsList}" var="specialization">
			<tr>
				<td><c:out value="${specialization.name}"/></td>
				<td><c:out value="${specialization.description}"/></td>			
				<td><a href="getSpecialization?id=${specialization.specializationId}">Edit</a></td>
				<td><a href="deleteSpecialization?id=${specialization.specializationId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>


</div>
</div>
</body>
</html>