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
import javax.persistence.Table;

@Entity
@Table(name="keyword_table")
public class KeywordEntity {
	
	@Id
	@GeneratedValue()
	@Column(name="keyword_id", length=7)
	private int keywordId;
	
	@Column(name="keywords", length=10, unique=true, nullable=false)
	private String keywords;

	@ManyToMany(mappedBy="keyword")
	private List<AssetPoolEntity> assets=new ArrayList<>();
	
	public List<AssetPoolEntity> getAssets() {
		return assets;
	}
	
	public void setAssets(List<AssetPoolEntity> assets) {
		this.assets = assets;
	}
	
	public int getKeywordId() {
		return keywordId;
	}
	
	public void setKeywordId(int keywordId) {
		this.keywordId = keywordId;
	}
	
	public String getKeywords() {
		return keywords;
	}
	
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
}
