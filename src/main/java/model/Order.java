package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="_order")
@Inheritance(strategy=InheritanceType.JOINED)
public class Order {

	@Id@Column(name="id",nullable=false)
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	private String userId;
	private String storeId;
	private String userName;
	private String userPhone;
	private UserAddress userAddress;
	private String price;
	private Integer amount;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date workTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public UserAddress getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
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
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Date getWorkTime() {
		return workTime;
	}
	public void setWorkTime(Date workTime) {
		this.workTime = workTime;
	}
    
}
