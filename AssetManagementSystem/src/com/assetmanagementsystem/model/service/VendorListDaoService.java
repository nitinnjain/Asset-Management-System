package com.assetmanagementsystem.model.service;

import java.util.List;

import com.assetmanagementsystem.model.dao.VendorListDao;
import com.assetmanagementsystem.model.entity.VendorListEntity;

public class VendorListDaoService {
	VendorListDao vld = new VendorListDao();
	
	public boolean addVendor(VendorListEntity vle) {
		return vld.addVendor(vle);
	}
	
	public boolean updateVendor(VendorListEntity vle) {
		return vld.updateVendor(vle);
	}
	
	public boolean deleteVendor(int vendorId) {
		return vld.deletevendor(vendorId);
	}
	
	public List<VendorListEntity> viewVendor() {
		return vld.viewVendor();
	}
}
