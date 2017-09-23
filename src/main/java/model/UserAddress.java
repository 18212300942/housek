package model;

import javax.persistence.*;

import org.hibernate.annotations.Parent;

@Embeddable
public class UserAddress {
	private String linkName;
	private String linkPhone;
	private String userProvince;
	private String userCity;
	private String userRegion;
	private String userStreet;
	private String userDetailAddress;
	/*
	@Parent
	private User owner1;
	
	@Parent
	private Demand owner2;
	@Parent 
	private Order owner3;
	*/
	public UserAddress(){
		
	}
	/**
	 * @param linkName
	 * @param linkPhone
	 * @param userProvince
	 * @param userCity
	 * @param userRegion
	 * @param userStreet
	 * @param userDetailAddress
	 */
	public UserAddress(String linkName, String linkPhone, String userProvince, String userCity, String userRegion,
			String userStreet, String userDetailAddress) {
		this.linkName = linkName;
		this.linkPhone = linkPhone;
		this.userProvince = userProvince;
		this.userCity = userCity;
		this.userRegion = userRegion;
		this.userStreet = userStreet;
		this.userDetailAddress = userDetailAddress;
	}
	public String getUserProvince() {
		return userProvince;
	}
	public void setUserProvince(String userProvince) {
		this.userProvince = userProvince;
	}
	
	public String getUserCity() {
		return userCity;
	}
	
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	
	public String getUserRegion() {
		return userRegion;
	}
	public void setUserRegion(String userRegion) {
		this.userRegion = userRegion;
	}
	public String getUserStreet() {
		return userStreet;
	}
	public void setUserStreet(String userStreet) {
		this.userStreet = userStreet;
	}
	public String getUserDetailAddress() {
		return userDetailAddress;
	}
	public void setUserDetailAddress(String userDetailAddress) {
		this.userDetailAddress = userDetailAddress;
	}
	/*
	public User getOwner1() {
		return owner1;
	}
	public void setOwner1(User owner1) {
		this.owner1 = owner1;
	}
	
	public Demand getOwner2() {
		return owner2;
	}
	public void setOwner2(Demand owner2) {
		this.owner2 = owner2;
	}
	public Order getOwner3() {
		return owner3;
	}
	public void setOwner3(Order owner3) {
		this.owner3 = owner3;
	}
	*/
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName=linkName;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	
}
