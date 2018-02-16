<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="validate.jsp" method="GET" required>
<h5>Driver</h5>
<input type="text" name="driver" value="com.mysql.jdbc.Driver" required>
<h5>Url</h5>
<input type="text" name="url" value="jdbc:mysql://localhost:3306/northwind" required>
<h5>Enter user name</h5>
<input type="text" name="username" required>
<br>
<h5>Enter password</h5>
<input type="password" name="password" required>
<br>
<h5>Enter Query</h5>
<input type="text" name="query" required>
<br>
<input type="submit">
</form>
</body>
</html>