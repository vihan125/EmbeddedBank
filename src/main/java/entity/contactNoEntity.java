package entity;

public class contactNoEntity {
	
	private int customer_ID;
	private int mobile_no;
	
	public contactNoEntity(int customer_ID, int mobile_no) {
		super();
		this.customer_ID = customer_ID;
		this.mobile_no = mobile_no;
	}

	public int getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}

	public int getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(int mobile_no) {
		this.mobile_no = mobile_no;
	}

	@Override
	public String toString() {
		return "contactNoEntity [customer_ID=" + customer_ID + ", mobile_no=" + mobile_no + "]";
	}
	
	

}

