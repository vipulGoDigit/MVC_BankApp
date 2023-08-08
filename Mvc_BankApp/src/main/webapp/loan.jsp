<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import=" com.digit.javaTraining.mvc.model.BankApp"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply for Loan</title>
</head>
<body>
	<h1  align="center">Apply For Loan</h1>
		
		<h2>		<%
	session=request.getSession();
		if(session==null){
			response.sendRedirect("/MVC_BankApp/HomePage.jsp");
			return;
		}
		BankApp bankapp= (BankApp)session.getAttribute("bankapp");
		if(bankapp==null){
			response.sendRedirect("/MVC_BankApp/HomePage.jsp");
			return;
		}
	String s1=(String)session.getAttribute("cust_name");
	out.println(s1+", Welcome to your account. please select a Loan type.");
	
	%>
	</h2>
	    <form action=Loan >
	<ol>
   	<li><label>Home Loan </label><input type="radio" id="ltype" name="ltype" value="Home" ><br><br></li>
   	
   	<li><label>Education Loan </label><input type="radio" name="ltype"><br><br></li>

	<li><label>Vechile Loan </label><input type="radio" name="ltype"><br><br></li>
	<li><label>Gold Loan </label><input type="radio" name="ltype"><br><br></li>
	<li><label>Personal Loan </label><input type="radio" name="ltype"><br><br></li>
	
	

		 	<a href="Loan">Apply</a>
        
        
        
        
        
		</form>
		
	
</body>
</html>