package model;

import javax.persistence.*;

@Entity
@Table(name="company_store")
public class CompanyStore extends User{
	private String comsIdcard;
	private String comsName;
	private Double sumScore=0.0;
	private Integer orderCount=0;
	
	@Lob
	private byte[] comsPhoto1;
	@Lob
	private byte[] comsPhoto2;
	private String companyId;
	private StoreInformation comStoreInformation;
	public String getComsIdcard() {
		return comsIdcard;
	}
	public void setComsIdcard(String comsIdcard) {
		this.comsIdcard = comsIdcard;
	}
	public String getComsName() {
		return comsName;
	}
	public void setComsName(String comsName) {
		this.comsName = comsName;
	}
	public byte[] getComsPhoto1() {
		return comsPhoto1;
	}
	public void setComsPhoto1(byte[] comsPhoto1) {
		this.comsPhoto1 = comsPhoto1;
	}
	public byte[] getComsPhoto2() {
		return comsPhoto2;
	}
	public void setComsPhoto2(byte[] comsPhoto2) {
		this.comsPhoto2 = comsPhoto2;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public StoreInformation getComStoreInformation() {
		return comStoreInformation;
	}
	public void setComStoreInformation(StoreInformation comStoreInformation) {
		this.comStoreInformation = comStoreInformation;
	}
	public CompanyStore(){
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
