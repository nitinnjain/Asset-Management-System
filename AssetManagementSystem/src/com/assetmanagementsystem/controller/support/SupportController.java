package com.assetmanagementsystem.controller.support;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assetmanagementsystem.model.entity.AssetCategoryEntity;
import com.assetmanagementsystem.model.entity.AssetPoolEntity;
import com.assetmanagementsystem.model.entity.AssetSerialNumberEntity;
import com.assetmanagementsystem.model.entity.EmployeeEntity;
import com.assetmanagementsystem.model.entity.KeywordEntity;
import com.assetmanagementsystem.model.entity.RequestEntity;
import com.assetmanagementsystem.model.service.AssetCategoryDaoService;
import com.assetmanagementsystem.model.service.AssetPoolDaoService;
import com.assetmanagementsystem.model.service.AssetSerialNumberDaoService;
import com.assetmanagementsystem.model.service.EmployeeDaoService;
import com.assetmanagementsystem.model.service.KeywordDaoService;
import com.assetmanagementsystem.model.service.RequestDaoService;

public class SupportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SupportController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		HttpSession session = request.getSession();

		if((String)session.getAttribute("username") == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		else {
			//			if("support".equals((String) session.getAttribute("department"))) {
			String operation = request.getParameter("operation");


			RequestEntity requestEntity = new RequestEntity();
			RequestDaoService requestDaoService = new RequestDaoService();
			AssetCategoryDaoService categoryService= new AssetCategoryDaoService();
			AssetSerialNumberDaoService serialNoService = new AssetSerialNumberDaoService(); 
			KeywordDaoService keyService = new KeywordDaoService();
			AssetPoolDaoService poolService = new AssetPoolDaoService();

			Enumeration<String> param=request.getParameterNames();
			String allocate=null;
			int allocateValue=-1;
			while(param.hasMoreElements()) {
				allocate=param.nextElement();
				if("request_id".equals(allocate))
					allocateValue=Integer.parseInt(request.getParameter(allocate));
			}
			List<RequestEntity> list = null;

			if("request_id".equals(allocate)) {
				RequestEntity re=requestDaoService.viewRequestByRequestId(allocateValue);
				request.setAttribute("empRequest", re);
				request.getRequestDispatcher("/SupportJsp/mapAsset.jsp").forward(request, response);
			}
			else {

				EmployeeEntity ee = new EmployeeEntity();
				EmployeeDaoService eds = new EmployeeDaoService();

				switch(operation) {
				//				new request to change user password
				case "change_pass" : {
					String newPass = request.getParameter("new_password");
					String confirmPass = request.getParameter("confirm_password");
					String username = (String) session.getAttribute("username");

					//					get employee id by using username
					ee = eds.displayEmployeeByUsername(username);
					int eno = ee.getEmployeeId();

					if(newPass.equals(confirmPass)) {
						eds.changePassword(eno, newPass);
					}

					request.getRequestDispatcher("/ManagerJsp/managerHome.jsp").forward(request, response);

					break;
				}
				case "request" : {
					list=requestDaoService.viewRequest();
					request.setAttribute("requestList", list);
					request.getRequestDispatcher("/SupportJsp/displayRequest.jsp").forward(request, response);
					break;
				}

				case "empAsset" : {
					int eId=Integer.parseInt(request.getParameter("e_id"));
					List<AssetSerialNumberEntity> assetList=serialNoService.displayAssetByEId(eId);
					request.setAttribute("employeeAssets", assetList);
					request.getRequestDispatcher("/SupportJsp/displayEmployeeAssets.jsp").forward(request, response);
					break;
				}

				case "empListByAssetId" : {
					int assetId=Integer.parseInt(request.getParameter("asset_id"));
					List<AssetSerialNumberEntity> employeeList=serialNoService.displayAssetByAssetId(assetId);
					request.setAttribute("assetEmpList", employeeList);
					request.getRequestDispatcher("/SupportJsp/displayEmployeeByAssetId.jsp").forward(request, response);;
					break;
				}

				case "empDetailsByAssetSno" : {
					String assetSno=request.getParameter("asset_sno");
					AssetSerialNumberEntity asne =serialNoService.displayEmployeeByAssetSno(assetSno);
					request.setAttribute("empAssetDetail", asne);
					request.getRequestDispatcher("/SupportJsp/displayByAssetSno.jsp").forward(request, response);
					break;
				}

				case "mapAsset" : {
					String assetSno=request.getParameter("asset_sno");
					int eId=Integer.parseInt(request.getParameter("employee_id"));
					String allocatedBy=request.getParameter("allocated_by");
					int requestId=Integer.parseInt(request.getParameter("request_id"));
					if(serialNoService.allocateAsset(assetSno, eId, allocatedBy, requestId))
						request.getRequestDispatcher("/SupportJsp/supportHome.jsp").forward(request, response);
					else
						request.getRequestDispatcher("/SupportJsp/displayRequest.jsp").forward(request, response);
					break;
				}

				case "deallocate" : {
					String assetSno=request.getParameter("asset_sno");
					if(serialNoService.deallocateAsset(assetSno))
						request.getRequestDispatcher("/SupportJsp/supportHome.jsp").forward(request, response);
					else
						out.println("Unable to deallocate Asset");
					break;
				}

				case "addCategory" : {
					String newCategory=request.getParameter("new_category");
					AssetCategoryEntity assetCategory=new AssetCategoryEntity();
					assetCategory.setCategoryName(newCategory);
					if(categoryService.addCategory(assetCategory)) {
						out.println("Category Added");
						request.getRequestDispatcher("SupportController?operation=displayCategories").include(request, response);
					}
					else {
						out.println("Category already exist");
						request.getRequestDispatcher("SupportController?operation=displayCategories").include(request, response);
					}
					break;
				}

				case "displayCategories" : {
					Map<Integer,AssetCategoryEntity> categoryMap=new HashMap<>();
					categoryMap=categoryService.listCategory();
					request.setAttribute("categoryMap", categoryMap);
					request.getRequestDispatcher("/SupportJsp/displayCategory.jsp").forward(request, response);
					break;
				}

				case "deleteCategory" : {
					int categoryId=Integer.parseInt(request.getParameter("category_id"));
					if(categoryService.deleteCategory(categoryId)) {
						out.println("Category Deleted Successfully");
						request.getRequestDispatcher("SupportController?operation=displayCategories").include(request, response);
					}
					else {
						out.println("Unable to delete Category");
						request.getRequestDispatcher("SupportController?operation=displayCategories").include(request, response);							
					}
					break;
				}

				case "updateCategory" :{
					String categoryName=request.getParameter("update_category_name");
					int categoryId=Integer.parseInt(request.getParameter("update_category_id"));
					AssetCategoryEntity ace=new AssetCategoryEntity();
					ace.setCategoryName(categoryName);
					ace.setCategoryId(categoryId);
					if(categoryService.updateCategory(ace)) {
						out.println("Category Updated Successfully");
						request.getRequestDispatcher("SupportController?operation=displayCategories").include(request, response);
					}
					else {
						out.println("Unable To Update Category");
						request.getRequestDispatcher("SupportController?operation=displayCategories").include(request, response);
					}
					break;
				}

				case "displayKeyword" :{
					Map<Integer,KeywordEntity> keywordMap=new LinkedHashMap<>();
					keywordMap=keyService.listKeyword();
					request.setAttribute("keywordMap", keywordMap);
					request.getRequestDispatcher("/SupportJsp/displayKeyword.jsp").forward(request, response);
					break;
				}

				case "updateKeyword" : {
					String keywordName=request.getParameter("update_keyword_name");
					int keywordId=Integer.parseInt(request.getParameter("update_keyword_id"));
					KeywordEntity key=new KeywordEntity();
					key.setKeywordId(keywordId);
					key.setKeywords(keywordName);
					if(keyService.updateKeyword(key)) {
						out.println("Keyword Updated Successfully");
						request.getRequestDispatcher("SupportController?operation=displayKeyword").include(request, response);
					}
					else {
						out.println("Unable To Update Keyword");
						request.getRequestDispatcher("SupportController?operation=displayKeyword").include(request, response);
					}

					break;
				}

				case "deleteKeyword" : {
					int keywordId=Integer.parseInt(request.getParameter("keyword_id"));
					if(keyService.deletekeyword(keywordId)) {
						out.println("Keyword Deleted Successfully");
						request.getRequestDispatcher("SupportController?operation=displayKeyword").include(request, response);
					}
					else {
						out.println("Unable to delete Keyword");
						request.getRequestDispatcher("SupportController?operation=displayKeyword").include(request, response);							
					}

					break;
				}
				case "assetPool" : {
					Map<Integer,AssetCategoryEntity> categoryMap=categoryService.listCategory();
					Map<Integer,KeywordEntity> keywordMap=keyService.listKeyword();
					request.setAttribute("categoryMap", categoryMap);
					request.setAttribute("keywordMap", keywordMap);
					request.getRequestDispatcher("/SupportJsp/asset.jsp").forward(request, response);
					break;
				}

				case "addAsset" : {
					AssetPoolEntity ape=new AssetPoolEntity();
					ape.setAssetName(request.getParameter("asset_name"));
					ape.setAssetCategory(request.getParameter("category"));
					ape.setAssetDescription(request.getParameter("description"));
					ape.setAssetQuantity(Integer.parseInt(request.getParameter("quantity")));
					List<AssetSerialNumberEntity> li=new ArrayList<>();
					AssetSerialNumberEntity asne;
					for(int j=0;j<ape.getAssetQuantity();j++) {
						asne=new AssetSerialNumberEntity();
						asne.setAssetPool(ape);
						asne.setAssetSerialNumber("ASSET-NO"+j);
						li.add(asne);
						j++;
					}
					ape.setAssetSerialNumber(li);
					String header;
					Enumeration<String> parameters=request.getParameterNames();
					while(parameters.hasMoreElements()) {
						header=parameters.nextElement();
						if(!("operation".equals(header) || "asset_name".equals(header) || "category".equals(header) || "quantity".equals(header) || "description".equals(header))) {
							if("addAsset".equals(request.getParameter(header))) {}
							else {
								int keyId=Integer.parseInt(request.getParameter(header));
								ape.getKeyword().add(keyService.listKeyword().get(keyId));
							}
						}							
					}

					if(poolService.addAsset(ape)) {
						request.getRequestDispatcher("/SupportJsp/supportHome.jsp").forward(request, response);
					}
					else
						out.println("Asset not Added");
					break;
				}
				case "addKeyword" : {
					String newKeyword=request.getParameter("new_keyword");
					KeywordEntity key=new KeywordEntity();
					key.setKeywords(newKeyword);
					if(keyService.addKeyword(key)) {
						out.println("Keyword Added");
						request.getRequestDispatcher("SupportController?operation=displayKeyword").include(request, response);
					}
					else {
						out.println("Keyword already exist");
						request.getRequestDispatcher("SupportController?operation=displayKeyword").include(request, response);
					}

					break;
				}
				}
			}
		}
		//}


	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
