package com.assetmanagementsystem.model.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.assetmanagementsystem.model.entity.PurchaseEntity;

public class PurchaseDao {
	
	public boolean addOrder(PurchaseEntity pe) {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		if(session.save(pe) != null) {
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public boolean deleteOrder(int orderId) {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql = "delete from purchase_table where order_id = :orderId";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("orderId", orderId);
		if(query.executeUpdate() > 0) {
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public boolean updateOrder(PurchaseEntity pe) {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		PurchaseEntity p = (PurchaseEntity) session.get(PurchaseEntity.class, pe.getOrderId());
		
		p.setOrderId(pe.getOrderId());
		p.setOrderStatus(pe.getOrderStatus());
//		p.setProductList(pe.getProductList());
		
		if(session.save(p) != null) {
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public PurchaseEntity viewOrder(int orderId) {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		PurchaseEntity pe = (PurchaseEntity) session.get(PurchaseEntity.class, orderId);
		session.getTransaction().commit();
		return pe;
	}
}
