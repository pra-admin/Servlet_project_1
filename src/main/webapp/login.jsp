<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
	
	<div class="log-form">
  <h2>Login to your account</h2>
  <form action="login" method="post">
    UserName <input type="text" title="username"  name="username"/>
    Password <input type="password" title="password" name="password"/>
    <button type="submit" class="btn">Login</button>
    <a href="signup">SignUp</a>
  </form>
</div>

	<%
		if(request.getAttribute("error")!=null){
			out.println(request.getAttribute("error"));
		}
	%>
	
	</body>
</html>