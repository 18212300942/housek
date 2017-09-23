package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="collection")
public class Collection implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer collectionId;
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(referencedColumnName="userId",nullable=false)
	private User user;
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(referencedColumnName="userId",nullable=false)
	private User store;
	public Integer getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getStore() {
		return store;
	}
	public void setStore(User store) {
		this.store = store;
	}
	
}
