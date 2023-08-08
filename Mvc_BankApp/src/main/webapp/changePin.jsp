<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    	import="com.digit.javaTraining.mvc.model.BankApp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>

	<form action="ChangePinController" method="post">
	

	
	
	<label>Old Pin</label>
	<input type="password" name="pin"><br><br>
	<label>New Pin</label>
	<input type="password" name="New_pin"><br><br>
		<label>Confrim Pin</label>
	<input type="password" name="Confirm_pin"><br><br>
	
	<input type="submit" value="Submit">
	</form>
</body>
</html>