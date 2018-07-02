package com.assetmanagementsystem.model.service;

import java.util.List;

import com.assetmanagementsystem.model.dao.AssetPoolDao;
import com.assetmanagementsystem.model.entity.AssetPoolEntity;

public class AssetPoolDaoService {
	
	AssetPoolDao assetDao=new AssetPoolDao();
	
	public boolean addAsset(AssetPoolEntity asset) {
		return assetDao.addAsset(asset);
	}
	
	public boolean updateAsset(AssetPoolEntity asset) {
		return assetDao.updateAsset(asset);
	}
	
	public boolean deleteAsset(int assetId) {
		return assetDao.deleteAsset(assetId);
	}
	
	public List<AssetPoolEntity> displayByName(String name) {
		return assetDao.displayByName(name);
	}
	
	public List<AssetPoolEntity> displayByCategory(String category) {
		return assetDao.displayByCategory(category);
	}
	
	public boolean updateQuantity(int quantity, String assetId) {
		return assetDao.updateQuantity(quantity, assetId);
	}
}
