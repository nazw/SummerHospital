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

<form:form method="POST" action="updateDoctor" modelAttribute="doctor">
		<table>
			<tr>
				<td>First Name</td>
				<td><form:input path="systemUser.firstName" /></td>
			</tr>
				<tr>
				<td>Last Name</td>
				<td><form:input path="systemUser.lastName" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="systemUser.email" /></td>
			</tr>
				<tr>
				<td>Pasword</td>
				<td><form:input path="systemUser.password" /></td>
			</tr>
				<td>Licence No</td>
				<td><form:input path="licenceNo" /></td>
			</tr>
					<tr>
				<td>Specialization</td>
				<td><form:select path="specialization.specializationId" items="${specializationList}" 
				itemLabel="name" itemValue="specializationId">
				<option value="0">--Please select--</option>
				</form:select>
				</td>
			</tr>
					<tr>
				<td>Account Status</td>
				<td><form:select path="accountStatus" items="${accountStatusList}">
				<option value="0">--Please select--</option>
				</form:select>
				</td>
			</tr>
				<tr>
				<td>Gender</td>
				<td><form:select path="systemUser.gender" items="${genderList}">
				<option value="0">--Please select--</option>
				</form:select>
				</td>
			</tr>
				<tr>
				<td>Phone No</td>
				<td><form:input path="systemUser.phoneNo" /></td>
			</tr>
			<tr>
				<td>Birth Date</td>
				<td><form:input path="systemUser.birthDate" placeholder="MM/dd/yyyy"/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:textarea path="systemUser.address" rows="8" cols="30" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><form:textarea path="description" rows="8" cols="30" /></td>
			</tr>
			<tr>
				<td>Profile</td>
				<td><form:textarea path="systemUser.profile" rows="8" cols="30" /></td>
			</tr>
			<tr>			
				<td colspan="2"><form:hidden path="doctorId" /> <input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>



</div>
</div>
</body>
</html>