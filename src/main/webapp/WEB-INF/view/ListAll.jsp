<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<h2> All Registrations </h2>
		<table border="1px solid black" border-collapse="collapse" >
			<tr>
				<th> Name </th>
				<th> City </th>
				<th> Email </th>
				<th> Mobile </th>
			</tr>
			
			<%
			ResultSet result = (ResultSet)request.getAttribute("results");
			
			while(result.next()){
				
			%>
			<tr>
			<td><%=result.getString(1)%></td>
			<td><%=result.getString(2)%></td>
			<td><%=result.getString(3)%></td>
			<td><%=result.getString(4)%></td>
			
			</tr>
			<%} %>
		</table>
	</body>
</html>