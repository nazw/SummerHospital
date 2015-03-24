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

<div class="header">Manage Doctors<a href="createDoctor">Add Doctor</a></div>
<table  border="1" bordercolor="teal">
		<tr>
			<th>Name</th>
			<th>Description</th>					
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${doctorsList}" var="doctor">
			<tr>
				<td><c:out value="${doctor.systemUser.firstName} "/><c:out value="${doctor.systemUser.lastName} "/></td>
				<td><c:out value="${doctor.description}"/></td>			
				<td><a href="getDoctor?id=${doctor.doctorId}">Edit</a></td>
				<td><a href="deleteDoctor?id=${doctor.doctorId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>


</div>
</div>
</body>
</html>