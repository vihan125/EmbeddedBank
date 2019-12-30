package model2;




public class ContactNo{


	private int customer_ID;
	private String  mobile_No;
	
	public int getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}

	public String getMobile_No() {
		return mobile_No;
	}

	public void setMobile_No(String mobile_No) {
		this.mobile_No = mobile_No;
	}

	public ContactNo(int customer_ID, String mobile_No) {
		super();
		this.customer_ID = customer_ID;
		this.mobile_No = mobile_No;
	}



}