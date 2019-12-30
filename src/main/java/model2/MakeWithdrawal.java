package model2;

public class MakeWithdrawal {
	
	private int account_ID;
	private int withdrawal_ID;
	public int getAccount_ID() {
		return account_ID;
	}
	public void setAccount_ID(int account_ID) {
		this.account_ID = account_ID;
	}
	public int getDeposit_ID() {
		return withdrawal_ID;
	}
	public void setDeposit_ID(int withdrawal_ID) {
		this.withdrawal_ID = withdrawal_ID;
	}
	
	public MakeWithdrawal(int account_ID, int withdrawal_ID) {
		super();
		this.account_ID = account_ID;
		this.withdrawal_ID = withdrawal_ID;
	}
	
	

}
