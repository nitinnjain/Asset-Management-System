package com.assetmanagementsystem.model.service;

import java.util.ArrayList;
import java.util.List;

import com.assetmanagementsystem.model.dao.RequestDao;
import com.assetmanagementsystem.model.entity.EmployeeEntity;
import com.assetmanagementsystem.model.entity.RequestEntity;

public class RequestDaoService {
	
	RequestDao rd = new RequestDao();
	
	public boolean raiseRequest(RequestEntity re) {
		return rd.raiseRequest(re);
	}
	
	public boolean removeRequest(int rNo) {
		return rd.removeRequest(rNo);
	}
	
	public boolean updateRequest(RequestEntity re) {
		return rd.updateRequest(re);
	}

	public List<RequestEntity> viewRequest(int eId) {
		return rd.viewRequest(eId);
	}

	public List<RequestEntity> viewRequest() {
		return rd.viewRequest();
	}
	
	public RequestEntity viewRequestByRequestId(int requestId) {
		return rd.viewRequestByRequestId(requestId);
	}

	public List<List<RequestEntity>> viewRequestByEmployee(List<EmployeeEntity> employeeList) {
		List<List<RequestEntity>> requestList = new ArrayList<>();
		for(EmployeeEntity e : employeeList) {
			int eId = e.getEmployeeId();
			requestList.add(viewRequest(eId));
		}
		return requestList;
	}
	
	public boolean updateRequestStatus(int requestId, String status) {
		return rd.updateRequestStatus(requestId, status);
	}
}
