<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<!-- Importing header  -->
<c:import url="header.jsp" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact List with DisplayTag</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/contactList.css" type="text/css"/>
</head>
<body>

	<!-- create a DAO -->
	<jsp:useBean id="dao" class="com.eduardoportfolio.jdbc.dao.ContactDao" />

	<!-- Using displayTag to show the contact list with CSS file -->
	<display:table name="${dao.list}" sort ="list" pagesize="10" class="contactList.css">
		<display:column property="name" title="Name" />
		<display:column property="email" title="Email"/>
		<display:column property="address" title="Address" />
		<display:column property="birthDate.time" title= "Date of Birth" format="{0,date,dd-MM-yyyy}"  />
	</display:table>

	<!-- importing footer -->
	<c:import url="footer.jsp" />

</body>
</html>