package com.digit.javaTraining.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.mvc.model.BankApp;

@WebServlet("/ChangePinController")
public class ChangePinController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		BankApp bankapp = (BankApp) session.getAttribute("bankapp");

		int pin = Integer.parseInt(req.getParameter("pin"));
		int New_pin = Integer.parseInt(req.getParameter("New_pin"));
		int Confirm_pin = Integer.parseInt(req.getParameter("Confirm_pin"));



		boolean b = bankapp.ChangePin(New_pin);
		

		if (b) {
			bankapp.setPin(New_pin);
			session.setAttribute("bankapp", bankapp);

			resp.sendRedirect("/MVC_BankApp/pinChangeSuccess.html");
		} else {
			resp.sendRedirect("/MVC_BankApp/pinChangeSuccessFail.html");

		}

	}

}
