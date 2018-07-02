package com.assetmanagementsystem.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="employee_table")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue()
	@Column(name="employee_id", length=7)
	private int employeeId;
	
	@Column(name="employee_name", length=25)
	private String employeeName;
	
	@Column(name="manager_id", length=7)
	private int managerId;
	
	@Column(name="project_id", length=7)
	private int projectId;
	
	@Column(name="department", length=15)
	private String employeeDepartment;
	
	@Column(name="salary", length=10)
	private long employeeSalary;
	
	@Column(name="phone_number", length=11)
	private long employeePhoneNumber;
	
	@Column(name="posting_city", length=25)
	private String employeePostingCity;
	
	@Column(name="username", length=15, unique=true, nullable=false)
	private String employeeUsername;
	
	@Column(name="password", length=30, nullable=false)
	private String employeePassword;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="address_id")
	private EmployeeAddressEntity address;

	public EmployeeAddressEntity getAddress() {
		return address;
	}

	public void setAddress(EmployeeAddressEntity address) {
		this.address = address;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public long getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(long employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public long getEmployeePhoneNumber() {
		return employeePhoneNumber;
	}

	public void setEmployeePhoneNumber(long employeePhoneNumber) {
		this.employeePhoneNumber = employeePhoneNumber;
	}

	public String getEmployeePostingCity() {
		return employeePostingCity;
	}

	public void setEmployeePostingCity(String employeePostingCity) {
		this.employeePostingCity = employeePostingCity;
	}

	public String getEmployeeUsername() {
		return employeeUsername;
	}

	public void setEmployeeUsername(String employeeUsername) {
		this.employeeUsername = employeeUsername;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [employeeId=" + employeeId + ", employeeName=" + employeeName + ", managerId="
				+ managerId + ", projectId=" + projectId + ", employeeDepartment=" + employeeDepartment
				+ ", employeeSalary=" + employeeSalary + ", employeePhoneNumber=" + employeePhoneNumber
				+ ", employeePostingCity=" + employeePostingCity + ", employeeUsername=" + employeeUsername
				+ ", employeePassword=" + employeePassword + ", address=" + address + "]";
	}
}