package com.assetmanagementsystem.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assetmanagementsystem.model.entity.EmployeeAddressEntity;
import com.assetmanagementsystem.model.entity.EmployeeEntity;
import com.assetmanagementsystem.model.service.EmployeeDaoService;

public class AdminEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Controll", "no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		if((String)session.getAttribute("username") == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		else {
			if("admin".equals((String) session.getAttribute("department"))) {
				String operation = request.getParameter("operation");

				EmployeeEntity employeeEntity = new EmployeeEntity();
				EmployeeDaoService employeeDaoService = new EmployeeDaoService();
				int employeeNumber;

				switch(operation) {
				case "addEmployee" : {
					int id = -1;
					employeeEntity = addEmployee(request);
					id = employeeDaoService.addEmployee(employeeEntity);
					if(id > -1) {
						request.setAttribute("id", id);
						out.println("<html><body><script type='text/javascript'>alert('Employee added successfully')</script></body></html>");
						request.getRequestDispatcher("/AdminJsp/newEmployee.jsp").forward(request, response);
					}
					else {
						out.println("<html><body><script type='text/javascript'>alert('There is some issue in adding the employee')</script></body></html>");
						request.getRequestDispatcher("/AdminJsp/addEmployee.jsp").forward(request, response);
					}
					break;
				}
				case "updateEmployee" : {
					employeeEntity = updateEmployee(request);
					if(employeeDaoService.updateEmployee(employeeEntity)) {
						out.println("<html><body><script type='text/javascript'>alert('Employee updated successfully')</script></body></html>");
						request.getRequestDispatcher("/AdminJsp/employeeHome.jsp").forward(request, response);
					}
					else {
						out.println("<html><body><script type='text/javascript'>alert('There is some issue in updating the employee')</script></body></html>");
						request.getRequestDispatcher("/AdminJsp/updateEmployee.jsp").forward(request, response);
					}
					break;
				}
				case "deleteEmployee" : {
					employeeNumber = deleteEmployee(request);
					if(employeeDaoService.deleteEmployee(employeeNumber)) {
						out.println("<html><body><script type='text/javascript'>alert('Employee deleted successfully')</script></body></html>");
						request.getRequestDispatcher("/AdminJsp/employeeHome.jsp").forward(request, response);
					}
					else {
						out.println("<html><body><script type='text/javascript'>alert('There is some issue in deleting the employee')</script></body></html>");
						request.getRequestDispatcher("/AdminJsp/deleteEmployee.jsp").forward(request, response);
					}
					break;
				}
				case "viewEmployee" : {
					employeeNumber = displayEmployee(request);
					employeeEntity = employeeDaoService.displayEmployeeByEno(employeeNumber);
					request.setAttribute("employeeDetails", employeeEntity);
					request.getRequestDispatcher("/AdminJsp/viewEmployeeDetails.jsp").forward(request, response);
				}
				break;
				}
			}
		}
	}

	private EmployeeEntity addEmployee(HttpServletRequest request) {

		EmployeeDaoService eds = new EmployeeDaoService();

		String password[] = eds.generatePassword();

		String normalPassword = password[0];
		System.out.println(normalPassword);
		String securePassword = password[1];

		String employeeName = request.getParameter("employee_name");
		int managerId = Integer.parseInt(request.getParameter("manager_id"));
		int projectId = Integer.parseInt(request.getParameter("project_id"));
		String employeeDepartment = request.getParameter("employee_department");
		long employeeSalary = Long.parseLong(request.getParameter("employee_salary"));
		long employeePhoneNumber = Long.parseLong(request.getParameter("employee_phone_number"));
		String employeePostingCity = request.getParameter("employee_posting_city");
		String employeeUsername = request.getParameter("employee_username");
		String flatHouseFloorBuilding = request.getParameter("flat_house_building_floor");
		String colonyStreetLocality = request.getParameter("colony_street_locality");
		String landmark = request.getParameter("landmark");
		String addressCity = request.getParameter("address_city");
		String addressState = request.getParameter("address_state");
		int pincode = Integer.parseInt(request.getParameter("address_pincode"));
		String country = request.getParameter("address_country");

		EmployeeAddressEntity employeeAddressEntity = new EmployeeAddressEntity();

		employeeAddressEntity.setFlatHouseFloorBuilding(flatHouseFloorBuilding);
		employeeAddressEntity.setColonyStreetLocality(colonyStreetLocality);
		employeeAddressEntity.setLandmark(landmark);
		employeeAddressEntity.setCity(addressCity);
		employeeAddressEntity.setState(addressState);
		employeeAddressEntity.setCountry(country);
		employeeAddressEntity.setPincode(pincode);
		EmployeeEntity employee = new EmployeeEntity();

		employee.setEmployeeName(employeeName);
		employee.setManagerId(managerId);
		employee.setProjectId(projectId);
		employee.setEmployeeDepartment(employeeDepartment);
		employee.setEmployeeSalary(employeeSalary);
		employee.setEmployeePhoneNumber(employeePhoneNumber);
		employee.setEmployeePostingCity(employeePostingCity);
		employee.setEmployeeUsername(employeeUsername);
		employee.setEmployeePassword(securePassword);
		employee.setAddress(employeeAddressEntity);

		request.setAttribute("name", employee.getEmployeeName());
		request.setAttribute("username", employee.getEmployeeUsername());
		request.setAttribute("password", normalPassword);
		
		return employee;
	}

	private EmployeeEntity updateEmployee(HttpServletRequest request) {

		String employeeName = request.getParameter("employee_name");
		int managerId = Integer.parseInt(request.getParameter("manager_id"));
		int projectId = Integer.parseInt(request.getParameter("project_id"));
		String employeeDepartment = request.getParameter("employee_department");
		long employeeSalary = Long.parseLong(request.getParameter("employee_salary"));
		long employeePhoneNumber = Long.parseLong(request.getParameter("employee_phone_number"));
		String employeePostingCity = request.getParameter("employee_posting_city");
		String employeeUsername = request.getParameter("employee_username");
		String employeePassword = request.getParameter("employee_passsword");
		String flatHouseFloorBuilding = request.getParameter("flat_house_building_floor");
		String colonyStreetLocality = request.getParameter("colony_street_locality");
		String landmark = request.getParameter("landmark");
		String addressCity = request.getParameter("address_city");
		String addressState = request.getParameter("address_state");
		int pincode = Integer.parseInt(request.getParameter("address_pincode"));
		String country = request.getParameter("address_country");

		EmployeeAddressEntity employeeAddressEntity = new EmployeeAddressEntity();

		employeeAddressEntity.setFlatHouseFloorBuilding(flatHouseFloorBuilding);
		employeeAddressEntity.setColonyStreetLocality(colonyStreetLocality);
		employeeAddressEntity.setLandmark(landmark);
		employeeAddressEntity.setCity(addressCity);
		employeeAddressEntity.setState(addressState);
		employeeAddressEntity.setPincode(pincode);
		employeeAddressEntity.setCountry(country);

		EmployeeEntity employee = new EmployeeEntity();

		employee.setEmployeeName(employeeName);
		employee.setManagerId(managerId);
		employee.setProjectId(projectId);
		employee.setEmployeeDepartment(employeeDepartment);
		employee.setEmployeeSalary(employeeSalary);
		employee.setEmployeePhoneNumber(employeePhoneNumber);
		employee.setEmployeePostingCity(employeePostingCity);
		employee.setEmployeeUsername(employeeUsername);
		employee.setEmployeePassword(employeePassword);
		employee.setAddress(employeeAddressEntity);

		return employee;
	}

	private int deleteEmployee(HttpServletRequest request) {
		int employeeNumber = Integer.parseInt(request.getParameter("employee_id"));
		return employeeNumber;
	}

	private int displayEmployee(HttpServletRequest request) {
		int employeeNumber = Integer.parseInt(request.getParameter("employee_id"));
		return employeeNumber;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
