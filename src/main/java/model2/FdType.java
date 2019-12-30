package model2;


import java.math.BigDecimal;

public class FdType {


	private int FD_type_ID;
	private BigDecimal interestRate;
	
	public FdType() {
	}

	public int getFD_type_ID() {
		return this.FD_type_ID;
	}

	public void setFD_type_ID(int FD_type_ID) {
		this.FD_type_ID = FD_type_ID;
	}

	public BigDecimal getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}


}