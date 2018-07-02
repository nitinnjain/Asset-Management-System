package com.assetmanagementsystem.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_request")
public class RequestEntity {
	
	@Id
	@GeneratedValue()
	@Column(name="request_id", length=7)
	private int requestId;
	
	@Column(name="employee_id", length=7)
	private int employeeId;
	
	@Column(name="asset_id", length=7)
	private int assetId;
	
//	This is for the type of request the user is raising like asset request or tech support request
	
	@Column(name="request_type", length=10)
	private String requestType;
	
	@Column(name="manager_id", length=7)
	private int managerId;
	
	@Column(name="request_status", length=11)
	private String requestStatus;
	
	@Column(name="user_notes", length=100)
	private String userNotes;
	
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getRequestId() {
		return requestId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getUserNotes() {
		return userNotes;
	}

	public void setUserNotes(String userNotes) {
		this.userNotes = userNotes;
	}

	@Override
	public String toString() {
		return "RequestEntity [requestId=" + requestId + ", employeeId=" + employeeId + ", assetId=" + assetId
				+ ", requestType=" + requestType + ", managerId=" + managerId + ", requestStatus=" + requestStatus
				+ ", userNotes=" + userNotes + "]";
	}
	
}