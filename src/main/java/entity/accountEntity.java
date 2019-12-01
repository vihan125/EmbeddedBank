package entity;

public class accountEntity {
	private int account_ID;
	private int acc_type_ID;
	private double balance;
	
	public accountEntity(int account_ID, int acc_type_ID, double balance) {
		this.account_ID = account_ID;
		this.acc_type_ID = acc_type_ID;
		this.balance = balance;
	}

	public int getAccount_ID() {
		return account_ID;
	}

	public void setAccount_ID(int account_ID) {
		this.account_ID = account_ID;
	}

	public int getAcc_type_ID() {
		return acc_type_ID;
	}

	public void setAcc_type_ID(int acc_type_ID) {
		this.acc_type_ID = acc_type_ID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "accountEntity [account_ID=" + account_ID + ", acc_type_ID=" + acc_type_ID + ", balance=" + balance
				+ "]";
	}
	
	
	

}
