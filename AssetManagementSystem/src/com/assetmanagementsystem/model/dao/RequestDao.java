package com.assetmanagementsystem.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.assetmanagementsystem.model.entity.RequestEntity;

public class RequestDao {
	
	public boolean raiseRequest(RequestEntity re) {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		if(session.save(re) != null) {	
			session.getTransaction().commit();
			return true;
		}
		return false;
	}

	public boolean removeRequest(int requestNo) {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql = "delete from request_table where request_id = :requestNo";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("requestNo", requestNo);
		if(query.executeUpdate() > 0) {
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public boolean updateRequest(RequestEntity re) {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		RequestEntity requestEntity = (RequestEntity) session.get(RequestEntity.class, re.getRequestId());
		
		requestEntity.setAssetId(re.getAssetId());
		requestEntity.setEmployeeId(re.getEmployeeId());
		requestEntity.setRequestId(re.getRequestId());
		requestEntity.setRequestStatus(re.getRequestStatus());
		requestEntity.setRequestType(re.getRequestType());
		requestEntity.setUserNotes(re.getUserNotes());
		
		if(session.save(requestEntity) != null) {
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public List<RequestEntity> viewRequest(int eId) {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "from RequestEntity where employeeId = :eId";
		Query query = session.createQuery(hql);
		
		query.setParameter("eId", eId);
		
		List<RequestEntity> request = query.list();
		
		session.getTransaction().commit();
		
		return request;
	}
	
	public List<RequestEntity> viewRequest() {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "from RequestEntity";
		Query query = session.createQuery(hql);
		
		List<RequestEntity> request = query.list();
		
		session.getTransaction().commit();
		
		return request;
	}
	
	public RequestEntity viewRequestByRequestId(int requestId) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "from RequestEntity where requestId = :requestId";
		Query query=session.createQuery(hql);
		query.setParameter("requestId", requestId);
		RequestEntity re=(RequestEntity)query.uniqueResult();
		session.getTransaction().commit();
		return re;
	}
	
	public boolean updateRequestStatus(int requestId, String status) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="update employee_request set request_status=:status where request_id=:requestId";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter("requestId", requestId);
		query.setParameter("status", status);
		if(query.executeUpdate()>0) {
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
}
