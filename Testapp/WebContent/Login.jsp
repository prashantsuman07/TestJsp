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
<%if(msg!=null) { %>
<%=msg %>
<%} %>
<fieldset>
<legend>EMPLOYEE LOGIN</legend>
<form method='POST' action='./Login'>

		<table border="1" align='center'>
			<tr>
				<td>username:</td>
				<td><input type='text' name='uname' required></td>
			</tr>
			<tr>
				<td>pswd:</td>
				<td><input type='password' name='pswd' required></td>
			</tr>
			<tr>
				<td><a href="./updatepass">forgot pswd: </a></td>
				<td><a href="./regpage">Register user! </a></td>
			</tr>
			<tr>
				
				<td colspan="3" align="center">
				<input type=submit value='Login'></td>
			</tr>
		</table>
</form>
</fieldset>	
</body>
</html>