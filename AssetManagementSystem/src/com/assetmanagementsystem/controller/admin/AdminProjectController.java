package com.assetmanagementsystem.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.assetmanagementsystem.model.entity.ProjectEntity;
import com.assetmanagementsystem.model.service.ProjectDaoService;

public class AdminProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminProjectController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		String operation=null;
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		if((String)session.getAttribute("username") == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		else {
			if("admin".equals((String) session.getAttribute("department"))) {

				ProjectDaoService projectDao=new ProjectDaoService();
				operation=request.getParameter("operation");
				ProjectEntity project=new ProjectEntity();
				switch(operation)
				{

				case "addProject" : {
					if(projectDao.addProject(addProject(request)))
					{
						out.println("<html><body><script type='text/javascript'>alert('Project Added Successfully')</script></body></html>");
						request.getRequestDispatcher("AdminJsp/projectHome.jsp").forward(request, response);
					}
					else {
						out.println("<html><body><script type='text/javascript'>alert('Unable To Add Project')</script></body></html>");
						request.getRequestDispatcher("AdminJsp/addProject.jsp").forward(request, response);
					}
					break;
				}

				case "changeManager" : {
					project=changeManager(request);
					if(projectDao.changeManager(project.getManagerId(), project.getProjectId()))
					{
						out.println("<html><body><script type='text/javascript'>alert('Manager Changed Successfully')</script></body></html>");
						request.getRequestDispatcher("AdminJsp/projectHome.jsp").forward(request, response);

					}
					else {
						out.println("<html><body><script type='text/javascript'>alert('Unable To Change Manager')</script></body></html> ");
						request.getRequestDispatcher("AdminJsp/changeManager.jsp").forward(request, response);
					}
					break;
				}

				case "changeProjectName" : {
					project=changeProjectName(request);
					if(projectDao.changeProjectName(project.getProjectName(), project.getProjectId()))
					{
						out.println("<html><body><script type='text/javascript'>alert('Name Of Project Changed Successfully')</script></body></html> ");
						request.getRequestDispatcher("AdminJsp/projectHome.jsp").forward(request, response);

					}
					else {
						out.println("<html><body><script type='text/javascript'>alert('Unable to Change Project Name')</script></body></html> ");
						request.getRequestDispatcher("AdminJsp/changeProjectName.jsp").forward(request, response);
					}
					break;
				}

				case "displayProject" :{
					project=projectDao.displayProject(Integer.parseInt(request.getParameter("project_id")));
					if(project!=null) {
						request.setAttribute("projectDetails", project);
						request.getRequestDispatcher("AdminJsp/viewProjectDetails.jsp").forward(request, response);
					}
					else {
						out.println("<html><body><script type='text/javascript'>alert('Project Does Not Exist')</script></body></html> ");
					}
					break;
				}
				}
			}
		}
	}

	private ProjectEntity addProject(HttpServletRequest request)
	{
		ProjectEntity project=new ProjectEntity();
		project.setManagerId(Integer.parseInt(request.getParameter("manager_id")));
		project.setProjectName(request.getParameter("project_name"));
		return project;
	}

	private ProjectEntity changeManager(HttpServletRequest request)
	{
		ProjectEntity project=new ProjectEntity();
		project.setProjectId(Integer.parseInt(request.getParameter("project_id")));
		project.setManagerId(Integer.parseInt(request.getParameter("manager_id")));
		return project;
	}

	private ProjectEntity changeProjectName(HttpServletRequest request)
	{
		ProjectEntity project=new ProjectEntity();
		project.setProjectId(Integer.parseInt(request.getParameter("project_id")));
		project.setProjectName(request.getParameter("project_name"));
		return project;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
