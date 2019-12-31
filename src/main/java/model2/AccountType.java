package model2;




public class AccountType {
	
	private int acc_type_ID;
	private int interestRate;
	private int minimumBalance;
	private String name;

	public AccountType() {
	}

	public AccountType(int acc_type_ID,int interestRate, int minimumBalance, String name) {
		this.acc_type_ID = acc_type_ID;
		this.interestRate = interestRate;
		this.minimumBalance = minimumBalance;
		this.name = name;
	}

	public AccountType(int interestRate, int minimumBalance, String name) {
		this.interestRate = interestRate;
		this.minimumBalance = minimumBalance;
		this.name = name;
	}



	public int getAcc_type_ID() {
		return this.acc_type_ID;
	}

	public void setAcc_type_ID(int acc_type_ID) {
		this.acc_type_ID = acc_type_ID;
	}

	public int getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

	public int getMinimumBalance() {
		return this.minimumBalance;
	}

	public void setMinimumBalance(int minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AccountType [acc_type_ID=" + acc_type_ID + ", interestRate=" + interestRate + ", minimumBalance="
				+ minimumBalance + ", name=" + name + "]";
	}
	

}