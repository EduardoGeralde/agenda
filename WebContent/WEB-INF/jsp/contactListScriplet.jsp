<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, java.text.*, java.sql.*, com.eduardoportfolio.jdbc.dao.*, 
																					     com.eduardoportfolio.jdbc.model.*"%>
																		
<%--Created by Eduardo Geralde Neto

In this JSP we use Scriplets to see how we can put Java and HTML together just with a simple tag, but this
kind of mixing Java and HTML turn the code hard to read and maintain. For example, If our Front End 
Team has to make some changes or improvements, they will have to know Java well or they could not do it.
But, we have to know it, because there are applications that still using Scriptlets with HTML.--%>	
				
<!--Importing header  -->
<c:import url="/WEB-INF/jsp/header.jsp"/>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Contact List</title>
		<style type="text/css">
			td {
				border: 1px solid black;
			}
			thead th {
				border: 1px dashed blue;
			}
		</style>
	</head>
	<body>
		<table border="1" width="100%">
			<tr bgcolor="ff6600" align="center">
				<td>Name</td>
				<td>Email</td>
				<td>Address</td>
				<td>Date of Birth</td>
			</tr>
				<%
					Connection connection = (Connection) request.getAttribute("connection");
					ContactDao dao = new ContactDao(connection);
					List<Contact> contacts = dao.getList();
					for (Contact contact : contacts) {
				%>
			<tr>
				<td><%=contact.getName()%></td>
				<td><%=contact.getEmail()%></td>
				<td><%=contact.getAddress()%></td>
				<td align="center"><%=new SimpleDateFormat("dd/MM/yyyy").format(contact.getBirthDate().getTime())%></td>
			</tr>
			<%
				}
			%>
		</table>
		<!--Importing footer -->
		<c:import url="/WEB-INF/jsp/footer.jsp"/>
	</body>
</html>