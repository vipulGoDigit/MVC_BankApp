<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.mvc.model.BankApp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Page</title>
</head>
<body>
	<h3>
		<%
		session = request.getSession();
		BankApp bankApp = (BankApp) session.getAttribute("bankapp");
		out.println("balance=" + bankApp.getBalance());
		out.println("accno=" + bankApp.getAccno());
		out.println("pin=" + bankApp.getPin());
		out.println("cust_id=" + bankApp.getCust_id());

		%>
	</h3>
	<a href="HomePage.jsp">HomePage</a>

</body>
</html>