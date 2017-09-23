package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="region")
public class Region {

	@Id@Column(name="region_id",nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer regionId;
	@Column(name="region_name")
	private String regionName;
	//@ManyToOne(targetEntity=City.class)
	//@JoinColumn(name="city_id",nullable=false)
	@Column(name="city_id")
	private Integer cityId;
	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
}
