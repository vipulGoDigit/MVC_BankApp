//package com.digit.javaTraining.mvcapp.controller;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.digit.javaTraining.mvc.model.BankApp;
//
//
//@WebServlet("/CheckBalanceController")
//public class CheckBalanceController extends HttpServlet {
//	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//	
//	
//		    HttpSession session = req.getSession();
//		    
//		    int balance = (int) session.getAttribute("bankAppbalance");
//
//		    
//			BankApp bankApp = (BankApp) session.getAttribute("bankapp");
//			int s1 = bankApp.getBalance();
//			
//
//
////		    boolean b=bankapp.CheckBalance();
////		    if (b) {
////		       
////		        resp.sendRedirect("/MVC_BankApp/HomePage.jsp");
////		    } else {
////		        resp.sendRedirect("/MVC_BankApp/loginFail.html");
////		    }
//		}
//
//		
//}	
//		
//		
//		
//		
//		
//		
////		HttpSession session= req.getSession();
////		session.setAttribute("accno", accno);
////	//int balance = Integer.parseInt(req.getParameter("balance"));
////
////		int accno=(int)session.getAttribute("accno");
////		System.out.println(accno);
//		
////	BankApp bankapp= new BankApp();
////	
////	int balance=bankapp.getBalance();
////	
//
