package model;

import javax.persistence.*;
@Entity
@Table(name="company_store_check")
public class CompanyStoreCheck {

	@Id@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer Id;
	private String userId;
	private String comsIdcard;
	private String comsName;
	private byte[] comsPhoto1;
	private byte[] comsPhoto2;
	private String companyId;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	
}
