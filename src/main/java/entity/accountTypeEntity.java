package entity;

public class accountTypeEntity {
	private int acc_type_ID;
	private double interest_rate;
	private double minimum_balance;
	private String name;
	
	public accountTypeEntity(int acc_type_ID, double interest_rate, double minimum_balance, String name) {
		super();
		this.acc_type_ID = acc_type_ID;
		this.interest_rate = interest_rate;
		this.minimum_balance = minimum_balance;
		this.name = name;
	}

	public int getAcc_type_ID() {
		return acc_type_ID;
	}

	public void setAcc_type_ID(int acc_type_ID) {
		this.acc_type_ID = acc_type_ID;
	}

	public double getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}

	public double getMinimum_balance() {
		return minimum_balance;
	}

	public void setMinimum_balance(double minimum_balance) {
		this.minimum_balance = minimum_balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "accountTypeEntity [acc_type_ID=" + acc_type_ID + ", interest_rate=" + interest_rate
				+ ", minimum_balance=" + minimum_balance + ", name=" + name + "]";
	}
	
	
	

}
