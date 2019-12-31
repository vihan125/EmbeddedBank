package model2;



public class FixedDeposit{

	private int fdId;
	private int account_ID;
	private int fdType;

	public FixedDeposit() {
	}

	
	public FixedDeposit(int fdId, int account_ID, int fdType) {
		super();
		this.fdId = fdId;
		this.account_ID = account_ID;
		this.fdType = fdType;
	}


	public int getFdId() {
		return this.fdId;
	}

	public void setFdId(int fdId) {
		this.fdId = fdId;
	}

	public int getAccount() {
		return this.account_ID;
	}

	public void setAccount(int account) {
		this.account_ID = account;
	}

	public int getFdType() {
		return this.fdType;
	}

	public void setFdType(int fdType) {
		this.fdType = fdType;
	}

}