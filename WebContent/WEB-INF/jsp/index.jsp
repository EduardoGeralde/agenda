<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--Created by Eduardo Geralde Neto

This JSP is just our simple welcome file.--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Importing header  -->
<c:import url="/WEB-INF/jsp/header.jsp" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
<title>Welcome to the Schedule</title>
</head>
<body>
	<h2>Welcome to the Eduardo's schedule</h2>
	<h3>Welcome to the Eduardo's schedule</h3>
	<h4>Welcome to the Eduardo's schedule</h4>
	<h5>Welcome to the Eduardo's schedule</h5>
	<h6>Welcome to the Eduardo's schedule</h6>

	<div id="d1">
	<a href="mvc?logic=ContactListLogic">Entrar</a>
	</div>
	<!-- importing footer -->
	<c:import url="/WEB-INF/jsp/footer.jsp" />
</body>
</html>