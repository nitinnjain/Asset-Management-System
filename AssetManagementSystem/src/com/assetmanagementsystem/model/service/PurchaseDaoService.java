package com.assetmanagementsystem.model.service;

import com.assetmanagementsystem.model.dao.PurchaseDao;
import com.assetmanagementsystem.model.entity.PurchaseEntity;

public class PurchaseDaoService {
	
	PurchaseDao pd = new PurchaseDao();
	
	public boolean addorder(PurchaseEntity pe) {
		return pd.addOrder(pe);
	}
	
	public boolean deleteOrder(int oId) {
		return pd.deleteOrder(oId);
	}
	
	public boolean updateOrder(PurchaseEntity pe) {
		return pd.updateOrder(pe);
	}
	
	public PurchaseEntity viewOrder(int oId) {
		return pd.viewOrder(oId);
	}
}
