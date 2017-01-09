<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--Created by Eduardo Geralde Neto

 This JSP is a form to add contact's  attributes and send to our AddContactServlet to do the job. Besides that
 this Servlet uses our created tag with date picker just to show how easy it is--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Adding the tag that was created  -->
<%@ taglib tagdir="/WEB-INF/tags" prefix="ed" %>

<html>
<head>
<link href=<c:url value="css/jquery.css"/> rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>
	<c:import url="header.jsp" />
	<h1>Add Contacts</h1>
	<hr />
	<form action="addContact" method="post">
		Name: <input type="text" name="name" /> <br /> 
		E-mail: <input type="text" name="email" /> <br /> 
		Address: <input type="text" name="address" /> <br /> 
		Birth Date: <ed:dateField id="birthDate"/> <br /> 
		<hr />
		<input type="submit" value="Save" />
	</form>
	<c:import url="footer.jsp" />
</body>
</html>