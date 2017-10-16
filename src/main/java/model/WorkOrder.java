package model;

import javax.persistence.*;

@Entity
@Table(name="work_order")
public class WorkOrder extends Order{

	/**
	 * 是否取消
	 */
	@Column(name="cancel_state",nullable=false)
	private Boolean cancelState=false;

	public Boolean getCancelState() {
		return cancelState;
	}

	public void setCancelState(Boolean cancelState) {
		this.cancelState = cancelState;
	}
	
}
