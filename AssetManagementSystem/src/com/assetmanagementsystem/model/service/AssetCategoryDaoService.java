package com.assetmanagementsystem.model.service;

import java.util.Map;

import com.assetmanagementsystem.model.dao.AssetCategoryDao;
import com.assetmanagementsystem.model.entity.AssetCategoryEntity;

public class AssetCategoryDaoService {
	
	AssetCategoryDao assetCategory=new AssetCategoryDao();
	
	public boolean addCategory(AssetCategoryEntity category) {
		return assetCategory.addCategory(category);
	}
	
	public boolean updateCategory(AssetCategoryEntity category) {
		return assetCategory.updateCategory(category);
	}
	
	public boolean deleteCategory(int categoryId) {
		return assetCategory.deleteCategory(categoryId);
	}
	
	public Map<Integer, AssetCategoryEntity> listCategory () {
		return assetCategory.listCategory();
	}
}
