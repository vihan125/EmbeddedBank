package model2;

import java.math.BigDecimal;
import java.util.Date;



public class Mobilet  {

	private int mobileT_ID;
	private int agent_ID;
	private int amount;
	private Date date_of_mobileT;

	public Mobilet() {
	}

	public int getMobileT_ID() {
		return this.mobileT_ID;
	}

	public void setMobileT_ID(int mobileT_ID) {
		this.mobileT_ID = mobileT_ID;
	}

	public int getAgent_ID() {
		return this.agent_ID;
	}

	public void setAgent_ID(int agent_ID) {
		this.agent_ID = agent_ID;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate_of_mobileT() {
		return this.date_of_mobileT;
	}

	public void setDate_of_mobileT(Date date_of_mobileT) {
		this.date_of_mobileT = date_of_mobileT;
	}


}