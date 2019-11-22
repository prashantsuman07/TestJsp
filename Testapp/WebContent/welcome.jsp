
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg=(String)request.getAttribute("msg"); %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><%if(msg!=null) { %>
<%=msg %>
<%} %></h1>
<br><br><br><br><br>
	<h1>click me to<a href="./homepage">log out</a></h1>
</body>
</html>