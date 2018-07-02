package com.assetmanagementsystem.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assetmanagementsystem.model.service.EmployeeDaoService;
import com.assetmanagementsystem.utility.Utility;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		
		EmployeeDaoService employeeDaoService = new EmployeeDaoService();
		HttpSession session = request.getSession();
			
		String loginUsername = request.getParameter("login_username");
		String loginPassword = request.getParameter("login_password");
		String loginDepartment = null;
		
//		if session is created
		if(request.getSession(false) != null) {
			
//			check user's department
			if(request.getParameter("login_department") != null) {
				loginDepartment = request.getParameter("login_department");
				
				if(employeeDaoService.checkLogin(loginUsername, loginPassword, loginDepartment)) {
					session.setAttribute("username", loginUsername);
					session.setAttribute("department", loginDepartment);
				
//					Admin will login
					if(Utility.ADMIN.equals((String)session.getAttribute("department"))) {
						request.getRequestDispatcher("AdminJsp/adminHome.jsp").forward(request, response);
					}
					
//					Employee will login
					else if(Utility.EMPLOYEE.equals((String)session.getAttribute("department"))) {
						request.getRequestDispatcher("EmployeeJsp/employeeHome.jsp").forward(request, response);
					}
					
//					Manager will login
					else if(Utility.MANAGER.equals((String)session.getAttribute("department"))) {
						request.getRequestDispatcher("ManagerJsp/managerHome.jsp").forward(request, response);
					}
					
//					Support Dept.Dept will login
					else if(Utility.TECH_SUPPORT.equals((String)session.getAttribute("department"))) {
						request.getRequestDispatcher("SupportJsp/supportHome.jsp").forward(request, response);
					}						
				}
//				if password is wrong
				else {
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
		}
//		if session is null
		else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
