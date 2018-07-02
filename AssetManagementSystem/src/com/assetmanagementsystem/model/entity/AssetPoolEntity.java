package com.assetmanagementsystem.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="asset_pool")
public class AssetPoolEntity {
	
	@Id
	@GeneratedValue
	@Column(name="asset_id", length=7)
	private int assetId;
	
	@Column(name="asset_name", length=25)
	private String assetName;

	@ManyToMany(cascade=CascadeType.ALL)
	private List<KeywordEntity> keyword = new ArrayList<>();
	
	@Column(name="asset_category", length=15)
	private String assetCategory;
	
	@Column(name="asset_quantity", length=7)
	private int assetQuantity;
	
	@Column(name="description", length=100)
	private String assetDescription;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<AssetSerialNumberEntity> assetSerialNumber = new ArrayList<>();

	public List<AssetSerialNumberEntity> getAssetSerialNumber() {
		return assetSerialNumber;
	}

	public void setAssetSerialNumber(List<AssetSerialNumberEntity> assetSerialNumber) {
		this.assetSerialNumber = assetSerialNumber;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetCategory() {
		return assetCategory;
	}

	public void setAssetCategory(String assetCategory) {
		this.assetCategory = assetCategory;
	}

	public int getAssetQuantity() {
		return assetQuantity;
	}

	public void setAssetQuantity(int assetQuantity) {
		this.assetQuantity = assetQuantity;
	}

	public String getAssetDescription() {
		return assetDescription;
	}

	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}
	
	public List<KeywordEntity> getKeyword() {
		return keyword;
	}

	public void setKeyword(List<KeywordEntity> keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "AssetPoolEntity [assetId=" + assetId + ", assetName=" + assetName + ", keyword=" + keyword
				+ ", assetCategory=" + assetCategory + ", assetQuantity=" + assetQuantity + ", assetDescription="
				+ assetDescription + ", assetSerialNumber=" + assetSerialNumber + "]";
	}
}