package entity;

public class mUnitEntity {
	
	private String MU_ID;
	private String Agent_ID;
	private String Balance;
	
	public mUnitEntity(String mU_ID, String agent_ID, String balance) {
		super();
		MU_ID = mU_ID;
		Agent_ID = agent_ID;
		Balance = balance;
	}

	public String getMU_ID() {
		return MU_ID;
	}

	public void setMU_ID(String mU_ID) {
		MU_ID = mU_ID;
	}

	public String getAgent_ID() {
		return Agent_ID;
	}

	public void setAgent_ID(String agent_ID) {
		Agent_ID = agent_ID;
	}

	public String getBalance() {
		return Balance;
	}

	public void setBalance(String balance) {
		Balance = balance;
	}

	@Override
	public String toString() {
		return "mUnitEntity [MU_ID=" + MU_ID + ", Agent_ID=" + Agent_ID + ", Balance=" + Balance + "]";
	}
	
	
	
	

}
