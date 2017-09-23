package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="comment")
public class Comment {

	@Id@Column(name="id",nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String userId;
	private String storeId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date commentDate;
	private Double commentScore;
	@Lob
	private String commentText;
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
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public Double getCommentScore() {
		return commentScore;
	}
	public void setCommentScore(Double commentScore) {
		this.commentScore = commentScore;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	
}
