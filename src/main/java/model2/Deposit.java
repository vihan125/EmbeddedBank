package model2;



import java.sql.Date;


public class Deposit {


	private int deposit_ID;
	private int amount;
	private Date dateOfDeposit;

	public Deposit() {
	}
	
	
	public Deposit( int amount, Date dateOfDeposit) {
		super();
		this.amount = amount;
		this.dateOfDeposit = dateOfDeposit;
	}
	
	public Deposit(int deposit_ID, int amount, Date dateOfDeposit) {
		super();
		this.deposit_ID = deposit_ID;
		this.amount = amount;
		this.dateOfDeposit = dateOfDeposit;
	}



	public int getDeposit_ID() {
		return this.deposit_ID;
	}

	public void setDeposit_ID(int deposit_ID) {
		this.deposit_ID = deposit_ID;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDateOfDeposit() {
		return this.dateOfDeposit;
	}

	public void setDateOfDeposit(Date dateOfDeposit) {
		this.dateOfDeposit = dateOfDeposit;
	}

	@Override
	public String toString() {
		return "Deposit [deposit_ID=" + deposit_ID + ", amount=" + amount + ", dateOfDeposit=" + dateOfDeposit + "]";
	}
	
	
}