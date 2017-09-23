package model;

import javax.persistence.*;

@Entity
@Table(name="single_store_check")
public class SingleStoreCheck {

	@Id@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer Id;
	private String userId;
	private String sinsIdcard;
	private String sinsName;
	@Lob
	private byte[] sinsPhoto1;
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
	 
	 
}
