package model2;


public class OwnBy {
	
	private int account_ID;
	private int customer_ID;
	
	
	public int getAccount_ID() {
		return account_ID;
	}
	public void setAccount_ID(int account_ID) {
		this.account_ID = account_ID;
	}
	public int getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}
	
	public OwnBy(int account_ID, int customer_ID) {
		super();
		this.account_ID = account_ID;
		this.customer_ID = customer_ID;
	}
	

}
