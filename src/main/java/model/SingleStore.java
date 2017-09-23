package model;

import javax.persistence.*;
@Entity
@Table(name="single_store")
public class SingleStore extends User{

	private String sinsIdcard;
	private String sinsName;
	private Double sumScore=0.0;
	private Integer orderCount=0;
	@Lob
	private byte[] sinsPhoto1;
	private StoreInformation sinsStoreInformation;
	public String getSinsIdcard() {
		return sinsIdcard;
	}
	public void setSinsIdcard(String sinsIdcard) {
		this.sinsIdcard = sinsIdcard;
	}
	public String getSinsName() {
		return sinsName;
	}
	public void setSinsName(String sinsName) {
		this.sinsName = sinsName;
	}
	public byte[] getSinsPhoto1() {
		return sinsPhoto1;
	}
	public void setSinsPhoto1(byte[] sinsPhoto1) {
		this.sinsPhoto1 = sinsPhoto1;
	}
	public StoreInformation getSinsStoreInformation() {
		return sinsStoreInformation;
	}
	public void setSinsStoreInformation(StoreInformation sinsStoreInformation) {
		this.sinsStoreInformation = sinsStoreInformation;
	}
	public SingleStore() {
		super();
	}
	public Double getSumScore() {
		return sumScore;
	}
	public void setSumScore(Double sumScore) {
		this.sumScore = sumScore;
	}
	public Integer getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}
	
}
