package model2;


public class MobileBankingAccount{
	
	
	private int mbaId;
	private String password;
	private MobileUnit mobileUnit;
	private User user;

	public MobileBankingAccount() {
	}

	public int getMbaId() {
		return this.mbaId;
	}

	public void setMbaId(int mbaId) {
		this.mbaId = mbaId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MobileUnit getMobileUnit() {
		return this.mobileUnit;
	}

	public void setMobileUnit(MobileUnit mobileUnit) {
		this.mobileUnit = mobileUnit;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}