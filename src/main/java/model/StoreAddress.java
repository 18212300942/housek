package model;

import javax.persistence.*;

import org.hibernate.annotations.Parent;

@Embeddable
public class StoreAddress {
	private String storeProvince;
	private String storeCity;
	private String storeRegion;
	private String storeStreet;
	private String storeDetailAddress;
//	@Parent
//	private StoreInformation owner;
	public String getStoreProvince() {
		return storeProvince;
	}
	public void setStoreProvince(String storeProvince) {
		this.storeProvince = storeProvince;
	}
	public String getStoreCity() {
		return storeCity;
	}
	public void setStoreCity(String storeCity) {
		this.storeCity = storeCity;
	}
	public String getStoreRegion() {
		return storeRegion;
	}
	public void setStoreRegion(String storeRegion) {
		this.storeRegion = storeRegion;
	}
	public String getStoreStreet() {
		return storeStreet;
	}
	public void setStoreStreet(String storeStreet) {
		this.storeStreet = storeStreet;
	}
	public String getStoreDetailAddress() {
		return storeDetailAddress;
	}
	public void setStoreDetailAddress(String storeDetailAddress) {
		this.storeDetailAddress = storeDetailAddress;
	}
//	public StoreInformation getOwner() {
//		return owner;
//	}
//	public void setOwner(StoreInformation owner) {
//		this.owner = owner;
//	}

}
