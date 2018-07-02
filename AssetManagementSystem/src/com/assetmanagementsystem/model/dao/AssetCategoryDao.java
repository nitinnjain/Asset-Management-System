package com.assetmanagementsystem.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.assetmanagementsystem.model.entity.AssetCategoryEntity;

public class AssetCategoryDao {
	
	public boolean addCategory(AssetCategoryEntity category) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		if(session.save(category)!=null) {	
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public boolean updateCategory(AssetCategoryEntity category) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		AssetCategoryEntity assetCategory = new AssetCategoryEntity();
		assetCategory=(AssetCategoryEntity)session.get(AssetCategoryEntity.class, category.getCategoryId());
		assetCategory.setCategoryId(category.getCategoryId());
		assetCategory.setCategoryName(category.getCategoryName());
		if(session.save(category)!=null) {	
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public boolean deleteCategory(int categoryId) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="delete from asset_category where category_id = :cId";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter("cId",categoryId);
		if(query.executeUpdate()>0) {	
			session.getTransaction().commit();
			return true;
		}
		return false;
		
	}
	
	public Map<Integer, AssetCategoryEntity> listCategory () {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Map<Integer,AssetCategoryEntity> assetCategoryMap=new HashMap<>();
		String hql="from AssetCategoryEntity";
		Query query=session.createQuery(hql);
		List<AssetCategoryEntity> list = query.list();
		for(AssetCategoryEntity assetCategory : list) {
			assetCategoryMap.put(assetCategory.getCategoryId(), assetCategory);
		}
		
		return assetCategoryMap;
	}
	
}