package model;

import javax.persistence.*;

@Entity
@Table(name="over_order")
public class OverOrder extends Order{

	@Column(name="comment_state",nullable=false)
	private Boolean commentState=false;

	public Boolean getCommentState() {
		return commentState;
	}

	public void setCommentState(Boolean commentState) {
		this.commentState = commentState;
	}
	
}
