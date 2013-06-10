<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<h2>Customer Registration</h2>
	<div style="color: red;">
		<div>${errorMessages}</div>
	</div>
	<div>
		<form method="POST" action="registration">
			<div>First Name: <input type="text" name="firstName" required></div>
			<div>Last Name:  <input type="text" name="lastName" required></div>
			<div>Username: <input type="text" name="userName" required></div>
			<div>Password:  <input type="password" name="password" required></div>
			<div>Birthday: <input type="date" name="birthday" required ></div>
			<div>Address: <input type="text" name="address" required ></div>
			<div> 
				  <input type="submit" value="register">
				  <input type="reset" value="clear"> 
			</div>
		</form>
	</div>
</body>
</html>