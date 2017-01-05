<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--Created by Eduardo Geralde Neto
After pass through the Servlets, where it was mixing Java with HTML. The reading was confusing
and the code difficult to maintain . Now let's have a look through the JSP with scriplets. There are still
 many applications on the market today made entirely using scriptlets with some code in the middle of 
 HTML. In this simple case, JSP still mixing HTML with Java, but we can evolve much more, at the point 
 that we won't do it anymore --%>

<%@ page
	import="java.util.*, 
						com.eduardoportfolio.jdbc.dao.*, 
						com.eduardoportfolio.jdbc.model.*,
						java.text.*"%>
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
		<tr bgcolor="aaeeee" align="center">
			<td>Name</td>
			<td>Email</td>
			<td>Address</td>
			<td>Date of Birth</td>
		</tr>
		<%
			ContactDao dao = new ContactDao();
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

</body>
</html>