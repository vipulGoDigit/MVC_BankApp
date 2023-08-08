package com.digit.javaTraining.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.mvc.model.BankApp;

@WebServlet("/TransferController")
public class TransferController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		BankApp bankapp = (BankApp) session.getAttribute("bankapp");

		int cust_id = Integer.parseInt(req.getParameter("cust_id"));
		String bank_name = req.getParameter("bank_name");

		String ifsc = req.getParameter("ifsc");

		int sender_accno = Integer.parseInt(req.getParameter("sender_accno"));
		String Receiver_ifsc = req.getParameter("receiver_ifsc");
		int Receiver_accno = Integer.parseInt(req.getParameter("Receiver_accno"));

		int pin = Integer.parseInt(req.getParameter("pin"));

		int amount = Integer.parseInt(req.getParameter("amount"));

		if (bankapp.getPin() != pin) {
			session.setAttribute("ERROR_NAME", "Transfer Amount Failed!");
			session.setAttribute("ERROR_MSG", "Invalid PIN! You are not Authenticated!");
			session.setAttribute("FILE_TO_REDIRECT", "home.jsp");

			resp.sendRedirect("/BankingWithMVC/Failure.jsp");
			return;
		}

		if (bankapp.getCust_id() != cust_id || bankapp.getAccno() != sender_accno
				|| !(bankapp.getIfsc_code().equals(ifsc))) {
			session.setAttribute("ERROR_NAME", "Transfer Amount Failed!");
			session.setAttribute("ERROR_MSG", "Invalid Customer Details! You are not Authenticated!");
			session.setAttribute("FILE_TO_REDIRECT", "home.jsp");

			resp.sendRedirect("/BankingWithMVC/Failure.jsp");
			return;
		}
		if (bankapp.getBalance() < amount) {
			session.setAttribute("ERROR_NAME", "Transfer Amount Failed!");
			session.setAttribute("ERROR_MSG", "Insufficient Funds! You do not have enough amount to Transfer");
			session.setAttribute("FILE_TO_REDIRECT", "home.jsp");

			resp.sendRedirect("/BankingWithMVC/Failure.jsp");
			return;
		}
		if (amount <= 0) {
			session.setAttribute("ERROR_NAME", "Transfer Amount Failed!");
			session.setAttribute("ERROR_MSG", "Invalid Amount! Cannot transfer " + amount + "!");
			session.setAttribute("FILE_TO_REDIRECT", "home.jsp");

			resp.sendRedirect("/BankingWithMVC/Failure.jsp");
			return;
		}

		boolean transferStatus = bankapp.Transferamount(cust_id, sender_accno, ifsc, amount, Receiver_accno,
				Receiver_ifsc, pin);
		if (transferStatus) {
			session.setAttribute("SUCCESS_NAME", "Transaction Successful!");
			session.setAttribute("SUCCESS_MSG", "Amount Transfered Successfully!");
			session.setAttribute("FILE_TO_REDIRECT", "home.jsp");

			resp.sendRedirect("/BankingWithMVC/Success.jsp");
			return;
		} else {
			session.setAttribute("ERROR_NAME", "Transfer Amount Failed!");
			session.setAttribute("ERROR_MSG", "Transfer Fail!");
			session.setAttribute("FILE_TO_REDIRECT", "home.jsp");

			resp.sendRedirect("/BankingWithMVC/Failure.jsp");
			return;
		}
	}

}
