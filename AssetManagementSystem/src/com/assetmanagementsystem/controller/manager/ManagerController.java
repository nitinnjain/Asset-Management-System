package com.assetmanagementsystem.controller.manager;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assetmanagementsystem.model.dao.EmployeeDao;
import com.assetmanagementsystem.model.dao.RequestDao;
import com.assetmanagementsystem.model.entity.AssetSerialNumberEntity;
import com.assetmanagementsystem.model.entity.EmployeeEntity;
import com.assetmanagementsystem.model.entity.RequestEntity;
import com.assetmanagementsystem.model.service.AssetPoolDaoService;
import com.assetmanagementsystem.model.service.AssetSerialNumberDaoService;
import com.assetmanagementsystem.model.service.EmployeeDaoService;
import com.assetmanagementsystem.model.service.RequestDaoService;
import com.assetmanagementsystem.utility.Utility;

public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AssetPoolDaoService apds = new AssetPoolDaoService();
		
		HttpSession session = request.getSession();
		
//		Checks session if it is not created go to login page or else continue further
		if(session.getAttribute("username") == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
//			Checks the department of user if it it employee then only they can enter the module
			if(Utility.MANAGER.equals((String) session.getAttribute("department"))) {
//				receive the operation user wants to perform
				String operation = request.getParameter("operation");
				
				EmployeeEntity ee = new EmployeeEntity();
				RequestEntity re = new RequestEntity();
				
				EmployeeDao ed = new EmployeeDao();
				RequestDaoService rd = new RequestDaoService();
				
				EmployeeDaoService eds = new EmployeeDaoService();
				AssetSerialNumberDaoService asnds = new AssetSerialNumberDaoService();
				
//				Checks which operation the user wants to perform
				switch(operation) {
//				User wants to search for a new asset allocation request---------request is coming from employeeHome.jsp
					case "search" : {
						Enumeration searchAsset = request.getParameterNames();
						String parameterName = null;
						while(searchAsset.hasMoreElements()) {
							parameterName = (String) searchAsset.nextElement();
						}
//						stores the search of the user
						String searchValue = request.getParameter(parameterName);
					
//						checks if the user wants to search using name, keyword, or by category
						switch(parameterName) {
//							search by name
							case "search_by_name" : {
								request.setAttribute("assetMap", apds.displayByName(searchValue));
								request.getRequestDispatcher("/ManagerJsp/displayAssetName.jsp").forward(request, response);
								break;
							}
//							search by keywords
							case "search_by_keyword" : {
								request.setAttribute("assetMap", apds.displayByCategory(searchValue));
								request.getRequestDispatcher("/ManagerJsp/displayAssetName.jsp").forward(request, response);
								break;
							}
//							search by categories
							case "category_list" : {
//								need to implement
								break;
							}
						}
						break;
					}
//					module to raise a new request for asset allocation
					case "raise" : {
						int inputAssetId = Integer.parseInt(request.getParameter("asset_id"));
						String employee_username = (String)session.getAttribute("username");
						String employee_notes = request.getParameter("employee_notes");
						
//						get employee by employee id
						ee = ed.displayEmployeeByUsername(employee_username);
						
						re.setAssetId(inputAssetId);
						re.setEmployeeId(ee.getEmployeeId());
						re.setManagerId(ee.getManagerId());
						re.setRequestStatus(Utility.PENDING);
						re.setRequestType(Utility.ASSET_REQUEST);
						re.setUserNotes(employee_notes);
						
//						request to raise a request
						rd.raiseRequest(re);
						
						request.getRequestDispatcher("/ManagerJsp/myRequest.jsp").forward(request, response);
						
						break;
					}
//					new request to change user password
					case "change_pass" : {
						String newPass = request.getParameter("new_password");
						String confirmPass = request.getParameter("confirm_password");
						String username = (String) session.getAttribute("username");
						
//						get employee id by using username
						ee = eds.displayEmployeeByUsername(username);
						int eno = ee.getEmployeeId();
						
						if(newPass.equals(confirmPass)) {
							eds.changePassword(eno, newPass);
						}
						
						request.getRequestDispatcher("/ManagerJsp/managerHome.jsp").forward(request, response);
						
						break;
					}
//					user can raise a new technical request to be solved by support
					case "tech_support" : {
						String userQuery = request.getParameter("user_query");
						String username = (String) session.getAttribute("username");
						
						ee = eds.displayEmployeeByUsername(username);
						
						re.setEmployeeId(ee.getEmployeeId());
						re.setManagerId(ee.getManagerId());
						re.setRequestStatus(Utility.PENDING);
						re.setRequestType(Utility.TECH_SUPPORT);
						re.setUserNotes(userQuery);
						
						request.getRequestDispatcher("/ManagerJsp/myrequest.jsp").forward(request, response);
						
						break;
					}
//					user can view their requests and can cancel the requests if they want
					case "my_requests" : {
						String username = (String) session.getAttribute("username");
						List<RequestEntity> requestList = null;
						
						ee = eds.displayEmployeeByUsername(username);
						int eno = ee.getEmployeeId();
						
						requestList = rd.viewRequest(eno);
						
						request.setAttribute("requestList", requestList);
						request.getRequestDispatcher("/ManagerJsp/myRequest.jsp").forward(request, response);
						break;
					}
//					user can cancel its request which are pending
					case "cancel_req" : {
						int requestNo = Integer.parseInt(request.getParameter("request_id"));
						if(rd.removeRequest(requestNo)) {
							request.getRequestDispatcher("/ManagerJsp/myRequest.jsp").forward(request, response);
						}
						break;
					}
//					user can view their assets(allocated)
					case "my_assets" : {
						String username = (String) session.getAttribute("username");
						List<AssetSerialNumberEntity> assetList = null;
						
						ee = eds.displayEmployeeByUsername(username);
						int eno = ee.getEmployeeId();
						
						assetList = asnds.displayAssetByEId(eno);
						
						request.setAttribute("asset_list", assetList);
						
						request.getRequestDispatcher("/ManagerJsp/myAssets.jsp").forward(request, response);
						break;
					}
//					user can view their team's requests -- since they are managers
					case "my_team_requests" : {
						String username = (String) session.getAttribute("username");
						
						ee = eds.displayEmployeeByUsername(username);
						int eno = ee.getEmployeeId();
						
//						get list of employee ids associated with a manager
						List<EmployeeEntity> employeeList = eds.listEmployeeByManager(eno);
						
//						get the list of requests from the list of employees
						List<List<RequestEntity>> requestList = rd.viewRequestByEmployee(employeeList);
						
						request.setAttribute("requestList", requestList);
						request.getRequestDispatcher("/ManagerJsp/myTeamRequest.jsp").forward(request, response);
						break;
					}
//					user can view their team's assets -- since they are managers
					case "my_team_assets" : {
						String username = (String) session.getAttribute("username");
						
						ee = eds.displayEmployeeByUsername(username);
						int eno = ee.getEmployeeId();
						
//						get list of employee ids associated with a manager
						List<EmployeeEntity> employeeList = eds.listEmployeeByManager(eno);
						
						List<List<AssetSerialNumberEntity>> assetList = asnds.displayAssetForAllEmployees(employeeList);
						
						request.setAttribute("assetList", assetList);
						request.getRequestDispatcher("/ManagerJsp/myTeamAsset.jsp").forward(request, response);
						break;
					}
//					accept request by their employees					
					case "accept_req" : {
						int requestId = Integer.parseInt(request.getParameter("request_id"));
						String status = Utility.APPROVED;
						
						if(rd.updateRequestStatus(requestId, status)) {
							request.getRequestDispatcher("/ManagerJsp/managerHome.jsp").forward(request, response);
						}
						
						break;
					}
//					reject request of their employees
					case "reject_req" : {
						int requestId = Integer.parseInt(request.getParameter("request_id"));
						String status = Utility.REJECTED;
						
						if(rd.updateRequestStatus(requestId, status)) {
							request.getRequestDispatcher("/ManagerJsp/managerHome.jsp").forward(request, response);
						}
						break;
					}
				}
			}
		}
	}
}
