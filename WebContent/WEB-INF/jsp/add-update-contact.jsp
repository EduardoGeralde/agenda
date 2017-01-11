<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--Created by Eduardo Geralde Neto

 This JSP is a form to add contact's  attributes and send to our AddContactServlet to do the job. Besides that
 this Servlet uses our created tag with date picker just to show how easy it is--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Adding the tag created  -->
<%@ taglib tagdir="/WEB-INF/tags" prefix="ed" %>

<!-- Importing header  -->
<c:import url="/WEB-INF/jsp/header.jsp" />

<html>
	<head>
		<link href=<c:url value="css/jquery.css"/> rel="stylesheet">
		<script src="js/jquery.js"></script>
		<script src="js/jquery-ui.js"></script>
	</head>
	<body>
		<h1>Add/Update Contacts</h1>
		<hr />
		<form action="mvc?logic=AddUpdateContactLogic" method="post" name="contact">
			ID: <input type="text" name="id" value="${contact.id}"/> <br />
			Name: <input type="text" name="name" value="${contact.name}" /> <br /> 
			E-mail: <input type="text" name="email" value="${contact.email}" /> <br /> 
			Address: <input type="text" name="address" value="${contact.address}" /> <br /> 
			<fmt:formatDate pattern="dd/MM/yyyy" value="${contact.birthDate.time}" var="formattedDate"/>
			Birth Date: <ed:dateField id="birthDate" value="${formattedDate}"/> <br /> 
			<hr />
			<input type="submit" value="Save" />
		</form>
		<c:import url="/WEB-INF/jsp/footer.jsp" />
	</body>
</html>