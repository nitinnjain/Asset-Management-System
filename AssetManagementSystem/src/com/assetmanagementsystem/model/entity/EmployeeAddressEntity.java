package com.assetmanagementsystem.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="employee_address_table")
public class EmployeeAddressEntity {
	
	@Id
	@GeneratedValue()
	@Column(name="address_id", length=8)
	private int addressId;

	@Column(name="flat_houseno_floor_building", length=30)
	private String flatHouseFloorBuilding;

	@Column(name="colony_street_locality", length=30)
	private String colonyStreetLocality;

	@Column(name="landmark", length=15)
	private String landmark;

	@Column(name="address_city", length=20)
	private String city;

	@Column(name="address_state", length=20)
	private String state;

	public EmployeeAddressEntity() {
		super();
	}

	@Column(name="address_country", length=15)
	private String country;

	@Column(name="address_pincode", length=8)
	private int pincode;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getFlatHouseFloorBuilding() {
		return flatHouseFloorBuilding;
	}

	public void setFlatHouseFloorBuilding(String flatHouseFloorBuilding) {
		this.flatHouseFloorBuilding = flatHouseFloorBuilding;
	}

	public String getColonyStreetLocality() {
		return colonyStreetLocality;
	}

	public void setColonyStreetLocality(String colonyStreetLocality) {
		this.colonyStreetLocality = colonyStreetLocality;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "EmployeeAddressEntity [addressId=" + addressId + ", flatHouseFloorBuilding=" + flatHouseFloorBuilding
				+ ", colonyStreetLocality=" + colonyStreetLocality + ", landmark=" + landmark + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}
}