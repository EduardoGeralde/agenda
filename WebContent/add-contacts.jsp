<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ed" %>

<html>
<head>
<link href="/schedule/WebContent/css/base/jquery-ui-1.9.2.custom.css" rel="stylesheet">
<script src="/schedule/WebContent/js/jquery-1.8.3.js"></script>
<script src="/schedule/WebContent/js/jquery-ui-1.9.2.custom.js"></script>
<title>Add Contacts</title>
</head>
<body>
	<c:import url="header.jsp" />
	<h1>Add Contacts</h1>
	<hr />
	<form action="addContact" method="post">
		Name: <input type="text" name="name" /> <br /> 
		E-mail: <input type="text" name="email" /> <br /> 
		Address: <input type="text" name="address" /> <br /> 
		Birth Date: <ed:inputDate id="birthDate"/> <br /> 
		<hr />
		<input type="submit" value="Save" />
	</form>
	<c:import url="footer.jsp" />
</body>
</html>