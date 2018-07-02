package com.assetmanagementsystem.model.dao;

import org.hibernate.Session;

import com.assetmanagementsystem.model.entity.ProjectEntity;

public class ProjectDao {
	
	public boolean addProject(ProjectEntity project) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		if(session.save(project)!=null) {	
			session.getTransaction().commit();
			return true;
		}
		
		return false;
	}
	
	public boolean changeProjectName(String projectName, int pId) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		ProjectEntity p=new ProjectEntity();
		p=(ProjectEntity)session.get(ProjectEntity.class,pId);
		p.setProjectName(projectName);
		if(session.save(p)!=null) {
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public boolean changeManager(int managerId, int pId) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		ProjectEntity p=new ProjectEntity();
		p=(ProjectEntity)session.get(ProjectEntity.class, pId);
		p.setManagerId(managerId);
		if(session.save(p)!=null) {
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public ProjectEntity displayProject(int pId) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		ProjectEntity p=new ProjectEntity();
		p=(ProjectEntity)session.get(ProjectEntity.class, pId);
		return p;
	}

}
