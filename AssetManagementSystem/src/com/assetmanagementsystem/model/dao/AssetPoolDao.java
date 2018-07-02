package com.assetmanagementsystem.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.assetmanagementsystem.model.entity.AssetPoolEntity;

public class AssetPoolDao {
	
	public boolean addAsset(AssetPoolEntity asset) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		if(session.save(asset)!=null) {			
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public boolean updateAsset(AssetPoolEntity asset) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		AssetPoolEntity assetPool=new AssetPoolEntity();
		assetPool=(AssetPoolEntity)session.get(AssetPoolEntity.class, asset.getAssetId());
		assetPool.setAssetId(asset.getAssetId());
		assetPool.setAssetCategory(asset.getAssetCategory());
		assetPool.setAssetName(asset.getAssetName());
		assetPool.setAssetQuantity(asset.getAssetQuantity());
		assetPool.setAssetDescription(asset.getAssetDescription());
		assetPool.setKeyword(asset.getKeyword());
		if(session.save(assetPool)!=null) {
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public boolean deleteAsset(int assetId) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="delete from asset_pool_table where asset_id = :aId";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter("aId",assetId);
		if(query.executeUpdate()>0) {	
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public List<AssetPoolEntity> displayByName(String name) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql="from AssetPoolEntity where assetName = :name";
		Query query=session.createQuery(hql);
		query.setParameter("name", name);
		List<AssetPoolEntity> list = query.list();
		return list;
	}
	
	public List<AssetPoolEntity> displayByCategory(String category) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql="from AssetPoolEntity where assetCategory = :category";
		Query query=session.createQuery(hql);
		query.setParameter("category", category);
		List<AssetPoolEntity> list = query.list();
		return list;
	}
	
	public boolean updateQuantity(int quantity, String assetId) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="update asset_pool_table set asset_quantity=:quantity where asset_id like :assetId";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter("quantity", quantity);
		query.setParameter("assetId", assetId);
		if(query.executeUpdate()>0) {	
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
}
