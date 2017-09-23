package model;

import javax.persistence.*;

@Entity
@Table(name="province")
public class Province {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pro_id",nullable=false)
    private	Integer provinceId;
	@Column(name="pro_name")
	private String provinceName;
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
}
