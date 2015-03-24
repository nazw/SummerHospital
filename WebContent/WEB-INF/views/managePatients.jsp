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

<div class="header">Manage Patients<a href="createAdmission">Add Patient</a></div>
<table  border="1" bordercolor="teal">
		<tr>
			<th>Name</th>
			<th>Sex</th>
			<th>Birth Date</th>					
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${patientsList}" var="patient">
			<tr>
				<td><c:out value="${patient.firstName} "/><c:out value="${patient.lastName} "/></td>
				<td><c:out value="${patient.gender}"/></td>
					<td><c:out value="${patient.birthDate}"/></td>			
				<td><a href="getAdmission?id=${patient.admissionId}">Edit</a></td>
				<td><a href="deleteAdmission?id=${patient.admissionId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>


</div>
</div>
</body>
</html>