package model;

import javax.persistence.*;

@Entity
@Table(name="city")
public class City {

	@Id@Column(name="city_id",nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cityId;
	@Column(name="city_name")
	private String cityName;
	//@ManyToOne(targetEntity=Province.class)
	//@JoinColumn(name="pro_id",nullable=false)
	@Column(name="pro_id")
	private Integer provinceId;
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	
}
