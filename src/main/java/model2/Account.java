package model2;





public class Account{

	private int user_ID;
	private int account_ID;
	private long balance;
	private AccountType accountType;

	public Account() {
	}
	

	public int getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}
	
	public Account(int user_ID,int account_ID,long balance, AccountType accountType) {
		super();
		this.account_ID = account_ID;
		this.user_ID = user_ID;
		this.balance = balance;
		this.accountType = accountType;
	}

	
	
	public Account(int user_ID,long balance, AccountType accountType) {
		super();
		this.user_ID = user_ID;
		this.balance = balance;
		this.accountType = accountType;
	}
	
	public Account(long balance, AccountType accountType) {
		super();
		this.balance = balance;
		this.accountType = accountType;
	}

	public int getAccount_ID() {
		return this.account_ID;
	}

	public void setAccount_ID(int account_ID) {
		this.account_ID = account_ID;
	}

	public long getBalance() {
		return this.balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public AccountType getAccountType() {
		return this.accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}


	@Override
	public String toString() {
		return "Account [user_ID=" + user_ID + ", account_ID=" + account_ID + ", balance=" + balance + ", accountType="
				+ accountType + "]";
	}

}