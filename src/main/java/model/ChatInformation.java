package model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Parent;

@Embeddable
public class ChatInformation {

	private String sendSide;
	@Temporal(TemporalType.TIMESTAMP)
	private Date chatTime;
	@Lob
	private String chatContent;
	@Parent
	private Chat owner;
	public String getSendSide() {
		return sendSide;
	}
	public void setSendSide(String sendSide) {
		this.sendSide = sendSide;
	}
	public Date getChatTime() {
		return chatTime;
	}
	public void setChatTime(Date chatTime) {
		this.chatTime = chatTime;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	public Chat getOwner() {
		return owner;
	}
	public void setOwner(Chat owner) {
		this.owner = owner;
	}
	
}
