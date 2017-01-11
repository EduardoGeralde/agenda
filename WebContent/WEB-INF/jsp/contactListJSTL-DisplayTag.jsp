<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--Created by Eduardo Geralde Neto

This JSP lists all contacts from the DB more easily and readable using display tag --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<!-- Importing header  -->
<c:import url="/WEB-INF/jsp/header.jsp" />

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/contactList.css" rel="stylesheet" type="text/css"/>
		<title>Contact List</title>
	</head>
	<body>

		<!-- Using displayTag to show the contact list with CSS file -->
		<display:table name="contacts" sort ="list" pagesize="10" class="contactList.css">
			<display:column property="name" title="Name" headerClass="r"/>
			<display:column property="email" title="Email"/>
			<display:column property="address" title="Address" />
			<display:column property="birthDate.time" title= "Date of Birth" format="{0,date,dd-MM-yyyy}" style="text-align:center;" />
			<display:column property="id" title="Remove ID" href="mvc?logic=RemoveLogic" paramId="id" style="text-align:center;"/>
			<display:column property="id" title="Update ID" href="mvc?logic=UpdateLogic" paramId="id" style="text-align:center;"/>
		</display:table>
		
		<a href="mvc?logic=AddLogic">Add Contact</a>
		
		<!-- importing footer -->
		<c:import url="/WEB-INF/jsp/footer.jsp" />
	</body>
</html>