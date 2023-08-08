<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.mvc.model.BankApp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
	<h1 align="center">Welcome to the bank</h1>
	<%
	session = request.getSession();
	BankApp bankApp = (BankApp) session.getAttribute("bankapp");
	String s1 = bankApp.getCust_name();
	out.println(s1 + ", Welcome to your account. please select an operation to perform.");
	%>
	<br>
	<br>
	<ol>
		<li><a href="balance.jsp">check Balance</a><br></li>
		<br>
		<br>
		<li><a href="changePin.jsp">change Pin</a></li>
		<br>
		<br>
		<li><a href="loan.jsp">Apply for Loan</a></li>
		<br>
		<br>
		<li><a href="transfer1.jsp">Transfer Amount</a></li>
		<br>
		<br>
		<li><a href="logOut">Log Out</a></li>
	</ol>

</body>
</html>