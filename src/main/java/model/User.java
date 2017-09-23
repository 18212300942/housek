package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="user")
public class User implements Serializable{
	
    @Id@Column(name="id",nullable=false)
    @GenericGenerator(name="user_hilo",strategy="hilo")
    @GeneratedValue(generator="user_hilo")
	private Integer Id;
    @Column(unique=true,nullable=false)
	private String userId;
	private String userPasswd;
	private String userName;
	@Lob
	private byte[] userPhoto;
	@ElementCollection(targetClass=UserAddress.class,fetch=FetchType.EAGER)
	@CollectionTable(name="user_addresses",joinColumns=@JoinColumn(name="user_id",nullable=false))
	@OrderColumn(name="list_order")
	private List<UserAddress> userAddresses=new ArrayList<UserAddress>();
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
	public String getUserPasswd() {
		return userPasswd;
	}
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public byte[] getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(byte[] userPhoto) {
		this.userPhoto = userPhoto;
	}
	public List<UserAddress> getUserAddresses() {
		return userAddresses;
	}
	public void setUserAddresses(List<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}
	public User(){
		
	}

	public User(String userId,String passwd){
		this.userId=userId;
		this.userPasswd=passwd;
	}
}
