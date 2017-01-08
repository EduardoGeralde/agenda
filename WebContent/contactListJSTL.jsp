<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--This contact list uses expression language and JSTL, to do almost the same thing of the 
contactListScriplet. But if we look at this code, we can read and  maintain more easily. Notice that code we do
not mix HTML and Java anymore, making the code more elegant. --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- Importing header  -->
<c:import url="header.jsp"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact List</title>
</head>
<body>

	<!-- create a DAO -->
	<jsp:useBean id="dao" class="com.eduardoportfolio.jdbc.dao.ContactDao" />
	<table border="1" width="100%">
		<tr bgcolor="ff6600" align="center">
			<td>Name</td>
			<td>Email</td>
			<td>Address</td>
			<td>Date of Birth</td>
		</tr>
		<!-- goes through the contacts list creating table rows -->
		<c:forEach var="contact" items="${dao.list}" varStatus="id">
			<!-- using varStatus="id" to toggle the color of lines -->
			<tr bgcolor="#${id.count % 2 == 0 ? 'c0c0c0' : 'ffffff' }">
				<td>${contact.name}</td>
				<td>
				<!-- If contact has email, insert link to it, if  not, show  "contact missing email" in contact list-->
				<c:choose>
					<c:when test="${not empty contact.email}">
					<a href="mailto:${contact.email}">${contact.email}</a>
					</c:when>
					<c:otherwise>
					Contact missing email
					</c:otherwise>
				</c:choose>
				</td>
				<td>${contact.address}</td>
				<td align="center">
				<!-- formatting date for the pattern that we want -->
				<fmt:formatDate value="${contact.birthDate.time}" pattern="dd-MM-yyyy" /> 
				</td>
			</tr>
		</c:forEach>
	</table>
	<!-- importing footer -->
	<c:import url="footer.jsp"/>
</body>
</html>