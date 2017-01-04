<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact List</title>
</head>
<body>

	<!-- create a DAO -->
	<jsp:useBean id="dao" class="com.eduardoportfolio.jdbc.dao.ContactDao" />
	<table border="1" width="100%">
		<tr bgcolor="aaeeee" align="center">
			<td>Name</td>
			<td>Email</td>
			<td>Address</td>
			<td>Date of Birth</td>
		</tr>
		<!-- goes through the contacts list creating table rows -->
		<c:forEach var="contact" items="${dao.list}" varStatus="id">
		<!-- Using varStatus="id" to toggle the color of lines -->
			<tr bgcolor="#${id.count % 2 == 0 ? 'c0c0c0' : 'ffffff' }">
				<td>${contact.name}</td>
				<td>
				<c:choose>
					<c:when test="${not empty contact.email}">
						<a href="mailto:${contact.email}">${contact.email}</a>
					</c:when>
					<c:otherwise>
						E-mail not informed
					</c:otherwise>
				</c:choose>
				</td>
				<td>${contact.address}</td>
				<td>${contact.birthDate.time}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>