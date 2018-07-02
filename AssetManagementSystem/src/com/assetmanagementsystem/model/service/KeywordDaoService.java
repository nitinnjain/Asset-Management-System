package com.assetmanagementsystem.model.service;

import java.util.Map;

import com.assetmanagementsystem.model.dao.KeywordDao;
import com.assetmanagementsystem.model.entity.KeywordEntity;

public class KeywordDaoService {
	
	KeywordDao keyDao=new KeywordDao();
	
	public boolean addKeyword(KeywordEntity keyword) {
		keyword.setKeywords(keyword.getKeywords().toLowerCase());
		return keyDao.addKeyword(keyword);
	}
	
	public boolean updateKeyword(KeywordEntity keyword) {	
		String keywordName=keyword.getKeywords().toLowerCase();
		keyword.setKeywords(keywordName);
		return keyDao.updateKeyword(keyword);
	}
	
	public boolean deletekeyword(int keywordId) {
		return keyDao.deleteKeyword(keywordId);
	}
	
	public Map<Integer, KeywordEntity> listKeyword () {
		return keyDao.listKeyword();
	}

	public boolean checkKeyword(String keyword) {
		return keyDao.checkKeyword(keyword);
	}
}
