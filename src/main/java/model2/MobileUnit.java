package model2;

import java.math.BigDecimal;


public class MobileUnit {


	private int muId;
	private int agent_ID;
	private BigDecimal balance;

	public MobileUnit() {
	}

	public int getMuId() {
		return this.muId;
	}

	public void setMuId(int muId) {
		this.muId = muId;
	}

	public int getAgent_ID() {
		return this.agent_ID;
	}

	public void setAgent_ID(int agent_ID) {
		this.agent_ID = agent_ID;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


}