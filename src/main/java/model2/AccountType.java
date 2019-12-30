package model2;


import java.math.BigDecimal;


public class AccountType {
	
	private int acc_type_ID;
	private BigDecimal interestRate;
	private BigDecimal minimumBalance;
	private String name;

	public AccountType() {
	}

	public int getAcc_type_ID() {
		return this.acc_type_ID;
	}

	public void setAcc_type_ID(int acc_type_ID) {
		this.acc_type_ID = acc_type_ID;
	}

	public BigDecimal getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public BigDecimal getMinimumBalance() {
		return this.minimumBalance;
	}

	public void setMinimumBalance(BigDecimal minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}