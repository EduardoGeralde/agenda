<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Testing Print Methods</title>
</head>
<body>

<%--Created by Eduardo Geralde Neto 
-Just testing the print methods in JSP : out.println, equal sign (=) and System.out.println--%>

	<%
		String message = "Welcome to the Schedule System !";
	%>
	<%
		out.println(message);
	%>

	<br />

	<%
		String developed = "Developed by Eduardo Geralde Neto";
	%>
	<%=developed%>

	<%
		System.out.println("Everything was executed");
	%>

</body>
</html>