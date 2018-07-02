package com.assetmanagementsystem.model.service;

import com.assetmanagementsystem.model.dao.ProjectDao;
import com.assetmanagementsystem.model.entity.ProjectEntity;

public class ProjectDaoService {

	ProjectDao projectDao=new ProjectDao();
	
	public boolean addProject(ProjectEntity project) {
		return projectDao.addProject(project);
	}
	
	public boolean changeProjectName(String projectName, int pId) {
		return projectDao.changeProjectName(projectName, pId);
	}
	
	public boolean changeManager(int managerId, int pId) {
		return projectDao.changeManager(managerId, pId);
	}
	
	public ProjectEntity displayProject(int pId) {
		return projectDao.displayProject(pId);
	}
	
}
