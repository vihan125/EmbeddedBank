package model2;


public class MobileUnit {


	private int muId;
	private int agent_ID;
	private int balance;

	public MobileUnit() {
	}
	
	

	public MobileUnit(int muId, int agent_ID, int balance) {
		super();
		this.muId = muId;
		this.agent_ID = agent_ID;
		this.balance = balance;
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

	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "MobileUnit [muId=" + muId + ", agent_ID=" + agent_ID + ", balance=" + balance + "]";
	}

	
}