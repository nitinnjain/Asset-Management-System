package com.assetmanagementsystem.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="asset_serial_no")
public class AssetSerialNumberEntity {
	
	@Id
	@GeneratedValue
	@Column(length=7)
	private int sno;
	
	@Column(name="asset_serial_number", length=25)
	private String assetSerialNumber;
	
	@ManyToOne
	private AssetPoolEntity assetPool;

	@Override
	public String toString() {
		return "AssetSerialNumberEntity [assetSerialNumber=" + assetSerialNumber + ", employeeId=" + employeeId + "]";
	}
	
	@Column(name="employee_id", length=7)
	private int employeeId;
	
	@Column(name="allocated_by", length=20)
	private String allocatedBy;
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public AssetPoolEntity getAssetPool() {
		return assetPool;
	}

	public void setAssetPool(AssetPoolEntity assetPool) {
		this.assetPool = assetPool;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getAssetSerialNumber() {
		return assetSerialNumber;
	}

	public void setAssetSerialNumber(String assetSerialNumber) {
		this.assetSerialNumber = assetSerialNumber;
	}

	public String getAllocatedBy() {
		return allocatedBy;
	}

	public void setAllocatedBy(String allocatedBy) {
		this.allocatedBy = allocatedBy;
	}
}
