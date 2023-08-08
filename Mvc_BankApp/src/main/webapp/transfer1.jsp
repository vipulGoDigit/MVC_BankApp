<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.mvc.model.BankApp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	background-image: url("images/image.jpg");
	background-size: cover;
	background-repeat: no-repeat;
	position: relative;
}

body::before {
	content: "";
	background-image: inherit;
	background-size: cover;
	background-repeat: no-repeat;
	filter: blur(2px);
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: -1;
}

.container {
	max-width: 400px;
	padding: 30px;
	background-color: rgba(255, 255, 255, 0.7);
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
	text-align: center;
}

form {
	margin-top: 20px;
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
}

input[type="text"], input[type="number"], input[type="password"] {
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
	width: 100%;
	margin-top: 3px;
	margin-bottom: 3px;
}

input[type="submit"] {
	background-color: #3366cc;
	color: #fff;
	border: none;
	padding: 10px 20px;
	border-radius: 4px;
	font-weight: bold;
	cursor: pointer;
	transition: background-color 0.4s ease;
}

input[type="submit"]:hover {
	background-color: #005580;
}
</style>
</head>
<body>
	<%
	session = request.getSession();
	if (session == null) {
		response.sendRedirect("/MVC_BankApp/login.html");
		return;
	}

	BankApp bankapp = (BankApp) session.getAttribute("bankapp");
	if (bankapp == null) {
		response.sendRedirect("/MVC_BankApp/login.html");
		return;
	}
	%>

	<h1 align="center">Please fill the transfer details</h1>
	    <form action="TransferController" method="post">
	<ol>
		

       
	<li><label>Customer ID </label><input type="text" name="cust_id"><br><br></li>

        <li><label>Bank Name</label><input type="text" name="bank_name"><br><br></li>

        <li><label>IFSC Code</label> <input type="text" name="ifsc"><br><br></li>

       <li> <label>Sender Account Number</label><input type="text" name="sender_accno"><br><br></li>
       <li> <label>Receiver IFSC Code</label><input type="text" name="receiver_ifsc"><br><br></li>
       <li> <label>Receiver Account Number</label><input type="text" name="Receiver_accno"><br><br></li>
       <li> <label>Amount</label><input type="text" name="amount"><br><br></li>

       <li> <label>Pin</label> <input type="password"name="pin"> </li><br><br>
       
       <input type="submit" value="Transfer Amount">
		
		
	</ol>


</body>
</html>
