package model;

import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="demand")
public class Demand {

	@Id@Column(name="id",nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String userId;
	private UserAddress userAddress;
	private String type;
	private String price;
	private Integer amount;
	@Temporal(TemporalType.TIMESTAMP)
	private Date workTime;
	
	@Column(length=1000)
	private String workDemand;
	
	public String getWorkDemand() {
		return workDemand;
	}
	public void setWorkDemand(String workDemand) {
		this.workDemand = workDemand;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Date getWorkTime() {
		return workTime;
	}
	public void setWorkTime(Date workTime) {
		this.workTime = workTime;
	}
	
}
