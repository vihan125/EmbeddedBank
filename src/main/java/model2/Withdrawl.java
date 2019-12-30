package model2;


import java.math.BigDecimal;
import java.util.Date;


public class Withdrawl {
	
	private int withdrawl_ID;
	private BigDecimal amount;
	private Date dateOfWithdrawl;
	
	public Withdrawl() {
	}

	public int getWithdrawl_ID() {
		return this.withdrawl_ID;
	}

	public void setWithdrawl_ID(int withdrawl_ID) {
		this.withdrawl_ID = withdrawl_ID;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDateOfWithdrawl() {
		return this.dateOfWithdrawl;
	}

	public void setDateOfWithdrawl(Date dateOfWithdrawl) {
		this.dateOfWithdrawl = dateOfWithdrawl;
	}

}