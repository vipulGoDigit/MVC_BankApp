package com.digit.javaTraining.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.mvc.model.loan;


@WebServlet("/Loan")
public class applyLoanController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ltype=req.getParameter("ltype");
		HttpSession session=req.getSession();
		
		loan l1=new loan();
		
		boolean b= l1.applyLoan(ltype);
		if(b) {
			session.setAttribute("l1",l1);
			
			resp.sendRedirect("/BankingAppProject/loanDetail.jsp");
		}
		else {
			resp.sendRedirect("/BankingAppProject/loanDetailFail.html");

		
		}
				
		
		
	}

}
