<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<div style="color: red;">
		<div>${errorMessages}</div>
	</div>
	<div>
		<h3>Customer Login</h3>
		<form method="POST" action="welcome">
			<div>Username: <input type="text" name="userName" required></div>
			<div>Password:  <input type="password" name="password" required></div>
			<div> <input type=submit value="Login"> </div>
		</form>
	</div>
</body>
</html>