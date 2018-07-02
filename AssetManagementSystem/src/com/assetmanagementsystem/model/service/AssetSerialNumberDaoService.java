package com.assetmanagementsystem.model.service;

import java.util.ArrayList;
import java.util.List;

import com.assetmanagementsystem.model.dao.AssetSerialNumberDao;
import com.assetmanagementsystem.model.entity.AssetSerialNumberEntity;
import com.assetmanagementsystem.model.entity.EmployeeEntity;

public class AssetSerialNumberDaoService {

	AssetSerialNumberDao serialNoDao=new AssetSerialNumberDao();

	public List<String> getSerialNumber(int assetId) {	
		List<String> serialNo=new ArrayList<>();
		for(Object i:getSerialNumber(assetId)) {
			serialNo.add(i.toString());
		}
		return serialNo;
	}

	public List<AssetSerialNumberEntity> displayAssetByAssetId(int assetId) {
		List<Object[]> list = serialNoDao.displayAssetByAssetId(assetId);
		List<AssetSerialNumberEntity> assetList=null;
		for(Object[] obj:list) {	
			AssetSerialNumberEntity ase = new AssetSerialNumberEntity();
			assetList =new ArrayList<>();
			ase.setEmployeeId(Integer.parseInt(obj[0].toString()));
			ase.setAssetSerialNumber(obj[1].toString());
			assetList.add(ase);
		}
		return assetList;
	}

	public List<AssetSerialNumberEntity> displayAssetByEId(int eId) {
		return serialNoDao.displayAssetByEId(eId);
	}

	public boolean allocateAsset(String assetSerialNumber, int eId, String allocatedBy, int requestId) {
		return serialNoDao.allocateAsset(assetSerialNumber, eId, allocatedBy,requestId);
	}

	public boolean deallocateAsset(String assetSerialNumber) {
		return serialNoDao.deallocateAsset(assetSerialNumber);
	}

	public AssetSerialNumberEntity displayEmployeeByAssetSno(String assetSno) {
		return serialNoDao.displayEmployeeByAssetSno(assetSno);
	}

	public List<List<AssetSerialNumberEntity>> displayAssetForAllEmployees(List<EmployeeEntity> employeeList) {
		List<List<AssetSerialNumberEntity>> assetList = new ArrayList<>();
		for(EmployeeEntity e : employeeList) {
			int eId = e.getEmployeeId();
			assetList.add(displayAssetByEId(eId));
		}
		return assetList;
	}
}
