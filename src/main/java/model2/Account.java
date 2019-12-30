package model2;


import java.math.BigDecimal;


public class Account{

	
	private int account_ID;
	private BigDecimal balance;
	private AccountType accountType;

	public Account() {
	}

	public int getAccount_ID() {
		return this.account_ID;
	}

	public void setAccount_ID(int account_ID) {
		this.account_ID = account_ID;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public AccountType getAccountType() {
		return this.accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

}