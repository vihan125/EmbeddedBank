package model2;


import java.sql.Date;


public class Withdrawl {
	
	private int withdrawl_ID;
	private int amount;
	private Date dateOfWithdrawl;
	
	public Withdrawl() {
	}

	public Withdrawl(int withdrawl_ID, int amount, Date dateOfWithdrawl) {
		super();
		this.withdrawl_ID = withdrawl_ID;
		this.amount = amount;
		this.dateOfWithdrawl = dateOfWithdrawl;
	}

	public int getWithdrawl_ID() {
		return this.withdrawl_ID;
	}

	public void setWithdrawl_ID(int withdrawl_ID) {
		this.withdrawl_ID = withdrawl_ID;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDateOfWithdrawl() {
		return this.dateOfWithdrawl;
	}

	public void setDateOfWithdrawl(Date dateOfWithdrawl) {
		this.dateOfWithdrawl = dateOfWithdrawl;
	}

}