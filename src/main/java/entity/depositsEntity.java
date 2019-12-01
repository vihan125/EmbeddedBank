package entity;

import java.sql.Date;

public class depositsEntity {
	private int deposit_ID;
	private Date date_of_deposit;
	private double amount;
	
	public depositsEntity(int deposit_ID, Date date_of_deposit, double amount) {
		super();
		this.deposit_ID = deposit_ID;
		this.date_of_deposit = date_of_deposit;
		this.amount = amount;
	}

	public int getDeposit_ID() {
		return deposit_ID;
	}

	public void setDeposit_ID(int deposit_ID) {
		this.deposit_ID = deposit_ID;
	}

	public Date getDate_of_deposit() {
		return date_of_deposit;
	}

	public void setDate_of_deposit(Date date_of_deposit) {
		this.date_of_deposit = date_of_deposit;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "depositsEntity [deposit_ID=" + deposit_ID + ", date_of_deposit=" + date_of_deposit + ", amount="
				+ amount + "]";
	}
	
	

}
