package com.assetmanagementsystem.controller.employee;

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
import com.assetmanagementsystem.utility.Utility;

public class EmployeeController extends HttpServlet {
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
			if(Utility.EMPLOYEE.equals((String) session.getAttribute("department"))) {
				//				receive the operation user wants to perform
				String operation = request.getParameter("operation");

				EmployeeEntity ee = new EmployeeEntity();
				RequestEntity re = new RequestEntity();

				EmployeeDao ed = new EmployeeDao();
				RequestDao rd = new RequestDao();

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
					case "search_by_name" : {
						request.setAttribute("assetMap", apds.displayByName(searchValue));
						request.getRequestDispatcher("/EmployeeJsp/displayAssetName.jsp").forward(request, response);
						break;
					}
					case "search_by_keyword" : {
						request.setAttribute("assetMap", apds.displayByCategory(searchValue));
						request.getRequestDispatcher("/EmployeeJsp/displayAssetName.jsp").forward(request, response);
						break;
					}
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

					ee = ed.displayEmployeeByUsername(employee_username);

					re.setAssetId(inputAssetId);
					re.setEmployeeId(ee.getEmployeeId());
					re.setManagerId(ee.getManagerId());
					re.setRequestStatus(Utility.PENDING);
					re.setRequestType(Utility.ASSET_REQUEST);
					re.setUserNotes(employee_notes);

					rd.raiseRequest(re);
					request.getRequestDispatcher("/EmployeeJsp/myRequest.jsp").forward(request, response);

					break;
				}
				//					new request to change user password
				case "change_pass" : {
					String newPass = request.getParameter("new_password");
					String confirmPass = request.getParameter("confirm_password");
					String username = (String) session.getAttribute("username");

					ee = eds.displayEmployeeByUsername(username);

					int eno = ee.getEmployeeId();

					if(newPass.equals(confirmPass)) {
						eds.changePassword(eno, newPass);
					}

					request.getRequestDispatcher("/EmployeeJsp/employeeHome.jsp").forward(request, response);

					break;
				}
				//					user can raise a new technical request to be solved by support
				case "tech_support" : {
					String userQuery = request.getParameter("user_query");
					String username = (String) session.getAttribute("username");

					eds = new EmployeeDaoService();

					ee = eds.displayEmployeeByUsername(username);

					re.setEmployeeId(ee.getEmployeeId());
					re.setManagerId(ee.getManagerId());
					re.setRequestStatus(Utility.PENDING);
					re.setRequestType(Utility.TECH_SUPPORT);
					re.setUserNotes(userQuery);
					
					request.getRequestDispatcher("/EmployeeJsp/employeeHome.jsp").forward(request, response);
					
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
					request.getRequestDispatcher("/EmployeeJsp/myRequest.jsp").forward(request, response);
					break;
				}
//				user can cancel its request which are pending
				case "cancel_req" : {
					int requestNo = Integer.parseInt(request.getParameter("request_id"));
					if(rd.removeRequest(requestNo)) {
						request.getRequestDispatcher("/EmployeeJsp/myRequest.jsp").forward(request, response);
					}
					break;
				}
				case "my_assets" : {
					String username = (String) session.getAttribute("username");
					List<AssetSerialNumberEntity> assetList = null;

					ee = eds.displayEmployeeByUsername(username);
					int eno = ee.getEmployeeId();

					assetList = asnds.displayAssetByEId(eno);

					request.setAttribute("asset_list", assetList);

					request.getRequestDispatcher("/EmployeeJsp/myAssets.jsp").forward(request, response);
					break;
				}
				}
			}
		}
	}
}