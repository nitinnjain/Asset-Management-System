package com.assetmanagementsystem.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.classic.Session;
import com.assetmanagementsystem.model.dao.DaoUtility;
import com.assetmanagementsystem.model.entity.AssetPoolEntity;
import com.assetmanagementsystem.model.entity.AssetSerialNumberEntity;
import com.assetmanagementsystem.model.service.RequestDaoService;
import com.assetmanagementsystem.utility.Utility;

public class AssetSerialNumberDao {

	public List<Object[]> getSerialNumber(int assetId) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="select asset_serial_number from asset_serial_no where assetpool_asset_id=:assetId and employee_Id is null";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter("assetId", assetId);
		List<Object[]> unmappedAssets=query.list();
		return unmappedAssets;
	}
	
	public boolean allocateAsset(String assetSerialNumber, int eId, String allocatedBy, int requestId) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="update asset_serial_no set employee_id=:eId, allocated_by=:allocatedBy where asset_serial_number=:sNo";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter("eId", eId);
		query.setParameter("sNo", assetSerialNumber);
		query.setParameter("allocatedBy", allocatedBy);
		
		if(query.executeUpdate()>0) {	
			RequestDaoService rds=new RequestDaoService();
			rds.updateRequestStatus(requestId, Utility.ALLOCATED);
			session.getTransaction().commit();
			return true;
		}
		return false;
		
	}

	public boolean deallocateAsset(String assetSerialNumber) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="update asset_serial_no set employee_id=null,allocated_by=null where asset_serial_number=:sNo";
		SQLQuery query=session.createSQLQuery(sql);
		//query.setParameter("eId", eId);
		query.setParameter("sNo", assetSerialNumber);
		if(query.executeUpdate()>0) {	
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public List<AssetSerialNumberEntity> displayAssetByEId(int eId) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql="from AssetSerialNumberEntity where employeeId=:eId";
		Query query=session.createQuery(hql);
		query.setParameter("eId", eId);
		List list=query.list();
		return list;
	}
	
	public List<Object[]> displayAssetByAssetId(int assetId) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="select employee_id, asset_serial_number from asset_serial_no where assetpool_asset_id=:assetId and employee_id is not null";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter("assetId", assetId);
		List list=query.list();
		return list;
	}
	
	public AssetSerialNumberEntity displayEmployeeByAssetSno(String assetSno) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql="from AssetSerialNumberEntity where assetSerialNumber=:assetSno";
		Query query=session.createQuery(hql);
		query.setParameter("assetSno",assetSno);
		AssetSerialNumberEntity asne=(AssetSerialNumberEntity)query.uniqueResult();
		return asne;
	}
}
