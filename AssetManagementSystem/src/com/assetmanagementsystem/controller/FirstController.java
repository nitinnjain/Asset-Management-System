package com.assetmanagementsystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assetmanagementsystem.utility.Utility;

public class FirstController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "must-revalidate");
		response.setHeader("Pragma", "no-cache");

		HttpSession session = request.getSession(false);

		if(session == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		else {
			if(Utility.ADMIN.equals((String)session.getAttribute("department"))) {
				request.getRequestDispatcher("/AdminJsp/adminHome.jsp").forward(request, response);
			}

			else if(Utility.EMPLOYEE.equals((String)session.getAttribute("department"))) {
				request.getRequestDispatcher("/EmployeeJsp/employeeHome.jsp").forward(request, response);
			}

			else if(Utility.MANAGER.equals((String)session.getAttribute("department"))) {
				request.getRequestDispatcher("/ManagerJsp/employeeHome.jsp").forward(request, response);
			}

			else if(Utility.TECH_SUPPORT.equals((String)session.getAttribute("department"))) {
				request.getRequestDispatcher("/SupportJsp/supportHome.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
