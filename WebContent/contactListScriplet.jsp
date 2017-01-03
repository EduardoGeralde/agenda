<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<table>
		<%
			ContactDao dao = new ContactDao();
			List<Contact> contacts = dao.getList();
			for (Contact contact : contacts) {
		%>
		<tr>
			<td><%=contact.getName()%></td>
			<td><%=contact.getEmail()%></td>
			<td><%=contact.getAddress()%></td>
			<td><%=new SimpleDateFormat("dd/MM/yyyy").format(contact.getBirthDate().getTime())%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>