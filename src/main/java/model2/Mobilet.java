package model2;

import java.sql.Date;



public class Mobilet  {

	private int mobileT_ID;
	private int agent_ID;
	private int amount;
	private Date date_of_mobileT;
	private char dep_with;
	private int MU_ID;
	

	public Mobilet() {
	}

	
	public int getMU_ID() {
		return MU_ID;
	}


	public void setMU_ID(int mU_ID) {
		MU_ID = mU_ID;
	}


	public char getDep_with() {
		return dep_with;
	}

	public void setDep_with(char dep_with) {
		this.dep_with = dep_with;
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