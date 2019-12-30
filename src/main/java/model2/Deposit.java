package model2;


import java.math.BigDecimal;
import java.util.Date;




public class Deposit {


	private int deposit_ID;
	private BigDecimal amount;
	private Date dateOfDeposit;

	public Deposit() {
	}

	public int getDeposit_ID() {
		return this.deposit_ID;
	}

	public void setDeposit_ID(int deposit_ID) {
		this.deposit_ID = deposit_ID;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDateOfDeposit() {
		return this.dateOfDeposit;
	}

	public void setDateOfDeposit(Date dateOfDeposit) {
		this.dateOfDeposit = dateOfDeposit;
	}
}