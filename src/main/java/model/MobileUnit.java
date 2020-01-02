package model;


public class MobileUnit {


	private int muId;
	private int balance;
	private String password;

	public MobileUnit() {
	}
	
	public MobileUnit(int muId, int balance) {
		super();
		this.muId = muId;
		this.balance = balance;
	}
	

	public MobileUnit(int muId, int balance, String password) {
		super();
		this.muId = muId;
		this.balance = balance;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMuId() {
		return this.muId;
	}

	public void setMuId(int muId) {
		this.muId = muId;
	}



	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}



	@Override
	public String toString() {
		return "MobileUnit [muId=" + muId + ", balance=" + balance + ", password=" + password
				+ "]";
	}

	

	
}