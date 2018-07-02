package com.assetmanagementsystem.model.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.assetmanagementsystem.model.entity.AssetCategoryEntity;
import com.assetmanagementsystem.model.entity.AssetPoolEntity;
import com.assetmanagementsystem.model.entity.AssetSerialNumberEntity;
import com.assetmanagementsystem.model.entity.EmployeeAddressEntity;
import com.assetmanagementsystem.model.entity.EmployeeEntity;
import com.assetmanagementsystem.model.entity.KeywordEntity;
import com.assetmanagementsystem.model.entity.ProjectEntity;
import com.assetmanagementsystem.model.entity.PurchaseEntity;
import com.assetmanagementsystem.model.entity.PurchaseProductEntity;
import com.assetmanagementsystem.model.entity.RequestEntity;
import com.assetmanagementsystem.model.entity.VendorListEntity;

public class DaoUtility {
	
	public static SessionFactory getSessionFactory()  {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(EmployeeEntity.class)
				.addAnnotatedClass(EmployeeAddressEntity.class)
				.addAnnotatedClass(ProjectEntity.class)
				.addAnnotatedClass(AssetCategoryEntity.class)
				.addAnnotatedClass(AssetPoolEntity.class)
				.addAnnotatedClass(AssetSerialNumberEntity.class)
				.addAnnotatedClass(KeywordEntity.class)
				.addAnnotatedClass(PurchaseEntity.class)
				.addAnnotatedClass(PurchaseProductEntity.class)
				.addAnnotatedClass(RequestEntity.class)
				.addAnnotatedClass(VendorListEntity.class)
				.buildSessionFactory();
		return factory;
	}
}

