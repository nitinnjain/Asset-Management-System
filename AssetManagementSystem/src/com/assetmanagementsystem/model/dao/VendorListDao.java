package com.assetmanagementsystem.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.assetmanagementsystem.model.entity.VendorListEntity;

public class VendorListDao {
	
	public boolean addVendor(VendorListEntity vle) {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		if(session.save(vle) != null) {
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public boolean updateVendor(VendorListEntity vle) {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		VendorListEntity ve = (VendorListEntity) session.get(VendorListEntity.class, vle.getVendorId());
		
		ve.setVendorId(vle.getVendorId());
		ve.setVendorName(vle.getVendorName());
		
		if(session.save(ve) != null) {
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public boolean deletevendor(int vendorId) {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String slq = "delete from vendor_list_table where vendor_id = :vendorId";
		SQLQuery query = session.createSQLQuery(slq);
		query.setParameter("vendorId", vendorId);
		
		if(query.executeUpdate() > 0) {
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	public List<VendorListEntity> viewVendor() {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql = "select * from vendor_list_table";
		Query query = session.createQuery(sql);
		
		List<VendorListEntity> vendorList = query.list();
		return vendorList;
	}
}
