package model2;



public class FixedDeposit{

	private int fdId;
	private Account account;
	private FdType fdType;

	public FixedDeposit() {
	}

	public int getFdId() {
		return this.fdId;
	}

	public void setFdId(int fdId) {
		this.fdId = fdId;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public FdType getFdType() {
		return this.fdType;
	}

	public void setFdType(FdType fdType) {
		this.fdType = fdType;
	}

}