package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="chat")
public class Chat{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(unique=true,nullable=false)
	private String uid;
	private Boolean readState=false;
	@ElementCollection(targetClass=ChatInformation.class,fetch=FetchType.EAGER)
	@CollectionTable(name="chat_information",joinColumns={@JoinColumn(name="uid",nullable=false)})
	@OrderColumn(name="list_order")
	private List<ChatInformation> chatInformations=new ArrayList<ChatInformation>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Boolean getReadState() {
		return readState;
	}
	public void setReadState(Boolean readState) {
		this.readState = readState;
	}
	public List<ChatInformation> getChatInformations() {
		return chatInformations;
	}
	public void setChatInformations(List<ChatInformation> chatInformations) {
		this.chatInformations = chatInformations;
	}
	
}
