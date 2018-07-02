package com.assetmanagementsystem.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="project_table")
public class ProjectEntity {
	
	@Id
	@GeneratedValue()
	@Column(name="project_id", length=7)
	private int projectId;
	
	@Column(name="project_name", length=25)
	private String projectName;
	
	@Column(name="manager_id", length=7)
	private int managerId;
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
}
