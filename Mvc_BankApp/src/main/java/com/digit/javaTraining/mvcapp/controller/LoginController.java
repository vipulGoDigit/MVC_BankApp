package com.digit.javaTraining.mvcapp.controller;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.mvc.model.BankApp;
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			int cust_id = Integer.parseInt(req.getParameter("cust_id"));
			int pin = Integer.parseInt(req.getParameter("pin"));
			
		

			  
				BankApp bankapp= new BankApp();
				bankapp.setCust_id(cust_id);
				bankapp.setPin(pin);
//				bankapp.setBalance(balance);
//				bankapp.setBank_name(bank_name);
//				bankapp.setIfsc_code(ifsc_code);
//				bankapp.setCust_Name(cust_name);
//				bankapp.setEmail(email);
//				bankapp.setPhone(phone);
				
				

				

				

				
			boolean b =bankapp.login();
			if(b) {
				HttpSession session= req.getSession(true);
				session.setAttribute("bankapp", bankapp);
                //session.setAttribute("accno", bankapp.getAccno());

			
				resp.sendRedirect("/MVC_BankApp/HomePage.jsp");
			}
			else {
				resp.sendRedirect("/MVC_BankApp/loginFail.html");

			}
			


	}

}
