package entity;

public class mBankingAccountEntity {
	
	private String Customer_ID;
	private String MBA_ID;
	private String Password;
	private String MU_ID;
	
	
	public mBankingAccountEntity(String customer_ID, String mBA_ID, String password, String mU_ID) {
		
		Customer_ID = customer_ID;
		MBA_ID = mBA_ID;
		Password = password;
		MU_ID = mU_ID;
	}


	public String getCustomer_ID() {
		return Customer_ID;
	}


	public void setCustomer_ID(String customer_ID) {
		Customer_ID = customer_ID;
	}


	public String getMBA_ID() {
		return MBA_ID;
	}


	public void setMBA_ID(String mBA_ID) {
		MBA_ID = mBA_ID;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getMU_ID() {
		return MU_ID;
	}


	public void setMU_ID(String mU_ID) {
		MU_ID = mU_ID;
	}


	@Override
	public String toString() {
		return "mBankingAccountEntity [Customer_ID=" + Customer_ID + ", MBA_ID=" + MBA_ID + ", Password=" + Password
				+ ", MU_ID=" + MU_ID + "]";
	}
	
	
	

}
