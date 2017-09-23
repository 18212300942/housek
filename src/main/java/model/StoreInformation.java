package model;

import javax.persistence.*;

import org.hibernate.annotations.Parent;
@Embeddable
public class StoreInformation {

	private String storeName;
	private String storePhone;
	private String storeType;
	private String storePrice="未定价";
	private StoreAddress storeAddress;
	@Lob
	private byte[] storePhoto;
	@Lob
	private String storeIntroduce;
//	@Parent
//	private SingleStore owner1;
//	@Parent
//	private CompanyStore owner2;
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStorePhone() {
		return storePhone;
	}
	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}
	public String getStoreType() {
		return storeType;
	}
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	public String getStorePrice() {
		return storePrice;
	}
	public void setStorePrice(String storePrice) {
		this.storePrice = storePrice;
	}
	public StoreAddress getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(StoreAddress storeAddress) {
		this.storeAddress = storeAddress;
	}
	public byte[] getStorePhoto() {
		return storePhoto;
	}
	public void setStorePhoto(byte[] storePhoto) {
		this.storePhoto = storePhoto;
	}
	public String getStoreIntroduce() {
		return storeIntroduce;
	}
	public void setStoreIntroduce(String storeIntroduce) {
		this.storeIntroduce = storeIntroduce;
	}
//	public SingleStore getOwner1() {
//		return owner1;
//	}
//	public void setOwner1(SingleStore owner1) {
//		this.owner1 = owner1;
//	}
//	public CompanyStore getOwner2() {
//		return owner2;
//	}
//	public void setOwner2(CompanyStore owner2) {
//		this.owner2 = owner2;
//	}
//	
	
}
