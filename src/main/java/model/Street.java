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
@Table(name="street")
public class Street {


	@Id@Column(name="street_id",nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer streetId;
	@Column(name="street_name")
	private String streetName;
	//@ManyToOne(targetEntity=Region.class)
	//@JoinColumn(name="region_id",nullable=false)
	@Column(name="region_id")
	private Integer regionId;
	public Integer getStreetId() {
		return streetId;
	}
	public void setStreetId(Integer streetId) {
		this.streetId = streetId;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}
	
}
