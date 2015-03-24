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
<div><c:if test="${errorMessage != null}" ><h2><span style="padding-left: 100px;"><c:out value="${errorMessage}"></c:out></span></h2></c:if></div>
   <form:form method="POST" action="systemUserLogin" modelAttribute="systemUser">
   
   <table>
   <tr><td>User Name</td><td><form:input path="email"/></td></tr>
    <tr><td>Password</td><td><form:password path="password"/></td></tr>
     <tr><td></td><td><input type="submit" value="Submit" /> </td></tr>
   </table>
   
   </form:form>
</body>
</html>