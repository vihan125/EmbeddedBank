package model2;

public class MakeDeposit {
	
	private int account_ID;
	private int deposit_ID;
	public int getAccount_ID() {
		return account_ID;
	}
	public void setAccount_ID(int account_ID) {
		this.account_ID = account_ID;
	}
	public int getDeposit_ID() {
		return deposit_ID;
	}
	public void setDeposit_ID(int deposit_ID) {
		this.deposit_ID = deposit_ID;
	}
	
	public MakeDeposit(int account_ID, int deposit_ID) {
		super();
		this.account_ID = account_ID;
		this.deposit_ID = deposit_ID;
	}
	
	

}
