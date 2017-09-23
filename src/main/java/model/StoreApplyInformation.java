package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="store_apply_information")
public class StoreApplyInformation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	private String province;
	private String city;
	private String region;
	private String street;
	private String addressDetail;
	private String storeName;
	private String storeType;
	private String rangeType;
	private String linkName;
	private String linkPhone;
	@Lob
	private byte[] mainPic1;
	@Lob
	private byte[] mainPic2;
	private String carType;
	@Lob
	private byte[] sellPic;
	@Lob
	private byte[] otherPic1;
	@Lob
	private byte[] otherPic2;
	@Lob
	private byte[] otherPic3;
	private Boolean passApply=false;
	public Boolean getPassApply() {
		return passApply;
	}
	public void setPassApply(boolean passApply) {
		this.passApply = passApply;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreType() {
		return storeType;
	}
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	public String getRangeType() {
		return rangeType;
	}
	public void setRangeType(String rangeType) {
		this.rangeType = rangeType;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	public byte[] getMainPic1() {
		return mainPic1;
	}
	public void setMainPic1(byte[] mainPic1) {
		this.mainPic1 = mainPic1;
	}
	public byte[] getMainPic2() {
		return mainPic2;
	}
	public void setMainPic2(byte[] mainPic2) {
		this.mainPic2 = mainPic2;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public byte[] getSellPic() {
		return sellPic;
	}
	public void setSellPic(byte[] sellPic) {
		this.sellPic = sellPic;
	}
	public byte[] getOtherPic1() {
		return otherPic1;
	}
	public void setOtherPic1(byte[] otherPic1) {
		this.otherPic1 = otherPic1;
	}
	public byte[] getOtherPic2() {
		return otherPic2;
	}
	public void setOtherPic2(byte[] otherPic2) {
		this.otherPic2 = otherPic2;
	}
	public byte[] getOtherPic3() {
		return otherPic3;
	}
	public void setOtherPic3(byte[] otherPic3) {
		this.otherPic3 = otherPic3;
	}
	
}
