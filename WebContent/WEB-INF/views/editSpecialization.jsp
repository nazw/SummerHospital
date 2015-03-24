<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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

<form:form method="POST" action="updateSpecialization" modelAttribute="specialization">
		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><form:textarea path="description" rows="8" cols="30" /></td>
			</tr>
			<tr>			
				<td colspan="2">
				<form:hidden path="specializationId"/>
				<input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>



</div>
</div>
</body>
</html>