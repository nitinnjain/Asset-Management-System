package com.assetmanagementsystem.model.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.assetmanagementsystem.model.entity.AssetCategoryEntity;
import com.assetmanagementsystem.model.entity.KeywordEntity;

public class KeywordDao {

	public boolean addKeyword(KeywordEntity keyword) {	
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		if(!checkKeyword(keyword.getKeywords())) {	
			if(session.save(keyword)!=null) {	
				session.getTransaction().commit();
				return true;
			}
		}
		return false;
	}

	public boolean updateKeyword(KeywordEntity keyword) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="update keyword_table set keywords=:updatedName where keyword_id=:keywordId";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter("updatedName", keyword.getKeywords());
		query.setParameter("keywordId", keyword.getKeywordId());
		if(query.executeUpdate()>0) {	
			session.getTransaction().commit();
			return true;
		}
		return false;
	}

	public boolean deleteKeyword(int keywordId) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="delete from keyword_table where keyword_id = :kId";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter("kId",keywordId);
		if(query.executeUpdate()>0) {	
			session.getTransaction().commit();
			return true;
		}
		return false;

	}

	public Map<Integer, KeywordEntity> listKeyword () {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Map<Integer,KeywordEntity> keywordMap=new LinkedHashMap<>();
		String hql="from KeywordEntity";
		Query query=session.createQuery(hql);
		List<KeywordEntity> list = query.list();
		for(KeywordEntity assetKeyword : list) {	

			KeywordEntity key=new KeywordEntity();
			key.setKeywordId(assetKeyword.getKeywordId());
			key.setKeywords(assetKeyword.getKeywords().toUpperCase());
			keywordMap.put(assetKeyword.getKeywordId(), key);
		}
		return keywordMap;
	}

	public boolean checkKeyword(String keyword) {	
		Session session =DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="select keywords from keyword_table where keywords=:keyword";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter("keyword", keyword);
		String returnKeyword=(String)query.uniqueResult();
		if(returnKeyword!=null) {	
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
}
